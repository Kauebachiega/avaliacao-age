<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC >
<html>
<head>
<title>Register</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
</head>
<body>
	<h2>Struts 2 </h2>
	<a href="report"><button class="button-report" type="button">Report</button></a>
	<s:form action="registeruser.action" method="post">
		<s:textfield label="Full Name" name="codigo" />
		<s:textfield label="Full Name" name="nome" />
		<s:password label="full Name" name="funcao" />
		<s:textfield label="Designation" name="udeg" />
		<s:submit cssClass="button-register" value="Resgister" />
	</s:form>
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>