;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm18 0
)

(local
	aDoor
)

(instance rm18 of Rm
	(properties
		picture 18
		horizon 113
		north 14
		east 22
		south 22
		west 17
	)

	(method (init)
		(Load rsVIEW 227)
		(Load rsVIEW 240)
		(super init:)
		((View new:)
			view: 240
			loop: 0
			cel: 0
			posn: 60 32
			setPri: 1
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 240
			loop: 1
			cel: 0
			posn: 196 32
			setPri: 1
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 227
			loop: 1
			cel: 2
			posn: 170 83
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 227
			loop: 1
			cel: 1
			posn: 233 125
			setPri: 11
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 227
			loop: 1
			cel: 0
			posn: 98 138
			setPri: 11
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 227
			loop: 1
			cel: 3
			posn: 20 137
			setPri: 11
			ignoreActors:
			addToPic:
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 253 120)
			)
			((== gPrevRoomNum 14)
				(gEgo posn: 253 120)
			)
			((== gPrevRoomNum 118)
				(gEgo posn: 172 147)
			)
		)
		(NormalEgo)
		((= aDoor (AutoDoor new:))
			view: 227
			setLoop: 0
			posn: 172 151
			setPri: 11
			entranceTo: 118
			locked: 0
			msgLook: {Through this door, you see a store.}
			init:
		)
		(gEgo init:)
		(self setRegions: 200 setScript: rm18Script) ; rm200
	)
)

(instance rm18Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/sign,cup')
				(Print 18 0) ; "Even in Hollywood, they're having trouble moving New Age gear!"
			)
			(if (Said '[/building,building,airport]')
				(Print 18 1) ; "Swabs Drug Store has everything a guy like you might need."
			)
		)
	)
)

