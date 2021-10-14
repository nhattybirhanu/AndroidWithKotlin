package com.natnaelAjema.mycv.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.natnaelAjema.mycv.Modele.WorkExperiance_data
import com.natnaelAjema.mycv.R
import kotlinx.android.synthetic.main.work_exprinceeditor.*

class WorkExperienceEditor:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_exprinceeditor)
    }
    fun save(view: View){


        var  experienc= WorkExperiance_data(et_language.text.toString(),et_wab.text.toString(),et_db.text.toString(),et_tool.text.toString(),et_cnote.text.toString(),et_cname.text.toString(),et_cadd.text.toString(),et_title.text.toString(),et_resp.text.toString(),et_tech.text.toString())
        Log.i("experienc",experienc.toString());
    }
    fun  showMessage(message:String){
    }
}