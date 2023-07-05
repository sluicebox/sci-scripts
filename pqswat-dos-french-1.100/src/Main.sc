;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use ExitButton)
(use PQEgo)
(use ControlLED)
(use aniProp)
(use SwatSaveDlg)
(use SwatRestoreDlg)
(use CareerID)
(use MedalID)
(use CloseUp)
(use AnimatingCursor)
(use SwatFile)
(use Styler)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Messager)
(use Talker)
(use PolyPath)
(use Polygon)
(use WalkieTalkie)
(use Cursor)
(use Timer)
(use Grooper)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Swat 0
	InterfacePlane 2
	IsFlag 3
	SetFlag 4
	ClearFlag 5
	InventoryPlane 6
	callUpTimer 7
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
	gGrooper
	global101 = 1234
	global102
	global103
	global104
	; 105
	global105
	gInterfacePlane
	gInterfaceCast
	global108
	gSwatInterface
	; 110
	global110 = 1
	global111 = -1
	global112
	gLashInterface
	global114
	; 115
	gInventoryPlane
	gInventoryCast
	gTheInvCursor
	gStr
	global119
	; 120
	gTheHandSigCursor
	gTheDoorEntryCursor
	global122
	global123
	global124
	; 125
	global125
	gBackMusic
	gFxSound
	global128
	global129
	; 130
	gTheHotspotCursor
	gTheHotspotList
	gSelectorCloseCode
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
	gTheInvisCursor
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
	gRobotDoVerb
	gBackMusic2
	global432
	global433
	global434
	; 435
	global435
	gMyAutoEventCode
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
	global445 = 10
	global446 = 8
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
	global500 = -1
)

(procedure (IsFlag param1)
	(return (& [global150 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(= [global150 (/ param1 16)]
		(| [global150 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global150 (/ param1 16)]
		(& [global150 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(instance BackMusic of Sound
	(properties)
)

(instance BackMusic2 of Sound
	(properties)
)

(instance FxSound of Sound
	(properties)
)

(instance InterfacePlane of Plane
	(properties)
)

(instance InterfaceCast of Cast
	(properties)
)

(instance InventoryPlane of Plane
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= inLeft temp0 inRight) (<= inTop temp1 inBottom)))
	)
)

(instance InventoryCast of Cast
	(properties)
)

(instance theWaitCursor of Cursor
	(properties
		view 997
	)
)

(instance theNormalCursor of Cursor
	(properties
		view 999
	)
)

(instance theInvisCursor of Cursor
	(properties
		view 996
	)
)

(instance theInvCursor of Cursor
	(properties
		view 999
	)
)

(instance theHandSigCursor of AnimatingCursor
	(properties
		view 985
	)

	(method (init)
		(self cycleSpeed: 7 loop: 0 cel: 0 setCycle: Fwd)
		(super init: &rest)
	)
)

(instance theDoorEntryCursor of Cursor
	(properties
		view 999
	)
)

(instance PoliceQuestEgo of PQEgo
	(properties)
)

(instance theHotspotCursor of AnimatingCursor
	(properties)

	(method (init)
		(super init: &rest)
		(if (== view 987)
			(self cycleSpeed: 5 cel: 0 setCycle: End)
		)
	)
)

(instance theHotspotList of Set
	(properties)
)

(class Swat of Game
	(properties
		isHandsOn 0
		currentSpeed 6
		oldCurs 0
		speedRating 0
		quitCode 0
		darkPlane 0
		darkCast 0
		callUpTime 5
	)

	(method (init &tmp [temp0 9] temp9 [temp10 2] temp12)
		(Load rsVIEW 55)
		(Lock rsVIEW 55 1)
		(ScriptID 64982)
		DText
		DButton
		Print
		Polygon
		PolyPath
		MedalList
		(= gScreenHeight 480)
		(= gScreenWidth 640)
		(super init: &rest)
		(gThePlane priority: 4)
		(UpdatePlane gThePlane)
		(gThePlane setRect: 0 0 640 480)
		(Styler init:)
		(self setCursor: gWaitCursor)
		((ScriptID 1 0) doit:) ; pqInitCode
		(DisposeScript 1)
		(= gFtrInitializer SwatFtrInitializer)
		((= gBackMusic BackMusic) owner: self flags: 5 init:)
		((= gBackMusic2 BackMusic2) owner: self flags: 5 init:)
		((= gFxSound FxSound) flags: 5 owner: self init:)
		(= gSystemPlane (Plane new:))
		((= gInterfaceCast InterfaceCast) add:)
		((= gInterfacePlane InterfacePlane)
			priority: 2
			init: 0 359 640 480
			addCast: gInterfaceCast
		)
		(gInterfaceCast plane: gInterfacePlane)
		(= gSwatInterface SwatInterface)
		(Load rsVIEW 10)
		((= gInventoryCast InventoryCast) add:)
		((= gInventoryPlane InventoryPlane)
			priority: 3
			init:
				(+ (gInterfacePlane left:) 106)
				(+ (gInterfacePlane top:) 19)
				(+ (gInterfacePlane left:) 525)
				(+ (gInterfacePlane top:) 80)
			picture: -2
			addCast: gInventoryCast
		)
		(gInventoryCast plane: gInventoryPlane)
		((ScriptID 19) doit:) ; swatInvInit
		(gSwatInterface setInvSet:)
		(= gStr (Str new:))
		(gStr copy: gCurSaveDir)
		(= gVersion {xx.yyy.zzz})
		(if (!= (= temp9 (FileIO fiOPEN {version} 1)) -1)
			(FileIO fiREAD_STRING gVersion 11 temp9)
		)
		(FileIO fiCLOSE temp9)
		(= gEgo PoliceQuestEgo)
		(= gTheCursor theNormalCursor)
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(= gTheInvCursor theInvCursor)
		(= gTheInvisCursor theInvisCursor)
		(= oldCurs gNormalCursor)
		(= gTheHandSigCursor theHandSigCursor)
		(= gTheDoorEntryCursor theDoorEntryCursor)
		(= gTheHotspotCursor theHotspotCursor)
		(= gTheHotspotList (theHotspotList add: yourself:))
		(= gGrooper Grooper)
		(= gDoVerbCode pqDoVerbCode)
		(= gApproachCode pqApproachCode)
		(= gMessager pqMessager)
		(= gNarrator Narrator)
		(= isHandsOn 0)
		(= global104 (MemoryInfo 0))
		(= global102 (= speedRating 0))
		(self masterVolume: 127)
		(= temp12 (Str new:))
		(temp12 format: {%sswat.dat} (gStr data:))
		(if (not (FileIO fiEXISTS (temp12 data:)))
			(SwatFile writeIt: 0 0)
			(SwatFile writeIt: 1 0)
			(SwatFile writeIt: 2 0)
		)
		(temp12 dispose:)
		(if (not (SwatFile readIt: 2))
			(self getDisc: 1)
		)
		(self newRoom: 8) ; sierraLogo
	)

	(method (doit &tmp temp0)
		(= temp0 panelSelector)
		(super doit: &rest)
		(if (and gTheCursor (gTheCursor isKindOf: AnimatingCursor))
			(gTheCursor doit:)
		)
		(if (and global123 (== temp0 82))
			(gGame restart:)
			(= global123 0)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0 temp1)
		(gBackMusic client: 0)
		(gBackMusic2 client: 0)
		(gFxSound client: 0)
		(if global112
			(if (OneOf newRoomNumber 72 6000 35 6200 15) ; funeralRoom, metroExt, mainMenu
				(ClearFlag 109)
				(if
					(and
						(not (IsFlag 64))
						(not (IsFlag 63))
						(not (IsFlag 100))
						(not (IsFlag 103))
					)
					(SetFlag 116)
					(self setCallUp: callUpTime)
				)
				(if (== newRoomNumber 35) ; metroExt
					(SetFlag 73)
				)
			)
			(if (not (IsFlag 109))
				(= global112 0)
			)
		)
		(gSwatInterface closeInvWindow:)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(PalCycle 4) ; Off
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR newRoomNumber release:)
		(gTheDoits release:)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(NewRoom gNewRoomNum)
		(self startRoom: gCurRoomNum)
		(while ((= temp0 (Event new: 3)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)

	(method (startRoom param1 &tmp temp0 temp1)
		(= temp1 (= temp0 0))
		(if darkPlane
			(darkPlane dispose:)
		)
		((ScriptID 28 0) doit:) ; dispCode
		(DisposeScript 28)
		(if (IsFlag 109)
			((= temp0 (ScriptID 71 0)) init:) ; crisisRegion
			(if (OneOf global108 4 5)
				(ScriptID 4054) ; kiplandRegion
				((ScriptID 4054 0) init:) ; kiplandRegion
			)
		)
		(= global112 temp0)
		(super startRoom: param1)
		(gSwatInterface setCursor:)
		(if global112
			(if (global112 resetData:)
				(global112 clearData:)
			)
			(global112 resetData: 1)
		)
		(if (IsFlag 2)
			(= temp1 1)
			(Palette 2 0 254 100) ; PalIntensity
			(FrameOut)
		)
		(if (not (OneOf gCurRoomNum 8 10 15 25 30 20 100 13 21 40 72)) ; sierraLogo, titleScreen, mainMenu, prevCareerId, prevCareerCallups, newCareer, openToon, funeralRoom
			(gSwatInterface showInterface:)
		)
		(if (not temp1)
			(Palette 2 0 254 100) ; PalIntensity
			(FrameOut)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((gUser canControl:)
				(if (and script (script handleEvent: event))
					(return 1)
				else
					(if (& (event type:) evVERB)
						(self pragmaFail:)
					)
					(return 1)
				)
			)
		)
	)

	(method (handsOff)
		(if isHandsOn
			(= isHandsOn 0)
			(gUser canControl: 0 canInput: 0)
			(gSwatInterface setCursor:)
		)
	)

	(method (handsOn)
		(if (not isHandsOn)
			(= isHandsOn 1)
			(gUser canControl: 1 canInput: 1)
			(gSwatInterface setCursor:)
		)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(SetCursor 305 303)
		(self setCursor: gWaitCursor init:)
		(while 1
			(if gQuit
				(switch gQuit
					(1
						(break)
					)
					(2
						(self queryQuit:)
					)
				)
			else
				(self doit:)
			)
		)
		((Styler pFadeArray:) dispose:)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 3])
		(DisposeScript 18)
		(DisposeScript 64990)
		(FrameOut)
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
		(gSwatInterface setCursor:)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(self saveRobot: 0)
		(if global112
			(global112 pausePath: 0)
		)
		(while 1
			(if gQuit
				(switch gQuit
					(1
						(break)
					)
					(2
						(self queryQuit:)
					)
				)
			else
				(self doit:)
			)
		)
		((Styler pFadeArray:) dispose:)
	)

	(method (restart &tmp temp0)
		(= global123 0)
		(for ((= temp0 10)) (< temp0 3999) ((++ temp0))
			(ClearFlag temp0)
		)
		(if (gTimers contains: callUpTimer)
			(callUpTimer dispose: delete:)
		)
		(if global403
			(global403 dispose:)
		)
		(if global404
			(global404 dispose:)
		)
		(if global405
			(global405 dispose:)
		)
		(if global406
			(global406 dispose:)
		)
		(if global407
			(global407 dispose:)
		)
		(if global408
			(global408 dispose:)
		)
		(if global409
			(global409 dispose:)
		)
		(if global410
			(global410 dispose:)
		)
		(if global411
			(global411 dispose:)
		)
		(if global434
			(global434 dispose:)
		)
		(if global435
			(global435 dispose:)
		)
		(= global136 0)
		(= global403 0)
		(= global404 0)
		(= global405 0)
		(= global406 0)
		(= global407 0)
		(= global408 0)
		(= global409 0)
		(= global410 0)
		(= global411 0)
		(= global434 0)
		(= global435 0)
		(= global415 0)
		(= global416 0)
		(= global417 0)
		(= global419 0)
		(= global432 0)
		(= global433 0)
		(= global437 0)
		(= global438 0)
		(= global439 0)
		(= global440 0)
		(= global441 0)
		(= global442 0)
		(= global443 0)
		(= global444 0)
		(= global445 10)
		(= global446 8)
		(= global447 0)
		(= global448 0)
		(= global134 0)
		(= global401 (Random 20 30))
		(= global402 (Random 20 30))
		(gEgo medals: 0)
		(gSwatInterface closeInvWindow:)
		(gCurRoom newRoom: 15) ; mainMenu
	)

	(method (save &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2] temp9 temp10 temp11)
		(if global112
			(global112 pausePath: 1)
		)
		(= temp0 (Str new:))
		(if (not (FileIO 19 (KString 9 gCurSaveDir))) ; ValidPath, StrGetData
			(= temp5 (Str new:))
			(= temp3 (Str new:))
			(Message msgGET 64994 9 0 0 1 (temp3 data:)) ; "%s is not a valid directory."
			(temp5 format: temp3 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: temp5
				addButtonBM: -1 0 0 1 {OK} 0 60
				init:
			)
			(GetDirectory gCurSaveDir)
			(temp5 dispose:)
			(temp3 dispose:)
		)
		(Load rsFONT gSmallFont)
		(= temp2 (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(self saveRobot: 1)
		(= temp1 (SwatSaveDlg doit: temp0))
		(DisposeScript 17)
		(DisposeScript 64990)
		(if (gGame darkPlane:)
			(gGame darkScreen: 0)
		)
		(switch temp1
			(-1)
			(-2
				(= temp3 (Str new:))
				(= temp4 (Str new:))
				(Message msgGET 64994 11 0 0 1 (temp3 data:)) ; "An error occurred while attempting to read the save game catalog file. The saved games in this directory are no longer usable."
				(Message msgGET 64994 2 0 0 1 (temp4 data:)) ; "OK"
				(if
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addText: temp3
						addButtonBM: 64990 0 0 0 temp4 0 80
						addButtonBM: 64990 2 0 1 {Change Dir} 110 80
						init:
					)
					(GetDirectory gCurSaveDir)
				)
				(temp3 dispose:)
				(temp4 dispose:)
			)
			(else
				(if gNumCD
					(self getDisc: gNumCD)
				)
				(= temp2 (self setCursor: gWaitCursor 1))
				(= temp9 global123)
				(= global123 0)
				(if (not (Save 0 name temp1 (temp0 data:) (KString 9 gVersion))) ; SaveGame, StrGetData
					(= temp3 (Str new:))
					(= temp4 (Str new:))
					(Message msgGET 64994 10 0 0 1 (temp3 data:)) ; "An error occurred while attempting to save your game. Try saving to another directory or saving over an existing saved game."
					(Message msgGET 64994 2 0 0 1 (temp4 data:)) ; "OK"
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addText: temp3
						addButtonBM: -1 0 0 1 temp4 0 80
						init:
					)
					(temp3 dispose:)
					(temp4 dispose:)
				else
					((= temp6 (MedalList new:))
						init:
						add: temp1
						write:
						dispose:
					)
					((= temp10 (CareerIDSet new:)) init:)
					(if (= temp11 (temp10 getCareerIdObj: temp1))
						(temp11
							valorCnt: global439
							starCnt: global440
							disServiceCnt: global441
							meritServCnt: global442
							commCitationCnt: global443
							policeCnt: global444
						)
					)
					(temp10 write: dispose:)
				)
				(= global123 temp9)
				(gSwatInterface setCursor:)
			)
		)
		(Sound pause: 0)
		(self saveRobot: 0)
		(if global112
			(global112 pausePath: 0)
		)
		(temp0 dispose:)
	)

	(method (restore param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= temp4 (Str new:))
		(if (not (FileIO 19 (KString 9 gCurSaveDir))) ; ValidPath, StrGetData
			(Message msgGET 64994 9 0 0 1 (temp2 data:)) ; "%s is not a valid directory."
			(temp4 format: temp2 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: temp4
				addButtonBM: -1 0 0 1 {OK} 0 60
				init:
			)
			(GetDirectory gCurSaveDir)
		)
		(self saveRobot: 1)
		(= temp1 (self setCursor: gNormalCursor))
		(= temp0
			(if argc
				param1
			else
				(SwatRestoreDlg doit: &rest)
			)
		)
		(DisposeScript 18)
		(DisposeScript 64990)
		(if (and (!= temp0 -1) (Save 3 name temp0 (KString 9 gVersion))) ; CheckSaveGame, StrGetData
			(self getDisc: (CD 1)) ; GetSaveCD
			(Sound pause: 1)
		else
			(Sound pause: 0)
		)
		(if (!= temp0 -1)
			(for
				((= temp9 (KList 3 (gPlanes elements:)))) ; FirstNode
				temp9
				((= temp9 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (KList 6 temp9)) ; NextNode
				(= temp5 (KList 8 temp9)) ; NodeValue
				(for
					((= temp10 (KList 3 ((temp5 casts:) elements:)))) ; FirstNode
					temp10
					((= temp10 ((temp5 casts:) nextNode:)))
					
					((temp5 casts:) nextNode: (KList 6 temp10)) ; NextNode
					(= temp6 (KList 8 temp10)) ; NodeValue
					(for
						((= temp11 (KList 3 (temp6 elements:)))) ; FirstNode
						temp11
						((= temp11 (temp6 nextNode:)))
						
						(temp6 nextNode: (KList 6 temp11)) ; NextNode
						(= temp7 (KList 8 temp11)) ; NodeValue
						(if (= temp8 (& (temp7 -info-:) $0010))
							(DeleteScreenItem temp7)
							(temp7 -info-: (| (temp7 -info-:) temp8))
						)
					)
				)
				(DeletePlane temp5)
			)
			(if (Save 3 name temp0 (KString 9 gVersion)) ; CheckSaveGame, StrGetData
				(proc4_5)
				(Palette 2 0 254 0) ; PalIntensity
				(FrameOut)
				(Save 1 name temp0 gVersion) ; RestoreGame
			else
				(for
					((= temp9 (KList 3 (gPlanes elements:)))) ; FirstNode
					temp9
					((= temp9 (gPlanes nextNode:)))
					
					(gPlanes nextNode: (KList 6 temp9)) ; NextNode
					(= temp5 (KList 8 temp9)) ; NodeValue
					(AddPlane temp5)
					(for
						((= temp10 (KList 3 ((temp5 casts:) elements:)))) ; FirstNode
						temp10
						((= temp10 ((temp5 casts:) nextNode:)))
						
						((temp5 casts:) nextNode: (KList 6 temp10)) ; NextNode
						(= temp6 (KList 8 temp10)) ; NodeValue
						(for
							((= temp11 (KList 3 (temp6 elements:)))) ; FirstNode
							temp11
							((= temp11 (temp6 nextNode:)))
							
							(temp6 nextNode: (KList 6 temp11)) ; NextNode
							(= temp7 (KList 8 temp11)) ; NodeValue
							(if (& (temp7 -info-:) $0010)
								(AddScreenItem temp7)
							)
						)
					)
				)
				(Message msgGET 64994 3 0 0 1 (temp2 data:)) ; "That game was saved under a different game or interpreter version. It cannot be restored."
				(Message msgGET 64994 2 0 0 1 (temp3 data:)) ; "OK"
				(Print
					font: 999
					fore: 0
					back: (Palette 3 127 127 127) ; PalMatch
					addText: (temp2 data:)
					addButtonBM: -1 0 0 1 (temp3 data:) 0 80
					init:
				)
				(gSwatInterface setCursor:)
			)
		)
		(self saveRobot: 0)
		(self setCursor: gWaitCursor 1)
		(gSwatInterface setCursor:)
		(DisposeScript 18)
		(temp2 dispose:)
		(temp3 dispose:)
		(temp4 dispose:)
	)

	(method (masterVolume param1)
		(if argc
			(DoAudio audVOLUME param1)
		else
			(DoAudio audVOLUME)
		)
	)

	(method (queryQuit &tmp temp0)
		(= temp0 isHandsOn)
		(gGame handsOn:)
		(proc4_4)
		(if (not temp0)
			(gGame handsOff:)
		)
	)

	(method (controlPanel &tmp temp0)
		(if (not (OneOf gCurRoomNum 13 30 15 20 25)) ; openToon, prevCareerCallups, mainMenu, newCareer, prevCareerId
			(gGame darkScreen: 1)
		)
		(= temp0 (proc11_0))
		(DisposeScript 11)
		(if temp0
			(switch temp0
				(1
					(gGame panelObj: gGame panelSelector: 82)
				)
				(2
					(gGame panelObj: gGame panelSelector: 83)
				)
			)
		else
			(gGame darkScreen: 0)
		)
	)

	(method (darkScreen &tmp [temp0 4]))

	(method (showCloseUp &tmp temp0)
		(= temp0 (CloseUp new:))
		(temp0 init: &rest)
	)

	(method (getDisc param1 &tmp temp0 temp1 temp2 temp3)
		(= gNumCD param1)
		(= temp3 (= temp2 0))
		(if (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
			(self setCursor: gTheInvisCursor 1)
			(if (gBackMusic handle:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic stop:)
			)
			(if (gBackMusic2 handle:)
				(Lock rsAUDIO (gBackMusic2 number:) 0)
				(gBackMusic2 stop:)
			)
			(Palette 2 0 254 0) ; PalIntensity
			(FrameOut)
			(= temp3 (Cast new:))
			((= temp2 (Plane new:))
				picture: 0
				init: 0 0 639 459
				priority: (+ (GetHighPlanePri) 100)
				addCast: (temp3 plane: temp2 yourself:)
			)
			(switch gNumCD
				(1
					(Load rsAUDIO 111)
					(discSound number: 111 setLoop: 0)
				)
				(2
					(Load rsAUDIO 112)
					(numberView setCel: 0 init: temp3)
					(discSound number: 112 setLoop: 0)
				)
				(3
					(Load rsAUDIO 113)
					(numberView setCel: 1 init: temp3)
					(discSound number: 113 setLoop: 0)
				)
				(4
					(Load rsAUDIO 114)
					(numberView setCel: 2 init: temp3)
					(discSound number: 114 setLoop: 0)
				)
			)
			(changeView init: temp3)
			(UpdateScreenItem changeView)
			(if (!= gNumCD 1)
				(UpdateScreenItem numberView)
			)
			(UpdatePlane temp2)
			(FrameOut)
			(Palette 2 0 41 100) ; PalIntensity
			(FrameOut)
			(proc4_5)
			(while (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
				(discSound play:)
				(while ((= temp1 (Event new:)) type:)
					(temp1 dispose:)
				)
				(temp1 dispose:)
				(for
					((= temp1 (Event new:)))
					(and (!= (temp1 message:) KEY_RETURN) (not (& (temp1 type:) evKEYBOARD)))
					((= temp1 (Event new:)))
					
					(temp1 dispose:)
				)
				(discSound stop:)
				(temp1 dispose:)
			)
			(temp2 dispose:)
		)
		(return temp0)
	)

	(method (saveRobot param1 &tmp temp0)
		(cond
			((or (not argc) param1)
				(if global420
					(if gAutoRobot
						(= temp0 (IntArray new: 4))
						(= global423
							(Max
								0
								(Min
									(Robot 11) ; FrameNum
									(- (Robot 2 (temp0 data:)) 1) ; FrameInfo
								)
							)
						)
						(temp0 dispose:)
						(gAutoRobot terminate: caller: 0 dispose: 0)
						(= gAutoRobot (= global128 0))
					else
						(WalkieTalkie terminate:)
					)
				)
			)
			(global420
				(= global128 global420)
				(if global429
					(WalkieTalkie
						doRobot:
							global420
							global421
							global422
							global423
							global425
							global428
							global424
							global426
					)
				else
					(WalkieTalkie
						showFrame:
							global420
							global423
							global421
							global422
							global424
							global427
					)
				)
			)
		)
	)

	(method (setCallUp param1)
		(if argc
			(if (gTimers contains: callUpTimer)
				(callUpTimer dispose: delete:)
			)
			(if (not (= callUpTime param1))
				(= param1 1)
			)
			(if
				(and
					(not (IsFlag 109))
					(IsFlag 116)
					(not (IsFlag 75))
					(not (IsFlag 64))
					(not (IsFlag 63))
					(not (IsFlag 67))
					(not (IsFlag 100))
					(not (IsFlag 103))
					(< callUpTime 15)
				)
				(if (and (or (IsFlag 89) (IsFlag 89)) (not (IsFlag 19)))
					(return)
				)
				(callUpTimer setReal: callUpTimer (* param1 2 60))
			)
		else
			(return callUpTime)
		)
	)
)

(instance pqDoVerbCode of Code
	(properties)

	(method (doit param1)
		(gCurRoom doVerb: param1)
	)
)

(instance pqApproachCode of Code
	(properties)

	(method (doit)
		(return -1)
	)
)

(instance pqMessager of Messager
	(properties)

	(method (findTalker &tmp temp0)
		(return gNarrator)
	)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

(instance SwatFtrInitializer of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #signal)
			(param1 signal: (| (param1 signal:) $7001))
		)
		(param1 sightAngle: 360)
	)
)

(instance DNKR of Code
	(properties)

	(method (doit param1 param2)
		(if (param1 respondsTo: #setKeep)
			(param1 setKeep: param2)
		)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance callUpTimer of Timer
	(properties)

	(method (doit)
		(if (and (!= gCurRoomNum 6200) (== gCurRoomNum gNewRoomNum) (not (IsFlag 109)))
			(super doit: &rest)
		)
	)

	(method (cue)
		(if
			(or
				(not (gGame isHandsOn:))
				(gCurRoom script:)
				(!= gNewRoomNum gCurRoomNum)
			)
			(self setReal: self 10)
		else
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(ClearFlag 12)
			(gSwatInterface closeInvWindow: startAlert: 1)
			(self dispose: delete:)
		)
	)
)

(instance changeView of View
	(properties
		view 20
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1000)
	)
)

(instance numberView of View
	(properties
		x 417
		y 135
		view 20
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1001)
	)
)

(instance discSound of Sound
	(properties
		flags 5
	)
)

