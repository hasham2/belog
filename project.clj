(defproject belog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [org.clojure/java.jdbc "0.3.0-alpha5"]
                 [org.xerial/sqlite-jdbc "3.7.15-M1"]
                 [de.ubercode.clostache/clostache "1.3.1"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler belog.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})