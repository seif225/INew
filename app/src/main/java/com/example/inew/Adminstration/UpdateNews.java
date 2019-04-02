package com.example.inew.Adminstration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inew.R;

public class UpdateNews extends AppCompatActivity {

    Button refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_news);
final UpdateNewsPresenter updateNewsPresenter=new UpdateNewsPresenter();
    refresh=findViewById(R.id.refresh);
    refresh.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateNewsPresenter.getDataFromApi();
        }
    });
    }
}
