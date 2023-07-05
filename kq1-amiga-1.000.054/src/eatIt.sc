;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 781)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	eatIt 0
)

(instance eatIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global137 (gEgo illegalBits:))
				(gEgo
					view: (if (IsFlag 0) 27 else 24)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setMotion: 0
				)
			)
			(1
				(proc0_1)
				(gEgo loop: 2 illegalBits: global137)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

