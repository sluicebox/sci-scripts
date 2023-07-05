;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use Plane)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	roStartingLedgeCu 0
)

(instance foBitternutExit of Feature
	(properties
		nsLeft 100
		nsTop 88
		nsRight 318
		nsBottom 264
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soBitternutExit)
	)
)

(instance soBitternutExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 364 163 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 354 153)
				(= cycles 2)
			)
			(3
				((ScriptID 64017 0) set: 86) ; oFlags
				((ScriptID 64017 0) clear: 85) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
			)
		)
	)
)

(instance foClotheslineExit of Feature
	(properties
		nsLeft 520
		nsTop 172
		nsRight 608
		nsBottom 312
		approachX 528
		approachY 182
		x 538
		y 172
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gEgo setScript: soClotheslineExit)
	)
)

(instance soClotheslineExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foClotheslineExit self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 538 172)
				(= cycles 2)
			)
			(2
				((ScriptID 64017 0) clear: 85 86) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
			)
		)
	)
)

(instance foTopExit of Feature
	(properties
		nsLeft 396
		nsTop 43
		nsRight 510
		nsBottom 172
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soTopExit)
	)
)

(instance soTopExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 426 160 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 446 180)
				(= cycles 2)
			)
			(3
				((ScriptID 64017 0) set: 85) ; oFlags
				((ScriptID 64017 0) clear: 86) ; oFlags
				(gCurRoom newRoom: 20100) ; roCliffScroller
			)
		)
	)
)

(instance oTileCU of Plane
	(properties
		picture 21001
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oLedge of Plane
	(properties
		picture 21000
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(foBitternutExit init:)
		(foTopExit init:)
		(foClotheslineExit init:)
	)
)

(instance voBody of View
	(properties
		x 444
		y 311
		loop 4
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= view 20131)
		else
			(= view 20101)
		)
		(super init: &rest)
	)
)

(instance poTorinLooksUp of Prop
	(properties
		x 417
		y 241
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= view 20131)
		else
			(= view 20101)
		)
		(super init: &rest)
	)
)

(instance poTile of Prop
	(properties
		x 281
		y 132
		loop 2
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= view 20131)
		else
			(= view 20101)
		)
		(super init: &rest)
	)
)

(instance poTorinPicksUpTile of Prop
	(properties
		x 380
		y 186
		loop 1
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= view 20131)
		else
			(= view 20101)
		)
		(super init: &rest)
	)
)

(instance soTileFalling of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oTileCU)
				(voBody init:)
				(poTorinLooksUp setCel: 0 init: setPri: 400)
				(poTile setCel: 0 init: hide:)
				(= ticks 60)
			)
			(1
				(goSound1 playSound: 20106)
				(= ticks 30)
			)
			(2
				(poTorinLooksUp setCycle: CT 8 1 self)
			)
			(3
				(= ticks 60)
			)
			(4
				(poTorinLooksUp setCycle: CT 11 1 self)
			)
			(5
				(poTorinLooksUp setCycle: CT 15 1 self)
				(poTile show: setCycle: End self)
				(goSound1 playSound: 20107)
			)
			(6)
			(7
				(poTorinLooksUp setCycle: End self)
			)
			(8
				(= ticks 120)
			)
			(9
				(gCurRoom deleteRoomPlane: oTileCU)
				(gCurRoom addRoomPlane: oLedge)
				(poTorinPicksUpTile setCel: 1 init: cycleSpeed: 9)
				(= ticks 120)
			)
			(10
				(if (== (poTorinPicksUpTile view:) 20131)
					(poTorinPicksUpTile setCel: 11)
					(self cue:)
				else
					(poTorinPicksUpTile setCycle: CT 11 1 self)
				)
			)
			(11
				(poTorinPicksUpTile cycleSpeed: 7 setCycle: CT 24 1 self)
			)
			(12
				(= ticks 60)
			)
			(13
				(poTorinPicksUpTile setCycle: End self)
			)
			(14
				(if ((ScriptID 64017 0) test: 46) ; oFlags
					(gEgo get: ((ScriptID 64001 0) get: 15)) ; oInvHandler, ioStepTile
					((ScriptID 64017 0) set: 47) ; oFlags
				else
					(gEgo get: ((ScriptID 64001 0) get: 14)) ; oInvHandler, ioGuillotineTile
					((ScriptID 64017 0) set: 46) ; oFlags
				)
				(gEgo
					posn: 380 186
					init:
					normalize: 0 60100 7
					stopwalk:
					hide:
				)
				(= cycles 2)
			)
			(15
				(poTorinPicksUpTile dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roStartingLedgeCu of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 20100)
		(Load rsAUDIO 20107)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 261 171 532 228 580 204 457 171 409 164 337 174 318 179 276 171
					yourself:
				)
		)
		(gCurRoom setScript: soTileFalling)
	)

	(method (gimme))
)

