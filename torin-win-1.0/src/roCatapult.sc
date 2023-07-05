;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42100)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use foEExit)
(use Plane)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roCatapult 0
)

(local
	bEgoInBowl
	bCranking
)

(instance foExitToIslandEast of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
		(self setRect: 0 0 20 316)
	)

	(method (doVerb)
		(gEgo setScript: soExitEast)
	)
)

(instance foExitToIslandNorth of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
		(self setRect: 0 296 632 316)
	)

	(method (doVerb)
		(gEgo setScript: soExitNorth)
	)
)

(instance foExitToIslandWest of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
		(self setRect: 612 0 632 316)
	)

	(method (doVerb)
		(gEgo setScript: soExitWest)
	)
)

(instance soExitEast of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath -30 290 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setMotion: PolyPath -30 290) ; oBoogle
				(gEgo setMotion: MoveTo -30 290 self)
			)
			(2
				(= gbCatapultEastSide 1)
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance soExitNorth of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 316 386 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setMotion: PolyPath 316 386) ; oBoogle
				(gEgo setMotion: MoveTo 316 386 self)
			)
			(2
				(= gbCatapultEastSide 1)
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance soExitWest of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 662 290 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setMotion: PolyPath 662 290) ; oBoogle
				(gEgo setMotion: MoveTo 662 290 self)
			)
			(2
				(= gbCatapultEastSide 0)
				(gCurRoom newRoom: 40200) ; roAstheniaIsland
			)
		)
	)
)

(instance voLever of View
	(properties
		x 489
		y 313
		priority 200
		fixPriority 1
		view 42101
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(if bEgoInBowl
			(gEgo setScript: soTryForLever)
			(return)
		)
		(if ((ScriptID 64017 0) test: 142) ; oFlags
			(gEgo setScript: soTriggerCatapult)
		else
			(gEgo setScript: soCockCatapult)
		)
	)
)

(instance poTorin of Prop
	(properties
		x 489
		y 313
		priority 316
		fixPriority 1
	)
)

(instance poCatapult of Prop
	(properties
		x 489
		y 313
		priority 200
		fixPriority 1
		view 42101
		loop 1
	)
)

(instance poBallsLand of Prop
	(properties
		priority 10
		fixPriority 1
		view 42102
	)
)

(instance poTorinLands of Prop
	(properties
		priority 10
		fixPriority 1
		view 42104
	)
)

(instance foLava of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 50)
		(self
			setPolygon:
				((Set new:)
					addToEnd:
						((Polygon new:)
							type: PTotalAccess
							init: 0 140 386 142 386 173 283 172 156 186 0 209
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 2 72 335 71 278 106 2 106
							yourself:
						)
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soThrowBall)
	)
)

(instance foFloor of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 1 225 0 315 631 314 630 250 611 272 460 309 241 194 93 218
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soGetOutOfBowl)
	)
)

(instance poLavaBubble of Prop
	(properties
		priority 2
		fixPriority 1
		view 40200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self hide:)
		(self setScaler: Scaler 100 50 150 97)
		(self setScript: (soRandomBubble new:))
	)
)

(instance soRandomBubble of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(= ticks (Random 30 250))
			)
			(1
				(= register (Random 0 4))
				(= caller (Random 8 15))
				(switch register
					(0)
					(1
						(client x: (+ (client x:) caller))
					)
					(2
						(client x: (- (client x:) caller))
					)
					(3
						(client y: (+ (client y:) 3))
					)
					(4
						(client y: (- (client y:) 3))
					)
				)
				(client
					cel: 0
					loop: (Random 2 4)
					cycleSpeed: (Random 6 10)
					show:
					setCycle: End self
				)
			)
			(2
				(switch register
					(0)
					(1
						(client x: (- (client x:) caller))
					)
					(2
						(client x: (+ (client x:) caller))
					)
					(3
						(client y: (- (client y:) 3))
					)
					(4
						(client y: (+ (client y:) 3))
					)
				)
				(= caller 0)
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance foSpit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 108 249 109 276 106 373 54 414 74 436 101 495 124 584 129 567 134 434 139 0 137
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soLookAtSpit)
	)
)

(instance soLookAtSpit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if bEgoInBowl
					(self cue:)
				else
					(gEgo setHeading: 0 self)
				)
			)
			(1
				(gMessager say: 4 1 0 0 self 40200) ; "That spit of land over there MUST be the way out of here. (PAUSE) The trouble is: you can't get there from here!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foRope of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 51)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 484 184 498 177 505 235 482 241 479 191
					yourself:
				)
		)
	)

	(method (doVerb)
		(gEgo setScript: soCutRope)
	)
)

(instance foCatapultBowl of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 50)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 503 166 543 158 586 171 584 210 552 242 525 240 497 219 494 184
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if bEgoInBowl
					(gEgo setScript: soGetOutOfBowl)
				else
					(gEgo setScript: soJumpInBowl)
				)
			)
			(50 ; ioCannonball1-6
				(gEgo setScript: soPutBallInBowl)
			)
		)
	)
)

(instance soTryForLever of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poTorin
					view: 42104
					loop: 0
					cel: 0
					posn: 489 313
					setCycle: CT 7 1 self
				)
			)
			(1
				(gMessager say: 2 1 3 0 self 40200) ; "There's no way I can reach the release handle from in here!"
			)
			(2
				(poTorin setCycle: End self)
			)
			(3
				(poTorin view: 42103)
				(poTorin loop: 0 cel: (poTorin lastCel:) posn: 453 316)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpInBowl of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 316 280 self)
			)
			(1
				(gGame handsOff:)
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(2
				(gEgo setMotion: PolyPath 489 313 self)
			)
			(3
				(gEgo setHeading: 315 self)
			)
			(4
				(gEgo hide:)
				(poTorin
					view: 42103
					loop: 0
					cel: 0
					posn: 453 316
					init:
					setCycle: End self
				)
			)
			(5
				(= bEgoInBowl 1)
				(foCatapultBowl deleteHotspotVerb: 50)
				(foExitToIslandNorth dispose:)
				(foExitToIslandWest dispose:)
				(foExitToIslandEast dispose:)
				(foLava dispose:)
				(foRope init:)
				(foFloor init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCutRope of TPScript
	(properties)

	(method (changeState newState &tmp nWeight)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 141) ; oFlags
				(goSound1 preload: 42105 42104 42106)
				(((ScriptID 64001 0) get: 34) moveTo: -3) ; oInvHandler, ioKnife
				(poTorin
					view: 42104
					loop: 1
					cel: 0
					posn: 489 313
					setCycle: CT 13 1 self
				)
			)
			(1
				(poCatapult hide:)
				(poTorin setCycle: CT 17 1 self)
			)
			(2
				(poTorin setCycle: CT 13 -1 self)
			)
			(3
				(poTorin setCycle: CT 16 1 self)
			)
			(4
				(poTorin setCycle: End self)
				(goSound1 playSound: 42105)
			)
			(5
				(= ticks 90)
			)
			(6
				(cond
					((> (= nWeight (+ 4 (NumCannonballsOwned) gnBallsInCatapult)) 5)
						(poTorinLands loop: 2 posn: 255 177)
					)
					((== nWeight 5)
						((ScriptID 64017 0) set: 143 142) ; oFlags
						(poTorinLands loop: 3 posn: 166 147)
					)
					(else
						(poTorinLands loop: 4 posn: 86 96)
					)
				)
				(poTorinLands cel: 0 init: setCycle: CT 2 1 self)
			)
			(7
				(if (or (== (poTorinLands loop:) 4) (== (poTorinLands loop:) 2))
					(goSound1 playSound: 42104)
				else
					(goSound1 playSound: 42106)
				)
				(poTorinLands setCycle: End self)
			)
			(8
				(poTorinLands dispose:)
				(cond
					((> (= nWeight (+ 4 (NumCannonballsOwned) gnBallsInCatapult)) 5)
						((ScriptID 64019 0) show: 0 42 4 40200) ; DeathDialog
					)
					((== nWeight 5)
						(gCurRoom newRoom: 40400) ; roSpittinSandCu
						(return)
					)
					(else
						((ScriptID 64019 0) show: 0 42 5 40200) ; DeathDialog
					)
				)
				(poCatapult show:)
				(poTorin dispose:)
				(gEgo posn: 316 280 normalize: 1 60100 4 show:)
				((ScriptID 64018 0) ; oBoogle
					posn: 346 280
					setLoop: 5
					heading: 225
					stopwalk:
					setWander: 1
					show:
				)
				(= bEgoInBowl 0)
				(foCatapultBowl addHotspotVerb: 50)
				(foExitToIslandNorth init:)
				(foExitToIslandWest init:)
				(foExitToIslandEast init:)
				(foLava init:)
				(foRope dispose:)
				(foFloor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetOutOfBowl of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poTorin
					view: 42103
					loop: 1
					cel: 0
					posn: 489 313
					setCycle: End self
				)
			)
			(1
				(poTorin dispose:)
				(gEgo posn: 489 313 normalize: 1 60100 7 show:)
				(gEgo setMotion: PolyPath 316 280 self)
			)
			(2
				(self setScript: (ScriptID 64018 2) self) ; soBoogleOutOfPouch
			)
			(3
				(= bEgoInBowl 0)
				(foCatapultBowl addHotspotVerb: 50)
				(foExitToIslandNorth init:)
				(foExitToIslandWest init:)
				(foExitToIslandEast init:)
				(foLava init:)
				(foRope dispose:)
				(foFloor dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soThrowBall of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 489 313 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 42104)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 42103
					loop: 2
					cel: 0
					posn: 489 313
					init:
					setCycle: CT 15 1 self
				)
			)
			(3
				(goSound1 playSound: 42104)
				(poTorin setCycle: End self)
			)
			(4
				(poTorin dispose:)
				(gEgo show:)
				(if (and gInventItem (IsCannonball gInventItem))
					(gEgo put: gInventItem)
				else
					(gEgo put: (GetHeldCannonball))
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleOutOfTheWay of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 371 292 self)
			)
			(1
				((ScriptID 64018 0) setHeading: 90 self) ; oBoogle
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soCockCatapult of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 489 313 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(goSound1 preload: 42101)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(voLever hide:)
				(poTorin
					view: 42101
					loop: 0
					cel: 0
					posn: 489 313
					init:
					setCycle: CT 4 1 self
				)
			)
			(3
				(= bCranking 1)
				(self cue:)
			)
			(4
				(poCatapult setCycle: End coFinishCrank)
				(goSound1 playSound: 42101)
				(poTorin setCycle: CT 8 1 self)
			)
			(5
				(poCatapult setCycle: 0)
				(poTorin setCycle: CT 10 1 self)
			)
			(6
				(if bCranking
					(poTorin cel: 5)
					(self changeState: 4)
				else
					(poTorin setCycle: End self)
				)
			)
			(7
				(poCatapult view: 42101 loop: 2 cel: 0)
				((ScriptID 64017 0) set: 142) ; oFlags
				(gEgo show:)
				(voLever show:)
				(foCatapultBowl init:)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(poTorin dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coFinishCrank of CueMe
	(properties)

	(method (cue)
		(= bCranking 0)
	)
)

(instance soTriggerCatapult of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 489 313 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(goSound1 preload: 42104 42103)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin view: 42102 loop: 0 cel: 0 init: setCycle: CT 4 1 self)
			)
			(3
				(voLever hide:)
				(poTorin setCycle: CT 8 1 self)
			)
			(4
				(poCatapult view: 42102 loop: 1 cel: 0 setCycle: End self)
				(goSound1 playSound: 42103)
			)
			(5
				(self setScript: soBallsLand self)
			)
			(6
				(poCatapult view: 42101 loop: 1 cel: 0)
				(poTorin setCycle: CT 11 1 self)
			)
			(7
				(voLever show:)
				(poTorin setCycle: End self)
			)
			(8
				((ScriptID 64017 0) clear: 142) ; oFlags
				(gEgo show:)
				(foCatapultBowl dispose:)
				(= gnBallsInCatapult 0)
				(poTorin dispose:)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBallsLand of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 90)
			)
			(1
				(cond
					((not gnBallsInCatapult)
						(self dispose:)
						(return)
					)
					((> gnBallsInCatapult 5)
						(poBallsLand loop: 2 posn: 254 174)
					)
					((== gnBallsInCatapult 5)
						(poBallsLand loop: 3 posn: 154 135)
					)
					(else
						(poBallsLand loop: 4 posn: 82 97)
					)
				)
				(poBallsLand cel: 0 init: setCycle: End self)
				(goSound1 playSound: 42104)
			)
			(2
				(poBallsLand dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soPutBallInBowl of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 489 313 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 42108)
				((ScriptID 64018 0) setScript: soBoogleOutOfTheWay) ; oBoogle
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 42100
					loop: 0
					cel: 0
					init:
					setCycle: CT 12 1 self
				)
			)
			(3
				(goSound1 playSound: 42108)
				(poTorin setCycle: End self)
			)
			(4
				(if (and gInventItem (IsCannonball gInventItem))
					(gEgo put: gInventItem)
				else
					(gEgo put: (GetHeldCannonball))
				)
				(++ gnBallsInCatapult)
				(poTorin dispose:)
				(gEgo normalize: 1 60100 7 show:)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWalkInEast of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: -30 290 setMotion: MoveTo 30 290 self)
				((ScriptID 64018 0) setScript: soBoogleWalkInEast) ; oBoogle
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkInEast of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: -40 290
					setMotion: MoveTo 20 290 self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soWalkInWest of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 662 290 setMotion: MoveTo 600 290 self)
				((ScriptID 64018 0) setScript: soBoogleWalkInWest) ; oBoogle
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleWalkInWest of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 672 290
					setMotion: MoveTo 610 290 self
				)
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance foTrapdoor of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 294 216 439 198 599 255 581 274 459 304
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soLookAtTrapdoor)
	)
)

(instance soLookAtTrapdoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 358 268 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo stopwalk: doit:)
				(FrameOut)
				(gCurRoom addRoomPlane: oTrapdoorCU)
				(self dispose:)
			)
		)
	)
)

(instance foExitCU of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oTrapdoorCU)
	)
)

(instance oTrapdoorCU of Plane
	(properties
		picture 42102
		priority 20
	)

	(method (init)
		((ScriptID 64017 0) set: 140) ; oFlags
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(foExitCU init:)
	)
)

(instance roCatapult of TPRoom
	(properties
		picture 42100
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 40300)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 225 0 315 631 314 630 250 611 272 460 309 241 194 93 218
					yourself:
				)
		)
		(foLava init:)
		(foSpit init:)
		(if ((ScriptID 64017 0) test: 136) ; oFlags
			((ScriptID 64017 0) set: 139) ; oFlags
			(voLever init:)
			(if ((ScriptID 64017 0) test: 142) ; oFlags
				(foCatapultBowl init:)
				(poCatapult view: 42101 loop: 2)
			else
				(poCatapult view: 42101 loop: 1)
			)
			(poCatapult init:)
		else
			(= picture 42101)
			(plane drawPic: 42101)
			(foTrapdoor init:)
		)
		((poLavaBubble new:) posn: 21 158 init:)
		((poLavaBubble new:) posn: 80 179 init:)
		((poLavaBubble new:) posn: 180 155 init:)
		(if (not ((ScriptID 64017 0) test: 136)) ; oFlags
			((poLavaBubble new:) posn: 295 161 init:)
			((poLavaBubble new:) posn: 421 155 init:)
		)
		((poLavaBubble new:) posn: 572 153 init:)
		((poLavaBubble new:) posn: 596 86 init:)
		((poLavaBubble new:) posn: 491 97 init:)
		((poLavaBubble new:) posn: 255 87 init:)
		((poLavaBubble new:) posn: 139 91 init:)
		((poLavaBubble new:) posn: 36 88 init:)
		(foExitToIslandEast init:)
		(foExitToIslandWest init:)
		(foExitToIslandNorth init:)
		(gEgo init: normalize:)
		((ScriptID 64018 0) posn: 30 300 init: normalize:) ; oBoogle
		(switch gPrevRoomNum
			(40200 ; roAstheniaIsland
				(if gbCatapultEastSide
					(gEgo setScript: soWalkInEast)
				else
					(gEgo setScript: soWalkInWest)
				)
			)
			(else
				(gEgo posn: 20 300)
				(gGame handsOn:)
			)
		)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 136) ; oFlags
		(if (GetUnheldCannonball)
			(gEgo get: (GetUnheldCannonball))
		)
	)
)

