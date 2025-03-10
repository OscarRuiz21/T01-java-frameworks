package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import javabeans.Mensaje;
import modelo.Operaciones;

public class Controlador extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("operacion");
        if (op == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Operación no especificada");
            return;
        }

        switch (op) {
            case "envio":
                // Acceso a la página de envío de mensajes
                response.sendRedirect("envio.jsp");
                break;
            case "grabar":
                // Grabación de un mensaje
                Mensaje men = (Mensaje) request.getAttribute("mensa");
                if (men != null) {
                    Operaciones oper = new Operaciones();
                    oper.grabaMensaje(men);
                    response.sendRedirect("inicio.html");
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mensaje no proporcionado");
                }
                break;
            case "muestra":
                // Acceso a la página de solicitud de mensajes
                response.sendRedirect("mostrar.html");
                break;
            case "ver":
                // Acceso a la lista de mensajes del usuario
                String nombre = request.getParameter("nombre");
                Operaciones oper = new Operaciones();
                ArrayList<Mensaje> mensajes = oper.obtenerMensajes(nombre);
                request.setAttribute("mensajes", mensajes);
                RequestDispatcher rd = request.getRequestDispatcher("/ver.jsp");
                rd.forward(request, response);
                break;
            case "eliminar":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Operaciones opera = new Operaciones();
                    opera.eliminaMensaje(id);
                    // Redirige a la página de listado (o al inicio)
                    response.sendRedirect("mostrar.html");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Operación no válida");
                break;
        }
    }
}
