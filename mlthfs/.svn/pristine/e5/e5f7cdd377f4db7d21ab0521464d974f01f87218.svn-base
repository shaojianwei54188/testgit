package com.hhu.mlthfs.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExcuteCmd {
    public static String excuteCmd_multiThread(String cmd, String encoding) {
        BufferedReader bReader = null;
        InputStreamReader sReader = null;
        try {
            Process p = Runtime.getRuntime().exec(cmd);

            /* 为"错误输出流"单独开一个线程读取之,否则会造成标准输出流的阻塞 */
            Thread t = new Thread(new InputStreamRunnable(p.getErrorStream(),"ErrorStream"));
            t.start();

            /* "标准输出流"就在当前方法中读取 */
            BufferedInputStream bis = new BufferedInputStream(p.getInputStream());

            if (encoding != null && encoding.length() != 0) {
                sReader = new InputStreamReader(bis, encoding);// 设置编码方式
            } else {
                sReader = new InputStreamReader(bis, "utf-8");
            }
            bReader = new BufferedReader(sReader);

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = bReader.readLine()) != null) {
                sb.append(line);
//                sb.append("\n");
            }

            bReader.close();
            p.destroy();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "result: error";
        } finally {
        }
    }
}
class InputStreamRunnable implements Runnable {
    BufferedReader bReader = null;
    String type = null;

    public InputStreamRunnable(InputStream is, String _type) {
        try {
            bReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(is), "UTF-8"));
            type = _type;
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unused")
    public void run() {
        String line;
        int lineNum = 0;

        try {
            while ((line = bReader.readLine()) != null) {
                lineNum++;
                // Thread.sleep(200);
            }
            bReader.close();
        } catch (Exception ex) {
        }
    }
}
