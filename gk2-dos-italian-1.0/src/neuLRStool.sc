;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9502)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	neuLRStool 0
)

(instance neuLRStool of ExitRoom ; "Neuschwanstein: Living Room"
	(properties
		modNum 950
		noun 23
		picture 9502
		south 950 ; rm950
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 960)
			(gEgo
				posn: 185 296
				heading: 135
				sel_737:
				init:
				setScaler: Scaler 90 73 349 303
			)
		else
			(gEgo
				posn: 240 365
				heading: 325
				sel_737:
				init:
				setScaler: Scaler 90 73 349 303
			)
		)
		(if (and (== gChapter 6) (not (IsFlag 731)))
			(gGame setScript: doScene777)
		)
		(door init:)
		(fSwan init:)
	)
)

(instance doScene777 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 731)
				(gGame handsOff:)
				(= ticks 40)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= cycles 16)
			)
			(3
				(PlayScene 777 self)
			)
			(4
				(gEgo sel_737: 225)
				(= seconds 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		sightAngle 360
		x 161
		y 183
		BAD_SELECTOR 960
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 66 189 79 189 287 133 301
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 2
		modNum 950
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 574)
		)
		(super doVerb: theVerb)
	)
)

(instance painting of GKFeature ; UNUSED
	(properties
		sightAngle 360
		x 425
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 37 252 192 357 195 370 160 384 160 392 171 406 165 426 175 426 196 597 202 599 -1 448 10 424 38 386 33 380 40 360 47 349 35 342 42 319 42 280 46
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fSwan of GKFeature
	(properties
		noun 7
		modNum 950
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 367 222 356 188 372 156 425 172 429 195 444 195 429 228
		)
	)
)

