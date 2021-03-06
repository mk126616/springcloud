package com.mk.controller;

import com.mk.entity.PaymentEntity;
import com.mk.entity.Result;

import com.mk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController
{
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String port;
    /**
     * 创建订单
     *
     * @param entity
     * @return
     */
    @PostMapping("/payment")
    public Result createPayment(PaymentEntity entity)
    {

        return service.createPayment(entity);
    }

    /**
     * 所有订单
     *
     * @return
     */
    @GetMapping("payments")
    public Result getAllPayment()
    {
        Result<List<PaymentEntity>> result = service.getAllPayment();
        result.setMessage(result.getMessage()+",端口为"+port);
        return result;
    }
}
