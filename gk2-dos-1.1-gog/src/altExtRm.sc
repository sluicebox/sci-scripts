;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	altExtRm 0
)

(local
	local0
	local1
)

(instance altExtRm of ExitRoom ; "Alt\99tting: Church Exterior"
	(properties
		noun 8
		picture 10001
		east 10010 ; rm10010
		west 10045 ; rm10045
	)

	(method (init)
		(if (and (gEgo has: 58) (IsFlag 705) (IsFlag 385) (IsFlag 387)) ; invOperaAct3, "Our Plan" in smithTopicCh6, "Von Glower's Letter" in smithTopicCh6
			(= local0 1)
		else
			(= local0 0)
		)
		(gCurRoom setScript: sndTrans)
		(gGame handsOff:)
		(if (== gPrevRoomNum 10002)
			(gEgo
				posn: 72 268
				heading: 180
				normalize:
				setScaler: Scaler 75 51 350 228
				init:
			)
		else
			(gEgo
				posn: 36 297
				heading: 45
				normalize:
				setScaler: Scaler 75 51 350 228
				init:
			)
		)
		(super init: &rest)
		(secondView init:)
		(south1 init:)
		(south2 init:)
		(plaqueArea1 init:)
		(glassCase init:)
		(crosses init:)
		(gGame handsOn:)
	)
)

(instance sndTrans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self dispose:)
				else
					(self cue:)
				)
			)
			(1
				(if (and (gGk2Music handle:) (== (gGk2Music number:) 1000))
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1 self)
				else
					(self cue:)
				)
			)
			(3
				(Lock 140 10045 0) ; WAVE
				(Lock 140 1000 1) ; WAVE
				(gGk2Music
					number: 1000
					setLoop: -1
					play: 0 0
					fade: 63 10 10 0 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance plaqueArea1 of GKFeature
	(properties
		sightAngle 0
		x 166
		y 172
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 105 212 96 186 252 124 218
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10040)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glassCase of GKFeature
	(properties
		sightAngle 0
		approachX 323
		approachY 331
		x 390
		y 156
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 86 494 57 518 62 518 242 492 254 262 192
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10043)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crosses of GKFeature
	(properties
		sightAngle 0
		approachX 323
		approachY 331
		x 360
		y 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 333 238 302 232 278 258 259 264 261 295 203 500 259 468 297 496 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10044)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance secondView of ExitFeature
	(properties
		sightAngle 40
		approachX 320
		x 74
		y 230
		exitDir 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 249 0 249 60 230 74 229 74 88 120 88 122 213 122 230
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10002)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance south1 of ExitFeature
	(properties
		sightAngle 40
		approachX 320
		approachY 600
		x 108
		y 308
		exitDir 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 333 1 283 215 283 215 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10010)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance south2 of ExitFeature
	(properties
		sightAngle 40
		approachX 320
		approachY 600
		x 542
		y 308
		exitDir 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 481 284 614 284 614 333 497 333 470 297
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10010)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

