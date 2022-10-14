package org.example.module_3.lesson2.homework.dmitriy.k;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
public class PhoneDto {
    @NonNull
    String number;
    @ToString.Exclude boolean isGovernment;
    @NonNull
    @ToString.Exclude PhoneType phoneType;
    String clientFio;
}
