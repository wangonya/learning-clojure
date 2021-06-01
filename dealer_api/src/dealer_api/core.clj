(ns dealer-api.core
  (:require [io.pedestal.http :as http]))

(defn respond-hello [request]
  {:status 200
   :body "Hello!"})

(def routes
  #{["/hello" :get respond-hello :route-name :hello]})

(defn serve []
  (-> {::http/routes routes ; -> :dealer-api.core.http/routes
       ::http/port 8890
       ::http/type :jetty}
      http/create-server
      http/start))
