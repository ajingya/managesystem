package com.org.mvcdemo.dao.proxy ;
import java.sql.* ;

import com.org.mvcdemo.dao.IUserDAO;
import com.org.mvcdemo.dao.impl.UserDAOImpl;
import com.org.mvcdemo.dbc.DatabaseConnection;
import com.org.mvcdemo.vo.User;
public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc = null ;
	private IUserDAO dao = null ;
	public UserDAOProxy(){
		try{
			this.dbc = new DatabaseConnection() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		this.dao = new UserDAOImpl(dbc.getConnection()) ;
	}
	public boolean findLogin(User user) throws Exception{
		boolean flag = false ;
		try{
			flag = this.dao.findLogin(user) ;	// ������ʵ���⣬��ɲ���
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
} 