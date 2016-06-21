package com.yuxinhui.text.myapplication.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yuxinhui.text.myapplication.R;

/**
 * Created by "于志渊"
 * 时间:"16:23"
 * 包名:com.yuxinhui.text.myapplication.Utils
 * 描述:ImageView创建工厂
 */
public class ViewFactory {
    /*获取ImageView视图*/
    public static ImageView getImageView(Context context,String uri){
        ImageView imageView=(ImageView) LayoutInflater.from(context).inflate(R.layout.view_indexbanner,null);
        ImageLoader.getInstance().displayImage(uri,imageView);
        return imageView;
    }
}
