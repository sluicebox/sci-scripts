;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use rm15)
(use n104)
(use Motion)
(use Actor)

(public
	castCalm 0
	castFetch 1
)

(local
	local0
)

(instance castCalm of KScript
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose:)
		(DisposeScript 114)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(CastCalm self self)
			)
			(1
				(proc15_1 0)
				(if (not (IsFlag 150))
					(LowPrint 114 0) ; "The Kobold doesn't look very calm. In fact, it looks totally unaffected by your spell."
				)
				(if register
					(self dispose:)
				)
			)
		)
	)
)

(instance castFetch of KScript
	(properties)

	(method (dispose)
		(NormalEgo)
		(LookAt gEgo gKobold)
		(gEgo illegalBits: global282)
		(HandsOn)
		(super dispose:)
		(DisposeScript 114)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 520 setLoop: 1 cel: 0 setCycle: 0)
				(= cycles 5)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				((= local0 (Act new:))
					view: 520
					illegalBits: 0
					ignoreActors:
					posn: (+ (gEgo x:) 2) (- (gEgo y:) 36)
					setLoop: 5
					setPri: 7
					setStep: 6 4
					setCycle: Fwd
					init:
					setMotion: MoveTo (gKobold x:) (+ (gKobold y:) 7) self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(if (not (TrySkill 24 35 0)) ; fetchSpell
					(local0 dispose:)
					(if (proc15_6)
						(LowPrint 114 1) ; "Uh oh, you've woken the Kobold."
					)
					(self dispose:)
				else
					(local0
						setPri: 11
						setMotion:
							MoveTo
							(+ (gEgo x:) 2)
							(- (gEgo y:) 36)
							self
					)
					((ScriptID 15 3) ; kobKey
						posn: (local0 x:) (local0 y:)
						show:
						setLoop: 7
						setCel: 0
						setPri: 11
						setStep: 6 4
						setMotion: MoveTo (+ (gEgo x:) 2) (- (gEgo y:) 36)
					)
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(local0 dispose:)
				((ScriptID 15 3) dispose:) ; kobKey
				(gEgo get: 5 setLoop: 3 cel: 0 setCycle: End self) ; key
				(SetFlag 147)
				(SolvePuzzle 649 7)
			)
			(7
				(LowPrint 114 2) ; "You now have the Kobold's key. Nice work!"
				(self dispose:)
			)
		)
	)
)

