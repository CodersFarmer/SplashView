package com.heima.yqz.mysplash.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.heima.yqz.mysplash.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate( R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.button1:
                Toast.makeText(Main2Activity.this,"shezhi",Toast.LENGTH_SHORT).show();
            case R.id.button2:
                Toast.makeText(Main2Activity.this,"guanyu",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
