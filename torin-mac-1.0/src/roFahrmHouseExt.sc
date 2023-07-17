;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use foEExit)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	roFahrmHouseExt 0
)

(local
	bTalking
)

(instance foSouthExit of ExitFeature
	(properties
		approachX 107
		approachY 330
		x 100
		y 335
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 292 345 290 313 331 -1 319
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo approach: self self)
	)

	(method (cue)
		(gCurRoom newRoom: 10100) ; roForestScroll
	)
)

(instance poDoorExit of Prop
	(properties
		approachX 378
		approachY 188
		x 386
		y 188
		priority 180
		fixPriority 1
		view 11004
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soDoorExit)
	)
)

(instance soDoorExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 11003)
				(gEgo face: (ScriptID 64018 0) self) ; oBoogle
			)
			(1
				(= gnBoogleInBagMsg 3)
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(2
				(= gnBoogleInBagMsg 0)
				(gEgo approach: poDoorExit self)
			)
			(3
				(gEgo hide:)
				(poDoorExit cel: 1 setCycle: CT 6 1 self)
			)
			(4
				(goSound1 playSound: 11003)
				(poDoorExit setCycle: End self)
			)
			(5
				(gCurRoom newRoom: 11100) ; roFahrmHouseInt
			)
		)
	)
)

(instance oAxPolygon of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: 501 254 545 254 545 273 496 273 453 283 402 270 412 238 497 238
		)
		(gCurRoom addObstacle: self)
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance oBlockPolygon of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super init: 503 269 453 282 401 269 413 238 496 238)
		(gCurRoom addObstacle: self)
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance voAx of View
	(properties
		x 503
		y 266
		priority 271
		fixPriority 1
		view 11006
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(gCurRoom setScript: soPickUpAx)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance poPickUpAx of Prop
	(properties
		view 11001
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(instance soPickUpAx of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 505 260 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (voAx x:) (voAx y:) self)
			)
			(2
				(gEgo setHeading: 225 self)
			)
			(3
				(gEgo hide:)
				(poPickUpAx
					posn: (voAx x:) (voAx y:)
					setPri: (- (voAx priority:) 1)
					init:
					setCycle: CT 5 1 self
				)
			)
			(4
				(voAx dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioAx
				((ScriptID 64017 0) set: 0) ; oFlags
				(oAxPolygon dispose:)
				(oBlockPolygon init:)
				(poPickUpAx setCycle: CT 13 1 self)
			)
			(5
				(= bTalking 1)
				(gMessager say: 1 1 0 0 coDoneTalking) ; "I wish I had a pleber for every time I've swung THIS."
				(poPickUpAx setCycle: End self)
			)
			(6
				(gEgo posn: (+ (poPickUpAx x:) 28) (poPickUpAx y:) show:)
				(poPickUpAx dispose:)
				(= cycles 1)
			)
			(7
				(if bTalking
					(-= state 2)
				)
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poSmoke of Prop
	(properties
		x 315
		y 53
		view 11003
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance voRope of View
	(properties
		x 229
		y 32
		view 11005
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Do
			(gCurRoom setScript: soPickUpRope)
		)
	)
)

(instance poPickUpRope of Prop
	(properties
		view 11000
	)
)

(instance soPickUpRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 208 184 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poPickUpRope
					posn: (gEgo x:) (gEgo y:)
					setScalePercent: 105
					init:
					setCycle: CT 8 1 self
				)
			)
			(3
				(voRope dispose:)
				(poPickUpRope setCycle: End self)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 13) (- (gEgo y:) 3) show:)
				(poPickUpRope dispose:)
				((ScriptID 64017 0) set: 1) ; oFlags
				(gEgo get: ((ScriptID 64001 0) get: 1)) ; oInvHandler, ioRope
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 66 410
					loop: 8
					cel: 6
					setMotion: MoveTo 162 304 self
				)
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 125 387
					setMotion: MoveTo 225 320 self
				)
			)
			(1)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roFahrmHouseExt of TPRoom
	(properties
		picture 11000
		south 10100
	)

	(method (init)
		(super init: &rest)
		(= gnChapter 1)
		(goMusic1 setMusic: 11000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 271 187 272 168 194 184 80 187 99 208 109 242 12 326 155 379 294 306 480 311 597 275 632 232 623 205 587 202 575 207 548 232 504 230 478 226 421 211 391 186 381 184 334 195 303 202
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 0)) ; oFlags
			(voAx init: addHotspotVerb: 1)
		)
		(if (not ((ScriptID 64017 0) test: 1)) ; oFlags
			(voRope init: addHotspotVerb: 1)
		)
		(foSouthExit init:)
		(poDoorExit init:)
		(poSmoke init:)
		(if ((ScriptID 64017 0) test: 0) ; oFlags
			(oBlockPolygon init:)
		else
			(oAxPolygon init:)
		)
		((ScriptID 64018 0) init: normalize: setScaler: Scaler 100 47 287 172) ; oBoogle
		(gEgo init: normalize: setScaler: Scaler 100 50 287 172)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(11100 ; roFahrmHouseInt
				(gEgo posn: 375 235 loop: 5)
				((ScriptID 64018 0) posn: 393 202) ; oBoogle
			)
			(else
				(gGame handsOff:)
				(gCurRoom setScript: soEnter)
			)
		)
	)
)

