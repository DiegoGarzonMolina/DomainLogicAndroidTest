/*
 * Copyright (C) 2015 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.domainlogictest.platform.interactor;

import com.example.domainlogictest.data.api.GetUsersApiImpl;
import com.example.domainlogictest.data.api.model.User;
import com.example.domainlogictest.domain.usecase.GetUsers;

import java.util.List;


public class GetUsersInteractor implements Interactor, GetUsers, GetUsers.Listener {
    GetUsers.Listener listener = new GetUsersApiImpl.NullListener();
    GetUsers getUsers;
    Executor executor;
    MainThread mainThread;

    public GetUsersInteractor(GetUsers dataSource, Executor executor, MainThread mainThread) {
        this.getUsers = dataSource;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void onUsersReceived(List<User> list, boolean isCached) {
        listener.onUsersReceived(list, isCached);
    }

    @Override
    public void onError(Exception e) {
        listener.onError(e);
    }

    @Override
    public void onNoInternetAvailable() {
        listener.onNoInternetAvailable();
    }

    @Override
    public void run() {
        getUsers.getAsync(listener);
    }

    @Override
    public List<User> get() {
        throw new IllegalArgumentException("Please use async version of this Interactor");
    }

    @Override
    public void getAsync(GetUsers.Listener listener) {
        if (listener != null) {
            this.listener = listener;
        }
        this.executor.run(this);
    }

}
