package com.android.codechallenge.ui.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.android.codechallenge.R;
import com.android.codechallenge.model.PersonalInfoForm;
import com.android.codechallenge.model.UserInfo;
import com.android.codechallenge.ui.BaseFragment;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ICallback;
import de.keyboardsurfer.android.widget.crouton.Style;
import org.jetbrains.annotations.NotNull;

import static com.android.codechallenge.network.RequestProvider.formConstraints;
import static com.android.codechallenge.network.RequestProvider.updateInfo;
import static de.keyboardsurfer.android.widget.crouton.Crouton.makeText;

/**
 * Created by greymatter on 17/03/16.
 */
public class UserFormFragment extends BaseFragment {

    @NonNull
    @Bind(R.id.input_name)
    EditText name;
    @NonNull
    @Bind(R.id.input_gender)
    EditText gender;
    @NonNull
    @Bind(R.id.input_dob)
    EditText dob;
    @NonNull
    @Bind(R.id.save)
    Button save;
    @NonNull
    @Bind(R.id.cancel)
    Button cancel;
    @NonNull
    @Bind(R.id.title)
    TextView title;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

        name.addTextChangedListener(new MyTextWatcher(name));
        gender.addTextChangedListener(new MyTextWatcher(gender));
        dob.addTextChangedListener(new MyTextWatcher(dob));

        formConstraints(new ICallback<PersonalInfoForm>() {
            @Override
            public void onSuccess(PersonalInfoForm personalInfoForm) {
                if (personalInfoForm.subTitle == null)
                    return;
                title.setText(personalInfoForm.subTitle);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final UserInfo newData = new UserInfo();
                final String inputName = name.getText().toString().trim();
                final String inputGender = gender.getText().toString().trim();
                final String inputDob = dob.getText().toString().trim();
                newData.setFirstName(inputName);
                newData.setGender(inputGender);
                newData.setDateOfBirth(inputDob);
                if (TextUtils.isEmpty(inputName) && TextUtils.isEmpty(inputGender) && TextUtils.isEmpty(inputGender)) {
                    makeText(ContextHelper.getContext(), R.string.not_saved, Style.INFO).show();
                    return;
                }

                updateInfo(newData, new ICallback<UserInfo>() {
                    @Override
                    public void onSuccess(UserInfo userInfo) {
                        makeText(ContextHelper.getContext(), R.string.saved, Style.CONFIRM).show();
                    }
                });
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_user_form;
    }

    @NotNull
    @Override
    public String tag() {
        return UserFormFragment.class.getSimpleName();
    }

    @OnClick(R.id.cancel)
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    //   validateName();
                    break;
                case R.id.input_gender:
                    //   validateGender();
                    break;
                case R.id.input_dob:
                    //   validateDOB();
                    break;
            }
        }
    }
}
