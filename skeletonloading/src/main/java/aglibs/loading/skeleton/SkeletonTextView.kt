package aglibs.loading.skeleton

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class SkeletonTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr), ISkeletonDrawer {

    private var skeletonDrawer: SkeletonDrawer = SkeletonDrawer(this).apply {
        getStyles(attrs, defStyleAttr)
    }

    override fun isLoading() = skeletonDrawer.isLoading()

    override fun startLoading() {
        skeletonDrawer.startLoading()
    }

    override fun stopLoading() {
        skeletonDrawer.stopLoading()
    }

    override fun onDraw(canvas: Canvas?) {
        if (isLoading() && canvas != null) {
            skeletonDrawer.draw(canvas)
        } else {
            super.onDraw(canvas)
        }
    }

    override fun onDetachedFromWindow() {
        stopLoading()
        super.onDetachedFromWindow()
    }

}
