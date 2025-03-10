<%@ page import="javabeans.Mensaje,java.util.ArrayList" %>
<html>
<head>
    <title>Ver Mensajes</title>
</head>
<body>
<center>
    <%
        String nombre = request.getParameter("nombre");
    %>
    <h1>Mensajes para <%= nombre %></h1>
    <table border="1">
        <tr>
            <th>Remitente</th>
            <th>Destinatario</th>
            <th>Copia Para</th>
            <th>Texto</th>
            <th>Fecha</th>
            <th>Acciones</th>
        </tr>
        <%
            boolean hayMensajes = false;
            ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");
            if (mensajes != null) {
                for (Mensaje m : mensajes) {
                    if (m.getDestinatario().equalsIgnoreCase(nombre)) {
                        hayMensajes = true;
        %>
        <tr>
            <td><%= m.getRemitente() %></td>
            <td><%= m.getDestinatario() %></td>
            <td><%= m.getCopiaPara() %></td>
            <td><%= m.getTexto() %></td>
            <td><%= m.getFecha() %></td>
            <td>
                <!-- Formulario para eliminar el mensaje -->
                <form action="controlador?operacion=eliminar" method="post" style="margin:0;">
                    <input type="hidden" name="id" value="<%= m.getId() %>"/>
                    <button type="submit">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
                    }
                }
            }
            if (!hayMensajes) {
        %>
        <jsp:forward page="nomensajes.jsp"/>
        <%
            }
        %>
    </table>
    <br/><br/>
    <h1><b><a href="inicio.html">Inicio</a></b></h1>
</center>
</body>
</html>