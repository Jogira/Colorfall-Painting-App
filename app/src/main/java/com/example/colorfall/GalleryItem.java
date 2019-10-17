package com.example.colorfall;
import com.mindorks.placeholderview.Animation;
import com.mindorks.placeholderview.annotations.*;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;



@Animate(Animation.CARD_LEFT_IN_DESC)
@NonReusable
@Layout(R.layout.activity_gallery)
public class GalleryItem{

    @View(R.id.imageView1)
    private ImageView imageView;

    private Drawable mDrawable;

    public GalleryItem(Drawable drawable) {

        mDrawable = drawable;
    }

    @Resolve
    private void onResolved() {

        imageView.setImageDrawable(mDrawable);
    }
}