(ns cause-agent.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [cause-agent.layout :refer [error-page]]
            [cause-agent.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [cause-agent.env :refer [defaults]]
            [mount.core :as mount]
            [cause-agent.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
