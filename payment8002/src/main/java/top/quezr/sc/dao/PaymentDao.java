package top.quezr.sc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.quezr.sc.entities.Payment;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/6 11:24
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getById(@Param("id") Long id);
}
