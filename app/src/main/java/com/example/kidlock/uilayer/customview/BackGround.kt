package com.example.kidlock.uilayer.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import com.example.kidlock.R

class BackGround constructor(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var colorBackGround: String = ""

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BackGround,
            0, 0
        )
            .apply {
                try {
                    colorBackGround = getString(R.styleable.BackGround_colorBackGround)!!
                } finally {
                    recycle()
                }

            }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            this.drawCircle(
                width.toFloat() / 3,
                -height.toFloat() / 3,
                height.toFloat() * 2 / 3,
                setUpPaint(50, colorBackGround, null)
            )

            this.drawCircle(
                width.toFloat() * 10 / 25,
                height.toFloat() * 2 / 25,
                height.toFloat() / 45,
                setUpPaint(
                    80, colorBackGround,
                    RadialGradient(
                        width.toFloat() * 10 / 25,
                        height.toFloat() * 2 / 25,
                        height.toFloat() / 45,
                        Color.parseColor("#FAFFFD"),
                        Color.parseColor(colorBackGround),
                        Shader.TileMode.MIRROR
                    )
                )
            )

            this.drawCircle(
                width.toFloat() * 7 / 25,
                height.toFloat() * 5 / 20,
                height.toFloat() / 38,
                setUpPaint(
                    30, colorBackGround,
                    RadialGradient(
                        width.toFloat() * 7 / 25,
                        height.toFloat() * 5 / 20,
                        height.toFloat() / 38,
                        Color.parseColor("#FAFFFD"),
                        Color.parseColor(colorBackGround),
                        Shader.TileMode.MIRROR
                    )
                )
            )

            this.drawCircle(
                width.toFloat() * 22 / 25,
                height.toFloat() * 3 / 20,
                height.toFloat() / 30,
                setUpPaint(
                    40, colorBackGround,
                    RadialGradient(
                        width.toFloat() * 22 / 25 - 20,
                        height.toFloat() * 3 / 20,
                        height.toFloat() / 30,
                        Color.parseColor("#FAFFFD"),
                        Color.parseColor(colorBackGround),
                        Shader.TileMode.MIRROR
                    )
                )
            )

            this.drawCircle(
                width.toFloat() * 92 / 100,
                height.toFloat() * 95 / 100,
                height.toFloat() / 7,
                setUpPaint(
                    100, colorBackGround,
                    RadialGradient(
                        width.toFloat() * 85 / 100,
                        height.toFloat() * 90 / 100,
                        height.toFloat() / 3,
                        Color.parseColor(colorBackGround),
                        Color.parseColor("#FAFFFD"),
                        Shader.TileMode.MIRROR
                    )
                )
            )

        }
    }

    fun setUpPaint(alphaColor: Int, colorName: String, shaderContent: Shader?): Paint {
        return Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor(colorName)
            alpha = alphaColor
            strokeWidth = 0.5f
            if (shaderContent != null) {
                shader = shaderContent
            }
        }
    }
}