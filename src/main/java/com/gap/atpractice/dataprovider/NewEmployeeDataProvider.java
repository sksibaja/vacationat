package com.gap.atpractice.dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by ssibaja on 5/30/17.
 */
public class NewEmployeeDataProvider {
    @DataProvider(name="dp")
    public static Object[][] dataProviderMethod (Method m){

        System.out.println(String.format("Data Provider name: %s", m.getName()));
        return new Object[][]{
                {"Katya", "Perez", "kperez@wearegap.com", "110600156", "Juana Perez", "2015", "9", "16"}
        };
    }
}
