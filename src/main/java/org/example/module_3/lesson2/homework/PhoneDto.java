package org.example.module_3.lesson2.homework;

import lombok.*;

@Builder
@ToString

public class PhoneDto {

    @NonNull
    private String number;
    private boolean isGovernment;
    @NonNull
    @ToString.Exclude
    private PhoneType phoneType;
    @ToString.Exclude
    private String clientFio;
}
