package domain;

public class Departamento extends Inmueble {

    public Departamento(int metrosCuadrados, int cantidadAmbientes){
        super(metrosCuadrados,cantidadAmbientes);
    }

    @Override
    public void calcularPrecio(){
        this.precio = plus() + this.cantidadAmbientes * 350000;
    }
}