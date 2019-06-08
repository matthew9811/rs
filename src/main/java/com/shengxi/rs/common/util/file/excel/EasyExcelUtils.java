package com.shengxi.rs.common.util.file.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.shengxi.system.common.constant.Index;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * @author mtthew
 * @ClassName EasyExcelUtils
 * @Date 2019.06.08
 * @Description 封装的EasyExcel导出工具类
 * @Version 2.0
 */
public class EasyExcelUtils {

    /**
     * 日志打印
     */
    private static Logger logger = LoggerFactory.getLogger(EasyExcelUtils.class);

    /**
     * 生成单个sheet的excel文件
     *
     * @param response  响应
     * @param dataList  数据
     * @param sheetName sheet的名称
     * @param typeEnum  类型
     */
    public static void exportExcel(HttpServletResponse response, List<? extends BaseRowModel> dataList, String sheetName, ExcelTypeEnum typeEnum) {
        try {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + typeEnum.getValue());
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, typeEnum, true);
            Sheet sheet = new Sheet(1, 0, dataList.get(0).getClass());
            sheet.setSheetName(sheetName);
            writer.write(dataList, sheet);
            writer.finish();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            logger.info("excel打印成功!");
        }
    }

    /**
     * @param type ExcelTypeEnum 要导出的excel的类型 有ExcelTypeEnum.xls 和有ExcelTypeEnum.xlsx
     * @Description 导出excel 支持一张表导出多个sheet
     * @Param OutputStream 输出流
     * @Param Map<String                                                               ,                                                                                                                               List>  sheetName和每个sheet的数据
     * @Date 上午12:16 2019/06/07
     */
    public static void exportExcelMutilEasyExcel(HttpServletResponse response, Map<String, List<? extends BaseRowModel>> SheetNameAndDateList, ExcelTypeEnum type) throws UnsupportedEncodingException {
        if (checkParam(SheetNameAndDateList, type)) {
            return;
        }
        try {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + "default" + type.getValue());
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, type, true);
            setSheet(SheetNameAndDateList, writer);
            writer.finish();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * setSheet
     *
     * @param SheetNameAndDateList data
     * @param writer               输出
     */
    private static void setSheet(Map<String, List<? extends BaseRowModel>> SheetNameAndDateList, ExcelWriter writer) {
        int sheetNum = 1;
        for (Map.Entry<String, List<? extends BaseRowModel>> stringListEntry : SheetNameAndDateList.entrySet()) {
            Sheet sheet = new Sheet(sheetNum, 0, stringListEntry.getValue().get(0).getClass());
            sheet.setSheetName(stringListEntry.getKey());
            writer.write(stringListEntry.getValue(), sheet);
            sheetNum++;
        }
    }


    /**
     * 校验参数
     *
     * @param SheetNameAndDateList data
     * @param type                 类型
     * @return 校验结果
     */
    private static boolean checkParam(Map<String, List<? extends BaseRowModel>> SheetNameAndDateList, ExcelTypeEnum type) {
        if (CollectionUtils.isEmpty(SheetNameAndDateList)) {
            logger.error("SheetNameAndDateList不能为空");
            return true;
        } else if (type == null) {
            logger.error("导出的excel类型不能为空");
            return true;
        }
        return false;
    }
}
