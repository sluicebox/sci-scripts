;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Motion)
(use System)

(class PPath of MoveTo
	(properties
		pathPts 0
		intermediate 0
		value 1
		endPt 0
		theDir 2
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= client param1)
		(= pathPts param2)
		(if (> argc 2)
			(if (IsObject param3)
				(= caller param3)
				(if (>= argc 4)
					(= intermediate param4)
				)
			else
				(= value (+ (* 2 param3) 1))
				(= endPt (+ (* 2 param4) 1))
				(if (>= argc 5)
					(= caller param5)
				)
				(if (>= argc 6)
					(= intermediate param6)
				)
				(if (> value endPt)
					(= theDir -2)
				)
				(+= endPt theDir)
			)
		)
		(= x (client x:))
		(= y (client y:))
		(if (self atEnd:)
			(self moveDone:)
		else
			(self next:)
			(super init: client x y)
		)
	)

	(method (moveDone)
		(if (self atEnd:)
			(super moveDone:)
		else
			(if intermediate
				(intermediate cue: (/ value 2))
			)
			(self next:)
			(super init: client x y)
		)
	)

	(method (next)
		(= x (WordAt pathPts (- value 1)))
		(= y (WordAt pathPts value))
		(+= value theDir)
	)

	(method (atEnd)
		(return
			(if endPt
				(== endPt value)
			else
				(or
					(== (WordAt pathPts (- value 1)) -32768)
					(== (WordAt pathPts value) -32768)
				)
			)
		)
	)
)

