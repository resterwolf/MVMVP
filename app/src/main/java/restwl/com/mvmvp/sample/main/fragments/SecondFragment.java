package restwl.com.mvmvp.sample.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import restwl.com.mvmvp.R;
import restwl.com.mvmvp.base.ui.BaseMvvmpFragment;
import restwl.com.mvmvp.sample.main.MainContract;
import restwl.com.mvmvp.sample.main.ViewModel;

public class SecondFragment extends BaseMvvmpFragment<MainContract.SecondFragmentView,
    MainContract.SecondFragmentPresenter, MainContract.ViewModel>
    implements MainContract.SecondFragmentView {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_second;
    }

    @NonNull
    @Override
    public MainContract.ViewModel createViewModel() {
        return ViewModelProviders.of(getActivity()).get(ViewModel.class);
    }

    @NonNull
    @Override
    public MainContract.SecondFragmentPresenter createFragmentPresenter() {
        return new SecondFragmentPresenter();
    }

    @NonNull
    @Override
    public MainContract.SecondFragmentView getFragmentView() {
        return this;
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        return view;
    }

}
