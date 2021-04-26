package app.mo.movie;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/*
 * Credits for this class go to cyrilmottier.
 * https://cyrilmottier.com/2013/05/24/pushing-the-actionbar-to-the-next-level/
 */

public class NotifyingScrollView extends ScrollView {

    private OnScrollChangedListener mOnScrollChangedListener;

    public NotifyingScrollView(Context context) {
        super(context);
    }

    public NotifyingScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NotifyingScrollView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(t);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(int t);
    }
}
