package restwl.com.mvmvp.sample.main;

import io.reactivex.Observable;
import restwl.com.mvmvp.base.Interactor.BaseInteractor;
import restwl.com.mvmvp.sample.data.Service;

public class MainInteractor extends BaseInteractor implements MainContract.MainInteractor {

    private Service service = new Service();

    @Override
    public Observable<String> loadData() {
        return service.loadSampleData();
    }
}
