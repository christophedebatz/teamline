package tech.btzstudio.teamline.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundHttpException extends ResponseStatusException {

    public NotFoundHttpException (String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }

}
