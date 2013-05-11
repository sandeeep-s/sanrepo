<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="brand.added" />
</h1>

<label><s:message code="brand.name" /> : </label>
${requestScope.brand.name}
<br />
<br />
<label><s:message code="brand.logo" /> : </label>
<img src="<c:url value='/resources/images/${requestScope.brand.logoImage.mediaFileName}'/>" title="${requestScope.brand.name}">
