;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use BertaWindow)
(use DLetter)
(use KQCursor)
(use CDActor)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use DCIcon)
(use Timer)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	KQ5 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	RedrawCast 5
	cls 6
	proc0_7 7
	proc0_8 8
	SetFlag 9
	ClearFlag 10
	proc0_11 11
	IsFlag 12
	proc0_15 15
	proc0_18 18
	proc0_19 19
	proc0_21 21
	proc0_24 24
	EgoDead 26
	SetScore 27
	proc0_28 28
	proc0_30 30
	proc0_31 31
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
	gSFeatures
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
	global102
	global103 = 1
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
	gGlobalSound3
	global159 = 256
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
	global312 = -1
	global313
	global314
	; 315
	global315
	global316
	gGlobalSound4
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
	gGlobalSound2
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
	global374 = 1
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
	gMordObj
	global387
	global388
	global389
	; 390
	global390
	global391
	global392
	global393
	global394 = 1
	; 395
	global395
	gTheCrownCursor
	gGlobalSound
	gEmptyBagCursor
	global399
	; 400
	global400
	global401
)

(procedure (proc0_19 &tmp temp0)
	(repeat
		(breakif
			(!= (= temp0 (GetNumber {Teleport to:})) -1)
		)
	)
	(= global103 0)
	(gGame setCursor: (= global106 global75) 1)
	(gCurRoom newRoom: temp0)
)

(procedure (NormalEgo param1 param2)
	(cond
		((>= argc 1)
			(gEgo loop: param1)
		)
		((== argc 2)
			(gEgo view: param2)
		)
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		moveSpeed: (gGame egoMoveSpeed:)
		setCycle: KQ5SyncWalk
		cycleSpeed: (gGame egoMoveSpeed:)
		setStep: 3 2
		normal: 1
		illegalBits: -32768
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(gGame setCursor: gWaitCursor 1)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(gTheIconBar disable:)
	(= global102 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable:)
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	(= global102 0)
)

(procedure (HaveMem param1) ; UNUSED
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (proc0_18 param1 param2 param3 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
		(Palette palSET_INTENSITY param1 param2 temp0)
		(Wait param3)
	)
)

(procedure (proc0_15 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if global156
		(Display 0 30 dsRESTOREPIXELS global157)
		(Display 0 30 dsRESTOREPIXELS global156)
		(= global156 0)
	)
	(if param1
		(= temp1 (if (and (> argc 1) (>= param2 0)) param2 else 5))
		(= temp0 (if (and (> argc 2) (>= param3 0)) param3 else 5))
		(= temp2 (if (and (> argc 3) (>= param4 0)) param4 else 0))
		(= global156
			(Display
				param1
				dsWIDTH
				(- 260 temp0)
				dsCOORD
				temp0
				temp1
				dsALIGN
				alLEFT
				dsFONT
				9
				dsCOLOR
				temp2
				dsSAVEPIXELS
			)
		)
		(= global157
			(Display
				param1
				dsWIDTH
				(- 260 temp0)
				dsCOORD
				temp0
				temp1
				dsALIGN
				alLEFT
				dsFONT
				8
				dsCOLOR
				15
				dsSAVEPIXELS
			)
		)
	)
)

(procedure (proc0_7 param1 param2 param3 &tmp temp0)
	(proc0_24
		param1
		(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
		param3
	)
	(if (== argc 4)
		(proc0_7 param2 param1 param3)
	)
)

(procedure (proc0_24 param1 param2 param3 &tmp temp0)
	(if (not (& (param1 signal:) $0800))
		(if (or (< argc 3) (not (= temp0 param3)))
			(= temp0 (NumLoops param1))
		)
		(cond
			((> temp0 8)
				(param1
					loop:
						(cond
							((and (> param2 22) (< param2 68)) 6)
							((and (> param2 67) (< param2 113)) 0)
							((and (> param2 112) (< param2 158)) 4)
							((and (> param2 157) (< param2 203)) 2)
							((and (> param2 202) (< param2 248)) 5)
							((and (> param2 247) (< param2 293)) 1)
							((and (> param2 292) (< param2 338)) 7)
							(else 3)
						)
				)
			)
			((> temp0 4)
				(param1
					loop:
						(cond
							((and (> param2 44) (< param2 136)) 0)
							((and (> param2 135) (< param2 225)) 2)
							((and (> param2 224) (< param2 316)) 1)
							(else 3)
						)
				)
			)
			(temp0
				(= param2 (mod (+ (-= param2 (/ 180 temp0)) 360) 360))
				(param1 loop: (/ param2 (/ 360 temp0)))
			)
		)
		(if (param1 respondsTo: #head)
			((param1 head:) look:)
		)
	)
)

(procedure (proc0_8 param1 param2 param3 param4 &tmp temp0)
	((= temp0 (Event new:)) type: param2 message: param3 modifiers: param4)
	(if param1
		(param1 handleEvent: temp0)
	else
		(KQ5 handleEvent: temp0)
	)
	(temp0 dispose:)
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
		(= temp2 (/ (= temp1 [param2 temp0]) 16))
		(= temp3 (<< $0001 (mod temp1 16)))
		(switch param1
			(1
				(break)
			)
			(2
				(&= [global129 temp2] (~ temp3))
			)
			(0
				(|= [global129 temp2] temp3)
			)
			(3
				(^= [global129 temp2] temp3)
			)
		)
	)
	(return (& [global129 temp2] temp3))
)

(procedure (SetFlag)
	(localproc_0 0 &rest)
)

(procedure (IsFlag)
	(localproc_0 1 &rest)
)

(procedure (ClearFlag)
	(localproc_0 2 &rest)
)

(procedure (proc0_11) ; UNUSED
	(localproc_0 3 &rest)
)

(procedure (EgoDead param1 param2 param3 param4)
	(HandsOff)
	(gGame setCursor: arrowCursor)
	(if argc
		(Load rsVIEW param1)
	else
		(Load rsVIEW 248)
	)
	(deathIcon
		view: (if argc param1 else 248)
		loop: (if argc param2 else 0)
		cycler: (if (< argc 3) 0 else param3)
		cycleSpeed: (if (< argc 4) 30 else param4)
	)
	(gGlobalSound number: 19 loop: 1 vol: 127 priority: 500 playBed:)
	(repeat
		(switch
			(Print
				global330
				#width
				220
				#icon
				deathIcon
				param2
				0
				#mode
				1
				#button
				{Restore}
				1
				#button
				{Restart}
				2
				#button
				{    Quit    }
				3
			)
			(1
				(DoAudio audSTOP)
				(gGame restore:)
			)
			(2
				(DoAudio audSTOP)
				(gGame restart: 0)
			)
			(3
				(DoAudio audSTOP)
				(= gQuit 1)
				(break)
			)
		)
	)
)

(procedure (proc0_30 param1 param2 param3 param4) ; UNUSED
	(DoAudio audPLAY param1)
	(Print {} #icon param2 param3 param4 &rest)
)

(procedure (SetScore param1)
	(rm0Sound priority: 15 number: 65 loop: 1 play:)
	(if argc
		(+= gScore param1)
	)
)

(procedure (proc0_28 param1 param2 param3 &tmp temp0 [temp1 500])
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp1)
	else
		(StrCpy @temp1 param2)
	)
	(talkerIcon
		view: param1
		cycler: Fwd
		cycleSpeed: 6
		count: (+ (/ (StrLen @temp1) 20) 1)
		talker: 1
	)
	(if (u< param2 1000)
		(Print @temp1 &rest #icon talkerIcon 0 0)
	else
		(Print @temp1 param3 &rest 82 talkerIcon 0 0)
	)
)

(procedure (proc0_21 &tmp temp0 temp1 temp2)
	(if (User canInput:)
		(= temp0 (gGame setCursor: gNarrator))
		(= global126 0)
		(signalView
			view: 942
			loop: 0
			cel: 10
			posn: gMouseX (- (signalView y:) 10) (- (signalView y:) gMouseY)
			forceUpd:
			show:
		)
		(Animate (gCast elements:) 0)
		(= temp2 (GetTime))
		(while (< (Abs (- temp2 (GetTime))) 40)
			(breakif (OneOf ((= temp1 (Event new:)) type:) evKEYBOARD evMOUSEBUTTON))
			(temp1 dispose:)
		)
		(if (IsObject temp1)
			(temp1 dispose:)
		)
		(signalView posn: 1000 1000 hide:)
		(gGame setCursor: temp0 1)
	)
)

(procedure (proc0_31 param1)
	(return (>= (gGame detailLevel:) (param1 detailLevel:)))
)

(class KQ5SyncWalk of SyncWalk
	(properties)

	(method (doit)
		(if (<= (client loop:) 3)
			(super doit:)
		)
	)
)

(class ego of Body
	(properties)

	(method (init)
		(if (not cycler)
			(self setCycle: KQ5SyncWalk)
		)
		(super init: &rest)
	)

	(method (setMotion)
		(self
			cycleSpeed: (gGame egoMoveSpeed:)
			moveSpeed: (gGame egoMoveSpeed:)
		)
		(super setMotion: &rest)
	)

	(method (handleEvent event)
		(if
			(or
				(& (event type:) $0040) ; direction
				(== (event type:) evMOUSEBUTTON)
				(and (== (event type:) evVERB) (== (event message:) 1))
			)
			(= global323 (event x:))
			(= global324 (event y:))
			(super handleEvent: event)
		)
		(if
			(or
				(event claimed:)
				(!= (event type:) evVERB)
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (IsFlag 74)
						(PrintDC 0 0) ; "Graham gently carries his friend Cedric, who has been wounded by the horrible harpies."
					else
						(PrintDC 0 1) ; "King Graham, heavy of heart, searches far and wide for his beloved family who've been stolen by an evil wizard."
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(cond
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 10)
							(if (and (!= gCurRoomNum 90) (!= gCurRoomNum 85))
								(rm0Sound number: 52 loop: 1 play:)
								(PrintDC 0 2) ; "Having learned to play the harp long ago, Graham now plays beautifully."
								(rm0Sound stop:)
								(event claimed: 1)
							)
						)
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 26)
							(cond
								((IsFlag 15)
									(PrintDC 0 3) ; "Graham is already wearing the warm cloak."
									(event claimed: 1)
								)
								((not (OneOf gCurRoomNum 29 30))
									(PrintDC 0 4) ; "Here, the air is too warm to be wearing heavy outer garments."
									(event claimed: 1)
								)
							)
						)
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 34)
							(if
								(or
									(IsFlag 15)
									(not (OneOf gCurRoomNum 29 30 85 2 90))
									(and (== gCurRoomNum 2) (IsFlag 47))
								)
								(rm0Sound number: 50 loop: 1 play:)
								(PrintDC 0 5) ; "Graham hits and shakes the tambourine with much ruckus, but finds it doesn't accomplish anything."
								(event claimed: 1)
							)
						)
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 17)
							(if (!= gCurRoomNum 24)
								(PrintDC 0 6) ; "Graham has no desire to put the dirty honeycomb in his mouth no matter how tempting the honey may be!"
								(event claimed: 1)
							)
						)
						((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 6)
							(gCurRoom newRoom: 208) ; releaseGenie
							(event claimed: 1)
						)
						(
							(OneOf
								(gInventory indexOf: (gTheIconBar curInvIcon:))
								2
								19
								27
								17
								32
								15
								33
								18
								12
								22
								25
								36
								8
								5
								37
							)
							(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
								(2
									(SetFlag 16)
									(PrintDC 0 7) ; "Mmmmmmm! That was the best custard pie Graham has ever eaten!"
									(gEgo put: 2 1) ; Pie
									(event claimed: 1)
								)
								(19
									(if (== (++ global316) 1)
										(SetScore 4)
										(SetFlag 16)
										(PrintDC 0 8) ; "Graham finds the leg of lamb a bit tough, but tasty enough. Filling up quickly, he saves the other half for later."
										((gInventory at: 19) cel: 5) ; Leg_of_Lamb
										((gInventory at: 19) ; Leg_of_Lamb
											cursor: halfLambCursor
											yourself:
										)
										(gEgo put: 19 gCurRoomNum) ; Leg_of_Lamb
										(gEgo get: 19) ; Leg_of_Lamb
									else
										(PrintDC 0 9) ; "Feeling a bit hungry, Graham finishes off the other half of the leg of lamb."
										(gEgo put: 19 1) ; Leg_of_Lamb
									)
									(event claimed: 1)
								)
								(27
									(if (IsFlag 84)
										(PrintDC 0 10) ; "Graham is already wearing the amulet around his neck."
									else
										(PrintDC 0 11) ; "The magic amulet begins to glow softly as Graham slips it over his head. He then carefully tucks the amulet into the front of his tunic, hiding it from sight."
										(rm0Sound
											priority: 15
											number: 65
											loop: 1
											play:
										)
										(SetFlag 84)
									)
									(event claimed: 1)
								)
								(else
									(if
										(or
											(IsFlag 15)
											(not (OneOf gCurRoomNum 29 30))
										)
										(switch
											(gInventory
												indexOf: (gTheIconBar curInvIcon:)
											)
											(32
												(PrintDC 0 12) ; "The moldy cheese is not fit for eating."
											)
											(15
												(PrintDC 0 13) ; "Unfortunately Graham is all thumbs when it comes to operating a spinning wheel."
											)
											(33
												(PrintDC 0 14) ; "Even though these are a very fine pair of shoes, Graham finds them too small for his own feet."
											)
											(12
												(PrintDC 0 15) ; "Graham is too old to play with toys!"
											)
											(22
												(PrintDC 0 16) ; "Nothing would be accomplished by using the hammer here."
											)
											(25
												(PrintDC 0 17) ; "Wearing the delicate locket would detract from Graham's "manly" appearance."
											)
											(36
												(PrintDC 0 18) ; "Graham would look silly wearing that hairpin!"
											)
											(8
												(PrintDC 0 19) ; "Wearing one old shoe would do Graham no good at all!"
											)
											(18
												(PrintDC 0 20) ; "The lump of beeswax has become soft and sticky from the warmth of Graham's body."
											)
											(else
												(PrintDC 0 21) ; "The smelly old fish is much too disgusting for human consumption."
											)
										)
										(event claimed: 1)
									)
								)
							)
						)
					)
				)
				(5 ; Talk
					(if (IsFlag 74)
						(PrintDC 0 22) ; "Cedric is in too much pain to carry on a conversation right now."
					else
						(PrintDC 0 23) ; "Talking to yourself again, Graham?"
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (IsFlag 74)
						(PrintDC 0 24) ; "Poor Cedric is hurt and needs help. How can Graham help him?"
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance gControls of Controls ; UNUSED
	(properties)
)

(instance globalSound of Sound
	(properties
		flags 1
		priority 1
	)
)

(instance globalSound2 of Sound
	(properties
		flags 1
		priority 2
	)
)

(instance globalSound3 of Sound
	(properties
		flags 1
		priority 3
	)
)

(instance globalSound4 of Sound
	(properties
		flags 1
		priority 4
	)
)

(instance rm0Sound of Sound
	(properties
		flags 1
		priority 15
	)
)

(instance KQ5 of Game
	(properties
		printLang 49
	)

	(method (init &tmp [temp0 28])
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(= global159 0)
		else
			(= global159 1)
		)
		(= gSystemWindow KQ5Window)
		(= gDoVerbCode kq5DoVerbCode)
		(= gFtrInitializer FtrInit)
		(= global330
			{Thanks for playing King's Quest V.}
		)
		(gGame egoMoveSpeed: 2 setSpeed: 1 masterVolume: 12)
		(= gPMouse kQPMouse)
		(LoadMany rsSCRIPT 932 756)
		Polygon
		PolyPath
		RFeature
		Timer
		(= gEmptyBagCursor emptyBagCursor)
		(super init:)
		(= gVersion {1.000.009})
		(if (== (StrAt gVersion 0) 120)
			(= global100 1)
		else
			(= global100 0)
		)
		(= global17 10)
		(User
			canControl: 0
			x: -1
			y: 150
			init: (User inputLineAddr:) 30
			alterEgo: ((= gEgo ego) looper: MyLooper yourself:)
		)
		(= gPossibleScore 260)
		(= gUserFont 4)
		(globalSound owner: self init:)
		(globalSound2 owner: self init:)
		(globalSound3 owner: self init:)
		(globalSound4 owner: self init:)
		(= gGlobalSound globalSound)
		(= gGlobalSound2 globalSound2)
		(= gGlobalSound3 globalSound3)
		(= gGlobalSound4 globalSound4)
		(= gNarrator theInvCursor)
		(= gWaitCursor speakCursor)
		(= gNormalCursor arrowCursor)
		(= gTheCrownCursor theCrownCursor)
		(= global75 theGameCursor)
		(DoSound sndSET_SOUND 1)
		(cls)
		((= gTheIconBar IconBar)
			add:
				(icon0 cursor: walkCursor yourself:)
				(icon1 cursor: eyeCursor yourself:)
				(icon2 cursor: handCursor yourself:)
				(icon3 cursor: talkCursor yourself:)
				(icon4 cursor: arrowCursor yourself:)
				(icon5 cursor: arrowCursor yourself:)
				(icon8 cursor: arrowCursor yourself:)
				(icon9 cursor: helpCursor yourself:)
			eachElementDo: #init
			eachElementDo: #highlightColor 1
			eachElementDo:
				#lowlightColor
				(cond
					((== global105 256) 19)
					((== global105 32) 9)
					(else 7)
				)
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
			disable: icon4
		)
		((ScriptID 758) init:) ; KQInv
		(= global103 0)
		(= global106 (= global75 6))
		(self setCursor: theGameCursor)
		(= gUseObstacles 1)
		(if (GameIsRestarting)
			(= global322 1)
		)
		(self newRoom: 99)
	)

	(method (save)
		(Load rsCURSOR 456)
		(super save:)
	)

	(method (restore)
		(Load rsCURSOR 456)
		(super restore: &rest)
	)

	(method (quitGame)
		(super quitGame: (Print 0 25 #button {Yes} 1 #button {No} 0)) ; "Do you really want to quit?"
		(DoAudio audSTOP)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(if
			(and
				(!=
					(= temp0 (gEgo loop:))
					(= temp1 (- (NumLoops gEgo) 1))
				)
				(not (IsFlag 22))
				(not (gEgo avoider:))
				(gEgo normal:)
				(or (not (gEgo mover:)) (gEgo isBlocked:))
			)
			(gEgo
				loop: temp1
				cel: temp0
				setMotion: 0
				signal: (& (gEgo signal:) $fbff)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(super newRoom: newRoomNumber)
	)

	(method (pragmaFail)
		(if (User canInput:)
			(proc0_21)
		)
	)

	(method (setCursor param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(if (IsObject param1)
			(param1 init: &rest)
			(return temp0)
		)
	)

	(method (startRoom roomNum &tmp temp0)
		(gGlobalSound3 stop:)
		(gGlobalSound4 stop:)
		(LoadMany
			0
			972
			970
			760
			762
			929
			941
			759
			982
			949
			202
			888
			889
			930
			928
			767
			754
		)
		(if (== gPrevRoomNum 99)
			(if (== gHowFast 0)
				((ScriptID 755) init:) ; slowControls
			else
				((ScriptID 755 1) init:) ; fastControls
			)
		)
		(LoadMany rsCURSOR 6 7 8 9)
		(Load rsFONT 4)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(| $0001 (Palette palSET_INTENSITY 0 255 100))
				(Print 0 26 #button {Who cares} 0 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(super startRoom: roomNum)
		(if (not (IsFlag 33))
			(signalView init: posn: 1000 1000 setPri: 15 hide:)
		)
		(= global124 160)
		(= global125 105)
		(gFeatures eachElementDo: #init)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 278])
		(if (event claimed:)
			(return)
		)
		(switch (event message:)
			(4 ; Inventory
				(cond
					((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(if (IsFlag 60)
							(PrintDC 0 27) ; "Graham waves Crispin's wand which now pulsates with renewed power, but nothing happens."
						else
							(PrintDC 0 28) ; "Graham gives the wand a good shake, but it only fizzles and dies."
						)
						(event claimed: 1)
					)
					((== (gInventory indexOf: (gTheIconBar curInvIcon:)) 35)
						(PrintDC 0 29) ; "Graham waves Mordack's glowing wand...but nothing happens. Could it be that Crispin was right? That wands only respond to their owner...like a pet?"
						(event claimed: 1)
					)
				)
			)
		)
		(switch (event type:)
			((super handleEvent: event))
			(evMOUSEBUTTON
				(if (and (not (event claimed:)) global100)
					(event localize:)
					(= temp2 (event x:))
					(= temp3 (event y:))
					(if (& (= temp4 (event modifiers:)) emALT)
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp1 (Event new:)) type:))
							(temp1 localize:)
							((User alterEgo:)
								posn: (temp1 x:) (temp1 y:)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp1 dispose:)
						)
						(temp1 dispose:)
					)
				)
			)
			(evKEYBOARD
				(if
					(and
						(not (event claimed:))
						(not global327)
						(User controls:)
					)
					(event claimed: 1)
					(switch (event message:)
						(KEY_TAB
							(gInventory showSelf: gEgo)
						)
						(KEY_SHIFTTAB
							(if (HaveMouse)
								(gInventory showSelf: gEgo)
							)
						)
						(KEY_F1
							((ScriptID 753) doit:) ; help
						)
						(else
							(if global100
								((ScriptID 889 0) doit: event) ; rm000Debug
							)
						)
					)
				)
			)
		)
	)
)

(instance signalView of View
	(properties
		view 942
	)
)

(instance icon0 of IconI
	(properties
		view 942
		loop 0
		cel 2
		message 1
		signal 64
		helpStr {This icon is for walking.}
		maskView 942
		maskCel 11
	)
)

(instance icon1 of IconI
	(properties
		view 942
		loop 0
		cel 3
		message 2
		signal 64
		helpStr {This icon is for looking.}
		maskView 942
		maskCel 11
	)
)

(instance icon2 of IconI
	(properties
		view 942
		loop 0
		cel 4
		message 3
		signal 64
		helpStr {This icon is for doing.}
		maskView 942
		maskCel 11
	)
)

(instance icon3 of IconI
	(properties
		view 942
		loop 0
		cel 5
		message 5
		signal 64
		helpStr {This icon is for talking.}
		maskView 942
		maskCel 11
	)
)

(instance icon4 of IconI
	(properties
		view 942
		loop 0
		cel 6
		message 4
		signal 64
		helpStr {This icon is for current inventory item.}
		maskView 942
		maskCel 11
	)
)

(instance icon5 of IconI
	(properties
		view 942
		loop 0
		cel 7
		type 0
		message 0
		signal 66
		helpStr {This icon brings up the inventory window.}
		maskView 942
		maskCel 11
	)

	(method (select)
		(if (super select:)
			(gInventory showSelf: gEgo)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 942
		loop 0
		cel 8
		message 8
		signal 66
		helpStr {This icon brings up the control panel.}
		maskView 942
		maskCel 11
	)

	(method (select)
		(if (super select:)
			(gTheIconBar hide:)
			(if (== gHowFast 0)
				((ScriptID 755) show:) ; slowControls
			else
				((ScriptID 755 1) show:) ; fastControls
			)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 942
		loop 0
		cel 9
		message 6
		signal 2
		helpStr {This icon tells you about other icons.}
		maskView 942
		maskCel 11
	)
)

(instance deathIcon of DCIcon
	(properties)
)

(instance talkerIcon of DCIcon
	(properties
		state 16
	)
)

(instance kq5DoVerbCode of Code
	(properties)

	(method (doit)
		(gGame pragmaFail:)
	)
)

(instance FtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
	)
)

(instance kQPMouse of PseudoMouse
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 ((gTheIconBar curIcon:) message:))
		((gTheIconBar curIcon:) message: 0)
		(super handleEvent: event)
		((gTheIconBar curIcon:) message: temp0)
	)
)

(instance arrowCursor of KQCursor
	(properties
		number 999
	)

	(method (init)
		(if global400
			(self number: 999 yourself:)
		)
		(super init: &rest)
	)
)

(instance theGameCursor of KQCursor
	(properties
		number 456
	)

	(method (init)
		(if global400
			(self number: 456 yourself:)
		)
		(super init: &rest)
	)
)

(instance theInvCursor of KQCursor
	(properties
		number 69
	)

	(method (init)
		(if global400
			(self number: 69 yourself:)
		)
		(super init: &rest)
	)
)

(instance walkCursor of KQCursor
	(properties
		number 6
	)

	(method (init)
		(if global400
			(self number: 6 yourself:)
		)
		(super init: &rest)
	)
)

(instance eyeCursor of KQCursor
	(properties
		number 7
	)

	(method (init)
		(if global400
			(self number: 7 yourself:)
		)
		(super init: &rest)
	)
)

(instance handCursor of KQCursor
	(properties
		number 8
	)

	(method (init)
		(if global400
			(self number: 8 yourself:)
		)
		(super init: &rest)
	)
)

(instance talkCursor of KQCursor
	(properties
		number 9
	)

	(method (init)
		(if global400
			(self number: 9 yourself:)
		)
		(super init: &rest)
	)
)

(instance helpCursor of KQCursor
	(properties
		number 70
	)

	(method (init)
		(if global400
			(self number: 70 yourself:)
		)
		(super init: &rest)
	)
)

(instance speakCursor of KQCursor
	(properties
		number 456
	)

	(method (init)
		(if global400
			(self number: 456 yourself:)
		)
		(super init: &rest)
	)
)

(instance theCrownCursor of KQCursor
	(properties
		number 997
	)

	(method (init)
		(if global400
			(self number: 997 yourself:)
		)
		(super init: &rest)
	)
)

(instance halfLambCursor of KQCursor
	(properties
		number 52
	)

	(method (init)
		(if global400
			(self number: 52 yourself:)
		)
		(super init: &rest)
	)
)

(instance emptyBagCursor of KQCursor
	(properties
		number 54
	)

	(method (init)
		(if global400
			(self number: 54 yourself:)
		)
		(super init: &rest)
	)
)

