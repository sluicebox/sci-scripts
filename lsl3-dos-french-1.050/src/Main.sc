;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use FileSelector)
(use LoadMany)
(use Sound)
(use Save)
(use Motion)
(use File)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	LSL3 0
	NormalEgo 1
	NormalActor 2
	HandsOff 3
	HandsOn 4
	cls 5
	Ok 6
	ItIs 7
	YouAre 8
	NotNow 9
	NotClose 10
	AlreadyTook 11
	DontHave 12
	Notify 13
	HaveMem 14
	AddActorToPic 15
	SetRgTimer 16
	LogIt 17
	LameResponse 18
	SetFlag 19
	ClearFlag 20
	ToggleFlag 21
	TestFlag 22
	InRoom 23
	PutInRoom 24
	PrintDelay 25
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
	gTheWindow
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
	gDebugging
	gEgoState
	gNormalEgoView
	gGameSeconds
	gGameMinutes
	; 105
	gGameHours
	gOldTime
	gSecondsInRoom
	gBgMusicLoops
	gRgTimer
	; 110
	gCurTimer
	gFlagArray
	gCreditsFinished
	global113
	global114
	; 115
	global115
	global116
	gLastFlag
	gEgoName
	gEgoNameBuffer
	; 120
	global120
	global121
	gNearPerson
	gMachineSpeed
	gFilthLevel
	; 125
	gKeyDownHandler
	gMouseDownHandler
	gDirectionHandler
	gBambooCount
	gScoreDisplayed
	; 130
	gDollars
	gMusic
	gBeachState
	gDemo
	gNewspaperState
	; 135
	gLawyerState
	gCurVendor
	gOldGameSpeed
	gPrevRoomX
	gPrevRoomY
	; 140
	gShowroomState
	gTextColor
	gBackgroundColor
	gSomeObject
	gEgoIsPatti
	; 145
	gSoundFX
	gStringDelay
	gLockerCombination1
	gLockerCombination2
	gLockerCombination3
	; 150
	gBenchPressCount
	gLegCurlsCount
	gPullupsCount
	gBarPullCount
	gEgoIsHunk
	; 155
	gPrevLoop
	gOldEgoState
	gNextVar
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
	gFilthLevelBuffer
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
	gExpletiveBuffer
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
	gExpletive
	; 220
	gLaffer
	gAutoSaveMinutes
	gAsMinutes
	gAsSeconds
	gDateBuffer
	; 225
	global225
	global226
	global227
	global228
	gInitialsBuffer
	; 230
	global230
	global231
	gNoteCounter
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
)

(procedure (NormalEgo theLoop theView)
	(HandsOn)
	(gEgo edgeHit: EDGE_NONE)
	(switch argc
		(0
			(NormalActor
				gEgo
				(gEgo loop:)
				(if (> argc 1) theView else gNormalEgoView)
			)
		)
		(1
			(NormalActor gEgo theLoop (if (> argc 1) theView else gNormalEgoView))
		)
		(2
			(NormalActor gEgo theLoop theView)
		)
	)
)

(procedure (NormalActor who theLoop theView)
	(if (> argc 1)
		(who loop: theLoop)
	)
	(if (> argc 2)
		(who view: theView)
	)
	(who
		setLoop: -1
		setPri: -1
		setStep: 3 2
		setCycle: Walk
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gEgo setMotion: 0)
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (Ok)
	(Print 0 175) ; "O.K."
)

(procedure (ItIs)
	(Print 0 176) ; "It is."
)

(procedure (YouAre)
	(Print 0 177) ; "You are."
)

(procedure (NotNow)
	(Print 0 178) ; "Good idea. You might try that again later."
)

(procedure (NotClose)
	(Print 0 179) ; "You're not close enough."
)

(procedure (AlreadyTook)
	(Print 0 180) ; "You already took it."
)

(procedure (DontHave)
	(Print 0 181) ; "You don't have it."
)

(procedure (Notify whom)
	(= whom (ScriptID whom))
	(whom notify: &rest)
)

(procedure (HaveMem howMuch)
	(if (> (MemoryInfo 1) howMuch) ; FreeHeap
		(return 1)
	else
		(Print 0 59) ; "You can't do that here; at least, not now."
		(return 0)
	)
)

(procedure (AddActorToPic whom)
	(if whom
		((View new:)
			view: (whom view:)
			loop: (whom loop:)
			cel: (whom cel:)
			setPri: (whom priority:)
			posn: (whom x:) (whom y:)
			addToPic:
		)
		(whom posn: (whom x:) (+ 1000 (whom y:)))
	)
)

(procedure (SetRgTimer name minutes seconds)
	(= gCurTimer name)
	(= gRgTimer (* 10 (+ seconds (* minutes 60))))
)

(procedure (LogIt &tmp [temp0 140])) ; UNUSED

(procedure (LameResponse &tmp [string 150]))

(procedure (SetFlag flag)
	(|= [gFlagArray (/ flag 16)] (>> $8000 (mod flag 16)))
)

(procedure (ClearFlag flag)
	(&= [gFlagArray (/ flag 16)] (~ (>> $8000 (mod flag 16))))
)

(procedure (ToggleFlag flag) ; UNUSED
	(^= [gFlagArray (/ flag 16)] (>> $8000 (mod flag 16)))
)

(procedure (TestFlag flag)
	(return
		(if (& [gFlagArray (/ flag 16)] (>> $8000 (mod flag 16))) 1 else 0)
	)
)

(procedure (InRoom iEnum room)
	(return
		(== ((gInventory at: iEnum) owner:) (if (< argc 2) gCurRoomNum else room))
	)
)

(procedure (PutInRoom iEnum room)
	((gInventory at: iEnum) owner: (if (< argc 2) gCurRoomNum else room))
)

(procedure (PrintDelay string)
	(return (+ 3 (/ (StrLen string) gStringDelay)))
)

(instance version of File
	(properties)
)

(instance LSL3 of Game
	(properties
		parseLang 33
		printLang 33
	)

	(method (init &tmp temp0 temp1)
		((= gTheWindow theWindow) color: (= gTextColor 1) back: (= gBackgroundColor 15))
		(super init:)
		(= global290
			{"My name is Larry; Larry Laffer."}
		)
		(StrSplitInTwo @global388 @global428 global290)
		(= global386 @global388)
		(= global387 @global428)
		(= gVersion {0.001})
		(if (!= (version open: 1) 0)
			(version read: gVersion 5 close:)
		)
		(= gVolume 8)
		(DoSound sndVOLUME 8)
		(SL code: statusCode)
		(TheMenuBar init:)
		(scoreSound owner: self init:)
		((= gMusic theMusic) owner: self init:)
		((= gSoundFX theSoundFX) owner: self init:)
		(User alterEgo: (= gEgo ego) blocks: 0 y: 150)
		(if (HaveMouse)
			(gGame setCursor: gNormalCursor 1)
		else
			(gGame setCursor: gNormalCursor 1 304 174)
		)
		(Load rsFONT (= gBigFont 0))
		(Load rsFONT (= gUserFont 1))
		(Load rsFONT (= gSmallFont 4))
		(Load rsFONT 999)
		(Load rsCURSOR gNormalCursor)
		(Load rsCURSOR gWaitCursor)
		(Load rsCURSOR 666)
		(Load rsCURSOR 992)
		(Inv
			add:
				Nothing
				Credit_Card
				Ginsu_Knife
				Granadilla_Wood
				Native_Grass
				Soap_On_A_Rope
				A_Twenty_Dollar_Bill
				Land_Deed
				Beach_Towel
				Spa_Keycard
				Divorce_Decree
				some_Orchids
				Penthouse_Key
				Bottle_of_Wine
				Panties
				Pantyhose
				Bra
				Dress
				Magic_Marker
				Coconuts
				Marijuana
		)
		(if (GameIsRestarting)
			(= temp0 290)
		else
			(= temp0 120)
		)
		(self newRoom: temp0)
	)

	(method (replay)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu
			1282
			26
			(if (DoSound sndSET_SOUND) {Turn Off} else {Turn On})
		)
		(super replay:)
	)

	(method (newRoom newRoomNumber style)
		(if
			(or
				(and
					(not
						(OneOf
							newRoomNumber
							200
							203
							210
							213
							216
							220
							230
							235
							240
							245
							250
							253
							300
							305
							310
						)
					)
					(OneOf
						gCurRoomNum
						200
						203
						210
						213
						216
						220
						230
						235
						240
						245
						250
						253
						300
						305
						310
					)
				)
				(and
					(not (OneOf newRoomNumber 400 410 415 416 420 460))
					(OneOf gCurRoomNum 400 410 415 416 420 460)
				)
				(and
					(not (OneOf newRoomNumber 360 370 375 380 390))
					(OneOf gCurRoomNum 360 370 375 380 390)
				)
				(and
					(not (OneOf newRoomNumber 510 520 523 540 550))
					(OneOf gCurRoomNum 510 520 523 540 550)
				)
				(and
					(not (OneOf newRoomNumber 610 620 630 640 650))
					(OneOf gCurRoomNum 610 620 630 640 650)
				)
			)
			(gMusic fade:)
		)
		(ClearFlag 3) ; cantSave
		(ClearFlag 5) ; noCursor
		(cls)
		(Load rsFONT gBigFont)
		(Load rsFONT gUserFont)
		(Load rsFONT gSmallFont)
		(Load rsFONT 999)
		(Load rsCURSOR gNormalCursor)
		(Load rsCURSOR gWaitCursor)
		(Load rsCURSOR 666)
		(Load rsCURSOR 992)
		(super newRoom: newRoomNumber)
		(= gSecondsInRoom 0)
		(if (< argc 2)
			(= gShowStyle (Random 0 5))
		else
			(= gShowStyle style)
		)
		(if global303
			(SL doit:)
		)
	)

	(method (startRoom roomNum)
		(LoadMany
			0
			993
			991
			988
			981
			973
			971
			969
			967
			21
			50
			51
			42
			43
			44
			45
			46
			40
			421
		)
		(DisposeScript 958)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(gSoundFX stop: number: 1)
		(super startRoom: roomNum &rest)
		(if (and (not (OneOf roomNum 530 260 420)) gDebugging)
			(gCurRoom setLocales: 20)
		)
		(if (TestFlag 14)
			(gCurRoom setLocales: 22)
		)
		(cond
			(
				(OneOf
					roomNum
					200
					203
					210
					213
					216
					220
					230
					235
					240
					245
					250
					253
					300
					305
					310
				)
				(gCurRoom setLocales: 299)
			)
			((OneOf roomNum 360 370 375 380 390)
				(gCurRoom setLocales: 399)
			)
			((OneOf roomNum 400 410 415 416 420 460)
				(gCurRoom setLocales: 499)
			)
			((OneOf roomNum 510 520 523 540 550)
				(gCurRoom setLocales: 599)
			)
			((OneOf roomNum 610 620 630 640 650)
				(gCurRoom setLocales: 699)
			)
		)
		(if (or (== gEgoState 11) (== gNormalEgoView 708))
			(gEgo baseSetter: NormalBase)
		)
	)

	(method (changeScore n)
		(+= gScore n)
		(if (> n 0)
			(scoreSound playMaybe:)
		)
	)

	(method (doit &tmp [string 150])
		(super doit:)
		(if gDemo
			(User canControl: 0 canInput: 0)
		)
		(if (!= gOldTime (= gOldTime (GetTime 1))) ; SysTime12
			(if (>= (++ gGameSeconds) 60)
				(= gGameSeconds 0)
				(if (>= (++ gGameMinutes) 60)
					(= gGameMinutes 0)
					(++ gGameHours)
				)
			)
			(++ gSecondsInRoom)
			(if
				(and
					(< gScore 20)
					(> gGameMinutes 19)
					(> gSecondsInRoom 8)
					(< gSecondsInRoom 69)
					(User canControl:)
					(== gGameSeconds 1)
				)
				(++ gGameSeconds)
				(Print 0 0) ; "You're getting off to a slow start, Larry. Perhaps you should dig out the documentation that came with this game and read through the Walk-Thru in your copy of "Nontoonyt Tonite.""
				(Print 0 1 #at -1 144) ; "(This is merely a friendly suggestion from your designer and programmer, Al Lowe.)"
			)
			(if (and (not (TestFlag 4)) global291 (>= (++ global293) 60))
				(= global293 0)
				(if (>= (++ global292) global291)
					(= global292 0)
					(if
						(==
							1
							(Print
								(Format ; "It has been %d minute%s since you saved your game!%"
									@string
									0
									2
									global291
									(if (== global291 1) {} else {s})
									global291
									(if (== global291 1) {} else {s})
								)
								#title
								{AutoSave\05 Warning!}
								#icon
								52
								0
								0
								#font
								gBigFont
								#button
								{Save Now!}
								1
								#button
								{Screw it.}
								0
								#at
								-1
								10
							)
						)
						(gGame save:)
					)
				)
			)
		)
		(if (> gScore 4000)
			(= gScore 4000)
		)
		(if (> gScoreDisplayed gScore)
			(if (> gMachineSpeed 39)
				(-- gScoreDisplayed)
			else
				(= gScoreDisplayed gScore)
			)
			(SL doit:)
		)
		(if (< gScoreDisplayed gScore)
			(if (> gMachineSpeed 39)
				(++ gScoreDisplayed)
			else
				(= gScoreDisplayed gScore)
			)
			(SL doit:)
		)
		(cond
			((TestFlag 5)
				(self setCursor: 666 1)
			)
			((== (User controls:) 0)
				(if (User canInput:)
					(self setCursor: 992 (HaveMouse))
				else
					(self setCursor: gWaitCursor (HaveMouse))
				)
			)
			(else
				(self setCursor: gNormalCursor (HaveMouse))
			)
		)
		(if (and gCurTimer gRgTimer)
			(-- gRgTimer)
		)
	)

	(method (wordFail param1 &tmp [temp0 150])
		(switch (Random 0 4)
			(0
				(Print (Format @temp0 0 3 param1 param1)) ; "Oh, yeah? Well, "%s" this!%"
			)
			(1
				(Print (Format @temp0 0 4 param1 param1)) ; "You may know the word "%s" but it's beyond Al Lowe's vocabulary!%"
			)
			(2
				(Print (Format @temp0 0 5 param1 param1)) ; "Oh, yeah? Well, I've got your "%s" right here!%"
			)
			(3
				(Print (Format @temp0 0 6 param1 param1)) ; "You don't need to type the word "%s" to complete this game!%"
			)
			(else
				(Print (Format @temp0 0 7 param1 param1)) ; "Don't you ever say the word "%s" again!%"
			)
		)
	)

	(method (syntaxFail &tmp [temp0 120])
		(switch (Random 0 2)
			(0
				(Print 0 8) ; "That doesn't appear to be a proper sentence."
			)
			(1
				(Print 0 9) ; "What in the hell are you talking about?"
			)
			(else
				(Print 0 10) ; "That's probably something you could do, but this game won't!"
			)
		)
	)

	(method (pragmaFail &tmp [temp0 120])
		(switch (Random 0 2)
			(0
				(Print 0 11) ; "The hell you say!"
			)
			(1
				(Print 0 12) ; "You're too smart for this game!"
			)
			(else
				(Print 0 13) ; "Congratulations! You have dumbfounded this game!"
			)
		)
	)

	(method (handleEvent event &tmp [temp0 2] temp2 [temp3 3] [temp6 150] temp156)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'ascot/drop,drop')
				(if (^= gDebugging $0001)
					(Print 0 14) ; "Hi, Al!"
				else
					(Print 0 15) ; "Goodbye."
				)
			)
			((Said 'adjust/bambi')
				(if (^= global303 $0001)
					(SL doit:)
					(Print 0 16) ; "Information will be displayed on menu bar."
				else
					(SL doit:)
					(Print 0 17) ; "All gone."
				)
			)
			((or (Said 'caress/ginsu') (Said 'sharpen/ginsu'))
				(cond
					((not (gEgo has: 2)) ; Ginsu_Knife
						(DontHave) ; "You don't have it."
					)
					((== (Ginsu_Knife view:) 21)
						(ItIs) ; "It is."
					)
					((!= gCurRoomNum 250)
						(Print 0 18) ; "There's nothing here suitable for sharpening your knife."
					)
				)
			)
			((or (Said 'drop/anyword/bottle') (Said 'fill/bottle'))
				(Print 0 19) ; "This is not the correct place to do that."
			)
			((Said '(drain<out),drain,drain/beer,bottle')
				(cond
					((not (gEgo has: 13)) ; Bottle_of_Wine
						(DontHave) ; "You don't have it."
					)
					((not gEgoIsPatti)
						(Print 0 20) ; "That's not a good idea, Larry. Patti wanted that wine!"
					)
					((== (Bottle_of_Wine view:) 28)
						(Print 0 21) ; "The bottle is already empty."
					)
					(else
						(Bottle_of_Wine view: 28)
						(Format (Bottle_of_Wine name:) 0 22) ; "Empty Bottle%"
						(Print 0 23) ; "Ok. It's empty now."
					)
				)
			)
			((Said 'cut,cut,cut>')
				(cond
					((not (gEgo has: 2)) ; Ginsu_Knife
						(Print 0 24) ; "You have nothing with which to cut anything."
					)
					((== (Ginsu_Knife view:) 2)
						(Print 0 25) ; "Your knife is too dull to cut anything."
					)
					((Said '[/!*]')
						(Print 0 26) ; "What do you want to cut?"
					)
					((Said '/blade')
						(Print 0 27) ; "This grass isn't really suitable. Keep looking."
					)
					((not (Said '/carving,granadilla'))
						(Print 0 28) ; "No, find something else to carve."
					)
					((not (gEgo has: 3)) ; Granadilla_Wood
						(Print 0 29) ; "You have nothing to carve."
					)
					(
						(or
							(== (Granadilla_Wood view:) 22)
							(== (Granadilla_Wood view:) 34)
						)
						(Print 0 30) ; "You've already done the best you can."
					)
					((or (== gEgoState 0) (== gEgoState 10))
						(Ok) ; "O.K."
						(gGame setScript: (ScriptID 43)) ; CarvingScript
					)
					(else
						(NotNow) ; "Good idea. You might try that again later."
					)
				)
				(event claimed: 1)
			)
			((or (Said 'use/flower/lei<make') (Said 'weave,make/flower,lei'))
				(cond
					((not (gEgo has: 11)) ; some_Orchids
						(Print 0 31) ; "You have no flowers with which to make a lei."
					)
					((== (some_Orchids view:) 26)
						(Print 0 32) ; "You've already made a lei from the orchids."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Ok) ; "O.K."
						(gGame setScript: (ScriptID 42)) ; LeiingScript
					)
				)
			)
			((Said 'wear,(alter,alter<in),(drop<on)/flower,lei')
				(cond
					((not (gEgo has: 11)) ; some_Orchids
						(Print 0 33) ; "An interesting thought -- but how?"
					)
					((!= (some_Orchids view:) 26)
						(Print 0 34) ; "Right now, they're just a beautiful bunch of orchids."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Print 0 35) ; "You're close, but you are not the person for whom they are intended."
					)
				)
			)
			((or (Said 'use/blade/skirt<make') (Said 'weave,make/blade,skirt'))
				(cond
					((not (gEgo has: 4)) ; Native_Grass
						(Print 0 36) ; "You have no grass."
					)
					((== (Native_Grass view:) 23)
						(Print 0 37) ; "You've already made a skirt from the grass."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Ok) ; "O.K."
						(gGame setScript: (ScriptID 44)) ; WeavingScript
					)
				)
			)
			(
				(or
					(Said 'get,get/naked')
					(Said '(get<off),drain/cloth,cloth')
					(Said 'strip')
				)
				(Print 0 38) ; "Please! Not here."
			)
			((Said 'alter,alter/cloth,cloth')
				(Print 0 39) ; "Be more specific. Say what you want to wear."
			)
			((Said 'wear,(alter,alter<in),(drop<on)/blade,skirt')
				(cond
					((not (gEgo has: 4)) ; Native_Grass
						(Print 0 33) ; "An interesting thought -- but how?"
					)
					((not (== (Native_Grass view:) 23))
						(Print 0 40) ; "It would be difficult to wear a clump of grass."
					)
					(else
						(Print 0 41) ; "A good idea, but you're far too modest to change clothes here."
					)
				)
			)
			((and (gEgo has: 5) (or (Said 'use/soap') (Said 'soap'))) ; Soap-On-A-Rope
				(Print 0 42) ; "A nice shower WOULD feel good!"
			)
			(
				(or
					(Said 'unknownnumber/')
					(Said '/unknownnumber')
					(Said '//unknownnumber')
				)
				(Print 0 43) ; "That's may do something somewhere but not here!"
			)
			(
				(and
					(gEgo has: 10) ; Divorce_Decree
					(not (gEgo has: 9)) ; Spa_Keycard
					(Said 'look,look,look/decree,document,document')
				)
				(gEgo get: 9) ; Spa_Keycard
				(gGame changeScore: 100)
				(Print 0 44) ; "Well, well. Look at this. Somehow Suzi Cheatem's Fat City Membership Card got mixed up in these papers. What a sleuth you are!"
			)
			(
				(and
					(gEgo has: 9) ; Spa_Keycard
					(or
						(Said 'look<back,back,back/keycard,card')
						(Said 'look/back,back,back/keycard,card')
						(Said 'look/(keycard,card)/back,back,back')
						(Said 'look/back,back,back[<keycard,card]')
						(Said 'pull/keycard,card')
						(Said 'look/combination/keycard,card')
					)
				)
				(Ok) ; "O.K."
				(gGame setScript: (ScriptID 45)) ; LockerScript
			)
			((Said 'count>')
				(= temp2 (gInventory saidMe:))
				(cond
					((Said '[/!*]')
						(Print 0 45) ; "What do you want to count?"
					)
					((not temp2)
						(event claimed: 1)
						(Printf 0 46 (= temp156 (Random 10 999)) temp156) ; "You quickly count to %d. Such fun, eh?%"
					)
					((!= (gInventory indexOf: temp2) 6)
						(Print 0 47) ; "How can you count that?"
					)
					((not (temp2 ownedBy: gEgo))
						(Print 0 48) ; "You're busted!"
					)
					(else
						(Printf 0 49 gDollars gDollars) ; "You have %d dollars.%"
					)
				)
			)
			((or (Said 'give/bill,buck') (Said 'bribe,bribe'))
				(cond
					((not (gEgo has: 6)) ; A_Twenty_Dollar_Bill
						(Print 0 50) ; "You have no money."
					)
					((== (A_Twenty_Dollar_Bill view:) 24)
						(Print 0 51 #icon (A_Twenty_Dollar_Bill view:) 0 0) ; ""How about a few of these ones?" you ask."
						(Print 0 52 #at -1 144) ; "(Evidently no one is interested.)"
					)
					((== (A_Twenty_Dollar_Bill view:) 25)
						(Print 0 53 #icon (A_Twenty_Dollar_Bill view:) 0 0) ; ""Hey! Can I give you a tip?" you say."
						(Print 0 54) ; ""Guess not," you think."
					)
					(else
						(Print 0 55 #icon (A_Twenty_Dollar_Bill view:) 0 0) ; "I've got twenty bucks on me," you announce. "Anybody interested?"
						(Print 0 56) ; "There is no response."
					)
				)
			)
			(
				(and
					(gEgo has: 4) ; Native_Grass
					(== (Native_Grass view:) 23)
					(or
						(Said 'dress,dress')
						(Said 'get,get/dress')
						(Said 'get,get<dress')
						(Said
							'wear,alter,alter,(get<off),drain,(drop<on)/skirt,cloth,cloth'
						)
					)
				)
				(Print 0 57) ; "A good idea, but you can't change here!"
			)
			((and (gEgo has: 16) (Said 'drop//(bra)>')) ; Bra
				(= temp2 (gInventory saidMe:))
				(cond
					((Said '[/!*]')
						(Print 0 58) ; "What did you want to put inside your bra?"
					)
					((not temp2)
						(event claimed: 1)
						(Print 0 59) ; "You can't do that here; at least, not now."
					)
					((not (temp2 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 0 60 #icon 16 0 0) ; "Ok. You put it in. It fits. You remove it."
						(Print 0 61 #at -1 144) ; "(Pretty much fun, eh?)"
					)
				)
			)
			((and (gEgo has: 2) (or (Said 'use/ginsu') (Said 'stab'))) ; Ginsu_Knife
				(Print 0 62) ; "Hey! We want our R rating for sex, not violence!"
			)
			((Said 'open,(look,look<in)>')
				(= temp2 (gInventory saidMe:))
				(cond
					((Said '[/!*]')
						(Print 0 63) ; "What do you want to inspect?"
					)
					((not temp2)
						(event claimed: 1)
						(Print 0 59) ; "You can't do that here; at least, not now."
					)
					((not (temp2 ownedBy: gEgo))
						(Print 0 64) ; "You see nothing special."
					)
					(else
						(switch (gInventory indexOf: temp2)
							(11
								(Print 0 65 #icon 11 0 0) ; "The orchids look perfectly safe."
							)
							(13
								(switch (Bottle_of_Wine view:)
									(28
										(Print 0 66 #icon 28 0 0) ; "The bottle is empty. Not even a note!"
									)
									(29
										(Print 0 67 #icon 29 0 0) ; "The water is still inside the bottle."
									)
									(else
										(Print 0 68 #icon 13 0 0) ; "The bottle is full of wine."
									)
								)
							)
							(14
								(Print 0 69 #icon 14 0 0) ; "100% Pure Silk"
							)
							(15
								(Print 0 70 #icon 15 0 0) ; "Extra Sheer"
							)
							(16
								(Print 0 71 #icon 16 0 0) ; "36C"
							)
							(17
								(Print 0 72 #icon 17 0 0) ; "You look pretty good, if you do think so yourself!"
							)
							(19
								(Print 0 73 #icon 19 0 0) ; "You can not open the coconuts."
							)
							(else
								(Print 0 64) ; "You see nothing special."
								(LameResponse)
							)
						)
					)
				)
			)
			((Said 'hello,hello')
				(Print 0 74) ; "Hi."
			)
			((or (Said '/bye') (Said 'bye'))
				(Print 0 15) ; "Goodbye."
			)
			((Said 'thank')
				(Print 0 75) ; "You're welcome."
			)
			((Said 'knock')
				(Print 0 76) ; "Knock, knock."
				(Print (Format @temp6 0 77 gEgoName gEgoName) #at -1 144) ; "(Nobody wants to play that game, %s!)%"
			)
			((Said 'hit')
				(Print 0 62) ; "Hey! We want our R rating for sex, not violence!"
			)
			((or (Said 'go/bathroom') (Said 'leak,leak') (Said 'get/leak,leak'))
				(if gEgoIsPatti
					(Print 0 78) ; "Patti!"
					(Print 0 79 #at -1 144) ; "(Really!"
				else
					(Print 0 80) ; "A warm feeling spreads down your leg."
				)
			)
			((Said 'climb>')
				(cond
					((Said '/wall,building')
						(Print 0 81) ; "Climbing the walls already?"
					)
					(gEgoIsPatti
						(Print 0 82) ; "You'd better not. You might rip your dress."
					)
					(else
						(Print 0 83) ; "That would be unbecoming a man of leisure."
					)
				)
				(event claimed: 1)
			)
			((or (Said '//larry') (Said '/larry'))
				(cond
					((not gEgoIsPatti)
						(Print 0 84) ; "Talking to yourself again, Larry?"
					)
					((< gCurRoomNum 590)
						(Print 0 85) ; "You really miss him, don't you, Patti?"
					)
					(else
						(Print 0 86) ; "You are so glad you two are back together!"
					)
				)
			)
			((Said 'jump,dance,dance')
				(Print 0 87) ; "Whee!"
			)
			((Said 'sing')
				(Print 0 88) ; "FEELINGS! NOTHING MORE THAN FEELINGS!!"
			)
			((Said 'delay')
				(Print 0 89) ; "Isn't that what you are doing?"
			)
			((Said 'pick')
				(Print 0 90) ; "If you pick it, it won't heal!"
			)
			((Said 'yell')
				(Print 0 91) ; "HELP!"
			)
			((Said 'rob')
				(Print 0 92) ; "That's against the law!"
			)
			((or (Said 'no') (Said 'yes'))
				(Ok) ; "O.K."
			)
			((Said 'borrow')
				(Print 0 93) ; "Who would loan you anything?"
			)
			((Said 'cheat')
				(Print 0 94) ; "Ok, you win.\05"
				(Print 0 95 #at -1 144) ; "(Game over."
				(= gQuit 1)
			)
			((Said '(drop<on),wear>')
				(cond
					((Said '[/!*]')
						(Print 0 96) ; "What do you want to wear?"
					)
					((= temp2 (gInventory saidMe:))
						(cond
							((not (gEgo has: (gInventory indexOf: temp2)))
								(DontHave) ; "You don't have it."
							)
							(
								(or
									(== temp2 16)
									(== temp2 17)
									(== temp2 14)
									(== temp2 15)
								)
								(YouAre) ; "You are."
							)
							(else
								(Print 0 97) ; "You'd look better if you didn't!"
							)
						)
					)
					(else
						(Print 0 98) ; "You can't wear what is not yours."
						(event claimed: 1)
					)
				)
			)
			((Said 'drop,drop>')
				(cond
					((Said '[/!*]')
						(Print 0 99) ; "What do you want to drop?"
					)
					((= temp2 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp2)))
							(DontHave) ; "You don't have it."
						else
							(Print 0 100) ; "Nah. Better not!"
						)
					)
					(else
						(Print 0 101) ; "It's not yours to drop."
						(event claimed: 1)
					)
				)
			)
			((Said 'throw>')
				(cond
					((Said '[/!*]')
						(Print 0 102) ; "What do you want to throw?"
					)
					((= temp2 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp2)))
							(DontHave) ; "You don't have it."
						else
							(Print 0 103) ; "Nah. You might need it later!"
						)
					)
					(else
						(Print 0 104) ; "That doesn't belong to you."
						(event claimed: 1)
					)
				)
			)
			((Said 'smell,smell,smell')
				(Print 0 105) ; "Sniff, sniff."
				(cond
					((TestFlag 8)
						(Print 0 106) ; "You should have showered after that workout!"
					)
					((TestFlag 10)
						(Print 0 107) ; "You should have used soap during your shower!"
					)
					((TestFlag 62)
						(Print 0 108) ; "Your deodorant has failed!"
					)
				)
			)
			((Said 'whistle')
				(Print 0 109) ; "You whistle a happy tune."
			)
			((Said 'ask/job')
				(Print 0 110) ; ""Is there any chance I could get a job around here?" you say."
				(Print 0 111 #at -1 144) ; "(There is no response.)"
			)
			((and gEgoIsPatti (or (Said '/arnold') (Said '//arnold')))
				(Print 0 112) ; "Forget about that creep, Patti!"
			)
			((Said 'laugh')
				(Print 0 113) ; "Ha, ha!"
			)
			((Said 'eat,eat')
				(Print 0 114) ; "Once you tasted it, you wouldn't want it!"
			)
			((Said 'lie,lie')
				(Print 0 115) ; "There's no time!"
			)
			((Said 'aid,aid/me,self')
				(Print 0 116) ; "Stop your whining!"
			)
			((Said 'aid,aid')
				(Print 0 117) ; "How would you help?"
			)
			((Said 'explore>')
				(if (Said '/cloth,panties,entertainer,larry')
					(Print 0 118) ; "Searching through your clothes you find..."
					(gInventory showSelf: gEgo)
				else
					(event claimed: 1)
					(Print 0 119) ; "You find nothing."
				)
			)
			((or (Said '/fuck,fuck/you') (Said 'fuck,fuck/you'))
				(Print 0 120) ; "Same to you, buddy!"
			)
			((Said 'fuck,fuck/anyword')
				(Print 0 121) ; "Yeah, you probably would, too!"
			)
			((or (Said 'caress/me,larry,self') (Said 'jack'))
				(Print 0 122) ; "Aren't your palms hairy enough?"
			)
			((Said 'caress,caress,embrace,embrace,embrace,look,look/clit')
				(Printf 0 123 gEgoName gEgoName) ; "Obviously, restraint is no problem for you, %s.%"
			)
			((Said 'eat/woman')
				(Print 0 124) ; "That comes later."
			)
			((or (Said 'look,look<in/blouse') (Said 'look,look<up/skirt'))
				(Print 0 125) ; "You see something special."
			)
			((Said 'drink,drink')
				(Print 0 126) ; "Nobody's THAT thirsty!"
			)
			((or (Said 'use/key') (Said 'unbolt'))
				(Print 0 127) ; "It's not that easy!"
			)
			((or (Said '/book') (Said '//book'))
				(Print 0 128) ; "It's in the box your disks came in. Have you read it?"
			)
			((Said 'listen')
				(Print 0 129) ; "If you are very quiet, you can hear your keyboard click."
			)
			((Said 'embrace,embrace,embrace')
				(Print 0 130) ; "Wouldn't you rather just remain friends?"
			)
			(
				(or
					(Said 'eat,fuck,fuck/me')
					(Said 'shit,shit,leak,leak,fuck,fuck,fart,fart')
					(Said
						'/clit,shit,shit,leak,leak,fuck,fuck,fart,fart,bullshit'
					)
					(Said
						'//clit,shit,shit,leak,leak,fuck,fuck,fart,fart,bullshit'
					)
				)
				(Print 0 131) ; "Tsk, tsk."
			)
			((or (Said '/hell') (Said '//hell'))
				(Print 0 132) ; "That's probably where you'll end up!"
			)
			((Said 'look,look>')
				(cond
					((Said '/self,larry,entertainer,me,blouse,cloth,panties')
						(if (not gEgoIsPatti)
							(Print 0 133) ; "You look pretty good, if you do say so yourself!"
						else
							(Print 0 134) ; "You look great, no matter what you wear!"
						)
					)
					((and (== (gEgo view:) 718) (Said '/sunglass'))
						(Print 0 135) ; "You're too cool!"
					)
					((Said '/ankle,sandal')
						(if (== (gEgo view:) 718)
							(Print 0 136) ; "Your toes are so ugly!"
						else
							(Print 0 137) ; "Your feet should hurt, what with all this walking!"
						)
					)
					((Said '/bush,palm')
						(Print 0 138) ; "You see many leaves."
					)
					((Said '/man,woman,couple')
						(Print 0 139) ; "Where?"
					)
					((Said '/wall,building')
						(Print 0 140) ; "Staring at the walls already?"
					)
					((Said '/carpet,down')
						(Print 0 141) ; "It just lies there, under your feet."
					)
					((Said '/air,ceiling')
						(Print 0 142) ; "It's still up there!"
					)
					((Said '/boob')
						(if gEgoIsPatti
							(Print 0 143) ; "Hey! That's Larry's line!"
						else
							(Print 0 144) ; "You really love this, don't you!"
						)
					)
					((Said '/ass')
						(if gEgoIsPatti
							(Print 0 145) ; "Tight butts drive you nuts!"
						else
							(Print 0 146) ; "Has it been 30 seconds already?"
						)
					)
					((Said '<in/cup')
						(Print 0 147) ; "This game does not encourage voyeurism!"
					)
					((= temp2 (gInventory saidMe:))
						(if (temp2 ownedBy: gEgo)
							(temp2 showSelf:)
						else
							(Print 0 64) ; "You see nothing special."
						)
					)
					(else
						(switch (Random 42 44)
							(42
								(Print 0 148) ; "It's just as it appears."
							)
							(43
								(Print 0 149) ; "It doesn't look interesting."
							)
							(44
								(Print 0 64) ; "You see nothing special."
							)
						)
						(event claimed: 1)
						(LameResponse)
					)
				)
			)
			((or (Said 'use,buy/bill,tips,buck') (Said 'buy'))
				(if (gEgo has: 6) ; A_Twenty_Dollar_Bill
					(Print 0 150) ; "There's nothing worth buying here."
				else
					(Print 0 151) ; "You're broke!"
				)
			)
			((Said 'use>')
				(= temp2 (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 0 152) ; "What do you want to use?"
					)
					((not temp2)
						(Print 0 153) ; "You can't do that here; at least, not now."
					)
					((not (temp2 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 0 154) ; "There's no need to use it here."
						(LameResponse)
					)
				)
				(event claimed: 1)
			)
			((Said 'give>')
				(= temp2 (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '/anyword[/!*]')
						(Print 0 155) ; "To whom?"
					)
					((Said '[/!*]')
						(Print 0 156) ; "What do you want to give?"
					)
					((not temp2)
						(Print 0 157) ; "It's not yours to give."
					)
					((not (temp2 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 0 158) ; "You have no reason to do that."
						(LameResponse)
					)
				)
				(event claimed: 1)
			)
			((Said 'get,get<down')
				(Print 0 159) ; "You get down from a duck, but not here!"
			)
			((Said 'get,get<up')
				(Print 0 160) ; "You already are "up for the game!""
			)
			((Said 'get,get>')
				(cond
					((Said '[/!*]')
						(Print 0 161) ; "What do you want to take?"
					)
					((and (= temp2 (gInventory saidMe:)) (temp2 ownedBy: gEgo))
						(Print 0 162) ; "You already have it."
					)
					((== temp2 3)
						(Print 0 163) ; "There is no wood here that strikes your fancy."
					)
					(else
						(switch (Random 33 35)
							(33
								(Print 0 164) ; "It's of no use."
							)
							(34
								(Print 0 165) ; "You don't need it."
							)
							(35
								(Print 0 166) ; "There's no reason to take it."
							)
						)
						(LameResponse)
					)
				)
				(event claimed: 1)
			)
			((= temp2 (gInventory saidMe:))
				(if (not (temp2 ownedBy: gEgo))
					(DontHave) ; "You don't have it."
				else
					(Print 0 167) ; "You can't do that now."
				)
			)
			((Said 'talk,talk>')
				(if (Said '[/!*]')
					(Print 0 155) ; "To whom?"
				else
					(Print 0 168) ; ""Hello," you say."
					(Print 0 169 #at -1 144) ; "(There is no response.)"
					(event claimed: 1)
				)
			)
			(
				(or
					(Said
						'/clit,shit,shit,leak,leak,fuck,fuck,asshole,boob,ass,bullshit'
					)
					(Said
						'//clit,shit,shit,leak,leak,fuck,fuck,asshole,boob,ass,bullshit'
					)
				)
				(Print 0 170) ; "Ok, but I don't usually do that!"
			)
			((or (Said '//woman') (Said '/woman/') (Said '/woman'))
				(Print 0 171) ; "She doesn't seem interested in that!"
			)
		)
	)
)

(class Iitem of InvI
	(properties)

	(method (showSelf &tmp temp0)
		(= temp0 (RestoreSubLang))
		(Print 30 (- view loop) #title name #icon view 0 0)
		(if temp0
			(SaveSubLang)
		)
	)
)

(instance Nothing of Iitem
	(properties)
)

(instance Credit_Card of Iitem
	(properties
		name {Credit Card}
		view 1
	)

	(method (saidMe)
		(if (gEgo has: 9) ; Spa_Keycard
			(return 0)
		else
			(return (Said '/card'))
		)
	)
)

(instance Ginsu_Knife of Iitem
	(properties
		name {Ginsu Knife}
		said '/ginsu'
		view 2
	)
)

(instance Granadilla_Wood of Iitem
	(properties
		name {Granadilla Wood}
		view 3
	)

	(method (saidMe)
		(if (== view 22)
			(Said '/granadilla,carving')
			(return)
		else
			(Said '/granadilla')
			(return)
		)
	)
)

(instance Native_Grass of Iitem
	(properties
		name {Native Grass}
		owner 230
		view 4
	)

	(method (saidMe)
		(if (== view 23)
			(Said '/skirt')
			(return)
		else
			(Said '/blade')
			(return)
		)
	)
)

(instance Soap_On_A_Rope of Iitem
	(properties
		name {Soap-On-A-Rope}
		said '/soap'
		owner 253
		view 5
	)
)

(instance A_Twenty_Dollar_Bill of Iitem
	(properties
		name {A Twenty Dollar Bill}
		view 6
	)

	(method (saidMe)
		(cond
			((== view 24)
				(Said '/buck,500,500')
				(return)
			)
			((== view 25)
				(Said '/buck,tips,jar,43')
				(return)
			)
			(else
				(Said '/buck,20,bill,20')
				(return)
			)
		)
	)
)

(instance Land_Deed of Iitem
	(properties
		name {Land Deed}
		said '/deed'
		view 7
	)

	(method (showSelf)
		(= view (LangSwitch 7 920))
		(= loop (LangSwitch 0 913))
		(super showSelf: &rest)
	)
)

(instance Beach_Towel of Iitem
	(properties
		name {Beach Towel}
		said '/towel'
		view 8
	)
)

(instance Spa_Keycard of Iitem
	(properties
		name {Spa Keycard}
		said '/keycard,card'
		view 9
	)
)

(instance Divorce_Decree of Iitem
	(properties
		name {Divorce Decree}
		said '/decree,decree'
		view 10
	)

	(method (showSelf)
		(= view (LangSwitch 10 900))
		(= loop (LangSwitch 0 890))
		(super showSelf: &rest)
	)
)

(instance some_Orchids of Iitem
	(properties
		name {some Orchids}
		owner 235
		view 11
	)

	(method (saidMe)
		(if (== view 26)
			(Said '/flower,lei')
			(return)
		else
			(Said '/flower')
			(return)
		)
	)
)

(instance Penthouse_Key of Iitem
	(properties
		name {Penthouse Key}
		said '/key'
		owner 450
		view 12
	)
)

(instance Bottle_of_Wine of Iitem
	(properties
		name {Bottle of Wine}
		view 13
	)

	(method (saidMe)
		(cond
			((== view 28)
				(Said '/bottle')
				(return)
			)
			((== view 29)
				(Said '/bottle,water')
				(return)
			)
			(else
				(Said '/bottle,beer')
				(return)
			)
		)
	)
)

(instance Panties of Iitem
	(properties
		said '/panties'
		owner 484
		view 14
	)
)

(instance Pantyhose of Iitem
	(properties
		said '/hose'
		owner 484
		view 15
	)
)

(instance Bra of Iitem
	(properties
		said '/bra'
		owner 484
		view 16
	)
)

(instance Dress of Iitem
	(properties
		said '/dress,dress'
		owner 484
		view 17
	)
)

(instance Magic_Marker of Iitem
	(properties
		name {Magic Marker}
		said '/marker'
		view 18
	)
)

(instance Coconuts of Iitem
	(properties
		said '/coconut'
		owner 530
		view 19
	)
)

(instance Marijuana of Iitem
	(properties
		said '/dope,dope'
		owner 530
		view 20
	)

	(method (saidMe)
		(if (== view 27)
			(Said '/dope,lasso,hemp')
			(return)
		else
			(Said '/dope')
			(return)
		)
	)
)

(instance statusCode of Code
	(properties)

	(method (doit str)
		(if global303
			(Format str 0 172 gScoreDisplayed 0 173 gCurRoomNum) ; "Score: %d of 4000 %7s Room Number: %d"
		else
			(Format ; "Score: %d of 4000 %7s %s%"
				str
				0
				174
				gScoreDisplayed
				0
				173
				(if gEgoIsPatti {Passionate Patti} else {Leisure Suit Larry 3})
				gScoreDisplayed
				0
				173
				(if gEgoIsPatti {Passionate Patti} else {Leisure Suit Larry 3})
			)
		)
	)
)

(instance ego of Ego
	(properties
		y 1111
		view 700
	)
)

(instance scoreSound of Sound
	(properties
		number 1
		priority 10
	)
)

(instance theMusic of Sound
	(properties
		number 1
	)
)

(instance theSoundFX of Sound
	(properties
		number 1
		priority 5
	)
)

(instance theWindow of SysWindow
	(properties)

	(method (open)
		(if (< (Graph grGET_COLOURS) 9)
			(if (or (< color 7) (== color 8))
				(= color 0)
				(= back 15)
			else
				(= color 15)
				(= back 0)
			)
		)
		(super open:)
	)
)

(instance NormalBase of Code
	(properties)

	(method (doit &tmp w)
		(if (== gCurRoomNum 253)
			(= w 22)
		else
			(= w 10)
		)
		(gEgo brBottom: (+ (gEgo y:) 1))
		(gEgo brTop: (- (gEgo brBottom:) (gEgo yStep:)))
		(gEgo brLeft: (- (gEgo x:) w))
		(gEgo brRight: (+ (gEgo x:) w))
	)
)

