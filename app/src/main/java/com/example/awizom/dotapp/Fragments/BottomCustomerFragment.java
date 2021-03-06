package com.example.awizom.dotapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awizom.dotapp.CustomerActivity;
import com.example.awizom.dotapp.OrderBottomActivity;
import com.example.awizom.dotapp.R;
import com.example.awizom.dotapp.ReportActivity;
import com.example.awizom.dotapp.StatusActivity;

public class BottomCustomerFragment extends Fragment implements View.OnClickListener {

    private TextView customerList, customerModify, customerAdd;
    private CardView cardViewFirst, cardViewSecond, cardViewthird;
    private Intent intent;
    private Fragment addCustomerFragment, modifyCustomerFragment, listCustomerFragment;
    Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_activity_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        customerList = view.findViewById(R.id.customerList);
        customerModify = view.findViewById(R.id.modifyCustomer);
        customerAdd = view.findViewById(R.id.addCustomer);

        cardViewFirst = view.findViewById(R.id.first_cardview);
        cardViewSecond = view.findViewById(R.id.second_cardview);
        cardViewthird = view.findViewById(R.id.third_cardview);

        addCustomerFragment = new AddCustomerFragment();
        modifyCustomerFragment = new ModifyCustomerFragment();
        listCustomerFragment = new CustomerListFrgment();

        customerList.setOnClickListener(this);
        customerModify.setOnClickListener(this);
        customerAdd.setOnClickListener(this);

        cardViewFirst.setOnClickListener(this);
        cardViewSecond.setOnClickListener(this);
        cardViewthird.setOnClickListener(this);

        BottomNavigationView navigation = view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public void onClick(View v) {

        Class fragmentClass = null;
        switch (v.getId()) {
            case R.id.first_cardview:

                fragment = addCustomerFragment;
                fragmentClass = AddCustomerFragment.class;
                break;
            case R.id.second_cardview:

                fragment = modifyCustomerFragment;
                fragmentClass = ModifyCustomerFragment.class;
                break;
            case R.id.third_cardview:

                fragment = listCustomerFragment;
                fragmentClass = CustomerListFrgment.class;
                break;
            case R.id.customerList:

                fragmentClass = CustomerListFrgment.class;
                break;
            case R.id.orderCreate:

                fragmentClass = AddCustomerFragment.class;
                break;

            case R.id.modifyCustomer:
                fragment = modifyCustomerFragment;
                fragmentClass = ModifyCustomerFragment.class;
                break;
            case R.id.addCustomer:

                fragmentClass = AddCustomerFragment.class;
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_customer:
                    startActivity(intent = new Intent(getContext(), CustomerActivity.class));
                    return true;
                case R.id.navigation_order:
                    startActivity(intent = new Intent(getContext(), OrderBottomActivity.class));
                    return true;
                case R.id.navigation_report:
                    startActivity(intent = new Intent(getContext(), ReportActivity.class));
                    return true;
                case R.id.navigation_status:
                    startActivity(intent = new Intent(getContext(), StatusActivity.class));
                    return true;
            }
            return false;
        }
    };
}
