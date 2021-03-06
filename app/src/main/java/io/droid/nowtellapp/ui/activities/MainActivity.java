package io.droid.nowtellapp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.droid.nowtellapp.R;
import io.droid.nowtellapp.ui.fragments.SignInFragment;
import io.droid.nowtellapp.ui.fragments.SignUpStepOneFragment;
import io.droid.nowtellapp.ui.fragments.SignUpStepTwoFragment;

public class MainActivity extends AppCompatActivity implements
        SignInFragment.OnSignUpListener, SignUpStepOneFragment.OnNextFragmentListener,
        SignUpStepTwoFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SignInFragment.newInstance())
                .commit();
    }

    @Override
    public void onSignUpClickListener() {
        fragmentTransaction(SignUpStepOneFragment.newInstance(), "signupstepone");
    }

    private void fragmentTransaction(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    @Override
    public void onNextFragment() {
        fragmentTransaction(SignUpStepTwoFragment.newInstance(), "signupsteptwo");
    }

    @Override
    public void onFragmentShowLogin() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        fragmentTransaction(SignInFragment.newInstance(), "signin");
    }
}
