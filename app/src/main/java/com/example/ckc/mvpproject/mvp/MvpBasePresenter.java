/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ckc.mvpproject.mvp;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * A base implementation of a {@link MvpPresenter} that uses a <b>WeakReference</b> for referring
 * to the attached view.
 * <p>
 * You should always check {@link #isViewAttached()} to check if the view is attached to this
 * presenter before calling {@link #getView()} to access the view.
 * </p>
 *
 * @param <V> type of the {@link MvpView}
 * @author Hannes Dorfmann
 * @since 1.0.0
 *
 * mvp中P层 持有view和model  连接view和model的桥梁
 */
public class MvpBasePresenter<V extends MvpView, M extends BaseModel> implements MvpPresenter<V> {
    protected Context mContext;
    private WeakReference<V> viewRef;
    private M data;

    /**
     * must be Application context
     * @param context must be Application context
     */
    public MvpBasePresenter(Context context) {
        if (context instanceof Application) {
            this.mContext = context;
        } else {
            throw new IllegalArgumentException("context must be ApplicationContext");
        }
    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is
     * attached to avoid NullPointerExceptions.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    @Nullable
    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    public M getModelData() {
        return data;
    }

    protected void setModelData(M data) {
        this.data=data;
    }


    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
