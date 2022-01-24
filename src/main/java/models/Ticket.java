package models;

import java.util.Date;

public class Ticket {
    private Date fecha;

    //id = nSala+Fila+columna?
    private String id;


    public Ticket(int nSala, char fila, int columna) {
        this.fecha = new Date();

        this.id = ""+ nSala + fila + columna;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
