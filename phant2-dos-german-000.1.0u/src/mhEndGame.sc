;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1006)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Timer)
(use P2Fidget)

(public
	mhEndGame 0
)

(instance mhEndGame of P2Room
	(properties
		picture 980
		style 0
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(evilDoctor init:)
		(docFeat init:)
		(layingCurtis init:)
		(table init:)
		(gP2SongPlyr fadeIn: 1960)
		(if (not (surgeryTimer initialized:))
			(surgeryTimer init: 3 15)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance evilDoctor of P2Fidget
	(properties
		x 181
		y 338
		view 19801
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance layingCurtis of P2Fidget
	(properties
		x 287
		y 340
		view 19800
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: 20)
	)
)

(instance table of P2Feature
	(properties
		nextRoom 1016
	)

	(method (init)
		(super init: (proc63002_10 404 188 448 184 466 199 416 204))
	)
)

(instance docFeat of P2Feature
	(properties
		scene 690
		doneFlag 1507
	)

	(method (init)
		(super init: 184 81 262 290)
	)
)

