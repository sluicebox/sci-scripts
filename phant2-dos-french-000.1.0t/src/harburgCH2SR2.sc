;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5022)
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
	harburgCH2SR2 0
)

(local
	[local0 8] = [24 9 10 32 1 11 12 13]
	[local8 8] = [234 235 236 237 239 240 241 242]
)

(instance harburgCH2SR2 of P2Room
	(properties
		picture 431
		east 5012
		west 5012
	)

	(method (init)
		(ClearFlag 1001)
		(snowStorm init:)
		(super init: &rest)
		(harburgFeat init:)
		(doorFeat init:)
		(chair init:)
		(harburgFidget init:)
		(curtisFidget init:)
		(snowStormFeat init:)
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
					117
					103
					176
					103
					176
					170
					192
					170
					192
					273
					102
					273
					102
					170
					117
					170
				)
		)
		(= whoDoit harburgCode)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(if (not (IsFlag [local8 temp0]))
				(super addVerb: [local0 temp0])
			)
		)
		(if (IsFlag 232)
			(super delVerb: 4)
		)
		(if (and (IsFlag 236) (not (IsFlag 238)))
			(super addVerb: 32)
		)
	)
)

(instance harburgCode of Code
	(properties)

	(method (doit &tmp temp0)
		(switch gVerb
			(4 ; Do
				(harburgFeat delVerb: 4)
				(= temp0 7010)
				(SetFlag 232)
			)
			(24 ; folderI
				(harburgFeat delVerb: 24)
				(= temp0 7110)
				(SetFlag 234)
			)
			(9 ; parentPhotoI
				(harburgFeat delVerb: 9)
				(= temp0 7050)
				(SetFlag 235)
			)
			(10 ; xmasPhotoI
				(harburgFeat delVerb: 10)
				(harburgFeat addVerb: 32)
				(= temp0 7070)
				(SetFlag 236)
			)
			(32 ; laceI
				(if (not (IsFlag 237))
					(= temp0 7130)
					(SetFlag 237)
					(if (harburgFeat seesVerb: 10)
						(harburgFeat delVerb: 32)
					)
				else
					(= temp0 7140)
					(SetFlag 238)
					(harburgFeat delVerb: 32)
				)
			)
			(1 ; buttonI
				(harburgFeat delVerb: 1)
				(= temp0 7160)
				(SetFlag 239)
			)
			(11 ; sexyCardI
				(harburgFeat delVerb: 11)
				(= temp0 7180)
				(SetFlag 240)
			)
			(12 ; bondageCardI
				(harburgFeat delVerb: 12)
				(= temp0 7190)
				(SetFlag 241)
			)
			(13 ; harburgCardI
				(harburgFeat delVerb: 13)
				(= temp0 7200)
				(SetFlag 242)
			)
		)
		(doneCode doit: temp0)
	)
)

(instance snowStormFeat of P2Feature
	(properties
		doneFlag 233
	)

	(method (init)
		(super init: 481 215 514 261)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(doneCode doit: 7040)
		)
		(event claimed:)
	)
)

(instance doneCode of Code
	(properties)

	(method (doit param1)
		(if (proc63002_4 233 234 235 236 237 239 232 238 240 241 242)
			(proc63002_7 param1)
			(SetFlag 222)
			(= global209 7250)
			(gCurRoom newRoom: 900) ; mapRoom
		else
			(= global209 param1)
			(gCurRoom newRoom: 5012) ; harburgCH2SR1
		)
	)
)

(instance doorFeat of ExitFeature
	(properties
		scene 7250
		doneFlag 222
		nextRoom 900
	)

	(method (init)
		(if (proc63002_4 233 234 235 236 237 239)
			(super init: (doorPoly init:))
		)
	)
)

(instance snowStorm of View
	(properties
		x 471
		y 268
		view 431
	)
)

(instance doorPoly of Polygon
	(properties)

	(method (init)
		(super init: 441 27 499 12 485 199 434 190)
		(return self)
	)
)

(instance chair of View
	(properties
		x 119
		y 285
		view 14311
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
		x 109
		y 286
		view 14311
		cycleSpeed 8
		initStart 3
		initFinish 5
		cycleStart 10
		cycleFinish 15
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

