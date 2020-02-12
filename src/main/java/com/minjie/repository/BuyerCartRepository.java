package com.minjie.repository;

import com.minjie.dataobject.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhengjie on 2020/2/12.
 */
public interface BuyerCartRepository extends JpaRepository<UserCart,String> {
  UserCart findByUserIdAndProductId(String userId,String productId);
}
