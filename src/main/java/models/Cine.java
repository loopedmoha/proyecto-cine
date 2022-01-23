package models;

public class Cine {
    private final int NUM_SALAS = 3;



    private Sala[] salas;
    private String nombreCine;

    public Cine(String nombreCine){
        salas = new Sala[NUM_SALAS];
        setNombreCine(nombreCine);
    }

    public Sala[] getSalas() {
        return salas;
    }

    public Sala getSalas(int sala){
        return salas[sala];
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }
}
