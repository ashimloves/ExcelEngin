package org.eaffiliation.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


@SuppressWarnings("unused")
public class Engin {


@SuppressWarnings("deprecation")
public static void main(String[] args) {
	try {
		Class.forName("jdbc:oracle:thin:@hostname:port Number:databaseName");
		Connection con = DriverManager.getConnection("url", "user", "pass");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from tablename");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("lawix10");
		HSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell((short) 0).setCellValue("CellHeadName1");
		rowhead.createCell((short) 1).setCellValue("CellHeadName2");
		rowhead.createCell((short) 2).setCellValue("CellHeadName3");
		int i = 1;
		while (rs.next())
		{
			HSSFRow row = sheet.createRow((short) i);
			row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("column1")));
			row.createCell((short) 1).setCellValue(rs.getString("column2"));
			row.createCell((short) 2).setCellValue(rs.getString("column3"));
			i++;
		}
		String yemi = "g:/test.xls";
		FileOutputStream fileOut = new FileOutputStream(yemi);
		workbook.write(fileOut);
		fileOut.close();
    	}
	catch (ClassNotFoundException e1)
	{
		e1.printStackTrace();
    }
	catch (SQLException e1)
	{
        e1.printStackTrace();
    }
	catch (FileNotFoundException e1)
	{
        e1.printStackTrace();
    }
	catch (IOException e1)
	{
        e1.printStackTrace();
    }
	}
}