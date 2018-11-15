package restwl.com.mvmvp.sample.MainFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.ui.BaseFragment;
import restwl.com.mvmvp.sample.MainContract;
import restwl.com.mvmvp.sample.MainViewModel;

public class MainFragment extends BaseFragment<MainContract.FragmentView,
    MainContract.FragmentPresenter, MainContract.FragmentViewModel> implements MainContract.FragmentView {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_blank;
    }

    @NonNull
    @Override
    public MainContract.FragmentViewModel createViewModel() {
        return ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }

    @NonNull
    @Override
    public MainContract.FragmentPresenter createFragmentPresenter() {
        return new MainFragmentPresenter();
    }

    @NonNull
    @Override
    public MainContract.FragmentView getFragmentView() {
        return this;
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        view.findViewById(R.id.fragment_button).setOnClickListener(this::onButtonClick);
        return view;
    }

    private void onButtonClick(View view) {
        getPresenter().onButtonClicked();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}
