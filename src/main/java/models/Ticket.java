package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket extends Butaca {
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

    public String getFechaString(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(getFecha());
    }

    public void printTicket(){
        System.out.println("Ticket creado el: " + fecha);
        System.out.print("ID de ticket: ");
        System.out.print(Ansi.colorize(id+"\n", Attribute.BOLD(), Attribute.RED_TEXT()));
    }
}
