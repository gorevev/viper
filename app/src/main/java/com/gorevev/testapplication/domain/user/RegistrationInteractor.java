package com.gorevev.testapplication.domain.user;

import android.util.Log;

import com.gorevev.testapplication.domain.common.Interactor;
import com.gorevev.testapplication.domain.common.entities.Response;
import com.gorevev.testapplication.domain.dictionary.api.IDictionaryAPI;
import com.gorevev.testapplication.domain.dictionary.entiny.Timezone;
import com.gorevev.testapplication.domain.dictionary.entiny.TimezoneList;
import com.gorevev.testapplication.domain.user.api.IUserAPI;
import com.gorevev.testapplication.domain.user.entities.RegUserParams;
import com.gorevev.testapplication.domain.user.entities.Token;
import com.gorevev.testapplication.infrastructure.network.manager.NetworkConnectionManager;
import com.gorevev.testapplication.infrastructure.repository.RepositoryException;
import com.gorevev.testapplication.infrastructure.storages.TokenStorage;
import com.gorevev.testapplication.presentation._common.injection.DomainModule;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

/**
 * Created by denischuvasov on 13.02.17.
 */
public class RegistrationInteractor extends Interactor<Response<Token>, RegUserParams> {
    private static final String TAG = "RegistrationInteractor";
    private IUserAPI service;
    private IDictionaryAPI dictionaryService;

    @Inject
    TokenStorage storage;

    @Inject
    public RegistrationInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                  @Named(DomainModule.UI) Scheduler uiScheduler,
                                  IUserAPI service,
                                  IDictionaryAPI dictionaryService,
                                  NetworkConnectionManager manager) {
        super(jobScheduler, uiScheduler, manager);
        this.service = service;
        this.dictionaryService = dictionaryService;
    }

    @Override
    protected Observable<Response<Token>> buildObservable(RegUserParams parameter) {
        return dictionaryService.timezone()
                .flatMap(new Func1<Response<TimezoneList>, Observable<Response<Token>>>() {
                    @Override
                    public Observable<Response<Token>> call(Response<TimezoneList> timezoneListResponse) {
                        String timeZone = getCurrentTimezone(timezoneListResponse.getData().getTimezones());
                        parameter.setTimezone(timeZone);
                        return service.registerUser(parameter);
                    }
                })
                .compose(convert())
                .map(response -> {

                    try {
                        storage.put(response.getData().getToken());
                    } catch (RepositoryException e) {
                        Log.e(TAG, e.getMessage());
                    }

                    return response;
                });
    }


    private String getCurrentTimezone(List<Timezone> timezones) {
        String timezone = "Asia/Novosibirsk";
        int currentOffset = Calendar.getInstance().getTimeZone().getRawOffset() / 1000;
        if(timezones != null && timezones.size() > 0) {
            for (Timezone tz : timezones) {
                if(tz.getOffset() == currentOffset) {
                    timezone = tz.getTimezone();
                    break;
                }
            }
        }

        return timezone;
    }
}
