package proceso2;


public class Boleto {
	
	public String generarCodigo() {
	    int numero = (int)(Math.random() * 9000) + 1000;
	    return String.valueOf(numero);
	    }
}



