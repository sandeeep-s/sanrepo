<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="tech.spec.property.edit" />
</h1>
<sf:form action="/eshop/techspecproperty/${techSpecProperty.id}" method="PUT" modelAttribute="techSpecProperty">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<c:forEach items="${categories}" var="categoryVar">
			<c:if test="${techSpecProperty.category.id == categoryVar.id}">
				<sf:option value="${categoryVar.id}" selected="true">${categoryVar.name}</sf:option>
			</c:if>
			<c:if test="${techSpecProperty.category.id != categoryVar.id}">
				<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="tech.spec.property.name" /> : </label>
	<sf:input type="text" path="name" value="${techSpecProperty.name}" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="tech.spec.property.unit" /> : </label>
	<sf:input type="text" path="unit" value="${techSpecProperty.unit}" />
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="tech.spec.property.description" /> : </label>
	<sf:input type="text" path="description" value="${techSpecProperty.description}" />
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='tech.spec.property.edit'/>">
</sf:form>
