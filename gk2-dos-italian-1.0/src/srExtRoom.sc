;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	srExtRoom 0
)

(instance srExtRoom of ExitRoom ; "Schloss Ritter: Exterior"
	(properties
		noun 4
		picture 1101
	)

	(method (newRoom newRoomNumber)
		(gGk2Music fade:)
		(Lock 140 100 0) ; WAVE
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (or (not (gGk2Music handle:)) (!= (gGk2Music number:) 100))
			(Lock 140 100 1) ; WAVE
			(gGk2Music number: 100 setLoop: -1 play:)
		)
		(super init: &rest)
		(doors init:)
		(if (!= gChapter 6)
			(castle init:)
		)
		(path init:)
		(car init:)
		(switch gPrevRoomNum
			(1211
				(gEgo posn: 221 280 heading: 180)
			)
			(700 ; sqRm
				(gEgo posn: 38 309 heading: 90)
			)
			(7011
				(gEgo posn: 38 309 heading: 90)
			)
			(else
				(gEgo posn: 459 296 heading: 270)
				(= global141 car)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 53 14 324 221 init:)
		(if (== gPrevRoomNum 800) ; bavMapRm
			(SetFlag 409)
			(PlayScene 1427)
		)
	)
)

(instance doors of ExitFeature
	(properties
		nsLeft 242
		nsTop 180
		nsRight 268
		nsBottom 220
		x 250
		y 310
		BAD_SELECTOR 120
		BAD_SELECTOR 0
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(cond
				((< (gEgo x:) 100)
					(= approachX 640)
					(= approachY 0)
				)
				((== (gEgo y:) 230)
					(= approachX 247)
					(= approachY 230)
				)
				((== gPrevRoomNum 1211)
					(= approachX 229)
					(= approachY 0)
				)
				(else
					(= approachX 50)
					(= approachY 310)
				)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance castle of GKFeature
	(properties
		noun 5
		sightAngle 360
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 268 234 223 374 220 374 136 324 60 242 12 198 38 160 0 104 64
					yourself:
				)
		)
	)
)

(instance path of ExitFeature
	(properties
		nsTop 230
		nsRight 80
		nsBottom 278
		sightAngle 0
		x 50
		y 670
		BAD_SELECTOR 460
		BAD_SELECTOR 700
		BAD_SELECTOR 4
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== gPrevRoomNum 700)) ; sqRm
			(= approachX -100)
			(= approachY 310)
		)
		(super handleEvent: event &rest)
	)
)

(instance car of GKFeature
	(properties
		nsLeft 338
		nsTop 202
		nsRight 602
		nsBottom 310
		sightAngle 360
		x 250
		y 310
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (event message:) KEY_q))
			(= sightAngle 0)
		else
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((== gChapter 6)
						(gMessager say: 6 62 0 1) ; "(PICKUP, LOOK AT CAR, CH 6)Gabriel won't be needing his car for a while. I don't think he'll mind if I use it. At least, not if I don't tell him."
					)
					((gEgo has: 72) ; invCarKeys
						(gMessager say: 3 62 0 1) ; "(LOOK AT CAR AFTER GETTING KEYS)At least I have the car keys now."
					)
					((IsFlag 186)
						(gMessager say: 2 62 0 1) ; "(LOOK AT CAR)Gerde's being a real pig about those car keys."
					)
					(else
						(gMessager say: 1 62 0 1) ; "(SCHLOSS RITTER EXT. CURIOUS)That must be Gabriel's car. I wonder where the keys are?"
						(SetFlag 460)
					)
				)
			)
			(113 ; invCarKeys
				(SetFlag 615)
				(PlayScene 427 0 800) ; bavMapRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

