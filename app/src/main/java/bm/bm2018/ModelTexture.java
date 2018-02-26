package bm.bm2018;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


//public static Bitmap RotateBitmap(Bitmap source, float angle)
//        {
//        Matrix matrix = new Matrix();
//        matrix.postRotate(angle);
//        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
//        }
//Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmapOrg,width,height,true);
//Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);



public class ModelTexture {
    protected Bitmap image;
    protected int rows;
    protected int columns;

    public ModelTexture(Bitmap image, int rows, int columns) {
        this.image = image;
        this.columns = columns;
        this.rows = rows;
    }

    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    public int getWidth() { return image.getWidth() / columns; }
    public int getHeigth() { return image.getHeight() / rows; }


    public void draw(Canvas canvas, int variant, Vector2 position) {
        int row = variant / columns;
        int column = variant % columns;
        int width = getWidth();
        int height = getHeigth();

        int top = row * height;
        int left = column * width;
        Rect sourceRect = new Rect(left, top, left + width, top + height);

        left = position.x;
        top = position.y;
        Rect destRect = new Rect(left, top, left + width, top + height);

        canvas.drawBitmap(image, sourceRect, destRect, null);
    }
}