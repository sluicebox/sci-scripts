;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7301)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm7301 0
)

(instance rm7301 of ExitRoom
	(properties
		picture 7301
	)

	(method (init)
		(doorExit init:)
		(super init: &rest)
		(if
			(and
				(IsFlag 308)
				(IsFlag 309)
				(IsFlag 305)
				(IsFlag 981)
				(not (IsFlag 615))
			)
			(gEgo
				posn: 271 214
				heading: 135
				sel_737:
				init:
				setScaler: Scaler 54 41 272 221
			)
			(gerde init: cycleSpeed: 9 setScript: fidget)
		else
			(gEgo
				posn: 477 219
				heading: 225
				sel_737:
				init:
				setScaler: Scaler 81 42 318 212
			)
			(wolfgangRitter1 init:)
			(wolfgangRitter2 init:)
			(martinRitter init:)
			(jergen init:)
			(jondoe init:)
		)
		(if (IsFlag 610)
			(roses init:)
		)
	)
)

(instance fidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gerde cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 3 8))
			)
			(2
				(gerde setCycle: Beg self)
			)
			(3
				(= state -1)
				(gerde setLoop: (Random 0 2))
			)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		x 250
		y 97
		BAD_SELECTOR 7312
		BAD_SELECTOR 0
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gCast contains: gerde))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 152 209 32 290 48 291 143 243 163
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance martinRitter of GKFeature
	(properties
		modNum 730
		sightAngle 360
		approachX 270
		approachY 253
		BAD_SELECTOR 7342
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 312 333 74 333 70 312 78 307 76 300 22 280 18 220 2 213 26 192 60 172 100 168 116 175 122 184 162 192 278 208 294 220 276 230 276 302 290 309 296 319 316 333
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolfgangRitter1 of Feature
	(properties
		sightAngle 360
		approachX 374
		approachY 299
	)

	(method (init)
		(self createPoly: 332 199 276 194 284 182 306 175 330 182 334 199)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (gCast contains: gerde)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(cond
			((gCast contains: gerde)
				(switch theVerb
					(76 ; invFourRoses
						(SetFlag 610)
						(gEgo put: 38 get: 72) ; invFourRoses, invCarKeys
						(gSoundManager sel_702: 1)
						(PlayScene 462)
						(roses init:)
					)
					(62 ; Do
						(gCurRoom newRoom: 7321)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			((== theVerb 62) ; Do
				(gCurRoom newRoom: 7321)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wolfgangRitter2 of Feature
	(properties
		sightAngle 360
		approachX 374
		approachY 299
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 321 161 362 165 382 165 388 184 398 192 378 204 378 240 380 247 388 254 388 266 346 297 277 287 275 229 295 219 295 170
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (gCast contains: gerde)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb)
		(wolfgangRitter1 doVerb: &rest)
	)
)

(instance jondoe of GKFeature
	(properties
		modNum 730
		sightAngle 360
		approachX 487
		approachY 262
		x 545
		y 212
		BAD_SELECTOR 7348
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 500 174 469 229 619 250 621 176
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance jergen of GKFeature
	(properties
		modNum 730
		sightAngle 360
		approachX 430
		approachY 238
		x 352
		y 190
		BAD_SELECTOR 7347
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 142 428 156 429 208 441 220 408 239 377 237 376 174 277 169 264 154
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance gerde of Prop
	(properties
		modNum 730
		sightAngle 360
		x 337
		y 271
		priority 400
		fixPriority 1
		view 20460
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 610)
						(= noun 11)
						(super doVerb: theVerb)
					)
					((IsFlag 608)
						(SetFlag 609)
						(= noun 10)
						(super doVerb: theVerb)
					)
					((IsFlag 607)
						(SetFlag 608)
						(= noun 9)
						(super doVerb: theVerb)
					)
					(else
						(SetFlag 607)
						(self setScript: s461)
					)
				)
			)
			(76 ; invFourRoses
				(gSoundManager sel_702: 1)
				(PlayScene 462)
				(SetFlag 610)
				(gEgo put: 38 get: 72) ; invFourRoses, invCarKeys
				(roses init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance s461 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 62 0 0 self 730) ; "(LOOK AT GERDE IN CRYPT AREA, SLIGHTLY SUSPICIOUS)Gerde's here. I wonder what she's up to?"
			)
			(1
				(gSoundManager sel_702: 1)
				(PlayScene 461 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance roses of View
	(properties
		modNum 730
		sightAngle 360
		x 250
		y 206
		priority 400
		fixPriority 1
		view 34612
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 610)
					(gMessager say: 13 62 0 0 0 730) ; "(LOOK AT FRESH ROSES ON COFFIN)Those look better."
				)
				((== gChapter 4)
					(gMessager say: 12 62 0 0 0 730) ; "(LOOK AT ROSES ON WOLFGANG'S COFFIN CH 4)The roses are wilting."
				)
				(else
					(gMessager say: 5 62 0 0 0 730) ; "(LOOK AT ROSES ON COFFIN--CH 2)Roses. I wonder who left them?"
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

