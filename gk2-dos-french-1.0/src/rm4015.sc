;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4015)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4015 0
)

(instance rm4015 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4015
		south 4004 ; rm4004
	)

	(method (init)
		(super init: &rest)
		(fSign init:)
		(fUbergrau init:)
		(gGame handsOn: 0)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 420) ; uberRm
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fUbergrau of ExitFeature
	(properties
		modNum 400
		x 386
		y 289
		exitDir 0
	)

	(method (init)
		(self createPoly: 318 40 432 52 432 285 326 307)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gChapter 3) (IsFlag 504))
						(gMessager say: 38 62 0 1 0 400) ; "Ubergrau's office is locked."
					)
					((!= gChapter 1)
						(PlayScene 61 0 420) ; uberRm
					)
					((not (IsFlag 606))
						(gMessager say: 33 62 0 0 0 400) ; "(PICK UP, LOOK AT UBERGRAU'S BUILDING BEFORE YOU KNOW UBERGRAU'S ADDRESS CH 1)It's just an office building."
					)
					((IsFlag 446)
						(PlayScene 61 0 420) ; uberRm
					)
					(else
						(SetFlag 446)
						(PlayScene 60 0 420) ; uberRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setCursor param1)
		(if (and (== gChapter 1) (not (IsFlag 606)))
			(param1 view: 999)
			(param1 loop: 1)
			(param1 cel: 0)
		else
			(super setCursor: param1)
		)
	)
)

(instance fSign of GKFeature
	(properties
		modNum 400
		sightAngle 180
		x 268
		y 158
	)

	(method (init)
		(self createPoly: 231 74 311 78 311 120 231 118)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((!= gChapter 1)
						(gCurRoom newRoom: 4016)
					)
					((not (IsFlag 606))
						(gMessager say: 33 62 0 0 0 400) ; "(PICK UP, LOOK AT UBERGRAU'S BUILDING BEFORE YOU KNOW UBERGRAU'S ADDRESS CH 1)It's just an office building."
					)
					((IsFlag 446)
						(gCurRoom newRoom: 4016)
					)
					(else
						(SetFlag 446)
						(PlayScene 60 0 420) ; uberRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

