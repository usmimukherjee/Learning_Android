package com.myapp.tdd_demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private String password;

    public Validator(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPasswordLength(){
        if (password.length() >= 8){
            return true;
        }else {
            return false;
        }
    }


    public boolean checkPasswordCase() {

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        char currentChar;
        for (int i = 0; i < password.length(); i++) {
            currentChar = password.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                isUpperCase = true;
            } else if(Character.isLowerCase(currentChar)) {
                isLowerCase = true;
            }
        }
        if(isUpperCase && isLowerCase)
            return true;
        else
            return false;
    }

    public boolean checkPasswordSpecialChar() {

        String regex = "[a-zA-Z0-9_@$!]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
