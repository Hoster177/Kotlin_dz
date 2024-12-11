package ru.hoster.aaa0512111

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.hoster.aaa0512111.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: BaseViewModel = ViewModelProvider(this)[BaseViewModel::class.java]
        val binding:ActivitySecondBinding = DataBindingUtil.setContentView(this,R.layout.activity_second)
        setContentView(binding.root)

        viewModel.initBase(this,binding)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val statusi = resources.getStringArray(R.array.statusi)
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,statusi)

        val achiveArray = arrayListOf<Achivka>(
            Achivka("Проснулся","12.11.1111"),
            Achivka("Позавтракал","12.11.1111"),
            Achivka("Умылся","12.11.1111"),
            Achivka("Достижение","12.11.1111"))
        val adapterAchive = AchivkaAdapter(achiveArray)

        binding.SP.adapter = adapter

        binding.SP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.RV.adapter = adapterAchive

        /*<ImageView
                android:id="@+id/Image2"
                android:background="@drawable/rectangle"
                android:layout_width="200dp"
                android:layout_height="200dp"
                android:onClick="@{() -> viewModel.chooseImage()}" />
                */
    }
}