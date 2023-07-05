;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Main)
(use System)

(public
	theDeathScript 0
)

(instance theDeathScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 14 0 15 0 self 710) ; "One of the mummies reaches Gabriel!"
			)
			(1
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

