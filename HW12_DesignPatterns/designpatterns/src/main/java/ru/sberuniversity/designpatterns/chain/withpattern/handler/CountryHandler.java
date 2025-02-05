package ru.sberuniversity.designpatterns.chain.withpattern.handler;

public class CountryHandler implements Handler{

    @Override
    public String handle(String input) {
        String codeCountry = input.substring(0, 1);
        if (!codeCountry.equals("7") && !codeCountry.equals("8")){
            return "Неверный формат номера. Укажите номер с помощью 7 или 8.";
        } if (codeCountry.equals("8")) {
            input = input.replaceFirst("8","7");
        }
        return input;
    }
}
