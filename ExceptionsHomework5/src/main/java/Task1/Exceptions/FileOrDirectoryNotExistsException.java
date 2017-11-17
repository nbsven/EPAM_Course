package Task1.Exceptions;

public class FileOrDirectoryNotExistsException extends Exception{
    public FileOrDirectoryNotExistsException() {
    }

    public FileOrDirectoryNotExistsException(String message) {
        super(message);
    }

    public FileOrDirectoryNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileOrDirectoryNotExistsException(Throwable cause) {
        super(cause);
    }

    public FileOrDirectoryNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
