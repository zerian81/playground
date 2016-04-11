(ns primes.core
  (:gen-class :main true))

(defn filterMultiplesOf
	"Filter a list of numbers to remove multiples of a specific number."
	[n numberList]
	(filter #(not (zero? (mod % n))) numberList))

(defn appendAll [l1 l2]
	"Append one list to another"
	(if (empty? l2) l1 (recur (conj l1 (first l2)) (rest l2))))

(defn sieve
	"Generate a list of primes using the sieve of eratosthenes algorithm"
	[n]
	(loop [primes [] candidates (range 2 (inc n))] 
		(if (>= (first candidates) (Math/sqrt (last candidates))) 
			(appendAll primes candidates)
			(recur (conj primes (first candidates)) (filterMultiplesOf (first candidates) (rest candidates))) 
			)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (sieve 1000)))
