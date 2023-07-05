;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm19 0
)

(local
	[unused 2]
)

(instance rm19 of Rm
	(properties
		picture 19
		horizon 106
		north 15
		south 23
		west 23
	)

	(method (init)
		(Load rsVIEW 254)
		(super init:)
		(gAddToPics add: aView1 doit:)
		(aChairlift setLoop: 0 setCycle: Fwd cycleSpeed: 2 isExtra: 1 init:)
		(aRollerCoaster
			setLoop: 3
			setCel: 255
			init:
			hide:
			setScript: coasterScript
		)
		(aFlags setLoop: 4 setCycle: Fwd cycleSpeed: 4 isExtra: 1 init:)
		(aMonorail
			setLoop: 1
			setPri: 2
			setStep: 4 1
			ignoreHorizon:
			illegalBits: 0
			init:
			setScript: monoScript
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 318 160)
			)
			((== gPrevRoomNum 15)
				(gEgo posn: 306 108)
			)
			((== gPrevRoomNum 20)
				(gEgo posn: 318 160)
			)
			((== gPrevRoomNum 23)
				(gEgo posn: 5 187)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm19Script) ; rm200
	)
)

(instance rm19Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== 2 (gEgo edgeHit:))
			(if (< (gEgo y:) 159)
				(gCurRoom newRoom: 15)
			else
				(gCurRoom newRoom: 20)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<over,below/brick,fence')
			(Print 19 0) ; "You don't have time for that."
		)
		(if (Said '/brick,fence')
			(Print 19 1) ; "That wall is designed to keep undesirables like you out!"
		)
		(if (Said 'look[/airport]')
			(Print 19 2) ; "Hey! Is that Disneyland?!"
			(Print 19 3) ; "Nah! Not in an Al Lowe game!!"
		)
	)
)

(instance monoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 21))
			)
			(1
				(aMonorail posn: -59 52 setMotion: MoveTo 380 52 self)
			)
			(2
				(aMonorail posn: -945 52)
				(self changeState: 0)
			)
		)
	)
)

(instance coasterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(aRollerCoaster cel: 0 show: setCycle: End self)
			)
			(2
				(aRollerCoaster hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 31
		x 144
		view 254
		loop 2
	)
)

(instance aChairlift of Prop
	(properties
		y 15
		x 60
		view 254
	)
)

(instance aRollerCoaster of Prop
	(properties
		y 13
		x 149
		view 254
	)
)

(instance aFlags of Prop
	(properties
		y 14
		x 239
		view 254
	)
)

(instance aMonorail of Act
	(properties
		y 52
		x -940
		view 254
		signal 16384
	)
)

