(ns db.dbaccess
  (:require [taoclj.foundation :as pg]))


;; for the sql structure see /resources/examples.sql


; define the datasource with your database details
(pg/def-datasource examples-db {:host     "POSTGRES_DB"
                                :port     5432
                                :database "game_state"
                                :username "usr"
                                :password "pwd"
                                :pooled   false})



; insert a single record, returns the database generated key
(pg/trx-> examples-db
          (pg/insert :categories {:name "Category A"}))



; select a single record, returns a map representing the row
(pg/qry-> examples-db
          (pg/select1 :categories {:id 1}))



; insert a multiple records, returns the generated keys as sequence
(pg/trx-> examples-db
          (pg/insert :categories [{:name "Category B"}
                                  {:name "Category C"}]))


; select multiple records, returns a sequence
(pg/qry-> examples-db
          (pg/select :categories {}))


; insert a new category and 2 child products, returns generated keys
(pg/trx-> examples-db
          (pg/insert :categories {:name "Category D"})
          (pg/insert :products (pg/with-rs

                                 ; a sequence of values for insertion
                                 ["Product D1" "Product D2"]

                                 ; this is the template to use for each item upon insert
                                 ; rs   - implicitly available and is the resultset
                                 ; item - implicitly available name for each value
                                 {:category-id (first rs)
                                  :name item})))