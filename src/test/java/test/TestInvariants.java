package test;

import org.junit.Test;
import start.Util;

public class TestInvariants {
    @Test
    public void TestVerifyingInvariantLog(){
        String example;
        example=Util.outPut("src/test/resources/ejemplo.txt");
        System.out.println(example);

    }
}
