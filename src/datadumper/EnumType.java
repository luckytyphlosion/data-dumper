package datadumper;

import com.google.common.base.CaseFormat;

public interface EnumType {

    default String getEnumLabelName() {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, this.toString());
    }
}
