(ns sticky-footer.core
  (:require [reagent.core :as reagent :refer [atom]]
            [sticky-footer.session :as session :refer [get-state]]
            [sticky-footer.routes :as routes]
            [sticky-footer.views.common :as common]))

(defn page-render []
  [:div
   [common/header]
   [(get-state :current-page)]])

(defn page-component [] 
  (reagent/create-class {:component-will-mount routes/app-routes
                         :render page-render}))

;; initialize app
(reagent/render-component [page-component]
                          (.getElementById js/document "app"))
