package com.xjtu.curriculumschedule.curriculumschedule_app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Kc_mainActivity  extends Activity{

    URLData urlData=new URLData();
    private Handler handler;

    private String kc=null;

    private ImageView imgView=null;
    private Bitmap bitmap_img=null;
    private Spinner kcname_spin;
    private List<String> kcitems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kc_layout);
        imgView=(ImageView) findViewById(R.id.imgv_yzm);
        //初始化学期下拉框 在xml里面配置过了

        EditText kcname_edit= (EditText) findViewById(R.id.edit_kcname);
        kc=kcname_edit.getText().toString();

        //课程下拉列
        kcname_spin= (Spinner) findViewById(R.id.spacer_kcname);

        //课程绑定
        new Thread(){
            @Override
            public void run() {
                urlData.GetCookie();
                String html_kc = urlData.GetXNXQKC("20161",kc);
                Document document= Jsoup.parse(html_kc);
                Elements eInfo = document.select("option");
                Log.i("element",eInfo.toString());
                for (int i = 0; i < eInfo.size(); i++) {
                    //System.out.println(eInfo.get(i).attr("value"));//获得value
                    //System.out.println(eInfo.get(i).text());//获得text
                    kcitems.add(eInfo.get(i).text().toString());
                    Log.i("infp",eInfo.get(i).attr("value"));
                }

                handler.sendEmptyMessage(1);
            }
        }.start();
        //验证码
        new Thread(){
            @Override
            public void run() {
                urlData.GetCookie();
                bitmap_img = urlData.GetImage(0);
                handler.sendEmptyMessage(2);
            }
        }.start();

        //更新页面
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==1){
                    ArrayAdapter<String> kcAdapter = new ArrayAdapter<String>(Kc_mainActivity.this, android.R.layout.simple_spinner_item, kcitems);
                    kcAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    kcname_spin.setAdapter(kcAdapter);
                }else if(msg.what==2){
                    imgView.setImageBitmap(bitmap_img);
                }
            }
        };
    }

}
