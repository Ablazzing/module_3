package org.example.module_3.lesson2.homeWork2;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class PhoneDto {
    @NonNull private String number;
    @ToString.Exclude
    private boolean isGovernment;
    @ToString.Exclude
    @NonNull private PhoneType phoneType;
    private String clientFio;
}
