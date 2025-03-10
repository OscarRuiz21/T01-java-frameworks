package javabeans;

import java.sql.Timestamp;

public class Mensaje {
    private int id;  // Nuevo: identificador único
    private String remitente;
    private String destinatario;
    private String copiaPara;
    private String texto;
    private Timestamp fecha; // Nuevo: fecha de envío

    // Constructor por defecto
    public Mensaje() {
    }

    // Constructor con todos los campos (sin id, en inserción se genera automáticamente)
    public Mensaje(String remitente, String destinatario, String copiaPara, String texto) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.copiaPara = copiaPara;
        this.texto = texto;
    }

    // Constructor completo (usado en consultas)
    public Mensaje(int id, String remitente, String destinatario, String copiaPara, String texto, Timestamp fecha) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.copiaPara = copiaPara;
        this.texto = texto;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCopiaPara() {
        return copiaPara;
    }
    public void setCopiaPara(String copiaPara) {
        this.copiaPara = copiaPara;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
