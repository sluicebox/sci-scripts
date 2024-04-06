;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use GloryWindow)
(use n026)
(use Print)
(use Messager)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Timer)
(use GameControls)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Glory 0
	HaveMem 1
	HandsOff 2
	HandsOn 3
	SetFlag 4
	ClearFlag 5
	IsFlag 6
	proc0_7 7
	Random300 8
	proc0_9 9
	proc0_10 10
	NextDay 11
	Face 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	textIcon 17
	mainIconBar 20
	proc0_21 21
	proc0_22 22
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
	global17 = 7
	gSet
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 997
	gUserFont
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont
	gVersion
	gLocales
	gCurSaveDir
	; 30
	global30 = 10
	gPerspective
	gFeatures
	gSFeatures
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemWindow
	global39
	; 40
	global40
	gModelessPort
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
	global62
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gQg3ApproachCode
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
	global75
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	global83
	gFastCast
	; 85
	gInputFont
	gTickOffset
	gHowFast
	gGameTime
	gNarrator
	; 90
	gMsgType
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
	; 95
	global95
	global96
	global97
	global98
	global99
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
	gDay
	gTimeOfDay
	gOldSysTime
	; 125
	gHeroType
	global126
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
	global155
	global156
	global157
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
	global181
	global182
	global183
	global184
	; 185
	global185
	global186
	global187
	global188
	global189
	; 190
	global190
	global191
	global192
	global193
	global194
	; 195
	global195
	global196
	global197
	global198 = 20
	gLongSong2
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
	global209 = 2
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
	gEgoStats
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
	gSkillTicks
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
	gBaseHeroType
	global363
	global364
	; 365
	global365
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
	global381 = 3
	global382 = 3
	global383 = 3
	global384 = 3
	; 385
	global385 = 3
	global386
	global387
	global388
	global389
	; 390
	global390
	global391
	global392
	gList
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
	global403 = 1
	global404
	; 405
	global405 = 4
	global406
	global407
	global408
	global409
	; 410
	global410
	global411 = 1
	gMonster
	gWarriorObj
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
	gLongSong3
	gCollect
	global459
	; 460
	global460
	global461
	global462
	global463
	global464
	; 465
	global465
	global466
	gGloryWindow
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
	global480
	global481
	global482
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
	; 700
	global700
)

(procedure (localproc_0 &tmp temp0 [temp1 400] [temp401 21] temp422 temp423)
	(= temp0 (GetSaveFiles (gGame name:) @temp1 @temp401))
	(for ((= temp422 1)) 1 ((++ temp422))
		(for ((= temp423 0)) (< temp423 temp0) ((++ temp423))
			(breakif (== temp422 [temp401 temp423]))
		)
		(if (== temp423 temp0)
			(break)
		)
	)
	(return temp422)
)

(procedure (HaveMem param1)
	(return (> (MemoryInfo 0) param1)) ; LargestPtr
)

(procedure (HandsOff)
	(= global208 1)
	(proc0_9)
	(User canControl: 0 canInput: 0)
	(= global200 0)
	(gTheIconBar eachElementDo: #perform checkIcon)
	(gTheIconBar disable: 1 2 3 4 5 6 7 8)
	(if (not (HaveMouse))
		(= global202 gMouseX)
		(= global203 gMouseY)
		(gGame setCursor: gWaitCursor 1 310 185)
	else
		(gGame setCursor: gWaitCursor 1)
	)
)

(procedure (HandsOn param1 &tmp [temp0 31])
	(= global208 0)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 1 2 3 4 5 6 7 8 9)
	(proc0_10)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 7)
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global202 global203)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
	(if (> argc 0)
		(gTheIconBar disable: param1 &rest)
	)
)

(procedure (proc0_13)
	(HandsOn)
	(gTheIconBar disable: 1 3 5 6 7 8)
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

(procedure (proc0_7)) ; UNUSED

(procedure (Random300)
	(return (+ 1 (/ (Random 0 2999) 10)))
)

(procedure (proc0_9)
	(if (and (not (IsObject global204)) (IsObject (gTheIconBar curIcon:)))
		(= global204 (gTheIconBar curIcon:))
	)
)

(procedure (proc0_10)
	(if (IsObject global204)
		(gTheIconBar curIcon: global204)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(= global204 0)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 7))
				(not (gTheIconBar curInvIcon:))
			)
			(gTheIconBar advanceCurIcon:)
		)
	)
)

(procedure (NextDay)
	(ClearFlag 31)
	(ClearFlag 135)
	(++ gDay)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc0_14 param1 param2)
	(= global386 0)
	(= global387 0)
	(if argc
		(= global386 param1)
		(if (> argc 1)
			(= global387 param2)
		)
	)
)

(procedure (localproc_1 param1 param2 &tmp [temp0 400] [temp400 21] temp421 temp422 temp423 temp424)
	(= temp421 (GetSaveFiles (gGame name:) @temp0 @temp400))
	((= temp423 (File new:))
		name: (DeviceInfo 7 param2 (gGame name:)) ; MakeSaveDirName
		open: 2
	)
	(= temp424 2570)
	(for ((= temp422 0)) (< temp422 temp421) ((++ temp422))
		(if (!= temp422 param1)
			(temp423 write: @[temp400 temp422] 2)
			(temp423 writeString: @[temp0 (* temp422 18)])
			(temp423 write: @temp424 1)
		)
	)
	(= temp424 -1)
	(temp423 write: @temp424 2 close: dispose:)
	(DeviceInfo 8 param2 (gGame name:) [temp400 param1]) ; MakeSaveFileName
	(FileIO fiUNLINK param2)
	(DisposeScript 993)
)

(procedure (proc0_15)
	(if (not (IsFlag 101))
		(Palette palANIMATE &rest)
	)
)

(procedure (proc0_16 &tmp temp0 temp1)
	(= temp1 -32768)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& global200 temp1)
			(gTheIconBar disable: temp0)
		)
		(>>= temp1 $0001)
	)
)

(procedure (proc0_21 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(procedure (proc0_22) ; UNUSED
	(return 933)
)

(instance qg3KDHandler of EventHandler
	(properties)
)

(instance qg3MDHandler of EventHandler
	(properties)
)

(instance qg3DirHandler of EventHandler
	(properties)
)

(instance qg3Walkers of EventHandler
	(properties)
)

(class Glory of Game
	(properties)

	(method (init &tmp temp0 temp1 [temp2 2])
		(= gSystemWindow GloryWindow)
		((= gEgo (ScriptID 28 0)) view: 0) ; hero
		(= global17 -32761)
		(Actor origStep: 1027)
		(= global102 2)
		(= gWaitCursor 945)
		(= temp0 StopWalk)
		Timer
		Polygon
		PolyPath
		(super init:)
		(= gVersion {x.yyy.zzz})
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiCLOSE temp1)
		(= gDoVerbCode qg3DoVerbCode)
		(= gFtrInitializer qg3FtrInit)
		(= gQg3ApproachCode qg3ApproachCode)
		(= gMessager qg3Messager)
		((= gKeyDownHandler qg3KDHandler) add:)
		((= gMouseDownHandler qg3MDHandler) add:)
		((= gDirectionHandler qg3DirHandler) add:)
		((= gWalkHandler qg3Walkers) add:)
		(= gPMouse PseudoMouse)
		((= gLongSong longSong) owner: self flags: 1 init:)
		((= gLongSong2 longSong2) owner: self flags: 1 init:)
		((= gLongSong3 longSong3) owner: self flags: 1 init:)
		((= gTheIconBar mainIconBar)
			init:
			disable: 7 iconLeft iconRight
			curIcon: iconLook
		)
		((ScriptID 16 0) init:) ; gloryInv
		((ScriptID 1) init:) ; QG3Init
		(SetFlag 14)
	)

	(method (newRoom &tmp [temp0 3] temp3)
		(if (IsObject gCollect)
			(gCollect dispose:)
			(= gCollect 0)
		)
		(while (IsObject gFastCast)
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp3 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp3)
			)
			(temp3 dispose:)
			(gTheDoits doit:)
		)
		(super newRoom: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit:)
		(if (IsFlag 6)
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= gOldSysTime temp0)
				(= gOldSysTime temp0)
				(if (not (IsFlag 7))
					(= temp1 gClock)
					(if (>= (++ gClock) 3600)
						(= gClock 0)
						(NextDay)
					)
					(if (< (mod gClock 150) (mod temp1 150))
						((ScriptID 7 4) init:) ; fixTime
					)
					(cond
						(
							(and
								(>= gClock 772)
								(IsFlag 81)
								(not (IsFlag 31))
							)
							(PalVary pvREVERSE 64)
							(ClearFlag 81)
							(SetFlag 131)
						)
						((and (<= 2700 gClock) (not (IsFlag 81)))
							(SetFlag 31)
							(PalVary pvINIT gCurRoomNum 64)
							(SetFlag 131)
							(SetFlag 81)
						)
					)
				)
				(cond
					((and (> gClock 2750) (IsFlag 81))
						(= gNight 1)
						(= global40 1)
					)
					((and (> gClock 790) (not (IsFlag 81)))
						(= gNight 0)
						(= global40 0)
					)
				)
				(if
					(and
						(not (IsFlag 35))
						(not (IsFlag 130))
						(>= gDay 1)
						(>= gClock 2200)
						(not (gCurRoom script:))
						(not global156)
						(not (gEgo script:))
						(not (IsObject gFastCast))
						[gEgoStats 16] ; health
						(not (OneOf gCurRoomNum 230 240 250 260))
						(!= gCurRoomNum 340)
						(!= gCurRoomNum 550) ; combatRm
					)
					(SetFlag 130)
					((ScriptID 7 4) init: 19) ; fixTime
					(gMessager say: 26 6 20 0 0 0) ; "You don't want to be late for your meeting tomorrow. You head for your room so that you will be well rested."
					(if (== gCurRoomNum 310)
						(gCurRoom setScript: (ScriptID 310 1)) ; meeting
					else
						(gLongSong2 fade:)
						(gLongSong3 fade:)
						(gCurRoom newRoom: 310)
					)
				)
				(if (and (== gEgoGait 2) (gEgo mover:)) ; sneaking
					(gEgo useSkill: 8 2) ; sneak
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
				(if (<= (-= global463 global411) 0)
					(= global463 100)
					(if (IsFlag 3)
						(gEgo eatMeal:)
					)
				)
				(if (<= (-= global134 global411) 0)
					(= global134 20)
					(cond
						((or (> global137 1) (IsFlag 5))
							(gEgo useStamina: 5)
							(if (IsFlag 5)
								(gEgo useStamina: (>> global465 $0007))
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
					(if (not (or (> global137 1) (IsFlag 3) (IsFlag 115)))
						(gEgo takeDamage: -1)
					)
					(if (IsFlag 115)
						(cond
							((not (gEgo takeDamage: 3))
								(EgoDead 27 28) ; "You are completely strychnine by poison. No curare for you. Next time, take some poison cure pills."
							)
							((< [gEgoStats 16] (>> (gEgo maxHealth:) $0003)) ; health
								(gMessager say: 2 0 28 0 0 28) ; "You really don't feel well."
							)
						)
					)
				)
			)
			(if (and (not (IsFlag 7)) (IsFlag 8))
				(switch (-- global210)
					(0
						(ClearFlag 8)
						(gMessager say: 0 0 10 0 0 0) ; "Your Reversal spell has worn off."
					)
					(10
						(gMessager say: 0 0 11 0 0 0) ; "Your Reversal spell is wearing thin."
					)
				)
			)
		)
	)

	(method (startRoom roomNum &tmp temp0)
		(proc0_9)
		(gGame setCursor: gWaitCursor 1)
		((ScriptID 27 0) init: roomNum) ; StartARoom
		(DisposeScript 27)
		(if
			(and
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(FileIO fiEXISTS {18.scr})
				(gMessager say: 0 0 12 0 0 0) ; "Memory Fragment"
			)
			(SetDebug)
		)
		(if (OneOf roomNum 230 240 250 260)
			(ScriptID 51) ; bazaarR
		)
		StopWalk
		Cycle
		(if (FileIO fiEXISTS {18.scr})
			((ScriptID 18 0) init:) ; MISSING SCRIPT
		)
		(gEgo edgeHit: EDGE_NONE)
		(= global201 0)
		(super startRoom: roomNum)
		(if (not global208)
			(proc0_10)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
	)

	(method (restart)
		(gCurRoom style: 6 drawPic: 0)
		(gCast eachElementDo: #dispose)
		(super restart:)
	)

	(method (quitGame &tmp temp0 temp1)
		(= temp1 (gGame setCursor: 999))
		((= global469 (GameControls new:))
			window:
				((GloryWindow new:)
					top: 30
					left: 65
					bottom: 120
					right: 256
					priority: 15
					yourself:
				)
		)
		(= temp0 (textIcon new: 0 0 13 1 0))
		(temp0 view: 935 loop: 1 cel: 0 nsTop: 2 nsLeft: 2 modifiers: 1)
		(global469 add: temp0)
		(= temp0 (textIcon new: 0 0 14 1 0))
		(temp0 nsTop: 70 nsLeft: 80 cursor: 1)
		(global469 add: temp0)
		(= temp0 (textIcon new: 0 0 15 1 0))
		(temp0 nsTop: 70 nsLeft: 145 cursor: 2)
		(global469 add: temp0)
		(= temp0 (IconI new:))
		(temp0
			nsTop: 30
			nsLeft: 20
			view: 937
			loop: 1
			cel: 0
			maskView: 937
			maskLoop: 1
			maskCel: 0
			signal: 132
		)
		(global469 add: temp0)
		(global469 show: dispose:)
		(switch global460
			(1
				(= gQuit 1)
			)
			(2
				(gGame setCursor: temp1)
			)
		)
	)

	(method (setSpeed param1)
		(if (and argc (User canControl:))
			(gEgo setSpeed: param1)
			(super setSpeed: param1)
		)
		(gEgo moveSpeed:)
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSERELEASE)
			(gMouseDownHandler handleEvent: event)
		else
			(super handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
	)

	(method (pragmaFail &tmp temp0)
		(if (User canInput:)
			(= temp0 ((User curEvent:) message:))
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(switch temp0
				(1
					(gMessager say: 24 1 0 0 0 0) ; "You are somewhere in the land of Tarna."
				)
				(4
					(gMessager say: 24 4 0 0 0 0) ; "Think again."
				)
				(2
					(gMessager say: 24 2 0 0 0 0) ; "No one seems to be listening."
				)
				(74
					(if
						(OneOf
							gCurRoomNum
							150
							160
							170
							180
							310
							390
							400
							430
							440
							600
							700
							770
							780
							820
						)
						(gCurRoom doVerb: 74)
					else
						(gMessager say: 24 0 9 0 0 0) ; "This doesn't seem to be a good place to sleep."
					)
				)
				(81
					(if
						(OneOf
							gCurRoomNum
							230
							280
							310
							380
							400
							430
							650
							700
							810
							820
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 81)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(83
					(if
						(OneOf
							gCurRoomNum
							0
							230
							280
							310
							380
							400
							430
							700
							810
							820
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 83)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(88
					(if
						(OneOf
							gCurRoomNum
							0
							230
							280
							310
							380
							400
							430
							700
							810
							820
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 88)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(75
					(if
						(OneOf
							gCurRoomNum
							230
							310
							380
							430
							450
							640
							650
							700
							810
							820
							853
						)
						(gCurRoom doVerb: 75)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(76
					(if
						(OneOf
							gCurRoomNum
							230
							280
							310
							390
							430
							650
							770
							780
							810
							853
						)
						(gCurRoom doVerb: 76)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(77
					(if
						(OneOf
							gCurRoomNum
							230
							280
							310
							400
							430
							650
							700
							850
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 77)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(78
					(if
						(OneOf
							gCurRoomNum
							230
							280
							310
							400
							430
							650
							700
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 78)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(80
					(if
						(OneOf
							gCurRoomNum
							230
							280
							310
							390
							400
							430
							450
							630
							650
							700
							820
							850
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 80)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(82
					(cond
						(
							(OneOf
								gCurRoomNum
								230
								280
								310
								380
								430
								640
								650
								700
								810
							)
							(gCurRoom doVerb: 82)
						)
						((> (gEgo view:) 5)
							(gMessager say: 0 0 21 1 0 0) ; "You're not in a very good position for casting spells at the moment."
						)
						(else
							(gEgo setScript: (ScriptID 37)) ; castFetchScript
						)
					)
				)
				(84
					(if
						(OneOf
							gCurRoomNum
							280
							310
							400
							430
							650
							700
							720
							740
							851
							852
							853
							854
						)
						(gCurRoom doVerb: 84)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(87
					(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
						(gCurRoom doVerb: 87)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(85
					(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
						(gCurRoom doVerb: 85)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(86
					(if (OneOf gCurRoomNum 230 280 310 400 430 650 700 853)
						(gCurRoom doVerb: 86)
					else
						(gMessager say: 24 0 8 0 0 0) ; "This is not a good place to practice your magic."
					)
				)
				(66
					(gMessager say: 24 66 22 0 0 0) ; "You can't heal that!"
				)
				(20
					(if (OneOf gCurRoomNum 230 400 460 700)
						(gCurRoom doVerb: 20)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(33
					(if (OneOf gCurRoomNum 400 700)
						(gCurRoom doVerb: 33)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(13
					(if (OneOf gCurRoomNum 380 810 851 852)
						(gCurRoom doVerb: 13)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(56
					(if (OneOf gCurRoomNum 380 851)
						(gCurRoom doVerb: 56)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(16
					(if (OneOf gCurRoomNum 0)
						(gCurRoom doVerb: 16)
					else
						(gMessager say: 24 0 7 0 0 0) ; "This does not seem to be the best place to do that."
					)
				)
				(else
					(gMessager say: 24 0 6 0 0 0) ; "Think again."
				)
			)
		)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(= temp0 gTheCursor)
		(if argc
			(if (IsObject param1)
				((= gTheCursor param1) init:)
			else
				(SetCursor (= gTheCursor param1) 0 0)
			)
		)
		(if (and (> argc 1) (not param2))
			(SetCursor 996 0 0)
		)
		(if (> argc 2)
			(SetCursor param3 param4)
		)
		(return temp0)
	)

	(method (showAbout)
		((ScriptID 19 0) doit:) ; aboutCode
	)

	(method (save param1 &tmp [temp0 400] [temp400 21] [temp421 18] [temp439 41] [temp480 70] temp550 temp551 temp552 temp553 temp554 temp555 [temp556 30])
		(if (and (== argc 1) (== param1 1))
			(GetCWD @temp480)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
			(Message msgGET 0 0 0 16 1 @temp439) ; "Automatic Save"
			(= temp552 0)
			(= temp551 -1)
			(for ((= temp553 0)) (< temp553 temp550) ((++ temp553))
				(if (not (= temp552 (StrCmp @temp439 @[temp0 (* temp553 18)])))
					(= temp551 temp553)
					(break)
				)
			)
			(if (>= temp551 0)
				(localproc_1 temp551 @temp439)
				(for
					((= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400)))
					(and (> temp550 0) (not (CheckFreeSpace @temp480)))
					((= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400)))
					
					(localproc_1 (- temp550 1) @[temp0 (* (- temp550 1) 18)])
				)
				(if (CheckFreeSpace @temp480)
					(Message msgGET 0 0 0 16 1 @temp421) ; "Automatic Save"
					(= temp554 (localproc_0))
					(if (not (SaveGame name temp554 @temp421 gVersion))
						(Message msgGET 0 0 17 1 @temp556)
						(Print addTextF: @temp556 init:)
						(return)
					else
						(if (not (and argc param1))
							(Message msgGET 0 0 18 1 @temp556)
							(Print addTextF: @temp556 init:)
						)
						(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
					)
				else
					(Message msgGET 0 0 0 19 1 @temp556) ; "Your disk is full."
					(Print addTextF: @temp556 init:)
					(return)
				)
			else
				(while
					(and
						(> temp550 0)
						(or (not (CheckFreeSpace @temp480)) (>= temp550 20))
					)
					(localproc_1 (- temp550 1) @[temp0 (* (- temp550 1) 18)])
					(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
				)
				(Message msgGET 0 0 0 16 1 @temp421) ; "Automatic Save"
				(= temp554 (localproc_0))
				(if (not (SaveGame name temp554 @temp421 gVersion))
					(Message msgGET 0 0 17 1 @temp556)
					(Print addTextF: @temp556 init:)
					(return)
				else
					(if (not (and argc param1))
						(Message msgGET 0 0 18 1 @temp556)
						(Print addTextF: @temp556 init:)
					)
					(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
				)
			)
			(while ((= temp555 (Event new:)) type:)
				(temp555 dispose:)
			)
			(temp555 dispose:)
		else
			(super save: &rest)
		)
		(gGame setCursor: ((mainIconBar curIcon:) cursor:))
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

(instance qg3DoVerbCode of Code
	(properties)

	(method (doit param1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch param1
			(3
				((User curEvent:) claimed: 0)
			)
			(1
				(gMessager say: 25 1 0 0 0 0) ; "That's interesting."
			)
			(4
				(gMessager say: 25 4 0 0 0 0) ; "Think again."
			)
			(2
				(gMessager say: 25 2 0 0 0 0) ; "It doesn't say much."
			)
			(74
				(if
					(OneOf
						gCurRoomNum
						150
						160
						170
						180
						310
						390
						400
						430
						440
						600
						700
						770
						780
						820
					)
					(gCurRoom doVerb: 74)
				else
					(gMessager say: 24 0 9 0 0 0) ; "This doesn't seem to be a good place to sleep."
				)
			)
			(81
				(if
					(OneOf
						gCurRoomNum
						230
						280
						310
						380
						400
						430
						650
						700
						810
						820
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 81)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(83
				(if
					(OneOf
						gCurRoomNum
						0
						230
						280
						310
						380
						400
						430
						700
						810
						820
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 83)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(88
				(if
					(OneOf
						gCurRoomNum
						0
						230
						280
						310
						380
						400
						430
						700
						810
						820
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 88)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(75
				(if
					(OneOf
						gCurRoomNum
						230
						310
						380
						430
						450
						640
						650
						700
						810
						820
						853
					)
					(gCurRoom doVerb: 75)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(76
				(if (OneOf gCurRoomNum 230 280 310 390 430 650 770 780 810 853)
					(gCurRoom doVerb: 76)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(77
				(if
					(OneOf
						gCurRoomNum
						230
						280
						310
						400
						430
						650
						700
						850
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 77)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(78
				(if
					(OneOf
						gCurRoomNum
						230
						280
						310
						400
						430
						650
						700
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 78)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(80
				(if
					(OneOf
						gCurRoomNum
						230
						280
						310
						390
						400
						430
						450
						630
						650
						700
						820
						850
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 80)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(82
				(cond
					((OneOf gCurRoomNum 230 280 310 380 430 640 650 700 810)
						(gCurRoom doVerb: 82)
					)
					((> (gEgo view:) 5)
						(gMessager say: 0 0 21 1 0 0) ; "You're not in a very good position for casting spells at the moment."
					)
					(else
						(gEgo setScript: (ScriptID 37)) ; castFetchScript
					)
				)
			)
			(84
				(if
					(OneOf
						gCurRoomNum
						280
						310
						400
						430
						650
						700
						720
						740
						851
						852
						853
						854
					)
					(gCurRoom doVerb: 84)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(87
				(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
					(gCurRoom doVerb: 87)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(85
				(if (OneOf gCurRoomNum 280 310 400 430 650 700 850 853)
					(gCurRoom doVerb: 85)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(86
				(if (OneOf gCurRoomNum 230 280 310 400 430 650 700 853)
					(gCurRoom doVerb: 86)
				else
					(gMessager say: 25 0 3 0 0 0) ; "You can't cast that spell here."
				)
			)
			(66
				(gMessager say: 25 66 23 0 0 0) ; "Save your healing for where it's needed."
			)
			(20
				(if (OneOf gCurRoomNum 230 400 460 700)
					(gCurRoom doVerb: 20)
				else
					(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
				)
			)
			(16
				(if (OneOf gCurRoomNum 0)
					(gCurRoom doVerb: 16)
				else
					(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
				)
			)
			(33
				(if (OneOf gCurRoomNum 400 700)
					(gCurRoom doVerb: 33)
				else
					(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
				)
			)
			(13
				(if (OneOf gCurRoomNum 380 810 851 852)
					(gCurRoom doVerb: 13)
				else
					(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
				)
			)
			(56
				(if (OneOf gCurRoomNum 380 851)
					(gCurRoom doVerb: 56)
				else
					(gMessager say: 25 0 7 0 0 0) ; "This is not a good place to practice throwing."
				)
			)
			(else
				(gMessager say: 25 0 5 0 0 0) ; "That didn't do any good."
			)
		)
	)
)

(instance qg3FtrInit of Code
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

(instance qg3ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(cond
				((== param1 1) 1)
				((== param1 2) 2)
				((== param1 3) 4)
				((== param1 4) 8)
				((<= 10 param1 59) 16)
				((<= 75 param1 88) 32)
				((== param1 -1) -1)
				(else -32768)
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
		(temp0 argCount: argc noun: param1 verb: param2 case: param3)
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
		(if (and (not said) (not (gMessager talkerList:)))
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

(instance qg3Messager of Messager
	(properties)

	(method (say)
		(if (== gNewRoomNum gCurRoomNum)
			(if talkerList
				(MessObj new: &rest)
			else
				(super say: &rest)
			)
		)
	)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(7
						(ScriptID 210 1) ; guard1Talker
					)
					(8
						(ScriptID 210 2) ; guard2Talker
					)
					(9
						(ScriptID 210 1) ; guard1Talker
					)
					(10
						(ScriptID 210 2) ; guard2Talker
					)
					(21
						(ScriptID 230 1) ; tMoneyChangerTalker
					)
					(22
						(ScriptID 232 1) ; tFruitTalker
					)
					(23
						(ScriptID 235 1) ; tLeatherTalker
					)
					(66
						(ScriptID 234 0) ; guardTalker
					)
					(27
						(ScriptID 245 0) ; weaponTalker
					)
					(26
						(ScriptID 247 0) ; honeyTalker
					)
					(25
						(ScriptID 248 0) ; oilTalker
					)
					(32
						(ScriptID 246 0) ; sanfordTalker
					)
					(33
						(ScriptID 246 1) ; sonTalker
					)
					(67
						(ScriptID 241 2) ; guardTalker
					)
					(30
						(ScriptID 250 1) ; beadTalker
					)
					(28
						(ScriptID 250 2) ; fishTalker
					)
					(29
						(ScriptID 250 3) ; ropeTalker
					)
					(39
						(ScriptID 360 1) ; anubisTalker
					)
					(72
						(ScriptID 360 2) ; desTalker
					)
					(58
						(ScriptID 290 1) ; salimTalker
					)
					(37
						(ScriptID 300 1) ; survivorTalker
					)
					(36
						(ScriptID 300 2) ; welcomeTalker
					)
					(62
						(ScriptID 320 1) ; rightGuardTalker
					)
					(63
						(ScriptID 320 2) ; leftGuardTalker
					)
					(64
						(ScriptID 320 3) ; rightGuardTalker
					)
					(65
						(ScriptID 320 4) ; leftGuardTalker
					)
					(4
						(ScriptID 330 1) ; rajahTalker
					)
					(18
						(ScriptID 340 1) ; speakerTalker
					)
					(15
						(ScriptID 340 2) ; warriorTalker
					)
					(57
						(ScriptID 340 3) ; MISSING EXPORT
					)
					(16
						(ScriptID 340 4) ; motherTalker
					)
					(61
						(ScriptID 340 5) ; haramiTalker
					)
					(20
						(ScriptID 241 1) ; haramiTalker
					)
					(38
						(ScriptID 350 1) ; sekhmetTalker
					)
					(42
						(ScriptID 58 0) ; elderTalker
					)
					(43
						(ScriptID 58 0) ; elderTalker
					)
					(59
						(ScriptID 420 1) ; MISSING EXPORT
					)
					(54
						(ScriptID 820 1) ; demonaTalker
					)
					(53
						(ScriptID 850 1) ; deWizTalker
					)
					(13
						(ScriptID 49 0) ; kreeshaTalker
					)
					(60
						(ScriptID 48 0) ; priestessTalker
					)
					(50
						(ScriptID 43 0) ; shamanTalker
					)
					(49
						(ScriptID 44 0) ; leaderTalker
					)
					(3
						(ScriptID 34 0) ; uhuraTalker
					)
					(2
						(ScriptID 35 0) ; rakeeshTalker
					)
					(48
						(ScriptID 36 0) ; johariTalker
					)
					(41
						(ScriptID 39 0) ; yesufuTalker
					)
					(19
						(ScriptID 40 0) ; haramiATalker
					)
					(40
						(ScriptID 42 0) ; laibonTalker
					)
					(51
						(ScriptID 41 0) ; monkeyTalker
					)
					(44
						(ScriptID 53 0) ; storyTalker
					)
					(46
						(ScriptID 401 1) ; laurelTalker
					)
					(47
						(ScriptID 401 2) ; hardyTalker
					)
					(45
						(ScriptID 402 1) ; aardvarkTalker
					)
					(6
						(ScriptID 110 1) ; azizaTalker
					)
					(11
						(ScriptID 120 1) ; sultanTalker
					)
					(5
						(ScriptID 100 1) ; avisTalker
					)
					(24
						(ScriptID 260 1) ; kattaTalker
					)
					(34
						(ScriptID 260 2) ; meatTalker
					)
					(35
						(ScriptID 260 3) ; amuletTalker
					)
					(31
						(ScriptID 260 4) ; clothTalker
					)
					(68
						(ScriptID 285 1) ; kreeshaBTalker
					)
					(69
						(ScriptID 285 2) ; rakeeshBTalker
					)
					(52
						(ScriptID 830 1) ; reeshaTalker
					)
					(70
						(ScriptID 490 1) ; yesuTalker
					)
					(71
						(ScriptID 830 2) ; reeshaBTalker
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(class GlorySong of Sound
	(properties
		change 0
		nextSong 0
		loopTwice 0
		holdVal 0
	)

	(method (check)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if change
				(= change 0)
				(self play: vol client)
			else
				(if (IsObject client)
					(client cue: self)
				)
				(if (and nextSong (== prevSignal -1))
					(= number nextSong)
					(= nextSong 0)
					(self setLoop: -1 play: vol)
				)
				(if (== prevSignal 126)
					(if loopTwice
						(= loopTwice 0)
						(self play: vol)
						(if holdVal
							(self hold: holdVal)
						)
					else
						(= loopTwice 1)
					)
				)
			)
		)
	)

	(method (changeTo param1 param2)
		(= number param1)
		(= change 1)
		(if (> argc 1)
			(= client param2)
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

(instance mainIconBar of IconBar
	(properties)

	(method (init)
		(self
			add:
				iconLeft
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconActions
				iconCast
				iconUseIt
				iconInventory
				iconControlPanel
				iconHelp
				iconRight
			eachElementDo: #init
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			useIconItem: iconUseIt
			helpIconItem: iconHelp
			walkIconItem: iconWalk
			state: 3072
		)
		(iconHelp view: 930 loop: 9)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: 999 1)
		(= height
			(CelHigh ((= temp0 (self at: 0)) view:) (temp0 loop:) (temp0 cel:))
		)
		(= port (GetPort))
		(SetPort -1)
		(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
		(= temp1 (PicNotValid))
		(PicNotValid 1)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
			(= temp6 (NextNode temp5))
			(if (not (IsObject (= temp7 (NodeValue temp5))))
				(return)
			)
			(if (<= (temp7 nsRight:) 0)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			else
				(temp7 show:)
			)
		)
		(if curInvIcon
			(if (gEgo has: (gInventory indexOf: curInvIcon))
				(= temp3
					(+
						(/
							(-
								(- (useIconItem nsRight:) (useIconItem nsLeft:))
								(CelWide
									(curInvIcon view:)
									(curInvIcon loop:)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsLeft:)
					)
				)
				(= temp4
					(+
						y
						(/
							(-
								(- (useIconItem nsBottom:) (useIconItem nsTop:))
								(CelHigh
									(curInvIcon view:)
									(curInvIcon loop:)
									(curInvIcon cel:)
								)
							)
							2
						)
						(useIconItem nsTop:)
					)
				)
				(DrawCel
					(curInvIcon view:)
					(curInvIcon loop:)
					(curInvIcon cel:)
					temp3
					temp4
					-1
				)
				(if (& (useIconItem signal:) $0004)
					(useIconItem mask:)
				)
			else
				(= curInvIcon 0)
			)
		)
		(PicNotValid temp1)
		(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
		(self highlight: curIcon)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			((& state $0004)
				(return)
			)
			((and (!= curIcon iconWalk) (not (& (iconWalk signal:) $0004)))
				(= prevIcon curIcon)
				(= curIcon iconWalk)
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)

	(method (handleEvent event)
		(if (> (event y:) (self height:))
			(self hide:)
		)
		(super handleEvent: event)
	)

	(method (hide)
		(super hide:)
		(if global449
			(PalVary pvPAUSE_RESUME 0)
			(ClearFlag 121)
			(= global449 0)
		)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(if (& (curIcon signal:) $0004)
			(self advanceCurIcon:)
		)
	)
)

(instance iconLeft of IconI
	(properties
		view 930
		loop 12
		cel 1
		nsTop 0
		cursor 69
	)

	(method (show)
		(super show: -30 nsTop)
	)

	(method (select)
		(return 0)
	)

	(method (mask))
)

(instance iconRight of IconI
	(properties
		view 930
		loop 13
		cel 1
		cursor 69
	)

	(method (select)
		(return 0)
	)

	(method (mask))
)

(instance iconWalk of IconI
	(properties
		view 930
		loop 0
		cel 0
		cursor 940
		type 20480
		message 3
		signal 65
		maskView 930
		maskLoop 14
		noun 14
		helpVerb 9
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gEgo changeGait: 0 1) ; walking
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconLook of IconI
	(properties
		view 930
		loop 1
		cel 0
		cursor 941
		message 1
		signal 65
		maskView 930
		maskLoop 14
		noun 15
		helpVerb 9
	)
)

(instance iconDo of IconI
	(properties
		view 930
		loop 2
		cel 0
		cursor 942
		message 4
		signal 65
		maskView 930
		maskLoop 14
		noun 16
		helpVerb 9
	)
)

(instance iconTalk of IconI
	(properties
		view 930
		loop 3
		cel 0
		cursor 943
		message 2
		signal 65
		maskView 930
		maskLoop 14
		noun 17
		helpVerb 9
	)
)

(instance iconActions of IconI
	(properties
		view 930
		loop 10
		cel 0
		cursor 942
		message 7
		signal 66
		maskView 930
		maskLoop 14
		noun 18
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(proc0_9)
			(gTheIconBar hide:)
			((ScriptID 20) init: show:) ; actionBar
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconCast of IconI
	(properties
		view 930
		loop 11
		cel 0
		message 8
		signal 67
		maskView 930
		maskLoop 14
		noun 19
		helpVerb 9
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(if (!= ((gTheIconBar curIcon:) cursor:) 948)
				(proc0_9)
			)
			(gTheIconBar hide:)
			(cond
				((not [gEgoStats 12]) ; magic use
					(gMessager say: 26 6 27 0 0 0) ; "You do not have any magical ability."
				)
				(
					(OneOf
						gCurRoomNum
						210
						240
						250
						260
						270
						290
						300
						320
						330
						340
						360
					)
					(gMessager say: 26 6 24 0 0 0) ; "You were told that you shouldn't use magic in Tarna. Someone might see you here."
				)
				(
					(and
						(OneOf
							gCurRoomNum
							410
							420
							440
							450
							460
							470
							475
							480
							485
							490
						)
						(not (and (== gCurRoomNum 450) gNight))
					)
					(gMessager say: 26 6 25 0 0 0) ; "It would not be a good idea to use magic in the Simbani village."
				)
				(else
					(for ((= temp1 0)) (< temp1 15) ((++ temp1))
						(if (= temp0 [gEgoStats (+ 19 temp1)])
							(break)
						)
					)
					(if (not temp0)
						(gMessager say: 26 6 26 0 0 0) ; "You do not know any spells."
					else
						((ScriptID 21) init: showSelf: dispose:) ; glorySpells
						(DisposeScript 21)
					)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconUseIt of IconI
	(properties
		view 930
		loop 4
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 930
		maskLoop 14
		maskCel 1
		noun 20
		helpVerb 9
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if (= temp2 (gTheIconBar curInvIcon:))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel
							(temp2 view:)
							(temp2 loop:)
							(temp2 cel:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(if (= temp2 (gTheIconBar curInvIcon:))
										(DrawCel
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= temp2 (gTheIconBar curInvIcon:))
									(DrawCel
										(temp2 view:)
										(temp2 loop:)
										(temp2 cel:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= temp2 (gTheIconBar curInvIcon:))
							(DrawCel
								(temp2 view:)
								(temp2 loop:)
								(temp2 cel:)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance iconInventory of IconI
	(properties
		view 930
		loop 5
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 930
		maskLoop 14
		noun 21
		helpVerb 9
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 16 1) init: gEgo) ; pageCode
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconControlPanel of IconI
	(properties
		view 930
		loop 7
		cel 0
		cursor 999
		message 9
		signal 67
		maskView 930
		maskLoop 14
		noun 22
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 25) init: show: dispose:) ; controlPanel
			(DisposeScript 25)
			(DisposeScript 19)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconHelp of IconI
	(properties
		view 930
		loop 9
		cel 0
		cursor 949
		message 9
		signal 3
		maskView 930
		maskLoop 14
		noun 23
		helpVerb 9
	)
)

(instance textIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
	)

	(method (new param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(= temp0 (Clone self))
		(if argc
			(= temp1 (Message msgSIZE param5 param1 param2 param3 param4))
			(temp0 message: (Memory memALLOC_NONCRIT temp1))
			(Message msgGET param5 param1 param2 param3 param4 (temp0 message:))
		)
		(return temp0)
	)

	(method (show)
		(= nsRight (+ nsLeft (if (== loop 1) 0 else 60)))
		(= nsBottom
			(if (== loop 1)
				nsTop
			else
				(+ nsTop 15)
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display
			message
			dsCOORD
			(if (== loop 1)
				nsLeft
			else
				(+ nsLeft 20)
			)
			(+ nsTop 2)
			dsFONT
			(if (== loop 1) 123 else 0)
			dsCOLOR
			17
			dsALIGN
			modifiers
			dsWIDTH
			(if (== loop 1) 189 else 40)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (!= loop 1)
			(if param1
				(DrawCel view loop 1 nsLeft nsTop -1)
				(= temp0 46)
			else
				(DrawCel view loop 0 nsLeft nsTop -1)
				(= temp0 17)
			)
			(Display
				message
				dsCOORD
				(if (== loop 1)
					nsLeft
				else
					(+ nsLeft 20)
				)
				(+ nsTop 2)
				dsFONT
				(if (== loop 1) 123 else 0)
				dsCOLOR
				temp0
				dsALIGN
				modifiers
				dsWIDTH
				(if (== loop 1) 189 else 40)
			)
		)
	)

	(method (select)
		(if (!= loop 1)
			(= global460 cursor)
			(global469 state: (& (global469 state:) $ffdf))
		else
			(return 0)
		)
	)

	(method (dispose)
		(Memory memFREE message)
		(super dispose:)
	)
)

