;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Deck)
(use Dealer)
(use WL)
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
	solitare 0
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
	gVersion = {solitare}
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
	gSysWindow
	; 60
	global60
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
	global76
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
	global301
	global302
	global303
	global304 = 10
	; 305
	gTheStock
	gTheDeck
	gTheInputList
	gTheCardToss
	gTheTransferList
	; 310
	gTheDealer
	global311
	global312
	global313
	gTheSound
	; 315
	gTheSliders
	global316 = 1
	global317
	global318
	global319
	; 320
	global320
	global321
	gTheWastePiles
	global323
	global324
	; 325
	global325
	gTheTransferList2
	gTheAutoCardToss
	global328
	global329
	; 330
	global330
	gTheFoundations
	gTheColumns
	gTheReserves
	gTheWorkingDeck
	; 335
	global335
	global336 = 1
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
	gGameName
	global402
	global403
	global404
	; 405
	global405
	global406
	global407 = 1
	gTheAutoCardToss2
	global409
	; 410
	global410
	gTheTransferList3
	global412 = 18
	global413
	global414
	; 415
	gATempList
	global416 = 1
	global417 = 1
	global418
	global419
	; 420
	global420
	global421
	global422 = 1
	global423
	global424
	; 425
	global425
	global426
	global427
	global428
	global429
	; 430
	global430 = 2
	global431 = 1
	global432 = 1
	global433 = 2
	global434 = 3
	; 435
	global435 = 3
	global436 = 1
	global437 = 3
	global438 = 2
	global439 = 1
	; 440
	global440 = 2
	global441 = 1
	global442 = 2
	global443 = 1
	global444 = 2
	; 445
	global445 = 1
	global446 = 2
	global447 = 1
	global448 = 2
	global449 = 1
	; 450
	global450 = 1
	global451 = 1
	global452 = 2
	global453 = 2
	global454 = 2
	; 455
	global455 = 1
	global456 = 1
	global457 = 1
	global458 = 2
	global459 = 2
	; 460
	global460 = 1
	global461 = 3
	global462 = 3
	global463 = 3
	global464 = 1
	; 465
	global465 = 3
	global466 = 2
	global467 = 1
	global468 = 3
	global469 = 1
	; 470
	global470 = 2
	global471 = 2
	global472 = 2
	global473 = 1
	global474 = 3
	; 475
	global475 = 2
	global476 = 2
	global477 = 1
	global478 = 1
	global479 = 1
	; 480
	global480 = 3
	global481 = 3
	global482 = 3
	global483 = 2
	global484 = 1
	; 485
	global485 = 1
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
	global644 = 1
	; 645
	global645 = 1
	global646 = 1
	global647
	global648 = -1
	global649 = -1
	; 650
	global650 = -1
	global651
	global652 = -1
	global653 = -1
	global654
	; 655
	global655 = 1
	global656 = 1
	global657 = 1
	global658
	global659 = -1
	; 660
	global660 = -1
	global661
	global662 = 1
	global663 = -1
	global664
	; 665
	global665 = 1
	global666 = -1
	global667
	global668 = 1
	global669 = 1
	; 670
	global670 = 1
	global671 = 1
	global672
	global673
	global674
	; 675
	global675 = -1
	global676 = -1
	global677 = -1
	global678
	global679 = 2
	; 680
	gOptions_sol
	global681 = 1
	global682
	global683
	global684 = -1
	; 685
	global685
	global686
	global687
	global688
	global689
	; 690
	global690 = 2
	global691 = 2
	global692 = 1
	global693 = 2
	global694 = 1
	; 695
	global695 = 1
	global696 = 1
	global697 = 3
	global698 = 2
	global699 = 2
	; 700
	global700 = 3
	global701 = 1
	global702 = 3
	global703 = 2
	global704 = 2
	; 705
	global705 = 2
	global706 = 2
	global707 = 1
	global708 = 3
	global709 = 1
	; 710
	global710 = 1
	global711 = 1
	global712 = 3
	global713 = 3
	global714 = 3
	; 715
	global715 = 1
	global716 = 2
	global717 = 2
	global718 = 2
	global719 = 2
	; 720
	global720 = 1
	global721 = 2
	global722 = 1
	global723 = 1
	global724 = 1
	; 725
	global725 = 3
	global726 = 2
	global727 = 2
	global728 = 3
	global729 = 1
	; 730
	global730 = 3
	global731 = 2
	global732 = 2
	global733 = 3
	global734 = 2
	; 735
	global735 = 1
	global736 = 3
	global737 = 1
	global738 = 1
	global739 = 1
	; 740
	global740 = 2
	global741 = 3
	global742 = 2
	global743 = 1
	global744 = 2
	; 745
	global745 = 2
	global746
	global747
	global748
	global749
	; 750
	global750 = 15872
)

(procedure (proc0_4 &tmp temp0 [temp1 10])
	(= temp0
		(if (== global681 1)
			(Format @temp1 0 1 0 2) ; "%s"
		else
			(Format @temp1 0 1 0 3) ; "%s"
		)
	)
	(if (proc0_6 119)
		(DrawStatus (Format @global100 0 4 (gGameName text:) temp0)) ; "%s%s"
	else
		(DrawStatus (Format @global100 0 5 (gGameName text:) temp0 global400)) ; "%s%s     Score: %d"
	)
)

(procedure (proc0_5 param1)
	(gTheSound number: 35 play:)
	(Print param1)
)

(procedure (proc0_1 param1 param2 param3 param4 param5 param6)
	((View new:)
		view: param1
		setLoop: param2
		setCel: param3
		setPri: (if (== argc 6) param6 else 8)
		posn: param4 param5
		ignoreActors:
		addToPic:
		yourself:
	)
)

(procedure (proc0_2)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_3 param1 &tmp temp0 temp1) ; UNUSED
	(if (> param1 0)
		(for ((= temp0 0)) (< temp0 (/ param1 6)) ((++ temp0))
			(Wait 6)
			(= temp1 (Event new:))
			(MenuBar handleEvent: temp1)
			(if
				(and
					(or
						(== (temp1 type:) evMOUSEBUTTON)
						(and (== (temp1 type:) evKEYBOARD) (== (temp1 message:) KEY_RETURN))
					)
					(>= (temp1 y:) 10)
				)
				(temp1 dispose:)
				(break)
			)
			(temp1 dispose:)
			(proc0_2)
		)
	)
)

(procedure (proc0_6 param1)
	(return (== (mod global337 100) (mod param1 100)))
)

(instance solitare of Game
	(properties)

	(method (init)
		(if (== (Graph grGET_COLOURS) 2)
			(sysWindow color: 0 back: 15)
		)
		(Load rsFONT (= gUserFont 0))
		(= gTheCardToss theCardToss)
		(= gTheAutoCardToss theAutoCardToss)
		(= gTheAutoCardToss2 theAutoCardToss2)
		(= gSysWindow sysWindow)
		((= gTheSound theSound) init:)
		(= gSpeed (= global316 1))
		(if (GameIsRestarting)
			(gTheSound number: 20 play:)
		)
		((= gOptions_sol options_sol) doit: 0)
		((= gTheDeck theDeck) add:)
		((= gTheDealer theDealer) add:)
		((= gTheTransferList theTransferList) add:)
		((= gTheTransferList2 theTransferList2) add:)
		((= gTheTransferList3 theTransferList3) add:)
		((= gTheInputList theInputList) add:)
		((= gTheWastePiles theWastePiles) add:)
		((= gTheWorkingDeck theWorkingDeck) add:)
		(super init:)
		(self newRoom: (if (GameIsRestarting) 2 else 900))
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and global318 (not global678) (== (event type:) evMOUSEBUTTON))
			(if
				(or
					(proc0_6 102)
					(proc0_6 105)
					(proc0_6 124)
					(proc0_6 120)
					(proc0_6 125)
				)
				(if
					(and
						(not (gTheCardToss mover:))
						(not (gTheAutoCardToss mover:))
						(not (gTheAutoCardToss2 mover:))
					)
					(gTheInputList handleEvent: event)
				)
			else
				(gTheInputList handleEvent: event)
			)
		)
	)

	(method (doit)
		(KeyMouse doit:)
		(super doit:)
	)
)

(instance options_sol of gamefile_sh
	(properties
		name {options.sol}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(if param1
			(self
				open: 2
				write:
					(Format ; "%2d%2d%2d%2d%2d%2d%2d"
						@temp0
						0
						0
						global300
						(DoSound sndSET_SOUND)
						gVolume
						global679
						gSpeed
						global681
						(KeyMouse cursorSpeed:)
					)
				close:
			)
		else
			(self open: 1)
			(if
				(or
					(< (= global300 (ReadNumber (self read: @temp20 3))) 0)
					(> global300 15)
				)
				(= global300 0)
			)
			(DoSound sndSET_SOUND (ReadNumber (self read: @temp20 3)))
			(DoSound sndVOLUME (= gVolume (ReadNumber (self read: @temp20 3))))
			(if
				(or
					(< (= global679 (ReadNumber (self read: @temp20 3))) 0)
					(> global679 15)
				)
				(= global679 2)
			)
			(if
				(or
					(< (= gSpeed (ReadNumber (self read: @temp20 3))) 1)
					(> gSpeed 8)
				)
				(= gSpeed 4)
			)
			(if
				(and
					(!= (= global681 (ReadNumber (self read: @temp20 3))) 1)
					(!= global681 4)
				)
				(= global681 1)
			)
			(KeyMouse cursorSpeed: (ReadNumber (self read: @temp20 3)))
			(if (or (< (KeyMouse cursorSpeed:) 1) (> (KeyMouse cursorSpeed:) 3))
				(KeyMouse cursorSpeed: 2)
			)
			(self close:)
		)
	)
)

(instance sysWindow of SysWindow
	(properties
		color 14
		back 1
	)
)

(instance theSound of Sound
	(properties
		number 10
		owner -1
	)
)

(class CardToss of Act
	(properties
		caller 0
		aMethod 0
		number 0
	)

	(method (init param1 param2 param3)
		(= caller param2)
		(= aMethod (if (== argc 3) param3 else 0))
		(self
			view: 203
			setLoop: 0
			posn: (+ (param1 x:) 17) (+ (param1 y:) 21)
			setPri: 14
			setMotion: MoveTo (param2 nextX:) (param2 nextY:) self
			setCycle: Fwd
			setStep: (- 41 (* 5 gSpeed)) (- 41 (* 5 gSpeed))
			cycleSpeed: 1
		)
		(gTheSound number: (if (>= (DoSound sndCHECK_DRIVER) 3) 100 else 212) play:)
		(super init:)
	)

	(method (cue &tmp temp0)
		(= temp0
			(switch number
				(0 0)
				(1 gTheTransferList2)
				(2 gTheTransferList3)
			)
		)
		(self posn: 500 500)
		(cond
			(temp0
				(if aMethod
					(caller transferCards: temp0)
				else
					(caller cue: temp0)
				)
			)
			(aMethod
				(caller transferCards:)
			)
			(else
				(caller cue:)
			)
		)
	)
)

(instance theCardToss of CardToss
	(properties)
)

(instance theAutoCardToss of CardToss
	(properties
		number 1
	)
)

(instance theAutoCardToss2 of CardToss
	(properties
		number 2
	)
)

(instance theDeck of Deck
	(properties)
)

(instance theDealer of Dealer
	(properties)
)

(instance theTransferList of WL
	(properties)
)

(instance theTransferList2 of WL
	(properties)
)

(instance theTransferList3 of WL
	(properties)
)

(instance theInputList of WL
	(properties)

	(method (handleEvent event)
		(if (or (proc0_6 124) (proc0_6 126))
			(self lastTrue: event)
		else
			(self firstTrue: #handleEvent event)
		)
	)
)

(instance theWastePiles of WL
	(properties)
)

(instance theWorkingDeck of WL
	(properties)
)

