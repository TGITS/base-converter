package tgits.baseconverter.integer;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellCommandGroup("Hexadecimal conversion commands")
@ShellComponent
public class HexadecimalConversionCommands {

    @ShellMethod(value = "Convert the provided integer to hexadecimal", key= {"to-hexadecimal", "toHexadecimal", "to-hex", "toHex"})
    public String toHexadecimal(String i, String r){
        String conversionOrErrorMessage;
        int radix = 10;
        try {
             radix = Integer.parseInt(r,10);
        } catch(NumberFormatException nfe) {
            conversionOrErrorMessage = "The provided radix is not valid";
        }

        try {
            int readInteger = Integer.parseInt(i,radix);
            conversionOrErrorMessage = Integer.toHexString(readInteger);
        }
        catch(NumberFormatException nfe) {
            conversionOrErrorMessage = "Conversion to hexadecimal not possible : you must provide a valid integer";
        }
        return conversionOrErrorMessage;
    }
}
