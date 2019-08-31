package com.jieandata.service.builder;

import com.jieandata.service.annotation.ReportField;
import com.jieandata.service.model.option.OptionVO;
import com.jieandata.service.model.report.ReportVO;
import com.jieandata.utils.common.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: pengke
 * @Date: 2019-8-2 16:54
 * @Description:
 */
public class ReportBuilder {
    private int colSize = 3;

    private Object objectVO;

    public ReportBuilder(Object objectVO){
        this.objectVO = objectVO;
    }
    public ReportBuilder colSize(int colSize){
        this.colSize = colSize;
        return this;
    }
    public List<ReportVO> buildList() {
        List<ReportVO> reportList = new ArrayList<>();
        try {
            Object clone = ObjectUtils.deepClone(objectVO);

            Field[] fields = ObjectUtils.getAllFields(clone);
            String lable;
            String fieldValue;
            int itemNum = 0;
            ReportVO tempReportVO = null;
            List<OptionVO> items = null;
            OptionVO tempOptionVO = null;
            for (int i = 0; i < fields.length; i++) {
                ReportField annotation = fields[i].getAnnotation(ReportField.class);
                lable = annotation.value();
                fields[i].setAccessible(true);
                fieldValue = (String)fields[i].get(clone);
                if(StringUtils.isBlank(lable)){
                    continue;
                }

                itemNum ++;

                if(tempReportVO == null){
                    tempReportVO = new ReportVO();
                    items = new ArrayList<>();
                }

                if(itemNum % colSize == 1){
                    tempReportVO.setRowNum(itemNum/colSize + 1);
                }

                tempOptionVO = new OptionVO(fieldValue, lable);
                items.add(tempOptionVO);

                if(itemNum % colSize == 0 || i == fields.length - 1){
                    tempReportVO.setItems(items);
                    reportList.add(tempReportVO);
                    tempReportVO = null;
                    items = null;
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return reportList;
    }
}
