;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use ExitButton)
(use aEgoTalker)
(use KQNarrator)
(use AniCursor)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use PolyPath)
(use Polygon)
(use Cursor)
(use Timer)
(use Grooper)
(use Sound)
(use Save)
(use File)
(use Game)
(use Actor)
(use System)

(public
	KQ7CD 0
	interfacePlane 1
	proc0_2 2
	proc0_3 3
	respondSet 4
	lavaDeathTimer 5
	scorpDeathTimer 6
	desertDeathTimer 7
	stormDeathTimer 8
	volcanoDeathTimer 9
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
	gScreenWidth
	gScreenHeight
	gLastScreenX
	gLastScreenY
	; 100
	gGrooper
	global101 = 1234
	gKqMusic1
	gKqSound1
	gValOrRoz
	; 105
	global105
	global106
	global107 = 29
	global108
	global109
	; 110
	gInterfacePlane
	gDebugging
	global112
	global113
	global114
	; 115
	global115 = 6
	global116
	global117
	global118
	global119
	; 120
	global120
	gTheInvCursor
	gChapter
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
	global302 = 1
	global303 = 2
	global304 = 3
	; 305
	global305
	global306
	gInventoryCount
	global308
	global309
	; 310
	gKqRespondCode
	global311
	global312
	global313
	global314 = 1
	; 315
	global315 = 1
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
	global325 = 77
	gGem1Position
	gGem2Position = 3
	gGem3Position = 1
	global329 = -1
	; 330
	global330 = -1
	global331
	gTheUseObjCursor
	global333
	global334
	; 335
	global335
	global336
	gRozInventoryIndexes
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
	gValInventoryIndexes
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
	global372 = -1
	gPlane
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
	global400 = -1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Actor new:))
	(temp0 view: 64980 loop: 0 cel: 0 init: posn: 100 100)
	(= temp2 0)
	(= temp3 -1)
	(= temp4 (Plane new:))
	(temp4 init: picture: -1 priority: 1000)
	(UpdatePlane temp4)
	(FrameOut)
	(= temp1 (+ (GetTime) 120))
	(while (< (GetTime) temp1)
		(*= temp3 -1)
		(temp0 x: (+ (temp0 x:) temp3))
		(UpdateScreenItem temp0)
		(FrameOut)
		(++ temp2)
	)
	(temp4 dispose:)
	(return temp2)
)

(procedure (proc0_2 param1 param2 param3)
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc0_3 param1 param2)
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (localproc_1 param1 &tmp temp0) ; UNUSED
	(Str format: {%s%s} gCurSaveDir param1)
)

(instance interfacePlane of Plane
	(properties)
)

(instance interfaceCast of Cast
	(properties)
)

(instance gameHotCast of Cast
	(properties)
)

(instance intFaceHotCast of Cast
	(properties)
)

(instance theWaitCursor of Cursor
	(properties
		view 997
	)
)

(instance theNormalCursor of AniCursor
	(properties
		view 999
	)
)

(instance theInvCursor of Cursor
	(properties
		view 990
	)
)

(instance theUseObjCursor of Cursor
	(properties
		view 999
	)
)

(instance theSkullCursor of Cursor
	(properties
		view 999
		loop 1
	)
)

(class KQ7CD of Game
	(properties
		isHandsOn 0
		currentSpeed 6
		oldCurs 0
		speedRating 0
	)

	(method (play &tmp temp0 temp1 temp2 temp3)
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(gCurSaveDir data: (GetSaveDir))
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(self setCursor: gWaitCursor init:)
		(while 1
			(switch gQuit
				(0
					(self doit:)
				)
				(1
					(break)
				)
				(2
					(= temp0 (Str newWith: 50 {}))
					(= temp1 (Str newWith: 50 {}))
					(= temp2 (Str newWith: 50 {}))
					(Message msgGET 0 1 8 0 1 (temp0 data:)) ; "Your Game has been saved."
					(Message msgGET 0 1 8 0 2 (temp1 data:)) ; "The game has not been saved. Exit the game anyway?"
					(Message msgGET 0 1 8 0 3 (temp2 data:)) ; "Information"
					(if (== (MessageBox (temp1 data:) (temp2 data:) 52) 6)
						(break)
					else
						(= gQuit 0)
					)
					(temp0 dispose:)
					(temp1 dispose:)
					(temp2 dispose:)
				)
			)
		)
	)

	(method (init &tmp [temp0 9] temp9 temp10 temp11)
		(ScriptID 64982)
		DText
		DButton
		Print
		Polygon
		PolyPath
		(super init:)
		(self setCursor: gWaitCursor)
		((ScriptID 10 0) doit:) ; kqInitCode
		(= global333 0)
		(kqMusic1 owner: self flags: 1 init:)
		(kqSound1 flags: 5 owner: self init:)
		(= gSystemPlane (Plane new:))
		(= global108 (interfaceCast add:))
		(interfacePlane init: 0 137 319 199 priority: 2 addCast: interfaceCast)
		(interfaceCast plane: interfacePlane)
		(= gInterfacePlane interfacePlane)
		(= global123 (gameHotCast add:))
		(= global124 (intFaceHotCast add:))
		(respondSet add:)
		((ScriptID 18 0) doit:) ; scaryInvInit
		(= gVersion {xx.yyy.zzz})
		(if (!= (= temp9 (FileIO fiOPEN {version} 1)) -1)
			(FileIO fiREAD_STRING gVersion 11 temp9)
		)
		(FileIO fiCLOSE temp9)
		(= gEgo KQEgo)
		(= gTheCursor theNormalCursor)
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(= gTheInvCursor theInvCursor)
		(= gTheUseObjCursor theUseObjCursor)
		(= oldCurs gNormalCursor)
		(= gGrooper Grooper)
		(= gDoVerbCode kqDoVerbCode)
		(= gApproachCode kqApproachCode)
		(= gKqRespondCode kqRespondCode)
		(= gMessager kqMessager)
		(= gNarrator KQNarrator)
		(= gKqSound1 kqSound1)
		(= gKqMusic1 kqMusic1)
		(= isHandsOn 0)
		(= global322 (MemoryInfo 0))
		(= speedRating (localproc_0))
		(if (> speedRating 165)
			(SetFlag 97)
		else
			(ClearFlag 97)
		)
		(if (< speedRating 20)
			(= temp10 (Str newWith: 50 {}))
			(= temp11 (Str newWith: 50 {}))
			(Message msgGET 0 1 8 0 6 (temp10 data:)) ; "We have determined that your machine speed is not sufficient to play King's Quest 7 properly. This can be caused by a number of different problems. Check the readme file for hints on how to improve performance."
			(Message msgGET 0 1 8 0 3 (temp11 data:)) ; "Information"
			(MessageBox (temp10 data:) (temp11 data:) 48)
			(temp10 dispose:)
			(temp11 dispose:)
		)
		(ClearFlag 551)
		(if gDebugging
			(self newRoom: 26)
		else
			(self newRoom: 15)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (IsFlag 551)
			(ClearFlag 551)
			(if (gCurRoom inset:)
				((gCurRoom inset:) dispose:)
			)
		)
		(if (IsFlag 561)
			(ClearFlag 561)
			(gCast eachElementDo: #perform doUpdateCode)
			(FrameOut)
			(gPlane dispose:)
			(gKqMusic1 play:)
			(gGame smallSave:)
			(gKqMusic1 stop:)
			(gGame setCursor: gWaitCursor 1)
			(gCast eachElementDo: #dispose)
			((gCurRoom plane:)
				back: 0
				picture: -1
				setRect: 0 0 319 (gThePlane bottom:)
				yourself:
			)
			(UpdatePlane (gCurRoom plane:))
			(gSounds eachElementDo: #stop)
			((View new:)
				view: 983
				x: (+ (Abs (gThePlane left:)) (/ (- 320 (CelWide 983 0 0)) 2))
				y: (+ (Abs (gThePlane top:)) (/ (- 136 (CelHigh 983 0 0)) 2))
				z: 0
				setPri: 5000
				init:
			)
			(FrameOut)
			(= temp0 (GetTime))
			(while (< (- (GetTime) temp0) 45)
			)
			(gCurRoom newRoom: 30)
		)
	)

	(method (startRoom roomNum &tmp [temp0 4])
		(if (and oldCurs (== (oldCurs view:) 989))
			(oldCurs view: 999 loop: 0 cel: 0)
		)
		(if
			(OneOf
				roomNum
				4350
				4400
				4050
				4000
				4101
				4102
				4200
				4250
				4300
				4600
				4500
				4550
				4650
				4450
				4700
			)
			(ScriptID 4001) ; OogaBooga
			((ScriptID roomNum) setRegions: 4001) ; OogaBooga
		)
		(super startRoom: roomNum)
	)

	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (handleEvent event)
		(if (and gDebugging (== (event type:) evKEYBOARD))
			(switch (event message:)
				(KEY_F5
					(gGame save:)
					(event claimed: 1)
				)
				(KEY_F7
					(gGame restore:)
					(event claimed: 1)
				)
				(KEY_ADD
					(if (gUser controls:)
						(= global115 (Max 1 (-- global115)))
						(gGame currentSpeed: global115)
						(gEgo setSpeed: global115)
					)
				)
				(KEY_SUBTRACT
					(if (gUser controls:)
						(++ global115)
						(gGame currentSpeed: global115)
						(gEgo setSpeed: global115)
					)
				)
				($003d ; =
					(if (gUser controls:)
						(= global115 6)
						(gEgo setSpeed: 6)
					)
				)
			)
		)
		(if (and gDebugging (== (event type:) evKEYBOARD))
			((ScriptID 99) handleEvent: event) ; debugHandler
			((ScriptID 99) dispose:) ; debugHandler
			(DisposeScript 99)
		)
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

	(method (pragmaFail &tmp temp0 temp1 temp2)
		(= temp0 (self setCursor: theSkullCursor 1))
		(for ((= temp2 0)) (< temp2 3) ((++ temp2))
			(for ((= temp1 0)) (< temp1 30000) ((++ temp1))
			)
		)
		(self setCursor: temp0 1)
	)

	(method (handsOff param1 param2)
		(if isHandsOn
			(= isHandsOn 0)
			(gUser canControl: 0 canInput: 0)
			(if (== gTheCursor theNormalCursor)
				(theNormalCursor setCycle: 0)
			)
			(= oldCurs (gGame setCursor: gWaitCursor 1))
		)
		(kqMessager scratch: 0)
		(if
			(and
				(or (< argc 2) (not param2))
				(not (gInterfacePlane onMe: gMouseX gMouseY))
			)
			(SetCursor 165 145)
		)
		(if (and argc param1)
			((ScriptID 16 0) init: global108) ; skipCartoon
			(SetFlag 540)
		)
	)

	(method (handsOn)
		(if (not isHandsOn)
			(ClearFlag 540)
			((ScriptID 16 0) dispose:) ; skipCartoon
			(= isHandsOn 1)
			(gUser canControl: 1 canInput: 1)
			(gGame setCursor: oldCurs 1)
			(gUser need_update: 1)
			(if
				(and
					global311
					global331
					(global311 scratch:)
					(not
						(&
							((global311 scratch:) _respondVerbs:)
							(gKqRespondCode doit: (gUser message:))
						)
					)
				)
				(global331 cel: (Max 0 (+ (global331 cel:) 1)))
				(cond
					((== global331 gNormalCursor)
						(global331 view: 999 setCycle: 0 loop: 0 cel: 0 init:)
					)
					((== gTheCursor global331)
						(global331 init:)
					)
				)
				(if (not global308)
					(gUser message: (gUser dftMessage:))
				)
				(= global331 0)
				(= global311 0)
			)
		)
	)

	(method (smallSave param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp3 (Str newWith: 50))
		(= temp6 (Str format: {%s%s} gCurSaveDir {kq7cdsg.cat}))
		(Sound pause: 1)
		(if (not argc)
			(if (not (FileIO fiEXISTS (temp6 data:)))
				(return 1)
			)
			(= temp1 (File new:))
			(temp1 name: (temp6 data:) open: 1 read: temp3 2)
			(while (!= (proc0_3 temp3 0) global305)
				(temp1 seek: 36 1 read: temp3 2)
			)
			(temp1 readString: temp3 36 dispose:)
			(= param1 temp3)
		)
		(if global308
			(gUser message: 10)
			(global308 show:)
			(gNormalCursor cel: 0)
			(gGame setCursor: gNormalCursor)
			(= global308 0)
		)
		(= temp4 (SaveGame name global305 (param1 data:) (KString 9 gVersion))) ; StrGetData
		(temp6 dispose:)
		(Sound pause: 0)
		(temp3 dispose:)
		(return temp4)
	)

	(method (smallRestore param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp1 (Str new:))
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(if (not (ValidPath (KString 9 gCurSaveDir))) ; StrGetData
			(Message msgGET 64994 9 0 0 1 (temp1 data:)) ; "%s is not a valid directory."
			(temp3 format: temp1 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: temp3
				addButtonBM: -1 0 0 1 {OK} 0 30
				init:
			)
			(GetDirectory gCurSaveDir)
		)
		(if (!= param1 -1)
			(if global333
				(global333 dispose:)
				(= global333 0)
			)
			(for
				((= temp8 (FirstNode (gPlanes elements:))))
				temp8
				((= temp8 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (NextNode temp8))
				(= temp4 (NodeValue temp8))
				(for
					((= temp9 (FirstNode ((temp4 casts:) elements:))))
					temp9
					((= temp9 ((temp4 casts:) nextNode:)))
					
					((temp4 casts:) nextNode: (NextNode temp9))
					(= temp5 (NodeValue temp9))
					(for
						((= temp10 (FirstNode (temp5 elements:))))
						temp10
						((= temp10 (temp5 nextNode:)))
						
						(temp5 nextNode: (NextNode temp10))
						(= temp6 (NodeValue temp10))
						(if (= temp7 (& (temp6 -info-:) $0010))
							(DeleteScreenItem temp6)
							(temp6 -info-: (| (temp6 -info-:) temp7))
						)
					)
				)
				(DeletePlane temp4)
			)
			(self setCursor: gWaitCursor 1)
			(if (CheckSaveGame name param1 (KString 9 gVersion)) ; StrGetData
				(self getDisc: (GetSaveCDisc))
				(RestoreGame name param1 gVersion)
			else
				(for
					((= temp8 (FirstNode (gPlanes elements:))))
					temp8
					((= temp8 (gPlanes nextNode:)))
					
					(gPlanes nextNode: (NextNode temp8))
					(= temp4 (NodeValue temp8))
					(AddPlane temp4)
					(for
						((= temp9 (FirstNode ((temp4 casts:) elements:))))
						temp9
						((= temp9 ((temp4 casts:) nextNode:)))
						
						((temp4 casts:) nextNode: (NextNode temp9))
						(= temp5 (NodeValue temp9))
						(for
							((= temp10 (FirstNode (temp5 elements:))))
							temp10
							((= temp10 (temp5 nextNode:)))
							
							(temp5 nextNode: (NextNode temp10))
							(= temp6 (NodeValue temp10))
							(if (& (temp6 -info-:) $0010)
								(AddScreenItem temp6)
							)
						)
					)
				)
				(Message msgGET 64994 3 0 0 1 (temp1 data:)) ; "That game was saved under a different game or interpreter version. It cannot be restored."
				(Message msgGET 64994 2 0 0 1 (temp2 data:)) ; "OK"
				(Print
					font: 999
					fore: 0
					back: (Palette 3 127 127 127) ; PalMatch
					addText: (temp1 data:)
					addButtonBM: -1 0 0 1 (temp2 data:) 0 40
					init:
				)
				(self setCursor: temp0 (HaveMouse)) ; UNINIT
			)
		)
		(Sound pause: 0)
		(temp1 dispose:)
		(temp2 dispose:)
		(temp3 dispose:)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(FrameOut)
		(for
			((= temp4 (FirstNode (gPlanes elements:))))
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (NextNode temp4))
			(= temp1 (NodeValue temp4))
			(AddPlane temp1)
			(for
				((= temp5 (FirstNode ((temp1 casts:) elements:))))
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (NextNode temp5))
				(= temp2 (NodeValue temp5))
				(for
					((= temp6 (FirstNode (temp2 elements:))))
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (NextNode temp6))
					(= temp3 (NodeValue temp6))
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
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(if (!= (gCurRoom screen_left:) -1)
			(AddPicAt gThePlane (gCurRoom screen_left:) 0 0)
		)
		(if (!= (gCurRoom screen_mid:) -1)
			(AddPicAt gThePlane (gCurRoom screen_mid:) 320 0)
		)
		(if (!= (gCurRoom screen_right:) -1)
			(AddPicAt gThePlane (gCurRoom screen_right:) 640 0)
		)
		(while 1
			(switch gQuit
				(0
					(self doit:)
				)
				(1
					(break)
				)
				(2
					(= temp7 (Str newWith: 50 {}))
					(= temp8 (Str newWith: 50 {}))
					(= temp9 (Str newWith: 50 {}))
					(Message msgGET 0 1 8 0 1 (temp7 data:)) ; "Your Game has been saved."
					(Message msgGET 0 1 8 0 2 (temp8 data:)) ; "The game has not been saved. Exit the game anyway?"
					(Message msgGET 0 1 8 0 3 (temp9 data:)) ; "Information"
					(if (== (MessageBox (temp8 data:) (temp9 data:) 52) 6)
						(break)
					else
						(= gQuit 0)
					)
					(temp7 dispose:)
					(temp8 dispose:)
					(temp9 dispose:)
				)
			)
		)
	)
)

(instance kqDoVerbCode of Code
	(properties)

	(method (doit)
		(gGame pragmaFail:)
	)
)

(instance kqApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(9 1)
				(7 2)
				(10 4)
				(8 8)
				(else 32768)
			)
		)
	)
)

(class kqMessager of Messager
	(properties)

	(method (say)
		(= scratch 0)
		(if (gGame isHandsOn:)
			(if (IsFlag 272)
				(ClearFlag 272)
				(gGame handsOff: 0 1)
			else
				(gGame handsOff:)
			)
			(= scratch 1)
		else
			(= scratch 0)
		)
		(if (and gNarrator (gNarrator initialized:))
			(gNarrator cueVal: 1 dispose:)
		)
		(super say: &rest)
	)

	(method (sayRange)
		(= scratch 0)
		(if (gGame isHandsOn:)
			(if (IsFlag 272)
				(ClearFlag 272)
				(gGame handsOff: 0 1)
			else
				(gGame handsOff:)
			)
			(= scratch 1)
		else
			(= scratch 0)
		)
		(if (and gNarrator (gNarrator initialized:))
			(gNarrator cueVal: 1 dispose:)
		)
		(super sayRange: &rest)
	)

	(method (findTalker param1 &tmp temp0)
		(= temp0 gNarrator)
		(= global309 param1)
		(if
			(= temp0
				(switch param1
					(1
						(switch gCurRoomNum
							(6060
								(ScriptID 6060 4) ; valTalker
							)
							(2208
								(ScriptID 2208 1) ; valTalker
							)
							(else
								(ScriptID 13) ; aEgoTalker
							)
						)
					)
					(2
						(ScriptID 13) ; aEgoTalker
					)
					(7
						(ScriptID 13) ; aEgoTalker
					)
					(29
						(ScriptID gCurRoomNum 29)
					)
					(62
						(ScriptID 6060 3) ; atroposTalker
					)
					(25
						(ScriptID 7000 0) ; attisTalker
					)
					(49
						(if (== gCurRoomNum 4350)
							(ScriptID 4350 1) ; catTalk
						else
							(ScriptID 4250 1) ; catTalk
						)
					)
					(58
						(ScriptID 4000 1) ; dogTalker
					)
					(45
						(if (== gCurRoomNum 4350)
							(ScriptID 4350 3) ; boogeyTalk
						else
							(ScriptID 4001 8) ; boogeyTalker
						)
					)
					(22
						(ScriptID 2550 1) ; brutusTalker
					)
					(42
						(ScriptID 4200 42) ; monsterTalker
					)
					(55
						(ScriptID 3200 1) ; ceresTalker
					)
					(30
						(ScriptID gCurRoomNum 30)
					)
					(35
						(ScriptID gCurRoomNum 35)
					)
					(61
						(ScriptID 6060 2) ; clothoTalker
					)
					(40
						(ScriptID gCurRoomNum 40)
					)
					(59
						(ScriptID 4101 59) ; countTalker
					)
					(31
						(ScriptID gCurRoomNum 31)
					)
					(18
						(ScriptID 2455 1) ; toadTalker
					)
					(23
						(ScriptID 2600 1) ; dragonTalker
					)
					(63
						(ScriptID 6150 1) ; dreamTalker
					)
					(37
						(if (== gCurRoomNum 5000)
							(ScriptID 5000 1) ; mockTalker
						else
							(ScriptID gCurRoomNum 37)
						)
					)
					(70
						(ScriptID 7001 4) ; edgerTalker
					)
					(6
						(if (== gCurRoomNum 4650)
							gNarrator
						else
							(ScriptID 7001 0) ; kingTalker
						)
					)
					(36
						(if (== gCurRoomNum 5050)
							(ScriptID 5050 1) ; bullTalker
						else
							(ScriptID gCurRoomNum 36)
						)
					)
					(17
						(ScriptID 2460 3) ; fem1Talker
					)
					(16
						(ScriptID 2460 4) ; fem2Talker
					)
					(20
						(ScriptID 2050 1) ; forgerTalker
					)
					(28
						(ScriptID gCurRoomNum 28)
					)
					(41
						(ScriptID 7001 5) ; kid1Talker
					)
					(48
						(ScriptID 7001 6) ; kid2Talker
					)
					(47
						(ScriptID 7001 7) ; bothKidsTalker
					)
					(39
						(switch gCurRoomNum
							(4350
								(if
									(==
										((ScriptID 4001 0) script:) ; OogaBooga
										(ScriptID 4001 4) ; diggerComes
									)
									(ScriptID 4001 7) ; diggerTalker
								else
									(ScriptID 4350 2) ; digTalk
								)
							)
							(4050
								(ScriptID 4050 1) ; gdTalker
							)
							(else
								(ScriptID 4001 7) ; diggerTalker
							)
						)
					)
					(43
						(ScriptID 4200 43) ; hannibalTalker
					)
					(50
						(ScriptID 4300 50) ; headTalker
					)
					(21
						(ScriptID 2050 2) ; jewelerTalker
					)
					(54
						(ScriptID gCurRoomNum 54)
					)
					(4
						(ScriptID 1100 1) ; ratTalker
					)
					(60
						(ScriptID 6060 1) ; lachesisTalker
					)
					(66
						(ScriptID 7001 8) ; levanterTalker
					)
					(15
						(ScriptID 2460 1) ; male1Talker
					)
					(14
						(ScriptID 2460 2) ; male2Talker
					)
					(12
						(ScriptID 7001 1) ; maliciaTalker
					)
					(8
						(ScriptID 7001 2) ; mathildeTalker
					)
					(33
						(ScriptID 5300 33) ; mockingBirdTalker
					)
					(68
						(ScriptID 7001 9) ; oberonTalker
					)
					(51
						(ScriptID 4550 1) ; plantTalker1
					)
					(52
						(ScriptID 4550 2) ; plantTalker2
					)
					(53
						(ScriptID 4550 3) ; plantTalker3
					)
					(44
						(if (== gCurRoomNum 4650)
							gNarrator
						else
							(ScriptID 7001 0) ; kingTalker
						)
					)
					(27
						(ScriptID 3100 1) ; rockTalker
					)
					(34
						(ScriptID 5300 34) ; snakeTalker
					)
					(9
						(ScriptID 2450 1) ; spikeTalker
					)
					(5
						(ScriptID 7001 3) ; spiritTalker
					)
					(67
						(ScriptID 7001 10) ; titaniaTalker
					)
					(32
						(ScriptID 5100 32) ; foremanTalker
					)
					(46
						(ScriptID 4101 46) ; elspethTalker
					)
					(else gNarrator)
				)
			)
			(return temp0)
		else
			(return gNarrator)
		)
	)

	(method (dispose)
		(if scratch
			(gGame handsOn:)
		)
		(super dispose:)
	)
)

(instance kqMusic1 of Sound
	(properties)
)

(instance kqSound1 of Sound
	(properties)
)

(instance kqRespondCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				((respondSet at: 0) 1)
				((respondSet at: 1) 2)
				((respondSet at: 2) 4)
				((respondSet at: 3) 8)
				((respondSet at: 4) 16)
				((respondSet at: 5) 32)
				((respondSet at: 6) 64)
				((respondSet at: 7) 128)
				((respondSet at: 8) 256)
				((respondSet at: 9) 512)
				((respondSet at: 10) 1024)
				((respondSet at: 11) 2048)
				((respondSet at: 12) 4096)
				((respondSet at: 13) 8192)
				((respondSet at: 14) 16384)
				(else 32768)
			)
		)
	)
)

(instance respondSet of Set
	(properties)
)

(instance scorpDeathTimer of Timer
	(properties)

	(method (cue)
		(ClearFlag 20)
		(if (== gCurRoomNum 1450)
			(gCurRoom cue:)
		)
		(self client: 0 delete: dispose:)
	)
)

(instance desertDeathTimer of Timer
	(properties)

	(method (cue)
		(if (or (IsFlag 17) (gCurRoom script:))
			(self setReal: self 15)
		else
			(SetFlag 128)
			(gCurRoom cue:)
			(self client: 0 delete: dispose:)
		)
	)
)

(instance stormDeathTimer of Timer
	(properties)

	(method (cue)
		(if (or (IsFlag 17) (gCurRoom script:))
			(self setReal: self 15)
		else
			(self client: 0 delete: dispose:)
			(gCurRoom cue:)
		)
	)
)

(class Chap6Timer of Timer
	(properties)

	(method (getProgress &tmp temp0)
		(= temp0 0)
		(if (IsFlag 251)
			(++ temp0)
		)
		(if (IsFlag 252)
			(++ temp0)
		)
		(if (IsFlag 256)
			(++ temp0)
		)
		(if (IsFlag 257)
			(++ temp0)
		)
		(if (IsFlag 258)
			(++ temp0)
		)
		(if (IsFlag 259)
			(++ temp0)
		)
		(return temp0)
	)

	(method (getTime)
		(return 0)
	)

	(method (setTicks)
		(Prints {Must use setReal for this timer, see Room 0})
	)

	(method (doit)
		(if (gUser input:)
			(super doit: &rest)
		)
	)
)

(instance lavaDeathTimer of Chap6Timer
	(properties)

	(method (cue)
		(if (not (IsFlag 281))
			(SetFlag 255)
			(self setReal: self (self getTime:))
			(if (not (IsFlag 570))
				(volcanoDeathTimer
					setReal: volcanoDeathTimer (volcanoDeathTimer getTime:)
				)
			)
		else
			(self client: 0 delete: dispose:)
		)
	)

	(method (getTime &tmp temp0 temp1)
		(= temp0 (self getProgress:))
		(= temp1 210)
		(if temp0
			(-= temp1 (* 35 temp0))
		)
		(if (<= temp1 0)
			(= temp1 35)
		)
		(return temp1)
	)
)

(instance volcanoDeathTimer of Chap6Timer
	(properties)

	(method (cue)
		(if (not (IsFlag 281))
			(SetFlag 266)
			(self setReal: self (self getTime:))
			(lavaDeathTimer setReal: lavaDeathTimer (lavaDeathTimer getTime:))
			(gCurRoom newRoom: 2150)
		else
			(self client: 0 delete: dispose:)
		)
	)

	(method (getTime &tmp temp0 temp1)
		(= temp0 (self getProgress:))
		(= temp1 300)
		(if temp0
			(-= temp1 (* 50 temp0))
		)
		(if (<= temp1 0)
			(= temp1 50)
		)
		(return temp1)
	)
)

(instance doUpdateCode of Code
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

