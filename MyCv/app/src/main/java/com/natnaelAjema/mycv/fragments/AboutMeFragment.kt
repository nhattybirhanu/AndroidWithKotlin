package com.natnaelAjema.mycv.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.natnaelAjema.mycv.Modele.About
import com.natnaelAjema.mycv.Modele.Contact
import com.natnaelAjema.mycv.R
import kotlinx.android.synthetic.main.about_me.*

class AboutMeFragment:Fragment(),View.OnClickListener {
    interface  TextResult{fun  result(text:String)}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.about_me,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAbout(about())
        e_education.setOnClickListener(this)
        e_person.setOnClickListener(this)
        e_strength.setOnClickListener(this)
        e_weaknes.setOnClickListener(this)
    }


    fun inputDialog(title:String,textResult: TextResult){
        var dialog=AlertDialog.Builder(requireContext());
        dialog.setTitle("Enter about your  ${title}");
        var editText=EditText(context);
        editText.setHint(title)
        dialog.setView(editText);

        dialog.setPositiveButton("Enter", DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i: Int ->
            if (editText.text.isNotEmpty()) textResult.result(editText.text.toString())
            dialogInterface.dismiss()

        })
        dialog.setNegativeButton("Cancle", DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()

        })
        dialog.show()
    }
    fun save(about:About){
        var gson= Gson();

        var setting=context?.getSharedPreferences(About::class.java.name, Context.MODE_PRIVATE)?.edit();
        var sContact=gson.toJson(about);
        setting?.putString("about",sContact)?.apply();
        showAbout(about)
    }

    fun about():About?{
        var gson= Gson();
        var about=context?.getSharedPreferences(About::class.java.name, Context.MODE_PRIVATE)?.getString("about","");
        return  gson.fromJson(about, About::class.java)

    }
    fun showAbout(about: About?){
        if (about!=null){
            body_one.text=about.eduaction;
            body_two.text=about.perosnal;
            body_three.text=about.strength;
            body_four.text=about.weakness;
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.e_education->
            {
                inputDialog("Eduction",object :TextResult{ override fun result(text: String) {
                    var about=about();
                    if (about==null) about= About("","","","");
                        about.eduaction=text;
                        save(about)

                }
                })
            }
            R.id.e_strength->{
                inputDialog("Strength",object :TextResult{ override fun result(text: String) {
                    var about=about();
                    if (about==null) about= About("","","","");
                        about!!.strength=text;
                        save(about!!)

                }
                })
            }
            R.id.e_weaknes->{
                inputDialog("Weakness",object :TextResult{ override fun result(text: String) {
                    var about=about();
                    if (about==null) about= About("","","","");
                        about!!.weakness=text;
                        save(about!!)

                }
                })
            }
            R.id.e_person->{
                inputDialog("Personal",object :TextResult{ override fun result(text: String) {
                    var about=about();
                    if (about==null) about=About("","","","");
                        about!!.perosnal=text;
                        save(about!!)

                }
                })
            }
        }

    }

}