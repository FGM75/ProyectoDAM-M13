package proyect.exepciones;

public class ErrorConectarEmpresaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorConectarEmpresaException(Long idC, Long idO) {

		super("La oferta con el ID" + idO + " no pertenece a esta empresa con el ID " + idC);
		
	}
	
	

}