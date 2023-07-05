;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6454)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	blBackCH4SR5 0
)

(instance blBackCH4SR5 of P2Room
	(properties
		picture 840
		south 6444
		east 6444
		west 6444
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 6941 70)
		(ropeFeat init:)
		(curtainFeat init:)
		(fidget init:)
		(maskView init:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance ropeFeat of P2Feature
	(properties
		scene 8205
		doneFlag 552
	)

	(method (init)
		(super init: (proc63002_10 390 151 577 65 574 284 389 263))
		(= whoDoit ropeCode)
	)
)

(instance ropeCode of Code
	(properties)

	(method (doit)
		(maskView init:)
	)
)

(instance curtainFeat of P2Feature
	(properties)

	(method (init)
		(super init: 253 86 355 275)
		(= whoDoit curtainCode)
	)
)

(instance curtainCode of Code
	(properties)

	(method (doit)
		(gP2SongPlyr fadeOut: 0)
		(switch global207
			(0
				(= global209 8215)
				(SetFlag 553)
			)
			(1
				(= global209 8216)
				(SetFlag 554)
			)
		)
		(gCurRoom newRoom: 800) ; endChapter
	)
)

(instance maskView of View
	(properties
		x 502
		y 137
		view 840
	)

	(method (init)
		(if (IsFlag 552)
			(super init: &rest)
			(self setPri: 10)
		else
			(return 0)
		)
	)
)

(instance fidget of P2Fidget
	(properties
		x 100
		y 339
		view 18400
		wiggler 1
		delay 1
		zone1aLeft 6
		zone1aRight 15
		zone1bLeft 16
		zone1bRight 25
		zone2aLeft 26
		zone2aRight 28
		zone2bLeft 29
		zone2bRight 32
		origin 200
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

