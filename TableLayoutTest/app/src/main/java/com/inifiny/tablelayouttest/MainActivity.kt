package com.inifiny.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var table:TableLayout?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        table=findViewById(R.id.table);
    }
    fun addNewTableRow(view:View){
        if (version_code.text.isNotEmpty()&& version_name.text.isNotEmpty())
        let {
            var row=TableRow(this);
            var versioncode=TextView(this);
            val versionname=TextView(this);
            versioncode.text=version_code.text;
            versionname.text=version_name.text;
            row.addView(versioncode);
            row.addView(versionname);
            versioncode.gravity=Gravity.CENTER;
            versionname.gravity=Gravity.CENTER;
            val padding=8;
            versioncode.setPadding(padding,padding,padding,padding);
            versionname.setPadding(padding,padding,padding,padding);

            table?.addView(row);
        }else Toast.makeText(this,"Please enter name or code in input filed",Toast.LENGTH_SHORT).show();
    }

}