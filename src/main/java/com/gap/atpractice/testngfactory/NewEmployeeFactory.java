package com.gap.atpractice.testngfactory;

import com.gap.atpractice.testSuites.NewEmployeeTest;
import org.testng.annotations.Factory;

/**
 * Created by ssibaja on 6/1/17.
 */
public class NewEmployeeFactory {


    //Factory implementation, This defines the number of iterations a testCall will be ran.
    @Factory
    public Object[] CreateInstances(){
        Object[] result = new Object[10];
        for (int i=0; i<10; i++){
            result[i] = new NewEmployeeTest(i);
        }
        return result;
    }
}
