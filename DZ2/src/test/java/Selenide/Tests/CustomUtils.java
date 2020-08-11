package Selenide.Tests;

import io.qameta.allure.Attachment;

public class CustomUtils {

    @Attachment
    public static String noPagesMessage(){
        return "Достигнута последняя страница поиска";
    }

    @Attachment
    public static String wrongPhoneMessage() {return "Найден не iPhone";}
}