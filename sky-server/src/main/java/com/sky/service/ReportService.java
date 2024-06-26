package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
    /**
     * 根据时间区间统计营业额
     */
    TurnoverReportVO getTurnover(LocalDate beginTime, LocalDate endTime);

    /**
     * 根据时间区间统计用户数量
     * @
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    /**
     * 根据时间区间统计订单数量
     */
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    /**
     * 查询指定时间区间内的销量排名top10
     */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
