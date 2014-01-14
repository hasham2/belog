(ns belog.models.migration
  (:require [clojure.java.jdbc :as sql]))

(def db {:classname "org.sqlite.JDBC"
         :subprotocol "sqlite" 
         :subname "db/database.db"})

(defn create-posts []
  (try (sql/with-connection db
         (sql/create-table :posts
          [:id :serial "PRIMARY KEY"]
          [:title :varchar "NOT NULL"]
          [:body :varchar "NOT NULL"]
          [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))
       (catch Exception e (println e))))

(defn -main []
  (println "Migrating databases ...")
  (flush)
  (create-posts)
  (println "Done ..."))
