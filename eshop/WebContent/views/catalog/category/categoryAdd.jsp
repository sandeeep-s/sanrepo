<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.add" />
</h1>
<sf:form action="/eshop/category" method="POST" modelAttribute="category">
	<label><s:message code="category.name" /> : </label>
	<sf:input path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="category.name" /> : </label>
	<sf:input path="description" />
	<sf:errors path="description" />
	<br />
	<br />
	<h3><s:message code="category.logo" /> : </h3>
	<sf:input type="hidden" path="logoImage.mediaType" value="<%=MediaType.IMAGE%>"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input path="logoImage.mediaFileName" />
	<sf:errors path="logoImage.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="logoImage.mediaName" />
	<sf:errors path="logoImage.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="logoImage.mediaThumbnailFileName" />
	<sf:errors path="logoImage.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='category.add'/>">
</sf:form>
