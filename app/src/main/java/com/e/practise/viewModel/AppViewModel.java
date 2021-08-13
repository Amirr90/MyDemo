package com.e.practise.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.e.practise.repository.ApiRepository;

import java.util.List;

import javax.inject.Inject;

public class AppViewModel extends ViewModel {

    ApiRepository apiRepository;

    public LiveData<List<Object>> listObject = new MutableLiveData<>();

    @Inject
    public AppViewModel(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public void loadList() {
        apiRepository.loadList();
    }
}
