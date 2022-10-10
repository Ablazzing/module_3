package org.example.module_3.lesson2.homework;

import lombok.Builder;
import lombok.ToString;


@Builder
@ToString
public class PhoneType {

    String name;
    String code;
    @ToString.Exclude
    boolean isMobile;
}
