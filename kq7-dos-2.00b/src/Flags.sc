;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64985)
(include sci.sh)
(use Array)
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
		(= array (IntArray new: (* numWords 2)))
		(array fill: 0 (* numWords 2))
	)

	(method (dispose)
		(if array
			(array dispose:)
			(= array 0)
		)
		(super dispose:)
	)

	(method (set flags &tmp theWord offset)
		(while argc
			(= offset (* (/ [flags (-- argc)] 16) 2))
			(= theWord
				(|
					(= theWord (array at: offset))
					(>> $8000 (mod [flags argc] 16))
				)
			)
			(array at: offset theWord)
		)
	)

	(method (clear flags &tmp theWord offset)
		(while argc
			(= offset (* (/ [flags (-- argc)] 16) 2))
			(= theWord
				(&
					(= theWord (array at: offset))
					(~ (>> $8000 (mod [flags argc] 16)))
				)
			)
			(array at: offset theWord)
		)
	)

	(method (test theFlag &tmp theWord offset)
		(= offset (* (/ theFlag 16) 2))
		(return (& (= theWord (array at: offset)) (>> $8000 (mod theFlag 16))))
	)
)

