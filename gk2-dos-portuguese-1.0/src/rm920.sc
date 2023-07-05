;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 920)
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
	rm920 0
)

(instance rm920 of ExitRoom ; "Neuschwanstein: Bedroom"
	(properties
		noun 22
		picture 9201
		east 921 ; bed2
		south 910 ; rm910
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(panel init:)
		)
		(if (OneOf gPrevRoomNum 950 940 9211) ; neuBedPanel
			(gEgo
				posn: 329 323
				heading: 225
				BAD_SELECTOR:
				setScaler: Scaler 75 35 371 272
				init:
			)
		else
			(gEgo
				posn: 279 343
				heading: 45
				BAD_SELECTOR:
				setScaler: Scaler 75 35 371 272
				init:
			)
		)
		(super init: &rest)
		(leftPic init:)
		(rightPic init:)
		(livingRmExit init:)
		(chapelExit init:)
		(bedArea init:)
		(cond
			((not (IsFlag 729))
				(guard1 init: setScript: FidgetScript)
				(SetFlag 786)
			)
			((not (IsFlag 787))
				(ClearFlag 786)
				(guard2 init: setScript: FidgetScript)
			)
			(else
				(SetFlag 786)
			)
		)
		(self setScript: guardsRotate)
	)
)

(instance guardsRotate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 40 50))
			)
			(1
				(gGame handsOff:)
				(cond
					((= register (gCast contains: guard1))
						(if (guard1 cel:)
							(guard1 setScript: 0 setCycle: Beg self)
						else
							(guard1 setScript: 0)
							(self cue:)
						)
					)
					((guard2 cel:)
						(guard2 setScript: 0 setCycle: Beg self)
					)
					(else
						(guard2 setScript: 0)
						(self cue:)
					)
				)
			)
			(2
				(if (not (DoAudio audWPLAY))
					(if register
						(SetFlag 729)
						(guard1 dispose:)
						(PlayRobot 12920 0 29 self 400)
					else
						(SetFlag 786)
						(guard2 dispose:)
						(PlayRobot 22920 264 157 self)
					)
				else
					(-- state)
					(= seconds 2)
				)
			)
			(3
				(cond
					(register
						(if (not (IsFlag 787))
							(if (not (DoAudio audWPLAY))
								(ClearFlag 786)
								(PlayRobot 20920 264 157 self)
							else
								(-- state)
								(= seconds 2)
							)
						else
							(self cue:)
						)
					)
					((not (DoAudio audWPLAY))
						(ClearFlag 729)
						(PlayRobot 10920 0 29 self 400)
					)
					(else
						(-- state)
						(= seconds 2)
					)
				)
			)
			(4
				(if register
					(if (not (IsFlag 787))
						(guard2 init: setScript: FidgetScript)
					)
				else
					(guard1 init: setScript: FidgetScript)
				)
				(= state -1)
				(= ticks 10)
			)
		)
	)
)

(instance leftPic of GKFeature
	(properties
		approachX 388
		approachY 200
		x 385
		y 86
		BAD_SELECTOR 9243
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 365 23 362 49 339 69 318 73 332 92 324 149 452 149 453 52 446 23
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPic of GKFeature
	(properties
		approachX 388
		approachY 200
		x 385
		y 86
		BAD_SELECTOR 9244
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 480 28 613 28 612 116 582 99 526 111 527 123 514 123 516 152 472 152 472 111 483 99 477 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance livingRmExit of ExitFeature
	(properties
		approachX 376
		approachY 274
		x 376
		y 217
		BAD_SELECTOR 950
		BAD_SELECTOR 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 356 286 356 149 397 149 397 277
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chapelExit of ExitFeature
	(properties
		approachX 551
		approachY 281
		x 562
		y 218
		BAD_SELECTOR 940
		BAD_SELECTOR 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 527 285 527 189 537 163 563 151 585 163 597 186 597 285
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance panel of GKFeature
	(properties
		approachX 484
		approachY 302
		x 496
		y 212
		BAD_SELECTOR 9211
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 453 167 514 167 514 291 453 291
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bedArea of GKFeature
	(properties
		approachX 195
		approachY 301
		x 131
		y 214
		BAD_SELECTOR 9210
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 33 127 230 127 230 281 33 302
					yourself:
				)
		)
		(super init: &rest)
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
		(gGame changeScore: 989)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 582)
			(gMessager say: noun 62 0 0 self) ; "You are now standing in the King's bedroom. The theme of the bedroom is "Tristan and Isolde," the tragic love story retold in Wagner's opera. The opera was given it's first performance in Munich in 1865 and a twenty-year old Ludwig attended."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance guard1 of Prop
	(properties
		modNum 910
		x 443
		y 331
		view 11920
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(= noun
			(cond
				((== gChapter 4)
					(if (== theVerb 62) ; Do
						1
					else
						(= theVerb 0)
						2
					)
				)
				((== theVerb 31) 19) ; invDove
				(else
					(= theVerb 62) ; Do
					18
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance guard2 of Prop
	(properties
		modNum 910
		x 477
		y 325
		view 21920
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(= noun
			(cond
				((== gChapter 4)
					(if (== theVerb 62) ; Do
						1
					else
						(= theVerb 0)
						2
					)
				)
				((== theVerb 31) 19) ; invDove
				(else
					(= theVerb 62) ; Do
					18
				)
			)
		)
		(super doVerb: theVerb)
	)
)

