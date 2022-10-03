package org.example.module_3.lesson2.home_work2;

public class Test {
    public static void main(String[] args) {
        PhoneType phoneType = PhoneType.builder()
                .code("123")
                .name("Ivan")
                .isMobile(true)
                .build();
        System.out.println(phoneType);

        PhoneDto phoneDto = PhoneDto.builder()
                .isGovernment(true)
                .phoneType(phoneType)
                .number("123")
                .clientFio("Man")
                .build();
        System.out.println(phoneDto);



    }
}
