package com.coherentsolutions.domain;

import com.coherentsolutions.domain.categories.BikeCategory;
import com.coherentsolutions.domain.categories.MilkCategory;
import com.coherentsolutions.domain.categories.PhoneCategory;

import java.util.Objects;

public class CategoryFactory {
    public Category getCategory(CategoryEnum categoryEnum){
        if (Objects.equals(categoryEnum, CategoryEnum.BIKE)){
            return new BikeCategory();
        } else if (Objects.equals(categoryEnum, CategoryEnum.PHONE)) {
            return new PhoneCategory();
        } else if (Objects.equals(categoryEnum, CategoryEnum.MILK)){
            return new MilkCategory();
        }
        return null;
    }
}
