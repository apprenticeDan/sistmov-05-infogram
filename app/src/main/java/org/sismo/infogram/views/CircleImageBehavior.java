package org.sismo.infogram.views;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class CircleImageBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

/*    private float initialY;
    private float initialX;*/

    public CircleImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // Called when the behavior is attached to a view.
   /* @Override
    public boolean onLayoutChild(CoordinatorLayout parent, CircleImageView child, int layoutDirection) {
        // Save the initial position of the view for reference.
        if (initialY == 0) {
            initialY = child.getY();
            initialX = child.getX();
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }*/

    // Indicates which view this behavior depends on for its movement.
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        // The CircleImageView depends on the AppBarLayout's movement.
        return dependency instanceof AppBarLayout;
    }

    // This is the core logic. It is called every time the AppBarLayout scrolls.
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        AppBarLayout appBarLayout = (AppBarLayout) dependency;
        int scrollRange = appBarLayout.getTotalScrollRange();
        float percentage = (scrollRange - appBarLayout.getY())/(float) scrollRange;
        float scaleFactor = 1-percentage;
        int margin = (int) (percentage * 100);

        child.setScaleX(scaleFactor);
        child.setScaleY(scaleFactor);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        params.topMargin = margin;
        params.leftMargin = margin;

        child.requestLayout();

        // Calculate the scroll progress from 0.0 (fully expanded) to 1.0 (fully collapsed).
        /*float totalScrollRange = appBarLayout.getTotalScrollRange();
        float scrollOffset = appBarLayout.getY();
        float progress = (-scrollOffset) / totalScrollRange;

        // Scale the image down as it scrolls.
        float scale = 1.0f - 0.5f * progress;
        child.setScaleX(scale);
        child.setScaleY(scale);

        // Move the image up and towards the center.
        float targetX = (parent.getWidth() / 2.0f) - (child.getWidth() / 2.0f);
        float targetY = initialY + scrollOffset;
        child.setX(initialX + (targetX - initialX) * progress);
        child.setY(targetY);*/

        return true;
    }
}
