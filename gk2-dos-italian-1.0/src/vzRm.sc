;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56501)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	vzRm 0
)

(instance vzRm of ExitRoom ; "Hunting Lodge: Von Zell's Room"
	(properties
		modNum 546
		noun 9
		picture 56501
		west 546 ; vzWRm
	)

	(method (init)
		(gEgo
			posn: 182 276
			heading: 135
			sel_737:
			setScaler: Scaler 95 75 310 250
			init:
		)
		(super init: &rest)
		(fDoor init:)
		(fBed init:)
		(fShrank init:)
		(fEastExit init:)
		(fBathroom init:)
		(gGame handsOn:)
	)
)

(instance fEastExit of ExitFeature
	(properties
		nsLeft 550
		nsTop 15
		nsRight 640
		nsBottom 334
		x 2000
		y 250
		BAD_SELECTOR 56511
		BAD_SELECTOR 2
	)
)

(instance fDoor of GKFeature
	(properties
		noun 1
		modNum 546
	)

	(method (handleEvent event)
		(= global141 self)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 18 274 18 35 101 47 101 255)
	)
)

(instance fBathroom of GKFeature
	(properties
		modNum 546
		approachX 466
		approachY 267
		BAD_SELECTOR 56512
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 429 239 429 25 536 8 536 249)
	)
)

(instance fBed of GKFeature
	(properties
		BAD_SELECTOR 1644
	)

	(method (handleEvent event)
		(= global141 self)
		(super handleEvent: event &rest)
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 38 333 38 311 44 306 42 294 48 289 56 290 60 299 56 304 62 313 96 302 107 295 106 288 140 274 207 238 242 230 269 236 311 222 333 229 362 233 392 235 458 247 550 254 561 264 614 232 614 333
		)
	)
)

(instance fShrank of GKFeature
	(properties
		sightAngle 360
		approachX 325
		approachY 273
		BAD_SELECTOR 2645
		BAD_SELECTOR 56515
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 257 230 257 44 249 34 355 19 386 32 382 39 382 231 351 227 336 228 311 220 273 233
		)
	)
)

