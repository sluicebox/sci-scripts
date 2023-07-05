;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5023)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use Polygon)
(use System)

(public
	harburgCH3SR2 0
)

(local
	[local0 8] = [32 24 9 10 28 1 11 12]
	[local8 8] = [330 331 332 333 334 336 337 338]
)

(instance harburgCH3SR2 of P2Room
	(properties
		picture 431
		east 5013
		west 5013
	)

	(method (init)
		(ClearFlag 1001)
		(harburgFeat init:)
		(doorFeat init:)
		(snowStorm init:)
		(chair init:)
		(curtisFidget init:)
		(harburgFidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance harburgFeat of P2Feature
	(properties
		priority 100
	)

	(method (init &tmp temp0)
		(super
			init:
				(proc63002_10
					132
					94
					184
					94
					184
					160
					214
					160
					214
					280
					106
					280
					106
					160
					132
					160
				)
		)
		(= whoDoit harburgCode)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (not (IsFlag [local8 temp0]))
				(super addVerb: [local0 temp0])
			)
		)
		(if (IsFlag 329)
			(super delVerb: 4)
		)
		(if (not (IsFlag 335))
			(super addVerb: 28)
		)
	)
)

(instance harburgCode of Code
	(properties)

	(method (doit &tmp temp0)
		(switch gVerb
			(4 ; Do
				(harburgFeat delVerb: 4)
				(= temp0 7270)
				(SetFlag 329)
			)
			(32 ; laceI
				(harburgFeat delVerb: 32)
				(= temp0 7470)
				(SetFlag 330)
			)
			(24 ; folderI
				(harburgFeat delVerb: 24)
				(= temp0 7420)
				(SetFlag 331)
			)
			(9 ; parentPhotoI
				(harburgFeat delVerb: 9)
				(= temp0 7320)
				(SetFlag 332)
			)
			(10 ; xmasPhotoI
				(harburgFeat delVerb: 10)
				(= temp0 7340)
				(SetFlag 333)
			)
			(28 ; dadLetterI
				(if (not (IsFlag 334))
					(= temp0 7440)
					(SetFlag 334)
				else
					(harburgFeat delVerb: 28)
					(= temp0 7450)
					(SetFlag 335)
				)
			)
			(1 ; buttonI
				(harburgFeat delVerb: 1)
				(= temp0 7480)
				(SetFlag 336)
			)
			(11 ; sexyCardI
				(harburgFeat delVerb: 11)
				(= temp0 7360)
				(SetFlag 337)
			)
			(12 ; bondageCardI
				(harburgFeat delVerb: 12)
				(= temp0 7370)
				(SetFlag 338)
			)
		)
		(doneCode doit: temp0)
	)
)

(instance doneCode of Code
	(properties)

	(method (doit param1)
		(if (proc63002_4 330 332 335 336 338 329 331 333 337)
			(proc63002_7 param1)
			(SetFlag 339)
			(= global209 7510)
			(gCurRoom newRoom: 900) ; mapRoom
		else
			(= global209 param1)
			(gCurRoom newRoom: 5013) ; harburgCH3SR1
		)
	)
)

(instance doorFeat of ExitFeature
	(properties
		scene 7510
		doneFlag 339
		nextRoom 900
	)

	(method (init)
		(if (proc63002_4 330 332 335 336 338)
			(super init: (doorPoly init:))
		)
	)
)

(instance doorPoly of Polygon
	(properties)

	(method (init)
		(super init: 441 27 499 12 485 199 434 190)
		(return self)
	)
)

(instance snowStorm of View
	(properties
		x 471
		y 268
		view 431
	)
)

(instance chair of View
	(properties
		x 119
		y 285
		view 14313
		loop 1
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 50)
	)
)

(instance harburgFidget of P2Fidget
	(properties
		x 118
		y 285
		view 14313
		cycleSpeed 8
		initStart 3
		initFinish 5
		cycleStart 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance curtisFidget of P2Fidget
	(properties
		x 230
		y 306
		view 14310
		cycleSpeed 8
		initStart 2
		initFinish 5
		cycleStart 1
		cycleFinish 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 60)
	)
)

