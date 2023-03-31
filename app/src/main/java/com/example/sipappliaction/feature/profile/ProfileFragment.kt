package com.example.sipappliaction.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sipappliaction.R
import com.example.sipappliaction.data.model.UserModel
import com.example.sipappliaction.databinding.FragmentHomeBinding
import com.example.sipappliaction.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tilNameOfUser.editText?.setText(UserModel.nama)
        binding.tilUserName.editText?.setText(UserModel.username)
        binding.tilPassword.editText?.setText(UserModel.password)
        Glide
            .with(this)
            .load(UserModel.avatar)
            .into(binding.ivUserAvatar)
        binding.btnUpdate.setOnClickListener {
            UserModel.apply {
                nama = binding.tilNameOfUser.editText?.text.toString()
                username = binding.tilUserName.editText?.text.toString()
                password = binding.tilPassword.editText?.text.toString()
            }
            Toast.makeText(activity, "Credential Updated", Toast.LENGTH_SHORT).show()
        }
    }

}