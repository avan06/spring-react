<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<script>${__jscss.jscmdh}</script>

<c:forEach var="s" items="${__jscss.jslib}">
<script src="${s}"></script>
</c:forEach>

<c:if test="${__jscss.jscmd != null}">
<script lang="javascript">
	<c:forEach var="s" items="${__jscss.jscmd}">
	${s}
	</c:forEach>
</script>
</c:if>

<c:forEach var="s" items="${__jscss.css}">
<LINK rel="stylesheet" href="${s}">
</c:forEach>

<title>${__jscss.title}</title>
</head>
<body>
	<div id="content"></div>

	<c:forEach var="s" items="${__jscss.js}">
	<script src="${s}"></script>
	</c:forEach>
</body>
</html>
