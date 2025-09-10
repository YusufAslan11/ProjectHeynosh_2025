package appiumserver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {

    static AppiumDriverLocalService server;
    static String mainJSpath = "C:/Users/yusuf/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";

    public static void start() {
        /* appium server manuel olarak başlatılmadıysa bu yapı appiumserver i otomatik çalıştırmak için kullanıyoruz */
        /*Bu methodu Hook classı içerisinde kullanabiliriz */

        if (server == null) {
            AppiumServiceBuilder service = new AppiumServiceBuilder();
            service.withIPAddress("127.0.0.1")
                    .usingPort(4725)
                    .withAppiumJS(new File(mainJSpath))
                    .usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"));


            server = AppiumDriverLocalService.buildService(service);
            server.start();
        }
    }

    public static void stop() {
        if (server.isRunning()) {
            server.stop();
        }
    }

}
