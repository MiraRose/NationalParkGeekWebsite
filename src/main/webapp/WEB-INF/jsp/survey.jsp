<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="takeSurveyURL" value="/survey" />

<div class=detailContent>
<div>
	<h1>National Park Survey</h1>
	<h3>Let us hear your thoughts on our nation's lovely parks!</h3>
</div>

<form:form action="${takeSurveyURL}" method="POST"
	modelAttribute="survey">

	<div class="questions">
		<div>
			<label for="park">Favorite Park:</label>
		</div>
		<div>
			<label for="email">Your Email:</label>
		</div>
		<div>
			<label for="state">State of Residence:</label>
		</div>
		<div>
			<label for="activityLevel">Activity Level:</label>
		</div>
	</div>

	<div class="answers">
		<div>
			<form:select path="parkCode">
				<form:errors path="parkCode" cssClass="error" />
				<c:forEach var="park" items="${parks}">

					<form:option value="${park.parkCode}">
						<c:out value="${park.parkName}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />
		</div>
		<div>
			<form:select path="state">
				<form:errors path="state" cssClass="error" />
				<c:forEach var="state" items="${states}">

					<form:option value="${state}">
						<c:out value="${state}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>

			<label> <form:radiobutton path="activityLevel"
					value="inactive" /> Inactive
			</label> <label> <form:radiobutton path="activityLevel"
					value="sedentary" /> Sedentary
			</label> <label> <form:radiobutton path="activityLevel"
					value="active" /> Active
			</label> <label> <form:radiobutton path="activityLevel"
					value="extremely active" /> Extremely Active
			</label>
			<div>
				<form:errors path="activityLevel" cssClass="error" />
			</div>
		</div>

		<div id="submit">
			<button type="submit">Submit Survey</button>
		</div>
	</div>

</form:form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />