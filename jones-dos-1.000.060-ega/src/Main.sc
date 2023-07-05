;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use InvisibleWindow)
(use BubbleWindow)
(use Interface)
(use KeyMouse)
(use Sound)
(use Game)
(use User)
(use Menu)
(use System)

(public
	jones 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	bubbleWindow 4
	invisibleWindow 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
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
	gVersion = {version}
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
	global59
	; 60
	global60 = 40
	global61 = 189
	global62 = 319
	global63
	global64 = 4
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
	global73
	global74
	; 75
	global75
	global76 = 3
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
	global100
	global101
	global102
	global103
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
	global130
	global131
	global132
	global133
	global134
	; 135
	global135
	global136
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145
	global146
	global147
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
	gPlaces
	global302
	gTheWalker
	global304
	; 305
	gCalc
	global306
	global307 = 100
	global308 = 100
	global309 = 100
	; 310
	global310 = 100
	global311 = 100
	global312 = 100
	global313 = 100
	global314 = 100
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
	global365
	global366
	global367
	global368
	global369
	; 370
	global370
	gBubbleWindow
	global372 = 1
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
	global401 = -1
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
	gTimeKeep
	global418
	global419
	; 420
	global420
	global421
	global422
	global423
	global424
	; 425
	gBoughtItem
	global426 = 5
	global427 = 1
	global428
	global429
	; 430
	global430
	global431
	gMainKeyMouseList
	global433
	gItems
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
	global447 = 1
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
	global475 = 20
	gASoundEffect
	gASong
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
	global501 = -1
	global502
	global503
	global504
	; 505
	global505
	global506
	global507
	global508
	global509 = 1
	; 510
	global510 = 1
	global511
	global512 = 7
	global513
	global514
	; 515
	global515
	global516
	gDoor
	global518
	global519
	; 520
	global520 = 12
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
	gNotice
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
	; 750
	global750 = -23040
)

(procedure (proc0_1)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_2 param1 param2 &tmp temp0 temp1)
	(-= argc 2)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= temp1 [param2 temp0])
		(if param1
			(Load param1 temp1)
		)
	)
)

(procedure (proc0_3 param1 &tmp temp0 temp1)
	(if (> param1 0)
		(for ((= temp0 0)) (< temp0 (/ param1 6)) ((++ temp0))
			(Wait 6)
			(= temp1 (Event new:))
			(MenuBar handleEvent: temp1)
			(if
				(or
					(and (== (temp1 type:) evMOUSERELEASE) (>= (temp1 y:) 10))
					(and (== (temp1 type:) evKEYBOARD) (== (temp1 message:) KEY_RETURN))
				)
				(temp1 dispose:)
				(break)
			)
			(temp1 dispose:)
			(if gQuit
				(break)
			)
		)
	)
)

(procedure (proc0_6 param1)
	(return
		(or (== global407 param1) (== global409 param1) (== global410 param1))
	)
)

(procedure (proc0_7)
	(SetMenu 513 112 0)
)

(procedure (proc0_8)
	(SetMenu 513 112 1)
)

(procedure (proc0_9 param1 param2 param3 &tmp temp0 temp1 [temp2 2])
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(= temp1 (param1 at: temp0))
		(if (& (temp1 state:) $0001)
			(param2 add: temp1)
			(temp1
				keyMouseX:
					(+
						(/ (+ (temp1 nsLeft:) (temp1 nsRight:)) 2)
						(if (>= argc 4)
							((param1 window:) left:)
						else
							(param1 nsLeft:)
						)
					)
				keyMouseY:
					(+
						(/ (+ (temp1 nsTop:) (temp1 nsBottom:)) 2)
						(if (>= argc 4)
							((param1 window:) top:)
						else
							(param1 nsTop:)
						)
					)
			)
		)
	)
	(if global447
		(KeyMouse
			setCursor:
				(if (and (>= argc 3) param3)
					param3
				else
					(param2 at: 0)
				)
		)
	)
	(KeyMouse
		curItem:
			(if (and (>= argc 3) param3)
				param3
			else
				(param2 at: 0)
			)
	)
)

(procedure (proc0_10 param1 &tmp temp0)
	(= temp0 (+ param1 (global302 cash:)))
	(cond
		((< param1 0)
			(if (and (global302 cashHi:) (< temp0 0))
				(global302 cashHi: (- (global302 cashHi:) 1))
				(+= temp0 32767)
			)
		)
		((u>= temp0 32767)
			(global302 cashHi: (+ (global302 cashHi:) 1))
			(-= temp0 32767)
		)
	)
	(global302 cash: temp0)
	(global302
		monStat:
			(if (global302 lqAssHi:)
				100
			else
				(/ (global302 lqAss:) 100)
			)
	)
	(if (> (global302 monStat:) 100)
		(global302 monStat: 100)
	)
	(if (< (global302 monStat:) 0)
		(global302 monStat: 0)
	)
)

(procedure (proc0_11 param1 &tmp temp0 temp1)
	(= temp1 (if argc param1 else global302))
	(return
		(cond
			((temp1 cashHi:) 32767)
			((< (temp1 cash:) 0) 0)
			(else
				(temp1 cash:)
			)
		)
	)
)

(procedure (proc0_12 param1 param2 param3 param4)
	(= global455 (+ param2 param4))
	(= global454 0)
	(cond
		((or (< param2 0) (< param4 0))
			(if (and (< global455 0) (or param1 param3))
				(+= global455 -32768)
				(= global454 -1)
			)
		)
		((u>= global455 32767)
			(= global454 1)
			(+= global455 -32768)
		)
	)
	(+= global454 (+ param1 param3))
)

(procedure (proc0_13 param1 param2 &tmp temp0 temp1)
	(= temp1 (if (< argc 2) global302 else param2))
	(if (> (= temp0 (+ (temp1 hapStat:) param1)) 100)
		(= temp0 100)
	)
	(if (< temp0 0)
		(= temp0 0)
	)
	(temp1 hapStat: temp0)
)

(procedure (proc0_14 &tmp temp0)
	(if
		(and
			global427
			(not
				[global690
					(= temp0
						(+ (* ((ScriptID 1 2) indexOf: global302) 13) global400) ; players
					)
				]
			)
		)
		(return (= [global690 temp0] 1))
	)
	(return 0)
)

(procedure (proc0_15 param1 param2 &tmp temp0)
	(if (and param1 (param1 isMemberOf: Dialog))
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if
				(and
					((param1 at: temp0) isKindOf: ErasableDIcon)
					(& ((param1 at: temp0) state:) $0001)
				)
				((param1 at: temp0) param2:)
			)
		)
	)
)

(procedure (proc0_16 param1)
	(DrawCel 0 0 param1 69 45 1)
)

(procedure (proc0_17 param1)
	(= global514 global513)
	(switch param1
		(1
			(= global512 (if global535 121 else 10))
			(= global511 (if global535 27 else 0))
			(= global513 6)
		)
		(2
			(= global512 (if global535 119 else 11))
			(= global511 (if global535 26 else 1))
			(= global513 7)
		)
		(3
			(= global512 (if global535 136 else 15))
			(= global511 (if global535 28 else 8))
			(= global513 8)
		)
		(else
			(= global512 (if global535 128 else 14))
			(= global511 (if global535 63 else 4))
			(= global513 5)
		)
	)
)

(instance jones of Game
	(properties)

	(method (init &tmp temp0)
		(DoSound sndMASTER_VOLUME global520)
		(if (<= (DoSound sndGET_POLYPHONY) 3)
			(aSong number: 100)
			(aSoundEffect number: 100)
		)
		(= global535 (if (== (Graph grGET_COLOURS) 16) 0 else 1))
		(= global552 (if (== (Graph grGET_COLOURS) 2) 1 else 0))
		(proc0_17 0)
		(= global427 1)
		(= gVersion 0)
		(if (= global538 (FileIO fiOPEN {version} 1))
			(= gVersion (FileIO fiREAD_STRING @global539 10 global538))
			(FileIO fiCLOSE global538)
		)
		(= global59 invisibleWindow)
		(= gBubbleWindow bubbleWindow)
		(User controls: 1)
		(gGame setSpeed: 0)
		(= global80 (GetPort))
		(super init:)
		(SetCursor gTheCursor 1 319 199)
		(= gASong aSong)
		((= gASoundEffect aSoundEffect) owner: self init:)
		(if (GameIsRestarting)
			(UnLoad 132 7)
			(UnLoad 132 8)
			(UnLoad 132 31)
			(UnLoad 132 6)
			(UnLoad 132 23)
			(gASong playBed: 10 -1)
			(self newRoom: 1)
		else
			(self newRoom: 764) ; noticeRoom
		)
	)

	(method (doit)
		(super doit:)
		(if (and global528 (not global502))
			(= global528 0)
			(gGame restart:)
		)
		(if (and global529 (not global502))
			(= global529 0)
			(gGame restore:)
		)
		(= global58 0)
		(if global533
			(gCurRoom init:)
		)
	)

	(method (replay)
		(= global59 invisibleWindow)
		(super replay:)
	)
)

(instance bubbleWindow of BubbleWindow
	(properties)
)

(instance invisibleWindow of InvisibleWindow
	(properties
		back -1
	)
)

(instance aSong of Sound
	(properties
		number 6
		owner -1
	)

	(method (cue param1 param2 param3)
		(if soundOn
			(self pause: 0)
		)
		(if (and (>= argc 2) param2)
			(if (== param2 10)
				(UnLoad 132 6)
			)
			(self loop: param3 play: param2)
		)
	)

	(method (toggle)
		(if (= soundOn (- 1 soundOn))
			(SetMenu 776 110 {Turn Music Off})
			(= vol 127)
			(self changeState:)
			(Print 0 0 #time global426) ; "Music is ON"
		else
			(SetMenu 776 110 {Turn Music On})
			(= vol 0)
			(self changeState:)
			(Print 0 1 #time global426) ; "Music is OFF"
		)
	)
)

(instance aSoundEffect of Sound
	(properties
		number 6
		priority 1
		owner -1
	)

	(method (cue param1 param2 param3)
		(if soundOn
			(self pause: 0)
		)
		(if (and (>= argc 2) param2)
			(self loop: param3 play: param2)
		)
	)

	(method (toggle)
		(if (= soundOn (- 1 soundOn))
			(SetMenu 777 110 {Turn Sound Effects Off})
			(= vol 127)
			(self changeState:)
			(Print 0 2 #time global426) ; "Sound Effects are ON"
		else
			(SetMenu 777 110 {Turn Sound Effects On})
			(= vol 0)
			(self changeState:)
			(Print 0 3 #time global426) ; "Sound Effects are OFF"
		)
	)
)

