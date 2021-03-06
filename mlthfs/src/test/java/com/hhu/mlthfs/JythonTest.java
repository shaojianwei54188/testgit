//package com.hhu.mlthfs;
//
//import com.hhu.mlthfs.utils.SubStringUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.python.core.PyFunction;
//import org.python.core.PyObject;
//import org.python.core.PyString;
//import org.python.util.PythonInterpreter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.LineNumberReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JythonTest {
//
//    public static final Logger logger = LoggerFactory.getLogger(JythonTest.class);
//
//    /**
//     * 执行单行代码
//     */
//    @Test
//    public void test1_code() {
//        PythonInterpreter pythonInterpreter = new PythonInterpreter();
//        pythonInterpreter.exec("print('-----执行单行代码：Hello')");
//    }
//
//    /**
//     * 执行文件脚本，有函数名不带参数
//     */
//
//    @Test
//    public void test2_file() {
//        PythonInterpreter pythonInterpreter = new PythonInterpreter();
//        //注意这边要用绝对路径
//        pythonInterpreter.execfile("E:\\mlthfs\\src\\main\\resources\\pythonDemo\\hello.py");
//        //第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
//        PyFunction pyFunction = pythonInterpreter.get("hello", PyFunction.class);
//        //调用函数，此时call无参数
//        PyObject pyObject = pyFunction.__call__();
//        System.out.println(pyObject);
//    }
//
//    /**
//     * 执行文件脚本，由函数名，带参数
//     */
//    @Test
//    public void test3_Param() {
//        PythonInterpreter interpreter = new PythonInterpreter();
//        interpreter.execfile("E:\\mlthfs\\src\\main\\resources\\pythonDemo\\testWithParam.py");
//        PyFunction pyFunction = interpreter.get("my_test", PyFunction.class);
//        //调用函数，此时call传入两个参数
//        PyObject pyObject = pyFunction.__call__(new PyString("tom"), new PyString("25"));
//        System.out.println(pyObject.toString());
//    }
//
//    /**
//     * 调用三方库Runtime.getRuntime().exec（）
//     */
//    @Test
//    public void test4_ThirdPackage() {
//        try {
//            Process process = Runtime.getRuntime().exec("python E:\\mlthfs\\src\\main\\resources\\pythonDemo\\rf\\RF_lyj.py");// 执行py文件
//            //用输入输出流来截取结果
//            InputStreamReader in = new InputStreamReader(process.getInputStream());
//            BufferedReader bf = new BufferedReader(in);
//            LineNumberReader input = new LineNumberReader(bf);
//            String line;
//            while ((line = input.readLine()) != null) {
//                //得到输出
//                System.out.println(line);
//            }
//            input.close();
//            process.waitFor();
//            logger.info(String.valueOf(process.waitFor()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 其中args是String[] { “python”,path,url1,url2 }; ，path是python程序所在的路径，url1是参数1，url2是参数2
//     */
//    @Test
//    public void test4_ThirdPackage_param() {
//        ArrayList<Integer> listx = new ArrayList<>();
//        listx.add(3);
//        listx.add(7);
//        listx.add(8);
//
//
//        String[] args = new String[]{"python"
//                , "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test_ThirdPackage_param.py" + listx
//        };
//
//        String[] argumentsSVM = new String[]{"python"
//                , "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test6.py" + listx
//
//        };
//        try {
//            Process proc = Runtime.getRuntime().exec(argumentsSVM);
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                logger.info(line);
//            }
//            in.close();
//            proc.waitFor();
//            logger.info(String.valueOf(proc.waitFor()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//
//
//     */
//
//    @Test
//    public void test6_ThirdPackage_param() {
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String filePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test7.py ";
//
//        String SVRFitPath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\SVRFit.py";
//        int[] x1 = {3340, 4525, 7304, 3335};
//        int[] x2 = {5319, 5319, 3932, 3932};
//
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        Integer list1Size = null;
//        //给list1赋值
//        list1.add(3340);
//        list1.add(4525);
//        list1.add(7304);
//        list1.add(3335);
//        //给list2赋值
//        list2.add(5319);
//        list2.add(5319);
//        list2.add(3932);
//        list2.add(3932);
//        list1Size = list1.size();
//        System.out.println("list1-size()" + list1.size());
//        //将list1.list2合并
//        list1.addAll(list2);
//        //将size加到list1最后
//        list1.add(list1Size);
//
//        try {
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath + filePath + list1);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 接收二维数组
//     */
//    @Test
//    public void test7_ThirdPackage_param() {
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String filePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\test8.py ";
//        String SVRFitFilePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\SVM\\SVRFit.py ";
//
//
//        Integer x_count = null;//因子个数
//        Integer year_count = null;//年数
//
//        List<Integer> newList = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(328);
//        list1.add(941);
//        list1.add(385);
//        list1.add(4327);
//        x_count = list1.size();
//        year_count = 4;//假设为4年
//        List<Integer> list2 = new ArrayList<>();
//        //给list2赋值
//        list2.add(388);
//        list2.add(1529);
//        list2.add(2063);
//        list2.add(4108);
//
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(436);
//        list3.add(891);
//        list3.add(1719);
//        list3.add(4272);
//
//        List<Integer> list4 = new ArrayList<>();
//        list4.add(467);
//        list4.add(2450);
//        list4.add(1148);
//        list4.add(1382);
//
//        List<Integer> list5 = new ArrayList<>();
//        list4.add(3340);
//        list4.add(4525);
//        list4.add(7304);
//        list4.add(3335);
//
//        System.out.println("newList0" + newList);
//        newList.addAll(list1);
//
//        System.out.println("newList1" + newList);
//        newList.addAll(list2);
//
//        System.out.println("newList2" + newList);
//
//        newList.addAll(list3);
//        newList.addAll(list4);
//
//        System.out.println("newList4" + newList);
//
//        newList.addAll(list5);
//        newList.add(x_count);
//        newList.add(year_count);
//
//        System.out.println(newList);
//
//        try {
//
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath +
//                            SVRFitFilePath +
//                            newList);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 接收一个二维数组。一个一维数组。二维数组的行、列数
//     */
//
//    @Test
//    public void test_SVRFit() {
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String SVRFitFilePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\SVM\\SVRFit.py ";
//        Integer x_count = null;//因子个数
//        Integer year_count = null;//年数
//
//
//        Integer[] x1 = {328, 941, 385, 4327};
//        Integer[] x2 = {388, 1529, 2063, 4108};
//        Integer[] x3 = {436, 891, 1719, 4272};
//        Integer[] x4 = {467, 2450, 1148, 1382};
//        Integer[] x5 = {3340, 4525, 7304, 3335};
//
//        ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(x1));
//        ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(x2));
//        ArrayList<Integer> arrayList3 = new ArrayList<Integer>(Arrays.asList(x3));
//        ArrayList<Integer> arrayList4 = new ArrayList<Integer>(Arrays.asList(x4));
//        ArrayList<Integer> arrayList5 = new ArrayList<Integer>(Arrays.asList(x5));
//
//        x_count = arrayList1.size();
//        year_count = 4;//假设为4年
//
//        ArrayList<Integer> newarrayList = new ArrayList<Integer>();
//
//        newarrayList.addAll(arrayList1);
//        newarrayList.addAll(arrayList2);
//        newarrayList.addAll(arrayList3);
//        newarrayList.addAll(arrayList4);
//        newarrayList.addAll(arrayList5);
//        newarrayList.add(x_count);
//        newarrayList.add(year_count);
//        System.out.println(newarrayList);
//        try {
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath +
//                            SVRFitFilePath +
//                            newarrayList);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * train：率定
//     * test：验证
//     * 接收
//     * 二维数组1，train_x   [[],[],[],[],[],[]...]
//     * 一维数组1. train_y   [,,,,,....]
//     * 二维数组的行数===率定期多少年===train_row_count
//     * 二维数组的列数===          ====train_col_count
//     * 一维数组1的元素个数=二维数组1的行数===train_y_count
//     * 二维数组2. test_x    [[],[],[],[]...]
//     * 一维数组2. test_y    [,,,,.....]
//     * 二维数组2的行数===验证期多少年===test_row_count
//     * 二维数组2的列数===             ===test_col_count
//     * 一维数组2的元素个数=二维数组2的行数===test_y_count
//     */
//    @Test
//    public void test_RF() {
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String SVRFitFilePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\rf\\RF.py ";
//
//        //最大的list，将所有的list组合包含（train_x、train_y、test_x、test_y、 train_row_count、train_col_count、train_y_count、test_row_count、test_col_count、test_y_count）
//        ArrayList<Double> newArrayList = new ArrayList<>();
//        //各个需要的参数（train_x、train_y、test_x、test_y）
//        ArrayList<Double> train_x = new ArrayList<Double>();
//        ArrayList<Double> train_y = new ArrayList<Double>();
//        ArrayList<Double> test_x = new ArrayList<Double>();
//        ArrayList<Double> test_y = new ArrayList<Double>();
//        //表示数组行列数的变量 train_row_count、train_col_count、train_y_count、test_row_count、test_col_count、test_y_count
//        //率定期=train_x的行数
//        Double train_row_count = null;
//        //train_x的列数,暂时先假定
//        Double train_col_count = 15.0;
//        Double train_y_count = train_row_count;
//        //验证期=test_x的行数
//        Double test_row_count = null;
//        //test_x的列数,暂时先假定
//        Double test_col_count = 15.0;
//        Double test_y_count = test_row_count;
//
//        Double[] train_x_array1 = {-0.247, 67.5, -0.308, 22.568, 2.0, -0.124, 14.844, 24.193, 28302.633, -0.329, 3.0, 24.929, 0.38, -0.072, -0.512};
//        Double[] train_x_array2 = {-0.174, 72.5, 0.167, 22.13, 4.0, -0.072, 15.0, 27.519, 28121.133, -0.308, 3.0, 25.186, -0.137, 0.151, 0.257};
//        Double[] train_x_array3 = {-0.4, 70.0, 0.456, 19.663, 4.0, -0.253, 13.676, 16.98, 27644.031, -0.415, 4.0, -999.0, 0.07, -0.233, -0.055};
//        Double[] train_x_array4 = {-0.097, 70.0, 0.132, 19.372, 4.0, -0.192, 15.583, 23.299, 27750.867, -0.126, 4.0, 28.584, 0.252, -0.364, -0.198};
//        Double[] train_x_array5 = {-0.08, 77.5, -0.009, 22.653, 4.0, -0.215, 15.607, 22.822, 28142.668, -0.224, 3.0, 25.949, -0.223, -0.229, 0.47};
//        Double[] train_x_array6 = {-0.125, 70.0, 0.379, 21.692, 3., -0.081, 14.706, 26.838, 27851.268, -0.184, 4.0, 26.855, -0.352, 0.056, -0.056};
//        Double[] train_x_array7 = {-0.259, 70.0, 0.146, 22.172, 3., -0.113, 16.579, 21.744, 27777.867, -0.001, 2., 24.484, 0.432, -0.14, -0.159};
//        Double[] train_x_array8 = {-0.163, 65.0, 0.301, 20.345, 3., -0.05, 14.456, 26.788, 28047.268, -0.171, 3., 26.37, 0.05, 0.14, -0.041};
//        Double[] train_x_array9 = {-0.085, 62.5, 0.226, 23.965, 3., -0.282, 16.457, 24.435, 27825.465, 0.065, 3., 25.246, 0.015, -0.381, -0.942};
//        Double[] train_x_array10 = {0.092, 67.5, -0.176, 24.154, 4., 0.051, 11.611, 22.694, 28032.066, -0.11, 3., 25.074, 0.507, -0.176, 0.088};
//        Double[] train_x_array11 = {0.03, 75., -0.356, 22.292, 4., 0.105, 15.919, 25.331, 28140.635, 0.033, 3., 24.5, -0.377, 0.179, 0.675};
//        Double[] train_x_array12 = {-0.153, 75., -0.293, 23.921, 2., -0.191, 14.048, 19.318, 28086.566, -0.027, 3., 29.684, -0.169, -0.299, 0.087};
//        Double[] train_x_array13 = {-0.021, 77.5, 0.391, 22.001, 4., -0.06, 14.734, 18.539, 28205.398, -0.13, 2., -999., 0.443, -0.256, 1.201};
//        Double[] train_x_array14 = {-0.238, 62.5, 0.146, 21.314, 3., -0.379, 16.393, 22.129, 27917.332, -0.208, 3., 27.462, -0.455, -0.095, -0.502};
//        Double[] train_x_array15 = {0.051, 80., -0.396, 22.565, 2., -0.063, 17.61, 22.569, 28074.365, 0.252, 1., 28.847, -0.132, -0.107, 0.33};
//        Double[] train_x_array16 = {0.111, 65., 0.217, 24.225, 4., 0.153, 14.044, 32.262, 27938.734, 0.206, 2., 26.543, 0.304, 0.126, -0.222};
//        Double[] train_x_array17 = {0.258, 77.5, -0.387, 24.575, 3., 0.261, 15.19, 30.273, 28117.301, 0.223, 2., 25.238, -0.047, 0.17, 0.437};
//        Double[] train_x_array18 = {-0.208, 70., 0.329, 22.482, 4., -0.178, 14.569, 23.281, 27926.768, -0.298, 1., 24.803, -0.015, -0.151, -0.397};
//        Double[] train_x_array19 = {0.043, 77.5, -0.088, 24.397, 1., -0.101, 16.929, 34.474, 28138.734, 0.001, 3., 28.275, -0.148, -0.092, 0.392};
//        Double[] train_x_array20 = {-0.087, 70., -0.056, 23.042, 2., -0.155, 15.03, 27.6, 28119.766, -0.231, 4., 26.906, 0.275, -0.241, -0.414};
//        Double[] train_x_array21 = {0.124, 72.5, -0.265, 23.504, 3., 0.135, 16.226, 34.565, 28099.168, 0.123, 3., 28.793, 0.335, 0.163, 0.38};
//        Double[] train_x_array22 = {0.202, 80., -0.399, 25.423, 3., 0.353, 16.262, 31.675, 27869.498, 0.179, 3., 26.656, -0.35, 0.352, 0.243};
//        Double[] train_x_array23 = {0.003, 70., -0.18, 23.91, 5., -0.033, 13.745, 30.732, 27906.766, 0.165, 4., 23.266, 0.093, 0.069, 0.019};
//        Double[] train_x_array24 = {0.099, 80., -0.077, 23.364, 4., 0.273, 16.687, 32.176, 28033.867, 0.165, 4., 25.794, -0.123, 0.337, 0.229};
//        Double[] train_x_array25 = {0.188, 70., -0.079, 23.611, 4., 0.232, 13.394, 29.787, 28073.166, 0.111, 5., 29.808, -0.009, 0.344, -0.488};
//        Double[] train_x_array26 = {0.176, 70., 0.138, 24.579, 2., 0.322, 16.996, 34.487, 27870.332, 0.179, 3., 26.419, -0.425, 0.203, -0.444};
//        Double[] train_x_array27 = {0.32, 75., -0.424, 23.625, 4., 0.226, 15.699, 28.187, 28223.268, 0.112, 2., 25.87, 0.204, 0.258, -0.098};
//        Double[] train_x_array28 = {0.187, 67.5, 0.083, 24.558, 2., 0.212, 15.979, 29.393, 28066.768, 0.174, 3., 28.174, -0.266, 0.027, 0.176};
//        Double[] train_x_array29 = {-0.015, 72.5, -0.383, 23.458, 3., 0.003, 14.986, 31.815, 28107.535, -0.019, 2., 27.672, -0.053, -0.027, -0.278};
//        Double[] train_x_array30 = {0.322, 60., 0.369, 25.276, 4., 0.253, 12.915, 29.171, 28012.398, 0.34, 3., 26.642, -0.079, 0.245, 0.091};
//
//        ArrayList<Double> train_x_arraylist1 = new ArrayList<Double>(Arrays.asList(train_x_array1));
//        ArrayList<Double> train_x_arraylist2 = new ArrayList<Double>(Arrays.asList(train_x_array2));
//        ArrayList<Double> train_x_arraylist3 = new ArrayList<Double>(Arrays.asList(train_x_array3));
//        ArrayList<Double> train_x_arraylist4 = new ArrayList<Double>(Arrays.asList(train_x_array4));
//        ArrayList<Double> train_x_arraylist5 = new ArrayList<Double>(Arrays.asList(train_x_array5));
//        ArrayList<Double> train_x_arraylist6 = new ArrayList<Double>(Arrays.asList(train_x_array6));
//        ArrayList<Double> train_x_arraylist7 = new ArrayList<Double>(Arrays.asList(train_x_array7));
//        ArrayList<Double> train_x_arraylist8 = new ArrayList<Double>(Arrays.asList(train_x_array8));
//        ArrayList<Double> train_x_arraylist9 = new ArrayList<Double>(Arrays.asList(train_x_array9));
//        ArrayList<Double> train_x_arraylist10 = new ArrayList<Double>(Arrays.asList(train_x_array10));
//        ArrayList<Double> train_x_arraylist11 = new ArrayList<Double>(Arrays.asList(train_x_array11));
//        ArrayList<Double> train_x_arraylist12 = new ArrayList<Double>(Arrays.asList(train_x_array12));
//        ArrayList<Double> train_x_arraylist13 = new ArrayList<Double>(Arrays.asList(train_x_array13));
//        ArrayList<Double> train_x_arraylist14 = new ArrayList<Double>(Arrays.asList(train_x_array14));
//        ArrayList<Double> train_x_arraylist15 = new ArrayList<Double>(Arrays.asList(train_x_array15));
//        ArrayList<Double> train_x_arraylist16 = new ArrayList<Double>(Arrays.asList(train_x_array16));
//        ArrayList<Double> train_x_arraylist17 = new ArrayList<Double>(Arrays.asList(train_x_array17));
//        ArrayList<Double> train_x_arraylist18 = new ArrayList<Double>(Arrays.asList(train_x_array18));
//        ArrayList<Double> train_x_arraylist19 = new ArrayList<Double>(Arrays.asList(train_x_array19));
//        ArrayList<Double> train_x_arraylist20 = new ArrayList<Double>(Arrays.asList(train_x_array20));
//        ArrayList<Double> train_x_arraylist21 = new ArrayList<Double>(Arrays.asList(train_x_array21));
//        ArrayList<Double> train_x_arraylist22 = new ArrayList<Double>(Arrays.asList(train_x_array22));
//        ArrayList<Double> train_x_arraylist23 = new ArrayList<Double>(Arrays.asList(train_x_array23));
//        ArrayList<Double> train_x_arraylist24 = new ArrayList<Double>(Arrays.asList(train_x_array24));
//        ArrayList<Double> train_x_arraylist25 = new ArrayList<Double>(Arrays.asList(train_x_array25));
//        ArrayList<Double> train_x_arraylist26 = new ArrayList<Double>(Arrays.asList(train_x_array26));
//        ArrayList<Double> train_x_arraylist27 = new ArrayList<Double>(Arrays.asList(train_x_array27));
//        ArrayList<Double> train_x_arraylist28 = new ArrayList<Double>(Arrays.asList(train_x_array28));
//        ArrayList<Double> train_x_arraylist29 = new ArrayList<Double>(Arrays.asList(train_x_array29));
//        ArrayList<Double> train_x_arraylist30 = new ArrayList<Double>(Arrays.asList(train_x_array30));
//
//        train_x.addAll(train_x_arraylist1);
//        train_x.addAll(train_x_arraylist2);
//        train_x.addAll(train_x_arraylist3);
//        train_x.addAll(train_x_arraylist4);
//        train_x.addAll(train_x_arraylist5);
//        train_x.addAll(train_x_arraylist6);
//        train_x.addAll(train_x_arraylist7);
//        train_x.addAll(train_x_arraylist8);
//        train_x.addAll(train_x_arraylist9);
//        train_x.addAll(train_x_arraylist10);
//        train_x.addAll(train_x_arraylist11);
//        train_x.addAll(train_x_arraylist12);
//        train_x.addAll(train_x_arraylist13);
//        train_x.addAll(train_x_arraylist14);
//        train_x.addAll(train_x_arraylist15);
//        train_x.addAll(train_x_arraylist16);
//        train_x.addAll(train_x_arraylist17);
//        train_x.addAll(train_x_arraylist18);
//        train_x.addAll(train_x_arraylist19);
//        train_x.addAll(train_x_arraylist20);
//        train_x.addAll(train_x_arraylist21);
//        train_x.addAll(train_x_arraylist22);
//        train_x.addAll(train_x_arraylist23);
//        train_x.addAll(train_x_arraylist24);
//        train_x.addAll(train_x_arraylist25);
//        train_x.addAll(train_x_arraylist26);
//        train_x.addAll(train_x_arraylist27);
//        train_x.addAll(train_x_arraylist28);
//        train_x.addAll(train_x_arraylist29);
//        train_x.addAll(train_x_arraylist30);
//
//        Double[] train_y_array = {1527.916667, 1457.25, 2391.666667, 1823.916667, 1210.583333, 754.5, 1199.416667, 970.0, 1464.25, 1140.083333, 823.3333333, 911.5, 1054.916667, 852.3333333, 707.3333333, 1132.5, 534.75, 1035.75, 541.5833333, 1235.333333, 658.9166667, 624.6666667, 1553.75, 901.1666667, 1459.25, 782.1666667, 1034., 868.3333333, 1131.666667, 1515.833333};
//        ArrayList<Double> train_y_arraylist = new ArrayList<Double>(Arrays.asList(train_y_array));
//        train_y.addAll(train_y_arraylist);
//
//        train_y_count = Double.valueOf(train_y_arraylist.size());
//        train_row_count = Double.valueOf(train_y_arraylist.size());
//
//        Double[] test_x_array1 = {-0.103, 67.5, 0.091, 24.027, 3., -0.159, 15.612, 32.923, 28053.332, 0.122, 5., 29.897, 0.382, -0.028, -0.782};
//        Double[] test_x_array2 = {0.049, 65., 0.097, 23.419, 3., 0.049, 16.44, 29.864, 27856.299, 0.082, 3., 27.688, -0.44, 0.133, -0.319};
//        Double[] test_x_array3 = {0.119, 72.5, -0.117, 23.054, 3., 0.141, 15.057, 30.543, 28267.133, 0.004, 3., 24.555, -0.628, 0.181, -0.047};
//        Double[] test_x_array4 = {0.383, 77.5, -0.422, 24.613, 3., 0.356, 14.618, 33.584, 28028.668, 0.246, 3., 31.223, 0.273, 0.327, 0.123};
//        Double[] test_x_array5 = {0.546, 80., -0.201, 24.241, 4., 0.436, 16.26, 34.822, 28239.199, 0.576, 4., 25.569, -0.057, 0.482, 0.35};
//        Double[] test_x_array6 = {0.258, 80., -0.254, 24.523, 3., 0.116, 14.607, 31.543, 28236.844, 0.219, 3., 26.334, 0.076, 0.223, 0.085};
//
//        ArrayList<Double> test_x_arraylist1 = new ArrayList<Double>(Arrays.asList(test_x_array1));
//        ArrayList<Double> test_x_arraylist2 = new ArrayList<Double>(Arrays.asList(test_x_array2));
//        ArrayList<Double> test_x_arraylist3 = new ArrayList<Double>(Arrays.asList(test_x_array3));
//        ArrayList<Double> test_x_arraylist4 = new ArrayList<Double>(Arrays.asList(test_x_array4));
//        ArrayList<Double> test_x_arraylist5 = new ArrayList<Double>(Arrays.asList(test_x_array5));
//        ArrayList<Double> test_x_arraylist6 = new ArrayList<Double>(Arrays.asList(test_x_array6));
//
//        test_x.addAll(test_x_arraylist1);
//        test_x.addAll(test_x_arraylist2);
//        test_x.addAll(test_x_arraylist3);
//        test_x.addAll(test_x_arraylist4);
//        test_x.addAll(test_x_arraylist5);
//        test_x.addAll(test_x_arraylist6);
//
//        Double[] test_y_array = {1616.75, 1010.333333, 757.0833333, 948.5833333, 857.75, 659.4166667};
//        ArrayList<Double> test_y_arraylist = new ArrayList<Double>(Arrays.asList(test_y_array));
//
//        test_y.addAll(test_y_arraylist);
//        test_row_count = Double.valueOf(test_y_arraylist.size());
//
//        test_y_count = Double.valueOf(test_y_arraylist.size());
//
//        newArrayList.addAll(train_x);
//        newArrayList.addAll(train_y);
//        newArrayList.addAll(test_x);
//        newArrayList.addAll(test_y);
//
//        newArrayList.add(train_row_count);
//        newArrayList.add(train_col_count);
//        newArrayList.add(test_row_count);
//        newArrayList.add(test_col_count);
//        newArrayList.add(train_y_count);
//        newArrayList.add(test_y_count);
//
//        String res = com.hhu.mlthfs.utils.ExcuteCmd.excuteCmd_multiThread(pythonPath +
//                SVRFitFilePath +
//                newArrayList, "utf-8");
//        System.out.println(res);
//
//
////        try {
////            Process process = Runtime.getRuntime().exec(
////                    pythonPath +
////                            SVRFitFilePath +
////                            newArrayList
////            );
////            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
////            String line;
////            in.readLine();
////            while ((line = in.readLine()) != null) {
////                System.out.println(line);
////            }
////            in.close();
////            int re = process.waitFor();
////            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
//
//    /**
//     * 字符串转数组
//     */
//    @Test
//    public void test_str(){
//
//        // 字符串转数组  java.lang.String
//        String str = "0,12,23,34,4,5";
//        System.out.println(str);
//        String[] arr = str.split(","); // 用,分割
//        int[] arr_int=new int[arr.length];
//        for (int i=0;i<arr.length;i++){
//            arr_int[i]=Integer.parseInt(arr[i]);
//        }
//        System.out.println(arr_int);
//
//        System.out.println(arr.length);
//        System.out.println(arr[0]);
//        System.out.println("arr"+arr.toString());
//        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
//
//
//
//        String result="(array([1373.69583354, 1273.77666666, 2006.96666692, 1639.71666691,       1083.56249979,  891.04583335, 1185.29833355, 1152.02583337,       1326.01833334, 1238.91999981,  891.11749995,  999.72      ,       1073.39250019,  950.63749998,  760.21916664, 1155.6325    ,        721.46916667, 1108.82250004,  678.05749996, 1226.81833313,        830.38083335,  692.89500002, 1390.76916667,  937.77416668,       1367.13916665,  837.64500002, 1079.49166666,  873.3758333 ,       1085.42500024, 1323.54333311]), array([1179.4566667 ,  893.43666668, 1022.53583334, 1002.07333333,        829.11916665, 1065.63416668]))";
//        String result1=result.replaceAll("\\s+","");//去除空格
//        System.out.println(result1);
//        String result2=result1.replaceAll("\\)","),");//改变最后的字符
//        System.out.println(result2);
//        //开始分割，（原字符串，第一个符号，第二个符号）
//        String result3= SubStringUtil.subString(result2,"array([","]),");
//        System.out.println(result3);
//        String result4=SubStringUtil.subString(result2,",,array([","]),),");
//        System.out.println(result4);
//
//        //按逗号分割转为字符串类型数组
//        String[] arr1=result3.split(",");
//        System.out.println(Arrays.toString(arr1));
//        String[] arr2=result4.split(",");
//        System.out.println(Arrays.toString(arr2));
//
//        //分别定义两个数字类型的数组
//        double[] arr1_double=new double[arr1.length];
//        double[] arr2_double=new double[arr2.length];
//
//        //将字符类型转为数字类型
//        for(int i=0;i<arr1.length;i++){
//            arr1_double[i]=Double.parseDouble(arr1[i]);
////            System.out.println(arr1_double[i]);
//        }
//        for(int i=0;i<arr2.length;i++){
//            arr2_double[i]=Double.parseDouble(arr2[i]);
//            System.out.println(arr2_double[i]);
//        }
//
//    }
//
//    /**
//     * 随机森林模型（excel）
//     *
//     */
//    @Test
//    public void test_pythonRFFile() {
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String filePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\rf.py ";
//
//        List<String> param=new ArrayList<>();
//
//        String s1="F:\\\\train.xlsx";
//        String s2="F:\\\\test.xlsx";
//        String s3="F:\\\\train_result.xlsx";
//        String s4="F:\\\\train_result.xlsx";
//        param.add(s1);
//        param.add(s2);
//        param.add(s3);
//        param.add(s4);
//
//
//        try {
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath + filePath + param);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 因子筛选（excel）1
//     */
//    @Test
//    public void test_pythonSelectFile(){
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String filePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\standard\\select.py";
//
//        List<String> param=new ArrayList<>();
//        String in_AllFactors_filePath="F:\\AllFactors.xlsx";
//        String in_Forecast_month="1";
//        String out_SelectionFactors_filePath="F:\\SelectionFactors.xlsx";
//
//        param.add(in_AllFactors_filePath);
//        param.add(in_Forecast_month);
//        param.add(out_SelectionFactors_filePath);
//
//        try {
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath + filePath + param);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     * 随机森林模型 率定验证（excel）2
//     *
//     */
//    @Test
//    public void Test_RFExcel(){
//        String pythonPath = "D:\\Program Files\\Python\\Python36\\python.exe ";
//        String filePath = "E:\\mlthfs\\src\\main\\resources\\pythonDemo\\standard\\rf.py ";
//
//        List<String> param=new ArrayList<>();
//        String in_selectionFactorsFilePath="F:\\SelectionFactors.xlsx";
//        String in_month_forecast="1";
//        String in_testTime="11";
//        String out_train_rasult="F:\\out_train_result_RF.xlsx";
//        String out_test_rasult="F:\\out_test_result_RF.xlsx";
//
//        param.add(in_selectionFactorsFilePath);
//        param.add(in_month_forecast);
//        param.add(in_testTime);
//        param.add(out_train_rasult);
//        param.add(out_test_rasult);
//
//        try {
//            Process process = Runtime.getRuntime().exec(
//                    pythonPath + filePath + param);
//            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            int re = process.waitFor();
//            System.out.println(re == 1 ? "----状态码1----运行失败" : "----状态码0----运行成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
