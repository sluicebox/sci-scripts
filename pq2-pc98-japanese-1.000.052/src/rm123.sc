;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rm123 0
)

(local
	[local0 3]
)

(instance rm123 of Rm
	(properties
		picture 204
		style 0
	)

	(method (init)
		(super init:)
		(self setRegions: 205) ; sewer
		(gEgo
			x:
				(cond
					((== gPrevRoomNum 120)
						(if (<= (gEgo x:) 50) 185 else 270)
					)
					((<= (gEgo x:) 200) 26)
					(else 158)
				)
			y: (if (== gPrevRoomNum 120) 87 else 185)
			view: (if (not global204) 0 else 6)
			init:
		)
		(HandsOn)
		((= [local0 0] (Prop new:))
			view: 99
			loop: 3
			cel: 2
			posn: 121 188
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		((= [local0 1] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 185 144
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors: 1
			init:
		)
		((= [local0 2] (Prop new:))
			view: 99
			loop: 3
			cel: 0
			posn: 225 113
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 4
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
		(gLightObj posn: 160 60 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 245 28 ignoreActors: 1 init: stopUpd:)
		(cockroach
			setLoop: 0
			ignoreActors:
			init:
			setMotion: MoveTo 133 44 cockroach
		)
	)

	(method (doit)
		(cond
			((< (gEgo y:) 100)
				(if (!= global156 -1)
					(= global156 -1)
					(if (not global140)
						(Print 123 0) ; "You seem to have made it through the pocket of deadly methane gas."
					else
						(Print 123 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
						(= global140 0)
						(gEgo view: (if (not global204) 0 else 6))
					)
				)
			)
			((== global156 -1)
				(= global156 65)
			)
		)
		(cond
			(global139 0)
			((<= (gEgo y:) 85)
				(gCurRoom newRoom: 120)
			)
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 125)
			)
		)
		(super doit:)
	)
)

(instance cockroach of Act
	(properties
		y 120
		x 133
		yStep 1
		view 260
		illegalBits 0
	)

	(method (cue)
		(self posn: 0 1000)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(if (Said '/bug>')
					(cond
						((> (cockroach x:) 200)
							(Print 123 2) ; "You don't see any cockroaches here."
							(event claimed: 1)
						)
						((Said 'look')
							(Print 123 3) ; "You look at the enormous cockroaches and think to yourself... "The balance of nature is intact, even in the sewer...only the large and the healthy survive.""
						)
						((Said 'get,apprehend')
							(Print 123 4) ; "The bugs are not something to play with."
						)
					)
				)
			)
		)
	)
)

