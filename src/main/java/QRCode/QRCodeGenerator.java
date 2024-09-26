package QRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator {
    public static void generateQRCodeImage(String text, int width, int height, String filePath) {
        try {
            // Create the QR Code Writer
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Define the encoding parameters for the QR Code
            Map<EncodeHintType, Object> hintMap = new HashMap<>();
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Generate the BitMatrix representing the QR Code
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hintMap);

            // Specify the file path where the QR Code will be saved
            Path path = FileSystems.getDefault().getPath(filePath);

            // Write the BitMatrix as an image to the file path
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("QR Code generated and saved to: " + filePath);
    }

}
