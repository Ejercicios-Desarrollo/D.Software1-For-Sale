package domain;

public class LocalALaCalle extends TipoLocal {
    private static double montoFijo = 25000;

    public LocalALaCalle(){

    }

    @Override
    public void calcularPrecio(Local unLocal){
        unLocal.setPrecio(unLocal.getPrecio() + montoFijo);
    }

    @Override
    public void remodelar(Local unLocal){
        unLocal.setTipoLocal(new Galpon());
    }

}
