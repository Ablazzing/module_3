package org.example.module_3.lesson3;


import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
public class PhoneDto {
    @NonNull
    String number;
    @ToString.Exclude
    boolean isGovernment;
    @NonNull
    @ToString.Exclude
    PhoneType phoneType;
    String clientFio;

    //Создать класс PhoneDto.
    //Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
    //data, value
    //поля: string number - не null, boolean isGovernment, PhoneType phoneType - не null, string clientFio
    //При выводе в String убрать поля isGoverment, phoneType
}
