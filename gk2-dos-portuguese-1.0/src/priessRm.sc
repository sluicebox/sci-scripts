;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 543)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Sound)
(use System)

(public
	priessRm 0
)

(instance priessRm of ExitRoom ; "Hunting Lodge: Priess' Bedroom"
	(properties
		modNum 543
		noun 8
		picture 5501
		south 5512 ; rm5512
	)

	(method (init)
		(gEgo
			posn: 182 276
			heading: 135
			sel_737:
			setScaler: Scaler 95 75 310 250
			init:
		)
		(Lock 140 543 1) ; WAVE
		(super init: &rest)
		(fBed init:)
		(fBathroom init:)
		(fShrank init:)
		(fDoor init:)
		(self setScript: washScript)
		(gGame handsOn:)
	)

	(method (dispose)
		(Lock 140 543 0) ; WAVE
		(super dispose:)
	)
)

(instance washSound of Sound
	(properties
		number 543
	)
)

(instance washScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 30))
			)
			(1
				(washSound play: self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance fDoor of GKFeature
	(properties
		approachX 61
		approachY 273
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 18 274 18 35 101 47 101 255)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 530) ; hallRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBathroom of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 429 239 429 25 536 8 536 249)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62) ; "(TRY TO OPEN PREISS'S BATHROOM DOOR)I'm pretty sure Herr Preiss is in there, and I DON'T want to know what he's doing."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBed of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				38
				333
				38
				311
				44
				306
				42
				294
				48
				289
				56
				290
				60
				299
				56
				304
				62
				313
				96
				302
				107
				295
				106
				288
				140
				274
				207
				238
				242
				230
				269
				236
				311
				222
				333
				229
				362
				233
				392
				235
				458
				247
				550
				254
				561
				264
				614
				232
				614
				333
		)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 644)
		else
			(super doVerb: &rest)
		)
	)
)

(instance fShrank of GKFeature
	(properties
		sightAngle 360
		approachX 465
		approachY 266
		BAD_SELECTOR 1645
		BAD_SELECTOR 54401
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				257
				230
				257
				44
				249
				34
				355
				19
				386
				32
				382
				39
				382
				231
				351
				227
				336
				228
				311
				220
				273
				233
		)
	)
)

