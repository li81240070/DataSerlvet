package testfordemo;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;


public class TestMysqlConnection {
	//声明类
	public static PostCardClass cardClass=new PostCardClass();
	public static ArrayList<PostCardClass>data=new ArrayList<PostCardClass>();
	public static String myResult="查询数据库失败";
	public static String a,b,c;
	
	
	public static void main(String args[]) { 
		insertData();
		
	}
	

	/////////////////////////////////////////////////////////////////////////////////
	
	//查询网络数据库的相关类
	public static String getData(String myName,String myToken,int myType,int myState) {
		

		try{   
		    //加载MySql的驱动类   
		    Class.forName("com.mysql.jdbc.Driver");   
		    }catch(ClassNotFoundException e){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！"+e.toString());   
		    e.printStackTrace() ;   
		    }   
	 //第二部分内容
		 String url = "jdbc:mysql://localhost:3306/postcard" ;    
	     String username = "root" ;   
	     String password = "root" ;   
	     try{   
	    	 
	    	 //查找数据的相关操作
	    	 
	    Connection con = DriverManager.getConnection(url , username , password ) ;   
	     Statement stat=con.createStatement();
	     ResultSet rs=stat.executeQuery("select * from couponscard");
	     
	     		data=new ArrayList<PostCardClass>();
	   
	   
	    		 while(rs.next()){
	    			 
	    			 if (myName.equals(rs.getString("username"))&&myToken.equals(rs.getString("token"))&&myType==rs.getInt("type")&&myState==rs.getInt("state")) {
	    				 cardClass=new PostCardClass();
		    			 
		    			 cardClass.setCouponscontent(rs.getString("content"));
		    			 System.out.println(cardClass.getCouponscontent());
		    			 
		    			 cardClass.setCouponsendtime(rs.getString("endtime"));
		    			 System.out.println(cardClass.getCouponsendtime());
		    			 
		    			 cardClass.setCouponsid(rs.getString("couponsid"));
		    			 System.out.println(cardClass.getCouponsid());
		    			 
		    			 cardClass.setCouponsname(rs.getString("username"));
		    			 System.out.println(cardClass.getCouponsname());
		    			 
		    			 cardClass.setCouponsrules1(rs.getString("rules1"));
		    			 System.out.println(cardClass.getCouponsrules1());
		    			 
		    			 cardClass.setCouponsrules2(rs.getString("rules2"));
		    			 System.out.println(cardClass.getCouponsrules2());
		    			 
		    			 cardClass.setCouponssharestate(rs.getInt("sharestate"));
		    			 System.out.println(cardClass.getCouponssharestate());
		    			 
		    			 cardClass.setCouponsstarttime(rs.getString("starttime"));
		    			 System.out.println(cardClass.getCouponsstarttime());
		    			
		    			 
		    			 cardClass.setUsername(rs.getString("username"));
		    			 System.out.println(cardClass.getUsername());
		    			 
		    			 cardClass.setToken(rs.getString("token"));
		    			 System.out.println(cardClass.getToken());
		    			 
		    			 cardClass.setCouponstype(rs.getInt("type"));
		    			 System.out.println(cardClass.getCouponstype());
		    			 
		    			 cardClass.setCouponsstate(rs.getInt("state"));
		    			 System.out.println(cardClass.getCouponsstate());
		    			 
		    			 cardClass.setCouponslowprice(rs.getInt("lowprice"));
		    			 System.out.println(cardClass.getCouponslowprice());
		    			 
		    			 cardClass.setCouponsonlytype(rs.getString("onlytype"));
		    			 System.out.println(cardClass.getCouponsonlytype());
		    			 data.add(cardClass);
					}
	    			 
	    			 
	    			 
	    			
	    		 }
	    		 rs.close();
	    		 stat.close();
	    		 con.close();
	    		 
	    		 if (data.size()==0) {
					return "该用户暂无数据";
				}
	    		 
	    		 
	    		 c=null;
	    		  a=null;
	    		 b=null;
	    		 
	    		 for (int i = 0; i < data.size()  ; i++) {
	    			 a=new String();
					a="{\"couponsname\":\""+data.get(i).getCouponsname()+"\",\"couponsstarttime\":\""+data.get(i).getCouponsstarttime()+"\",\"couponsendtime\":\""+data.get(i).getCouponsendtime()+"\",\"couponscontent\":\""+data.get(i).getCouponscontent()+"\",\"couponsid\":\""+data.get(i).getCouponsid()+"\",\"Couponsrule\":[{\"couponsrule1\":\""+data.get(i).getCouponsrules1()+"\",\"couponsrules2\":\""+data.get(i).getCouponsrules2()+"\"}],\"couponslowprice\":\""+data.get(i).getCouponslowprice()+"\",\"couponstype\":\""+data.get(i).getCouponstype()+"\",\"couponssharestate\":\""+data.get(i).getCouponssharestate()+"\"}";
					b=a+","+b;
	    		 }  		 
	    		b=b.substring(0, b.length()-5);
	    		 c="{\"content\":["+b+"]}";
	    		 
	     }catch(SQLException se){   
	    System.out.println("数据库连接失败！"+se.toString());   
	    se.printStackTrace() ;   
	     } 
	     
	 
	    	return c;
		
	     
	 
	}
	
	
	/////////////////////////////////////////////////
	//创建表的方法
	public static void createTable(){
		try{   
		    //加载MySql的驱动类   
		    Class.forName("com.mysql.jdbc.Driver");   
		    }catch(ClassNotFoundException e){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！"+e.toString());   
		    e.printStackTrace() ;   
		    }   
		String url = "jdbc:mysql://localhost:3306/postcard" ;    
	     String username = "root" ;   
	     String password = "root" ;   
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "CREATE TABLE couponscard (couponsid int not null, name text not null, starttime text , endtime text,content text,username text,token text,type int,state int ,rules1 text, rules2 text,lowprice int,onlytype text,sharestate int,primary key (couponsid));";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////
	//向数据表中插入数据的方法
	public static void insertData(){
		try{   
		    //加载MySql的驱动类   
		    Class.forName("com.mysql.jdbc.Driver");   
		    }catch(ClassNotFoundException e){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！"+e.toString());   
		    e.printStackTrace() ;   
		    }   
		String url = "jdbc:mysql://localhost:3306/postcard" ;    
	     String username = "root" ;   
	     String password = "root" ;   
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "insert into  couponscard (couponsid,name, starttime, endtime,content,username,token,type,state,rules1, rules2,lowprice,onlytype,sharestate)values(6955531,\"高手优惠券\",\"2050.06.05\",\"2070.01.08\",\"￥100\",\"金三胖\",\"28141223\",1,0,\"1 全世界通用券\",\"2 满100000可用\",100000,\"毁灭地球\",1);";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
