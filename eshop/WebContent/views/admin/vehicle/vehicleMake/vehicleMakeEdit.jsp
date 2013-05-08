<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.edit" />
</h1>
<sf:form action="/eshop/vehiclemake/${vehicleMake.id}" method="PUT" modelAttribute="vehicleMake">
	<sf:input type="hidden" path="id" value="${vehicleMake.id}" />
	<sf:input type="hidden" path="version" value="${vehicleMake.version}" />
	<label><s:message code="vehicle.make.name" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
	<sf:input type="text" path="name" value="${vehicleMake.name}" />
	<br />
	<br />
	<h3><s:message code="vehicle.make.logo" /> : </h3>
	<sf:input type="hidden" path="logoImage.mediaType" value="${vehicleMake.logoImage.mediaType}"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input type="text" path="logoImage.mediaFileName" value="${vehicleMake.logoImage.mediaFileName}" />
	<sf:errors path="logoImage.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="logoImage.mediaName" value="${vehicleMake.logoImage.mediaName}"/>
	<sf:errors path="logoImage.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="logoImage.mediaThumbnailFileName" value="${vehicleMake.logoImage.mediaThumbnailFileName}"/>
	<sf:errors path="logoImage.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.make.edit'/>">
</sf:form>
