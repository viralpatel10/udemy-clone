package com.app.udemy.ui.activity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.udemy.R
import com.app.udemy.databinding.ActivityProfileBinding
import com.app.udemy.ui.base.BaseActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityProfileBinding
        get() = ActivityProfileBinding::inflate

    private lateinit var sharedPreferences: SharedPreferences
    companion object {
        private const val PICK_IMAGE_REQUEST = 1
        private const val PREFS_NAME = "MyPrefs"
        private const val IMAGE_URI_KEY = "profile_image_uri"
    }
    override fun setup() {


        loadImageFromPreferences()

        binding.imgAdd.setOnClickListener {
            openGallery()
        }

        binding.etLanguage.setOnClickListener {
            showLanguageDialog()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            selectedImageUri?.let {
                binding.imgProfile.setImageURI(it)
                saveImageToPreferences(it.toString()) // Save URI to SharedPreferences
            }
        }
    }

    private fun saveImageToPreferences(imageUri: String) {
        val editor = sharedPreferences.edit()
        editor.putString(IMAGE_URI_KEY, imageUri)
        editor.apply()
    }

    private fun loadImageFromPreferences() {
        val imageUriString = sharedPreferences.getString(IMAGE_URI_KEY, null)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            binding.imgProfile.setImageURI(imageUri)
        }
    }

    private fun showLanguageDialog(){

        val languages = arrayOf(
            "English", "Hindi", "Português", "Español", "Türkçe", "日本語", "Français",
            "العربية", "中文", "한국어", "Deutsch", "Русский", "Polski", "Bahasa Indonesia",
            "Italiano", "Español", "ภาษาไทย", "Tiếng Việt", "اردو", "தமிழ்", "Română",
            "Azərbaycan dili", "עברית", "বাংলা", "Telugu", "Українська", "Nederlands",
            "Malayāḷam", "فارسی", "Bahasa Melayu" , "Ελληνικά" , "Soomaaliga" , "Magyar" , "Қазақша",
            "मराठी" , "Slovenčina" , "Čeština" , "Lietuvių" , "Svenska" , "Afrikaans" , "Suomi" ,
            "ગુજરાતી" , "Hrvatski" , "Kannaḍa" , "Latviešu" , "नेपाली" , "پښتو" , "संस्कृतम्" , "Shqip" , "Shqip"
        )

        var selectedLanguage = ""
        val checkedItem = -1

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Language")
        builder.setSingleChoiceItems(languages, checkedItem) { dialog, which ->
            selectedLanguage = languages[which]
        }

        builder.setPositiveButton("OK") { dialog, _ ->
            if (selectedLanguage.isNotEmpty()) {
                binding.etLanguage.setText(selectedLanguage)
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}