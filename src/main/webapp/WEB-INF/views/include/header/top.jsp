<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<sec:authentication property="principal" var="principal" />
<c:set var="user" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="root" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}"/>
<c:set var="requestUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:set var="locale" value="<%=RequestContextUtils.getLocale(request).toString()%>" />
<c:set var="testMode"><spring:eval expression="@config['super.test']" /></c:set>
<c:set var="resources"><spring:eval expression="@config['resources.cdn']" /></c:set>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="ko">
<!--<![endif]-->
