;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	rm122 0
)

(local
	[local0 4]
)

(instance rm122 of Rm
	(properties
		picture 200
		style 0
	)

	(method (init)
		(super init:)
		(Load rsVIEW 301)
		(self setRegions: 205) ; sewer
		(if (== gPrevRoomNum 121)
			(= global156 80)
		else
			(= global156 -1)
		)
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
				(cond
					((== gPrevRoomNum 121) 15)
					((<= (gEgo x:) 85) 190)
					(else 285)
				)
			y:
				(if (== gPrevRoomNum 121)
					(if (<= (gEgo y:) 115) 95 else 135)
				else
					185
				)
			init:
		)
		(HandsOn)
		((View new:)
			view: 301
			loop: 0
			cel: 0
			posn: 112 90
			setPri: 1
			init:
			addToPic:
		)
		((Prop new:)
			view: 260
			loop: 8
			cel: 1
			posn: 311 182
			setPri: 1
			ignoreActors: 1
			init:
			addToPic:
		)
		((= [local0 0] (Prop new:))
			view: 99
			loop: 2
			cel: 2
			posn: 210 189
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local0 1] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 65 124
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local0 2] (Prop new:))
			view: 99
			loop: 0
			cel: 2
			posn: 16 126
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local0 3] (Prop new:))
			view: 99
			loop: 2
			cel: 0
			posn: 163 153
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local0 0] stopUpd:)
			([local0 1] stopUpd:)
		)
		(if (< global110 30)
			([local0 2] stopUpd:)
			([local0 3] stopUpd:)
		)
		(gLightObj posn: 190 78 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 91 54 ignoreActors: 1 init: stopUpd:)
		(cockroach
			setLoop: 0
			ignoreActors:
			init:
			setMotion: MoveTo 165 50 cockroach
		)
	)

	(method (doit)
		(cond
			(global139 0)
			((< (gEgo y:) 170)
				(if (== global156 -1)
					(= global156 80)
				)
			)
			((== global156 -1) 0)
			(else
				(cond
					((>= global156 60) 0)
					((not global140)
						(Print 122 0) ; "You seem to have made it through the pocket of deadly methane gas."
					)
					(else
						(Print 122 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
					)
				)
				(gEgo view: (if (not global204) 0 else 6))
				(= global156 -1)
				(= global140 0)
			)
		)
		(cond
			((>= (gEgo y:) 190)
				(gCurRoom newRoom: 124)
			)
			((<= (gEgo x:) 3)
				(cond
					((> global156 60) 0)
					((not global140)
						(Print 122 0) ; "You seem to have made it through the pocket of deadly methane gas."
					)
					(else
						(Print 122 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
					)
				)
				(= global140 0)
				(= global156 -1)
				(gCurRoom newRoom: 121)
			)
		)
		(super doit:)
	)
)

(instance cockroach of Act
	(properties
		y 92
		x 165
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
					(Print 122 2) ; "You don't see any bugs here."
					(event claimed: 1)
				)
				((Said 'look')
					(Print 122 3) ; "You look at the enormous cockroaches and think to yourself... "The balance of nature is intact, even in the sewer...only the large and the healthy survive.""
				)
				((Said 'get')
					(Print 122 4) ; "The bugs are not something to play with."
				)
			)
		)
	)
)

