package restwl.com.mvmvp.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import restwl.com.mvmvp.base.presenter.MvvmpPresenter;
import restwl.com.mvmvp.base.viewmodel.MvvmpViewModel;

public abstract class BaseMvvmpFragment<FragmentView extends MvvmpView,
    FragmentPresenter extends MvvmpPresenter<FragmentView>,
    ViewModel extends MvvmpViewModel> extends Fragment {

    private ViewModel mViewModel;

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

        if (getViewModel() == null) {
            mViewModel = createViewModel();
        }

        if (getPresenter() == null) {
            getViewModel().setFragmentPresenter(getClass(), createFragmentPresenter());
        }

        getPresenter().onViewCreated(getFragmentView());

        return view;
    }

    @Override
    public void onDestroyView() {
        getPresenter().onViewDestroyed();
        super.onDestroyView();
    }

    @SuppressWarnings("unchecked")
    public FragmentPresenter getPresenter() {
        return (FragmentPresenter) getViewModel().getFragmentPresenter(getClass());
    }

    public ViewModel getViewModel() {
        return mViewModel;
    }
}