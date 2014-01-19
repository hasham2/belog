(ns belog.models.posts
  (:refer-clojure :exclude [:get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def sqlite-db {:classname "org.sqlite.JDBC"
                :subprotocol "sqlite"
                :subname "db/database.db"})
;; to get current time in milliseconds
(def now 
  (str (java.sql.Timestamp. (System/currentTimeMillis))))
;; Fetch one blog post with given ID

(defn get [id]
  (j/query sqlite-db
    (s/select * :posts (s/where {:id id}))))

(defn create [params]
  (j/insert! sqlite-db :posts (merge params {:created_at now})))

(defn save [id params]
  (j/update! sqlite-db :posts params (s/where {:id id})))

(defn delete [id]
  (j/delete! sqlite-db :posts (s/where {:id id})))

;; Fetch all the blog posts in database
(defn all []
  (j/query sqlite-db
    (s/select * :posts)))
