<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class=detailContent>

	<div class="profile">

		<div>
			
			<c:set var="lowercase" value="${fn:toLowerCase(park.parkCode)}"/>
			<c:url var="imageURL" value="/img/parks/${lowercase}.jpg"/>
			
			
			<img src="${imageURL}" />

			<h2>
				<c:out value="${park.parkName}" />
			</h2>
			<h3>
				<c:out value="${park.state}" />
			</h3>




			<h4>
				Entry fee:
				<fmt:formatNumber value="${park.entryFee}" type="currency" />

			</h4>
		</div>
		<p>
			<c:out value="${park.description}" />
		</p>
		<div>
		<p class="quote">
			&#8220;<c:out value="${park.inspirationalQuote}" />&#8221;
		</p>
		<p class="quoteSource">
			- <c:out value="${park.inspirationalQuoteSource}" />
		</p>
		</div>
	</div>




	<div>
		<h3>Fast Facts</h3>
	</div>

	<div>
		<div class="facts">

			<div>
				<h4>Acreage</h4>
				<p>
				<fmt:formatNumber type="number" maxFractionDigits="0" value="${park.acreage}" />
					
				</p>
			</div>

			<div>

				<h4>Elevation</h4>
				<p>
					<c:out value="${park.elevation}" />
					feet
				</p>
			</div>

			<div>

				<h4>Miles of trail</h4>
				<p>
				
					<c:out value="${park.milesOfTrail}" />
				</p>
			</div>

			<div>

				<h4>Number of campsites</h4>
				<p>
					<c:out value="${park.numberOfCampsites}" />
				</p>
			</div>

			<div>

				<h4>Climate</h4>
				<p>
					<c:out value="${park.climate}" />
				</p>
			</div>

			<div>

				<h4>Year founded</h4>
				<p>
					<c:out value="${park.yearFounded}" />
				</p>
			</div>

			<div>

				<h4>Annual visitor count</h4>
				<p>
				<fmt:formatNumber type="number" maxFractionDigits="0" value="${park.annualVisitorCount}" />
					
				</p>
			</div>



			<div>

				<h4>Number of animal species</h4>
				<p>

					<c:out value="${park.numberOfAnimalSpecies}" />
				</p>
			</div>
		</div>
	</div>

	<div class="tempChange">
		<c:url var="changeTempUrl" value="/details" />

		<form action="${changeTempUrl}" method="POST">
			
			<select name="temp">
			<option selected hidden>Select Fahrenheit or Celsius</option>
				<option value="f"> ºF</option>
				<option value="c"> ºC</option>
			</select> <input type="submit" value="Apply" />

		</form>
	</div>
	<div class="weather">

		<c:forEach var="weather" items="${weathers}">

			<c:if test="${weather.day == 1}">
				<div class="today">
					<h3>Today</h3>
			</c:if>

			<c:if test="${weather.day != 1}">
				<div class="other">
			</c:if>

			<div>
				<c:url var="imageURL" value="/img/weather/${weather.forecast}.png" />
				<img src="${imageURL}" />
			</div>


			<p>
				Low:
				<c:if test="${temp == 'f'}">

					<c:out value="${weather.lowTemp}" /> ºF
					</c:if>

				<c:if test="${temp == 'c'}">

					<fmt:formatNumber type="number" maxFractionDigits="1"
						value="${weather.lowTempC}" /> ºC
						
					</c:if>

				<c:if test="${weather.day != 1}">
				</p>
				<p>
				</c:if>
			
				High:
				<c:if test="${temp == 'f'}">
					<c:out value="${weather.highTemp}" /> ºF
					</c:if>

				<c:if test="${temp == 'c'}">
					<fmt:formatNumber type="number" maxFractionDigits="1"
						value="${weather.highTempC}" /> ºC
					</c:if>
			</p>

			<c:if test="${weather.day == 1}">
				<c:forEach var="suggestion" items="${weather.suggestions}">
					<p>
						<c:out value="${suggestion}" />
					</p>
				</c:forEach>
			</c:if>
	</div>

	</c:forEach>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />