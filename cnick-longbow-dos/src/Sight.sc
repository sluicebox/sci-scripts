;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 982)
(include sci.sh)
(use Main)

(public
	IsOffScreen 0
	CantBeSeen 1
	AngleDiff 2
)

(procedure (IsOffScreen theObj) ; UNUSED
	(return
		(not
			(and
				(<= 0 (theObj sel_1:) 319)
				(<= 0 (- (theObj sel_0:) (theObj sel_82:)) 189)
			)
		)
	)
)

(procedure (CantBeSeen theSight optSeer optFieldAngle optFieldDepth &tmp theSeer fieldAngle fieldDepth sx sy ex ey) ; UNUSED
	(= theSeer optSeer)
	(= fieldAngle optFieldAngle)
	(= fieldDepth optFieldDepth)
	(if (< argc 4)
		(= fieldDepth 32767)
		(if (< argc 3)
			(if (< argc 2)
				(= theSeer gEgo)
			)
			(= fieldAngle
				(-
					360
					(if (== theSeer gEgo)
						(* 2 global35)
					)
				)
			)
		)
	)
	(= sx (theSight sel_1:))
	(= sy (theSight sel_0:))
	(= ex (theSeer sel_1:))
	(= ey (theSeer sel_0:))
	(return
		(and
			(!= theSight theSeer)
			(or
				(<
					(/ fieldAngle 2)
					(Abs
						(AngleDiff
							(GetAngle ex ey sx sy)
							(theSeer sel_55:)
						)
					)
				)
				(< fieldDepth (GetDistance ex ey sx sy gPerspective))
			)
		)
	)
)

(procedure (AngleDiff ang h)
	(if (>= argc 2)
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

