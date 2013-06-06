<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="product.deleted" />
</h1>

<label><s:message code="category" /> : </label> 
<c:forEach items="${product.categorizedProducts}" var="categorizedProduct">
	${categorizedProduct.category.name},
</c:forEach>
<br />
<br />
<label><s:message code="brand" /> : </label> ${product.brand.name}
<br />
<br />
<label><s:message code="pattern" /> : </label> ${product.productSpec.pattern.name}
<br />
<br />
<label><s:message code="product.name" /> : </label> ${product.name}
<br />
<br />
<label><s:message code="product.description" /> : </label> ${product.description}
<br />
<br />
