<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="dimension.edit" />
</h1>
<sf:form action="/eshop/dimension/${dimension.id}" method="PUT" modelAttribute="dimension">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<c:forEach items="${categorys}" var="categoryVar">
			<c:if test="${dimension.category.id == categoryVar.id}">
				<sf:option value="${categoryVar.id}" selected="true">${categoryVar.name}</sf:option>
			</c:if>
			<c:if test="${dimension.category.id != categoryVar.id}">
				<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="dimension.name" /> : </label>
	<sf:input type="text" path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='dimension.edit'/>">
</sf:form>