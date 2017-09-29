(def project 'boot-nvd)
(def version "0.1.0")

(set-env! :resource-paths #{"src"}
          :dependencies '[[org.clojure/clojure "1.8.0"]
                          [org.clojure/data.json "0.2.6"]
                          [nvd-clojure "0.3.0"]
                          [boot/core "2.7.2"]])

(task-options!
  pom {:project     project
       :version     version
       :description "FIXME: write description"
       :url         "http://example/FIXME"
       :scm         {:url "https://github.com/yourname/onyx-http-proxy"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}})
