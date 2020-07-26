package com.example.coldchain.b_mine_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.coldchain.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class S1_Goods_Activity extends AppCompatActivity {

    public static final String CONTEXT = "context";

    public static final String IMAGE_ID = "image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1__goods_);

        Intent intent = getIntent();

        String Context = intent.getStringExtra(CONTEXT);
        int[] ImageId = intent.getIntArrayExtra(IMAGE_ID);

        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        ImageView imageView = findViewById(R.id.fruit_image_view);
        TextView textView = findViewById(R.id.fruit_content_text);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbar.setTitle(Context);
        Glide.with(this).load(ImageId[0]).into(imageView);
        String goodsContent = generateGoodsContent(Context);
        textView.setText(goodsContent);
    }
    private String generateGoodsContent(String goodsName) {
        StringBuilder goodsContent = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            goodsContent.append(goodsName);
        }
        return goodsContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
