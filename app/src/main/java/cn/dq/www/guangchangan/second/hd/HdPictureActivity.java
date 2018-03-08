package cn.dq.www.guangchangan.second.hd;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.dq.www.guangchangan.adapter.DividerGridItemDecoration;
import cn.dq.www.guangchangan.adapter.MasonryAdapter;
import cn.dq.www.guangchangan.adapter.RecyclerViewItemViewListener;
import cn.dq.www.guangchangan.picture.PictureDetailsActivity;
import cn.dq.www.guangchangan.utils.SPUtil;
import cn.dq.www.guangchangan.utils.ToastUtil;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by dugaolong on 17/9/19.
 */

public class HdPictureActivity extends Activity implements EasyPermissions.PermissionCallbacks {

    private final String TAG = "HdPictureActivity";
    String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static final int TAKE_PICTURE = 0;
    private static final int CHOOSE_PICTURE = 1;
    private static final int PHOTO_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;
    private static final int PHOTO_CLIP = 3;
    private long imageName;
    private ArrayList<String> IMAGE_URL_ARRAYS = new ArrayList<String>();
    MasonryAdapter adapter;

    @InjectView(cn.dq.www.guangchangan.R.id.rv_id)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cn.dq.www.guangchangan.R.layout.picture);
        //using butter knife
        ButterKnife.inject(this);

        Resources r = getApplicationContext().getResources();
        Uri uri01 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(cn.dq.www.guangchangan.R.drawable.pic01) + "/"
                + r.getResourceTypeName(cn.dq.www.guangchangan.R.drawable.pic01) + "/"
                + r.getResourceEntryName(cn.dq.www.guangchangan.R.drawable.pic01));
        Uri uri02 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(cn.dq.www.guangchangan.R.drawable.pic02) + "/"
                + r.getResourceTypeName(cn.dq.www.guangchangan.R.drawable.pic02) + "/"
                + r.getResourceEntryName(cn.dq.www.guangchangan.R.drawable.pic02));
        Uri uri03 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(cn.dq.www.guangchangan.R.drawable.pic03) + "/"
                + r.getResourceTypeName(cn.dq.www.guangchangan.R.drawable.pic03) + "/"
                + r.getResourceEntryName(cn.dq.www.guangchangan.R.drawable.pic03));
        Uri uri04 = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(cn.dq.www.guangchangan.R.drawable.pic04) + "/"
                + r.getResourceTypeName(cn.dq.www.guangchangan.R.drawable.pic04) + "/"
                + r.getResourceEntryName(cn.dq.www.guangchangan.R.drawable.pic04));

        requestPermission();

        String urls_sp = SPUtil.appget(this, "image", "no");
        Log.e("HdPic","urls_sp:"+urls_sp);
        if (urls_sp.equals("no")) {//首次进入
            IMAGE_URL_ARRAYS.add("ddddd");
            IMAGE_URL_ARRAYS.add(uri01.getPath());
            IMAGE_URL_ARRAYS.add(uri02.getPath());
            IMAGE_URL_ARRAYS.add(uri03.getPath());
            IMAGE_URL_ARRAYS.add(uri04.getPath());
        } else {
            List<String> urlList = JSON.parseArray(urls_sp, String.class);
            IMAGE_URL_ARRAYS.addAll(urlList);
        }

        //设置布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //添加分隔符
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        adapter = new MasonryAdapter(this, IMAGE_URL_ARRAYS);
        adapter.setHeightList(IMAGE_URL_ARRAYS);
        //设置Adapter
        recyclerView.setAdapter(adapter);

        //为子条目设置点击事件
        adapter.setOnRecyclerViewItemViewListener(new RecyclerViewItemViewListener() {
            @Override
            public void onClickListener(RecyclerView.ViewHolder viewHolder, int position) {
                if (position == 0) {
                    showPicturePicker();
                }else {
                    Intent intent = new Intent(HdPictureActivity.this,PictureDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    ArrayList clone = (ArrayList)IMAGE_URL_ARRAYS.clone();
                    clone.remove(0);
                    bundle.putString("urls", JSON.toJSONString(clone));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

//            @Override
//            public void onLongClickListener(RecyclerView.ViewHolder viewHolder, int position) {
//                ToastUtil.showToast(PictureActivity.this, "长按事件："+position, Toast.LENGTH_SHORT).show();
//            }
        });
    }


    public void showPicturePicker() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("图片来源");
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"拍照", "相册"}, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case TAKE_PICTURE:
                        getPicFromCamera();
                        break;
                    case CHOOSE_PICTURE:
                        getPicFromPhoto();
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void getPicFromPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }

    private void getPicFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 下面这句指定调用相机拍照后的照片存储的路径
        imageName = Calendar.getInstance().getTimeInMillis();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), imageName+".jpg")));
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                switch (resultCode) {
                    case -1://-1表示拍照成功
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/"+imageName+".jpg");
                        if (file.exists()) {
                            Uri uri = Uri.fromFile(file);
                            String url = uri.getPath();
                            IMAGE_URL_ARRAYS.add(url);

                            //list转成json
                            String json = JSON.toJSONString(IMAGE_URL_ARRAYS);

                            Log.e("json", "json===" + json);
                            SPUtil.appput(this, "image", json);

                            adapter.setHeightList(IMAGE_URL_ARRAYS);
                            adapter.notifyDataSetChanged();

                            Log.e("PictureActivity", "url==" + url);
                        }
                        break;
                    default:
                        break;
                }
                break;
            case PHOTO_REQUEST:
                if (data != null) {
                    Uri uri = data.getData();
                    String url = uri.getPath();
                    // 如果不是document类型的Uri，则使用普通方式处理
                    String  imagePath = getImagePath(uri, null);
                    if(imagePath==null){
                        IMAGE_URL_ARRAYS.add(url);
                    }else {
                        IMAGE_URL_ARRAYS.add(imagePath);
                    }


                    //list转成json
                    String json = JSON.toJSONString(IMAGE_URL_ARRAYS);

                    Log.e("json", "json===" + json);
                    SPUtil.appput(this, "image", json);

                    adapter.setHeightList(IMAGE_URL_ARRAYS);
                    adapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }

    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        // 通过uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null,
                null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void requestPermission() {
        //请求权限
        if (EasyPermissions.hasPermissions(this, perms)) {
            Log.i(TAG, "已获取权限");
        } else {
            //第二个参数是被拒绝后再次申请该权限的解释
            //第三个参数是请求码
            //第四个参数是要申请的权限
            EasyPermissions.requestPermissions(this, "拍照需要摄像头权限", 1, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //把申请权限的回调交由EasyPermissions处理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    showPicturePicker(context);
//                } else {
//                    ToastUtil.showToast(context, "You denied the permission");
//                }
//                break;
//            default:
//        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
//        ToastUtil.showToast(context, "onPermissionsGranted");
//        showPicturePicker();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        ToastUtil.showToast(this, "onPermissionsDenied");
    }
}
