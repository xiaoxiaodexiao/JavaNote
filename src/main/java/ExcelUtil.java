//
//import com.google.common.collect.Maps;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//    /**
//     * @author CHY
//     * @data 2019/6/19 22:30
//     * Excel操作的工具类
//     */
//    public class ExcelUtil {
//        public static final String OFFICE_EXCEL_XLS = "xls";
//        public static final String OFFICE_EXCEL_XLSX = "xlsx";
//
//        /**
//         * 读取Excel文件的内容
//         * @param filePath 文件全路径
//         * @param sheetNo sheet序号,从0开始。如果读取全部Sheet页内容则把sheetNo设置null，否则只读取指定Sheet页内容
//         * @return
//         * @throws IOException
//         * @throws InvalidFormatException
//         */
//        public static String readExcel(String filePath,Integer sheetNo) throws IOException, InvalidFormatException {
//
//            StringBuilder sb = new StringBuilder();
//            Workbook workbook = getWorkbook(filePath);
//
//            if (workbook != null){
//                if (sheetNo == null){
//                    int numberOfSheets = workbook.getNumberOfSheets();
//                    for (int i = 0; i <numberOfSheets ; i++) {
//                        Sheet sheet = workbook.getSheetAt(i);
//                        if (sheet == null){
//                            continue;
//                        }
//                        sb.append(readExcelSheet(sheet));
//                    }
//                } else {
//                    Sheet sheet = workbook.getSheetAt(sheetNo);
//                    if (sheet != null){
//                        sb.append(readExcelSheet(sheet));
//                    }
//                }
//
//            }
//
//            return sb.toString();
//        }
//
//        /**
//         * 根据文件路径获取Workbook对象
//         * @param filePath 文件全路径
//         * @return
//         */
//        private static Workbook getWorkbook(String filePath) throws IOException, InvalidFormatException {
//
//            InputStream is = null;
//            Workbook wb = null;
//
//            if(StringUtils.isBlank(filePath)){
//                throw new IllegalArgumentException("文件路径不能玩为空");
//            } else {
//                //获取文件后缀名
//                String suffiex = getSuffiex(filePath);
//                if (StringUtils.isBlank(suffiex)){
//                    throw new IllegalArgumentException("文件后缀不能为空");
//                }
//                if (OFFICE_EXCEL_XLS.equals(suffiex) || OFFICE_EXCEL_XLSX.equals(suffiex)){
//                    try {
//                        is = new FileInputStream(filePath);
//                        wb = WorkbookFactory.create(is);
//                    }finally {
//                        if (is != null){
//                            is.close();
//                        }
//                        if (wb != null){
//                            wb.close();
//                        }
//                    }
//                } else {
//                    throw  new IllegalArgumentException("该文件不是EXCEL文件");
//                }
//            }
//
//            return wb;
//        }
//
//        /**
//         * 获取文件后缀名
//         * @param filePath 文件全路径
//         * @return
//         */
//        private static String getSuffiex(String filePath) {
//            //返回指定字符串最后一次出现的索引位置，不存在的话默认返回-1
//            int index = filePath.lastIndexOf(".");
//            //文件后缀名不存在的情况下
//            if (index == -1){
//                return "";
//            }
//            //文件后缀名存在
//            return filePath.substring(index+1,filePath.length());
//        }
//
//        /**
//         *读取Sheet里面的内容，遍历输出
//         * @param sheet
//         * @return
//         */
//        private static String readExcelSheet(Sheet sheet) {
//            StringBuilder sb = new StringBuilder();
//
//            if (sheet != null){
//                //得到EXCEL的总记录条数
//                int rowNums = sheet.getLastRowNum();
//                //遍历行
//                for (int i = 0; i <rowNums ; i++) {
//                    Row row = sheet.getRow(i);
//                    if (row != null){
//                        //总列数
//                        int columNums = row.getLastCellNum();
//                        for (int j = 0; j <columNums ; j++) {
//                            Cell cell = row.getCell(j);
//                            if (cell != null){
//                                cell.setCellType(CellType.STRING);
//                                sb.append(cell.getStringCellValue() + " ");
//                            }
//                        }
//                    }
//                }
//            }
//            return sb.toString();
//        }
//
//        /**
//         * 创建Excel文件
//         * @param filePath 文件全路径
//         * @param sheetName 指定创建的sheet页名字，选填
//         * @param titles 表头
//         * @param values 每行的单元格
//         * @return
//         */
//        public static boolean writeExcel(String filePath, String sheetName, List<String> titles, List<Map<String,Object>> values) throws IOException {
//
//            boolean success = false;
//            OutputStream outputStream = null;
//
//            if (StringUtils.isBlank(filePath)){
//                throw new IllegalArgumentException("文件路径不能为空");
//            }else {
//
//                //文件后缀名
//                String suffiex = getSuffiex(filePath);
//                if (StringUtils.isBlank(suffiex)){
//                    throw new IllegalArgumentException("文件后缀名不能为空");
//                }
//
//                Workbook workbook;
//                if (OFFICE_EXCEL_XLS.equals(suffiex.toLowerCase())){
//                    workbook = new HSSFWorkbook();
//                }else {
//                    workbook = new XSSFWorkbook();
//                }
//
//                //生成一个sheet页名
//                Sheet sheet;
//                if (StringUtils.isBlank(sheetName)){
//                    //sheetName为空时默认创建sheet页名
//                    sheet = workbook.createSheet();
//                }else {
//                    //指定sheet页名
//                    sheet = workbook.createSheet(sheetName);
//                }
//
//                //设置表格默认列宽度为15个字节
//                sheet.setDefaultColumnWidth((short)15);
//                //生成样式
//                Map<String,CellStyle> styles = createStyles(workbook);
//                //创建标题行
//                Row row = sheet.createRow(0);
//
//                //存储标题在excel文件中的序号
//                Map<String,Integer> titleOrder = Maps.newHashMap();
//                for (int i = 0; i <titles.size() ; i++) {
//                    Cell cell = row.createCell(i);
//                    cell.setCellStyle(styles.get("header"));
//                    String title = titles.get(i);
//                    cell.setCellValue(title);
//                    titleOrder.put(title,i);
//                }
//
//                //写入正文
//                Iterator<Map<String,Object>> iterator = values.iterator();
//                //行号
//                int index = 1;
//                while (iterator.hasNext()){
//                    row = sheet.createRow(index);
//                    Map<String,Object> value = iterator.next();
//
//                    for (Map.Entry<String,Object> map : value.entrySet()){
//                        //获取列名
//                        String title = map.getKey();
//                        //根据列名获取序号
//                        int i = titleOrder.get(title);
//                        //在指定序号处创建cell
//                        Cell cell = row.createCell(i);
//                        //设置cell的样式
//                        if(index % 2 == 1){
//                            cell.setCellStyle(styles.get("cellA"));
//                        }else {
//                            cell.setCellStyle(styles.get("cellB"));
//                        }
//
//                        //获取列的值
//                        Object object = map.getValue();
//                        //判断Object的类型
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//                        if (object instanceof Double){
//                            cell.setCellValue((Double) object);
//                        }else if (object instanceof Date){
//                            String time = simpleDateFormat.format((Date) object);
//                            cell.setCellValue(time);
//                        }else if (object instanceof Calendar){
//                            Calendar calendar = (Calendar) object;
//                            String time = simpleDateFormat.format(calendar.getTime());
//                            cell.setCellValue(time);
//                        }else if (object instanceof Boolean){
//                            cell.setCellValue((Boolean) object);
//                        }else {
//                            if (object != null){
//                                cell.setCellValue(object.toString());
//                            }
//                        }
//                    }
//                    index++;
//                }
//
//                try {
//                    outputStream = new FileOutputStream(filePath);
//                    workbook.write(outputStream);
//                    success = true;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (outputStream != null){
//                        outputStream.close();
//                    }
//                    if (workbook != null){
//                        workbook.close();
//                    }
//                }
//                return success;
//            }
//        }
//
//        /**
//         * 设置格式
//         * @param wb
//         * @return
//         */
//        private static Map<String, CellStyle> createStyles(Workbook wb) {
//            Map<String, CellStyle> styles = Maps.newHashMap();
//
//            // 标题样式
//            XSSFCellStyle titleStyle = (XSSFCellStyle) wb.createCellStyle();
//            // 水平对齐
//            titleStyle.setAlignment(HorizontalAlignment.CENTER);
//            // 垂直对齐
//            titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//            // 样式锁定
//            titleStyle.setLocked(true);
//            titleStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
//            Font titleFont = wb.createFont();
//            titleFont.setFontHeightInPoints((short) 16);
//            titleFont.setBold(true);
//            titleFont.setFontName("微软雅黑");
//            titleStyle.setFont(titleFont);
//            styles.put("title", titleStyle);
//
//            // 文件头样式
//            XSSFCellStyle headerStyle = (XSSFCellStyle) wb.createCellStyle();
//            headerStyle.setAlignment(HorizontalAlignment.CENTER);
//            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//            // 前景色
//            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
//            // 颜色填充方式
//            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            headerStyle.setWrapText(true);
//            // 设置边界
//            headerStyle.setBorderRight(BorderStyle.THIN);
//            headerStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
//            headerStyle.setBorderLeft(BorderStyle.THIN);
//            headerStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//            headerStyle.setBorderTop(BorderStyle.THIN);
//            headerStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
//            headerStyle.setBorderBottom(BorderStyle.THIN);
//            headerStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//            Font headerFont = wb.createFont();
//            headerFont.setFontHeightInPoints((short) 12);
//            headerFont.setColor(IndexedColors.WHITE.getIndex());
//            titleFont.setFontName("微软雅黑");
//            headerStyle.setFont(headerFont);
//            styles.put("header", headerStyle);
//
//            Font cellStyleFont = wb.createFont();
//            cellStyleFont.setFontHeightInPoints((short) 12);
//            cellStyleFont.setColor(IndexedColors.BLUE_GREY.getIndex());
//            cellStyleFont.setFontName("微软雅黑");
//
//            // 正文样式A
//            XSSFCellStyle cellStyleA = (XSSFCellStyle) wb.createCellStyle();
//            // 居中设置
//            cellStyleA.setAlignment(HorizontalAlignment.CENTER);
//            cellStyleA.setVerticalAlignment(VerticalAlignment.CENTER);
//            cellStyleA.setWrapText(true);
//            cellStyleA.setBorderRight(BorderStyle.THIN);
//            cellStyleA.setRightBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleA.setBorderLeft(BorderStyle.THIN);
//            cellStyleA.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleA.setBorderTop(BorderStyle.THIN);
//            cellStyleA.setTopBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleA.setBorderBottom(BorderStyle.THIN);
//            cellStyleA.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleA.setFont(cellStyleFont);
//            styles.put("cellA", cellStyleA);
//
//            // 正文样式B:添加前景色为浅黄色
//            XSSFCellStyle cellStyleB = (XSSFCellStyle) wb.createCellStyle();
//            cellStyleB.setAlignment(HorizontalAlignment.CENTER);
//            cellStyleB.setVerticalAlignment(VerticalAlignment.CENTER);
//            cellStyleB.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
//            cellStyleB.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            cellStyleB.setWrapText(true);
//            cellStyleB.setBorderRight(BorderStyle.THIN);
//            cellStyleB.setRightBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleB.setBorderLeft(BorderStyle.THIN);
//            cellStyleB.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleB.setBorderTop(BorderStyle.THIN);
//            cellStyleB.setTopBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleB.setBorderBottom(BorderStyle.THIN);
//            cellStyleB.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//            cellStyleB.setFont(cellStyleFont);
//            styles.put("cellB", cellStyleB);
//
//            return styles;
//        }
//
//        public static void main(String args[]) throws IOException, InvalidFormatException {
//
//            // String excelData = readExcel("C:\\Users\\CHY\\Desktop\\千锋Java视频网盘链接-20190304.xlsx",null);
//            // System.out.println(excelData);
//
//            List<String> list = new ArrayList<String>();
//            list.add("1");
//            list.add("2");
//            list.add("3");
//            list.add("4");
//            list.add("5");
//            list.add("6");
//            list.add("8");
//
//            List<Map<String,Object>> list1 = new ArrayList<Map<String, Object>>();
//            Map<String,Object> map = new HashMap();
//            map.put("1",list);
//            map.put("2","200");
//            map.put("3",list);
//            map.put("4","200");
//            map.put("5",list);
//            map.put("6","200");
//
//            list1.add(map);
//            list1.add(map);
//            list1.add(map);
//            list1.add(map);
//            Boolean status = writeExcel("F:\\text.xlsx","TEST",list,list1);
//            System.out.println(status);
//        }
//    }
//
//
