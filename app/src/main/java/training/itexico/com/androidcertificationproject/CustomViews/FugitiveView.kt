package training.itexico.com.androidcertificationproject.CustomViews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import training.itexico.com.androidcertificationproject.Models.Fugitive
import training.itexico.com.androidcertificationproject.R
import android.R.attr.maxHeight
import android.R.attr.maxWidth



class FugitiveView : ViewGroup {

    private val avatar : CircleImageView
    private val caught : ImageView
    private val name : TextView

    var fugitive : Fugitive? = null
        set(value) {
            field = value
            field?.let { fugitive ->
                avatar.fugitive = fugitive
                name.text = fugitive.name
            }
            this.invalidate()
        }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        context?.let { context ->
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.compound_fugitive_view, this, true)
        }

        avatar = getChildAt(0) as CircleImageView
        caught = getChildAt(1) as ImageView
        name = getChildAt(2) as TextView
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //measureChild(caught, widthMeasureSpec, heightMeasureSpec)
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
        var heightSize = Math.max(caught.measuredHeight, (avatar.measuredHeight + name.measuredHeight))

        val widthMeasureSpec = MeasureSpec.makeMeasureSpec( widthSize, MeasureSpec.EXACTLY );
        val heightMeasureSpec = MeasureSpec.makeMeasureSpec( heightSize, MeasureSpec.EXACTLY);

        // Report our final dimensions.
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left:Int, top:Int, right: Int, bottom: Int) {
        avatar.layout(left, top, right, bottom)

        val nameTop = bottom - name.measuredHeight
        name.layout(left, nameTop, right, bottom)

        val caugtLeft = Math.abs(right - left) - caught.measuredWidth
        val caughtRight = caugtLeft + caught.measuredWidth
        val caughtBottom = top + caught.measuredHeight
        caught.layout(caugtLeft, top, caughtRight, caughtBottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}