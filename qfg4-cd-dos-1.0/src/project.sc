;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	project 0
)

(local
	local0
	local1 = 30
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(instance project of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(= local6 (IntArray with: 20 -20 10 -10))
		(= local7 (IntArray with: 0 0 0 0))
		(= local8 (IntArray with: 10 -10 -10 10))
		(= local9 (IntArray with: -5 -5 -5 -5))
		(= local10 (IntArray with: 0 1 0 0 0 1 0 1))
		(= local11 (IntArray with: 2 3 6 7))
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
					(if (>= argc 4)
						(= local4 param4)
					else
						(= local4 0)
					)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose)
		(local6 dispose:)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local10 dispose:)
		(local11 dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_12 gMouseX (- gMouseY 10))
				(gGlory handsOff:)
				(Face gEgo global441 global442 self)
			)
			(1
				(if (== register 36)
					(= register 37)
				)
				(= local3 (gEgo heading:))
				(= local0 (gEgo loop:))
				(gEgo setMotion: 0)
				(gEgo
					view:
						(cond
							((< register 75) 9)
							(
								(==
									(and
										(> (gEgo view:) 17)
										(< (gEgo view:) 21)
									)
									1
								)
								18
							)
							(else 14)
						)
					loop:
						(cond
							((<= 0 local3 85)
								(= local2 2)
							)
							((<= 86 local3 180)
								(= local2 0)
							)
							((<= 181 local3 274)
								(= local2 1)
							)
							(else
								(= local2 3)
							)
						)
					setCel: 0
				)
				(cond
					((< register 75)
						(gEgo setCycle: CT 4 1 self)
					)
					((== (and (> (gEgo view:) 17) (< (gEgo view:) 21)) 1)
						(gEgo setCycle: CT 2 1 self)
					)
					(else
						(gEgo setCycle: End self)
					)
				)
			)
			(2
				(if (OneOf register 21 37)
					(if [gEgoStats 10] ; throwing
						(gEgo useSkill: 10 25 useSkill: 0 3 useSkill: 2 5) ; throwing, strength, agility
					)
					(gEgo useStamina: 2)
					(= temp0 (Random 0 (>> (+ (- 400 [gEgoStats 10]) 4) $0002))) ; throwing
					(+=
						global441
						(if (Random 0 1)
							(- 0 temp0)
						else
							temp0
						)
					)
					(+=
						global442
						(if (Random 0 1)
							(- 0 temp0)
						else
							temp0
						)
					)
				)
				((ProjObj new:) fixPriority: 1 type: register init:)
				(switch register
					(86
						(spellSoundFX number: 933 play:)
					)
					(88
						(spellSoundFX number: 938 play:)
					)
					(93
						(spellSoundFX number: 974 play:)
					)
					(79
						(spellSoundFX number: 983 play:)
					)
					(else
						(spellSoundFX number: 916 play:)
					)
				)
				(if
					(or
						(and (> (gEgo view:) 17) (< (gEgo view:) 21))
						(< register 75)
					)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(if (not (and (> (gEgo view:) 17) (< (gEgo view:) 21)))
					(gEgo normalize: local0)
				else
					(gEgo
						view: 20
						loop: (local11 at: (gEgo loop:))
						cel: (if (< (local11 at: (gEgo loop:)) 6) 4 else 5)
					)
				)
				(= cycles 2)
			)
			(4
				(if (not (IsFlag 9))
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(class ProjObj of Actor
	(properties
		signal 24577
		type 0
		cuedOnce 0
	)

	(method (init)
		(if (== type 37)
			(gEgo drop: 5 1) ; theThrowdagger
		)
		(if (== type 21)
			(gEgo drop: 6 1) ; theRocks
		)
		(self
			view: (if (> type 75) 21 else 46)
			setLoop:
				(switch type
					(37
						(+ (local10 at: local0) 2)
					)
					(21 4)
					(86 2)
					(88 13)
					(93 4)
					(79 13)
					(33 6)
					(else 4)
				)
				1
			x:
				(+
					(gEgo x:)
					(/
						(*
							(gEgo scaleY:)
							(switch (gEgo view:)
								(14
									(local6 at: (gEgo loop:))
								)
								(9
									(local8 at: (gEgo loop:))
								)
								(18
									(local6 at: (gEgo loop:))
								)
								(else
									(local8 at: (gEgo loop:))
								)
							)
						)
						128
					)
				)
			y:
				(+
					(gEgo y:)
					(/
						(*
							(gEgo scaleY:)
							(switch (gEgo view:)
								(14
									(local7 at: (gEgo loop:))
								)
								(9
									(local9 at: (gEgo loop:))
								)
								(else
									(local9 at: (gEgo loop:))
								)
							)
						)
						128
					)
					(- 0 (/ scaleY 4))
				)
			setStep: 8 5
			moveSpeed: 0
			illegalBits: 0
			scaleX: (gEgo scaleX:)
			scaleY: (gEgo scaleY:)
			setCycle: Fwd
		)
		(if local4
			(self setMotion: MoveTo (local4 x:) (local4 y:) self)
		else
			(self setMotion: MoveTo global441 global442 self)
		)
		(super init:)
		(SetNowSeen self)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (> y (gEgo y:))
			(= priority y)
		else
			(= priority (gEgo priority:))
		)
		(super doit: &rest)
		(= temp2 (/ (- nsRight nsLeft) 2))
		(if
			(and
				(not cuedOnce)
				gList
				(= temp0 (gList firstTrue: #onMe x y))
			)
			(switch type
				(37
					(= temp1 (+ 16 (/ [gEgoStats 0] 20))) ; strength
				)
				(21
					(= temp1 (+ 3 (/ [gEgoStats 0] 20))) ; strength
				)
				(86
					(= temp1 (+ 10 (/ [gEgoStats 26] 10))) ; flameDartSpell
				)
				(88
					(= temp1 (+ 8 (/ [gEgoStats 28] 20))) ; forceSpell
				)
				(93
					(= temp1 (+ 12 (/ [gEgoStats 33] 10))) ; lightningSpell
				)
				(79
					(= temp1 (+ 16 (/ [gEgoStats 34] 10))) ; frostSpell
				)
			)
			(cond
				(local4
					(local4 getHurt: type temp1)
				)
				(temp0
					(temp0 getHurt: type temp1)
				)
			)
			(= local5 0)
			(self cue:)
		)
	)

	(method (cue)
		(if (not cuedOnce)
			(= cuedOnce 1)
			(if local4
				(= local5 1)
			)
			(self setScript: (checkLoop new:) self)
		else
			(if (self script:)
				((self script:) caller: 0)
				(self setScript: 0)
			)
			(self dispose:)
		)
	)
)

(instance checkLoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cuedOnce: 1)
				(if (== (client view:) 21)
					(cond
						((== (client loop:) 13)
							(client
								setLoop: 14 1
								setMotion: 0
								setCycle: End self
							)
						)
						((< -1 (client loop:) 4)
							(client
								setLoop: 9 1
								setMotion: 0
								setCycle: End self
							)
							(spellSoundFX number: 930 play: 0)
						)
						((< (client loop:) 6)
							(client
								setLoop: 10 1
								setMotion: 0
								setCycle: End self
							)
							(spellSoundFX number: 930 play:)
						)
						(else
							(client setMotion: 0 hide: setCycle: End self)
						)
					)
				else
					(spellSoundFX number: 921 play:)
					(client setMotion: 0 hide: setCycle: End self)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance spellSoundFX of Sound
	(properties)
)

