package com.example.phonenumberutilsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.EditText
import android.widget.Toast
import com.example.phonenumberutilsex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        events()
    }

    private fun events() {
        with(binding){
            btnSand.setOnClickListener {
                if (inputUserPhone.setText().isBlank()){
                    Toast.makeText(this@MainActivity, "전화번호를 입력해 주세요", Toast.LENGTH_SHORT).show()
                } else {
                    textUserInfo.text = "결과 : 이름은 ${inputUserName.setText()} 나이는 ${inputUserAge.setText()}\n전화번호는 ${setPhoneNumber(inputUserPhone.setText())}이다"
                }
            }
        }
    }

    // EditText의 text값을 String으로 바꿔주는 확장 함수
    private fun EditText.setText() = this.text.toString()

    // 전화번호 양식을 번경 시켜주는 함수
    private fun setPhoneNumber(phoneNumber: String):String{
        // removeRange를 이용하여 맨앞 0을 지워주고 대한민국 국가 코드인 +82를 추가 해준다.
        return PhoneNumberUtils.formatNumber("+82${phoneNumber.removeRange(0, 1)}", "KR")
    }
}