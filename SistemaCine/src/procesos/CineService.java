package procesos;

import modelos.Asiento;

public class CineService {

    public String reservarAsiento(Asiento asiento) {

        if(asiento.isOcupado()) {
            return "Asiento ocupado.";
        }

        asiento.reservar();

        return "Asiento reservado.";
    }
}