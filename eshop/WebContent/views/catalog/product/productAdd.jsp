<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="product.add" />
</h1>
<sf:form action="/eshop/product" method="POST" modelAttribute="product">
	<label><s:message code="category" /> : </label>
	<sf:select path="categorizedProducts[0].category">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${categories}" var="categoryVar">
			<sf:option value="${categoryVar.id}">${categoryVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="categorizedProducts[0].category" />
	<br />
	<br />
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
	<h3><s:message code="product.tech.spec" /> : </h3>
	<c:forEach items="${product.productSpec.techSpecs}" var="techSpec" varStatus="status">
		<label><s:message code="tech.spec" /> : </label>
		<s:bind path="productSpec.techSpecs[${status.index}].techSpecProperty">
			<sf:select path="${status.expression}">
				<sf:option value="-1">
					<s:message code="select" />
				</sf:option>
				<c:forEach items="${techSpecProperties}" var="techSpecProperty">
					<sf:option value="${techSpecProperty.id}">${techSpecProperty.name}</sf:option>
				</c:forEach>
			</sf:select>
 		</s:bind>
		<s:bind path="productSpec.techSpecs[${status.index}].techSpecProperty">
				<sf:errors path="${status.expression}"/>
 		</s:bind>
 		<br/>
 		<br/>
		<label><s:message code="tech.spec.value" /> : </label>
		<s:bind path="productSpec.techSpecs[${status.index}].techSpecValue">
			<sf:input path="${status.expression}"></sf:input>
 		</s:bind>
		<s:bind path="productSpec.techSpecs[${status.index}].techSpecValue">
				<sf:errors path="${status.expression}"/>
 		</s:bind>
 		<br/>
 		<br/>
	</c:forEach>
	<h3><s:message code="product.dimension" /> : </h3>
	<c:forEach items="${product.productSpec.dimensions}" var="dimension" varStatus="status">
		<label><s:message code="dimension" /> : </label>
		<s:bind path="productSpec.dimensions[${status.index}].dimensionProperty">
			<sf:select path="${status.expression}">
				<sf:option value="-1">
					<s:message code="select" />
				</sf:option>
				<c:forEach items="${dimensionProperties}" var="dimensionProperty">
					<sf:option value="${dimensionProperty.id}">${dimensionProperty.name}</sf:option>
				</c:forEach>
			</sf:select>
 		</s:bind>
		<s:bind path="productSpec.dimensions[${status.index}].dimensionProperty">
				<sf:errors path="${status.expression}"/>
 		</s:bind>
 		<br/>
 		<br/>
		<label><s:message code="dimension" /> : </label>
		<s:bind path="productSpec.dimensions[${status.index}].dimensionValue">
			<sf:input path="${status.expression}"></sf:input>
 		</s:bind>
		<s:bind path="productSpec.dimensions[${status.index}].dimensionValue">
				<sf:errors path="${status.expression}"/>
 		</s:bind>
 		<br/>
 		<br/>
	</c:forEach>
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
