<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle" />
</h1>
<div>
	<label><s:message code="vehicle.make" /> : </label> ${vehicleModel.vehicleMake.name} <br /> <br /> 
	<label><s:message code="vehicle.type" /> : </label> ${vehicleModel.vehicleType.name} <br /> <br /> 
	<label><s:message code="vehicle.model.name" /> : </label> ${vehicleModel.name} <br /> <br />
	<label><s:message code="vehicle.model.year" /> : </label> ${vehicleModel.manufacturingYear} <br /> <br /> 
</div>