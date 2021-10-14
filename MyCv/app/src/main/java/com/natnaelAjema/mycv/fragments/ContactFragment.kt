package com.natnaelAjema.mycv.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.natnaelAjema.mycv.Modele.Contact
import com.natnaelAjema.mycv.R

import kotlinx.android.synthetic.main.conatct_editor.*
import kotlinx.android.synthetic.main.contact.*

class ContactFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.contact,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        showContact()
    }

    fun  showContact(){
        var contact=contact();
        if (contact!=null){
            tv_phone.text=contact.Phone_number;
            tv_email.text=contact.email;
            tv_twitter.text=contact.github
            tv_linked.text=contact.link_den;
        }
    }

    fun contact():Contact?{
        var gson=Gson();
        var contact=context?.getSharedPreferences(Contact::class.java.name,Context.MODE_PRIVATE)?.getString("contact","");
        return  gson.fromJson(contact,Contact::class.java)

    }





}