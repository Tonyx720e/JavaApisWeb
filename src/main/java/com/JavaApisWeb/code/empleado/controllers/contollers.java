package com.JavaApisWeb.code.empleado.controllers;

import com.JavaApisWeb.code.empleado.entidades.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class contollers {

    public static final List<Empleado> empleados = new ArrayList<>();

    static {
        empleados.add(new Empleado(1L,"Tony","Medina", "Programador"));
        empleados.add(new Empleado(2L,"Dylan","Parker", "FrontEnd"));
        empleados.add(new Empleado(3L,"Angelberth","Caracol", "Diseño Grafico"));
    }

    @GetMapping("/")
    public String home() {
        return "Esta es uan prueba";
    }

    @GetMapping("/empleados")
    public List<Empleado> empleados(){
        return empleados;

    }
}
