package training.itexico.com.androidcertificationproject.CustomViews

import android.content.Context
import android.graphics.*
import android.icu.util.Measure
import android.os.AsyncTask
import android.support.v4.graphics.BitmapCompat
import android.support.v7.content.res.AppCompatResources
import android.util.AttributeSet
import android.view.View
import training.itexico.com.androidcertificationproject.Models.Fugitive
import training.itexico.com.androidcertificationproject.R

class CircleImageView : View {
    private var task : BitmapLoader? = null
    private var bitmap : Bitmap? = null
    private var resourceId : Int? = -1
    private var paint = Paint()
    private var calculatedHeight : Int = 100
    private var calculatedWidth : Int = 100

    var fugitive : Fugitive? = null
        set(value) {
            field = value
            value?.let { fugitive ->
                resourceId = fugitive.picture
                bitmap?.recycle()
                bitmap = null
            }
            this.invalidate()
        }

    constructor(context:Context) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setUpView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setUpView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        setUpView(context, attrs)
    }

    init {
        paint.isAntiAlias = true
    }

    fun setUpView(context: Context?, attrs: AttributeSet?) {
        context?.let { context ->
            val attrs = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            resourceId = attrs.getResourceId(R.styleable.CircleImageView_resourceImage, -1)
            attrs?.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)

        val withSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)

        if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.EXACTLY) {
            calculatedWidth = withSize
        }

        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.EXACTLY) {
            calculatedHeight = heightSize
        }

        val widthMeasureSpec = MeasureSpec.makeMeasureSpec( calculatedWidth, MeasureSpec.EXACTLY );
        val heightMeasureSpec = MeasureSpec.makeMeasureSpec( calculatedHeight, MeasureSpec.EXACTLY);

        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        bitmap?.let { bitmap ->
            canvas?.let { canvas ->
                val path = Path()
                path.addCircle(
                        calculatedWidth.toFloat() / 2,
                        calculatedHeight.toFloat() / 2,
                        (Math.min(canvas.width.toFloat(), canvas.height.toFloat())) /2,
                        Path.Direction.CW)
                canvas.clipPath(path)
                canvas.drawBitmap(bitmap, 0f, 0f, paint)
            }
        } ?: run {
            loadBitmapAsync()
        }
    }

    fun loadBitmapAsync() {
        if (resourceId != -1 && task == null) {
            task = BitmapLoader()
            task?.execute(resourceId)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        task?.let { task ->
            task.cancel(true)
        }
        bitmap?.let { bitmap ->
            bitmap.recycle()
        }
    }

    inner class BitmapLoader : AsyncTask<Int, Void, Bitmap?> () {

        override fun doInBackground(vararg resource: Int?): Bitmap? {
            resource?.let {  resource ->
                if (resource.size > 0) {
                    resource[0]?.let { resourceId ->
                        BitmapFactory.decodeResource(context.resources, resourceId)?.let { bitmap ->
                            return Bitmap.createScaledBitmap(bitmap, calculatedWidth, calculatedHeight, false)
                        }
                    }
                }
            }

            return null
        }

        override fun onPostExecute(result: Bitmap?) {
            this@CircleImageView.bitmap = result
            this@CircleImageView.task = null
            this@CircleImageView.invalidate()
        }
    }
}