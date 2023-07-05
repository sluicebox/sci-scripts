;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use n814)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ThrowKnife 0
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
)

(procedure (ThrowKnife param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(if global426
		(return 1)
	)
	(if (not global102)
		(= local10 1)
	)
	(if (!= gCurRoomNum global252)
		(= global252 gCurRoomNum)
		(= global250 0)
	)
	(if (not (gEgo has: 6)) ; dagger
		(gMessager say: 3 0 0 1 0 558) ; "You don't have any daggers."
		(DisposeScript 101)
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
		((gInventory at: 6) dumpIt: 1) ; dagger
		(LoadMany rsSOUND 2031 2029)
		(if param1
			(Face gEgo param1)
			(= local3 (+ (param1 x:) (param1 targDeltaX:)))
			(= local4 (+ (param1 y:) (param1 targDeltaY:)))
			(= temp0 (- local3 (+ (gEgo x:) 15)))
			(= temp1 (- local4 (- (gEgo y:) 40)))
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
		((= local9 (Sound new:)) number: 2031 priority: 15 init:)
		(= local0 param1)
		((= temp2 (Actor new:))
			view: 524
			setLoop: 2
			setCel: 0
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			z: 35
			setStep: 30 20
			init:
			hide:
			setScript: knifeScript 0 param1
		)
		(return 1)
	)
)

(instance knifeScript of Script
	(properties)

	(method (dispose)
		(= global426 0)
		(local9 dispose:)
		(if local10
			(HandsOn)
		)
		(NormalEgo)
		(gEgo
			loop: (if (not (gEgo loop:)) 0 else 1)
			priority: local7
			illegalBits: local8
			signal: local6
			cycleSpeed: local5
		)
		(if (IsObject register)
			(register getHurt: (+ 5 (/ [gEgoStats 0] 10))) ; strength
		)
		(super dispose:)
		(DisposeScript 101)
	)

	(method (doit &tmp temp0)
		(if (IsObject local0)
			(= local3 (+ (local0 x:) (local0 targDeltaX:)))
			(= local4 (+ (local0 y:) (local0 targDeltaY:)))
		)
		(super doit:)
	)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(= global426 client)
				(= local6 (gEgo signal:))
				(= local7 (gEgo priority:))
				(= local8 (gEgo illegalBits:))
				(= local5 (gEgo cycleSpeed:))
				(HandsOff)
				(if (gEgo onMe: local3 (- local4 35))
					(= local11 1)
				)
				(gEgo
					setMotion: 0
					setHeading: (if (<= local3 (gEgo x:)) 270 else 90)
				)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 524
					setLoop: (if (== (gEgo loop:) 0) 0 else 1)
					cel: 0
					cycleSpeed: 8
					setCycle: CT 7 1 self
				)
				(++ global250)
			)
			(2
				(if local11
					(= local3 (gEgo x:))
					(= local4 (gEgo y:))
				)
				(local9 play:)
				(= param2
					(cond
						((< (= param2 (Abs (- local3 (gEgo x:)))) 20) 15)
						((< param2 30) 20)
						((< param2 50) 25)
						((< param2 80) 30)
						(else 35)
					)
				)
				(client
					posn:
						(if (== (gEgo loop:) 1)
							(- (gEgo x:) param2)
						else
							(+ (gEgo x:) param2)
						)
						(if (!= (gEgo loop:) 1)
							(- (gEgo y:) 30)
						else
							(gEgo y:)
						)
					setLoop: (+ (gEgo loop:) 2)
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
				(if (not local11)
					(-- global250)
					(++ global251)
				)
				(local9 number: 2029 play:)
				(= cycles 1)
			)
			(5
				(if local11
					(if (not (TakeDamage 50))
						(EgoDead 142) ; "That's it!!! You've hurt you for the last time!"
					else
						(gMessager say: 3 0 0 2 0 558) ; "Ouch! You threw your dagger... Now you're stuck with it!"
					)
				)
				(HandsOn)
				(client dispose:)
				(= cycles 1)
			)
		)
	)
)

