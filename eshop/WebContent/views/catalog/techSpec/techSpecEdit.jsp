<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="tech.spec.edit" />
</h1>
<sf:form action="/eshop/techspec/${techSpec.id}" method="PUT" modelAttribute="techSpec">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<c:forEach items="${categories}" var="categoryVar">
			<c:if test="${techSpec.category.id == categoryVar.id}">
				<sf:option value="${categoryVar.id}" selected="true">${categoryVar.name}</sf:option>
			</c:if>
			<c:if test="${techSpec.category.id != categoryVar.id}">
				<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="tech.spec.name" /> : </label>
	<sf:input type="text" path="name" value="${techSpec.name}" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="tech.spec.unit" /> : </label>
	<sf:input type="text" path="unit" value="${techSpec.unit}" />
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="tech.spec.description" /> : </label>
	<sf:input type="text" path="description" value="${techSpec.description}" />
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='tech.spec.edit'/>">
</sf:form>
