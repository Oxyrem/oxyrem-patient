package com.oxyrem.patient.gui.libs;

import android.app.Activity;
import android.graphics.Typeface;

/**
 * Utility for font management.
 *
 * @author Patrick Reid
 */
public class FontLibrary {

    public static final String OPEN_SANS = "fonts/open_sans/open_sans_regular.ttf";
    public static final String OPEN_SANS_LIGHT = "fonts/open_sans/open_sans_light.ttf";
    public static final String ROBOTO = "fonts/roboto/roboto_regular.ttf";
    public static final String ROBOTO_LIGHT = "fonts/roboto/roboto_light.ttf";
    public static final String ROBOTO_LIGHT_ITALIC = "fonts/roboto/roboto_light_italic.ttf";

    private Activity activity;

    /**
     * @param Activity
     */
    public FontLibrary(Activity activity) {
        this.activity = activity;
    }

    /**
     * @param activity An instance of the calling Activity, usually found by "this"
     * @param font String name of font, as are defined in com.utechsapna.sconnections.gui.libs.Font.
     * @return Usable instance of requested font.
     */
    public Typeface getFont(String font){
        return (Typeface) Typeface.createFromAsset(this.activity.getAssets(), font);
    }
}
