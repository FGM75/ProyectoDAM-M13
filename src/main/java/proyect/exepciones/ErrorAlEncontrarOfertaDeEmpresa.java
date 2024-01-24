package proyect.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ErrorAlEncontrarOfertaDeEmpresa {

    @ResponseBody
    @ExceptionHandler(ErrorAlEncontrarOfertaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String companyNotFoundHandler(ErrorAlEncontrarOfertaException ex) {
        return ex.getMessage();
    }
}
