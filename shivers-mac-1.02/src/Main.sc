;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n951)
(use soundRoom)
(use Movie)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Feature)
(use Ego)
(use Sound)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	SHIVERS 0
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
	global101
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	gShiversInvItem
	global109 = 100
	; 110
	gExitFeature
	gSound1
	gSound2
	gSound3
	gSound4
	; 115
	gPBoatView
	global116
	global117
	global118 = 6220
	global119 = 212
	; 120
	global120 = 7112
	global121
	global122 = 8100
	global123
	global124 = 8490
	; 125
	global125
	global126 = 9420
	global127 = 217
	global128 = 9760
	global129
	; 130
	global130 = 11310
	global131
	global132 = 12181
	global133
	global134 = 14080
	; 135
	global135
	global136 = 16420
	global137
	global138 = 19220
	global139 = 202
	; 140
	global140 = 20553
	global141
	global142 = 21070
	global143
	global144 = 22190
	; 145
	global145
	global146 = 23550
	global147
	global148 = 24320
	global149
	; 150
	global150 = 24380
	global151
	global152 = 25050
	global153
	global154 = 29080
	; 155
	global155
	global156 = 30420
	global157
	global158 = 31310
	global159
	; 160
	global160 = 32570
	global161
	global162 = 35110
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
	global187 = 15
	global188 = 178
	global189 = 253
	; 190
	global190 = 178
	global191 = 36
	global192 = 173
	global193 = 232
	global194 = 173
	; 195
	global195 = 57
	global196 = 169
	global197 = 211
	global198 = 169
	global199 = 78
	; 200
	global200 = 166
	global201 = 190
	global202 = 166
	global203 = 99
	global204 = 163
	; 205
	global205 = 169
	global206 = 163
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
	global321 = -1
	global322 = 1
	global323 = 3
	global324 = 5
	; 325
	global325 = 11
	global326 = 9
	global327 = 7
	global328
	global329 = 1
	; 330
	global330 = 2
	global331
	global332 = 1
	global333 = 2
	global334
	; 335
	global335 = 2
	global336 = 3
	global337
	global338 = 1
	global339 = 3
	; 340
	global340
	global341
	global342
	global343
	global344
	; 345
	global345
	gShiversRoomItem
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
	global541 = 1
	global542 = 2
	global543 = 3
	global544
	; 545
	global545 = 1
	global546
	global547
	global548
	global549
	; 550
	global550
	global551
	gSound5
	gSound6
)

(instance sound1 of ShiversSound
	(properties)
)

(instance sound2 of ShiversSound
	(properties)
)

(instance sound3 of ShiversSound
	(properties)
)

(instance sound4 of ShiversSound
	(properties)
)

(instance sound5 of ShiversSound
	(properties)
)

(instance sound6 of ShiversSound
	(properties)
)

(class ShiversRoom of Room
	(properties
		purge 2000
		movie 0
		invView 0
	)

	(method (init &tmp temp0)
		(gGame handsOn:)
		(super init: &rest)
	)

	(method (initRoom param1 param2 param3 param4)
		(if (!= global106 0)
			(= gShiversRoomItem
				((ShiversRoomItem new:)
					view: global106
					loop: (gCurRoom invView:)
					cel: 0
					x: (/ (+ param1 param2) 2)
					y: param4
					setScale:
					scaleX: (/ (* 128 (- param4 param3)) 75)
					scaleY: (/ (* 128 (- param4 param3)) 75)
					nsLeft: param1
					nsTop: param3
					nsRight: param2
					nsBottom: param4
					init:
					yourself:
				)
			)
		)
	)

	(method (drawPic param1)
		(if (== style -1)
			(= style 0)
		)
		(super drawPic: param1 &rest)
	)

	(method (drawText param1 param2 param3 param4)
		(textBox dispose:)
		(if (> argc 1)
			(if (> argc 3)
				(textBox x: param2 y: param3 fore: param4 init: param1)
			else
				(textBox x: param2 y: param3 fore: 181 init: param1)
			)
		else
			(textBox init: param1)
		)
		(textBox text: (param1 data:) setSize: 263)
		(UpdateScreenItem textBox)
		(FrameOut)
	)

	(method (eraseText)
		(textBox dispose:)
		(FrameOut)
	)

	(method (playAVI param1 param2 &tmp temp0 temp1 [temp2 3])
		(if movie
			(movie dispose:)
		)
		(if (IsFlag 38)
			(= temp0 27)
			(= temp1 7)
		else
			(= temp0 91)
			(= temp1 47)
		)
		(= movie
			((Movie new:) posn: temp0 temp1 open: param1 client: self yourself:)
		)
		(if (and (> argc 1) param2)
			(movie caller: param2)
		)
		(if (IsFlag 38)
			(movie putDouble:)
		)
		(movie play:)
	)

	(method (playVMD param1 param2 &tmp temp0 temp1 [temp2 3] temp5 temp6 temp7 temp8 temp9 temp10)
		(if movie
			(movie dispose:)
		)
		(= temp5 0)
		(= temp6 0)
		(= temp7 0)
		(= temp8 0)
		(= temp9 0)
		(= temp10 0)
		(if (gSound1 handle:)
			(= temp5 (gSound1 number:))
			(gSound1 stop:)
		)
		(if (gSound2 handle:)
			(= temp6 (gSound2 number:))
			(gSound2 stop:)
		)
		(if (gSound3 handle:)
			(= temp7 (gSound3 number:))
			(gSound3 stop:)
		)
		(if (gSound4 handle:)
			(= temp8 (gSound4 number:))
			(gSound4 stop:)
		)
		(if (gSound5 handle:)
			(= temp9 (gSound5 number:))
			(gSound5 stop:)
		)
		(if (gSound6 handle:)
			(= temp10 (gSound6 number:))
			(gSound6 stop:)
		)
		(if (IsFlag 38)
			(= temp0 54)
			(= temp1 16)
		else
			(= temp0 182)
			(= temp1 102)
		)
		(= movie ((VmdMovie new:) open: param1 client: self yourself:))
		(if (and (> argc 1) param2)
			(movie caller: param2)
		)
		(if (IsFlag 38)
			(movie put: temp0 temp1 5 setWaitEvent: 7)
		else
			(movie put: temp0 temp1 4 setWaitEvent: 7)
		)
		(movie close:)
		(if (gSound1 number:)
			(gSound1 number: temp5 play:)
		)
		(if (gSound2 number:)
			(gSound2 number: temp6 play:)
		)
		(if (gSound3 number:)
			(gSound3 number: temp7 play:)
		)
		(if (gSound4 number:)
			(gSound4 number: temp8 play:)
		)
		(if (gSound5 number:)
			(gSound5 number: temp9 play:)
		)
		(if (gSound6 number:)
			(gSound6 number: temp10 play:)
		)
	)

	(method (dispose)
		(if movie
			(movie dispose:)
		)
		(super dispose: &rest)
	)
)

(instance SHIVERS of Game
	(properties)

	(method (init)
		(Font 1 640 480) ; SetFontRes
		(= gSystemPlane (Plane new:))
		(= gUser User)
		(= gScore 0)
		(if (FileIO fiEXISTS {classes})
			(= global100 1)
		)
		(= gVersion {1.000.000})
		(gUser alterEgo: (Ego new:))
		(gUser init:)
		(= global528 (Str new: 9))
		(super init: &rest)
		(= gSounds SoundManager)
		(= gDirectionHandler shiversDirection)
		(= global103 (Cast new:))
		(= global102
			((Plane new:)
				picture: -2
				priority: 10
				init: 0 0 320 200
				addCast: global103
				yourself:
			)
		)
		(global103 plane: global102)
		(= global345 (Cast new:))
		(= global344
			((Plane new:)
				picture: -2
				priority: 30
				init: 0 0 320 200
				addCast: global345
				yourself:
			)
		)
		(global345 plane: global344)
		(= global208 (Cast new:))
		(= global207
			((Plane new:)
				picture: -2
				priority: 45
				init: 27 133 290 200
				addCast: global208
				yourself:
			)
		)
		(global208 plane: global207)
		(SetPalStyleRange 180 236)
		(gThePlane setRect: 27 7 290 149 priority: 20)
		(DoAudio 12 0) ; AudMixCheck
		((= gSound1 sound1) channelNum: 1 owner: self init:)
		((= gSound2 sound2) channelNum: 2 owner: self init:)
		((= gSound3 sound3) channelNum: 3 owner: self init:)
		((= gSound4 sound4) channelNum: 4 owner: self init:)
		((= gSound5 sound5) channelNum: 5 owner: self init:)
		((= gSound6 sound6) channelNum: 6 owner: self init:)
		(= global101 900)
		(self newRoom: 942) ; speedRoom
	)

	(method (startRoom roomNum &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 23) ((++ temp0))
			(breakif (== [global118 (* temp0 2)] roomNum))
		)
		(if (< temp0 23)
			(= global106 [global118 (+ (* temp0 2) 1)])
			(= global185 1)
		else
			(= global106 0)
			(= global185 0)
		)
		(if (and (== global100 1) (< roomNum 0))
			(= temp1 (/ (= temp0 (+ roomNum 32768)) 10))
			(= temp0 (+ (mod temp0 10) 8))
			(+= temp1 (+ (/ temp0 10) 3276))
			(= temp0 (mod temp0 10))
		)
		(if (!= global105 0)
			(gTheDoits add: gShiversInvItem)
		)
		(gTheDoits add: gSound1)
		(gTheDoits add: gSound2)
		(gTheDoits add: gSound3)
		(gTheDoits add: gSound4)
		(gTheDoits add: gSound5)
		(gTheDoits add: gSound6)
		(if (and (< 0 gPrevRoomNum 990) (or (>= roomNum 990) (< roomNum 0))) ; shiversOptions, shiversOptions
			((ScriptID 950 0) init:) ; vInterfaceView
			(if (!= global105 0)
				(self setScript: (ScriptID 950 13)) ; sEyeOpen
			)
		)
		(if (and (or (>= gPrevRoomNum 990) (< gPrevRoomNum 0)) (< 0 roomNum 950)) ; shiversOptions
			((ScriptID 950 0) dispose:) ; vInterfaceView
		)
		(= gTheCursor 0)
		(SetCursor 999 0 0)
		(gNormalCursor show:)
		(super startRoom: roomNum)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_ALT_v
					(Prints {Version number 1.02})
					(event claimed: 1)
				)
				(KEY_ALT_s
					(if (or (< gCurRoomNum 0) (> gCurRoomNum 1000)) ; rm1v00
						(= global550 1)
						(event claimed: 1)
					)
				)
				(KEY_ALT_q
					(= gQuit 1)
					(event claimed: 1)
				)
			)
		)
		(if (and (== global100 1) (== (event claimed:) 0))
			((ScriptID 940) handleEvent: event) ; debugHandler
			(DisposeScript 940)
		)
		(super handleEvent: event)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for
			((= temp4 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp1 (KList 8 temp4)) ; NodeValue
			(AddPlane temp1)
			(for
				((= temp5 (KList 3 ((temp1 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp2 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp2 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (KList 6 temp6)) ; NextNode
					(= temp3 (KList 8 temp6)) ; NodeValue
					(if (& (temp3 -info-:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
		)
		(if
			(or
				(== gCurRoomNum 993) ; saveGame
				(== gCurRoomNum 994)
				(== gCurRoomNum 927) ; oldGame
				(== gCurRoomNum 991) ; shiversFlashback
				(== gCurRoomNum 910) ; shiversLogo
			)
			(gCurRoom newRoom: global343)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(SL doit:)
		(Sound pause: 0)
		(gSound1 pause: 0)
		(gSound2 pause: 0)
		(gSound3 pause: 0)
		(gSound4 pause: 0)
		(gSound5 pause: 0)
		(gSound6 pause: 0)
		(= gExitFeature 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (save &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (not (= temp0 (Platform 0 3 {SHIVER} global539)))
			(gGame setCursor: gNormalCursor)
			(switch
				(Print
					addBitmap: 928 6 0
					addButtonBM: 928 2 0 0 {} 105 53
					init:
				)
				(0
					(return)
				)
			)
		else
			(Platform 0 4 {SHIVER} global539 (global528 data:))
			(= temp1 (Str format: {%s%d.SG} gCurSaveDir global539))
			(= temp4 (Str new: 20))
			(= temp4 (Str format: {%s\0d\n} (global528 data:)))
			(if global349
				(cond
					((== gScore 0)
						(= temp3 (Str format: {%-3d000} global349))
					)
					((< 0 gScore 10)
						(= temp3 (Str format: {%-3d00%d} global349 gScore))
					)
					((< 9 gScore 100)
						(= temp3 (Str format: {%-3d0%-2d} global349 gScore))
					)
					(else
						(= temp3 (Str format: {%-3d%-3d} global349 gScore))
					)
				)
			else
				(= temp3 (Str format: {%-6d} gScore))
			)
			(temp3 strip: 115)
			(= temp2 (File new:))
			(temp2 name: (temp1 data:))
			(temp2
				open: 2
				writeString: (temp4 data:)
				writeString: (temp3 data:)
				close:
			)
			(temp2 dispose:)
			(temp1 dispose:)
			(temp4 dispose:)
			(temp3 dispose:)
		)
		(return temp0)
	)

	(method (restore param1 &tmp [temp0 4] temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(for
			((= temp8 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp8
			((= temp8 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp8)) ; NextNode
			(= temp4 (KList 8 temp8)) ; NodeValue
			(for
				((= temp9 (KList 3 ((temp4 casts:) elements:)))) ; FirstNode
				temp9
				((= temp9 ((temp4 casts:) nextNode:)))
				
				((temp4 casts:) nextNode: (KList 6 temp9)) ; NextNode
				(= temp5 (KList 8 temp9)) ; NodeValue
				(for
					((= temp10 (KList 3 (temp5 elements:)))) ; FirstNode
					temp10
					((= temp10 (temp5 nextNode:)))
					
					(temp5 nextNode: (KList 6 temp10)) ; NextNode
					(= temp6 (KList 8 temp10)) ; NodeValue
					(if (= temp7 (& (temp6 -info-:) $0010))
						(DeleteScreenItem temp6)
						(temp6 -info-: (| (temp6 -info-:) temp7))
					)
				)
			)
			(DeletePlane temp4)
		)
		(if (= temp11 (Save 3 {SHIVER} param1 (KString 9 gVersion))) ; CheckSaveGame, StrGetData
			(Platform 0 5 {SHIVER} param1)
		else
			(for
				((= temp8 (KList 3 (gPlanes elements:)))) ; FirstNode
				temp8
				((= temp8 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (KList 6 temp8)) ; NextNode
				(= temp4 (KList 8 temp8)) ; NodeValue
				(AddPlane temp4)
				(for
					((= temp9 (KList 3 ((temp4 casts:) elements:)))) ; FirstNode
					temp9
					((= temp9 ((temp4 casts:) nextNode:)))
					
					((temp4 casts:) nextNode: (KList 6 temp9)) ; NextNode
					(= temp5 (KList 8 temp9)) ; NodeValue
					(for
						((= temp10 (KList 3 (temp5 elements:)))) ; FirstNode
						temp10
						((= temp10 (temp5 nextNode:)))
						
						(temp5 nextNode: (KList 6 temp10)) ; NextNode
						(= temp6 (KList 8 temp10)) ; NodeValue
						(if (& (temp6 -info-:) $0010)
							(AddScreenItem temp6)
						)
					)
				)
			)
			(gGame setCursor: gNormalCursor)
			(switch
				(Print
					addBitmap: 928 3 0
					addButtonBM: 928 4 0 0 {} 135 100
					addButtonBM: 928 5 0 1 {} 85 100
					init:
				)
				(0)
				(1
					(deleteGame doit: param1)
				)
			)
		)
	)

	(method (doit)
		(cond
			((gUser canControl:)
				(if (== gTheCursor gWaitCursor)
					(gGame setCursor: gNormalCursor)
					(if gExitFeature
						(= gTheCursor (gExitFeature cursorCel:))
						(SetCursor 999 0 gTheCursor)
					)
				)
			)
			((!= gTheCursor gWaitCursor)
				(gGame setCursor: gWaitCursor)
			)
		)
		(if (and (== global550 1) (not (gCurRoom script:)))
			(= global550 0)
			(gGame save:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(super dispose:)
	)
)

(class ShiversInvItem of Prop
	(properties
		x 57
		y 185
	)

	(method (init)
		(super init: global345)
		(self setPri: 254 plane: global344)
		(UpdatePlane global344)
		(gTheDoits add: self)
		(self setScript: (ScriptID 950 13)) ; sEyeOpen
	)

	(method (doit)
		(if (and (== global184 1) (!= gCurRoomNum 992)) ; viewingInv
			(if (and (< 0 gMouseX 320) (< 0 gMouseY 200))
				(gNormalCursor hide:)
				(self x: gMouseX y: gMouseY show:)
			else
				(self hide:)
				(gNormalCursor show:)
			)
			(if (self isNotHidden:)
				(UpdateScreenItem self)
			)
		)
	)

	(method (dispose)
		(global345 delete: self)
		(self setScript: (ScriptID 950 14)) ; sEyeClose
		(gTheDoits delete: self)
		(super dispose: &rest)
	)
)

(class ShiversRoomItem of View
	(properties
		priority 20
		fixPriority 1
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(self isNotHidden:)
				(!= global184 1)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(gSounds stop: 15014)
			(gSounds play: 15014 0 106 0)
			(= temp2 global105)
			(if (<= 200 global106 219)
				(proc951_16 (- global106 200))
			)
			(if (== (Abs (- global105 global106)) 10)
				(= global105 (+ (Max global105 global106) 10))
				(= global106 0)
			else
				(= temp1 global105)
				(= global105 global106)
				(= global106 temp1)
			)
			(for ((= temp0 0)) (< temp0 23) ((++ temp0))
				(breakif (== [global118 (* temp0 2)] gCurRoomNum))
			)
			(= [global118 (+ (* temp0 2) 1)] global106)
			(if (!= global106 0)
				(self view: global106 loop: (gCurRoom invView:) setScale:)
				(UpdateScreenItem self)
			else
				(gMouseDownHandler delete: self)
				(gGame handsOn:)
				(self dispose:)
			)
			(if (== temp2 0)
				(= gShiversInvItem
					((ShiversInvItem new:)
						view: global105
						loop: 0
						init:
						yourself:
					)
				)
			else
				(gShiversInvItem view: global105)
				(UpdateScreenItem gShiversInvItem)
			)
			(gGame handsOn:)
		)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(class ShiversProp of Prop
	(properties)

	(method (init)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
			)
			(event claimed: 1)
			(self doVerb:)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb))

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(class PotSpot of Feature
	(properties)

	(method (init)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(== global184 1)
				(== global106 0)
				(gUser canControl:)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(gSounds play: 15030 0 90 0)
			(gNormalCursor show:)
			(= global184 0)
			(= gShiversRoomItem
				((ShiversRoomItem new:)
					view: global105
					loop: (gCurRoom invView:)
					cel: 0
					x: (/ (+ (self nsLeft:) (self nsRight:)) 2)
					y: (self nsBottom:)
					setScale:
					scaleX: (/ (* 128 (- (self nsBottom:) (self nsTop:))) 75)
					scaleY: (/ (* 128 (- (self nsBottom:) (self nsTop:))) 75)
					nsLeft: (self nsLeft:)
					nsTop: (self nsTop:)
					nsRight: (self nsRight:)
					nsBottom: (self nsBottom:)
					init:
					yourself:
				)
			)
			(= global106 global105)
			(= global105 0)
			(gShiversInvItem dispose:)
			(= gShiversInvItem 0)
			(for ((= temp0 0)) (< temp0 23) ((++ temp0))
				(breakif (== [global118 (* temp0 2)] gCurRoomNum))
			)
			(= [global118 (+ (* temp0 2) 1)] global106)
			(gGame handsOn:)
		)
		(super handleEvent: event &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(class HotSpot of Feature
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
				(self onMe: event)
				(!= global184 1)
			)
			(event claimed: 1)
			(self doVerb:)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb))

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(class ExitFeature of Feature
	(properties
		nsLeft -999
		nsTop -999
		nsRight -999
		nsBottom -999
		x -999
		y -999
		exitDir 0
		nextRoom 0
		cursorCel -999
	)

	(method (init param1)
		(self exitDir: param1 plane: gThePlane)
		(gMouseDownHandler add: self)
		(gTheDoits add: self)
		(cond
			((== param1 1)
				(if (== nsLeft -999)
					(= nsLeft 244)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (== nsRight -999)
					(= nsRight 264)
				)
				(if (== nsBottom -999)
					(= nsBottom 143)
				)
				(if (== cursorCel -999)
					(= cursorCel 1)
				)
			)
			((== param1 2)
				(if (== nsLeft -999)
					(= nsLeft 0)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (== nsRight -999)
					(= nsRight 20)
				)
				(if (== nsBottom -999)
					(= nsBottom 143)
				)
				(if (== cursorCel -999)
					(= cursorCel 2)
				)
			)
			((== param1 6)
				(if (== nsLeft -999)
					(= nsLeft 244)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (== nsRight -999)
					(= nsRight 264)
				)
				(if (== nsBottom -999)
					(= nsBottom 143)
				)
				(if (== cursorCel -999)
					(= cursorCel 6)
				)
			)
			((== param1 7)
				(if (== nsLeft -999)
					(= nsLeft 0)
				)
				(if (== nsTop -999)
					(= nsTop 0)
				)
				(if (== nsRight -999)
					(= nsRight 20)
				)
				(if (== nsBottom -999)
					(= nsBottom 143)
				)
				(if (== cursorCel -999)
					(= cursorCel 7)
				)
			)
			((or (== param1 9) (== param1 3))
				(if (== cursorCel -999)
					(= cursorCel 3)
				)
			)
			((== param1 4)
				(if (== cursorCel -999)
					(= cursorCel 4)
				)
			)
			((== param1 5)
				(if (== cursorCel -999)
					(= cursorCel 5)
				)
			)
			((and (== param1 8) (== cursorCel -999))
				(= cursorCel 8)
			)
		)
		(if (== cursorCel -999)
			(= cursorCel 0)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(!= nextRoom 0)
				(gUser canControl:)
				(!= global184 1)
			)
			(gGame handsOff:)
			(event claimed: 1)
			(if (== global184 1)
				(gShiversInvItem x: 57 y: 185 view: global105 show:)
				(UpdateScreenItem gShiversInvItem)
				(= global184 0)
			)
			(gNormalCursor show:)
			(gCurRoom newRoom: nextRoom)
		)
		(super handleEvent: event &rest)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (- gMouseX 27))
		(= temp1 (- gMouseY 7))
		(cond
			((self onMe: temp0 temp1)
				(if (and (!= gTheCursor cursorCel) (== gExitFeature 0))
					(= gTheCursor cursorCel)
					(SetCursor 999 0 gTheCursor)
					(= gExitFeature self)
				)
			)
			((and (== gTheCursor cursorCel) (== gExitFeature self))
				(= gTheCursor 0)
				(SetCursor 999 0 0)
				(= gExitFeature 0)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gTheDoits delete: self)
		(= gExitFeature 0)
		(super dispose: &rest)
	)
)

(instance textBox of DText
	(properties
		priority 255
		fixPriority 1
		fore 181
		back 0
		font 2510
	)

	(method (init param1)
		(self text: (param1 data:) setSize: 265)
		(super init: global208)
	)

	(method (dispose)
		(if text
			(KString 4 text) ; StrFree
			(= text 0)
		)
		(global208 delete: self)
		(super dispose: &rest)
	)
)

(instance deleteGame of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= temp0 (IntArray new: 21))
		(= temp1 (Save 5 {SHIVER} (temp2 data:) (temp0 data:))) ; GetSaveFiles
		(Save 6 (temp3 data:) {SHIVER}) ; MakeSaveCatName
		((= temp4 (File new:)) name: (temp3 data:) open: 2)
		(for ((= temp6 0)) (< temp6 temp1) ((++ temp6))
			(if (!= (temp0 at: param1) (temp0 at: temp6))
				(= temp5 (temp0 at: temp6))
				(temp3
					at: 0 0
					at: 1 (& temp5 $00ff)
					at: 2 (& (>> temp5 $0008) $00ff)
				)
				(temp4 write: (temp3 data:) 2)
				(= temp8 (Str new: 36))
				(temp8 copyToFrom: 0 temp2 (* temp6 36) 36)
				(temp4 write: (temp8 data:) 36)
				(temp8 dispose:)
			)
		)
		(temp3 at: 0 255 at: 1 255)
		(temp4 write: (temp3 data:) 2 close: dispose:)
		(Save 7 (temp3 data:) {SHIVER} (temp0 at: param1)) ; MakeSaveFileName
		(FileIO fiUNLINK (temp3 data:))
		(= temp8 (Str new: 200))
		(= temp8 (Str format: {%s%d.SG} gCurSaveDir (temp0 at: param1)))
		(FileIO fiUNLINK (temp8 data:))
		(temp8 dispose:)
		(temp3 dispose:)
		(temp2 dispose:)
	)
)

(instance shiversDirection of EventHandler
	(properties)

	(method (handleEvent))
)

