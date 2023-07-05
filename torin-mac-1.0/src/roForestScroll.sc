;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10100)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use ScrollView)
(use foEExit)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roForestScroll 0
)

(local
	egoLoc
	bTest
	nScrollAmt = 9
	nTimeSave
	bScroll
	nFrames
	nVineTouchX
	nVineTouchY
	nVineTouchScale
	bAutoSlug = 1
	bSlugsMunching
)

(procedure (WalkToViaTree nX nY oCueParm &tmp loc oCuee)
	(if (> argc 2)
		(= oCuee oCueParm)
	else
		(= oCuee 0)
	)
	(if (> nX 1614)
		(= loc 2)
	else
		(= loc 0)
	)
	(if (== egoLoc loc)
		(gEgo setMotion: PolyPath nX nY oCuee)
		(return)
	)
	(switch loc
		(0
			(poNull
				setScript:
					(soCrossTreeL destX: nX destY: nY yourself:)
					oCuee
			)
		)
		(2
			(poNull
				setScript:
					(soCrossTreeR destX: nX destY: nY yourself:)
					oCuee
			)
		)
	)
)

(instance poNull of Prop
	(properties)
)

(class soCrossTreeL of TPScript
	(properties
		destX 0
		destY 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== egoLoc 1)
					(self setScript: soJumpToLeftBank self)
				else
					(self setScript: soGoThroughTreeL self)
				)
			)
			(1
				(gGame handsOn:)
				(gEgo setMotion: PolyPath destX destY self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(class soCrossTreeR of TPScript
	(properties
		destX 0
		destY 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== egoLoc 1)
					(self setScript: soJumpToRightBank self)
				else
					(self setScript: soGoThroughTreeR self)
				)
			)
			(1
				(gGame handsOn:)
				(gEgo setMotion: PolyPath destX destY self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance poTorinSwings of Prop
	(properties
		priority 320
		fixPriority 1
		cycleSpeed 8
	)
)

(instance soGoThroughTreeR of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1393 324 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 1393 324 self)
			)
			(2
				(gEgo setHeading: 45 self)
				(goSound1 preload: 10109 10110 10111 10112 10114 10115)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(gEgo bAutoScroll: 0)
			)
			(3)
			(4
				(gEgo hide:)
				(poTorinSwings
					view: 10124
					loop: 0
					cel: 0
					posn: 1630 322
					setPri: 324
					init:
					setCycle: CT 1 1 self
				)
			)
			(5
				(goSound1 playSound: 10108)
				(poTorinSwings setCycle: CT 6 1 self)
			)
			(6
				(goSound1 playSound: 10109)
				(poTorinSwings setCycle: CT 10 1 self)
				((ScriptID 64018 0) setScript: soBoogleCrossR) ; oBoogle
			)
			(7
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 14 1 self)
			)
			(8
				(goSound1 playSound: 10111)
				(poTorinSwings setPri: 245)
				(poTorinSwings setCycle: CT 26 1 self)
			)
			(9
				(goSound1 playSound: 10112)
				(poTorinSwings setCycle: End self)
			)
			(10
				((gCurRoom plane:) panTo: 1614 0 self 1 10 10)
			)
			(11
				(= egoLoc 2)
				(gEgo posn: 1858 245)
				(gEgo setScaler: Scaler 100 87 273 246)
				(gEgo setLoop: 4)
				(gEgo show:)
				(gEgo setAvoider: 0)
				(poTorinSwings dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGoThroughTreeL of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1767 239 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 10110 10112 10119 10120 10121)
				(gEgo setHeading: 315 self)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(gEgo bAutoScroll: 0)
			)
			(2)
			(3
				(gEgo hide:)
				(poTorinSwings
					view: 10126
					loop: 0
					cel: 0
					posn: 1404 303
					setPri: 239
					init:
					setCycle: CT 5 1 self
				)
			)
			(4
				(poTorinSwings setPri: 500)
				((ScriptID 64018 0) setScript: soBoogleCrossL) ; oBoogle
				(poTorinSwings setCycle: CT 27 1 self)
			)
			(5
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 43 1 self)
			)
			(6
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 52 1 self)
			)
			(7
				(poTorinSwings setPri: 308 setCycle: CT 53 1 self)
			)
			(8
				(goSound1 playSound: 10112)
				(poTorinSwings setCycle: End self)
			)
			(9
				((gCurRoom plane:) panTo: 1052 0 self 1 10 10)
			)
			(10
				(= egoLoc 0)
				(gEgo posn: 1402 308)
				(gEgo setScale: 0)
				(gEgo setLoop: 5)
				(gEgo show:)
				(gEgo setAvoider: 0)
				(poTorinSwings dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poBoogleCrosses of Prop
	(properties)
)

(instance soJumpLeftToTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1767 239 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(gEgo bAutoScroll: 0)
			)
			(2)
			(3
				(gEgo hide: posn: 1741 341)
				(poTorinSwings
					view: 10125
					loop: 0
					cel: 0
					posn: 1404 303
					setPri: 239
					init:
					setCycle: End self
				)
			)
			(4
				(= egoLoc 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpRightToTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 1393 324 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 10109 10110 10111)
				(gEgo setMotion: MoveTo 1393 324 self)
			)
			(2
				(gEgo setHeading: 45 self)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(gEgo bAutoScroll: 0)
			)
			(3)
			(4
				(gEgo hide: posn: 1741 341)
				(poTorinSwings
					view: 10123
					loop: 0
					cel: 0
					posn: 1630 322
					setPri: 324
					init:
					setCycle: CT 1 1 self
				)
			)
			(5
				(goSound1 playSound: 10108)
				(poTorinSwings setCycle: CT 6 1 self)
			)
			(6
				(goSound1 playSound: 10109)
				(poTorinSwings setCycle: CT 10 1 self)
				((ScriptID 64018 0) setScript: soBoogleCrossR) ; oBoogle
			)
			(7
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 14 1 self)
			)
			(8
				(goSound1 playSound: 10111)
				(poTorinSwings setCycle: End self)
			)
			(9
				(= egoLoc 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJumpToLeftBank of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(goSound1 preload: 10110 10112 10119 10120 10121)
				(gEgo bAutoScroll: 0)
			)
			(1
				(if (> ((ScriptID 64018 0) x:) 1614) ; oBoogle
					((ScriptID 64018 0) setScript: soBoogleCrossL) ; oBoogle
				)
				(poTorinSwings
					view: 10129
					loop: 0
					cel: 0
					posn: 1404 303
					setPri: 500
					setCycle: CT 14 1 self
				)
			)
			(2
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 30 1 self)
			)
			(3
				(goSound1 playSound: 10110)
				(poTorinSwings setCycle: CT 39 1 self)
			)
			(4
				(poTorinSwings setPri: 308 setCycle: CT 40 1 self)
			)
			(5
				(goSound1 playSound: 10112)
				(poTorinSwings setCycle: End self)
			)
			(6
				((gCurRoom plane:) panTo: 1052 0 self 1 10 10)
			)
			(7
				(= egoLoc 0)
				(gEgo posn: 1402 308)
				(gEgo setScale: 0)
				(gEgo setLoop: 5)
				(gEgo show:)
				(poTorinSwings dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oBoogleSound of TPSound
	(properties)
)

(instance soBoogleCrossL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 1822 280 self)
				(= ticks 360)
			)
			(1
				(= ticks 0)
				((ScriptID 64018 0) setWander: 0) ; oBoogle
				((ScriptID 64018 0) setHeading: 270 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogleCrosses
					view: 10131
					loop: 0
					cel: 0
					posn: 1822 280
					setPri: 300
					init:
					setCycle: CT 9 1 self
				)
			)
			(3
				(oBoogleSound playSound: 10119)
				(poBoogleCrosses setCycle: CT 17 1 self)
			)
			(4
				(oBoogleSound playSound: 10120)
				(poBoogleCrosses setCycle: CT 30 1 self)
			)
			(5
				(oBoogleSound playSound: 10121)
				(poBoogleCrosses setCycle: End self)
			)
			(6
				(poBoogleCrosses dispose:)
				((ScriptID 64018 0) ; oBoogle
					posn: 1432 306
					setLoop: 7
					heading: 315
					show:
					setWander: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance soBoogleCrossR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 1434 301 self)
				(= ticks 360)
			)
			(1
				(= ticks 0)
				((ScriptID 64018 0) setWander: 0) ; oBoogle
				((ScriptID 64018 0) setHeading: 90 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogleCrosses
					view: 10130
					loop: 0
					cel: 0
					posn: 1429 304
					setPri: 300
					init:
					setCycle: CT 4 1 self
				)
			)
			(3
				(oBoogleSound playSound: 10114)
				(poBoogleCrosses setCycle: CT 10 1 self)
			)
			(4
				(oBoogleSound playSound: 10115)
				(poBoogleCrosses setCycle: End self)
			)
			(5
				(poBoogleCrosses dispose:)
				((ScriptID 64018 0) ; oBoogle
					posn: 1855 281
					setLoop: 6
					heading: 45
					show:
					setWander: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance soJumpToRightBank of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom plane:) panTo: 1298 0 self 1 10 10)
				(goSound1 preload: 10112 10114 10115)
				(gEgo bAutoScroll: 0)
			)
			(1
				(if (< ((ScriptID 64018 0) x:) 1614) ; oBoogle
					((ScriptID 64018 0) setScript: soBoogleCrossR) ; oBoogle
				)
				(poTorinSwings
					view: 10128
					loop: 0
					cel: 0
					posn: 1630 322
					setPri: 245
					setCycle: CT 13 1 self
				)
			)
			(2
				(goSound1 playSound: 10112)
				(poTorinSwings setCycle: End self)
			)
			(3
				((gCurRoom plane:) panTo: 1614 0 self 1 10 10)
			)
			(4
				(= egoLoc 2)
				(gEgo setScaler: Scaler 100 87 273 246)
				(gEgo posn: 1858 245)
				(gEgo setLoop: 4)
				(gEgo show:)
				(poTorinSwings dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foRightTreeClimb of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1613 129 1657 118 1718 192 1728 233 1783 249 1784 275 1611 225
				yourself:
			)
		)
	)

	(method (handleEvent)
		(switch egoLoc
			(1
				(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
			)
			(2
				(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
			)
			(0
				(self forceCursor: 0)
			)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb)
		(switch egoLoc
			(1
				(gEgo setScript: soJumpToRightBank)
			)
			(2
				(gEgo setScript: soJumpLeftToTree)
			)
		)
	)
)

(instance foLeftTreeClimb of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1331 187 1509 91 1608 107 1614 179 1607 214 1446 288 1313 256
				yourself:
			)
		)
	)

	(method (handleEvent)
		(switch egoLoc
			(1
				(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
			)
			(0
				(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
			)
			(2
				(self forceCursor: 0)
			)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb)
		(switch egoLoc
			(1
				(gEgo setScript: soJumpToLeftBank)
			)
			(0
				(gEgo setScript: soJumpRightToTree)
			)
		)
	)
)

(instance foCrossTree of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1452 287 1600 223 1805 283 1817 308 1464 314
				yourself:
			)
		)
	)

	(method (handleEvent)
		(switch egoLoc
			(1
				(self forceCursor: 0)
			)
			(0
				(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
			)
			(2
				(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
			)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb)
		(switch egoLoc
			(0
				(gEgo setScript: soGoThroughTreeR)
			)
			(2
				(gEgo setScript: soGoThroughTreeL)
			)
		)
	)
)

(class ApproachFaceHandle of TPScript
	(properties
		bKillRew 0
		destX 0
		destY 0
		verb 0
		oFace 0
	)

	(method (doVerb))

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree destX destY self)
			)
			(1
				(if oFace
					(gEgo face: oFace self)
				else
					(self cue:)
				)
			)
			(2
				(self doVerb: verb)
				(self dispose:)
			)
		)
	)
)

(instance foLeafExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(= nsTop 134)
		(= nsBottom 211)
		(= nsLeft 882)
		(= nsRight 928)
	)

	(method (doVerb)
		(gEgo setScript: soExitToLeaves)
	)
)

(instance foGuardHouseExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
		(= onMeCheck
			((Polygon new:)
				init: 3160 312 2880 312 2682 235 2682 0 3160 0
				yourself:
			)
		)
	)

	(method (doVerb)
		(gEgo setScript: soExitToGuardHouse)
	)
)

(instance foBogExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(self setRect: 1883 122 1924 190)
	)

	(method (doVerb)
		(gEgo setScript: soExitToBog)
	)
)

(instance foFahrmanExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 2 314 2 0 450 0 450 259 278 312
				yourself:
			)
		)
	)

	(method (doVerb)
		(gEgo setScript: soExitToFahrman)
	)
)

(instance foCityExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
		(= nsTop 297)
		(= nsBottom 316)
		(= nsLeft 396)
		(= nsRight 538)
	)

	(method (doVerb)
		(gEgo setScript: soExitToCity)
	)
)

(instance foSnailLedge of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 1631 83 1662 118)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soGoToSnails)
	)
)

(instance soGoToSnails of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== egoLoc 1)
					(self cue:)
				)
				(if (== egoLoc 2)
					(self setScript: soJumpLeftToTree self)
				else
					(self setScript: soJumpRightToTree self)
				)
			)
			(1
				(poTorinSwings
					view: 10127
					posn: 1404 303
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 14000) ; roSnails
				(self dispose:)
			)
		)
	)
)

(instance soExitToGuardHouse of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 2782 268 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExitGuardHouse) ; oBoogle
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo
					setLoop: 6 1
					setPri: 10
					setMotion: MoveTo 2853 436 self
				)
			)
			(3
				((gCurRoom plane:) scrollTo: 3000 0)
				(= ticks 90)
			)
			(4
				(gEgo
					setScaler: 0
					setScalePercent: 15
					setLoop: -1
					setStep: 10 2
					posn: 2870 309
					setMotion: MoveTo 2871 309 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 2938 292 self)
			)
			(6
				(gEgo setMotion: MoveTo 2952 297 self)
			)
			(7
				(gEgo setMotion: MoveTo 2978 279 self)
			)
			(8
				(gEgo setLoop: 2 1 setPri: 4 setMotion: MoveTo 2976 302 self)
			)
			(9
				(= ticks 90)
			)
			(10
				(gEgo
					setScaler: 0
					setScalePercent: 10
					setLoop: -1
					posn: 2864 266
					setMotion: MoveTo 2855 232 self
				)
			)
			(11
				(if ((ScriptID 64017 0) test: 28) ; oFlags
					(gCurRoom newRoom: 15000) ; roGuardHouseExt
				else
					(gCurRoom newRoom: 15800) ; roGuardsHouseLS
				)
			)
		)
	)

	(method (ff)
		(gEgo hide:)
		((ScriptID 64018 0) hide:) ; oBoogle
		(if ((ScriptID 64017 0) test: 28) ; oFlags
			(gCurRoom newRoom: 15000) ; roGuardHouseExt
		else
			(gCurRoom newRoom: 15800) ; roGuardsHouseLS
		)
	)
)

(instance soBoogleExitGuardHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 2762 268 self)
			)
			(1
				(= ticks 5)
			)
			(2
				((ScriptID 64018 0) setMotion: MoveTo 2782 268 self) ; oBoogle
			)
			(3
				((ScriptID 64018 0) setHeading: 45 self) ; oBoogle
			)
			(4
				((ScriptID 64018 0) ; oBoogle
					setLoop: 6 1
					setPri: 10
					setMotion: MoveTo 2853 436 self
				)
			)
			(5
				(= ticks 90)
			)
			(6
				((ScriptID 64018 0) ; oBoogle
					setScaler: 0
					setScalePercent: 15
					setLoop: -1
					setStep: 10 2
					posn: 2870 309
					setMotion: MoveTo 2871 309 self
				)
			)
			(7
				((ScriptID 64018 0) setMotion: MoveTo 2938 292 self) ; oBoogle
			)
			(8
				((ScriptID 64018 0) setMotion: MoveTo 2952 297 self) ; oBoogle
			)
			(9
				((ScriptID 64018 0) setMotion: MoveTo 2978 279 self) ; oBoogle
			)
			(10
				((ScriptID 64018 0) ; oBoogle
					setLoop: 2 1
					setPri: 4
					setMotion: MoveTo 2976 302 self
				)
			)
			(11
				(= ticks 90)
			)
			(12
				((ScriptID 64018 0) ; oBoogle
					setScaler: 0
					setScalePercent: 10
					setLoop: -1
					posn: 2864 266
					setMotion: MoveTo 2855 232 self
				)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance soWalkInFromGuardHouse of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleEnterGuardHouse) ; oBoogle
				(gEgo
					posn: 2853 436
					setLoop: 5 1
					setPri: 10
					setMotion: MoveTo 2782 268 self
				)
			)
			(1
				(gEgo setPri: -1 setLoop: -1 setMotion: MoveTo 2711 264 self)
			)
			(2
				(gEgo setScaler: Scaler 100 87 273 246)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		((ScriptID 64018 0) ; oBoogle
			setScript: 0
			posn: 2731 268
			setPri: -1
			setLoop: -1
			setMotion: 0
			setScaler: 0
			setScale: 0
			setWander: 1
			doit:
		)
		(gEgo
			posn: 2711 264
			setPri: -1
			setLoop: -1
			setMotion: 0
			setScaler: Scaler 100 87 273 246
			doit:
		)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soBoogleEnterGuardHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 2853 436
					setLoop: 5 1
					setPri: 10
				)
				(= ticks 80)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 2782 268 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 2731 268 self
				)
			)
			(3
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soEnterFromLeaves of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleEnterLeaves) ; oBoogle
				(gEgo
					posn: 908 235
					setScaler: Scaler 100 89 269 234
					setLoop: 7
					heading: 315
					doit:
					hide:
				)
				(poTorin
					view: 10108
					loop: 1
					cel: 10
					posn: 908 235
					init:
					setCycle: Beg self
				)
			)
			(1
				(poTorin dispose:)
				(gEgo show: setMotion: MoveTo 890 269 self)
			)
			(2
				(gEgo setScaler: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(poTorin dispose:)
		(gEgo
			show:
			setMotion: 0
			posn: 890 269
			setScaler: 0
			setPri: -1
			setLoop: 2
			heading: 180
			doit:
		)
		((ScriptID 64018 0) ; oBoogle
			setWander: 0
			setMotion: 0
			posn: 870 269
			setScaler: 0
			setPri: -1
			setLoop: 2
			heading: 180
			doit:
			setWander: 1
		)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soBoogleEnterLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 882 240
					setLoop: 6
					heading: 45
					setScaler: Scaler 100 89 269 234
					stopwalk:
					doit:
					setMotion: MoveTo 870 269 self
				)
			)
			(1
				((ScriptID 64018 0) setScaler: 0 setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soExitToLeaves of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 890 269 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExitLeaves) ; oBoogle
				(= bHasFF 1)
				(self setButtons:)
				(gEgo
					setScaler: Scaler 100 89 269 234
					setMotion: MoveTo 908 235 self
				)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(gEgo hide:)
				(poTorin
					view: 10108
					loop: 1
					cel: 0
					posn: 908 235
					init:
					setCycle: CT 10 1 self
				)
			)
			(4
				(gCurRoom newRoom: 12000) ; roLeaves
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo hide:)
		(poTorin view: 10108 loop: 1 cel: 10 posn: 908 235 init:)
		((ScriptID 64018 0) ; oBoogle
			setWander: 0
			posn: 882 240
			setLoop: 6
			heading: 45
			stopwalk:
		)
		(UpdateScreenItem (ScriptID 64018 0)) ; oBoogle
		(UpdateScreenItem poTorin)
		(FrameOut)
		(gCurRoom newRoom: 12000) ; roLeaves
	)
)

(instance soBoogleExitLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 870 269 self)
			)
			(1
				(= ticks 40)
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setScaler: Scaler 100 89 269 234
					setMotion: MoveTo 882 240 self
				)
			)
			(3
				((ScriptID 64018 0) setHeading: 45 self) ; oBoogle
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soEnterFromBog of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleEnterBog) ; oBoogle
				(gEgo
					posn: 1956 176
					setScaler: Scaler 87 50 230 181
					setLoop: 1
					heading: 270
					doit:
					setMotion: MoveTo 1911 180 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 1893 240 self)
			)
			(2
				(gEgo setScaler: Scaler 100 87 273 246 doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			setMotion: 0
			posn: 1893 240
			setScaler: Scaler 100 87 273 246
			setPri: -1
			setLoop: 2
			heading: 180
			doit:
		)
		((ScriptID 64018 0) ; oBoogle
			setWander: 0
			setMotion: 0
			posn: 1893 230
			setScaler: 0
			setPri: -1
			setLoop: 2
			heading: 180
			doit:
			setWander: 1
		)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soBoogleEnterBog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 1956 176
					setScaler: Scaler 87 50 230 181
					setLoop: 1
					heading: 270
					doit:
				)
				(= ticks 40)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 1911 180 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setMotion: MoveTo 1893 230 self) ; oBoogle
			)
			(3
				((ScriptID 64018 0) setScaler: 0 doit: setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soExitToBog of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 1893 230 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExitBog) ; oBoogle
				(= bHasFF 1)
				(self setButtons:)
				(gEgo
					setScaler: Scaler 87 50 230 181
					setMotion: MoveTo 1911 180 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 1956 176 self)
			)
			(3
				(gCurRoom newRoom: 13000) ; roBog
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo hide:)
		((ScriptID 64018 0) hide:) ; oBoogle
		(FrameOut)
		(gCurRoom newRoom: 13000) ; roBog
	)
)

(instance soBoogleExitBog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 1893 240 self)
			)
			(1
				(= ticks 40)
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setScaler: Scaler 87 50 230 181
					setMotion: MoveTo 1911 180 self
				)
			)
			(3
				((ScriptID 64018 0) setMotion: MoveTo 1956 176 self) ; oBoogle
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soExitToFahrman of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 386 280 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleExitFahrman) ; oBoogle
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo setLoop: 7 1 setPri: 5 setMotion: MoveTo 301 452 self)
			)
			(3
				((gCurRoom plane:) scrollTo: 0 0)
				(= ticks 90)
			)
			(4
				(gEgo
					setScaler: 0
					setScalePercent: 20
					setLoop: -1
					setStep: 10 2
					posn: 66 347
					setMotion: MoveTo 40 302 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 50 270 self)
			)
			(6
				(gEgo setMotion: MoveTo 91 256 self)
			)
			(7
				(gEgo setMotion: MoveTo 159 253 self)
			)
			(8
				(gCurRoom newRoom: 11000) ; roFahrmHouseExt
			)
		)
	)

	(method (ff)
		(gEgo hide:)
		((ScriptID 64018 0) hide:) ; oBoogle
		(gCurRoom newRoom: 11000) ; roFahrmHouseExt
	)
)

(instance soBoogleExitFahrman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 416 280 self)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 386 280 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setLoop: 7 1
					setPri: 6
					setMotion: MoveTo 301 452 self
				)
			)
			(3
				(= ticks 90)
			)
			(4
				((ScriptID 64018 0) ; oBoogle
					setScaler: 0
					setScalePercent: 20
					setStep: 10 2
					setLoop: -1
					posn: 66 347
					setMotion: MoveTo 40 302 self
				)
			)
			(5
				((ScriptID 64018 0) setMotion: MoveTo 50 270 self) ; oBoogle
			)
			(6
				((ScriptID 64018 0) setMotion: MoveTo 91 256 self) ; oBoogle
			)
			(7
				((ScriptID 64018 0) setMotion: MoveTo 159 253 self) ; oBoogle
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance soWalkInFromFahrman of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleEnterFahrman) ; oBoogle
				(gEgo
					posn: 301 452
					setLoop: 4 1
					setPri: 6
					setMotion: MoveTo 386 280 self
				)
			)
			(1
				(gEgo setPri: -1 setLoop: -1 setMotion: MoveTo 416 280 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		((ScriptID 64018 0) ; oBoogle
			setScript: 0
			posn: 387 280
			setPri: -1
			setLoop: -1
			setMotion: 0
			setWander: 1
		)
		(gEgo posn: 416 280 setPri: -1 setLoop: -1 setMotion: 0)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soBoogleEnterFahrman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 301 452
					setLoop: 4 1
					setPri: 5
				)
				(= ticks 80)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 386 280 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) ; oBoogle
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 387 280 self
				)
			)
			(3
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soExitToCity of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 470 305 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 470 470 self)
				((ScriptID 64018 0) setScript: soBoogleExitCity) ; oBoogle
				(= bHasFF 1)
				(self setButtons:)
			)
			(2
				(gCurRoom newRoom: 16000) ; roCrystalCityLS
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gCurRoom newRoom: 16000) ; roCrystalCityLS
	)
)

(instance soBoogleExitCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 470 289 self)
			)
			(1
				((ScriptID 64018 0) setMotion: MoveTo 470 470 self) ; oBoogle
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soEnterFromCity of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soBoogleEnterCity) ; oBoogle
				(gEgo posn: 470 470 setMotion: MoveTo 470 289 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		((ScriptID 64018 0) ; oBoogle
			setScript: 0
			setMotion: 0
			posn: 473 308
			setPri: -1
			setLoop: 6
			heading: 45
			setWander: 1
		)
		(gEgo posn: 470 289 setMotion: 0 setPri: -1 setLoop: 0 heading: 90)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soBoogleEnterCity of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 470 470
					setMotion: MoveTo 470 308 self
				)
			)
			(1
				((ScriptID 64018 0) setHeading: 45 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance poWater of Prop
	(properties
		x 1438
		y 300
		view 10132
		loop 1
		cycleSpeed 8
	)

	(method (init)
		(self setPri: 30)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance aoBird of Actor
	(properties
		x -100
		y 20
		view 10114
	)

	(method (init)
		(self setPri: 10)
		(super init: &rest)
		(self setCycle: Walk)
		(self setScript: (soFlyRandom new:))
	)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance soFlyRandom of Script
	(properties)

	(method (changeState newState &tmp nStartX nEndX nY)
		(switch (= state newState)
			(0
				(= ticks (Random 400 1000))
			)
			(1
				(if (!= (Random 30 50) 47)
					(= nStartX -100)
					(= nEndX 3260)
				else
					(= nEndX -100)
					(= nStartX 3260)
				)
				(= nY (Random 20 60))
				(client
					setStep: (Random 9 14) 5
					setSpeed: (Random 4 8)
					posn: nStartX nY
					setMotion: MoveTo nEndX nY self
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance voSquareRoot of View
	(properties
		x 2275
		y 260
		view 10120
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
		(self addHotspotVerb: 1 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soThinkAboutRoot)
			)
			(2 ; ioAx
				(gEgo setScript: soChopRoot)
			)
		)
	)
)

(instance soThinkAboutRoot of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 2236 252 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(2
				(gMessager say: 7 1 0 0 self) ; "If you want a square meal, this looks like the root!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soChopRoot of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 64001 0) get: 0) moveTo: -3) ; oInvHandler, ioAx
				(goSound1 preload: 10104)
				(WalkToViaTree 2205 269 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64018 0) setScript: soWaitForChop) ; oBoogle
				(gEgo setHeading: 135 self)
				((gCurRoom plane:) panTo: 1900 0 self 1 10 10)
			)
			(2)
			(3
				(gEgo hide:)
				(poTorinChops cel: 0 loop: 0 init: setCycle: CT 16 1 self)
			)
			(4
				(goSound1 playSound: 10104)
				(poTorinChops setCycle: CT 18 1 self)
			)
			(5
				(voSquareRoot dispose:)
				(poTorinChops setCycle: CT 31 1 self)
			)
			(6
				(voCutRoot init:)
				(poTorinChops setCycle: End self)
			)
			(7
				(poTorinChops dispose:)
				(gEgo posn: 2182 268 normalize: 1 60100 6 stopwalk: show:)
				((ScriptID 64017 0) set: 19) ; oFlags
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(= egoLoc 2)
		(gEgo posn: 2205 269 normalize: 1 60100 4 stopwalk: show:)
		(voCutRoot dispose:)
		(voSquareRoot init:)
		(poTorinChops dispose:)
		((ScriptID 64017 0) unSet: 19) ; oFlags
		(gEgo setScript: self)
	)

	(method (ff)
		(= egoLoc 2)
		(gEgo posn: 2182 268 normalize: 1 60100 6 stopwalk: show:)
		(((ScriptID 64001 0) get: 0) moveTo: -3) ; oInvHandler, ioAx
		(voSquareRoot dispose:)
		(voCutRoot init:)
		(poTorinChops dispose:)
		((ScriptID 64018 0) setWander: 1) ; oBoogle
		((ScriptID 64017 0) set: 19) ; oFlags
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soWaitForChop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(BoogleBoogie 2122 244 self)
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

(instance poTorinChops of Prop
	(properties
		x 2205
		y 269
		view 10107
	)
)

(instance soPickUpRoot of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 2247 254 self)
			)
			(1
				(gGame handsOff:)
				((gCurRoom plane:) panTo: 1900 0 self 1 10 10)
				(gEgo setHeading: 45 self)
			)
			(2)
			(3
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(4
				(gEgo get: ((ScriptID 64001 0) get: 5)) ; oInvHandler, ioSquareRoot
				((ScriptID 64017 0) set: 5) ; oFlags
				(voCutRoot dispose:)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voCutRoot of View
	(properties
		x 2295
		y 247
		view 10120
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soPickUpRoot)
	)
)

(instance foBerryBushes of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 547 181 565 183 577 200 582 197 594 173 583 159 561 156
					yourself:
				)
		)
		(= x 570)
		(= y 222)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 4) ; oFlags
			(gEgo setScript: soThinkAboutBerries)
		else
			(gEgo setScript: soPickUpBerries)
		)
	)
)

(instance soThinkAboutBerries of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo face: foBerryBushes self)
			)
			(1
				(gMessager say: 8 1 6 0 self) ; "I have all the berries I need."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPickUpBerries of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 563 275 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(gMessager say: 8 1 0 0 self) ; "These berries look ripe."
			)
			(3
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(4
				(gEgo get: ((ScriptID 64001 0) get: 4)) ; oInvHandler, ioChuckBerries
				((ScriptID 64017 0) set: 4) ; oFlags
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foLRazorVines1 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= onMeCheck
			((Polygon new:) init: 764 38 880 38 880 223 764 223 yourself:)
		)
	)

	(method (doVerb)
		(= nVineTouchX 942)
		(= nVineTouchY 263)
		(= nVineTouchScale 110)
		(gEgo setScript: soTouchRazorVines)
	)
)

(instance foLRazorVines2 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 909 221 936 201 946 159 927 157 909 129 893 92 914 52 913 32 938 1 971 12 981 31 976 53 998 66 999 103 979 121 973 152 978 177 964 223
				yourself:
			)
		)
	)

	(method (doVerb)
		(= nVineTouchX 1048)
		(= nVineTouchY 262)
		(= nVineTouchScale 110)
		(gEgo setScript: soTouchRazorVines)
	)
)

(instance foLRazorVines3 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1939 221 1977 198 1973 182 1937 162 1943 131 1940 98 1957 59 1960 23 1986 22 1996 45 1981 64 2033 93 2046 132 2032 162 2028 204 1996 228
				yourself:
			)
		)
	)

	(method (doVerb)
		(= nVineTouchX 1999)
		(= nVineTouchY 236)
		(= nVineTouchScale 100)
		(gEgo setScript: soTouchRazorVines)
	)
)

(instance foLRazorVines4 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 2154 224 2148 170 2093 150 2085 130 2130 107 2127 59 2142 42 2143 5 2196 3 2174 34 2217 70 2206 123 2220 151 2188 183 2215 224
				yourself:
			)
		)
	)

	(method (doVerb)
		(= nVineTouchX 2180)
		(= nVineTouchY 239)
		(= nVineTouchScale 100)
		(gEgo setScript: soTouchRazorVines)
	)
)

(instance poTouchRazorVines of Prop
	(properties
		x 880
		y 242
		view 10108
	)
)

(instance soTouchRazorVines of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree nVineTouchX nVineTouchY self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
				(goSound1 preload: 10122)
			)
			(2
				(gEgo hide:)
				(poTouchRazorVines
					setScalePercent: nVineTouchScale
					posn: nVineTouchX nVineTouchY
					cel: 0
					init:
					setCycle: CT 10 1 self
				)
			)
			(3
				(goSound1 playSound: 10122)
				(poTouchRazorVines setCycle: End self)
			)
			(4
				(poTouchRazorVines dispose:)
				(gEgo show:)
				(gMessager say: 1 1 0 0 self) ; "Whoa! These spines are razor-sharp! I'd better be careful."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poSlugs of Prop
	(properties
		x 1026
		y 79
		view 10106
	)

	(method (init)
		(super init: &rest)
		(self setPri: 244)
		(if ((ScriptID 64017 0) test: 15) ; oFlags
			(= loop 1)
		else
			(= loop 0)
		)
	)

	(method (dispose)
		(= bSlugsMunching 0)
		(super dispose: &rest)
	)

	(method (doit &tmp nDistance nBoogleDist)
		(super doit: &rest)
		(if bAutoSlug
			(= nDistance (GetDistance 1004 252 (gEgo x:) (gEgo y:)))
			(if ((ScriptID 64017 0) test: 17) ; oFlags
				(= nBoogleDist 10000)
			else
				(= nBoogleDist
					(GetDistance
						1004
						252
						((ScriptID 64018 0) x:) ; oBoogle
						((ScriptID 64018 0) y:) ; oBoogle
					)
				)
			)
			(cond
				((and (> nDistance 200) (> nBoogleDist 200))
					(if
						(and
							((ScriptID 64017 0) test: 17) ; oFlags
							((ScriptID 64017 0) test: 15) ; oFlags
							(not (poBoogleBoxOverScum script:))
						)
						(poBoogleBoxOverScum setScript: soCatchSlugs)
					)
					(if (or (not cycler) (not (cycler isKindOf: Beg)))
						(= cycleSpeed 7)
						(self setCycle: Beg)
					)
				)
				((or (not cycler) (not (cycler isKindOf: End)))
					(= cycleSpeed 0)
					(self setCycle: End)
				)
			)
		)
		(if (and (== cel 0) ((ScriptID 64017 0) test: 15)) ; oFlags
			(= bSlugsMunching 1)
			((ScriptID 64017 0) set: 16) ; oFlags
		else
			(= bSlugsMunching 0)
		)
	)

	(method (testHotspotVerb)
		(foSlugTree testHotspotVerb: &rest)
	)

	(method (doVerb)
		(foSlugTree doVerb: &rest)
	)
)

(instance foSlugTree of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 1006 0 1060 247)
		(= x 1036)
		(= y 240)
		(self addHotspotVerb: 1 11 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soDealWithSlugTree)
			)
			(11 ; ioMoatScum
				(gEgo setScript: soPutScum)
			)
			(15 ; ioBoogleBox
				(gEgo setScript: soPutBoogleBox)
			)
			(2 ; ioAx
				(gEgo setScript: soAxSlugTree)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soDealWithSlugTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 1300)
					(WalkToViaTree 1300 307 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo face: foSlugTree self)
			)
			(2
				(cond
					(((ScriptID 64017 0) test: 15) ; oFlags
						(if (poSlugs cel:)
							(gMessager say: 2 1 7 0 self) ; "I'm not jumping up there again. I might slip and fall on that scum!"
						else
							(gMessager say: 2 1 8 0 self) ; "They're so fast...this must be their "extra-caffeine" day!"
						)
					)
					((poSlugs cel:)
						(self setScript: soTryToGetSlugs self)
					)
					(else
						(gMessager say: 2 1 1 0 self) ; "Hmmm. That tree is just covered with exotic, high-speed, caffeine-laced slugs."
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soAxSlugTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 1300)
					(WalkToViaTree 1300 307 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo face: foSlugTree self)
			)
			(2
				(gMessager say: 2 2 0 0 self) ; "No, cutting down the whole tree is no way to harvest a few slugs!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soCatchSlugs of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 10102)
				(gEgo setMotion: 0)
				(gEgo face: poBoogleBoxOverScum self)
			)
			(1
				(poSlugs cycleSpeed: 7 setCycle: Beg self)
			)
			(2
				(poBoogleBoxOverScum loop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(3
				(goSound1 playSound: 10102)
				(poSlugs dispose:)
				(voMoatScumOnGround dispose:)
				(foSlugTree dispose:)
				(poBoogleBoxOverScum setCycle: End self)
			)
			(4
				(gCurRoom setScript: soChangeToNormalMusic)
				(gMessager say: 10 15 7 2 self) ; "That's it, Boog! Now we've got 'em. No more caffeine for you guys!"
			)
			(5
				((ScriptID 64017 0) set: 18) ; oFlags
				(gEgo setScript: soPickUpBoogle)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinJumps of Prop
	(properties
		x 991
		y 268
		view 10109
	)
)

(instance soTryToGetSlugs of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 995 266 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 10126)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorinJumps cel: 0 loop: 0 init: setCycle: CT 5 1 self)
			)
			(3
				(goSound1 playSound: 10126)
				(poTorinJumps setCycle: End self)
			)
			(4
				(poTorinJumps dispose:)
				(gEgo posn: 1013 261 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foSlugTrapLoc of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self setRect: 960 242 1002 264)
		(= x 960)
		(= y 256)
		(self addHotspotVerb: 11)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; ioBoogleBox
				(gEgo setScript: soPutBoogleBox)
			)
			(11 ; ioMoatScum
				(gEgo setScript: soPutScum)
			)
		)
	)
)

(instance poPutsScum of Prop
	(properties
		x 1003
		y 249
		view 10110
	)
)

(instance soBoogleWaitForScum of TPScript
	(properties
		bKillRew 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) setWander: 0 setMotion: MoveTo 792 294 self) ; oBoogle
			)
			(1
				((ScriptID 64018 0) setHeading: 90) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soPutScum of TPScript
	(properties
		bHasRew 1
	)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 1003 249 self)
			)
			(1
				(gGame handsOff:)
				(= bHasFF 1)
				(self setButtons:)
				(goSound1 preload: 10101 10124)
				(gEgo setHeading: 215 self)
				((gCurRoom plane:) panTo: 687 0 self 1 10 10)
				(gEgo bAutoScroll: 0)
				((ScriptID 64018 0) setScript: soBoogleWaitForScum) ; oBoogle
				(gCurRoom setScript: soChangeToSlugMusic)
			)
			(2)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 2 11 0 1 self) ; "(FAKE & OBVIOUS) Well, I guess I'll just leave this delicious MOAT scum right here for a while."
			)
			(5
				(gEgo hide:)
				(poPutsScum view: 10110 loop: 0 cel: 0 init: setCycle: End self)
			)
			(6
				(gEgo put: ((ScriptID 64001 0) get: 7) 10100) ; oInvHandler, ioMoatScum
				(voMoatScumOnGround init:)
				((ScriptID 64017 0) set: 15) ; oFlags
				(UnLoad 128 10110)
				(poPutsScum view: 10133 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(gMessager say: 2 11 0 2 self) ; "NOW I'm gonna get you!"
			)
			(8
				(= bAutoSlug 0)
				(poSlugs loop: 1)
				(poSlugs cycleSpeed: 7 setCycle: Beg self)
			)
			(9
				(UnLoad 128 10133)
				(poPutsScum view: 10134 loop: 0 cel: 0 setCycle: CT 8 1 self)
			)
			(10
				(goSound1 playSound: 10124)
				(poPutsScum setCycle: End self)
				(poSlugs cycleSpeed: 3 setCycle: End)
			)
			(11
				(poPutsScum dispose:)
				(gEgo posn: 1189 265 normalize: 1 60100 5 show:)
				(= bAutoSlug 1)
				(foSlugTrapLoc addHotspotVerb: 15)
				(foSlugTree addHotspotVerb: 15)
				(soBoogleWaitForScum cue:)
				(gMessager say: 10 1 11 0 self) ; "Those slugs are so fast, I'll never catch 'em like this. If only I could make a trap...."
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(= egoLoc 0)
		(gEgo
			setMotion: 0
			posn: 1003 249
			setLoop: -1
			setLoop: 5
			heading: 225
			show:
		)
		(poPutsScum dispose:)
		(= bAutoSlug 0)
		(poSlugs loop: 0)
		(poSlugs cel: (poSlugs lastCel:) setCycle: 0)
		(gEgo get: ((ScriptID 64001 0) get: 7)) ; oInvHandler, ioMoatScum
		(voMoatScumOnGround dispose:)
		((ScriptID 64017 0) unSet: 15) ; oFlags
		(gEgo setScript: self)
	)

	(method (ff)
		(= egoLoc 0)
		(voMoatScumOnGround init:)
		(gEgo put: ((ScriptID 64001 0) get: 7) 10100) ; oInvHandler, ioMoatScum
		(poSlugs loop: 1)
		((ScriptID 64017 0) set: 15) ; oFlags
		(poPutsScum dispose:)
		(gEgo
			setMotion: 0
			posn: 1189 265
			setLoop: -1
			setLoop: 5
			heading: 225
			show:
		)
		(= bAutoSlug 1)
		(foSlugTrapLoc addHotspotVerb: 15)
		(foSlugTree addHotspotVerb: 15)
		(soBoogleWaitForScum changeState: 2)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soPutBoogleBox of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 870 248 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 10128 60011)
				(gEgo face: foSlugTree self)
				((gCurRoom plane:) panTo: 600 0 self 1 10 10)
				(gCurRoom setScript: soChangeToSlugMusic)
			)
			(2)
			(3
				(((ScriptID 64001 1) get: 0) moveTo: -3) ; oBoogleHandler, ioBoogleBox
				(gMessager say: 10 15 7 1 self) ; "Boogle? Can you make a box? Right over that moat scum?"
			)
			(4
				(BoogleBoogie 945 245 self)
			)
			(5
				((ScriptID 64018 0) setHeading: 135 self) ; oBoogle
			)
			(6
				((ScriptID 64018 0) setWander: 0 setLoop: 4 hide:) ; oBoogle
				(poBoogleBoxOverScum loop: 0 cel: 0 init: setCycle: CT 8 1 self)
			)
			(7
				(goSound1 playSound: 10128)
				(poBoogleBoxOverScum setCycle: CT 16 1 self)
			)
			(8
				(goSound1 playSound: 60011)
				(poBoogleBoxOverScum setCycle: End self)
			)
			(9
				(foSlugTrapLoc deleteHotspotVerb: 15)
				(foSlugTree deleteHotspotVerb: 15)
				(voMoatScumOnGround deleteHotspotVerb: 15)
				((ScriptID 64017 0) set: 17) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voMoatScumOnGround of View
	(properties
		approachX 920
		approachY 242
		x 1003
		y 249
		view 10122
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 15)
		(self setPri: 20)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTalkAboutScum)
			)
			(15 ; ioBoogleBox
				(gEgo setScript: soPutBoogleBox)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soTalkAboutScum of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 1300)
					(WalkToViaTree 1300 307 self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo face: foSlugTree self)
			)
			(2
				(gMessager say: 10 1 0 0 self) ; "Here's some scum for you, slugs!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poBoogleBoxOverScum of Prop
	(properties
		x 945
		y 245
		view 10111
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soPickUpBoogle)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soBoogleGetsUp of TPScript ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64017 0) clear: 17) ; oFlags
				(poBoogleBoxOverScum cel: 0 loop: 2 setCycle: CT 2 1 self)
			)
			(1
				(goSound1 playSound: 60011)
				(poBoogleBoxOverScum setCycle: End self)
			)
			(2
				(if (foSlugTrapLoc scratch:)
					(foSlugTrapLoc addHotspotVerb: 15)
				)
				(if (foSlugTree scratch:)
					(foSlugTree addHotspotVerb: 15)
				)
				(if (voMoatScumOnGround scratch:)
					(voMoatScumOnGround addHotspotVerb: 15)
				)
				(poBoogleBoxOverScum dispose:)
				((ScriptID 64018 0) show:) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soPickUpBoogle of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkToViaTree 920 242 self)
			)
			(1
				(gGame handsOff:)
				(goSound1 preload: 60011)
				(gEgo face: poBoogleBoxOverScum self)
			)
			(2
				(poBoogleBoxOverScum cel: 0 loop: 2 setCycle: CT 2 1 self)
			)
			(3
				(goSound1 playSound: 60011)
				(poBoogleBoxOverScum setCycle: End self)
			)
			(4
				(if (foSlugTrapLoc scratch:)
					(foSlugTrapLoc addHotspotVerb: 15)
				)
				(if (foSlugTree scratch:)
					(foSlugTree addHotspotVerb: 15)
				)
				(if (voMoatScumOnGround scratch:)
					(voMoatScumOnGround addHotspotVerb: 15)
				)
				(if ((ScriptID 64017 0) test: 18) ; oFlags
					(gEgo get: ((ScriptID 64001 0) get: 10)) ; oInvHandler, ioSlugs
					((ScriptID 64017 0) set: 14) ; oFlags
					(foSlugTree dispose:)
					(foSlugTrapLoc dispose:)
					(gMessager say: 11 1 9 0 self) ; "Thanks, Boogle."
				else
					(= cycles 1)
				)
			)
			(5
				((ScriptID 64017 0) clear: 17) ; oFlags
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					posn: 977 256
					setLoop: 5
					heading: 225
					stopwalk:
					show:
					setWander: 1
				)
				(poBoogleBoxOverScum dispose:)
				(gCurRoom setScript: soChangeToNormalMusic)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poSnails of Prop
	(properties
		x 1650
		y 102
		view 10115
	)

	(method (init)
		(self setScalePercent: 50)
		(super init: &rest)
		(= cycleSpeed 12)
		(self setCycle: RandCycle)
	)
)

(instance oStayInTree of Code ; UNUSED
	(properties)

	(method (doit)
		(if (gEgo mover:)
			(gEgo setMotion: 0)
		)
	)
)

(instance oBrook of TPSound
	(properties)
)

(instance oSlugMunch of TPSound
	(properties)
)

(instance oMoonView of ScrollView
	(properties
		view 10100
	)

	(method (init)
		(super init: &rest)
		(self setPri: 3)
	)
)

(instance oBackView1 of ScrollView
	(properties
		view 10135
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView2 of ScrollView
	(properties
		x 316
		view 10136
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView3 of ScrollView
	(properties
		x 632
		view 10137
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView4 of ScrollView
	(properties
		x 948
		view 10138
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oWoodsScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics &tmp i)
		(for ((= i 0)) (< i 20) ((++ i))
			(AddPicAt self (+ 10100 i) (* i 158) 0)
		)
	)

	(method (addViews)
		(self addScrollView: oMoonView)
		(self addScrollView: oBackView1)
		(self addScrollView: oBackView2)
		(self addScrollView: oBackView3)
		(self addScrollView: oBackView4)
		(oMoonView setScreenSpeed: 0 0)
		(oBackView1 setTotalWidth: 0 1264)
		(oBackView2 setTotalWidth: 0 1264)
		(oBackView3 setTotalWidth: 0 1264)
		(oBackView4 setTotalWidth: 0 1264)
	)
)

(instance soChangeToSlugMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (goMusic1 number:) 10123)
					(self dispose:)
					(return)
				)
				(goMusic1 fadeOut: 6 10 self)
			)
			(1
				(goMusic1 fadeIn: 10123)
				(self dispose:)
			)
		)
	)
)

(instance soChangeToNormalMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (goMusic1 number:) 10100)
					(self dispose:)
					(return)
				)
				(goMusic1 fadeOut: 6 10 self)
			)
			(1
				(goMusic1 fadeIn: 10100)
				(self dispose:)
			)
		)
	)
)

(instance roForestScroll of TPRoom
	(properties)

	(method (init &tmp oPlaneCast)
		(Palette 1 10000) ; PalLoad
		(super init: &rest)
		(= plane (oWoodsScrollPlane init: 3160 (gThePlane getHeight:) yourself:))
		(gEgo init: normalize: setWalkHandler: oScrollerWalkHandler)
		((ScriptID 64018 0) init: normalize:) ; oBoogle
		(foLeafExit init:)
		(foBogExit init:)
		(foGuardHouseExit init:)
		(foFahrmanExit init:)
		(foCityExit init:)
		(foLRazorVines1 init:)
		(foLRazorVines2 init:)
		(foLRazorVines3 init:)
		(foLRazorVines4 init:)
		(foLeftTreeClimb init:)
		(foRightTreeClimb init:)
		(foCrossTree init:)
		(poWater init:)
		((aoBird new:) init:)
		((aoBird new:) init:)
		(if (not ((ScriptID 64017 0) test: 14)) ; oFlags
			(foSlugTree init:)
			(poSlugs init:)
			(foSlugTrapLoc init:)
		else
			(= bSlugsMunching 0)
		)
		(if
			(and
				((ScriptID 64017 0) test: 19) ; oFlags
				(not ((ScriptID 64017 0) test: 5)) ; oFlags
			)
			(voCutRoot init:)
		)
		(if
			(and
				((ScriptID 64017 0) test: 15) ; oFlags
				(not ((ScriptID 64017 0) test: 18)) ; oFlags
			)
			(voMoatScumOnGround init:)
			(foSlugTrapLoc addHotspotVerb: 15)
			(foSlugTree addHotspotVerb: 15)
		)
		(if (not ((ScriptID 64017 0) test: 19)) ; oFlags
			(voSquareRoot init:)
		)
		(if (not ((ScriptID 64017 0) test: 4)) ; oFlags
			(foBerryBushes init:)
		)
		(if (not ((ScriptID 64017 0) test: 6)) ; oFlags
			(foSnailLedge init:)
			(poSnails init:)
		)
		(goMusic1 setMusic: 10100)
		(oBrook relVolPercent: 0 init: setAmbient: 10106)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1454 310 1447 293 1386 290 1260 261 1291 246 1216 239 1155 231 1063 255 974 252 915 260 873 259 760 242 696 244 399 271 338 291 393 313
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 1888 303 1933 293 1949 255 2143 243 2150 270 2228 289 2430 247 2630 280 2828 285 2755 255 2656 249 2528 216 2289 214 2222 233 2041 232 1956 239 1902 222 1797 212 1778 214 1744 223 1761 231 1827 235 1850 251 1825 274 1847 282
					yourself:
				)
		)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(11000 ; roFahrmHouseExt
				(= egoLoc 0)
				(gEgo setScript: soWalkInFromFahrman)
			)
			(16000 ; roCrystalCityLS
				(= egoLoc 0)
				(gEgo setScript: soEnterFromCity)
			)
			(12000 ; roLeaves
				(plane scrollTo: 632 0)
				(= egoLoc 0)
				(gEgo setScript: soEnterFromLeaves)
			)
			(13000 ; roBog
				(plane scrollTo: 1600 0)
				(= egoLoc 2)
				(gEgo setScript: soEnterFromBog)
			)
			(15800 ; roGuardsHouseLS
				(plane scrollTo: 3000 0)
				(= egoLoc 2)
				(gEgo setScript: soWalkInFromGuardHouse)
			)
			(15000 ; roGuardHouseExt
				(plane scrollTo: 3000 0)
				(= egoLoc 2)
				(gEgo setScript: soWalkInFromGuardHouse)
			)
			(14000 ; roSnails
				(gEgo posn: 1741 341)
				((ScriptID 64018 0) posn: 1858 245) ; oBoogle
				(gEgo hide:)
				(poTorinSwings view: 10123 posn: 1630 322 loop: 0)
				(poTorinSwings cel: (poTorinSwings lastCel:) init:)
				(plane scrollTo: 1298 0)
				(= egoLoc 1)
			)
			(else
				(gEgo posn: 420 285 normalize: 1 60100 4)
				((ScriptID 64018 0) ; oBoogle
					posn: 460 285
					setLoop: 4
					heading: 135
					stopwalk:
				)
				(= egoLoc 0)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
		(gEgo get: ((ScriptID 64001 0) get: 7)) ; oInvHandler, ioMoatScum
		((ScriptID 64017 0) set: 30) ; oFlags
		(gEgo get: ((ScriptID 64001 0) get: 0)) ; oInvHandler, ioAx
	)

	(method (doit &tmp nTicks nDist nSlugDist nSlugVol)
		(super doit: &rest)
		(= nDist (Abs (- 1600 (gEgo x:))))
		(oBrook setRelVol: (Max 0 (- 100 (/ nDist 10))))
		(if
			(and
				(>
					(= nSlugDist (Max 0 (- (Abs (- 984 (gEgo x:))) 100)))
					150
				)
				(== (goMusic1 number:) 10123)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: soChangeToNormalMusic)
		)
		(if bSlugsMunching
			(if (== (= nSlugVol (Max 0 (- 100 (/ nSlugDist 5)))) 0)
				(oSlugMunch setAmbient: 0)
			else
				(oSlugMunch setRelVol: nSlugVol)
				(oSlugMunch setAmbient: 10101)
			)
		else
			(oSlugMunch setAmbient: 0)
		)
		(if bScroll
			(plane scroll: nScrollAmt 0)
			(++ nFrames)
			(if (== (plane nCurPosX:) (plane nScrollMaxX:))
				(= nTicks (- gGameTime nTimeSave))
				(= bScroll 0)
				(plane scrollTo: 0 0)
			)
		)
	)
)

(instance oScrollerWalkHandler of Code
	(properties)

	(method (doit nX nY)
		(WalkToViaTree nX nY)
	)
)

