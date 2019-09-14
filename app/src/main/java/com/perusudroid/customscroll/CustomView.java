package com.perusudroid.customscroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomView extends ConstraintLayout {

    private TextView tvTxt,tvCount;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
        LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.include_custom_view, this);
        bindViews();
        setAssets(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void bindViews() {
        tvTxt = findViewById(R.id.tvTxt);
        tvCount = findViewById(R.id.tvCount);
    }

    private void setAssets(TypedArray obtainStyledAttributes) {
        String title = obtainStyledAttributes.getString(R.styleable.CustomView_myTitle);
        String content = obtainStyledAttributes.getString(R.styleable.CustomView_myContent);

        tvTxt.setText(title);
        tvCount.setText(content);
    }


}
