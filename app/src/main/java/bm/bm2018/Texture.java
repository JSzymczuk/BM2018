package bm.bm2018;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Texture {
    private Bitmap image;

    public Texture(Bitmap image) {
        this.image = image;
    }

    public void draw(Canvas canvas) {
        //Resources.getSystem().getDisplayMetrics().widthPixels;
        canvas.drawBitmap(image, 50, 50, null);
    }
}
