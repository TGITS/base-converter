package tgits.baseconverter.base64;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.nio.charset.Charset;
import java.util.Base64;

@ShellComponent
public class Base64ConversionCommands {

    private Base64.Encoder encoder;
    private Base64.Decoder decoder;
    private Charset selectedCharset = Charset.defaultCharset();

    @ShellMethod(value = "Encode the provided string to Base 64.", key = {"to-base64", "toBase64", "to-b64", "toB64"})
    public String toBase64(String toEncodeString) {
        byte[] encodedBytesArray = Base64.getEncoder().encode(toEncodeString.getBytes(selectedCharset));
        return new String(encodedBytesArray,selectedCharset);
    }

    @ShellMethod(value = "Decode from Base 64 the provided string.", key = {"from-base64", "from-Base64", "from-b64", "fromB64"})
    public String fromBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes, selectedCharset);
    }
}
