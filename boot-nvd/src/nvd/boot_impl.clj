(ns nvd.boot-impl
  (:require
    [clojure.string :as str]
    [clojure.java.io :as io]
    [clojure.data.json :as json]
    [boot.pod :as pod]
    [boot.core :as core]))

(defn classpath-files
  [cp]
  (keep
    (fn [path]
      (when (and (str/starts-with? path "file:"))
        (str/replace path "file:" ""))) cp))

(defn pom-details
  []
  (-> #'boot.task.built-in/pom meta :task-options (select-keys [:project :version])))

(defn generate-config
  [options]
  (let [{:keys [project version]} (pom-details)]
    (merge {:classpath        (classpath-files (pod/get-classpath))
            :name             (name project)
            :group            (namespace project)
            :version          version
            :exit-after-check false}
           options)))

(defn write-config!
  [config]
  (let [out-file (io/file (core/tmp-dir!) "opts.json")]
    (spit out-file (json/write-str config))
    out-file))

(defn execute-nvd-task
  [config task-function]
  (task-function (write-config! (generate-config config))))
