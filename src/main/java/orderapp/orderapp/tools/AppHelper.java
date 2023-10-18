package orderapp.orderapp.tools;

import java.time.LocalDateTime;

public class AppHelper {
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    public String slugify(String words){
        return words.replaceAll("\\p{Punct}", " ").replace(" ","-").toLowerCase().trim();
    }


}
