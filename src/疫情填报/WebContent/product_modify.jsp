<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><%@ page import="java.util.*,com.org.mvcdemo.vo.*,com.org.mvcdemo.common.Pager" %><html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"><script src="jquery/jquery-1.9.1.min.js"></script><script src="bootstrap/js/bootstrap.min.js"></script><title>疫情管理</title></head><body>		<div class="container-fluid"		style="padding-left: 0px; padding-right: 0px">		<!-- 顶部Logo定义开始 -->		<div class="row-fluid">			<jsp:include page="north.jsp" flush="true"/>		</div>		<!-- 顶部Logo定义结束 -->		<div class="row-fluid">			<!-- 左边导航条定义开始  -->			<jsp:include page="left.jsp" flush="true"/>			<!-- 左边导航条定义结束-->			<!-- 内容  -->			<div class="col-md-10" style="margin-top: 20">				<%					Product p = (Product)request.getAttribute("product");													%>				<div class="row-fluid">				<div class="col-md-6 column">				<form role="form" name="updateform" method="post" enctype="multipart/form-data" action="UpdateProductSubmitServlet">				<input type="hidden" name="pid" value="<%= p.getPid()%>"/>				<div class="form-group">					 <label for="exampleInput">学号</label><input type="text" class="form-control" id="pid" name="pid" />				</div>				<div class="form-group">					 <label for="exampleInput">姓名</label><input type="text" class="form-control" id="name" name="name" />				</div>				<div class="form-group">					 <label for="exampleInput">学院</label><input type="text" class="form-control" id="note" name="note"/>				</div>								<div class="form-group">					 <label for="exampleInput">是否接触湖北人员</label><input type="radio" class="input" id="touch" name="touch" value="是" checked="checked" />是					 <input type="radio" class="input" id="touch" name="touch"  value="否"/>否				</div>				<div class="form-group">					 <label for="exampleInput">是否已确定被感染</label><input type="radio" class="input" id="infect" name="infect" value="是" checked="checked"/>是					 <input type="radio" class="input" id="infect" name="infect" value="否" />否				</div>				<div class="form-group">					 <label for="exampleInput">是否今日返校</label><input type="radio" class="input" id="fanxiao" name="fanxiao" value="是" checked="checked"/>是					 <input type="radio" class="input" id="fanxiao" name="fanxiao" value="否"/>否				</div>				<div class="form-group">					 <label for="exampleInput">是否有疑似症状请说明</label><input type="text" class="form-control" id="symptom" name="symptom" />				</div>				<button type="submit" class="btn btn-default">确定修改</button>				</form>				</div>				</div>							</div>			<!-- 内容  -->		</div>	</div></body></html>