;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64255)
(include sci.sh)
(use Str)
(use Print)
(use System)

(public
	StillDown 0
	GetNumber 1
	MousedOn 2
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (GetNumber string default &tmp theLine theVal)
	(= theLine (Str newWith: 80 {}))
	(if (> argc 1)
		(theLine format: {%d} default)
	)
	(= theVal
		(if (GetInput theLine 5 string)
			(theLine asInteger:)
		else
			-1
		)
	)
	(theLine dispose:)
	(return theVal)
)

(procedure (MousedOn obj event) ; UNUSED
	(return
		(and
			(< (obj nsLeft:) (event x:) (obj nsRight:))
			(< (obj nsTop:) (event y:) (obj nsBottom:))
		)
	)
)

