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
import com.example.appdemo.Class.QLVouCher;
import com.example.appdemo.Class.Voucher;
import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

public class QLVoucherActivity extends AppCompatActivity {

    ListView mListView;
    Toolbar mToolBar;
    EditText edtMVCh, edtGiam, edtHSD;
    Button btnXoa,btnSua,btnThem,btnHienthi;
    QLVouCher qlVouCher;
    List<String> list = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlvoucher);
        mListView = (ListView) findViewById(R.id.listVC);
        mToolBar = (Toolbar) findViewById(R.id.toolbarAC);
        edtMVCh = (EditText) findViewById(R.id.edtMVC);
        edtGiam = (EditText) findViewById(R.id.edtGiam);
        edtHSD = (EditText) findViewById(R.id.edtHSD);
        btnXoa = (Button) findViewById(R.id.btnXoa);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnHienthi = (Button) findViewById(R.id.btnShow);
        setSupportActionBar(mToolBar);
        //hiển thị dữ liệu khi chạy chương trình
        qlVouCher = new QLVouCher(QLVoucherActivity.this);
        list= qlVouCher.getAllVoucherToString();
        ArrayAdapter adapter =new ArrayAdapter(QLVoucherActivity.this, android.R.layout.simple_list_item_1,list);
        mListView.setAdapter(adapter);
        //button hiển thị
        btnHienthi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qlVouCher = new QLVouCher(QLVoucherActivity.this);
                list = qlVouCher.getAllVoucherToString();
                ArrayAdapter adapter =new ArrayAdapter(QLVoucherActivity.this, android.R.layout.simple_list_item_1,list);
                mListView.setAdapter(adapter);
            }
        });
        //button thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Voucher s = new Voucher();// tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                s.setMAVOUCHER(edtMVCh.getText().toString());
                s.setGIAM(Integer.parseInt(edtGiam.getText().toString()));
                s.setHANSD(edtHSD.getText().toString());
                //gọi hàm thêm
                int kq = qlVouCher.ThemVoucher(s);
                if(kq==-1){
                    Toast.makeText(QLVoucherActivity.this,"Thêm thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLVoucherActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Button Xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String VOUVHER = edtMVCh.getText().toString();
                //gọi hàm Xóa
                int kq = qlVouCher.XoaVoucher(VOUVHER);
                if(kq==-1){
                    Toast.makeText(QLVoucherActivity.this,"Xóa thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLVoucherActivity.this,"Xóa thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
        //Button Sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Voucher s = new Voucher();// tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                s.setMAVOUCHER(edtMVCh.getText().toString());
                s.setGIAM(Integer.parseInt(edtGiam.getText().toString()));
                s.setHANSD(edtHSD.getText().toString());
                //gọi hàm thêm
                int kq = qlVouCher.SuaVoucher(s);
                if(kq==-1){
                    Toast.makeText(QLVoucherActivity.this,"Thêm thất bại",Toast.LENGTH_LONG).show();
                }
                if (kq==1){
                    Toast.makeText(QLVoucherActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
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
                Intent KH = new Intent(QLVoucherActivity.this, QLAccountActivity.class);
                startActivity(KH);
                return true;
            case R.id.QL:
                Intent QL = new Intent(QLVoucherActivity.this, AdminActivity.class);
                startActivity(QL);
                return true;
            case R.id.HoaDon:
                Intent HD = new Intent(QLVoucherActivity.this, QLHoaDonActivity.class);
                startActivity(HD);
                return true;
            case R.id.Logout:
                Intent Logout = new Intent(QLVoucherActivity.this, MainActivity.class);
                startActivity(Logout);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}