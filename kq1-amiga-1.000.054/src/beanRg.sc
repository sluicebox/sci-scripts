;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 606)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Rev)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	beanRg 0
)

(local
	local0
	local1
	local2
)

(instance beanRg of Rgn
	(properties)

	(method (init)
		(self keep: 0)
		(super init: &rest)
		(LoadMany rsVIEW 1 270)
		(Load rsPIC 270)
		(Load rsSOUND 94)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			((Said 'bury/bean')
				(cond
					(global131
						(Print 606 0) ; "You've already planted them."
					)
					((not (gEgo has: 20)) ; Beans
						(if (IsFlag 35)
							(Print 606 1) ; "You ate the beans."
						else
							(proc0_6) ; "You don't have anything that fits that description in your inventory."
						)
					)
					((not (& (gEgo onControl: 1) $0400))
						(Print 606 2) ; "That is not a bad idea, but this is not a very suitable place to plant these beans. Why don't you try it elsewhere?"
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((IsFlag 1)
						(Print 606 3) ; "You can't plant the beans while you're invisible."
					)
					(else
						(if
							(and
								(gCast contains: gGoat)
								(gGoat inRect: 110 125 220 150)
							)
							(= local1 (if (< (gGoat x:) 165) -1 else 1))
							(= local2 (if (< (gGoat y:) 137) -1 else 1))
						)
						(gCurRoom setScript: plantBeans)
					)
				)
			)
		)
	)
)

(instance plantBeans of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> state 3) (!= local0 ((ScriptID 0 21) prevSignal:))) ; gameSound
			(= local0 ((ScriptID 0 21) prevSignal:)) ; gameSound
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 131 138 self
				)
			)
			(1
				(SetScore 109 2)
				(gEgo
					loop: 0
					cel: 0
					view: 1
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(proc0_1)
				(Print 606 4) ; "You plant the magical beans in the fertile soil. Suddenly, something incredible begins to happen!"
				(self cue:)
			)
			(4
				((ScriptID 0 23) pause: 1) ; backSound
				((ScriptID 0 21) init: number: 94 playBed:) ; gameSound
				(gEgo setLoop: 0 setCycle: SyncWalkBack 2)
				(= cycles 1)
			)
			(5 0)
			(6
				(ShakeScreen 1 ssUPDOWN)
				(stalk posn: 149 138 init: setCycle: End)
				(gEgo setMotion: MoveTo 127 138)
				(if local1
					(= global120 (+ (gGoat x:) (* local1 5)))
					(= global121 (+ (gGoat y:) (* local2 3)))
					(gGoat setMotion: MoveTo global120 global121)
				)
				(= global131 gCurRoomNum)
			)
			(7
				(ShakeScreen 8 ssFULL_SHAKE)
				(stalk loop: 1 cel: 0 setCycle: End)
				(gEgo setMotion: MoveTo 117 138)
				(if local1
					(= global120 (+ (gGoat x:) (* local1 5)))
					(= global121 (+ (gGoat y:) (* local2 3)))
					(gGoat setMotion: MoveTo global120 global121)
				)
			)
			(8
				(ShakeScreen 12 ssUPDOWN)
				(stalk loop: 2 cel: 0 setCycle: CT 5 1)
				(gEgo setMotion: MoveTo 107 138)
				(if local1
					(= global120 (+ (gGoat x:) (* local1 5)))
					(= global121 (+ (gGoat y:) (* local2 3)))
					(gGoat setMotion: MoveTo global120 global121)
				)
			)
			(9
				(ShakeScreen 18 ssFULL_SHAKE)
				(if local1
					(= global120 (+ (gGoat x:) (* local1 5)))
					(= global121 (+ (gGoat y:) (* local2 3)))
					(gGoat setMotion: MoveTo global120 global121)
				)
				(stalk stopUpd:)
				(self cue:)
			)
			(10
				(gCurRoom overlay: 270 4)
				(proc0_1)
				(proc0_15 gEgo stalk)
				(stalk dispose:)
				(if (and (!= global119 gCurRoomNum) (IsFlag 2))
					(= global120 0)
					(= global121 0)
					(gGoat setMotion: Follow gEgo 60)
				)
				(HandsOn)
				(gCurRoom setRegions: 607) ; stalkRg
				((ScriptID 0 23) pause: 0) ; backSound
				(self dispose:)
			)
		)
	)
)

(instance stalk of Prop
	(properties
		description {beanstalk}
		view 270
		cycleSpeed 2
	)
)

(class SyncWalkBack of Rev
	(properties
		xLast 0
		yLast 0
		vWalking 0
		vStopped 0
	)

	(method (init param1 param2)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
			)
		)
		(super init: client)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if
			(and
				(IsObject (= temp0 (client mover:)))
				(or (!= (client x:) xLast) (!= (client y:) yLast))
			)
			(= xLast (client x:))
			(= yLast (client y:))
			(super doit:)
		)
		(if (client isStopped:)
			(if (== (client view:) vWalking)
				(client view: vStopped)
				(if (and (= temp1 (client mover:)) (not (temp1 completed:)))
					(client setMotion: 0)
				)
				(super doit:)
			)
		else
			(if (== (client view:) vStopped)
				(client view: vWalking)
			)
			(super doit:)
		)
	)

	(method (nextCel)
		(= cycleCnt (client cycleSpeed:))
		(super nextCel:)
	)
)

