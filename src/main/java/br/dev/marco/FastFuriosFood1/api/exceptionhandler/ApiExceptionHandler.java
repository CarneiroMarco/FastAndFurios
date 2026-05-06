
package br.dev.marco.FastFuriosFood1.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request) {

    ProblemaException problema = new ProblemaException();
    problema.setStatus(status.value());
    problema.setTitulo("Um ou mais campos estão inválidos. Corrija e tente novamente.");
    problema.setDataHora(LocalDateTime.now());
    
    List<ProblemaException.CampoProblema> camposComErro = new ArrayList<>();

for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
    String nomeCampo = ((FieldError) erro).getField();
    String mensagem = erro.getDefaultMessage();

    ProblemaException.CampoProblema campoProblema =
            new ProblemaException.CampoProblema(nomeCampo, mensagem);

    camposComErro.add(campoProblema);
}

problema.setCampos(camposComErro);

    return handleExceptionInternal(ex, problema, headers, status, request);
}
}
