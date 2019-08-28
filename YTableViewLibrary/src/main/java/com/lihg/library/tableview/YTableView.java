package com.lihg.library.tableview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class YTableView extends FrameLayout {

    public static interface ImageLoader {
        void displayImage(ImageView imageView, YTableItem tableItem);
    }

    //设置单元格高度
    private int mTableItemHeight;

    //列数
    private int mColumnCount;

    //属性
    private YTableItemAttr mTableItemAttr;

    //容器
    private LinearLayout mContainer;

    //单元格控件集合
    private List<YTableItemView> mTableItemViews;

    //点击事件
    private View.OnClickListener mListener;

    //图片加载器
    private ImageLoader mImageLoader;

    public YTableView(Context context) {
        this(context, null);
    }

    public YTableView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YTableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTableItemHeight = YDesityUtil.dp2px(context, 80);
        mColumnCount = 4;
        mTableItemViews = new ArrayList<YTableItemView>();

        mTableItemAttr = new YTableItemAttr();
        mTableItemAttr.setTextSize(YDesityUtil.sp2px(context, 14));
        mTableItemAttr.setTextMarginTop(YDesityUtil.dp2px(context,3));

        //初始化属性
        this.initAttrs(attrs);

        //初始化控件
        this.initViews();
    }

    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.YTableView);
            mTableItemHeight = typedArray.getDimensionPixelSize(R.styleable.YTableView_table_itemHeight, mTableItemHeight);
            this.setColumnCount(typedArray.getInt(R.styleable.YTableView_table_columnCount, mColumnCount));
            mTableItemAttr.setTextColor(typedArray.getColor(R.styleable.YTableView_table_textColor, mTableItemAttr.getTextColor()));
            mTableItemAttr.setTextSize(typedArray.getDimensionPixelSize(R.styleable.YTableView_table_textSize, mTableItemAttr.getTextSize()));
            mTableItemAttr.setTextMarginTop(typedArray.getDimensionPixelSize(R.styleable.YTableView_table_textMarginTop, mTableItemAttr.getTextMarginTop()));
            mTableItemAttr.setImageWidth(typedArray.getDimensionPixelSize(R.styleable.YTableView_table_imageWidth, mTableItemAttr.getImageWidth()));
            mTableItemAttr.setImageHeight(typedArray.getDimensionPixelSize(R.styleable.YTableView_table_imageHeight, mTableItemAttr.getImageHeight()));
            typedArray.recycle();
        }
    }

    private void initViews() {
        mContainer = new LinearLayout(this.getContext());
        mContainer.setLayoutParams(new LayoutParams(-1, -2));
        mContainer.setOrientation(LinearLayout.VERTICAL);
        this.addView(mContainer);
    }

    public void setItemHeight(int itemHeight) {
        this.setItemHeight(itemHeight, true);
    }

    public void setItemHeight(int itemHeight, boolean isDp) {
        mTableItemHeight = isDp ? YDesityUtil.dp2px(getContext(), itemHeight) : itemHeight;
    }

    public void setColumnCount(int columnCount) {
        if (mColumnCount != columnCount) {
            mColumnCount = columnCount < 1 ? 1 : (columnCount > 6 ? 6 : columnCount);
        }
    }

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.mListener = listener;
    }

    public void setmImageLoader(ImageLoader imageLoader) {
        this.mImageLoader = imageLoader;
    }

    /**
     * 设置表格项
     * @param tableItems
     */
    public void setTableItems(List<YTableItem> tableItems) {
        for (YTableItemView itemView : mTableItemViews) {
            LinearLayout parent = (LinearLayout)itemView.getParent();
            if (parent != null) {
                parent.removeView(itemView);
            }
        }
        mTableItemViews.clear();
        mContainer.removeAllViews();
        if (tableItems != null && tableItems.size() > 0) {
            for (YTableItem tableItem : tableItems) {
                YTableItemView tableItemView = new YTableItemView(this.getContext());
                tableItemView.setLayoutParams(new LinearLayout.LayoutParams(0, mTableItemHeight, 1));
                tableItemView.setTableItem(tableItem, mTableItemAttr);
                tableItemView.setTag(tableItem.getTag());
                tableItemView.setOnClickListener(mListener);
                mTableItemViews.add(tableItemView);
                if (mImageLoader != null) {
                    mImageLoader.displayImage(tableItemView.getImageView(), tableItem);
                }
            }
        }
        this.layoutSubViews();
    }

    private void layoutSubViews() {
        if (mTableItemViews.size() > 0) {
            int row = ((mTableItemViews.size() - 1) / mColumnCount) + 1;
            for (int i = 0; i < row; i++) {
                LinearLayout layout = new LinearLayout(this.getContext());
                layout.setLayoutParams(new LayoutParams(-1, -2));
                mContainer.addView(layout);
                for (int j = 0; j < mColumnCount; j++) {
                    int index = i * mColumnCount + j;
                    if (index < mTableItemViews.size()) {
                        layout.addView(mTableItemViews.get(index));
                    } else {
                        layout.addView(new View(getContext()), new LinearLayout.LayoutParams(0, mTableItemHeight, 1));
                    }
                }
            }
        }
    }

    public YTableItemAttr getmTableItemAttr() {
        return mTableItemAttr;
    }

    public List<YTableItemView> getTableItemViews() {
        return mTableItemViews;
    }
}
