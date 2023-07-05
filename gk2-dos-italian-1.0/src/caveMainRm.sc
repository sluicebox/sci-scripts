;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	caveMainRm 0
)

(instance caveMainRm of ExitRoom
	(properties
		picture 6601
	)

	(method (init)
		(switch gPrevRoomNum
			(670 ; cavePitRm
				(gEgo posn: 213 370 heading: 135)
			)
			(else
				(gEgo posn: 213 370 heading: 0)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 100 84 357 312 init:)
		(super init: &rest)
		(fPitExit init:)
		(fSouthExit init:)
		(Lock 140 660 1) ; WAVE
		(gGk2Music setLoop: -1 number: 660 play:)
		(gGame handsOn:)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		sightAngle 360
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(Lock 140 660 0) ; WAVE
			(gGk2Music stop:)
			(PlayScene 678 0 640) ; lairExtRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fPitExit of ExitFeature
	(properties
		sightAngle 360
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 121 308 142 251 139 214 76 201 23 242 10 276 14 327)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(Lock 140 660 0) ; WAVE
			(gGk2Music stop:)
			(PlayScene 699 0 670) ; cavePitRm
		else
			(super doVerb: &rest)
		)
	)
)

