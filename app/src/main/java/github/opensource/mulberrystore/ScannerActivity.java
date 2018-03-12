package github.opensource.mulberrystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.PermissionUtil;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

import github.benjamin.tbsreader.WebBrowserActivity;
import github.opensource.mulberrystore.api.Api;
import github.opensource.mulberrystore.bean.StoreJsonBean;

public class ScannerActivity extends AppCompatActivity implements View.OnClickListener, RationaleListener, PermissionListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner);
        findViewById(R.id.scanner).setOnClickListener(this);
        textView = findViewById(R.id.message);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scanner:
                PermissionUtil.checkMorePermission(this, 30001, this, this, Permission.CAMERA);
                break;
            case R.id.message:
                String tempRejsult = textView.getText().toString().trim();
                if (tempRejsult != null && tempRejsult.length() > 0) {
                    StoreJsonBean json = new Gson().fromJson(tempRejsult, StoreJsonBean.class);
                    if (json != null && json.getMes() != null) {
                        String currentUrl = json.getMes().getTitleSrc();
                        if (currentUrl != null && currentUrl.trim().length() > 0 && currentUrl.contains("http")) {
                            WebBrowserActivity.openActivity(ScannerActivity.this, currentUrl);
                        }
                    }
                }
                break;
            default:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case 1001:
                    String code = data.getStringExtra("result");
                    Log.e("扫描结果", code);
                    doCode(code);
                    /*WebBrowserActivity.openActivity(this, url);*/
                    break;
                default:
                    break;
            }
        }
    }

    public void doCode(String code) {
        OkGo.<String>get(Api.code)
                .params("code", code)
                .params("uid", "add" + (int) ((Math.random() * 9 + 1) * 10000) + "shop")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            String result = response.body().toString();
                            Log.e("请求结果", result);
                            textView.setText(Html.fromHtml("<u>" + result + "</u>"));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        textView.setText(Html.fromHtml("<u>" + "出错了:" + response.getException().getMessage() + "</u>"));

                    }
                });
    }

    @Override
    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
        SimpleCaptureActivity.openSannerActivity(this, 1001);
    }

    @Override
    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
        SimpleCaptureActivity.openSannerActivity(this, 1001);
        for (String temp : deniedPermissions) {
            Log.e("error", temp);
        }
    }

    @Override
    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
        AndPermission.rationaleDialog(this, rationale).show();
    }
}
