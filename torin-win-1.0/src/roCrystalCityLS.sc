;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use foEExit)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roCrystalCityLS 0
)

(local
	bBoogleLeft
)

(instance poMeteor of Prop
	(properties
		x 355
		y 105
		priority 1
		fixPriority 1
		view 16001
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self hide: setScript: soMeteor)
	)
)

(instance soMeteor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 300 1000))
			)
			(1
				(poMeteor show: setCycle: End self)
			)
			(2
				(poMeteor dispose:)
			)
		)
	)
)

(instance soTwinkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0 cycleSpeed: (Random 6 45) setCycle: End self)
			)
			(1
				(= ticks (Random 30 200))
				(= state -1)
			)
		)
	)
)

(instance soFlag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0 cycleSpeed: (Random 6 25) setCycle: End self)
			)
			(1
				(= ticks (Random 30 90))
				(= state -1)
			)
		)
	)
)

(instance poStar1 of Prop
	(properties
		x 69
		y 52
		priority 1
		fixPriority 1
		view 16000
		loop 2
	)
)

(instance poStar2 of Prop
	(properties
		x 378
		y 118
		priority 1
		fixPriority 1
		view 16000
		loop 1
	)
)

(instance poStar3 of Prop
	(properties
		x 408
		y 6
		priority 1
		fixPriority 1
		view 16000
		loop 2
	)
)

(instance poStar4 of Prop
	(properties
		x 231
		y 144
		priority 1
		fixPriority 1
		view 16000
		loop 3
	)
)

(instance poStar5 of Prop
	(properties
		x 517
		y 21
		priority 1
		fixPriority 1
		view 16000
		loop 1
	)
)

(instance poStar6 of Prop
	(properties
		x 545
		y 149
		priority 1
		fixPriority 1
		view 16000
		loop 2
	)
)

(instance poLight1 of Prop
	(properties
		x 230
		y 239
		priority 1
		fixPriority 1
		view 16001
		loop 3
		cycleSpeed 100
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poRiver1 of Prop
	(properties
		x 397
		y 218
		priority 1
		fixPriority 1
		view 16001
		loop 4
		cycleSpeed 25
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poRiver2 of Prop
	(properties
		x 144
		y 270
		priority 1
		fixPriority 1
		view 16001
		loop 5
		cycleSpeed 22
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poSmoke of Prop
	(properties
		x 93
		y 223
		priority 1
		fixPriority 1
		view 16001
		loop 7
		cycleSpeed 19
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poFlag of Prop
	(properties
		x 130
		y 195
		priority 1
		fixPriority 1
		view 16001
		loop 6
		cycleSpeed 13
	)
)

(instance soWowCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gMessager say: 0 0 1) ; "No matter how many times I see Crystal City, it's still impressive."
				(self dispose:)
			)
		)
	)
)

(instance soForestExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 365 313 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 464 384 self setPri:)
			)
			(2
				(gCurRoom newRoom: 10100) ; roForestScroll
				(self dispose:)
			)
		)
	)
)

(instance foForestExit of ExitFeature
	(properties
		approachX 464
		approachY 384
		x 475
		y 389
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 298 389 272 450 317 293 319
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soForestExit)
	)
)

(instance foCliffsExit of ExitFeature
	(properties
		approachX 290
		approachY 276
		x 290
		y 276
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 163 627 164 630 269 353 252 239 278 112 315 0 318 0 146
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitToCity)
	)
)

(instance soExitToCity of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(gCurRoom newRoom: 16100) ; roCrystalCityMoat
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: soTorinExitToCity self)
				((ScriptID 64018 0) setScript: soBoogleExitToCity self) ; oBoogle
			)
			(1)
			(2
				(= ticks 180)
			)
			(3
				(gEgo setScript: soTorinWalkSmall self)
				((ScriptID 64018 0) setScript: soBoogleWalkSmall self) ; oBoogle
			)
			(4)
			(5
				(gCurRoom newRoom: 16100) ; roCrystalCityMoat
				(self dispose:)
			)
		)
	)
)

(instance soTorinExitToCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approach: foCliffsExit self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo setLoop: setPri: 5 setMotion: MoveTo 178 470 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTorinWalkSmall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 3
					setScalePercent: 7
					setPri: 5
					xStep: 1
					yStep: 1
					cycleSpeed: 25
					posn: 191 289
					setMotion: MoveTo 165 281 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 163 277 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soBoogleExitToCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< ((ScriptID 64018 0) x:) 279) ; oBoogle
					(= bBoogleLeft 1)
					((ScriptID 64018 0) ; oBoogle
						setWander: 0
						setMotion: PolyPath 215 289 self
					)
				else
					((ScriptID 64018 0) ; oBoogle
						setWander: 0
						setMotion: PolyPath 365 259 self
					)
				)
			)
			(1
				(if bBoogleLeft
					((ScriptID 64018 0) setHeading: 0 self) ; oBoogle
				else
					((ScriptID 64018 0) setHeading: 315 self) ; oBoogle
				)
			)
			(2
				(if bBoogleLeft
					((ScriptID 64018 0) ; oBoogle
						setWander: 0
						setPri: 5
						setLoop:
						setMotion: MoveTo 158 380 self
					)
				else
					((ScriptID 64018 0) ; oBoogle
						setWander: 0
						setPri: 5
						setLoop:
						setMotion: MoveTo 178 380 self
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkSmall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setLoop: 3
					setScalePercent: 7
					setPri: 5
					xStep: 1
					yStep: 1
					cycleSpeed: 25
					posn: 194 290
					setMotion: MoveTo 168 282 self
				)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 163 274 self) ; oBoogle
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEnterFromCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: soTorinEnterFromCity self)
				((ScriptID 64018 0) setScript: soBoogleEnterFromCity self) ; oBoogle
			)
			(1)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinEnterFromCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					normalize:
					posn: 258 365
					setPri: 5
					setLoop: 4 1
					doit:
					setMotion: MoveTo 287 273 self
				)
			)
			(1
				(gEgo setLoop: -1 setPri: -1 setMotion: MoveTo 301 278 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soBoogleEnterFromCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					init:
					normalize:
					setWander: 0
					posn: 334 316
					setPri: 5
					setLoop: 4 1
					setMotion: MoveTo 359 256 self
				)
			)
			(1
				((ScriptID 64018 0) ; oBoogle
					setLoop: -1
					setPri: -1
					setMotion: MoveTo 383 270 self
				)
			)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance coStartMusic of CueObj
	(properties)

	(method (cue)
		(goMusic1 setMusic: 16000)
	)
)

(instance roCrystalCityLS of TPRoom
	(properties
		picture 16000
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 338 266 275 286 205 294 123 321 574 317 569 275 494 267
					yourself:
				)
		)
		(goMusic1 playSound: 16099 coStartMusic)
		(foForestExit init:)
		(foCliffsExit init:)
		(poStar1 init: setScript: (soTwinkle new:))
		(poStar2 init: setScript: (soTwinkle new:))
		(poStar3 init: setScript: (soTwinkle new:))
		(poStar4 init: setScript: (soTwinkle new:))
		(poStar5 init: setScript: (soTwinkle new:))
		(poStar6 init: setScript: (soTwinkle new:))
		(poMeteor init:)
		(poLight1 init:)
		(poRiver1 init:)
		(poRiver2 init:)
		(poSmoke init:)
		(poFlag init: setScript: soFlag)
		(switch gPrevRoomNum
			(16100 ; roCrystalCityMoat
				(gCurRoom setScript: soEnterFromCity)
			)
			(else
				(gEgo
					normalize:
					loop: 3
					posn: 464 384
					init:
					setMotion: MoveTo 365 313 (ScriptID 64020 0) ; oHandsOnWhenCued
				)
				((ScriptID 64018 0) ; oBoogle
					normalize:
					posn: 493 401
					init:
					setWander: 0
					setMotion: MoveTo 411 310 (ScriptID 64018 5) ; oBoogleStartWandering
				)
				(if (not ((ScriptID 64017 0) test: 25)) ; oFlags
					(gCurRoom setScript: soWowCity)
					((ScriptID 64017 0) set: 25) ; oFlags
				)
			)
		)
	)

	(method (dispose)
		(gMessager kill:)
		(super dispose: &rest)
	)
)

