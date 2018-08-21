package com.step.demo.spring;

import com.step.util.PathUtil;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.rowset.spi.XmlReader;
import java.io.File;

public class AopTest {

    @Test
    public void test_x() {
        System.err.printf("%s\n" , PathUtil.getPackeRootPath(AopTest.class));

    }

    private static String basepath = null;
    private static String[] path = new String[1];
    private static String[] paths = new String[2];

    private static String getBasepath(){
        if (basepath == null) {
            basepath = PathUtil.getPackeRootPath(AopTest.class)+"aop";
        }
        return basepath;
    }

    private static String[] getPath (){
        if (path[0] == null) {
            path[0] = getBasepath()+"/app.xml";
        }
     return path;
    }

    private static String[] getPaths(){
        if (paths[0] == null) {
            paths[0] =getPath()[0];
            paths[1] = getBasepath()+"/aopAr.xml";
        }
        return paths;
    }

    @Test
    public void testIoc() {
        ApplicationContext app = new ClassPathXmlApplicationContext(getPath()[0]);
        //app.getBean("");
        UserDaoInf usrDao = app.getBean("usrDao" , UserDaoInf.class);
        usrDao.syaHello(new User("jack"));
        //ClassUtil.getObjectInfoByClass(usrDao);
    }

    //@Test
    public void testAop() {
        ApplicationContext app = new ClassPathXmlApplicationContext(paths);
        UserDaoInf usrDao = app.getBean("usrDao" , UserDaoInf.class);
        //usrDao.syaHello(new User("jack"));
        Class<? extends Object> cls = usrDao.getClass();
        String objectName = Object.class.getName();
        String suClassName = null;
        while (null != cls && !objectName.equals(suClassName)) {
            //ClassUtil.getObjectInfoByClass(cls);
            cls = cls.getSuperclass();
            suClassName = cls.getName();
            System.out.println(objectName+":"+suClassName);
        }
    }

    /**
     * ProxyFactory
     ***/
    //@Test
    public void TestProxyFactory() {
        ProxyFactory pfbf = new ProxyFactory();
        pfbf.setTarget(new UserDao());
        pfbf.addAdvice(new SayImplBeforeAdvice());
        UserDaoInf ud = (UserDaoInf) pfbf.getProxy();
        ud.syaHello(new User());
        ProxyFactory pfar = new ProxyFactory();
        pfar.setTarget(ud);
        pfar.addAdvice(new SayImplAroundAdvice());
        UserDaoInf udend = (UserDaoInf) pfar.getProxy();
        udend.syaHello(new User());
    }

}
