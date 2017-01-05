(ns cause-agent.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [cause-agent.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[cause_agent started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[cause_agent has shut down successfully]=-"))
   :middleware wrap-dev})
