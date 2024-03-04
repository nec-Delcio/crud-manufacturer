package crud.backend.services.exceptions;

public class ManufactureNotFoundException extends RuntimeException {

    public ManufactureNotFoundException(String msg){
        super(msg);
    }

}
