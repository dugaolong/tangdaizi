package cn.dq.www.guangchangan.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.utils.noaAd.ADFilterTool;
import cn.dq.www.guangchangan.widget.swingindicator.SwingIndicator;


/**
 * 播放视频的activity
 * Created by dugaolong on 17/12/21.
 */

public class VideoActivity extends Activity {

    private Context mContext;
    private WebView webView;//系统自带的WebView
    private String url = "";

    private static final String TAG = VideoActivity.class.getSimpleName();

    private String number;
    FrameLayout frameLayout;
    SwingIndicator loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.video);
        mContext = this;
        initView();
        initBundle();
        webView.loadUrl(url);
    }

    private void initBundle() {
        Bundle bundle = getIntent().getExtras();
        if(bundle.containsKey("url")){
            url = bundle.getString("url");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        loadingView = (SwingIndicator) findViewById(R.id.loadView);
        webView = (WebView) findViewById(R.id.webview);
//        webView = new WebView(getApplicationContext());
//        FrameLayout.LayoutParams mLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        frameLayout.addView(webView, mLayoutParams);
        webView.setLayerType(View.LAYER_TYPE_NONE, null);
        webView.setVerticalScrollBarEnabled(false);
        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(true);
        //启用数据库
        webSettings.setDatabaseEnabled(true);
        //设置定位的数据库路径
        String dir = this.getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
        webSettings.setGeolocationDatabasePath(dir);
        //启用地理定位
        webSettings.setGeolocationEnabled(true);
        //开启DomStorage缓存
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        //配置权限
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, true);
            }
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
//                return true;
//            }

        });
        webView.setWebViewClient(new WebViewClient() {
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                }
                return true;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url){
               String urla= url.toLowerCase();
                System.out.println("url===="+url);
                if(!ADFilterTool.hasAd(mContext,urla)){
                    return super.shouldInterceptRequest(view,url);//正常加载
                }else{
                    System.out.println("含有广告资源:url===="+url);
                    return new WebResourceResponse(null,null,null);//含有广告资源屏蔽请求
                }
            }


//            @Override
//            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request){
//                String url= null;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    url = request.getUrl().getPath().toLowerCase();
//                }
//                if(!ADFilterTool.hasAd(mContext,url)){
//                    return super.shouldInterceptRequest(view,url);//正常加载
//                }else{
//                    return new WebResourceResponse(null,null,null);//含有广告资源屏蔽请求
//                }
//            }
            //加载https时候，需要加入 下面代码
            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {

                handler.proceed();  //接受所有证书
            }

            // 旧版本，会在新版本中也可能被调用，所以加上一个判断，防止重复显示
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return;
                }
                // 在这里显示自定义错误页
                frameLayout.setVisibility(View.GONE);
                loadingView.setVisibility(View.VISIBLE);
            }

            // 新版本，只会在Android6及以上调用
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                if (request.isForMainFrame()) { // 或者： if(request.getUrl().toString() .equals(getUrl()))
                    // 在这里显示自定义错误页
                    frameLayout.setVisibility(View.GONE);
                    loadingView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                frameLayout.setVisibility(View.VISIBLE);
                loadingView.setVisibility(View.GONE);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.removeAllViews();
        webView.destroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
