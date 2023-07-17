;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use System)

(class VPScaler of Obj
	(properties
		client 0
		vanX 160
		vanY 100
		xLast 9999
		yLast 9999
		const 0
		scaleNum 1
		scaleDen 1
		perspec 80
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(= client param1)
		(if (> argc 4)
			(= perspec param5)
			(if (> argc 5)
				(= vanX param6)
				(= vanY param7)
			else
				(= vanX (gCurRoom vanishingX:))
				(= vanY (gCurRoom vanishingY:))
			)
		else
			(= perspec (gCurRoom global31:))
			(= vanX (gCurRoom vanishingX:))
			(= vanY (gCurRoom vanishingY:))
		)
		(= scaleNum (- param2 param3))
		(= scaleDen param4)
		(= const (- param2 (/ (* scaleNum param4) scaleDen)))
		(self doit:)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(if (and (== (client y:) yLast) (== (client x:) xLast))
			(return)
		else
			(= xLast (client x:))
			(= yLast (client y:))
			(= temp0 (GetDistance xLast yLast vanX vanY perspec))
			(= temp1
				(/
					(* (= temp1 (+ (/ (* scaleNum temp0) scaleDen) const)) 128)
					100
				)
			)
			(client scaleX: temp1 scaleY: temp1)
		)
	)
)

