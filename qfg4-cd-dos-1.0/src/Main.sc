;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use DeathIcon)
(use QIcon)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Timer)
(use Sound)
(use Motion)
(use File)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Glory 0
	proc0_1 1
	SetFlag 2
	ClearFlag 3
	IsFlag 4
	Random300 6
	proc0_7 7
	proc0_8 8
	NextDay 9
	Face 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_16 16
	proc0_17 17
	proc0_18 18
	statusCode 21
)

(local
	; 0
	gEgo
	gGlory
	gCurRoom
	gThePlane
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gPlanes
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gTextCode
	gCuees
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gEventMask = 32767
	gBigFont = 1
	gVersion
	gAutoRobot
	gCurSaveDir
	; 30
	gNumCD
	gPerspective
	gFeatures
	gPanels
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemPlane
	gSaveFileSelText
	; 40
	global40
	global41
	gSysLogPath
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	global50
	global51
	global52
	global53
	global54
	; 55
	global55
	global56
	global57
	global58
	global59
	; 60
	global60
	global61
	gEndSysLogPath
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gApproachCode
	gUseObstacles = 1
	global68
	gTheIconBar
	; 70
	gMouseX
	gMouseY
	gKeyDownHandler
	gMouseDownHandler
	gDirectionHandler
	; 75
	gSpeechHandler
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	gExtMouseHandler
	gTalkers
	; 85
	gInputFont
	gTickOffset
	gHowFast
	gGameTime
	gNarrator
	; 90
	gMsgType = 1
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
	; 95
	gAltPolyList
	gScreenWidth
	gScreenHeight
	gLastScreenX
	gLastScreenY
	; 100
	gEgoGait
	global101 = 1234
	global102
	gLongSong
	global104
	; 105
	global105
	global106
	global107
	global108
	global109
	; 110
	global110
	global111
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	global118
	global119
	; 120
	gClock
	gNight
	gDay = 1
	gTime
	global124
	; 125
	gHeroType
	gTempEgoSpeed
	global127
	global128
	global129
	; 130
	global130
	global131
	global132
	global133
	global134 = 20
	; 135
	global135 = 15
	gFreeMeals
	global137
	global138 = 9
	global139 = 12
	; 140
	global140
	global141
	global142
	global143
	global144 = 180
	; 145
	global145
	global146 = 45
	global147 = 90
	global148 = 135
	global149 = 180
	; 150
	global150 = 225
	global151 = 270
	global152 = 315
	global153
	global154
	; 155
	gCombatResult
	global156
	gHeroName
	global158
	global159
	; 160
	global160
	global161
	global162
	global163
	global164
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	global170
	global171
	global172
	global173
	global174
	; 175
	global175
	global176
	global177
	global178
	global179
	; 180
	global180
	gDagger
	global182
	global183
	global184
	; 185
	gCombatMonsterActor
	global186
	global187
	gEgoSpell
	global189
	; 190
	global190
	global191
	global192
	global193
	gTeller
	; 195
	gCombatEgoActor
	global196
	global197
	global198 = 20
	gLongSong2
	; 200
	global200
	gDebugging
	global202
	global203
	global204
	; 205
	gInitialStats
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
	gEgoStats
	global248
	global249
	; 250
	global250
	global251
	global252
	global253
	global254
	; 255
	global255
	global256
	global257
	global258
	global259
	; 260
	global260
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267
	global268
	global269
	; 270
	global270
	global271
	global272
	global273
	global274
	; 275
	global275
	global276
	global277
	global278
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	global286
	global287
	global288
	global289
	; 290
	global290
	global291
	global292
	global293
	global294
	; 295
	global295
	global296
	global297
	global298
	global299
	; 300
	global300
	global301
	global302
	global303
	global304
	; 305
	global305
	global306
	global307
	global308
	global309
	; 310
	global310
	global311
	global312
	global313
	global314
	; 315
	global315
	global316
	global317
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
	global336
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
	gCombatMonsterNum
	global366
	global367 = 2
	global368 = 2
	global369 = 3
	; 370
	global370 = 3
	global371 = 3
	global372 = 4
	global373 = 5
	global374 = 5
	; 375
	global375 = 6
	global376 = 7
	global377 = 8
	global378 = 8
	global379 = 5
	; 380
	global380 = 10
	global381 = 15
	global382 = 20
	global383 = 6
	global384 = 8
	; 385
	global385 = 7
	global386 = 10
	global387 = 10
	global388
	global389
	; 390
	global390
	global391
	gList
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
	global401
	global402
	gLongSong3
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
	gPuzzleBar
	global414
	; 415
	global415
	gPrevKatrinaDayNumber
	global417
	global418
	global419
	; 420
	global420 = 100
	global421
	global422 = 200
	global423
	global424
	; 425
	global425
	gPrevDomoTalkDayNumber
	global427
	global428
	global429
	; 430
	global430
	global431
	global432
	global433 = 6
	global434
	; 435
	global435
	global436
	global437
	global438
	global439 = 2
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
	global450 = 8
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
	global460 = 1
	global461
	global462
	global463
	global464
	; 465
	global465
	global466 = 400
	global467
	global468
	global469
	; 470
	global470
	global471
	global472
	global473
	global474
	; 475
	global475
	global476
	global477
	global478
	global479
	; 480
	global480 = 300
	global481 = 300
	gFShore
	global483
	global484
	; 485
	global485
	global486
	global487
	global488
	global489
	; 490
	global490
	global491
	global492
	global493
	global494
	; 495
	global495
	global496
	global497
	global498
	global499
	; 500
	global500
	global501
	global502
	global503
	global504
	; 505
	global505
	global506
	global507
	global508
	global509
	; 510
	global510
	global511
	global512
	global513
	global514
	; 515
	global515
	global516
	global517
	global518
	global519
	; 520
	global520
	global521
	global522
	global523
	global524
	; 525
	global525
	global526
	global527
	global528
	global529
	; 530
	global530
	global531
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
	global570
	global571
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
	global611
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
	global650
	global651
	global652
	global653
	global654
	; 655
	global655
	global656
	global657
	global658
	global659
	; 660
	global660
	global661
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
	global670
	global671
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
	global691
	global692
	global693
	global694
	; 695
	global695
	global696
	global697
	global698
	global699
)

(procedure (proc0_1)
	(if (OneOf gCurRoomNum 710 720 740 750 760 770)
		(gMessager say: 28 0 8 0 0 0) ; "The chaotic forces in these caves twist and change your magic in strange, unpredictable ways. For the moment, that spell has no discernible effect."
	else
		(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
	)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp1 (Str new:))
	(= temp2 (IntArray new: 21))
	(if
		(<
			(= temp0 (GetSaveFiles (gGlory name:) (temp1 data:) (temp2 data:)))
			0
		)
		(return 0)
	)
	(for ((= temp3 0)) 1 ((++ temp3))
		(for ((= temp4 0)) (< temp4 temp0) ((++ temp4))
			(breakif (== temp3 (temp2 at: temp4)))
		)
		(if (== temp4 temp0)
			(break)
		)
	)
	(temp1 dispose:)
	(temp2 dispose:)
	(return temp3)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 (Str new:))
	(MakeSaveCatName (temp4 data:) (gGlory name:))
	((= temp2 (File new:)) name: (temp4 data:) open: 2)
	(for ((= temp1 0)) (< temp1 param3) ((++ temp1))
		(if (!= temp1 param1)
			(= temp3 (param4 at: temp1))
			(temp4
				at: 0 (& temp3 $00ff)
				at: 1 (& (>> temp3 $0008) $00ff)
				at: 2 0
			)
			(temp2 write: (temp4 data:) 2)
			(= temp0 (Str new: 36))
			(temp0 copyToFrom: 0 param2 (* temp1 36) 36)
			(temp2 write: (temp0 data:) 36)
			(temp0 dispose:)
			(= temp0 0)
		)
	)
	(temp4 at: 0 255 at: 1 255)
	(temp2 write: (temp4 data:) 2 close: dispose:)
	(MakeSaveFileName (temp4 data:) (gGlory name:) (param4 at: param1))
	(FileIO fiUNLINK (temp4 data:))
	(temp4 dispose:)
)

(procedure (proc0_16)
	(cond
		(
			(OneOf
				gCurRoomNum
				551
				552
				553
				554
				555
				556
				557
				558
				559
				560
				561
				562
				563
				564
				565
				566
				567
				568
				569
				570
				571
				572
				573
				574
				575
				576
				577
				578
				579
				580
				581
				582
				583
				584
				585
				586
				587
				588
				589
				590
				591
				592
				593
				250
				260
				270
				280
				290
				300
				440
				460
				480
				500
				520
				600
				790
				800
				810 ; combat
			)
			(cond
				((< 770 gClock 871)
					(PalVary 3) ; PalVaryKill
					(PalVary 0 (gCurRoom picture:) 0 (- 870 gClock)) ; PalVaryStart
				)
				((< 2600 gClock 2701)
					(PalVary 0 (+ (gCurRoom picture:) 1) 0 (- gClock 2600)) ; PalVaryStart
				)
				((< 2700 gClock 2801)
					(PalVary 9 (+ (gCurRoom picture:) 1)) ; PalVaryMergeSource
					(PalVary 0 (gCurRoom picture:) 0 (- gClock 2700)) ; PalVaryStart
				)
				((or (< 2800 gClock 4000) (<= 0 gClock 771))
					(PalVary 9 (+ (gCurRoom picture:) 1)) ; PalVaryMergeSource
					(PalVary 0 (gCurRoom picture:) 0 100) ; PalVaryStart
				)
				((not (OneOf gCurRoomNum 180 320))
					(PalVary 3) ; PalVaryKill
				)
			)
		)
		((== gCurRoomNum 320)
			(PalVary 0 320 0) ; PalVaryStart
		)
	)
)

(procedure (proc0_11) ; UNUSED
	(gGlory handsOn:)
	(gTheIconBar disable: 0 2 4 5 6 7)
)

(procedure (SetFlag param1)
	(|= [global500 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (ClearFlag param1)
	(&= [global500 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (IsFlag param1)
	(return (& [global500 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (Random300)
	(return (+ 1 (/ (Random 0 2999) 10)))
)

(procedure (proc0_7)
	(if (not (OneOf ((User curEvent:) message:) KEY_P KEY_R KEY_W))
		(if (gTheIconBar curIcon:)
			(= global204 (gTheIconBar curIcon:))
		)
	else
		(= global204 0)
	)
)

(procedure (proc0_8)
	(if global204
		(gTheIconBar curIcon: global204)
		(gGlory setCursor: (gTheIconBar getCursor:))
		(= global204 0)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
				(not (gTheIconBar curInvIcon:))
			)
			(gTheIconBar advanceCurIcon:)
		)
	)
)

(procedure (NextDay)
	(ClearFlag 32)
	(ClearFlag 11)
	(ClearFlag 189)
	(ClearFlag 204)
	(ClearFlag 338)
	(if (IsFlag 37)
		(if (IsFlag 238)
			(if (not (IsFlag 48))
				(SetFlag 38)
			)
		else
			(SetFlag 238)
		)
	)
	(++ gDay)
)

(procedure (Face param1 param2 param3 param4)
	(param1
		setHeading:
			(GetAngle (param1 x:) (param1 y:) param2 param3)
			(and (== argc 4) param4)
	)
)

(procedure (proc0_12 param1 param2)
	(= global441 0)
	(= global442 0)
	(if argc
		(= global441 param1)
		(if (> argc 1)
			(= global442 param2)
		)
	)
)

(procedure (proc0_18 param1 &tmp temp0)
	(switch param1
		(17
			(= temp0 (gEgo maxHealth:))
		)
		(18
			(= temp0 (gEgo maxStamina:))
		)
		(19
			(= temp0 (gEgo maxMana:))
		)
	)
	(return
		(if (> [gEgoStats param1] 0)
			(- 60 (/ (* 60 (/ (* [gEgoStats param1] 80) temp0)) 80))
		else
			60
		)
	)
)

(procedure (proc0_13)
	(cond
		(
			(OneOf
				gCurRoomNum
				551
				552
				553
				554
				555
				556
				557
				558
				559
				560
				561
				562
				563
				564
				565
				566
				567
				568
				569
				570
				571
				572
				573
				574
				575
				576
				577
				578
				579
				580
				581
				582
				583
				584
				585
				586
				587
				588
				589
				590
				591
				592
				593
				250
				260
				270
				280
				290
				300
				440
				460
				480
				500
				520
				600
				790
				800
				810 ; combat
			)
			(cond
				((< 770 gClock 871)
					(if (== gClock 771)
						(PalVary 3) ; PalVaryKill
					)
					(PalVary 0 (gCurRoom picture:) 0 (- 870 gClock)) ; PalVaryStart
				)
				((< 2600 gClock 2701)
					(PalVary 0 (+ (gCurRoom picture:) 1) 0 (- gClock 2600)) ; PalVaryStart
				)
				((< 2700 gClock 2801)
					(if (== gClock 2701)
						(PalVary 9 (+ (gCurRoom picture:) 1)) ; PalVaryMergeSource
					)
					(PalVary 0 (gCurRoom picture:) 0 (- gClock 2700)) ; PalVaryStart
				)
				((or (< 2800 gClock 3600) (<= 0 gClock 771))
					(PalVary 0 (gCurRoom picture:) 0 100) ; PalVaryStart
				)
			)
		)
		((not (OneOf gCurRoomNum 180 320))
			(PalVary 3) ; PalVaryKill
		)
	)
)

(procedure (proc0_14 &tmp temp0 temp1) ; UNUSED
	(= temp1 32768)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& global200 temp1)
			(gTheIconBar disable: temp0)
		)
		(>>= temp1 $0001)
	)
)

(procedure (proc0_17 param1 param2 param3 param4 param5 &tmp temp0 temp1)
	(= temp1 0)
	(= temp0 (if (> argc 4) param5 else gCurRoomNum))
	(while (Message msgSIZE temp0 param1 param2 param3 (++ temp1))
		0
	)
	(gMessager
		say:
			param1
			param2
			param3
			(Random 1 (- temp1 1))
			(if (> argc 3) param4 else 0)
			temp0
	)
)

(class Glory of Game
	(properties)

	(method (init &tmp temp0 [temp1 3])
		(SetFlag 51)
		(= gSystemPlane Plane)
		(= gHeroName (Str new: 40))
		((= gEgo (ScriptID 28 0)) view: 0) ; hero
		(Actor origStep: 1027)
		(View signal: 16384)
		(= global102 2)
		(= temp0 StopWalk)
		Timer
		Polygon
		PolyPath
		(super init:)
		(gWaitCursor view: 945 loop: 1 init:)
		(self setCursor: gNormalCursor)
		(statusPlane init:)
		(= gDoVerbCode gloryDoVerbCode)
		(= gFtrInitializer gloryFtrInit)
		(= gApproachCode gloryApproachCode)
		(= gMessager gloryMessager)
		(= gPMouse PseudoMouse)
		((= gLongSong longSong) owner: self flags: 1 init:)
		((= gLongSong2 longSong2) owner: self flags: 1 init:)
		((= gLongSong3 longSong3) owner: self flags: 1 init:)
		((= gTheIconBar (ScriptID 36 0)) init:) ; mainIconBar
		((ScriptID 16 0) init:) ; gloryInv
		((ScriptID 21 0) init:) ; glorySpells
		((ScriptID 1) init:) ; glryInit
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(if
			(and
				(or (!= gMouseX global202) (!= gMouseY global203))
				(== (Platform) 1)
				(not (IsFlag 51))
				(gUser canControl:)
			)
			(switch (IconBarCursor view:)
				(940
					(if (> (++ global358) 15)
						(= global358 0)
					)
					(IconBarCursor setCel: global358)
				)
				(941
					(if (> (++ global358) 15)
						(= global358 0)
					)
					(IconBarCursor setCel: global358)
				)
				(942
					(if (> (++ global358) 15)
						(= global358 0)
					)
					(IconBarCursor setCel: global358)
				)
				(943
					(if (> (++ global358) 15)
						(= global358 0)
					)
					(IconBarCursor setCel: global358)
				)
			)
		)
		(= global202 gMouseX)
		(= global203 gMouseY)
		(if (IsFlag 6)
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= global124 temp0)
				(= global124 temp0)
				(if (not (IsFlag 7))
					(= temp1 gClock)
					(if (>= (++ gClock) 3600)
						(= gClock 0)
						(NextDay)
					)
					(if (< (mod gClock 150) (mod temp1 150))
						((ScriptID 7 4) init:) ; fixTime
					)
					(if (and (not (IsFlag 11)) (< 2700 gClock 2801))
						(if
							(and
								(>= gDay (+ global459 4))
								(!= global459 0)
							)
							(proc0_17 26 6 34 0 0)
						)
						(SetFlag 11)
					)
				)
				(proc0_13)
				(if (< 820 gClock 2780)
					(= gNight 0)
				else
					(= gNight 1)
				)
				(if (and (not gNight) (gEgo has: 41)) ; theWillowisp
					(gLongSong3 number: 912 play:)
					(gEgo drop: 41) ; theWillowisp
					(gEgo get: 9) ; theFlask
					(gEgo addHonor: -1000)
					(gMessager say: 26 6 35 0 0 0) ; "The tiny Will o' Wisp flickers within its flask, then quietly expires. If only you had learned more about Will o' Wisps, maybe you could have prevented this sad loss!"
				)
				(if (and (== gEgoGait 2) (gEgo mover:)) ; sneaking
					(gEgo useSkill: 8 2) ; stealth
				)
				(cond
					(
						(and
							(or (< 1100 gClock 1200) (< 2500 gClock 2600))
							(not global141)
						)
						(if (> gClock 2500)
							(= global141 2650)
						else
							(= global141 1250)
						)
						(gEgo eatMeal:)
					)
					((> gClock global141)
						(= global141 0)
					)
				)
				(if (<= (-= global406 1) 0)
					(= global406 100)
					(if (IsFlag 3)
						(gEgo eatMeal:)
					)
				)
				(if (<= (-= global134 1) 0)
					(= global134 20)
					(cond
						((or (> global137 1) (IsFlag 5))
							(gEgo useStamina: 5)
							(if (IsFlag 5)
								(gEgo useStamina: (>> global407 $0007))
								(gEgo useSkill: 0 2) ; strength
							)
						)
						((and (= temp2 (gEgo mover:)) (== gEgoGait 1)) ; running
							(gEgo useStamina: 4)
						)
						((and temp2 (== gEgoGait 2)) ; sneaking
							(gEgo useStamina: 1)
						)
						(else
							(gEgo useStamina: -2)
						)
					)
				)
				(if (not (-- global198))
					(= global198 20)
					(gEgo useMana: -1)
				)
				(if (not (-- global135))
					(= global135 15)
					(if (not (or (> global137 1) (IsFlag 3) (IsFlag 14)))
						(gEgo takeDamage: -1)
					)
					(if (IsFlag 14)
						(if (> global479 0)
							(-= global479 3)
							(cond
								(
									(and
										(not (gEgo takeDamage: 3))
										(== gNewRoomNum gCurRoomNum)
									)
									(EgoDead 27 28 977 1) ; "You are completely strychnine by poison. No curare for you now. Next time, take some poison cure pills before it's too late."
								)
								(
									(<
										[gEgoStats 17] ; health
										(>> (gEgo maxHealth:) $0003)
									)
									(gMessager say: 2 0 28 0 0 28) ; "You really don't feel well."
								)
							)
						else
							(= global479 0)
							(ClearFlag 14)
							((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
						)
					)
				)
				(if (IsFlag 8)
					(switch (-- global440)
						(0
							(ClearFlag 8)
							(statusCode doit:)
							(gMessager say: 0 0 10 0 0 0) ; "Your Reversal spell has worn off."
						)
						(10
							(gMessager say: 0 0 11 0 0 0) ; "Your Reversal spell is wearing thin."
						)
					)
				)
				(if (and (IsFlag 149) (<= (-- global448) 0))
					(= global448 3)
					(if (not (gEgo useMana: 1))
						(gCurRoom notify: -2)
					)
				)
				(if (and (> global449 0) (<= (-= global449 10) 0))
					(= global449 0)
					(statusCode doit:)
					(gMessager say: 0 0 31 0 0 0) ; "Your Aura has evaporated."
				)
				(if (and (> global453 0) (<= (-= global453 10) 0))
					(if (IsFlag 21)
						(= global453 1)
					else
						(= global453 0)
						(statusCode doit:)
						(gMessager say: 0 0 32 0 0 0) ; "Your Protection spell has worn off."
					)
				)
				(if (and (> global454 0) (<= (-- global454) 0))
					(= global454 0)
					(statusCode doit:)
					(gMessager say: 0 0 33 0 0 0) ; "Your Resistance spell has expired."
				)
			)
		)
		(if (IsFlag 382)
			(ClearFlag 382)
			(self restart: 1)
		)
	)

	(method (handsOff)
		(if (not global438)
			(= global438 1)
			(proc0_7)
		)
		(gUser canControl: 0 canInput: 0)
		(= global200 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(if (not (HaveMouse))
			(= global202 gMouseX)
			(= global203 gMouseY)
			(gGlory setCursor: gWaitCursor 1 310 185)
		else
			(gGlory setCursor: gWaitCursor 1)
		)
	)

	(method (handsOn param1 &tmp temp0)
		(= global438 0)
		(gUser canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6 7 8)
		(proc0_8)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 6)
		)
		(if (not (HaveMouse))
			(gGlory setCursor: (gTheIconBar getCursor:) 1 global202 global203)
		else
			(gGlory setCursor: (gTheIconBar getCursor:) 1)
		)
		(if (> argc 0)
			(gTheIconBar disable: param1 &rest)
		)
	)

	(method (startRoom roomNum &tmp temp0)
		(gGlory setCursor: gWaitCursor 1)
		((ScriptID 27 0) init: roomNum) ; StartARoom
		(DisposeScript 27)
		StopWalk
		Cycle
		(if (FileIO fiEXISTS {18.scr})
			((ScriptID 18 0) init:) ; debugRoom
		)
		(if (not global438)
			(proc0_8)
			(gGlory setCursor: IconBarCursor 1)
		)
		(if gDebugOn
			(SetDebug)
		)
		(super startRoom: roomNum)
		(statusCode doit: roomNum)
	)

	(method (restart &tmp temp0 temp1 temp2)
		(if (and (not argc) (not (proc91_0 0 0 0 37 1)))
			(return)
		)
		(= gDoMotionCue 0)
		(gLongSong stop:)
		(gLongSong2 stop:)
		(gLongSong3 stop:)
		(= gCurRoomNum 100)
		(statusCode doit: 100)
		(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(PalCycle 4) ; Off
		(RemapColors 0) ; Off
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(gTheDoits release:)
		(gCurRoom dispose:)
		(FrameOut)
		(= temp1 (ScriptID 21 0)) ; glorySpells
		(for ((= temp0 0)) (< temp0 22) ((++ temp0))
			((temp1 at: temp0) owner: 0)
		)
		(for ((= temp0 0)) (< temp0 57) ((++ temp0))
			((gInventory at: temp0)
				owner: 0
				state: 0
				amount: 0
				maskView: 0
				maskLoop: 0
				maskCel: 0
			)
		)
		(= temp2 (ScriptID 36 1)) ; invItem
		(if (not (& (temp2 signal:) $0008))
			(temp2 hide:)
		)
		(gTheIconBar curIcon: (gTheIconBar at: 1))
		(gTheIconBar advanceCurIcon:)
		(gHeroName dispose:)
		(for ((= temp0 100)) (< temp0 699) ((++ temp0))
			(= [gEgo temp0] 0)
		)
		(= global101 1234)
		(= gDay 1)
		(= global134 20)
		(= global135 15)
		(= global138 9)
		(= global139 12)
		(= [global144 0] 180)
		(= [global144 1] 0)
		(= [global144 2] 45)
		(= [global144 3] 90)
		(= [global144 4] 135)
		(= [global144 5] 180)
		(= [global144 6] 225)
		(= [global144 6] 270)
		(= [global144 6] 315)
		(= global198 20)
		(= global367 2)
		(= global368 2)
		(= global369 3)
		(= global370 3)
		(= global371 3)
		(= global372 4)
		(= global373 5)
		(= global374 5)
		(= global375 6)
		(= global376 7)
		(= global377 8)
		(= global378 8)
		(= global379 5)
		(= global380 10)
		(= global381 15)
		(= global382 20)
		(= global383 6)
		(= global384 8)
		(= global385 7)
		(= global386 10)
		(= global387 10)
		(= global420 100)
		(= global422 150)
		(= global439 2)
		(= global460 1)
		(= global450 8)
		(= global433 6)
		(= global466 400)
		(= gHeroName (Str new: 40))
		((= gLongSong longSong) owner: self flags: 1)
		((= gLongSong2 longSong2) owner: self flags: 1)
		((= gLongSong3 longSong3) owner: self flags: 1)
		(= gCurRoom 0)
		((ScriptID 1) init:) ; glryInit
		(DisposeScript 1)
		(gEgo get: 0) ; thePurse
	)

	(method (quitGame)
		(if (proc91_0 0 0 0 13 1)
			(= gQuit 1)
		)
	)

	(method (detailLevel param1)
		(if argc
			(= _detailLevel param1)
			(gPlanes eachElementDo: #checkDetail _detailLevel)
		)
		(return _detailLevel)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(cond
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					(KEY_TAB
						(if
							(and
								(User canInput:)
								(User canControl:)
								(not (& ((gTheIconBar at: 7) signal:) $0004))
							)
							(if (gTalkers size:)
								(return)
							)
							(gInventory showSelf: gEgo)
							(if
								(and
									(= temp3 (gInventory curIcon:))
									(temp3 isKindOf: InvI)
								)
								(= temp0 (temp3 view:))
								(= temp1 (temp3 loop:))
								(= temp2 (temp3 cel:))
								(= temp4 (ScriptID 36 1)) ; invItem
								(= temp5 (ScriptID 36 2)) ; iconUseIt
								(temp5 cursorView: temp0)
								(temp5 cursorLoop: temp1)
								(temp5 cursorCel: temp2)
								(temp4 view: temp0 loop: temp1 cel: temp2 show:)
								(UpdateScreenItem temp4)
								(self
									setCursor:
										(IconBarCursor
											view: temp0
											loop: temp1
											cel: temp2
											yourself:
										)
								)
							)
							(event claimed: 1)
						)
					)
					(KEY_CONTROL
						(if
							(and
								(User canInput:)
								(User canControl:)
								(not (IsFlag 50))
							)
							(gGlory quitGame:)
							(event claimed: 1)
						)
					)
					($0016
						(if
							(and
								(User canInput:)
								(User canControl:)
								(not (IsFlag 50))
							)
							((ScriptID 15) doit:) ; charSheet
							(DisposeScript 15)
						)
					)
					(JOY_RIGHT
						(if
							(and
								(not (& ((gTheIconBar at: 8) signal:) $0004))
								(not (IsFlag 50))
							)
							(= temp9 (gTheIconBar getCursor:))
							(= temp6 (gTheCursor view:))
							(= temp7 (gTheCursor loop:))
							(= temp8 (gTheCursor cel:))
							(self
								setCursor:
									(temp9 view: 999 loop: 0 cel: 0 yourself:)
							)
							((ScriptID 25) init: show: dispose:) ; controlPanel
							(DisposeScript 25)
							(DisposeScript 19)
							(self
								setCursor:
									(temp9
										view: temp6
										loop: temp7
										cel: temp8
										yourself:
									)
							)
						)
					)
					(KEY_F2
						(cond
							((gGlory masterVolume:)
								(gGlory masterVolume: 0)
							)
							((> global133 1)
								(gGlory masterVolume: 15)
							)
							(else
								(gGlory masterVolume: 1)
							)
						)
						(event claimed: 1)
					)
					(KEY_F5
						(if
							(and
								(not (& ((gTheIconBar at: 8) signal:) $0004))
								(not (IsFlag 50))
							)
							(if (gTalkers size:)
								(return)
							)
							(gGlory save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if
							(and
								(not (& ((gTheIconBar at: 8) signal:) $0004))
								(not (IsFlag 50))
							)
							(if (gTalkers size:)
								(return)
							)
							(gGlory restore:)
							(event claimed: 1)
						)
					)
					(KEY_F9
						(if
							(and
								(User canInput:)
								(User canControl:)
								(not (& ((gTheIconBar at: 8) signal:) $0004))
							)
							(if (gTalkers size:)
								(return)
							)
							(gGlory restart:)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (gUser controls:)
							(= global346 (Max 0 (-- global346)))
							(gEgo cycleSpeed: global346 moveSpeed: global346)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(++ global346)
							(gEgo cycleSpeed: global346 moveSpeed: global346)
						)
					)
					($003d ; =
						(if (gUser controls:)
							(gEgo cycleSpeed: 6 moveSpeed: 6)
						)
					)
				)
			)
			((== (event type:) evMOUSERELEASE)
				(gMouseDownHandler handleEvent: event)
			)
			(else
				(super handleEvent: event)
			)
		)
		(if (event claimed:)
			(return 1)
		)
	)

	(method (pragmaFail &tmp temp0)
		(if (User canInput:)
			(switch (= temp0 ((User curEvent:) message:))
				(1
					(gMessager say: 24 1 0 0 0 0) ; "You don't notice anything special there."
				)
				(4
					(gMessager say: 24 4 0 0 0 0) ; "That didn't do anything."
				)
				(2
					(gMessager say: 24 2 0 0 0 0) ; "No one seems to be listening."
				)
				(104
					(if
						(OneOf
							gCurRoomNum
							440
							270
							330
							350
							740
							730
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
						)
						(gCurRoom doVerb: 104)
					else
						(gMessager say: 24 0 9 0 0 0) ; "This doesn't seem to be a good place to sleep."
					)
				)
				(86
					(if
						(OneOf
							gCurRoomNum
							440
							340
							360
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							545
							600
							650
							670
							680
							625
							750
							780
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							800
							632
							740
							710
							730
						)
						(gCurRoom doVerb: 86)
					else
						(proc0_1)
					)
				)
				(88
					(if
						(OneOf
							gCurRoomNum
							440
							340
							360
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							545
							600
							650
							670
							680
							625
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							632
							710
							730
							740
							750
							770
							800
						)
						(gCurRoom doVerb: 88)
					else
						(proc0_1)
					)
				)
				(93
					(if
						(OneOf
							gCurRoomNum
							270
							340
							360
							440
							545
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							600
							650
							670
							680
							625
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							632
							740
							710
							750
							760
							730
							770
							800
						)
						(gCurRoom doVerb: 93)
					else
						(proc0_1)
					)
				)
				(80
					(if
						(OneOf
							gCurRoomNum
							250
							260
							270
							340
							440
							500
							510
							593
							641
							643
							660
							610
							662
							670
							600
							661
							662
							780
							460
							470
							790
							620
							621
							622
							623
							624
							625
							626
							627
							629
							630
							631
							632
							640
							642
							644
							633
							634
							645
							663
							680
							300
						)
						(gCurRoom doVerb: 80)
					else
						(proc0_1)
					)
				)
				(81
					(if
						(OneOf
							gCurRoomNum
							250
							270
							290
							300
							320
							340
							360
							780
							440
							480
							510
							545
							579
							580
							593
							600
							800
							720
							740
							750
							770
							730
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
						)
						(gCurRoom doVerb: 81)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(82
					(if
						(OneOf
							gCurRoomNum
							270
							290
							340
							440
							460
							520
							580
							593
							600
							641
							643
							650
							750
							800
						)
						(gCurRoom doVerb: 82)
					else
						(proc0_1)
					)
				)
				(83
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							340
							460
							520
							545
							600
							625
							650
							670
							710
							730
							750
							770
						)
						(gCurRoom doVerb: 83)
					else
						(proc0_1)
					)
				)
				(85
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							340
							460
							545
							710
							750
							730
							632
						)
						(gCurRoom doVerb: 85)
					else
						(proc0_1)
					)
				)
				(87
					(cond
						(
							(OneOf
								gCurRoomNum
								270
								340
								440
								460
								470
								551
								552
								553
								554
								555
								556
								557
								558
								559
								560
								561
								562
								563
								564
								565
								566
								567
								568
								569
								570
								571
								572
								573
								574
								575
								576
								577
								578
								579
								580
								581
								582
								583
								584
								585
								586
								587
								588
								589
								590
								591
								592
								593
								670
								710
								750
								800
								530
								535
								541 ; swamp1
								542 ; swamp2
								543 ; swamp3
								545
								790
								290
							)
							(gCurRoom doVerb: 87)
						)
						((> (gEgo view:) 5)
							(gMessager say: 0 0 21 1 0 0) ; "You're not in a very good position for casting spells at the moment."
						)
						(else
							(gEgo setScript: (ScriptID 37)) ; castFetchScript
						)
					)
				)
				(89
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							250
							260
							270
							280
							290
							330
							340
							600
							710
							720
							800
							740
							750
							730
						)
						(gCurRoom doVerb: 89)
					else
						(proc0_1)
					)
				)
				(92
					(if (OneOf gCurRoomNum 270 340 460 670 740 750 730)
						(gCurRoom doVerb: 92)
					else
						(proc0_1)
					)
				)
				(90
					(if (OneOf gCurRoomNum 270 340 460 750)
						(gCurRoom doVerb: 90)
					else
						(proc0_1)
					)
				)
				(94
					(if (OneOf gCurRoomNum 270 340 750)
						(gCurRoom doVerb: 94)
					else
						(proc0_1)
					)
				)
				(91
					(if
						(OneOf
							gCurRoomNum
							270
							340
							390
							520
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							600
							632
							630
							670
							680
							750
							770
							800
						)
						(gCurRoom doVerb: 91)
					else
						(proc0_1)
					)
				)
				(102
					(gMessager say: 24 102 22 0 0 0) ; "You can't heal that!"
				)
				(37
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							600
							650
							670
							680
							625
							632
							460
							520
							800
							740
							730
						)
						(gCurRoom doVerb: 37)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(21
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							535
							600
							650
							670
							680
							625
							632
							460
							520
							800
							740
							730
							545
						)
						(gCurRoom doVerb: 21)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(33
					(if (OneOf gCurRoomNum 0)
						(gCurRoom doVerb: 33)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(10
					(gMessager say: 24 0 38 0 0 0) ; "Why would you want to jump there?"
				)
				(else
					(gMessager say: 24 0 6 0 0 0) ; "Nothing happens."
				)
			)
		)
	)

	(method (setCursor)
		(if (not (IsFlag 51))
			(return (super setCursor: &rest))
		else
			(return gTheCursor)
		)
	)

	(method (showAbout)
		((ScriptID 19 0) doit:) ; aboutCode
	)

	(method (save param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15)
		(return
			(if (and (== argc 1) (== param1 1))
				(ClearFlag 380)
				(if (not (IsFlag 379))
					(return 0)
				)
				(= temp0 (Str new:))
				(= temp6 (Str new:))
				(= temp1 (IntArray new: 21))
				(= temp3 (Str new:))
				(= temp4 (Str new:))
				(= temp7 (Str new:))
				(= temp2 (Str new:))
				(= temp9 (GetSaveFiles name (temp0 data:) (temp1 data:)))
				(Message msgGET 0 0 0 16 1 (temp7 data:)) ; "Automatic Save"
				(= temp11 0)
				(= temp10 -1)
				(= temp8 (temp7 size:))
				(for ((= temp12 0)) (< temp12 temp9) ((++ temp12))
					(temp2 copyToFrom: 0 temp0 (* temp12 36) (+ temp8 1))
					(if (= temp15 (temp2 compare: temp7))
						(= temp10 temp12)
						(break)
					)
				)
				(if (>= temp10 0)
					(localproc_1 temp10 temp0 temp9 temp1)
					(= temp9 (GetSaveFiles name (temp0 data:) (temp1 data:)))
					(while
						(and
							(> temp9 0)
							(not (CheckFreeSpace (gCurSaveDir data:)))
						)
						(localproc_1 (- temp9 1) temp0 temp9 temp1)
						(= temp10
							(-
								(= temp9
									(GetSaveFiles
										name
										(temp0 data:)
										(temp1 data:)
									)
								)
								1
							)
						)
					)
					(if (CheckFreeSpace (gCurSaveDir data:))
						(Message msgGET 0 0 0 16 1 (temp3 data:)) ; "Automatic Save"
						(= temp13 (localproc_0))
						(if (not (SaveGame name temp13 (temp3 data:) gVersion))
							(Print addText: 0 0 17 1 0 0 0 init:) ; "Save Error"
							(temp0 dispose:)
							(temp1 dispose:)
							(temp7 dispose:)
							(temp3 dispose:)
							(temp4 dispose:)
							(return (temp2 dispose:))
						else
							(if (not (and argc param1))
								(Print addText: 0 0 18 1 0 0 0 init:) ; "Game Saved"
							)
							(= temp9
								(GetSaveFiles
									(gGlory name:)
									(temp0 data:)
									(temp1 data:)
								)
							)
						)
					else
						(Print addText: 0 0 19 1 0 0 0 init:) ; "Your disk is full."
						(temp0 dispose:)
						(temp6 dispose:)
						(temp7 dispose:)
						(temp3 dispose:)
						(temp4 dispose:)
						(return (temp2 dispose:))
					)
				else
					(while
						(and
							(> temp9 0)
							(or
								(not (CheckFreeSpace (gCurSaveDir data:)))
								(>= temp9 20)
							)
						)
						(localproc_1 (- temp9 1) temp0 temp9 temp1)
						(= temp9
							(GetSaveFiles
								(gGlory name:)
								(temp0 data:)
								(temp1 data:)
							)
						)
					)
					(Message msgGET 0 0 0 16 1 (temp3 data:)) ; "Automatic Save"
					(= temp13 (localproc_0))
					(if
						(not
							(SaveGame
								name
								temp13
								(temp3 data:)
								(KString 9 gVersion) ; StrGetData
							)
						)
						(Print addText: 0 0 17 1 0 0 0 init:) ; "Save Error"
						(temp0 dispose:)
						(temp1 dispose:)
						(temp7 dispose:)
						(temp3 dispose:)
						(temp4 dispose:)
						(return (temp2 dispose:))
					else
						(if (not (and argc param1))
							(Print addText: 0 0 18 1 0 0 0 init:) ; "Game Saved"
						)
						(= temp9
							(GetSaveFiles
								(gGlory name:)
								(temp0 data:)
								(temp1 data:)
							)
						)
					)
				)
				(while ((= temp14 (Event new:)) type:)
					(temp14 dispose:)
				)
				(temp14 dispose:)
				(temp0 dispose:)
				(temp7 dispose:)
				(temp1 dispose:)
				(temp3 dispose:)
				(temp4 dispose:)
				(temp2 dispose:)
			else
				(super save:)
			)
		)
	)
)

(instance theIcon1 of DCIcon ; UNUSED
	(properties
		cycleSpeed 16
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global200 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance gloryDoVerbCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 (Str new:))
		(temp0 format: {%d.msg} gCurRoomNum)
		(if (and (FileIO fiEXISTS (temp0 data:)) (Message msgSIZE gCurRoomNum 0 param1 0 1))
			(gMessager say: 0 param1 0 0 0 gCurRoomNum)
		else
			(switch param1
				(3
					((User curEvent:) claimed: 0)
				)
				(1
					(gMessager say: 25 1 0 0 0 0) ; "It looks pretty much as you'd expect."
				)
				(4
					(gMessager say: 25 4 0 0 0 0) ; "It doesn't budge."
				)
				(2
					(gMessager say: 25 2 0 0 0 0) ; "It doesn't say much."
				)
				(104
					(if
						(OneOf
							gCurRoomNum
							440
							270
							330
							350
							740
							730
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
						)
						(gCurRoom doVerb: 104)
					else
						(gMessager say: 24 0 9 0 0 0) ; "This doesn't seem to be a good place to sleep."
					)
				)
				(86
					(if
						(OneOf
							gCurRoomNum
							440
							340
							360
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							545
							600
							650
							670
							680
							625
							750
							780
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							800
							632
							740
							710
							730
						)
						(gCurRoom doVerb: 86)
					else
						(proc0_1)
					)
				)
				(88
					(if
						(OneOf
							gCurRoomNum
							440
							340
							360
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							545
							600
							650
							670
							680
							625
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							632
							710
							730
							740
							750
							770
							800
						)
						(gCurRoom doVerb: 88)
					else
						(proc0_1)
					)
				)
				(93
					(if
						(OneOf
							gCurRoomNum
							270
							340
							360
							440
							545
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							600
							650
							670
							680
							625
							460
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							520
							632
							740
							710
							750
							760
							730
							770
							800
						)
						(gCurRoom doVerb: 93)
					else
						(proc0_1)
					)
				)
				(80
					(if
						(OneOf
							gCurRoomNum
							250
							260
							270
							340
							440
							500
							510
							593
							641
							643
							660
							610
							662
							670
							600
							661
							662
							780
							460
							470
							790
							620
							621
							622
							623
							624
							625
							626
							627
							629
							630
							631
							632
							640
							642
							644
							633
							634
							645
							663
							680
							300
						)
						(gCurRoom doVerb: 80)
					else
						(proc0_1)
					)
				)
				(81
					(if
						(OneOf
							gCurRoomNum
							250
							270
							290
							300
							320
							340
							360
							780
							440
							480
							510
							545
							579
							580
							593
							600
							800
							720
							740
							750
							770
							730
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
						)
						(gCurRoom doVerb: 81)
					else
						(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
					)
				)
				(82
					(if
						(OneOf
							gCurRoomNum
							270
							290
							340
							440
							460
							520
							580
							593
							600
							641
							643
							650
							750
							800
						)
						(gCurRoom doVerb: 82)
					else
						(proc0_1)
					)
				)
				(83
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							340
							460
							520
							545
							600
							625
							650
							670
							710
							730
							750
							770
						)
						(gCurRoom doVerb: 83)
					else
						(proc0_1)
					)
				)
				(85
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							270
							340
							460
							545
							710
							750
							730
							632
						)
						(gCurRoom doVerb: 85)
					else
						(proc0_1)
					)
				)
				(87
					(cond
						(
							(OneOf
								gCurRoomNum
								270
								340
								440
								460
								470
								551
								552
								553
								554
								555
								556
								557
								558
								559
								560
								561
								562
								563
								564
								565
								566
								567
								568
								569
								570
								571
								572
								573
								574
								575
								576
								577
								578
								579
								580
								581
								582
								583
								584
								585
								586
								587
								588
								589
								590
								591
								592
								593
								670
								710
								750
								800
								530
								535
								541 ; swamp1
								542 ; swamp2
								543 ; swamp3
								545
								790
								290
							)
							(gCurRoom doVerb: 87)
						)
						((> (gEgo view:) 5)
							(gMessager say: 0 0 21 1 0 0) ; "You're not in a very good position for casting spells at the moment."
						)
						(else
							(gEgo setScript: (ScriptID 37)) ; castFetchScript
						)
					)
				)
				(89
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							250
							260
							270
							280
							290
							330
							340
							600
							710
							720
							800
							740
							750
							730
						)
						(gCurRoom doVerb: 89)
					else
						(proc0_1)
					)
				)
				(92
					(if (OneOf gCurRoomNum 270 340 460 670 740 750 730)
						(gCurRoom doVerb: 92)
					else
						(proc0_1)
					)
				)
				(90
					(if (OneOf gCurRoomNum 270 340 460 750)
						(gCurRoom doVerb: 90)
					else
						(proc0_1)
					)
				)
				(91
					(if
						(OneOf
							gCurRoomNum
							270
							340
							390
							520
							530
							535
							541 ; swamp1
							542 ; swamp2
							543 ; swamp3
							545
							600
							632
							630
							670
							680
							750
							770
							800
						)
						(gCurRoom doVerb: 91)
					else
						(proc0_1)
					)
				)
				(102
					(gMessager say: 25 102 23 0 0 0) ; "Save your healing for where it's needed."
				)
				(37
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							600
							650
							670
							680
							625
							632
							460
							520
							800
							740
							730
						)
						(gCurRoom doVerb: 37)
					else
						(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
					)
				)
				(33
					(if (OneOf gCurRoomNum 0)
						(gCurRoom doVerb: 33)
					else
						(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
					)
				)
				(21
					(if
						(OneOf
							gCurRoomNum
							551
							552
							553
							554
							555
							556
							557
							558
							559
							560
							561
							562
							563
							564
							565
							566
							567
							568
							569
							570
							571
							572
							573
							574
							575
							576
							577
							578
							579
							580
							581
							582
							583
							584
							585
							586
							587
							588
							589
							590
							591
							592
							593
							535
							600
							650
							670
							680
							625
							632
							460
							520
							800
							740
							730
							545
						)
						(gCurRoom doVerb: 21)
					else
						(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
					)
				)
				(10
					(gMessager say: 24 0 38 0 0 0) ; "Why would you want to jump there?"
				)
				(else
					(gMessager say: 25 0 5 0 0 0) ; "That didn't do anything useful."
				)
			)
		)
		(temp0 dispose:)
	)
)

(instance gloryFtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 40)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance gloryApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(cond
				((== param1 1) 1)
				((== param1 2) 2)
				((== param1 3) 4)
				((== param1 4) 8)
				((<= 15 param1 78) 16)
				((<= 80 param1 93) 32)
				((== param1 -1) -1)
				(else 32768)
			)
		)
	)
)

(class MessObj of Obj
	(properties
		noun 0
		verb 0
		case 0
		seq 0
		who 0
		module 0
		said 0
		argCount 0
	)

	(method (new param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 (Clone self))
		(temp0 said: 0 argCount: argc noun: param1 verb: param2 case: param3)
		(if (> argc 2)
			(temp0 seq: param4)
			(if (> argc 3)
				(temp0 who: param5)
				(if (> argc 4)
					(temp0 module: param6)
				)
			)
		)
		(gTheDoits add: temp0)
	)

	(method (doit)
		(if (and (not said) (not ((ScriptID 64924 1) size:))) ; talkerSet
			(= said 1)
			(switch argCount
				(3
					(gMessager say: noun verb case)
				)
				(4
					(gMessager say: noun verb case seq)
				)
				(5
					(gMessager say: noun verb case seq who)
				)
				(6
					(gMessager say: noun verb case seq who module)
				)
			)
			(self dispose:)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance gloryMessager of Messager
	(properties)

	(method (say)
		(if (== gNewRoomNum gCurRoomNum)
			(= global432 0)
			(if ((ScriptID 64924 1) size:) ; talkerSet
				(MessObj new: &rest)
			else
				(ClearFlag 165)
				(super say: &rest)
			)
		)
	)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(5
						(ScriptID 74) ; avisTalker
					)
					(22
						(ScriptID 490 1) ; babaTalker
					)
					(24
						(ScriptID 480 1) ; boneTalker
					)
					(7
						(ScriptID 65) ; burgoTalker
					)
					(18
						(ScriptID 69) ; craniumTalker
					)
					(20
						(ScriptID 75) ; annaTalker
					)
					(16
						(ScriptID 93) ; bellaTalker
					)
					(4
						(ScriptID 71) ; tanyaTalker
					)
					(39
						(ScriptID 99) ; tanyaVampTalker
					)
					(17
						(ScriptID 72) ; domovoiTalker
					)
					(9
						(ScriptID 76) ; hansTalker
					)
					(15
						(ScriptID 77) ; franzTalker
					)
					(14
						(ScriptID 78) ; ivanTalker
					)
					(13
						(ScriptID 67) ; gnomeTalker
					)
					(8
						(ScriptID 92) ; gypsyTalker
					)
					(1
						(ScriptID 73) ; igorTalker
					)
					(12
						(ScriptID 98) ; innkeeperTalker
					)
					(6
						(ScriptID 68) ; katrinaTalker
					)
					(35
						(ScriptID 95) ; katrinaHoodTalker
					)
					(36
						(ScriptID 96) ; katrinaRedTalker
					)
					(37
						(ScriptID 97) ; katrinaBlackTalker
					)
					(23
						(ScriptID 66) ; keeperTalker
					)
					(19
						(ScriptID 79) ; leshyTalker
					)
					(10
						(ScriptID 64) ; oldmanTalker
					)
					(11
						(ScriptID 94) ; olgaTalker
					)
					(2
						(ScriptID 270 2) ; piotyrTalker
					)
					(26
						(ScriptID 629 1) ; goonTalker
					)
					(27
						(ScriptID 629 2) ; goonTalker2
					)
					(28
						(ScriptID 520 1) ; rusalkaTalkerYoung
					)
					(38
						(ScriptID 520 2) ; rusalkaTalkerOld
					)
					(3
						(ScriptID 70) ; tobyTalker
					)
					(40
						(ScriptID 101) ; tobyNiceTalker
					)
					(30
						(ScriptID 580 1) ; queenTalker
					)
					(33
						(ScriptID 730 1) ; eranaTalker
					)
					(29
						(ScriptID 103) ; chiefTalker
					)
					(21
						(ScriptID 470 1) ; gTalker
					)
					(32
						(ScriptID 470 2) ; fTalker
					)
					(48
						(ScriptID 104) ; erasmusTalker
					)
					(49
						(ScriptID 105) ; fenrisTalker
					)
					(31
						(ScriptID 106) ; oldGhostTalker
					)
					(else gNarrator)
				)
			)
			(if (temp0 isKindOf: Talker)
				(if (and global347 (!= global347 temp0))
					(= global432 global347)
				)
				(= global347 temp0)
			)
			(return temp0)
		else
			(super findTalker: param1)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(= global347 0)
		(= global432 0)
		(ClearFlag 165)
		(if (not (IsFlag 147))
			(ClearFlag 50)
			(if (IsFlag 148)
				(ClearFlag 148)
				(statusCode doit:)
			)
		)
	)
)

(class GlorySong of Sound
	(properties
		numSongs 0
	)

	(method (doSongs param1 &tmp temp0)
		(= numSongs argc)
		(if numSongs
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(= [global351 temp0] [param1 temp0])
			)
			(self
				number: [global351 (Random 0 (- numSongs 1))]
				setLoop: 1
				play:
			)
		else
			(self setLoop: -1)
		)
	)

	(method (check)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if client
				(client cue: self)
			)
			(if (and numSongs (== prevSignal -1))
				(self
					number: [global351 (Random 0 (- numSongs 1))]
					setLoop: 1
					play:
				)
			)
		)
	)
)

(instance longSong of GlorySong
	(properties)
)

(instance longSong2 of GlorySong
	(properties)
)

(instance longSong3 of GlorySong
	(properties)
)

(instance statHealth of View
	(properties
		x 20
		view 907
		loop 2
	)
)

(instance statStam of View
	(properties
		x 100
		view 907
		loop 2
	)
)

(instance statMana of View
	(properties
		x 180
		view 907
		loop 2
	)
)

(instance statManaBack of View
	(properties
		x 171
		y 1
		view 907
		loop 1
	)
)

(instance statReverse of View
	(properties
		x 250
		view 907
	)
)

(instance statZap of View
	(properties
		x 264
		view 907
		cel 1
	)
)

(instance statResist of View
	(properties
		x 278
		view 907
		cel 2
	)
)

(instance statAura of View
	(properties
		x 292
		view 907
		cel 3
	)
)

(instance statProtect of View
	(properties
		x 306
		view 907
		cel 4
	)
)

(instance statusBitmap of View
	(properties
		view 907
		loop 6
	)
)

(instance statusPlane of Plane
	(properties)

	(method (init &tmp temp0)
		(self priority: (+ (GetHighPlanePri) 1))
		(super init: 0 0 0 0 -1 -1 -1 -1)
		(self addCast: (= temp0 (Cast new:)))
		(statusBitmap
			view: 907
			loop: 3
			cel: 0
			posn: 0 0
			setPri: (+ priority 1)
			init: temp0
		)
		(statHealth setPri: (+ priority 2) init: temp0)
		(statStam setPri: (+ priority 2) init: temp0)
		(statManaBack setPri: (+ priority 2) init: temp0 hide:)
		(statMana setPri: (+ priority 3) init: temp0 hide:)
		(statReverse setPri: (+ priority 2) init: temp0)
		(statZap setPri: (+ priority 2) init: temp0)
		(statResist setPri: (+ priority 2) init: temp0)
		(statAura setPri: (+ priority 2) init: temp0)
		(statProtect setPri: (+ priority 2) init: temp0)
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (not argc)
			(= param1 gCurRoomNum)
		)
		(if (OneOf param1 4 52 54 100 101 110 140 160 180 810 475)
			(statusPlane setInsetRect: -1 -1 -1 -1)
			(UpdatePlane statusPlane)
		else
			(if (IsFlag 147)
				(return)
			)
			(statusPlane setRect: 0 0 319 9)
			(= temp0 (proc0_18 17))
			(statHealth
				cel: (if (IsFlag 14) 1 else 0)
				x: (- 20 temp0)
				setInsetRect: temp0 0 59 9
			)
			(UpdateScreenItem statHealth)
			(= temp0 (proc0_18 18))
			(statStam x: (- 100 temp0) setInsetRect: temp0 0 59 9)
			(UpdateScreenItem statStam)
			(if
				(and
					[gEgoStats 12] ; magic
					[gEgoStats 19] ; mana
					(/ (+ [gEgoStats 1] [gEgoStats 19] [gEgoStats 19]) 3) ; intelligence, mana, mana
				)
				(= temp0 (proc0_18 19))
				(statMana x: (- 180 temp0) setInsetRect: temp0 0 59 9 show:)
				(statManaBack show:)
				(UpdateScreenItem statMana)
				(UpdateScreenItem statManaBack)
			)
			(if (IsFlag 8)
				(statReverse show:)
			else
				(statReverse hide:)
			)
			(if global142
				(statZap show:)
			else
				(statZap hide:)
			)
			(if global454
				(statResist show:)
			else
				(statResist hide:)
			)
			(if global449
				(statAura show:)
			else
				(statAura hide:)
			)
			(if global453
				(statProtect show:)
			else
				(statProtect hide:)
			)
			(UpdatePlane statusPlane)
		)
	)
)

