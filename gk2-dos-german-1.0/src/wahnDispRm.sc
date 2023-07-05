;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8601)
(include sci.sh)
(use Main)
(use northExit)
(use soundRegion)
(use Scaler)
(use Feature)
(use System)

(public
	wahnDispRm 0
)

(local
	[local0 4]
)

(instance wahnDispRm of ExitRoom ; "Wagner Museum: Display Rooms"
	(properties
		modNum 860
		noun 12
		picture 8601
		south 850 ; wahnEntryRm
	)

	(method (init)
		(if
			(and
				(== 0 (SoundManager seconds:))
				(or
					(not (gGk2Music handle:))
					(not (OneOf (gGk2Music number:) 851 852 853))
				)
			)
			(gSoundManager play: 0 851 852 853)
		)
		(super init: &rest)
		((ScriptID 22 0) sightAngle: 360) ; northExit
		((ScriptID 22 1) sightAngle: 360) ; southExit
		((ScriptID 22 2) sightAngle: 360) ; eastExit
		((ScriptID 22 3) sightAngle: 360) ; westExit
		(switch gPrevRoomNum
			(8604 ; wahnDisp4Rm
				(gEgo
					posn: 542 338
					heading: 225
					normalize:
					init:
					setScaler: Scaler 81 46 362 278
				)
			)
			(8602 ; wahnDisp2Rm
				(gEgo
					posn: 171 315
					heading: 135
					normalize:
					init:
					setScaler: Scaler 81 46 362 278
				)
			)
			(else
				(gEgo
					posn: 542 338
					heading: 325
					normalize:
					init:
					setScaler: Scaler 81 46 362 278
				)
			)
		)
		(leftBust init:)
		(rightBust init:)
		(leftExit init:)
		(rightExit init:)
		(harpsichord init:)
	)

	(method (dispose)
		((ScriptID 22 0) sightAngle: 40) ; northExit
		((ScriptID 22 1) sightAngle: 40) ; southExit
		((ScriptID 22 2) sightAngle: 40) ; eastExit
		((ScriptID 22 3) sightAngle: 40) ; westExit
		(super dispose: &rest)
	)
)

(instance leftBust of GKFeature
	(properties
		nsLeft 4
		nsTop 103
		nsRight 52
		nsBottom 168
		sightAngle 360
		nextRoomNum 8613 ; wahnBustRm1
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
	)
)

(instance rightBust of GKFeature
	(properties
		nsLeft 272
		nsTop 127
		nsRight 296
		nsBottom 170
		sightAngle 360
		nextRoomNum 8612 ; wahnBustRm1
	)
)

(instance harpsichord of GKFeature
	(properties
		nsLeft 330
		nsTop 216
		nsRight 434
		nsBottom 249
		sightAngle 360
		nextRoomNum 8614 ; wahnharpsichordRm1
	)
)

(instance rightExit of ExitFeature
	(properties
		nsLeft 510
		nsTop 105
		nsRight 590
		nsBottom 283
		sightAngle 360
		nextRoomNum 8604 ; wahnDisp4Rm
		exitDir 1
	)
)

(instance leftExit of ExitFeature
	(properties
		nsLeft 120
		nsTop 120
		nsRight 218
		nsBottom 283
		sightAngle 360
		nextRoomNum 8602 ; wahnDisp2Rm
		exitDir 7
	)
)

