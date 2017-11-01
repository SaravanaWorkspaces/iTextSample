package com.csk.itexrpdf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Document mDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDocument();
        new CreateCoverPage(mDocument).create();
        closePDF();
    }

    private void createDocument() {
        mDocument = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(mDocument, new FileOutputStream(Util.createNewPDF()));
            mDocument.open();
            writeSampleText();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeSampleText() {
        try {
            Paragraph paragraph = new Paragraph("<HTML><BODY>HEY</BODY></HTML>", Util.FONT_MODEL_NAME);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            mDocument.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private void closePDF() {
        if (mDocument == null) {
            Log.d(TAG, "mDocument is null.");
            return;
        }
        mDocument.close();
        Util.launchCreateFile(this);
        finish();
    }
}
