package shopapplication.project.exceptions;

public class BoutiqueNotFoundException extends RuntimeException {

    public BoutiqueNotFoundException(String message) {
        super(message);
    }
}