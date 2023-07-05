;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use KeyMouse)
(use SpeakWindow)
(use domino1)
(use checkers)
(use Interface)
(use dummyPublic0)
(use pachisi)
(use yacht)
(use snakes)
(use hoyle3GameControls)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	hoyle3 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
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
	global18
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 20
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVersion
	gLocales
	gCurSaveDir
	; 30
	global30 = 10
	gPerspective
	gFeatures
	global33
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemWindow
	global39 = 3
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
	global66
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
	gTextSpeed
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	global100
	global101 = 3
	gLooperDir8
	gSnakes_opt
	gChar1
	; 105
	gChar2
	gChar3
	global107
	global108
	gAbsoluteCast
	; 110
	global110
	global111
	global112
	gDomino
	gMouseCursor
	; 115
	global115
	gTheInputList
	global117
	global118
	global119
	; 120
	global120
	global121
	global122
	global123
	global124
	; 125
	global125
	global126
	global127
	global128
	global129
	; 130
	global130 = 1
	global131 = 200
	global132
	global133
	global134
	; 135
	global135
	global136
	global137
	gShowBoneYard
	global139
	; 140
	global140
	global141
	global142
	global143
	gTheKeyMouseList
	; 145
	global145
	gDominoes_opt
	gGame_opt
	global148
	global149
	; 150
	global150
	global151
	global152
	global153
	global154
	; 155
	global155
	global156
	global157
	global158 = 1
	global159
	; 160
	global160
	global161
	global162
	global163
	global164
	; 165
	global165 = 2
	global166
	global167
	global168
	global169
	; 170
	global170
	global171
	global172 = 3
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
	global182 = 999
	global183
	global184
	; 185
	global185 = 1
	global186
	global187
	global188 = 1
	global189 = 1
	; 190
	global190
	global191
	global192
	global193
	global194 = 1
	; 195
	global195 = 1
	global196 = 1
	global197 = 1
	global198
	global199 = 6
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
	global248 = 35
	global249
	; 250
	global250
	global251
	global252
	global253
	gGameScript
	; 255
	global255
	global256
	global257
	global258
	global259
	; 260
	global260
	gCheckers_opt
	global262
	global263
	global264
	; 265
	global265
	global266 = 200
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
	gPropList
	gStar
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	gMoveScript
	gSnakesScript
	gBoy1
	gBoy2
	; 290
	gGirl1
	gGirl2
	gSlSquares
	global293
	global294
	; 295
	global295
	global296
	gSong
	gSound
	gSound2
	; 300
	gAllStonesObj
	gThePoints
	gTheDiceList
	global303
	global304
	; 305
	global305
	global306
	global307
	gGamePlayScript
	gTheDice1
	; 310
	gTheDice2
	gTheDice3
	gTheDice4
	gTheBar1
	gTheBar2
	; 315
	global315
	gAssocPoint
	global317 = 300
	gBackgam_opt
	global319
	; 320
	gTheDiceCup
	gTheDoubleCube
	global322
	global323
	global324
	; 325
	global325
	global326
	global327
	gTheArrow
	global329
	; 330
	global330
	global331
	global332
	global333
	global334
	; 335
	gACast
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
	gTheGameSquares
	global401
	global402 = 400
	gPachisi_opt
	global404
	; 405
	gTheGamePieces
	global406 = 400
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
	gSound3
	gSound4
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
	global466
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
	gOnesScore
	gTwosScore
	gThreesScore
	gFoursScore
	; 525
	gFivesScore
	gSixesScore
	gFourOfAKindScore
	gFullHouseScore
	gSmStraightScore
	; 530
	gLgStraightScore
	gYahtzeeScore
	gChanceScore
	global533
	global534
	; 535
	gYacht_opt
	global536 = 1
	global537
	global538 = 1
	global539
	; 540
	gDoAbsCode
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
	global749
)

(procedure (proc0_6)
	(if (gAbsoluteCast size:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(Animate (gAbsoluteCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(if (gAbsoluteCast size:)
				(gAbsoluteCast eachElementDo: #motionCue)
			)
		)
	)
)

(procedure (proc0_1)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_2 param1)
	(return (and (== (param1 type:) 4) (== (param1 message:) 13)))
)

(procedure (localproc_0)
	((= gTheIconBar IconBar)
		curIcon: gameControlIcon
		init:
		add: gameControlIcon optionsIcon scoreIcon rulesIcon helpIcon
		eachElementDo: #init
		helpIconItem: helpIcon
	)
)

(procedure (proc0_4 param1)
	(if
		(or
			(User controls:)
			(and argc (!= param1 gTheCursor))
			(and (not argc) (== gTheCursor 30))
		)
		(User canControl: 0 canInput: 0)
		(if (not (HaveMouse))
			(if (and (!= gTheCursor 20) (!= gTheCursor 30))
				(= global183 ((User curEvent:) x:))
				(= global184 ((User curEvent:) y:))
				(= global182 gTheCursor)
			)
			(gGame setCursor: (if argc param1 else 20) 1 319 199)
		else
			(gGame setCursor: (if argc param1 else 20) 1)
		)
	)
)

(procedure (proc0_3)
	(if (not (User controls:))
		(User canControl: 1 canInput: 1)
		(if (not (HaveMouse))
			(gGame setCursor: global182 1 global183 global184)
		else
			(gGame setCursor: global182)
		)
	)
)

(procedure (proc0_5 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 1)
	)
)

(procedure (localproc_1)
	(= global375 0)
	(= global376 -1)
	(if (= global294 (== (Graph grGET_COLOURS) 16))
		(= global370 0)
		(= global377 14)
		(= global378 31)
		(= global379 31)
		(= global380 8)
		(= global381 8)
		(= global382 7)
	else
		(= global370 1)
		(= global377 50)
	)
)

(class ColorBorderWindow of BorderWindow
	(properties)

	(method (open)
		(= topBordColor (+ back 2))
		(= lftBordColor (+ back 1))
		(= rgtBordColor (- back 1))
		(= botBordColor (- back 2))
		(if global294
			(= topBordColor global378)
			(= lftBordColor global379)
			(= rgtBordColor global381)
			(= botBordColor global380)
			(= back global382)
			(= color global375)
		)
		(super open: &rest)
	)
)

(class KMRect of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)
)

(class KMView of View
	(properties)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)
)

(class KMActor of Actor
	(properties
		cycleSpeed 3
		moveSpeed 3
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)
)

(class Character of View
	(properties
		loop 1
		priority 6
		face 0
		charScript 0
		active 0
		holdTalk 30
		ticks 0
	)

	(method (init)
		(self
			setLoop: loop
			cel: 0
			posn: x y
			setPri: priority
			ignoreActors:
			stopUpd:
		)
		(super init:)
	)

	(method (stop param1)
		(if (and active (!= self param1))
			(face setCycle: 0 hide:)
		)
	)

	(method (smile param1 param2)
		(= global108 0)
		(if active
			(charScript
				caller: (if (>= argc 2) param2 else 0)
				register:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast add: face)
			(face startUpd: loop: 2 setScript: charScript init:)
		)
	)

	(method (laugh param1 param2)
		(= global108 0)
		(if active
			(charScript
				caller: (if (>= argc 2) param2 else 0)
				register:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast add: face)
			(face startUpd: loop: 3 setScript: charScript init:)
		)
	)

	(method (frown param1 param2)
		(= global108 0)
		(if active
			(charScript
				caller: (if (>= argc 2) param2 else 0)
				register:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast add: face)
			(face startUpd: loop: 4 setScript: charScript init:)
		)
	)

	(method (posn)
		(super posn: &rest)
		(face posn: x y)
	)

	(method (say param1 param2 param3 param4 &tmp temp0 [temp1 500] temp501 temp502 temp503 temp504 temp505)
		(face setScript: 0)
		(if (and (<= 100 global187 500) (not (mod global187 100)))
			(if (>= argc 3)
				(= global108 param3)
			)
			(if (>= argc 4)
				(cond
					((== param4 -32768)
						(= temp504 1)
					)
					(param4
						(= temp505 param4)
						(= temp504 0)
					)
					(else
						(= temp505 5)
						(= temp504 0)
					)
				)
			)
			(if (and (not temp504) (Random 0 temp505))
				(= global108 0)
			)
			(if (u< param1 100)
				(if active
					(= temp501 (+ (* 1000 (+ view 1)) global187))
					(= temp502 param1)
				else
					(= temp501 (+ 19000 global187))
					(= temp502 (/ param1 3))
				)
				(GetFarText temp501 temp502 @temp1)
				(= param1 (Format @global550 0 0 @temp1)) ; "%s"
			)
			(= temp503 (if (> argc 1) param2 else 0))
			(cond
				(active
					(if global83
						(self startAudio: (+ temp501 temp502))
					else
						(self startText: param1)
					)
				)
				(temp503
					(if global83
						(= temp0 (+ temp501 temp502))
						(DoAudio audWPLAY temp0)
						(DoAudio audPLAY temp0)
					else
						(Print param1)
					)
				)
			)
		)
	)

	(method (startText param1 &tmp [temp0 500] [temp500 4] temp504)
		(= temp504 (Format @temp0 param1))
		(self setLen: (StrLen @temp0))
		(face loop: 0 show: startUpd: setCycle: RandCycle init:)
		(theTalker release:)
		(theTalker add: face)
		(SpeakWindow speakObj: self)
		(TextSize @[temp500 0] temp504 gUserFont 0)
		(Characters eachElementDo: #stop self)
		(proc0_1)
		(if (< [temp500 3] 60)
			(Print @temp0 35 SpeakWindow 25 holdTalk 179 talkCode 70 80 30 1)
		else
			(Print @temp0 35 SpeakWindow 25 holdTalk 179 talkCode)
		)
		(theTalker delete: face)
		(if global108
			(self global108:)
		else
			(face setCycle: 0 hide: stopUpd:)
		)
	)

	(method (startAudio param1 &tmp temp0)
		(= temp0 param1)
		(= ticks (DoAudio audWPLAY temp0))
		(gAbsoluteCast add: face)
		(face loop: 0 show: startUpd: setCycle: Unknown_Class_33 0 temp0 init:)
		(Unknown_Class_8 set60ths: self ticks)
		(DoAudio audPLAY temp0)
	)

	(method (setLen param1)
		(if (< param1 1)
			(= param1 1)
		)
		(= holdTalk (+ (/ param1 20) (/ global199 2) 1))
		(if (== global199 15)
			(= holdTalk 30000)
		)
	)

	(method (cue)
		(gAbsoluteCast delete: face)
		(if (and global83 global108)
			(self global108:)
		)
	)
)

(class Characters of List
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) active:)
				(((self at: temp0) face:)
					init:
					hide:
					setPri: (((self at: temp0) face:) priority:)
				)
			)
		)
	)

	(method (laugh)
		(self eachElementDo: #laugh)
	)

	(method (smile)
		(self eachElementDo: #smile)
	)

	(method (frown)
		(self eachElementDo: #frown)
	)

	(method (say &tmp temp0 temp1 temp2 temp3)
		(switch
			(= temp0
				(+
					(= temp0
						(+
							(= temp0
								(+ (= temp0 0) ((= temp1 (self at: 0)) active:))
							)
							((= temp2 (self at: 1)) active:)
						)
					)
					((= temp3 (self at: 2)) active:)
				)
			)
			(2
				(switch (Random 0 1)
					(0
						(temp1 say: &rest)
					)
					(1
						(temp2 say: &rest)
					)
				)
			)
			(3
				(switch (Random 0 2)
					(0
						(temp1 say: &rest)
					)
					(1
						(temp2 say: &rest)
					)
					(2
						(temp3 say: &rest)
					)
				)
			)
			(else
				(temp1 say: &rest)
			)
		)
	)
)

(instance theTalker of Set
	(properties)
)

(instance talkCode of Code
	(properties)

	(method (doit)
		(if (theTalker size:)
			(Animate (theTalker elements:) 1)
		)
	)
)

(instance char1 of Character
	(properties)
)

(instance char2 of Character
	(properties)
)

(instance char3 of Character
	(properties)
)

(instance face1 of Prop
	(properties
		priority 7
	)
)

(instance face2 of Prop
	(properties
		priority 7
	)
)

(instance face3 of Prop
	(properties
		priority 7
	)
)

(instance charScript1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide: stopUpd:)
				(if caller
					(caller cue:)
				)
				(proc0_1)
			)
		)
	)
)

(instance charScript2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide: stopUpd:)
				(if caller
					(caller cue:)
				)
				(proc0_1)
			)
		)
	)
)

(instance charScript3 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide: stopUpd:)
				(if caller
					(caller cue:)
				)
				(proc0_1)
			)
		)
	)
)

(instance dummyEgo of Ego ; UNUSED
	(properties)
)

(instance hoyle3 of Game
	(properties)

	(method (init &tmp temp0)
		(= global183 319)
		(= global184 199)
		(= gHowFast 2)
		(proc0_4)
		(localproc_1)
		(= gEatMice (= gSpeed 0))
		(= gSystemWindow ColorBorderWindow)
		(gSystemWindow color: 0 back: 53)
		(= gDoAbsCode doAbsCode)
		(= gUseSortedFeatures 1)
		(User alterEgo: (= gEgo Ego))
		(= gLooperDir8 looperDir8)
		((= gTheInputList theInputList) add:)
		((= gAbsoluteCast absoluteCast) add:)
		((= gKeyDownHandler hoyle3keyDown) add:)
		((= gMouseDownHandler hoyle3MouseDown) add:)
		((= gDirectionHandler hoyle3Direction) add:)
		((= gTheKeyMouseList theKeyMouseList) add:)
		(= gMouseCursor mouseCursor)
		(mouseCursor x: 319)
		(mouseCursor y: 199)
		(version doit:)
		(= gVersion @global541)
		((= gGame_opt game_opt) doit: 2)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(KeyMouse init: setList: gTheKeyMouseList)
		(super init:)
		DItem
		(Load rsVIEW 700)
		(Load rsVIEW 701)
		(Load rsCURSOR 29)
		(ScriptID 700 1) ; hoyle3GameControls
		GameControls
		IconBar
		(Load rsVIEW 997)
		(Lock rsVIEW 997)
		(Characters add:)
		(theTalker add:)
		(localproc_0)
		(proc700_0)
		(proc0_3)
		(Characters
			add: (= gChar1 char1) (= gChar2 char2) (= gChar3 char3)
		)
		(gChar1 face: face1 charScript: charScript1)
		(gChar2 face: face2 charScript: charScript2)
		(gChar3 face: face3 charScript: charScript3)
		(= gSong song)
		(= gSound sound)
		(= gSound2 sound2)
		(gSong owner: gGame init:)
		(gSong setPri: 1)
		(sound setPri: 2)
		(sound2 setPri: 3)
		(Format @gSysLogPath 0 1)
		(gTheIconBar disable:)
		(self newRoom: 900) ; sierra
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event globalize:)
		(mouseCursor x: (event x:) y: (event y:))
	)

	(method (quitGame)
		(if (Print 0 2 #button {YES} 1 #button {NO} 0) ; "Quit HOYLE 3?"
			(super quitGame:)
		)
	)

	(method (newRoom)
		(gAbsoluteCast release:)
		(gGame setCursor: 20 1)
		(proc0_5)
		(super newRoom: &rest)
	)

	(method (startRoom param1)
		(gRegions addToFront: (= gCurRoom (ScriptID param1)))
		(gCurRoom init:)
		(if global538
			(= global538 0)
			(gGame setCursor: gNormalCursor 1 (mouseCursor x:) (mouseCursor y:))
		else
			(gGame setCursor: gNormalCursor 1)
		)
	)
)

(instance hoyle3MouseDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(gCurRoom handleEvent: event)
		)
	)
)

(instance hoyle3keyDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(return)
			)
			(gCurRoom handleEvent: event)
		)
	)
)

(instance hoyle3Direction of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
	)
)

(instance theKeyMouseList of Set
	(properties)
)

(instance mouseCursor of Actor
	(properties)
)

(instance theInputList of EventHandler
	(properties)
)

(instance gameControlIcon of IconI
	(properties
		view 700
		loop 0
		cel 0
		cursor 999
		signal 451
		helpStr {This icon is for the Game Control Panel. It will let you Select a new game , Quit, Replay the current game, Set text speed, Adjust the Volume, and tell you who made Hoyle 3 what it is today.}
		highlightColor -1
	)

	(method (highlight)
		(return 1)
	)

	(method (select &tmp temp0)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(gGameControls show:)
		)
		(return temp0)
	)
)

(instance optionsIcon of IconI
	(properties
		view 700
		loop 1
		cel 0
		cursor 999
		signal 195
		helpStr {This icon is for setting options of the individual games.}
		highlightColor -1
	)

	(method (select &tmp temp0 temp1 temp2)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(switch gCurRoomNum
				(100 ; domino1
					(= temp2 110)
				)
				(200 ; checkers
					(= temp2 210)
				)
				(300 ; backgam
					(= temp2 310)
				)
				(400 ; pachisi
					(= temp2 410)
				)
				(500 ; yacht
					(= temp2 510)
				)
				(600 ; snakes
					(= temp2 653)
				)
				(else
					(= temp2 0)
				)
			)
			(if temp2
				(gGameControls hide:)
				(= temp1 (gSystemWindow back:))
				(gSystemWindow back: 53)
				((ScriptID temp2 0) doit:)
				(gSystemWindow back: temp1)
			else
				(Print 0 3) ; "Options are displayed for each game after entering the game."
			)
		)
		(return temp0)
	)
)

(instance scoreIcon of IconI
	(properties
		view 700
		loop 3
		cel 0
		cursor 999
		signal 195
		helpStr {This icon reports the current score of the current game.}
		highlightColor -1
	)

	(method (select &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100 ; domino1
					(proc100_2)
				)
				(200 ; checkers
					(proc200_2)
				)
				(300 ; backgam
					(proc303_2)
				)
				(400 ; pachisi
					(proc400_2)
				)
				(500 ; yacht
					(proc500_2)
				)
				(600 ; snakes
					(proc600_2)
				)
				(else
					(Print 0 4) ; "You must be in a game to show the score."
				)
			)
			(SetPort temp21)
		)
		(return temp0)
	)
)

(instance rulesIcon of IconI
	(properties
		view 700
		loop 4
		cel 0
		cursor 999
		signal 195
		helpStr {This icon has the rules for each game. To read the rules of a particular game, go to that game first and then choose this Icon.}
		highlightColor -1
	)

	(method (select &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100 ; domino1
					((ScriptID 111 0) doit:) ; showRules
				)
				(200 ; checkers
					((ScriptID 211 0) doit:) ; showRules
				)
				(300 ; backgam
					((ScriptID 311 0) doit:) ; showRules
				)
				(400 ; pachisi
					((ScriptID 411 0) doit:) ; showRules
				)
				(500 ; yacht
					((ScriptID 511 0) doit:) ; showRules
				)
				(600 ; snakes
					((ScriptID 611 0) doit:) ; showRules
				)
				(else
					(Print 0 5) ; "You must be in a game to read Rules."
				)
			)
			(SetPort temp21)
		)
		(return temp0)
	)
)

(instance helpIcon of IconI
	(properties
		view 700
		loop 5
		cel 0
		cursor 29
		message 6
		signal 131
		helpStr {This icon is the help icon. By choosing this icon and pointing the special cursor on another icon, you will get a description of what the icon is for.}
		highlightColor -1
	)
)

(instance game_opt of File
	(properties
		name {game.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10] temp30 temp31 temp32 temp33)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%3d%3d%2d%2d%2d%2d%s%s%s%s"
								@temp0
								0
								6
								global199
								(DoSound sndMASTER_VOLUME)
								(StrLen @global472)
								(StrLen @global479)
								(StrLen @global486)
								(StrLen @global493)
								@global472
								@global479
								@global486
								@global493
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global199 (ReadNumber (self readString: @temp20 4)))
				(gGame masterVolume: (ReadNumber (self readString: @temp20 4)))
				(= temp30 (ReadNumber (self readString: @temp20 3)))
				(= temp31 (ReadNumber (self readString: @temp20 3)))
				(= temp32 (ReadNumber (self readString: @temp20 3)))
				(= temp33 (ReadNumber (self readString: @temp20 3)))
				(self readString: @temp20 (+ temp30 1))
				(StrCpy @global472 @temp20)
				(self readString: @temp20 (+ temp31 1))
				(StrCpy @global479 @temp20)
				(self readString: @temp20 (+ temp32 1))
				(StrCpy @global486 @temp20)
				(self readString: @temp20 (+ temp33 1))
				(StrCpy @global493 @temp20)
				(self close:)
				(return 0)
			)
			(else
				(= global199 6)
				(gGame masterVolume: 12)
				(Format @global150 0 1)
				(Format @global157 0 1)
				(Format @global164 0 1)
				(Format @global171 0 1)
				(Format @global472 0 1)
				(Format @global479 0 1)
				(Format @global486 0 1)
				(Format @global493 0 1)
				(return 0)
			)
		)
	)
)

(class TrackingView of KMView
	(properties
		associatedObj 0
		trackingCode 0
		prevSignal 0
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(self flash:)
					(= temp0 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(= temp0 (self track:))
				)
			)
		)
		(return temp0)
	)

	(method (track &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(self prevSignal: signal startUpd:)
		(= cel 1)
		((= temp2 (List new:)) add: self)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp3 0)) (< temp3 (associatedObj size:)) ((++ temp3))
					(temp2 add: (associatedObj at: temp3))
				)
			else
				(temp2 add: associatedObj)
			)
		)
		(Animate (temp2 elements:) 0)
		(if trackingCode
			(trackingCode init: self)
		)
		(while (!= evMOUSERELEASE ((= temp1 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= temp4 (self onMe: temp1))
			(if (!= cel temp4)
				(= cel temp4)
				(if (== (temp2 size:) 1)
					(Animate (temp2 elements:) 0)
				)
			)
			(if (> (temp2 size:) 1)
				(Animate (temp2 elements:) 0)
			)
			(if trackingCode
				(trackingCode doit: self)
			)
			(temp1 dispose:)
		)
		(if (== cel 1)
			(= temp0 cel)
		)
		(= cel 0)
		(Animate (temp2 elements:) 0)
		(if trackingCode
			(trackingCode dispose: self)
		)
		(temp2 release: dispose:)
		(temp1 dispose:)
		(self signal: (& prevSignal $fffb) stopUpd:)
		(return temp0)
	)

	(method (flash &tmp temp0 temp1)
		(= cel 1)
		(self startUpd:)
		((= temp0 (List new:)) add: self)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp1 0)) (< temp1 (associatedObj size:)) ((++ temp1))
					(temp0 add: (associatedObj at: temp1))
				)
			else
				(temp0 add: associatedObj)
			)
		)
		(Animate (temp0 elements:) 1)
		(Wait 1)
		(Wait 10)
		(= cel 0)
		(Animate (temp0 elements:) 1)
		(temp0 release: dispose:)
		(self stopUpd:)
	)
)

(class DragableActor of KMActor
	(properties
		hiView -1
		hiLoop -1
		hiCel -1
		prevX 0
		prevY 0
		prevView 0
		prevLoop 0
		prevCel 0
		prevSignal 0
		draggingCode 0
		dragable 1
		associatedObj 0
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(event claimed: 1)
					(= temp0 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(= temp0 1)
				)
			)
		)
		(return temp0)
	)

	(method (processEvent param1)
		(cond
			((& (param1 type:) $0001)
				(return (self track:))
			)
			((proc0_2 param1)
				(return (self flash:))
			)
		)
		(return 0)
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp5 (List new:))
		(if global181
			(global181 dim:)
			(temp5 add: global181)
			(Animate (temp5 elements:) 0)
			(temp5 release:)
		)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp8 0)) (< temp8 (associatedObj size:)) ((++ temp8))
					(temp5 add: (associatedObj at: temp8))
				)
			else
				(temp5 add: associatedObj)
			)
		)
		(= temp6 priority)
		(self setPri: 15)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self saveData: hilite:)
		(= global181 self)
		(temp5 add: self)
		(if (gAbsoluteCast size:)
			(for ((= temp8 0)) (< temp8 (gAbsoluteCast size:)) ((++ temp8))
				(temp5 add: (gAbsoluteCast at: temp8))
			)
		)
		(self prevSignal: signal)
		(Animate (temp5 elements:) 0)
		(if draggingCode
			(draggingCode init: self)
		)
		(= temp7 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(cond
				(dragable
					(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1))
				)
				(
					(and
						(<= nsLeft gMouseX (- nsRight 1))
						(<= nsTop gMouseY (- nsBottom 1))
					)
					(= temp7 1)
					(self hilite: 1)
				)
				(else
					(= temp7 0)
					(self dim: 1)
				)
			)
			(if draggingCode
				(draggingCode doit: self)
			)
			(Animate (temp5 elements:) 0)
			(temp2 dispose:)
		)
		(if dragable
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
		)
		(if draggingCode
			(draggingCode dispose: self)
		)
		(temp2 dispose:)
		(self setPri: temp6)
		(self dim:)
		(temp5 release: dispose:)
		(return temp7)
	)

	(method (flash)
		(if (and global181 (!= global181 self))
			(global181 dim:)
		)
		(if (== global181 self)
			(self dim:)
			(= global181 0)
		else
			(self hilite:)
			(= global181 self)
		)
		(proc0_1)
		(return 2)
	)

	(method (dim param1)
		(if (and (== hiView -1) (== hiLoop -1) (== hiCel -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and param1 (== hiView view) (== hiLoop loop) (== hiCel cel))
			)
			(self
				view: prevView
				loop: prevLoop
				cel: prevCel
				signal: prevSignal
				forceUpd:
			)
		)
	)

	(method (hilite param1)
		(if (and (== hiView -1) (== hiLoop -1) (== hiCel -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and
					param1
					(or (!= hiView view) (!= hiLoop loop) (!= hiCel cel))
				)
			)
			(self saveData:)
			(if (!= hiView -1)
				(self view: hiView)
			)
			(if (!= hiLoop -1)
				(self loop: hiLoop)
			)
			(if (!= hiCel -1)
				(self cel: hiCel)
			)
			(self startUpd:)
		)
	)

	(method (saveData)
		(= prevX x)
		(= prevY y)
		(= prevView view)
		(= prevLoop loop)
		(= prevCel cel)
		(= prevSignal signal)
	)
)

(instance looperDir8 of Code
	(properties)

	(method (doit param1 param2)
		(param1
			loop:
				(cond
					((<= 70 param2 110) 0)
					((<= 250 param2 290) 1)
					((<= 160 param2 200) 2)
					((<= 110 param2 160) 4)
					((<= 20 param2 70) 6)
					((<= 200 param2 250) 5)
					((<= 290 param2 340) 7)
					(else 3)
				)
		)
	)
)

(instance absoluteCast of Set
	(properties)
)

(instance song of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance sound of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance sound2 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
	)
)

(instance doAbsCode of Code
	(properties)

	(method (doit)
		(proc0_6)
	)
)

(instance version of File
	(properties)

	(method (doit)
		(if (self open: 1)
			(self readString: @global541 6 close:)
		)
	)
)

