;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	CastDart 0
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
)

(procedure (CastDart param1 &tmp temp0 temp1)
	(LoadMany rsSOUND (SoundFX 33) (SoundFX 45))
	(Load rsVIEW 522)
	(if param1
		(LookAt gEgo param1)
		(= local3 (+ (param1 x:) (param1 targDeltaX:)))
		(= local4 (+ (param1 y:) (param1 targDeltaY:)))
		(= temp0 (- local3 (gEgo x:)))
		(= temp1 (- local4 (- (gEgo y:) 20)))
		(while (and (< 0 local3 319) (< 0 local4 189))
			(+= local3 temp0)
			(+= local4 temp1)
		)
		(if (not (TrySkill 12 0 (- 50 (/ (gEgo distanceTo: param1) 5)))) ; magic
			(if (< local4 0)
				(+= local4 (Random 30 100))
			else
				(-= local4 (Random 30 100))
			)
		)
	)
	(if (not param1)
		(SkillUsed 10 (/ [gEgoStats 2] 10)) ; throwing, agility
		(= local3 (if (== (gEgo loop:) 1) -10 else 330))
		(= local4 (Random 20 80))
	)
	((= local10 (Sound new:)) number: (SoundFX 33) priority: 15 init:)
	(= local0 param1)
	((= local9 (Act new:))
		view: 522
		setLoop: 2
		setCel: 0
		illegalBits: 0
		ignoreActors:
		ignoreHorizon:
		z: 20
		posn: (gEgo x:) (- (gEgo y:) 6)
		setStep: 12 8
		init:
		hide:
		setScript: dartScript 0 param1
	)
	(return 1)
)

(instance dartScript of Script
	(properties)

	(method (dispose)
		(local10 dispose:)
		(HandsOn)
		(if local5
			(register getHurt: (/ [gEgoStats 23] 2)) ; flameDartSpell
		)
		(super dispose:)
		(DisposeScript 100)
	)

	(method (doit)
		(= local1
			(-
				(local9 x:)
				(if local0
					(local0 x:)
				else
					local3
				)
			)
		)
		(= local2
			(-
				(local9 y:)
				(if local0
					(+ (local0 y:) (local0 targDeltaY:))
				else
					local4
				)
			)
		)
		(if
			(and
				(== state 1)
				(or
					(and (< -25 local1 25) (< -25 local2 25))
					(not (< 0 (local9 x:) 319))
					(not (< 0 (local9 y:) 189))
				)
			)
			(if (and register (< -25 local1 25) (< -25 local2 25))
				(= local5 1)
			else
				(= local5 0)
			)
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
					view: 522
					setLoop:
						(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
							1
						else
							0
						)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(local10 play:)
				(client
					x:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) 19)
						else
							(+ (gEgo x:) 19)
						)
					show:
					setCycle: Fwd
					setMotion: MoveTo local3 local4
				)
			)
			(2
				(if (and register local5)
					(local10 stop: number: (SoundFX 45) play:)
					(client setLoop: 3 cel: 0 setMotion: 0 setCycle: End self)
				else
					(client hide:)
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

