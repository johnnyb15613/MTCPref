package com.jb15613.preference.utility;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import androidx.core.content.res.ResourcesCompat;
import android.widget.ImageView;

import java.lang.ref.WeakReference;
import com.jb15613.preference.themechooser.R;

public class ImageLoader extends AsyncTask<String, Void, Drawable> {

    private final WeakReference<ImageView> mImageViewReference;
    private final Resources mResources;
    private final int mId;
    private final int mColor;

    private final int fieldData = 420;

    private PorterDuff.Mode colorMode;

    public ImageLoader(ImageView imageView, Resources r, int id, int color) {

        mImageViewReference = new WeakReference<>(imageView);
        mResources = r;
        mId = id;
        mColor = color;
    }

    @Override
    protected Drawable doInBackground(String... params) {

        if (mId == R.drawable.themechooser_shape_circle) {
            colorMode = PorterDuff.Mode.MULTIPLY;
        } else {
            colorMode = PorterDuff.Mode.SRC_IN;
        }

        return ResourcesCompat.getDrawable(mResources, mId, null);

    }

    @Override
    protected void onPostExecute(Drawable d) {

        if (isCancelled()) {
            d = null;
        }

        if (d != null) {
            final ImageView imageView = mImageViewReference.get();
            final ImageLoader imageLoader = getImageLoaderTask(imageView);
            if (this == imageLoader) {
                imageView.setImageDrawable(d);

                if (!Integer.toHexString(mColor).equals("ff000000")) {
                    imageView.setColorFilter(mColor, colorMode);
                }

            }
        }
    }

    public static class AsyncDrawable extends BitmapDrawable {

        private final WeakReference<ImageLoader> imageLoaderTaskReference;

        public AsyncDrawable(Resources res, ImageLoader imageLoader) {
            super(res);
            imageLoaderTaskReference = new WeakReference<>(imageLoader);
        }

        ImageLoader getImageLoader() {
            return imageLoaderTaskReference.get();
        }
    }

    public static boolean cancelPotentialWork(String data, ImageView imageView) {
        final ImageLoader imageLoaderTask = getImageLoaderTask(imageView);

        if (imageLoaderTask != null) {
            final int imageData = imageLoaderTask.fieldData;

            if (imageData == 0 || imageData != Integer.parseInt(data)) {

                imageLoaderTask.cancel(true);
            } else {

                return false;
            }
        }

        return true;
    }

    public static ImageLoader getImageLoaderTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getImageLoader();
            }
        }
        return null;
    }

}
