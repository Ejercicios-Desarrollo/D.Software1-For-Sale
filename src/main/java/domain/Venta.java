package domain;

public class Venta extends Operacion{
    private static double porcentaje = 1.5;

    public Venta(){
        super();
    }

    @Override
    public double calcularComision(){
        return this.getInmueble().precio * porcentaje/100;
    }
}
