package com.minjie.config.decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
