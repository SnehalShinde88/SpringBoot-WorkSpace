package com.euro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XmlReadingAndWritting {
	static XSSFRow row;

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		euroDataBean databean = new euroDataBean();
		Connection con= DBConnection.getConnect();
		System.out.println("Getting connection :: "+ con);
		readFile(con,databean);
	}
	
	public static void readFile(Connection conn, euroDataBean databean) throws FileNotFoundException, IOException, ClassNotFoundException {

	// FileInputStream fis;
	try {
		System.out.println(
				"-------------------------------READING THE SPREADSHEET-------------------------------------");

		//FileInputStream fis=new FileInputStream(new File("E:\\eurodata.xlsx")); 
		//FileInputStream fis=new FileInputStream(new File("E:\\reportcarddata.xlsx")); 
		//FileInputStream fis=new FileInputStream(new File("E:\\grade1H.xlsx")); 
		FileInputStream fis=new FileInputStream(new File("E:\\grade10T2.xlsx")); 



		//FileInputStream fis=new FileInputStream(new File(Utilities.getProperty("PICK_XLS_FILE"))); 
		System.out.println("PICK_XLSX_FILE: "+fis.toString());
		//System.out.println("file picked :"+Utilities.getProperty("PICK_XLS_FILE"));

			
			
			XSSFWorkbook workbookRead = new XSSFWorkbook(fis);
			XSSFSheet spreadsheetRead = workbookRead.getSheetAt(0);

			int a = spreadsheetRead.getLastRowNum()+1;
			System.out.println("total row: "+a);
			
			Iterator<Row> rowIterator = spreadsheetRead.iterator();
			ArrayList<euroDataBean> bean = new ArrayList<euroDataBean>();
			ArrayList a1 = new ArrayList();
			euroDataBean eurobean = new euroDataBean();
			while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue;
			}
			Iterator<Cell> cellIterator = row.cellIterator();
			rowIterator.hasNext();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				//cell.setCellType(CellType.STRING);

			}
			System.out.println();
			
			eurobean.setSname(row.getCell(0).getStringCellValue());
			String classValue = eurobean.setSClass(row.getCell(1).getStringCellValue());
			eurobean.setSSection(row.getCell(2).getStringCellValue());
			eurobean.setS1(row.getCell(3).getStringCellValue());
			eurobean.setS2(row.getCell(4).getStringCellValue());
			eurobean.setS3(row.getCell(5).getStringCellValue());
			eurobean.setS4(row.getCell(6).getStringCellValue());
			eurobean.setS5(row.getCell(7).getStringCellValue());
			eurobean.setS6(row.getCell(8).getStringCellValue());
			eurobean.setS7(row.getCell(9).getStringCellValue());
			eurobean.setS8(row.getCell(10).getStringCellValue());
			eurobean.setS9(row.getCell(11).getStringCellValue());
			eurobean.setS10(row.getCell(12).getStringCellValue());

			//bean.add(eurobean);
			a1.add(eurobean);
						
		
				
				//generateAndSignPDF(bean,eurobean);
				//generateAndSignPDF(a1,eurobean);
			EuroReportCard card = new EuroReportCard();
			String pdfName = eurobean.getSname()+"_"+eurobean.getSClass()+eurobean.getSSection()+" Report Card.pdf";
			String folderDest = "GRADE"+classValue;
			System.out.println("name of pdf :"+pdfName +" & CLASS VALUE : "+folderDest);
		euroDataBean ebean = new euroDataBean();
		card.createPdf(bean,eurobean,pdfName,classValue,folderDest);
				
			
			/*System.out.println("Data Insertion started");
			InsertRowInDB(bean,conn);
			
			System.out.println("read Executed");
			Vector dataHolder = xlsRead.read(vcfbean );
			System.out.println("Vectore size: "+dataHolder.size() );
			xlsRead.updateDOB(dataHolder, conn);*/
			
		}

			
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	private static void generateAndSignPDF(ArrayList bean, euroDataBean eurobean) {
		// TODO Auto-generated method stub
		EuroReportCard card = new EuroReportCard();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//EuroReportCard generateAndSignCNDN = new EuroReportCard(euroDataBean);
		for(int i=0;i<bean.size(); i++ ){
			String pdfName = i+"NewPdf.pdf";
			System.out.println("name of pdf :"+pdfName);
		euroDataBean ebean = new euroDataBean();
		//card.createPdf(bean,eurobean,pdfName);
		}
		
		/*String fileName="";
		if(cndndataBean.getCreditNoteNumber()!=null && !cndndataBean.getCreditNoteNumber().trim().equals("")) {
			fileName="CN_"+cndndataBean.getCreditNoteNumber().trim()+".pdf";
		}
		if(cndndataBean.getDebitNoteNumber()!=null && !cndndataBean.getDebitNoteNumber().trim().equals("")) {
			fileName="DN_"+cndndataBean.getDebitNoteNumber().trim()+".pdf";
		}
		String DEST = "test_1.pdf";
		OutputStream os = new FileOutputStream(fileName);
		os.write(baos.toByteArray());*/
		//Connection con = null;
		
		/*
		 * /savePDF(con,baos,cndndataBean); baos=null;
		 */

	}
}
