(ns fwpd.core
  (:require
   [clojure.string :as string]))

(def filename "suspects.csv")

(defn my-fn [x] (inc x))

(println (my-fn 9))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "convert csv into rows of columns"
  [string]
  (map #(string/split % #",")
       (string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key
                          (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(println (glitter-filter 3 (mapify (parse (slurp filename)))))

(glitter-filter 3 (mapify (parse (slurp filename))))
; ({:name "Edward Cullen", :glitter-index 10}
;  {:name "Jacob Black", :glitter-index 3}
;  {:name "Carlisle Cullen", :glitter-index 6})

