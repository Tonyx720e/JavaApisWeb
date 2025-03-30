package com.JavaApisWeb.code.empleado.controllers;

import com.JavaApisWeb.code.empleado.entidades.Empleado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class contollers {

    public static final List<Empleado> empleados = new ArrayList<>();

    static {
        empleados.add(new Empleado(1L,"Tony","Medina", "Programador"));
        empleados.add(new Empleado(2L,"Dylan","Parker", "FrontEnd"));
        empleados.add(new Empleado(3L,"Angelberth","Caracol", "Diseño tecnico"));
        empleados.add(new Empleado(3L,"Carlos","Fenix", "SEO"));
    }

    @GetMapping("/")
    public String home() {
        return "Esta es uan prueba";
    }

    @GetMapping("/empleados")
    public List<Empleado> empleados(){
        return empleados;
    }

    @GetMapping("/empleado/{id}")
    public Empleado getEmpleado(@PathVariable long id){
        return empleados.stream().filter(empleado -> empleado.getId() == id).findFirst().orElse(null);
    }

    @DeleteMapping("/empleado/{id}")
    public String  getDelete(@PathVariable long id){
        Empleado empleado = empleados.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (empleado != null){
            empleados.remove(empleado);
            return "Empleado eliminado correctamente";
        }else{
            return  "Empleado no encontrado";
        }
    }

    @PostMapping("/empleados")
    public String addEmpleado(@RequestBody Empleado empleado){
        Long id = empleados.stream().mapToLong(Empleado::getId).max().orElse(0) + 1;
        empleado.setId(id);
        empleados.add(empleado);
        return "empleado añadido correctamente";
    }
    @PutMapping("/empleados/{id}")
    public String updateEmpleado(@PathVariable long id, @RequestBody Empleado empleado){
        Empleado empleadoExistente = empleados.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (empleadoExistente != null){
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setPosicion(empleado.getPosicion());
            return "Empleado actualizado correctamente";
        }else{
            return "Empleado no encontrado";
        }
    }
}
