package proyect.exepciones;

public class NoSeEncuentraOfertaException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public NoSeEncuentraOfertaException(Long id) {
		super("La oferta no se encuentra " + id);
	}

}
