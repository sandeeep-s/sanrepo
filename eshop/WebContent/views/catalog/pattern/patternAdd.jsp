<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="pattern.add" />
</h1>
<sf:form action="/eshop/pattern" method="POST" modelAttribute="pattern">
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.brands}" var="brandVar">
			<sf:option value="${brandVar.id}">${brandVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="brand" />
	<br />
	<br />
	<label><s:message code="pattern.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='pattern.add'/>">
</sf:form>
