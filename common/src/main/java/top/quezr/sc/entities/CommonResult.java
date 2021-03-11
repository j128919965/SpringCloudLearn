package top.quezr.sc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author que
 * @version 1.0
 * @date 2021/3/6 11:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T       data;


    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
