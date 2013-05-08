<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.add" />
</h1>
<sf:form action="/etyre-spring-rest/vehicle" method="POST" enctype="multipart/form-data" modelAttribute="vehicle">
	<label><s:message code="vehicle.make" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
	<sf:select path="make">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.vehicleMakeSet}" var="vehicleMake">
			<sf:option value="${vehicleMake.id}">${vehicleMake.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="make" />
	<br />
	<br />
	<label><s:message code="vehicle.model" /> : </label>
	<sf:input type="text" path="model"/>
	<sf:errors path="model" />
	<br />
	<br />
	<label><s:message code="vehicle.submodel" /> : </label>
	<sf:input type="text" path="subModel"/>
	<sf:errors path="subModel" />
	<br />
	<br />
	<label><s:message code="vehicle.year" /> : </label>
	<sf:select path="manufacturingYear">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<sf:option value="2012">2012</sf:option>
		<sf:option value="2011">2011</sf:option>
		<sf:option value="2010">2010</sf:option>
		<sf:option value="2009">2009</sf:option>
		<sf:option value="2008">2008</sf:option>
		<sf:option value="2007">2007</sf:option>
		<sf:option value="2006">2006</sf:option>
		<sf:option value="2005">2005</sf:option>
		<sf:option value="2004">2004</sf:option>
		<sf:option value="2003">2003</sf:option>
		<sf:option value="2002">2002</sf:option>
		<sf:option value="2001">2001</sf:option>
		<sf:option value="2000">2000</sf:option>
	</sf:select>
	<sf:errors path="manufacturingYear" />
	<br />
	<br />
	<label><s:message code="image" /> : </label>
	<input type="file" name="image">
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.add'/>">
</sf:form>

