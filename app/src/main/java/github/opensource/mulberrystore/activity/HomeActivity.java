package github.opensource.mulberrystore.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import github.benjamin.tbsreader.WebBrowserActivity;
import github.opensource.mulberrystore.R;
import github.opensource.mulberrystore.api.Api;

public class HomeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.home_store).setOnClickListener(this);
        findViewById(R.id.home_platform).setOnClickListener(this);
        findViewById(R.id.home_calculator).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_store:
                WebBrowserActivity.openActivity(this, Api.StoreApi);
                break;
            case R.id.home_platform:
                WebBrowserActivity.openActivity(this, Api.PlatformApi);
                break;
            case R.id.home_calculator:
                break;

        }
    }
}
