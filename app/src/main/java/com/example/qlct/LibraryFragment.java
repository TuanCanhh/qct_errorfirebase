package com.example.qlct;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LibraryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private FirebaseAuth mAuth;

    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Khởi tạo FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        Button logout, editprofile;
        TextView name, phone, age, gmail;

        // Ánh xạ Id
        logout = view.findViewById(R.id.logout);
        editprofile = view.findViewById(R.id.editprofile);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        age = view.findViewById(R.id.age);
        gmail = view.findViewById(R.id.gmail);

        // Thiết lập lắng nghe sự kiện cho nút logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đăng xuất người dùng
                mAuth.signOut();
                Toast.makeText(getActivity(), "Logged out", Toast.LENGTH_SHORT).show();

                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(getActivity(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Xóa stack hiện tại
                startActivity(intent);
            }
        });

        // Thiết lập lắng nghe sự kiện cho nút editButton
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi nhấn vào nút editButton
                Toast.makeText(getActivity(), "Edit Profile", Toast.LENGTH_SHORT).show();
                // Thêm logic chỉnh sửa hồ sơ ở đây nếu cần thiết
            }
        });

        return view;
    }
}
