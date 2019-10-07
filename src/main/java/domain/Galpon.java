package domain;

public class Galpon extends TipoLocal {

    public Galpon(){

    }

    @Override
    public void calcularPrecio(Local unLocal){
        unLocal.setPrecio(unLocal.getPrecio() / 2 );
    }

    @Override
    public void remodelar(Local unLocal){
        unLocal.setTipoLocal(new LocalALaCalle());
    }

}
