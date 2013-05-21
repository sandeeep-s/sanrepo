<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="product.add" />
</h1>
<sf:form action="/eshop/product" method="POST" modelAttribute="product">
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
	<label><s:message code="pattern" /> : </label>
	<sf:select path="productSpec.pattern">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${patterns}" var="patternVar">
			<sf:option value="${patternVar.id}">${patternVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="productSpec.pattern" />
	<br />
	<br />
	<label><s:message code="product.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="product.description" /> : </label>
	<sf:textarea type="text" path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<h3><s:message code="product.image" /> : </h3>
		<c:forEach items="${product.images}" var="image" varStatus="status">
			<s:bind path="images[${status.index}].mediaType">
					<sf:input type="hidden" path="${status.expression}" value="<%=MediaType.IMAGE%>"/>
	 		</s:bind>
			<label><s:message code="image.filename" /> : </label>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.name" /> : </label>
			<s:bind path="images[${status.index}].mediaName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.thumbnailFileName" /> : </label>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
		</c:forEach>	
	<input type="submit" value="<s:message code='product.add'/>">
</sf:form>
