package com.euro;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EuroReportCard {

	public static void main(String args[]) {
		try {
			// Create Document instance.
			Document document = new Document();
			
			// Create OutputStream instance.
			final String dest = "E:\\TestFile.pdf";

			// Create PDFWriter instance.
			PdfWriter.getInstance(document, new FileOutputStream(dest));
			// PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			float[] columnWidths = { 300, 250 };
			PdfPTable table = new PdfPTable(columnWidths);
			table.setTotalWidth(550F);
			table.setLockedWidth(true);

			//buildNestedAddressAndLogoTables(table);
			table.setSpacingAfter(10);
			document.add(table);

			float[] columnWidthsForName = { 22, 110, 10, 25, 20, 31, 20 };
			table = new PdfPTable(columnWidthsForName);
			table.setTotalWidth(420F);
			table.setLockedWidth(true);
			//buildNestedTablesName(table);
			document.add(table);

			float[] columnWidthsForMarks = { 150, 150, 100, 100 };
			table = new PdfPTable(columnWidthsForMarks);
			table.setTotalWidth(550F);
			table.setLockedWidth(true);
			//buildNestedTablesMarks(table);
			document.add(table);

			/*document.add(new Paragraph(
					"-------------------------------------------------------------------------------------------------------------------------"));
*/
			document.close();

			System.out.println("Pdf created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void buildNestedTablesMarks(PdfPTable outerTable, euroDataBean eurobean) {
		// TODO Auto-generated method stub
		Font headerRowFont = FontFactory.getFont("Ariel", 10, Color.BLACK);
		Font headerRowFont1 = FontFactory.getFont("Ariel", 10, Font.BOLD, Color.BLACK);
		Font headerRowTaxFont = FontFactory.getFont("Ariel", 8, Color.BLACK);
		Font addressDataRowFont = FontFactory.getFont("Ariel", 8, Color.BLACK);
		int headerRowHeight = 30;

		PdfPCell skCell = new PdfPCell(new Phrase("Skills Observed/ Parameters Measured", headerRowFont1));
		skCell.setFixedHeight(headerRowHeight);
		skCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell descCell = new PdfPCell(new Phrase("Description", headerRowFont1));
		descCell.setFixedHeight(headerRowHeight);
		descCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell t1Cell = new PdfPCell(new Phrase("TERM 1", headerRowFont1));
		t1Cell.setFixedHeight(headerRowHeight);
		t1Cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell t2Cell = new PdfPCell(new Phrase("TERM 2", headerRowFont1));
		t2Cell.setFixedHeight(headerRowHeight);
		t2Cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(skCell);
		outerTable.addCell(descCell);
		outerTable.addCell(t1Cell);
		outerTable.addCell(t2Cell);

		// 1.
		// ------------------------------------------------------------------------------------------

		PdfPCell bCell = new PdfPCell(new Phrase("Basics", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell descVCell = new PdfPCell(new Phrase("Flexibility, Stamina, Strenght, Stances", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell t1VCell = new PdfPCell(new Phrase(eurobean.getS1(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell t2VCell = null;
		if(eurobean.getS1().equals("A")){
		 t2VCell = new PdfPCell(new Phrase("A", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}else if(eurobean.getS1().equals("B")) {
			 t2VCell = new PdfPCell(new Phrase("A", headerRowFont));
			t2VCell.setFixedHeight(headerRowHeight);
			t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}
		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// 2.
		// ------------------------------------------------------------------------------------------

		bCell = new PdfPCell(new Phrase("Punches & Blocks", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		descVCell = new PdfPCell(new Phrase("Accuracy & Perfection", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t1VCell = new PdfPCell(new Phrase(eurobean.getS2(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t2VCell = new PdfPCell(new Phrase("NA", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// 3.
		// ------------------------------------------------------------------------------------------

		bCell = new PdfPCell(new Phrase("Kicks", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		descVCell = new PdfPCell(new Phrase("Accuracy & Perfection", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t1VCell = new PdfPCell(new Phrase(eurobean.getS3(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t2VCell = new PdfPCell(new Phrase("NA", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// 4.
		// ------------------------------------------------------------------------------------------

		bCell = new PdfPCell(new Phrase("Poomsae", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		descVCell = new PdfPCell(new Phrase("Body-Mind Co-ordination & Rythm", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t1VCell = new PdfPCell(new Phrase(eurobean.getS4(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t2VCell = new PdfPCell(new Phrase("NA", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// 5.
		// ------------------------------------------------------------------------------------------

		bCell = new PdfPCell(new Phrase("Sparring(Kyorugi)", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		descVCell = new PdfPCell(new Phrase("Fighting Skills", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t1VCell = new PdfPCell(new Phrase(eurobean.getS5(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t2VCell = new PdfPCell(new Phrase("NA", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// 6.
		// ------------------------------------------------------------------------------------------

		bCell = new PdfPCell(new Phrase("Breaking(Kyuk-pah)", headerRowFont));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		descVCell = new PdfPCell(new Phrase("Strenght Skills", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t1VCell = new PdfPCell(new Phrase(eurobean.getS6(), headerRowFont));
		t1VCell.setFixedHeight(headerRowHeight);
		t1VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		t2VCell = new PdfPCell(new Phrase("NA", headerRowFont));
		t2VCell.setFixedHeight(headerRowHeight);
		t2VCell.setHorizontalAlignment(Element.ALIGN_CENTER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);
		outerTable.addCell(t1VCell);
		outerTable.addCell(t2VCell);

		// ------------------- 1. After Table ---------------------------------

		PdfPCell Blank = new PdfPCell(new Phrase("", headerRowFont));
		Blank.setFixedHeight(headerRowHeight);
		Blank.setColspan(4);
		Blank.setBorder(Rectangle.NO_BORDER);

		bCell = new PdfPCell(new Phrase("Strenght :", headerRowFont1));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		bCell.setColspan(1);
		bCell.setBorder(Rectangle.NO_BORDER);

		descVCell = new PdfPCell(new Phrase(eurobean.getS7(), headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		descVCell.setColspan(3);
		descVCell.setBorder(Rectangle.NO_BORDER);

		outerTable.addCell(Blank);
		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);

		// ------------------- 2. After Table ---------------------------------

		bCell = new PdfPCell(new Phrase("Area of Improvement :", headerRowFont1));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		bCell.setColspan(1);
		bCell.setBorder(Rectangle.NO_BORDER);

		descVCell = new PdfPCell(new Phrase(eurobean.getS8(), headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		descVCell.setColspan(3);
		descVCell.setBorder(Rectangle.NO_BORDER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);

		// ------------------- 3. After Table ---------------------------------

		bCell = new PdfPCell(new Phrase("Sign of Coach/Instructor :", headerRowFont1));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		bCell.setColspan(1);
		bCell.setBorder(Rectangle.NO_BORDER);

		descVCell = new PdfPCell(new Phrase("Mr. Shiva Swami.", headerRowFont));
		descVCell.setFixedHeight(headerRowHeight);
		descVCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		descVCell.setColspan(3);
		descVCell.setBorder(Rectangle.NO_BORDER);

		outerTable.addCell(bCell);
		outerTable.addCell(descVCell);

		// ------------------- 4. After Table ---------------------------------

		bCell = new PdfPCell(new Phrase("Rubrics :", headerRowFont1));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		bCell.setColspan(4);
		bCell.setBorder(Rectangle.NO_BORDER);

		outerTable.addCell(Blank);
		outerTable.addCell(bCell);

		// ------------------- 5. After Table ---------------------------------

		bCell = new PdfPCell(new Phrase("Excellent-A+           Very Good-A          Good-B             Average-C           Need Improvement-D           Not Taken-NT", headerRowFont1));
		bCell.setFixedHeight(headerRowHeight);
		bCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		bCell.setColspan(4);
		bCell.setBorder(Rectangle.NO_BORDER);

		outerTable.addCell(bCell);

	}

	private static void buildNestedTablesName(PdfPTable outerTable, ArrayList<euroDataBean> bean, euroDataBean eurobean, String classValue) {
		// TODO Auto-generated method stub
		outerTable.setSpacingBefore(90);
		Font headerRowFont = FontFactory.getFont("Ariel", 10, Color.BLACK);
		Font headerRowFont1 = FontFactory.getFont("Ariel", 10, Font.BOLD, Color.BLACK);
		Font headerRowTaxFont = FontFactory.getFont("Ariel", 8, Color.BLACK);
		Font addressDataRowFont = FontFactory.getFont("Ariel", 8, Color.BLACK);

		int headerRowHeight = 30;

		PdfPCell nameCell = new PdfPCell(new Phrase("NAME : ", headerRowFont));
		nameCell.setFixedHeight(headerRowHeight);

		PdfPCell nameValueCell = new PdfPCell(new Phrase(eurobean.getSname().toUpperCase(), headerRowFont));
		nameValueCell.setFixedHeight(headerRowHeight);

		PdfPCell spaceCell = new PdfPCell(new Phrase("", headerRowFont));
		spaceCell.setFixedHeight(headerRowHeight);

		PdfPCell classCell = new PdfPCell(new Phrase("CLASS : ", headerRowFont));
		classCell.setFixedHeight(headerRowHeight);

		PdfPCell classValueCell = new PdfPCell(new Phrase(classValue,headerRowFont ));
		classValueCell.setFixedHeight(headerRowHeight);

		PdfPCell sectionCell = new PdfPCell(new Phrase("SECTION : ", headerRowFont));
		sectionCell.setFixedHeight(headerRowHeight);

		PdfPCell sectionValueCell = new PdfPCell(new Phrase(eurobean.getSSection(), headerRowFont));
		sectionValueCell.setFixedHeight(headerRowHeight);

		int summaryRowHeight1 = 35;
		PdfPCell HCell = new PdfPCell(new Phrase("ASPIRE(EXPLORE) - TAEKWONDO ", headerRowFont1));
		HCell.setFixedHeight(summaryRowHeight1);
		HCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		HCell.setColspan(7);

		nameCell.setBorder(0);
		nameValueCell.setBorder(0);
		spaceCell.setBorder(0);
		classCell.setBorder(0);
		classValueCell.setBorder(0);
		sectionCell.setBorder(0);
		sectionValueCell.setBorder(0);
		HCell.setBorder(0);

		outerTable.addCell(nameCell);
		outerTable.addCell(nameValueCell);
		outerTable.addCell(spaceCell);
		outerTable.addCell(classCell);
		outerTable.addCell(classValueCell);
		outerTable.addCell(sectionCell);
		outerTable.addCell(sectionValueCell);
		outerTable.addCell(HCell);

	}

	private static void buildNestedAddressAndLogoTables(PdfPTable outerTable, ArrayList<euroDataBean> bean, euroDataBean eurobean) {
		// TODO Auto-generated method stub

		try {

			Font headingRowFont = FontFactory.getFont("Ariel", 12, Color.BLACK);
			Font headingSubRowFont = FontFactory.getFont("Ariel", 10, Color.BLACK);
			Font addressDataRowFont = FontFactory.getFont("Ariel", 8, Color.BLACK);
			Font rhsRowFont = FontFactory.getFont("Ariel", 8, Color.BLACK);

			PdfPTable AddressAndLogo = new PdfPTable(1);
			PdfPTable rhsTable = new PdfPTable(1);

			Image logoImage = Image.getInstance("EuroLogo.jpeg");
			logoImage.setWidthPercentage(35);
			PdfPCell logoCell = new PdfPCell();
			logoCell.addElement(logoImage);
			logoCell.setFixedHeight(40);
			logoCell.setBorder(Rectangle.BOX);

			PdfPCell addressHeaderCell = new PdfPCell(new Phrase("BILLING ADDRESS", addressDataRowFont));
			addressHeaderCell.setFixedHeight(15);
			addressHeaderCell.setBorder(Rectangle.NO_BORDER);

			PdfPCell customerNameCell = new PdfPCell(new Phrase(eurobean.getSname(), addressDataRowFont));
			customerNameCell.setFixedHeight(13);
			customerNameCell.setBorder(Rectangle.NO_BORDER);

			Paragraph addressPara = new Paragraph();
			addressPara.add(new Phrase("cndndataBean.getAdd1()", addressDataRowFont));
			addressPara.add(new Phrase("+cndndataBean.getAdd3()", addressDataRowFont));
			addressPara.add(new Phrase("cndndataBean.getAdd4()", addressDataRowFont));
			PdfPCell addressCell = new PdfPCell(addressPara);
			addressCell.setFixedHeight(80);
			addressCell.setBorder(Rectangle.NO_BORDER);

			PdfPCell outerTableAddressCell = new PdfPCell(AddressAndLogo);
			outerTableAddressCell.setBorder(Rectangle.NO_BORDER);

			outerTable.addCell(outerTableAddressCell);

			Image logoImage1 = Image.getInstance("EuroLogo.jpeg");
			logoImage1.setWidthPercentage(55);
			logoImage1.setAlignment(26);
			PdfPCell logoCell1 = new PdfPCell();
			logoCell1.addElement(logoImage1);
			logoCell1.setFixedHeight(60);
			logoCell1.setBorder(Rectangle.NO_BORDER);

			rhsTable.addCell(logoCell1);

			PdfPCell outerTableCell = new PdfPCell(rhsTable);
			outerTableCell.setBorder(Rectangle.NO_BORDER);
			outerTable.addCell(outerTableCell);

		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ByteArrayOutputStream createPdf(ArrayList bean, euroDataBean eurobean, String pdfName, String classValue, String folderDest) {

		try {
			// Create Document instance.
			Document document = new Document(PageSize.A4);
			String dest = null;
			// Create OutputStream instance.
			//final String dest = "E:\\TestFile1234.pdf";
			//dest ="E:\\sheet\\GoodStudent\\"+pdfName;
			
			if(eurobean.getSSection().equals("A")){
				 dest ="E:\\sheetT2\\"+folderDest+"\\A\\"+(pdfName.toUpperCase());
				 System.out.println("name of pdf :::: "+ pdfName.toUpperCase());
			}
			else if(eurobean.getSSection().equals("B")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\B\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("C")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\C\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("D")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\D\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("E")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\E\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("F")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\F\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("G")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\G\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("H")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\H\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("I")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\I\\"+(pdfName.toUpperCase());

			}else if(eurobean.getSSection().equals("J")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\J\\"+(pdfName.toUpperCase());


			}else if(eurobean.getSSection().equals("CAIE")) {
				dest ="E:\\sheetT2\\"+folderDest+"\\CAIE\\"+(pdfName.toUpperCase());//CAIE
			}
			// Create PDFWriter instance.
			PdfWriter.getInstance(document, new FileOutputStream(dest));
			// PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			float[] columnWidths = { 300, 250 };
			PdfPTable table = new PdfPTable(columnWidths);
			table.setTotalWidth(550F);
			table.setLockedWidth(true);

			buildNestedAddressAndLogoTables(table,bean,eurobean);
			table.setSpacingAfter(10);
			document.add(table);

			float[] columnWidthsForName = { 22, 110, 10, 25, 20, 31, 20 };
			table = new PdfPTable(columnWidthsForName);
			table.setTotalWidth(420F);
			table.setLockedWidth(true);
			buildNestedTablesName(table,bean,eurobean,classValue);
			document.add(table);

			float[] columnWidthsForMarks = { 150, 150, 100, 100 };
			table = new PdfPTable(columnWidthsForMarks);
			table.setTotalWidth(550F);
			table.setLockedWidth(true);
			buildNestedTablesMarks(table,eurobean);
			document.add(table);

			/*document.add(new Paragraph(
					"-------------------------------------------------------------------------------------------------------------------------"));
*/
			document.close();

			System.out.println("Pdf created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
