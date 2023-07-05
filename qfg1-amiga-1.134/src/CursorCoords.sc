;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use System)

(class CursorCoords of Obj
	(properties
		cursorX 0
		cursorY 0
	)
)

(class InputList of Set
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== (event type:) $0040) ; direction
			(= temp7 [global252 (event message:)])
			(= temp3 60)
			(= temp4 400)
			(= temp10 (event x:))
			(= temp11 (event y:))
			(for ((= temp5 (= temp2 0))) (< temp5 size) ((++ temp5))
				(= temp1 (self at: temp5))
				(= temp12 (temp1 cursorX:))
				(= temp13 (temp1 cursorY:))
				(if (or (!= temp10 temp12) (!= temp11 temp13))
					(= temp8 (GetAngle temp10 temp11 temp12 temp13))
					(= temp0 (GetDistance temp10 temp11 temp12 temp13))
					(if (> (= temp9 (Abs (- temp7 temp8))) 180)
						(= temp9 (- 360 temp9))
					)
					(= temp6 (<= temp9 (+ temp3 10)))
					(if
						(or
							(<= temp9 (- temp3 10))
							(and temp6 (< (+ temp9 temp0) (+ temp3 temp4)))
							(and
								temp6
								(== (+ temp9 temp0) (+ temp3 temp4))
								(< temp9 temp3)
							)
						)
						(= temp3 temp9)
						(= temp4 temp0)
						(= temp2 temp1)
					)
				)
			)
			(if temp2
				(SetCursor gTheCursor 1 (temp2 cursorX:) (temp2 cursorY:))
			)
		)
	)

	(method (empty &tmp temp0)
		(if size
			(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
				((self at: temp0) dispose:)
				(self delete: (self at: temp0))
			)
		)
	)
)

