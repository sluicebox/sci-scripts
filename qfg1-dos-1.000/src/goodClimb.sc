;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 137)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	goodClimb 0
	badClimb 1
	climbDown 2
)

(instance goodClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 137)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(if (> (gEgo y:) 142)
					(self cue:)
				else
					(HighPrint 137 0) ; "You look for a good place to climb."
					(gEgo setMotion: MoveTo (gEgo x:) 143 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 88 143 self)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 2)
			)
			(3
				(gEgo view: 517 setLoop: 0 setCel: 0 posn: 96 143)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 1 y: 122)
				(= cycles 2)
			)
			(5
				(gEgo setCel: 2)
				(= cycles 2)
			)
			(6
				(gEgo setCel: 3 y: 101)
				(= cycles 2)
			)
			(7
				(gEgo setCel: 0)
				(= cycles 2)
			)
			(8
				(gEgo
					setLoop: 1
					posn: 84 68
					setCel: -1
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(9
				(if (not (IsFlag 236))
					(Print 137 1 #mode 1) ; "That was almost too easy...almost like climbing a ladder."
				)
				(= cycles 10)
			)
			(10
				(gEgo posn: 86 55 setLoop: 3)
				(NormalEgo)
				(HandsOn)
				(SetFlag 272)
				(client setScript: 0)
			)
		)
	)
)

(instance badClimb of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 137)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo x:) 90)
					(gEgo setMotion: MoveTo 47 134 self)
				else
					(gEgo setMotion: MoveTo 120 140 self)
				)
			)
			(1
				(gEgo
					view: 517
					x: (+ (gEgo x:) 10)
					y: (- (gEgo y:) 1)
					setLoop: 0
					cel: 0
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(2
				(HighPrint 137 2) ; "The rocks are too slick from the spray of the waterfall for your limited climbing skill."
				(gEgo x: (- (gEgo x:) 10) y: (+ (gEgo y:) 1))
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo (+ (gEgo x:) 6) (gEgo y:) self)
			)
			(4
				(NormalEgo)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 137)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 86 55 self)
			)
			(1
				(gEgo view: 517 setLoop: 1 cel: 6 posn: 84 68)
				(= cycles 2)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 0 setCel: 0 posn: 96 101)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 3)
				(= cycles 2)
			)
			(5
				(gEgo y: 122 setCel: 2)
				(= cycles 2)
			)
			(6
				(gEgo setCel: 1)
				(= cycles 2)
			)
			(7
				(gEgo posn: 96 143 setCel: 0)
				(= cycles 2)
			)
			(8
				(gEgo loop: 2)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 272)
				(client setScript: 0)
			)
		)
	)
)

