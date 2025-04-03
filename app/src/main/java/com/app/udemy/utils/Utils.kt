package com.app.udemy.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.udemy.R
import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import java.util.regex.Pattern

object Utils {
    inline fun <reified T : Serializable> Intent.getSerializableData(key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getSerializableExtra(key, T::class.java)
        } else {
            @Suppress("DEPRECATION")
            getSerializableExtra(key) as? T
        }
    }

    fun String.formatToTwoDecimals(): String {
        return try {
            val number = this.toDoubleOrNull()
            if (number != null)
                DecimalFormat("#,##0.00").format(number)
            else
                "0.00"
        } catch (e: Exception) {
            "0.00"
        }
    }

    fun String.formatNumberWithCommas(): String {
        return try {
            val number = this.toLong()
            NumberFormat.getNumberInstance(Locale.US).format(number)
        } catch (e: NumberFormatException) {
            this
        }
    }

    fun isValidEmail(email: CharSequence): Boolean {
        var isValid = true
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }

    fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.firstOrNull { it.isDigit() } == null) return false
        if (password.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } == null) return false
        if (password.filter { it.isLetter() }.firstOrNull { it.isLowerCase() } == null) return false
        if (password.firstOrNull { !it.isLetterOrDigit() } == null) return false
        return true
    }

    fun customToast(activity: Activity, message: String) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_toast_message)
        dialog.setCancelable(false)

        val txtMessage = dialog.findViewById<TextView>(R.id.txtMessage)
        txtMessage.text = message

        dialog.show()
        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            //attributes?.windowAnimations = R.style.dialogAnimation
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }, 2500)
    }

    fun setRecyclerItemMargin(activity: Activity, recyclerView: RecyclerView) {
        val spacing = activity.resources.getDimensionPixelSize(R.dimen.recycler_spacing_8) / 2
        recyclerView.setPadding(spacing, spacing, spacing, spacing)
        recyclerView.clipToPadding = false
        recyclerView.clipChildren = false
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.set(spacing, spacing, spacing, spacing)
            }
        })
    }

    private fun toast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun handleErrors(context: Context?, jsonObject: JSONObject) {
        try {
            // Get the "errors" object
            val errorsObject = jsonObject.getJSONObject("errors")

            // Get an iterator for the keys in the "errors" object
            val keysIterator = errorsObject.keys()

            // Iterate through the keys
            while (keysIterator.hasNext()) {
                val key = keysIterator.next()
                val valueArray = errorsObject.getJSONArray(key) // Value is a JSON array
                val valueString = valueArray.join(", ").replace("\"", "") // Convert array to string
                Log.e("TAG@@@", "key: $key     Value: $valueString")
                toast(context, valueString)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}
