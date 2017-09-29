(ns nvd.boot
  (:require
    [boot.core :as core]
    [nvd.boot-impl :as impl]
    [nvd.task.check]
    [nvd.task.purge-database]
    [nvd.task.update-database]))

(core/deftask nvd-check
  [o options VAL edn ""]
  (impl/execute-nvd-task options nvd.task.check/-main))

(core/deftask nvd-purge
  [o options VAL edn ""]
  (impl/execute-nvd-task options nvd.task.purge-database/-main))

(core/deftask nvd-update
  [o options VAL edn ""]
  (impl/execute-nvd-task options nvd.task.update-database/-main))
