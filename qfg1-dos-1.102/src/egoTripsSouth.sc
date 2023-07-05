;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 189)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoTripsSouth 0
)

(instance egoTripsSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 189)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 536
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					illegalBits: 0
					setCycle: End
					setMotion:
						MoveTo
						(- (gEgo x:) 3)
						(- (gEgo y:) 12)
						self
				)
				(if (not ((ScriptID 94 0) notify: 1)) ; rm94
					((ScriptID 94 11) setScript: (ScriptID 192 0)) ; jackCycle, jackJumps
				)
			)
			(1
				(gEgo
					view: 515
					setLoop: 1
					setCel: 4
					cycleSpeed: 3
					setCycle: Beg self
				)
			)
			(2
				(NormalEgo)
				(gEgo loop: 3)
				(= cycles 2)
			)
			(3
				(NormalEgo)
				(gEgo loop: 1)
				(= cycles 2)
			)
			(4
				(NormalEgo)
				(gEgo loop: 2)
				(= cycles 2)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

