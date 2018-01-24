package com.centit.hlwyw.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExportUtil<T> {
	private static Logger log = Logger.getLogger(ExportUtil.class);  

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param title
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 */

	@SuppressWarnings("unchecked")
	public HSSFWorkbook exportExcelMore(String[] headers,List<T> dataset) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个样式
		CellStyle header = workbook.createCellStyle();
		header.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		header.setFillPattern(CellStyle.SOLID_FOREGROUND);
		header.setBorderTop(HSSFCellStyle.BORDER_THIN);
		header.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		header.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		header.setBorderRight(HSSFCellStyle.BORDER_THIN);
		CellStyle border = workbook.createCellStyle();
		border.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		border.setFillPattern(CellStyle.SOLID_FOREGROUND);
		border.setBorderTop(HSSFCellStyle.BORDER_THIN);
		border.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		border.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		border.setBorderRight(HSSFCellStyle.BORDER_THIN);
		int sheetcount;
		if (dataset.size() % 60000 == 0) {
			sheetcount = dataset.size() / 60000;
		} else {
			sheetcount = dataset.size() / 60000 + 1;
		}
		for (int i = 0; i < sheetcount; i++) {
			if(i==sheetcount-1){
				createSheet(workbook, i, headers,dataset.subList(i * 60000, dataset.size()-1),border,header);
			}else{
				createSheet(workbook, i, headers,dataset.subList(i * 60000, (i + 1) * 60000 - 1),border,header);
			}
		}
		return workbook;

	}

	private void createSheet(HSSFWorkbook workbook, int i,
			String[] headers, List<T> dataset,CellStyle style,CellStyle style2) {
		HSSFSheet sheet = workbook.createSheet("sheet" + i);
		createHeader(  sheet,0, headers,style2);
		int index = 1;
		for (T t : dataset) {
			createRow(  sheet, index, t,style);
			index++;
		}
	}

	private void createHeader(
//			HSSFWorkbook workbook,
			HSSFSheet sheet, int index, String[] headers,CellStyle style) {
		HSSFRow row = sheet.createRow(index);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
	}

	private void createRow(
//			HSSFWorkbook workbook, 
			HSSFSheet sheet, int index, T t,CellStyle style) {
		
		HSSFRow row = sheet.createRow(index);
		// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
		Field[] fields = t.getClass().getDeclaredFields();
		Field[] newFields = new Field[fields.length - 1];
		System.arraycopy(fields, 1, newFields, 0, fields.length - 1);
		SimpleDateFormat sdf =null;
		for (short i = 0; i < newFields.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			Field field = newFields[i];
			String fieldName = field.getName();
			String getMethodName = "get"
					+ fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			try {
				Class tCls = t.getClass();
				Method getMethod = tCls
						.getMethod(getMethodName, new Class[] {});
				Object value = getMethod.invoke(t, new Object[] {});
				// 判断值的类型后进行强制类型转换
				String textValue = null;
				if (value instanceof Date) {
					Date date = (Date) value;
					  sdf = new SimpleDateFormat("yyyy-MM-dd");
					textValue = sdf.format(date);
				} else {
					// 其它数据类型都当作字符串简单处理
					if (value == null) {
						textValue = "";
					} else {
						textValue = value.toString();
					}
				}
				cell.setCellValue(textValue);
				// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
				/*if (textValue != null) {
					Pattern p = Pattern.compile("^//d+(//.//d+)?$");
					Matcher matcher = p.matcher(textValue);
					if (matcher.matches()) {
						// 是数字当作double处理
						cell.setCellValue(Double.parseDouble(textValue));
					} else {
						cell.setCellValue(textValue);
					}
				}*/
			} catch (SecurityException e) {
				
				log.error(e.getMessage());log.info(e);
			} catch (NoSuchMethodException e) {
				
				log.error(e.getMessage());log.info(e);
			} catch (IllegalArgumentException e) {
				
				log.error(e.getMessage());log.info(e);
			} catch (IllegalAccessException e) {
				
				log.error(e.getMessage());log.info(e);
			} catch (InvocationTargetException e) {
				
				log.error(e.getMessage());log.info(e);
			} 
		}
	}

	public static Object convertType(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			// 得到Boolean对象的方法
			return (Boolean.toString(cell.getBooleanCellValue()) );
		case Cell.CELL_TYPE_NUMERIC:
			// 先看是否是日期格式
			if (DateUtil.isCellDateFormatted(cell)) {
				// 读取日期格式
				return (cell.getDateCellValue().toString());
			} else {
				// 读取数字
				return (Double.toString(cell.getNumericCellValue()) ).split("\\.")[0];
			}
		case Cell.CELL_TYPE_FORMULA:
			// 读取公式
			return cell.getCellFormula().toString();
		case Cell.CELL_TYPE_STRING:
			// 读取String
			return cell.getRichStringCellValue().toString();
		}
		return null;
	}

}
