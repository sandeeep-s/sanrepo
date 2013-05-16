<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="tech.spec.add" />
</h1>
<sf:form action="/eshop/techspec" method="POST" modelAttribute="techSpec">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.categories}" var="categoryVar">
			<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="tech.spec.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='tech.spec.add'/>">
</sf:form>
