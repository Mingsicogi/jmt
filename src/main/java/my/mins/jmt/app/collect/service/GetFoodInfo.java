package my.mins.jmt.app.collect.service;

import my.mins.jmt.app.collect.entity.Food;

public interface GetFoodInfo {

	Food getInfo(String fromUrl, String queryParam);
}
