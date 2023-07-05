;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 157)
(include sci.sh)
(use Main)
(use Interface)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	killEgo 0
	guard 1
)

(instance guard of Actor
	(properties
		view 417
		cycleSpeed 3
		xStep 4
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self
			hide:
			posn: 327 223 moveSpeed (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
			setCycle: Walk
			setLoop: Grooper
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 157 0) ; "What do you want to do, make faces at him to scare him away?"
			)
			(2 ; Look
				(Print 157 1) ; "Oh, crud! It's one of the Sarien guards. I don't think you're going to enjoy this visit."
			)
			(11 ; Taste
				(Print 157 2) ; "Go ahead. Walk on up and give it a try."
			)
			(12 ; Smell
				(Print 157 2) ; "Go ahead. Walk on up and give it a try."
			)
			(4 ; Inventory
				(Print 157 3) ; "You probably thought that was actually going to work. Ha!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard init: show: setMotion: MoveTo 270 175 self)
			)
			(1
				(Face gEgo guard self)
			)
			(2
				(cond
					((& (gEgo onControl: 0) $0010)
						(guard setLoop: 1)
					)
					((& (gEgo onControl: 0) $0040)
						(guard setLoop: 4)
					)
					(else
						(guard setLoop: 5)
					)
				)
				(guard view: 415 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					view: 48
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(4
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

