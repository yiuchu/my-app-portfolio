package com.chu.cheung.yiu.myappportfolio;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate custom adapter
        MyPortfolioItemsAdapter myPortfolioItemsAdapter = new MyPortfolioItemsAdapter(this, getPortfolioProjectNames(), getProjectButtonClickedMessages());

        //handle listview and assign adapter
        ListView portfolioListView = (ListView)findViewById(R.id.my_app_portfolio_listView);
        portfolioListView.setAdapter(myPortfolioItemsAdapter);
    }

    private ArrayList<String> getPortfolioProjectNames(){
        Resources res = getResources();
        ArrayList<String> portfolioProjectNames = new ArrayList<String>();
        portfolioProjectNames.add(res.getString(R.string.project_1_name));
        portfolioProjectNames.add(res.getString(R.string.project_2_name));
        portfolioProjectNames.add(res.getString(R.string.project_3_name));
        portfolioProjectNames.add(res.getString(R.string.project_4_name));
        portfolioProjectNames.add(res.getString(R.string.project_5_name));
        portfolioProjectNames.add(res.getString(R.string.project_6_name));
        return portfolioProjectNames;
    }

    private ArrayList<String> getProjectButtonClickedMessages(){
        Resources res = getResources();
        ArrayList<String> projectButtonClickedMessages = new ArrayList<String>();
        projectButtonClickedMessages.add(res.getString(R.string.project_1_button_clicked_message));
        projectButtonClickedMessages.add(res.getString(R.string.project_2_button_clicked_message));
        projectButtonClickedMessages.add(res.getString(R.string.project_3_button_clicked_message));
        projectButtonClickedMessages.add(res.getString(R.string.project_4_button_clicked_message));
        projectButtonClickedMessages.add(res.getString(R.string.project_5_button_clicked_message));
        projectButtonClickedMessages.add(res.getString(R.string.project_6_button_clicked_message));
        return projectButtonClickedMessages;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
