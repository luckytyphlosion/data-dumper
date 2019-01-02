package datadumper.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Set;

import datadumper.StringToken;
import datadumper.ValueType;
import datadumper.gba.bn6f.BattleObjSetupTypeConst;
import datadumper.gba.bn6f.BattleObjSetupTypeConstDT;

public class ValueSet {

    private ValueType[] setArgs;
    private ArrayList<String> postfixSetFormat;
    private static HashMap<Character, Integer> operatorPrecedence;
    
    static {
        operatorPrecedence = new HashMap<Character, Integer>();
        operatorPrecedence.put('>', 3);
        operatorPrecedence.put('&', 2);
        operatorPrecedence.put('|', 1);
        operatorPrecedence.put('-', 1);
        operatorPrecedence.put('!', 0);
    }

    public ValueSet(long singleValueAsLong) {
        this("[]", new Value(singleValueAsLong));
    }

    public ValueSet(ValueType singleValue) {
        this("[]", singleValue);
    }
    
    public ValueSet(long lowerBoundAsLong, long upperBoundAsLong) {
        this("[] > []", new Value(lowerBoundAsLong), new Value(upperBoundAsLong));
    }

    public ValueSet(ValueType lowerBound, ValueType upperBound) {
        this("[] > []", lowerBound, upperBound);
    }

    public ValueSet(String setFormat, ValueType ... setArgs) {
        this.postfixSetFormat = ValueSet.performShuntingYardOnSetFormat(setFormat, setArgs.length);
        String debugPostfixStr = "";
        for (String token : this.postfixSetFormat) {
            debugPostfixStr += token;
        }
        System.out.println(debugPostfixStr);
        this.setArgs = setArgs;
    }

    private static ArrayList<String> performShuntingYardOnSetFormat(String setFormat, int setArgsLength) {
        StringToken stringToken = new StringToken(setFormat);
        ArrayList<Character> stack = new ArrayList<Character>();
        ArrayList<String> postfixSetFormat = new ArrayList<String>();
        boolean automaticFieldNumbering = true;
        int currentArgIndex = 0;
        for (char c : stringToken) {
            switch (c) {
            case '[':
                String argInside = "";
                boolean firstRunthrough = true;
                while (true) {
                    char nextChar = stringToken.next();
                    if (nextChar == ']') {
                        if (firstRunthrough && !automaticFieldNumbering) {
                            throw new IllegalArgumentException("Cannot switch from automatic field numbering to manual field numbering!");
                        }
                        break;
                    }
                    automaticFieldNumbering = false;
                    firstRunthrough = false;
                    argInside += nextChar;
                }
                if (argInside.equals("")) {
                    if (currentArgIndex >= setArgsLength) {
                        throw new IllegalArgumentException(
                            String.format("Field number %d is larger than varargs ValueType array of length %d!", currentArgIndex, setArgsLength));
                    }
                    postfixSetFormat.add("[" + Integer.toString(currentArgIndex));
                    currentArgIndex++;
                } else {
                    try {
                        int num = Integer.parseInt(argInside);
                        if (num < 0) {
                            throw new IllegalArgumentException("Field number is a negative integer!");
                        } else if (num >= setArgsLength) {
                            throw new IllegalArgumentException(
                                String.format("Field number %d is larger than varargs ValueType array of length %d!", num, setArgsLength));
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Field number is not a non-negative integer!");
                    }
                    postfixSetFormat.add("[" + argInside);
                }
                break;
            case '!':
                stack.add('!');
                break;
            case '|':
            case '&':
            case '-':
            case '>':
                while (stack.size() != 0) {
                    Character topToken = stack.get(stack.size() - 1);
                    if (topToken == '!' ||
                    (topToken != '(' && ValueSet.operatorPrecedence.get(topToken) >= ValueSet.operatorPrecedence.get(c))) {
                        postfixSetFormat.add(Character.toString(topToken));
                        stack.remove(topToken);
                        continue;
                    }
                    break;
                }
                stack.add(c);
                break;
            case '(':
                stack.add('(');
                break;
            case ')':
                while (true) {
                    Character topToken = stack.remove(stack.size() - 1);
                    if (topToken == '(') {
                        break;
                    }
                    postfixSetFormat.add(Character.toString(topToken));
                    if (stack.size() == 0) {
                        throw new IllegalArgumentException("Mismatched parentheses in ValueSet format!");
                    }
                }
                break;
            case ' ':
                break;
            default:
                throw new IllegalArgumentException("Invalid character in ValueSet format: \"" + c + "\"!");
            }
        }
        while (stack.size() != 0) {
            char topToken = stack.remove(stack.size() - 1);
            if (topToken == '(' || topToken == ')') {
                throw new IllegalArgumentException("Mismatched parentheses in ValueSet format!");
            }
            postfixSetFormat.add(Character.toString(topToken));
        }
        return postfixSetFormat;
    }

    public boolean contains(ValueType value) {
        ArrayList<ValueToken> operandStack = new ArrayList<ValueToken>();
        // maybe make function pointers?
        for (String token : this.postfixSetFormat) {
            switch (token.charAt(0)) {
            case '[':
                operandStack.add(new ValueToken(this.setArgs[Integer.parseInt(token.substring(1))]));
                break;
            case '!':
            {
                ValueToken operand = operandStack.get(operandStack.size() - 1);
                operandStack.set(operandStack.size() - 1, new ValueToken(!operand.getTruthValue(value)));
                break;
            }
            case '>':
            {
                ValueToken operand2 = operandStack.remove(operandStack.size() - 1);
                ValueToken operand1 = operandStack.get(operandStack.size() - 1);
                if (!operand1.hasValueType() || !operand2.hasValueType()) {
                    throw new IllegalArgumentException("Tried performing a range operation from evaluated operands!");
                }
                boolean inRange = operand1.getValue() <= value.getValue() && value.getValue() <= operand2.getValue();
                operandStack.set(operandStack.size() - 1, new ValueToken(inRange));
                break;
            }
            case '&':
            {
                ValueToken operand2 = operandStack.remove(operandStack.size() - 1);
                ValueToken operand1 = operandStack.get(operandStack.size() - 1);
                operandStack.set(operandStack.size() - 1, new ValueToken(operand2.getTruthValue(value) && operand1.getTruthValue(value)));
                break;
            }
            case '|':
            {
                ValueToken operand2 = operandStack.remove(operandStack.size() - 1);
                ValueToken operand1 = operandStack.get(operandStack.size() - 1);
                operandStack.set(operandStack.size() - 1, new ValueToken(operand2.getTruthValue(value) || operand1.getTruthValue(value)));
                break;
            }
            case '-':
            {
                ValueToken operand2 = operandStack.remove(operandStack.size() - 1);
                ValueToken operand1 = operandStack.get(operandStack.size() - 1);
                operandStack.set(operandStack.size() - 1, new ValueToken(operand1.getTruthValue(value) && !operand2.getTruthValue(value)));
                break;
            }
            }
        }
        return operandStack.get(operandStack.size() - 1).getTruthValue(value);
    }

    public class ValueToken {
        private boolean hasValueType;
        private ValueType value;
        private boolean evaluated;
        private boolean truthValue;

        public ValueToken(ValueType value) {
            this.value = value;
            this.evaluated = false;
            this.hasValueType = true;
        }

        public ValueToken(boolean truthValue) {            
            this.truthValue = truthValue;
            this.evaluated = true;
            this.hasValueType = false;
        }

        public boolean isEvaluated() {
            return this.evaluated;
        }

        public boolean evaluate(ValueType value) {
            this.evaluated = true;
            this.truthValue = this.value.equals(value);
            return this.truthValue;
        }

        public boolean getTruthValue() {
            if (!this.evaluated) {
                throw new RuntimeException("ValueToken not evaluated yet!");
            }
            return this.truthValue;
        }

        public boolean getTruthValue(ValueType value) {
            if (!this.evaluated) {
                this.evaluate(value);
            }
            return this.truthValue;
        }

        public long getValue() {
            if (!this.hasValueType) {
                throw new RuntimeException("Tried to get ValueType of ValueToken with unknown ValueType!");
            }
            return this.value.getValue();
        }
        
        public boolean hasValueType() {
            return this.hasValueType;
        }
    }

    public static void main(String[] args) {
        ValueSet valueSet = new ValueSet(
            "!([] | [] | [])",
            BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_MYSTERY_DATA,
            BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_BLUE_SIDE,
            BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_RED_SIDE);
        System.out.println(valueSet.contains(BattleObjSetupTypeConst.BATTLE_OBJECT_TYPE_MYSTERY_DATA));
        System.out.println(valueSet.contains(new Value(0x10)));
    }
}
