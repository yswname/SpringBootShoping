<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:forEach items="${userList }" var="_user" varStatus="_index">
      ${_index.index+1 }: ${_user.urUserName }<br/>
   </c:forEach>
</body>
</html>