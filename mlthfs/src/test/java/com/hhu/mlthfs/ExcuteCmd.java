//package com.hhu.mlthfs;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//
//public class ExcuteCmd {
//    public static void main(String[] args) {
//
//        String [][]  x = {{"1981" ,"928" ,"3028" ,"4314"},
//                {"1982","385" ,"4327" ,"3125"},
//                {"1983","2063" ,"4108" ,"5442"}};
//
//        String[] x1={"1981" ,"1300" ,"432" ,"928" ,"3028" ,"4314"};
//        String [] y={"4353","3340","4525"};
//
//        String x0="[[1981, 928, 3028, 4314],[1981, 928, 3028, 4314],[1981, 928, 3028, 4314]]";
//        String x2="[928, 3028, 4314]";
//
//        String y0="[4353, 3340, 4525]";
//
//        ArrayList<String> listx=new ArrayList<>();
//        listx.add("1");
//        listx.add("2");
//        listx.add("3");
//
//        ArrayList<String> listy=new ArrayList<>();
//        listy.add("4");
//        listy.add("5");
//        listy.add("6");
//
//        String a="1";
//        String b="2";
//
//        String commandStr = new String("python E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test6.py param1 param2 param3");
//        String[] argumentsSVM = new String[] { "python"
//                , "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test_ThirdPackage_param.py"
//                , String.valueOf(listx)
//                ,String.valueOf(listy)
//        };
//
//        String[] argumentsSVM1 = new String[] { "python"
//                , "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test6.py"+listx
//
//        };
//
//        Object re= excuteCmd_multiThread(argumentsSVM1,null);
//
//       System.out.println("re="+re);
//    }
//
//
//
//    /** 执行外部程序,并获取标准输出 */
//    public static String excuteCmd_multiThread(String[] cmd, String encoding) {
//        BufferedReader bReader = null;
//        InputStreamReader sReader = null;
//        try {
//            Process p = Runtime.getRuntime().exec(cmd);
//
//            /* 为"错误输出流"单独开一个线程读取之,否则会造成标准输出流的阻塞 */
//            Thread t = new Thread(new InputStreamRunnable(p.getErrorStream(),"ErrorStream"));
//            t.start();
//
//            /* "标准输出流"就在当前方法中读取 */
//            BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
//
//            if (encoding != null && encoding.length() != 0) {
//                sReader = new InputStreamReader(bis, encoding);// 设置编码方式
//            } else {
//                sReader = new InputStreamReader(bis, "utf-8");
//            }
//            bReader = new BufferedReader(sReader);
//
//            StringBuilder sb = new StringBuilder();
//            String line;
//
//            while ((line = bReader.readLine()) != null) {
//                sb.append(line);
//                sb.append("\n");
//            }
//
//            bReader.close();
//            p.destroy();
//            return sb.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "result: error";
//        } finally {
//        }
//    }
//}
//
//class InputStreamRunnable implements Runnable {
//    BufferedReader bReader = null;
//    String type = null;
//
//    public InputStreamRunnable(InputStream is, String _type) {
//        try {
//            bReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(is), "UTF-8"));
//            type = _type;
//        } catch (Exception ex) {
//        }
//    }
//
//    @SuppressWarnings("unused")
//    public void run() {
//        String line;
//        int lineNum = 0;
//
//        try {
//            while ((line = bReader.readLine()) != null) {
//                lineNum++;
//                // Thread.sleep(200);
//            }
//            bReader.close();
//        } catch (Exception ex) {
//        }
//    }
//}
