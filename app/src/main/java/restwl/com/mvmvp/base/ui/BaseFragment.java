package restwl.com.mvmvp.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import restwl.com.mvmvp.base.presenter.MVPFragmentPresenter;
import restwl.com.mvmvp.base.viewmodel.MVPFragmentViewModel;

public abstract class BaseFragment<FragmentView extends MVPView,
    FragmentPresenter extends MVPFragmentPresenter<FragmentView>, ViewModel extends MVPFragmentViewModel> extends Fragment {

    private ViewModel mViewModel;
    private FragmentPresenter mFragmentPresenter;

    public BaseFragment() {
    }

    public abstract @LayoutRes
    int getFragmentLayout();

    public abstract @NonNull
    ViewModel createViewModel();

    public abstract @NonNull
    FragmentPresenter createFragmentPresenter();

    public abstract @NonNull
    FragmentView getFragmentView();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = null;
        if (getFragmentLayout() != 0) {
            view = inflater.inflate(getFragmentLayout(), container, false);
        } else {
            view = super.onCreateView(inflater, container, savedInstanceState);
        }

        if (mViewModel == null) {
            mViewModel = createViewModel();
        }
        String tag = getTag();
        if (tag == null) throw new IllegalArgumentException();
        mFragmentPresenter = mViewModel.getFragmentPresenter(tag);
        if (mFragmentPresenter == null) {
            mFragmentPresenter = createFragmentPresenter();
            mViewModel.setFragmentPresenter(tag, mFragmentPresenter);
        }

        mFragmentPresenter.onFragmentViewCreated(getFragmentView());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentPresenter.onFragmentViewDestroyed();
    }

    public FragmentPresenter getPresenter() {
        return mFragmentPresenter;
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }


}
