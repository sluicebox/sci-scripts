;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use dummyClient)
(use Interface)
(use n804)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use LoadMany)
(use DCIcon)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	Brain 0
	proc0_1 1
	proc0_2 2
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
	gCMusic
	global101 = 2
	global102
	gCMusic2
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
	global116 = -1
	global117 = -1
	global118 = -1
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
	gIcon2
	global164
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	global170 = -1
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
)

(procedure (proc0_1 param1 param2)
	(return (if (IsFlag 0) param1 else param2))
)

(procedure (proc0_2))

(instance cMusic of Sound
	(properties
		number 1
	)
)

(instance cMusic2 of Sound
	(properties
		number 1
	)
)

(instance statLn of Code
	(properties)

	(method (doit param1)
		(Format ; "Castle of Dr. Brain    %s Level"
			param1
			0
			0
			(switch global114
				(0 {Novice})
				(1 {Standard})
				(2 {Expert})
			)
		)
	)
)

(instance brainKeyDownHandler of EventHandler
	(properties)
)

(instance brainDirectionHandler of EventHandler
	(properties)
)

(instance brainMouseDownHandler of EventHandler
	(properties)
)

(instance Brain of Game
	(properties)

	(method (init &tmp temp0)
		(= gSystemWindow BorderWindow)
		(= gUseSortedFeatures 0)
		(= gDoVerbCode BrainVerbCode)
		(proc804_0)
		(= gFtrInitializer brainFtrInit)
		(= gPMouse PseudoMouse)
		(SL code: statLn)
		(super init:)
		(StrCpy @gSysLogPath {})
		((= gKeyDownHandler brainKeyDownHandler) add:)
		((= gMouseDownHandler brainMouseDownHandler) add:)
		((= gDirectionHandler brainDirectionHandler) add:)
		((= gTheIconBar IconBar)
			curIcon: icon1
			useIconItem: icon4
			disable: icon4
			state: (| (IconBar state:) $0800)
			init:
		)
		(= gEgo Ego)
		(User
			alterEgo: gEgo
			verbMessager: 0
			canControl: 0
			canInput: 0
			x: -1
			y: 150
		)
		(self setCursor: gTheCursor 1 304 172)
		(= gPossibleScore 200)
		(= gUserFont 4)
		(= gEatMice 10)
		(= gVersion {x.yyy    })
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 9 temp0)
		(FileIO fiCLOSE temp0)
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 0)
		else
			(SetFlag 0)
		)
		(if (not (IsFlag 0))
			(BorderWindow
				back: 7
				topBordColor: 15
				lftBordColor: 15
				rgtBordColor: 8
				botBordColor: 8
			)
			(InsetWindow
				back: 7
				topBordColor: 15
				lftBordColor: 15
				rgtBordColor: 8
				botBordColor: 8
				insideColor: 8
				topBordColor2: 0
				lftBordColor2: 0
				botBordColor2: 15
				rgtBordColor2: 15
				botBordHgt: 26
			)
		)
		(cMusic owner: self init:)
		(cMusic2 owner: self init:)
		(= gCMusic cMusic)
		(= gCMusic2 cMusic2)
		(gTheIconBar
			add: icon1 icon2 icon4 icon5 icon6 icon8 icon9 icon10
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (proc0_1 21 9)
			helpIconItem: icon9
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(= gIcon2 icon2)
		(Inv
			normalHeading: {You are carrying}
			add:
				coin
				solarClue
				certificate
				token
				clockKey
				timeCard1
				timeCard2
				timeCard3
				dataCard
				blueBook
				truthHead
				liarHead
				confusedHead
				dartHand
				magnetHand
				forkLiftHand
				letterCounter
				rubyKey
				bookClue
				decoderRing
				tangrams
				robotRmPlaque
				clockRmPlaque
				puzzleRmPlaque
				starRmPlaque
				jigsawRmPlaque
				wrdPzlRmPlaque
				firstRmPlaque
				codeRmPlaque
				circuitRmPlaque
				invLook
				invSelect
				invHelp
				ok
			eachElementDo: #init
			window: InsetWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(= gGameControls controlBox)
		(gGameControls
			window: gcWin
			add:
				iconOk
				(difficultySlider
					theObj: self
					selector: #detailLevel
					topValue: 14
					bottomValue: 0
					yStep: 5
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: aboutCode selector: #doit yourself:)
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (proc0_1 19 3)
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(= global107 (if (GameIsRestarting) 100 else 500))
		(self newRoom: 802) ; speedChecker
	)

	(method (detailLevel param1)
		(if argc
			(= global114 (/ param1 5))
			(SL doit:)
		)
		(return (* global114 7))
	)

	(method (quitGame)
		(super
			quitGame:
				(proc5_9
					0
					1
					81
					{Quit for now}
					1
					81
					{Keep solving}
					0
					82
					brainSaysBye
				)
		)
	)

	(method (save)
		(super save: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (startRoom param1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self setCursor: gWaitCursor 1)
		(LoadMany 0 10 15 377 973 939 425 428 427 426 325 850)
		(DisposeScript 800)
		(if
			(and
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(proc5_9 0 2 81 {Who cares} 0 81 {Debug} 1)
			)
			(SetDebug)
		)
		(if gDebugOn
			(SetDebug)
		)
		(if (OneOf gCurRoomNum 500 802) ; speedChecker
			(SL disable:)
			(gTheIconBar disable:)
		else
			(SL enable:)
			(gTheIconBar enable:)
		)
		(ScriptID 982)
		(super startRoom: param1)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (handleEvent event &tmp temp0 [temp1 20])
		(= temp0 (event type:))
		(cond
			((or (not (User controls:)) (event claimed:))
				(event claimed: 1)
			)
			((== temp0 evKEYBOARD)
				(switch (event message:)
					(KEY_TAB
						(Inv showSelf: gEgo)
					)
					(KEY_SHIFTTAB
						(if (HaveMouse)
							(Inv showSelf: gEgo)
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global106 1)
								(gGame masterVolume: 15)
							)
							(else
								(gGame masterVolume: 1)
							)
						)
						(event claimed: 1)
					)
					(KEY_F5
						(if
							(and
								(not (& ((gTheIconBar at: 5) signal:) $0004))
								(not gFastCast)
							)
							(gGame save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if
							(and
								(not (& ((gTheIconBar at: 5) signal:) $0004))
								(not gFastCast)
							)
							(gGame restore: &rest)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (User controls:)
							(gGame
								setSpeed:
									(Max 0 (- (gGame egoMoveSpeed:) 1))
							)
						)
					)
					(KEY_SUBTRACT
						(if (User controls:)
							(gGame setSpeed: (+ (gGame egoMoveSpeed:) 1))
						)
					)
					($003d ; =
						(if (User controls:)
							(gGame setSpeed: 6)
						)
					)
					(KEY_ALT_n
						(Format @temp1 0 3 800) ; "%d.scr"
						(if (FileIO fiEXISTS @temp1)
							(if (proc5_3 1536)
								((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
							else
								(Print 0 4) ; "Not Enough Memory!!"
							)
						)
					)
					(else
						(Format @temp1 0 3 800) ; "%d.scr"
						(if (FileIO fiEXISTS @temp1)
							(event claimed: 0)
							((ScriptID 800) handleEvent: event) ; debugHandler
						)
					)
				)
			)
		)
	)
)

(instance brainSaysBye of DCIcon
	(properties
		view 902
		cycleSpeed 10
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		cursor 80
		signal 67
		helpStr {Choose this icon to close the inventory window.}
	)

	(method (init)
		(= lowlightColor (proc0_1 21 9))
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 19
		message 2
		helpStr {Choose this icon, then select an inventory item, to see a description of the item.}
	)

	(method (init)
		(= lowlightColor (proc0_1 21 9))
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 29
		message 6
		helpStr {Choose this icon to find out what the other icons do.}
	)

	(method (init)
		(= lowlightColor (proc0_1 21 9))
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 8
		helpStr {Choose this icon to pick up an item so you can use it.}
	)

	(method (init)
		(= lowlightColor (proc0_1 21 9))
		(super init:)
	)
)

(class BrainInv of InvI
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(proc5_9 20 description)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(= lowlightColor (proc0_1 2 8))
		(super init:)
	)
)

(instance coin of BrainInv
	(properties
		view 700
		cursor 1
		signal 2
		helpStr {You can spend these coins to get hints to the puzzles, or save them to get a higher score.}
		owner 380
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(if global115
				(proc5_14
					20
					description
					global115
					(if (== global115 1) { } else {s })
				)
			else
				(proc5_9 0 5)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance solarClue of BrainInv
	(properties
		view 700
		cel 1
		cursor 112
		signal 2
		description 1
		owner 380
	)
)

(instance certificate of BrainInv
	(properties
		view 700
		cel 2
		cursor 112
		signal 2
		description 2
		owner 440
	)
)

(instance token of BrainInv
	(properties
		view 700
		cel 3
		cursor 1
		signal 2
		description 3
		owner 380
	)
)

(instance clockKey of BrainInv
	(properties
		view 700
		cel 4
		cursor 69
		signal 2
		description 4
		owner 120
	)
)

(instance timeCard1 of BrainInv
	(properties
		view 700
		cel 5
		cursor 111
		signal 2
		description 5
		owner 180
	)
)

(instance timeCard2 of BrainInv
	(properties
		view 700
		cel 6
		cursor 111
		signal 2
		description 6
		owner 180
	)
)

(instance timeCard3 of BrainInv
	(properties
		view 700
		cel 7
		cursor 111
		signal 2
		description 5
		owner 180
	)
)

(instance dataCard of BrainInv
	(properties
		view 700
		cel 10
		cursor 28
		signal 2
		description 6
		owner 240
	)
)

(instance tangrams of BrainInv
	(properties
		view 700
		loop 2
		cel 10
		cursor 113
		signal 2
		description 7
		owner 320
	)
)

(instance truthHead of BrainInv
	(properties
		view 701
		cel 1
		cursor 25
		signal 2
		description 8
		owner 280
	)
)

(instance liarHead of BrainInv
	(properties
		view 701
		cel 2
		cursor 25
		signal 2
		description 9
		owner 280
	)
)

(instance confusedHead of BrainInv
	(properties
		view 701
		cursor 25
		signal 2
		description 10
		owner 280
	)
)

(instance dartHand of BrainInv
	(properties
		view 701
		cel 5
		cursor 26
		signal 2
		description 11
		owner 280
	)
)

(instance magnetHand of BrainInv
	(properties
		view 701
		cel 3
		cursor 26
		signal 2
		description 12
		owner 280
	)
)

(instance forkLiftHand of BrainInv
	(properties
		view 701
		cel 4
		cursor 26
		signal 2
		description 13
		owner 280
	)
)

(instance letterCounter of BrainInv
	(properties
		view 700
		cel 8
		cursor 68
		signal 2
		description 14
		owner 380
	)
)

(instance rubyKey of BrainInv
	(properties
		view 700
		cel 9
		cursor 69
		signal 2
		description 15
		owner 380
	)
)

(instance blueBook of BrainInv
	(properties
		view 701
		loop 2
		cel 2
		cursor 112
		signal 2
		description 16
		owner 280
	)
)

(instance bookClue of BrainInv
	(properties
		view 701
		loop 2
		cel 1
		cursor 112
		signal 2
		description 17
		owner 280
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(= description (+ 17 global114))
				(if (IsFlag 51)
					(+= description 3)
				)
				(super doVerb: theVerb invItem &rest)
			)
			((or (!= theVerb 4) (!= invItem 19))
				(super doVerb: theVerb invItem &rest)
			)
			((IsFlag 51)
				(proc5_9 0 6)
			)
			(else
				(SetFlag 51)
				(++ description)
				(proc5_9 0 7)
				(self doVerb: 2)
			)
		)
	)
)

(instance decoderRing of BrainInv
	(properties
		view 700
		cel 11
		cursor 35
		signal 2
		description 23
		owner 440
	)
)

(instance robotRmPlaque of BrainInv
	(properties
		view 701
		loop 2
		cursor 42
		signal 2
		description 24
		owner 280
	)
)

(instance clockRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 9
		cursor 40
		signal 2
		description 25
		owner 180
	)
)

(instance puzzleRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 2
		cursor 41
		signal 2
		description 26
		owner 320
	)
)

(instance starRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 3
		cursor 43
		signal 2
		description 27
		owner 420
	)
)

(instance jigsawRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 4
		cursor 44
		signal 2
		description 28
		owner 360
	)
)

(instance wrdPzlRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 5
		cursor 45
		signal 2
		description 29
		owner 320
	)
)

(instance firstRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 6
		cursor 46
		signal 2
		description 30
		owner 280
	)
)

(instance codeRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 7
		cursor 47
		signal 2
		description 31
		owner 380
	)
)

(instance circuitRmPlaque of BrainInv
	(properties
		view 700
		loop 2
		cel 8
		cursor 48
		signal 2
		description 32
		owner 280
	)
)

(instance icon1 of IconI
	(properties
		view 900
		loop 0
		cel 0
		cursor 19
		message 2
		signal 65
		helpStr {Choose the eye icon to look at things on the screen.}
		maskView 900
		maskLoop 8
		maskCel 2
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 1
		cel 0
		cursor 8
		message 3
		signal 65
		helpStr {Choose the hand icon to touch or manipulate objects on the screen.}
		maskView 900
		maskLoop 8
		maskCel 1
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 2
		cel 0
		state 4
		cursor 999
		message 4
		signal 65
		helpStr {Choose this icon to use the inventory item you are currently carrying.}
		maskView 900
		maskLoop 8
		maskCel 3
	)
)

(instance icon5 of IconI
	(properties
		view 900
		loop 3
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		helpStr {Choose the book bag to look at or use things you have picked up.}
		maskView 900
		maskLoop 8
		maskCel 3
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(Inv showSelf: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 80
		type 0
		message 0
		signal 67
		helpStr {Choose the "go back" icon to go back to the next room off the bottom of the screen.}
		maskView 900
		maskLoop 8
		maskCel 2
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(if (= temp0 (gCurRoom south:))
				(gCurRoom newRoom: temp0)
			else
				(proc5_9 0 8)
			)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 900
		loop 5
		cel 0
		cursor 80
		signal 67
		helpStr {Choose this icon to change game options, to save or restore the game, or to quit.}
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gGameControls show:)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 900
		loop 6
		cel 0
		cursor 29
		message 6
		signal 3
		helpStr {Choose the "?" icon to get help about other icons.}
		maskView 900
		maskLoop 8
	)
)

(instance icon10 of IconI
	(properties
		view 900
		loop 7
		cel 0
		cursor 80
		signal 3
		helpStr {Choose this icon to find out about the current room.}
		maskView 900
		maskLoop 8
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gCurRoom doVerb: 2)
		)
	)
)

(instance brainFtrInit of Code
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

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 15] [temp29 4])
		(self
			top: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			left: (/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
			bottom:
				(+ (CelHigh 947 1 1) 6 (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2))
			right:
				(+
					144
					(CelWide 947 0 1)
					(/ (- 320 (+ 144 (CelWide 947 0 1))) 2)
				)
			back: (proc0_1 21 11)
			topBordColor: (proc0_1 23 15)
			lftBordColor: (proc0_1 23 15)
			rgtBordColor: (proc0_1 18 8)
			botBordColor: (proc0_1 17 8)
			priority: 15
		)
		(super open:)
		(DrawCel
			947
			0
			5
			(+
				(/
					(-
						(- (+ 144 (CelWide 947 0 1)) (+ 4 (CelWide 947 1 1)))
						(CelWide 947 0 5)
					)
					2
				)
				4
				(CelWide 947 1 1)
			)
			6
			15
		)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 116 38 15)
		(DrawCel 947 0 4 65 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 3 128 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 947 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 144 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 (proc0_1 17 7))
		(= temp11 (proc0_1 18 7))
		(= temp10 (proc0_1 22 8))
		(= temp9 (proc0_1 23 8))
		(= temp1 3)
		(= temp7 3)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grFILL_BOX temp2 temp3 (+ temp2 temp1) temp4 temp7 temp8 temp12)
		(Graph grFILL_BOX (- temp5 temp1) temp3 temp5 temp4 temp7 temp9 temp12)
		(for ((= temp13 0)) (< temp13 temp1) ((++ temp13))
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(+ temp3 temp13)
				(- temp5 (+ temp13 1))
				(+ temp3 temp13)
				temp11
				temp12
				-1
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(- temp4 (+ temp13 1))
				(- temp5 (+ temp13 1))
				(- temp4 (+ temp13 1))
				temp10
				temp12
				-1
			)
		)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(proc5_18)
		(Format @temp14 0 9 gScore gPossibleScore) ; "Your Score: %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			(proc0_1 21 global130)
			dsCOORD
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(- (+ 144 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 947 0 1) 3)
		)
	)
)

(instance controlBox of GameControls
	(properties)
)

(instance difficultySlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 80
		nsTop 37
		signal 128
		helpStr {Slide this knob up or down to increase or decrease the puzzle difficulty level. There are three difficulty levels -- Novice, Standard, and Expert.}
		sliderView 947
		topValue 14
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 136
		nsTop 37
		signal 128
		helpStr {Slide this knob up or down to increase or decrease the sound volume level. There are 16 levels for most supported synthesizers, while the standard PC speaker only has two -- On and Off.}
		sliderView 947
		topValue 15
	)
)

(instance iconSave of ControlIcon
	(properties
		view 947
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		signal 451
		helpStr {Choose this button to save your current game position.}
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		signal 451
		helpStr {Choose this button to return to a previously-saved game position.}
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		signal 451
		helpStr {Choose this button to start the game over from the beginning.}
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		signal 451
		helpStr {Choose this button to quit the game. (Make sure you save first!)}
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 6
		signal 451
		helpStr {Choose this button to learn more about the making of Dr. Brain, and about other Sierra games by the same author.}
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 70
		message 6
		signal 387
		helpStr {This button tells you what the other buttons do.}
	)
)

(instance iconOk of IconI
	(properties
		view 947
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 70
		signal 451
		helpStr {Choose this button to return to your game in progress.}
	)
)

(instance BrainVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 [temp1 100])
		(if (= temp0 (param2 description:))
			(switch param1
				(2
					(if (param2 lookStr:)
						(proc5_9 (param2 lookStr:))
					else
						(proc5_9 (Format @temp1 0 10 temp0)) ; "It is the %s."
					)
				)
				(4
					(proc5_9 0 11)
				)
				(else
					(proc0_2)
				)
			)
		else
			(proc0_2)
		)
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 300])
		(= temp0 (gSystemWindow back:))
		(gSystemWindow back: (proc0_1 44 11))
		(Print (Format @temp1 0 12 gVersion) #mode 1 #width 120) ; "Castle of Dr. Brain Version %s Designed and Directed by Corey Cole Art Design by Andy Hoyos Lead Artist Douglas Herring"
		(Print (Format @temp1 0 13) #mode 1 #width 120) ; "Castle of Dr. Brain (Macintosh) was programmed by Krishnan Shankar & Jason Hickingbottom"
		(Print (Format @temp1 0 14) #mode 1 #width 120) ; "Castle of Dr. Brain was: Programmed by Corey Cole Brett Miller Jack Magne' John Wentworth Steve Conrad"
		(Print (Format @temp1 0 15) #mode 1 #width 120) ; "Art and Animation by Andy Hoyos Dennis Lewis Douglas Herring Vasken Nokhoudian Dana Dean Jerry Jessurun Deena Krutak Arturo Sinclair Bob Gleason Jay Allan Friedmann Jon Bock Diana Wilson John Shroades"
		(Print (Format @temp1 0 16) #mode 1 #width 120) ; "Music and Sound Effects by Ken Allen Mark Siebert Chris Braymen Rob Atesalp Orpheus Hanley"
		(Print (Format @temp1 0 17) #mode 1 #width 120) ; "Development System by Jeff Stephenson Robert E. Heitman Pablo Ghenis J. Mark Hood Larry Scott Dan Foy Mark Wilden"
		(Print (Format @temp1 0 18) #mode 1 #width 120) ; "Eric Hart Terry McHenry John Rettig Chris Smith Chad Bye Ken Koch John Crane Steve Coallier Randy Moss Krishnan Shankar"
		(Print (Format @temp1 0 19) #mode 1 #width 120) ; "Quality Assurance Lead by Sharon Simmons Dave Clingman"
		(Print 0 20 #width 250) ; "And if you think THIS was a challenge, try the "Quest for Glory" role-playing/adventure series by Lori and Corey Cole. In "Quest for Glory I: So You Want to Be a Hero", you are the only one who can fulfill a mysterious prophecy and save the town of Spielburg. In "Quest for Glory II: Trial By Fire", you travel to the magical lands of the Arabian Nights tales as you battle elemental creatures to help your friends and stop the growing darkness."
		(Print 0 21 #width 250) ; "Both games feature stunning graphics, fantastic music tracks, fascinating characters, and rich story lines. Not to mention a healthy dose of fun and general silliness. You play each game as your choice of a Fighter, Magic User, Thief, or hybrid character. Also watch for "Quest for Glory III: Wages of War", set in the African veldt, coming Summer 1992. But now, back to the Castle of Dr. Brain!"
		(gSystemWindow back: temp0)
	)
)

