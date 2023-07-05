;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm25 0
)

(local
	aDoor
	aPole
	aWave
)

(instance rm25 of Rm
	(properties
		picture 25
		horizon 1
		east 26
		west 24
	)

	(method (init)
		(Load rsVIEW 231)
		(Load rsVIEW 230)
		(super init:)
		((View new:)
			view: 231
			loop: 1
			cel: 1
			posn: 266 84
			setPri: 12
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 231
			loop: 1
			cel: 0
			posn: 248 107
			setPri: 12
			ignoreActors:
			addToPic:
		)
		((= aWave (Prop new:))
			view: 231
			setLoop: 2
			setCel: 0
			setPri: 0
			posn: 319 96
			setCycle: Fwd
			cycleSpeed: 3
			isExtra: 1
			init:
		)
		((= aPole (Prop new:))
			view: 230
			setPri: 12
			posn: 176 139
			setCycle: Fwd
			cycleSpeed: 1
			isExtra: 1
			init:
		)
		(NormalEgo)
		((= aDoor (AutoDoor new:))
			view: 231
			setLoop: 0
			posn: 185 85
			setPri: 4
			entranceTo: 125
			msgLook:
				{A small, discreetly lettered sign on the door says: "No hair loss too great."}
			msgFunny: {"Come in. It's open!"}
			msgCloser: {Just walk closer.}
			init:
		)
		(cond
			((== gPrevRoomNum 24)
				(gEgo posn: 2 169)
			)
			((== gPrevRoomNum 26)
				(gEgo posn: 318 135)
			)
			((== gPrevRoomNum 125)
				(gEgo posn: 186 125)
			)
			(else
				(gEgo posn: 245 121)
			)
		)
		(gEgo init:)
		(self setRegions: 200 setScript: rm25Script) ; rm200
	)
)

(instance rm25Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0008)
			(gCurRoom newRoom: 21)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/lagoon,beach,water,lagoon')
				(Print 25 0) ; "The ocean waves, and the dock "piers" back at you."
			)
			(if (Said '[/building,(building<man),building,airport]')
				(Print 25 1) ; "Gee, isn't Hairy Reams that famous Hollywood barber?"
				(Print 25 2) ; "Maybe he could help you with your hair problem."
				(Print 25 3) ; "What do you mean, "what problem?!""
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aWave cel: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 6 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

