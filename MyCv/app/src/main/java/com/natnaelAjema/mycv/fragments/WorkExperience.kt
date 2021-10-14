package com.natnaelAjema.mycv.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.natnaelAjema.mycv.Modele.Contact
import com.natnaelAjema.mycv.Modele.WorkExperiance_data
import com.natnaelAjema.mycv.R
import kotlinx.android.synthetic.main.conatct_editor.*
import kotlinx.android.synthetic.main.work_exprinceeditor.*

class WorkExperience:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.work_exprince,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}