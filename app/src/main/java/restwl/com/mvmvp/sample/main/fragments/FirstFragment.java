package restwl.com.mvmvp.sample.main.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.Utils;
import restwl.com.mvmvp.base.ui.BaseFragment;
import restwl.com.mvmvp.sample.main.MainContract;
import restwl.com.mvmvp.sample.main.MainInteractor;
import restwl.com.mvmvp.sample.main.NavigationManager;
import restwl.com.mvmvp.sample.main.ViewModel;

public class FirstFragment extends BaseFragment<MainContract.FirstFragmentView,
    MainContract.FirstFragmentPresenter, MainContract.FragmentViewModel>
    implements MainContract.FirstFragmentView {

    public static final String TAG = FirstFragment.class.getSimpleName();

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_blank;
    }

    @NonNull
    @Override
    public MainContract.FragmentViewModel createViewModel() {
        return ViewModelProviders.of(getActivity()).get(ViewModel.class);
    }

    @NonNull
    @Override
    public MainContract.FirstFragmentPresenter createFragmentPresenter() {
        return new FirstFragmentPresenter(new NavigationManager(getActivity()), new MainInteractor());
    }

    @NonNull
    @Override
    public MainContract.FirstFragmentView getFragmentView() {
        return this;
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        view.findViewById(R.id.fragment_button).setOnClickListener(this::onButtonClick);
        return view;
    }

    private void onButtonClick(View view) {
        Utils.showDebugMessage(this.toString());
//        getPresenter().onButtonClicked();
    }

    @Override
    public void showToastMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}
