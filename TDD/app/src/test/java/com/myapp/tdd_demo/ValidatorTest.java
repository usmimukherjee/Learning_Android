package com.myapp.tdd_demo;

import static org.junit.Assert.*;

import org.junit.Test;

// Unit Test Example
public class ValidatorTest {

    // Password Length : Password should be of minimum 8 characters
    @Test
    public void checkPasswordLengthTest(){

        Validator v1 = new Validator("password");
        Validator v2 = new Validator("test");
        Validator v3 = new Validator("CSCI3130---");
        Validator v4 =  new Validator(" ");

        assertTrue(v1.checkPasswordLength());
        assertFalse(v2.checkPasswordLength());
        assertTrue(v3.checkPasswordLength());
//          assertTrue(v4.checkPasswordLength());
    }

    @Test
    public void checkPasswordCaseTest(){
        Validator v1 = new Validator("password"); // all lower cases
        Validator v2 = new Validator("PASSWORD"); // all upper cases
        Validator v3 = new Validator("Password"); // Atlease one upper and one lower case
        Validator v4 = new Validator(""); // Blank String

        assertFalse(v1.checkPasswordCase());
        assertFalse(v2.checkPasswordCase());
        assertTrue(v3.checkPasswordCase());
//        assertFalse(v3.checkPasswordCase()); //
//        assertFalse(v4.checkPasswordCase());


    }

    @Test
    public void checkPasswordSpecialCharTest(){
        Validator v1 = new Validator("password"); // No Special Charater
        Validator v2 = new Validator("Java2blog@"); // one Special Character
        Validator v3 = new Validator("Password#"); // one special character # which is not allowed as special character

        assertTrue(v1.checkPasswordSpecialChar());
        assertTrue(v2.checkPasswordSpecialChar());
        assertFalse(v3.checkPasswordSpecialChar()); //
    }
}
