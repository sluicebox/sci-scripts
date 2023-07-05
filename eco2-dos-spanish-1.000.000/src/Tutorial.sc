;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 980)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class Tutorial of Script
	(properties
		nextItem 0
		nextAction 0
		numTries 0
	)

	(method (waitFor obj act nOrMsg v c s m)
		(= nextItem obj)
		(= nextAction act)
		(cond
			((== argc 3)
				(Prints nOrMsg)
			)
			((> argc 3)
				(gMessager say: nOrMsg v c s m)
			)
		)
	)

	(method (report))

	(method (cue)
		(= numTries 0)
		(super cue: &rest)
	)
)

