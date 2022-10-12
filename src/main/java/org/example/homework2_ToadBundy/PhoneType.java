package org.example.homework2_ToadBundy;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Data
public class PhoneType {
    @NonNull private String name;
    @NonNull private String code;
    @ToString.Exclude
    @NonNull private Boolean isMobile;


}
