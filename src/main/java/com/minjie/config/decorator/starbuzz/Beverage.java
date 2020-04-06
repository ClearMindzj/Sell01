package com.minjie.config.decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
