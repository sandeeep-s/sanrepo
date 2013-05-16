<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.edit" />
</h1>
<sf:form action="/eshop/category/${category.id}" method="PUT" modelAttribute="category">
	<sf:input type="hidden" path="id" value="${category.id}" />
	<sf:input type="hidden" path="version" value="${category.version}" />
	<label><s:message code="category.name" /> : </label>
	<sf:input type="text" path="name" value="${category.name}" />
	<br />
	<br />
	<h3><s:message code="category.logo" /> : </h3>
	<sf:input type="hidden" path="logoImage.mediaType" value="${category.logoImage.mediaType}"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input type="text" path="logoImage.mediaFileName" value="${category.logoImage.mediaFileName}" />
	<sf:errors path="logoImage.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="logoImage.mediaName" value="${category.logoImage.mediaName}"/>
	<sf:errors path="logoImage.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="logoImage.mediaThumbnailFileName" value="${category.logoImage.mediaThumbnailFileName}"/>
	<sf:errors path="logoImage.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='category.edit'/>">
</sf:form>
