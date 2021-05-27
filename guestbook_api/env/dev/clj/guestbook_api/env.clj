(ns guestbook-api.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [guestbook-api.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[guestbook_api started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[guestbook_api has shut down successfully]=-"))
   :middleware wrap-dev})
