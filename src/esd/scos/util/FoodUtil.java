package esd.scos.util;

import java.util.ArrayList;
import java.util.UUID;

import org.dom4j.*;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.xml.internal.txw2.Document;

import esd.scos.bean.FoodBean;
import esd.scos.dao.FoodDao;

public class FoodUtil {
	
	/**
	 * 获取json数据
	 * @return	json字符串
	 */
	public static JSONObject getJsonData() {
		try{
			//从数据库获取新闻数据
			ArrayList<FoodBean> foods = FoodDao.getFoods();

			//将list中的数据封装成一个jsonArray对象
			JSONArray jsonArray = new JSONArray();
			for (FoodBean foodBean : foods) {
				JSONObject foodJson = new JSONObject();
				foodJson.put("id", foodBean.getId());
				foodJson.put("number", foodBean.getNumber());
				foodJson.put("name", foodBean.getName());
				foodJson.put("price", foodBean.getPrice());
				foodJson.put("type", foodBean.getType());
				jsonArray.put(foodJson);
			}

			//将jsonArray对象作为一个json对象，用来返回给客户端
			JSONObject allFoodsJson = new JSONObject();
			allFoodsJson.put("foods", jsonArray);
			return allFoodsJson;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取XML数据
	 * @return	xml数据流
	 */
	public static org.dom4j.Document getXmlData() {
		//从数据库获取新闻数据
		ArrayList<FoodBean> foods = FoodDao.getFoods();
		
		org.dom4j.Document document = DocumentHelper.createDocument();
		Element rootElem = document.addElement("Foods");
		
		//添加food标签
		for (int i = 0; i < foods.size(); i++) {
			FoodBean foodBean = foods.get(i);
			Element foodElem = rootElem.addElement("food");		
//			foodElem.addAttribute("id", foodBean.getId()+"");
			foodElem.addElement("id").setText(foodBean.getId()+"");
			foodElem.addElement("name").setText(foodBean.getName());
			foodElem.addElement("number").setText(foodBean.getNumber()+"");
			foodElem.addElement("price").setText(foodBean.getPrice());
			foodElem.addElement("type").setText(foodBean.getType()+"");
		}
		System.out.println("+++++++"+document.asXML());
		return document;
	}

}
