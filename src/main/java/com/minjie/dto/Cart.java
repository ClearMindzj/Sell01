package com.minjie.dto;

import com.minjie.dataobject.ProductInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhengjie on 2020/2/11.
 */
@Data
public class Cart {
    private Map<String,CartDTO> map=new HashMap<>();
    private BigDecimal price;

    public void addItem(ProductInfo productInfo){


    }
}
