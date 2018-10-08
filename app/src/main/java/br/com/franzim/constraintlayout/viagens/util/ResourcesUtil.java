package br.com.franzim.constraintlayout.viagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {


    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String drawable) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawable, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
