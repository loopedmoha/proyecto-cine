package models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket{
    private Date fecha;
    private final String sFecha;
    //id = nSala+Fila+columna?
    private String id;


    public Ticket(int nSala, char fila, int columna) {
        this.fecha = new Date();
        this.sFecha = getFechaString();

        this.id = ""+ nSala + fila + columna;
    }


public Date getFecha(){
        return fecha;
}
    public String getsFecha() {
        return sFecha;
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

    /**
     * Compara dos tickets
     * @param t1 ticket1
     * @param t2 ticket2
     * @return 0 si son iguales. -1 si t1 < t2. 1 si t1 > t2
     */
    public static int compareTicket(Ticket t1, Ticket t2){
        String s1, s2;
        s1 = t1.getsFecha();
        s2 = t2.getsFecha();

        int out = s1.compareTo(s2);

        if(out < 0) out = -1;
        else if (out > 0) out = 1;
        
        return out;
    }

    public void printTicket(){
        System.out.println("Ticket creado el: " + fecha);
        System.out.print("ID de ticket: ");
        System.out.print(Ansi.colorize(id+"\n", Attribute.BOLD(), Attribute.RED_TEXT()));
    }


}
