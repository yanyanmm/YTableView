package com.lihg.tableview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import com.lihg.library.tableview.YTableItem;
import com.lihg.library.tableview.YTableView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<YTableItem> tableItems = new ArrayList<YTableItem>();
        for (int i = 0; i < 8; i++) {
            tableItems.add(new YTableItem(i, R.mipmap.ic_launcher_round, null, 0, "集体活动"));
        }
        final YTableView tableView = findViewById(R.id.table_view);
        tableView.setTableItems(tableItems);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<YTableItem> tableItems = new ArrayList<YTableItem>();
                for (int i = 0; i < 11; i++) {
                    tableItems.add(new YTableItem(i, R.mipmap.ic_launcher_round, null, 0, "集体活动"));
                }
                tableView.setTableItems(tableItems);
            }
        }, 1000 * 10);
    }
}
