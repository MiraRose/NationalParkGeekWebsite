<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="results">
	<div class="resultDescription">
		<h2>Survey Results</h2>
		<h3>Thank you for voting for ${survey}!</h3>
		<p>Thanks for taking our survey! We're always glad to hear from
			fellow park-lovers! Here's the results of our survey ranked by number
			of votes!</p>
	</div>



	<c:forEach var="result" items="${results}">
		<div class="result">

			<c:set var="lowercase" value="${fn:toLowerCase(result.parkCode)}" />
			<c:url var="imageURL" value="/img/parks/${lowercase}.jpg" />
			<img src="${imageURL}" />

			<h4>
				<c:out value="${result.parkName}" />
			</h4>
			<p>
				<c:out value="${result.surveyCount}" />
			</p>

		</div>

	</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />