package com.natnaelAjema.mycv.Modele

data class Contact(var Phone_number:String, var email:String, var link_den:String, var github:String){
    override fun toString(): String {
        return "Contact(Phone_number='$Phone_number', email='$email', facebook='$link_den', twitter='$github')"
    }
}
