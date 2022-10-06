package org.example.module_3.homework_2.task_1;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

//Задача №1
//Создать класс PhoneType, сделать поля неизменяемыми. Все поля должны быть не null.
//Подумать какую(ие) аннотацию использовать: builder, superbuilder, noargsconstructor, requiredconstructor,
//data, value
//поля: string name, string code, boolean isMobile
//При выводе в String убрать поле isMobile
@Value
@RequiredArgsConstructor
public class PhoneType {
    @NonNull
    String name;

    @NonNull
    String code;

    @ToString.Exclude
    boolean isMobile;
}
