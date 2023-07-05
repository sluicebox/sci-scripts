;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm14 0
)

(instance rm14 of Rm
	(properties
		picture 14
		horizon 50
		south 18
		west 13
	)

	(method (init)
		(Load rsVIEW 243)
		(super init:)
		(aView1 loop: 0 cel: 1 setPri: 2 ignoreActors: addToPic:)
		(aView2 loop: 0 cel: 0 setPri: 2 addToPic:)
		(aView3 loop: 0 cel: 0 setPri: 2 addToPic:)
		(aView4 loop: 1 cel: 1 setPri: 12 addToPic:)
		(aView5 loop: 1 cel: 2 setPri: 12 addToPic:)
		(aView6 loop: 1 cel: 0 setPri: 9 addToPic:)
		(aSign
			loop: 2
			cel: 0
			setPri: 12
			setCycle: Fwd
			cycleSpeed: 10
			isExtra: 1
			init:
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 312 187)
			)
			((== gPrevRoomNum 18)
				(gEgo posn: 312 187)
			)
			((== gPrevRoomNum 114)
				(gEgo posn: 36 152)
			)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 200 setScript: rm14Script) ; rm200
	)
)

(instance rm14Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 114)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/carpet')
				(Print 14 0) ; "The sidewalk here is littered with junk food wrappers and old paper cups."
			)
			(if (Said '/cup,sign')
				(Print 14 1) ; "From the looks of this window, they sell things inside."
			)
			(if (Said '[/building,convenience,building,airport]')
				(Print 14 2) ; "Only in Southern California would you find a convenience store without a door. "Gosh," you think, "I wonder if they're open?""
			)
		)
		(if (Said 'open/door')
			(Print 14 3) ; "What door?"
		)
	)
)

(instance aView1 of View
	(properties
		y 52
		x 96
		view 243
	)
)

(instance aView2 of View
	(properties
		y 57
		x 17
		view 243
	)
)

(instance aView3 of View
	(properties
		y 57
		x 175
		view 243
	)
)

(instance aView4 of View
	(properties
		y 73
		x 99
		view 243
	)
)

(instance aView5 of View
	(properties
		y 81
		x 166
		view 243
	)
)

(instance aView6 of View
	(properties
		y 134
		x 105
		view 243
	)
)

(instance aSign of Prop
	(properties
		y 104
		x 34
		view 243
	)
)

