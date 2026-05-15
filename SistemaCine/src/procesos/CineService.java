package procesos;

import java.util.ArrayList;
import modelos.Asiento;
import modelos.Funcion;

public class CineService {
	
	private ArrayList<Funcion> funciones = new ArrayList<>();
    
	public String reservarAsiento(Asiento asiento) {

        if(asiento.isOcupado()) {
            return "Asiento ocupado.";
        }

        asiento.reservar();

        return "Asiento reservado.";
    }
    
	// -------- FUNCIONES --------

    // ✔ AHORA VALIDANDO HORARIO
    public String registrarFuncion(Funcion funcion) {

        if (!funcion.horarioValido()) {
            return "Horario inválido";
        }

        funciones.add(funcion);
        return "Función registrada correctamente";
    }

    // -------- LISTAR FUNCIONES --------

    public void listarFunciones() {

        System.out.println("=== FUNCIONES ===");

        for (Funcion f : funciones) {
            System.out.println(f);
        }
    }
}