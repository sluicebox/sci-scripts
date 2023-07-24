;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4002)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Osc)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm4002 0
)

(instance rm4002 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4002
		south 400 ; marienRm
		west 400 ; marienRm
	)

	(method (init)
		(switch gPrevRoomNum
			(400 ; marienRm
				(gEgo posn: 112 238 heading: 45)
			)
			(else
				(gEgo posn: 295 221 heading: 225)
			)
		)
		(if (OneOf gPrevRoomNum 400 200 410) ; marienRm, MunichMapRm, dienerRm
			(Lock 140 401 0) ; WAVE
			(Lock 140 410 0) ; WAVE
			(Lock 140 402 1) ; WAVE
			(gGk2Music setLoop: -1 number: 402 play:)
		)
		(gEgo normalize: setScaler: Scaler 80 8 333 179 init:)
		(super init: &rest)
		(switch gChapter
			(1
				(if (> (gGame detailLevel:) 5)
					(pGuitarMan init: setCycle: Fwd)
					(pCoupleListening init: setCycle: Fwd)
				else
					(pGuitarMan init:)
					(pCoupleListening init:)
				)
				(if (!= gPrevRoomNum 4044)
					(Lock rsAUDIO 4002 1)
					(gGk2Sound setLoop: -1 number: 4002 play:)
				)
			)
			(3
				(if (> (gGame detailLevel:) 5)
					(pGuitarGroup init: setCycle: Osc -1)
				else
					(pGuitarGroup init:)
				)
				(pLovers init: setScript: FidgetScript)
				(Lock rsAUDIO 4002 1)
				(if (!= gPrevRoomNum 4044)
					(Lock rsAUDIO 4002 1)
					(gGk2Sound setLoop: -1 number: 4002 play:)
				)
			)
			(else
				(pCoupleStanding init: setScript: FidgetScript)
			)
		)
		(fFountain init:)
		(efStreetExit init:)
		(efUBahn init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 4044 4001))
			(Lock 140 402 0) ; WAVE
			(Lock rsAUDIO 4002 0)
			(gGk2Sound stop:)
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance pGuitarGroup of Prop
	(properties
		modNum 400
		sightAngle 360
		x 430
		y 290
		view 23400
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 1 0 400) ; "(TRY TO TALK TO PEDESTRIANS)I'd give it a shot, but I don't speak the language."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pGuitarMan of Prop
	(properties
		modNum 400
		sightAngle 360
		x 489
		y 286
		view 20811
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 1 0 400) ; "(TRY TO TALK TO PEDESTRIANS)I'd give it a shot, but I don't speak the language."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCoupleListening of Prop
	(properties
		modNum 400
		sightAngle 360
		x 458
		y 295
		view 22400
		signal 30753
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 2 0 400) ; "(TRY TO TALK TO PEDESTRIANS)They're busy."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pLovers of Prop
	(properties
		modNum 400
		sightAngle 360
		x 112
		y 360
		view 20800
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 2 0 400) ; "(TRY TO TALK TO PEDESTRIANS)They're busy."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCoupleStanding of Prop
	(properties
		modNum 400
		sightAngle 360
		x 562
		y 240
		view 21400
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 2 0 400) ; "(TRY TO TALK TO PEDESTRIANS)They're busy."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fFountain of GKFeature
	(properties
		modNum 400
		approachX 452
		approachY 223
	)

	(method (init)
		(self
			createPoly: 424 108 410 180 332 180 332 216 354 223 448 225 536 225 566 216 566 187 486 180 456 105
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4044)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance efUBahn of ExitFeature
	(properties
		modNum 400
		y 400
		exitDir 5
	)

	(method (init)
		(self
			createPoly: -2 192 -2 315 164 308 253 292 256 214 243 203 15 220 13 201
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4001)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance efStreetExit of ExitFeature
	(properties
		modNum 400
		x 400
		y 147
		exitDir 7
	)

	(method (init)
		(self createPoly: 368 0 365 203 570 211 614 211 614 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gGame handsOff:)
			(if (== gChapter 1)
				(if (IsFlag 445)
					(gCurRoom newRoom: 410) ; dienerRm
				else
					(SetFlag 445)
					(gCurRoom newRoom: 4140)
				)
			else
				(gCurRoom newRoom: 410) ; dienerRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

