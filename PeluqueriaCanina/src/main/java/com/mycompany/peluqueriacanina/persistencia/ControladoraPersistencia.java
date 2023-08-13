package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;

/**
 *
 * @author Carlos David Pérez Dóniz
 */
public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio dueno, Mascota mascota) {

        //crear en la BD el dueño
        duenioJpa.create(dueno);
        
        //crear en la BD la mascota
        mascotaJpa.create(mascota);

    }
    
}
