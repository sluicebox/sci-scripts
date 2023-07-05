;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	foyerRm 0
)

(instance foyerRm of ExitRoom ; "Wittelsbacher Theater: Foyer"
	(properties
		noun 7
		picture 11001
		south 11002 ; rm11002
	)

	(method (init)
		(if (== gPrevRoomNum 1140) ; centerHallRm
			(gEgo
				posn: 372 268
				heading: 135
				normalize:
				setScaler: Scaler 82 36 354 249
				init:
			)
		else
			(gEgo
				posn: 555 321
				heading: 315
				normalize:
				setScaler: Scaler 82 36 354 249
				init:
			)
		)
		(if (IsFlag 739)
			(Palette 1 (= global249 249)) ; PalLoad
		else
			(Palette 1 (= global249 250)) ; PalLoad
		)
		(super init: &rest)
		(if (IsFlag 735)
			(vProgrammes init:)
		)
		(frontDoor init:)
		(vSign init:)
		(eastExit init:)
		(stairs init:)
		(if
			(and
				(IsFlag 735)
				(IsFlag 741)
				(IsFlag 742)
				(not (IsFlag 743))
			)
			(vUsher init: setScript: FidgetScript)
		)
		(if (not (IsFlag 740))
			(SetFlag 740)
			(gEgo get: 56 put: 21 put: 17 put: 37 put: 42 put: 41 put: 58) ; invChandelierDiagram, invScrewdriver, invBarclayCard, invGabeLetter2, invChaphillNote, invDallmeierNote, invOperaAct3
			(PlayScene 819)
			(if
				(and
					(IsFlag 735)
					(or
						(not (gGk2Music handle:))
						(!= 11002 (gGk2Music number:))
					)
				)
				(Lock rsAUDIO 11002 1)
				(gGk2Music number: 11002 setLoop: -1 play: 0 0 fade: 63 10 10 0)
			)
		)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
	)
)

(instance vProgrammes of GKFeature
	(properties
		modNum 1100
		nsLeft 247
		nsTop 203
		nsRight 314
		nsBottom 254
		sightAngle 40
		x 287
		y 217
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 750))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 750)
					(gMessager say: 5 62 0 0 0 1100) ; "(TRY TO TAKE SECOND PROGRAM)I already have a program."
				else
					(SetFlag 750)
					(PlayScene 829)
					(gEgo get: 65 posn: 325 245 heading: 225) ; invOperaProgram
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vSign of GKFeature
	(properties
		modNum 1100
		nsLeft 494
		nsTop 190
		nsRight 563
		nsBottom 276
		x 474
		y 279
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (gEgo x:) 555))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11040)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vUsher of Prop
	(properties
		modNum 1100
		sightAngle 360
		x 427
		y 320
		view 20820
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 6 62 0 0 0 1100) ; "(LOOK AT USHER)He's Paul, the head usher."
			)
			(104 ; invSeatingChart
				(PlayScene 830)
				(gEgo put: 66) ; invSeatingChart
				(SetFlag 754)
				(SetFlag 745)
				(self dispose:)
			)
			(else
				(gMessager say: 10 62 0 0 0 1100) ; "I don't think he'd be interested in that."
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		sightAngle 40
		x 581
		y 253
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 548 333 548 208 614 173 614 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11002)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairs of ExitFeature
	(properties
		modNum 1100
		sightAngle 40
		approachX 403
		approachY 249
		x 517
		y 178
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 614 176 477 241 467 261 423 261 422 250 429 243 432 195 447 193 614 96
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 736) (not (IsFlag 739)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 735)
						(PlayScene 826 0 1140) ; centerHallRm
					)
					((and (IsFlag 736) (not (IsFlag 739)))
						(gMessager say: 2 62 0 0 0 modNum) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(PlayScene 827 0 1140) ; centerHallRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToMap of GKFeature ; UNUSED
	(properties
		sightAngle 40
		x 183
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 86 202 102 206 253 161 272
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 800) ; bavMapRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frontDoor of GKFeature
	(properties
		noun 8
		modNum 1100
		nsLeft 75
		nsTop 65
		nsRight 224
		nsBottom 268
		sightAngle 360
	)
)

