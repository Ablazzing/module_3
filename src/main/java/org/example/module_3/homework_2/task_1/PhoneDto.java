package org.example.module_3.homework_2.task_1;

import lombok.*;

//Создать класс PhoneDto.
//Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
//data, value
//поля: string number - не null, boolean isGovernment, PhoneType phoneType - не null, string clientFio
//При выводе в String убрать поля isGoverment, phoneType
@Data
@AllArgsConstructor
public class PhoneDto {
    @NonNull
    private String number;

    @ToString.Exclude
    private boolean isGovernment;

    @NonNull
    @ToString.Exclude
    private PhoneType phoneType;

    private String clientFio;
}
