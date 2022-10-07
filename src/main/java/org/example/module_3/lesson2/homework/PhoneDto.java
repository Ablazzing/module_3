package org.example.module_3.lesson2.homework;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
public class PhoneDto {
    @NonNull
    private String number;
    @ToString.Exclude
    private boolean isGovernment;
    @NonNull @ToString.Exclude
    private PhoneType phoneType;
    private String clientFio;

}
