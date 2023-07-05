;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm80 0
)

(local
	seenMessage
)

(instance rm80 of Rm
	(properties
		picture 80
		horizon 5
	)

	(method (init)
		(Load rsVIEW 728)
		(super init:)
		(gAddToPics add: aPlant1 aPlant2 doit:)
		(aWaterfall setCycle: Fwd cycleSpeed: 2 init:)
		(self setRegions: 700 setScript: rm80Script) ; rm700
		(NormalEgo)
		(if (== gPrevRoomNum 81)
			(gEgo posn: 114 124 loop: 1)
		else
			(gEgo posn: 265 184 loop: 3)
		)
		(gEgo init:)
	)
)

(instance rm80Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl:) $0004)
				(if (== seenMessage 0)
					(= seenMessage 1)
					(Print 80 0) ; "There's no need to return that way ever again, Larry."
				)
			)
			((& (gEgo onControl:) $0002)
				(gCurRoom newRoom: 81)
			)
			(else
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/fern,leaf,bush')
				(Print 80 1) ; "It's a member of the fern family and one of the first true trees. Its species is over 300-million years old. Since most of the jokes in this game come from the same era, it seems appropriate."
			)
			(if (Said '[/airport,island,hill]')
				(Print 80 2) ; "What lies before you?"
			)
		)
	)
)

(instance aPlant1 of PV
	(properties
		y 153
		x 175
		view 728
		loop 1
		priority 11
	)
)

(instance aPlant2 of PV
	(properties
		y 138
		x 154
		view 728
		loop 1
		cel 1
		priority 10
	)
)

(instance aWaterfall of Prop
	(properties
		y 76
		x 127
		view 728
		signal 16384
	)
)

