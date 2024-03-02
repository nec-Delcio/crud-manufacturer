package crud.backend.services.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class ManufactureDatabaseIntegrity extends DataIntegrityViolationException {

    public ManufactureDatabaseIntegrity(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ManufactureDatabaseIntegrity(String msg, String cause) {
        super(msg);
    }
}
