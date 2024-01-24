package proyect.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class NoSeEncuentraOferta {

    @ResponseBody
    @ExceptionHandler(NoSeEncuentraOfertaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String offerNotFoundHandler(NoSeEncuentraOfertaException ex) {
        return ex.getMessage();
    }
}
