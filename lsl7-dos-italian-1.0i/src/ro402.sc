;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	ro402 0
)

(instance ro402 of L7Room
	(properties
		picture 40200
	)

	(method (init)
		(if (== gPrevRoomNum 400) ; ro400
			(gEgo
				posn: 409 428
				normalize: 5
				init:
				setScaler: Scaler 145 50 476 285
			)
		else
			(gEgo
				normalize: 3
				posn: 262 469
				init:
				setScaler: Scaler 145 50 476 285
			)
		)
		(UpdateScreenItem gEgo)
		(super init: &rest)
		(gOMusic1 setMusic: 38000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 26 294 49 418 5 429 3 475 500 477 498 433 367 388 327 400 256 396 217 406 110 342 148 311 70 283
					yourself:
				)
		)
		(if
			(or
				((ScriptID 64017 0) test: 106) ; oFlags
				(not ((ScriptID 64017 0) test: 157)) ; oFlags
				(not ((ScriptID 64017 0) test: 33)) ; oFlags
			)
			(foBallroomDoor init:)
		else
			(foExitBallroom init:)
		)
		(foBackStageDoor init:)
		(foFrieze init:)
		(foNeptune init:)
		(foExit init:)
		(poOcean init:)
		(if ((ScriptID 64017 0) test: 106) ; oFlags
			(if ((ScriptID 64017 0) test: 104) ; oFlags
				(voAfterShowNote init:)
			else
				(voBeforeShowNote init:)
			)
		)
		(gGame handsOn:)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nCenterY 222
		nRange 12
	)
)

(instance poOcean of Prop
	(properties
		priority 1
		x 67
		y 210
		loop 1
		view 40250
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance voBeforeShowNote of View
	(properties
		priority 30
		x 440
		y 391
		loop 2
		view 40250
		fixPriority 1
	)
)

(instance voAfterShowNote of View
	(properties
		priority 30
		x 440
		y 391
		loop 2
		cel 1
		view 40250
		fixPriority 1
	)
)

(instance foExitBallroom of Feature
	(properties
		x 461
		y 265
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 367 377 366 149 556 98 536 432
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soExitToBallroom)
	)
)

(instance foBallroomDoor of Feature
	(properties
		noun 2
		x 446
		y 392
		approachX 423
		approachY 427
	)

	(method (init)
		(if
			(or
				(not ((ScriptID 64017 0) test: 157)) ; oFlags
				(not ((ScriptID 64017 0) test: 33)) ; oFlags
			)
			(= case 3)
		else
			(= case 1)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 367 377 366 149 556 98 536 432
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
		(if (== case 1)
			(self addHotspotVerb: 97)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(gMessager say: 2 1 case 0)
			)
			(97 ; Read
				(if (== case 3)
					(super doVerb: theVerb &rest)
					(return)
				)
				(if ((ScriptID 64017 0) test: 104) ; oFlags
					((ScriptID 64017 0) set: 109) ; oFlags
					(gMessager say: 2 97 2 0) ; "Cher Larry:   After changing the course of world fashion, I'm off to do the late-night talk show circuit! I'm sure you'll derive great satisfaction from knowing you played a tiny part in moi's greatness. If you are ever in Manhattan or Paris (BEAT) feel free to buy some of my clothes.   Yours truly,  Jamie"
				else
					((ScriptID 64017 0) set: 108) ; oFlags
					(gMessager sayRange: 2 97 1 2 3) ; "Larry:   Meet me backstage!  Jamie"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foBackStageDoor of Feature
	(properties
		noun 1
		x 108
		y 279
		approachX 96
		approachY 298
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 285 84 202 134 192 128 300
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(if
					(and
						((ScriptID 64017 0) test: 106) ; oFlags
						(not ((ScriptID 64017 0) test: 104)) ; oFlags
					)
					((ScriptID 64017 0) set: 110) ; oFlags
					(gEgo setScript: soGoBackStage)
				else
					(gMessager say: 1 61 0 0) ; "Never the bashful one, eh, Larry?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soExitToBallroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 423 427 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gCurRoom newRoom: 400) ; ro400
			)
		)
	)
)

(instance soGoBackStage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 1 61 1 0 self) ; "She left these unlocked. Here I come, baby!"
			)
			(3
				(gCurRoom newRoom: 403) ; ro403
				(self dispose:)
			)
		)
	)
)

(instance foExit of Feature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 450 639 450 639 479 0 479
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance foFrieze of Feature
	(properties
		noun 4
		x 454
		y 81
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 309 146 430 16 599 67 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNeptune of Feature
	(properties
		noun 3
		x 209
		y 311
		approachX 151
		approachY 371
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 182 205 186 207 201 223 202 229 168 239 165 240 128 263 96 289 117 300 127 288 146 290 157 299 157 305 168 305 180 315 182 313 241 291 246 257 277 260 285 283 290 285 301 302 306 302 316 311 321 306 353 234 365 239 375 226 386 197 381 174 359 138 344 143 331 156 330 167 323 175 322 176 307 191 293 191 239 183 235 183 228 189 223 191 207 185 204
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

