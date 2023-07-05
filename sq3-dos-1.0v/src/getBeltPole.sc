;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 521)
(include sci.sh)
(use Main)
(use Avoid)
(use Motion)
(use System)

(public
	getBeltPole 0
)

(instance getBeltPole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: Avoid
					setMotion: MoveTo (- (global127 x:) 40) 122 self
				)
			)
			(1
				(gEgo
					view: 104
					setLoop: 0
					cel: 255
					cycleSpeed: 3
					setCycle: CT 4 1 self
				)
			)
			(2
				(gView dispose:)
				(gEgo setCycle: End)
				(= seconds 3)
			)
			(3
				(gEgo get: 16) ; Invisibility_Belt
				(gGame changeScore: 35)
				(gEgo
					view: 0
					setLoop: -1
					setCel: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 179 110 self
				)
			)
			(4
				(HandsOn)
				(gEgo loop: 2 setAvoider: 0)
				(gCurRoom setScript: 0)
				(DisposeScript 521)
			)
		)
	)
)

