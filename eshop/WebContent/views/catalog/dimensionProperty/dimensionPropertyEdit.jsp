<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="dimension.property.edit" />
</h1>
<sf:form action="/eshop/dimensionproperty/${dimensionProperty.id}" method="PUT" modelAttribute="dimensionProperty">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<c:forEach items="${categories}" var="categoryVar">
			<c:if test="${dimensionProperty.category.id == categoryVar.id}">
				<sf:option value="${categoryVar.id}" selected="true">${categoryVar.name}</sf:option>
			</c:if>
			<c:if test="${dimensionProperty.category.id != categoryVar.id}">
				<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="dimension.property.name" /> : </label>
	<sf:input type="text" path="name" value="${dimensionProperty.name}"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="dimension.property.unit" /> : </label>
	<sf:input type="text" path="unit" value="${dimensionProperty.unit}"/>
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="dimension.property.description" /> : </label>
	<sf:input type="text" path="description" value="${dimensionProperty.description}"/>
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='dimension.property.edit'/>">
</sf:form>
