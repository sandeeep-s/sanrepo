<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.added" />
</h1>

<label><s:message code="category.name" /> : </label>
${requestScope.category.name}
<br />
<br />
<label><s:message code="category.logo" /> : </label>
<img src="<c:url value='/resources/images/${requestScope.category.logoImage.mediaFileName}'/>" title="${requestScope.category.name}">
