;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10002)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm10002 0
)

(local
	local0
	local1
)

(instance rm10002 of ExitRoom ; "Alt\99tting: Church Exterior"
	(properties
		modNum 1000
		noun 8
		picture 10002
		east 10045 ; rm10045
	)

	(method (init)
		(if (and (gEgo has: 58) (IsFlag 705) (IsFlag 385) (IsFlag 387)) ; invOperaAct3
			(= local1 1)
		else
			(= local1 0)
		)
		(gCurRoom setScript: sndTrans)
		(if (== gPrevRoomNum 1000) ; altExtRm
			(gEgo
				posn: 436 295
				heading: 180
				sel_737:
				setScaler: Scaler 100 51 350 228
				init:
			)
		else
			(gEgo
				posn: 452 328
				heading: 0
				sel_737:
				setScaler: Scaler 100 51 350 228
				init:
				heading: 5
			)
		)
		(super init: &rest)
		(firstView init:)
		(southExit init:)
		(priestDoor init:)
		(plaqueArea2 init:)
		(plaqueArea3 init:)
	)
)

(instance sndTrans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (not local1) (== gPrevRoomNum 1020)) ; priestOfficeRm
						(gGk2Music fade: 0 10 10 1 self)
					)
					((and local1 (== gPrevRoomNum 1020)) ; priestOfficeRm
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(1
				(if (not local1)
					(Lock 140 1020 0) ; WAVE
					(Lock 140 1000 1) ; WAVE
					(= local0 1000)
				else
					(Lock 140 10045 1) ; WAVE
					(= local0 10045)
				)
				(gGk2Music
					number: local0
					setLoop: -1
					play: 0 0
					fade: 63 10 10 0 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance firstView of ExitFeature
	(properties
		sightAngle 40
		x 434
		y 157
		BAD_SELECTOR 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 345 258 345 57 412 57 410 228 523 258
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 1000) ; altExtRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		sightAngle 40
		x 404
		y 315
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 299 602 299 602 331 207 331
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

(instance priestDoor of ExitFeature
	(properties
		nsLeft 214
		nsTop 25
		nsRight 321
		nsBottom 306
		sightAngle 40
		approachX 139
		approachY 309
		x 139
		y 166
		BAD_SELECTOR 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 1020) ; priestOfficeRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plaqueArea2 of GKFeature
	(properties
		sightAngle 40
		approachX 50
		approachY 336
		x 50
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 332 0 1 95 1 95 332 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10041)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plaqueArea3 of GKFeature
	(properties
		nsLeft 95
		nsTop 28
		nsRight 213
		nsBottom 310
		sightAngle 40
		approachX 270
		approachY 309
		x 270
		y 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10042)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

