;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ThrowKnife 0
)

(local
	knTarg
	thisX
	thisY
	knTargX
	knTargY
	gotHit
	savSignal
	savPriority
	savIllegalBits
	projSound
)

(procedure (ThrowKnife atWhat &tmp pushX pushY projectile)
	(if (!= gCurRoomNum global273)
		(= global273 gCurRoomNum)
		(= global271 0)
	)
	(if (not (gEgo has: 7)) ; dagger
		(HighPrint 101 0) ; "You do not have any daggers."
		(return 0)
	else
		(gEgo use: 7 1) ; dagger
		(Load rsSOUND (SoundFX 31))
		(Load rsSOUND (SoundFX 29))
		(if atWhat
			(LookAt gEgo atWhat)
			(= knTargX (+ (atWhat x:) (atWhat targDeltaX:)))
			(= knTargY (+ (atWhat y:) (atWhat targDeltaY:)))
			(= pushX (- knTargX (+ (gEgo x:) 15)))
			(= pushY (- knTargY (- (gEgo y:) 40)))
			(while (and (< 0 knTargX 319) (< 0 knTargY 189))
				(+= knTargX pushX)
				(+= knTargY pushY)
			)
			(if (not (TrySkill 10 0 (- 50 (/ (gEgo distanceTo: atWhat) 5)))) ; throwing
				(if (< knTargY 0)
					(+= knTargY (Random 30 100))
				else
					(-= knTargY (Random 30 100))
				)
			)
		)
		(if (not atWhat)
			(SkillUsed 10 (/ [gEgoStats 2] 10)) ; throwing, agility
			(= knTargX (if (& (gEgo loop:) $0001) -10 else 330))
			(= knTargY (Random 20 80))
		)
		((= projSound (Sound new:)) number: (SoundFX 31) priority: 15 init:)
		(= knTarg atWhat)
		((= projectile (Act new:))
			view: 524
			setLoop: 2
			setCel: 0
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			z: 20
			posn: (gEgo x:) (- (gEgo y:) 20)
			setStep: 12 8
			init:
			hide:
			setScript: knifeScript 0 atWhat
		)
		(return 1)
	)
)

(instance knifeScript of Script
	(properties)

	(method (dispose)
		(projSound dispose:)
		(HandsOn)
		(if (and gotHit (IsObject register))
			(register getHurt: (+ 5 (/ [gEgoStats 0] 10))) ; strength
		)
		(super dispose:)
	)

	(method (doit &tmp hitFlag)
		(if (IsObject knTarg)
			(= knTargX (+ (knTarg x:) (knTarg targDeltaX:)))
			(= knTargY (+ (knTarg y:) (knTarg targDeltaY:)))
		)
		(= thisX (- (client x:) knTargX))
		(= thisY (- (client y:) knTargY))
		(if
			(and
				(== state 1)
				(or
					(= hitFlag (and (< -15 thisX 15) (< -15 thisY 15)))
					(not (client mover:))
					(not (< 0 (client x:) 319))
					(not (< 0 (client y:) 189))
				)
			)
			(= gotHit (if register hitFlag))
			(self cue:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= savSignal (gEgo signal:))
				(= savPriority (gEgo priority:))
				(= savIllegalBits (gEgo illegalBits:))
				(HandsOff)
				(gEgo
					view: 524
					setLoop: (if (& (gEgo loop:) $0001) 1 else 0)
					cel: 0
					setCycle: CT 9 1 self
				)
				(++ global271)
			)
			(1
				(gEgo setCycle: End)
				(projSound play:)
				(client
					x:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 15)
						else
							(+ (gEgo x:) 15)
						)
					show:
					setLoop: (+ (gEgo loop:) 2)
					setMotion: MoveTo knTargX knTargY
				)
			)
			(2
				(client hide:)
				(if gotHit
					(-- global271)
					(++ global272)
					(projSound stop: number: (SoundFX 29) play: self)
				else
					(= cycles 1)
				)
			)
			(3
				(NormalEgo)
				(gEgo priority: savPriority illegalBits: savIllegalBits signal: savSignal)
				(client dispose:)
			)
		)
	)
)

