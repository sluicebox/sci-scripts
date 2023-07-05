;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 784)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use System)

(public
	slingr 0
)

(instance slingr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo cel: 0 cycleSpeed: 1)
				(if (IsFlag 0)
					(gEgo
						view: 40
						setCycle: CT (if (< (gEgo loop:) 2) 7 else 5) 1 self
					)
				else
					(gEgo view: 41 setCycle: CT 5 1 self)
				)
			)
			(1
				(slingSound init: play:)
				(if (IsFlag 0)
					(gEgo
						cel: (if (< (gEgo loop:) 2) 8 else 6)
						setCycle: End
					)
				else
					(gEgo setCycle: End)
				)
				(= cycles 15)
			)
			(2
				(if (and (<= 56 gCurRoomNum 72) (not (OneOf gCurRoomNum 63 65)))
					(Print 784 0) ; "You had better practice. Your aim with the slingshot is poor."
				else
					(Print 784 1) ; "You missed. Then again, you weren't aiming at anything worthwhile."
				)
				(if global140
					(UpdatePebbles)
				)
				(HandsOn)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance slingSound of Sound
	(properties
		number 19
		priority 10
	)
)

