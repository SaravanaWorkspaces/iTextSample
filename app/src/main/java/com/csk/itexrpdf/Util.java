package com.csk.itexrpdf;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

import java.io.File;

/**
 * Comments
 */
public class Util {

    public static Font FONT_MODEL_NAME = new Font(Font.FontFamily.TIMES_ROMAN, 32.0f, Font.BOLD, BaseColor.BLACK);


    private static String DIR_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    /**
     * Creates a file with PDF extension.
     *
     * @return created a file.
     */
    public static File createNewPDF() {
        String PDF_EXTENSION = ".pdf";
        File dirPath = new File(DIR_PATH);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
        File file = new File(dirPath, "sample" + PDF_EXTENSION);
        return file;
    }


    public static void launchCreateFile(Context context){
        File file = createNewPDF();
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file),"application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open File");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {}
    }
}
