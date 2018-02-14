package com.lxt.common.excel;

import com.lxt.common.exception.SheetNotFindException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * poi操作excel工具类
 *
 * @author lixuetao
 * @version 1.0
 */
public class ExcelUtils {

    /**
     * 从模板读取excel
     * @param templatePath
     * @return
     */
    public static Workbook getExcelFromTemplate(String templatePath){
        templatePath = templatePath.replaceAll("%20", "");
        File templateFile = new File(templatePath);
        if (templateFile.exists()) {
            POIFSFileSystem fs = null;
            try {
                fs = new POIFSFileSystem(new FileInputStream(templateFile));
                //读取excel模板
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                return wb;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Sheet getSheetByName(Workbook wb, String sheetName){
        if (!checkSheet(wb, sheetName)){
            Sheet sheet = wb.createSheet(sheetName);
            return sheet;
        }else {
            throw new SheetNotFindException("Sheet(" + sheetName + ")不存在");
        }
    }

    /**
     * 根据旧sheet名，重命名sheet
     * @param wb
     * @param oldName
     * @param newName
     */
    public static void renameSheet(Workbook wb, String oldName, String newName){
        if (!checkSheet(wb, oldName)){
            int index = wb.getSheetIndex(oldName);
            wb.setSheetName(index, newName);
        }else {
            throw new SheetNotFindException("Sheet(" + oldName + ")不存在");
        }
    }

    /**
     * 隐藏sheet
     * @param wb
     * @param sheetName
     */
    public static void hiddenSheet(Workbook wb, String sheetName){
        operateSheet(wb, sheetName, 1);
    }

    /**
     * 显示sheet
     * @param wb
     * @param sheetName
     */
    public static void showSheet(Workbook wb, String sheetName){
        operateSheet(wb, sheetName, 0);
    }

    /**
     * 操作sheet的隐藏显示：
     * <li>0 - 显示. </li>
     * <li>1 - 隐藏. </li>
     * <li>2 - 深度隐藏.</li>
     * @param wb
     * @param sheetName
     * @param hidden
     */
    public static void operateSheet(Workbook wb, String sheetName, int hidden){
        if (!checkSheet(wb, sheetName)){
            int hiddenSheetIndex = wb.getSheetIndex(sheetName);
            wb.setSheetHidden(hiddenSheetIndex, hidden);
        }else {
            throw new SheetNotFindException("Sheet(" + sheetName + ")不存在");
        }
    }

    /**
     * 删除sheet
     * @param wb
     * @param sheetName
     */
    public static void removeSheet(Workbook wb, String sheetName){
        if (!checkSheet(wb, sheetName)){
            int removeSheetIndex = wb.getSheetIndex(sheetName);
            wb.removeSheetAt(removeSheetIndex);
        }else {
            throw new SheetNotFindException("Sheet(" + sheetName + ")不存在");
        }
    }

    /**
     * 检查工作表是否存在
     * @param wb
     * @param sheetName
     * @return
     */
    public static boolean checkSheet(Workbook wb, String sheetName){
        try{
            for(int numSheets = 0; numSheets < wb.getNumberOfSheets(); numSheets++){
                Sheet sheet = wb.getSheetAt(numSheets);
                if (sheetName.equals(sheet.getSheetName())){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 插入或更新单元格的值
     * @param sheet
     * @param rowNum
     * @param cellNum
     * @param value
     */
    public static void insertOrUpdateCell(Sheet sheet, int rowNum, int cellNum, String value){
        Row row = null;
        if (sheet.getLastRowNum() < rowNum){
            row = sheet.createRow(rowNum);
        } else {
            row = sheet.getRow(rowNum);
        }
        Cell cell = row.getCell(cellNum);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(value);
    }

    /**
     * 清除sheet内容
     * @param sheet
     */
    public static void clearSheet(Sheet sheet){
        for(int i = 0; i < sheet.getLastRowNum(); i++){
            if (sheet.getRow(i) != null){
                sheet.removeRow(sheet.getRow(i));
            }
        }
    }

    /**
     * 清除行内容
     * @param sheet
     * @param row
     */
    public static void clearRow(Sheet sheet, int row){
        if (sheet.getRow(row) != null){
            sheet.removeRow(sheet.getRow(row));
        }else{
            throw new UnsupportedOperationException("row" + row + "不存在");
        }
    }

    /**
     * 移除行
     * @param sheet
     * @param rowIndex
     */
    public static void removeRow(HSSFSheet sheet, int rowIndex) {
        int lastRowNum=sheet.getLastRowNum();
        if(rowIndex>=0&&rowIndex<lastRowNum)
            sheet.shiftRows(rowIndex+1,lastRowNum,-1);//将行号为rowIndex+1一直到行号为lastRowNum的单元格全部上移一行，以便删除rowIndex行
        if(rowIndex==lastRowNum){
            HSSFRow removingRow=sheet.getRow(rowIndex);
            if(removingRow!=null)
                sheet.removeRow(removingRow);
        }
    }

    /**
     * 创建常见单元格样式
     * 居中，11字符宋体，黑色实线
     * @param wb
     * @return
     */
    private static HSSFCellStyle syleOfCenterBorder(HSSFWorkbook wb){
        short fontSize = 11;
        BorderStyle borderStyle = BorderStyle.THIN;
        IndexedColors borderColor = IndexedColors.BLACK;
        HorizontalAlignment horizontalAlignment = HorizontalAlignment.CENTER;
        VerticalAlignment verticalAlignment = VerticalAlignment.CENTER;
        String fontName = "宋体";
        IndexedColors fontColor = IndexedColors.BLACK;
        return createStyle(wb, fontSize, borderStyle, borderColor, horizontalAlignment, verticalAlignment, fontName, fontColor);
    }

    /**
     * 创建单元格样式
     * @param wb
     * @param fontSize
     * @return
     */
    private static HSSFCellStyle createStyle(HSSFWorkbook wb, short fontSize,
                                                           BorderStyle borderStyle, IndexedColors borderColor,
                                                           HorizontalAlignment horizontalAlign,
                                                           VerticalAlignment verticalAlign,
                                                           String fontName, IndexedColors fontColor){
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(borderStyle);
        cellStyle.setBorderLeft(borderStyle);
        cellStyle.setBorderRight(borderStyle);
        cellStyle.setBorderTop(borderStyle);
        cellStyle.setBottomBorderColor(borderColor.getIndex());
        cellStyle.setLeftBorderColor(borderColor.getIndex());
        cellStyle.setRightBorderColor(borderColor.getIndex());
        cellStyle.setTopBorderColor(borderColor.getIndex());
        cellStyle.setAlignment(horizontalAlign);
        cellStyle.setVerticalAlignment(verticalAlign);

        HSSFFont font=wb.createFont();
        font.setColor(fontColor.index);//HSSFColor.VIOLET.index //字体颜色
        font.setFontHeightInPoints(fontSize);
        font.setFontName(fontName);
        cellStyle.setFont(font);

        return cellStyle;
    }

}
