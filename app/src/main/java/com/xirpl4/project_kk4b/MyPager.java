package com.xirpl4.project_kk4b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class MyPager extends PagerAdapter {

    String[] sTitle = new String[] {"Temukan Event", "Pesan Tiket", "Nikmati Event"};
    String[] sSubtitle = new String[] {"Temukan berbagai event yang akan diadakan di kota Purwokerto dengan mudah", "Mudahkan kamu untuk membeli tiket suatu event secara online", "Nikmati event yang sudah kamu pesan bersama teman-temanmu"};

    private Context context;

    public MyPager(Context context) {
        this.context = context;
    }

    /*
    This callback is responsible for creating a page. We inflate the layout and set the drawable
    to the ImageView based on the position. In the end we add the inflated layout to the parent
    container .This method returns an object key to identify the page view, but in this example page view
    itself acts as the object key
    */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager, null);
        ImageView imageView = view.findViewById(R.id.onboard_img);
        TextView title = view.findViewById(R.id.onboard_title);
        TextView subtitle = view.findViewById(R.id.onboard_subtitle);

        title.setText(sTitle[position]);
        subtitle.setText(sSubtitle[position]);

        imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
        container.addView(view);
        return view;
    }

    /*
    This callback is responsible for destroying a page. Since we are using view only as the
    object key we just directly remove the view from parent container
    */
    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    /*
    Returns the count of the total pages
    */
    @Override
    public int getCount() {
        return 3;
    }

    /*
    Used to determine whether the page view is associated with object key returned by instantiateItem.
    Since here view only is the key we return view==object
    */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    private int getImageAt(int position) {
        switch (position) {
            case 0:
                return R.drawable.onboard1;
            case 1:
                return R.drawable.onboard2;
            case 2:
                return R.drawable.onboard3;
        }
        return position;
    }
}