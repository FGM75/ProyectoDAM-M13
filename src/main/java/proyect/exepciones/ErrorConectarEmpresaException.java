package proyect.exepciones;

public class ErrorConectarEmpresaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorConectarEmpresaException(Long id1, Long id2) {

		super("La oferta con el ID" + id2 + " no pertenece a esta empresa con el ID " + id1);
		
	}
	
	

}