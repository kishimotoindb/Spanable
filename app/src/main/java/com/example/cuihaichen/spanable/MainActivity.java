package com.example.cuihaichen.spanable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);

        //click spanable学习
        mTv.setText(getClickSpan());
        mTv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private SpannableString getClickSpan() {
        SpannableString s1 = new SpannableString("按键1------按键2");
        s1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "按键1被按下", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.colorPrimary));
            }
        }, 0, 2, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        s1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "按键2被按下", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ds.linkColor);
                ds.setUnderlineText(false);
                ds.setAlpha(50);
            }
        }, 9, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return s1;
    }
}
