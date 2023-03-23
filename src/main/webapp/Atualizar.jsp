<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html>
<html>
<head>
<title>Update</title>
</head>
<body>
	<h2>Atualizar</h2>
	<form action=updatedetails method="post">
		<pre>
<b>Nome:         </b><input type="text" name="nome" value='<s:property value="nome"/>'>
		
		
<b>Funcao:        </b><input type="text"  name="funcao" value='<s:property value="funcao"/>'>
		            <input type="hidden" name="uemailhidden" value='<s:property value="uemail"/>'>
		

		
		<button name="submitType" value="update" type="submit">Update</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>