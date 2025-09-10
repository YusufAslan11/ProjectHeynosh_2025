package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                // Adapter’i burada sabit tut – mutlaka yüklensin
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        //tags = "@reservation_Make",
        //tags = "@registerNegative",
        //tags= "@searchRestaurant",
        //tags= "@searchFood",
        //tags ="@loginPositive",
        //tags= "@loginNegative",
        //tags="@registerP",
        tags= "@guestReservation",
        //tags= "@reservation_Cancel",
        dryRun = false
)
public class Runner {

    // Sınıf yüklenirken çalışır; Cucumber pluginleri başlatılmadan ÖNCE property set edilir.
    static {
        String ts = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

        // Cucumber çıktıları: her koşuda BENZERSİZ dosya isimleri
        System.setProperty(PLUGIN_PROPERTY_NAME, String.join(",",
                "pretty",
                "html:target/cucumber-reports/cucumber-" + ts + ".html",
                "json:target/json-reports/cucumber-" + ts + ".json",
                "junit:target/xml-report/cucumber-" + ts + ".xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        ));

        // Extent: extent.properties olmasa bile rapor üretecek “güvenlik kemeri”
        System.setProperty("basefolder.name", "target/extent/Run_");
        System.setProperty("basefolder.datetimepattern", "yyyyMMdd-HHmmss");
        System.setProperty("extent.reporter.spark.start", "true");
        System.setProperty("extent.reporter.spark.offline", "true");
        System.setProperty("extent.reporter.spark.out", "Spark.html"); // klasör içinde sabit ad
        System.setProperty("extent.reporter.pdf.start", "true");
        System.setProperty("extent.reporter.pdf.out", "Report.pdf");
        System.setProperty("screenshot.dir", "./screenshots");
        System.setProperty("screenshot.rel.path", "./screenshots/");
    }
}





//
//
//package runners;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME; // Cucumber 7
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        // Adapter'i BURADA sabitle -> çalıştığı garanti olsun
//        plugin = {
//                "pretty",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//        },
//        monochrome = true,
//        features = "src/test/resources/features",
//        glue = "stepdefinitions",
//        tags = "@searchRestaurant",
//        dryRun = false
//)
//public class Runner {
//
//    @BeforeClass
//    public static void setupReportNames() {
//        String ts = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
//
//        // Cucumber'ın kendi HTML/JSON/XML çıktıları timestamp'li olsun
//        System.setProperty(PLUGIN_PROPERTY_NAME, String.join(",",
//                "pretty",
//                "html:target/cucumber-reports/cucumber-" + ts + ".html",
//                "json:target/json-reports/cucumber-" + ts + ".json",
//                "junit:target/xml-report/cucumber-" + ts + ".xml"
//                // NOT: Adapter'i burada tekrar eklemiyoruz; zaten annotation'da var
//        ));
//
//        // Extent'i programatik olarak da ayarla (extent.properties olmasa bile yazsın)
//        System.setProperty("extent.reporter.spark.start", "true");
//        System.setProperty("extent.reporter.spark.offline", "true");
//        System.setProperty("extent.reporter.spark.out", "target/extent/Spark_" + ts + ".html");
//        System.setProperty("screenshot.dir", "target/extent/screenshots");
//        System.setProperty("screenshot.rel.path", "./screenshots/");
//    }
//}
