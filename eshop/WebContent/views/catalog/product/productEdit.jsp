<%@page import="com.eshop.catalog.model.Category"%>
<%@page import="java.util.Set"%>
<%@page import="com.eshop.catalog.model.Product"%>
<%@page import="com.eshop.catalog.model.CategorizedProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="product.edit" />
</h1>

<sf:form action="/eshop/product/${product.id}" method="PUT" modelAttribute="product">
	<sf:input type="hidden" path="id" value="${product.id}" />
	<sf:input type="hidden" path="version" value="${product.version}" />
	<sf:input type="hidden" path="productSpec.id" value="${product.productSpec.id}" />
	<sf:input type="hidden" path="productSpec.version" value="${product.productSpec.version}" />
	<label><s:message code="category" /> : </label>
	<sf:select path="categorizedProducts" multiple="true">
		<%
			Product product = (Product)request.getAttribute("product");
			Set<Category> categories = (Set<Category>)request.getAttribute("categories");
			for (Category category : categories ){
				boolean categorySelected = false;
				for (CategorizedProduct categorizedProduct : product.getCategorizedProducts()){
					if (category.equals(categorizedProduct.getCategory())){
						categorySelected = true;
						break;
					}
				}
				if (categorySelected == true){
			%>
				<sf:option value="<%=category.getId()%>" label="<%=category.getName()%>" selected="true"/>						
			<%		
				}else{
			%>
				<sf:option value="<%=category.getId()%>" label="<%=category.getName()%>"/>						
			<%		
				}
			}
		%>
	</sf:select>
	<sf:errors path="categorizedProducts" />
	<br />
	<br />
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<sf:options items="${brands}" itemLabel="name" itemValue="id"/>
	</sf:select>
	<sf:errors path="brand" />
	<br />
	<br />
	<label><s:message code="pattern" /> : </label>
	<sf:select path="productSpec.pattern">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<sf:options items="${patterns}" itemLabel="name" itemValue="id"/>
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
		<sf:select path="productSpec.techSpecs[${status.index}].techSpecProperty">
			<sf:options items="${techSpecProperties}" itemLabel="name" itemValue="id"/>
		</sf:select>
		<sf:errors path="productSpec.techSpecs[${status.index}].techSpecProperty"/>
 		<br/>
 		<br/>
		<label><s:message code="tech.spec.value" /> : </label>
		<sf:input path="productSpec.techSpecs[${status.index}].techSpecValue"></sf:input>
		<sf:errors path="productSpec.techSpecs[${status.index}].techSpecValue"/>
 		<br/>
 		<br/>
	</c:forEach>
	<h3><s:message code="product.dimension" /> : </h3>
	<c:forEach items="${product.productSpec.dimensions}" var="dimension" varStatus="status">
		<label><s:message code="dimension" /> : </label>
		<sf:select path="productSpec.dimensions[${status.index}].dimensionProperty">
			<sf:options items="${dimensionProperties}" itemLabel="name" itemValue="id"/>
		</sf:select>
		<sf:errors path="productSpec.dimensions[${status.index}].dimensionProperty"/>
 		<br/>
 		<br/>
		<label><s:message code="dimension" /> : </label>
		<sf:input path="productSpec.dimensions[${status.index}].dimensionValue"></sf:input>
		<sf:errors path="productSpec.dimensions[${status.index}].dimensionValue"/>
 		<br/>
 		<br/>
	</c:forEach>
	<h3><s:message code="product.image" /> : </h3>
	<c:forEach items="${product.images}" var="image" varStatus="status">
		<s:message code="product.image" /> ${status.count} :<br/>
		<sf:input type="hidden" path="images[${status.index}].mediaType" value="<%=MediaType.IMAGE%>"/>
		<label><s:message code="image.filename" /> : </label>
		<sf:input path="images[${status.index}].mediaFileName"/>
		<sf:errors path="images[${status.index}].mediaFileName"/>
		<br />
		<br />
		<label><s:message code="image.name" /> : </label>
		<sf:input path="images[${status.index}].mediaName"/>
		<sf:errors path="images[${status.index}].mediaName"/>
		<br />
		<br />
		<label><s:message code="image.thumbnailFileName" /> : </label>
		<sf:input path="images[${status.index}].mediaThumbnailFileName"/>
		<sf:errors path="images[${status.index}].mediaThumbnailFileName"/>
		<br />
		<br />
	</c:forEach>	
	<input type="submit" value="<s:message code='product.edit'/>">
</sf:form>
