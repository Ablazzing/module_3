package org.example.module_3.lesson2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PhoneType {
    private String name;
    private String code;
    @ToString.Exclude
    private boolean isMobile;

    public static void main(String[] args) {
        PhoneType phoneType = new PhoneType("Nokia", "3110", true);
        System.out.println(phoneType);
    }
}
