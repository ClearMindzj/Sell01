package com.minjie.controller;

import com.minjie.VO.ProductInfoVO;
import com.minjie.VO.ProductVO;
import com.minjie.dataobject.ProductCategory;
import com.minjie.dataobject.ProductInfo;
import com.minjie.enums.ProductStatusEnum;
import com.minjie.service.CategoryService;
import com.minjie.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Create by zj on 2018/7/6
 */

@RestController  //返回json格式用这个
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam("categoryType") Integer categoryType,
                             @RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "8") Integer size,
                             Map<String,Object> map){
        PageRequest request=new PageRequest(page-1,size);

        //1.查询所有上架商品
       Page<ProductInfo> productInfoList= productService.findAll(request);
        //2.查询类目(一次性查询)
   //    List<Integer> categoryTypeList=new ArrayList<>();
       //传统方法
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(JAVA 8,lambda)

        List<ProductCategory> productCategoryList= categoryService.findByCategoryType(categoryType);
        //3.数据拼装
        List<ProductInfoVO> productInfoVOList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())&&
                productInfo.getProductStatus().equals(ProductStatusEnum.Up.getCode())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    //productInfo属性值拷贝到后面一个
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

        }
        map.put("productInfoVOList",productInfoVOList);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("/login/Index",map);
    }
}
