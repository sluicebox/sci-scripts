;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20100)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use ScrollView)
(use n64896)
(use foEExit)
(use Talker)
(use Scaler)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	roCliffScroller 0
)

(local
	oContainerPolygon
	nLocation = 1
	nFallCounter
	bStartMeatFalling = 1
	nMeatTerminalVelocity = 10
	oBasketPolygon
	oRiverPolygon
	bBoogleInPouch = 1
	bVulturesPosed
)

(procedure (EnterStartingLedge)
	(= nLocation 1)
	(gEgo setScaler: Scaler 60 60 1 0)
	(gEgo setPri: 45)
	(foStartingLedgeToTopLedge init:)
	(foStartingLedgeToBitternut init:)
	(foStartingLedgeToClotheslineLedge init:)
	(if (not ((ScriptID 64017 0) test: 47)) ; oFlags
		(foStepTileFromBelow init:)
	)
	(= oContainerPolygon
		((Polygon new:)
			type: PContainedAccess
			init: 82 465 180 465 206 470 206 468 180 463 82 463
			yourself:
		)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitStartingLedge)
	(if (== nLocation 1)
		(foStartingLedgeToTopLedge dispose:)
		(foStartingLedgeToBitternut dispose:)
		(foStartingLedgeToClotheslineLedge dispose:)
		(foStepTileFromBelow dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterTopLedge)
	(= nLocation 2)
	(foTopLedgeToStartingLedge init:)
	(if (not ((ScriptID 64017 0) test: 47)) ; oFlags
		(foStepTile init:)
	)
	(gEgo setPri: 25)
	(= oContainerPolygon
		((Polygon new:) type: PContainedAccess init: 62 316 62 319 102 319 102 316 yourself:)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitTopLedge)
	(if (== nLocation 2)
		(foTopLedgeToStartingLedge dispose:)
		(foStepTile dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterClotheslineLedge)
	(= nLocation 3)
	(foBridgeDoor init:)
	(foClotheslineLedgeToStartingLedge init:)
	(foClotheslineLedgeToDragon init:)
	(foVeder init:)
	(voSplash init:)
	(if (not ((ScriptID 64017 0) test: 77)) ; oFlags
		(foBasket init:)
		(oWashing fadeIn: 20122 6 10 0 1)
	)
	(if (not ((ScriptID 64017 0) test: 55)) ; oFlags
		(foClothesline init:)
	)
	(gEgo setScaler: Scaler 70 50 921 720)
	(gEgo setPri: 65)
	(= oContainerPolygon
		((Polygon new:)
			type: PContainedAccess
			init: 0 720 0 899 158 899 218 888 189 822 215 812 148 785 128 785 107 780 98 763 111 753 140 753 175 775 198 775 222 765 188 765 80 722
			yourself:
		)
	)
	(= oBasketPolygon
		((Polygon new:) type: PBarredAccess init: 9 750 11 730 53 730 54 748 yourself:)
	)
	(= oRiverPolygon
		((Polygon new:)
			type: PTotalAccess
			init: -3 808 13 808 0 803 0 798 22 795 76 795 97 792 43 785 24 777 24 773 40 766 18 761 31 753 131 740 139 742 79 755 90 765 57 772 102 785 131 794 121 800 39 809 39 815 62 821 -2 825
			yourself:
		)
	)
	(gTheDoits add: oSplashTest)
	(gCurRoom addObstacle: oContainerPolygon oBasketPolygon)
	(if (not ((ScriptID 64017 0) test: 79)) ; oFlags
		(gCurRoom setScript: soBoogleGetsWashed)
		(oCliffScrollPlane panTo: 0 587 soBoogleGetsWashed 1)
	else
		(oCliffScrollPlane panTo: 0 587 0 1)
	)
)

(procedure (ExitClotheslineLedge)
	(if (== nLocation 3)
		(oWashing fadeOut:)
		(foBasket dispose:)
		(foVeder dispose:)
		(foClothesline dispose:)
		(foBridgeDoor dispose:)
		(voSplash dispose:)
		(foClotheslineLedgeToStartingLedge dispose:)
		(foClotheslineLedgeToDragon dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		((gCurRoom obstacles:) delete: oBasketPolygon)
		(oContainerPolygon dispose:)
		(oBasketPolygon dispose:)
		(oRiverPolygon dispose:)
		(gTheDoits delete: oSplashTest)
	)
	(= nLocation 0)
)

(procedure (EnterBridge)
	(= nLocation 4)
	(foPalaceDoor init:)
	(foBridgeToClotheslineLedge init:)
	(gEgo setScaler: Scaler 33 33 1 0)
	(gEgo setPri: 35)
	(= oContainerPolygon
		((Polygon new:) type: PContainedAccess init: 244 519 578 519 578 516 244 516 yourself:)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitBridge)
	(if (== nLocation 4)
		(foPalaceDoor dispose:)
		(foBridgeToClotheslineLedge dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterDragonLedge)
	(= nLocation 5)
	(gEgo setScaler: Scaler 60 60 1 0)
	(gEgo setPri: 85)
	(foDragonToClotheslineLedge init:)
	(foDragonCave init:)
	(foDragonToVultures init:)
	(foRockOverVultures init:)
	(= oContainerPolygon
		((Polygon new:)
			type: PContainedAccess
			init: 0 1262 0 1277 32 1274 126 1280 128 1262
			yourself:
		)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitDragonLedge)
	(if (== nLocation 5)
		(foDragonToClotheslineLedge dispose:)
		(foDragonCave dispose:)
		(foDragonToVultures dispose:)
		(foRockOverVultures dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterVultureLedge)
	(= nLocation 6)
	(gEgo setScaler: Scaler 60 60 1 0)
	(gEgo setPri: 95)
	(foVulturesToDragon init:)
	(if (== (voTree view:) 20129)
		(voTree forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	else
		(voTree addHotspotVerb: 36)
	)
	(if ((ScriptID 64017 0) test: 76) ; oFlags
		(foVulturesToLeap init:)
		(= oContainerPolygon
			((Polygon new:)
				type: PContainedAccess
				init: 0 1533 27 1586 189 1552 233 1570 197 1545 267 1532 267 1527 54 1544 48 1533
				yourself:
			)
		)
	else
		(foVultures init:)
		(foWalkByVultures init:)
		(= oContainerPolygon
			((Polygon new:)
				type: PContainedAccess
				init: 0 1533 -3 1571 29 1586 144 1558 143 1542 59 1545 45 1532
				yourself:
			)
		)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitVultureLedge)
	(if (== nLocation 6)
		(goMusic1 fade: 0 10 9 1)
		(foVulturesToDragon dispose:)
		(voTree forceCursor: 0)
		(voTree deleteHotspotVerb: 36)
		(foVulturesToLeap dispose:)
		(foWalkByVultures dispose:)
		(foVultures dispose:)
		(foVulturesForward dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterLeapLedge)
	(= nLocation 7)
	(foLeapLedgeToVultures init:)
	(foLeapAcrossRight init:)
	(= oContainerPolygon
		((Polygon new:)
			type: PContainedAccess
			init: 290 1339 290 1342 354 1342 354 1339
			yourself:
		)
	)
	(gEgo setPri: 85)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitLeapLedge)
	(if (== nLocation 7)
		(foLeapLedgeToVultures dispose:)
		(foLeapAcrossRight dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(procedure (EnterSkunkLedge)
	(= nLocation 8)
	(gEgo setScaler: Scaler 46 46 1 0)
	(gEgo setPri: 85)
	(foClimbToSeraglio init:)
	(foLeapAcrossLeft init:)
	(foSkunkCave init:)
	(= oContainerPolygon
		((Polygon new:)
			type: PContainedAccess
			init: 523 1295 489 1297 628 1296 628 1293
			yourself:
		)
	)
	(gCurRoom addObstacle: oContainerPolygon)
)

(procedure (ExitSkunkLedge)
	(if (== nLocation 8)
		(foClimbToSeraglio dispose:)
		(foSkunkCave dispose:)
		(foLeapAcrossLeft dispose:)
		((gCurRoom obstacles:) delete: oContainerPolygon)
		(oContainerPolygon dispose:)
	)
	(= nLocation 0)
)

(instance foStartingLedgeToBitternut of Feature
	(properties
		nsTop 446
		nsRight 82
		nsBottom 525
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soStartingLedgeToBitternut)
	)
)

(instance soStartingLedgeToBitternut of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 88 463 self)
			)
			(1
				(gGame handsOff:)
				(ExitStartingLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo setLoop: 7 1)
				(gEgo setMotion: MoveTo 51 514 self)
			)
			(3
				(gEgo setLoop: -1)
				(gEgo setMotion: MoveTo 18 518 self)
			)
			(4
				(gEgo setHeading: 0 self)
			)
			(5
				(gCurRoom newRoom: 20200) ; roBitternuts
			)
		)
	)

	(method (ff)
		(gEgo setLoop: -1)
		(gCurRoom newRoom: 20200) ; roBitternuts
	)
)

(instance foStartingLedgeToClotheslineLedge of Feature
	(properties
		nsLeft 194
		nsTop 420
		nsRight 230
		nsBottom 511
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soStartingLedgeToClotheslineLedge)
	)
)

(instance soStartingLedgeToClotheslineLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 200 468 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(ExitStartingLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setLoop: 3 1)
				(gEgo setScaler: Scaler 50 60 480 468)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo 200 480 self)
			)
			(4
				(gEgo setLoop: -1)
				(gEgo setMotion: DPath 210 532 134 578 self)
			)
			(5
				(gEgo setScaler: Scaler 50 50 1 0)
				(= cycles 2)
			)
			(6
				(gEgo setMotion: DPath 72 600 34 609 -32 662 self)
			)
			(7
				(gEgo setMotion: MoveTo 18 724 self)
			)
			(8
				(gEgo setHeading: 180 self)
			)
			(9
				(gGame handsOn:)
				(EnterClotheslineLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo normalize: 1 60100 2 posn: 18 724 setMotion: 0)
		(gGame handsOn:)
		(EnterClotheslineLedge)
		(self dispose:)
	)
)

(instance foStartingLedgeToTopLedge of Feature
	(properties
		nsLeft 118
		nsTop 372
		nsRight 184
		nsBottom 456
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gEgo setScript: soStartingLedgeToTopLedge 0 0)
	)
)

(instance foStepTileFromBelow of Feature
	(properties
		nsLeft 90
		nsTop 326
		nsRight 104
		nsBottom 340
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soStartingLedgeToTopLedge 0 1)
	)
)

(instance soStartingLedgeToTopLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 140 463 self)
			)
			(1
				(gGame handsOff:)
				(ExitStartingLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setScaler: Scaler 60 40 463 374)
				(= cycles 2)
			)
			(2
				(gEgo setMotion: MoveTo 172 420 self)
			)
			(3
				(gEgo setPri: 25)
				(gEgo setMotion: MoveTo 144 374 self)
			)
			(4
				(gEgo setScaler: Scaler 40 62 374 316)
				(= cycles 2)
			)
			(5
				(gEgo setHeading: 225 self)
			)
			(6
				(gEgo setLoop: 5 1)
				(gEgo setMotion: MoveTo 96 316 self)
			)
			(7
				(gEgo setLoop: 2 0)
				(EnterTopLedge)
				(if register
					(gEgo approachThenFace: foStepTile self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(8
				(if register
					(foStepTile doVerb: 1)
				)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 2
			posn: 96 316
			setScaler: Scaler 40 62 374 316
			setPri: 25
			setMotion: 0
		)
		(EnterTopLedge)
		(if register
			(foStepTile doVerb: 1)
		else
			(gGame handsOn:)
		)
		(self dispose:)
	)
)

(instance foTopLedgeToStartingLedge of Feature
	(properties
		nsLeft 108
		nsTop 309
		nsRight 184
		nsBottom 412
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soTopLedgeToStartingLedge)
	)
)

(instance foStepTile of Feature
	(properties
		nsLeft 90
		nsTop 326
		nsRight 104
		nsBottom 340
		approachX 96
		approachY 316
		x 96
		y 321
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self approachVerbs: 1) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTorinGrabsTile)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTorinGrabsTile of Prop
	(properties
		x 72
		y 317
		view 20100
		loop 1
	)
)

(instance soTorinGrabsTile of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 72 317 self)
			)
			(1
				(gEgo hide:)
				(poTorinGrabsTile setCel: 0 init: setCycle: CT 6 1 self)
			)
			(2
				(goSound1 playSound: 15008 self)
			)
			(3
				(oCliffScrollPlane panTo: 0 156 self 1)
			)
			(4
				(poTorinGrabsTile setCycle: End self)
				(gMessager say: 0 0 6 1 self) ; "(AS TORIN LEANS OVER CLIFF SIDE) WHOA!!"
			)
			(5)
			(6
				(gMessager say: 3 1 2 2 self 12000) ; "Oh, not again!"
			)
			(7
				(voStepTile dispose:)
				(poTileFalls
					posn: 98 321
					setCel: 0
					loop: 3
					init:
					setCycle: CT 2 1 self
				)
			)
			(8
				(gCurRoom newRoom: 21000) ; roStartingLedgeCu
			)
		)
	)
)

(instance soTopLedgeToStartingLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 96 316 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gGame handsOff:)
				(ExitTopLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setScaler: Scaler 40 62 374 316)
				(= cycles 2)
			)
			(3
				(gEgo setLoop: 6 1)
				(gEgo setMotion: MoveTo 144 374 self)
			)
			(4
				(gEgo setLoop: -1)
				(gEgo setScaler: Scaler 60 40 463 374)
				(= cycles 2)
			)
			(5
				(gEgo setMotion: MoveTo 172 420 self)
			)
			(6
				(gEgo setPri: 45)
				(gEgo setMotion: MoveTo 140 463 self)
			)
			(7
				(EnterStartingLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo normalize: 1 60100 5 posn: 140 463 setPri: 45 setMotion: 0)
		(EnterStartingLedge)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance foBridgeDoor of Feature
	(properties
		nsLeft 54
		nsTop 640
		nsRight 114
		nsBottom 720
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soBridgeDoor)
	)
)

(instance soWaitForBoogle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 91 812 self)
			)
			(1
				(if ((ScriptID 64017 0) test: 79) ; oFlags
					(self cue:)
				else
					(= state 0)
					(= cycles 2)
				)
			)
			(2
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soBridgeDoor of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if bBoogleInPouch
					(self cue:)
				else
					(= bBoogleInPouch 1)
					(self setScript: soWaitForBoogle self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 74 724 self)
			)
			(2
				(gGame handsOff:)
				(ExitClotheslineLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setPri: 35)
				(gEgo setMotion: DPath 196 652 134 602 self)
			)
			(3
				(gEgo setScaler: Scaler 33 33 1 0)
				(gEgo setMotion: MoveTo 160 516 self)
			)
			(4
				(gEgo setMotion: MoveTo 300 516 self)
			)
			(5
				(EnterBridge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 0
			setPri: 35
			setScaler: Scaler 33 33 1 0
			posn: 300 516
			setMotion: 0
		)
		(EnterBridge)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance foClotheslineLedgeToStartingLedge of Feature
	(properties
		nsTop 624
		nsRight 50
		nsBottom 720
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soClotheslineLedgeToStartingLedge)
	)
)

(instance soClotheslineLedgeToStartingLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if bBoogleInPouch
					(self cue:)
				else
					(= bBoogleInPouch 1)
					(self setScript: soWaitForBoogle self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 18 724 self)
			)
			(2
				(gGame handsOff:)
				(ExitClotheslineLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setPri: 45)
				(gEgo setMotion: MoveTo -32 662 self)
			)
			(3
				(gEgo setMotion: DPath 34 609 72 600 134 578 self)
			)
			(4
				(gEgo setScaler: Scaler 50 60 480 468)
				(= cycles 2)
			)
			(5
				(gEgo setMotion: DPath 210 532 200 480 self)
			)
			(6
				(gEgo setLoop: 2 1)
				(gEgo setMotion: MoveTo 200 468 self)
			)
			(7
				(gEgo setLoop: 2 0)
				(EnterStartingLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 2
			setPri: 45
			setScaler: Scaler 60 60 1 0
			posn: 200 468
			setMotion: 0
		)
		(EnterStartingLedge)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance foClotheslineLedgeToDragon of Feature
	(properties
		nsLeft 206
		nsTop 832
		nsRight 284
		nsBottom 938
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soClotheslineLedgeToDragon)
	)
)

(instance soClotheslineLedgeToDragon of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if bBoogleInPouch
					(self cue:)
				else
					(= bBoogleInPouch 1)
					(self setScript: soWaitForBoogle self)
				)
			)
			(1
				(gEgo setMotion: PolyPath 204 816 self)
			)
			(2
				(gGame handsOff:)
				(ExitClotheslineLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setScaler: Scaler 60 60 1 0)
				(gEgo setPri: 55)
				(gEgo setMotion: MoveTo 272 936 self)
			)
			(3
				(gEgo setPri: 65)
				(gEgo
					setMotion: DPath 240 1010 150 1047 202 1154 246 1195 self
				)
			)
			(4
				(gEgo setPri: 85)
				(gEgo setMotion: MoveTo 126 1280 self)
			)
			(5
				(gGame handsOn:)
				(EnterDragonLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 5
			setPri: 85
			setScaler: Scaler 60 60 1 0
			posn: 126 1280
			setMotion: 0
		)
		(gGame handsOn:)
		(EnterDragonLedge)
		(self dispose:)
	)
)

(instance voClothespin of View
	(properties
		x 68
		y 846
		view 20117
	)
)

(instance foClothesline of Feature
	(properties
		nsLeft 63
		nsTop 841
		nsRight 74
		nsBottom 855
		approachX 84
		approachY 899
		x 84
		y 900
	)

	(method (init)
		(super init: &rest)
		(if (not ((ScriptID 64017 0) test: 55)) ; oFlags
			(self addHotspotVerb: 1)
		)
		(self approachVerbs: 1) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeClothespin)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTakeClothespin of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(1
				(gEgo get: ((ScriptID 64001 0) get: 23)) ; oInvHandler, ioClothespin
				((ScriptID 64017 0) set: 55) ; oFlags
				(voClothespin dispose:)
				(foClothesline deleteHotspotVerb: 1)
			)
			(2
				(gMessager say: 6 1 0 0 self) ; "Someone left this clothespin just hanging here."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foBasket of Feature
	(properties
		nsLeft 100
		nsTop 751
		nsRight 173
		nsBottom 780
		approachX 186
		approachY 771
		x 185
		y 772
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 29)
		(self approachVerbs: 2 1) ; ioAx, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 9 1 12 0) ; "(CHEERFULLY) Hello."
			)
			(29 ; ioWarningTile
				(gEgo setScript: soWashTile)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTorinAndTile of Prop
	(properties
		x 186
		y 771
		view 20107
	)
)

(instance soWashTile of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(poTorinAndTile setLoop: 0 setCel: 0 init: setCycle: End self)
			)
			(1
				(gEgo put: ((ScriptID 64001 0) get: 19)) ; oInvHandler, ioWarningTile
				((ScriptID 64017 0) set: 77) ; oFlags
				(= ticks
					(*
						2
						(+ 1 (poWasherLady lastCel:))
						(poWasherLady cycleSpeed:)
					)
				)
			)
			(2
				(poTorinAndTile setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo get: ((ScriptID 64001 0) get: 33)) ; oInvHandler, ioCleanTile
				((ScriptID 64017 0) set: 64) ; oFlags
				(poTorinAndTile dispose:)
				(foBasket dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poWasherLady of Prop
	(properties
		x 149
		y 777
		view 20125
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(self setPri: 65)
	)
)

(instance poBoogleGetsWashed of Prop
	(properties
		view 20126
	)
)

(instance soBoogleGetsWashed of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= bBoogleInPouch 0)
			)
			(1
				(self setScript: (ScriptID 64018 2) self) ; soBoogleOutOfPouch
			)
			(2
				(gGame handsOn:)
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					setPri: 65
					show:
					setMotion: PolyPath 196 770 self
				)
			)
			(3
				((ScriptID 64018 0) setHeading: 270 self) ; oBoogle
			)
			(4
				((ScriptID 64018 0) hide:) ; oBoogle
				(poBoogleGetsWashed
					setLoop: 0
					setCel: 0
					setPri: (- (poWasherLady priority:) 1)
					posn: 200 773
					init:
					setCycle: End self
				)
			)
			(5
				(poWasherLady setCycle: End self)
				(goSound1 preload: 20123 20124)
			)
			(6
				(poBoogleGetsWashed setLoop: 1 setCel: 0 setCycle: CT 14 1 self)
				(poWasherLady setCel: 0 setCycle: CT 14 1 self)
			)
			(7)
			(8
				(goSound1 playSound: 20123)
				(poBoogleGetsWashed setCycle: End self)
				(poWasherLady setCycle: End self)
			)
			(9)
			(10
				(poWasherLady setCycle: Fwd)
				(poBoogleGetsWashed
					setLoop: 2
					setCel: 0
					posn: 241 770
					setCycle: CT 6 1 self
				)
			)
			(11
				(= ticks (poBoogleGetsWashed cycleSpeed:))
			)
			(12
				(goSound1 playSound: 20124)
				(poBoogleGetsWashed setCycle: End self)
			)
			(13
				(poBoogleGetsWashed dispose:)
				((ScriptID 64018 0) ; oBoogle
					posn: 232 770
					show:
					setMotion: MoveTo 188 770 self
				)
			)
			(14
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				((ScriptID 64017 0) set: 79) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance foVeder of Feature
	(properties
		nsLeft 419
		nsTop 865
		nsRight 442
		nsBottom 878
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soYellAtVeder)
	)
)

(instance poTorinYells of Prop
	(properties
		x 212
		y 888
		view 20102
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 128)
	)
)

(instance soYellAtVeder of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 212 888 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorinYells setCel: 0 init: setCycle: CT 20 1 self)
			)
			(3
				(gMessager say: 3 1 13 0 self) ; "(CUP HANDS. TURN OFF MIKE AND YELL) Haaaaalllloooooo."
			)
			(4
				(poTorinYells setCycle: End coEndYell)
				(if (not ((ScriptID 64017 0) test: 53)) ; oFlags
					(voVeder hide:)
					(poVeder init: setCel: 0 setCycle: Osc 1 self)
				else
					(self cue:)
				)
			)
			(5)
			(6
				(poVeder dispose:)
				(voVeder show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coEndYell of CueMe
	(properties)

	(method (cue)
		(poTorinYells dispose:)
		(gEgo show:)
		(soYellAtVeder cue:)
	)
)

(instance oSplashTest of Code
	(properties)

	(method (doit)
		(if (and (gEgo mover:) (oRiverPolygon onMe: (gEgo x:) (gEgo y:)))
			(voSplash
				posn: (gEgo x:) (gEgo y:)
				loop: (gEgo loop:)
				cel: (gEgo cel:)
				setScaleDirect: (gEgo scaleX:) (gEgo scaleY:)
				show:
			)
		else
			(voSplash hide:)
		)
	)
)

(instance voSplash of View
	(properties
		view 60111
	)

	(method (init)
		(super init: &rest)
		(self setPri: 66 1)
	)
)

(instance oWashing of TPSound
	(properties)
)

(instance foPalaceDoor of Feature
	(properties
		nsLeft 560
		nsTop 468
		nsRight 598
		nsBottom 516
		approachX 565
		approachY 516
		x 570
		y 516
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soPalaceDoor)
	)
)

(instance soPalaceDoor of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foPalaceDoor self)
			)
			(1
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(2
				((ScriptID 64007 1) poMyEgo: 0) ; soEgoGetLow
				(ExitBridge)
				(gCurRoom newRoom: 20300) ; roThroneRoom
			)
		)
	)
)

(instance foBridgeToClotheslineLedge of Feature
	(properties
		nsLeft 180
		nsTop 458
		nsRight 278
		nsBottom 516
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soBridgeToClotheslineLedge)
	)
)

(instance soBridgeToClotheslineLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 244 516 self)
			)
			(1
				(gGame handsOff:)
				(ExitBridge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setMotion: DPath 160 516 134 602 self)
			)
			(2
				(= cycles 2)
				(gEgo setScaler: Scaler 50 50 1 0)
			)
			(3
				(gEgo setMotion: DPath 196 652 74 724 self)
			)
			(4
				(gGame handsOn:)
				(EnterClotheslineLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 5
			setScaler: Scaler 50 50 1 0
			posn: 74 724
			setMotion: 0
		)
		(gGame handsOn:)
		(EnterClotheslineLedge)
		(self dispose:)
	)
)

(instance foDragonToClotheslineLedge of Feature
	(properties
		nsLeft 114
		nsTop 1195
		nsRight 244
		nsBottom 1286
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soDragonToClotheslineLedge)
	)
)

(instance soDragonToClotheslineLedge of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 126 1280 self)
			)
			(1
				(gGame handsOff:)
				(ExitDragonLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setMotion: MoveTo 246 1195 self)
			)
			(2
				(gEgo setPri: 65)
				(gEgo
					setMotion: DPath 202 1154 150 1039 240 1005 272 926 self
				)
			)
			(3
				(gEgo setPri: 55)
				(gEgo setMotion: MoveTo 204 816 self)
			)
			(4
				(gGame handsOn:)
				(EnterClotheslineLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo normalize: 1 60100 7 setPri: 55 posn: 204 816 setMotion: 0)
		(gGame handsOn:)
		(EnterClotheslineLedge)
		(self dispose:)
	)
)

(instance foDragonCave of ExitFeature
	(properties
		nsLeft 2
		nsTop 1180
		nsRight 92
		nsBottom 1257
		approachX 46
		approachY 1262
		x 44
		y 1260
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gEgo approachThenFace: self self)
	)

	(method (cue)
		(ExitDragonLedge)
		(gCurRoom newRoom: 20400) ; roDragonCave
	)
)

(instance foDragonToVultures of Feature
	(properties
		nsTop 1272
		nsRight 60
		nsBottom 1351
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soDragonToVultures)
	)
)

(instance soDragonToVultures of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 14 1274 self)
			)
			(1
				(gGame handsOff:)
				(ExitDragonLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo
					setMotion: DPath -30 1341 -176 1420 -44 1464 38 1543 self
				)
			)
			(2
				(gGame handsOn:)
				(EnterVultureLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo normalize: 1 60100 4 posn: 38 1543 setMotion: 0)
		(gGame handsOn:)
		(EnterVultureLedge)
		(self dispose:)
	)
)

(instance foRockOverVultures of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 35 1)
		(self myPriority: 10)
		(self
			createPoly: 158 1236 180 1237 208 1292 224 1306 263 1315 288 1311 288 1322 271 1338 253 1345 227 1345 199 1335 166 1305 136 1282
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; ioBeestLeg
				(if (not ((ScriptID 64017 0) test: 76)) ; oFlags
					(gEgo setScript: soTorinDropsMeat)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTorinPullsOutMeat of Prop
	(properties
		x 122
		y 1275
		view 20104
	)
)

(instance poVulturesFlyAway of Prop
	(properties
		x 289
		y 1587
		view 20104
		loop 5
	)
)

(instance aoFlyingMeat of Actor
	(properties
		view 20104
		loop 3
	)

	(method (init)
		(super init: &rest)
		(= xStep 3)
		(= yStep 0)
	)

	(method (doit)
		(if bStartMeatFalling
			(self posn: (+ x xStep) (+ y yStep))
			(if (> y 1650)
				(self dispose:)
				(return)
			)
			(if (== nFallCounter 0)
				(= nFallCounter 2)
				(= yStep (Min (+ yStep 1) nMeatTerminalVelocity))
			else
				(-- nFallCounter)
			)
		)
		(super doit: &rest)
	)
)

(instance voVultureBodyMeat of View
	(properties
		view 20104
		loop 10
	)

	(method (init)
		(= x (poVulturesFlyAway x:))
		(= y (poVulturesFlyAway y:))
		(super init: &rest)
	)
)

(instance poVisceraIdleMeat of Prop
	(properties
		view 20104
		loop 14
	)

	(method (init)
		(= x (poVulturesFlyAway x:))
		(= y (poVulturesFlyAway y:))
		(super init: &rest)
		(= cycleSpeed 30)
		(self setCycle: RandCycle)
	)
)

(instance poTripeIdleMeat of Prop
	(properties
		view 20104
		loop 13
	)

	(method (init)
		(= x (poVulturesFlyAway x:))
		(= y (poVulturesFlyAway y:))
		(super init: &rest)
		(= cycleSpeed 30)
		(self setCycle: RandCycle)
	)
)

(instance toTripeMeat of Talker
	(properties
		view 20104
		loop 11
		priority 2000
	)

	(method (init)
		(= x (poVulturesFlyAway x:))
		(= y (poVulturesFlyAway y:))
		(poVulturesFlyAway hide:)
		(voVultureBodyMeat init:)
		(poVisceraIdleMeat init:)
		(super init: &rest)
	)

	(method (dispose)
		(poVulturesFlyAway show:)
		(voVultureBodyMeat dispose:)
		(poVisceraIdleMeat dispose:)
		(super dispose: &rest)
	)
)

(instance toVisceraMeat of Talker
	(properties
		view 20104
		loop 12
		priority 2000
	)

	(method (init)
		(= x (poVulturesFlyAway x:))
		(= y (poVulturesFlyAway y:))
		(poVulturesFlyAway hide:)
		(voVultureBodyMeat init:)
		(poTripeIdleMeat init:)
		(super init: &rest)
	)

	(method (dispose)
		(poVulturesFlyAway show:)
		(voVultureBodyMeat dispose:)
		(poTripeIdleMeat dispose:)
		(super dispose: &rest)
	)
)

(instance toTorinPullsOutMeat of Talker
	(properties
		x 122
		y 1275
		view 20104
		loop 1
		priority 1276
	)
)

(instance soTorinDropsMeat of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 122 1275 self)
				(oCliffScrollPlane panTo: 0 1072 self 1)
			)
			(1)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gEgo stopwalk:)
				(= cycles 2)
			)
			(4
				(goSound1 preload: 20108 20198 20121 20110)
				(gEgo hide:)
				(poTorinPullsOutMeat init: setCycle: End self)
			)
			(5
				(= gtTorin toTorinPullsOutMeat)
				(gMessager say: 2 35 0 1 self) ; "Hey, vulture! Try and catch this!"
			)
			(6
				(= gtTorin 0)
				(poTorinPullsOutMeat
					setLoop: 2
					setCel: 0
					setCycle: CT 13 1 self
				)
			)
			(7
				(= ticks (poTorinPullsOutMeat cycleSpeed:))
				(goSound1 playSound: 20108)
			)
			(8
				(poTorinPullsOutMeat setCycle: End self)
			)
			(9
				(poTorinPullsOutMeat dispose:)
				(gEgo show:)
				(gEgo put: ((ScriptID 64001 0) get: 25)) ; oInvHandler, ioBeestLeg
				((ScriptID 64017 0) set: 76) ; oFlags
				((ScriptID 64017 0) set: 78) ; oFlags
				(aoFlyingMeat
					setLoop: 3 1
					setCel: 0
					posn: 381 1241
					init:
					setCycle: Fwd
				)
				(voVultures dispose:)
				(poVulturesFlyAway init:)
				(oCliffScrollPlane panTo: 0 1262 self 1)
			)
			(10
				(goMusic1 setMusic: 20198)
				(oMyAmbience setAmbient: 0)
				(poVulturesFlyAway setCycle: CT 30 1 self)
			)
			(11
				(= ticks (poVulturesFlyAway cycleSpeed:))
			)
			(12
				(goSound1 playSound: 20121)
				(poVulturesFlyAway setCycle: End self)
			)
			(13
				(= gtViscera toVisceraMeat)
				(= gtTripe toTripeMeat)
				(gMessager sayRange: 2 35 0 2 3 self) ; "Hey, Viscera! Look at dat! Fresh dead meat! Flying! Let's go after it!"
			)
			(14
				(poVulturesFlyAway
					setLoop: 6
					setCel: 0
					posn: 266 1570
					setCycle: End self
				)
			)
			(15
				(poVulturesFlyAway
					setLoop: 7
					setCel: 0
					posn: 287 1563
					setCycle: CT 8 1 self
				)
			)
			(16
				(= ticks (poVulturesFlyAway cycleSpeed:))
				(goSound1 playSound: 20110)
			)
			(17
				(poVulturesFlyAway setCycle: End self)
			)
			(18
				(poVulturesFlyAway dispose:)
				(= gtViscera 0)
				(= gtTripe 0)
				(oCliffScrollPlane panTo: 0 1580 self 2)
				(gMessager sayRange: 2 35 0 4 5 self) ; "Can't cha hurry up a little? It's gettin' away from us!"
			)
			(19)
			(20
				(oMyAmbience setAmbient: 20100)
				(goMusic1 fade: 0 10 9 1 self)
			)
			(21
				(gMessager say: 2 35 0 6 self) ; "What's that beside that little tree?"
			)
			(22
				(oCliffScrollPlane panTo: 0 1072 self 1)
			)
			(23
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			setMotion: 0
			posn: 122 1275
			setLoop: 4
			stopwalk:
			show:
			put: ((ScriptID 64001 0) get: 25) ; oInvHandler, ioBeestLeg
		)
		((ScriptID 64017 0) set: 76 78) ; oFlags
		(oCliffScrollPlane killPan: scrollTo: 0 1072)
		(poTorinPullsOutMeat dispose:)
		(aoFlyingMeat dispose:)
		(voVultures dispose:)
		(poVulturesFlyAway dispose:)
		(= gtViscera 0)
		(= gtTripe 0)
		(goMusic1 setMusic: 0)
		(goSound1 stop:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(gEgo
			setMotion: 0
			posn: 122 1275
			setLoop: 4
			stopwalk:
			show:
			get: ((ScriptID 64001 0) get: 25) ; oInvHandler, ioBeestLeg
		)
		((ScriptID 64017 0) unSet: 76) ; oFlags
		(oCliffScrollPlane killPan: scrollTo: 0 1072)
		(poTorinPullsOutMeat setLoop: 0 setCel: 0 dispose:)
		(aoFlyingMeat dispose:)
		(voVultures init:)
		(poVulturesFlyAway
			view: 20104
			setLoop: 5
			setCel: 0
			posn: 289 1587
			dispose:
		)
		(= gtViscera toViscera)
		(= gtTripe toTripe)
		(goMusic1 setMusic: 0)
		(goSound1 stop:)
		(gEgo setScript: self)
	)
)

(instance foVulturesToDragon of Feature
	(properties
		nsTop 1466
		nsRight 72
		nsBottom 1538
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soVulturesToDragon)
	)
)

(instance soVulturesToDragon of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not ((ScriptID 64017 0) test: 76)) (not bVulturesPosed)) ; oFlags
					(poVultures setCycle: Beg coPoseVultures)
					(foVulturesForward dispose:)
					(foVultures init:)
				)
				(gEgo setMotion: PolyPath 38 1543 self)
			)
			(1
				(gGame handsOff:)
				(ExitVultureLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo
					setMotion: DPath -44 1464 -176 1420 -30 1341 14 1274 self
				)
			)
			(2
				(gGame handsOn:)
				(EnterDragonLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo normalize: 1 60100 6 posn: 14 1274 setMotion: 0)
		(gGame handsOn:)
		(EnterDragonLedge)
		(self dispose:)
	)
)

(instance coPoseVultures of CueMe
	(properties)

	(method (cue)
		(poVultures dispose:)
		(voVultures init:)
	)
)

(instance foVulturesToLeap of Feature
	(properties
		nsLeft 216
		nsTop 1462
		nsRight 271
		nsBottom 1530
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soVulturesToLeap)
	)
)

(instance foWalkByVultures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsTop (foVulturesToLeap nsTop:))
		(= nsBottom (foVulturesToLeap nsBottom:))
		(= nsLeft (foVulturesToLeap nsLeft:))
		(= nsRight (foVulturesToLeap nsRight:))
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(foVultures doVerb: &rest)
	)
)

(instance soVulturesToLeap of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 257 1533 self)
			)
			(1
				(gGame handsOff:)
				(ExitVultureLedge)
				(gEgo setPri: 85)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setMotion: DPath 190 1454 184 1339 self)
			)
			(2
				(gEgo setScaler: Scaler 46 46 1 0)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo 306 1339 self)
			)
			(4
				(gGame handsOn:)
				(EnterLeapLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 0
			setScaler: Scaler 46 46 1 0
			setPri: 85
			posn: 306 1339
			setMotion: 0
		)
		(gGame handsOn:)
		(EnterLeapLedge)
		(self dispose:)
	)
)

(instance voVultures of View
	(properties
		x 264
		y 1570
		view 20124
	)

	(method (init)
		(= bVulturesPosed 1)
		(super init: &rest)
	)

	(method (dispose)
		(= bVulturesPosed 0)
		(super dispose: &rest)
	)
)

(instance poVultures of Prop
	(properties
		x 264
		y 1570
		view 20105
	)
)

(instance poVulturesEatMeat of Prop
	(properties
		x 264
		y 1570
		view 20123
		loop 1
	)
)

(instance foVultures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 35)
		(self createPoly: 230 1565 288 1489 335 1494 328 1528 275 1571)
	)

	(method (doVerb theVerb)
		(goMusic1 setMusic: 20199)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTorinTalksToVultures)
			)
			(35 ; ioBeestLeg
				(gEgo setScript: soTorinGivesMeat)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foVulturesForward of Feature
	(properties
		nsLeft 144
		nsTop 1465
		nsRight 263
		nsBottom 1563
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 35)
	)

	(method (doVerb)
		(foVultures doVerb: &rest)
	)
)

(instance voVultureBody of View
	(properties
		view 20105
		loop 1
	)

	(method (init)
		(= x (poVultures x:))
		(= y (poVultures y:))
		(super init: &rest)
	)
)

(instance poVisceraIdle of Prop
	(properties
		view 20105
		loop 5
	)

	(method (init)
		(= x (poVultures x:))
		(= y (poVultures y:))
		(super init: &rest)
		(= cycleSpeed 30)
		(self setCycle: RandCycle)
	)
)

(instance poTripeIdle of Prop
	(properties
		view 20105
		loop 4
	)

	(method (init)
		(= x (poVultures x:))
		(= y (poVultures y:))
		(super init: &rest)
		(= cycleSpeed 30)
		(self setCycle: RandCycle)
	)
)

(instance toTripe of Talker
	(properties
		view 20105
		loop 2
		priority 2000
	)

	(method (init)
		(= x (poVultures x:))
		(= y (poVultures y:))
		(poVultures hide:)
		(voVultureBody init:)
		(poVisceraIdle init:)
		(super init: &rest)
	)

	(method (dispose)
		(poVultures show:)
		(voVultureBody dispose:)
		(poVisceraIdle dispose:)
		(super dispose: &rest)
	)
)

(instance toViscera of Talker
	(properties
		view 20105
		loop 3
	)

	(method (init)
		(= priority (- (poVultures y:) 5))
		(= x (poVultures x:))
		(= y (poVultures y:))
		(poVultures hide:)
		(voVultureBody init:)
		(poTripeIdle init:)
		(super init: &rest)
	)

	(method (dispose)
		(poVultures show:)
		(voVultureBody dispose:)
		(poTripeIdle dispose:)
		(super dispose: &rest)
	)
)

(instance soTorinTalksToVultures of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gnVulturesTalk
					(0
						(= gnVulturesTalk 7)
					)
					(7
						(= gnVulturesTalk 8)
					)
					(8
						(= gnVulturesTalk 9)
					)
					(else
						(= gnVulturesTalk 10)
						((ScriptID 64017 0) set: 78) ; oFlags
					)
				)
				(gEgo face: voVultures self)
			)
			(1
				(if (> (gEgo x:) 118)
					(gEgo setLoop: 0 1)
					(gEgo setMotion: PolyPath 118 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setLoop: -1)
				(gMessager say: 4 1 gnVulturesTalk 1 self)
				(voVultures dispose:)
				(poVultures init: setCycle: End self)
				(foVultures dispose:)
				(foVulturesForward init:)
			)
			(3)
			(4
				(switch gnVulturesTalk
					(7
						(gMessager sayRange: 4 1 7 2 9 self) ; "Hey, get outta here!"
					)
					(8
						(gMessager sayRange: 4 1 8 2 9 self) ; "Yeah, you're ugly. You're skinny and, and...tall. Why, I've only seen one person tall as you, but..."
					)
					(9
						(gMessager sayRange: 4 1 9 2 4 self) ; "An' I order you to shut up. And (SUDDENLY SWEET) per chance, did I forget to mention? (NASTY AGAIN) Go away!"
					)
					(10
						(gMessager sayRange: 4 1 10 2 4 self) ; "(SARCASTICLY) Yeah. Right."
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oChomp of TPSound
	(properties)
)

(instance soTorinGivesMeat of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 119 1550 self)
				(voVultures dispose:)
				(poVultures init: setCycle: End self)
				(foVultures dispose:)
				(foVulturesForward init:)
			)
			(1)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gEgo stopwalk:)
				(= cycles 2)
			)
			(4
				(goSound1 preload: 20120 20115)
				(gMessager say: 4 35 0 1 self) ; "Here, guys. I wondered if you'd like a little something to munch on."
			)
			(5
				(gEgo hide:)
				(poTorinOffersMeat
					setLoop: 0
					setCel: 0
					init:
					setCycle: End self
				)
			)
			(6
				(poVultures hide:)
				(poVulturesEatMeat setCel: 0 init: setCycle: CT 18 1 self)
			)
			(7
				(oChomp playSound: 20120)
				(gEgo put: ((ScriptID 64001 0) get: 25)) ; oInvHandler, ioBeestLeg
				(= ticks (poVulturesEatMeat cycleSpeed:))
			)
			(8
				(goSound1 playSound: 20115)
				(poTorinOffersMeat setLoop: 2 setCel: 0 setCycle: End self)
				(poVulturesEatMeat setCycle: End self)
			)
			(9)
			(10
				(poTorinOffersMeat dispose:)
				(poVulturesEatMeat dispose:)
				(poVultures show:)
				(gEgo posn: 44 1549 show:)
				(gMessager sayRange: 4 35 0 2 8 self) ; "Umpghsh! (HE SWALLOWS IT) Ahhhhhhhhh! Good."
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinOffersMeat of Prop
	(properties
		x 100
		y 1555
		view 20123
	)

	(method (init)
		(super init: &rest)
		(self setPri: (gEgo priority:))
	)
)

(instance voTree of View
	(properties
		x 192
		y 1887
		view 20120
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(if (not ((ScriptID 64017 0) test: 75)) ; oFlags
			(self addHotspotVerb: 1)
		)
	)

	(method (doVerb theVerb)
		(if (== view 20129)
			(if ((ScriptID 64017 0) test: 76) ; oFlags
				(gEgo setScript: soBigTree)
			else
				(gEgo setScript: soTorinTalksToVultures)
			)
		else
			(switch theVerb
				(1 ; Do
					(gMessager say: 5 1 3 0) ; "Hmmm. If only I could make that tree grow...."
				)
				(36 ; ioDragonPoo
					(gEgo setScript: soTorinFertilizesTree)
				)
				(else
					(super doVerb: &rest)
				)
			)
		)
	)
)

(instance poTorinFertilizesTree of Prop
	(properties
		x 89
		y 1571
		view 20106
	)
)

(instance poTreeGrows of Prop
	(properties
		x 192
		y 1887
		view 20121
	)
)

(instance soTorinFertilizesTree of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 20119 20112)
				(gEgo setMotion: PolyPath 89 1571 self)
				(oCliffScrollPlane panTo: 0 1424 self 1)
			)
			(1)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gMessager say: 5 36 3 0) ; "This should either make that tree grow, or kill it completely!"
				(= seconds 3)
			)
			(4
				(gEgo hide:)
				(poTorinFertilizesTree setCel: 0 init: setCycle: CT 20 1 self)
			)
			(5
				(goSound1 playSound: 20119)
				(poTorinFertilizesTree setCycle: End self)
			)
			(6
				(gEgo put: ((ScriptID 64001 0) get: 26)) ; oInvHandler, ioDragonPoo
				(oCliffScrollPlane panTo: 0 1580 self 1)
			)
			(7
				(voTree dispose:)
				(goSound1 playSound: 20112)
				(poTreeGrows setCel: 0 init: setCycle: End self)
			)
			(8
				((ScriptID 64017 0) set: 75) ; oFlags
				(poTreeGrows dispose:)
				(voTree view: 20129 init:)
				(voTree forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
				(voTree deleteHotspotVerb: 1 36)
				(oCliffScrollPlane panTo: 0 1424 self 1)
			)
			(9
				(poTorinFertilizesTree setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(poTorinFertilizesTree dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(gEgo
			setMotion: 0
			posn: 89 1571
			loop: 4
			stopwalk:
			show:
			get: ((ScriptID 64001 0) get: 26) ; oInvHandler, ioDragonPoo
		)
		(poTorinFertilizesTree
			view: 20106
			setLoop: 0
			setCel: 0
			posn: 89 1571
			dispose:
		)
		(poTreeGrows dispose:)
		(voTree view: 20120 init:)
		(voTree forceCursor: 0)
		((ScriptID 64017 0) unSet: 75) ; oFlags
		(goSound1 stop:)
		(oCliffScrollPlane killPan:)
		(oCliffScrollPlane scrollTo: 0 1424)
		(gEgo setScript: self)
	)

	(method (ff)
		(gEgo
			setMotion: 0
			posn: 89 1571
			loop: 4
			stopwalk:
			show:
			put: ((ScriptID 64001 0) get: 26) ; oInvHandler, ioDragonPoo
		)
		((ScriptID 64017 0) set: 75) ; oFlags
		(poTorinFertilizesTree dispose:)
		(poTreeGrows dispose:)
		(goSound1 stop:)
		(oCliffScrollPlane killPan:)
		(oCliffScrollPlane scrollTo: 0 1424)
		(voTree view: 20129 init:)
		(voTree forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
		(voTree deleteHotspotVerb: 1 36)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance poTorinClimbsDownTree of Prop
	(properties
		x 310
		y 1560
		view 20127
	)
)

(instance soBigTree of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 310 1560 self)
			)
			(1
				(gGame handsOff:)
				(ExitLeapLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setMotion: MoveTo 310 1560 self)
			)
			(2
				(oCliffScrollPlane panTo: 0 1440 self 1)
				(gEgo setHeading: 135 self)
			)
			(3)
			(4
				(gEgo stopwalk:)
				(= cycles 2)
			)
			(5
				(goSound1 preload: 20116)
				(gEgo hide:)
				(poTorinClimbsDownTree
					setCel: 0
					init:
					setPri: 2000
					setCycle: CT 16 1 self
				)
			)
			(6
				(goSound1 playSound: 20116)
				(oCliffScrollPlane panTo: 0 1580 self 1)
				(poTorinClimbsDownTree setCycle: End self)
			)
			(7)
			(8
				(gCurRoom newRoom: 20700) ; roPhace
			)
		)
	)

	(method (ff)
		(goSound1 stop:)
		(oCliffScrollPlane killPan:)
		(gCurRoom newRoom: 20700) ; roPhace
	)
)

(instance foLeapLedgeToVultures of Feature
	(properties
		nsLeft 226
		nsTop 1305
		nsRight 292
		nsBottom 1344
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soLeapLedgeToVultures)
	)
)

(instance soLeapLedgeToVultures of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 306 1351 self)
			)
			(1
				(gGame handsOff:)
				(ExitLeapLedge)
				(= bHasFF 1)
				(self setButtons:)
				(gEgo setMotion: MoveTo 184 1339 self)
			)
			(2
				(gEgo hide:)
				(gEgo setScaler: Scaler 60 60 1 0)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo 195 1454 self)
			)
			(4
				(gEgo show:)
				(gEgo setMotion: MoveTo 257 1533 self)
			)
			(5
				(gGame handsOn:)
				(EnterVultureLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo
			normalize: 1 60100 4
			posn: 257 1533
			setScaler: Scaler 60 60 1 0
			show:
			setMotion: 0
		)
		(gGame handsOn:)
		(EnterVultureLedge)
		(self dispose:)
	)
)

(instance foLeapAcrossRight of Feature
	(properties
		nsLeft 390
		nsTop 1289
		nsRight 508
		nsBottom 1377
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soLeapAcrossRight)
	)
)

(instance poTorinLeapsRight of Prop
	(properties
		x 293
		y 1339
		view 20112
	)
)

(instance soLeapAcrossRight of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 293 1339 self)
				(oCliffScrollPlane panTo: 0 1183)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gGame handsOff:)
				(ExitLeapLedge)
				(gEgo stopwalk:)
				(= cycles 2)
			)
			(3
				(= bHasFF 1)
				(self setButtons:)
				(goSound1 preload: 20113)
				(cond
					(((ScriptID 64017 0) test: 81) ; oFlags
						(self cue:)
					)
					(((ScriptID 64017 0) test: 80) ; oFlags
						(gMessager say: 7 1 2 0 self) ; "Ooow. Just don't look down."
					)
					(else
						(gMessager sayRange: 7 1 1 1 2 self) ; "(WHAT! OH NO!) Bwark!"
					)
				)
			)
			(4
				(gEgo hide:)
				(goSound1 playSound: 20113)
				(poTorinLeapsRight setCel: 0 init: setCycle: End self)
			)
			(5
				(if ((ScriptID 64017 0) test: 80) ; oFlags
					((ScriptID 64017 0) set: 81) ; oFlags
				else
					((ScriptID 64017 0) set: 80) ; oFlags
				)
				(poTorinLeapsRight dispose:)
				(gEgo posn: 478 1294 show: setMotion: MoveTo 489 1297 self)
			)
			(6
				(gGame handsOn:)
				(EnterSkunkLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(goSound1 stop:)
		(poTorinLeapsRight dispose:)
		(gEgo normalize: 1 60100 0 posn: 489 1297 show: setMotion: 0)
		(gGame handsOn:)
		(EnterSkunkLedge)
		(self dispose:)
	)
)

(instance foLeapAcrossLeft of Feature
	(properties
		nsLeft 325
		nsTop 1291
		nsRight 466
		nsBottom 1377
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soLeapAcrossLeft)
	)
)

(instance poTorinLeapsLeft of Prop
	(properties
		x 564
		y 1293
		view 20128
	)
)

(instance soLeapAcrossLeft of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 564 1293 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gGame handsOff:)
				(ExitSkunkLedge)
				(gEgo stopwalk:)
				(= cycles 2)
			)
			(3
				(= bHasFF 1)
				(self setButtons:)
				(goSound1 preload: 20114)
				(gEgo hide:)
				(goSound1 playSound: 20114)
				(poTorinLeapsLeft setCel: 0 init: setPri: 89 setCycle: End self)
			)
			(4
				(poTorinLeapsLeft dispose:)
				(gEgo posn: 310 1342 setLoop: 1 stopwalk: show:)
				(gGame handsOn:)
				(EnterLeapLedge)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(goSound1 stop:)
		(poTorinLeapsLeft dispose:)
		(gEgo normalize: 1 60100 1 posn: 310 1342 show: setMotion: 0)
		(gGame handsOn:)
		(EnterLeapLedge)
		(self dispose:)
	)
)

(instance foSkunkCave of Feature
	(properties
		nsLeft 548
		nsTop 1200
		nsRight 630
		nsBottom 1291
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soSkunkCave)
	)
)

(instance soSkunkCave of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 582 1293 self)
			)
			(1
				(gGame handsOff:)
				(ExitSkunkLedge)
				(gEgo setMotion: MoveTo 612 1278 self)
			)
			(2
				(gCurRoom newRoom: 20500) ; roSkunkCave
			)
		)
	)
)

(instance foClimbToSeraglio of Feature
	(properties
		nsLeft 538
		nsTop 1293
		nsRight 628
		nsBottom 1384
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soClimbToSeraglio)
	)
)

(instance poTorinClimbsToSeraglio of Prop
	(properties
		x 548
		y 1293
		view 20114
	)
)

(instance soClimbToSeraglio of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 548 1293 self)
			)
			(1
				(gEgo setHeading: 125 self)
			)
			(2
				(if ((ScriptID 64017 0) test: 82) ; oFlags
					(self cue:)
				else
					((ScriptID 64017 0) set: 82) ; oFlags
					(gMessager say: 8 1 4 0 self) ; "Hang on, Boog. I hope this is worth it!"
				)
			)
			(3
				(gGame handsOff:)
				(ExitSkunkLedge)
				(gEgo hide:)
				(= bHasFF 1)
				(self setButtons:)
				(poTorinClimbsToSeraglio setCel: 0 init: setCycle: End self)
				(goSound1 playSound: 20125)
			)
			(4
				(gCurRoom newRoom: 20600) ; roSeraglio
			)
		)
	)

	(method (ff)
		(gCurRoom newRoom: 20600) ; roSeraglio
	)
)

(instance poTorinFallsIn of Prop
	(properties
		x 109
		y 117
		view 20100
		cycleSpeed 8
	)
)

(instance poTileFalls of Prop
	(properties
		view 20100
		loop 2
		cycleSpeed 8
	)
)

(instance voGuilloTile of View
	(properties
		x 82
		y 332
		view 20132
	)

	(method (init)
		(super init: &rest)
		(self setPri: 116)
	)
)

(instance voStepTile of View
	(properties
		x 99
		y 335
		view 20133
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)
)

(instance oThud of TPSound ; UNUSED
	(properties)
)

(instance soEgoFallsIn of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo dispose:)
				(oCliffScrollPlane scrollTo: 0 0)
				(FadeToBlack 0 10 self)
			)
			(1
				(= ticks 180)
			)
			(2
				(poTorinFallsIn setCel: 0 init: hide:)
				(goSound1 preload: 20101 20102)
				(= ticks 1)
			)
			(3
				(goSound1 playSound: 20101)
				(= ticks 120)
			)
			(4
				(poTorinFallsIn show: setCycle: CT 9 1 self)
				(gMessager say: 0 0 5 2 self) ; "(PAUSE AS TORIN SEES WHERE HE IS) WHOA!!"
			)
			(5
				(goSound1 playSound: 20102)
			)
			(6
				(= ticks 60)
			)
			(7
				(poTorinFallsIn setCycle: CT 15 1 self)
			)
			(8
				(gMessager say: 0 0 5 3 self) ; "(TORIN FALLS ONTO TREE, THEN) WHEW!"
			)
			(9
				(= ticks 120)
				(Load rsPIC 21000)
				(Load rsVIEW 20101)
				(goSound1 preload: 20102 20105 20106)
			)
			(10
				(goSound1 playSound: 20102 self)
			)
			(11
				(oCliffScrollPlane panTo: 0 156 self 1)
			)
			(12
				(goSound1 playSound: 20105)
				(gMessager say: 0 0 5 4) ; "(AS TORIN LEANS OVER CLIFF SIDE) WHOA!!"
				(poTorinFallsIn setCycle: CT 30 1 self)
			)
			(13
				(= ticks 4)
			)
			(14
				(poTorinFallsIn setCycle: CT 27 -1 self)
			)
			(15
				(gMessager kill:)
				(gMessager say: 0 0 5 1) ; "(TORIN MATERIALIZES FIRST, THEN) WHEW!"
				(= ticks 4)
			)
			(16
				(poTorinFallsIn setCycle: CT 30 1 self)
			)
			(17
				(= ticks 4)
			)
			(18
				(poTorinFallsIn setCycle: CT 27 -1 self)
			)
			(19
				(poTorinFallsIn setCycle: End self)
				(gMessager kill:)
				(gMessager say: 0 0 6 1 self) ; "(AS TORIN LEANS OVER CLIFF SIDE) WHOA!!"
			)
			(20)
			(21
				(voGuilloTile dispose:)
				(poTileFalls setCel: 0 posn: 82 321 init: setCycle: CT 1 1 self)
			)
			(22
				(gCurRoom newRoom: 21000) ; roStartingLedgeCu
			)
		)
	)
)

(instance soBitternutToStartingLedge of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 18 518)
				(gEgo setScaler: Scaler 60 60 1 0)
				(gEgo setPri: 45)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 51 514 self)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gEgo setLoop: 4 1)
				(gEgo setMotion: MoveTo 88 463 self)
			)
			(4
				(gEgo setLoop: -1)
				(EnterStartingLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinClimbsUpTree of Prop
	(properties
		x 198
		y 1845
		view 20109
	)
)

(instance soClimbUpBigTree of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 20117)
				(gEgo
					setScaler: Scaler 60 60 1 0
					posn: 198 1845
					setLoop: 7
					hide:
				)
				(poTorinClimbsUpTree
					setCel: 0
					init:
					setPri: 2500
					setCycle: CT 30 1 self
				)
				(= bHasFF 1)
				(self setButtons:)
			)
			(1
				(goSound1 playSound: 20117)
				(= ticks (poTorinClimbsUpTree cycleSpeed:))
			)
			(2
				(poTorinClimbsUpTree setCycle: End self)
			)
			(3
				(poTorinClimbsUpTree dispose:)
				(gEgo posn: 276 1583 show: setMotion: MoveTo 233 1570 self)
			)
			(4
				(EnterVultureLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(goSound1 stop:)
		(poTorinClimbsUpTree dispose:)
		(gEgo posn: 233 1570 show: setMotion: 0)
		(EnterVultureLedge)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soClimbFromSeraglio of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					hide:
					posn: 548 1293
					setScaler: Scaler 46 46 1 0
					normalize: 1 60100 4
					setPri: 85
					stopwalk:
				)
				(poTorinClimbsToSeraglio setCel: 24 init: setCycle: Beg self)
				(= bHasFF 1)
				(self setButtons:)
				(goSound1 playSound: 20126)
			)
			(1
				(poTorinClimbsToSeraglio dispose:)
				(gEgo show:)
				(EnterSkunkLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(poTorinClimbsToSeraglio dispose:)
		(gEgo show:)
		(EnterSkunkLedge)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soEnterFromDragonCave of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(EnterDragonLedge)
				(if ((ScriptID 64017 0) test: 232) ; oFlags
					(self cue:)
				else
					((ScriptID 64018 0) ; oBoogle
						init:
						normalize:
						posn: 0 1262
						setLoop: 0
						setScaleDirect: 60 60
					)
					(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSkunkCaveFront of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 612 1255)
				(gEgo setScaler: Scaler 46 46 1 0)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 582 1293 self)
			)
			(2
				(EnterSkunkLedge)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSkunkCaveBack of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 530 1044)
				(gEgo setScaler: Scaler 17 17 1 0)
				(gEgo setPri: 65)
				(= cycles 2)
			)
			(1
				(oCliffScrollPlane panTo: 0 810 self 1)
			)
			(2
				(gEgo setMotion: DPath 455 1013 444 1002 self)
			)
			(3
				(gEgo setPri: 55)
				(gEgo setMotion: DPath 472 989 512 958 512 932 self)
			)
			(4
				(gEgo
					setMotion:
						DPath
						504
						932
						484
						931
						469
						916
						478
						899
						520
						899
						520
						880
						452
						880
						self
				)
			)
			(5
				(gCurRoom newRoom: 20900) ; roVedarCu
			)
		)
	)

	(method (ff)
		(oCliffScrollPlane killPan:)
		(gCurRoom newRoom: 20900) ; roVedarCu
	)
)

(instance soLeaveManLedge of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 452 880 setScaler: Scaler 17 17 1 0 setPri: 55)
				(= cycles 2)
			)
			(1
				(gEgo
					setMotion:
						DPath
						520
						880
						520
						899
						478
						899
						469
						916
						484
						931
						504
						932
						self
				)
			)
			(2
				(gEgo setMotion: DPath 512 932 512 958 472 989 444 1002 self)
			)
			(3
				(gEgo setPri: 65)
				(gEgo setMotion: DPath 455 1013 530 1044 self)
			)
			(4
				(oCliffScrollPlane panTo: 0 982 self 1)
			)
			(5
				(gCurRoom newRoom: 20500) ; roSkunkCave
			)
		)
	)

	(method (ff)
		(oCliffScrollPlane killPan:)
		(gCurRoom newRoom: 20500) ; roSkunkCave
	)
)

(instance poVeder of Prop
	(properties
		x 430
		y 872
		view 20102
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 39)
	)
)

(instance voVeder of View
	(properties
		x 430
		y 872
		view 20122
	)

	(method (init)
		(super init: &rest)
		(self setScalePercent: 39)
	)
)

(instance poRiver of Prop
	(properties
		x 82
		y 832
		view 20108
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 50)
		(self setCycle: Fwd)
	)
)

(instance oBackView11 of ScrollView
	(properties
		y 78
		view 20140
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView12 of ScrollView
	(properties
		y 157
		view 20141
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView13 of ScrollView
	(properties
		y 236
		view 20142
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView14 of ScrollView
	(properties
		y 315
		view 20143
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView21 of ScrollView
	(properties
		y 394
		view 20144
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView22 of ScrollView
	(properties
		y 473
		view 20145
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView23 of ScrollView
	(properties
		y 552
		view 20146
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oBackView24 of ScrollView
	(properties
		y 631
		view 20147
	)

	(method (init)
		(super init: &rest)
		(self setPri: 4)
	)
)

(instance oCliffScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics)
		(AddPicAt self 20110 0 0)
		(AddPicAt self 20111 0 79)
		(AddPicAt self 20112 0 158)
		(AddPicAt self 20113 0 237)
		(AddPicAt self 20114 0 316)
		(AddPicAt self 20115 0 395)
		(AddPicAt self 20116 0 474)
		(AddPicAt self 20117 0 553)
		(AddPicAt self 20118 0 632)
		(AddPicAt self 20119 0 711)
		(AddPicAt self 20120 0 790)
		(AddPicAt self 20121 0 869)
		(AddPicAt self 20122 0 948)
		(AddPicAt self 20123 0 1027)
		(AddPicAt self 20124 0 1106)
		(AddPicAt self 20125 0 1185)
		(AddPicAt self 20126 0 1264)
		(AddPicAt self 20127 0 1343)
		(AddPicAt self 20128 0 1422)
		(AddPicAt self 20129 0 1501)
		(AddPicAt self 20130 0 1580)
		(AddPicAt self 20131 0 1659)
		(AddPicAt self 20132 0 1738)
		(AddPicAt self 20133 0 1817)
	)

	(method (addViews)
		(self addScrollView: oBackView11)
		(self addScrollView: oBackView12)
		(self addScrollView: oBackView13)
		(self addScrollView: oBackView14)
		(self addScrollView: oBackView21)
		(self addScrollView: oBackView22)
		(self addScrollView: oBackView23)
		(self addScrollView: oBackView24)
		(oBackView11 setTotalWidth: 1 632)
		(oBackView12 setTotalWidth: 1 632)
		(oBackView13 setTotalWidth: 1 632)
		(oBackView14 setTotalWidth: 1 632)
		(oBackView21 setTotalWidth: 1 632)
		(oBackView22 setTotalWidth: 1 632)
		(oBackView23 setTotalWidth: 1 632)
		(oBackView24 setTotalWidth: 1 632)
	)
)

(instance oMyAmbience of TPSound
	(properties)
)

(instance roCliffScroller of TPRoom
	(properties
		picture -2
	)

	(method (init)
		(Palette 1 20000) ; PalLoad
		(super init: &rest)
		(= plane
			(oCliffScrollPlane
				oNScrollExit: 0
				oSScrollExit: 0
				init: (gThePlane getWidth:) 1896
				yourself:
			)
		)
		(= gnChapter 2)
		(= gtTripe toTripe)
		(= gtViscera toViscera)
		(if (not ((ScriptID 64017 0) test: 46)) ; oFlags
			(voGuilloTile init:)
		)
		(if (not ((ScriptID 64017 0) test: 47)) ; oFlags
			(voStepTile init:)
		)
		(if (!= gPrevRoomNum 20000) ; roChapter2
			(if (not ((ScriptID 64017 0) test: 76)) ; oFlags
				(voVultures init:)
			)
			(if ((ScriptID 64017 0) test: 75) ; oFlags
				(voTree view: 20129 init:)
			else
				(voTree view: 20120 init:)
			)
			(poRiver init:)
			(if (not ((ScriptID 64017 0) test: 77)) ; oFlags
				(poWasherLady init:)
			)
			(if (not ((ScriptID 64017 0) test: 55)) ; oFlags
				(voClothespin init:)
			)
			(if ((ScriptID 64017 0) test: 53) ; oFlags
				(voVeder view: 20134)
			)
			(voVeder init:)
		)
		(goMusic1 setMusic: 0)
		(oMyAmbience setAmbient: 20100)
		(gEgo init: normalize:)
		(gEgo setScaler: Scaler 60 60 1 0)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(20200 ; roBitternuts
				(oCliffScrollPlane scrollTo: 0 276)
				(gEgo setScript: soBitternutToStartingLedge)
			)
			(20300 ; roThroneRoom
				(oCliffScrollPlane scrollTo: 0 360)
				(gEgo posn: 576 516)
				(gEgo setLoop: 1)
				(gEgo setScaler: Scaler 33 33 1 0)
				(EnterBridge)
			)
			(20400 ; roDragonCave
				(oCliffScrollPlane scrollTo: 0 1104)
				(gEgo posn: 46 1262)
				(gEgo setLoop: 4)
				(gEgo setScaler: Scaler 60 60 1 0)
				(gEgo setScript: soEnterFromDragonCave)
			)
			(20500 ; roSkunkCave
				(if ((ScriptID 64017 0) test: 88) ; oFlags
					(oCliffScrollPlane scrollTo: 0 982)
					(gEgo setScript: soSkunkCaveBack)
				else
					(oCliffScrollPlane scrollTo: 0 1104)
					(gEgo setScript: soSkunkCaveFront)
				)
			)
			(20900 ; roVedarCu
				(oCliffScrollPlane scrollTo: 0 696)
				(gEgo setScript: soLeaveManLedge)
			)
			(20600 ; roSeraglio
				(oCliffScrollPlane scrollTo: 0 1104)
				(gCurRoom setScript: soClimbFromSeraglio)
			)
			(20700 ; roPhace
				(oCliffScrollPlane scrollTo: 0 1579)
				(gEgo setScript: soClimbUpBigTree)
			)
			(21000 ; roStartingLedgeCu
				(EnterStartingLedge)
				(oCliffScrollPlane scrollTo: 0 276)
				(cond
					(((ScriptID 64017 0) test: 85) ; oFlags
						(gEgo
							posn: 140 463
							setLoop: 6
							setScript: soStartingLedgeToTopLedge 0 0
						)
					)
					(((ScriptID 64017 0) test: 86) ; oFlags
						(gEgo
							posn: 88 463
							setLoop: 7
							setScript: soStartingLedgeToBitternut
						)
					)
					(else
						(gEgo
							posn: 200 468
							setLoop: 3
							setScript: soStartingLedgeToClotheslineLedge
						)
					)
				)
			)
			(20000 ; roChapter2
				(gEgo
					get:
						((ScriptID 64001 0) get: 8) ; oInvHandler, ioShard
						((ScriptID 64001 0) get: 9) ; oInvHandler, ioEressdy
						((ScriptID 64001 1) get: 0) ; oBoogleHandler, ioBoogleBox
						((ScriptID 64001 1) get: 1) ; oBoogleHandler, ioBoogleWorm
						((ScriptID 64001 1) get: 4) ; oBoogleHandler, ioBoogleLantern
				)
				(gCurRoom setScript: soEgoFallsIn)
			)
			(else
				(oCliffScrollPlane scrollTo: 0 276)
				(gEgo setScript: soBitternutToStartingLedge)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 25)) ; oInvHandler, ioBeestLeg
		(gEgo get: ((ScriptID 64001 0) get: 26)) ; oInvHandler, ioDragonPoo
		(gEgo get: ((ScriptID 64001 0) get: 27)) ; oInvHandler, ioHaremPillow
		(gEgo get: ((ScriptID 64001 0) get: 19)) ; oInvHandler, ioWarningTile
	)
)

