;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	staffScript 0
)

(local
	[local0 8] = [0 1 0 4 0 1 4 5]
)

(instance staffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					setMotion: 0
					view: 20
					loop: [local0 (gEgo loop:)]
					cel: 0
					setCycle: End self
				)
				(sFx number: 900 play:)
			)
			(1
				(gEgo loop: (+ (gEgo loop:) 2) cel: 0 setCycle: End self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

