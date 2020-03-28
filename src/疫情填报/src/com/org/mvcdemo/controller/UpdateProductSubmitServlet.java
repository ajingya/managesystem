package com.org.mvcdemo.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.org.mvcdemo.dao.IProductDAO;
import com.org.mvcdemo.factory.DAOFactory;
import com.org.mvcdemo.vo.Product;

/**
 * Servlet implementation class UpdateProductSubmitServlet
 */
@WebServlet("/UpdateProductSubmitServlet")
@MultipartConfig
public class UpdateProductSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String pid = request.getParameter("pid");
		
		String name = request.getParameter("name");
		String note = request.getParameter("note");
		String touch = request.getParameter("touch");
		String infect = request.getParameter("infect");
		String fanxiao = request.getParameter("fanxiao");
		String symptom= request.getParameter("symptom");
		
//		String pic = request.getParameter("pic");
//	//��ȡ����·��
//		String path = getServletContext().getRealPath("/pic");		
//       //��ȡ�ϴ����ļ�
//        Part part = request.getPart("newpic");
//       
//        String newpic = null;
//        if(part.getSize() != 0) {
//        	String filename = part.getSubmittedFileName();
//        	String str[] = filename.split("\\.");
//        	String suffix = str[str.length-1];
//        	UUID uuid = UUID.randomUUID();
//        	newpic = uuid.toString()+"."+suffix;
//        	String filePath = path + "\\" + newpic;
//            //д���ļ�
//            part.write(filePath);
//        }
        
        Product p = new Product();
        p.setPid(Integer.parseInt(pid));
       
        p.setName(name);
        p.setNote(note);
        p.setFanxiao(fanxiao);
        p.setInfect(infect);
        p.setSymptom(symptom);
        p.setTouch(touch);
        //��������ϴ���ͼƬ����ʹ���µģ�����ʹ��ԭ����
//        if(newpic != null)
//        	p.setPic(newpic);
//        else
//        	p.setPic(pic);
        
        try {
        	IProductDAO proxy = DAOFactory.getIProductDAOInstance();
        	proxy.updateProduct(p);
        	request.getRequestDispatcher("SearchProductServlet").forward(request,response) ;
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
