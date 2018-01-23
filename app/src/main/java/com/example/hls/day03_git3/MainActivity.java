package com.example.hls.day03_git3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
  private  String url="http://pic29.photophoto.cn/20131204/0034034499213463_b.jpg";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button bt= (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用OKhttp请求数据
                //创建client
                OkHttpClient client = new OkHttpClient();
                //创建请求
                Request request = new Request.Builder().url(url).build();
                //创建请求队列
                Call call = client.newCall(request);//参数，请求对象
                //执行
                call.enqueue(new Callback() {
                    //失败的时候调用
                    @Override
                    public void onFailure(Call call, IOException e) {

//                        Log.d("TAG",msg:"失败----");
                        Log.d(TAG, "shibai-----");

                    }
                    //成功的时候调用
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d(TAG, "成功-----");
                    }
                });

            }
        });

    }
}
