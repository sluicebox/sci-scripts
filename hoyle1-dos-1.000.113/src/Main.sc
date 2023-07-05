;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n888)
(use Tmrs)
(use DisplayBox)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	cardGames 0
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
	gVersion = {1.000.113}
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
	global111 = 9
	global112
	global113 = 6
	global114 = 4
	; 115
	global115 = 6
	global116 = 1
	global117 = 8
	global118 = 4
	global119 = 4
	; 120
	global120
	global121 = 4
	global122
	global123 = 7
	global124 = 6
	; 125
	global125 = 4
	global126 = 2
	global127 = 6
	global128 = 5
	global129 = 6
	; 130
	global130 = 4
	global131 = 6
	global132 = 3
	global133 = 8
	global134 = 5
	; 135
	global135 = 4
	global136 = 1
	global137 = 4
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
	gView
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
	gTwoOfClubsLeads
	gPlayer0
	gPlayer1
	gPlayer2
	gPlayer3
	; 195
	gDeck
	gCardRoom
	global197
	gCommon
	global199
	; 200
	global200
	global201
	global202 = 1
	global203 = 1
	global204 = 1
	; 205
	global205
	global206 = -1
	global207 = -1
	global208 = -1
	global209
	; 210
	global210 = -1
	global211 = -1
	global212
	global213 = 1
	global214 = 1
	; 215
	global215 = 1
	global216
	global217 = -1
	global218 = -2
	global219
	; 220
	global220 = 2
	global221 = -2
	global222
	global223 = 2
	global224 = -2
	; 225
	global225
	global226 = 2
	global227 = 2
	global228 = 2
	global229 = 2
	; 230
	global230
	global231
	global232
	global233 = -2
	global234 = -2
	; 235
	global235 = -2
	global236 = 5
	global237
	gSndEffect
	global239
	; 240
	global240
	global241 = 180
	global242
	global243 = 45
	global244 = 90
	; 245
	global245 = 135
	global246 = 180
	global247 = 225
	global248 = 270
	global249 = 315
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
	gGinRummyCardList
	global267
	global268 = 1
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
	gTheCardToss
	gPlayerList
	gGoneTimer
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
	global312 = 3
	global313 = 1
	global314 = 2
	; 315
	gWL
	gScoreObj
	global317
	global318
	global319
	; 320
	global320
	global321
	gColumn
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
	global405 = 5
	global406 = 5
	global407 = 5
	global408 = 46
	global409 = 37
	; 410
	global410 = 29
	global411 = 24
	global412 = 18
	global413 = 13
	global414 = 9
	; 415
	global415 = 6
	global416 = 4
	global417 = 30
	global418 = 22
	global419 = 15
	; 420
	global420 = 10
	global421 = 8
	global422 = 7
	global423 = 6
	global424 = 5
	; 425
	global425 = 4
	global426
	global427
	global428 = 1
	global429
	; 430
	global430
	gKnownCards
	global432
	global433 = 5
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
	global445 = 1
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
	global500 = 10
	global501 = 11
	global502 = 12
	global503
	global504
	; 505
	gIntroSong
	global506
	global507
	global508
	global509
	; 510
	global510
	global511 = 100
	global512
	global513
	global514 = 3
	; 515
	global515 = 3
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
	global750
	global751
	global752
	global753
	global754
	; 755
	global755
	global756
	global757
	global758
	global759
	; 760
	global760
	global761
	global762
	global763
	global764
	; 765
	global765
	global766
	global767
	global768
	global769
	; 770
	global770
	global771
	global772
	global773
	global774
	; 775
	global775
	global776
	global777
	global778
	global779
	; 780
	global780
	global781
	global782
	global783 = 4
	global784 = -1
	; 785
	global785 = -1
	global786
	global787
	global788
	global789
	; 790
	global790
	global791
	global792
	global793
	global794
	; 795
	global795
	global796
	global797
	global798
	global799
	; 800
	global800
	global801 = 4
	global802
	global803
	global804
	; 805
	global805
	global806 = 110
	global807 = 130
	global808 = 150
	global809 = 170
	; 810
	global810 = 800
	global811 = 820
	global812
	global813 = 230
	global814 = 260
	; 815
	global815 = 280
	global816 = 300
	global817 = 320
	global818 = 340
	global819 = 360
	; 820
	global820 = 380
	global821 = 840
	global822 = 420
	global823 = 440
	global824 = 460
	; 825
	global825 = 480
	global826
	global827 = 1
	global828 = 6
	global829 = 2
	; 830
	global830 = 2
	global831 = 2
	global832 = 6
	global833 = 4
	global834 = 4
	; 835
	global835 = 1
	global836 = 6
	global837 = 4
	global838 = 2
	global839 = 4
	; 840
	global840 = 4
	global841 = 4
	global842 = 6
	global843 = 2
	global844 = 2
	; 845
	global845 = 4
	global846 = 4
	global847 = 2
	global848 = 6
	global849 = 4
	; 850
	global850 = 4
	global851 = 4
	global852 = 6
	global853 = 4
	global854
	; 855
	global855
	global856
	global857
	global858
	global859
	; 860
	global860
	global861
	global862
	global863
	global864
	; 865
	global865
	global866
	global867
	global868
	global869
	; 870
	global870
	global871
	global872
	global873
	global874
	; 875
	global875
	global876
	global877
	global878
	global879
	; 880
	global880
	global881 = 511
	global882 = 501
	global883 = 521
	global884 = 541
	; 885
	global885 = 551
	global886 = 561
	global887
	global888 = 581
	global889 = 591
	; 890
	global890 = 601
	global891 = 611
	global892 = 621
	global893 = 631
	global894 = 641
	; 895
	global895 = 651
	global896 = 661
	global897 = 671
	global898 = 681
	global899 = 691
	; 900
	global900
)

(procedure (proc0_6 param1)
	(if (> (DoSound sndCHECK_DRIVER) 3)
		(return param1)
	else
		(return (if (<= 100 param1 102) 212 else 213))
	)
)

(procedure (proc0_2 param1 param2 param3 param4 param5 param6)
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

(procedure (proc0_3 param1 param2 &tmp temp0)
	(if (== argc 1)
		(= param2 0)
	)
	(repeat
		(breakif (!= (= temp0 (Random 1 3)) global184))
	)
	(switch temp0
		(1
			(((if (gPlayer1 sittingOut:)
						(if (gPlayer2 sittingOut:) gPlayer3 else gPlayer2)
					else
						gPlayer1
					)
					altrEgo:
				)
				say: param1 param2
			)
		)
		(2
			(((if (gPlayer2 sittingOut:)
						(if (gPlayer3 sittingOut:) gPlayer1 else gPlayer3)
					else
						gPlayer2
					)
					altrEgo:
				)
				say: param1 param2
			)
		)
		(3
			(((if (gPlayer3 sittingOut:)
						(if (gPlayer1 sittingOut:) gPlayer2 else gPlayer1)
					else
						gPlayer3
					)
					altrEgo:
				)
				say: param1 param2
			)
		)
	)
)

(procedure (proc0_4 param1 param2)
	(if (and (not (gPlayer1 sittingOut:)) (!= param2 1) (Random 0 1))
		((gPlayer1 altrEgo:) delay: 1 param1: 1)
	)
	(if (and (not (gPlayer2 sittingOut:)) (!= param2 2) (Random 0 1))
		((gPlayer2 altrEgo:) delay: 1 param1: 1)
	)
	(if (and (not (gPlayer3 sittingOut:)) (!= param2 3) (Random 0 1))
		((gPlayer3 altrEgo:) delay: 1 param1: 1)
	)
)

(procedure (proc0_5)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_1 param1 &tmp temp0 temp1)
	(if (<= param1 0)
		(return)
	)
	(for ((= temp0 0)) (< temp0 (/ param1 6)) ((++ temp0))
		(Wait 6)
		(= temp1 (Event new:))
		(MenuBar handleEvent: temp1)
		(if
			(and
				(or
					(== (temp1 type:) evMOUSERELEASE)
					(and
						(== (temp1 type:) evKEYBOARD)
						(or
							(== (temp1 message:) KEY_RETURN)
							(== (temp1 message:) KEY_INSERT)
						)
					)
				)
				(>= (temp1 y:) 10)
			)
			(temp1 dispose:)
			(break)
		)
		(temp1 dispose:)
		(if gQuit
			(break)
		)
		(if (and (IsObject gPlayer1) (not (gPlayer1 sittingOut:)))
			((gPlayer1 altrEgo:) doit:)
		)
		(if (and (IsObject gPlayer2) (not (gPlayer2 sittingOut:)))
			((gPlayer2 altrEgo:) doit:)
		)
		(if (and (IsObject gPlayer3) (not (gPlayer3 sittingOut:)))
			((gPlayer3 altrEgo:) doit:)
		)
		(proc0_5)
	)
)

(procedure (proc0_7 param1 param2 &tmp temp0 temp1)
	(-= argc 2)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= temp1 [param2 temp0])
		(if param1
			(Load param1 temp1)
		)
	)
)

(procedure (proc0_8 &tmp temp0)
	(= temp0 (+ (* global407 5) 15))
	(gGoneTimer setSeconds: temp0)
)

(instance cardGames of Game
	(properties)

	(method (init &tmp temp0)
		(Format @global520 0 0)
		(= gVersion {1.000.113})
		(= gSpeed 1)
		(= temp0 (ScriptID 897)) ; myGauge
		(= temp0 Person)
		(= temp0 255)
		(= gSysWindow sysWindow)
		(super init:)
		(User alterEgo: (= gEgo ego))
		(MenuBar init:)
		(self setSpeed: (= gUserFont 0))
		(= global300 (proc899_0))
		(= gGoneTimer goneTimer)
		(= gTheCardToss theCardToss)
		(= gPlayerList playerList)
		(= gIntroSong introSong)
		(= gSndEffect sndEffect)
		(gIntroSong stop: init:)
		(gSndEffect init:)
		(self newRoom: (if (GameIsRestarting) 101 else 900))
	)
)

(instance sysWindow of SysWindow
	(properties
		color 4
		back 14
	)
)

(instance introSong of Sound
	(properties
		number 10
		loop -1
		owner -1
	)
)

(instance sndEffect of Sound
	(properties
		number 100
		owner -1
	)
)

(instance ego of View
	(properties)
)

(class c
	(properties
		cardRank 0
		cardSuit 0
		x 0
		y 0
		loop 0
		erase 0
		faceUp 0
		rating 0
		cursorX 0
		cursorY 0
	)
)

(class GO of Obj
	(properties
		onOrOff 0
		status0 0
		x 0
		y 0
		view 0
		state 0
		caller 0
		special 0
		cursorX 0
		cursorY 0
		cursorZ 0
	)

	(method (cue))
)

(class WL of List
	(properties)

	(method (empty param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else self))
		(for ((= temp0 (- (temp1 size:) 1))) (>= temp0 0) ((-- temp0))
			(temp1 delete: (temp1 at: temp0))
		)
	)

	(method (addAllToWorkingDeck &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((gDeck workingDeck:) add: (self at: temp0))
		)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) cardRank:) param1)
					(== ((self at: temp0) cardSuit:) param2)
				)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class CardList of WL
	(properties)

	(method (setSize)
		(= global309 (- (= global308 (self size:)) 1))
	)
)

(class CardDeck of WL
	(properties
		theDeck 0
		workingDeck 0
		dealX 0
		dealY 0
		discardX -40
		discardY -40
		cursorX 0
		cursorY 0
	)

	(method (resetDealXY))

	(method (init &tmp temp0)
		(= theDeck tDeck)
		(= workingDeck wDeck)
		(wDeck add:)
		(tDeck add:)
		(self dealFrom:)
	)

	(method (reShuffle &tmp temp0)
		(= temp0 (workingDeck size:))
		(for ((= global264 0)) (< global264 temp0) ((++ global264))
			((workingDeck at: 0) rating: 0)
			(theDeck add: (workingDeck at: 0))
			(workingDeck delete: (workingDeck at: 0))
		)
		(self shuffle:)
	)

	(method (shuffle &tmp temp0 temp1)
		(for ((= temp1 0)) (< temp1 2) ((++ temp1))
			(while (>= (- (theDeck size:) 1) 0)
				(= temp0 (Random 0 (- (theDeck size:) 1)))
				(workingDeck add: (theDeck at: temp0))
				(theDeck delete: (theDeck at: temp0))
			)
			(while (>= (- (workingDeck size:) 1) 0)
				(= temp0 (Random 0 (- (workingDeck size:) 1)))
				(theDeck add: (workingDeck at: temp0))
				(workingDeck delete: (workingDeck at: temp0))
			)
		)
	)

	(method (aCardToGet)
		(theDeck size:)
	)

	(method (getCard)
		(= global173 (theDeck at: 0))
		(theDeck delete: (theDeck at: 0))
	)

	(method (dealFrom)
		(= dealX ((playerList at: 0) dealFromX:))
		(= dealY ((playerList at: 0) dealFromY:))
	)

	(method (plotCard param1 param2 &tmp temp0 temp1)
		(if (and param2 (!= param2 5))
			(= temp0 100)
		else
			(= temp0 0)
		)
		(if (or (== global184 1) (== global184 3))
			(= temp1 2)
		else
			(= temp1 0)
		)
		(if (and (== gCurRoomNum 1) (== param1 (gDeck upCardView:)))
			(= temp1 0)
		)
		(proc0_2
			(cond
				((param1 erase:) 161)
				((not (param1 faceUp:))
					(+ 290 global507)
				)
				(else
					(+
						(- (- 352 temp0) (* (!= gCurRoomNum 2) 200))
						(param1 cardSuit:)
					)
				)
			)
			(if (param1 erase:)
				(if (or (== (param1 erase:) 4) (== param2 5))
					2
				else
					(not temp1)
				)
			else
				(switch param2
					(0
						(param1 loop:)
					)
					(1
						(if (param1 faceUp:)
							(+ (param1 loop:) temp1)
						else
							(+ (param1 loop:) 2 temp1)
						)
					)
					(2
						(cond
							((param1 faceUp:)
								(if temp1 5 else 4)
							)
							(temp1 7)
							(else 6)
						)
					)
				)
			)
			(cond
				((param1 erase:) 0)
				((not (param1 faceUp:)) 0)
				(else
					(param1 cardRank:)
				)
			)
			(if temp1
				(param1 x:)
			else
				(switch param2
					(0
						(if (param1 erase:)
							(+ (param1 x:) 28)
						else
							(param1 x:)
						)
					)
					(2
						(+ (param1 x:) 7)
					)
					(3
						(+ (param1 x:) 28)
					)
					(else
						(param1 x:)
					)
				)
			)
			(if (not temp1)
				(param1 y:)
			else
				(switch param2
					(0
						(if (param1 erase:)
							(+ (param1 y:) 36)
						else
							(param1 y:)
						)
					)
					(2
						(+ (param1 y:) 7)
					)
					(3
						(+ (param1 y:) 36)
					)
					(else
						(param1 y:)
					)
				)
			)
		)
		(if (>= (param1 erase:) 3)
			(workingDeck add: param1)
		)
		(param1 erase: 0)
	)

	(method (setUpCardView))

	(method (showDeck))

	(method (turnUpCard))
)

(class Player of Obj
	(properties
		playerNum 0
		dealFromX 160
		dealFromY 100
		overlapX 7
		overlapY 7
		baseX 160
		baseY 95
		showDeckX 160
		showDeckY 100
		dealFaceUp 0
		bX 0
		bX2 0
		bY 0
		sittingOut 0
		cardList 0
		tempList 0
		place 0
		place1 0
		place2 0
		pickedUpCard 0
		tmpx 0
		tmpy 0
		oneLessCard 0
		oldCardListSize 99
		gamePoints 0
		speakFrom 0
		altrEgo 0
		portraitPri 14
		takeCardSound 100
		playCardSound 103
		skill 0
	)

	(method (updateCursorCoords &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(= temp1 (cardList at: temp0))
			(temp1
				cursorX: (+ (temp1 x:) (if (!= playerNum 3) 3 else 17))
				cursorY: (+ (temp1 y:) (if (!= playerNum 3) 27 else 3))
			)
		)
	)

	(method (preInit))

	(method (mvCard))

	(method (init)
		(if playerNum
			(= sittingOut (not [global500 (- playerNum 1)]))
		)
		(= pickedUpCard 0)
	)

	(method (reDrawHand)
		(cardList setSize:)
		(if global308
			(if (> oldCardListSize global308)
				(self eraseHand:)
			)
			(for ((= global264 0)) (< global264 global308) ((++ global264))
				(if (not ((cardList at: global264) erase:))
					(if
						(and
							(< (+ global264 1) global308)
							(not ((cardList at: (+ global264 1)) erase:))
						)
						(self plotCard: (cardList at: global264) 1)
					else
						(self plotCard: (cardList at: global264) (self isLast:))
					)
				)
			)
		)
		(= oldCardListSize global308)
		(if
			(or
				(not playerNum)
				(and
					(== gCurRoomNum 2)
					(== playerNum ((gPlayer0 playFromID:) playerNum:))
				)
			)
			(self updateCursorCoords:)
		)
	)

	(method (removeCard)
		(for ((= global264 0)) (< global264 (cardList size:)) ((++ global264))
			(if ((cardList at: global264) erase:)
				(cond
					((and (not global264) (!= global264 (- (cardList size:) 1)))
						(self plotCard: (cardList at: global264) 1)
					)
					((== global264 (- (cardList size:) 1))
						(self plotCard: (cardList at: global264) (self isLast:))
						(if (> global264 0)
							(self plotCard: (cardList at: (- global264 1)) 0)
						)
					)
					(else
						(self plotCard: (cardList at: (- global264 1)) 2)
					)
				)
			)
		)
	)

	(method (eraseHand)
		(if (cardList size:)
			(if (or (== playerNum 2) (not playerNum))
				(self drawBlank: (- ((cardList at: 0) x:) 7) baseY 1)
				(self
					drawBlank:
						(+ ((cardList at: (- (cardList size:) 1)) x:) 35)
						baseY
						1
				)
			else
				(self drawBlank: baseX (- ((cardList at: 0) y:) 7) 0)
				(self
					drawBlank:
						baseX
						(+ ((cardList at: (- (cardList size:) 1)) y:) 43)
						0
				)
			)
		)
	)

	(method (drawBlank param1 param2 param3)
		(proc0_2 161 param3 0 param1 param2)
	)

	(method (adjustLists param1 param2)
		(if (== param1 0)
			(tempList add: (cardList at: (- param2 1)))
		)
		(for ((= global264 0)) (< global264 (cardList size:)) ((++ global264))
			(if (!= global264 (- param2 1))
				(tempList add: (cardList at: global264))
				(if (== global264 (- param1 1))
					(tempList add: (cardList at: (- param2 1)))
				)
			)
		)
		(cardList empty:)
		(for ((= global264 0)) (< global264 (tempList size:)) ((++ global264))
			(cardList add: (tempList at: global264))
		)
		(tempList empty:)
	)

	(method (addCard)
		(if (not sittingOut)
			(global173 x: global182 y: global183)
			(cardList add: global173)
			(= oldCardListSize (cardList size:))
			(if
				(or
					(not playerNum)
					(and
						(== gCurRoomNum 2)
						(== playerNum ((gPlayer0 playFromID:) playerNum:))
					)
				)
				(global517 add: global173)
			)
		)
	)

	(method (playCard param1)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(= global173 param1)
		(= place 92)
		(= tmpx (param1 x:))
		(= tmpy (param1 y:))
		(param1 erase: 1 loop: 0)
		(self removeCard:)
		(if (== gCurRoomNum 3)
			(self mvCard:)
		else
			(gTheCardToss
				init:
					tmpx
					tmpy
					(gDeck discardX:)
					(gDeck discardY:)
					[global417 (- global406 1)]
			)
		)
	)

	(method (afterThrow)
		(if pickedUpCard
			(return)
		)
		(if (== place 91)
			(global173 x: global182 y: global183)
			(self addCard: rePosition: cue:)
			(return)
		)
		(if (or (== place 92) (== place 97))
			(self transferCard:)
			(if (not (cardList size:))
				(= global181 1)
			)
			(if (== place 97)
				(global173 faceUp: 1 erase: 0)
				(self showRealCard:)
			)
			(proc0_5)
			(self rePosition:)
		else
			(self showRealCard:)
		)
		(self cue:)
	)

	(method (showRealCard)
		(global173 x: global182 y: global183)
		(self plotCard: global173 5)
	)

	(method (setbXbY param1 param2)
		(if (or (== playerNum 0) (== playerNum 2))
			(= bX (+ 35 (* (- param2 1) overlapX)))
			(= bX (- baseX (/ bX 2)))
			(+= bX (* param1 overlapX))
			(= bY baseY)
		else
			(= bY (+ 43 (* (- param2 1) overlapY)))
			(= bY (- baseY (/ bY 2)))
			(+= bY (* param1 overlapY))
			(= bX baseX)
		)
	)

	(method (rePosition)
		(for ((= global264 0)) (< global264 (cardList size:)) ((++ global264))
			(self setbXbY: global264 (cardList size:))
			((cardList at: global264) erase: 0)
			((cardList at: global264) x: bX)
			((cardList at: global264) y: bY)
		)
		(self reDrawHand:)
	)

	(method (setBase)
		(if global185
			(self setbXbY: (cardList size:) (+ (cardList size:) 1))
		else
			(self setbXbY: (cardList size:) (- global174 oneLessCard))
		)
	)

	(method (flipCards)
		(++ global186)
		(if sittingOut
			(return)
		)
		(= global184 playerNum)
		(if (and (not dealFaceUp) (cardList size:))
			(for
				((= global264 0))
				(< global264 (cardList size:))
				((++ global264))
				
				((cardList at: global264) faceUp: 1)
			)
			(self reDrawHand:)
		)
	)

	(method (giveUpCards)
		(= oldCardListSize 99)
		(if sittingOut
			(return)
		)
		(if (cardList size:)
			(= global184 playerNum)
			(for
				((= global264 0))
				(< global264 (cardList size:))
				((++ global264))
				
				((cardList at: global264) erase: 4)
				(self plotCard: (cardList at: global264) 5)
			)
			(cardList empty:)
		)
	)

	(method (invertCard param1)
		((cardList at: param1) loop: (^ ((cardList at: param1) loop:) $0001))
		(self
			plotCard:
				(cardList at: param1)
				(if (== param1 (- (cardList size:) 1)) 0 else 1)
		)
	)

	(method (plotCard param1 param2)
		(= global184 playerNum)
		(gDeck plotCard: param1 param2)
	)

	(method (transferCard)
		(cardList delete: global173)
	)

	(method (cue)
		(gCardRoom cue:)
	)

	(method (isLast)
		(return (if (== (cardList size:) 1) 5 else 0))
	)

	(method (takeTurn))

	(method (takeCard))
)

(class HumanPlayer of Player
	(properties
		dealFromY 220
		overlapY 0
		baseY 143
		dealFaceUp 1
		input 0
		evtX 0
		evtY 0
		nsL 0
		nsR 0
		nsT 0
		nsB 0
		numClicks 0
		down 0
		type 0
		ignoreNextInput 0
	)

	(method (playerSeemsToBeGone)
		(if global774
			(goneTimer setSeconds: (Random 7 9))
			(switch (proc888_0)
				(0
					((gPlayer1 altrEgo:) say: 0)
				)
				(1
					((gPlayer2 altrEgo:) say: 0)
				)
				(2
					((gPlayer3 altrEgo:) say: 0)
				)
			)
		else
			(proc0_8)
		)
	)

	(method (handleEvent event &tmp temp0)
		(event claimed: 1)
		(= global321 event)
		(= evtX (event x:))
		(= evtY (event y:))
		(if
			(or
				(== global855 1)
				(== global855 2)
				(and
					(== global855 4)
					(or (== global854 13) (== global854 20992))
				)
			)
			(= input global855)
		)
		(if
			(and
				(or (== global855 2) (and (== global855 4) (== global854 13)))
				(global300 windowUp:)
			)
			(global300 dispose:)
			(= input 0)
		)
		(if global855
			(DisposeScript 888)
		)
	)

	(method (handleInput))

	(method (takeTurn)
		(if sittingOut
			(self cue:)
			(return)
		)
		(if (and input global180)
			(if (and (!= gCurRoomNum 2) (== input 1))
				(= input 0)
				(= global179 1)
				(self cue:)
			else
				(proc0_8)
				(= global180 0)
				(= global184 playerNum)
				(self handleInput:)
			)
		else
			(if (goneTimer done:)
				(self playerSeemsToBeGone:)
			)
			(= global179 1)
			(self cue:)
		)
	)

	(method (inRect)
		(return (and (>= evtX nsL) (<= evtX nsR) (>= evtY nsT) (<= evtY nsB)))
	)

	(method (findRect &tmp temp0)
		(if (== place -1)
			(= temp0 overlapX)
			(for
				((= global264 0))
				(< global264 (cardList size:))
				((++ global264))
				
				(self
					setNS:
						((cardList at: global264) x:)
						((cardList at: global264) y:)
				)
				(if (!= global264 (- (cardList size:) 1))
					(= nsR (+ nsL temp0))
				)
				(if (self inRect:)
					(= place (+ global264 1))
					(return)
				)
			)
			(self
				setNS: (- ((cardList at: 0) x:) overlapX) ((cardList at: 0) y:)
			)
			(if (self inRect:)
				(= place 0)
			)
		)
	)

	(method (setNS param1 param2)
		(= nsR (+ (= nsL param1) 35))
		(= nsB (+ (= nsT param2) 43))
	)
)

(class CardRoom of Rm
	(properties
		picture 11
		numPlayers 4
		numActivePlayers 0
		currentPlayer 0
		lastPlayer 0
		state 0
		passDir 0
		counter 0
		winner 0
	)

	(method (init &tmp temp0)
		(if (< gCurRoomNum 7)
			(gIntroSong fade:)
		)
		(Load rsVIEW 161)
		(Load rsVIEW 700)
		(Load rsVIEW (+ 290 global507))
		(Load rsFONT 3)
		(if (< gCurRoomNum 7)
			(if global500
				(Load rsVIEW global500)
				(gPlayer1 altrEgo: (ScriptID [global880 global500]))
			)
			(Load rsVIEW global501)
			(gPlayer2 altrEgo: (ScriptID [global880 global501]))
			(if global502
				(Load rsVIEW global502)
				(gPlayer3 altrEgo: (ScriptID [global880 global502]))
			)
		)
		(= temp0 (ScriptID 897)) ; myGauge
		(= temp0 Person)
		(self setCurrentPlayer:)
		(= global185 (= global175 (= global186 0)))
		(= global446 (Random 0 -1))
		(self drawPic: picture)
		(playerList init:)
		(= numActivePlayers (playerList size:))
		(for ((= temp0 0)) (< temp0 (playerList size:)) ((++ temp0))
			(-= numActivePlayers ((playerList at: temp0) sittingOut:))
		)
		(= global448 numActivePlayers)
		(gDeck init:)
	)

	(method (handInit))

	(method (whoPlaysFirst))

	(method (newDeal)
		(self removeViews:)
		(gDeck reShuffle:)
		(playerList next:)
	)

	(method (newDeal2)
		(self setCurrentPlayer:)
		(gDeck dealFrom:)
		(= global186 (= global185 (= global175 (= global180 0))))
		(gPlayer0 input: 0)
		(gPlayerList eachElementDo: #place 0)
	)

	(method (removeViews))

	(method (doit))

	(method (setCurrentPlayer)
		(= lastPlayer 0)
		(= currentPlayer 1)
	)
)

(class EndThrow of Obj
	(properties
		client 0
	)

	(method (handleEvent))

	(method (init param1)
		(= client param1)
	)

	(method (cue)
		(= global182 (- (client x:) 17))
		(= global183 (- (client y:) 21))
		(client dispose:)
		(switch global184
			(0
				(gPlayer0 afterThrow:)
			)
			(1
				(gPlayer1 afterThrow:)
			)
			(2
				(gPlayer2 afterThrow:)
			)
			(3
				(gPlayer3 afterThrow:)
			)
			(4
				(gCardRoom cue:)
			)
		)
	)
)

(instance theCardToss of Act
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(self
			view: (+ 290 global507)
			setLoop: 8
			setCel: 3
			setCycle: Fwd
			setStep: param5 param5
			setPri: 15
			posn: (+ param1 17) (+ param2 21)
			setScript: global197
			setMotion: MoveTo (+ param3 17) (+ param4 21) self
		)
		(super init:)
	)
)

(instance playerList of List
	(properties)

	(method (init)
		(super init:)
		(if (IsObject gPlayer0)
			(self add: gPlayer0)
		)
		(if (IsObject gPlayer1)
			(self add: gPlayer1)
		)
		(if (IsObject gPlayer2)
			(self add: gPlayer2)
		)
		(if (IsObject gPlayer3)
			(self add: gPlayer3)
		)
		(if ((self at: 0) sittingOut:)
			(self next:)
		)
		(self eachElementDo: #init)
	)

	(method (next)
		(self add: (self at: 0) delete: (self at: 0))
		(while ((self at: 0) sittingOut:)
			(self add: (self at: 0) delete: (self at: 0))
		)
	)
)

(instance tDeck of WL
	(properties)
)

(instance wDeck of WL
	(properties)
)

(instance goneTimer of Tmrs
	(properties)

	(method (setSeconds param1)
		(super setSeconds: param1)
		(if (>= param1 20)
			(= global188 0)
		)
	)
)

