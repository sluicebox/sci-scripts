;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use System)

(public
	readNote 0
)

(instance readNote of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 96)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 36 5 0 0 self 907) ; "Alexander reads Cassima's note again, searching for any sign of her true feelings for him...."
			)
			(1
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

