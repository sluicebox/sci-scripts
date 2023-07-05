;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64985)
(include sci.sh)
(use Array)
(use WriteFeature)

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
		(= size (<< (= numWords (>> (+ howMany 15) $0004)) $0004))
		(if array
			(array dispose:)
		)
		(= array (IntArray new: numWords))
		(array fill: 0 numWords 0)
	)

	(method (dispose)
		(if array
			(array dispose:)
			(= array 0)
		)
		(super dispose:)
	)

	(method (clear flags &tmp temp0 temp1 temp2 temp3 temp4)
		(while argc
			(= temp1 (>> (= temp0 [flags (-- argc)]) $0004))
			(= temp2 (- temp0 (<< temp1 $0004)))
			(= temp4 (~ (<< $0001 temp2)))
			(= temp3 (array at: temp1))
		)
	)

	(method (set flags &tmp temp0 temp1 temp2 temp3 temp4)
		(while argc
			(= temp1 (>> (= temp0 [flags (-- argc)]) $0004))
			(= temp2 (- temp0 (<< temp1 $0004)))
			(= temp4 (<< $0001 temp2))
			(= temp3 (array at: temp1))
			(array at: temp1 (| temp4 temp3))
		)
	)

	(method (test theFlag &tmp temp0 temp1 temp2 temp3)
		(= temp0 (>> theFlag $0004))
		(= temp1 (- theFlag (<< temp0 $0004)))
		(= temp3 (<< $0001 temp1))
		(= temp2 (array at: temp0))
		(return (& temp3 temp2))
	)
)

