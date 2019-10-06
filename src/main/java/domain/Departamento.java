package domain;

public class Departamento extends Inmueble {

    public Departamento(int metrosCuadrados, int cantidadAmbientes, Zona zona){
        super(metrosCuadrados,cantidadAmbientes, zona);
    }

    @Override
    protected void calcularPrecio(){
        this.precio = plus() + this.cantidadAmbientes * 350000;
    }
}