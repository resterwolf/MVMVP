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
    FragmentPresenter extends MVPFragmentPresenter<FragmentView>,
    ViewModel extends MVPFragmentViewModel<FragmentView, FragmentPresenter>> extends Fragment {

    private ViewModel mViewModel;

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
        if (mViewModel.getFragmentPresenter(getId()) == null) {
            mViewModel.setFragmentPresenter(getId(), createFragmentPresenter());
        }
        mViewModel.getFragmentPresenter(getId()).onFragmentViewCreated(getFragmentView());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.getFragmentPresenter(getId()).onFragmentViewDestroyed();
    }

    public FragmentPresenter getPresenter() {
        return mViewModel.getFragmentPresenter(getId());
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }
}
