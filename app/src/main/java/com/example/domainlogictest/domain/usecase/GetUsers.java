package com.example.domainlogictest.domain.usecase;



import com.example.domainlogictest.data.api.model.User;

import java.util.List;

public interface GetUsers {
    List<User> get();

    void getAsync(Listener listener);

    interface Listener {
        void onUsersReceived(List<User> users, boolean isCached);

        void onError(Exception e);

        void onNoInternetAvailable();
    }
}
