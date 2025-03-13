package modelo;

import java.sql.*;
import javabeans.*;
import java.util.*;

public class Operaciones {
    // Metodo para obtener conexión usando H2
    public Connection getConnection() {
        Connection cn = null;
        try {
            // Cargar el driver H2
            Class.forName("org.h2.Driver");
            // Conectar a la base de datos H2 (archivo en memoria)
            cn = DriverManager.getConnection("jdbc:h2:mem:mensajes;DB_CLOSE_DELAY=-1", "sa", "pas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    public ArrayList<Mensaje> obtenerMensajes(String destino) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        try (Connection cn = getConnection();
             Statement st = cn.createStatement()) {

            String tsql = "SELECT * FROM mensajes WHERE destinatario = '" + destino + "'";
            ResultSet rs = st.executeQuery(tsql);

            while (rs.next()) {
                Mensaje m = new Mensaje(
                        rs.getInt("id"),                     // id
                        rs.getString("remitente"),           // remitente
                        rs.getString("destinatario"),          // destinatario
                        rs.getString("copiaPara"),           // copiaPara
                        rs.getString("texto"),               // texto
                        rs.getTimestamp("fecha")             // fecha
                );
                mensajes.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mensajes;
    }

    public void grabaMensaje(Mensaje m) {
        try (Connection cn = getConnection();
             Statement st = cn.createStatement()) {

            String sql = "INSERT INTO mensajes (remitente, destinatario, copiaPara, texto) VALUES ('"
                    + m.getRemitente() + "', '"
                    + m.getDestinatario() + "', '"
                    + m.getCopiaPara() + "', '"
                    + m.getTexto() + "')";
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminaMensaje(int id) {
        try (Connection cn = getConnection();
             Statement st = cn.createStatement()) {

            String sql = "DELETE FROM mensajes WHERE id = " + id;
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
