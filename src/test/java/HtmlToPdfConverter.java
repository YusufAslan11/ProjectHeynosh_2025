import java.io.IOException;

public class HtmlToPdfConverter {

    public static void convertHtmlToPdf(String htmlFilePath, String pdfFilePath) {
        // wkhtmltopdf komutunu ve argümanlarını ayarla
        String[] command = {
                "wkhtmltopdf",
                htmlFilePath,
                pdfFilePath
        };

        // ProcessBuilder kullanarak komutu çalıştır
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("HTML başarıyla PDF'ye dönüştürüldü: " + pdfFilePath);
            } else {
                System.err.println("Dönüştürme işlemi sırasında bir hata oluştu.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // HTML dosyasının yolu
        String htmlFilePath = "raporlar/CucumberRapor.html";

        // Çıktı PDF dosyasının yolu
        String pdfFilePath = "raporlar/output.pdf";

        // Dönüştürme işlemini başlat
        convertHtmlToPdf(htmlFilePath, pdfFilePath);
    }
}

