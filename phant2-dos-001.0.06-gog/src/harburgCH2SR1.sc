;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5012)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	harburgCH2SR1 0
)

(local
	[local0 8] = [24 9 10 32 1 11 12 13]
	[local8 8] = [234 235 236 237 239 240 241 242]
	local16
)

(instance harburgCH2SR1 of P2Room
	(properties
		picture 430
		east 5022
		west 5022
	)

	(method (init)
		(= local16 0)
		(ClearFlag 1001)
		(snowStorm init:)
		(harburgFidget init:)
		(super init: &rest)
		(harburgFeat init:)
		(snowStormFeat init:)
		(moneyMaker init:)
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
					34
					431
					34
					431
					116
					470
					116
					470
					315
					330
					315
					330
					116
					367
					116
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

	(method (doit)
		(switch gVerb
			(4 ; Do
				(harburgFeat delVerb: 4)
				(proc63002_7 7010)
				(SetFlag 232)
			)
			(24 ; folderI
				(harburgFeat delVerb: 24)
				(proc63002_7 7110)
				(SetFlag 234)
			)
			(9 ; parentPhotoI
				(harburgFeat delVerb: 9)
				(proc63002_7 7050)
				(SetFlag 235)
			)
			(10 ; xmasPhotoI
				(harburgFeat delVerb: 10)
				(harburgFeat addVerb: 32)
				(proc63002_7 7070)
				(SetFlag 236)
			)
			(32 ; laceI
				(if (not (IsFlag 237))
					(proc63002_7 7130)
					(SetFlag 237)
					(if (harburgFeat seesVerb: 10)
						(harburgFeat delVerb: 32)
					)
				else
					(proc63002_7 7140)
					(SetFlag 238)
					(harburgFeat delVerb: 32)
				)
			)
			(1 ; buttonI
				(harburgFeat delVerb: 1)
				(proc63002_7 7160)
				(SetFlag 239)
			)
			(11 ; sexyCardI
				(harburgFeat delVerb: 11)
				(proc63002_7 7180)
				(SetFlag 240)
			)
			(12 ; bondageCardI
				(harburgFeat delVerb: 12)
				(proc63002_7 7190)
				(SetFlag 241)
			)
			(13 ; harburgCardI
				(harburgFeat delVerb: 13)
				(proc63002_7 7200)
				(SetFlag 242)
			)
		)
		(doneCode doit:)
	)
)

(instance snowStormFeat of P2Feature
	(properties
		scene 7040
		doneFlag 233
	)

	(method (init)
		(= whoDoit doneCode)
		(super init: 250 126 268 150)
	)
)

(instance doneCode of Code
	(properties)

	(method (doit)
		(if
			(and
				(proc63002_4 233 234 235 236 237 239)
				(proc63002_4 232 238 240 241 242)
			)
			(SetFlag 222)
			(= global209 7250)
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
		x 301
		y 338
		view 14303
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

(instance moneyMaker of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 269)
			(return 0)
		else
			(super init: 550 33 626 164)
			(self delVerb: 4)
			(self addVerb: 32)
		)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(switch (++ local16)
				(1
					(self delVerb: 32)
					(self addVerb: 11)
				)
				(2
					(self delVerb: 11)
					(self addVerb: 12)
				)
				(3
					(proc63002_7 6922)
					(eggAMatic add: 5012 1 20)
					(SetFlag 269)
					(self dispose:)
				)
			)
		)
		(event claimed:)
	)
)

