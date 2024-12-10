package ru.hoster.aaa0512111

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.hoster.aaa0512111.databinding.ActivitySecondBinding

class BaseViewModel:ViewModel() {
    var activity: AppCompatActivity? = null
    var binding: ActivitySecondBinding? = null
    var launcher: ActivityResultLauncher<Intent>? = null

    fun initBase(activity:AppCompatActivity,binding:ActivitySecondBinding){
        this.activity = activity
        this.binding = binding
        launcher = activity?.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                val uriImage = it.data?.data

                binding?.Image?.setImageURI(uriImage)
            }
        )
    }

    fun clickNumber(){
        val uri = Uri.parse("tel:+78005553535")
        val intent = Intent(Intent.ACTION_DIAL,uri)
        activity?.startActivity(intent)
    }
    fun clickURL(){
        val uri = Uri.parse("http://www.mirea.ru")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        activity?.startActivity(intent)
        /*<TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="сайт мирэа"
            android:textSize="20sp"
            android:textColor="#FF00FF"
            android:onClick="@{() -> viewModel.clickURL()}"/>*/
    }
    fun clickEmail(){
        val addresses = arrayOf("mail@mail.ru","hoster177@gmail.com")
        val uri = Uri.parse("mailto:")
        val intent = Intent(Intent.ACTION_SENDTO,uri)

        intent.putExtra(Intent.EXTRA_EMAIL,addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT,"zagolovok")
        intent.putExtra(Intent.EXTRA_TEXT,"teloooololololooooo")
        activity?.startActivity(intent)
    }

    fun chooseImage(){
        val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launcher?.launch(intent)

    }


}