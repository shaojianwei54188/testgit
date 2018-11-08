package com.hhu.mlthfs.utils;

import com.alibaba.fastjson.JSON;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 读取excel，xlsx格式转化为json
 * 传入excel文件路径
 * 返回 excelMap
 */

public class ExcelUtils {
    public static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public static LinkedHashMap<String, String> excelToJson(String excelPath) throws IOException {
        logger.info("-----------excelToJson方法开始执行-----------");


        //返回的map
        LinkedHashMap<String, String> excelMap = new LinkedHashMap<>();
        // Excel列的样式，主要是为了解决Excel数字科学计数的问题
        CellStyle cellStyle;
        // 根据Excel构成的对象
        Workbook wb;
        // 如果是2007及以上版本，则使用想要的Workbook以及CellStyle
        logger.info("-----------是2007及以上版本  xlsx--------------");
        wb = new XSSFWorkbook(new FileInputStream(excelPath));
        XSSFDataFormat dataFormat = (XSSFDataFormat) wb.createDataFormat();
        cellStyle = wb.createCellStyle();
        // 设置Excel列的样式为文本
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        // sheet表个数
        int sheetsCounts = wb.getNumberOfSheets();
        // 遍历每一个sheet
        for (int i = 0; i < sheetsCounts; i++) {
            Sheet sheet = wb.getSheetAt(i);
            logger.info("第" + i + "个sheet:" + sheet.getSheetName().toString());
            // 一个sheet表对于一个List
            List list = new LinkedList();
            // 将第一行的列值作为正个json的key
            String[] cellNames;
            // 取第一行列的值作为key
            Row fisrtRow = sheet.getRow(0);
            // 如果第一行就为空，则是空sheet表，该表跳过
            if (null == fisrtRow) {
                continue;
            }
            // 得到第一行有多少列
            int curCellNum = fisrtRow.getLastCellNum();
            System.out.println("第一行的列数：" + curCellNum);
            // 根据第一行的列数来生成列头数组
            cellNames = new String[curCellNum];
            // 单独处理第一行，取出第一行的每个列值放在数组中，就得到了整张表的JSON的key
            for (int m = 0; m < curCellNum; m++) {
                Cell cell = fisrtRow.getCell(m);
                // 设置该列的样式是字符串
                cell.setCellStyle(cellStyle);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                // 取得该列的字符串值
                cellNames[m] = cell.getStringCellValue();
            }
            for (String s : cellNames) {
                logger.info("得到第" + i + " 张sheet表的列头： " + s + ",");
            }
            System.out.println();
            // 从第二行起遍历每一行
            int rowNum = sheet.getLastRowNum();
            System.out.println("总共有 " + rowNum + " 行");
            for (int j = 1; j <= rowNum; j++) {
                // 一行数据对于一个Map
                LinkedHashMap rowMap = new LinkedHashMap();
                // 取得某一行
                Row row = sheet.getRow(j);
                int cellNum = row.getLastCellNum();
                // 遍历每一列
                for (int k = 0; k < cellNum; k++) {
                    Cell cell = row.getCell(k);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            cell.setCellStyle(cellStyle);
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            rowMap.put(cellNames[k], cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            cell.setCellStyle(cellStyle);
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            // 保存该单元格的数据到该行中
                            rowMap.put(cellNames[k], cell.getNumericCellValue());
                            break;
                    }

//                    cell.setCellStyle(cellStyle);
//                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    // 保存该单元格的数据到该行中
//                    rowMap.put(cellNames[k], cell.getNumericCellValue());
                }
                // 保存该行的数据到该表的List中
                list.add(rowMap);
            }
            // 将该sheet表的表名为key，List转为json后的字符串为Value进行存储,false:json显示为一行，true：显示为标准格式
            excelMap.put(sheet.getSheetName() + "月", JSON.toJSONString(list, false));
        }
        logger.info("-------------------excelToJson方法结束----------------");
        return excelMap;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String excelPath1 = "F:\\test.xlsx"; //Excel2007
        //excel转换成json
        LinkedHashMap<String, String> excelMap = excelToJson(excelPath1);
        System.out.println(excelMap.get("test"));
    }


}
