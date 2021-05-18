(ns clojure-noob.core
  (:gen-class)
  (:require
   [clojure.string :as string]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, Clojure World!")
  (println (str "this " "is " "a " "concatenated " "string")))

(if true
  "stuff is true"
  "stuff is false")

(if true
  (do (println "Success!")
      "true!")
  (do (println "Fail!")
      "false!"))

(def name "Chewbacca")
(str "\"Uggllglglglglglglglll\" - " name)
; => "Uggllglglglglglglglll" - Chewbacca


; when is like a combination of if and do,
; but with no else branch
(when true
  (println "Success!")
  "true!")
; Use when if you want to do multiple things when some condition is true,
; and you always want to return nil when the condition is false.

(nil? 1)
; => false

(nil? nil)
; => true



; = used to check equality


(= 1 1)
; => true

(= nil nil)
; => true

(= 1 2)
; false


; first truthy value returned for or

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; => :large_I_mean_venti

(or (= 0 1) (= "yes" "no"))
; => false

(or nil)
; => nil


; last truthy / first falsey value returned for and

(and :free_wifi :hot_coffee)
; => :hot_coffee

(and :feelin_super_cool nil false)
; => nil


; use def to bind a name to a value in Clojure

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names
; => ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"]


; maps (dict)

{:first-name "Charlie"
 :last-name "McFishwich"}

; map values can be of any type — strings, numbers, maps, vectors, even functions

; you can use the hash-map function to create a map
(hash-map :a 1 :b 2)
; => {:a 1 :b 2}

; look up values in maps with the get function
(get {:a 0 :b 1} :b)
; => 1

(get {:a 0 :b {:c "ho hum"}} :b)
; => {:c "ho hum"}


; get will return nil if it doesn’t find your key, or you can give it a default value to return, such as "unicorns?":

(get {:a 0 :b 1} :c)
; => nil

(get {:a 0 :b 1} :c "unicorns?")
; => "unicorns?"

; The get-in function lets you look up values in nested maps:

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])
; => "ho hum"


; Another way to look up a value in a map is to treat the map like a function with the key as its argument:

({:name "The Human Coffeepot"} :name)
; => "The Human Coffeepot"


; Keywords can be used as functions that look up the corresponding value in a data structure. For example, you can look up :a in a map:

(:a {:a 1 :b 2 :c 3})
; => 1

; This is equivalent to:

(get {:a 1 :b 2 :c 3} :a)
; => 1

; You can provide a default value, as with get:

(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")
; => "No gnome knows homes like Noah knows"



; vectors (not lists/arrays !!!)


(get [3 2 1] 0)
; => 3

; You can create vectors with the vector function:

(vector "creepy" "full" "moon")
; => ["creepy" "full" "moon"]

; You can use the conj function to add additional elements to the vector. Elements are added to the end of a vector:

(conj [1 2 3] 4)
; => [1 2 3 4]




; Lists are similar to vectors in that they’re linear collections of values.
; But there are some differences.
; For example, you can’t retrieve list elements with get.
; To write a list literal, just insert the elements into parentheses and use a single quote at the beginning:


'(1 2 3 4)
; => (1 2 3 4)

; to retrieve an element from a list, you can use the nth function:

(nth '(:a :b :c) 0)
; => :a

(nth '(:a :b :c) 2)
; => :c

; List values can have any type, and you can create lists with the list function:

(list 1 "two" {3 4})
; => (1 "two" {3 4})

; Elements are added to the beginning of a list:

(conj '(1 2 3) 4)
; => (4 1 2 3)

; When should you use a list and when should you use a vector?
; A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro,
; you should use a list. Otherwise, you should use a vector.



; sets - collection of unique values


#{"kurt vonnegut" 20 :icicle}

; You can also use hash-set to create a set:
(hash-set 1 1 2 2)
; => #{1 2}

; You can also create sets from existing vectors and lists by using the set function:

(set [3 3 3 4 4])
; => #{3 4}

; You can check for set membership using the contains? function, by using get, or by using a keyword as a function with the set as its argument.
; contains? returns true or false, whereas get and keyword lookup will return the value if it exists, or nil if it doesn’t.

; Here’s how you’d use contains?:

(contains? #{:a :b} :a)
; => true

(contains? #{:a :b} 3)
; => false

(contains? #{nil} nil)
; => true

; Here’s how you’d use a keyword:

(:a #{:a :b})
; => :a

; And here’s how you’d use get:

(get #{:a :b} :a)
; => :a

(get #{:a nil} nil)
; => nil

(get #{:a :b} "kurt vonnegut")
; => nil

; Notice that using get to test whether a set contains nil will always return nil, which is confusing.
; contains? may be the better option when you’re testing specifically for set membership.




; functions

; functions can return anything


(or + -)
; => #<core$_PLUS_ clojure.core$_PLUS_@76dace31>

((or + -) 1 2 3)
; => 6

((and (= 1 1) +) 1 2 3)
; => 6

((first [+ 0]) 1 2 3)
; => 6

; Functions that can either take a function as an argument or return a function are called higher-order functions.

(inc 1.1)
; => 2.1

(map inc [0 1 2 3])
; => (1 2 3 4)


(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")
; => "OH. MY. GOD! Zelda YOU ARE MOST DEFINITELY LIKE THE BEST MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"


(defn no-params
  []
  "I take no parameters!")
(defn one-param
  [x]
  (str "I take one parameter: " x))
(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))

(defn multi-arity
  ;; 0-arity arguments and body
  ([]
   (no-params))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (two-params first-arg second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
   (one-param first-arg)))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

; If you call x-chop with two arguments, the function works just as it would if it weren’t a multiple-arity function:

(x-chop "Kanye West" "slap")
; => "I slap chop Kanye West! Take that!"

(x-chop "Kanye East")
; => "I karate chop Kanye East! Take that!"

; You can also make each arity do something completely unrelated:

(defn weird-arity
  ([]
   "Destiny dressed you this morning, my friend, and now Fear is
     trying to pull off your pants. If you give up, if you give in,
     you're gonna end up naked with Fear just standing there laughing
     at your dangling unmentionables! - the Tick")
  ([number]
   (inc number)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")
; => ("Get off my lawn, Billy!!!"
;      "Get off my lawn, Anne-Marie!!!"
;      "Get off my lawn, The Incredible Bulk!!!")


(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")
; => "Hi, Doreen, here are my favorite things: gum, shoes, kara-te"




; Destructuring

; The basic idea behind destructuring is that it lets you concisely bind names to values within a collection

;; Return the first element of a collection


(defn my-first
  [[first-thing]] ; Notice that first-thing is within a vector
  first-thing)

(my-first ["oven" "bike" "war-axe"])
; => "oven"

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])
; => Your first choice is: Marmalade
; => Your second choice is: Handsome Jack
; => We're ignoring the rest of your choices. Here they are in case \
     ; you need to cry over them: Pigpen, Aquaman


(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)
; => "That number's OK, I guess"

(number-comment 7)
; => "Oh my gosh! What a big number!"



; anonymous funcs
;(fn [param-list]
;  function body)


(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])
; => ("Hi, Darth Vader" "Hi, Mr. Magoo")

((fn [x] (* x 3)) 8)
; => 24

(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)
; => 36


#(* % 3)

(#(* % 3) 8)
; => 24

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])
; => ("Hi, Darth Vader" "Hi, Mr. Magoo")

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)
; => 10


(let [x 3]
  x)
; => 3

(def x 0)
(let [x 1] x)
; => 1

(def x 0)
(let [x (inc x)] x)
; => 1


(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))
; => Iteration 0
; => Iteration 1
; => Iteration 2
; => Iteration 3
; => Iteration 4
; => Goodbye!


#"regular-expression"

(re-find #"^left-" "left-eye")
; => "left-"

(re-find #"^left-" "cleft-chin")
; => nil

(re-find #"^left-" "wongleblart")
; => nil


; using a regex to replace "left-" with "right-":

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(matching-part {:name "left-eye" :size 1})
; => {:name "right-eye" :size 1}]

(matching-part {:name "head" :size 3})
; => {:name "head" :size 3}]



; convert from seq - use into


(into {} (seq {:a 1 :b 2 :c 3}))
; => {:a 1, :c 3, :b 2}


(def human-consumption   [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)
; => ({:human 8.1, :critter 0.0}
      ; {:human 7.3, :critter 0.2}
      ; {:human 6.6, :critter 0.3}
      ; {:human 5.0, :critter 1.1})


(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])
; => (17 3 17/3)

(stats [80 1 44 13 6])
; => (144 5 144/5)


(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)
; => ("Bruce Wayne" "Peter Parker" "Your mom" "Your dad")





; reduce


(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})
; => {:max 31, :min 11}

; checks whether the value of a key-value pair is greather than 4.
; If it isn’t, then the key-value pair is filtered out
(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})
; => {:human 4.1}




; take, drop ...while


(take 3 [1 2 3 4 5 6 7 8 9 10])
; => (1 2 3)

(take 3 (repeatedly (fn [] (rand-int 10))))
; => (1 4 0)

(drop 3 [1 2 3 4 5 6 7 8 9 10])
; => (4 5 6 7 8 9 10)

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)

(drop-while #(< (:month %) 3) food-journal)

(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))


; filter, some


(filter #(< (:human %) 5) food-journal)

; Because the food journal is already sorted by date,
; we know that take-while will return the data we want
; without having to examine any of the data we won’t need.
; Therefore, take-while can be more efficient.

(some #(> (:critter %) 5) food-journal)
; => nil

(some #(> (:critter %) 3) food-journal)
; => true



; sort, sort-by


(sort [3 1 2])
; => (1 2 3)

(sort-by count ["aaa" "c" "bb"])
; => ("c" "bb" "aaa")


; concat
(concat [1 2] [3 4])
; => (1 2 3 4)

(concat (take 8 (repeat "na")) ["Batman!"])
; => ("na" "na" "na" "na" "na" "na" "na" "na" "Batman!")



; Lazy Seq Efficiency


(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))



; collection abstractions


(empty? [])
; => true

(empty? ["no!"])
; => false

(map identity {:sunlight-reaction "Glitter!"})
; => ([:sunlight-reaction "Glitter!"])

(into {} (map identity {:sunlight-reaction "Glitter!"}))
; => {:sunlight-reaction "Glitter!"}

(into [0] [1])
; => [0 1]
(conj [0] 1)
; => [0 1]

(max 0 1 2)
; => 2
(max [0 1 2])
; => [0 1 2]
(apply max [0 1 2])
; => 2


(def add10 (partial + 10))
(add10 3)
; => 13
(add10 5)
; => 15

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtainium" "adamantium")
; => ["water" "earth" "air" "unobtainium" "adamantium"]

; In general, you want to use partials when you find
; you’re repeating the same combination of function
; and arguments in many different contexts


(def not-vampire? (complement vampire?))
(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))



