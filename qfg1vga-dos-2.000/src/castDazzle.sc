;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use rm15)
(use n104)
(use n814)
(use Motion)
(use User)
(use Actor)

(public
	castDazzle 0
	castDet 1
	castOpen 2
	castTrig 3
	castCalm 4
	castFetch 5
)

(local
	local0
	local1
	local2
)

(instance castDazzle of KScript
	(properties)

	(method (dispose)
		(proc15_1 1)
		(Face gEgo gKobold)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gKobold view: 179 setCel: 0)
				(gKobold setScript: 0)
				(= register (User canControl:))
				(gGame setCursor: gWaitCursor 1)
				(Face gEgo gKobold)
				(gEgo
					view: 521
					setLoop: (- 3 global286)
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(gKobold setScript: (ScriptID 15 4)) ; kobDazzle
				(gEgo setCycle: End)
				(= cycles 6)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance castDet of KScript
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(if
					(or
						(gEgo has: 16) ; brassKey
						[global340 16]
						(gCast contains: (ScriptID 15 3)) ; kobKey
					)
					(= register 1)
					(gMessager say: 3 0 9 0 self) ; "A strong magical aura radiates from the Kobold's key."
				else
					(= ticks 1)
				)
			)
			(1
				(cond
					((gCast contains: (ScriptID 15 2)) ; chest
						(gMessager say: 3 0 7 1)
						(= register 1)
						((ScriptID 15 2) setCel: 1) ; chest
						(= ticks 120)
					)
					((not (IsFlag 175))
						(= register 1)
						(gMessager say: 3 0 7 2 self) ; "You can detect a faint glimmering of magic from the shattered remains of the chest."
					)
					(else
						(= ticks 1)
					)
				)
			)
			(2
				(if (not register)
					(gMessager say: 3 0 10 1 self)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance castOpen of KScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					view: 521
					setLoop: (not (mod (gEgo loop:) 2))
					setCycle: End self
				)
			)
			(2
				(SetFlag 216)
				(if (TrySkill 17 50 0) ; openSpell
					((ScriptID 15 2) setCel: 1) ; chest
					(= ticks 60)
				else
					((ScriptID 15 2) setScript: (ScriptID 15 5)) ; chest, chestBlows
					(self dispose:)
				)
			)
			(3
				(gEgo get: 38 10 get: 0 60) ; gold, silver
				(= cycles 1)
			)
			(4
				(SetFlag 151)
				(SetFlag 175)
				(SolvePuzzle 650 5)
				(gMessager say: 8 0 7)
				(proc15_1 1)
				(Face gEgo (ScriptID 15 2)) ; chest
				(self dispose:)
			)
		)
	)
)

(instance castTrig of KScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(gEgo view: 521 setLoop: 1 setCycle: End self)
			)
			(2
				(SetFlag 216)
				((ScriptID 15 2) setScript: (ScriptID 15 5) 0 1) ; chest, chestBlows
				(self dispose:)
			)
		)
	)
)

(instance castCalm of KScript
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose:)
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
					(gMessager say: 1 0 0 0 self)
				)
			)
			(2
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
		(Face gEgo gKobold)
		(gEgo illegalBits: global260)
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 10)
			)
			(1
				(= local1 (gEgo cycleSpeed:))
				(= local2 (gEgo moveSpeed:))
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					view: 520
					cycleSpeed: 12
					loop: 3
					cel: 6
					setCycle: Beg self
				)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gEgo loop: 1 setCel: 6)
				((= local0 (Actor new:))
					view: 520
					illegalBits: 0
					ignoreActors:
					posn: (+ (gEgo x:) 11) (- (gEgo y:) 44)
					setLoop: 5
					setPri: 7
					setStep: 6 4
					setCycle: Fwd
					init:
					setMotion:
						MoveTo
						(+ (gKobold x:) 3)
						(- (gKobold y:) 9)
						self
				)
			)
			(3
				(= ticks 100)
			)
			(4
				(if (not (TrySkill 24 35 0)) ; fetchSpell
					(local0 dispose:)
					(if (proc15_6)
						(gMessager say: 4 0 0 1)
					)
					(self dispose:)
				else
					(local0
						setPri: 11
						setMotion:
							MoveTo
							(+ (gEgo x:) 11)
							(- (gEgo y:) 44)
							self
					)
					((ScriptID 15 3) ; kobKey
						posn: (local0 x:) (local0 y:)
						show:
						setLoop: 6
						setCel: 0
						setPri: 10
						setStep: 6 4
						setMotion:
							MoveTo
							(+ (gEgo x:) 11)
							(- (gEgo y:) 44)
					)
					(if (not (IsFlag 153))
						(gKobold setLoop: 5)
					)
				)
			)
			(5
				(local0 dispose:)
				((ScriptID 15 3) dispose:) ; kobKey
				(gEgo get: 16 loop: 3 cel: 0 setCycle: End self) ; brassKey
				(SetFlag 147)
				(SolvePuzzle 649 7)
			)
			(6
				(gMessager say: 4 0 0 2)
				(gEgo cycleSpeed: local1 moveSpeed: local2)
				(self dispose:)
			)
		)
	)
)

