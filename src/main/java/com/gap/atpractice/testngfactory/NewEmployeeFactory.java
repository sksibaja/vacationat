package com.gap.atpractice.testngfactory;

import com.gap.atpractice.testSuites.NewEmployeeTest;
import org.testng.annotations.Factory;

/**
 * Created by ssibaja on 6/1/17.
 */
public class NewEmployeeFactory {


    private int INDEX = 5;

    //Factory implementation, This defines the number of iterations a testCall will be ran.
    @Factory
    public Object[] CreateInstances(){
        Object[] result = new Object[INDEX];
        for (int i=0; i<INDEX; i++){
            result[i] = new NewEmployeeTest(i);
        }
        return result;
    }
}
