# 第六次安卓作业JavaWeb服务器端
## 1.运行环境
	eclipse+tomcat8.0
## 2.实现过程
### a.登录过程
	请求方式：post
	请求URL：http://localhost:8080/SCOSServer/LoginValidator
			 安卓模拟器的话讲localhost换成10.0.2.2
			 真机就是开启服务器端的IP地址
	请求参数：userName:wangcong
			  password:123456
	响应结果：验证正确返回1，错误返回0
### b.更新食物信息
#### b.1 Json方式
	请求方式：get
	请求URL：http://localhost:8080/SCOSServer/FoodUpdateService
			 安卓模拟器的话讲localhost换成10.0.2.2
			 真机就是开启服务器端的IP地址
	请求参数：type:json  (json方式可以不传参数)
	响应结果：返回正常json数据
#### b.2 XML方式
	请求方式：get
	请求URL：http://localhost:8080/SCOSServer/FoodUpdateService
			 安卓模拟器的话讲localhost换成10.0.2.2
			 真机就是开启服务器端的IP地址
	请求参数：type:xml  (必须传递，不然返回的是json类型的数据)
	响应结果：返回正常XML数据
## 3.实现代码
### a.登录部分
```java
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// 获取输入的客户端参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (this.name.equals(userName) && this.pwd.equals(password)) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
```
### b.更新列表
```java
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// 取出要求返回类型
		String type = request.getParameter("type");
		
		// 返回格式是XML流
		if ("xml".equals(type)) {
			org.dom4j.Document document =  FoodUtil.getXmlData();
			System.out.println("-------"+document.asXML());
			response.setContentType("text/xml;charset=UTF-8");
	        response.getWriter().write(document.asXML());
		} else {	// 默认json格式
			// 将jsonArray对象作为一个json对象，用来返回给客户端
			JSONObject allFoodsJson = FoodUtil.getJsonData();
			response.getOutputStream().write(allFoodsJson.toString().getBytes("gbk"));
		}
```
### c.生成json部分代码
```java
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
```
d.生成xml部分代码
```java
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

```
