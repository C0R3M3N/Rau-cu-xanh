package com.nhom12.rau_cu_xanh.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.api.login.login_Api.Companion.ApiService
import com.nhom12.rau_cu_xanh.databinding.LoginBinding
import com.nhom12.rau_cu_xanh.model.User
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.text_user_name
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private var _binding: LoginBinding? = null

    private val binding get() = _binding!!

    private var textUserName: TextView? = null
    private var textPassword: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.buttonDangNhap.setOnClickListener(){

            check_User_Login()
//            if(text_user_name.text.toString() == "admin" && user_password.text.toString() == "admin"){
//                Toast.makeText(activity, "Login Successful", Toast.LENGTH_LONG).show()
//                view.findNavController().navigate(R.id.action_loginFragment_to_navigation_home)
//            } else {
//
//                Toast.makeText(activity, "error", Toast.LENGTH_LONG).show()
//              }
        }
        binding.quenMatKhau.setOnClickListener{
        }

        return root
    }

//    private fun clickCallApi() {
//        ApiService.getBook_id(5).enqueue(object : Callback<Array<Books>> {
//            override fun onResponse(call: Call<Array<Books>>, response: Response<Array<Books>>) {
//                Log.e("Test response", response.body().toString())
//                Toast.makeText(activity,"Yeah!!",Toast.LENGTH_SHORT)
//                val books: Array<Books>? = response.body()
//                if (books != null) {
//                    val book: Books = books[0]
//                    text_user_name.setText(book.name)
//                    user_password.setText(book.author)
//                }
//            }
//
//            override fun onFailure(call: Call<Array<Books>>, t: Throwable) {
//                Toast.makeText(activity, "Failed!! " + t.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }

    private fun getMyData() {
        ApiService.getUser(4).enqueue(object : Callback<Array<User>> {
            override fun onResponse(call: Call<Array<User>>, response: Response<Array<User>>) {
                Log.e("Test response", response.body().toString())
                Toast.makeText(activity,"Yeah!!",Toast.LENGTH_SHORT)
                val books: Array<User>? = response.body()
                if (books != null) {
                    val book: User = books[0]
                    text_user_name.setText(book.full_name)
                    user_password.setText(book.password)
                }
            }

            override fun onFailure(call: Call<Array<User>>, t: Throwable) {
                Toast.makeText(activity, "Failed!! " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun check_User_Login() {

         val str: String = text_user_name.text.toString()
        ApiService.getUser_via_UserName(str).enqueue(object : Callback<Array<User>> {
            override fun onResponse(call: Call<Array<User>>, response: Response<Array<User>>) {
                Log.e("Test response", response.body().toString())
                val books: Array<User>? = response.body()
                if (books != null) {
                    val book: User = books[0]
                    if(book.password == user_password.text.toString())
                        view?.findNavController()?.navigate(R.id.action_loginFragment_to_navigation_home)
                    else
                        Toast.makeText(activity, "Password not Correct!!",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "User not fond!!",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Array<User>>, t: Throwable) {
                Toast.makeText(activity, "Failed!! " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textUserName = text_user_name;
        textPassword = user_password;

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}



