package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

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

    public List<Mascota> traerMascotas() {

        return controladoraPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        
        //Pasamos a la persistencia el número de cliente a buscar para eliminar esa mascota
        controladoraPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascotas(int num_cliente) {
        //Traemos los datos de la mascota a eliminar
        return controladoraPersis.traerMascota(num_cliente);

    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String duenio, String movil,
            String observa, String alergico, String atEsp) {

        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observa);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEsp);

        //modificamos la mascota
        controladoraPersis.modificarMascota(masco);

        //nuevos valores del dueño
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setNombre(duenio);
        dueno.setMovil(movil);
        
        //Se llama al metodo modificar Dueño
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controladoraPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controladoraPersis.modificarDuenio(dueno);
    }

}
