package bm.bm2018;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private  MainThread thread;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    ModelTexture texture;
    private void loadResources() {
        texture = new ModelTexture(BitmapFactory.decodeResource(getResources(), R.drawable.hair), 5, 6);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        loadResources();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (canvas != null) {
            texture.draw(canvas, 8, new Vector2(100,100));
        }
    }

    public void update() {}
}
