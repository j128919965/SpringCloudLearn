package top.quezr.sc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.quezr.sc.entities.CommonResult;
import top.quezr.sc.entities.Payment;
import top.quezr.sc.service.PaymentService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/6 12:00
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public CommonResult<Payment> getPaymentById(Long id){
        Payment payment = paymentService.getById(id);
        log.info("查询到的数据： {}",payment);
        return payment!=null?
                new CommonResult<>(200,"success",payment):
                new CommonResult<>(404,"no such element");
    }

    @PostMapping
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果为： {} , 端口号为：{}",result,serverPort);
        return result>0?new CommonResult(200,"success at serverPost"+serverPort,result):new CommonResult(444,"failed");
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***** element :{}",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+'\t'+instance.getUri());
        }
        return discoveryClient;
    }
}
