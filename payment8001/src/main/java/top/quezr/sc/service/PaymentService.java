package top.quezr.sc.service;

import top.quezr.sc.entities.Payment;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/6 11:55
 */
public interface PaymentService {

    int create(Payment payment);
    Payment getById(Long id);


}
