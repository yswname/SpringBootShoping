<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="sum" value="0"></c:set>
<c:forEach items="${itemList }" var="_item">
               <div class="shopCarItemDiv">
				   <div class="itemCk">
					   <input type="checkbox" name="proIds" value="${_item.pro.prId }"/>
				   </div>
				   <div class="itemImg">
					   <img src="images/${_item.pro.listPic.imgUrl }" width="40px" height="30px"/>
				   </div>
				   <div class="itemName">${_item.pro.prTitle }</div>
				   <div class="itemPrice">￥${_item.pro.prPrice }</div>
				   <div class="itemCount">
					   <div>-</div><div><input type="text" value="${_item.count }" style="width: 20px; border-width:0px ;"/></div><div>+</div>
				   </div>
				   <div class="itemSum" id="sum${_item.pro.prId }">
					   ￥${_item.pro.prPrice*_item.count }
				   </div>
				   <div class="itemOperate">
					   <a href="#">删除</a>
				   </div>
			   </div>
			   <br/><br/>
			   <c:set var="sum" value="${sum + _item.pro.prPrice*_item.count }"/>
</c:forEach>			   


			   <div class="shopCarItemDiv"></div>
			   <br/><br/><br />
			   <div class="shopCarItemDiv" style="text-align: right;" id="sumDiv">总计:￥0</div>
			   <br/><br/>