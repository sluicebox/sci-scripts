;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 173)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	trappedByDoors 0
	dropBone 2
	trappedByDoors 3
	proc173_4 4
)

(local
	local0
	local1
)

(procedure (proc173_4 param1 param2)
	(if (> (gEgo distanceTo: param1) 25)
		(NotClose) ; "Perhaps you should move closer."
		(DisposeScript 173)
	else
		(pickUpTheBone register: param1)
		(ClearFlag param2)
		(gEgo setScript: pickUpTheBone)
	)
)

(instance trappedByDoors of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gRegMusic stop:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(== (gSFX number:) (proc0_20 87))
				(== (gSFX prevSignal:) 10)
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(gEgo illegalBits: $c070)
				(Print 173 0) ; "Your fate is sealed, as is this room. I cannot bear to remain and watch the slow, lingering death that awaits you within this dusty tomb. Farewell, Arthur."
				(gCurRoom style: 8 drawPic: 112)
				(gCast eachElementDo: #hide)
				(= seconds 2)
			)
			(2
				(EgoDead)
			)
		)
	)
)

(instance dropBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 2)
				(= cycles 4)
			)
			(1
				((= register (Act new:))
					view: 267
					setLoop: 1
					setCel: 0
					illegalBits: 0
					ignoreActors:
					posn: (- (gEgo x:) 10) (- (gEgo y:) 25)
					setStep: 3 4
					init:
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 3)
						self
				)
			)
			(2
				(register setCycle: End self)
			)
			(3
				(PutItem 9) ; herbs | bone
				(register dispose:)
				(= cycles 2)
			)
			(4
				(Print 173 1) ; "It was so old, it crumbled to dust upon hitting the floor."
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 173)
			)
		)
	)
)

(instance pickUpTheBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gEgo illegalBits:))
				(= local1 (gEgo cycler:))
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion:
						MoveTo
						(- ((pickUpTheBone register:) x:) 18)
						(+ ((pickUpTheBone register:) y:) 2)
						self
				)
			)
			(1
				(gEgo view: 93 cel: 0 cycler: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo get: 9) ; herbs | bone
				((pickUpTheBone register:) dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(Print 173 2) ; "It is a terribly old, moldering bone. I cannot imagine why you want it."
				(gEgo
					view: 0
					illegalBits: local0
					ignoreActors: 0
					setCycle: 0
					cycler: local1
				)
				(client setScript: 0)
				(HandsOn)
				(DisposeScript 173)
			)
		)
	)
)

