(ns belog.controllers.posts
  (:require
    [clostache.parser :as clostache]
    [belog.models.posts :as posts-model]))

;; helper methods

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/posts/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

;; controller actions
(defn index [] 
  (render-template "index" {:posts (posts-model/all)}))
