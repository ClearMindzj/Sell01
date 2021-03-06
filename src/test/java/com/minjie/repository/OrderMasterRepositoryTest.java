package com.minjie.repository;

import com.minjie.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Create by zj on 2019/7/31
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private  OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("郑杰");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("金牛湖");
        orderMaster.setUserId(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest request= new PageRequest(0,1);
        Page<OrderMaster> result=repository.findByUserId(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());
    }

}