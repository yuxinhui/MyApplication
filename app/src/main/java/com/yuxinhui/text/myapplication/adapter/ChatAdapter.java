package com.yuxinhui.text.myapplication.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuxinhui.text.myapplication.Bean.ShowMessaage;
import com.yuxinhui.text.myapplication.R;
import com.yuxinhui.text.myapplication.Utils.ChatEmojiParser;
import com.yuxinhui.text.myapplication.Utils.NetUtil;
import com.yuxinhui.text.myapplication.Utils.RequestManager;
import com.yuxinhui.text.myapplication.Utils.ZhiboImgSizeUtil;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */

public class ChatAdapter extends BaseAdapter {
    public List<ShowMessaage> list;
    Context context;
    private Activity activity;
    public ChatAdapter(Context context,Activity activity,List<ShowMessaage> list) {
        this.context = context;
        this.activity=activity;
        this.list = list;
    }
    public static Handler handler;
    Bitmap map;
    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public ShowMessaage getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return ShowMessaage.MESSAGE_TYPE_COUNT;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ShowMessaage message = getItem(i);
        Log.e("TAG", message.getContent());
        final ViewHolder holder;
        if (view == null) {
            holder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_chat, null);
            holder.ivLevel = (NetworkImageView) view.findViewById(R.id.net_level);
            holder.tvUserName = (TextView) view.findViewById(R.id.username);
            holder.tvTime = (TextView) view.findViewById(R.id.time);
            holder.tvContent = (WebView) view.findViewById(R.id.chat_msg);
            holder.netPic= (ImageView) view.findViewById(R.id.netPic);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.ivLevel.setImageUrl(message.getLevelUrl(),RequestManager.getImageLoader());
        holder.tvUserName.setText(message.getUsername());
        holder.tvTime.setText(message.getTime());
        if(message.getType()==ShowMessaage.MESSAGE_TYPE_SEND_IMAGE){
            holder.tvContent.setVisibility(View.GONE);
            holder.netPic.setVisibility(View.VISIBLE);
            if(message.getContent().contains(YuXinHuiApplication.URL_BOOT)){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap bitmap= NetUtil.downloadAvatar(context, message.getContent());
                        int height = bitmap.getHeight();
                        int width = bitmap.getWidth();
                        clickToShowBigImage(holder.netPic,message);
                        int scale = (int) (height/(float)200);
                        if (scale <= 0) {
                            scale = 1;
                        }
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = scale;
                        map = Bitmap.createBitmap(bitmap, 0, 0, width / scale, 200);
                    }
                }).start();
                handler=new Handler(){
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                holder.netPic.setImageBitmap(map);
                                break;
                        }
                        super.handleMessage(msg);
                    }
                };
            }else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap = BitmapFactory.decodeFile(message.getContent(), options);
                int scale = (int) (options.outHeight / (float) 200);
                if (scale <= 0) {
                    scale = 1;
                }
                options.inSampleSize = scale;
                options.inJustDecodeBounds = false;
                Bitmap bitmap1 = BitmapFactory.decodeFile(message.getContent(), options);
                holder.netPic.setImageBitmap(bitmap1);
            }
            clickToShowBigImage(holder.netPic,message);
        }else {
            holder.tvContent.setVisibility(View.VISIBLE);
            holder.tvContent.setTag(message.getContent());
            String unicode = ChatEmojiParser.getInstance(context).parseEmoji(message.getContent());
            holder.tvContent.loadData(message.getContent(),unicode,"UTF-8");
            holder.tvContent.loadDataWithBaseURL(null,message.getContent(),"text/html","utf-8",null);
        }
        return view;
    }
    class ViewHolder{
        TextView tvUserName,tvTime;
        NetworkImageView ivLevel;
        public WebView tvContent;
        ImageView netPic;
    }

    //点击图片查看大图
    private void clickToShowBigImage(ImageView webView, final ShowMessaage message) {
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = new ImageView(activity);
                final Dialog dialog = new Dialog(activity,
                        android.R.style.Theme_NoTitleBar_Fullscreen);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                image.setImageDrawable(ZhiboImgSizeUtil.getScaledBitmapDrawable(
                        activity, message.getContent()));
                dialog.addContentView(image, new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                dialog.show();
            }
        });
    }
    /**
     * 销毁图片文件
     */
    private void destoryBimap(Bitmap bit) {
        if (bit != null && !bit.isRecycled()) {
            bit.recycle();
            bit = null;
        }
    }
    public void setDataSet(List<ShowMessaage> data) {
        this.list=data;
    }
}