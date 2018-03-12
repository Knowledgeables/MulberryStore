package com.yanzhenjie.permission;

import android.content.Context;

/**
 * Project :  BePermission.
 * Package name: github.opensource.bepermission
 * Created by :  Benjamin.
 * Created time: 2017/11/1 13:35
 * Changed by :  Benjamin.
 * Changed time: 2017/11/1 13:35
 * Class description:
 */

public class PermissionUtil {
    public static final int SINGLE_PERMISSION = 100;
    public static final int MULTI_PERMISSION = 101;
    public static final int SETTING_CODE = 300;

    public static final int CAMERA = 60001;
    public static final int GALLARY = 60002;
    public static final int LOCATION = 60003;
    public static final int VOICE = 60004;

    // 申请单个权限。
    public static void checkSinglePermission(Context context, Object callback, RationaleListener listener, String... permission) {
        AndPermission.with(context)
                .requestCode(SINGLE_PERMISSION)
                .permission(permission)
                .callback(callback)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                // 这样避免用户勾选不再提示，导致以后无法申请权限。
                // 你也可以不设置。
                .rationale(listener).start();
    }

    // 申请多个权限。
    public static void checkeMultiplePermission(Context context, Object callback, RationaleListener listener, String[]... permissions) {
        AndPermission.with(context)
                .requestCode(MULTI_PERMISSION)
                .permission(Permission.MICROPHONE, Permission.STORAGE)
                .callback(callback)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                // 这样避免用户勾选不再提示，导致以后无法申请权限。
                // 你也可以不设置。
                .rationale(listener)
                .start();
    }

    // 申请具体权限
    public static void checkOnePermission(Context context, int requestCode, Object callback, RationaleListener listener, String... permission) {
        AndPermission.with(context)
                .requestCode(requestCode)
                .permission(permission)
                .callback(callback)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                // 这样避免用户勾选不再提示，导致以后无法申请权限。
                // 你也可以不设置。
                .rationale(listener).start();
    }
    // 申请具体权限
    public static void checkMorePermission(Context context, int requestCode, Object callback, RationaleListener listener, String[]... permission) {
        AndPermission.with(context)
                .requestCode(requestCode)
                .permission(permission)
                .callback(callback)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框；
                // 这样避免用户勾选不再提示，导致以后无法申请权限。
                // 你也可以不设置。
                .rationale(listener).start();
    }
}
