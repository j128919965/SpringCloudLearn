package top.quezr.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.quezr.sc.dao.PaymentDao;
import top.quezr.sc.entities.Payment;
import top.quezr.sc.service.PaymentService;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/6 11:55
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    PaymentServiceImpl(PaymentDao dao){
        paymentDao = dao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
