(ns user
  (:require [mount.core :as mount]
            cause-agent.core))

(defn start []
  (mount/start-without #'cause-agent.core/http-server
                       #'cause-agent.core/repl-server))

(defn stop []
  (mount/stop-except #'cause-agent.core/http-server
                     #'cause-agent.core/repl-server))

(defn restart []
  (stop)
  (start))


