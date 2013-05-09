<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.model.add" />
</h1>
<sf:form action="/eshop/vehiclemodel" method="POST" modelAttribute="vehicleModel">
	<label><s:message code="vehicle.make" /> : </label>
	<sf:select path="vehicleMake">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.vehicleMakes}" var="vehicleMakeVar">
			<sf:option value="${vehicleMakeVar.id}">${vehicleMakeVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleMake" />
	<br />
	<br />
	<label><s:message code="vehicle.type" /> : </label>
	<sf:select path="vehicleType">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.vehicleTypes}" var="vehicleTypeVar">
			<sf:option value="${vehicleTypeVar.id}">${vehicleTypeVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleType" />
	<br />
	<br />
	<label><s:message code="vehicle.model.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="vehicle.model.year" /> : </label>
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
	<input type="submit" value="<s:message code='vehicle.model.add'/>">
</sf:form>

