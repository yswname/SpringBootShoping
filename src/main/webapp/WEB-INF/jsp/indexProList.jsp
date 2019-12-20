<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
   function toAddShopCar(proId){
	   var _data = "prId=" + proId;
	   $.ajax({
		   type:'post',
		   url:'car/addShopCar.mvc',
		   data:_data,
		   success:function(msg){
			   $.ajax({
				   type:'post',
				   url:'car/showShopCarProductCount.mvc',
				   success:function(countMsg){
					   $("#shopCarCountDiv").html(countMsg);
				   }
			   });
			   alert(msg);
		   }
	   });
   }
</script>
<c:forEach items="${firstProList }" var="_pro" varStatus="index">
    <c:choose>
      <c:when test="${index.index == 0 }">
         <div class="grid1">
      </c:when>
      <c:otherwise>
         <div class="grid1 box4">
      </c:otherwise>
    </c:choose>
			  
			  <div style="float: right;position: relative; top: -30px; right: 30px;"><a href="#">更多...</a></div>
			    <h5>${_pro.prTitle }</h5>
   				  <div class="view view-first">
                     <img src="images/${_pro.listPic.imgUrl }" class="img-responsive" alt="${_pro.listPic.imgTitle }"/>
   				       <a href="single.html"><div class="mask">
   			            <h3>查看详细信息</h3>
                        <p>-----Or----</p>
                        <h4>加入购物车</h4>
                      </div></a>
                   </div> 
               <h6>￥${_pro.prPrice}</h6>
               <input class="shopCarBtn" type="button" value="加入购物车" title="" onclick="toAddShopCar(${_pro.prId})">
			  </div>
</c:forEach>   