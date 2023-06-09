package com.example.exam_shop2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_product_main;
    EditText edit_count;
    TextView txt_price, txt_delivery, txt_pay;
    CheckBox chk_agree;

    ImageButton btn_minus, btn_plus;
    Button btn_pay;
    RadioButton radio1,radio2,radio3,radio4;

    int val_price;                  // 제품의 총 가격(배송비 미포함)
    int val_delivery;               // 배송비 ( 제품 총 가격이 10000원 이상이면 0원, 미만이면 2500원)
    int val_pay;                    // 총 결제 금액
    int selected_product=2000;      // 선택한 제품 한개의 가격
    int selected_count;             // 선택한 수량





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        img_product_main = findViewById(R.id.img_product_main);
        edit_count = findViewById(R.id.edit_count);
        txt_price = findViewById(R.id.txt_price);
        chk_agree = findViewById(R.id.chk_agree);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_pay = findViewById(R.id.txt_pay);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus= findViewById(R.id.btn_plus);

        btn_pay = findViewById(R.id.btn_pay);

        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        radio3.setOnClickListener(this);
        radio4.setOnClickListener(this);

        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);

        btn_pay.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.coffee1);
                selected_product = 2000;
                sumTotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.coffee2);
                selected_product = 3000;
                sumTotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.coffee3);
                selected_product = 4000;
                sumTotal();
                break;
            case R.id.radio4:
                img_product_main.setImageResource(R.drawable.coffee4);
                selected_product = 5000;
                sumTotal();
                break;
            case R.id.btn_minus:
                if(selected_count == 1)
                    Toast.makeText(getApplicationContext(), "주문할 수 있는 최소수량은 1개 입니다.", Toast.LENGTH_SHORT).show();
                else {
                    --selected_count;
                    edit_count.setText(String.valueOf(selected_count));
                    sumTotal();
                }
                break;
            case R.id.btn_plus:
                ++selected_count;
                edit_count.setText(String.valueOf(selected_count));
                sumTotal();
                break;
            case R.id.btn_pay:
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                if(chk_agree.isChecked() == false)
                    Toast.makeText(getApplicationContext(),  "결제 동의 버튼을 체크해주세요", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getApplicationContext(), val_pay + "원을 결제하겠습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                break;
        }
    }

    private void sumTotal() {
        int selected_count = Integer.parseInt(edit_count.getText().toString());

        val_price = selected_product * selected_count;

        if(val_price>=10000)
            val_delivery = 0;
        else
            val_delivery = 2500;

        val_pay = val_price + val_delivery;

        txt_price.setText(val_price + "원");
        txt_delivery.setText(val_delivery + "원");
        txt_pay.setText(val_pay + "원");

    }


}