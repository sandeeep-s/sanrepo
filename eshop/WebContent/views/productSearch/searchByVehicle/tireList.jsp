<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.original.equipment"/>
</h1>
<br />
<br />

<c:forEach items="${products}" var="product">
	${product.name}
	<br/>
</c:forEach>