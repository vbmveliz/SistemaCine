package modelos;

import java.time.LocalDate;

/* 
 * Autor: Juilliand Damian Gomez
 */
public class Director extends Persona {

    private String especialidad;

    public Director(int idPersona,
                    String nombres,
                    String apePaterno,
                    String apeMaterno,
                    String nombreLargo,
                    LocalDate fechaNacimiento,
                    String nacionalidad,
                    String especialidad) {

        super(idPersona,
              nombres,
              apePaterno,
              apeMaterno,
              nombreLargo,
              fechaNacimiento,
              nacionalidad);

        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}