;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 985)
(include sci.sh)
(use System)

(class Flags of Obj
	(properties
		size 0
		array 0
	)

	(method (init)
		(if (and size (not array))
			(self setSize: size)
		)
	)

	(method (setSize howMany &tmp numWords i)
		(= numWords (/ howMany 16))
		(if (mod howMany 16)
			(++ numWords)
		)
		(= size (* numWords 16))
		(= array (Memory memALLOC_CRIT (* numWords 2)))
		(for ((= i 0)) (< i numWords) ((++ i))
			(Memory memPOKE (+ array (* i 2)) 0)
		)
	)

	(method (dispose)
		(if array
			(Memory memFREE array)
			(= array 0)
		)
		(super dispose:)
	)

	(method (set flags &tmp theWord offset)
		(while argc
			(= offset (* (/ [flags (-- argc)] 16) 2))
			(= theWord
				(|
					(= theWord (Memory memPEEK (+ array offset)))
					(>> $8000 (mod [flags argc] 16))
				)
			)
			(Memory memPOKE (+ array offset) theWord)
		)
	)

	(method (clear flags &tmp theWord offset)
		(while argc
			(= offset (* (/ [flags (-- argc)] 16) 2))
			(= theWord
				(&
					(= theWord (Memory memPEEK (+ array offset)))
					(~ (>> $8000 (mod [flags argc] 16)))
				)
			)
			(Memory memPOKE (+ array offset) theWord)
		)
	)

	(method (test theFlag &tmp theWord offset)
		(= offset (* (/ theFlag 16) 2))
		(return
			(& (= theWord (Memory memPEEK (+ array offset))) (>> $8000 (mod theFlag 16)))
		)
	)
)

