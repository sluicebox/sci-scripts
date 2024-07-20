;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Motion)

(class MoveToEndLoop of MoveTo
	(properties)

	(method (init param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= yLast (= xLast (= b-moveCnt (= completed 0))))
		(if (= temp3 (client cycler:))
			(temp3 cycleCnt: 0)
		)
		(if
			(= temp4
				(GetDistance (= temp2 (client x:)) (= temp3 (client y:)) x y)
			)
			(client setHeading: (GetAngle temp2 temp3 x y))
		)
		(= temp5 (client lastCel:))
		(client
			cel: 0
			setStep:
				(if (< (/ temp4 temp5) 1)
					1
				else
					(/ temp4 temp5)
				)
				(if (< (/ temp4 temp5) 1)
					1
				else
					(/ temp4 temp5)
				)
			setCycle: End
		)
		(InitBresen self)
	)
)

