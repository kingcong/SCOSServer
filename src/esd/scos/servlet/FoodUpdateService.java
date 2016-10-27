package esd.scos.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import esd.scos.bean.FoodBean;
import esd.scos.dao.FoodDao;
import esd.scos.util.FoodUtil;;

/**
 * Servlet implementation class FoodUpdateService
 */
@WebServlet("/FoodUpdateService")
public class FoodUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodUpdateService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
