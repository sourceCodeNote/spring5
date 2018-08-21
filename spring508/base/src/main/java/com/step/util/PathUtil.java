package com.step.util;

import org.junit.Test;

import java.io.File;

public class PathUtil {

    @Test
    public void test_x(){
        System.err.printf("%s" ,getPackeRootPath(PathUtil.class));
    }

    public static String getOppositePath(Class cls){
        if (null != cls) {
            return cls.getResource("").getPath();
        }
        return null;
    }

    public static String getPackeRootPath(Class cls){
        if (null != cls) {
            String pp = cls.getPackage().getName().replace(".","/");
            String comp = cls.getResource("").getPath();
            comp = comp.replaceFirst(pp,"");
            comp = comp.replaceFirst("//","/");
            return comp;
        }
        return null;
    }

}
