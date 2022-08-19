package tgits.baseconverter.base64;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.nio.charset.Charset;
import java.util.Base64;

@ShellComponent
public class Base64Commands {

    @ShellMethod("Encode a string to Base 64")
    public String toBase64(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(Charset.defaultCharset()));
    }

    @ShellMethod("Decode a string from Base 64")
    public String fromBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes, Charset.defaultCharset());
    }
}
