package com.soluntech.js.soluntechandroidjs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.liquidplayer.webkit.javascriptcore.JSContext;
import org.liquidplayer.webkit.javascriptcore.JSValue;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private JSContext mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text_view);

        mContext = new JSContext();

        mContext.evaluateScript("a = 10");
        JSValue newAValue = mContext.property("a");
        String script = "function factorial(x) { var f = 1; for(; x > 1; x--) f *= x; return f; }\n" +
                        "var fact_a = factorial(a);\n";
        mContext.evaluateScript(script);

        JSValue factA = mContext.property("fact_a");

        textView.setText(factA.toString());
    }
}
