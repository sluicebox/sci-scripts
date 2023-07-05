;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use IconBar)
(use System)

(class Dial of IconI
	(properties
		points 0
		locations 0
		curPos 0
	)

	(method (init param1)
		(= curPos (= mainCel (self update:)))
		(super init: (if (not argc) gGameControls else param1))
	)

	(method (increment)
		(self update: (= cel (++ curPos)))
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (decrement)
		(self update: (= cel (-- curPos)))
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (findClosestPoint param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for ((= temp0 0)) (< temp0 points) ((++ temp0))
			(= temp3 (* temp0 2))
			(= temp1 (+ x (locations at: temp3)))
			(= temp2 (+ y (locations at: (+ temp3 1))))
			(cond
				((== temp0 0)
					(= temp4 (GetDistance (param1 x:) (param1 y:) temp1 temp2))
					(= temp5 0)
				)
				(
					(<
						(= temp6
							(GetDistance (param1 x:) (param1 y:) temp1 temp2)
						)
						temp4 ; UNINIT
					)
					(= temp4 temp6)
					(= temp5 temp0)
				)
			)
		)
		(return temp5)
	)

	(method (select &tmp temp0 temp1)
		(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
			(temp0 localize: plane)
			(= temp1 (self findClosestPoint: temp0))
			(cond
				((> curPos temp1)
					(self decrement:)
				)
				((< curPos temp1)
					(self increment:)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(return curPos)
	)

	(method (update))
)

