package domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Empleados {
    private List<Empleado> empleados;

    public Empleados(){
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado unEmpleado){
        this.empleados.add(unEmpleado);
    }

    public Empleado mejorEmpleadoSegunComisiones(){
        return Collections.max(empleados, Comparator.comparing(e -> e.getComisiones()));
    }

    public Empleado mejorEmpleadoSegunOperacionesCerradas(){
        return Collections.max(empleados, Comparator.comparing(e -> e.getOperacionesConcretadas()));
    }

    public Empleado mejorEmpleadoSegunCantidadReservas(){
        return Collections.max(empleados, Comparator.comparing(e -> e.getCantidadReservas()));
    }
}
