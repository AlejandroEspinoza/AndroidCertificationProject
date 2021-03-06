package training.itexico.com.androidcertificationproject.CustomViews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import training.itexico.com.androidcertificationproject.Models.Fugitive
import training.itexico.com.androidcertificationproject.R

class FugitiveView : ViewGroup {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var avatar : CircleImageView
    var caught : ImageView
    var name : TextView

    var fugitivo : Fugitive? = null
        set(value) {
            value?.let { fugitive ->
                field = fugitive
                avatar.fugitivo = fugitivo
                }
            }

    init {
        context?.let { context ->
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.fugitive_view, this, true)
        }

        avatar = getChildAt(0) as CircleImageView
        caught = getChildAt(1) as ImageView
        name = getChildAt(2) as TextView
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChild(avatar, widthMeasureSpec, heightMeasureSpec)
        measureChild(name, widthMeasureSpec, heightMeasureSpec)

        val widthCaughtSpec = MeasureSpec.makeMeasureSpec(
                (MeasureSpec.getSize(widthMeasureSpec) / 4),
                MeasureSpec.EXACTLY)
        val heightCaughtSpec = MeasureSpec.makeMeasureSpec(
                (MeasureSpec.getSize(heightMeasureSpec) / 4),
                MeasureSpec.EXACTLY)
        measureChild(caught, widthCaughtSpec, heightCaughtSpec)

        var widthSize = Math.max(Math.max(caught.measuredWidth, avatar.measuredWidth), name.measuredWidth)
        var heightSize = avatar.measuredHeight + name.measuredHeight

        val widthMeasureSpec = MeasureSpec.makeMeasureSpec( widthSize, MeasureSpec.EXACTLY );
        val heightMeasureSpec = MeasureSpec.makeMeasureSpec( heightSize, MeasureSpec.EXACTLY);

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        avatar.layout(left, top, right, bottom)

        val nameTop = bottom - name.measuredHeight
        name.layout(left, nameTop, right, bottom)

        val caugtLeft = Math.abs(right - left) - caught.measuredWidth
        val caughtRight = caugtLeft + caught.measuredWidth
        val caughtBottom = top + caught.measuredHeight
        caught.layout(caugtLeft, top, caughtRight, caughtBottom)
    }
}