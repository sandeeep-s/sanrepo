<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="category.edit" />
</h1>
<sf:form action="/eshop/category/${category.id}" method="PUT" modelAttribute="category">
	<sf:input type="hidden" path="id" value="${category.id}" />
	<sf:input type="hidden" path="version" value="${category.version}" />
	<label><s:message code="category.parent.category" /> : </label>
	<sf:select path="parentCategory">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<sf:options items="${categories}" itemLabel="name" itemValue="id"/>
	</sf:select>
	<br />
	<br />
	<label><s:message code="category.name" /> : </label>
	<sf:input type="text" path="name"/>
	<br />
	<br />
	<label><s:message code="category.description" /> : </label>
	<sf:textarea path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<h3><s:message code="category.image" /></h3>
	<sf:input type="hidden" path="image.mediaType" value="${category.image.mediaType}" />
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input type="text" path="image.mediaFileName"/>
	<sf:errors path="image.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="image.mediaName"/>
	<sf:errors path="image.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="image.mediaThumbnailFileName"/>
	<sf:errors path="image.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='category.edit'/>">
</sf:form>
