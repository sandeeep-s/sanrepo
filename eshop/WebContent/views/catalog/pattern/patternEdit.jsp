<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="pattern.edit" />
</h1>
<sf:form action="/eshop/pattern/${pattern.id}" method="PUT" modelAttribute="pattern">
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<c:forEach items="${brands}" var="brandVar">
			<c:if test="${pattern.brand.id == brandVar.id}">
				<sf:option value="${brandVar.id}" selected="true">${brandVar.name}</sf:option>
			</c:if>
			<c:if test="${pattern.brand.id != brandVar.id}">
				<sf:option value="${brandVar.id}">${brandVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="brand" />
	<br />
	<br />
	<label><s:message code="pattern.name" /> : </label>
	<sf:input type="text" path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='pattern.edit'/>">
</sf:form>
