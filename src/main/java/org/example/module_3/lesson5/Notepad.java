package org.example.module_3.lesson5;

public class Notepad {
    private Redactor redactor;

    public static void main(String[] args) {
        System.out.println("hi redactor");
    }

    public Notepad(Redactor redactor) {
        this.redactor = redactor;
    }

    public boolean findText(String src, String regex) {
        //src = hello People
        //regex = people
        String lowerCaseText = redactor.getLowerCaseText(src);
        String lowerCaseRegex = redactor.getLowerCaseText(regex);
        return lowerCaseText.contains(lowerCaseRegex);
//        if (src.indexOf(regex) == -1) {
//            return false;
//        } else {
//            return true;
//        }
    }
}
