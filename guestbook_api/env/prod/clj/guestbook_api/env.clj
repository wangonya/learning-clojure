(ns guestbook-api.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[guestbook_api started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[guestbook_api has shut down successfully]=-"))
   :middleware identity})
