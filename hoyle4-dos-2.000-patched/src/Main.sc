;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use KeyMouse)
(use InvisibleWindow)
(use Piles)
(use Character)
(use Interface)
(use Print)
(use BorderWindow)
(use IconBar)
(use GameControls)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	hoyle4 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
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
	gWaitCursor = 997
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
	gTextSpeed = 2
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	global100
	global101 = 1234
	gAbsoluteCast
	gDelayCast
	gChar1
	; 105
	gChar2
	gChar3
	global107
	global108
	global109
	; 110
	gMouseCursor
	global111
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	gTheKeyMouseList
	global119
	; 120
	gGame_opt
	global121
	global122 = 1
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
	global190 = 999
	global191
	global192
	global193
	global194 = 1
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
	gCrazy8s_opt
	global221
	global222
	global223
	global224
	; 225
	gOldmaid_opt
	global226
	global227
	global228
	global229
	; 230
	gHearts_opt
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
	gGinrummy_opt
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
	gCribbage_opt
	global251
	global252
	global253
	global254
	; 255
	global255 = 257
	global256
	global257
	global258
	global259
	; 260
	gKlondike_opt
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
	gBridge_opt
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
	gEuchre_opt
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
	gSong
	gSound
	gSound2
	; 300
	global300
	global301
	global302
	global303
	global304
	; 305
	global305
	global306
	global307 = 1
	global308
	global309
	; 310
	global310
	global311
	global312 = 1
	global313
	global314
	; 315
	global315
	global316
	global317
	global318 = 30
	global319 = 40
	; 320
	global320 = 98
	global321 = 97
	global322 = 80
	global323 = 70
	global324 = 90
	; 325
	global325 = 20
	global326 = 60
	global327 = 95
	global328 = 99
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
	global343 = 1
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
	gGcWindow
	global384
	; 385
	global385
	global386 = 10
	global387 = 2
	global388
	gHoyle4GameControls
	; 390
	global390
	global391 = 3
	global392 = 1
	global393 = 2
	global394 = 1
	; 395
	global395
	global396 = 8
	global397 = 8
	global398
	global399
	; 400
	gATalker
	gAniList
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
	gCrazy8sSortCode
	global419
	; 420
	global420 = -1
	global421
	global422
	global423
	global424 = -1
	; 425
	global425
	global426
	global427
	global428
	global429
	; 430
	global430
	global431
	global432 = 1
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
	gTheCard1
	gTheCard2
	gTheCard3
	gTheCard4
	global454
	; 455
	gCrazy8sHand
	global456
	global457
	global458
	global459
	; 460
	gAddToTricksWon
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
	gTrick
	gTray
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
	global527 = 4
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
	global538 = 1
	global539
	; 540
	global540
	global541
	global542
	global543
	global544
	; 545
	gWL
	gKnownCards
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

(procedure (proc0_7 &tmp temp0)
	(while ((= temp0 (Event new: 3)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (proc0_6) ; UNUSED
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

(procedure (proc0_1 param1)
	(Animate (gCast elements:) (if argc param1 else 0))
)

(procedure (proc0_2 param1)
	(return (and (== (param1 type:) 4) (== (param1 message:) 13)))
)

(procedure (localproc_0)
	(= gGameControls hoyle4GameControls)
	((= gTheIconBar IconBar)
		curIcon: (ScriptID 12 0) ; gameControlIcon
		state: 1024
		init:
		add:
			((ScriptID 12 0) ; gameControlIcon
				theObj: (ScriptID 12 0) ; gameControlIcon
				selector: #doit
				init:
				yourself:
			)
			((ScriptID 12 1) ; optionsIcon
				theObj: (ScriptID 12 1) ; optionsIcon
				selector: #doit
				init:
				yourself:
			)
			((ScriptID 12 2) ; scoreIcon
				theObj: (ScriptID 12 2) ; scoreIcon
				selector: #doit
				init:
				yourself:
			)
			((ScriptID 12 3) ; rulesIcon
				theObj: (ScriptID 12 3) ; rulesIcon
				selector: #doit
				init:
				yourself:
			)
			((ScriptID 12 5) ; deckIcon
				theObj: (ScriptID 12 5) ; deckIcon
				selector: #doit
				init:
				yourself:
			)
			((ScriptID 12 4) ; helpIcon
				theObj: (ScriptID 12 4) ; helpIcon
				selector: #doit
				init:
				yourself:
			)
		helpIconItem: (ScriptID 12 4) ; helpIcon
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
			(if (and (!= gTheCursor 997) (!= gTheCursor 30))
				(= global191 (mouseCursor x:))
				(= global192 (mouseCursor y:))
			)
			(= global190 gTheCursor)
			(gGame setCursor: (if argc param1 else 997) 1 319 199)
		else
			(= global190 gTheCursor)
			(gGame setCursor: (if argc param1 else 997) 1)
		)
	)
)

(procedure (proc0_3)
	(if (not (User controls:))
		(User canControl: 1 canInput: 1)
		(if (not (HaveMouse))
			(gGame setCursor: global190 1 global191 global192)
		else
			(gGame setCursor: global190)
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
		(= global378 31)
		(= global379 31)
		(= global380 8)
		(= global381 8)
		(= global382 7)
	else
		(= global370 1)
	)
)

(procedure (proc0_8 param1)
	(if (OneOf gCurRoomNum 100 200 300 400 500 600 700 800) ; crazy8s, oldMaid, heartsGame, ginRummy, cribbage, klondike, bridge, euchre
		(if (and argc param1)
			(gSong stop:)
			(PlaySong play: param1)
		else
			(gSong fade:)
		)
	)
)

(class HoyleRoom of Rm
	(properties)

	(method (beforeNewPic &tmp temp0)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(return 1)
	)

	(method (afterNewPic &tmp temp0)
		(return 1)
	)

	(method (drawNewPic)
		(DrawPic picture 10)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(if (!= (+ global385 901) picture)
			(IconBar disable:)
			(= temp1 picture)
			(= picture (+ global385 901))
			(proc0_4)
			(if (self beforeNewPic:)
				(for ((= temp0 0)) (< temp0 (gDelayCast size:)) ((++ temp0))
					(gCast add: (gDelayCast at: temp0))
				)
				(proc0_1)
				(= temp2 (PicNotValid))
				(PicNotValid 1)
				(self drawNewPic:)
				(if (gChar1 active:)
					(gChar1 init:)
				)
				(if (gChar2 active:)
					(gChar2 init:)
				)
				(if (gChar3 active:)
					(gChar3 init:)
				)
				(PicNotValid temp2)
				(proc0_1)
				(for ((= temp0 0)) (< temp0 (gDelayCast size:)) ((++ temp0))
					(gCast delete: (gDelayCast at: temp0))
				)
				(self afterNewPic:)
			else
				(= picture temp1)
			)
			(proc0_3)
			(IconBar enable:)
		)
	)

	(method (dispose)
		(DisposeScript 929)
		(= global395 0)
		(gDelayCast release:)
		(super dispose:)
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
			(= color 0)
		)
		(super open: &rest)
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
				(gChar1 init:)
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
				(gChar2 init:)
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
				(gChar3 init:)
				(if caller
					(caller cue:)
				)
				(proc0_1)
			)
		)
	)
)

(instance hoyle4 of Game
	(properties)

	(method (init &tmp temp0 [temp1 7] temp8 temp9 temp10)
		(= gTheCursor gNormalCursor)
		(= global191 319)
		(= global192 199)
		(= gHowFast 2)
		(proc0_4)
		(localproc_1)
		(TextColors 0 55 7 6 5)
		(TextFonts 0 2107 2107)
		(Print font: 2107 width: 220 mode: 1)
		(= gUserFont 2107)
		(= gEatMice 0)
		(self setSpeed: 0)
		(= gSystemWindow HoyleWindow)
		(gSystemWindow color: 55 back: -1)
		(= gUseSortedFeatures 1)
		(User alterEgo: (= gEgo Ego))
		(= gHoyle4GameControls hoyle4GameControls)
		(Dealer add:)
		((= gAniList aniList) add:)
		((= gAbsoluteCast absoluteCast) add:)
		((= gKeyDownHandler hoyle4KeyDown) add:)
		((= gMouseDownHandler hoyle4MouseDown) add:)
		((= gDirectionHandler hoyle4Direction) add:)
		((= gTheKeyMouseList theKeyMouseList) add:)
		((= gDelayCast delayCast) add:)
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
		(= gMsgType 1)
		DItem
		(Load rsVIEW 902)
		(Load rsVIEW 901)
		(ScriptID 14 0) ; setGC
		GameControls
		IconBar
		(Load rsVIEW 990)
		(Lock rsVIEW 990)
		(Characters add:)
		((= gATalker aTalker) add:)
		(localproc_0)
		(= gGcWindow gcWindow)
		(= gGameControls hoyle4GameControls)
		((ScriptID 14 0) doit:) ; setGC
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
		(Format @gSysLogPath 0 0)
		(gTheIconBar disable:)
		(= gTheCard1 theCard1)
		(Format @temp1 0 1) ; "resource.aud"
		(= global454 0)
		(if (FileIO fiEXISTS @temp1)
			(= global454 1)
		)
		(= temp10 (mod (= temp9 (MemoryInfo 4)) 1024)) ; TotalHunk
		(= global254
			(= temp8 (+ (= temp8 (* (/ temp9 1024) 16)) (/ (* temp10 16) 1024)))
		)
		(self newRoom: 900) ; sierra
	)

	(method (doit)
		(super doit:)
	)

	(method (setCursor param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (IsObject param1)
			(= gTheCursor param1)
			(param1 init:)
		else
			(= gTheCursor param1)
			(SetCursor param1 0 0)
		)
		(if (> argc 1)
			(if (not param2)
				(SetCursor 998 0 0)
			else
				(SetCursor param1 0 0)
			)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor param1 0 0 param5 param6)
				)
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event globalize:)
		(mouseCursor x: (event x:) y: (event y:))
	)

	(method (quitGame &tmp [temp0 10])
		(super quitGame:)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(Deck eachElementDo: #hide)
		(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
			(gCast delete: (Deck at: temp0))
		)
		(gAbsoluteCast release:)
		(gGame setCursor: 997 1)
		(if (== (Platform 4 1) 1)
			(proc0_5)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom param1)
		(if gDebugOn
			(SetDebug)
		)
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

(instance hoyle4MouseDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(gCurRoom handleEvent: event)
		)
		(event claimed:)
	)
)

(instance hoyle4KeyDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed:)
				(return)
			)
			(gCurRoom handleEvent: event)
			(event claimed:)
			(return)
		)
	)
)

(instance aTalker of Set
	(properties)
)

(instance hoyle4Direction of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(event claimed:)
	)
)

(instance theKeyMouseList of Set
	(properties)
)

(instance aniList of Set
	(properties)
)

(instance mouseCursor of Actor
	(properties)
)

(class HoyleGameControls of GameControls
	(properties
		okIconItem 0
	)

	(method (dispatchEvent event &tmp temp0)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL claimed: 1)
			(if okIconItem
				(okIconItem doit:)
			)
			(return)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance hoyle4GameControls of HoyleGameControls
	(properties)

	(method (show)
		(self window: gGcWindow)
		(super show:)
	)
)

(instance gcWindow of InvisibleWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4)
		(self top: 46 left: 60 bottom: 162 right: 258)
		(super open:)
		(DrawCel 901 0 0 0 0 15)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1) ; UNINIT, UNINIT, UNINIT, UNINIT
	)
)

(instance game_opt of File
	(properties
		name {game.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10] temp30)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%3d%2d%2d%2d%2d%2d%d%2d%d"
								@temp0
								0
								2
								(DoSound sndMASTER_VOLUME)
								(StrLen @global472)
								global384
								global385
								global387
								global386
								global462
								gSpeed
								global121
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				1
				(gGame masterVolume: (ReadNumber (self readString: @temp20 4)))
				(= temp30 (ReadNumber (self readString: @temp20 3)))
				(self readString: @temp20 (+ temp30 1))
				(= global384 (ReadNumber (self readString: @temp20 3)))
				(= global385 (ReadNumber (self readString: @temp20 3)))
				(= global387 (ReadNumber (self readString: @temp20 3)))
				(= global386 (ReadNumber (self readString: @temp20 3)))
				(= global462 (ReadNumber (self readString: @temp20 2)))
				(= gSpeed (ReadNumber (self readString: @temp20 3)))
				(= global121 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(gGame masterVolume: 12)
				(= global384 1)
				(= global385 1)
				(= global387 2)
				(= global386 10)
				(= global462 0)
				(= gSpeed 0)
				(= global121 1)
				(return 0)
			)
		)
	)
)

(instance absoluteCast of Set
	(properties)
)

(instance version of File
	(properties)

	(method (doit)
		(if (self open: 1)
			(self readString: @global541 6 close:)
		)
	)
)

(instance theCard1 of Actor
	(properties)
)

(instance delayCast of Set
	(properties)
)

(class PlaySong of Obj
	(properties
		nextSong 0
		client 0
		nextOverride 0
	)

	(method (play param1 param2 &tmp temp0)
		(= client (if (>= argc 2) param2 else 0))
		(gSong setLoop: -1)
		(if (and argc param1)
			(if (not (gSong handle:))
				(= temp0 param1)
				(if (and (== global121 2) (<= argc 2))
					(= temp0 [global318 (Random 0 10)])
				)
				(if (== global121 3)
					(DoSound sndSUSPEND 1)
				)
				(gSong play: temp0 client)
				(if (== global121 3)
					(if (< temp0 100)
						(gSong mute: 1)
					)
					(DoSound sndSUSPEND 0)
				)
				(= nextSong (= nextOverride 0))
			else
				(= nextSong param1)
				(= nextOverride (if (>= argc 3) 1 else 0))
				(gSong fade: self)
			)
		else
			(gSong fade:)
			(= nextSong (= nextOverride 0))
		)
	)

	(method (cue &tmp temp0)
		(if nextSong
			(= temp0 nextSong)
			(if (and (== global121 2) (not nextOverride))
				(= temp0 [global318 (Random 0 10)])
			)
			(if (== global121 3)
				(DoSound sndSUSPEND 1)
			)
			(gSong play: temp0 client)
			(if (== global121 3)
				(if (< temp0 100)
					(gSong mute: 1)
				)
				(DoSound sndSUSPEND 0)
			)
			(= nextOverride (= nextSong 0))
		)
	)
)

(instance song of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(if
			(and
				(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
				(<= (DoSound sndGET_POLYPHONY) 11)
			)
			(+= number 1000)
		)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
		(if (>= argc 2)
			(= client param2)
		)
	)
)

(instance sound of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(if
			(and
				(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
				(<= (DoSound sndGET_POLYPHONY) 11)
			)
			(+= number 1000)
		)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
		(if (>= argc 2)
			(= client param2)
		)
	)
)

(instance sound2 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(= number param1)
		(if
			(and
				(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
				(<= (DoSound sndGET_POLYPHONY) 11)
			)
			(+= number 1000)
		)
		(= client (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super play: param3)
		else
			(super play:)
		)
		(if (>= argc 2)
			(= client param2)
		)
	)
)

