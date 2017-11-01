package com.csk.itexrpdf;

import com.itextpdf.text.Document;

/**
 * Comments
 */
public class CreateCoverPage {

    private String MODEL_IMAGE = "https://gotourhd.com/avid/madison/images/model_fb.png";
    private String MODEL_LOGO = "https://gotourhd.com/veridian/images/logo.png";


    private Document mDocument;

    public CreateCoverPage(Document document) {
        mDocument = document;
    }

    public void create() {}
}
