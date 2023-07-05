;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Cursor)
(use Actor)
(use System)

(public
	dienerRm 0
)

(instance dienerRm of ExitRoom ; "Dienerstrasse"
	(properties
		modNum 410
		noun 4
		picture 4101
		horizon 204
		south 4002 ; rm4002
	)

	(method (init)
		(switch gPrevRoomNum
			(4002
				(gEgo posn: 47 330 heading: 45)
			)
			(4140
				(gEgo posn: 47 330 heading: 45)
			)
			(4110
				(gEgo posn: 430 213 heading: 225)
			)
			(else
				(gEgo posn: 183 216 heading: 135)
			)
		)
		(gEgo normalize: setScaler: Scaler 80 8 333 179 init:)
		(switch gChapter
			(1
				(randomPeople init: setScript: (FidgetScript new:))
			)
			(3
				(randomDude init: setScript: FidgetScript)
			)
		)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 4002 4140)
			(Lock 140 402 0) ; WAVE
			(Lock 140 410 1) ; WAVE
			(gGk2Music setLoop: -1 number: 410 play:)
		)
		(fPost init:)
		(fExitNorth init:)
		(if (and (not (IsFlag 549)) (== gChapter 3))
			(vPoliceCars init:)
		)
		((ScriptID 22 1) sightAngle: 0) ; southExit
		(gGame handsOn: 0)
	)
)

(instance vPoliceCars of View
	(properties
		x 241
		y 183
		view 21336
		loop 1
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)
)

(instance fPost of GKFeature
	(properties
		modNum 410
		approachX 640
		approachY 167
	)

	(method (init)
		(self createPoly: 428 127 428 194 452 201 452 127)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame handsOff:)
				(gCurRoom newRoom: 4110)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance randomDude of Prop
	(properties
		modNum 410
		sightAngle 360
		x 518
		y 243
		view 41011
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

(instance randomPeople of Prop
	(properties
		modNum 410
		sightAngle 360
		x 348
		y 202
		view 41012
	)

	(method (doVerb theVerb)
		(randomDude doVerb: theVerb)
	)
)

(instance fExitNorth of ExitFeature
	(properties
		modNum 410
		sightAngle 0
		approachX 260
		exitDir 0
	)

	(method (init)
		(self createPoly: 216 -2 221 177 343 189 335 -3)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4102)
		else
			(super doVerb: theVerb)
		)
	)
)

