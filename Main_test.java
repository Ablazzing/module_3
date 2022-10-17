package org.example;

public class Main_test {
    public static void main(String[] args) {
        PhoneType phone = new PhoneType("Sumsung", "+898", true);
        System.out.println(phone);
        PhoneDto dto = new PhoneDto("8902414151",true, phone, "Петров Иван Иваныч");
        System.out.println(dto);
    }
}
