package com.bike2ride.ludzhev.bike2ride.Home;

import com.bike2ride.ludzhev.bike2ride.base.BaseContracts;

/**
 * Holds contracts for Home.
 *
 * @author ludzhev
 * @version %I%, %G%
 * @since 1.0
 */

public interface HomeContracts {
    /**
     * Base View for Home.
     */
    interface View extends BaseContracts.View<Presenter> {
        void setContent(String content);
    }

    /**
     * Base Presenter for Home.
     */
    interface Presenter extends BaseContracts.ViewStatePresenter<View, ViewState> {
    }

    /**
     * Contract for Home navigation.
     */
    interface Router extends BaseContracts.Router {
    }

    /**
     * Base ViewState for Home.
     */
    interface ViewState extends BaseContracts.ViewState {
        void setContent(String content);
        String getContent();

    }
}

//public interface PersonsListContracts {
//    /**
//     * Base view for PersonsList
//     */
//    interface View extends BaseContracts.View<Presenter> {
//        /**
//         * Sets the presenter
//         *
//         * @param persons array of objects to visualize
//         */
//        void setPersons(List<Person> persons);
//
//        /**
//         * Show loading screen
//         */
//        void showLoadingScreen();
//
//        /**
//         * Hide loading screen
//         */
//        void hideLoadingScreen();
//    }
//
//    /**
//     * Base presenter for PersonsList
//     */
//    interface Presenter extends BaseContracts.ViewStatePresenter<View, ViewState> {
//        /**
//         * React on selection of a person object
//         *
//         * @param index the index of the person
//         */
//        void onPersonSelect(int index);
//
//        /**
//         * Sets the a {@link Router} instance
//         *
//         * @param router the router
//         */
//        void setRouter(Router router);
//    }
//
//    /**
//     * Contract for PersonsList navigation
//     */
//    interface Router extends BaseContracts.Router {
//        /**
//         * Handle the navigation
//         *
//         * @param obj the object to navigate with
//         */
//        void showDetails(Person obj);
//    }
//
//    interface ViewState extends BaseContracts.ViewState {
//        void setPersons(List<Person> persons);
//
//        List<Person> getPersons();
//
//        void setHasCache(boolean hasCache);
//
//        boolean getHasCache();
//    }
//}
