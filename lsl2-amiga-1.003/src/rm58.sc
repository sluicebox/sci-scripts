;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use airplaneScript)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm58 0
)

(local
	work
	seenMessage
)

(instance blockWest of Blk
	(properties
		top 129
		left -20
		bottom 136
		right -10
	)
)

(instance rm58 of Rm
	(properties
		picture 58
		horizon 1
	)

	(method (init)
		(Load rsVIEW 511)
		(Load rsVIEW 600)
		(super init:)
		(gAddToPics add: aStewardess doit:)
		(aPlane startY: 7 endY: 0 delayMin: 2 delayMax: 3 init:)
		(self setRegions: 500 setScript: rm58Script) ; rm500
		(blockWest init:)
		(NormalEgo 0)
		(gEgo posn: 10 132 observeBlocks: blockWest init:)
	)
)

(instance rm58Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 61)
		)
		(if (& (gEgo onControl:) $0004)
			(if (not seenMessage)
				(= seenMessage 1)
				(Print 58 0) ; "You have no reason to return there. Hurry, Larry; you don't want to miss your plane!"
			)
		else
			(= seenMessage 0)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (Said 'look>') (Said '[/airport,airline]'))
			(Print 58 1) ; "This jetway stretches between the airport waiting room and your flight to freedom."
			(Print 58 2 #at -1 130) ; "(But, where are you going?)"
		)
	)
)

(instance aStewardess of PV
	(properties
		y 132
		x 311
		view 600
		loop 1
		cel 4
	)
)

(instance aPlane of Airplane
	(properties)
)

