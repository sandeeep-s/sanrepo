<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="dimension.add" />
</h1>
<sf:form action="/eshop/dimension" method="POST" modelAttribute="dimension">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${categories}" var="categoryVar">
			<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="dimension.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="dimension.unit" /> : </label>
	<sf:input type="text" path="unit"/>
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="dimension.description" /> : </label>
	<sf:input type="text" path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='dimension.add'/>">
</sf:form>
