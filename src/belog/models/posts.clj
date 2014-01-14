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

;; Fetch all the blog posts in database
(defn all []
  (j/query sqlite-db
    (s/select * :posts)))
