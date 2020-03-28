package com.org.mvcdemo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.mvcdemo.common.Pager;
import com.org.mvcdemo.dao.IProductDAO;
import com.org.mvcdemo.factory.DAOFactory;
import com.org.mvcdemo.vo.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//��ȡ���ܴ��͹����Ĳ�ѯ������ҳ�룬����һ���ᴫ�͹�����
		//�����ڵ����߲˵��ġ���ѯ��Ʒ"ʱ����û�д��Ͳ�ѯ������ҳ��ģ����Ժ��������Ҫ�ж��Ƿ�����Щ����
		String search_name = request.getParameter("search_name");
		String currentPage = request.getParameter("currentPage");
		//�ж��Ƿ���յ�ҳ�룬���û�У���Ĭ������Ϊ��һҳ
		int iCurrentPage = currentPage==null?1:Integer.parseInt(currentPage);
		Pager pager = null;
		ArrayList<Product> productList = null;
		
		try {
			IProductDAO proxy = DAOFactory.getIProductDAOInstance();
			//���û�в�ѯ�����ύ���������ѯȫ�����������������ѯ
			if(search_name == null) {
				int count = proxy.getCount();
				pager = new Pager(iCurrentPage,count,5);//����pager�������õ�ǰҳ���ܼ�¼����ÿҳ��ʾ����
				productList = DAOFactory.getIProductDAOInstance().findProduct(pager.getStartResults(),pager.getPageSize());
			}else {
				int count = proxy.getCount(search_name);
				pager = new Pager(iCurrentPage,count,5);
				productList = DAOFactory.getIProductDAOInstance().findProduct(search_name,pager.getStartResults(),pager.getPageSize());
			}
			
			//��������������������õ������У�������jspҳ���У���֤jsp��ҳ����ˢ�º󣬲�ѯ������ֵһֱ�������ı���
			if(search_name != null) {
				request.setAttribute("search_name", search_name);
			}
			//��Pager����Ͳ�ѯ���Ľ�����õ������У�������jspҳ��
			request.setAttribute("pager", pager);
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("product.jsp").forward(request,response) ;
		}catch(Exception ex) {
			ex.printStackTrace();
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
