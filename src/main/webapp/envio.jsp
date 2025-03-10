<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Envío de Mensajes</title>
</head>
<body>
<jsp:useBean id="mensa" class="javabeans.Mensaje" scope="request" />
<jsp:setProperty name="mensa" property="*" />

<%
    // Si el usuario ya llenó "texto", forward para grabar:
    if (request.getParameter("texto") != null) {
%>
<jsp:forward page="controlador?operacion=grabar" />
<%
    }
%>

<center>
    <h1>Generación de mensajes</h1>
    <form method="post">
        <br/><br/>
        <b>Datos del mensaje:</b><br/><br/>

        <!-- 1. Remitente -->
        Introduzca el remitente:
        <input type="text" name="remitente" required><br/><br/>

        <!-- 2. Destinatario -->
        Introduzca el destinatario:
        <input type="text" name="destinatario" required><br/><br/>

        <!-- 3. Copia Para -->
        Introduzca copia para:
        <input type="text" name="copiaPara"><br/><br/>

        <!-- 4. Texto -->
        Introduzca el texto:<br/>
        <textarea name="texto" rows="10" cols="60" required></textarea>
        <hr/><br/>

        <input type="submit" name="Submit" value="Enviar">
        <input type="reset" value="Reset">
    </form>
</center>
</body>
</html>
