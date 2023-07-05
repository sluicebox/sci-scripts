;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5014)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use Str)
(use Rectangle)
(use PolyEdit)
(use TextField)
(use System)

(public
	harburgCH4SR1 0
)

(local
	[local0 2] = [400 129]
	local2
)

(instance harburgCH4SR1 of P2Room
	(properties
		picture 961
	)

	(method (init)
		(ClearFlag 1001)
		(= local2 0)
		(super init: &rest)
		(diploma init:)
		(harburgFeat init:)
		(snowStorm init:)
		(windowCurtisBackFidget init:)
		(windowHarburgFidget init:)
		(gGame handsOn: 1)
	)
)

(instance harburgFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit harburgCode)
		(super init: 228 1 314 316)
	)
)

(instance harburgCode of Code
	(properties)

	(method (doit)
		(cond
			((not (IsFlag 533))
				(SetFlag 533)
				(proc63002_7 7530)
				(windowCurtisBackFidget dispose:)
				(windowCurtisFidget init:)
				(snowStormFeat init:)
			)
			((and (IsFlag 533) (not (IsFlag 534)))
				(SetFlag 534)
				(proc63002_7 7560)
				((harburgFeat target:) dispose:)
				(harburgFeat target: (Rectangle new: 336 17 415 283))
				(windowCurtisFidget dispose:)
				(windowHarburgFidget dispose:)
				(deskCurtisFidget init:)
				(deskHarburgFidget init:)
			)
			((and (proc63002_4 533 534) (not (IsFlag 535)))
				(= global211 1)
				(= global212 0)
				(SetFlag 535)
				(if local2
					(= global209 7572)
				else
					(= global209 7570)
				)
				(gCurRoom newRoom: 900) ; mapRoom
			)
		)
	)
)

(instance snowStormFeat of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 537)
			(return 0)
		else
			(= whoDoit snowCode)
			(super init: 201 153 216 173)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (IsFlag 537)
			(self dispose:)
		)
	)
)

(instance snowCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 536))
			(proc63002_7 7600)
			(SetFlag 536)
		else
			(proc63002_7 7610)
			(SetFlag 537)
		)
	)
)

(instance snowStorm of View
	(properties
		x 194
		y 178
		view 961
	)
)

(instance windowHarburgFidget of P2Fidget
	(properties
		x 225
		y 327
		view 19612
		cycleSpeed 7
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

(instance windowCurtisFidget of P2Fidget
	(properties
		x 339
		y 247
		view 19611
		cycleSpeed 8
		initStart 2
		initFinish 5
		cycleStart 1
		cycleFinish 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance windowCurtisBackFidget of P2Fidget
	(properties
		x 339
		y 254
		view 19615
		cycleSpeed 8
		initStart 2
		initFinish 5
		cycleStart 1
		cycleFinish 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance deskHarburgFidget of P2Fidget
	(properties
		x 331
		y 338
		view 19614
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

(instance deskCurtisFidget of P2Fidget
	(properties
		x 226
		y 282
		view 19613
		cycleSpeed 8
		initStart 2
		initFinish 5
		cycleStart 1
		cycleFinish 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance diploma of P2Feature
	(properties)

	(method (init)
		(super init: 32 12 101 64)
		(self delVerb: 4)
		(self addVerb: 5)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(= temp0 (Str format: {}))
			(proc64986_1 temp0 15 {Who ARE You?})
			(if (not (temp0 weigh: {batman}))
				(gP2SoundFX play: 4833)
				(eggAMatic add: 5014 1 40)
				(self delVerb: 5)
				(= local2 1)
			else
				(gP2SoundFX play: 4807)
			)
			(temp0 dispose:)
		)
		(event claimed:)
	)
)

