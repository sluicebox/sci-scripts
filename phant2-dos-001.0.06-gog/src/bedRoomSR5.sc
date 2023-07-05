;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2050)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)
(use PolyEdit)
(use Polygon)

(public
	bedRoomSR5 0
)

(instance bedRoomSR5 of CloseupRoom
	(properties
		picture 31
		style 0
	)

	(method (init)
		(if (== gChapter 1)
			(MR_Happy init:)
		)
		(if (<= gChapter 3)
			(photo init:)
			(screwDriver init:)
			(candyBar init:)
		)
		(if (== gChapter 5)
			(wallet init:)
		)
		(= exitRoom (- (+ 2021 gChapter) 1))
		(super init: &rest)
		((ScriptID 63000 3) exitScene: 741) ; wExit
		((ScriptID 63000 2) exitScene: 741) ; eExit
		((ScriptID 63000 1) exitScene: 741) ; sExit
		((ScriptID 63000 0) exitScene: 741) ; nExit
		(gGame handsOn: 1)
	)
)

(instance MR_Happy of View
	(properties
		priority 9
		x 298
		y 220
		view 31
		loop 3
	)

	(method (init)
		(self setPri: 10)
		(super init:)
	)
)

(instance photo of P2View
	(properties
		priority 20
		x 325
		y 281
		view 31
		loop 4
		doneFlag 91
		invItem 4
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (photoPoly init:))
		)
	)
)

(instance screwDriver of P2View
	(properties
		priority 7
		x 105
		y 246
		view 31
		doneFlag 92
		invItem 10
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (screwPoly init:))
		)
	)
)

(instance candyBar of P2View
	(properties
		priority 6
		x 135
		y 172
		view 31
		loop 2
		doneFlag 93
		invItem 3
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (candyPoly init:))
		)
	)
)

(instance photoPoly of Polygon
	(properties)

	(method (init)
		(super init: 396 189 474 223 438 275 351 253)
		(return self)
	)
)

(instance screwPoly of Polygon
	(properties)

	(method (init)
		(super init: 165 146 298 228 285 245 140 160)
		(return self)
	)
)

(instance candyPoly of Polygon
	(properties)

	(method (init)
		(super init: 190 121 324 103 333 140 198 164)
		(return self)
	)
)

(instance wallet of P2View
	(properties
		priority 20
		x 178
		y 212
		view 31
		loop 5
		doneFlag 762
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (walletPoly init:))
		)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo get: 1) ; walletI
			(gEgo get: 2) ; cardKeyI
			(gEgo get: 8) ; harburgCardI
		)
		(event claimed:)
	)
)

(instance walletPoly of Polygon
	(properties)

	(method (init)
		(super init: 241 115 322 151 267 242 175 210)
		(return self)
	)
)

