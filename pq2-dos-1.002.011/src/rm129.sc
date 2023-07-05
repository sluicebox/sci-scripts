;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 129)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm129 0
)

(local
	local0
	[local1 2]
)

(instance rm129 of Rm
	(properties
		picture 203
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
				(cond
					((== gPrevRoomNum 127)
						(if (<= (gEgo x:) 220) 55 else 133)
					)
					((<= (gEgo x:) 120) 163)
					(else 292)
				)
			y: (if (== gPrevRoomNum 127) 87 else 180)
			init:
		)
		(HandsOn)
		(if (== gPrevRoomNum 132)
			(= global156 66)
		)
		((= local0 (Act new:))
			view: 92
			loop: 5
			cel: 0
			posn: 122 153
			setPri: 0
			ignoreActors: 1
			init:
			addToPic:
		)
		((= [local1 0] (Prop new:))
			view: 99
			loop: 2
			cel: 2
			posn: 96 113
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		((= [local1 1] (Prop new:))
			view: 99
			loop: 2
			cel: 1
			posn: 175 177
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors: 1
			init:
		)
		(if (< global110 60)
			([local1 0] stopUpd:)
		)
		(if (< global110 30)
			([local1 1] stopUpd:)
		)
		(gLightObj posn: 75 29 ignoreActors: 1 init: stopUpd:)
		(global115 posn: 159 59 ignoreActors: 1 init: stopUpd:)
		(cockroach
			view: 260
			setLoop: 0
			ignoreActors:
			init:
			setMotion: MoveTo 135 34 cockroach
		)
	)

	(method (doit)
		(cond
			(global139 0)
			((and (not global139) (gEgo inRect: 118 144 133 150))
				(= global139 1)
				(gEgo setScript: holeScript)
			)
			((<= (gEgo y:) 85)
				(gCurRoom newRoom: 127)
			)
			((>= (gEgo y:) 190)
				(cond
					((>= global156 60) 0)
					((not global140)
						(Print 129 0) ; "You seem to have made it through the pocket of deadly methane gas."
					)
					(else
						(Print 129 1) ; "You seem to have passed through the deadly gas. You can take off your mask."
					)
				)
				(= global140 0)
				(= global156 -1)
				(gCurRoom newRoom: 132)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look<(in,down)[/hole]')
						(Print 129 2) ; "It's too dark in the hole to see anything."
					)
					((Said 'look/hole')
						(Print 129 3) ; "The maintenance hole is for sewer personnel only."
					)
					((Said 'move,press,cover,drop/cover,manhole,lid')
						(Print 129 4) ; "The cover is too heavy to push."
					)
					((Said 'go,enter,climb/hole')
						(Print 129 5) ; "Leave the hole alone...you can't climb down."
					)
				)
			)
		)
	)
)

(instance cockroach of Act
	(properties
		y 90
		x 135
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
				((> (cockroach x:) 200)
					(Print 129 6) ; "You don't see any bugs here."
					(event claimed: 1)
				)
				((Said 'look')
					(Print 129 7) ; "You look at the enormous cockroaches and think to yourself... "The balance of nature is intact, even in the sewer...only the large and the healthy survive.""
				)
				((Said 'get')
					(Print 129 8) ; "The bugs are not something to play with."
				)
			)
		)
	)
)

(instance holeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setLoop: (gEgo loop:)
					setPri: 0
					yStep: 8
					posn: 130 148
					setMotion: MoveTo 130 195 self
				)
			)
			(1
				(EgoDead
					{What a wimpy way to die....falling in a hole! Next time, be more careful.}
					298
					2
					0
				)
			)
		)
	)
)

