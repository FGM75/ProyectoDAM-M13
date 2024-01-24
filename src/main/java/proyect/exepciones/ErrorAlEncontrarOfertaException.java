package proyect.exepciones;

public class ErrorAlEncontrarOfertaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorAlEncontrarOfertaException(Long id) {
		super("No se encuentra oferta" + id);
	}
}
