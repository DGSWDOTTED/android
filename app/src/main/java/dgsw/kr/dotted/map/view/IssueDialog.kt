package dgsw.kr.dotted.map.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import dgsw.kr.dotted.databinding.DialogIssueBinding
import dgsw.kr.dotted.home.data.Company
import dgsw.kr.dotted.local.DB.CompanyEntity
import java.time.LocalDate

class IssueDialog(private val context : Context, company : CompanyEntity) {

    private lateinit var binding : DialogIssueBinding
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    val company = company


    fun setOnClicklistener(listener : OnDialogClickListener){
        onClickListener = listener
    }

    fun showDialog(){

        binding = DialogIssueBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(binding.root)
        dialog.show()

        binding.nameTxt.text = company.companyTitle
        binding.addressTxt.text = company.address
        binding.infoTxt.text = company.jobType


        context.dialogResize(dialog,0.9F,0.13F)
        dialog.getWindow()!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialog.window!!.setBackgroundDrawable( ColorDrawable(Color.TRANSPARENT))
        val params = dialog.window!!.attributes
        params.y = 200
        dialog.window!!.setGravity(Gravity.CENTER)

        binding.root.setOnClickListener {
            onClickListener.onClicked()
            dialog.dismiss()

        }

        dialog.setOnDismissListener {

            onClickListener.onDismissed()

        }

    }

    interface OnDialogClickListener{
        fun onClicked()

        fun onDismissed()
    }

    fun Context.dialogResize(dialog: Dialog, width: Float, height: Float){
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        if (Build.VERSION.SDK_INT < 30){
            val display = windowManager.defaultDisplay
            val size = Point()

            display.getSize(size)

            val window = dialog.window

            val x = (size.x * width).toInt()
            val y = (size.y * height).toInt()

            window?.setLayout(x, y)

        }else{
            val rect = windowManager.currentWindowMetrics.bounds

            val window = dialog.window
            val x = (rect.width() * width).toInt()
            val y = (rect.height() * height).toInt()

            window?.setLayout(x, y)
        }
    }
}