;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	rm211 0
)

(instance rm211 of KQ5Room
	(properties
		picture 14
		horizon 90
	)

	(method (init)
		(super init:)
		(HandsOff)
		(trees init:)
		(gEgo init:)
		(scorpion init:)
		(roomScript register: (if (< (gEgo x:) 160) 1 else 0))
		(self setScript: roomScript)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (== (gGlobalSound prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scorpion
					setLoop: (+ 8 register)
					x:
						(if register
							(+ (gEgo x:) 45)
						else
							(- (gEgo x:) 45)
						)
					y: (- (gEgo y:) 3)
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self
				)
			)
			(1
				(scorpion setLoop: (+ 12 register) cel: 0 setCycle: End self)
				(gGlobalSound number: 39 loop: 1 vol: 127 play:)
			)
			(2
				(scorpion setCycle: Beg self)
			)
			(3
				(gEgo view: 358 cycleSpeed: 2 normal: 0 setCycle: End self)
				((gEgo head:) hide:)
				(scorpion
					setLoop: (+ 8 (not register))
					setCycle: Fwd
					setMotion:
						MoveTo
						(if register 330 else -10)
						(+ (scorpion y:) 30)
				)
			)
			(4 0)
			(5
				(= global330
					{Watch for those critters, Graham!}
				)
				(EgoDead 244)
			)
		)
	)
)

(instance scorpion of Actor
	(properties
		view 352
		signal 24576
		illegalBits 0
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 211 0) ; "Don't step on the scorpion!"
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 211 1) ; "Stay away from scorpions!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance trees of Prop
	(properties
		x 294
		y 53
		view 352
		cel 3
		priority 3
		signal 1
	)
)

