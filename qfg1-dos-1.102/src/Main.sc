;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n001)
(use n005)
(use n006)
(use n007)
(use n008)
(use n100)
(use n101)
(use n102)
(use n104)
(use n105)
(use n106)
(use Interface)
(use n896)
(use StopWalk)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use System)

(public
	HQ 0
	EgoDead 1
	RedrawCast 2
	HaveMem 3
	clr 4
	HandsOff 5
	HandsOn 6
	MouseClaimed 7
	SoundFX 8
	SetFlag 9
	ClearFlag 10
	IsFlag 11
	NextDay 12
	proc0_13 13
	NormalEgo 14
	NotClose 15
	AlreadyDone 16
	DontHave 17
	CantDo 18
	HighPrint 19
	LowPrint 20
	TimePrint 21
	FindTime 22
	CanPickLocks 23
	LookAt 24
	Purchase 25
	FixTime 26
	PromptQuit 27
	UseMana 28
	UseStamina 29
	TrySkill 30
	SkillUsed 31
	SolvePuzzle 32
	Random100 35
	TakeDamage 36
	MaxMana 37
	MaxStamina 38
	MaxHealth 39
	MaxLoad 40
	CastSpell 41
	EgoGait 42
	EatMeal 43
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
	gVersion = {ego}
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
	gHSW
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
	gEgoGait
	global101
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	gContMusic
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
	gClock
	gNight
	gDay
	gTimeOfDay
	global134
	; 135
	global135
	gHeroType
	gHowFast
	global138
	gEgoStats
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
	global190 = 2
	global191 = 2
	global192 = 3
	global193 = 3
	global194 = 3
	; 195
	global195 = 4
	global196 = 5
	global197 = 5
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
	global213 = 20
	global214 = 15
	; 215
	global215
	gKeyHandler
	gMouseHandler
	gDirHandler
	gFreeMeals
	; 220
	global220
	global221
	gOldStats
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
	global252 = 180
	global253
	global254 = 45
	; 255
	global255 = 90
	global256 = 135
	global257 = 180
	global258 = 225
	global259 = 270
	; 260
	global260 = 315
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267 = -1
	global268
	global269
	; 270
	global270
	global271
	global272
	global273
	global274 = 9
	; 275
	global275 = 12
	global276
	global277 = -3
	gStatusCode
	global279
	; 280
	global280
	global281
	global282 = -32768
	global283 = -1
	global284
	; 285
	gKobold
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
	global325 = 26
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
	gInvNum
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
	gInvDropped
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
	gInvWeight
	global542 = 1
	global543 = 1
	global544 = 20
	; 545
	global545 = 30
	global546 = 15
	global547 = 420
	global548 = 120
	global549 = 1200
	; 550
	global550 = 720
	global551 = 1
	global552 = 15
	global553 = 30
	global554 = 6
	; 555
	global555 = 30
	global556 = 180
	global557 = 45
	global558 = 60
	global559 = 30
	; 560
	global560 = 10
	global561 = 60
	global562 = 30
	global563 = 1
	global564 = 5
	; 565
	global565 = 30
	global566 = 2
	global567 = 10
	global568 = 3
	global569 = 10
	; 570
	global570 = 40
	global571 = 10
	global572 = 20
	global573 = 60
	global574 = 2100
	; 575
	global575 = 40
	global576 = 40
	global577 = 40
	global578 = 40
	global579 = 40
	; 580
	global580 = 40
	global581 = 30
	global582 = 3
	global583 = 160
	global584 = 120
	; 585
	global585 = 93
	global586 = 1000
	global587
	global588
	global589
	; 590
	global590 = 1000
	global591 = 5
	gEndBattle
	global593
	global594
)

(procedure (EgoDead)
	(HandsOff)
	(Wait 100)
	(gGame setCursor: gNormalCursor 1)
	(gSounds eachElementDo: #stop)
	(if global325
		(music number: global325 priority: 15 init: play:)
	)
	(repeat
		(switch
			(Print
				&rest
				#width
				250
				#button
				{Restore}
				1
				#button
				{ Restart }
				2
				#button
				{ Quit }
				3
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (HaveMem howMuch)
	(return (> (MemoryInfo 0) howMuch)) ; LargestPtr
)

(procedure (clr)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (HandsOff)
	(= global104 1)
	(User canControl: 0 canInput: 0)
	(gGame setCursor: gWaitCursor 1)
	(gEgo setMotion: 0)
)

(procedure (HandsOn)
	(= global104 0)
	(User canControl: 1 canInput: 1)
	(gGame setCursor: gNormalCursor (HaveMouse))
)

(procedure (MouseClaimed obj event shifts)
	(if (MousedOn obj event shifts)
		(event claimed: 1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (SetFlag flag)
	(|= [global350 (/ flag 16)] (>> $8000 (mod flag 16)))
)

(procedure (ClearFlag flag)
	(&= [global350 (/ flag 16)] (~ (>> $8000 (mod flag 16))))
)

(procedure (IsFlag flag)
	(return (& [global350 (/ flag 16)] (>> $8000 (mod flag 16))))
)

(procedure (FindTime &tmp whatDay [str 30])
	(= whatDay gDay)
	(if (or (!= gTimeOfDay 6) (> gClock 500))
		(++ whatDay)
	)
	(HighPrint (Format @str 0 48 297 (+ 40 gTimeOfDay) whatDay)) ; "%s on day %d."
)

(procedure (EgoGait newGait gaitMsg &tmp theView)
	(if gaitMsg
		(cond
			((not (User canControl:))
				(HighPrint 0 49) ; "You can't do that now."
				(return)
			)
			((== gEgoGait newGait)
				(HighPrint 0 50) ; "Go ahead. Just do it."
				(return)
			)
		)
	)
	(if (!= newGait -1)
		(= gEgoGait newGait)
	)
	(gEgo setLoop: -1 cycleSpeed: 0 moveSpeed: 0)
	(switch gEgoGait
		(1 ; running
			(gEgo view: 5 setStep: 6 4 setCycle: egoSW 4)
		)
		(2 ; sneaking
			(gEgo view: 6 setStep: 2 1 setCycle: Walk)
		)
		(else
			(gEgo view: 0 setStep: 3 2 setCycle: egoSW 4)
		)
	)
	(if global201
		(gEgo setStep: (* (gEgo xStep:) 2) (* (gEgo yStep:) 2))
	)
	(if (IsFlag 205)
		(gEgo setStep: 1 1)
	)
)

(procedure (NormalEgo)
	(EgoGait -1 0)
	(gEgo
		setPri: -1
		setMotion: 0
		illegalBits: -32768
		ignoreHorizon:
		ignoreActors: 0
	)
)

(procedure (proc0_13)) ; UNUSED

(procedure (NotClose)
	(HighPrint 0 51) ; "You're not close enough."
)

(procedure (AlreadyDone)
	(HighPrint 0 52) ; "You've already done that."
)

(procedure (CantDo)
	(HighPrint 0 49) ; "You can't do that now."
)

(procedure (DontHave)
	(HighPrint 0 53) ; "You don't have it."
)

(procedure (HighPrint &tmp [temp0 4] [temp4 400])
	(clr)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print @temp4 #at -1 12 #width (if (> [temp0 2] 24) 300 else 0) #mode 1)
)

(procedure (TimePrint numSeconds &tmp [temp0 4] [temp4 400])
	(clr)
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print
		@temp4
		#at
		-1
		12
		#width
		(if (> [temp0 2] 24) 300 else 0)
		#mode
		1
		#dispose
		#time
		numSeconds
	)
)

(procedure (LowPrint &tmp [temp0 4] [temp4 400])
	(Format @temp4 &rest)
	(TextSize @[temp0 0] @temp4 gUserFont 0)
	(Print @temp4 #at -1 115 #width (if (> [temp0 2] 24) 300 else 0) #mode 1)
)

(procedure (LookAt actor1 actor2)
	(DirLoop actor1 (GetAngle (actor1 x:) (actor1 y:) (actor2 x:) (actor2 y:)))
	(if (== argc 3)
		(DirLoop
			actor2
			(GetAngle (actor2 x:) (actor2 y:) (actor1 x:) (actor1 y:))
		)
	)
)

(procedure (Purchase itemPrice &tmp oldSilver oldGold)
	(= oldSilver [gInvNum 1]) ; silver
	(= oldGold [gInvNum 2]) ; gold
	(if (< (+ oldSilver (* oldGold 10)) itemPrice)
		(return 0)
	)
	(for ((-= oldSilver itemPrice)) (< oldSilver 0) ((+= oldSilver 10))
		(-- oldGold)
	)
	(= [gInvNum 1] oldSilver) ; silver
	(= [gInvNum 2] oldGold) ; gold
	(return 1)
)

(procedure (FixTime newClock newMinutes &tmp oldTime)
	(if (>= argc 1)
		(= gClock (* 150 newClock))
		(= global135 (GetTime 1)) ; SysTime12
		(if (>= argc 2)
			(+= gClock (/ (* 150 newMinutes) 60))
		)
	)
	(^= gClock $0001)
	(= oldTime gTimeOfDay)
	(cond
		((< gClock 300)
			(= gTimeOfDay 6)
		)
		((< gClock 750)
			(= gTimeOfDay 7)
		)
		((< gClock 1200)
			(= gTimeOfDay 0)
		)
		((< gClock 1650)
			(= gTimeOfDay 1)
		)
		((< gClock 2100)
			(= gTimeOfDay 2)
		)
		((< gClock 2550)
			(= gTimeOfDay 3)
		)
		((< gClock 3000)
			(= gTimeOfDay 4)
		)
		((< gClock 3450)
			(= gTimeOfDay 5)
		)
		(else
			(= gTimeOfDay 6)
		)
	)
	(if (> gTimeOfDay 4)
		(= gNight 1)
		(= global61 1)
	else
		(= gNight 0)
		(= global61 0)
	)
	(if (and (== gTimeOfDay 6) (!= oldTime 6))
		(if (== (++ global268) 1)
			(Print 0 54) ; "You are getting tired."
		else
			(Print 0 55) ; "You are exhausted from lack of sleep."
		)
	)
)

(procedure (NextDay)
	(++ gDay)
	(ClearFlag 217)
)

(procedure (Random100)
	(return (+ 1 (/ (Random 0 999) 10)))
)

(procedure (localproc_0 param1 param2)
	(SkillUsed param1 param2)
	(return (* [gEgoStats param1] param2))
)

(procedure (TrySkill skillNum difficulty bonus &tmp skVal skDiv skRef success)
	(if (not (= skVal [gEgoStats skillNum]))
		(return 0)
	)
	(if (== argc 3)
		(+= skVal bonus)
	)
	(if difficulty
		(if (>= skillNum 5)
			(UseStamina (/ difficulty 10))
		)
	else
		(if (>= skillNum 5)
			(UseStamina (Random 1 6))
		)
		(= difficulty (Random100))
	)
	(if (>= (localproc_0 4 1) (Random 1 200))
		(+= skVal (Random 1 20))
	)
	(= success (<= difficulty skVal))
	(= skDiv
		(cond
			((<= (= skDiv (Abs (- difficulty skVal))) 10) 2)
			((<= skDiv 30) 4)
			((<= skDiv 50) 6)
			(else
				(return success)
			)
		)
	)
	(= skRef
		(cond
			((== skillNum 5)
				(/ (+ (localproc_0 2 2) (localproc_0 0 2)) 16)
			)
			((or (== skillNum 6) (== skillNum 7) (== skillNum 8))
				(/ (+ (localproc_0 2 3) (localproc_0 1 1)) 8)
			)
			((== skillNum 9)
				(/ (+ (localproc_0 2 3) (localproc_0 1 1)) 4)
			)
			((or (== skillNum 10) (== skillNum 11))
				(/ (+ (localproc_0 2 3) (localproc_0 0 2)) 5)
			)
			((>= skillNum 17)
				(/ (+ (localproc_0 12 4) (localproc_0 1 2)) 6)
			)
			(else 10)
		)
	)
	(SkillUsed skillNum (/ skRef skDiv))
	(return success)
)

(procedure (SkillUsed skillNum learnValue)
	(if (not [gEgoStats skillNum])
		(return 0)
	)
	(if (> (= learnValue (Abs learnValue)) [gEgoStats skillNum])
		(= learnValue [gEgoStats skillNum])
	)
	(+= [gEgoStats 13] (/ learnValue 4)) ; experience
	(+= [global164 skillNum] learnValue)
	(if (>= [global164 skillNum] [gEgoStats skillNum])
		(-= [global164 skillNum] [gEgoStats skillNum])
		(if (> (+= [gEgoStats skillNum] (Random 1 3)) 100)
			(= [gEgoStats skillNum] 100)
		)
		(return 1)
	)
	(return 0)
)

(procedure (UseStamina pointsUsed &tmp foo)
	(if (> pointsUsed 0)
		(SkillUsed 3 (/ (+ pointsUsed 3) 4)) ; vitality
	)
	(cond
		((< (= foo (-= [gEgoStats 15] pointsUsed)) 0) ; stamina
			(TakeDamage (/ (- -3 [gEgoStats 15]) 4)) ; stamina
			(= [gEgoStats 15] 0) ; stamina
			(if (not (IsFlag 110))
				(SetFlag 110)
				(HighPrint 0 56) ; "You are so exhausted that everything you do hurts. Better get some rest."
			)
			(if (<= [gEgoStats 14] 0) ; health
				(EgoDead 0 57 80 {Death from Overwork} 82 800 1 4) ; "That was a little too much for you. You collapse from exhaustion and die."
			)
		)
		((> foo 4)
			(ClearFlag 110)
			(if (> foo (MaxStamina))
				(= [gEgoStats 15] (MaxStamina)) ; stamina
			)
		)
	)
)

(procedure (UseMana pointsUsed)
	(if [gEgoStats 12] ; magic
		(if (< (-= [gEgoStats 16] pointsUsed) 0) ; mana
			(= [gEgoStats 16] 0) ; mana
		)
		(if (> [gEgoStats 16] (MaxMana)) ; mana
			(= [gEgoStats 16] (MaxMana)) ; mana
		)
		(if (> pointsUsed 0)
			(SkillUsed 1 (/ pointsUsed 5)) ; intelligence
			(SkillUsed 12 (/ pointsUsed 2)) ; magic
		)
	)
)

(procedure (TakeDamage damage)
	(if (> damage 0)
		(SkillUsed 3 (/ (+ damage 1) 2)) ; vitality
	)
	(if (< (-= [gEgoStats 14] damage) 0) ; health
		(= [gEgoStats 14] 0) ; health
	)
	(if (> [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 14] (MaxHealth)) ; health
	)
	(return (> [gEgoStats 14] 0)) ; health
)

(procedure (MaxStamina)
	(return (* (+ [gEgoStats 2] [gEgoStats 3]) 2)) ; agility, vitality
)

(procedure (MaxHealth &tmp temp0)
	(return (* 2 (= temp0 (/ (+ [gEgoStats 0] [gEgoStats 3] [gEgoStats 3]) 3)))) ; strength, vitality, vitality
)

(procedure (MaxMana &tmp temp0)
	(if (= temp0 [gEgoStats 12]) ; magic
		(return (/ (+ [gEgoStats 1] temp0 temp0) 3)) ; intelligence
	else
		(return 0)
	)
)

(procedure (MaxLoad)
	(return (+ 40 (/ [gEgoStats 0] 2))) ; strength
)

(procedure (CastSpell spellNum &tmp temp0)
	(cond
		((not [gEgoStats 12]) ; magic
			(HighPrint 0 58) ; "You don't know how to cast spells."
		)
		((not (gEgo knows: spellNum))
			(HighPrint 0 59) ; "You don't know that spell."
		)
		((< [gEgoStats 16] [global190 (- spellNum 17)]) ; mana
			(HighPrint 0 60) ; "You don't have enough Magic Points to cast that spell."
		)
		(else
			(TrySkill spellNum 0)
			(UseMana [global190 (- spellNum 17)])
			(return 1)
		)
	)
	(return 0)
)

(procedure (SoundFX soundNum)
	(if (> global212 4)
		(return soundNum)
	else
		(return (+ 100 soundNum))
	)
)

(procedure (SolvePuzzle pFlag pValue charType)
	(if (and (>= argc 3) (!= gHeroType charType))
		(return)
	)
	(if (not (IsFlag pFlag))
		(SetFlag pFlag)
		(gGame changeScore: pValue)
		(SkillUsed 1 pValue) ; intelligence
	)
)

(procedure (EatMeal)
	(cond
		(gFreeMeals
			(-- gFreeMeals)
		)
		([gInvNum 3] ; food
			(if (not (-- [gInvNum 3])) ; food
				(LowPrint 0 61) ; "You just ate your last ration; you'd better get some more food soon."
			)
		)
		((IsFlag 124)
			(SetFlag 125)
			(LowPrint 0 62) ; "You're starving. Better find some food *soon*!"
			(TakeDamage 1)
		)
		(else
			(SetFlag 124)
			(LowPrint 0 63) ; "You're really getting hungry."
		)
	)
)

(procedure (CanPickLocks)
	(return (and [gEgoStats 9] (or (gEgo has: 23) (gEgo has: 24)))) ; pick locks, lockpick, thief kit
)

(procedure (PromptQuit)
	(= gQuit
		(Print ; "How about a slice of quiche?"
			0
			64
			#title
			{Giving up, huh?}
			#button
			{Quit}
			1
			#button
			{Don't Quit}
			0
			#icon
			800
			1
			4
		)
	)
)

(class ego of Ego
	(properties)

	(method (has param1)
		(return [gInvNum param1])
	)

	(method (get param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (if (== argc 1) 1 else param2))
		(= temp2 [gInvNum param1])
		(cond
			(
				(>
					(= temp3
						(+
							(WtCarried)
							(/ (+ 59 (* temp1 [gInvWeight param1])) 60)
						)
					)
					(MaxLoad)
				)
				(if (not (IsFlag 205))
					(HighPrint 0 0) ; "You are carrying so much that you can hardly move. You'd better drop something soon."
					(SetFlag 205)
					(gEgo setStep: 1 1)
				)
			)
			((IsFlag 205)
				(ClearFlag 205)
				(EgoGait -1 0)
			)
		)
		(if (< (+= temp1 temp2) 0)
			(= temp1 0)
		)
		(= [gInvNum param1] temp1)
		(return (- temp1 temp2))
	)

	(method (put param1 param2 &tmp temp0 temp1)
		(= temp1 (if (== argc 1) 1 else param2))
		(if (not (= temp1 (self use: param1 temp1)))
			(return 0)
		)
		(+= [gInvDropped param1] temp1)
		(return (and (not (gEgo has: 30)) (ClearFlag 279))) ; magic mushroom
	)

	(method (use param1 param2 &tmp temp0 temp1 temp2)
		(if (> (= temp1 (if (== argc 1) 1 else param2)) [gInvNum param1])
			(= temp1 [gInvNum param1])
		)
		(self get: param1 (- temp1))
		(if (and (== param1 30) (not [gInvNum 30])) ; magic mushroom
			(ClearFlag 148)
		)
		(return temp1)
	)

	(method (drop param1)
		(self put: param1 &rest)
	)

	(method (pickUp param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (if (== argc 1) 1 else param2))
		(= temp3 [gInvDropped param1])
		(= temp4 0)
		(if temp3
			(= temp4 (if (u< temp3 temp1) temp3 else temp1))
			(self get: param1 temp4)
			(-= [gInvDropped param1] temp4)
		)
		(return temp4)
	)

	(method (knows param1)
		(return [gEgoStats param1])
	)

	(method (learn param1 param2 &tmp temp0 temp1)
		(= temp1 (if (== argc 1) 5 else param2))
		(if (and [gEgoStats 12] (> temp1 [gEgoStats param1])) ; magic
			(= [gEgoStats param1] temp1)
		)
		(return [gEgoStats param1])
	)
)

(instance egoBase of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (+ 1 (param1 y:)))
		(param1
			brTop: (- temp1 2)
			brBottom: temp1
			brLeft: (- temp0 9)
			brRight: (+ temp0 9)
		)
	)
)

(instance egoObj of ego
	(properties)
)

(instance contMusic of Sound
	(properties
		number 26
	)
)

(instance endBattle of Sound
	(properties
		number 26
		priority 10
	)
)

(instance music of Sound
	(properties
		number 26
		priority 10
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 1 gScore) ; "So You Want To Be A Hero [score %d of 500]"
	)
)

(instance keyHandler of EventHandler
	(properties)

	(method (handleEvent event)
		(if (and (not (super handleEvent: event)) (== (event message:) KEY_RETURN))
			(clr)
			(event claimed: 1)
		)
	)
)

(instance dirHandler of EventHandler
	(properties)
)

(instance mouseHandler of EventHandler
	(properties)
)

(instance hSW of SysWindow
	(properties)
)

(instance HQ of Game
	(properties)

	(method (init &tmp temp0)
		(Load rsSCRIPT 1)
		(= gHSW hSW)
		((= gEgo egoObj) baseSetter: egoBase)
		(= gVersion {1.102____})
		(= gWaitCursor 997)
		(SL code: (= gStatusCode statusCode))
		(= temp0 StopWalk)
		(super init:)
		((= gKeyHandler keyHandler) add:)
		((= gMouseHandler mouseHandler) add:)
		((= gDirHandler dirHandler) add:)
		(= global212 (DoSound sndCHECK_DRIVER))
		((= gContMusic contMusic) number: (SoundFX 26) owner: self init:)
		((= gEndBattle endBattle) number: (SoundFX 26) owner: self init:)
		(music number: (SoundFX 26) owner: self init:)
		(= global325 (SoundFX 26))
		(InitGame)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (IsFlag 328)
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= global135 temp0)
				(= global135 temp0)
				(++ gClock)
				(if (and (>= gDay 7) (& gClock $0001))
					(++ gClock)
				)
				(if (>= gClock 3600)
					(= gClock 0)
					(NextDay)
				)
				(if
					(and
						(IsFlag 326)
						(> gDay global112)
						(> gClock 750)
					)
					(HandsOff)
					(HighPrint 0 2) ; "Suddenly, you hear voices, seeming to come from everywhere at once. They all sound like Baba Yaga, and they all say: "Wheeeeeere's myyyyyy Maaaandraaaaake Rooooooooooooot????""
					(EgoDead 0 3 82 800 1 2 80 {Curses!}) ; "Because you failed to meet Baba Yaga's DEADline, her curse turns you into a frog on the spot, and you are forced to live out your years dodging Sauruses (Saurii?) with large feet."
				)
				(if global334
					(-- global334)
				)
				(if (or (== gClock 1100) (== gClock 2500))
					(EatMeal)
				)
				(if (IsFlag 168)
					(switch (-- global220)
						(24
							(HighPrint 0 4) ; "The tingling sensation is wearing off."
						)
						(0
							(ClearFlag 168)
							(HighPrint 0 5) ; "The tingling sensation is gone."
						)
					)
				)
				(if (not (-- global213))
					(= global213 20)
					(cond
						((or (IsFlag 125) (> global268 1))
							(UseStamina 5)
						)
						((== gEgoGait 1) ; running
							(UseStamina 2)
						)
						((and (not (IsFlag 124)) (not global268))
							(UseStamina -1)
						)
					)
					(if (not (-- global591))
						(= global591 5)
						(UseMana -1)
					)
					(if (not (-- global214))
						(= global214 15)
						(TakeDamage -1)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(super newRoom: newRoomNumber)
		(self setCursor: (if global104 gWaitCursor else gNormalCursor) (HaveMouse))
	)

	(method (startRoom roomNum &tmp temp0)
		(proc896_0 roomNum)
		(DisposeScript 896)
		(if (u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
			(cond
				(global101
					(if (Print 0 6 #button {Debug} 1) ; "Memory fragmented."
						(SetDebug)
					)
				)
				((!= roomNum 601) ; CharSave
					(EgoDead 0 7 80 {Bitten by a program bug}) ; "Suddenly, the deadly poison Fragmentation Bug leaps out of a crack in the system, and injects you with its poison. Alas, there is no cure, save to . . ."
				)
			)
		)
		(gMouseHandler add: gCast gFeatures)
		StopWalk
		Cycle
		(super startRoom: roomNum)
		(= global101 0)
	)

	(method (handleEvent event &tmp temp0 [temp1 4] temp5 temp6)
		(switch (event type:)
			(evKEYBOARD
				(gKeyHandler handleEvent: event)
			)
			(evMOUSEBUTTON
				(if
					(and
						(not global104)
						(not (gMouseHandler handleEvent: event))
						(not (Random 0 4))
						(& (event modifiers:) emSHIFT)
					)
					(HighPrint 297 (Random 26 34))
				)
			)
			(evMOUSERELEASE
				(gCast handleEvent: event)
			)
			($0040 ; direction
				(gDirHandler handleEvent: event)
			)
			(evJOYDOWN
				(event type: evKEYBOARD message: KEY_RETURN)
				(gKeyHandler handleEvent: event)
			)
			(evSAID
				(cond
					((super handleEvent: event))
					((or (Said 'quit') (Said 'done,done/game'))
						(PromptQuit)
					)
					(
						(or
							(Said 'kiss,fuck,blow,shit,leak')
							(Said 'get/shit,leak')
							(Said 'eat/shit')
						)
						(HighPrint 297 (Random 0 8))
					)
					((Said 'get>')
						(cond
							((== (= temp0 (SaidInv event)) 0)
								(HighPrint 0 8) ; "You can't get that."
							)
							((== temp0 9)
								(if (== gCurRoomNum global276)
									(gEgo get: 9) ; shield
									(HighPrint 0 9) ; "You retrieve your shield."
									(= global276 0)
								else
									(HighPrint 0 10) ; "There aren't any here."
								)
							)
							((and (== temp0 7) (== gCurRoomNum global273))
								(if (and global332 (> global333 0))
									(HighPrint 0 11) ; "You don't have time -- there's the slight matter of the monster that wants to eat you."
								else
									(= temp6 0)
									(= global273 0)
									(if (or global271 [gInvDropped 7]) ; dagger
										(= temp6 1)
										(gEgo
											get: 7 (+ global271 [gInvDropped 7]) ; dagger, dagger
										)
										(HighPrint 0 12) ; "You pick up the loose daggers."
									)
									(if global272
										(= temp6 1)
										(gEgo get: 7 global272) ; dagger
										(HighPrint 0 13) ; "You retrieve your knives from the dead monster's body, and carefully wipe them clean for reuse."
									)
									(= [gInvDropped 7] ; dagger
										(= global272 (= global271 0))
									)
									(if (not temp6)
										(HighPrint 0 10) ; "There aren't any here."
									)
								)
							)
							((gEgo pickUp: temp0 -1)
								(HighPrint 0 14) ; "Ok"
							)
							(else
								(HighPrint 0 10) ; "There aren't any here."
							)
						)
					)
					((Said 'throw/dagger')
						(ThrowKnife 0)
					)
					((Said 'throw/boulder')
						(ThrowRock 0)
					)
					((Said 'cast>')
						(cond
							((not (= temp0 (SaidSpell event)))
								(HighPrint 0 15) ; "That isn't a known spell."
							)
							((CastSpell temp0)
								(switch temp0
									(17
										(CastOpen)
										(HighPrint 0 16) ; "The spell has no effect."
									)
									(18
										(HighPrint 0 17) ; "You sense no magic in this area."
									)
									(20
										(CastDazzle)
									)
									(21
										(= global250
											(+ 5 (/ [gEgoStats 21] 10)) ; zapSpell
										)
										(if
											(or
												(gEgo has: 6) ; blade
												(gEgo has: 7) ; dagger
											)
											(HighPrint 0 18) ; "Your weapon is now magically charged."
										else
											(HighPrint 0 19) ; "You don't have a weapon to charge."
										)
									)
									(22
										(CastCalm)
									)
									(23
										(CastDart 0)
									)
									(else
										(HighPrint 0 16) ; "The spell has no effect."
									)
								)
							)
						)
					)
					((Said 'fight')
						(HighPrint 0 20) ; "Aggressive, aren't you?"
					)
					((Said 'talk')
						(HighPrint 0 21) ; "No one responds."
					)
					((or (Said 'put<down>') (Said 'drop>'))
						(cond
							((not (= temp0 (SaidInv event)))
								(HighPrint 0 22) ; "I don't know what you're trying to drop."
							)
							([gInvNum temp0]
								(if (== temp0 9)
									(= global276 gCurRoomNum)
									(gEgo use: 9) ; shield
								else
									(gEgo drop: temp0 1)
								)
								(HighPrint 0 23) ; "Ok, you drop it."
								(if (not (gEgo has: 30)) ; magic mushroom
									(ClearFlag 148)
								)
							)
							(else
								(HighPrint 0 24) ; "You can't drop something you don't have."
							)
						)
					)
					((Said 'walk')
						(EgoGait 0 1) ; walking
					)
					((Said 'run')
						(EgoGait 1 1) ; running
					)
					((or (Said '[use]/stealth') (Said 'sneak'))
						(if (!= gEgoGait 2) ; sneaking
							(if (TrySkill 8 5 0) ; stealth
								(EgoGait 2 1) ; sneaking
							else
								(HighPrint 0 25) ; "You're about as stealthy as the average Goon."
							)
						)
					)
					((Said 'unlock,lockpick/door,hasp')
						(HighPrint 0 26) ; "There's no point in trying that here."
					)
					((Said 'lockpick/nose')
						(if (CanPickLocks)
							(HighPrint 0 27) ; "You delicately insert the lockpick into your left nostril."
							(if (not (TrySkill 9 40)) ; pick locks
								(EgoDead ; "Unfortunately, you push it in too far, causing yourself a cerebral hemorrhage. Guess you should have practiced some more on less difficult locks."
									0
									28
									80
									{The surgeon general warns . . . }
									82
									800
									0
									0
								)
							else
								(HighPrint 0 29) ; "Success! You now have an open nose."
							)
						else
							(HighPrint 0 30) ; "You don't have an appropriate tool."
						)
					)
					((Said 'ask')
						(HighPrint 0 31) ; "You get no response."
					)
					((Said 'buy')
						(HighPrint 0 32) ; "It's not for sale."
					)
					((Said 'eat>')
						(Eat event)
					)
					((Said '/ale<root<dazzle<razzle')
						(if (^= global101 $0001)
							(gCurRoom setLocales: 298)
						)
					)
					((Said 'use,drink>')
						(DrinkPotion event 0)
					)
					((Said 'thank')
						(HighPrint 0 33) ; "You're welcome!"
					)
					((Said '/sorry')
						(HighPrint 0 34) ; "That's OK."
					)
					((Said 'yes,no,please')
						(HighPrint 0 21) ; "No one responds."
					)
					((Said '/hello')
						(HighPrint 0 35) ; "Hi!"
					)
					((Said '/bye')
						(HighPrint 0 36) ; "Bye!"
					)
					((Said 'open/door')
						(HighPrint 0 37) ; "You're not close enough to a door."
					)
					((Said 'open/box,musicbox')
						(if (gEgo has: 16) ; music box
							(HighPrint 0 38) ; "You open the music box, which plays Beethoven's "Fur Elise." After listening to it for a bit, you close the box."
						else
							(HighPrint 0 39) ; "You don't have a box to open."
						)
					)
					((Said 'knock')
						(HighPrint 0 40) ; "No one hears you knocking."
					)
					((Said 'sat')
						(HighPrint 0 41) ; "You don't need to."
					)
					((Said 'give')
						(HighPrint 0 42) ; "You have no reason to do that."
					)
					((Said 'search[/!*,room,area,area]')
						(HighPrint 0 43) ; "You don't find anything interesting."
					)
					((Said 'look,read>')
						(= temp5
							(+
								[gInvNum (= temp0 (SaidInv event))]
								[gInvDropped temp0]
							)
						)
						(cond
							((not temp0)
								(HighPrint 297 (Random 10 13))
							)
							(temp5
								(HighPrint 3 (+ temp0 temp0 1))
							)
							(else
								(HighPrint 0 44) ; "You don't see any here."
							)
						)
					)
					((Said 'rest[/!*]')
						(EgoRests 10 1)
					)
					((or (Said 'nap[/!*]') (Said 'go[<to]/nap'))
						(EgoSleeps 5 0)
					)
				)
			)
		)
	)

	(method (replay)
		(InitGlobals)
		(if (not (OneOf gCurRoomNum 200 202 203 299 600)) ; intro, selChar, chAlloc, speedChecker, EndGame
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

	(method (wordFail param1)
		(Printf 0 45 param1) ; "You will not need to use the word "%s" in this game."
	)

	(method (syntaxFail)
		(HighPrint 0 46) ; "Please try a different way of saying that."
	)

	(method (pragmaFail)
		(HighPrint 0 47) ; "I'm not sure what you're trying to do."
	)
)

(instance egoSW of StopWalk
	(properties)
)

