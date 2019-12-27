package my.mins.jmt.app.collect.service;

import my.mins.jmt.app.collect.entity.Food;
import my.mins.jmt.app.common.cd.FoodTypeCd;

public interface GetFoodInfo {

	Food getInfo(String location, FoodTypeCd foodTypeCd);
}
