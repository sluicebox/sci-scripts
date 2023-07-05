;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use n814)
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
	local10
	local11
	local12
	local13
)

(procedure (ThrowRock param1 param2 param3 &tmp temp0 temp1 temp2 temp3 [temp4 20])
	(if global426
		(return global426)
	)
	(if (not global102)
		(= local12 1)
	)
	(if (not (gEgo has: 10)) ; rock
		(gMessager say: 13 0 0 1 0 558) ; "You don't have any rocks."
		(DisposeScript 102)
		(return 0)
	else
		(if (>= argc 2)
			(= local1 param2)
			(= local2 param3)
		else
			(= local1 ((= temp3 (Event new:)) x:))
			(= local2 (+ (temp3 y:) 25))
			(temp3 dispose:)
		)
		(gEgo use: 10 1) ; rock
		(Load rsSOUND 2058)
		(if param1
			(Face gEgo param1)
			(= local3 (+ (param1 x:) (param1 targDeltaX:)))
			(= local4 (+ (param1 y:) (param1 targDeltaY:)))
			(= temp0 (- local3 (gEgo x:)))
			(= temp1 (- local4 (- (gEgo y:) 34)))
			(while (and (< 0 local3 319) (< 0 local4 189))
				(+= local3 temp0)
				(+= local4 temp1)
			)
			(if
				(not
					(TrySkill 10 0 (- 50 (/ (gEgo distanceTo: param1) 5))) ; throwing
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
		(= local0 param1)
		((= temp2 (Actor new:))
			view: 510
			setLoop: 4
			setCel: 0
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			z: 35
			setStep: 25 18
			init:
			hide:
			setScript: rockScript 0 param1
		)
		(return 1)
	)
)

(instance rockScript of Script
	(properties)

	(method (dispose)
		(= global426 0)
		(if (IsObject local11)
			(local11 dispose:)
		)
		(NormalEgo)
		(gEgo
			loop: (if (== (gEgo loop:) 2) 1 else 0)
			priority: local7
			illegalBits: local10
			signal: local6
			cycleSpeed: local8
			moveSpeed: local9
		)
		(if (IsObject register)
			(register getHurt: 1)
		)
		(super dispose:)
		(if local12
			(HandsOn)
		)
		(DisposeScript 102)
	)

	(method (doit)
		(if (IsObject local0)
			(= local3 (+ (local0 x:) (local0 targDeltaX:)))
			(= local4 (+ (local0 y:) (local0 targDeltaY:)))
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global426 client)
				(= local6 (gEgo signal:))
				(= local7 (gEgo priority:))
				(= local10 (gEgo illegalBits:))
				(= local8 (gEgo cycleSpeed:))
				(= local9 (gEgo moveSpeed:))
				(HandsOff)
				(if (gEgo onMe: local3 (- local4 35))
					(= local13 1)
				)
				(gEgo
					setMotion: 0
					setHeading: (if (<= local3 (gEgo x:)) 270 else 90) self
				)
			)
			(1
				(gEgo
					view: 510
					setLoop: (if (== (gEgo loop:) 0) 3 else 2)
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
				((= local11 (Sound new:)) number: 2058 priority: 15 init:)
			)
			(2
				(if local13
					(= local3 (gEgo x:))
					(= local4 (gEgo y:))
				)
				(= temp0
					(cond
						((< (= temp0 (Abs (- local3 (gEgo x:)))) 20) 10)
						((< temp0 30) 15)
						((< temp0 50) 20)
						((< temp0 80) 25)
						(else 30)
					)
				)
				(client
					posn:
						(if (== (gEgo loop:) 2)
							(- (gEgo x:) temp0)
						else
							(+ (gEgo x:) temp0)
						)
						(gEgo y:)
					setCycle: Fwd
					setMotion: MoveTo local3 local4 self
				)
				(gEgo setCycle: End)
				(= ticks 6)
			)
			(3
				(client show:)
			)
			(4
				(client hide:)
				(if (or local5 local13)
					(local11 play: self)
				else
					(self cue:)
				)
			)
			(5
				(if local13
					(if (not (TakeDamage 1))
						(EgoDead 142) ; "That's it!!! You've hurt you for the last time!"
					else
						(gMessager say: 13 0 0 2 0 558) ; "Ouch! You always hurt the one you love!"
					)
				)
				(client dispose:)
			)
		)
	)
)

