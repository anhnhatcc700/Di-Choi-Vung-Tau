package com.example.appdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appdemo.Class.Account;
import com.example.appdemo.Class.QLAccount;
import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

public class QLAccountActivity extends AppCompatActivity {
    ListView mListView;
    Toolbar mToolBar;
    EditText edtTK, edtMK, edtRole, edtTen, edtSDT, edtGmail, edtDChi;
    Button btnXoa,btnSua,btnThem,btnHienthi;
    QLAccount qlAccount;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlaccount);
        mListView = (ListView) findViewById(R.id.listAC);
        mToolBar = (Toolbar) findViewById(R.id.toolbarAC);
        edtTK = (EditText) findViewById(R.id.edtTKAC);
        edtMK = (EditText) findViewById(R.id.edtMK);
        edtRole = (EditText) findViewById(R.id.edtQHan);
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtSDT = (EditText) findViewById(R.id.edtSĐT);
        edtGmail = (EditText) findViewById(R.id.edtGmail);
        edtDChi = (EditText) findViewById(R.id.edtĐC);
        btnXoa = (Button) findViewById(R.id.btnXoaAC);
        btnSua = (Button) findViewById(R.id.btnSuaAC);
        btnThem = (Button) findViewById(R.id.btnThemAC);
        btnHienthi = (Button) findViewById(R.id.btnShowAC);
        setSupportActionBar(mToolBar);
        //hiển thị dữ liệu khi chạy chương trình
        qlAccount = new QLAccount(QLAccountActivity.this);
        list=qlAccount.getAllAccountToString();
        ArrayAdapter adapter =new ArrayAdapter(QLAccountActivity.this, android.R.layout.simple_list_item_1,list);
        mListView.setAdapter(adapter);

        //button hiển thị
        btnHienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qlAccount = new QLAccount(QLAccountActivity.this);
                list = qlAccount.getAllAccountToString();
                ArrayAdapter adapter =new ArrayAdapter(QLAccountActivity.this, android.R.layout.simple_list_item_1,list);
                mListView.setAdapter(adapter);
            }
        });
        //button thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account s = new Account();// tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                s.setTAIKHOAN(edtTK.getText().toString());
                s.setMATKHAU(edtMK.getText().toString());
                s.setQUYENHAN(edtRole.getText().toString());
                s.setTEN(edtTen.getText().toString());
                s.setSDT(Integer.parseInt(edtSDT.getText().toString()));
                s.setDIACHI(edtDChi.getText().toString());
                s.setGMAIL(edtGmail.getText().toString());
                //gọi hàm thêm
                int kq = qlAccount.ThemAccount(s);
                if(kq==-1){
                    Toast.makeText(QLAccountActivity.this,"Thêm thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLAccountActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Button Xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TAIKHOAN = edtTK.getText().toString();
                //gọi hàm Xóa
                int kq = qlAccount.XoaAccount(TAIKHOAN);
                if(kq==-1){
                    Toast.makeText(QLAccountActivity.this,"Xóa thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLAccountActivity.this,"Xóa thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Button Sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account s = new Account();// tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                s.setTAIKHOAN(edtTK.getText().toString());
                s.setMATKHAU(edtMK.getText().toString());
                s.setQUYENHAN(edtRole.getText().toString());
                s.setTEN(edtTen.getText().toString());
                s.setSDT(Integer.parseInt(edtSDT.getText().toString()));
                s.setDIACHI(edtDChi.getText().toString());
                s.setGMAIL(edtGmail.getText().toString());
                //gọi hàm thêm
                int kq = qlAccount.SuaAccount(s);
                if(kq==-1){
                    Toast.makeText(QLAccountActivity.this,"Thêm thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLAccountActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadmin, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.KH:
                Intent KH = new Intent(QLAccountActivity.this, QLAccountActivity.class);
                startActivity(KH);
                return true;
            case R.id.QL:
                Intent QL = new Intent(QLAccountActivity.this, AdminActivity.class);
                startActivity(QL);
                return true;
            case R.id.SanPham:
                Intent HD = new Intent(QLAccountActivity.this, QLHoaDonActivity.class);
                startActivity(HD);
                return true;
            case R.id.Logout:
                Intent Logout = new Intent(QLAccountActivity.this, MainActivity.class);
                startActivity(Logout);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}

