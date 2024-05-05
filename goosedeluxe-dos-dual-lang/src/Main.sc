;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n091)
(use n098)
(use StopEgo)
(use MGNarrator)
(use EgoTalk)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use Talker)
(use PFollow)
(use IconBar)
(use Feature)
(use Ego)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	MG 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_13 13
	proc0_14 14
	proc0_16 16
	proc0_17 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
	proc0_21 21
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gThePlane
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gPlanes
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gTextCode
	gCuees
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gEventMask = 32767
	gBigFont = 1
	gVersion
	gAutoRobot
	gCurSaveDir
	; 30
	gNumCD
	gPerspective
	gFeatures
	gPanels
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemPlane
	gSaveFileSelText
	; 40
	global40
	global41
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
	gEndSysLogPath
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gApproachCode
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
	gSpeechHandler
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	gExtMouseHandler
	gTalkers
	; 85
	gInputFont
	gTickOffset
	gHowFast
	gGameTime
	gNarrator
	; 90
	gMsgType = 1
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
	; 95
	gAltPolyList
	gScreenWidth = 320
	gScreenHeight = 200
	gLastScreenX = 319
	gLastScreenY = 199
	; 100
	global100
	global101 = 1234
	gLongSong
	global103
	global104 = 1
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
	global118 = 1
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
	gShell2
	; 135
	gShell3
	gShell4
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	gStdWalkIn
	gStdWalkOut
	; 145
	gStdClimbIn
	gStdClimbOut
	global147
	global148
	global149
	; 150
	global150
	gPlace
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
	gSfx
	global161
	gDoInvBut
	global163
	global164
	; 165
	global165
	global166
	global167
	global168
	gLanguage
	; 170
	global170
	global171
	global172
	global173
	global174
	; 175
	global175
	global176 = 1
	global177 = 1
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
	global200 = -1
	global201 = -1
	global202
	global203 = -1
	global204 = -1
	; 205
	global205 = -1
	global206
	global207 = -1
	global208
	global209 = -1
	; 210
	global210 = -1
	global211
	global212 = -1
	global213 = -1
	global214
	; 215
	global215 = -1
	global216
	global217
	global218 = -1
	global219
	; 220
	global220
	global221 = -1
	global222
	global223 = -1
	global224
	; 225
	global225 = -1
	global226
	global227 = -1
	global228
	global229
	; 230
	global230
	global231 = -1
	global232 = -1
	global233 = -1
	global234
	; 235
	global235
	global236 = -1
	global237 = -1
	global238 = -1
	global239
	; 240
	global240
	global241 = -1
	global242 = -1
	global243 = -1
	global244
	; 245
	global245 = -1
	gJillBody
	global247
	global248
	gGoals
	; 250
	global250 = 1
	global251 = 49
	global252 = 33
	global253 = 34
	global254 = 81
	; 255
	global255 = 1
	global256 = 49
	global257 = 133
	global258 = 134
	global259 = 181
	; 260
	global260 = 1
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
	gWave
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
	gList
	global514
	; 515
	global515
	global516
	gTalkEgo
	gEgoName
	gMacSaveNumber
	; 520
	global520
	global521
	global522
)

(procedure (proc0_13 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (proc0_14 param1 param2 param3)
	(if (< param1 param2 param3)
		(if (< param2 (/ (+ param1 param3) 2))
			(= param2 param1)
		else
			(= param2 param3)
		)
	)
	(return param2)
)

(procedure (proc0_1 param1 param2)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
		)
	)
	(gEgo
		view: global114
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: StopEgo
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 1
	)
)

(procedure (proc0_4)) ; UNUSED

(procedure (proc0_5)
	(FrameOut)
)

(procedure (proc0_6))

(procedure (proc0_8 param1 param2 param3 param4)
	(= global115 param3)
	(= global116 param4)
	(place x: param1 y: param2)
	(if
		(and
			global129
			(or (> global130 47) (!= gStdClimbIn (gCurRoom script:)))
			global129
		)
		(if (or (< gCurRoomNum 36) (== gCurRoomNum 41) (<= global130 47))
			(global129 init: z: 0)
		else
			(global129 init: z: 13)
		)
	)
	(if global150
		(global150 init: 1)
		(= global165 (if (== (global150 view:) 45) 30 else 20))
	)
)

(procedure (proc0_9)
	(Load rsFONT 8)
	(Load rsFONT 9)
	(= global130 0)
	(= global107 0)
	(= global104 1)
)

(procedure (proc0_10 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
		(if ((gGoals at: temp0) egoHas:)
			(break)
		)
	)
	((gGoals at: temp0) egoHas: 0 egoReturned: 1)
	(if (== global123 (+ temp0 1))
		(= global123 0)
	)
	(if (and global129 (!= gCurRoomNum 23))
		(global129 dispose:)
	)
	(= global129 0)
	(= global130 0)
	(if (not global172)
		(gGame changeScore: 1)
		(icon3 draw:)
	)
	(= global104 0)
)

(procedure (proc0_11)) ; UNUSED

(procedure (proc0_19 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
		(Palette 2 0 255 temp0) ; PalIntensity
	)
)

(procedure (proc0_17 param1)
	(return
		(switch param1
			(41 601)
			(42 602)
			(44 608)
			(45 603)
			(46 609)
			(47 604)
			(60 606)
			(else 605)
		)
	)
)

(procedure (proc0_16 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
	(if global512
		(global512 dispose:)
		(global514 dispose:)
		(= global514 (= global512 0))
	)
	(if (and global118 param1)
		(= temp3 (Str format: {%s} param1))
		(= temp4 (Str format: {%s} param1))
		(= temp1 (if (and (> argc 1) (>= param2 0)) param2 else 5))
		(= temp0 (if (and (> argc 2) (>= param3 0)) param3 else 5))
		(= temp2 (if (and (> argc 3) (>= param4 0)) param4 else 0))
		(= global512
			((DText new:)
				font: 9
				setPri: 254
				text: (temp3 data:)
				fore: temp2
				posn: temp0 temp1
				setSize: 250
				init:
				yourself:
			)
		)
		(= global514
			((DText new:)
				font: 8
				setPri: 255
				text: (temp4 data:)
				fore: 7
				posn: temp0 temp1
				setSize: 250
				init:
				yourself:
			)
		)
		(temp3 data: 0 dispose:)
		(temp4 data: 0 dispose:)
	)
)

(procedure (proc0_7 param1 param2 &tmp temp0 temp1 temp2)
	(switch
		(= temp1
			(if
				(<
					(= temp0
						(GetAngle
							(param1 x:)
							(param1 y:)
							(param2 x:)
							(param2 y:)
						)
					)
					45
				)
				3
			else
				(/ (- temp0 45) 90)
			)
		)
		(0
			(= temp2 0)
		)
		(1
			(= temp2 2)
		)
		(2
			(= temp2 1)
		)
		(3
			(= temp2 3)
		)
	)
	(param1 loop: temp2 cel: 0)
	(param1 doit:)
	(if (== argc 3)
		(proc0_7 param2 param1)
	)
)

(procedure (proc0_21 param1) ; UNUSED
	(if param1
		(Printf &rest)
	else
		(Prints &rest)
	)
)

(procedure (proc0_18 param1 param2) ; UNUSED
	(return
		(and
			(== (param2 type:) 1)
			(>= (param2 x:) (param1 nsLeft:))
			(<= (param2 x:) (param1 nsRight:))
			(>= (param2 y:) (param1 nsTop:))
			(<= (param2 y:) (param1 nsBottom:))
		)
	)
)

(procedure (proc0_20)
	(= global104 1)
)

(procedure (proc0_2)
	(gGame handsOff:)
)

(procedure (proc0_3) ; UNUSED
	(gGame handsOn:)
)

(class MGIconInvItem of Prop
	(properties
		client 0
	)

	(method (onMe)
		(return (client onMe: &rest))
	)
)

(instance MGUser of User
	(properties)

	(method (handleEvent event)
		(= global520 1)
		(if global511
			(global511 checkCursor: event &rest)
		)
		(if (== global511 MgButtonBar)
			(cond
				(
					(and
						(or (== (event type:) evMOUSEBUTTON) (== (event type:) evMOUSERELEASE))
						(not global520)
					)
					(event claimed: 1)
					(event dispose:)
				)
				((!= (event type:) evMOUSERELEASE)
					(super handleEvent: event &rest)
				)
				(else
					(event claimed: 1)
					(event dispose:)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(class MgButtonBar of Cast
	(properties
		saveCursor 0
	)

	(method (checkCursor param1 &tmp temp0 temp1 temp2)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
		)
		(if (icon7 x:)
			(if
				(and
					(!= (= temp0 (self firstTrue: #onMe param1)) icon7)
					(!= temp0 icon8)
					(!= temp0 icon9)
				)
				(= temp0 0)
			)
		else
			(= temp0 0)
		)
		(cond
			((or (gUser canControl:) temp0)
				(if (= temp0 (self firstTrue: #onMe param1))
					(temp0 changeCursor:)
				else
					(param1 globalize:)
					(if (gThePlane onMe: param1)
						(param1 localize: gThePlane)
						(= temp1 (param1 x:))
						(= temp2 (param1 y:))
						(cond
							((== gCurRoomNum 45) ; mapRoom
								(if (!= gTheCursor 10)
									(gGame setCursor: 10)
								)
							)
							(
								(and
									gCurRoom
									(<= (gCurRoom edgeE:) (+ temp1 10))
									(<= temp2 (gCurRoom edgeS:))
								)
								(if (!= gTheCursor 2)
									(gGame setCursor: 2)
								)
							)
							(
								(and
									gCurRoom
									(<= temp1 (gCurRoom edgeW:))
									(<= temp2 (gCurRoom edgeS:))
								)
								(if (!= gTheCursor 4)
									(gGame setCursor: 4)
								)
							)
							(
								(and
									gCurRoom
									(<= (gCurRoom edgeS:) (+ temp2 10))
									(<= temp1 (gCurRoom edgeE:))
								)
								(if (!= gTheCursor 3)
									(gGame setCursor: 3)
								)
							)
							(
								(and
									gCurRoom
									(<= temp2 (gCurRoom edgeN:))
									(<= temp1 (gCurRoom edgeE:))
								)
								(if (!= gTheCursor 5)
									(gGame setCursor: 5)
								)
							)
							((!= gTheCursor gNormalCursor)
								(gGame setCursor: gNormalCursor)
							)
						)
					else
						(if (!= gTheCursor 6)
							(gGame setCursor: 6)
						)
						(= global520 0)
					)
				)
			)
			((!= gTheCursor 8)
				(gGame setCursor: 8)
			)
		)
	)

	(method (init)
		(if (not plane)
			(= plane (Plane new:))
			(plane
				back: 0
				priority: 1
				init: 0 0 319 199
				drawPic: 800
				addCast: self
			)
			(self add: icon0 icon1 icon2 icon3 icon4 icon5 icon6)
			(self eachElementDo: #init self)
			(plane setSize:)
		else
			(self eachElementDo: #init self)
		)
	)
)

(class MGIconItem of IconI
	(properties
		saveCursor 0
		obj 0
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (== (event type:) evMOUSEBUTTON)
				(self select:)
			)
		)
	)

	(method (checkCursor param1)
		(cond
			((self onMe: param1)
				(if (not saveCursor)
					(= saveCursor gTheCursor)
					(self changeCursor:)
				)
			)
			(saveCursor
				(gGame setCursor: 6)
				(= saveCursor 0)
			)
		)
		(return 1)
	)

	(method (changeCursor))

	(method (onMe param1)
		(if (and (< nsTop (param1 y:) nsBottom) (< nsLeft (param1 x:) nsRight))
			(return 1)
		else
			(return 0)
		)
	)

	(method (figureNSBorders))

	(method (draw))
)

(instance icon0 of MGIconItem
	(properties
		nsLeft 267
		nsRight 319
		nsBottom 38
		x 272
		y 4
		mainView 801
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(self cel: mainCel)
	)

	(method (select)
		(if (and (gUser canControl:) (super select: 1))
			(if (gCurRoom script:)
				(gCurRoom setScript: 0)
			)
			(gGame handsOff:)
			(icon7 init:)
			(icon8 init:)
			(icon9 init:)
			(SetCursor (+ (icon7 x:) 12) (+ (icon7 y:) 12))
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (== (event type:) evMOUSEBUTTON) (gUser canControl:))
				(gSfx number: 811 play:)
				(self select:)
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance icon1 of MGIconItem
	(properties
		x 290
		y 77
		mainView 801
		mainLoop 2
	)

	(method (init)
		(self setPri: 255)
		(gGame masterVolume: 14)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2)
		(if (gUser canControl:)
			(= temp2 cel)
			(self setPri: 255)
			(UpdateScreenItem self)
			(FrameOut)
			(repeat
				(= temp0 (Event new:))
				(temp0 localize: plane)
				(= temp1 (temp0 y:))
				(= cel (proc0_13 0 (/ (- temp1 47) 3) (- (NumCels self) 1)))
				(if (!= temp2 cel)
					(gGame masterVolume: (- 14 (* cel 2)))
					(= temp2 cel)
					(UpdateScreenItem self)
					(FrameOut)
				)
				(if (== (temp0 type:) evMOUSERELEASE)
					(break)
				)
				(temp0 dispose:)
			)
			(temp0 dispose:)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance icon2 of MGIconItem
	(properties
		x 292
		y 160
		mainView 801
		mainLoop 1
		mainCel 3
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(gEgo cycleSpeed: mainCel moveSpeed: mainCel)
	)

	(method (select &tmp temp0 temp1 temp2)
		(if (gUser canControl:)
			(= temp2 cel)
			(self setPri: 255)
			(UpdateScreenItem self)
			(FrameOut)
			(repeat
				(= temp0 (Event new:))
				(temp0 localize: plane)
				(= temp1 (temp0 y:))
				(= cel (proc0_13 0 (/ (- temp1 104) 4) (- (NumCels self) 1)))
				(if (!= temp2 cel)
					(= temp2 cel)
					(gEgo cycleSpeed: cel moveSpeed: cel)
					(UpdateScreenItem self)
					(FrameOut)
				)
				(if (== (temp0 type:) evMOUSERELEASE)
					(break)
				)
				(temp0 dispose:)
			)
			(temp0 dispose:)
		)
	)

	(method (onMe param1)
		(if
			(and
				(< (- x 16) (param1 x:) (+ x 12))
				(< (- y 60) (param1 y:) (- y 20))
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)
)

(instance icon3 of MGIconItem
	(properties
		x 219
		y 166
		priority 255
		mainView 202
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(self cel: mainCel)
	)

	(method (select)
		(if gDoInvBut
			(gDoInvBut doit:)
		)
	)

	(method (changeCursor)
		(cond
			((and obj (== gCurRoomNum 45)) ; mapRoom
				(if (!= gTheCursor 10)
					(gGame setCursor: 10)
				)
			)
			((!= gTheCursor 6)
				(gGame setCursor: 6)
			)
		)
	)

	(method (draw &tmp temp0)
		(if obj
			(obj dispose:)
			(= obj 0)
		)
		(if (== global130 0)
			(= view mainView)
			(= loop mainLoop)
			(= cel mainCel)
		else
			(= temp0 (+ global130 56))
			(= obj
				((MGIconInvItem new:)
					view:
						(switch (gGame printLang:)
							(33
								(if (== temp0 114) 1114 else temp0)
							)
							(else temp0)
						)
					loop: 1
					cel: 0
					setPri: 255
					posn:
						(+ 219 (/ (- 39 (CelWide temp0 loop 15)) 2))
						(+ 167 (/ (- 29 (CelHigh temp0 loop 15)) 2))
					client: self
					init: global511
					yourself:
				)
			)
		)
	)
)

(instance icon4 of MGIconItem
	(properties
		x 265
		y 163
		mainView 801
		mainLoop 6
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(self cel: mainCel)
	)

	(method (select)
		(if (and (gUser canControl:) (!= gCurRoomNum 45) (super select: 1)) ; mapRoom
			(cond
				((gCurRoom script:) 0)
				(global301
					(gCurRoom setScript: global301)
				)
				(else
					(gCurRoom setScript: saySomething)
				)
			)
		)
	)

	(method (changeCursor)
		(cond
			((== gCurRoomNum 45) ; mapRoom
				(if (!= gTheCursor 6)
					(gGame setCursor: 6)
				)
			)
			((!= gTheCursor 10)
				(gGame setCursor: 10)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(gUser canControl:)
					(!= gCurRoomNum 45) ; mapRoom
				)
				(gSfx number: 813 play:)
				(self select:)
			)
		)
	)
)

(instance icon5 of MGIconItem
	(properties
		nsLeft 154
		nsTop 173
		nsRight 212
		nsBottom 199
		x 157
		y 166
		mainView 801
		mainLoop 4
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(self cel: mainCel)
	)

	(method (select)
		(if
			(and
				(gUser canControl:)
				(super select: 1)
				(not (gCurRoom script:))
			)
			(if (== gCurRoomNum 45) ; mapRoom
				(gCurRoom newRoom: gPrevRoomNum)
			else
				(gCurRoom newRoom: 45) ; mapRoom
			)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (== (event type:) evMOUSEBUTTON) (gUser canControl:))
				(gSfx number: 809 play:)
				(self select:)
			)
		)
	)
)

(instance icon6 of MGIconItem
	(properties
		x 23
		y 177
		mainView 801
		mainLoop 7
	)

	(method (init)
		(self setPri: 254)
		(super init: &rest)
		(self cel: mainCel)
	)

	(method (select)
		(return 1)
	)

	(method (changeCursor)
		(if (!= gTheCursor 6)
			(gGame setCursor: 6)
		)
	)
)

(instance icon7 of MGIconItem
	(properties
		y 62
		mainView 801
		mainLoop 8
	)

	(method (init)
		(self setPri: 255 x: 90)
		(super init: &rest)
		(global511 add: self)
	)

	(method (dispose)
		(global511 delete: self)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (select)
		(if (super select: 1)
			(gCurRoom setScript: saveScript)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed: 1)
				(super handleEvent: event &rest)
				(icon8 dispose:)
				(icon9 dispose:)
				(self dispose:)
			)
			((and (self onMe: event) (== (event type:) evMOUSEBUTTON))
				(gSfx number: 801 play:)
				(event claimed: 1)
				(self select:)
			)
		)
	)
)

(instance icon8 of MGIconItem
	(properties
		x 127
		y 61
		mainView 801
		mainLoop 5
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(global511 add: self)
	)

	(method (dispose)
		(global511 delete: self)
		(super dispose: &rest)
	)

	(method (select)
		(if (super select: 1)
			(icon7 dispose:)
			(icon9 dispose:)
			(gGame handsOn:)
			(self dispose:)
		)
	)

	(method (changeCursor)
		(if (!= gTheCursor 10)
			(gGame setCursor: 10)
		)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed: 1)
				(super handleEvent: event &rest)
				(self dispose:)
			)
			((and (self onMe: event) (== (event type:) evMOUSEBUTTON))
				(gSfx number: 805 play:)
				(event claimed: 1)
				(self select:)
			)
		)
	)
)

(instance icon9 of MGIconItem
	(properties
		x 90
		y 95
		mainView 801
		mainLoop 9
	)

	(method (init)
		(self setPri: 255)
		(super init: &rest)
		(global511 add: self)
	)

	(method (dispose)
		(global511 delete: self)
		(super dispose: &rest)
	)

	(method (select))

	(method (changeCursor)
		(if (!= gTheCursor 6)
			(gGame setCursor: 6)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(self select:)
	)
)

(instance ego of Ego
	(properties
		view 1
		illegalBits 0
	)

	(method (init)
		(super init:)
		(proc0_1)
		(if (and (!= [global200 gCurRoomNum] 45) (!= global130 45))
			(not (and (== gCurRoomNum 23) ((gGoals at: 2) egoReturned:)))
		)
	)

	(method (doit)
		(if (& signal $0400)
			(self setMotion: 0)
			(&= signal $fbff)
		)
		(super doit:)
		(= edgeHit
			(cond
				((<= x (gCurRoom edgeW:)) 4)
				((>= x (gCurRoom edgeE:)) 2)
				((>= y (gCurRoom edgeS:)) 3)
				((<= y (gCurRoom edgeN:)) 1)
				(else 0)
			)
		)
	)

	(method (setMotion param1)
		(if param1
			(self setScript: 0)
			(self setCycle: StopEgo)
		)
		(super setMotion: param1 &rest)
	)

	(method (onMe)
		(if (!= gTheCursor gNormalCursor)
			(return 0)
		else
			(super onMe: &rest)
		)
	)

	(method (doVerb)
		(cond
			((gCurRoom script:) 0)
			(global301
				(gCurRoom setScript: global301)
			)
			(else
				(gCurRoom setScript: saySomething)
			)
		)
	)
)

(instance longSong of Sound
	(properties
		flags 1
		number 600
	)
)

(instance sfx of Sound
	(properties
		number 600
	)
)

(instance MH of EventHandler ; UNUSED
	(properties)
)

(instance KH of EventHandler ; UNUSED
	(properties)
)

(instance DH of EventHandler ; UNUSED
	(properties)
)

(instance MG of Game
	(properties
		printLang 0
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(= temp0 gTheCursor)
		(if (>= argc 3)
			(SetDebug self)
			(if (< param3 0)
				(= param3 0)
			)
			(if (< param4 0)
				(= param4 0)
			)
			(= gTheCursor param1)
			(SetCursor 895 0 param1)
			(SetCursor param3 param4)
		else
			(= gTheCursor param1)
			(SetCursor 895 0 param1)
		)
		(return temp0)
	)

	(method (play)
		(= gWaitCursor 8)
		(= gNormalCursor 1)
		(self setCursor: 10)
		(super play:)
	)

	(method (replay)
		(= global522 1)
		(if (== gLanguage 1)
			(SetLanguage {spanish})
		else
			(SetLanguage {})
		)
		(super replay: &rest)
	)

	(method (init)
		(= gMsgType 2)
		(= gLanguage 0)
		(= gUser MGUser)
		(= gStdWalkIn stdWalkIn)
		(= gStdWalkOut stdWalkOut)
		(= gStdClimbIn stdClimbIn)
		(= gStdClimbOut stdClimbOut)
		(= global522 0)
		(= global521 1)
		(= gPlace place)
		(= gEgo ego)
		(= gTalkEgo talkEgo)
		(= gDoVerbCode mgDoVerbCode)
		(= global512 0)
		(= global514 0)
		(= gLongSong longSong)
		(= gSfx sfx)
		(= gVersion {0.0arf})
		(= gMessager mgMessager)
		(= gNarrator Narrator)
		(= gSystemPlane (Plane new:))
		(super init: &rest)
		(gUser alterEgo: gEgo)
		(= gList (List new:))
		(= gExtMouseHandler MGMouseHandler)
		(= global304 1)
		((ScriptID 600) init:) ; Goals
		(gLongSong owner: gGame init:)
		(gSfx owner: gGame init:)
		(proc98_0)
		(self newRoom: 108)
		(DisposeScript 98)
	)

	(method (changeScore param1 &tmp [temp0 2] temp2)
		(cond
			((<= gScore 17)
				(if (not param1)
					(gList dispose:)
					(= gList (List new:))
					(= gScore 0)
				)
				(if param1
					(gSfx number: 34 play:)
					(gList
						add:
							(= temp2
								((MGIconInvItem new:)
									view: 147
									setPri: 255
									client: icon6
									setLoop: 2
									cel: 0
									ignoreActors: 1
									posn:
										[global261 gScore]
										[global280 gScore]
									init: global511
									yourself:
								)
							)
					)
					(temp2 setCycle: End)
					(if (< (+= gScore 1) gPossibleScore)
						(= global302 1)
					)
				)
			)
			((not param1)
				(gList dispose:)
				(= gList (List new:))
				(= gScore 0)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(gList doit:)
		(if (and global150 (!= (global150 view:) 0) (> (gEgo priority:) 0))
			(cond
				(
					(and
						(< (= temp2 (gEgo distanceTo: global150)) global165)
						(!= global166 1)
					)
					(= global165 0)
					(global150 get:)
					(if global129
						(global129 put:)
					)
					(= temp1 global150)
					(if (> global130 47)
						(= global150 global129)
					else
						(= global150 0)
					)
					(= global130
						(if (= global129 temp1)
							(global129 view:)
						else
							0
						)
					)
					(icon3 draw:)
					(gSfx number: 30 play:)
				)
				((> temp2 80)
					(= global165 (if (== (global150 view:) 45) 30 else 20))
					(if (> [global200 gCurRoomNum] 47)
						(global150 ignoreActors:)
					)
				)
			)
		)
		(super doit:)
	)

	(method (startRoom roomNum &tmp [temp0 5])
		(Purge 2000)
		(= global304 1)
		(= global305 0)
		(= gWave 0)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gDebugOn
			(= gDebugOn 0)
		)
		(if
			(and
				(<= gCurRoomNum 44)
				(!= [global200 gCurRoomNum] 0)
				(!= [global200 gCurRoomNum] -1)
			)
			(= global150 (ScriptID (proc0_17 [global200 gCurRoomNum])))
		else
			(= global150 0)
		)
		(if
			(and
				global130
				(== (= global129 (ScriptID (proc0_17 global130))) global150)
			)
			(= global129 (global150 new:))
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(gCurRoom init:)
		(if global176
			(return)
		)
	)

	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 5] temp6 temp7 temp8 [temp9 2] temp11 temp12 temp13 temp14)
		(if global511
			(global511 handleEvent: event)
		else
			(if (= temp13 (gCast firstTrue: #onMe event))
				(temp13 doVerb:)
				(event claimed: 1)
				(return)
			)
			(if (= temp14 (gFeatures firstTrue: #onMe event))
				(temp14 doVerb:)
				(event claimed: 1)
				(return)
			)
		)
		(if (event claimed:)
			(return)
		)
		(= temp11 (Str new: 50))
		(if (event claimed:)
			(return)
		)
		(= temp0 (event type:))
		(= temp12 (event message:))
		(cond
			((and (== temp0 evKEYBOARD) (== temp12 KEY_CONTROL))
				(= gQuit 1)
			)
			((and (== temp0 evKEYBOARD) (== temp12 KEY_F2))
				(cond
					((gGame masterVolume:)
						(gGame masterVolume: 0)
					)
					((> (DoSound sndGET_AUDIO_CAPABILITY) 1)
						(gGame masterVolume: 14)
					)
					(else
						(gGame masterVolume: (- 14 (* (icon1 cel:) 2)))
					)
				)
				(event claimed: 1)
			)
			((or (not (gUser controls:)) (event claimed:))
				(event claimed: 1)
			)
			((== temp0 evKEYBOARD)
				(switch temp12
					(KEY_F10
						(if (FileIO fiEXISTS {107.scr})
							(proc91_0)
							(DisposeScript 91)
						)
					)
					(KEY_F9
						(if (FileIO fiEXISTS {107.scr})
							(gGame changeScore: 1)
						)
					)
					(KEY_F8
						(if (FileIO fiEXISTS {107.scr})
							(gGame changeScore: 0)
						)
					)
					(KEY_F7
						(if (FileIO fiEXISTS {107.scr})
							(gCurRoom setScript: (ScriptID 205)) ; walkTo
						)
					)
					(else
						(if
							(and
								(not (gKeyDownHandler handleEvent: event))
								(FileIO fiEXISTS {107.scr})
							)
							((ScriptID 107) handleEvent: event) ; debugHandler
						)
					)
				)
				(event claimed: 1)
			)
			((== temp0 evMOUSEBUTTON)
				(if
					(and
						(not (gMouseDownHandler handleEvent: event))
						(= temp11 (Str format: {%d.scr} 107))
						(FileIO fiEXISTS temp11)
						(temp11 dispose:)
					)
					((ScriptID 107) handleEvent: event) ; debugHandler
				)
				(event claimed: 1)
			)
		)
		(if (event claimed:)
			(return)
		)
		(if (and (== (event type:) evMOUSEBUTTON) global100)
			(= temp6 (event x:))
			(= temp7 (event y:))
			(= temp8 (event modifiers:))
		)
		(temp11 dispose:)
		(super handleEvent: event)
	)

	(method (save &tmp temp0 temp1 temp2 temp3 temp4)
		(Sound pause: 1)
		(= temp0 (Save 0 {MG} gMacSaveNumber (gEgoName data:) (KString 9 gVersion))) ; SaveGame, StrGetData
		(= temp2 (Str format: {%s%d.DTA} gCurSaveDir gMacSaveNumber))
		(= temp4 (Str format: {\0d\n%d} (gEgo view:)))
		(= temp3 (File new:))
		(temp3 name: (temp2 data:))
		(temp3
			open: 2
			writeString: (gEgoName data:)
			writeString: (temp4 data:)
			close:
		)
		(temp3 dispose:)
		(temp2 dispose:)
		(temp4 dispose:)
		(Sound pause: 0)
		(return temp0)
	)

	(method (restore param1)
		(gCast eachElementDo: #dispose)
		(Load rsFONT gSmallFont)
		(self setCursor: gWaitCursor 1)
		(if (Save 3 name param1 gVersion) ; CheckSaveGame
			(Save 1 name param1 gVersion) ; RestoreGame
		)
	)

	(method (handsOn)
		(= global104 0)
		(gUser canControl: 1 canInput: 1)
		(= global300 1)
		(= global103 0)
		(= gNormalCursor 1)
	)

	(method (handsOff)
		(gUser canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(= global300 0)
		(if (!= gTheCursor 8)
			(gGame setCursor: 8)
		)
		(= global103 1)
	)
)

(instance talkEgo of EgoTalk
	(properties)
)

(instance saySomething of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(gEgo setHeading: 180 self)
				(= cycles 2)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (Random 0 1)
					(gMessager say: 1 1 33 (Random 1 29) self 0)
				else
					(gMessager say: 1 1 34 (Random 1 21) self 0)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(= gNarrator global516)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance saveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(icon7 dispose:)
				(icon8 dispose:)
				(icon9 dispose:)
				(gGame handsOn:)
				(= cycles 1)
				(gGame save:)
				(= global300 0)
				(= gQuit 1)
			)
			(1
				(global511 init:)
				(self dispose:)
			)
		)
	)
)

(class mgMessager of Messager
	(properties)

	(method (findTalker param1)
		(= global515 param1)
		(return gNarrator)
	)
)

(instance place of Feature
	(properties)
)

(instance stdWalkIn of Script
	(properties
		register 50
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(switch (= state newState)
			(0
				(gEgo edgeHit: EDGE_NONE)
				(gGame handsOff:)
				(= temp6 (gCurRoom roomToEdge: gPrevRoomNum))
				(= temp5
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp4
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(switch temp6
					(3
						(= temp0 temp2)
						(= temp1 (+ (gCurRoom edgeS:) temp5))
					)
					(2
						(= temp1 temp3)
						(= temp0 (+ (gCurRoom edgeE:) temp4))
					)
					(4
						(= temp1 temp3)
						(= temp0 (- (gCurRoom edgeW:) temp4))
					)
					(1
						(= temp0 temp2)
						(= temp1 (- temp3 2))
					)
				)
				(gEgo
					posn: temp0 temp1
					init:
					setLoop: -1
					ignoreActors: 1
					setMotion: MoveTo temp2 temp3 self
				)
				(if (and (!= global130 0) (<= global130 47))
					(global129 posn: temp0 temp1)
				)
			)
			(1
				(gGame handsOn:)
				(gEgo ignoreActors: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance stdWalkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(1
						(-= temp1 10)
					)
					(3
						(+= temp1 20)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 30)
					)
				)
				(gGame handsOff:)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(gGame handsOn:)
				(client setScript: 0)
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
			)
		)
	)
)

(instance stdClimbIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= global130 0) (<= global130 47))
					(global129 hide:)
				)
				(= temp1
					(+
						temp2
						4
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					init:
					setPri: 0
					y: temp1
					ignoreActors: 1
					setMotion: MoveTo temp0 temp2 self
					setLoop: 2
				)
			)
			(1
				(= temp1
					(+
						temp2
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					setPri: -1
					setLoop: -1
					setMotion: MoveTo temp0 temp1 self
				)
				(if (and (!= global130 0) (<= global130 47))
					(= global166 1)
					(if (== global130 45)
						(global129 init:)
					else
						(global129 init: setScript: followOver)
					)
				)
			)
			(2
				(gEgo ignoreActors: 1)
				(if global521
					(gGame handsOn:)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance stdClimbOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp1
					(-
						(+
							temp2
							(CelHigh
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
							)
						)
						7
					)
				)
				(gEgo
					init:
					setPri: 0
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo temp0 temp1 self
					setLoop: 3
				)
				(if (<= 1 global130 47)
					(if (== global130 45)
						(= global166 2)
					else
						(global129
							illegalBits: 32768
							setMotion: MoveTo (gEgo x:) (gEgo y:) self
						)
					)
				)
			)
			(1
				(if
					(and
						(<= 1 global130 47)
						(!= global130 45)
						(not (global129 mover:))
					)
					(global129
						setPri: 1
						setLoop: 3 1
						setMotion: MoveTo (gEgo x:) (gEgo y:)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(if (and (<= 1 global130 47) (!= global130 45))
					(global129 setPri: -1 setLoop: -1)
				)
				(= global166 0)
				(client setScript: 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance followOver of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(= temp1
					(+
						temp2
						4
						(CelHigh
							(global129 view:)
							(global129 loop:)
							(global129 cel:)
						)
					)
				)
				(global129
					ignoreActors: 1
					setPri: 0 1
					setLoop: 2 1
					illegalBits: 0
					posn: temp0 temp1
					setMotion: MoveTo temp0 temp2 self
				)
			)
			(1
				(= global166 0)
				(global129
					ignoreActors: 1
					setPri: -1
					setLoop: -1
					setMotion: MoveTo temp0 (- temp2 5) self
				)
			)
			(2
				(global129 ignoreActors: 1 setMotion: PFollow gEgo 30)
				(self dispose:)
			)
		)
	)
)

(instance DNKR of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance MGMouseHandler of EventHandler
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (and (& (event type:) evMOUSE) global511)
			(event localize: (global511 plane:))
			(global511 eachElementDo: #handleEvent event)
			(if (or (event claimed:) (not (gUser canControl:)))
				(return)
			)
			(event type: (| (event type:) evVERB) message: JOY_UP)
			(event localize: gThePlane)
			(gCast eachElementDo: #handleEvent event)
			(if gFeatures
				(event claimed: (gFeatures handleEvent: event))
			)
			(if (event claimed:)
				(return)
			else
				(event type: $5000) ; evVERB | evMOVE
				(cond
					((and (OneOf gTheCursor 2 4 3 5) global305)
						(global305 doit: (event x:) (event y:))
					)
					((and (gUser controls:) (== global511 MgButtonBar))
						(gEgo handleEvent: event)
					)
				)
			)
		)
	)
)

(instance mgDoVerbCode of Code
	(properties)

	(method (doit))
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

