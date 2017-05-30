package com.gap.atpractice.dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by ssibaja on 5/29/17.
 */
public class LoginDataProvider {

    @DataProvider (name="dp")
    public static Object[][] dataProviderMethod (Method m){
        System.out.println(String.format("Data Provider name: %s", m.getName()));
        return new Object[][]{
                {"at_java_training@wearegap.com", "123queso"},
                {"at_java_training@wearegap.com", "123queso"},
        };
    }
}
