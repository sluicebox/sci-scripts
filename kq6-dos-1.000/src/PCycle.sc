;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 938)
(include sci.sh)
(use Motion)

(class PCycle of CT
	(properties
		startPal 0
		endPal 0
		howMany 1
	)

	(method (init theObj p1 p2OrWhoCares howManyOrWhoCares whoCares)
		(if argc
			(= client theObj)
			(cond
				((or (== argc 2) (and (== argc 3) (IsObject p2OrWhoCares)))
					(= startPal (client palette:))
					(= endPal p1)
					(if (== argc 3)
						(= caller p2OrWhoCares)
					)
				)
				((or (== argc 3) (and (== argc 4) (IsObject howManyOrWhoCares)))
					(= startPal p1)
					(= endPal p2OrWhoCares)
					(if (== argc 4)
						(= caller howManyOrWhoCares)
					)
				)
				((>= argc 4)
					(= startPal p1)
					(= endPal p2OrWhoCares)
					(= howMany howManyOrWhoCares)
					(if (== argc 5)
						(= caller whoCares)
					)
				)
			)
		)
		(= cycleDir (if (< endPal startPal) -1 else 1))
		(= completed (= cycleCnt 0))
	)

	(method (doit)
		(if (>= (++ cycleCnt) (client cycleSpeed:))
			(= cycleCnt 0)
			(client palette: (self nextCel:) forceUpd:)
			(if (not howMany)
				(= completed 1)
				(self cycleDone:)
			)
		)
	)

	(method (nextCel &tmp thePal)
		(cond
			((> (= thePal (+ (client palette:) cycleDir)) endPal)
				(= thePal startPal)
				(-- howMany)
			)
			((< thePal startPal)
				(= thePal endPal)
				(-- howMany)
			)
		)
		(if (not howMany)
			(= thePal (client palette:))
		)
		(return thePal)
	)
)

