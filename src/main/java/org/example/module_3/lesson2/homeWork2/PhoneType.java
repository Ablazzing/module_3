package org.example.module_3.lesson2.homeWork2;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneType {
    @NonNull String name;
    @NonNull String code;
    @ToString.Exclude
    @NonNull Boolean isMobile;
}
