package com.dialog.getemaildialog;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GetEmailDialog extends DialogFragment {
    private TextView txtTitle, txtSubTitle, btnYes, btnNo;
    private EditText edtEmail;

    GetEmailCallback callback;

    private String title;
    private String subTitle;
    private String yesTitle;
    private String noTitle;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setYesTitle(String yesTitle) {
        this.yesTitle = yesTitle;
    }

    public void setNoTitle(String noTitle) {
        this.noTitle = noTitle;
    }

    public GetEmailDialog(GetEmailCallback callback) {
        this.callback = callback;
        this.setCancelable(false);
    }

    public GetEmailCallback getCallback() {
        return callback;
    }

    public void setCallback(GetEmailCallback callback) {
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.get_email_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        txtTitle = view.findViewById(R.id.txtTitle);
        txtSubTitle = view.findViewById(R.id.txtSubTitle);
        btnYes = view.findViewById(R.id.btnYes);
        btnNo = view.findViewById(R.id.btnNo);
        edtEmail = view.findViewById(R.id.edtEmail);

        if (title != null && !title.isEmpty()) {
            txtTitle.setText(title);
        }

        if (subTitle != null && !subTitle.isEmpty()) {
            txtSubTitle.setText(subTitle);
        }

        if (yesTitle != null && !yesTitle.isEmpty()) {
            btnYes.setText(yesTitle);
        }

        if (noTitle != null && !noTitle.isEmpty()) {
            btnNo.setText(noTitle);
        }

        edtEmail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        btnNo.setPaintFlags(btnNo.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        btnYes.setOnClickListener(v -> {
            if ( isValidEmail(edtEmail.getText()) ) {
                callback.onYesButtonClick(edtEmail.getText().toString());
            } else {
                edtEmail.setError("Please input valid email address.");
            }
        });

        btnNo.setOnClickListener(v -> {
            dismiss();
            callback.onNoButtonClick();
        });

        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                edtEmail.setError(null);
            }
        });
    }

    public interface GetEmailCallback {
        void onYesButtonClick(String email);
        void onNoButtonClick();
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
