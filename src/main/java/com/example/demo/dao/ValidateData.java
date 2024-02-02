package com.example.demo.dao;

import com.example.demo.model.state.ClientEnum;
import com.example.demo.model.state.OrderEnum;

public class ValidateData {
    public static boolean isAnyStringBlank(String... strings){
        for (String s : strings){
            if (s == null || s.isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static boolean isStringInClientEnum(String string){
        for (ClientEnum c : ClientEnum.values()){
            if (c.name().equals(string)){
                return true;
            }
        }
        return false;
    }

    public static boolean isStringInOrderEnum(String string){
        for (OrderEnum o : OrderEnum.values()){
            if (o.name().equals(string)){
                return true;
            }
        }
        return false;
    }
}
