;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm930 0
)

(instance rm930 of ExitRoom ; "Neuschwanstein: Study"
	(properties
		noun 17
		picture 9301
		west 960 ; rm960
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(gEgo
			posn: 410 332
			heading: 315
			normalize:
			setScaler: Scaler 83 50 364 284
			init:
		)
		(super init: &rest)
		(if (not (IsFlag 788))
			(guard3 init:)
		)
		(door init:)
		(if (!= gChapter 6)
			(desk init:)
		)
		(leftPic init:)
		(rightPic init:)
		(nudePic init:)
		(cabinet init:)
		(self setScript: guardControl)
	)
)

(instance door of ExitFeature
	(properties
		x 201
		y 182
		nextRoomNum 970 ; rm970
		exitDir 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 104 242 112 246 190 216 156 185 184 180 237 166 282 150 282
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance desk of GKFeature
	(properties
		sightAngle 360
		x 265
		y 284
		nextRoomNum 9343 ; rm9343
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 242 168 281 177 333 334 305 336 249 360 246 358 238 307 225
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftPic of GKFeature
	(properties
		x 47
		y 77
		nextRoomNum 9340 ; neuStudyLeftPic
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 152 97 154 98 6 75 -1 -1 -3
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPic of GKFeature
	(properties
		x 324
		y 97
		nextRoomNum 9341 ; neuStudyRightPic
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 158 350 158 350 61 316 40 296 61 324 81 324 91 293 101 281 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance nudePic of GKFeature
	(properties
		x 493
		y 79
		nextRoomNum 9342 ; neuStudyNudePic
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 381 33 354 64 354 159 379 155 382 116 432 109 439 133 450 108 457 129 463 109 474 130 494 109 515 133 517 149 616 147 616 -3 471 -3
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cabinet of GKFeature
	(properties
		sightAngle 360
		x 455
		y 227
		nextRoomNum 9310 ; rm9310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 381 139 372 277 508 322 539 305 534 133
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance guard3 of Prop
	(properties
		modNum 910
		sightAngle 360
		x 74
		y 333
		view 31930
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(= noun
			(if (== gChapter 4)
				(if (== theVerb 62) ; Do
					1
				else
					(= theVerb 0)
					2
				)
			else
				(switch theVerb
					(31 19) ; invDove
					(else
						(= theVerb 62) ; Do
						18
					)
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 1
		sightAngle 360
		x 10
		y 290
		view 141
		loop 5
	)

	(method (cue)
		(gGame changeScore: 993)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 583)
			(gMessager say: noun 62 0 0 self) ; "This is the king's study. Ludwig spent much time at his desk writing letters, drawing up plans for his projects, and studying his favorite authors. He loved poetry, history, and the classics. In latter years he also studied the occult. What affairs of state he did reluctantly attend to where generally attended to alone at his desk, in writing."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance guardControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 40 50))
			)
			(1
				(cond
					((= register (gCast contains: guard3))
						(SetFlag 788)
						(guard3 setScript: 0 setCycle: Beg self)
					)
					((not (DoAudio audWPLAY))
						(ClearFlag 788)
						(PlayRobot 30930 0 135 self 200)
					)
					(else
						(-- state)
						(= seconds 2)
					)
				)
			)
			(2
				(= state -1)
				(gGame handsOff:)
				(if register
					(if (not (DoAudio audWPLAY))
						(guard3 dispose:)
						(PlayRobot 32930 0 135 self 200)
					else
						(= state 1)
						(= seconds 2)
					)
				else
					(= seconds (Random 2 4))
					(guard3 init: setScript: FidgetScript)
				)
			)
		)
	)
)

