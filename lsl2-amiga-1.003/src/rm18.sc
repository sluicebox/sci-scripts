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
		(aView1 loop: 0 cel: 0 setPri: 1 ignoreActors: addToPic:)
		(aView2 loop: 1 cel: 0 setPri: 1 ignoreActors: addToPic:)
		(aView3 loop: 1 cel: 2 setPri: 4 ignoreActors: addToPic:)
		(aView4 loop: 1 cel: 1 setPri: 11 ignoreActors: addToPic:)
		(aView5 loop: 1 cel: 0 setPri: 11 ignoreActors: addToPic:)
		(aView6 loop: 1 cel: 3 setPri: 11 ignoreActors: addToPic:)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 253 119)
			)
			((== gPrevRoomNum 14)
				(gEgo posn: 253 119)
			)
			((== gPrevRoomNum 118)
				(gEgo posn: 172 146)
			)
		)
		(NormalEgo)
		(aDoor
			setLoop: 0
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

(instance aView1 of View
	(properties
		y 31
		x 60
		view 240
	)
)

(instance aView2 of View
	(properties
		y 31
		x 196
		view 240
	)
)

(instance aView3 of View
	(properties
		y 82
		x 170
		view 227
	)
)

(instance aView4 of View
	(properties
		y 124
		x 233
		view 227
	)
)

(instance aView5 of View
	(properties
		y 137
		x 98
		view 227
	)
)

(instance aView6 of View
	(properties
		y 136
		x 20
		view 227
	)
)

(instance aDoor of AutoDoor
	(properties
		y 150
		x 172
		view 227
		msgLook {Through this door, you see a store.}
		msgLookLock 1116
		msgLocked 1136
		msgExcept {aView2}
		msgFunny 1180
		msgCloser 1200
	)
)

