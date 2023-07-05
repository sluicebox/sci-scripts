;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 541)
(include sci.sh)
(use Main)
(use Print)
(use Sound)
(use System)

(public
	phoneCall 0
)

(instance phoneCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 200)
			)
			(1
				(sFx number: 937 owner: self loop: 1 play: self)
			)
			(2
				(sFx number: 0 stop:)
				(if
					(and
						(not (or (gTalkers size:) (Print dialog:)))
						(== gCurRoomNum 540)
						(not (mod register 10))
						(not (gCurRoom inset:))
					)
					(gMessager sayRandom: 2 2 3 0 0 540)
				)
				(++ register)
				(self init:)
			)
		)
	)

	(method (dispose)
		(sFx client: 0 stop: dispose:)
		(super dispose:)
	)
)

(instance sFx of Sound
	(properties
		flags 5
	)
)

