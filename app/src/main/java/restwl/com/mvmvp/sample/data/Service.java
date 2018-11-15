package restwl.com.mvmvp.sample.data;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class Service {

    private MutableLiveData<String> mLiveData = new MutableLiveData<>();

    public LiveData<String> loadData() {
        Completable.create(emitter -> {
            TimeUnit.SECONDS.sleep(3);
            mLiveData.postValue("Hello world!!!");
        }).subscribeOn(Schedulers.io())
            .subscribe();
        return mLiveData;
    }

}
