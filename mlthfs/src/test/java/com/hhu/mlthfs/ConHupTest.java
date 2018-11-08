//package com.hhu.mlthfs;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class ConHupTest {
//
//    @Test
//    public void test1(){
//        String Q0="58, 59, 58, 38 ,22, 43, 37, 146, 44, 65, 75, 99, 99, 28, 22, 40, 57, 32, 23, 102, 113, 390, 56, 64, 67";
//        String Qcc="124, 132, 172, 165, 321, 191, 206, 148, 139, 141, 180, 84, 84, 89, 84, 240, 239, 158, 159, 196, 149, 350, 149, 129, 141";
//        String FN="2011,2011,2011,2011,2011,2011,2011,2011,2011,2011,2011,2011,2012,2012,2012,2012,2012,2012,2012,2012,2012,2012,2012,2012,2012";
//        String TTN="1";
//
//        ActiveXComponent com=new ActiveXComponent("HUPCom.HUPTools");
//        Dispatch dispatch=com.getObject();
//
//        Variant result=Dispatch.call(dispatch,"HUPforecast",Q0,Qcc,FN,TTN);
//        System.out.println(result);
//
//    }
//
//    @Test
//    public void test2(){
//        ActiveXComponent xl = new ActiveXComponent("Excel.Application");
//        Dispatch xlo = (Dispatch)(xl.getObject());
//        try {
//            System.out.println("version="+xl.getProperty("Version"));
//            System.out.println("version="+Dispatch.get(xlo, "Version"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            xl.invoke("Quit", new Variant[] {});
//        }
//
//    }
//
//}
