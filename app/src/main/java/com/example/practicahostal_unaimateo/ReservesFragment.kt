package com.example.practicahostal_unaimateo

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import com.example.practicahostal_unaimateo.databinding.FragmentReservesBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CalendarConstraints.DateValidator
import com.google.android.material.datepicker.MaterialDatePicker
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReservesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReservesFragment : Fragment() {
    lateinit var binding: FragmentReservesBinding
    lateinit var dataInici : String
    lateinit var dataFinal : String

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReservesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.buttonDatesRange.setOnClickListener {
            var constraintsBuilder = CalendarConstraints.Builder()
                .setValidator(WinterAndSummerDateValidator())

            val datePicker: MaterialDatePicker<Pair<Long, Long>> =
                MaterialDatePicker.Builder.dateRangePicker()
                    .setTitleText("Escull la data inici i final")
                    .setCalendarConstraints(constraintsBuilder.build()).build()

            datePicker.show(parentFragmentManager, "DATE_RANG_PICKER")

            datePicker.addOnPositiveButtonClickListener {
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dataInici = sdf.format(it.first)
                dataFinal = sdf.format(it.second)

                binding.textDates.setText(dataInici + " - " + dataFinal)
            }
        }
        binding.reservarButton.setOnClickListener {
            val reserva = Reserva(
                reserves.lastIndex + 1,
                binding.nomTextField.text.toString(),
                binding.cognomsTextField.text.toString(),
                binding.emailTextField.text.toString(),
                binding.telefTextField.text.toString(),
                if(binding.radioB1.isChecked){1}else if(binding.radioB2.isChecked){2}else{3},
                Date.valueOf(dataInici),Date.valueOf(dataFinal), 0.0
            )
            reserva.preu = calculatePreu(reserva)
            reserves += reserva
            Toast.makeText(this.context,"Reserva afegida", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReservesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReservesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        private class WinterAndSummerDateValidator() : DateValidator {
            constructor(parcel: Parcel) : this() {
            }

            override fun isValid(date: Long): Boolean {
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = date

                val day = calendar[Calendar.DAY_OF_MONTH]
                val month = calendar[Calendar.MONTH]

                if ((month == Calendar.OCTOBER && day >= 31) ||
                    (month == Calendar.NOVEMBER) ||
                    (month == Calendar.DECEMBER) ||
                    (month == Calendar.JANUARY) ||
                    (month == Calendar.FEBRUARY) ||
                    (month == Calendar.MARCH) ||
                    (month <= Calendar.APRIL && day <= 15)
                ) {
                    return true
                }

                if ((month == Calendar.JULY) ||
                    (month == Calendar.AUGUST) ||
                    (month == Calendar.SEPTEMBER && day <= 12)
                ) {
                    return true
                }

                return false
            }

            override fun describeContents(): Int {
                return 0
            }

            override fun writeToParcel(dest: Parcel, flags: Int) {
                TODO("Not yet implemented")
            }

            companion object CREATOR : Parcelable.Creator<WinterAndSummerDateValidator> {
                override fun createFromParcel(parcel: Parcel): WinterAndSummerDateValidator {
                    return WinterAndSummerDateValidator(parcel)
                }

                override fun newArray(size: Int): Array<WinterAndSummerDateValidator?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }


}