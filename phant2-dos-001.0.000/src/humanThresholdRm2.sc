;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9401)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use Cycle)
(use Jump)

(public
	humanThresholdRm2 0
)

(instance humanThresholdRm2 of P2Room
	(properties
		picture 941
	)

	(method (init)
		(proc63002_7 6680)
		(super init: &rest)
		(curtis init: setPri: 300)
		(joc init:)
		(jocFeat init: 72 70 150 334)
		(threshold init: setCycle: Fwd)
		(thresholdF init: 390 114 606 212)
		(InvPlane recalc: 0)
		(gP2SongPlyr start: 5007)
	)
)

(instance threshold of Prop
	(properties
		x 408
		y 140
		view 19406
	)
)

(instance thresholdF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(event claimed: 1)
			(= global211 1)
			(= global212 0)
			(proc63002_7 6690 5 10600)
			(= gQuit 3)
		)
	)
)

(instance curtis of P2Fidget
	(properties
		x 268
		y 31
		view 19400
	)
)

(instance joc of P2Fidget
	(properties
		x 75
		y 338
		view 19401
	)
)

(instance jocFeat of P2Feature
	(properties
		priority 100
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(event claimed: 1)
			(= global211 1)
			(= global212 0)
			(proc63002_7 9490 5 10600)
			(= gQuit 3)
		)
	)
)

