;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4004)
(include sci.sh)
(use Main)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm4004 0
)

(instance rm4004 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4004
		east 400 ; marienRm
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(400 ; marienRm
				(gEgo posn: 470 372 heading: 315)
			)
			(else
				(gEgo posn: 226 302 heading: 135)
			)
		)
		(if (OneOf gPrevRoomNum 400 420) ; marienRm, uberRm
			(Lock 140 401 0) ; WAVE
			(Lock 140 400 1) ; WAVE
			(gGk2Music setLoop: -1 number: 400 play:)
		)
		(gEgo normalize: setScaler: Scaler 95 45 355 241 init:)
		(vVendor init: setScript: FidgetScript)
		(fWasharia init:)
		(fUbergrau init:)
		(gGame handsOn: 0)
	)
)

(instance vVendor of Prop
	(properties
		modNum 400
		approachX 500
		approachY 250
		x 335
		y 167
		view 20551
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4014)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fUbergrau of Feature
	(properties
		modNum 400
		nsLeft 86
		nsTop 122
		nsRight 156
		nsBottom 218
		x 86
		y 122
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4015)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fWasharia of Feature
	(properties
		modNum 400
		nsLeft 282
		nsTop 72
		nsRight 500
		nsBottom 259
		x 500
		y 250
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4014)
		else
			(super doVerb: theVerb)
		)
	)
)

