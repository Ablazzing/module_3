package org.example.module_3.lesson2.home_work2;

import lombok.*;

//Создать класс PhoneDto.
//Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
//data, value
//поля: string number - не null, boolean isGovernment, PhoneType phoneType - не null, string clientFio
//При выводе в String убрать поля isGoverment, phoneType
@Data
@AllArgsConstructor
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
