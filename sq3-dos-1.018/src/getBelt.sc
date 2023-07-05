;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	getBelt 0
)

(local
	local0
)

(instance getBelt of Script
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
					view: 122
					setLoop: 0
					cel: 255
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0)
				(= local0 (Prop new:))
				(local0
					view: 122
					setLoop: 2
					cel: 255
					posn: (+ (gEgo x:) 5) (- (gEgo y:) 2)
					setPri: 7
					cycleSpeed: 3
					setCycle: End self
					init:
				)
			)
			(3
				(gView dispose:)
				(= seconds 3)
			)
			(4
				(local0 dispose:)
				(gEgo loop: 0 setCel: 255 setCycle: Beg self)
				(gEgo get: 16) ; Invisibility_Belt
				(gGame changeScore: 35)
			)
			(5
				(gEgo
					view: 0
					setLoop: -1
					setCel: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 179 110 self
				)
			)
			(6
				(HandsOn)
				(gEgo loop: 2 setAvoider: 0)
				(gCurRoom setScript: 0)
				(DisposeScript 520)
			)
		)
	)
)

