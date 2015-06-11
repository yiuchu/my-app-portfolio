package com.chu.cheung.yiu.myappportfolio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;
import java.util.ArrayList;

public class MyPortfolioItemsAdapter extends BaseAdapter implements ListAdapter {
    private Context context;
    private ArrayList<String> portfolioProjectNames;
    private ArrayList<String> projectButtonClickedMessages;

    public MyPortfolioItemsAdapter(Context context, ArrayList<String> portfolioProjectNames, ArrayList<String> projectButtonClickedMessages) {
        this.context = context;
        this.portfolioProjectNames = portfolioProjectNames;
        this.projectButtonClickedMessages = projectButtonClickedMessages;
    }

    @Override
    public int getCount() {
        return portfolioProjectNames!=null?portfolioProjectNames.size():0;
    }

    @Override
    public Object getItem(int pos) {
        return ((portfolioProjectNames!=null)&&(portfolioProjectNames.size()>pos))?portfolioProjectNames.get(pos):null;
    }

    @Override
    public long getItemId(int pos) {
        //return 0 as list items do not have an Id variable.
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_portfolio_list_item, null);
        }

        //Handle buttons and add onClickListeners
        Button portfolioAppBtn = (Button)view.findViewById(R.id.portfolio_app_btn);
        String thisProjectName = portfolioProjectNames.get(position);
        portfolioAppBtn.setText(thisProjectName);
        Resources res = context.getResources();
        portfolioAppBtn.getBackground().setColorFilter(thisProjectName.toUpperCase().contains("CAPSTONE") ? res.getColor(R.color.lightgreen500):
                res.getColor(R.color.lime500), PorterDuff.Mode.MULTIPLY);

        portfolioAppBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, projectButtonClickedMessages.get(position), duration);
                toast.show();
            }
        });

        return view;
    }
}