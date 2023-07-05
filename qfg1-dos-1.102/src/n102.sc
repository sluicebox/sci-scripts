;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ThrowRock 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (ThrowRock atWhat &tmp temp0 temp1 temp2)
	(if (not (gEgo has: 21)) ; boulder
		(HighPrint 102 0) ; "You do not have any rocks."
		(DisposeScript 102)
		(return 0)
	else
		(gEgo use: 21 1) ; boulder
		(Load rsSOUND (SoundFX 58))
		(if atWhat
			(LookAt gEgo atWhat)
			(= local3 (+ (atWhat x:) (atWhat targDeltaX:)))
			(= local4 (+ (atWhat y:) (atWhat targDeltaY:)))
			(= temp0 (- local3 (gEgo x:)))
			(= temp1 (- local4 (- (gEgo y:) 34)))
			(while (and (< 0 local3 319) (< 0 local4 189))
				(+= local3 temp0)
				(+= local4 temp1)
			)
			(if (not (TrySkill 10 0 (- 50 (/ (gEgo distanceTo: atWhat) 5)))) ; throwing
				(if (< local4 0)
					(+= local4 (Random 30 100))
				else
					(-= local4 (Random 30 100))
				)
			)
		)
		(if (not atWhat)
			(SkillUsed 10 (/ [gEgoStats 2] 10)) ; throwing, agility
			(= local3 (if (& (gEgo loop:) $0001) -10 else 330))
			(= local4 (Random 20 80))
		)
		(= local0 atWhat)
		((= temp2 (Act new:))
			view: 510
			setLoop: 4
			setCel: 0
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			z: 20
			posn: (- (gEgo x:) 10) (- (gEgo y:) 12)
			setStep: 20 8
			init:
			hide:
			setPri: 15
			setScript: rockScript 0 atWhat
		)
		(return 1)
	)
)

(instance rockScript of Script
	(properties)

	(method (dispose)
		(local9 dispose:)
		(HandsOn)
		(if (and local5 (IsObject register))
			(register getHurt: 1)
		)
		(super dispose:)
		(DisposeScript 102)
	)

	(method (doit &tmp temp0)
		(if (IsObject local0)
			(= local3 (+ (local0 x:) (local0 targDeltaX:)))
			(= local4 (+ (local0 y:) (local0 targDeltaY:)))
		)
		(= local1 (- (client x:) local3))
		(= local2 (- (client y:) local4))
		(if
			(and
				(== state 1)
				(or
					(= temp0 (and (< -15 local1 15) (< -15 local2 15)))
					(not (client mover:))
					(not (< 0 (client x:) 319))
					(not (< 0 (client y:) 189))
				)
			)
			(= local5 (if register temp0))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (gEgo signal:))
				(= local7 (gEgo priority:))
				(= local8 (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 510
					cycleSpeed: 1
					setLoop: (if (& (gEgo loop:) $0001) 2 else 3)
					cel: 0
					setCycle: CT 3 1 self
				)
				((= local9 (Sound new:))
					number: (SoundFX 58)
					priority: 15
					init:
				)
			)
			(1
				(gEgo setCycle: End)
				(client
					x:
						(if (== (gEgo loop:) 2)
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
					show:
					setCycle: Fwd
					setMotion: MoveTo local3 local4
				)
			)
			(2
				(client hide:)
				(if local5
					(local9 play: self)
				else
					(= cycles 1)
				)
			)
			(3
				(NormalEgo)
				(gEgo priority: local7 illegalBits: local8 signal: local6)
				(client dispose:)
			)
		)
	)
)

