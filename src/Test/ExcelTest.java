package Test;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//import jxl.read.biff.File;

//import jxl.read.biff.File;

//import jxl.read.biff.File;

/**
 * Created by tuchang on 13/04/2017.
 */

public class ExcelTest {
    public static void main(String[] args)
    {
        Workbook readwb = null;
        try

        {

            //构建Workbook对象, 只读Workbook对象

            //直接从本地文件创建Workbook

            InputStream instream = new FileInputStream("/Users/tuchang/IdeaProjects/StuTest/RosterArchive/名册模板.xls");

            readwb = Workbook.getWorkbook(instream);



            //Sheet的下标是从0开始

            //获取第一张Sheet表

            Sheet readsheet = readwb.getSheet(0);

            //获取Sheet表中所包含的总列数

            int rsColumns = readsheet.getColumns();

            //获取Sheet表中所包含的总行数

            int rsRows = readsheet.getRows();

            //获取指定单元格的对象引用

            for (int i = 0; i < rsRows; i++)

            {

                for (int j = 0; j < rsColumns; j++)

                {

                    Cell cell = readsheet.getCell(j, i);

                    System.out.print(cell.getContents() + "-" +cell.getType());

                }

                System.out.println();

            }



            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
            String xlsName = "/Users/tuchang/IdeaProjects/StuTest/RosterArchive/名册模板1.xls";
            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(
                    xlsName), readwb);

            //读取第一张工作表
            jxl.write.WritableSheet ws = wwb.getSheet(0);

            //获得第一个单元格对象
            jxl.write.WritableCell wc = ws.getWritableCell(0, 0);

            //判断单元格的类型, 做出相应的转化

            if (wc.getType() == CellType.LABEL)
            {

                Label l = (Label) wc;
                String title;
                title = "课程编号" + "课程名称" + "任课老师";
                l.setString(title);

            }

            jxl.write.WritableCell idCell = ws.getWritableCell(0, 1);
            jxl.write.WritableCell nameCell = ws.getWritableCell(1, 1);

//            System.out.println("idCell:"+idCell.getContents()+" type:"+idCell.getType());
//            System.out.println("nameCell:"+nameCell.getContents()+" type:"+nameCell.getType());



            //写入Excel对象

            wwb.write();

            wwb.close();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            readwb.close();

        }
    }
}
