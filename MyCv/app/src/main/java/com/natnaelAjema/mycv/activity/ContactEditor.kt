package com.natnaelAjema.mycv.activity

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.natnaelAjema.mycv.Modele.Contact
import com.natnaelAjema.mycv.R
import kotlinx.android.synthetic.main.conatct_editor.*
import kotlinx.android.synthetic.main.contact.*

class ContactEditor:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conatct_editor)
        var contact=contact();
        if (contact!=null){
            et_Phone.setText(contact.Phone_number);
            et_email.setText(contact.email);
            et_linkedin.setText(contact.link_den);
            et_github.setText(contact.github);

        }
    }
    fun Cont_save(view: View){


        var  contact=Contact(et_Phone.text.toString(),et_email.text.toString(),et_linkedin.text.toString(),et_github.text.toString())
        save(contact)
        finish();
    }

    fun save(contact: Contact){
        var gson= Gson();

        var setting=getSharedPreferences(Contact::class.java.name, Context.MODE_PRIVATE).edit();
        var sContact=gson.toJson(contact);
        setting.putString("contact",sContact).apply();

    }

    fun contact():Contact?{
        var gson=Gson();
        var contact=getSharedPreferences(Contact::class.java.name,Context.MODE_PRIVATE)?.getString("contact","");
        return  gson.fromJson(contact,Contact::class.java)

    }



}