//package com.hhu.mlthfs;
//
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Maps;
//import com.hhu.mlthfs.utils.CreateFileUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.*;
//
//import static com.hhu.mlthfs.utils.ExcelUtils.excelToJson;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class EchartsTest {
//    @Test
//    public void test1() throws IOException {
//
////        String excelPath1 = "F:\\师门项目\\2018 中长期项目\\王军师兄2018.9.24_郦于杰\\王军师兄2018.9.24\\随机森林-率定期.xlsx"; //Excel2007
//        String excelPath1 = "F:\\forecast_plans\\DanJiangKou\\sys_plan_2018-11_RF_01\\selectedFactors.xlsx"; //Excel2007
//        //excel转换成json
//        LinkedHashMap<String, String> excelMap = excelToJson(excelPath1);
////        System.out.println(excelMap.get(1+"月"));
////        System.out.println(excelMap.get("1月").length());
//
//        Map<String, Object> result = Maps.newHashMap();
//        result.put("status",200);
//        result.put("message","");
////        result.put("total",excelMap.get("1月").length());
//        result.put("rows",excelMap.get("1月"));
//        System.out.println(result.toString());
//
////
//
//        JSONObject json =new JSONObject(result);
//
//        System.out.println(json);
//        System.out.println(json.toString());
//        String jsonStr=json.toString()
//                .replaceAll("\\\\","")
//                .replaceAll("\"\\[","\\[")
//                .replaceAll("]\"","]");
//
//
//        CreateFileUtil.createJsonFile(jsonStr, "E:\\mlthfs\\src\\main\\resources\\static\\common\\json\\table","table1");
//
//
//
//
//
////
////        List list = new ArrayList();
////        Iterator iter = result.entrySet().iterator(); // 获得map的Iterator
////        while (iter.hasNext()) {
////            Entry entry = (Entry) iter.next();
////            list.add(entry.getKey());
////            list.add(entry.getValue());
////        }
////
////        System.out.println("list"+list);
////        LayerData<SelectedFactors> layerData=new LayerData<SelectedFactors>();
////        layerData.setData(list);
////        layerData.setCode(200);
////        layerData.setCount(21);
////        System.out.println(layerData);
//    }
//}
