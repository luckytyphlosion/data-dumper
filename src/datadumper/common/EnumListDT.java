package datadumper.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import datadumper.DataDumper;
import datadumper.DataType;
import datadumper.FormatType;

public class EnumListDT extends ListDT {

    protected int loopIndex;
    protected EnumDT enumDataType;
    protected static HashMap<Class<? extends EnumDT>, EnumDT> enumCacheMap;

    static {
        EnumListDT.enumCacheMap = new HashMap<Class<? extends EnumDT>, EnumDT>();
    }

    public EnumListDT(DataDumper dumper, FormatType format, Class<? extends EnumDT> enumDataTypeClass, DataType related) {
        super(dumper, format, related);
        if (EnumListDT.enumCacheMap.containsKey(enumDataTypeClass)) {
            this.enumDataType = EnumListDT.enumCacheMap.get(enumDataTypeClass);
        } else {
            try {
                this.enumDataType = enumDataTypeClass.getConstructor(DataDumper.class, FormatType.class).newInstance(this.dumper, this.format);
            } catch (NoSuchMethodException e1) {
                throw new RuntimeException(
                        String.format("%s does not have the basic EnumDT Constructor (DataDumper, FormatType)!", this.getClass().getName()), e1);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e1) {
                throw new RuntimeException(e1);
            }
        }
        this.loopIndex = 0;
    }

    public DataType createCopy() {
        return new EnumListDT(this.dumper, this.format, this.enumDataType.getClass(), this.related.createCopy());
    }

    @Override
    public boolean loopCondition() {
        this.loopIndex++;
        return (this.loopIndex < (this.enumDataType.getEnumNameArray().length - this.enumDataType.getStartingValue()));
    }
}
