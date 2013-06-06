<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="dimension.property.add" />
</h1>
<sf:form action="/eshop/dimensionproperty" method="POST" modelAttribute="dimensionProperty">
	<label><s:message code="category" /> : </label>
	<sf:select path="category">
		<sf:options items="${categories}" itemLabel="name" itemValue="id"/>
	</sf:select>
	<sf:errors path="category" />
	<br />
	<br />
	<label><s:message code="dimension.property.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="dimension.property.unit" /> : </label>
	<sf:input type="text" path="unit"/>
	<sf:errors path="unit" />
	<br />
	<br />
	<label><s:message code="dimension.property.description" /> : </label>
	<sf:input type="text" path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<input type="submit" value="<s:message code='dimension.property.add'/>">
</sf:form>
