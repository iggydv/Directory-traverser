package hello;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * The {@link DirectoryTraverserController} acts as a Controller for the {@link DirectoryTraverser}:
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Exposes a RESTful interface on port: 8080
 *
 * Requests two parameters from the user 'path' and 'depth'
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * String path: the starting directory for the {@link DirectoryTraverser}
 * Integer depth: the Maximum depth that the {@link DirectoryTraverser} object is allowed to traverse
 *
 * Exception Handling
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Handling of all exception are done by the {@link ExceptionHandlerAdvice} class
 */

@RestController
public class DirectoryTraverserController
{
    final static Logger logger = Logger.getLogger(DirectoryTraverserController.class);

    private static ObjectMapper MAPPER = new ObjectMapper();
    List<FileAttributes> list = null;
    private String output = null;


    @RequestMapping("/traverse_directory")
    public ResponseEntity traverse_directory(@RequestParam(value = "path", defaultValue = ".") String path, @RequestParam(value = "depth", defaultValue = "10") Integer depth ) throws IOException {

        logger.info("==== in traverse-directory ====");
        logger.info("Requested path: " + path);
        logger.info("Requested depth: " + depth);

        DirectoryTraverser traverser = new DirectoryTraverser();

        list = traverser.traverseDirectory(path, depth);
        output = MAPPER.writeValueAsString(list);

        logger.info("EVERYTHING IS OK");

        return ResponseEntity.ok(output);
    }

}

