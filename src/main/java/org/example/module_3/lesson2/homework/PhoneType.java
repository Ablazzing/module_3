package org.example.module_3.lesson2.homework;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneType {
    @NonNull
    private String name;
    @NonNull
    private String code;
    @ToString.Exclude @NonNull
    private boolean isMobile;
}
