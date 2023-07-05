;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4624)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)

(public
	paulsOfficeRoomCH4SR2 0
)

(instance paulsOfficeRoomCH4SR2 of P2Room
	(properties
		picture 350
		east 4634
		west 4614
	)

	(method (init)
		(gP2SongPlyr fadeIn: 3041)
		(curtis init:)
		(super init: &rest)
		(deskFeat
			init: (proc63002_10 56 333 81 286 118 274 240 247 375 268 635 333)
		)
		(doorFeat init: (proc63002_10 225 27 298 50 298 253 225 253))
		(ssATP init: isHot: 0)
		(gGame handsOn: 1)
	)
)

(instance ssATP of P2View
	(properties
		x 554
		y 301
		view 13502
	)
)

(instance deskFeat of P2Feature
	(properties
		nextRoom 4644
	)
)

(instance doorFeat of ExitFeature
	(properties
		nextRoom 3014
		exitScene 6847
	)
)

(instance curtis of P2Fidget
	(properties
		x 295
		y 339
		view 13500
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 4
		zone1aRight 8
		zone1bLeft 9
		zone1bRight 14
		zone2aLeft 15
		zone2aRight 20
		zone2bLeft 21
		zone2bRight 27
	)
)

