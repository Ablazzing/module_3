package org.example.module_3.lesson3;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneType {
    @NonNull
    String name;
    @NonNull
    String code;
    @ToString.Exclude
    boolean isMobile;
    //Задача №1
    //Создать класс PhoneType, сделать поля неизменяемыми. Все поля должны быть не null.
    //Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
    //data, value
    //поля: string name, string code, boolean isMobile
    //При выводе в String убрать поле isMobile
}
