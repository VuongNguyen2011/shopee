package BUS;
 
import DTO.ChitietHoaDon;
import DTO.HoaDon;
import DTO.KhachHang;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class importData {
 
    public  final int COLUMN_INDEX_ID = 0;
    public  final int COLUMN_INDEX_HO = 1;
    public  final int COLUMN_INDEX_TEN = 2;
    public  final int COLUMN_INDEX_DIACHI = 3;
    public  final int COLUMN_INDEX_TOTAL = 4;
    private  CellStyle cellStyleFormatNumber = null;

    public importData() {
    }
 
//    public  void main(String[] args) throws IOException {
//        ArrayList<KhachHang> listKH = (ArrayList<KhachHang>) getKhachHangs();
//        String excelFilePath = "C:\\Users\\Nguyen\\Desktop\\dsKH.xlsx";
//        writeExcel(listKH, excelFilePath);
//        ArrayList<KhachHang> a = new ArrayList<>(); 
//        a = readExcel("C:\\Users\\Nguyen\\Desktop\\dsKH.xlsx");
//        for (KhachHang khachHang : a) {
//            System.out.println(khachHang.getTen());
//        }
//    }
 
    public void writeExcel(ArrayList<KhachHang> listKH, String excelFilePath) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
 
        SXSSFSheet sheet = workbook.createSheet("KhachHangs"); // Create sheet with sheet name
         
        sheet.trackAllColumnsForAutoSizing();
 
        int rowIndex = 0;
 
        writeHeader(sheet, rowIndex);
 
        rowIndex++;
        for (KhachHang book : listKH) {

            SXSSFRow row = sheet.createRow(rowIndex);

            writeKhachHang(book, row);
            rowIndex++;
        }
 
 
        int numberOfColumn = 4; 
        autosizeColumn(sheet, numberOfColumn);
 
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
 
    // Create dummy data
    private  ArrayList<KhachHang> getKhachHangs() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        KhachHang kh;
        for (int i = 1; i <= 5; i++) {
            kh = new KhachHang(i,"nguyen"+i,"ten"+i,"diahci");
            listKhachHang.add(kh);
        }
        return listKhachHang;
    }
 
    // Write header with format
    private  void writeHeader(SXSSFSheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
 
        // Create row
        SXSSFRow row = sheet.createRow(rowIndex);
 
        // Create cells
        SXSSFCell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");
 
        cell = row.createCell(COLUMN_INDEX_HO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ");
 
        cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên");
 
        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa Chỉ");
 
    }
    private  void writeHeaderHoaDon(SXSSFSheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
 
        // Create row
        SXSSFRow row = sheet.createRow(rowIndex);
 
        // Create cells
        SXSSFCell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID");
 
        cell = row.createCell(COLUMN_INDEX_HO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã Nv");
 
        cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày");
 
        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tổng tiền");
 
    }
 
    // Write data
    private  void writeKhachHang(KhachHang khachhang, SXSSFRow row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
     
            // Create CellStyle
            SXSSFWorkbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
 
        SXSSFCell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(khachhang.getId());
 
        cell = row.createCell(COLUMN_INDEX_HO);
        cell.setCellValue(khachhang.getHo());
 
        cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellValue(khachhang.getTen());
        cell.setCellStyle(cellStyleFormatNumber);
 
        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellValue(khachhang.getDiachi());
 
        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_TEN);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_DIACHI);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }
 
    // Create CellStyle for header
    private  CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
 
    // Write footer
    private  void writeFooter(SXSSFSheet sheet, int rowIndex) {
        // Create row
        SXSSFRow row = sheet.createRow(rowIndex);
        SXSSFCell cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
        cell.setCellFormula("SUM(E2:E6)");
    }
 
    // Auto resize column width
    private  void autosizeColumn(SXSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
 
    // Create output file
    private  void createOutputFile(SXSSFWorkbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
    
 /// khuc nay la khuc ghhi  file  ne ==========================================
    
    // Get Workbook
    private  Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    
    // Get cell value
    private  Object getCellValue(Cell cell) {
//        CellType cellType = cell.getCellTypeEnum();
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
    
    public  ArrayList<KhachHang> readExcel(String excelFilePath) throws IOException {
        ArrayList<KhachHang> listKhachHangs = new ArrayList<>();
        
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }
 
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
 
            // Read cells and set value for book object
            KhachHang kh = new KhachHang();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                case COLUMN_INDEX_ID:
                    kh.setId(new BigDecimal((double) cellValue).intValue());
                    break;
                case COLUMN_INDEX_HO:
                    kh.setHo((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_TEN:
                    kh.setTen((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_DIACHI:
                    kh.setDiachi((String) getCellValue(cell));
                    break;
                
                default:
                    break;
                }
 
            }
            listKhachHangs.add(kh);
        }
 
        workbook.close();
        inputStream.close();
 
        return listKhachHangs;
    }
 
    public void xuatPDF(ArrayList<KhachHang> list,String name) throws DocumentException{
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc,new FileOutputStream(name));
            doc.open();
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("ID");
            tbl.addCell("Last Name");
            tbl.addCell("First Name");
            tbl.addCell("Address");
            
            for (KhachHang kh : list) {
                tbl.addCell(""+kh.getId());
                tbl.addCell(kh.getHo());
                tbl.addCell(kh.getTen());
                tbl.addCell(kh.getDiachi());
            }
            doc.add(tbl);
            System.out.println("Thanh Cong");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(importData.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }
    public void xuatPDF_CT_HD(ArrayList<ChitietHoaDon> list,String name) throws DocumentException{
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc,new FileOutputStream(name));
            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            tbl.addCell("ID");
            tbl.addCell("Tên Sản Phẩm");
            tbl.addCell("Số Lượng");
            tbl.addCell("Đơn giá");
            tbl.addCell("Tổng tiền");
            
            for (ChitietHoaDon kh : list) {
                tbl.addCell(""+kh.getCtmaHD());
                tbl.addCell("ten");
                tbl.addCell("2");
                tbl.addCell("100");
                tbl.addCell("200");
            }
            doc.add(tbl);
            System.out.println("Thanh Cong");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(importData.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }
    
    private  void writeTK_DonHang(HoaDon hd, SXSSFRow row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
     
            // Create CellStyle
            SXSSFWorkbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
 
        SXSSFCell cell = row.createCell(0);
        cell.setCellValue(hd.getHoadonID());
 
        cell = row.createCell(1);
        cell.setCellValue(hd.getNhanvienID());
 
        cell = row.createCell(2);
        cell.setCellValue(hd.getNgaylap());
//        cell.setCellStyle(cellStyleFormatNumber);
 
        cell = row.createCell(3);
        cell.setCellValue(hd.getTongtien());
 
    }
    public void writeExcel_HoaDon(ArrayList<HoaDon> listKH, String excelFilePath) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
 
        SXSSFSheet sheet = workbook.createSheet("HoaDons"); // Create sheet with sheet name
         
        sheet.trackAllColumnsForAutoSizing();
 
        int rowIndex = 0;
 
        writeHeaderHoaDon(sheet, rowIndex);
 
        rowIndex++;
        for (HoaDon hd : listKH) {

            SXSSFRow row = sheet.createRow(rowIndex);

            writeTK_DonHang(hd, row);
            rowIndex++;
        }
 
 
        int numberOfColumn = 4; 
        autosizeColumn(sheet, numberOfColumn);
 
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
    
}
