<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Recently added items(<c:choose>
  <c:when test="${empty itemSize }">0</c:when>
  <c:otherwise>${itemSize}</c:otherwise>
</c:choose>)</h3>

<div class="shopping_cart">
<c:set var="sum" value="0"></c:set>
	<!-- 判断有itemList的时候，再循环生成购物车项 -->
	<c:if test="${!empty itemList }">
		<c:forEach items="${itemList }" var="_item">
			<div class="cart_box">
			  <div class="message">
				<div class="alert-close"> </div> 
				<div class="list_img"><img src="images/${_item.pro.listPic.imgUrl }" class="img-responsive" alt=""/></div>
				<div class="list_desc"><h4><a href="#">${_item.pro.prTitle}</a></h4>${_item.count } x<span class="actual">
		                             ￥${_item.pro.prPrice}</span></div>
		        <div class="clearfix"></div>
	          </div>
	        </div>
	        <c:set var="sum" value="${sum + _item.pro.prPrice*_item.count }"/>
	     </c:forEach>   
	</c:if> 
	<!-- 总计 -->
    <div class="total">
    	<div class="total_left">CartSubtotal : </div>
    	<div class="total_right">￥${sum }</div>
    	<div class="clearfix"> </div>
    </div>
    <!-- 操作按钮 -->
    <div class="login_buttons">
     <c:choose>
       <c:when test="${empty LOGIN_USER }">
        <div class="login_button"><a href="login.html">登录</a></div>
       </c:when>
       <c:otherwise>
        <div class="login_button"><a href="checkout.html">结算</a></div>
       </c:otherwise>
     </c:choose>
  
     <div class="clearfix"></div>
   </div>
</div>
    <div class="clearfix"></div>