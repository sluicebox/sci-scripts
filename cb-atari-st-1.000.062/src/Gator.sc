;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Chase)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Gator 0
)

(local
	local0
)

(instance Gator of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsSOUND 10)
		(if
			(= local0
				(if gDetailLevel
					(and (> (gEgo y:) 161) (== (Random 1 3) 2))
				)
			)
			(if (< (gEgo x:) 160)
				(gatorHead setLoop: 0 posn: -28 173)
				(gatorBody setLoop: 2 posn: -40 173)
			else
				(gatorHead setLoop: 1 posn: 349 173)
				(gatorBody setLoop: 3 posn: 361 173)
			)
			(gatorHead init: hide:)
			(gatorBody init: hide:)
		)
	)

	(method (doit)
		(if (gCast contains: gatorHead)
			(gatorHead
				posn:
					(if (& (gatorHead loop:) $0001)
						(- (gatorBody x:) 12)
					else
						(+ (gatorBody x:) 12)
					)
					(gatorBody y:)
			)
		)
		(if
			(and
				local0
				(or
					(and (gatorHead loop:) (< (gEgo x:) 275))
					(and (not (gatorHead loop:)) (> (gEgo x:) 55))
				)
			)
			(gatorHead setCycle: Fwd show:)
			(gatorBody setCycle: Walk setScript: GrabEgo show:)
			(= local0 0)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look/alligator'))
			(if (gCast contains: gatorBody)
				(Print 405 0) ; "That's one big, mean-looking alligator!"
			else
				(NotHere) ; "You don't see it here."
			)
		)
	)
)

(instance GrabEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gatorBody setMotion: Chase gEgo 35 self)
			)
			(1
				(HandsOff)
				(gatorBody stopUpd:)
				(gatorHead
					loop: (+ (gatorHead loop:) 4)
					cel: 0
					setCycle: End self
				)
				(gEgo hide:)
			)
			(2
				(scream play:)
				(gatorHead
					loop: (+ (gatorHead loop:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gatorHead loop: (+ (gatorHead loop:) 2) cel: 0 setCycle: Fwd)
				(gatorBody
					startUpd:
					setMotion:
						MoveTo
						(if (& (gatorHead loop:) $0001) -80 else 400)
						(gatorBody y:)
						self
				)
			)
			(4
				(scream dispose:)
				(= temp0 (myIcon lastCel:))
				(= global128 myIcon)
				(= global129 0)
				(= global130 temp0)
				(= global132 1)
				(EgoDead 405 1) ; "Laura, please don't feed the animals!"
				(client setScript: 0)
			)
		)
	)
)

(instance gatorHead of Act
	(properties
		view 208
		signal 16384
	)
)

(instance gatorBody of Act
	(properties
		yStep 4
		view 208
		signal 16384
		xStep 6
	)
)

(instance myIcon of DCIcon
	(properties
		view 650
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance scream of Sound
	(properties
		number 53
		priority 15
	)
)

