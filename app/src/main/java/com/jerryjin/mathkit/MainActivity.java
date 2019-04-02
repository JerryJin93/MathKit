package com.jerryjin.mathkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.jerryjin.kit.geometrics.point.Point;
import com.jerryjin.kit.geometrics.shape.Square;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.text);

        Square square = new Square(5, new Point(0, 0), Square.LEFT_BOTTOM);

        result.setText(square.toString());

    }
}
