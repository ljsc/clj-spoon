(ns spoon.clients
  (:require [spoon.core :as client]))

(defn get-clients
  [org & [options]]
  (client/api-request :get "/organizations/%s/clients" [org] options))

(defn get-client
  [org name & [options]]
  (client/api-request :get "/organizations/%s/clients/%s" [org name] options))

(defn create-client
  [org name & [options]]
  (let [data {:name name :admin (:admin options false)}]
    (client/api-request :post "/organizations/%s/clients" [org] (assoc options :body data))))

(defn delete-client
  [org name & [options]]
  (client/api-request :delete "/organizations/%s/clients/%s" [org name] options))
