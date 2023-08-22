;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Blk)
(use LoadMany)
(use Rev)
(use Wander)
(use Follow)
(use Window)
(use Avoid)
(use Sound)
(use Save)
(use Motion)
(use File)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	MG 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	RedrawCast 5
	clr 6
	IsItemAt 7
	PutItem 8
	NearControl 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
	LookAt 21
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
	global59
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
	global73
	global74
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
	global100
	global101
	global102
	global103 = 1
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
	gGlobalMGSound
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
	global193 = 29
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
	global401
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
)

(procedure (NormalEgo param1 param2)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
		)
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Walk
		setStep: 3 2
		looper: 0
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		setAvoider: 0
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(= global132 1)
	(gEgo setMotion: 0)
	(= global102 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 0)
	(= global132 0)
	(= global102 0)
)

(procedure (HaveMem param1) ; UNUSED
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (clr)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (IsItemAt param1 param2) ; UNUSED
	(return
		(== ((gInventory at: param1) owner:) (if (== argc 1) gCurRoomNum else param2))
	)
)

(procedure (PutItem param1 param2) ; UNUSED
	((gInventory at: param1) owner: (if (== argc 1) gCurRoomNum else param2))
)

(procedure (NearControl param1 param2) ; UNUSED
	(if (< argc 2)
		(= param2 5)
	)
	(OnControl
		(- (param1 x:) param2)
		(- (param1 y:) param2)
		(+ (param1 x:) param2)
		(+ (param1 y:) param2)
	)
)

(procedure (proc0_10 param1 param2 param3 param4)
	(= global108 0)
	(= global720 global126)
	(box init:)
	(if global111
		(boxItem init:)
		(if (== global125 0)
			(= global125 -1)
		)
		(if (<= global111 47)
			(egoItem
				setPri: global125
				init:
				posn:
					(if global195
						global195
					else
						(gEgo x:)
					)
					(if global196
						global196
					else
						(gEgo y:)
					)
			)
			(= global195 0)
			(= global196 0)
			(if (< gCurRoomNum 36)
				(egoItem setMotion: Follow gEgo 30)
				(egoItem setScript: followEgo)
				(= global128 1)
			else
				(egoItem setScript: 0)
				(= global115 param3)
				(= global116 param4)
			)
		)
	)
	(if (= global600 [global630 gCurRoomNum])
		(= global109 param1)
		(= global110 param2)
		(roomItem setPri: -1 init:)
		(= global124 (roomItem priority:))
	)
)

(procedure (proc0_12)
	(if (<= global111 47)
		(egoItem dispose:)
	)
	(if (and (!= global111 52) (!= global111 53))
		(gGame changeScore: 1)
	)
	(= global111 0)
	(if (< gScore gPossibleScore)
		(box show:)
	)
)

(procedure (proc0_13)
	(while (>= (= global601 [global604 (= global602 (Random 1 global603))]) 36)
		(contif
			(or
				(<= global600 47)
				(and (== global601 44) (== global600 54))
				(and (== global601 36) (== global600 51))
				(and (== global601 43) (== global600 49))
				(and (== global601 40) (== global600 58))
				(if (== global601 37)
					(contif (== global600 53))
					(== global600 52)
				)
			)
		)
		(break)
	)
	(= [global630 global601] global600)
	(while (< global602 global603)
		(= [global604 global602] [global604 (+ global602 1)])
		(++ global602)
	)
	(-- global603)
)

(procedure (proc0_14 param1 param2)
	(HandsOff)
	(box dispose:)
	(= global129 param1)
	(= global130 param2)
	(gCurRoom setScript: endGameScript)
)

(procedure (proc0_15 param1 param2) ; UNUSED
	(param1 loop: param2 changeState:)
)

(procedure (proc0_16 param1 param2 param3 param4 param5)
	(if
		(and
			(== (param1 type:) 1)
			(< param2 (param1 x:) param4)
			(< param3 (param1 y:) param5)
		)
		(param1 claimed: 1)
	)
)

(procedure (proc0_17)
	(box hide:)
)

(procedure (proc0_11 param1)
	(if (== global111 param1)
		(if (<= global111 47)
			(egoItem hide:)
			(return egoItem)
		else
			(return 1)
		)
	else
		(return 0)
	)
)

(procedure (proc0_19 param1 param2)
	(if (MousedOn param1 param2 3)
		(param2 claimed: 1)
	)
)

(procedure (proc0_18)
	(boxItem dispose:)
	(if (not (OneOf gCurRoomNum 23 27 13 37))
		(gotItSound loop: 1 play:)
	)
)

(procedure (LookAt param1 &tmp temp0)
	(= temp0 (GetAngle (gEgo x:) (gEgo y:) (param1 x:) (param1 y:)))
	(gEgo heading: temp0)
	(DirLoop gEgo temp0)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_20)
	(for ((= global601 1)) (<= global601 44) ((++ global601))
		(= [global630 global601] 0)
		(= [global675 global601] 0)
	)
	(= gScore 0)
	(SL doit:)
	(= global200 0)
	(= global112 0)
	(= global113 0)
	(= global208 0)
	(= [global604 1] 2)
	(= [global604 2] 6)
	(= [global604 3] 8)
	(= [global604 4] 11)
	(= [global604 5] 14)
	(= [global604 6] 16)
	(= [global604 7] 17)
	(= [global604 8] 19)
	(= [global604 9] 20)
	(= [global604 10] 22)
	(= [global604 11] 28)
	(= [global604 12] 30)
	(= [global604 13] 36)
	(= [global604 14] 37)
	(= [global604 15] 39)
	(= [global604 16] 40)
	(= [global604 17] 41)
	(= [global604 18] 43)
	(= [global604 19] 44)
	(= [global604 20] 29)
	(= [global604 21] 35)
	(= [global604 22] 34)
	(= global603 22)
	(= global111 0)
	(= [global630 [global604 global603]] 57)
	(-- global603)
	(for ((= global600 41)) (<= global600 60) ((++ global600))
		(if (!= global600 57)
			(proc0_13)
		)
	)
	(= [global604 3] 4)
	(= [global604 4] 10)
	(= [global604 5] 24)
	(= [global604 6] 25)
	(= [global604 7] 26)
	(= global603 7)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 0 gScore gPossibleScore 0 1 {Mixed-Up Mother Goose} 0 1) ; "Score: %d of %d %7s%s%1s"
	)
)

(instance ego of Ego
	(properties)
)

(instance globalMGSound of Sound
	(properties
		number 1
		priority 5
	)
)

(instance gotItSound of Sound
	(properties
		number 2
		priority 10
	)
)

(instance version of File
	(properties)
)

(instance MG of Game
	(properties)

	(method (init)
		(= global59 Window)
		(= global59 (SysWindow new:))
		(global59 color: 1)
		(= global100 0)
		(= global76 0)
		(super init:)
		(= gVersion {x.yyy})
		(if (!= (version open: 1) 0)
			(version read: gVersion 5 close:)
		)
		(= global105 (Graph grGET_COLOURS))
		(= global126 35)
		(= global127 75)
		((= gGlobalMGSound globalMGSound) init: owner: self)
		(= gEgo ego)
		(User alterEgo: gEgo blocks: 0 canControl: 0 x: -1 y: 150)
		(= gPossibleScore 18)
		(TheMenuBar init:)
		(SL code: statusCode)
		(HandsOn)
		(= gUserFont 1)
		(proc0_20)
		(= global121 4)
		(= global120 6)
		(= global122 3)
		(if (GameIsRestarting)
			(= global133 1)
			(self newRoom: 99) ; speedTest
		else
			(clr)
			(self newRoom: 99) ; speedTest
		)
	)

	(method (replay)
		(SetMenu 1026 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(super replay:)
	)

	(method (doit &tmp temp0)
		(= temp0 (HaveMouse))
		(if (not global106)
			(cond
				(global103
					(= global104 69)
				)
				((== (User controls:) 0)
					(= temp0 1)
					(= global104 gWaitCursor)
				)
				(else
					(= global104 gNormalCursor)
				)
			)
			(if (!= gTheCursor global104)
				(self setCursor: global104 temp0)
			)
		)
		(if (and (IsObject roomItem) (roomItem view:))
			(cond
				((< (gEgo distanceTo: roomItem) global720)
					(= global720 0)
					(if
						(and
							(= global600 global111)
							(<= global600 47)
							(>= gCurRoomNum 36)
						)
						(egoItem setScript: relocateScript)
						(= global600 0)
					)
					(cond
						((<= (= global111 (roomItem view:)) 47)
							(egoItem init: posn: (roomItem x:) (roomItem y:))
						)
						(global600
							(egoItem dispose:)
						)
					)
					(boxItem init:)
					(if (= [global630 (= global601 gCurRoomNum)] global600)
						(roomItem init:)
					else
						(roomItem view: 0)
						(roomItem dispose:)
					)
					(gotItSound loop: 1 play:)
					(if (<= global111 43)
						(gCurRoom setScript: tS)
					)
				)
				((> (gEgo distanceTo: roomItem) global127)
					(= global720 global126)
				)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (IsObject roomItem)
			(roomItem view: 0 dispose:)
		)
		(clr)
		(= global76 0)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum)
		(LoadMany 0 985 972 971 970 969 964 982 956)
		(if gDebugOn
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				global100
				(Print 0 2 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(super startRoom: roomNum)
		(= global76 0)
		(Load rsSOUND 2)
		(LoadMany rsSCRIPT 985 972 971 970 969 964 982 956)
		(if (gCast contains: gEgo)
			(gEgo setAvoider: 0)
		)
	)

	(method (handleEvent event &tmp [temp0 82] temp82 temp83 temp84 temp85 temp86 temp87 temp88 temp89 temp90 [temp91 50])
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(switch (event type:)
			(evMOUSEBUTTON
				(= temp87 (event x:))
				(= temp88 (event y:))
				(if (& (= temp89 (event modifiers:)) emSHIFT)
					(cond
						((proc0_19 egoItem event)
							(if
								(and
									(or
										(== global111 43)
										(== global111 42)
										(== global111 41)
									)
									(== global102 0)
									(== global207 0)
								)
								(event claimed: 1)
								(LookAt egoItem)
								(gCurRoom setScript: tS)
							)
						)
						(
							(and
								(proc0_19 roomItem event)
								(or
									(== (roomItem view:) 43)
									(== (roomItem view:) 42)
									(== (roomItem view:) 41)
								)
								(== global102 0)
								(== global207 0)
							)
							(event claimed: 1)
							(LookAt roomItem)
							(roomItem setScript: 0 setMotion: 0)
							(gCurRoom setScript: followTalk)
						)
					)
				)
				(if global100
					(cond
						((== temp89 $000a) ; emALT | emLEFT_SHIFT
							(event claimed: 1)
							((User alterEgo:)
								setMotion: Unknown_Class_38 temp87 temp88
							)
						)
						((& temp89 emSHIFT)
							(event claimed: 1)
							(= temp83
								(Print
									(Format @temp91 0 3 temp87 (- temp88 10)) ; "%d/%d"
									#at
									(- temp87 20)
									(+ temp88 20)
									#font
									999
									#dispose
								)
							)
							(while (!= evMOUSERELEASE ((= temp84 (Event new:)) type:))
								(temp84 dispose:)
							)
							(temp83 dispose:)
							(temp84 dispose:)
						)
						((& temp89 emCTRL)
							(event claimed: 1)
							(while (!= evMOUSERELEASE ((= temp84 (Event new:)) type:))
								((User alterEgo:)
									posn: (temp84 x:) (- (temp84 y:) 10)
									setMotion: 0
								)
								(Animate (gCast elements:) 0)
								(temp84 dispose:)
							)
							(temp84 dispose:)
						)
						((& temp89 emALT)
							(event claimed: 1)
							((User alterEgo:) showSelf:)
						)
					)
				)
			)
			(evKEYBOARD
				(switch (event message:)
					(JOY_RIGHT
						(if global100
							(= global113 1)
							(= global112 1)
							(= global200 2)
							(gGame changeScore: (- 17 gScore))
						)
					)
					(JOY_DOWNRIGHT
						(if global100
							(for
								((= global601 1))
								(<= global601 44)
								((++ global601))
								
								(if (= global600 [global630 global601])
									(Printf 0 4 global600 global601) ; "item %d is in room %d"
								)
							)
							(= temp86 (Joystick 12 -1))
							(Printf 0 5 temp86) ; "joyRepeat = %d"
						)
					)
					(KEY_ALT_s
						(if global100
							(for
								((= temp86 (gCast first:)))
								temp86
								((= temp86 (gCast next: temp86)))
								
								(= temp82 (NodeValue temp86))
								(Print
									(Format ; "view: %d (x,y):%d,%d STOPUPD=%d IGNRACT=%d ILLBITS=$%x"
										@temp0
										0
										6
										(temp82 view:)
										(temp82 x:)
										(temp82 y:)
										(/ (& (temp82 signal:) $0004) 4)
										(/ (& (temp82 signal:) $4000) 16384)
										(if
											(or
												(== (temp82 superClass:) Actor)
												(== (temp82 superClass:) Ego)
											)
											(temp82 illegalBits:)
										else
											-1
										)
									)
									#window
									SysWindow
									#title
									(temp82 name:)
									#icon
									(temp82 view:)
									(temp82 loop:)
									(temp82 cel:)
								)
							)
						)
					)
					(KEY_CAPITAL
						(if global100
							(User canControl: 1)
							(if
								(and
									(!= (= temp86 (GetNumber {Teleport to:})) 1)
									(!= temp86 900)
									(!= temp86 155)
								)
								(= global103 0)
								(= global104 gNormalCursor)
								(gGame setCursor: gNormalCursor (HaveMouse))
							)
							(gCurRoom newRoom: temp86)
						)
					)
					(KEY_ALT_p
						(if global100
							(Show 2)
							(event claimed: 1)
						)
					)
					(KEY_ALT_v
						(if global100
							(Show 1)
							(event claimed: 1)
						)
					)
					(KEY_ALT_c
						(if global100
							(Show 4)
							(event claimed: 1)
						)
					)
					(KEY_ALT_i
						(if global100
							(event claimed: 1)
							(User canInput: 1)
						)
					)
					(KEY_ALT_z
						(if global100
							(event claimed: 1)
							(= gQuit 1)
						)
					)
				)
			)
		)
	)

	(method (wordFail param1 &tmp [temp0 100])
		(Print (Format @temp0 0 7 param1)) ; "Try another word. Apparently, "%s" is not in the Mother Goose dictionary."
	)

	(method (syntaxFail)
		(Print 0 8) ; "Mother Goose does not understand. Please try again."
	)

	(method (pragmaFail &tmp [temp0 100])
		(Print 0 9) ; "Pardon me. Mother Goose does not understand your sentence. Please try something else."
	)
)

(instance relocateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_13)
				(egoItem
					illegalBits: -32768
					ignoreActors: 0
					setMotion: MoveTo global115 global116
				)
				(if global131
					(= seconds 2)
				else
					(= cycles 5)
				)
			)
			(1
				(egoItem dispose:)
				(HandsOn)
			)
		)
	)
)

(instance followTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global270 0)
				(= global103 1)
				(if (< (roomItem x:) 100)
					(itemBalloon0
						init:
						posn: (+ (roomItem x:) 63) (- (roomItem y:) 44)
						setLoop: 1
						setCel: 0
						show:
					)
				else
					(itemBalloon0
						init:
						posn: (- (roomItem x:) 63) (- (roomItem y:) 44)
						setLoop: 0
						setCel: 0
						show:
					)
				)
				(RedrawCast)
				(StrCpy
					@global270
					(cond
						((== (roomItem view:) 41) {I live\nin a\npumpkin!})
						((== (roomItem view:) 43) {Can you\nhelp us\nfind the\ncastle?})
						(else {Please\nhelp me\nfind my\ntuffet!})
					)
				)
				(if (< (roomItem x:) 100)
					(Display
						@global270
						dsWIDTH
						150
						dsCOORD
						(- (roomItem x:) 15)
						(- (roomItem y:) 96)
						dsALIGN
						alCENTER
						dsFONT
						0
						dsCOLOR
						0
					)
				else
					(Display
						@global270
						dsWIDTH
						150
						dsCOORD
						(- (roomItem x:) 138)
						(- (roomItem y:) 96)
						dsALIGN
						alCENTER
						dsFONT
						0
						dsCOLOR
						0
					)
				)
				(roomItem setLoop: 4 setCycle: Fwd)
				(= seconds global120)
			)
			(1
				(itemBalloon0 setCel: 1)
				(if (< (roomItem x:) 100)
					(itemVisual0
						init:
						setLoop:
							(cond
								((== (roomItem view:) 43) 0)
								((== (roomItem view:) 41) 1)
								(else 2)
							)
						posn: (+ (roomItem x:) 62) (- (roomItem y:) 63)
						show:
					)
				else
					(itemVisual0
						init:
						setLoop:
							(cond
								((== (roomItem view:) 43) 0)
								((== (roomItem view:) 41) 1)
								(else 2)
							)
						posn: (- (roomItem x:) 65) (- (roomItem y:) 63)
						show:
					)
				)
				(roomItem setCel: 0)
				(= seconds 3)
			)
			(2
				(itemVisual0 hide:)
				(itemBalloon0 hide:)
				(= global103 0)
				(roomItem setLoop: -1 setCycle: Walk setScript: doWander)
				(HandsOn)
			)
		)
	)
)

(instance tS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global270 0)
				(= global103 1)
				(HandsOff)
				(roomItem setMotion: 0)
				(egoItem setMotion: 0)
				(if (< (egoItem x:) 100)
					(itemBalloon0
						init:
						posn: (+ (egoItem x:) 63) (- (egoItem y:) 44)
						setLoop: 1
						setCel: 0
						show:
					)
				else
					(itemBalloon0
						init:
						posn: (- (egoItem x:) 63) (- (egoItem y:) 44)
						setLoop: 0
						setCel: 0
						show:
					)
				)
				(RedrawCast)
				(StrCpy
					@global270
					(cond
						((== global111 41) {I live\nin a\npumpkin!})
						((== global111 43) {Can you\nhelp us\nfind the\ncastle?})
						(else {Please\nhelp me\nfind my\ntuffet!})
					)
				)
				(if (< (egoItem x:) 100)
					(Display
						@global270
						dsWIDTH
						150
						dsCOORD
						(- (egoItem x:) 15)
						(- (egoItem y:) 96)
						dsALIGN
						alCENTER
						dsFONT
						0
						dsCOLOR
						0
					)
				else
					(Display
						@global270
						dsWIDTH
						150
						dsCOORD
						(- (egoItem x:) 138)
						(- (egoItem y:) 96)
						dsALIGN
						alCENTER
						dsFONT
						0
						dsCOLOR
						0
					)
				)
				(egoItem setLoop: 4 setCycle: Fwd)
				(= seconds global120)
			)
			(1
				(itemBalloon0 setCel: 1)
				(if (< (egoItem x:) 100)
					(itemVisual0
						init:
						posn: (+ (egoItem x:) 62) (- (egoItem y:) 63)
						show:
					)
				else
					(itemVisual0
						init:
						posn: (- (egoItem x:) 65) (- (egoItem y:) 63)
						show:
					)
				)
				(egoItem setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual0 hide:)
				(itemBalloon0 hide:)
				(= global103 0)
				(HandsOn)
				(egoItem
					setLoop: -1
					setCycle: Walk
					setMotion: Follow gEgo 30
				)
			)
			(3
				(client setScript: tS)
			)
		)
	)
)

(instance endGameScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(HandsOff)
				(gEgo
					setAvoider: Avoid
					setMotion: MoveTo global129 global130 self
				)
			)
			(1
				(gGlobalMGSound number: 1 loop: -1 play:)
				(gEgo setLoop: 1)
				(flyer0 init:)
				(wing init:)
				(flyer0 setMotion: MoveTo (- (gEgo x:) 30) (gEgo y:) self)
			)
			(2
				(flyer0
					view: 17
					setLoop: 0
					setCel: 0
					posn: (flyer0 x:) (- (flyer0 y:) 1)
				)
				(wing hide:)
				(motherG0
					init:
					view: 94
					posn: (+ (flyer0 x:) 2) (flyer0 y:)
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(endBalloon init:)
				(RedrawCast)
				(Display
					(Format
						@global270
						{You've done a\nwonderful job,\n%s!}
						@global210
					)
					dsWIDTH
					100
					dsCOORD
					(+ (flyer0 x:) 2)
					(- (flyer0 y:) 82)
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(4
				(endBalloon init:)
				(RedrawCast)
				(Display
					{And everyone\nwants to\nthank you!}
					dsWIDTH
					100
					dsCOORD
					(+ (flyer0 x:) 2)
					(- (flyer0 y:) 82)
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(5
				(endBalloon dispose:)
				(motherG0 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(6
				(motherG0
					setLoop: 6
					setCel: 0
					setCycle: Rev
					setMotion: MoveTo (- (flyer0 x:) 24) (flyer0 y:) self
				)
			)
			(7
				(motherG0 setCycle: 0)
				(gEgo
					setMotion: MoveTo (- (flyer0 x:) 3) (+ (flyer0 y:) 2) self
				)
			)
			(8
				(gEgo dispose:)
				(rider1 init:)
				(= cycles 2)
			)
			(9
				(rider1 setCycle: Beg self)
			)
			(10
				(motherG0
					setCycle: Fwd
					setMotion: MoveTo (- (flyer0 x:) 7) (flyer0 y:) self
				)
			)
			(11
				(motherG0 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(12
				(rider0 init:)
				(motherG0 dispose:)
				(rider1 hide:)
				(wing show:)
				(flyer0
					view: global117
					setCycle: Fwd
					setMotion: MoveTo 350 21 self
				)
			)
			(13
				(gCurRoom newRoom: 32)
			)
		)
	)
)

(instance box of View
	(properties)

	(method (init)
		(super init:)
		(self view: 40 posn: 288 37 setPri: 13 stopUpd:)
	)
)

(instance boxItem of View
	(properties)

	(method (init)
		(super init:)
		(if (> global111 47)
			(self
				name: {staticBoxItem}
				view: global111
				setLoop: 1
				posn: 290 30
				setPri: 14
				stopUpd:
			)
		else
			(self
				name: {followBoxItem}
				view: 133
				setLoop: (- global111 41)
				posn: 285 33
				setPri: 14
				stopUpd:
			)
		)
	)
)

(instance roomItem of Actor
	(properties)

	(method (init)
		(super init:)
		(if (> global600 47)
			(self
				name: {staticItem}
				view: global600
				setPri: -1
				setLoop: 0
				illegalBits: 0
				ignoreControl: 1
				ignoreActors: 1
				posn: global109 global110
				setScript: 0
				forceUpd:
				stopUpd:
			)
			(if (== global600 55)
				(self setCycle: Fwd setMotion: 0 cycleSpeed: 1)
			)
		else
			(followerCage init:)
			(self
				name: {followItem}
				view: global600
				illegalBits: -32768
				posn: global109 global110
				setLoop: -1
				setCycle: Walk
				cycleSpeed: 0
				setScript: doWander
				observeBlocks: followerCage
			)
		)
		(if (<= gCurRoomNum 36)
			(self setPri: -1)
		)
	)
)

(instance followerCage of Cage
	(properties)

	(method (init)
		(super init:)
		(self
			top:
				(if (!= gCurRoomNum 26)
					(- global110 20)
				else
					135
				)
			left: (- global109 25)
			bottom: (+ global110 20)
			right: (+ global109 25)
		)
	)
)

(instance endBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 39
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			posn: (+ (flyer0 x:) 52) (- (flyer0 y:) 32)
			setPri: 14
			stopUpd:
		)
	)
)

(instance rider0 of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 7
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)

	(method (doit)
		(if (== (flyer0 view:) global117)
			(self
				setCel: (flyer0 cel:)
				setPri: (+ (flyer0 priority:) 1)
				posn: (- (flyer0 x:) 10) (+ (flyer0 y:) 4)
			)
		else
			(self
				setCel: (flyer0 cel:)
				setPri: (+ (flyer0 priority:) 1)
				posn: (- (flyer0 x:) 8) (+ (flyer0 y:) 6)
			)
		)
		(super doit:)
	)
)

(instance rider1 of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: (+ global117 1)
			posn: (- (flyer0 x:) 3) (- (flyer0 y:) 1)
			setCel: 9
			setPri: (+ (flyer0 priority:) 1)
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)
)

(instance flyer0 of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 93
			setPri: (- (gEgo priority:) 1)
			setLoop: 0
			setCycle: Walk
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			posn: -19 21
		)
	)
)

(instance wing of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 16
			setLoop: (+ (flyer0 loop:) 5)
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)

	(method (doit)
		(self
			posn: (flyer0 x:) (flyer0 y:)
			setPri: (+ (flyer0 priority:) 2)
			setCel: (flyer0 cel:)
		)
		(super doit:)
	)
)

(instance motherG0 of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			setCel: (flyer0 cel:)
			setPri: (+ (flyer0 priority:) 1)
			posn: (+ (flyer0 x:) 2) (+ (flyer0 y:) 2)
		)
	)
)

(instance goose0 of View ; UNUSED
	(properties)

	(method (init)
		(super init:)
		(self
			view: 17
			setLoop: 1
			setCel: 0
			posn: (flyer0 x:) (- (flyer0 y:) 5)
			stopUpd:
		)
	)
)

(instance followEgo of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gNewRoomNum gCurRoomNum)
				(== global128 1)
				(<= (gEgo distanceTo: egoItem) 18)
				(gEgo isBlocked:)
			)
			(egoItem setAvoider: 0 setMotion: Wander 50)
			(= global128 0)
		)
		(if
			(and
				(== gNewRoomNum gCurRoomNum)
				(== global128 0)
				(>= (gEgo distanceTo: egoItem) 40)
			)
			(= global128 1)
			(egoItem setAvoider: Avoid setMotion: Follow gEgo 30)
		)
	)
)

(instance blockOne of Blk
	(properties
		top 189
		bottom 333
		right 320
	)
)

(instance itemVisual0 of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 145
			setLoop:
				(cond
					((== global111 43) 0)
					((== global111 41) 1)
					(else 2)
				)
			setCel: 0
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon0 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 2 setCel: 0 setPri: 14 hide: stopUpd:)
	)
)

(instance doWander of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: Wander 100)
				(= seconds (Random 5 15))
			)
			(1
				(client setMotion: 0)
				(= state -1)
				(= seconds (Random 2 10))
			)
		)
	)
)

(instance egoItem of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			name: {egoItem}
			view: global111
			setCycle: Walk
			setMotion: Follow gEgo 30
			setAvoider: Avoid
			ignoreActors: 0
			observeBlocks: blockOne
		)
		(egoItem setScript: followEgo)
		(= global128 1)
		(if (>= gCurRoomNum 36)
			(self setMotion: 0 stopUpd:)
		)
	)
)

