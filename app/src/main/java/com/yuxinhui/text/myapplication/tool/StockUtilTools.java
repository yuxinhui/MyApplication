package com.yuxinhui.text.myapplication.tool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by "于志渊"
 * 时间:"16:06"
 * 包名:com.yuxinhui.text.myapplication.tool
 * 描述:
 */
public class StockUtilTools {
    public static void setListViewHeightBasedOnChildren(ListView listView){
        ListAdapter adapter = listView.getAdapter();
        if (adapter==null){
            return;
        }
        int totalHeight=0;
        for (int i=0,len=adapter.getCount();i<len;i++){
            View viewItem = adapter.getView(i, null, listView);
            viewItem.measure(0,0);
            totalHeight+=viewItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height=totalHeight+(listView.getDividerHeight()*(adapter.getCount()-1));
        listView.setLayoutParams(params);
    }
}
