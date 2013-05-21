<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="tech.spec.property.add" />
</h1>
<sf:form action="/eshop/techspecproperty" method="POST" modelAttribute="techSpecProperty">
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
	<label><s:message code="tech.spec.property.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="tech.spec.property.unit" /> : </label>
	<sf:input type="text" path="unit"/>
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="tech.spec.property.description" /> : </label>
	<sf:input type="text" path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='tech.spec.property.add'/>">
</sf:form>
