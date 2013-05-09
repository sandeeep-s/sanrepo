<%@page import="com.eshop.common.model.MediaType"%>
<%@ include file="/views/init.jsp" %>


<h1 align="center">
	<s:message code="vehicle.type.add" />
</h1>

<sf:form action="/eshop/vehicletype" method="POST" modelAttribute="vehicleType">
	<label><s:message code="vehicle.type.name" /> : </label>
	<sf:input path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<h3><s:message code="vehicle.type.image" /> : </h3>
	<sf:input type="hidden" path="image.mediaType" value="<%=MediaType.IMAGE%>"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input path="image.mediaFileName" />
	<sf:errors path="image.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="image.mediaName" />
	<sf:errors path="image.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="image.mediaThumbnailFileName" />
	<sf:errors path="image.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.type.add'/>">
</sf:form>
