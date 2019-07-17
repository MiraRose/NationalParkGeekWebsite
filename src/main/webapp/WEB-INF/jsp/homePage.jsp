<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="main-content">
<c:forEach var="park" items="${parks}">


<div class="park-description">

<c:set var="lowercase" value="${fn:toLowerCase(park.parkCode)}"/>
<c:url var="imageURL" value="/img/parks/${lowercase}.jpg"/>

<c:url var="detailURL" value="/details">
<c:param name="parkCode" value="${park.parkCode}" />
</c:url>
<div class="parkimg">
<a href="${detailURL}"><img src = "${imageURL}"/></a></div>
<div id="parkDetails">
<h2><c:out value="${park.parkName}"/></h2>
<h4><c:out value="${park.state}"/></h4>
<p><c:out value="${park.description}"/></p>
</div>
</div>

</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />