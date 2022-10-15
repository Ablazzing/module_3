package org.example.module_3.lesson2.voodoo_homework;

import lombok.*;

@Data
@Builder
public class PhoneDto {
    @NonNull
    String number;
    @ToString.Exclude
    boolean isGovernment;
    @NonNull
    @ToString.Exclude
    PhoneType phoneType;

    String clientFio;

}
