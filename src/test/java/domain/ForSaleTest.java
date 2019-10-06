package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.zip.DeflaterOutputStream;

public class ForSaleTest {
    private Zona urquiza;
    private Zona belgrano;
    private Zona almagro;
    private Zona caballito;
    private Zona devoto;
    private Zona retiro;
    private Zona palermo;

    private Casa casa_urquiza;
    private Casa casa_belgrano;
    private Casa casa_caballito;
    private Casa casa_devoto;

    private Departamento depto_urquiza;
    private Departamento depto_belgrano;
    private Departamento depto_caballito;
    private Departamento depto_almagro;
    private Departamento depto_retiro;

    private PH ph_urquiza;
    private PH ph_belgrano;
    private PH ph_caballito;

    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;

    private Cliente cliente1;
    private Cliente cliente2;
    private Cliente cliente3;
    private Cliente cliente4;
    private Cliente cliente5;
    private Cliente cliente6;

    private Venta venta_casa_urquiza;
    private Venta venta_casa_belgrano;
    private Venta venta_casa_caballito;
    private Venta venta_casa_devoto;
    private Venta venta_depto_belgrano;
    private Venta venta_depto_retiro;
    private Venta venta_ph_caballito;

    private Alquiler alquiler_depto_urquiza;
    private Alquiler alquiler_depto_caballito;
    private Alquiler alquiler_depto_almagro;
    private Alquiler alquiler_ph_urquiza;
    private Alquiler alquiler_ph_belgrano;

    private Empleados listaEmpleados;

    @Before
    public void init(){
        //Zonas
        this.urquiza = new Zona(15000, "Urquiza");
        this.belgrano = new Zona(20000, "Belgrano");
        this.almagro = new Zona(8000, "Almagro");
        this.caballito = new Zona(15000, "Caballito");
        this.devoto = new Zona(20000, "Devoto");
        this.retiro = new Zona(15000, "Retiro");
        this.palermo = new Zona(18000, "Palermo");

        //Casas
        this.casa_urquiza = new Casa(250, 5, urquiza, 400000);
        this.casa_belgrano = new Casa(200, 5, belgrano, 550000);
        this.casa_caballito = new Casa(250, 5, caballito, 350000);
        this.casa_devoto = new Casa(200, 5, devoto, 450000);

        //Departamentos
        this.depto_urquiza = new Departamento(90, 3, urquiza);
        this.depto_belgrano = new Departamento(120, 4, belgrano);
        this.depto_caballito = new Departamento(100, 3, caballito);
        this.depto_almagro = new Departamento(80, 2, almagro);
        this.depto_retiro = new Departamento(100, 3, retiro);

        //PHs
        this.ph_urquiza = new PH(90, 3, urquiza);
        this.ph_belgrano = new PH(120, 3, belgrano);
        this.ph_caballito = new PH(140, 4, caballito);

        //Empleados
        this.empleado1 = new Empleado("Juan");
        this.empleado2 = new Empleado("Carla");
        this.empleado3 = new Empleado("Diego");

        this.listaEmpleados = new Empleados();
        this.listaEmpleados.agregarEmpleado(empleado1);
        this.listaEmpleados.agregarEmpleado(empleado2);
        this.listaEmpleados.agregarEmpleado(empleado3);

        //Clientes
        this.cliente1 = new Cliente("Tomas");
        this.cliente2 = new Cliente("Federico");
        this.cliente3 = new Cliente("Romina");
        this.cliente4 = new Cliente("Andrea");
        this.cliente5 = new Cliente("Alejandro");
        this.cliente6 = new Cliente("Paula");

        //Pendiente: hayProblemasCon(Empleado unEmpleado, Zona unaZona)
        //Pendiente: Que operacion guarde dos Empleados, el que reservó y el que concretó.

        //Set de Operaciones
        this.venta_casa_urquiza = new Venta();
        this.venta_casa_belgrano = new Venta();
        this.venta_casa_caballito = new Venta();
        this.venta_casa_devoto = new Venta();
        this.venta_depto_belgrano = new Venta();
        this.venta_depto_retiro = new Venta();
        this.venta_ph_caballito = new Venta();

        this.alquiler_depto_urquiza = new Alquiler(12);
        this.alquiler_depto_almagro = new Alquiler(18);
        this.alquiler_depto_caballito = new Alquiler(24);
        this.alquiler_ph_urquiza = new Alquiler(24);
        this.alquiler_ph_belgrano = new Alquiler(18);

        //Asignacion de Operaciones
        this.casa_urquiza.setOperacion(venta_casa_urquiza);
        this.casa_belgrano.setOperacion(venta_casa_belgrano);
        this.casa_caballito.setOperacion(venta_casa_caballito);
        this.casa_devoto.setOperacion(venta_casa_devoto);
        this.depto_belgrano.setOperacion(venta_depto_belgrano);
        this.depto_retiro.setOperacion(venta_depto_retiro);
        this.ph_caballito.setOperacion(venta_ph_caballito);

        this.depto_urquiza.setOperacion(alquiler_depto_urquiza);
        this.depto_almagro.setOperacion(alquiler_depto_almagro);
        this.depto_caballito.setOperacion(alquiler_depto_caballito);
        this.ph_urquiza.setOperacion(alquiler_ph_urquiza);
        this.ph_belgrano.setOperacion(alquiler_ph_belgrano);
    }

    //Test Ejercicio 1
    @Test
    public void comisionDeOperacionConcretadaTest(){
        cliente1.concretarOperacion(empleado1, casa_belgrano);
        Assert.assertEquals(8550, empleado1.getComisiones(), 0);
        cliente2.concretarOperacion(empleado2, depto_almagro);
        Assert.assertEquals(254.88, empleado2.getComisiones(), 0);
        cliente6.concretarOperacion(empleado3, ph_caballito);
        Assert.assertEquals(37125, empleado3.getComisiones(), 0);
    }

    @Test
    public void mejoresEmpleadosTest(){
        cliente1.solicitarReserva(empleado1, depto_almagro);
        cliente2.concretarOperacion(empleado1, ph_caballito);
        cliente3.concretarOperacion(empleado1, depto_almagro);

        cliente4.solicitarReserva(empleado2, depto_urquiza);
        cliente4.solicitarReserva(empleado2, depto_almagro);
        cliente6.solicitarReserva(empleado2, depto_caballito);


        cliente5.concretarOperacion(empleado3, ph_urquiza);
        cliente5.concretarOperacion(empleado3, ph_belgrano);
        cliente4.concretarOperacion(empleado3, depto_urquiza);
        cliente4.concretarOperacion(empleado3, depto_almagro);
        cliente4.concretarOperacion(empleado3, depto_caballito);

        Assert.assertEquals(empleado1, listaEmpleados.mejorEmpleadoSegunComisiones());
        Assert.assertEquals(empleado2, listaEmpleados.mejorEmpleadoSegunCantidadReservas());
        Assert.assertEquals(empleado3, listaEmpleados.mejorEmpleadoSegunOperacionesCerradas());
    }


    @Test
    public void empleadoTieneProblemasConOtroTest(){
        cliente1.solicitarReserva(empleado1, casa_belgrano);
        cliente1.concretarOperacion(empleado2, casa_belgrano);
        Assert.assertEquals(true, empleado1.hayProblemasCon(empleado2));

        cliente6.solicitarReserva(empleado2, depto_urquiza);
        cliente6.concretarOperacion(empleado2, depto_urquiza);
        cliente6.concretarOperacion(empleado3, depto_caballito);
        Assert.assertEquals(false, empleado2.hayProblemasCon(empleado3));
    }
}
