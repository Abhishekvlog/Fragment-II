package com.example.fragment_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnAddA;
    private Button mBtnAddB;
    private Button mBtnRemoveA;
    private Button mBtnRemoveB;
    private Button mBtnReplaceAwithBwhithoutBackStack;
    private Button mBtnReplaceAToBWithBackStack;
    private Button mBtnReplaceBWithA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAwithBwhithoutBackStack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceAToBWithBackStack = findViewById(R.id.btnReplaceAWithBackStack);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(MainActivity.this);
        mBtnAddB.setOnClickListener(MainActivity.this);
        mBtnRemoveA.setOnClickListener( MainActivity.this);
        mBtnRemoveB.setOnClickListener( MainActivity.this);
        mBtnReplaceAwithBwhithoutBackStack.setOnClickListener(MainActivity.this);
        mBtnReplaceAToBWithBackStack.setOnClickListener(MainActivity.this);
        mBtnReplaceBWithA.setOnClickListener(MainActivity.this);

    }
    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                btnRemoveA();
                break;
            case R.id.btnRemoveB:
                btnRemoveB();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                btnReplaceAWithBWithoutBackstack();
                break;
            case R.id.btnReplaceAWithBackStack:
                btnReplaceAWithBackStack();
                break;
            case R.id.btnReplaceBWithA:
                btnReplaceBWithA();
                break;
        }
    }

    private void btnReplaceBWithA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.replace(R.id.flContainer,fragmentA,"fragmentB").commit();


    }

    private void btnReplaceAWithBackStack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer,fragmentB,"fragmentB").addToBackStack("fragB").commit();


    }

    private void btnReplaceAWithBWithoutBackstack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer,fragmentB,"fragmentB").commit();

    }

    private void btnRemoveB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if (fragmentB != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void btnRemoveA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if (fragmentA != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void addB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer,fragmentB,"fragmentB").commit();
    }

    private void addA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.flContainer,fragmentA,"fragmentA").commit();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        
    }
}