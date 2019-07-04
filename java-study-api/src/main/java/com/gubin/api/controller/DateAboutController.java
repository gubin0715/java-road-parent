package com.gubin.api.controller;

import com.gubin.common.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@Api(value = "DateAboutController", description = "日期接口")
public class DateAboutController {

    @ApiOperation(value = "日期相关转换及计算")
    @RequestMapping(value = "/dateabout", method = RequestMethod.POST)
    public ResponseDto dateabout() {
        try {
            /**
             * 格式化时间为（年-月-日 时：分：秒）
             */
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = simpleDateFormat.format(new Date());
            System.out.println("格式化时间为======" + dateTime);
            /**
             * 格式化时间之后转Date类行
             */
            System.out.println("格式化后转Date类型======" + simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            /**
             * 比较时间
             */
            String date = "2018-11-14 00:00:00";
            if (simpleDateFormat.parse(date).getTime() > simpleDateFormat.parse(simpleDateFormat.format(new Date())).getTime()) {
                System.out.println("2018-11-14 00:00:00是否大于当前时间======true");
            } else {
                System.out.println("2018-11-14 00:00:00是否大于当前时间======false");
            }
            /**
             * 计算两个时间相差的天数
             */
            SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = ymd.parse("2018-11-10");
            Date endDate = ymd.parse("2018-11-14");
            Calendar beginCalendar = Calendar.getInstance();
            beginCalendar.setTime(beginDate);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endDate);
            long beginTime = beginCalendar.getTime().getTime();
            long endTime = endCalendar.getTime().getTime();
            int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));//先算出两时间的毫秒数之差大于一天的天数
            endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
            endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
            if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
            {
                System.out.println("2018-11-10与2018-11-14相差天数======" + (betweenDays + 2));    //相等说明确实跨天了
            } else {
                System.out.println("2018-11-10与2018-11-14相差天数======" + (betweenDays + 1));    //不相等说明确实未跨天
            }
            /**
             * 推算时间
             */
            Calendar calendar = new GregorianCalendar();
            Date datebegin = new Date();
            calendar.setTime(ymd.parse(ymd.format(datebegin)));
            calendar.add(calendar.DATE, -1);//把日期往前推一天.整数往后推,负数往前移动
            System.out.println("日期往前推一天======" + ymd.format(calendar.getTime()));
            Date dateafter = new Date();
            calendar.setTime(ymd.parse(ymd.format(dateafter)));
            calendar.add(calendar.DATE, 1);//把日期往后推一天.整数往后推,负数往前移动
            System.out.println("日期往前后一天======" + ymd.format(calendar.getTime()));
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseDto.ERROR();
        }
        return ResponseDto.SUCCESS();
    }
}
