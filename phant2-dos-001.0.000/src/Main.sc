;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use eggAMatic)
(use invItems)
(use n63002)
(use AboutButton)
(use P2Timer)
(use P2SoundFX)
(use RoboGary)
(use WynIniFile)
(use Plane)
(use Str)
(use Rectangle)
(use Array)
(use Cel)
(use PolyEdit)
(use WriteFeature)
(use Feature)
(use PlaneManager)
(use Cursor)
(use TextField)
(use Button)
(use Jump)
(use File)
(use Game)
(use User)
(use Menu)
(use System)

(public
	p2 0
	p2Cursor 1
	topInterfacePlane 2
	botInterfacePlane 3
	cursorLoopTable 4
	IntensityPassWordWindow 5
	thunderTimer 6
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
	gCuees = 60
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
	gUseSortedFeatures = 255
	; 35
	global35 = 255
	gOverlays = 255
	gDoMotionCue
	gSystemPlane = 3
	gSaveFileSelText
	; 40
	global40
	global41 = 64978
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
	gMouseDownHandler = 255
	gDirectionHandler
	; 75
	gSpeechHandler = 1
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
	gTextSpeed = 5
	; 95
	gAltPolyList
	gScreenWidth = 640
	gScreenHeight = 480
	gLastScreenX = 639
	gLastScreenY = 479
	; 100
	global100 = 1234
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
	gP2SoundFX
	global202 = 62999
	global203
	global204
	; 205
	gChapter
	global206
	global207 = 1
	gVerb = -1
	global209
	; 210
	gP2SongPlyr
	global211
	global212 = 1
	global213
	gSceneList
	; 215
	global215 = 1
	global216
	gRoboGary = -1
	gPlayback
	global219
	; 220
	gWynNet
	global221
	global222
	global223
	global224
	; 225
	global225
	global226 = 3156
	global227
	global228 = -1
	global229
	; 230
	global230
	global231
	global232
	global233
	global234
	; 235
	global235 = 127
	global236 = 85
	global237
	global238
	global239
	; 240
	global240
	global241 = 100
	global242
	global243
	global244 = 1
	; 245
	global245 = 1
	global246
	global247
	global248
	global249
	; 250
	global250
	global251 = 1
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
	global400 = -1
)

(class P2Game of Game
	(properties)
)

(instance p2 of P2Game
	(properties)

	(method (init &tmp [temp0 5])
		(= gChapter 1)
		(= gVerb 4) ; Do
		(= gThePlane gamePlane)
		(= handsOffCode P2HandsOff)
		(= handsOnCode P2HandsOn)
		(= gSceneList sceneList)
		((= gUser p2User) init:)
		(super init: &rest)
		(gThePlane init: 0 70 640 406)
		(= global227 (if (== (Platform 2) 2) 1 else 20))
		(topInterfacePlane setPri: 100 init: 0 0 gScreenWidth 70 update:)
		(botInterfacePlane setPri: 100 init: 0 406 gScreenWidth gScreenHeight update:)
		(hidePlane init: 0 0 gScreenWidth gScreenHeight hide:)
		((gUser mousers:) add: topInterfacePlane)
		(topInterfaceView init: topInterfacePlane)
		(botInterfaceView init: botInterfacePlane)
		(intTopLButn init: topInterfacePlane)
		(intTopRButn init: topInterfacePlane)
		(intBotLButn init: botInterfacePlane)
		(intBotRButn init: botInterfacePlane)
		(= gP2SoundFX P2SoundFX)
		(= gP2SongPlyr P2SongPlyr)
		(= gRoboGary (RoboGary new:))
		(eggAMatic init:)
		(= gEgo P2Ego)
		(P2Ego initialize:)
		((ScriptID 63001 0) init:) ; invItems
		(InvPlane init: 121 408 510 475)
		(p2Cursor
			x: (/ (+ (gThePlane left:) (gThePlane right:)) 2)
			y: (/ (+ (gThePlane top:) (gThePlane bottom:)) 2)
			init:
			isActive: 1
		)
		((ScriptID 62998 0) doit:) ; p2InitCode
		(= global216 1)
		(self newRoom: 62999) ; p2IntroRm
	)

	(method (getDisc param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= gNumCD param1)
		(gTheCursor set: 4050 7 0)
		(while (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
			(gSounds eachElementDo: #stop eachElementDo: #number 0)
			(Palette 2 3 31 100) ; PalIntensity
			(askNice setPri: 30000 init: param1 update:)
			(FrameOut)
			(while ((= temp4 (Event new: $0007)) type:) ; evMOUSEKEYBOARD | evMOUSERELEASE
				(temp4 dispose:)
			)
			(temp4 dispose:)
			(= temp4 (Clone Event))
			(repeat
				(temp4 new:)
				(breakif
					(or
						(& (temp4 type:) $0001)
						(and (& (temp4 type:) $0004) (& (temp4 message:) $000d))
					)
				)
			)
			(temp4 dispose:)
			(= temp2 (+ (GetTime) 60))
			(while (< (GetTime) temp2)
			)
			(askNice dispose:)
		)
		(gTheCursor normalize:)
		(= global219 (ScriptID (+ 63025 (- gChapter 1))))
		(return temp0)
	)

	(method (bookMark &tmp temp0 temp1)
		(= temp0 global41)
		(= global41 63024)
		(self save:)
		(= global41 temp0)
		(if gQuit
			(= temp1 gQuit)
			(= gQuit 0)
			(self reallySave:)
			(= gQuit temp1)
		)
	)

	(method (newRoom)
		(intTopLButn disposeHelpText:)
		(intTopRButn disposeHelpText:)
		(intBotLButn disposeHelpText:)
		(intBotRButn disposeHelpText:)
		(super newRoom: &rest)
	)

	(method (gameLoop)
		(while (not gQuit)
			(super gameLoop:)
			(if (== gQuit 1)
				(verifyQuit new:)
				(= gQuit global228)
			)
			(= global228 -1)
			(if (not (OneOf gQuit 0 3))
				(self bookMark:)
			)
		)
	)
)

(instance verifyQuit of View
	(properties
		y 71
		view 4037
	)

	(method (new &tmp temp0 temp1)
		(= global228 -1)
		(= temp0 (super new:))
		(temp0 init:)
	)

	(method (init &tmp temp0)
		(Palette 2 0 31 100) ; PalIntensity
		(self needsEvents: 0)
		(= plane (Plane new: 0 0 639 479))
		(plane init: setPri: (+ 1 (GetHighPlanePri)) drawPic: -2)
		(if (OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
			(plane drawPic: -1)
		)
		(super init: plane)
		(self setPri: 1)
		(quitB new: plane)
		(canclB new: plane)
		((gUser hogs:) push: self 1)
		(gUser doit:)
		(plane dispose:)
	)

	(method (handleEvent event)
		(plane update:)
		(plane doit:)
		(FrameOut)
		(event localize: plane)
		(event claimed: 0)
		(plane handleEvent: event)
		(if (!= global228 -1)
			((gUser hogs:) pop:)
		)
		(event globalize:)
	)
)

(instance quitB of View
	(properties
		x 189
		y 301
		view 4037
		loop 1
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init)
		(super init: &rest)
		(self setRect:)
		(self setPri: 2)
		(self hide:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 param1)
			(= temp1 param2)
		else
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)

	(method (handleEvent event)
		(event claimed: 0)
		(if (& signal $0008)
			(if (& (event type:) evMOUSEBUTTON)
				(self show:)
				(self update:)
				(plane update:)
				(FrameOut)
				((gUser hogs:) push: self 1)
			)
		else
			(event localize: plane)
			(if (& (event type:) evMOUSERELEASE)
				((gUser hogs:) pop:)
				(if (self onMe: event)
					(= global228 1)
				)
				(self hide:)
			)
		)
		(event claimed:)
	)
)

(instance canclB of View
	(properties
		x 408
		y 300
		view 4037
		loop 2
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init)
		(super init: &rest)
		(self setRect:)
		(self setPri: 2)
		(self hide:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 param1)
			(= temp1 param2)
		else
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)

	(method (handleEvent event)
		(event claimed: 0)
		(if (& signal $0008)
			(if (& (event type:) evMOUSEBUTTON)
				(self show:)
				(self update:)
				(plane update:)
				(FrameOut)
				((gUser hogs:) push: self 1)
			)
		else
			(event localize: plane)
			(if (& (event type:) evMOUSERELEASE)
				((gUser hogs:) pop:)
				(if (self onMe: event)
					(= global228 0)
				)
				(self hide:)
			)
		)
		(event claimed:)
	)
)

(class P2HotCast of SortedCast
	(properties
		hotList 0
	)

	(method (init param1)
		(if (not hotList)
			(= hotList (Set new:))
		)
		(super init: param1 &rest)
	)

	(method (dispose)
		(hotList release: dispose:)
		(= hotList 0)
		(super dispose:)
	)

	(method (add param1 &tmp temp0 temp1)
		(if (not elements)
			(self init:)
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(= temp0 [param1 temp1])
			(if (and (temp0 respondsTo: #isHot) (temp0 isHot:))
				(hotList add: temp0)
			)
		)
		(super add: param1 &rest)
		(eventList sort: 109 1)
	)

	(method (addHot param1 param2)
		(if (not hotList)
			(self init:)
		)
		(if param2
			(hotList add: param1)
		else
			(hotList delete: param1)
		)
	)

	(method (delete param1 &tmp temp0 temp1)
		(if disposing
			(return -1)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(hotList delete: [param1 temp0])
		)
		(return (super delete: param1 &rest))
	)

	(method (hotObject param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 0)
		(= temp3 -1)
		(for
			((= temp4 (hotList first:)))
			temp4
			((= temp4 (hotList next: temp4)))
			
			(= temp0 (hotList value: temp4))
			(if (and (temp0 onMe: param1) (> (= temp1 (temp0 priority:)) temp3))
				(= temp2 temp0)
				(= temp3 temp1)
			)
		)
		(return temp2)
	)

	(method (release)
		(hotList release:)
		(super release: &rest)
	)
)

(class P2HotPlane of HotPlane
	(properties)

	(method (init)
		(= cast ((P2HotCast new:) init: self))
		(super init: &rest)
	)
)

(instance gamePlane of P2HotPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(& evMOUSEBUTTON (event type:))
				(& emSHIFT (event modifiers:))
				(!= gVerb 4) ; Do
			)
			(= gVerb 4) ; Do
			(if (== gCurRoomNum 42032)
				(gTheCursor set: 2590 0 0)
				(gCurRoom notify:)
			else
				(gTheCursor set: 999 (cursorLoopTable lookup: gVerb) 0)
			)
			(event claimed: 1)
		)
		(super handleEvent: event)
	)
)

(instance p2User of User
	(properties)

	(method (doit &tmp temp0)
		(= temp0 mousePlane)
		(super doit: &rest)
		(if (or (!= temp0 mousePlane) (!= gNewRoomNum gCurRoomNum))
			(if (p2Cursor hotObject:)
				((gUser primaDonnas:) delete: (p2Cursor hotObject:))
			)
			(p2Cursor forceUpdate: 1 hotObject: cursorKludge)
		)
	)
)

(instance cursorKludge of Feature
	(properties)
)

(instance p2Cursor of HotCursor
	(properties)

	(method (init)
		(super init: &rest)
		(cursorLoopTable init:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 hotObject)
		(super handleEvent: event &rest)
		(if (!= hotObject temp0)
			(if temp0
				((gUser primaDonnas:) delete: temp0)
			)
			(if hotObject
				((gUser primaDonnas:) add: hotObject)
			)
		)
	)

	(method (showHot param1)
		(if argc
			(cond
				(
					(and
						gCurRoom
						(or
							(gCurRoom isKindOf: WynCompBaseRoom)
							(OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
						)
						(or
							(OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
							(== (gUser mousePlane:) gThePlane)
							(and
								(gCurRoom respondsTo: #docoTextPlane)
								(gCurRoom docoTextPlane:)
								(==
									(gUser mousePlane:)
									(gCurRoom docoTextPlane:)
								)
							)
						)
						(not
							(OneOf
								param1
								(ScriptID 63000 0) ; nExit
								(ScriptID 63000 1) ; sExit
								(ScriptID 63000 2) ; eExit
								(ScriptID 63000 3) ; wExit
							)
						)
					)
					(if
						(or
							(== (gUser mousePlane:) gThePlane)
							(OneOf gCurRoomNum 62999 999) ; p2IntroRm, poorSadDeadCrazyAlienSucker
							(not ((gCurRoom docoTextPlane:) scratch:))
						)
						(self set: 999 1 0)
					else
						(self set: 999 (cursorLoopTable lookup: 4) 1)
					)
				)
				(param1
					(cond
						(global233)
						((== view 2590)
							(self set: 2590 loop 1)
						)
						(
							(and
								(param1 respondsTo: #seesVerb)
								(param1 respondsTo: #exitDir)
							)
							(cond
								((!= (param1 exitDir:) -1)
									(self set: 999 0 (param1 exitDir:))
								)
								((param1 seesVerb: gVerb)
									(self
										set:
											999
											(cursorLoopTable lookup: gVerb)
											1
									)
								)
								(else
									(self
										set:
											999
											(cursorLoopTable lookup: gVerb)
											0
									)
								)
							)
						)
						((param1 isMemberOf: InterButton))
						(else
							(self
								set: 999 (cursorLoopTable lookup: gVerb) 0
							)
						)
					)
				)
				((== view 2590)
					(self set: 2590 loop 0)
				)
				(else
					(self set: 999 (cursorLoopTable lookup: gVerb) 0)
				)
			)
		else
			(self forceUpdate: 1)
		)
	)

	(method (normalize)
		(= type 0)
		(&= state $fff7)
		(self forceUpdate: 1)
	)
)

(instance P2HandsOff of Code
	(properties)

	(method (doit)
		(gUser canInput: 0)
		(p2Cursor showHandsOff:)
	)
)

(instance P2HandsOn of Code
	(properties)

	(method (doit)
		(p2Cursor normalize:)
		(gUser canInput: 1)
	)
)

(instance topInterfacePlane of Plane
	(properties
		priority 100
	)

	(method (hide)
		(hidePlane show:)
	)

	(method (show)
		(hidePlane hide:)
	)

	(method (handleEvent event param2)
		(cond
			(
				(or
					(== gCurRoomNum 900) ; mapRoom
					global238
					(and gCurRoom (gCurRoom isKindOf: WynCompBaseRoom))
				)
				(event claimed: 0)
				(return)
			)
			((== argc 1)
				(super handleEvent: event)
				(return)
			)
			((== param2 self)
				(if (< scratch 100)
					(for
						((= scratch 0))
						(< scratch 100)
						((+= scratch global227))
						
						(Palette 2 3 31 scratch) ; PalIntensity
						(FrameOut)
					)
				)
				(= scratch 100)
				(Palette 2 3 31 scratch) ; PalIntensity
				(FrameOut)
				(cast eachElementDo: #update event)
			)
			((or (== param2 botInterfacePlane) (== param2 InvPlane))
				(if (< scratch 100)
					(for
						((= scratch 0))
						(< scratch 100)
						((+= scratch global227))
						
						(Palette 2 3 31 scratch) ; PalIntensity
						(FrameOut)
					)
				)
				(= scratch 100)
				(Palette 2 3 31 scratch) ; PalIntensity
				(FrameOut)
				((botInterfacePlane cast:) eachElementDo: #update event)
			)
			(scratch
				(for ((= scratch 100)) (> scratch 0) ((-= scratch global227))
					(Palette 2 3 31 scratch) ; PalIntensity
					(FrameOut)
				)
				(= scratch 0)
				(Palette 2 3 31 scratch) ; PalIntensity
				(FrameOut)
			)
		)
	)
)

(instance botInterfacePlane of Plane
	(properties
		priority 100
	)

	(method (handleEvent)
		(if (not (gCurRoom isKindOf: WynCompBaseRoom))
			(super handleEvent: &rest)
		)
	)
)

(instance topInterfaceView of View
	(properties
		x 90
		view 1
		loop 8
	)
)

(instance botInterfaceView of View
	(properties
		x 90
		view 1
		loop 9
	)
)

(class InterButton of Button
	(properties
		view 1
		helpText 0
		animDelay 0
		approachLoop 0
	)

	(method (init)
		(= loop approachLoop)
		(super init: &rest)
		(|= signal $1000)
	)

	(method (doit)
		(cond
			((and (== cel 6) (== (topInterfacePlane scratch:) 100))
				(super doit: &rest)
			)
			(helpText
				(self doHelp: 0)
			)
		)
	)

	(method (press param1)
		(if param1
			(= animDelay 40)
			(= loop (+ approachLoop 1))
			(= cel 0)
		else
			(= loop approachLoop)
			(= cel 4)
		)
		(UpdateScreenItem self)
		(super press: param1 &rest)
	)

	(method (update param1 &tmp temp0 temp1 temp2)
		(if (== gCurRoomNum 900) ; mapRoom
			(return 0)
		)
		(= temp2 loop)
		(= temp1 cel)
		(if (not (not (& state $0001)))
			(cond
				((not (not (not (& state $0020))))
					(if argc
						(param1 localize: plane)
						(if (self onMe: param1)
							(= cel 6)
						else
							(= temp0 (GetDistance x y (param1 x:) (param1 y:)))
							(= loop approachLoop)
							(= cel
								(cond
									((> temp0 60) 0)
									((> temp0 55) 1)
									((> temp0 50) 2)
									((> temp0 40) 3)
									((> temp0 30) 4)
									((> temp0 20) 5)
									(else 6)
								)
							)
						)
					)
				)
				((and (== cel 1) (!= loop approachLoop))
					(= loop approachLoop)
					(= cel 4)
				)
				((not (-- animDelay))
					(= animDelay 60)
					(++ cel)
				)
			)
		else
			(= loop approachLoop)
			(= cel 0)
		)
		(return
			(and (or (!= temp1 cel) (!= temp2 loop)) (UpdateScreenItem self))
		)
	)

	(method (hilite param1 param2 &tmp [temp0 2])
		(if (and argc (^ param1 (not (not (& state $0002)))))
			(if param1
				(|= state $0002)
				(= selectTime gGameTime)
			else
				(&= state $fffd)
				(self doHelp: 0)
			)
			(self update: param2)
		)
		(return (not (not (& state $0002))))
	)

	(method (track param1 &tmp temp0 [temp1 2])
		(if (or (gUser mouseMoved:) (not (not (& state $0020))))
			(= temp0 (self onMe: param1))
			(self hilite: temp0 param1)
		)
	)

	(method (disposeHelpText)
		(if helpText
			(self doHelp: 0)
		)
	)
)

(instance intTopLButn of InterButton
	(properties
		x 31
		y 31
		approachLoop 4
	)

	(method (action)
		(gPlayback init: gChapter)
	)

	(method (doHelp param1)
		(cond
			((or (not argc) param1)
				(if (not helpText)
					(= helpText (TextView new:))
					(helpText
						setText: 0 1 0 14 1
						setSize:
						setPri: 500
						posn: 5 4
						init:
					)
				)
			)
			(helpText
				(helpText dispose:)
				(= helpText 0)
			)
		)
	)
)

(instance intTopRButn of InterButton
	(properties
		x 594
		y 31
		approachLoop 6
	)

	(method (action)
		(gGame panelSend: ControlPanel 5)
	)

	(method (doHelp param1)
		(cond
			((or (not argc) param1)
				(if (not helpText)
					(= helpText (TextView new:))
					(helpText
						setText: 0 1 0 15 1
						setSize:
						setPri: 500
						posn: 545 4
						init:
					)
				)
			)
			(helpText
				(helpText dispose:)
				(= helpText 0)
			)
		)
	)
)

(instance intBotLButn of InterButton
	(properties
		x 31
		y 38
	)

	(method (action)
		(if (IsFlag 1001)
			(SetFlag 1002)
			(gCurRoom newRoom: 900) ; mapRoom
		)
	)

	(method (update)
		(if (IsFlag 1001)
			(= approachLoop 0)
		else
			(= approachLoop 12)
		)
		(super update: &rest)
	)

	(method (doHelp param1)
		(cond
			((or (not argc) param1)
				(if (not helpText)
					(= helpText (TextView new:))
					(helpText
						setText: 0 1 0 18 1
						setSize:
						setPri: 500
						posn: 5 324
						init:
					)
				)
			)
			(helpText
				(helpText dispose:)
				(= helpText 0)
			)
		)
	)
)

(instance intBotRButn of InterButton
	(properties
		x 594
		y 38
		approachLoop 2
	)

	(method (action)
		((ScriptID 63001 1) new:) ; invCUPlane
	)

	(method (doHelp param1)
		(cond
			((or (not argc) param1)
				(if (not helpText)
					(= helpText (TextView new:))
					(helpText
						setText: 0 1 0 16 1
						setSize:
						setPri: 500
						posn: 530 324
						init:
					)
				)
			)
			(helpText
				(helpText dispose:)
				(= helpText 0)
			)
		)
	)
)

(class P2Ego of Prop
	(properties
		invSet 0
	)

	(method (initialize)
		(if (not invSet)
			(= invSet (Set new:))
			(invSet init:)
		)
		(return self)
	)

	(method (get param1 param2)
		(self initialize:)
		(invSet addToFront: ((ScriptID 63001 0) at: param1)) ; invItems
		(if (or (< argc 2) param2)
			(InvPlane recalc:)
		)
	)

	(method (has param1)
		(invSet contains: ((ScriptID 63001 0) at: param1)) ; invItems
	)

	(method (put param1)
		(invSet delete: ((ScriptID 63001 0) at: param1)) ; invItems
		(InvPlane recalc:)
	)
)

(class sceneItem of Obj
	(properties
		scene 0
	)
)

(instance sceneList of List
	(properties)

	(method (add param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 (sceneItem new:))
			(temp1 scene: [param1 temp0])
			(super add: temp1)
		)
	)

	(method (addToFront param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 (sceneItem new:))
			(temp1 scene: [param1 temp0])
			(super addToFront: temp1)
		)
	)
)

(instance hidePlane of Plane
	(properties)

	(method (init)
		(self setPri: 10000)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(class HelpPrint of Plane
	(properties)

	(method (new param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (Clone self))
		(= temp1 (param1 celWidth:))
		(= temp2 (param1 celHeight:))
		(= temp4 (+ (= temp3 (>> (- gScreenWidth temp1) $0001)) temp1 -1))
		(= temp6 (+ (= temp5 (>> (- gScreenHeight temp2) $0001)) temp2 -1))
		(temp0 priority: (+ 1 (GetHighPlanePri)) init: temp3 temp5 temp4 temp6)
		(param1 init: temp0)
		((gUser hogs:) push: temp0 1)
		(return temp0)
	)

	(method (handleEvent event)
		(if (& (event type:) $000a) ; evKEYUP | evMOUSERELEASE
			((gUser hogs:) pop:)
			(event claimed: 1)
			(self dispose:)
		)
		(return 0)
	)
)

(class cursorLoopTable of Obj
	(properties
		verbNums 0
		loopNums 0
	)

	(method (init)
		(if (not verbNums)
			(= verbNums (IntArray new: 0))
		)
		(if (not loopNums)
			(= loopNums (IntArray new: 0))
		)
		(super init: &rest)
		(self
			add:
				1
				3
				3
				5
				4
				6
				5
				7
				6
				8
				7
				9
				9
				11
				10
				12
				11
				13
				12
				14
				13
				15
				14
				16
				15
				17
				16
				18
				21
				23
				23
				25
				24
				26
				25
				27
				27
				29
				28
				30
				30
				32
				31
				33
				32
				34
				33
				35
				34
				36
				35
				37
				36
				38
				40
				19
				144
				20
				150
				21
				43
				22
				41
				39
				145
				40
				151
				41
				146
				42
				39
				43
		)
	)

	(method (lookup param1 &tmp temp0)
		(return
			(if (!= -1 (= temp0 (verbNums indexOf: param1)))
				(loopNums at: temp0)
			else
				6
			)
		)
	)

	(method (add param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 2))
			(verbNums at: (verbNums size:) [param1 temp0])
			(loopNums at: (loopNums size:) [param2 temp0])
		)
	)
)

(instance askNice of Plane
	(properties)

	(method (init param1)
		(super init: 0 0 640 479)
		(askNiceBack init: self)
		(askNiceCel loop: param1 init: self)
		(contButn init: self)
		(self update:)
		(FrameOut)
	)
)

(instance askNiceBack of Cel
	(properties
		x 162
		y 146
		view 4050
	)
)

(instance askNiceCel of Cel
	(properties
		x 244
		y 168
		view 4050
	)
)

(instance contButn of Button
	(properties
		x 284
		y 236
		view 4050
		loop 6
	)
)

(class IntensityPassWordWindow of View
	(properties
		x 146
		y 74
		view 4038
		okB 0
		cncB 0
		pwStars 0
		pw 0
		curPw 0
		pwCursor 0
		lIntB 0
		startingNewGame 0
	)

	(method (new param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (Str newWith: 16 {}))
		(RESDUK_PAT readString: temp3 16)
		(RESDUK_PAT close:)
		(temp3 strip: 1)
		(if (not (temp3 size:))
			(temp3 dispose:)
			(return 1)
		)
		(temp3 upper:)
		(Palette 2 3 31 100) ; PalIntensity
		(= temp1 0)
		(while (not temp1)
			(= temp0 (super new:))
			(if argc
				(temp0 startingNewGame: param1)
			)
			((= temp2 (Plane new:))
				init:
					(gThePlane left:)
					(gThePlane top:)
					(gThePlane right:)
					(gThePlane bottom:)
				setPri: (+ (GetHighPlanePri) 1) 1
				drawPic: -2
			)
			(temp0 pw: temp3 init: temp2)
			(= temp1
				(cond
					((not ((temp0 curPw:) weigh: {~cancel~})) -1)
					(
						(or
							(not ((temp0 curPw:) weigh: (temp0 pw:)))
							(and (temp0 startingNewGame:) (== global207 1))
						)
						1
					)
					(else 0)
				)
			)
			(temp0 dispose:)
			(temp2 dispose:)
			(if (not temp1)
				(IPWErr new:)
			)
		)
		(temp3 dispose:)
		(return temp1)
	)

	(method (init param1)
		(self setPri: 1000)
		(super init: param1)
		((= okB (View new:))
			view: 4038
			loop: 1
			init: param1
			setPri: 1001
			posn: 167 208
			update:
		)
		((= cncB (View new:))
			view: 4038
			loop: 3
			init: param1
			setPri: 1001
			posn: 383 208
			update:
		)
		(self addTarget: okB addTarget: cncB)
		(if startingNewGame
			((= lIntB (View new:))
				view: 4038
				loop: 2
				init: param1
				setPri: 1001
				posn: 272 208
				update:
			)
			(self addTarget: lIntB)
		)
		(= curPw (Str format: {}))
		(= pwStars (Stack new:))
		(= pwCursor (IPWWCursor new: self))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(and
				(& (event type:) evKEYBOARD)
				(or
					(OneOf (= temp1 (event message:)) JOY_UPLEFT KEY_SPACE)
					(<= KEY_a temp1 KEY_z)
					(<= KEY_A temp1 KEY_Z)
					(<= KEY_0 temp1 KEY_9)
				)
				(or (== temp1 JOY_UPLEFT) (<= (curPw size:) 16))
			)
			(cond
				((== (event message:) JOY_UPLEFT)
					(if (curPw size:)
						(= temp2 (curPw getLeft: (- (curPw size:) 1)))
						(curPw dispose:)
						(= curPw temp2)
						(if (= temp0 (pwStars peek:))
							(pwStars pop:)
							(temp0 dispose:)
						)
					)
				)
				((<= (curPw size:) 15)
					(if (<= KEY_a temp1 KEY_z)
						(-= temp1 32)
					)
					(= temp2 (Str format: {%c} temp1))
					(curPw cat: temp2)
					(temp2 dispose:)
					((= temp0 (View new:))
						view: 4038
						loop: 5
						cel: 0
						init: plane
						setPri: 1001
						posn: (+ 257 (* 9 ((pwStars data:) size:))) 172 1
					)
					(pwStars push: temp0)
				)
			)
		else
			(event localize: plane)
			(cond
				((& (event type:) evMOUSERELEASE)
					(cond
						((okB cel:)
							(okB setCel: 0 update:)
							(if (okB onMe: event)
								((gUser hogs:) pop:)
							)
						)
						((cncB cel:)
							(cncB setCel: 0 update:)
							(if (cncB onMe: event)
								(curPw dispose:)
								(= curPw (Str format: {~cancel~}))
								((gUser hogs:) pop:)
							)
						)
						((and lIntB (lIntB cel:))
							(lIntB setCel: 0 update:)
							(if (lIntB onMe: event)
								(= global207 1)
								((gUser hogs:) pop:)
							)
						)
					)
				)
				((& (event type:) evMOUSEBUTTON)
					(cond
						((okB onMe: event)
							(okB setCel: 1 update:)
						)
						((cncB onMe: event)
							(cncB setCel: 1 update:)
						)
						((and lIntB (lIntB onMe: event))
							(lIntB setCel: 1 update:)
						)
					)
				)
				(
					(and
						(& (event type:) evKEYBOARD)
						(OneOf (= temp1 (event message:)) KEY_RETURN KEY_ESCAPE)
					)
					((gUser hogs:) pop:)
					(if (== temp1 KEY_ESCAPE)
						(curPw dispose:)
						(= curPw (Str format: {~cancel~}))
					)
				)
			)
			(pwStars doit:)
			(pwCursor doit:)
			(FrameOut)
			((event globalize:) claimed: self)
			(return)
		)
	)

	(method (dispose)
		((pwStars data:) release:)
		(pwStars dispose:)
		(curPw dispose:)
		(target dispose:)
		(super dispose: &rest)
	)
)

(class IPWWCursor of View
	(properties
		view 4038
		loop 4
		myWindow 0
		blinkTime 10
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1)
		(= myWindow param1)
		(self posn: 257 165)
		(super init: (param1 plane:))
		(self setPri: 1001)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime))
		(while (== (GetTime) temp0)
		)
		(if (not (-- blinkTime))
			(= blinkTime 10)
			(if cel
				(= cel 0)
			else
				(= cel 1)
			)
		)
		(if (myWindow pwStars:)
			(self posn: (+ 257 (* 9 (((myWindow pwStars:) data:) size:))) 165 1)
		)
		(self update:)
		(super doit:)
	)
)

(class IPWErr of View
	(properties
		x 170
		y 107
		view 4038
		loop 6
		okbV 0
	)

	(method (new &tmp temp0 temp1)
		(= temp0 (super new:))
		((= temp1 (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(temp0 init: temp1)
		(temp1 dispose:)
	)

	(method (init)
		(super init: &rest)
		(self addTarget: (Rectangle new: 276 171 362 200))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event)
		(event globalize: localize: plane)
		(cond
			((and (target onMe: event) (& (event type:) evMOUSEBUTTON) (not okbV))
				((= okbV (View new:))
					view: 4038
					loop: 1
					cel: 1
					init: plane
					posn: 276 171
					setPri: 1001
					update:
				)
			)
			(
				(or
					(and okbV (& (event type:) evMOUSERELEASE))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(if okbV
					(okbV dispose:)
				)
				((gUser hogs:) pop:)
				(event claimed: self)
				(self dispose:)
			)
		)
		(FrameOut)
		(event claimed:)
	)

	(method (dispose)
		(if target
			(target dispose:)
			(= target 0)
		)
		(super dispose: &rest)
	)
)

(instance thunderTimer of P2Timer
	(properties)

	(method (cue)
		(gP2SoundFX play: (Random 6000 6001))
	)

	(method (dispose)
		(if argc
			(gCast delete: self)
			(= plane (= cuee (= cuer (= register 0))))
		else
			(self restart: 3 (Random 3 7))
		)
	)
)

(instance RESDUK_PAT of File
	(properties
		name {RESDUK.PAT}
	)
)

