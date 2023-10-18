package orderapp.orderapp.tools;

import org.springframework.core.env.Environment;

import java.net.UnknownHostException;
import java.util.Random;

    public class Utils {
        public String baseUrl(Environment environment) throws UnknownHostException {
    //        return "http://"+InetAddress.getLocalHost().getHostAddress()+":"+environment.getProperty("local.server.port");
            return "localhost:8080";
        }

    public String generateRandomString(Integer stringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = stringLength;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}
