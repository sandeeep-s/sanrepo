<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.added" />
</h1>

<label><s:message code="category.name" /> : </label>
${requestScope.category.name}
<br />
<br />
