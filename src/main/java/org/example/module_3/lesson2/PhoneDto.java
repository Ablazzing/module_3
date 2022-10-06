package org.example.module_3.lesson2;

import lombok.ToString;
import lombok.Value;

@Value
public class PhoneDto {

    private String number;
    @ToString.Exclude
    private boolean isGovernment;
    @ToString.Exclude
    PhoneType phoneType;

    private String clientFio;

    public static void main(String[] args) {
        PhoneDto phoneDto = new PhoneDto("35",true, new PhoneType("Nokia", "3110", true),
                "Ivanov Ivan Ivanovich");
        System.out.println(phoneDto);
    }
}
