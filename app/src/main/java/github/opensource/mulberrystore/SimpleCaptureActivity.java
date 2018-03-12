package github.opensource.mulberrystore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import io.github.xudaojie.qrcodelib.CaptureActivity;


public class SimpleCaptureActivity extends CaptureActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void handleResult(String resultString) {
        if (TextUtils.isEmpty(resultString)) {
            Toast.makeText(this, getResources().getString(R.string.scan_failed), Toast.LENGTH_LONG).show();
            restartPreview();
        } else {
            Intent intent = new Intent();
            intent.putExtra("result", resultString);
            setResult(0, intent);
            this.finish();
        }
    }


    public static void openSannerActivity(Object context, int requestCode) {
        if (context instanceof AppCompatActivity) {
            Intent intent = new Intent((Context) context, SimpleCaptureActivity.class);
            ((AppCompatActivity) context).startActivityForResult(intent, requestCode);
        } else if (context instanceof Fragment) {
            Intent intent = new Intent(((Fragment) context).getContext(), SimpleCaptureActivity.class);
            ((Fragment) context).startActivityForResult(intent, requestCode);
        }
    }


}

