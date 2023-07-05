;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	throwDag 0
)

(instance throwDag of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: gMenace)
					(proc0_15 gEgo gMenace)
				)
				(cond
					((IsFlag 0)
						(gEgo view: 53)
					)
					((!= gCurRoomNum 65)
						(gEgo
							loop: (if (< 0 (gEgo heading:) 180) 0 else 1)
							view: 51
						)
					)
					(else
						(gEgo view: 51)
					)
				)
				(gEgo cel: 0 setCycle: End self)
			)
			(1
				(Print 780 0) ; "Your aim could use some improvement. The dagger flies through the air, and where it lands, you know not where."
				(gGame changeScore: -5)
				(gEgo put: 0) ; Dagger
				(= temp0 (gEgo illegalBits:))
				(proc0_1)
				(gEgo illegalBits: temp0)
				(gEgo loop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

