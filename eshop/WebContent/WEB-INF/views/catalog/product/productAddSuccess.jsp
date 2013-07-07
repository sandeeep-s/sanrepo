<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="product.added" />
</h1>

<label><s:message code="category" /> : </label>
<c:forEach items="${product.categorizedProducts}" var="categorizedProduct">
	${categorizedProduct.category.name},
</c:forEach>
<br />
<br />
<label><s:message code="brand" /> : </label> ${product.brand.name}
<br />
<br />
<label><s:message code="pattern" /> : </label> ${product.productSpec.pattern.name}
<br />
<br />
<label><s:message code="product.name" /> : </label> ${product.name}
<br />
<br />
<label><s:message code="product.description" /> : </label> ${product.description}
<br />
<br />
<h3><s:message code="product.tech.spec" /> : </h3>
<c:forEach items="${product.productSpec.techSpecs}" var="techSpec" varStatus="status">
	<s:message code="product.tech.spec" /> ${status.count} :<br/>
	<label><s:message code="tech.spec" /> : </label> ${product.productSpec.techSpecs[status.index].techSpecProperty.name}
	<br/>
	<br/>
	<label><s:message code="tech.spec.value" /> : </label> ${product.productSpec.techSpecs[status.index].techSpecValue}
	<br/>
	<br/>
</c:forEach>
<h3><s:message code="product.dimension" /> : </h3>
<c:forEach items="${product.productSpec.dimensions}" var="dimension" varStatus="status">
	<s:message code="product.dimension" /> ${status.count} :<br/>
	<label><s:message code="dimension" /> : </label> ${product.productSpec.dimensions[status.index].dimensionProperty.name}
	<br/>
	<br/>
	<label><s:message code="dimension.value" /> : </label>  ${product.productSpec.dimensions[status.index].dimensionValue}
	<br/>
	<br/>
</c:forEach>
<h3><s:message code="product.image" /> : </h3>
<c:forEach items="${product.images}" var="image" varStatus="status">
	<s:message code="product.image" /> ${status.count} :<br/>
	<label><s:message code="image.filename" /> : </label> ${image.mediaFileName}
	<br />
	<br />
	<label><s:message code="image.name" /> : </label> ${image.mediaName}
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label> ${image.mediaThumbnailFileName}
	<br />
	<br />
</c:forEach>
