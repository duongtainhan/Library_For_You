package android.dienty.library_for_you.ImageProcessing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.util.AttributeSet;
import android.util.Log;

import java.io.IOException;

public class CustomImageView extends android.support.v7.widget.AppCompatImageView {
    private int rotate=0;

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    public void setBackgroundRotate(String path){

        Bitmap bitmapOrg = BitmapFactory.decodeFile(path);
        Matrix matrix = new Matrix();

        matrix.postRotate(getRotate(path));

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmapOrg, getWidth(), getHeight(), true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        setImageBitmap(rotatedBitmap);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    public int getRotate(String path) {
        ExifInterface exif = null;
        int rotation =0;
        try {
            exif = new ExifInterface(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        if (orientation == 6) {
            rotation=90;
        }
        else if (orientation == 3) {
            rotation=180;
        }
        else if (orientation == 8) {
            rotation=270;
        }
        return rotation;
    }
}
