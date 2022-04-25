package com.internshala.foodrunner.fragment


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity

import com.internshala.foodrunner.R
import com.internshala.foodrunner.activity.RefundStatusActivity
import com.internshala.foodrunner.activity.SafetyStandardsActivity
import com.internshala.foodrunner.util.DrawerLocker
import java.lang.reflect.Array.newInstance

class ProfileFragment : Fragment() {

    private lateinit var txtUserName: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtAddress: TextView
    private lateinit var txtEmail: TextView
    private lateinit var sharedPrefs: SharedPreferences

     lateinit var txtProfile1: TextView
     lateinit var txtProfile2: TextView
     lateinit var txtProfile3: TextView
     lateinit var txtProfile4: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        (activity as DrawerLocker).setDrawerEnabled(true)
        sharedPrefs = (activity as FragmentActivity).getSharedPreferences("FoodApp", Context.MODE_PRIVATE)
        txtUserName = view.findViewById(R.id.txtUserName)
        txtPhone = view.findViewById(R.id.txtPhone)
        txtEmail = view.findViewById(R.id.txtEmail)
        txtAddress = view.findViewById(R.id.txtAddress)

        txtProfile1 = view.findViewById(R.id.txtProfile1) as TextView
        txtProfile2 = view.findViewById(R.id.txtProfile2) as TextView
        txtProfile3 = view.findViewById(R.id.txtProfile3) as TextView
        txtProfile4 = view.findViewById(R.id.txtProfile4) as TextView

        txtUserName.text = sharedPrefs.getString("user_name", null)
        val phoneText = "+91-${sharedPrefs.getString("user_mobile_number", null)}"
        txtPhone.text = phoneText
        txtEmail.text = sharedPrefs.getString("user_email", null)
        val address = sharedPrefs.getString("user_address", null)
        txtAddress.text = address

        openLinks()

        return view
    }

    private fun openLinks(){
        txtProfile1.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frame,OrderHistoryFragment())?.commit()
        }

        txtProfile2.setOnClickListener {
            val intent = Intent(this@ProfileFragment.context, RefundStatusActivity::class.java)
            startActivity(intent)
        }

        txtProfile4.setOnClickListener{
            fragmentManager?.beginTransaction()?.replace(R.id.frame,FAQFragment())?.commit()
        }

        txtProfile3.setOnClickListener{
            fragmentManager?.beginTransaction()?.replace(R.id.frame,FavouritesFragment())?.commit()
        }
    }

}
