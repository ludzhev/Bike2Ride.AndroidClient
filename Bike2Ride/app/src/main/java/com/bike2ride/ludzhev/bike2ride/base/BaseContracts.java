package com.bike2ride.ludzhev.bike2ride.base;

import java.io.Serializable;

/**
 * Holds contracts for needs of MVP architecture.
 *
 * @author ludzhev
 * @version %I%, %G%
 * @since 1.0
 */
public interface BaseContracts {
    /**
     * Represents a base contract for View which main purpose is to provide user interface.
     * @param <T> {@link Presenter} to be used for interaction logic of the View.
     */
    public interface View<T extends Presenter> {
        /**
         * Sets the presenter to be used for interaction logic of the View.
         * @param presenter Instance of {@link Presenter} implementer to be set.
         */
        void setPresenter(T presenter);
    }

    /**
     * Represent a base contract for {@link ViewState}
     * which main purpose is to keep the data used in the Activity not to be lost when recreating.
     */
    public interface ViewState extends Serializable {
    }

    /**
     * Represent a base contract for {@link Presenter} which main purpose is to hold all the nonAndroid dependent logic.
     * @param <T> {@link View} to be used for providing user interface.
     */
    public interface Presenter<T extends View> {
        /**
         * Subscribe to a view to provide user interface.
         * @param view Instance of {@link View} implementer to be subscribed to.
         */
        void subscribe(T view);

        /**
         * Cancel the subscription to any {@link View} which the {@link Presenter} is subscribed to.
         */
        void unsubscribe();
    }

    /**
     * Represent a base contract for {@link ViewStatePresenter} which extends {@link Presenter} interface
     * and use {@link ViewState} to keep the data not to be lost when recreating the Activity.
     * @param <T> {@link View} to be used for providing user interface.
     * @param <S> {@link ViewState} to be used for keeping the data not to be lost when recreating the Activity.
     */
    public interface ViewStatePresenter<T extends View, S extends ViewState> extends Presenter<T> {
        /**
         * Sets the viewState to be used for keeping the data not to be lost when recreating the Activity.
         * @param viewState Instance of {@link ViewState} implementer to be set.
         */
        void setViewState(S viewState);

        /**
         * Provide the current state of the Activity.
         * @return The ViewState of the {@link ViewStatePresenter} implementer.
         */
        S getViewState();
    }

    /**
     * Base router for needs of MVP architecture.
     */
    public interface Router {
    }
}
