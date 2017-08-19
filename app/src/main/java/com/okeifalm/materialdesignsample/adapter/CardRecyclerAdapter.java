package com.okeifalm.materialdesignsample.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.okeifalm.materialdesignsample.R;

/**
 * Created by keisuke on 2017/08/16.
 */

public class CardRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private String[] mDataset;

    public CardRecyclerAdapter(String[] myDataset, Context context) {
        super();
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 0;
        } else if (position % 3 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        switch (viewType) {
            case 0: {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.simple_card_view, parent, false);
                return new SimpleCardViewHolder(v);
            }
            case 1: {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.button_card_view, parent, false);
                return new ButtonCardViewHolder(v);
            }
            case 2: {
                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.support_text_card_view, parent, false);
                return new SupportTextCardViewHolder(v);
            }
            default: {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_card_view, parent, false);
                return new SimpleCardViewHolder(view);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof SimpleCardViewHolder) {
            SimpleCardViewHolder simpleCardViewHolder = (SimpleCardViewHolder) holder;
            simpleCardViewHolder.mTextView.setText(mDataset[position]);
            simpleCardViewHolder.mSubTitleTextView.setText("Subtitle here Subtitle here Subtitle here Subtitle here Subtitle here ");
            simpleCardViewHolder.mImageView.setImageResource(R.drawable.card_pic_04);
            simpleCardViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,mDataset[position],Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof ButtonCardViewHolder) {
            ButtonCardViewHolder buttonCardViewHolder = (ButtonCardViewHolder) holder;
            buttonCardViewHolder.mTextView.setText(mDataset[position]);
            buttonCardViewHolder.mSubTitleTextView.setText("Subtitle here Subtitle here Subtitle here Subtitle here Subtitle here ");
            buttonCardViewHolder.mImageView.setImageResource(R.drawable.card_pic_01);
            buttonCardViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,mDataset[position],Toast.LENGTH_SHORT).show();
                }
            });
            buttonCardViewHolder.mButton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context,"button1",Toast.LENGTH_SHORT).show();
                }
            });
            buttonCardViewHolder.mButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context,"button2",Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof SupportTextCardViewHolder) {
            SupportTextCardViewHolder supportTextCardViewHolder = (SupportTextCardViewHolder) holder;
            supportTextCardViewHolder.mTextView.setText(mDataset[position]);
            supportTextCardViewHolder.mSubTitleTextView.setText("Subtitle here Subtitle here Subtitle here Subtitle here Subtitle here ");
            supportTextCardViewHolder.mSupportTextView.setText("so it's a full string. I need to read it as a list of strings like. I tried the solution provided in this question but no luck there, since I have the [ and ] characters that actually mess up the things.");
            supportTextCardViewHolder.mImageView.setImageResource(R.drawable.card_pic_03);
            supportTextCardViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,mDataset[position],Toast.LENGTH_SHORT).show();
                }
            });
            supportTextCardViewHolder.mButton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context,"button1",Toast.LENGTH_SHORT).show();
                }
            });
            supportTextCardViewHolder.mButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context,"button2",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    private class SimpleCardViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextView;
        TextView mSubTitleTextView;
        ImageView mImageView;

        SimpleCardViewHolder(View v) {
            super(v);
            mCardView = (CardView)v.findViewById(R.id.simple_card_view);
            mTextView = (TextView)v.findViewById(R.id.info_text);
            mSubTitleTextView = (TextView)v.findViewById(R.id.sub_title_text);
            mImageView = (ImageView)v.findViewById(R.id.imageView);
        }
    }

    private class ButtonCardViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextView;
        TextView mSubTitleTextView;
        ImageView mImageView;
        Button mButton1;
        Button mButton2;

        public ButtonCardViewHolder(View v) {
            super(v);
            mCardView = (CardView)v.findViewById(R.id.button_card_view);
            mTextView = (TextView)v.findViewById(R.id.info_text);
            mSubTitleTextView = (TextView)v.findViewById(R.id.sub_title_text);
            mImageView = (ImageView)v.findViewById(R.id.imageView);
            mButton1 = (Button) v.findViewById(R.id.flat_button_1);
            mButton2 = (Button) v.findViewById(R.id.flat_button_2);
        }
    }

    private class SupportTextCardViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextView;
        TextView mSubTitleTextView;
        TextView mSupportTextView;
        ImageView mImageView;
        Button mButton1;
        Button mButton2;

        public SupportTextCardViewHolder(View v) {
            super(v);
            mCardView = (CardView)v.findViewById(R.id.support_text_card_view);
            mTextView = (TextView)v.findViewById(R.id.info_text);
            mSubTitleTextView = (TextView)v.findViewById(R.id.sub_title_text);
            mSupportTextView = (TextView)v.findViewById(R.id.support_text);
            mImageView = (ImageView)v.findViewById(R.id.imageView);
            mButton1 = (Button) v.findViewById(R.id.flat_button_1);
            mButton2 = (Button) v.findViewById(R.id.flat_button_2);
        }
    }
}
