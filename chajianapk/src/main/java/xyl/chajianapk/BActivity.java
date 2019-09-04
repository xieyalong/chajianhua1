package xyl.chajianapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import xyl.biao_zhuan_library.BaseActivity;

public class BActivity extends BaseActivity {
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_main);
        tv=findViewById(R.id.tv1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                that.onBackPressed();
            }
        });
    }
}
