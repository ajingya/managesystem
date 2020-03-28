<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.sql.Connection"%>
<%@page import="com.org.mvcdemo.dbc.DatabaseConnection"%>
<%@page import="com.org.mvcdemo.vo.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>

<% 
DatabaseConnection db=new DatabaseConnection();
  Connection conn=db.getConnection();
	Statement stmt=null;
	stmt=conn.createStatement();
	ResultSet rs=null;
	
	String sql="select * from product ";
	
	
	String pid=request.getParameter("pid");
	String name = request.getParameter("name");
	String note = request.getParameter("note");
	String touch = request.getParameter("touch");
	String infect = request.getParameter("infect");
	String fanxiao = request.getParameter("fanxiao");
	String symptom= request.getParameter("symptom");

	if (pid!= null && pid != "")
		sql = sql + " and pid='" + pid + "'";
	
	if (name != null && name != "")
		sql = sql + " and name='" + name + "'";
	if (note !=null && note != "")
		sql =sql + "and note='" + note + "'";
	if (touch!= null && touch != "")
		sql = sql + " and touch='" + touch + "'";
	
	if (infect != null && infect != "")
		sql = sql + " and infect='" + infect + "'";
	if (fanxiao!= null && fanxiao != "")
		sql = sql + " and fanxiao='" +fanxiao + "'";
	
	
	
	if (symptom != null && symptom != "")
		sql = sql + " and symptom='" + symptom + "'";
	

 	rs=stmt.executeQuery(sql);
 %>
 
 <center> 
 	<table id="main" algin="center" border="0" >
  		<h3>防控情况统计表</h3>
 		
	 			<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>学院</th>
									<th>是否接触湖北人员</th>
									<th>是否已被感染</th>
									<th>是否今日返校</th>
									<th>是否有疑似症状请说明</th>

	  	</tr>
	  	
		                <%
			 while(rs.next())
 			{
	 			 String x=rs.getString("pid");
 		%> 
		
		<tr>
			<td><%=x%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("note")%></td>
			<td><%=rs.getString("touch")%></td>
			<td><%=rs.getString("infect")%></td>
			<td><%=rs.getString("fanxiao")%></td>
			<td><%=rs.getString("symptom")%></td>
		
		</tr>
		<% 
 			}
		%> 
	</table>

  <th><a id="print">导出数据到excel</a></th></tr>
<%-- <a href="<c:url value="/DownLoadServlet" />">本地下载</a>导出数据到Excel</a> --%>
</center>
<script type="application/javascript" src="js/FileSaver.js" ></script>
	<script>
		var html = "<html><head><meta charset='utf-8' /></head><body>" + document.getElementById("main").outerHTML + "</body></html>";
		var blob = new Blob
			(
				[html], 
					{
						type: "application/vnd.ms-excel"
					}
			);
		var b = document.getElementById("print");
		b.href = URL.createObjectURL(blob);
		b.download = "学生疫情情况统计表.xls";
	</script>
	</center>
</body>
</html>
