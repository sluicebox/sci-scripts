;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rm125 0
)

(local
	[local0 3]
)

(instance rm125 of Rm
	(properties
		picture 201
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			view:
				(cond
					(global140
						(if global204 306 else 296)
					)
					(global204 6)
					(else 0)
				)
			x:
				(switch gPrevRoomNum
					(123
						(if (<= (gEgo x:) 70) 165 else 237)
					)
					(126 305)
					(128
						(if (>= (gEgo x:) 235) 140 else 35)
					)
				)
			y:
				(switch gPrevRoomNum
					(123
						(if (<= (gEgo x:) 70) 100 else 95)
					)
					(126
						(if (<= (gEgo y:) 115) 95 else 135)
					)
					(128 180)
				)
			init:
		)
		(HandsOn)
		(if (!= gPrevRoomNum 123)
			(= global156 70)
		)
		(if (and (== gPrevRoomNum 123) (>= (gEgo x:) 70) (>= global156 20))
			(-= global156 10)
		)
		((= [local0 0] (Prop new:))
			view: 99
			loop: 1
			cel: 0
			posn: 260 128
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local0 1] (Prop new:))
			view: 99
			loop: 1
			cel: 2
			posn: 317 130
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		((= [local0 2] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 176 141
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 3
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local0 1] stopUpd:)
			([local0 2] stopUpd:)
		)
		(if (< global110 30)
			([local0 0] stopUpd:)
		)
		(gLightObj posn: 127 78 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 226 56 ignoreActors: 1 init: stopUpd:)
		(cockroach
			setLoop: 0
			ignoreActors:
			init:
			setMotion: MoveTo 147 50 cockroach
		)
	)

	(method (doit)
		(cond
			(global139 0)
			((>= (gEgo x:) 315)
				(if (not global140)
					(Print 125 0) ; "You seem to have made it through the pocket of deadly methane gas."
				else
					(Print 125 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
				)
				(= global156 -1)
				(= global140 0)
				(gCurRoom newRoom: 126)
			)
			((>= (gEgo y:) 190)
				(cond
					((> global156 60) 0)
					((not global140)
						(Print 125 0) ; "You seem to have made it through the pocket of deadly methane gas."
					)
					(else
						(Print 125 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
					)
				)
				(= global156 -1)
				(= global140 0)
				(gCurRoom newRoom: 128)
			)
			((gEgo inRect: 175 85 250 94)
				(gCurRoom newRoom: 123)
			)
		)
		(super doit:)
	)
)

(instance cockroach of Act
	(properties
		y 108
		x 147
		yStep 1
		view 260
		illegalBits 0
	)

	(method (cue)
		(self posn: 0 1000)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(if (Said '/bug>')
			(cond
				((>= (cockroach x:) 200)
					(Print 125 2) ; "You don't see any bugs here."
					(event claimed: 1)
				)
				((Said 'look')
					(Print 125 3) ; "You look at the enormous cockroaches and think to yourself... "The balance of nature is intact, even in the sewer...only the large and the healthy survive.""
				)
				((Said 'get')
					(Print 125 4) ; "The bugs are not something to play with."
				)
			)
		)
	)
)

