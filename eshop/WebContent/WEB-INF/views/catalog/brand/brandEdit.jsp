<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="brand.edit" />
</h1>
<sf:form action="/eshop/brand/${brand.id}" method="PUT" modelAttribute="brand">
	<sf:input type="hidden" path="id" value="${brand.id}" />
	<sf:input type="hidden" path="version" value="${brand.version}" />
	<label><s:message code="brand.name" /> : </label>
	<sf:input type="text" path="name"/>
	<br />
	<br />
	<label><s:message code="brand.description" /> : </label>
	<sf:textarea  path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<h3><s:message code="brand.logo" /> : </h3>
	<sf:input type="hidden" path="logoImage.mediaType" value="${brand.logoImage.mediaType}"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input type="text" path="logoImage.mediaFileName"/>
	<sf:errors path="logoImage.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="logoImage.mediaName"/>
	<sf:errors path="logoImage.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="logoImage.mediaThumbnailFileName"/>
	<sf:errors path="logoImage.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='brand.edit'/>">
</sf:form>
