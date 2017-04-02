package com.example.angitha.menus;

import android.support.annotation.ColorRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    TextView textView;
    private boolean isStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.parentLayout);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //return super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.start).setVisible(!isStarted);
        menu.findItem(R.id.stop).setVisible(isStarted);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    textView.setText("Item 1");
                return true;
            case R.id.item2:
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                textView.setText("Item 2");
                return true;
            case R.id.item3:
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                textView.setText("Item 3");
                return true;
            //Changing menu items at runtime
            case R.id.start:
                isStarted = true;
                textView.setText("Started");
                //Re-draw there is a menu update
                invalidateOptionsMenu();
                return true;
            case R.id.stop:
                textView.setText("Stopped");
                isStarted = false;
                invalidateOptionsMenu();
                return true;
            case R.id.menu_archive:
            case R.id.menu_delete:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;
            case R.id.menu_commit:textView.setText("Menu Commit");
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;
            case R.id.menu_push:textView.setText("Menu Push");
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

