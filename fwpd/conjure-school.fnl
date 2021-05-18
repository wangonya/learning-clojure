(module user.conjure-school
  {autoload {school conjure.school}})

;; Welcome to Conjure school!
;; Grab yourself a nice beverage and let's get evaluating. I hope you enjoy!

;; This language is Fennel, it's quite similar to Clojure.
;; Conjure is written in Fennel, it's compiled to Lua and executed inside Neovim itself.
;; This means we can work with a Lisp without installing or running anything else.

;; Note: Some colorschemes will make the HUD unreadable, see here for more: https://git.io/JJ1Hl

;; Let's learn how to evaluate it using Conjure's assortment of mappings.
;; You can learn how to change these mappings with :help conjure-mappings

;; Let's begin by evaluating the whole buffer using <localleader>eb
;; Your <localleader> is currently mapped to ","
(school.lesson-1)
