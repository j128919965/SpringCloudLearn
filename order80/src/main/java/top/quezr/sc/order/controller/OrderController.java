package top.quezr.sc.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.quezr.sc.entities.CommonResult;
import top.quezr.sc.entities.Payment;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/8 19:03
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    // private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public CommonResult create(Payment payment){
        log.info(String.valueOf(payment));
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }


    @GetMapping
    public CommonResult getPayment(Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment?id="+id,CommonResult.class);
    }
}
