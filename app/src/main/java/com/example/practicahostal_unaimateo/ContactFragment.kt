package com.example.practicahostal_unaimateo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicahostal_unaimateo.databinding.FragmentContactBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
    lateinit var binding:FragmentContactBinding
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(inflater,container,false)
        binding.sendButton.setOnClickListener {
            if(binding.contactNameText.text!!.isNotBlank() && binding.contactEmailText.text!!.isNotBlank() && binding.contactTelephoneText.text!!.isNotBlank()){
                Toast.makeText(this.context,"Messatge enviat correctament",Toast.LENGTH_LONG).show()
                binding.contactNameText.setText("")
                binding.contactEmailText.setText("")
                binding.contactTelephoneText.setText("")
                binding.contactMessageText.setText("")
            }else{
                Toast.makeText(this.context,"Falta informacio per enviar el missatge",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }


}