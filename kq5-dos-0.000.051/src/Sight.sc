;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 982)
(include sci.sh)
(use Main)
(use User)

(public
	IsOffScreen 0
	CantBeSeen 1
	AngleDiff 2
)

(procedure (IsOffScreen theObj) ; UNUSED
	(return (and (< 0 (theObj x:) 320) (< 0 (theObj y:) 200)))
)

(procedure (CantBeSeen theSight optSeer optFieldAngle optFieldDepth &tmp theSeer fieldAngle fieldDepth sx sy ex ey) ; UNUSED
	(= theSeer
		(if (>= argc 2)
			optSeer
		else
			(User alterEgo:)
		)
	)
	(= fieldAngle
		(/
			(cond
				((> (if (>= argc 3) optFieldAngle) 0) optFieldAngle)
				((== theSeer gEgo)
					(- 360 (* 2 global56))
				)
				(else 360)
			)
			2
		)
	)
	(= fieldDepth (if (>= argc 4) optFieldDepth else 32767))
	(= sx (theSight x:))
	(= sy (theSight y:))
	(= ex (theSeer x:))
	(= ey (theSeer y:))
	(return
		(and
			(>=
				fieldAngle
				(Abs
					(AngleDiff
						(GetAngle sx sy ex ey)
						(theSeer heading:)
					)
				)
			)
			(>= fieldDepth (GetDistance sx sy ex ey gPerspective))
		)
	)
)

(procedure (AngleDiff ang h)
	(if (>= argc 3)
		(-= ang h)
	)
	(return
		(cond
			((<= ang -180)
				(+ ang 360)
			)
			((> ang 180)
				(- ang 360)
			)
			(else ang)
		)
	)
)

