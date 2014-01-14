(ns belog.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [belog.controllers.posts :as posts-controller])) ;; New controller added

(defroutes app-routes
  (GET "/" [] (posts-controller/index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
