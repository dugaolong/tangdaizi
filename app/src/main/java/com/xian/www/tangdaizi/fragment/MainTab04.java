package com.xian.www.tangdaizi.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.xian.www.tangdaizi.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

import static android.app.Activity.RESULT_OK;


public class MainTab04 extends Fragment implements View.OnClickListener,EasyPermissions.PermissionCallbacks {

    private final String TAG = "MainTab04";
    private static final int TAKE_PICTURE = 0;
    private static final int CHOOSE_PICTURE = 1;
    private static final int SCALE = 5;//照片缩小比例
    private ImageView iv_image = null;
    private Uri imageUri;
    private Button update;
    private Context context;

    private String fileName;
    public final File FILE_SDCARD = Environment
            .getExternalStorageDirectory();
    public final File FILE_LOCAL = new File(FILE_SDCARD, "vCar");
    public final File FILE_PIC_SCREENSHOT = new File(FILE_LOCAL,
            "images/screenshots");

    String[] perms = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.main_tab_04, container, false);
        TextView textView = (TextView) view.findViewById(R.id.title_text);
        update = (Button) view.findViewById(R.id.update);
        update.setOnClickListener(this);
        iv_image = (ImageView) view.findViewById(R.id.head);
        textView.setText("个人中心");

        Glide.with(context).load(R.drawable.head).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_image) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv_image.setImageDrawable(circularBitmapDrawable);
            }
        });
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update:
                //请求权限
                if (EasyPermissions.hasPermissions(getActivity(), perms)) {
                    Log.i(TAG, "已获取权限");
                    showPicturePicker(context);
                } else {
                    //第二个参数是被拒绝后再次申请该权限的解释
                    //第三个参数是请求码
                    //第四个参数是要申请的权限
//                    EasyPermissions.requestPermissions(this, "必要的权限", 0, perms);
                    EasyPermissions.requestPermissions(this, "拍照需要摄像头权限", 1, perms);
                }
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {// ANDROID6.0 请求权限
//                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
//                    } else {
//                        showPicturePicker(context);
//                    }
//                } else {
//                    showPicturePicker(context);
//                }
//				if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//					ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
//				} else {
//					showPicturePicker(context);
//				}
                break;
        }
    }



    public void showPicturePicker(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("图片来源");
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"拍照", "相册"}, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case TAKE_PICTURE:
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        File outPutImage = new File(getActivity().getExternalCacheDir(), "image.jpg");//创建File对象,用于存储拍照后的照片
                        try {
                            if (outPutImage.exists()) {
                                outPutImage.delete();
                            }
                            outPutImage.createNewFile();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        //从Android7.0开始,直接使用本地真实路径的URI被认为是不安全的,会抛出FileURIExposedException异常。
//                        //FileProvider是一种特殊的内容提供器,他使用了和内容提供器类似的机制来对数据进行保护。
//                        if (Build.VERSION.SDK_INT >= 24) {
//                            imageUri = FileProvider.getUriForFile(getActivity(), "com.example.dugaolong.wiewone.fileprovider", outPutImage);
//                        } else {
//                            imageUri = Uri.fromFile(outPutImage);
//                        }
                        //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                    case CHOOSE_PICTURE:
                        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PICTURE:
                    Glide.with(context).load(Uri.parse(context.getExternalCacheDir() + "/image.jpg")).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_image) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            iv_image.setImageDrawable(circularBitmapDrawable);
                        }
                    });
//                    setPic(iv_image,Uri.parse(context.getExternalCacheDir() + "/image.jpg"));
//                    //将保存在本地的图片取出并缩小后显示在界面上
//                    Bitmap bitmap = BitmapFactory.decodeFile(context.getExternalCacheDir() + "/image.jpg");
//                    Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
//                    //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
//                    bitmap.recycle();
//
//                    //将处理过的图片显示在界面上，并保存到本地
//                    iv_image.setImageBitmap(newBitmap);
//                    ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));
                    break;

                case CHOOSE_PICTURE:
                    ContentResolver resolver = context.getContentResolver();
                    //照片的原始资源地址
                    Uri originalUri = data.getData();
//                    Glide.with(context).load(originalUri).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_image) {
//                        @Override
//                        protected void setResource(Bitmap resource) {
//                            RoundedBitmapDrawable circularBitmapDrawable =
//                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                            circularBitmapDrawable.setCircular(true);
//                            iv_image.setImageDrawable(circularBitmapDrawable);
//                        }
//                    });
                    setPic(iv_image,originalUri);
//                    try {
//                        //使用ContentProvider通过URI获取原始图片
//                        Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
//                        if (photo != null) {
//                            //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
//                            Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
//                            //释放原始图片占用的内存，防止out of memory异常发生
//                            photo.recycle();
//
//                            iv_image.setImageBitmap(smallBitmap);
//                        }
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    break;

                default:
                    break;
            }
        }
    }

    private void setPic(ImageView imageView, Uri uri) {
        if (context != null) {
            //获取目标控件的大小
            int targetW = imageView.getWidth();
            int targetH = imageView.getHeight();

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            try {
                //inJustDecodeBounds为true，可以加载源图片的尺寸大小，decodeStream方法返回的bitmap为null
                bmOptions.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, bmOptions);
                // 得到源图片的尺寸
                int photoW = bmOptions.outWidth;
                int photoH = bmOptions.outHeight;
                //通过比较获取较小的缩放比列
                int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
                // 将inJustDecodeBounds置为false，设置bitmap的缩放比列
                bmOptions.inJustDecodeBounds = false;
                bmOptions.inSampleSize = scaleFactor;
                bmOptions.inPurgeable = true;
                //再次decode获取bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, bmOptions);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 相机选择
     */
    private void selectCamera() {
        fileName = String.valueOf((new Date()).getTime()) + ".jpg";
//        SPUtil.put(context,SPUtil.FILE_PATH,"fileName",fileName);
        File filePath = FILE_PIC_SCREENSHOT;
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            Intent intent = new Intent(
                    MediaStore.ACTION_IMAGE_CAPTURE);
            File f = new File(filePath, fileName);
            // localTempImgDir和localTempImageFileName是自己定义的名字
            Uri u = Uri.fromFile(f);
            intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
            startActivityForResult(intent, TAKE_PICTURE);
        } catch (Exception e) {
            e.printStackTrace();
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
//                    Toast.makeText(context, "You denied the permission", Toast.LENGTH_LONG).show();
//                }
//                break;
//            default:
//        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
//        Toast.makeText(context, "onPermissionsGranted", Toast.LENGTH_LONG).show();
        showPicturePicker(context);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(context, "onPermissionsDenied", Toast.LENGTH_LONG).show();
    }
}
