package tgits.baseconverter.base64;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.nio.charset.Charset;
import java.util.Base64;

@ShellComponent
public class Base64EncodingCommands {

    @ShellMethod(value = "Encode the provided string to Base 64.", key= {"to-base64, toBase64, to-b64, toB64"})
    public String toBase64(String toEncodeString) {
        return Base64.getEncoder().encodeToString(toEncodeString.getBytes(Charset.defaultCharset()));
    }

    @ShellMethod(value = "Decode from Base 64 the provided string.", key= {"from-base64, from-Base64, from-b64, fromB64"})
    public String fromBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes, Charset.defaultCharset());
    }
}
