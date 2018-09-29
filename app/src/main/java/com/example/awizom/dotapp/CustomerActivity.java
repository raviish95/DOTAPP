package com.example.awizom.dotapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.awizom.dotapp.Fragments.AddCustomerFragment;
import com.example.awizom.dotapp.Fragments.CustomerListFrgment;
import com.example.awizom.dotapp.Fragments.ModifyCustomerFragment;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView customerList,customerModify,customerAdd;
    private Intent intent;
    private Fragment addCustomerFragment,modifyCustomerFragment,listCustomerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_layout);
        initView();
    }

    private void initView() {
        customerList = findViewById(R.id.customerList);
        customerModify = findViewById(R.id.customerModify);
        customerAdd = findViewById(R.id.customerAdd);

        addCustomerFragment = new AddCustomerFragment();
        modifyCustomerFragment = new ModifyCustomerFragment();
        listCustomerFragment = new CustomerListFrgment();

        customerList.setOnClickListener(this);
        customerModify.setOnClickListener(this);
        customerAdd.setOnClickListener(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Class fragmentClass = null;
            switch (item.getItemId()) {
                case R.id.navigation_customer:
                    startActivity(intent = new Intent(getApplicationContext(),CustomerActivity.class));
                    return true;
                case R.id.navigation_order:
                    startActivity(intent = new Intent(getApplicationContext(),OrderBottomActivity.class));
                    return true;
                case R.id.navigation_report:
                    startActivity(intent = new Intent(getApplicationContext(),ReportActivity.class));
                    return true;
                case R.id.navigation_status:
                    startActivity(intent = new Intent(getApplicationContext(),StatusActivity.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onClick(View v) {
        Class fragment = null;
        switch (v.getId()){
            case R.id.customerList:
                fragment = AddCustomerFragment.class;
                break;
            case R.id.customerModify:
                fragment = ModifyCustomerFragment.class;
                break;
            case R.id.customerAdd:
                fragment = AddCustomerFragment.class;
                break;
        }
    }


}
