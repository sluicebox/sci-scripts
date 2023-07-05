;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use TargActor)
(use n814)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	CastDart 0
	dartScript 1
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
	local10
	local11
	local12
)

(procedure (CastDart param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(if global426
		(return global426)
	)
	(= global194 100)
	(if (>= argc 3)
		(= local1 param3)
		(= local2 param4)
	else
		(= local1 ((= temp3 (Event new:)) x:))
		(= local2 (+ (temp3 y:) 24))
		(temp3 dispose:)
	)
	(if (not global102)
		(= local10 1)
	)
	(LoadMany rsSOUND (SoundFX 33) (SoundFX 45))
	(Load rsVIEW 522)
	(if param1
		(Face gEgo param1)
		(= local3 (+ (param1 x:) (param1 targDeltaX:)))
		(= local4 (+ (param1 y:) (param1 targDeltaY:)))
		(= temp0 (- local3 (gEgo x:)))
		(= temp1 (- local4 (- (gEgo y:) 25)))
		(while (and (< 0 local3 319) (< 0 local4 189))
			(+= local3 temp0)
			(+= local4 temp1)
		)
		(if
			(and
				(param1 isKindOf: TargActor)
				(not
					(TrySkill 12 0 (- 50 (/ (gEgo distanceTo: param1) 5))) ; magic
				)
			)
			(if (< local4 0)
				(+= local4 (Random 30 100))
			else
				(-= local4 (Random 30 100))
			)
		)
	else
		(SkillUsed 10 (/ [gEgoStats 2] 10)) ; throwing, agility
		(= local3 local1)
		(= local4 local2)
	)
	((= local9 (Sound new:)) number: (SoundFX 33) priority: 15 init:)
	(= local0 param1)
	((= temp2 (Actor new:))
		view: 522
		setLoop: 2
		setCel: 0
		illegalBits: 0
		ignoreActors:
		ignoreHorizon:
		z: 34
		setStep: 12 8
		init:
		hide:
		setScript: dartScript (if (>= argc 2) param2 else 0) param1
	)
	(return 1)
)

(instance dartScript of Script
	(properties)

	(method (dispose)
		(local9 dispose:)
		(= global426 0)
		(if local10
			(HandsOn)
		)
		(NormalEgo)
		(gEgo
			loop: (if (gEgo loop:) 5 else 4)
			priority: local7
			illegalBits: local8
			signal: local6
			cycleSpeed: local5
		)
		(proc814_31)
		(super dispose:)
		(DisposeScript 100)
	)

	(method (doit &tmp temp0)
		(if (IsObject local0)
			(= local3 (+ (local0 x:) (local0 targDeltaX:)))
			(= local4 (+ (local0 y:) (local0 targDeltaY:)))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global426 client)
				(= local12 0)
				(= local6 (gEgo signal:))
				(= local7 (gEgo priority:))
				(= local8 (gEgo illegalBits:))
				(= local5 (gEgo cycleSpeed:))
				(HandsOff)
				(if (gEgo onMe: local3 (- local4 34))
					(= local11 1)
				)
				(gEgo
					setMotion: 0
					setHeading: (if (<= local3 (gEgo x:)) 225 else 135) self
				)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					view: 522
					setLoop: (if (== (gEgo loop:) 4) 0 else 1)
					cel: 0
					cycleSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo setCycle: End)
				(if local11
					(= local3 (gEgo x:))
					(= local4 (gEgo y:))
				)
				(local9 play:)
				(client
					posn:
						(if (gEgo loop:)
							(- (gEgo x:) 25)
						else
							(+ (gEgo x:) 25)
						)
						(gEgo y:)
					show:
					setCycle: Fwd
					setMotion: MoveTo local3 local4 self
				)
			)
			(3
				(if (and (IsFlag 281) (not local12))
					(-= state 1)
					(= local12 1)
					(client setMotion: MoveTo (gEgo x:) (gEgo y:) self)
				else
					(local9 stop: number: (SoundFX 45) play:)
					(client setLoop: 3 cel: 0 setMotion: 0 setCycle: End self)
				)
			)
			(4
				(= ticks 12)
			)
			(5
				(if local11
					(if (not (TakeDamage 100))
						(EgoDead 51) ; "I don't mean to throw this in your face, but why did you throw that in your face?"
					else
						(gMessager say: 13 0 0 2 0 558) ; "Ouch! You always hurt the one you love!"
					)
				)
				(cond
					((IsObject register)
						(register getHurt: (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
					)
					((and local12 (> [gEgoStats 14] 0)) ; health
						(TakeDamage 100)
					)
				)
				(client dispose:)
			)
		)
	)
)

