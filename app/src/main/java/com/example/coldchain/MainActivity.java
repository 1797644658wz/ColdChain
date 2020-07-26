package com.example.coldchain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.coldchain.database_Test.MyDatabaseHelper;
import com.example.coldchain.util.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg;
    RadioButton buy_radioButton, sell_radioButton;
    Button login, regist;
    private MyDatabaseHelper databaseHelper;
    EditText username_login;
    EditText password_login;

    CheckBox auto_login, rem_password_checkbox;

    SharedPreferences preferences;
    /* SharedPreferences preferences_domestic;*/

    SharedPreferences.Editor editor;
    /*SharedPreferences.Editor editor_domestic;*/

    String transport_name;
    String domestic_name;

    String transport_pwd;
    String domestic_pwd;

    Boolean isremember_password_transport;
    Boolean isremember_password_domestic;
    Boolean isautologin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

        preferences = this.getSharedPreferences("userInfo", MODE_PRIVATE);

        isremember_password_transport = preferences.getBoolean("remember_password_transport", false);
        isremember_password_domestic = preferences.getBoolean("remember_password_domestic", false);
        isautologin = preferences.getBoolean("auto_login", false);


        StatusBarUtil.fullScreen(this);
        rg.setOnCheckedChangeListener(new MyRadioButtonListener());
        databaseHelper = new MyDatabaseHelper(this, "coldchain.db", null, 1);

        if (isremember_password_transport) {
            transport_name = preferences.getString("transport_name", "");
            transport_pwd = preferences.getString("transport_pwd", "");
            username_login.setText(transport_name);
            password_login.setText(transport_pwd);
            rem_password_checkbox.setChecked(true);
        } else if (isremember_password_domestic) {
            domestic_name = preferences.getString("domestic_name", "");
            domestic_pwd = preferences.getString("domestic_pwd", "");
            username_login.setText(domestic_name);
            password_login.setText(domestic_pwd);
            rem_password_checkbox.setChecked(true);
        }


    }

    private void initview() {
        rg = findViewById(R.id.radio_group);
        buy_radioButton = findViewById(R.id.buy);
        sell_radioButton = findViewById(R.id.sell);
        login = findViewById(R.id.login);
        regist = findViewById(R.id.regist);
        username_login = findViewById(R.id.username_login);
        password_login = findViewById(R.id.password_login);
        auto_login = findViewById(R.id.auto_login);
        rem_password_checkbox = findViewById(R.id.rem_password_checkbox);
        regist.setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist:
                Intent register = new Intent(this, RegisterActivity.class);
                startActivity(register);
                break;
        }
    }

    class MyRadioButtonListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.buy:
                    buy_radioButton.setChecked(true);
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = username_login.getText().toString();
                            String password = password_login.getText().toString();

                            if (name.length() == 0 && password.length() == 0) {
                                Toast.makeText(MainActivity.this, "账号密码不能为空！", Toast.LENGTH_SHORT).show();
                            } else {
                                if (Checkusername_buy(name, password)) {
                                    Intent main_Activity = new Intent(MainActivity.this, Buy_Activity.class);
                                    startActivity(main_Activity);
                                    Toast.makeText(MainActivity.this, "运输登录成功！", Toast.LENGTH_SHORT).show();
                                    if (rem_password_checkbox.isChecked()) {
                                        editor = preferences.edit();
                                        editor.putBoolean("remember_password_transport", true);
                                        editor.putString("transport_name", name);
                                        editor.putString("transport_pwd", password);
                                        Toast.makeText(MainActivity.this, "transport自动登录已选中！", Toast.LENGTH_SHORT).show();
                                    } else {
                                        editor.clear();
                                    }
                                    editor.commit();
                                    finish();//关闭
                                } else {
                                    Toast.makeText(MainActivity.this, "账号或密码错误，请重新输入：", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                    break;
                case R.id.sell:
                    sell_radioButton.setChecked(true);
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = username_login.getText().toString();
                            String password = password_login.getText().toString();

                            if (name.length() == 0 && password.length() == 0) {
                                Toast.makeText(MainActivity.this, "账号密码不能为空！", Toast.LENGTH_SHORT).show();
                            } else {
                                if (Checkusername_sell(name, password)) {
                                    Intent main_Activity = new Intent(MainActivity.this, Sell_Activity.class);
                                    startActivity(main_Activity);
                                    Toast.makeText(MainActivity.this, "普通用户登录成功！", Toast.LENGTH_SHORT).show();
                                    if (rem_password_checkbox.isChecked()) {
                                        editor = preferences.edit();
                                        editor.putBoolean("remember_password_domestic", true);
                                        editor.putString("domestic_name", name);
                                        editor.putString("domestic_pwd", password);
                                        Toast.makeText(MainActivity.this, "domestic自动登录已选中！", Toast.LENGTH_SHORT).show();
                                    } else {
                                        editor.clear();
                                    }
                                    editor.commit();
                                    finish();//关闭

                                } else {
                                    Toast.makeText(MainActivity.this, "账号或密码错误，请重新输入：", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                    break;
            }
        }

        //验证登录
        public boolean Checkusername_buy(String username, String password) {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            String sql = "select*from transport_user where name=? and password=?";
            Cursor cursor = db.rawQuery(sql, new String[]{username, password});
            if (cursor.moveToFirst()) {
                cursor.close();
                return true;
            }
            return false;
        }

        public boolean Checkusername_sell(String username, String password) {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            String sql = "select*from domestic_user where name=? and password=?";
            Cursor cursor = db.rawQuery(sql, new String[]{username, password});
            if (cursor.moveToFirst()) {
                cursor.close();
                return true;
            }
            return false;
        }
    }

}
