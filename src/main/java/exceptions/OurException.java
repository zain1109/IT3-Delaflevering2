package exceptions;

package exceptions;

public class OurException extends Exception {

    @Override
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    String Message ="Error 420";

}
//Klassen overskriver getMessage() metoden fra Exception-klasse, som returnerer en streng, der beskriver fejlen, der opstod.
//Klassen har også en setMessage() metode til at indstille fejlmeddelelsen, og en standard fejlmeddelelse er defineret i klassen som strengen "Error 420".