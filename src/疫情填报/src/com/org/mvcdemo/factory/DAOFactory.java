package com.org.mvcdemo.factory ;

import com.org.mvcdemo.dao.IProductDAO;
import com.org.mvcdemo.dao.IUserDAO;
import com.org.mvcdemo.dao.proxy.ProductDAOProxy;
import com.org.mvcdemo.dao.proxy.UserDAOProxy;
public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy() ;
	}
	
	public static IProductDAO getIProductDAOInstance(){
		return new ProductDAOProxy() ;
	}
}