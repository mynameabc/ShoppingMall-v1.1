package com.mapper;

import com.MyMapper;
import com.entity.PayOrder;
import org.apache.ibatis.annotations.Param;

public interface PayOrderMapper extends MyMapper<PayOrder> {

    PayOrder getOrderForPlatformOrderNo(@Param("platformOrderNo") String platformOrderNo);

    PayOrder getOrderForClientOrderNo(@Param("clientOrderNo") String clientOrderNo);
}
