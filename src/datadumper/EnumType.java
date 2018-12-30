package datadumper;

import com.google.common.base.CaseFormat;

public interface EnumType extends ValueType {

    default String getEnumLabelName() {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, this.toString());
    }
    
    default long getValue() {
        return DataDumper.typeSafeCast(this, Enum.class).ordinal();
    }
}
