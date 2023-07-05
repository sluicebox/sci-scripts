;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Styler)
(use System)

(public
	sRamaQuake 0
)

(instance sRamaQuake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
				(= scratch 5)
				(gGame handsOff:)
			)
			(1
				(ShakePlane global116 3 10 1)
				(= seconds 2)
			)
			(2
				(ShakePlane global116 (Random 1 2) 2 8)
				(-- scratch)
				(if scratch
					(-- state)
				)
				(= cycles 5)
			)
			(3
				(ShakePlane global116 3)
				(= seconds 2)
			)
			(4
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

