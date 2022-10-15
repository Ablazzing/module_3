package org.example.module_3.lesson2.voodoo_homework;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneType {

    @NonNull
    String name;
    @NonNull
    String code;
    @NonNull
    @ToString.Exclude
    Boolean isMobile;


}
