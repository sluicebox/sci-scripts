;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 121)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	drawWeapon 0
	putWeaponAway 1
)

(instance drawWeapon of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(ClearFlag 350)
		(DisposeScript 121)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 350)
				(HandsOn)
				(User canControl: 0 canInput: 0)
				(if (< (gEgo y:) 105)
					(gEgo illegalBits: 0 setMotion: MoveTo 172 94 self)
				else
					(gEgo
						illegalBits: 0
						setMotion: MoveTo 160 (gEgo y:) self
					)
				)
			)
			(1
				(if (< (gEgo x:) 172)
					(gEgo setMotion: MoveTo 172 94 self)
				else
					(self cue:)
				)
			)
			(2
				(cond
					((gEgo has: 6) ; blade
						(if (IsFlag 149)
							(gEgo setLoop: 1)
						else
							(gEgo setLoop: 0)
						)
					)
					((IsFlag 149)
						(gEgo setLoop: 3)
					)
					(else
						(gEgo setLoop: 2)
					)
				)
				(gEgo view: 502 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(if (gEgo has: 6) ; blade
					(gEgo
						view: 501
						setLoop: (if (IsFlag 149) 1 else 0)
						setCel: 0
						cycleSpeed: 0
						stopUpd:
					)
				else
					(gEgo
						view: 512
						setLoop: (if (IsFlag 149) 1 else 0)
						cel: 0
						cycleSpeed: 0
						stopUpd:
					)
				)
				(= cycles 2)
			)
			(4
				(SetFlag 308)
				(self dispose:)
			)
		)
	)
)

(instance putWeaponAway of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(HandsOn)
		(DisposeScript 121)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 502)
				(cond
					((gEgo has: 6) ; blade
						(if (IsFlag 149)
							(gEgo setLoop: 1)
						else
							(gEgo setLoop: 0)
						)
					)
					((IsFlag 149)
						(gEgo setLoop: 3)
					)
					(else
						(gEgo setLoop: 2)
					)
				)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(1
				(if (and (< [gEgoStats 12] 10) (not (gEgo has: 6))) ; magic, blade
					(gEgo setLoop: (if (IsFlag 149) 5 else 4))
					(gEgo
						cel: (- (NumCels gEgo) 1)
						cycleSpeed: 1
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(2
				(ClearFlag 315)
				(= cycles 2)
			)
			(3
				(NormalEgo)
				(gEgo loop: (if (IsFlag 149) 1 else 0))
				(self dispose:)
			)
		)
	)
)

