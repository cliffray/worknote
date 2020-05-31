package com.project.worknote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Boolean firstTime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp1 = findViewById(R.id.sp1);
        Button btAdd = findViewById(R.id.btnAdd);
        Button btRe = findViewById(R.id.btnRe);

        //手動製造資料
        ArrayList<Data> mData = new ArrayList<>();
        mData.add(new Data("台北市",1111));
        mData.add(new Data("高雄市",2222));

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.workArray, android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adapter);

        final ArrayList arrayList = new ArrayList<Integer>();
        for(int i=0; i<5; i++){
            arrayList.add(i);
        }//製作陣列
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstTime){
                    firstTime = false;
                }else {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //按鈕控制
        btAdd.setOnClickListener((v)->{
            arrayList.add(arrayList.size());
        });
        btRe.setOnClickListener((v -> {
            if (arrayList.size()!=0){
                arrayList.remove(arrayList.size()-1);
            }
        }));
        /*
        //建立spinner
        Spinner spinner = findViewById(R.id.spinner);
        WorkSpinnerAdapter nAdapter = new WorkSpinnerAdapter(this,mData); //自定義ArrayAdapter
        spinner.setAdapter(nAdapter);

        //設置Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvInfo = findViewById(R.id.textView);
                Data mData = (Data) parent.getItemAtPosition(position);
                tvInfo.setText("地點:\t" + mData.getLaction() + "\n"
                + "TVID:\t" + mData.getTVID());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });//點擊事件
    }
    //自定義ArrayAdapter,方法為繼承原有的ArrayAdapter後修改他的介面
    private class WorkSpinnerAdapter extends ArrayAdapter{
        //建構子
        public WorkSpinnerAdapter(@NonNull Context context, @NonNull List<Data> mData){
            super(context, 0, mData);
        }

        @NonNull
        @Override
        public View getView(int postition, @NonNull View convertView, @NonNull ViewGroup parent){
            return createView(postition, convertView, parent,false);
        }
        //getDropDownView為設置點開後的畫面
        @Override
        public View getDropDownView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            return createView(position, convertView, parent,true);
        }

        //因為兩個介面通常都長差不多...所以新增介面的我把它寫在一起，差別只在最後的true/false
        @SuppressLint("SetTextI18n")
        private View createView(int position, View convertView, ViewGroup parent,Boolean ageDisplay){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_item, parent, false);
            TextView tvName = convertView.findViewById(R.id.textViewTitle);
            TextView tvAge = convertView.findViewById(R.id.textViewAge);
            Data item = (Data) getItem(position);
            if (item != null) {
                tvName.setText(item.getLaction());
                tvAge.setText(item.getTVID()+"y");
                if (ageDisplay) tvAge.setVisibility(View.VISIBLE);
                else tvAge.setVisibility(View.GONE);

            }
            return convertView;
        }//複寫介面*/
    }//class MySpinnerAdapter

}
