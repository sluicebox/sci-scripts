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

(local
	aSign
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
		((View new:)
			view: 243
			loop: 0
			cel: 1
			posn: 96 52
			setPri: 2
			ignoreActors:
			addToPic:
		)
		((View new:) view: 243 loop: 0 cel: 0 posn: 17 57 setPri: 2 addToPic:)
		((View new:) view: 243 loop: 0 cel: 0 posn: 175 57 setPri: 2 addToPic:)
		((View new:) view: 243 loop: 1 cel: 1 posn: 99 73 setPri: 12 addToPic:)
		((View new:) view: 243 loop: 1 cel: 2 posn: 166 81 setPri: 12 addToPic:)
		((View new:) view: 243 loop: 1 cel: 0 posn: 105 134 setPri: 9 addToPic:)
		((= aSign (Prop new:))
			view: 243
			loop: 2
			cel: 0
			posn: 34 104
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

