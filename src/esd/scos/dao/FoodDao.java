package esd.scos.dao;

import java.util.ArrayList;
import esd.scos.bean.FoodBean;

public class FoodDao {
	
	// 获取食物列表
	public static ArrayList<FoodBean> getFoods() {
		ArrayList<FoodBean> arrayList = new ArrayList<FoodBean>();
		for (int i = 0; i < 1000; i++) {
			FoodBean foodBean = new FoodBean();
			foodBean.setId(i);
			foodBean.setNumber(i);
			foodBean.setName("红烧牛肉面"+i);
			foodBean.setPrice("100.0"+i);
			foodBean.setType(1);
			arrayList.add(foodBean);
		}
		return arrayList;
	}
	
	

}
