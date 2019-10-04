package domain;

public class Alquiler extends Operacion{
    private int cantidadMeses;

    public Alquiler(int cantidadMeses){
        super();
        this.cantidadMeses = cantidadMeses;
    }

    @Override
    public double calcularComision(){
        return this.getInmueble().precio * cantidadMeses / 50000;
    }
}