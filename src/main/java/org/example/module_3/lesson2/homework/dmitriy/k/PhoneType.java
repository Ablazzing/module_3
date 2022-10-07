package org.example.module_3.lesson2.homework.dmitriy.k;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

//Задача №1
//Создать класс PhoneType, сделать поля неизменяемыми. Все поля должны быть не null.
//Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
//data, value
//поля: string name, string code, boolean isMobile
//При выводе в String убрать поле isMobile
@Value
public class PhoneType {
    @NonNull
    String name;
    @NonNull
    String code;
    @NonNull
    @ToString.Exclude boolean isMobile;
}
