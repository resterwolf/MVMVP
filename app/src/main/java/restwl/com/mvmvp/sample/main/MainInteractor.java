package restwl.com.mvmvp.sample.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import restwl.com.mvmvp.base.Interactor.BaseInteractor;
import restwl.com.mvmvp.sample.data.Service;

public class MainInteractor extends BaseInteractor implements MainContract.MainInteractor {

    private Service service = new Service();
    private MutableLiveData<String> liveData = new MutableLiveData<>();

    @Override
    public Observable<String> loadDataRx() {
        return Observable.just("Hello world");
    }

    @Override
    public LiveData<String> loadData() {

        return liveData;
    }
}
