;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use KeyMouse)
(use SpeakWindow)
(use Interface)
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
	proc0_7 7
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
	gNormalCursor = 982
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
	global101 = 1234
	gLooperDir8
	global103
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
	global113
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
	global138
	global139
	; 140
	global140
	global141
	global142
	global143
	gTheKeyMouseList
	; 145
	global145
	global146
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
	global182 = 982
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
	global400
	global401
	global402 = 400
	global403
	global404
	; 405
	global405
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
	(if (gAbsoluteCast sel_86:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(Animate (gAbsoluteCast sel_24:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(if (gAbsoluteCast sel_86:)
				(gAbsoluteCast sel_119: 222)
			)
		)
	)
)

(procedure (proc0_1)
	(Animate (gCast sel_24:) 0)
)

(procedure (proc0_2 param1)
	(return (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 13)))
)

(procedure (localproc_0)
	((= gTheIconBar IconBar)
		sel_210: (ScriptID 12 0) ; gameControlIcon
		sel_110:
		sel_118:
			(ScriptID 12 0) ; gameControlIcon
			(ScriptID 12 1) ; optionsIcon
			(ScriptID 12 2) ; scoreIcon
			(ScriptID 12 3) ; rulesIcon
			(ScriptID 12 4) ; helpIcon
		sel_119: 110
		sel_215: (ScriptID 12 4) ; helpIcon
	)
)

(procedure (proc0_4 param1)
	(if
		(or
			(User sel_311:)
			(and argc (!= param1 gTheCursor))
			(and (not argc) (== gTheCursor 981))
		)
		(User sel_319: 0 sel_321: 0)
		(if (not (HaveMouse))
			(if (and (!= gTheCursor 20) (!= gTheCursor 981))
				(= global183 (mouseCursor sel_1:))
				(= global184 (mouseCursor sel_0:))
				(= global182 gTheCursor)
			)
			(gGame sel_191: (if argc param1 else 20) 1 319 199)
		else
			(gGame sel_191: (if argc param1 else 20) 1)
		)
	)
)

(procedure (proc0_3)
	(if (not (User sel_311:))
		(User sel_319: 1 sel_321: 1)
		(if (not (HaveMouse))
			(gGame sel_191: global182 1 global183 global184)
		else
			(gGame sel_191: global182)
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

(procedure (proc0_7 param1) ; UNUSED
	(User sel_319: 0 sel_321: 1)
	(if argc
		(SetCursor param1 0 0)
	)
)

(class ColorBorderWindow of BorderWindow
	(properties
		sel_20 {ColorBorderWindow}
	)

	(method (sel_183)
		(= sel_337 (+ sel_26 2))
		(= sel_338 (+ sel_26 1))
		(= sel_339 (- sel_26 1))
		(= sel_340 (- sel_26 2))
		(if global294
			(= sel_337 global378)
			(= sel_338 global379)
			(= sel_339 global381)
			(= sel_340 global380)
			(= sel_26 global382)
			(= sel_25 global375)
		)
		(super sel_183: &rest)
	)
)

(class KMRect of Obj
	(properties
		sel_20 {KMRect}
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)

	(method (sel_438)
		((KeyMouse sel_414:) sel_81: self)
	)
)

(class KMView of View
	(properties
		sel_20 {KMView}
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)

	(method (sel_438)
		((KeyMouse sel_414:) sel_81: self)
	)
)

(class KMActor of Actor
	(properties
		sel_20 {KMActor}
		sel_223 3
		sel_53 3
	)

	(method (sel_437)
		((KeyMouse sel_414:) sel_118: self)
	)

	(method (sel_438)
		((KeyMouse sel_414:) sel_81: self)
	)
)

(class Character of View
	(properties
		sel_20 {Character}
		sel_3 1
		sel_60 6
		sel_439 0
		sel_440 0
		sel_441 0
		sel_442 30
		sel_138 0
	)

	(method (sel_110)
		(self
			sel_165: sel_3
			sel_4: 0
			sel_282: sel_1 sel_0
			sel_63: sel_60
			sel_287:
			sel_283:
		)
		(super sel_110:)
	)

	(method (sel_159 param1)
		(if (and sel_441 (!= self param1))
			(sel_439 sel_153: 0 sel_102:)
		)
	)

	(method (sel_443 param1 param2)
		(= global108 0)
		(if sel_441
			(sel_440
				sel_142: (if (>= argc 2) param2 else 0)
				sel_140:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast sel_118: sel_439)
			(sel_439 sel_285: sel_3: 2 sel_145: sel_440 sel_110:)
		)
	)

	(method (sel_444 param1 param2)
		(= global108 0)
		(if sel_441
			(sel_440
				sel_142: (if (>= argc 2) param2 else 0)
				sel_140:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast sel_118: sel_439)
			(sel_439 sel_285: sel_3: 3 sel_145: sel_440 sel_110:)
		)
	)

	(method (sel_445 param1 param2)
		(= global108 0)
		(if sel_441
			(sel_440
				sel_142: (if (>= argc 2) param2 else 0)
				sel_140:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(gAbsoluteCast sel_118: sel_439)
			(sel_439 sel_285: sel_3: 4 sel_145: sel_440 sel_110:)
		)
	)

	(method (sel_282)
		(super sel_282: &rest)
		(sel_439 sel_282: sel_1 sel_0)
	)

	(method (sel_446 param1 param2 param3 param4 &tmp temp0 [temp1 500] temp501 temp502 temp503 temp504 temp505)
		(sel_439 sel_145: 0)
		(if (and (<= 100 global187 500) (not (mod global187 100)))
			(cond
				((u< param1 100)
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
				)
				((u< param1 1000)
					(if (>= argc 4)
						(= global108 [param3 1])
					)
					(if (>= argc 5)
						(cond
							((== [param4 1] -32768)
								(= temp504 1)
							)
							([param4 1]
								(= temp505 [param4 1])
								(= temp504 0)
							)
							(else
								(= temp505 5)
								(= temp504 0)
							)
						)
					)
				)
			)
			(if (and (not temp504) (Random 0 temp505))
				(= global108 0)
			)
			(cond
				((u< param1 100)
					(if sel_441
						(= temp501 (+ (* 1000 (+ sel_2 1)) global187))
						(= temp502 param1)
					else
						(= temp501 (+ 19000 global187))
						(= temp502 (/ param1 3))
					)
					(GetFarText temp501 temp502 @temp1)
					(= param1 (Format @global550 0 0 @temp1)) ; "%s"
					(= temp503 (if (> argc 1) param2 else 0))
				)
				((u< param1 1000)
					(GetFarText [param1 0] [param1 1] @temp1)
					(= param1 (Format @global550 0 0 @temp1)) ; "%s"
					(= temp503 (if (> argc 2) [param1 2] else 0))
				)
			)
			(cond
				(sel_441
					(if global83
						(self sel_448: (+ temp501 temp502))
					else
						(self sel_447: param1)
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

	(method (sel_447 param1 &tmp [temp0 500] [temp500 4] temp504)
		(= temp504 (Format @temp0 param1))
		(self sel_449: (StrLen @temp0))
		(sel_439 sel_3: 0 sel_198: sel_285: sel_153: RandCycle sel_110:)
		(theTalker sel_125:)
		(theTalker sel_118: sel_439)
		(SpeakWindow sel_430: self)
		(TextSize @[temp500 0] temp504 gUserFont 0)
		(Characters sel_119: 159 self)
		(proc0_1)
		(if (< [temp500 3] 60)
			(Print @temp0 32 SpeakWindow 22 sel_442 182 talkCode 67 80 27 1)
		else
			(Print @temp0 32 SpeakWindow 22 sel_442 182 talkCode)
		)
		(theTalker sel_81: sel_439)
		(if global108
			(self global108:)
		else
			(sel_439 sel_153: 0 sel_102: sel_283:)
		)
	)

	(method (sel_448 param1 &tmp temp0)
		(= temp0 param1)
		(= sel_138 (DoAudio audWPLAY temp0))
		(gAbsoluteCast sel_118: sel_439)
		(sel_439
			sel_3: 0
			sel_198:
			sel_285:
			sel_153: Unknown_Class_33 0 temp0
			sel_110:
		)
		(Unknown_Class_8 sel_155: self sel_138)
		(DoAudio audPLAY temp0)
	)

	(method (sel_449 param1)
		(if (< param1 1)
			(= param1 1)
		)
		(= sel_442 (+ (/ param1 20) (/ global199 2) 1))
		(if (== global199 15)
			(= sel_442 30000)
		)
	)

	(method (sel_144)
		(gAbsoluteCast sel_81: sel_439)
		(if (and global83 global108)
			(self global108:)
		)
	)
)

(class Characters of List
	(properties
		sel_20 {Characters}
	)

	(method (sel_110 &tmp temp0)
		(for ((= temp0 0)) (< temp0 sel_86) ((++ temp0))
			(if ((self sel_64: temp0) sel_441:)
				(((self sel_64: temp0) sel_439:)
					sel_110:
					sel_102:
					sel_63: (((self sel_64: temp0) sel_439:) sel_60:)
				)
			)
		)
	)

	(method (sel_444)
		(self sel_119: 444)
	)

	(method (sel_443)
		(self sel_119: 443)
	)

	(method (sel_445)
		(self sel_119: 445)
	)

	(method (sel_446 &tmp temp0 temp1 temp2 temp3)
		(switch
			(= temp0
				(+
					(= temp0
						(+
							(= temp0
								(+
									(= temp0 0)
									((= temp1 (self sel_64: 0)) sel_441:)
								)
							)
							((= temp2 (self sel_64: 1)) sel_441:)
						)
					)
					((= temp3 (self sel_64: 2)) sel_441:)
				)
			)
			(2
				(switch (Random 0 1)
					(0
						(temp1 sel_446: &rest)
					)
					(1
						(temp2 sel_446: &rest)
					)
				)
			)
			(3
				(switch (Random 0 2)
					(0
						(temp1 sel_446: &rest)
					)
					(1
						(temp2 sel_446: &rest)
					)
					(2
						(temp3 sel_446: &rest)
					)
				)
			)
			(else
				(temp1 sel_446: &rest)
			)
		)
	)
)

(instance theTalker of Set
	(properties
		sel_20 {theTalker}
	)
)

(instance talkCode of Code
	(properties
		sel_20 {talkCode}
	)

	(method (sel_57)
		(if (theTalker sel_86:)
			(Animate (theTalker sel_24:) 1)
		)
	)
)

(instance char1 of Character
	(properties
		sel_20 {char1}
	)
)

(instance char2 of Character
	(properties
		sel_20 {char2}
	)
)

(instance char3 of Character
	(properties
		sel_20 {char3}
	)
)

(instance face1 of Prop
	(properties
		sel_20 {face1}
		sel_60 7
	)
)

(instance face2 of Prop
	(properties
		sel_20 {face2}
		sel_60 7
	)
)

(instance face3 of Prop
	(properties
		sel_20 {face3}
		sel_60 7
	)
)

(instance charScript1 of Script
	(properties
		sel_20 {charScript1}
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(sel_42 sel_4: 0 sel_198: sel_153: End self)
			)
			(1
				(= sel_138 sel_140)
			)
			(2
				(= temp0 sel_42)
				(sel_42 sel_145: 0 sel_102: sel_283:)
				(if sel_142
					(sel_142 sel_144:)
				)
				(proc0_1)
			)
		)
	)
)

(instance charScript2 of Script
	(properties
		sel_20 {charScript2}
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(sel_42 sel_4: 0 sel_198: sel_153: End self)
			)
			(1
				(= sel_138 sel_140)
			)
			(2
				(= temp0 sel_42)
				(sel_42 sel_145: 0 sel_102: sel_283:)
				(if sel_142
					(sel_142 sel_144:)
				)
				(proc0_1)
			)
		)
	)
)

(instance charScript3 of Script
	(properties
		sel_20 {charScript3}
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(sel_42 sel_4: 0 sel_198: sel_153: End self)
			)
			(1
				(= sel_138 sel_140)
			)
			(2
				(= temp0 sel_42)
				(sel_42 sel_145: 0 sel_102: sel_283:)
				(if sel_142
					(sel_142 sel_144:)
				)
				(proc0_1)
			)
		)
	)
)

(instance hoyle3 of Game
	(properties
		sel_20 {hoyle3}
	)

	(method (sel_110 &tmp temp0)
		(= gTheCursor 982)
		(= global183 319)
		(= global184 199)
		(= gHowFast 2)
		(proc0_4)
		(localproc_1)
		(= gEatMice (= gSpeed 0))
		(= gSystemWindow ColorBorderWindow)
		(gSystemWindow sel_25: 0 sel_26: 53)
		(= gDoAbsCode doAbsCode)
		(= gUseSortedFeatures 1)
		(User sel_309: (= gEgo Ego))
		(= gLooperDir8 looperDir8)
		((= gTheInputList theInputList) sel_118:)
		((= gAbsoluteCast absoluteCast) sel_118:)
		((= gKeyDownHandler hoyle3keyDown) sel_118:)
		((= gMouseDownHandler hoyle3MouseDown) sel_118:)
		((= gDirectionHandler hoyle3Direction) sel_118:)
		((= gTheKeyMouseList theKeyMouseList) sel_118:)
		(= gMouseCursor mouseCursor)
		(mouseCursor sel_1: 319)
		(mouseCursor sel_0: 199)
		(version sel_57:)
		(= gVersion @global541)
		((= gGame_opt game_opt) sel_57: 2)
		(gKeyDownHandler sel_118: self)
		(gMouseDownHandler sel_118: self)
		(KeyMouse sel_110: sel_423: gTheKeyMouseList)
		(super sel_110:)
		DItem
		(Load rsVIEW 700)
		(Load rsVIEW 701)
		(Load rsVIEW 980)
		(ScriptID 700 1) ; hoyle3GameControls
		GameControls
		IconBar
		(Load rsVIEW 997)
		(Lock rsVIEW 997)
		(Characters sel_118:)
		(theTalker sel_118:)
		(localproc_0)
		(proc700_0)
		((ScriptID 12 5) sel_57:) ; setHelpStrings
		(proc0_3)
		(Characters
			sel_118: (= gChar1 char1) (= gChar2 char2) (= gChar3 char3)
		)
		(gChar1 sel_439: face1 sel_440: charScript1)
		(gChar2 sel_439: face2 sel_440: charScript2)
		(gChar3 sel_439: face3 sel_440: charScript3)
		(= gSong song)
		(= gSound sound)
		(= gSound2 sound2)
		(gSong sel_158: gGame sel_110:)
		(gSong sel_63: 1)
		(sound sel_63: 2)
		(sound2 sel_63: 3)
		(gTheIconBar sel_205:)
		(self sel_358: 900)
	)

	(method (sel_191 param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (IsObject param1)
			(= gTheCursor param1)
			(param1 sel_110:)
		else
			(= gTheCursor param1)
			(SetCursor param1 0 0)
		)
		(if (> argc 1)
			(if (not param2)
				(SetCursor 979 0 0)
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

	(method (sel_132 param1)
		(super sel_132: param1)
		(param1 sel_148:)
		(mouseCursor sel_1: (param1 sel_1:) sel_0: (param1 sel_0:))
	)

	(method (sel_100 &tmp [temp0 5] [temp5 5])
		(if (Print 0 1 78 (Format @temp0 99 6) 1 78 (Format @temp5 99 7) 0) ; "Quit King Graham?", "Yes", "No"
			(super sel_100:)
		)
	)

	(method (sel_358)
		(gAbsoluteCast sel_125:)
		(gGame sel_191: 20 1)
		(proc0_5)
		(super sel_358: &rest)
	)

	(method (sel_359 param1)
		(if (> (MemoryInfo 1) (+ (MemoryInfo 0) 20)) ; FreeHeap, LargestPtr
			(Palette palSET_INTENSITY 0 255 100)
			(if (Print 0 2 78 {Who Cares} 0 78 {SetDebug} 1) ; "Memory Fragmented"
				(SetDebug)
			)
			(Palette palSET_INTENSITY 0 255 100)
		)
		(gRegions sel_128: (= gCurRoom (ScriptID param1)))
		(gCurRoom sel_110:)
		(if global538
			(= global538 0)
			(gGame
				sel_191: gNormalCursor 1 (mouseCursor sel_1:) (mouseCursor sel_0:)
			)
		else
			(gGame sel_191: gNormalCursor 1)
		)
	)
)

(instance hoyle3MouseDown of EventHandler
	(properties
		sel_20 {hoyle3MouseDown}
	)

	(method (sel_132 param1)
		(mouseCursor sel_1: (param1 sel_1:) sel_0: (param1 sel_0:))
		(super sel_132: param1)
		(if (and (User sel_311:) (not (param1 sel_73:)) (param1 sel_31:))
			(gCurRoom sel_132: param1)
		)
	)
)

(instance hoyle3keyDown of EventHandler
	(properties
		sel_20 {hoyle3keyDown}
	)

	(method (sel_132 param1)
		(mouseCursor sel_1: (param1 sel_1:) sel_0: (param1 sel_0:))
		(if (and (& (param1 sel_31:) $0004) (== (param1 sel_37:) 4096))
			(param1 sel_73: 1)
			(= gQuit 1)
			(return)
		)
		(super sel_132: param1)
		(if (and (User sel_311:) (not (param1 sel_73:)) (param1 sel_31:))
			(if (and (& (param1 sel_31:) $0004) (== (param1 sel_37:) 27))
				(return)
			)
			(gCurRoom sel_132: param1)
		)
	)
)

(instance hoyle3Direction of EventHandler
	(properties
		sel_20 {hoyle3Direction}
	)

	(method (sel_132 param1)
		(mouseCursor sel_1: (param1 sel_1:) sel_0: (param1 sel_0:))
		(super sel_132: param1)
	)
)

(instance theKeyMouseList of Set
	(properties
		sel_20 {theKeyMouseList}
	)
)

(instance mouseCursor of Actor
	(properties
		sel_20 {mouseCursor}
	)
)

(instance theInputList of EventHandler
	(properties
		sel_20 {theInputList}
	)
)

(instance game_opt of File
	(properties
		sel_20 {game.opt}
	)

	(method (sel_57 param1 &tmp [temp0 20] [temp20 10] temp30 temp31 temp32 temp33)
		(cond
			((and argc (== param1 3))
				(if (self sel_183: 2)
					(self
						sel_328:
							(Format ; "%3d%3d%2d%2d%2d%2d%s%s%s%s"
								@temp0
								0
								3
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
						sel_332:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self sel_183: 1)
				(= global199 (ReadNumber (self sel_327: @temp20 4)))
				(gGame sel_365: (ReadNumber (self sel_327: @temp20 4)))
				(= temp30 (ReadNumber (self sel_327: @temp20 3)))
				(= temp31 (ReadNumber (self sel_327: @temp20 3)))
				(= temp32 (ReadNumber (self sel_327: @temp20 3)))
				(= temp33 (ReadNumber (self sel_327: @temp20 3)))
				(self sel_327: @temp20 (+ temp30 1))
				(StrCpy @global472 @temp20)
				(self sel_327: @temp20 (+ temp31 1))
				(StrCpy @global479 @temp20)
				(self sel_327: @temp20 (+ temp32 1))
				(StrCpy @global486 @temp20)
				(self sel_327: @temp20 (+ temp33 1))
				(StrCpy @global493 @temp20)
				(self sel_332:)
				(return 0)
			)
			(else
				(= global199 6)
				(gGame sel_365: 12)
				(Format @global150 0 4)
				(Format @global157 0 4)
				(Format @global164 0 4)
				(Format @global171 0 4)
				(Format @global472 0 4)
				(Format @global479 0 4)
				(Format @global486 0 4)
				(Format @global493 0 4)
				(return 0)
			)
		)
	)
)

(class TrackingView of KMView
	(properties
		sel_20 {TrackingView}
		sel_450 0
		sel_451 0
		sel_157 0
	)

	(method (sel_132 param1 &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (param1 sel_73:))
				(not (& (param1 sel_31:) $0002))
				(<= sel_7 (param1 sel_1:) (- sel_9 1))
				(<= sel_6 (param1 sel_0:) (- sel_8 1))
			)
			(cond
				((proc0_2 param1)
					(self sel_436:)
					(= temp0 1)
				)
				((& (param1 sel_31:) $0001)
					(= temp0 (self sel_172:))
				)
			)
		)
		(return temp0)
	)

	(method (sel_172 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(self sel_157: sel_14 sel_285:)
		(= sel_4 1)
		((= temp2 (List sel_109:)) sel_118: self)
		(if sel_450
			(if (sel_450 sel_114: Collect)
				(for ((= temp3 0)) (< temp3 (sel_450 sel_86:)) ((++ temp3))
					(temp2 sel_118: (sel_450 sel_64: temp3))
				)
			else
				(temp2 sel_118: sel_450)
			)
		)
		(Animate (temp2 sel_24:) 0)
		(if sel_451
			(sel_451 sel_110: self)
		)
		(while (!= 2 ((= temp1 (Event sel_109:)) sel_31:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= temp4 (self sel_200: temp1))
			(if (!= sel_4 temp4)
				(= sel_4 temp4)
				(if (== (temp2 sel_86:) 1)
					(Animate (temp2 sel_24:) 0)
				)
			)
			(if (> (temp2 sel_86:) 1)
				(Animate (temp2 sel_24:) 0)
			)
			(if sel_451
				(sel_451 sel_57: self)
			)
			(temp1 sel_111:)
		)
		(if (== sel_4 1)
			(= temp0 sel_4)
		)
		(= sel_4 0)
		(Animate (temp2 sel_24:) 0)
		(if sel_451
			(sel_451 sel_111: self)
		)
		(temp2 sel_125: sel_111:)
		(temp1 sel_111:)
		(self sel_14: (& sel_157 $fffb) sel_283:)
		(return temp0)
	)

	(method (sel_436 &tmp temp0 temp1)
		(= sel_4 1)
		(self sel_285:)
		((= temp0 (List sel_109:)) sel_118: self)
		(if sel_450
			(if (sel_450 sel_114: Collect)
				(for ((= temp1 0)) (< temp1 (sel_450 sel_86:)) ((++ temp1))
					(temp0 sel_118: (sel_450 sel_64: temp1))
				)
			else
				(temp0 sel_118: sel_450)
			)
		)
		(Animate (temp0 sel_24:) 1)
		(Wait 1)
		(Wait 10)
		(= sel_4 0)
		(Animate (temp0 sel_24:) 1)
		(temp0 sel_125: sel_111:)
		(self sel_283:)
	)
)

(class DragableActor of KMActor
	(properties
		sel_20 {DragableActor}
		sel_452 -1
		sel_453 -1
		sel_454 -1
		sel_418 0
		sel_419 0
		sel_455 0
		sel_456 0
		sel_457 0
		sel_157 0
		sel_458 0
		sel_459 1
		sel_450 0
	)

	(method (sel_132 param1 &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (param1 sel_73:))
				(<= sel_7 (param1 sel_1:) (- sel_9 1))
				(<= sel_6 (param1 sel_0:) (- sel_8 1))
			)
			(cond
				((proc0_2 param1)
					(param1 sel_73: 1)
					(= temp0 1)
				)
				((& (param1 sel_31:) $0001)
					(param1 sel_73: 1)
					(= temp0 1)
				)
			)
		)
		(return temp0)
	)

	(method (sel_460 param1)
		(cond
			((& (param1 sel_31:) $0001)
				(return (self sel_172:))
			)
			((proc0_2 param1)
				(return (self sel_436:))
			)
		)
		(return 0)
	)

	(method (sel_172 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp5 (List sel_109:))
		(if global181
			(global181 sel_461:)
			(temp5 sel_118: global181)
			(Animate (temp5 sel_24:) 0)
			(temp5 sel_125:)
		)
		(if sel_450
			(if (sel_450 sel_114: Collect)
				(for ((= temp8 0)) (< temp8 (sel_450 sel_86:)) ((++ temp8))
					(temp5 sel_118: (sel_450 sel_64: temp8))
				)
			else
				(temp5 sel_118: sel_450)
			)
		)
		(= temp6 sel_60)
		(self sel_63: 15)
		(= temp0 (- sel_1 (gMouseCursor sel_1:)))
		(= temp1 (- sel_0 (gMouseCursor sel_0:)))
		(self sel_463: sel_462:)
		(= global181 self)
		(temp5 sel_118: self)
		(if (gAbsoluteCast sel_86:)
			(for ((= temp8 0)) (< temp8 (gAbsoluteCast sel_86:)) ((++ temp8))
				(temp5 sel_118: (gAbsoluteCast sel_64: temp8))
			)
		)
		(self sel_157: sel_14)
		(Animate (temp5 sel_24:) 0)
		(if sel_458
			(sel_458 sel_110: self)
		)
		(= temp7 1)
		(while (!= 2 ((= temp2 (Event sel_109:)) sel_31:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 sel_1:))
			(= gMouseY (temp2 sel_0:))
			(cond
				(sel_459
					(self
						sel_1: (+ (temp2 sel_1:) temp0)
						sel_0: (+ (temp2 sel_0:) temp1)
					)
				)
				(
					(and
						(<= sel_7 gMouseX (- sel_9 1))
						(<= sel_6 gMouseY (- sel_8 1))
					)
					(= temp7 1)
					(self sel_462: 1)
				)
				(else
					(= temp7 0)
					(self sel_461: 1)
				)
			)
			(if sel_458
				(sel_458 sel_57: self)
			)
			(Animate (temp5 sel_24:) 0)
			(temp2 sel_111:)
		)
		(if sel_459
			(= gMouseX (temp2 sel_1:))
			(= gMouseY (temp2 sel_0:))
		)
		(if sel_458
			(sel_458 sel_111: self)
		)
		(temp2 sel_111:)
		(self sel_63: temp6)
		(self sel_461:)
		(temp5 sel_125: sel_111:)
		(return temp7)
	)

	(method (sel_436)
		(if (and global181 (!= global181 self))
			(global181 sel_461:)
		)
		(if (== global181 self)
			(self sel_461:)
			(= global181 0)
		else
			(self sel_462:)
			(= global181 self)
		)
		(proc0_1)
		(return 2)
	)

	(method (sel_461 param1)
		(if (and (== sel_452 -1) (== sel_453 -1) (== sel_454 -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and
					param1
					(== sel_452 sel_2)
					(== sel_453 sel_3)
					(== sel_454 sel_4)
				)
			)
			(self
				sel_2: sel_455
				sel_3: sel_456
				sel_4: sel_457
				sel_14: sel_157
				sel_284:
			)
		)
	)

	(method (sel_462 param1)
		(if (and (== sel_452 -1) (== sel_453 -1) (== sel_454 -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and
					param1
					(or
						(!= sel_452 sel_2)
						(!= sel_453 sel_3)
						(!= sel_454 sel_4)
					)
				)
			)
			(self sel_463:)
			(if (!= sel_452 -1)
				(self sel_2: sel_452)
			)
			(if (!= sel_453 -1)
				(self sel_3: sel_453)
			)
			(if (!= sel_454 -1)
				(self sel_4: sel_454)
			)
			(self sel_285:)
		)
	)

	(method (sel_463)
		(= sel_418 sel_1)
		(= sel_419 sel_0)
		(= sel_455 sel_2)
		(= sel_456 sel_3)
		(= sel_457 sel_4)
		(= sel_157 sel_14)
	)
)

(instance looperDir8 of Code
	(properties
		sel_20 {looperDir8}
	)

	(method (sel_57 param1 param2)
		(param1
			sel_3:
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
	(properties
		sel_20 {absoluteCast}
	)
)

(instance song of Sound
	(properties
		sel_20 {song}
		sel_99 1
	)

	(method (sel_39 param1 param2 param3)
		(= sel_40 param1)
		(= sel_42 (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super sel_39: param3)
		else
			(super sel_39:)
		)
	)
)

(instance sound of Sound
	(properties
		sel_20 {sound}
		sel_99 1
	)

	(method (sel_39 param1 param2 param3)
		(= sel_40 param1)
		(= sel_42 (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super sel_39: param3)
		else
			(super sel_39:)
		)
	)
)

(instance sound2 of Sound
	(properties
		sel_20 {sound2}
		sel_99 1
	)

	(method (sel_39 param1 param2 param3)
		(= sel_40 param1)
		(= sel_42 (if (>= argc 2) param2 else 0))
		(if (>= argc 3)
			(super sel_39: param3)
		else
			(super sel_39:)
		)
	)
)

(instance doAbsCode of Code
	(properties
		sel_20 {doAbsCode}
	)

	(method (sel_57)
		(proc0_6)
	)
)

(instance version of File
	(properties
		sel_20 {version}
	)

	(method (sel_57)
		(if (self sel_183: 1)
			(self sel_327: @global541 6 sel_332:)
		)
	)
)

