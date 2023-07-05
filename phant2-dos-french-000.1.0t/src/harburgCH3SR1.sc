;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5013)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	harburgCH3SR1 0
)

(local
	[local0 8] = [32 24 9 10 28 1 11 12]
	[local8 8] = [330 331 332 333 334 336 337 338]
)

(instance harburgCH3SR1 of P2Room
	(properties
		picture 430
		east 5023
		west 5023
	)

	(method (init)
		(ClearFlag 1001)
		(harburgFeat init:)
		(harburgFidget init:)
		(snowStorm init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance harburgFeat of P2Feature
	(properties)

	(method (init &tmp temp0)
		(super
			init:
				(proc63002_10
					367
					29
					436
					29
					436
					110
					472
					110
					472
					287
					344
					287
					344
					110
					367
					110
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

	(method (doit)
		(switch gVerb
			(4 ; Do
				(harburgFeat delVerb: 4)
				(proc63002_7 7270)
				(SetFlag 329)
			)
			(32 ; laceI
				(harburgFeat delVerb: 32)
				(proc63002_7 7470)
				(SetFlag 330)
			)
			(24 ; folderI
				(harburgFeat delVerb: 24)
				(proc63002_7 7420)
				(SetFlag 331)
			)
			(9 ; parentPhotoI
				(harburgFeat delVerb: 9)
				(proc63002_7 7320)
				(SetFlag 332)
			)
			(10 ; xmasPhotoI
				(harburgFeat delVerb: 10)
				(proc63002_7 7340)
				(SetFlag 333)
			)
			(28 ; dadLetterI
				(if (not (IsFlag 334))
					(proc63002_7 7440)
					(SetFlag 334)
				else
					(harburgFeat delVerb: 28)
					(proc63002_7 7450)
					(SetFlag 335)
				)
			)
			(1 ; buttonI
				(harburgFeat delVerb: 1)
				(proc63002_7 7480)
				(SetFlag 336)
			)
			(11 ; sexyCardI
				(harburgFeat delVerb: 11)
				(proc63002_7 7360)
				(SetFlag 337)
			)
			(12 ; bondageCardI
				(harburgFeat delVerb: 12)
				(proc63002_7 7370)
				(SetFlag 338)
			)
		)
		(doneCode doit:)
	)
)

(instance doneCode of Code
	(properties)

	(method (doit)
		(if
			(and
				(proc63002_4 330 332 335 336 338)
				(proc63002_4 329 331 333 337)
			)
			(SetFlag 339)
			(= global209 7510)
			(gCurRoom newRoom: 900) ; mapRoom
		)
	)
)

(instance snowStorm of View
	(properties
		x 244
		y 158
		view 430
	)
)

(instance harburgFidget of P2Fidget
	(properties
		x 321
		y 339
		view 14301
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

