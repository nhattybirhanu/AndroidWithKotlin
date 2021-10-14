package com.natnaelAjema.mycv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.natnaelAjema.mycv.Adapter.FragmentPageAdapter
import com.natnaelAjema.mycv.activity.ContactEditor
import com.natnaelAjema.mycv.activity.WorkExperienceEditor
import com.natnaelAjema.mycv.fragments.AboutMeFragment
import com.natnaelAjema.mycv.fragments.ContactFragment
import com.natnaelAjema.mycv.fragments.Home
import com.natnaelAjema.mycv.fragments.WorkExperience

class MainActivity : AppCompatActivity() {
    lateinit var viewPage: ViewPager;
    lateinit var tabLayout:TabLayout;
    lateinit var adapter: FragmentPageAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPage=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab)
        adapter= FragmentPageAdapter(supportFragmentManager)
        adapter.add(Home(),"Home")
        adapter.add(WorkExperience(),"Experience")
        adapter.add(AboutMeFragment(),"About")
        adapter.add(ContactFragment(),"Contact");
        viewPage.adapter=adapter;
        tabLayout.setupWithViewPager(viewPage)



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


override fun onOptionsItemSelected(item: MenuItem):Boolean {
   when(item.itemId){
       R.id.m_contact->{
           val intent = Intent(this,ContactEditor::class.java);
                startActivity(intent)
       }
       R.id.m_experience->{
           val intent = Intent(this, WorkExperienceEditor::class.java)
           startActivity(intent)
       }
   }

    return true


}}