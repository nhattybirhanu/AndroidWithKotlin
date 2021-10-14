package com.natnaelAjema.mycv.Modele

data class WorkExperiance_data(var language:String, var web:String, var db:String, var tool:String, var note:String, var company_name:String, var address:String, var title:String, var resp:String, var tech:String) {

    override fun toString(): String {
        return "WorkExperiance_data(language='$language', web='$web', db='$db', tool='$tool', note='$note', company_name='$company_name', address='$address', title='$title', resp='$resp', tech='$tech')"
    }
}