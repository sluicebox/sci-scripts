;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm17 0
)

(instance rm17 of Rm
	(properties
		picture 17
		horizon 5
		north 13
		east 18
		south 21
		west 16
	)

	(method (init)
		(Load rsVIEW 250)
		(super init:)
		(aView1 loop: 0 cel: 0 setPri: 9 ignoreActors: addToPic:)
		(aView2 loop: 0 cel: 1 setPri: 7 ignoreActors: addToPic:)
		(aView3 loop: 0 cel: 2 setPri: 9 ignoreActors: addToPic:)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 260 187)
			)
			((== gPrevRoomNum 13)
				(gEgo posn: 194 76)
			)
			((== gPrevRoomNum 21)
				(gEgo posn: 260 187)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm17Script) ; rm200
	)
)

(instance rm17Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 13)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (or (Said 'look<in') (Said 'get,look/all'))
			(Print 17 0) ; "There is nothing inside of interest to you."
		)
		(if (Said 'open/door')
			(Print 17 1) ; "You can't. It's boarded up."
		)
		(if (Said 'bang')
			(Print 17 2) ; "They're closed."
		)
		(if (Said 'look>')
			(if (Said '/cup')
				(Print 17 3) ; "Peering through the dirty windows, you see an interior filled with memories of a bygone day, and junk."
			)
			(if (Said '/sign')
				(Print 17 4) ; "The Brown Derby"
				(Print 17 5 #font gSmallFont) ; "Closed for reblocking"
			)
			(if (Said '/door')
				(Print 17 6) ; "It's boarded up."
			)
			(if (Said '/building<back')
				(Print 17 7) ; "It's an empty parking lot."
			)
			(if (Said '[/cafe,building,building,airport]')
				(Print 17 8) ; "This place has been closed for years."
				(Print 17 9) ; "It's in desperate need of blocking."
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 128
		x 311
		view 250
	)
)

(instance aView2 of View
	(properties
		y 110
		x 18
		view 250
	)
)

(instance aView3 of View
	(properties
		y 72
		x 92
		view 250
	)
)

