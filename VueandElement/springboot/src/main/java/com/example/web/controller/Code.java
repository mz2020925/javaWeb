package com.example.web.controller;

import java.util.HashMap;
import java.util.Map;

public class Code {
    public static final Integer INSERT_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer SELECT_OK = 20041;

    public static final Integer INSERT_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer SELECT_ERR = 20040;

    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer BUSINESS_ERR = 50002;

    public static final Integer SYSTEM_UNKNOW_ERR = 59999;

    public static Map<String, String> coefficientMap;

    static {
        coefficientMap = new HashMap<>();
        coefficientMap.put("2", "111");
        coefficientMap.put("3", "1011");
        coefficientMap.put("4", "10011");
        coefficientMap.put("5", "100101");
        coefficientMap.put("6", "1000011");
        coefficientMap.put("7", "10001001");
        coefficientMap.put("8", "100011101");
        coefficientMap.put("9", "1000010001");
        coefficientMap.put("10", "10000001001");
        coefficientMap.put("11", "100000101101");
        coefficientMap.put("12", "1000001010011");
        coefficientMap.put("13", "10000000011011");
        coefficientMap.put("14", "100010001000011");
        coefficientMap.put("15", "1000000000000011");
        coefficientMap.put("16", "10001000000001011");
        coefficientMap.put("17", "100000000000001001");
        coefficientMap.put("18", "1000000000010000001");
        coefficientMap.put("19", "10000000000000100111");
        coefficientMap.put("20", "100000000000000001001");
    }
}


























