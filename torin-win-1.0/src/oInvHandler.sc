;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64001)
(include sci.sh)
(use Main)
(use CueMe)
(use InventItem)
(use oRotInvPlane)

(public
	oInvHandler 0
	oBoogleHandler 1
	GetUnheldCannonball 2
	IsCannonball 3
	NumCannonballsOwned 4
	GetHeldCannonball 5
	LoseAllBut 6
)

(procedure (GetUnheldCannonball)
	(if (not (gEgo has: ioCannonball1))
		(return ioCannonball1)
	)
	(if (not (gEgo has: ioCannonball2))
		(return ioCannonball2)
	)
	(if (not (gEgo has: ioCannonball3))
		(return ioCannonball3)
	)
	(if (not (gEgo has: ioCannonball4))
		(return ioCannonball4)
	)
	(if (not (gEgo has: ioCannonball5))
		(return ioCannonball5)
	)
	(if (not (gEgo has: ioCannonball6))
		(return ioCannonball6)
	)
	(return 0)
)

(procedure (GetHeldCannonball)
	(if (gEgo has: ioCannonball1)
		(return ioCannonball1)
	)
	(if (gEgo has: ioCannonball2)
		(return ioCannonball2)
	)
	(if (gEgo has: ioCannonball3)
		(return ioCannonball3)
	)
	(if (gEgo has: ioCannonball4)
		(return ioCannonball4)
	)
	(if (gEgo has: ioCannonball5)
		(return ioCannonball5)
	)
	(if (gEgo has: ioCannonball6)
		(return ioCannonball6)
	)
	(return 0)
)

(procedure (NumCannonballsOwned &tmp nBalls)
	(= nBalls 0)
	(if (gEgo has: ioCannonball1)
		(++ nBalls)
	)
	(if (gEgo has: ioCannonball2)
		(++ nBalls)
	)
	(if (gEgo has: ioCannonball3)
		(++ nBalls)
	)
	(if (gEgo has: ioCannonball4)
		(++ nBalls)
	)
	(if (gEgo has: ioCannonball5)
		(++ nBalls)
	)
	(if (gEgo has: ioCannonball6)
		(++ nBalls)
	)
	(return nBalls)
)

(procedure (IsCannonball ioThis)
	(if
		(or
			(== ioThis ioCannonball1)
			(== ioThis ioCannonball2)
			(== ioThis ioCannonball3)
			(== ioThis ioCannonball4)
			(== ioThis ioCannonball5)
			(== ioThis ioCannonball6)
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (LoseAllBut args &tmp i j ioTemp bFound nSize)
	(= nSize ((oInvHandler oAllHandledItems:) size:))
	(for ((= i 0)) (< i nSize) ((++ i))
		(if (= ioTemp ((oInvHandler oAllHandledItems:) at: i))
			(= bFound 0)
			(for ((= j 0)) (< j argc) ((++ j))
				(if (== ioTemp [args j])
					(= bFound 1)
				)
			)
			(if (not bFound)
				(ioTemp moveTo: -1)
			else
				(ioTemp moveTo: -3)
			)
		)
	)
	(= nSize ((oBoogleHandler oAllHandledItems:) size:))
	(for ((= i 0)) (< i nSize) ((++ i))
		(if (= ioTemp ((oBoogleHandler oAllHandledItems:) at: i))
			(= bFound 0)
			(for ((= j 0)) (< j argc) ((++ j))
				(if (== ioTemp [args j])
					(= bFound 1)
				)
			)
			(if (not bFound)
				(ioTemp moveTo: -1)
			else
				(ioTemp moveTo: -3)
			)
		)
	)
)

(procedure (MakeHanky)
	(gGame handsOff:)
	(ioSilkWorms deleteHotspotVerb: 55)
	(ioPlaybill deleteHotspotVerb: 54)
	(goSound1 playSound: 50925 coMakeHanky)
)

(procedure (PlaySawBadly)
	(gGame handsOff:)
	(goSound1 playSound: 50926 coBadSaw)
)

(procedure (PlaySaw)
	(if (== gCurRoomNum 51000) ; roOnStage
		(PutAwayEyeItem)
		(gCurRoom setScript: (ScriptID 51000 1)) ; soPlaySaw
	else
		(gGame handsOff:)
		(goSound1 playSound: 50916 (ScriptID 64020 0)) ; oHandsOnWhenCued
	)
)

(procedure (MakeWand)
	(gGame handsOff:)
	(goSound1 playSound: 50910 coMakeWand)
)

(procedure (RosinBow)
	(gEgo put: ioBow)
	(gEgo put: ioRosin)
	(gEgo get: ioRosinedBow)
	((ScriptID 64017 0) set: 176) ; oFlags
)

(instance oInvHandler of InvHandler
	(properties)

	(method (initItems &tmp i nSize ioTemp)
		(self
			add:
				1
				ioRope
				0
				ioAx
				1
				ioRope
				2
				ioPouch
				3
				ioInchworm
				4
				ioChuckBerries
				5
				ioSquareRoot
				6
				ioSnails
				7
				ioMoatScum
				8
				ioShard
				9
				ioEressdy
				10
				ioSlugs
				11
				ioPeat
				12
				ioConsoleShard
				13
				ioLeaf
				14
				ioGuillotineTile
				15
				ioStepTile
				16
				ioTrivetTile
				17
				ioSmallDoorTile
				18
				ioTableTopTile
				19
				ioWarningTile
				20
				ioTubTile
				21
				ioSeatTile
				22
				ioFloorTile
				23
				ioClothespin
				24
				ioBallInvite
				25
				ioBeestLeg
				26
				ioDragonPoo
				27
				ioHaremPillow
				28
				ioRedCarpet
				29
				ioStinkyCarpet
				30
				ioFan
				31
				ioLocket
				32
				ioOpenLocket
				33
				ioCleanTile
				34
				ioKnife
				35
				ioAmmonia
				36
				ioOpenAmmonia
				37
				ioWrench
				38
				ioCannonball1
				39
				ioCannonball2
				40
				ioCannonball3
				41
				ioCannonball4
				42
				ioCannonball5
				43
				ioCannonball6
				44
				ioSilkWorms
				45
				ioPlaybill
				46
				ioBagpipes
				47
				ioTopHat
				48
				ioRabbit
				49
				ioCane
				50
				ioWand
				51
				ioMagicBook
				52
				ioCrystcorder
				53
				ioAudcryst
				54
				ioShatteredShard
				55
				ioSaw
				56
				ioBow
				57
				ioRosin
				58
				ioSilkHanky
				59
				ioMagicTrick
				60
				ioRosinedBow
				61
				ioDawburr
				62
				ioSappyDawburr
		)
		(= nSize (oAllHandledItems size:))
		(for ((= i 0)) (< i nSize) ((++ i))
			(= ioTemp (oAllHandledItems at: i))
			(ioTemp addSelfToCursorList: global100)
		)
	)
)

(instance ioAx of InventItem
	(properties
		verb 2
		noun 2
		vInventory 60300
		vCloseup 60500
	)
)

(instance ioRope of InventItem
	(properties
		verb 4
		noun 3
		vInventory 60301
		vCloseup 60501
	)
)

(instance ioPouch of InventItem
	(properties
		verb 3
		noun 8
		vInventory 60302
		vCloseup 60502
	)
)

(instance ioInchworm of InventItem
	(properties
		verb 18
		noun 4
		vInventory 60303
		vCloseup 60503
	)
)

(instance ioChuckBerries of InventItem
	(properties
		verb 8
		noun 9
		vInventory 60304
		vCloseup 60504
	)
)

(instance ioSquareRoot of InventItem
	(properties
		verb 9
		noun 10
		vInventory 60305
		vCloseup 60505
	)
)

(instance ioSnails of InventItem
	(properties
		verb 10
		noun 11
		vInventory 60306
		vCloseup 60506
	)
)

(instance ioMoatScum of InventItem
	(properties
		verb 11
		noun 12
		vInventory 60307
		vCloseup 60507
	)
)

(instance ioShard of InventItem
	(properties
		verb 12
		noun 13
		vInventory 60308
		vCloseup 60508
	)
)

(instance ioEressdy of InventItem
	(properties
		verb 13
		noun 14
		vInventory 60309
		vCloseup 60509
	)
)

(instance ioSlugs of InventItem
	(properties
		verb 20
		noun 17
		vInventory 60311
		vCloseup 60511
	)
)

(instance ioPeat of InventItem
	(properties
		verb 21
		noun 18
		vInventory 60310
		vCloseup 60510
	)
)

(instance ioConsoleShard of InventItem
	(properties
		verb 22
		noun 19
		vInventory 60312
		vCloseup 60512
	)
)

(instance ioLeaf of InventItem
	(properties
		verb 23
		noun 20
		vInventory 60313
		vCloseup 60513
	)
)

(instance ioGuillotineTile of InventItem
	(properties
		verb 24
		noun 22
		vInventory 60314
		vCloseup 60514
	)
)

(instance ioStepTile of InventItem
	(properties
		verb 25
		noun 23
		vInventory 60315
		vCloseup 60515
	)
)

(instance ioTrivetTile of InventItem
	(properties
		verb 26
		noun 24
		vInventory 60316
		vCloseup 60516
	)
)

(instance ioSmallDoorTile of InventItem
	(properties
		verb 27
		noun 25
		vInventory 60317
		vCloseup 60517
	)
)

(instance ioTableTopTile of InventItem
	(properties
		verb 28
		noun 26
		vInventory 60318
		vCloseup 60518
	)
)

(instance ioWarningTile of InventItem
	(properties
		verb 29
		noun 27
		vInventory 60319
		vCloseup 60519
	)
)

(instance ioTubTile of InventItem
	(properties
		verb 30
		noun 28
		vInventory 60320
		vCloseup 60520
	)
)

(instance ioSeatTile of InventItem
	(properties
		verb 31
		noun 29
		vInventory 60321
		vCloseup 60521
	)
)

(instance ioFloorTile of InventItem
	(properties
		verb 32
		noun 30
		vInventory 60322
		vCloseup 60522
	)
)

(instance ioCleanTile of InventItem
	(properties
		verb 48
		noun 44
		vInventory 60349
		vCloseup 60548
	)
)

(instance ioClothespin of InventItem
	(properties
		verb 33
		noun 31
		vInventory 60323
		vCloseup 60523
	)
)

(instance ioBallInvite of InventItem
	(properties
		verb 34
		noun 32
		vInventory 60324
		vCloseup 60524
	)
)

(instance ioBeestLeg of InventItem
	(properties
		verb 35
		noun 33
		vInventory 60325
		vCloseup 60525
	)
)

(instance ioDragonPoo of InventItem
	(properties
		verb 36
		noun 34
		vInventory 60326
		vCloseup 60526
	)
)

(instance ioHaremPillow of InventItem
	(properties
		verb 37
		noun 35
		vInventory 60327
		vCloseup 60527
	)
)

(instance ioRedCarpet of InventItem
	(properties
		verb 38
		noun 36
		vInventory 60328
		vCloseup 60528
	)
)

(instance ioStinkyCarpet of InventItem
	(properties
		verb 39
		noun 37
		vInventory 60329
		vCloseup 60529
	)
)

(instance ioFan of InventItem
	(properties
		verb 40
		noun 38
		vInventory 60330
		vCloseup 60530
	)
)

(instance ioLocket of InventItem
	(properties
		verb 41
		noun 39
		vInventory 60331
		vCloseup 60531
	)
)

(instance ioOpenLocket of InventItem
	(properties
		verb 73
		noun 86
		vInventory 60362
		vCloseup 60555
	)
)

(instance ioKnife of InventItem
	(properties
		verb 51
		noun 58
		vInventory 60354
		vCloseup 60552
	)
)

(instance ioAmmonia of InventItem
	(properties
		verb 76
		noun 88
		vInventory 60355
		vCloseup 60553
	)
)

(instance ioOpenAmmonia of InventItem
	(properties
		verb 49
		noun 71
		vInventory 60361
		vCloseup 60557
	)
)

(instance ioWrench of InventItem
	(properties
		verb 74
		noun 87
		vInventory 60358
		vCloseup 60558
	)
)

(instance ioCannonball1 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance ioCannonball2 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance ioCannonball3 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance ioCannonball4 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance ioCannonball5 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance ioCannonball6 of InventItem
	(properties
		verb 50
		noun 54
		vInventory 60359
		vCloseup 60559
	)
)

(instance coMakeHanky of CueMe
	(properties)

	(method (cue)
		(gEgo get: ioSilkHanky)
		((ScriptID 64017 0) set: 174) ; oFlags
		(gGame handsOn:)
	)
)

(instance coBadSaw of CueMe
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gMessager say: 11 68 0 0 0 50900) ; "Oouw. This bow could use something to keep it from slipping."
	)
)

(instance coMakeWand of CueMe
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gEgo put: ioCane)
		(gEgo get: ioWand)
		((ScriptID 64017 0) set: 166) ; oFlags
	)
)

(instance ioSilkWorms of InventItem
	(properties
		verb 54
		noun 66
		vInventory 60332
		vCloseup 60532
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 55)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; ioPlaybill
				(MakeHanky)
			)
		)
	)
)

(instance ioPlaybill of InventItem
	(properties
		verb 55
		noun 59
		vInventory 60333
		vCloseup 60533
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 54)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(54 ; ioSilkWorms
				(MakeHanky)
			)
		)
	)
)

(instance ioBagpipes of InventItem
	(properties
		verb 63
		noun 47
		vInventory 60334
		vCloseup 60534
	)
)

(instance ioTopHat of InventItem
	(properties
		verb 57
		noun 68
		vInventory 60335
		vCloseup 60535
	)
)

(instance ioRabbit of InventItem
	(properties
		verb 58
		noun 61
		vInventory 60336
		vCloseup 60536
	)
)

(instance ioCane of InventItem
	(properties
		verb 59
		noun 53
		vInventory 60337
		vCloseup 60537
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 67)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; ioSaw
				(MakeWand)
			)
		)
	)
)

(instance ioWand of InventItem
	(properties
		verb 60
		noun 70
		vInventory 60338
		vCloseup 60538
	)
)

(instance ioMagicBook of InventItem
	(properties
		verb 62
		noun 48
		vInventory 60339
		vCloseup 60539
	)
)

(instance ioCrystcorder of InventItem
	(properties
		verb 64
		noun 55
		vInventory 60340
		vCloseup 60540
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 65 66)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; ioAudcryst
				((ScriptID 64017 0) set: 214) ; oFlags
				(((ScriptID 64001 0) get: 53) moveTo: -1) ; oInvHandler, ioAudcryst
			)
			(66 ; ioShatteredShard
				((ScriptID 64017 0) set: 214) ; oFlags
				(((ScriptID 64001 0) get: 54) moveTo: -1) ; oInvHandler, ioShatteredShard
			)
		)
	)
)

(instance ioAudcryst of InventItem
	(properties
		verb 65
		noun 46
		vInventory 60341
		vCloseup 60540
	)
)

(instance ioShatteredShard of InventItem
	(properties
		verb 66
		noun 45
		vInventory 60342
		vCloseup 60541
	)
)

(instance ioSaw of InventItem
	(properties
		verb 67
		noun 65
		vInventory 60343
		vCloseup 60542
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 59 68 69)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; ioCane
				(MakeWand)
			)
			(68 ; ioBow
				(PlaySawBadly)
			)
			(69 ; ioRosinedBow
				(PlaySaw)
			)
		)
	)
)

(instance ioBow of InventItem
	(properties
		verb 68
		noun 49
		vInventory 60344
		vCloseup 60543
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 70 67)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; ioRosin
				(RosinBow)
			)
			(67 ; ioSaw
				(PlaySawBadly)
			)
		)
	)
)

(instance ioRosin of InventItem
	(properties
		verb 70
		noun 63
		vInventory 60345
		vCloseup 60544
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 68)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(68 ; ioBow
				(RosinBow)
			)
		)
	)
)

(instance ioSilkHanky of InventItem
	(properties
		verb 56
		noun 57
		vInventory 60346
		vCloseup 60545
	)
)

(instance ioMagicTrick of InventItem
	(properties
		verb 61
		noun 69
		vInventory -1
		vCloseup -1
	)
)

(instance ioRosinedBow of InventItem
	(properties
		verb 69
		noun 62
		vInventory 60348
		vCloseup 60547
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 67)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; ioSaw
				(PlaySaw)
			)
		)
	)
)

(instance ioDawburr of InventItem
	(properties
		verb 52
		noun 56
		vInventory 60353
		vCloseup 60551
	)
)

(instance ioSappyDawburr of InventItem
	(properties
		verb 53
		noun 64
		vInventory 60356
		vCloseup 60554
	)
)

(instance ioBoogleBox of InventItem
	(properties
		verb 15
		noun 15
		vInventory 60401
		vCloseup 60601
	)
)

(instance ioBoogleYoYo of InventItem
	(properties
		verb 46
		noun 43
		vInventory 60406
		vCloseup 60606
	)
)

(instance ioBoogleShovel of InventItem
	(properties
		verb 44
		noun 42
		vInventory 60404
		vCloseup 60604
	)
)

(instance ioBoogleLantern of InventItem
	(properties
		verb 45
		noun 41
		vInventory 60405
		vCloseup 60605
	)
)

(instance ioBoogleWorm of InventItem
	(properties
		verb 43
		noun 40
		vInventory 60403
		vCloseup 60603
	)
)

(instance ioBoogleRedCross of InventItem
	(properties
		verb 71
		noun 50
		vInventory 60407
		vCloseup 60607
	)
)

(instance oBoogleHandler of InvHandler
	(properties)

	(method (initItems &tmp i nSize ioTemp)
		(self
			add:
				0
				ioBoogleBox
				2
				ioBoogleYoYo
				3
				ioBoogleShovel
				4
				ioBoogleLantern
				1
				ioBoogleWorm
				5
				ioBoogleRedCross
		)
		(= nSize (oAllHandledItems size:))
		(for ((= i 0)) (< i nSize) ((++ i))
			(if (not (= ioTemp (oAllHandledItems at: i)))
				(break)
			)
			(ioTemp addSelfToCursorList: global100)
		)
	)
)

