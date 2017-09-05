package hello;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.FileNotFoundException;

/**
 * The {@link ExceptionHandlerAdvice} class acts as ControllerAdvice
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * This class dictates how the {@link DirectoryTraverserController} handles Exceptions
 */

@ControllerAdvice
public class ExceptionHandlerAdvice {
    final static Logger logger = Logger.getLogger(DirectoryTraverserController.class);
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity handleException(FileNotFoundException e) {
        logger.info("File was not found");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Status: "+HttpStatus.NOT_FOUND+" Could Not find the specified path");

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleException(IllegalArgumentException e) {
        logger.info("Invalid depth parameter was entered");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Status: "+HttpStatus.BAD_REQUEST+" Invalid depth parameter");

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException e) {
        logger.info("RuntimeException");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Status: "+HttpStatus.INTERNAL_SERVER_ERROR+" Something went wrong");

    }

}

