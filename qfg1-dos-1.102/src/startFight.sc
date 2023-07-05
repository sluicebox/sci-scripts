;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use rm15)
(use Motion)

(public
	startFight 0
	stopFight 1
)

(instance startFight of KScript
	(properties)

	(method (dispose)
		(= global289 0)
		(super dispose:)
		(DisposeScript 117)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global289 1)
				(= global290 0)
				(HandsOff)
				(EgoGait 0 0) ; walking
				(gEgo illegalBits: 0)
				(if
					(<
						(= global344
							(-
								(/
									(+
										(* [gEgoStats 5] 8) ; weapon-use
										(* [gEgoStats 2] 4) ; agility
										(* [gEgoStats 0] 2) ; strength
										[gEgoStats 1] ; intelligence
										[gEgoStats 4] ; luck
									)
									16
								)
								20
							)
						)
						5
					)
					(= global344 5)
				)
				(= global345 (+ 9 (/ [gEgoStats 0] 10))) ; strength
				(if (gEgo has: 6) ; blade
					(+= global345 3)
				)
				(if (< (gEgo y:) 105)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 160 (gEgo y:) self)
				)
			)
			(1
				(if global348
					(gEgo setMotion: MoveTo 111 96 self)
				else
					(gEgo setMotion: MoveTo 172 94 self)
				)
			)
			(2
				(= temp0 global348)
				(if (not (gEgo has: 6)) ; blade
					(+= temp0 2)
				)
				(gEgo
					view: 502
					setLoop: temp0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(client setScript: (ScriptID 15 8)) ; egoFighting
			)
		)
	)
)

(instance stopFight of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 117)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global290 0)
				(= temp0 global348)
				(if (not (gEgo has: 6)) ; blade
					(+= temp0 2)
				)
				(gEgo
					view: 502
					setLoop: temp0
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(NormalEgo)
				(gEgo loop: global348)
				(if (not (IsFlag 150))
					(gEgo illegalBits: global282)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

