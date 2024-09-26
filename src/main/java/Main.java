import QRCode.QRCodeGenerator;

public class Main {
    public static void main(String[] args) {
        // Provide the input to generate QR Code
        String text = "Hello, this is a QR content example";
        int width = 300;
        int height = 300;
        String filePath = "QRCode.png";

        // Generate the QR Code
        QRCodeGenerator.generateQRCodeImage(text, width, height, filePath);
    }
}