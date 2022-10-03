package org.example.module_3.lesson2.home_work2;

import lombok.Builder;
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
@Builder
public class PhoneType {
    @NonNull
    String name;
    @NonNull
    String code;
    @NonNull
    @ToString.Exclude
    boolean isMobile;
}
