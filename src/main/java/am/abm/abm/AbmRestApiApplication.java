package am.abm.abm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbmRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbmRestApiApplication.class, args);
    }

    //Java HotSpot(TM) 64-Bit Server VM warning: Options -Xverify:none and -noverify were deprecated in JDK 13 and will likely be removed in a future release.
    //Error: Could not find or load main class com.abm.abmrest.AbmRestCloneApplication
    //Caused by: java.lang.ClassNotFoundException: com.abm.abmrest.AbmRestCloneApplication
}

