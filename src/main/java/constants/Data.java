package constants;

import java.util.List;

public class Data {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String LOGIN = "newcourier";
    public static final String PASSWORD = "12345qwerty";
    public static final String FIRST_NAME = "hahaha";
    public static final String SECOND_PASSWORD = "12345";
    public static final String FIRST_NAME_2 = "name2";
    public static final String EMPTY_LOGIN = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String EMPTY_FIRST_NAME = "";

    public static final String NONEXIST_LOGIN = "nonexistl";
    public static final String NONEXIST_PASSWORD = "nonexistp";


    public static final String LAST_NAME = "PETROVA";
    public static final String ADDRESS = "RODIONOVA 17";
    public static final int METRO_STATION = 1;
    public static final String PHONE = "+79127963366";
    public static final int RENT_TIME = 2;
    public static final String DELIVERY_DATE = "2024-04-24";
    public static final String COMMENT = "Домофон через консьержа";
    public static final List<String> BLACK_COLOR = List.of("BLACK");
    public static final List<String> GREY_COLOR = List.of("GREY");
    public static final List<String> BOTH_COLORS = List.of("BLACK","GREY");
    public static final List<String> WITHOUT_COLOR = List.of("");


    public static final String ERROR_FOR_CREATE_COURIER = "Недостаточно данных для создания учетной записи";
    public static final String ERROR_FOR_LOGIN_COURIER = "Недостаточно данных для входа";
    public static final String ERROR_FOR_INCORRECT_LOGIN_COURIER = "Учетная запись не найдена";
    public static final String ERROR_FOR_INCORRECT_CREATE_COURIER = "Этот логин уже используется. Попробуйте другой.";

}

