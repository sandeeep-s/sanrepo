<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.add" />
</h1>
<sf:form action="/eshop/category" method="POST" modelAttribute="category">
	<label><s:message code="category.parent.category" /> : </label>
		<sf:select path="parentCategory">
			<sf:option value="-1">
				<s:message code="select" />
			</sf:option>
			<c:forEach items="${categories}" var="categoryVar">
				<sf:option value="${category.id}">${category.name}</sf:option>
			</c:forEach>
		</sf:select>
	<br/>
	<br/>
	<label><s:message code="category.name" /> : </label>
	<sf:input path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="category.description" /> : </label>
	<sf:textarea  path="description" />
	<sf:errors path="description" />
	<br />
	<br />
	<h3><s:message code="category.image" /> : </h3>
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
	<input type="submit" value="<s:message code='category.add'/>">
</sf:form>
