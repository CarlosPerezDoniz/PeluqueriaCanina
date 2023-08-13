package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;

/**
 *
 * @author Carlos David Pérez Dóniz
 */
public class Controladora {
    
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String duenio, String movil, String observa, String alergico, String atEsp) {

        //Creamos dueño y asignamos valores
        Duenio dueno = new Duenio();
        dueno.setNombre(duenio);
        dueno.setMovil(movil);
        
        //Creamos la mascota y asignamos valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEsp);
        mascota.setObservaciones(observa);
        mascota.setUnDuenio(dueno);
        
        
        controladoraPersis.guardar(dueno, mascota);
    }

  
    
}
