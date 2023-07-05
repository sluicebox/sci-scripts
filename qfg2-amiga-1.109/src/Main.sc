;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use n065)
(use TargActor)
(use Interface)
(use VerbMessager)
(use Feature)
(use StopWalk)
(use DCIcon)
(use Grooper)
(use Window)
(use Sound)
(use Save)
(use Motion)
(use File)
(use Game)
(use User)
(use Menu)
(use System)

(public
	Trial 0
	RedrawCast 1
	MaxStamina 2
	MaxMana 3
	MaxHealth 4
	NotClose 5
	AlreadyDone 6
	DontHave 7
	CantDo 8
	InitAddToPics 9
	MoreSpecific 10
	PreLoad 11
	LogIt 12
	Pluralize 13
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gSpeed = 6
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gAddToPics
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gShowStyle = 7
	gAniInterval
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 997
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVolume = 12
	gVersion
	gLocales
	; 30
	gCurSaveDir
	global31
	global32
	global33
	global34
	; 35
	global35
	global36
	global37
	global38
	global39
	; 40
	global40
	global41
	global42
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	gAniThreshold = 10
	gPerspective
	gFeatures
	gSortedFeatures
	global54
	; 55
	global55
	global56
	global57 = -1
	global58
	gSfWin
	; 60
	global60 = 3
	global61
	global62
	global63
	global64
	; 65
	global65
	global66
	global67
	global68
	global69
	; 70
	global70
	global71
	global72
	gFtrInitCode
	gHQVerbCode
	; 75
	global75
	global76 = 1
	global77
	global78
	global79
	; 80
	global80
	global81
	global82
	global83
	global84
	; 85
	global85
	global86
	global87
	global88
	global89
	; 90
	global90
	global91
	global92
	global93
	global94
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	gEgoGait
	gDebugging
	gCantTalk
	gEgoX
	gEgoY
	; 105
	gMachineSpeed
	gCSound
	gYesNoTimer
	gLastRestTime
	gLastRestDay
	; 110
	gDay
	gClock
	gTimeODay
	gNight
	gOldSysTime
	; 115
	gHeroType
	gHowFast
	gTransferRoom
	gKeyDownHandler
	gMouseDownHandler
	; 120
	gDirectionHandler
	gCustomWindow
	gEgoStopWalk
	gLogFile
	gRoomExitDir
	; 125
	gEgoLooper
	gFastEgo
	gNumColors
	gNumVoices
	gStamCounter = 20
	; 130
	gHealCounter = 15
	gDrinksLeft
	gFreeMeals
	gLockPickBonus
	gZapPower
	; 135
	gMonsterDazzle
	gTargetAngles = 180
	global137
	global138 = 45
	global139 = 90
	; 140
	global140 = 135
	global141 = 180
	global142 = 225
	global143 = 270
	global144 = 315
	; 145
	gLostSleep
	gMissedDaggers
	gHitDaggers
	gDaggerRoom
	gSameColor = 9
	; 150
	gChangeColor = 12
	gDftStatusCode
	gCombatIconView
	gStatusBarView
	gCombatColor
	; 155
	gDeathMusic = 10
	gManaCounter = 5
	gXEgo
	gYEgo
	gWrestlingBet
	; 160
	gSwordBonus
	gCantMove
	gReversalTimer
	gEgoBaseSetter
	gMiscSound
	; 165
	gTimeScale = 1
	gLevHighY
	gLevScript
	gRopeHighY
	gRopeScript
	; 170
	gRopeUses = 50
	gCIcon
	gElementalState
	gThirstCounter = 50
	gSpellChecker
	; 175
	gDefaultChecker
	gAllChecker
	gNoChecker
	gNoWalkCursor = 999
	gNoTalkCursor = 997
	; 180
	gSillyClowns
	gPaladinPoints
	gSpareSound
	gDftHowFast
	gTimeToEat
	; 185
	gNumScorpTails
	gNumGhoulClaws
	gOrigHeroType
	gRoomThanks
	gCurDayElemState
	; 190
	gHowMuchMemory
	gPlazaDoorOpen
	gRoomAsks
	gEgoWalk
	gOddTime
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200
	global201
	global202
	global203
	global204
	; 205
	global205
	global206
	global207
	global208
	global209
	; 210
	global210
	global211
	global212
	global213
	global214
	; 215
	global215
	global216
	global217
	global218
	global219
	; 220
	global220
	global221
	global222
	global223
	global224
	; 225
	global225
	global226
	global227
	global228
	global229
	; 230
	global230
	global231
	global232
	global233
	global234
	; 235
	global235
	global236
	global237
	global238
	global239
	; 240
	global240
	global241
	global242
	global243
	global244
	; 245
	global245
	global246
	global247
	global248
	global249
	; 250
	global250
	gMoneyDate = -1
	gBucks
	gMonsterNum
	gMonsterHealth
	; 255
	gShieldRoom
	gOldScore
	gInnLastHere
	gInnLastAte
	gEnter140 = 1
	; 260
	gGuildLastHere
	gFortuneDay = -1
	gAstroVisits
	gAlleyScript
	gHarikVisits
	; 265
	gHarikDay
	gUSE_ME_sits
	gEnchLastHere
	gEnter320
	gMonsterMode
	; 270
	gMonsterRoom
	gFakirVisits
	gTightropeTried
	gTightWinCount
	gAzizaTemper
	; 275
	gLastTimeIn
	gGriffinPOed
	gNow
	gCloseUpSubject
	gCageLastHere
	; 280
	gBeastCare
	gTashtariMsgNum
	gSabaMsgNum
	gLashamMsgNum
	gWimpyHero
	; 285
	gCurDayMsg
	gSloreeMsgNum
	gToshurMsgNum
	gKiramMsgNum
	gMirakMsgNum
	; 290
	gDropObjRoom
	gDropObjPosn
	gAirPoints
	gClumpsLeft
	gFollowTime
	; 295
	gInnState
	gFallCount
	gArcadeLevel
	gEarthElemHealth = 20
	gEarthElemStamina = 20
	; 300
	gDesertRoom
	gMagicLastHere
	gMagicTrips
	gPlazaLastHere
	gBattleResult
	; 305
	gGateGuards
	gGriffinHealth
	gNAlichicaVisits
	gDesertFunCtr
	gSaurusRoom
	; 310
	gNumJackals
	gJackalsKilled
	gRasGuardLeft
	gGuildCount1
	gGuildCount2
	; 315
	gNoLevel
	gHuhLevel
	gEnchAlleyLast
	global318
	global319
	; 320
	global320
	global321
	global322
	global323
	global324
	; 325
	global325
	global326
	global327
	global328
	global329
	; 330
	global330
	global331
	global332
	global333
	global334
	; 335
	global335
	gInvNum
	global337
	global338
	global339
	; 340
	global340
	global341
	global342
	global343
	global344
	; 345
	global345
	global346
	global347
	global348
	global349
	; 350
	global350
	global351
	global352
	global353
	global354
	; 355
	global355
	global356
	global357
	global358
	global359
	; 360
	global360
	global361
	global362
	global363
	global364
	; 365
	global365
	global366
	global367
	global368
	global369
	; 370
	global370
	global371
	global372
	global373
	global374
	; 375
	global375
	global376
	global377
	global378
	global379
	; 380
	global380
	global381
	global382
	global383
	global384
	; 385
	global385
	global386
	global387
	global388
	global389
	; 390
	global390
	global391
	global392
	global393
	global394
	; 395
	global395
	global396
	global397
	global398
	global399
	; 400
	global400
	gInvDropped
	global402
	global403
	global404
	; 405
	global405
	global406
	global407
	global408
	global409
	; 410
	global410
	global411
	global412
	global413
	global414
	; 415
	global415
	global416
	global417
	global418
	global419
	; 420
	global420
	global421
	global422
	global423
	global424
	; 425
	global425
	global426
	global427
	global428
	global429
	; 430
	global430
	global431
	global432
	global433
	global434
	; 435
	global435
	global436
	global437
	global438
	global439
	; 440
	global440
	global441
	global442
	global443
	global444
	; 445
	global445
	global446
	global447
	global448
	global449
	; 450
	global450
	global451
	global452
	global453
	global454
	; 455
	global455
	global456
	global457
	global458
	global459
	; 460
	global460
	global461
	global462
	global463
	global464
	; 465
	global465
	gInvWeight
	gWicentime = 1
	gWidinar = 4
	gWifood = 20
	; 470
	gWisword = 420
	gWidagger = 60
	gWileather = 1200
	gWishield = 720
	gWipaper = 1
	; 475
	gWirock = 30
	gWipick = 5
	gWikit = 30
	gWilicense = 2
	gWiincense = 10
	; 480
	gWibeard = 4
	gWimail = 2100
	gWirope = 300
	gWigold = 1
	gWiheal = 40
	; 485
	gWimana = 40
	gWivigor = 40
	gWidispel = 40
	gWimap = 4
	gWicompass = 10
	; 490
	gWifinesword = 420
	gWibellows = 300
	gWiflower = 2
	gWisapphpin = 10
	gWifeather = 1
	; 495
	gWiscorp = 120
	gWighoul = 30
	gWisoulforge = 480
	gWidirt = 60
	gWilamp = 180
	; 500
	gWibasket = 20
	gWiemptypot = 20
	gWifruit = 10
	gWiwaterskin = 30
	gWiclothbag = 10
	; 505
	gWiburnpowder = 5
	gWieoftoken = 4
	gWivisa = 1
	gWioil = 30
	gWimagicwater = 10
	; 510
	gWiring = 12
	gWiscarf = 2
	gWimirror = 30
	gWibird = 900
	gWicurepill = 40
	; 515
	gWiclothes = 150
	gWisaurus
	gWibagofsand = 180
	gWimagicearth = 180
	gWiteapot = 180
	; 520
	gWiglasses = 15
	gWipurse = 15
	gWisilverdagger = 150
	gWibowl = 360
	gWinail = 3
	; 525
	global525
	global526
	global527
	global528
	global529
	; 530
	global530
	gOldStats
	global532
	global533
	global534
	; 535
	global535
	global536
	global537
	global538
	global539
	; 540
	global540
	global541
	global542
	global543
	global544
	; 545
	global545
	global546
	global547
	global548
	global549
	; 550
	global550
	global551
	global552
	global553
	global554
	; 555
	global555
	global556
	global557
	global558
	global559
	; 560
	global560
	global561
	global562
	global563
	global564
	; 565
	global565
	global566
	global567
	global568
	global569
	; 570
	gEndStats
	gEgoStats
	global572
	global573
	global574
	; 575
	global575
	global576
	global577
	global578
	global579
	; 580
	global580
	global581
	global582
	global583
	global584
	; 585
	global585
	global586
	global587
	global588
	global589
	; 590
	global590
	global591
	global592
	global593
	global594
	; 595
	global595
	global596
	global597
	global598
	global599
	; 600
	global600
	global601
	global602
	global603
	global604
	; 605
	global605
	global606
	global607
	global608
	global609
	; 610
	global610
	gSkillTicks
	global612
	global613
	global614
	; 615
	global615
	global616
	global617
	global618
	global619
	; 620
	global620
	global621
	global622
	global623
	global624
	; 625
	global625
	global626
	global627
	global628
	global629
	; 630
	global630
	global631
	global632
	global633
	global634
	; 635
	global635
	global636
	global637
	global638
	global639
	; 640
	global640
	global641
	global642
	global643
	global644
	; 645
	global645
	global646
	global647
	global648
	global649
	; 650
	gLastSkillTick
	gSpCostOpen = 2
	gSpCostDetect = 2
	gSpCostTrigger = 3
	gSpCostDazzle = 3
	; 655
	gSpCostZap = 3
	gSpCostCalm = 4
	gSpCostFlame = 5
	gSpCostFetch = 5
	gSpCostForce = 6
	; 660
	gSpCostLevitate = 7
	gSpCostReversal = 8
	global662
	global663
	global664
	; 665
	global665
	global666
	global667
	global668
	global669
	; 670
	gSpellCostEnd
	gUserName
	global672
	global673
	global674
	; 675
	global675
	global676
	global677
	global678
	global679
	; 680
	global680
	global681
	global682
	global683
	global684
	; 685
	global685
	global686
	global687
	global688
	global689
	; 690
	global690
	gEndUserName
	gLogName
	global693
	global694
	; 695
	global695
	global696
	global697
	global698
	gEndLogName
	; 700
	gGameFlags
	global701
	global702
	global703
	global704
	; 705
	global705
	global706
	global707
	global708
	global709
	; 710
	global710
	global711
	global712
	global713
	global714
	; 715
	global715
	global716
	global717
	global718
	global719
	; 720
	global720
	global721
	global722
	global723
	global724
	; 725
	global725
	global726
	global727
	global728
	global729
	; 730
	global730
	global731
	global732
	global733
	global734
	; 735
	global735
	global736
	global737
	global738
	global739
	; 740
	global740
	global741
	global742
	global743
	global744
	; 745
	global745
	global746
	global747
	global748
	gEndGameFlags
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (MaxStamina)
	(return (* (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, Vitality
)

(procedure (MaxHealth &tmp tmpHealth)
	(return (* 2 (= tmpHealth (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)))) ; strength, Vitality, Vitality
)

(procedure (MaxMana &tmp egoMagic)
	(return (and (= egoMagic [gEgoStats 12]) (/ (+ [gEgoStats 1] egoMagic egoMagic) 3))) ; magic use, intelligence
)

(procedure (NotClose)
	(HighPrint 0 91) ; "You're not close enough."
)

(procedure (MoreSpecific)
	(HighPrint 0 92) ; "Please, Effendi. A thousand pardons, but I do not understand"
)

(procedure (AlreadyDone)
	(HighPrint 0 93) ; "You've already done that."
)

(procedure (CantDo) ; UNUSED
	(HighPrint 0 94) ; "You can't do that now."
)

(procedure (DontHave)
	(HighPrint 0 95) ; "You don't have it."
)

(procedure (InitAddToPics)
	(gAddToPics add: &rest eachElementDo: #init doit:)
)

(procedure (PreLoad which &tmp i)
	(for ((= i 0)) (< i argc) ((++ i))
		(ScriptID [which i])
	)
)

(procedure (LogIt what why &tmp [str 100])
	(if (or gDebugging 0)
		(gLogFile
			writeString: (Format @str 0 97 gCurRoomNum what why) ; "RM%03d: %s: "%s""
			close:
		)
	)
)

(procedure (lastDagger num)
	(return
		(not
			(or
				[gInvNum 31] ; Soulforge
				[gInvNum 24] ; FineSword
				[gInvNum 4] ; Sword
				[gInvNum 56] ; SilverDagger
				(u> [gInvNum 5] num) ; Dagger
			)
		)
	)
)

(procedure (Pluralize strAddr index count &tmp temp0)
	(= temp0 (if (>= argc 3) count else [gInvNum index]))
	(if (== index 13)
		(Format strAddr 11 (+ index index) (if (> temp0 1) {es} else {}))
	else
		(Format strAddr 11 (+ index index) (if (> temp0 1) {s} else {}))
	)
)

(class HQEgo of Ego
	(properties
		hurtScript 0
	)

	(method (has what)
		(return [gInvNum what])
	)

	(method (get what howMany &tmp obj num oldNum curW maxW)
		(= oldNum [gInvNum what])
		(if (< (= num (+ (= num (if (== argc 1) 1 else howMany)) oldNum)) 0)
			(= num 0)
		)
		(= [gInvNum what] num)
		(cond
			((> (= curW (WtCarried)) (= maxW (MaxLoad)))
				(HighPrint 0 0) ; "You are carrying so much that you can hardly move. You'd better drop something soon."
				(SetFlag 6)
			)
			((and (< num oldNum) (IsFlag 6) (> (- maxW curW) 180))
				(HighPrint 0 1) ; "Ah, that's better. You're no longer so overloaded."
				(ClearFlag 6)
			)
		)
		(return (- num oldNum))
	)

	(method (put what howMany &tmp obj num index theRoom)
		(= num (if (== argc 1) 1 else howMany))
		(if (= num (self use: what num))
			(if (== (= theRoom gCurRoomNum) 665)
				(= theRoom (- gDesertRoom))
			)
			(if (!= gDropObjRoom theRoom)
				(= gDropObjRoom theRoom)
				(for ((= index 1)) (<= index 58) ((++ index))
					(= [gInvDropped index] 0)
				)
			)
			(+= [gInvDropped what] num)
		)
		(return num)
	)

	(method (use what howMany &tmp obj num oldNum maxDrinks)
		(if (> (= num (if (== argc 1) 1 else howMany)) [gInvNum what])
			(= num [gInvNum what])
		)
		(self get: what (- num))
		(= maxDrinks (* [gInvNum 37] 10)) ; Waterskin
		(if (> gDrinksLeft maxDrinks)
			(= gDrinksLeft maxDrinks)
		)
		(return num)
	)

	(method (drop what)
		(self put: what &rest)
	)

	(method (pickUp what howMany &tmp obj num index count some theRoom)
		(= num (if (== argc 1) 1 else howMany))
		(= some (= count 0))
		(if (== (= theRoom gCurRoomNum) 665)
			(= theRoom (- gDesertRoom))
		)
		(if (== gDropObjRoom theRoom)
			(= count [gInvDropped what])
		)
		(if count
			(= some (if (u< count num) count else num))
			(self get: what some)
			(-= [gInvDropped what] some)
		)
		(return some)
	)

	(method (knows what)
		(return [gEgoStats what])
	)

	(method (learn what howWell &tmp obj num)
		(= num (if (== argc 1) 5 else howWell))
		(if (and [gEgoStats 12] (> num [gEgoStats what])) ; magic use
			(return (= [gEgoStats what] num))
		else
			(return 0)
		)
	)

	(method (hurtMe amount whatHurt &tmp isHeAlive hurtObj)
		(= hurtObj (if (>= argc 2) whatHurt else 0))
		(= isHeAlive (TakeDamage amount))
		(cond
			(hurtScript
				(self setScript: hurtScript 0 hurtObj)
			)
			((not isHeAlive)
				(EgoDead 1 0 2 #title {Ouch!}) ; "That really hurt. But it only really hurt for a few moments. The pain is quite gone now. So is every other sensation. Taking quick stock of your condition, you find the reason -- you're dead. Better run away next time."
			)
		)
		(return 1)
	)
)

(instance egoBase of Code
	(properties)

	(method (doit theActor &tmp theX theY)
		(= theX (theActor x:))
		(= theY (+ 1 (theActor y:)))
		(theActor
			brTop: (- theY 2)
			brBottom: theY
			brLeft: (- theX 9)
			brRight: (+ theX 9)
		)
	)
)

(instance ego of HQEgo
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(== (event modifiers:) emSHIFT)
					(self onMe: event)
				)
				(event claimed: 1)
				(HighPrint 0 3) ; "Obviously a graduate of the Famous Adventurers' Correspondence School."
			)
		)
	)
)

(instance ftrInitCode of Code
	(properties)

	(method (doit theObj)
		(if (== (theObj sightAngle:) 26505)
			(theObj sightAngle: 180)
		)
		(if (== (theObj closeRangeDist:) 26505)
			(theObj closeRangeDist: 500)
		)
		(if (== (theObj longRangeDist:) 26505)
			(theObj longRangeDist: 500)
		)
		(if (== (theObj shiftClick:) 26505)
			(theObj shiftClick: 1)
		)
		(if (== (theObj contClick:) 26505)
			(theObj contClick: 0)
		)
		(if (== (theObj actions:) 26505)
			(theObj actions: 0)
		)
		(if (== (theObj control:) 26505)
			(theObj control: 0)
		)
		(if (== (theObj verbChecks1:) 26505)
			(theObj verbChecks1: -17483)
		)
		(if (== (theObj verbChecks2:) 26505)
			(theObj verbChecks2: -17477)
		)
		(if (== (theObj verbChecks3:) 26505)
			(theObj verbChecks3: -17477)
		)
	)
)

(instance verbWords of VerbMessager
	(properties
		ssLook 'look,look>'
		ssOpen 'open,open>'
		ssClose 'close,close>'
		ssSmell 'smell>'
		ssMove 'move>'
		ssEat 'eat,eat>'
		ssGet 'get,get,(lockpick<up)>'
		ssClimb 'climb,climb>'
		ssTalk 'talk,talk,talk>'
	)
)

(instance HQVerbCode of Code
	(properties)

	(method (doit theObj theVerb &tmp [str 100])
		(switch theVerb
			(1
				(if (theObj lookStr:)
					(HighPrint (theObj lookStr:))
				else
					(HighPrint (Format @str 0 4 (theObj description:))) ; "It is %s."
				)
			)
			(2
				(HighPrint (Format @str 0 5 (theObj description:))) ; "You can't open %s."
			)
			(3
				(HighPrint (Format @str 0 6 (theObj description:))) ; "You can't close %s."
			)
			(4
				(HighPrint 0 7) ; "The smell is exactly as you would expect."
			)
			(5
				(HighPrint (Format @str 0 8 (theObj description:))) ; "You can't move %s."
			)
			(6
				(HighPrint (Format @str 0 9 (theObj description:))) ; "You wouldn't want to eat %s."
			)
			(7
				(HighPrint (Format @str 0 10 (theObj description:))) ; "You can't get %s."
			)
			(8
				(HighPrint (Format @str 0 11 (theObj description:))) ; "You can't climb %s."
			)
			(9
				(HighPrint (Format @str 0 12 (theObj description:))) ; "Don't bother trying to talk to %s."
			)
		)
	)
)

(instance deathIcon of DCIcon
	(properties
		view 999
		cycleSpeed 10
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance cMusic of Sound
	(properties
		number 10
	)
)

(instance miscMusic of Sound
	(properties
		number 10
		priority 15
	)
)

(instance spareMusic of Sound
	(properties
		number 10
	)
)

(instance errLog of File
	(properties)
)

(instance statLn of Code
	(properties)

	(method (doit str)
		(Format str 0 13 gScore gPossibleScore) ; "Quest for Glory II: Trial By Fire [%d of %d]"
	)
)

(instance keyH of EventHandler
	(properties)

	(method (handleEvent event)
		(if (and (not (super handleEvent: event)) (== (event message:) KEY_RETURN))
			(cls)
			(event claimed: 1)
		)
	)
)

(instance dirH of EventHandler
	(properties)
)

(instance mouseH of EventHandler
	(properties)
)

(instance sfWin of SysWindow
	(properties)
)

(instance cWin of SysWindow
	(properties)
)

(instance Trial of Game
	(properties)

	(method (play)
		(Feature shiftClick: 0 contClick: 0)
		(super play: &rest)
	)

	(method (init &tmp promptString)
		(SetFlag 16)
		(= gHowMuchMemory (if (>= (MemoryInfo 4) 17408) 1 else 0)) ; TotalHunk
		(= gSfWin sfWin)
		(= gCustomWindow cWin)
		(= gEgo ego)
		(= gEgoBaseSetter egoBase)
		(= gVersion {x.yyy    })
		(= gWaitCursor 997)
		(SL code: (= gDftStatusCode statLn))
		Cycle
		StopWalk
		DCIcon
		Window
		MenuBar
		HandsOffScript
		TopWindow
		TargActor
		(PreLoad 255 958 990 982 984 1 2 23)
		(Lock rsTEXT 0 1)
		(Lock rsTEXT 10 1)
		(Lock rsTEXT 997 1)
		(super init:)
		((= gKeyDownHandler keyH) add:)
		((= gMouseDownHandler mouseH) add:)
		((= gDirectionHandler dirH) add:)
		(= global54 1)
		(= gFtrInitCode ftrInitCode)
		(= gNumVoices (DoSound sndGET_POLYPHONY))
		(= gHQVerbCode HQVerbCode)
		(= gEgoWalk egoW)
		(= gEgoStopWalk egoSW)
		(= gEgoLooper egoGL)
		(= gLogFile errLog)
		(= gSpellChecker (= gDefaultChecker dftSC))
		(= gAllChecker allSC)
		(= gNoChecker noSC)
		((= gCSound cMusic) number: 10 owner: self init:)
		(= gCIcon deathIcon)
		((= gMiscSound miscMusic) number: 10 owner: self init:)
		((= gSpareSound spareMusic) number: 10 owner: self init:)
		(InitGlobals)
		(= promptString {*})
		(StrAt promptString 0 0)
		(User
			alterEgo: gEgo
			prompt: promptString
			blocks: 0
			y: 160
			verbMessager: verbWords
		)
		(MenuBar init:)
		(HandsOn 1)
		(= gTransferRoom (GameStartRoom))
		(gGame newRoom: 98) ; speedChecker
	)

	(method (doit &tmp thisTime sickBits [egoView 2])
		(super doit:)
		(if (IsFlag 2)
			(= thisTime (GetTime 1)) ; SysTime12
			(if (!= gOldSysTime thisTime)
				(= gOldSysTime thisTime)
				(if (< gDay 30)
					(= sickBits gClock)
					(++ gClock)
					(if (== (++ gOddTime) 2)
						(= gOddTime 0)
						(+= gClock (- gTimeScale 1))
					)
					(if (>= gClock 3600)
						(= gClock 0)
						(NextDay)
					)
					(if (< (mod gClock 150) (mod sickBits 150))
						(FixTime)
					)
					(if (or (< 1050 gClock 1100) (< 2450 gClock 2500))
						(= gTimeToEat 1)
					)
				)
				(if (== gEgoGait 2) ; sneaking
					(SkillUsed 8 2) ; sneak
				)
				(if (not (-- gStamCounter))
					(= gStamCounter 20)
					(if
						(and
							(or (< 1100 gClock 1200) (< 2500 gClock 2600))
							gTimeToEat
						)
						(= gTimeToEat 0)
						(EatMeal)
					)
					(cond
						(
							(or
								(> gLostSleep 1)
								(IsFlag 6)
								(IsFlag 5)
								(IsFlag 137)
							)
							(UseStamina 5)
							(if (IsFlag 6)
								(SkillUsed 0 2) ; strength
							)
						)
						((or (== gEgoGait 1) (IsFlag 3)) ; running
							(UseStamina 2)
						)
						((== gEgoGait 2) ; sneaking
							(UseStamina 1)
						)
						((and (not (IsFlag 4)) (not gLostSleep))
							(UseStamina -1)
						)
					)
					(if (not (-- gManaCounter))
						(= gManaCounter 5)
						(UseMana -1)
					)
					(if (not (-- gHealCounter))
						(= gHealCounter 15)
						(if (not (or (> gLostSleep 1) (IsFlag 5) (IsFlag 137)))
							(TakeDamage -1)
						)
					)
					(if (not (-- gThirstCounter))
						(= gThirstCounter 50)
						(cond
							((DrinkWater 0))
							((IsFlag 137)
								(if (not (TakeDamage 2))
									(EgoDead 1 0 14 #title {Too thirsty to go on}) ; "You collapse in the hot desert air and never awaken. Truly it is said that "Water is life itself in a desert land.""
								)
							)
							((IsFlag 3)
								(SetFlag 137)
								(HighPrint 0 15) ; "You must get water soon, or you will surely die of thirst."
							)
							(else
								(SetFlag 3)
								(HighPrint 0 16) ; "The dry desert air seems to suck the moisture right out of your body."
							)
						)
					)
				)
				(if (and (not (IsFlag 140)) (IsFlag 86))
					(switch (-- gReversalTimer)
						(0
							(ClearFlag 86)
							(gMiscSound number: 35 loop: 1 priority: 12 play:)
							(HighPrint 0 17) ; "Your Reversal spell has worn off."
						)
						(10
							(HighPrint 0 18) ; "Your Reversal spell is wearing thin."
						)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(HandsOn 1)
		(super newRoom: newRoomNumber)
		(ShowTheCursor 304 174)
	)

	(method (startRoom nr &tmp newRegion)
		(StartARoom nr)
		(if (u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
			(cond
				(gDebugging
					(if (Print 0 19 #button {test} 1) ; "Memory fragmented."
						(gGame showMem:)
						(SetDebug)
					)
				)
				((not (SetFlag 187))
					(HighPrint 0 20) ; "You thought for a moment that you saw a deadly Fragmentation Bug, but then realize that it is actually the harmless Southern variety. You squash it under your boot, and it vanishes."
				)
			)
		)
		(gMouseDownHandler add: gCast gFeatures)
		(if
			(OneOf
				gCurRoomNum
				764 ; noticeRoom
				765 ; notice2Room
				750 ; intro
				770 ; OpeningCredits
				785 ; CarpetLand
				800 ; selChar
				810 ; chAlloc
				805 ; import
				98 ; speedChecker
				850 ; closingCredits
				820 ; rmEndCartoon
				821 ; rmEndCartoon2
				822 ; rmEndCartoon3
			)
			(SL disable:)
		else
			(SL enable:)
		)
		(= gSpellChecker gDefaultChecker)
		(= global76 0)
		(NormalEgo)
		(gEgo hurtScript: 0)
		(= gRoomThanks (= gRoomAsks 0))
		(User verbMessager: verbWords)
		(super startRoom: nr)
		(ClearFlag 28)
		(if gDebugging
			(gCurRoom setLocales: 99)
		)
	)

	(method (handleEvent event &tmp num index gotOne theRoom dropQty strNum [str 50] [str2 20])
		(if
			(and
				(or gDebugging 0)
				(not (event claimed:))
				(== (event message:) KEY_ALT_n)
			)
			((ScriptID 952) doit: @global63 addLog) ; sysLogger
			(event claimed: 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(gKeyDownHandler handleEvent: event)
			)
			(evMOUSEBUTTON
				(gMouseDownHandler handleEvent: event)
			)
			(evMOUSERELEASE
				(gCast handleEvent: event)
			)
			($0040 ; direction
				(gDirectionHandler handleEvent: event)
			)
			(evJOYDOWN
				(event type: evKEYBOARD message: KEY_RETURN)
				(gKeyDownHandler handleEvent: event)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'get,use,eat,eat/pill>')
						(TakePill event (SaidInv event))
					)
					((Said 'rub,rub,use,light,(turn<on)/lamp,light')
						(cond
							((not (gEgo has: 33)) ; BrassLamp
								(HighPrint 0 21) ; "Great idea. If you could, you would."
							)
							((>= gElementalState 2)
								(HighPrint 0 22) ; "The lamp seems to enjoy that (but it's just your imagination)."
							)
							(else
								(HighPrint 0 23) ; "You faintly hear "To the left... up... ahh, right there!" The lamp glows faintly with pleasure, then decides it isn't dark enough to really put on a show, and goes out again."
							)
						)
					)
					(
						(and
							(gEgo has: 41) ; Visa
							(or (Said 'show/visa') (Said 'show//visa'))
						)
						(HighPrint 0 24) ; "It's not as effective as Raseirian Express."
					)
					((Said 'use,wear,(put<on)/glasses[<ray]')
						(cond
							((IsFlag 125)
								(HighPrint 0 25) ; "Silly you! They're right there on the end of your nose!"
							)
							((gEgo has: 54) ; Glasses
								(SetFlag 125)
								(HighPrint 0 26) ; "You put on the Ali Fakir Genuine X-Ray Glasses. Suddenly, everything appears as though you were looking through a veil."
							)
							(else
								(HighPrint 0 27) ; "Yeh! Glasses! Maybe that's what you need to stop those migraines. Too bad you don't have any."
							)
						)
					)
					((Said 'get,(put<away),(get<off)/glasses[<ray]')
						(if (IsFlag 125)
							(ClearFlag 125)
							(HighPrint 0 28) ; "You take off the glasses and put them away."
						else
							(HighPrint 0 29) ; "You're not wearing them."
						)
					)
					(
						(and
							(gEgo has: 55) ; Purse
							(Said
								'get,get,get,grab/alm,dinar,cent/purse,bag,pouch'
							)
						)
						(if (SetFlag 135)
							(AlreadyDone)
						else
							(gEgo get: 2 6) ; Dinar
							(gEgo get: 1 25) ; Centime
							(SkillUsed 14 -300) ; honor
						)
					)
					((Said 'get,get,(lockpick<up)>')
						(cond
							((Said '/pan[<!*][/!*]')
								(cond
									((gEgo pickUp: 35 -1)
										(HighPrint 0 30) ; "Ok, you get the empty pot."
									)
									((gEgo pickUp: 32 -1)
										(HighPrint 0 31) ; "Ok, you get the pot of dirt."
									)
									((or (gEgo has: 32) (gEgo has: 35)) ; PotOfDirt, EmptyPot
										(HighPrint 0 32) ; "You have it already."
									)
									(else
										(HighPrint 0 33) ; "There aren't any here."
									)
								)
								(return)
							)
							((Said '/bag[<!*][/!*]')
								(cond
									((gEgo pickUp: 52 -1)
										(HighPrint 0 34) ; "Ok, you pick up the bag."
									)
									((gEgo pickUp: 51 -1)
										(HighPrint 0 34) ; "Ok, you pick up the bag."
									)
									((gEgo pickUp: 38 -1)
										(HighPrint 0 34) ; "Ok, you pick up the bag."
									)
									(
										(or
											(gEgo has: 52) ; MagicEarth
											(gEgo has: 38) ; ClothBag
											(gEgo has: 51) ; BagOfSand
										)
										(HighPrint 0 32) ; "You have it already."
									)
									(else
										(HighPrint 0 33) ; "There aren't any here."
									)
								)
								(return)
							)
							(else
								(= index (SaidInv event))
							)
						)
						(cond
							((== index 0)
								(HighPrint 0 35) ; "You can't get that."
							)
							((== index 7)
								(if (== gCurRoomNum gShieldRoom)
									(gEgo get: 7) ; Shield
									(HighPrint 0 36) ; "You retrieve your shield."
									(= gShieldRoom 0)
								else
									(HighPrint 0 37) ; "There isn't a shield here."
								)
							)
							(
								(and
									(== index 5)
									(or
										(== gCurRoomNum gDaggerRoom)
										(and
											(== gCurRoomNum 665) ; desert
											(== gDaggerRoom (- gDesertRoom))
										)
									)
								)
								(if (and gMonsterNum (> gMonsterHealth 0))
									(HighPrint 0 38) ; "You will have to finish off your opponent first."
								else
									(= gotOne 0)
									(= gDaggerRoom 0)
									(= num gMissedDaggers)
									(if (== (= theRoom gCurRoomNum) 665)
										(= theRoom (- gDesertRoom))
									)
									(if (== gDropObjRoom theRoom)
										(+= num [gInvDropped 5]) ; Dagger
										(= [gInvDropped 5] 0) ; Dagger
									)
									(if num
										(= gotOne 1)
										(gEgo get: 5 num) ; Dagger
										(HighPrint 0 39) ; "You pick up the loose daggers."
									)
									(if gHitDaggers
										(= gotOne 1)
										(gEgo get: 5 gHitDaggers) ; Dagger
										(HighPrint 0 40) ; "You retrieve your knives and carefully wipe them clean for reuse."
									)
									(= gHitDaggers (= gMissedDaggers 0))
									(if (not gotOne)
										(HighPrint 0 33) ; "There aren't any here."
									)
								)
							)
							((Said '/water')
								(DrinkWater 1)
							)
							((= dropQty (gEgo pickUp: index -1))
								(Format ; "Ok, you pick %s up."
									@str
									0
									41
									(if (> dropQty 1) {them} else {it})
								)
								(HighPrint @str)
							)
							((gEgo has: index)
								(HighPrint 0 32) ; "You have it already."
							)
							(else
								(HighPrint 0 33) ; "There aren't any here."
							)
						)
					)
					((or (Said 'put<down>') (Said 'drop>'))
						(if (Said '/<all>')
							(= dropQty 20000)
						else
							(= dropQty 1)
						)
						(cond
							((Said '/pan[<!*][/!*]')
								(cond
									((and (gEgo has: 35) (gEgo has: 32)) ; EmptyPot, PotOfDirt
										(HighPrint 0 42) ; "Which one?"
										(return)
									)
									((gEgo has: 35) ; EmptyPot
										(= index 35)
									)
									((gEgo has: 32) ; PotOfDirt
										(= index 32)
									)
									(else
										(= index 32)
									)
								)
							)
							((Said '/bag[<!*][/!*]')
								(cond
									(
										(or
											(and
												(gEgo has: 52) ; MagicEarth
												(gEgo has: 38) ; ClothBag
											)
											(and
												(gEgo has: 52) ; MagicEarth
												(gEgo has: 51) ; BagOfSand
											)
											(and
												(gEgo has: 51) ; BagOfSand
												(gEgo has: 38) ; ClothBag
											)
										)
										(HighPrint 0 42) ; "Which one?"
										(return)
									)
									((gEgo has: 52) ; MagicEarth
										(= index 52)
									)
									((gEgo has: 38) ; ClothBag
										(= index 38)
									)
									((gEgo has: 51) ; BagOfSand
										(= index 51)
									)
									(else
										(= index 38)
									)
								)
							)
							(else
								(= index (SaidInv event))
							)
						)
						(cond
							((not index)
								(HighPrint 0 43) ; "I don't know what you're trying to drop."
							)
							([gInvNum index]
								(cond
									((== index 7)
										(= gShieldRoom gCurRoomNum)
										(gEgo use: 7) ; Shield
										(HighPrint 0 44) ; "You drop your shield."
									)
									((and (== index 5) (lastDagger dropQty))
										(HighPrint 0 45) ; "You'd better not. That's your last dagger, and you may need it for combat."
									)
									((== index 50)
										(HighPrint 0 46) ; "O.k. Your Saurus is now standing on the ground."
									)
									(else
										(= dropQty (gEgo drop: index dropQty))
										(Pluralize @str2 index)
										(HighPrint (Format @str 0 47 @str2)) ; "You drop the %s."
									)
								)
							)
							(else
								(HighPrint 0 48) ; "You can't drop something you don't have."
							)
						)
					)
					((Said 'throw>')
						(cond
							((Said '/dagger<silver,magic')
								(if (gEgo has: 56) ; SilverDagger
									(HighPrint 0 49) ; "The silver dagger isn't balanced properly for throwing."
								else
									(HighPrint 0 50) ; "You don't have one to throw."
								)
							)
							((Said '/dagger')
								(if (lastDagger 1)
									(HighPrint 0 45) ; "You'd better not. That's your last dagger, and you may need it for combat."
								else
									(ThrowObj 5 gEgo 0 0 0)
								)
							)
							((Said '/boulder')
								(ThrowObj 4 gEgo 0 0 0)
							)
							((Said '/powder,dust')
								(ThrowObj 3 gEgo 0 0 0)
							)
							(else
								(event claimed: 1)
								(HighPrint 0 51) ; "That isn't useful here."
							)
						)
					)
					((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
						(if (not gRopeUses)
							(HighPrint 0 52) ; "I'm a frayed knot."
						else
							(ThrowObj 6 gEgo 0 0 0)
						)
					)
					((Said 'levitate')
						(HighPrint 0 53) ; "To do that, you must cast the Levitate spell."
					)
					((Said 'cast>')
						(= index (SaidSpell event))
						(CastSpell index gEgo 0 0 0)
					)
					((Said 'walk')
						(EgoGait 0 1) ; walking
					)
					((Said 'escape,escape,(run<away)')
						(HighPrint 0 54) ; "You don't need to retreat if you're not in combat."
					)
					((Said 'run')
						(EgoGait 1 1) ; running
					)
					((or (Said '[use]/stealth') (Said 'sneak'))
						(cond
							((== gEgoGait 2) ; sneaking
								(HighPrint 0 55) ; "You're already sneaking."
							)
							((TrySkill 8 20 0) ; sneak
								(EgoGait 2 1) ; sneaking
							)
							(else
								(HighPrint 0 56) ; "You're about as stealthy as the average Goon."
							)
						)
					)
					((Said 'use')
						(HighPrint 0 57) ; "Pardon, Effendi. I don't know how you would use that here."
					)
					((or (Said 'quit') (Said 'done,done/game'))
						(PromptQuit)
					)
					((Said 'attack,kill,hit')
						(HighPrint 0 58) ; "Aggressive, aren't you?"
					)
					((Said 'climb,climb')
						(HighPrint 0 59) ; "You don't need to climb it."
					)
					((Said 'talk,talk')
						(HighPrint 0 60) ; "No one responds."
					)
					((Said 'smell[/!*]')
						(HighPrint 0 61) ; "You certainly do!"
					)
					(
						(or
							(Said 'lockpick[/lock]')
							(Said 'use/(lockpick[<lock]),lockpick')
							(Said 'unlock')
						)
						(HighPrint 0 62) ; "There's no point in trying that here."
					)
					((Said 'lockpick/nose')
						(if (CanPickLocks 1)
							(HighPrint 0 63) ; "You delicately insert the lockpick into your left nostril."
							(if (not (PickLock 40 0 1))
								(EgoDead ; "Unfortunately, you push it in too far, causing yourself a cerebral hemorrhage. Guess you should have practiced some more on less difficult locks."
									0
									0
									64
									#title
									{The surgeon general warns . . . }
									#icon
									999
									1
									5
								)
							else
								(HighPrint 0 65) ; "Success! You now have an open nose."
							)
						)
					)
					((Said 'ask')
						(HighPrint 0 66) ; "You get no response."
					)
					((Said 'buy/*')
						(HighPrint 0 67) ; "It's not for sale."
					)
					((Said 'eat,eat>')
						(Eat event)
					)
					((Said 'blow/frog<blue')
						(if (^= gDebugging $0001)
							(gCurRoom setLocales: 99)
						)
					)
					((Said 'drink>')
						(= index (SaidInv event))
						(DrinkPotion event index)
					)
					((Said 'thank')
						(HighPrint 0 68) ; "You're welcome!"
					)
					((Said '/sorry')
						(HighPrint 0 69) ; "That's OK."
					)
					((Said 'yes,no,please')
						(HighPrint 0 60) ; "No one responds."
					)
					((Said '/hello')
						(HighPrint 0 70) ; "Hi!"
					)
					((Said '/bye')
						(HighPrint 0 71) ; "Bye!"
					)
					((Said 'open,open/door')
						(HighPrint 0 72) ; "You're not close enough to a door."
					)
					((Said 'knock')
						(HighPrint 0 73) ; "No one hears you knocking."
					)
					((Said 'sat')
						(HighPrint 0 74) ; "You don't need to."
					)
					((or (Said 'give/bouquet') (Said 'give//bouquet'))
						(HighPrint 0 75) ; "There is no one here who would appreciate them."
					)
					((Said 'give,kiss')
						(HighPrint 0 76) ; "You have no reason to do that."
					)
					((Said 'search[/!*,room,area,area]')
						(HighPrint 0 77) ; "You don't find anything interesting."
					)
					((Said 'look,look/clown[<silly]')
						(switch gSillyClowns
							(0
								(HighPrint (Format @str 0 78 @gUserName)) ; "This is a serious game, %s."
							)
							(1
								(HighPrint 0 79) ; "You see no silly clowns here, at least not now."
							)
							(2
								(HighPrint 0 80) ; "Don't worry about it. It's all being taken care of."
							)
						)
					)
					((Said 'look,look,read>')
						(= num [gInvNum (= index (SaidInv event))])
						(if (== (= theRoom gCurRoomNum) 665)
							(= theRoom (- gDesertRoom))
						)
						(if (== gDropObjRoom theRoom)
							(+= num [gInvDropped index])
						)
						(cond
							((not index)
								(HighPrint 0 81) ; "Sorry, but there is nothing I can tell you about that."
							)
							(num
								(= strNum
									(cond
										((and (== index 33) (>= gElementalState 2)) 118)
										((and (== index 25) (<= 4 gElementalState 8)) 119)
										(else
											(+ index index 1)
										)
									)
								)
								(HighPrint 11 strNum)
							)
							(else
								(HighPrint 0 82) ; "You don't see any here."
							)
						)
						(event claimed: 1)
					)
					((Said 'rest[/!*]')
						(HighPrint 0 83) ; "You really can't rest here."
					)
					((or (Said 'nap[/!*]') (Said 'go[<to]/nap'))
						(HighPrint 0 84) ; "This isn't a safe place to sleep."
					)
					((Said 'make,give,show/sign[<thief]')
						(if (MakeSign)
							(HighPrint 0 85) ; "Boy, did you look silly!"
						else
							(HighPrint 0 86) ; "Wait a minute! You can't do that here!!!"
						)
					)
					(else
						(MoreSpecific)
						(event claimed: 1)
					)
				)
			)
		)
	)

	(method (replay)
		(InitGlobals)
		(if (OneOf gCurRoomNum 750 800 810 805 98) ; intro, selChar, chAlloc, import, speedChecker
			(MenuBar state: 1)
		else
			(MenuBar draw:)
			(SL enable:)
		)
		(if (DoSound sndSET_SOUND)
			(SetMenu 774 113 1 110 {Turn off})
		else
			(SetMenu 774 113 0 110 {Turn on})
		)
		(super replay:)
	)

	(method (wordFail word input &tmp [str 40])
		(Printf 0 87 word) ; "You will not need to use the word "%s" in this game."
		(LogIt (Format @str 0 88 word input) {Unknown word}) ; "%s -> %s"
	)

	(method (syntaxFail input)
		(HighPrint 0 89) ; "Please try a different way of saying that."
		(LogIt input {Couldn't parse})
	)

	(method (pragmaFail input)
		(HighPrint 0 90) ; "I'm not sure what you're trying to do."
		(LogIt input {No response})
	)
)

(instance egoW of Walk
	(properties)
)

(instance egoSW of StopWalk
	(properties)
)

(instance egoGL of Grooper
	(properties)
)

(instance addLog of Code
	(properties)

	(method (doit str)
		(Format
			str
			{\r\nDay %d Time %d cantMove %d cantTalk %d totalHunk/16 %u}
			gDay
			gTimeODay
			gCantMove
			gCantTalk
			(MemoryInfo 4) ; TotalHunk
		)
		(if (gCurRoom script:)
			(Format
				(StrEnd str)
				{ Room script %s: state %d}
				((gCurRoom script:) name:)
				((gCurRoom script:) state:)
			)
		)
	)
)

(instance dftSC of Code
	(properties)

	(method (doit spellNum &tmp allowed)
		(if (OneOf spellNum 20 23 29)
			(= allowed 1)
		else
			(= allowed 0)
			(HighPrint 0 96) ; "That wouldn't be a good idea right now."
		)
		(return allowed)
	)
)

(instance allSC of Code
	(properties)

	(method (doit)
		(return 1)
	)
)

(instance noSC of Code
	(properties)

	(method (doit)
		(HighPrint 0 96) ; "That wouldn't be a good idea right now."
		(return 0)
	)
)

