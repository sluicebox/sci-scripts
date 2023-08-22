;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use invCode)
(use eRS)
(use ego)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use Osc)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use System)

(public
	LB2 0
	StepOn 1
	IsFlag 2
	SetFlag 3
	ClearFlag 4
	Face 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	lb2Win 9
	TimeCheck 10
	Localize 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
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
	gWaitCursor = 997
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
	global39
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
	gLb2ApproachCode
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
	gTextSpeed = 2
	; 95
	gAltPolys
	global96
	global97
	global98
	global99
	; 100
	gStopGroop
	global101 = 1234
	gGameMusic1
	gGameMusic2
	global104
	; 105
	global105
	global106
	global107 = 100
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
	gAct
	gMustDos
	; 125
	gClockTimeMustDos
	global126
	global127
	global128
	global129
	; 130
	gLb2Exits
	global131 = 1
	global132 = 1
	global133 = 1
	global134 = 1
	; 135
	global135 = 1
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
	global150 = 4
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
)

(procedure (proc0_13)
	(SetFlag 7)
	(SetFlag 8)
	(SetFlag 9)
	(SetFlag 24)
	(SetFlag 26)
	(SetFlag 27)
	(SetFlag 28)
	(SetFlag 29)
	(SetFlag 34)
	(SetFlag 43)
	((ScriptID 21 0) doit: 791) ; addCluesCode, Magnifying Glass
	((ScriptID 21 0) doit: 263) ; addCluesCode, Steve Dorian
	((ScriptID 21 0) doit: 264) ; addCluesCode, Ziggy
	((ScriptID 21 0) doit: 265) ; addCluesCode, Wolf Heimlich
	((ScriptID 21 0) doit: 266) ; addCluesCode, Yvette Delacroix
	((ScriptID 21 0) doit: 267) ; addCluesCode, Ernie Leach
	((ScriptID 21 0) doit: 268) ; addCluesCode, Rameses Najeer
	((ScriptID 21 0) doit: 269) ; addCluesCode, Countess W-C
	((ScriptID 21 0) doit: 270) ; addCluesCode, Dr. Olympia Myklos
	((ScriptID 21 0) doit: 271) ; addCluesCode, Dr. "Tut" Smith
	((ScriptID 21 0) doit: 272) ; addCluesCode, Watney Little
	((ScriptID 21 1) doit: 518) ; dropCluesCode, Flower Shop
	((ScriptID 21 0) doit: 520) ; addCluesCode, Speakeasy
	(ego wearingGown: 1)
	(ego get: -1 22)
	(ego get: -1 6)
)

(procedure (proc0_14)
	(proc0_13)
	(SetFlag 1)
	(SetFlag 25)
	(SetFlag 23)
	((ScriptID 21 0) doit: 797) ; addCluesCode, Water Glass
	(ego get: -1 28)
	(ego get: -1 21)
)

(procedure (proc0_15)
	(proc0_14)
	(= global129 13)
	(SetFlag 2)
	(SetFlag 3)
	(SetFlag 4)
	(SetFlag 22)
	(SetFlag 31)
	(SetFlag 33)
	(SetFlag 35)
	(SetFlag 36)
	(SetFlag 37)
	(SetFlag 40)
	(SetFlag 42)
	(SetFlag 49)
	((ScriptID 21 0) doit: 790) ; addCluesCode, Pippin's Notepad
	((ScriptID 21 0) doit: 789) ; addCluesCode, Ankh Medallion
	((ScriptID 21 0) doit: 787) ; addCluesCode, Dinosaur Bone
	((ScriptID 21 0) doit: 783) ; addCluesCode, Snake Oil
	((ScriptID 21 0) doit: 788) ; addCluesCode, Snake Lasso
	((ScriptID 21 0) doit: 798) ; addCluesCode, Carbon Paper
	((ScriptID 21 0) doit: 802) ; addCluesCode, Charcoal
	((ScriptID 21 0) doit: 779) ; addCluesCode, Wire Cutters
	((ScriptID 21 0) doit: 777) ; addCluesCode, Skeleton Key
	((ScriptID 21 0) doit: 776) ; addCluesCode, Pocketwatch
	((ScriptID 21 0) doit: 778) ; addCluesCode, Meat
	((ScriptID 21 0) doit: 1025) ; addCluesCode, Hieroglyphs
	((ScriptID 21 0) doit: 1030) ; addCluesCode, Sterling W-C Diary
	(ego get: -1 20 18 14 19 29 33 10 8 7 9 11)
)

(procedure (proc0_16 &tmp temp0)
	(proc0_15)
	(SetFlag 72)
	(SetFlag 5)
	(SetFlag 6)
	(SetFlag 62)
	((ScriptID 21 0) doit: 794) ; addCluesCode, Animal Hair
	((ScriptID 21 0) doit: 785) ; addCluesCode, Cheese
	((ScriptID 21 0) doit: 786) ; addCluesCode, Garter
	((ScriptID 21 0) doit: 799) ; addCluesCode, Woman's Shoe
	((ScriptID 21 0) doit: 796) ; addCluesCode, Red Hair
	((ScriptID 21 0) doit: 795) ; addCluesCode, Bifocals
	((ScriptID 21 0) doit: 781) ; addCluesCode, Work Boot
	((ScriptID 21 0) doit: 800) ; addCluesCode, Grapes
	((ScriptID 21 0) doit: 782) ; addCluesCode, Smelling Salts
	((ScriptID 21 0) doit: 780) ; addCluesCode, Dagger of Amon Ra
	(ego put: 6 0 1 3 4 5 8 9 18 23 32)
	((ScriptID 21 1) doit: 775) ; dropCluesCode, Press Pass
	((ScriptID 21 1) doit: 769) ; dropCluesCode, Free Sandwich Coupon
	((ScriptID 21 1) doit: 770) ; dropCluesCode, Laundry Claim Ticket
	((ScriptID 21 1) doit: 772) ; dropCluesCode, Corned Beef Sandwich
	((ScriptID 21 1) doit: 773) ; dropCluesCode, Baseball
	((ScriptID 21 1) doit: 774) ; dropCluesCode, Desk Key
	((ScriptID 21 1) doit: 777) ; dropCluesCode, Skeleton Key
	((ScriptID 21 1) doit: 778) ; dropCluesCode, Meat
	((ScriptID 21 1) doit: 787) ; dropCluesCode, Dinosaur Bone
	((ScriptID 21 1) doit: 792) ; dropCluesCode, Lightbulb
	((ScriptID 21 1) doit: 801) ; dropCluesCode, Evening Gown
	(for ((= temp0 1)) (< temp0 27) ((++ temp0))
		((ScriptID 21 0) doit: (+ temp0 1088)) ; addCluesCode
	)
	(ego get: -1 25 16 17 30 27 26 12 31 13)
)

(procedure (proc0_17)
	(proc0_16)
	(SetFlag 10)
	((ScriptID 21 0) doit: 784) ; addCluesCode, Lantern
	((ScriptID 21 0) doit: 803) ; addCluesCode, Wire
	(ego get: -1 34 15)
)

(procedure (StepOn param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (IsFlag param1)
	(return (& [global186 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global186 (/ param1 16)]
		(| [global186 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global186 (/ param1 16)]
		(& [global186 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc0_7 &tmp temp0)
	(gUser canControl: global108 canInput: global109)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (& global116 (>> $8000 temp0))
			(gTheIconBar disable: temp0)
		)
	)
)

(procedure (proc0_6 param1 param2)
	(cond
		((OneOf param2 4 3 38)
			(gMessager say: 0 param2 0 0 0 0)
		)
		((OneOf param2 6 1 8)
			(gMessager say: 0 param2 0 (Random 1 2) 0 0)
		)
		((== param2 2)
			(gMessager say: 0 param2 0 (Random 1 4) 0 0)
		)
		(else
			(gMessager say: 0 47 0 0 0 0) ; "While this is an interesting approach, it serves no practical purpose."
		)
	)
)

(procedure (proc0_8 param1)
	(if param1
		(gTheIconBar delete: icon0 addToFront: (icon10 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon0)
			(gTheIconBar curIcon: icon10 walkIconItem: 0)
			(gGame setCursor: (icon10 cursor:))
		)
	else
		(gTheIconBar delete: icon10 addToFront: (icon0 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon10)
			(gTheIconBar curIcon: icon0 walkIconItem: icon0)
			(gGame setCursor: (icon0 cursor:))
		)
	)
)

(procedure (TimeCheck param1 param2)
	(&= param1 $00ff)
	(return
		(if (and (> argc 1) param2)
			(== (- param1 1) (& gMustDos (- param1 1)))
		else
			(& gMustDos param1)
		)
	)
)

(procedure (Localize param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(procedure (proc0_12) ; UNUSED
	(Localize 1026 1040 1051 1050 995)
)

(instance gameMusic1 of Sound
	(properties)
)

(instance gameMusic2 of Sound
	(properties)
)

(class WrapMusic of List
	(properties
		wrapSound 0
		currentSound 0
		loopIt 0
		vol 127
		paused 0
	)

	(method (init param1)
		(Sounds eachElementDo: #check)
		(if (not wrapSound)
			(= wrapSound gGameMusic1)
		)
		(= loopIt param1)
		(= currentSound 0)
		(self add: &rest cue:)
	)

	(method (cue &tmp temp0 temp1 temp2)
		(cond
			((OneOf (wrapSound prevSignal:) -1 0)
				(= temp0 1)
				(cond
					((and (== loopIt -1) (== currentSound (- size 1)))
						(= temp0 -1)
					)
					((== currentSound size)
						(switch loopIt
							(1
								(= currentSound 0)
							)
							(else
								(self release: dispose:)
								(return)
							)
						)
					)
				)
				(if (> (= temp1 (self at: currentSound)) 1000)
					(-= temp1 1000)
					(= temp2 1)
				else
					(= temp2 0)
				)
				(wrapSound
					number: temp1
					setLoop: temp0
					flags: (if temp2 5 else 1)
					play: vol self
				)
				(++ currentSound)
			)
			(paused
				(wrapSound pause:)
			)
			(else
				(= vol (wrapSound vol:))
			)
		)
	)

	(method (pause param1)
		(if (IsObject wrapSound)
			(if (and argc (not param1))
				(= paused 0)
				(wrapSound pause: 0 fade: vol 5 5 0)
			else
				(= paused 1)
				(wrapSound fade: 0 5 5 0)
			)
		)
	)

	(method (dispose param1)
		(wrapSound client: 0)
		(if (and argc param1)
			(super dispose:)
		else
			(self release:)
		)
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance walkCursor of Cursor
	(properties)
)

(instance lookCursor of Cursor
	(properties
		view 1
	)
)

(instance doCursor of Cursor
	(properties
		view 2
	)
)

(instance talkCursor of Cursor
	(properties
		view 3
	)
)

(instance askCursor of Cursor
	(properties
		view 4
	)
)

(instance exitCursor of Cursor
	(properties
		view 6
	)
)

(instance lb2KDH of EventHandler
	(properties)
)

(instance lb2MDH of EventHandler
	(properties)
)

(instance lb2DH of EventHandler
	(properties)
)

(instance lb2WH of EventHandler
	(properties)
)

(instance lb2Exits of EventHandler
	(properties)
)

(class LB2 of Game
	(properties
		printLang 0
	)

	(method (init &tmp temp0 [temp1 5] [temp6 16])
		(StrSplit @temp1 @temp6 0)
		Print
		StopWalk
		Polygon
		PolyPath
		Timer
		LBRoom
		ego
		IconBar
		Inv
		LBIconItem
		(ScriptID 982)
		Narrator
		Osc
		(super init:)
		(= gVersion {x.yyy.zzz})
		(= global112 {991-999-9999})
		(= global113 {9999-999999})
		(= global114 {992-999-9999})
		((ScriptID 14 0) init:) ; lb2InitCode
		(DisposeScript 14)
		((ScriptID 15 0) init:) ; invCode
		(= gNormalCursor walkCursor)
		(= gDoVerbCode lb2DoVerbCode)
		(= gFtrInitializer lb2FtrInit)
		(= gLb2ApproachCode lb2ApproachCode)
		(= gStopGroop stopGroop)
		(= gMessager lb2Messager)
		((= gKeyDownHandler lb2KDH) add:)
		((= gMouseDownHandler lb2MDH) add:)
		((= gDirectionHandler lb2DH) add:)
		((= gWalkHandler lb2WH) add:)
		((= gLb2Exits lb2Exits) add:)
		((= gAltPolys (List new:)) name: {altPolys} add:)
		(gMouseDownHandler addToFront: lb2Exits)
		(gKeyDownHandler addToFront: lb2Exits)
		(= gPMouse PseudoMouse)
		(WrapMusic add:)
		((= gGameMusic1 gameMusic1) owner: self flags: 1 init:)
		((= gGameMusic2 gameMusic2) owner: self flags: 1 init:)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor global157
			eachElementDo: #lowlightColor global177
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			walkIconItem: icon0
			disable: 5
			disable:
			state: 3072
		)
		(if (GameIsRestarting)
			(MemorySegment 1 @global107)
		else
			(= global107 28)
		)
		(if (FileIO fiEXISTS {10.scr})
			(= global110 1)
		else
			(= global110 0)
		)
		(gTheIconBar enable:)
		(= gEgo ego)
		(gUser alterEgo: gEgo canControl: 0 canInput: 0)
		(self newRoom: global107)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(gLb2Exits size:)
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
			)
			(gLb2Exits eachElementDo: #doit)
		)
		(if panelObj
			(= temp0 panelObj)
			(= temp1 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp0 temp1)
		)
		(super doit:)
	)

	(method (checkAni))

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(= temp0 gTheCursor)
		(if argc
			(if (IsObject param1)
				((= gTheCursor param1) init:)
			else
				(SetCursor (= gTheCursor param1) 0 0)
			)
		)
		(if (and (> argc 1) (not param2))
			(SetCursor 996 0 0)
		)
		(if (> argc 2)
			(if (< param3 0)
				(= param3 0)
			)
			(if (< param4 0)
				(= param4 0)
			)
			(SetCursor param3 param4)
		)
		(return temp0)
	)

	(method (pragmaFail)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (gUser canInput:)
			(gMessager say: 0 ((gUser curEvent:) message:))
		)
	)

	(method (save &tmp temp0 temp1 temp2)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super save: &rest)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar curIcon:) cursor:)) 999)
			(gGame setCursor: gWaitCursor)
		else
			(gGame setCursor: temp2)
		)
	)

	(method (restore &tmp temp0 temp1 temp2 temp3)
		(= temp3 (EventHandler new:))
		(for ((= temp2 0)) (< temp2 (gAddToPics size:)) ((++ temp2))
			(temp3 add: (gAddToPics at: temp2))
		)
		(DrawPic 780 7)
		(gCast eachElementDo: #hide)
		(Animate 0)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super restore: &rest)
		(DrawPic (gCurRoom picture:) 100)
		(gCast eachElementDo: #show)
		(for ((= temp2 0)) (< temp2 (temp3 size:)) ((++ temp2))
			(gAddToPics add: (temp3 at: temp2))
		)
		(temp3 release: dispose:)
		(gAddToPics doit:)
		(Animate (gCast elements:) 0)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar curIcon:) cursor:)) 999)
			(gGame setCursor: gWaitCursor)
		else
			(gGame setCursor: temp2)
		)
	)

	(method (replay &tmp temp0)
		(= gSystemWindow lb2Win)
		(= gNormalCursor walkCursor)
		(if (and (OneOf gCurRoomNum 330 335) (== gAct 2))
			(Palette palSET_INTENSITY 0 255 60)
		else
			(Palette palSET_INTENSITY 0 255 100)
		)
		(super replay: &rest)
	)

	(method (restart)
		(gCurRoom style: 6 drawPic: 780)
		(gCast eachElementDo: #hide)
		(Animate (gCast elements:) 0)
		(MemorySegment 0 @global107 2)
		(super restart:)
	)

	(method (quitGame)
		(if
			(Print
				addText: 12 0 0 1 0 0 0 ; "You can't quit, you're FIRED!"
				addIcon: 992 0 0 0 15
				addButton: 1 12 0 8 1 140 67 0 ; "Bye!"
				addButton: 0 12 0 9 1 140 87 0 ; "Oops!"
				saveCursor: 1
				init:
			)
			(super quitGame: 1)
		)
	)

	(method (newRoom newRoomNumber)
		(gGame setCursor: gWaitCursor)
		(gPMouse stop:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (and (IsObject gFastCast) (gFastCast elements:))
			(gFastCast eachElementDo: #dispose 1)
		)
		(if (gLb2Exits size:)
			(gLb2Exits eachElementDo: #dispose)
		)
		(gNarrator
			x: -1
			y: -1
			disposeWhenDone: 1
			talkWidth: 0
			keepWindow: 1
			modeless: 0
			showTitle: 0
			name: {Narrator}
		)
		(gTheIconBar disable:)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp temp0 temp1 [temp2 2])
		((ScriptID 11) doit: roomNum) ; disposeCode
		(for ((= temp1 0)) (< temp1 (gTimers size:)) ((++ temp1))
			(gTimers delete: (= temp0 (gTimers at: 0)))
			(gTimers add: temp0)
		)
		(for ((= temp1 0)) (< temp1 (WrapMusic size:)) ((++ temp1))
			(WrapMusic delete: (= temp0 (WrapMusic at: 0)))
			(WrapMusic add: temp0)
		)
		(if
			(and
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print
					addText: 1 0 0 1 0 0 10 ; "Memory fragmented"
					addButton: 0 1 0 1 1 0 12 10 ; "So what?"
					addButton: 1 1 0 2 1 70 12 10 ; "Debug"
					init:
				)
			)
			(SetDebug)
		)
		(if
			(and
				(OneOf
					roomNum
					335
					340 ; testRoom
					350
					355
					360
					370
					400
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					430
					435
					440
					448
					450
					454
					455
					456 ; magRosetta
					460
					480
					490
					521 ; meanWhile
					600
					610
					620
					630
					640
					650
					666
					660
					700
					710
					715
					720
					730
					740
				)
				(!= gAct 5)
			)
			(ScriptID 90) ; MuseumRgn
		)
		(if
			(and
				(OneOf roomNum 335 340 350 355 360 370 400) ; testRoom
				(== gAct 2)
			)
			(ScriptID 93) ; RotundaRgn
		)
		(if (OneOf roomNum 280 210 260 300)
			(ScriptID 91) ; streetRgn
		)
		(if
			(and
				(== gAct 5)
				(OneOf roomNum 420 430 435 440 448 450 454 460 480 490 660)
			)
			(ScriptID 94) ; PursuitRgn
		)
		(if (OneOf roomNum 100 105 110 120 140 150 155 160 180 190 220) ; logo
			(ScriptID 92) ; intro
		)
		(if (and global110 (not (OneOf roomNum 100)))
			((ScriptID 10 0) init:) ; MISSING SCRIPT
		)
		(gTheIconBar enable:)
		(super startRoom: roomNum)
		(if
			(and
				(gEgo cycler:)
				(not (gEgo looper:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo setLoop: stopGroop)
		)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 5))
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_TAB
						(if (not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gEgo showInv:)
							(event claimed: 1)
						)
					)
					(KEY_SHIFTTAB
						(if (not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gEgo showInv:)
							(event claimed: 1)
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(JOY_RIGHT
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(gGame showControls:)
						)
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
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gGame save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gGame restore:)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (gUser controls:)
							(= gSpeed (Max 0 (-- gSpeed)))
							(gEgo setSpeed: gSpeed)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(++ gSpeed)
							(gEgo setSpeed: gSpeed)
						)
					)
					($003d ; =
						(if (gUser controls:)
							(gEgo setSpeed: 6)
						)
					)
				)
			)
		)
	)

	(method (handsOff)
		(if (not global121)
			(= global121 (gTheIconBar curIcon:))
		)
		(= global108 (gUser canControl:))
		(= global109 (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(= global116 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar curIcon: (gTheIconBar at: 7))
		(gTheIconBar disable: 0 1 2 3 4 5 6)
		(if (not (HaveMouse))
			(gGame setCursor: 996)
		else
			(gGame setCursor: gWaitCursor)
		)
	)

	(method (handsOn param1)
		(gUser canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6)
		(if (not (gCurRoom inset:))
			(gTheIconBar enable: 7)
		)
		(if (and argc param1)
			(proc0_7)
		)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 5)
		)
		(if
			(and
				global121
				(or (!= global121 icon10) (== (gTheIconBar at: 0) icon10))
			)
			(gTheIconBar curIcon: global121)
			(gGame setCursor: (global121 cursor:))
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 5))
					(not (gTheIconBar curInvIcon:))
				)
				(gTheIconBar advanceCurIcon:)
			)
		)
		(= global121 0)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (points param1 param2)
		(if (and (> argc 1) (SetFlag param2))
			(= param1 0)
		)
		(if param1
			(gGame changeScore: param1)
		)
	)

	(method (showControls &tmp temp0)
		((ScriptID 24 0) init: show: dispose:) ; lb2GameControls
	)

	(method (showAbout)
		(if
			(or
				(== gAct 2)
				(OneOf gCurRoomNum 435 454 455 520 521 525 550 560 565 620 650) ; meanWhile
			)
			(gMessager say: 11 0 0 0 0 0) ; "There is not enough memory available right now to show the about screen."
		else
			((ScriptID 13 0) doit:) ; aboutCode
		)
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		type 20480
		message 3
		signal 65
		maskView 990
		maskLoop 9
		noun 1
		helpVerb 12
	)

	(method (init)
		(= cursor walkCursor)
		(super init:)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon1 of IconI
	(properties
		view 990
		loop 1
		cel 0
		message 1
		signal 65
		maskView 990
		maskLoop 9
		noun 2
		helpVerb 12
	)

	(method (init)
		(= cursor lookCursor)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		message 4
		signal 65
		maskView 990
		maskLoop 9
		noun 3
		helpVerb 12
	)

	(method (init)
		(= cursor doCursor)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		message 2
		signal 65
		maskView 990
		maskLoop 9
		noun 4
		helpVerb 12
	)

	(method (init)
		(= cursor talkCursor)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 4
		cel 0
		message 6
		signal 65
		maskView 990
		maskLoop 9
		noun 5
		helpVerb 12
	)

	(method (init)
		(= cursor askCursor)
		(super init:)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 990
		maskLoop 9
		maskCel 1
		noun 9
		helpVerb 12
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if (= temp2 (gTheIconBar curInvIcon:))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(temp2 view:)
											(+ (temp2 loop:) 1)
											(temp2 cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(temp2 view:)
											(+ (temp2 loop:) 1)
											(temp2 cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel
							(temp2 view:)
							(+ 1 (temp2 loop:))
							(temp2 cel:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(if (= temp2 (gTheIconBar curInvIcon:))
										(DrawCel
											(temp2 view:)
											(+ 1 (temp2 loop:))
											(temp2 cel:)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= temp2 (gTheIconBar curInvIcon:))
									(DrawCel
										(temp2 view:)
										(+ 1 (temp2 loop:))
										(temp2 cel:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= temp2 (gTheIconBar curInvIcon:))
							(DrawCel
								(temp2 view:)
								(+ 1 (temp2 loop:))
								(temp2 cel:)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance icon7 of IconI
	(properties
		view 990
		loop 6
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 990
		maskLoop 9
		noun 6
		helpVerb 12
	)

	(method (show)
		(= loop (if (gEgo wearingGown:) 11 else 6))
		(super show: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gEgo showInv:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 7
		signal 67
		maskView 990
		maskLoop 9
		noun 7
		helpVerb 12
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gGame showControls:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 990
		loop 8
		cel 0
		cursor 9
		type 8192
		message 12
		signal 3
		maskView 990
		maskLoop 9
		noun 8
		helpVerb 12
	)
)

(instance icon10 of IconI
	(properties
		view 990
		loop 10
		cel 0
		message 13
		signal 65
		maskView 990
		maskLoop 9
		noun 10
		helpVerb 12
	)

	(method (init)
		(= cursor exitCursor)
		(super init:)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global116 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance lb2DoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(proc0_6 param2 param1)
	)
)

(instance lb2FtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 40)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance lb2Messager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(22
						(ScriptID 310 22) ; Bartender
					)
					(20
						(ScriptID 1904 20) ; Talking_Bear
					)
					(33
						(ScriptID 260 33) ; Biff
					)
					(14
						(ScriptID 1903 14) ; Bob
					)
					(17
						(ScriptID 300 17) ; Bouncer
					)
					(16
						(ScriptID 1901 16) ; Bum
					)
					(21
						(if (== gCurRoomNum 750)
							(ScriptID 750 21) ; Coroner
						else
							(ScriptID 1899 21) ; Coroner
						)
					)
					(29
						(ScriptID 1884 29) ; Countess
					)
					(7
						(if (IsFlag 30)
							(ScriptID 230 7) ; Crodfoller
						else
							(ScriptID 1896 7) ; Crodfoller
						)
					)
					(1
						(ScriptID 1880 1) ; Dad
					)
					(41
						(ScriptID 280 41) ; Drunk
					)
					(23
						(if (== gCurRoomNum 355)
							(ScriptID 355 23) ; tkrErnie
						else
							(ScriptID 1893 23) ; Ernie
						)
					)
					(8
						(ScriptID 1906 8) ; Lesbian_Flapper
					)
					(18
						(ScriptID 1889 18) ; Heimlich
					)
					(15
						(ScriptID 1900 15) ; Irmgaard
					)
					(2
						(cond
							((IsFlag 30)
								(ScriptID 230 2) ; Laura
							)
							((== gCurRoomNum 155)
								(ScriptID 155 2) ; Laura
							)
							((== gCurRoomNum 220)
								(ScriptID 220 2) ; Laura220
							)
							((== gCurRoomNum 330)
								(ScriptID 330 2) ; Laura
							)
							((and (== gCurRoomNum 355) (not (IsFlag 91)))
								(ScriptID 355 2) ; tkrLaura
							)
							((and (== gCurRoomNum 710) (== (gCurRoom picture:) 716))
								(ScriptID 710 2) ; Rameses_b
							)
							(else
								(ScriptID 1881 2) ; Laura
							)
						)
					)
					(4
						(ScriptID 1895 4) ; Lo_Fat
					)
					(24
						(ScriptID 1907 24) ; Luigi
					)
					(37
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(36
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(35
						(if (== gCurRoomNum 230)
							(ScriptID 230 37) ; ManWriting
						)
					)
					(25
						(ScriptID 1892 25) ; Olympia
					)
					(19
						(cond
							((== gCurRoomNum 295)
								(ScriptID 295 19) ; myORiley
							)
							((== gCurRoomNum 770)
								(ScriptID 770 19) ; O_Riley
							)
							(else
								(ScriptID 1888 19) ; O_Riley
							)
						)
					)
					(30
						(ScriptID 310 30) ; PianoPlayer
					)
					(10
						(ScriptID 1882 10) ; Pippin
					)
					(27
						(if (and (== gCurRoomNum 710) (== (gCurRoom picture:) 716))
							(ScriptID 710 27) ; Rameses_a
						else
							(ScriptID 1891 27) ; Rameses
						)
					)
					(39
						(ScriptID 480 39) ; Rex
					)
					(13
						(ScriptID 1902 13) ; Rocco
					)
					(3
						(if (== gCurRoomNum 220)
							(ScriptID 220 3) ; Sam220
						else
							(ScriptID 1894 3) ; Sam
						)
					)
					(5
						(ScriptID 1897 5) ; Sergeant
					)
					(31
						(ScriptID 310 31) ; Singer
					)
					(12
						(cond
							((== gCurRoomNum 240)
								(ScriptID 240 12) ; local_Steve
							)
							((== gCurRoomNum 330)
								(ScriptID 330 12) ; Steve
							)
							((== gCurRoomNum 775)
								(ScriptID 775 12) ; Steve
							)
							(else
								(ScriptID 1887 12) ; Steve
							)
						)
					)
					(32
						(ScriptID 260 32) ; Stinky
					)
					(34
						(ScriptID 260 34) ; Tubby
					)
					(9
						(ScriptID 1883 9) ; TutSmith
					)
					(38
						(ScriptID 290 38) ; theWanderer
					)
					(11
						(ScriptID 1886 11) ; Watney
					)
					(28
						(ScriptID 1885 28) ; Yvette
					)
					(6
						(ScriptID 1890 6) ; Ziggy
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance lb2ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(6 16)
				(13 32)
				(8 64)
				(38 128)
				(else -32768)
			)
		)
	)
)

(instance lb2Win of SysWindow
	(properties
		type 128
	)

	(method (open &tmp temp0 temp1)
		(cond
			((OneOf gCurRoomNum 280 210 330 240 260 300)
				(= temp1 0)
			)
			((OneOf gCurRoomNum 210 220 230 260 270 280 290 295 300 310 320)
				(= temp1 1)
			)
			(
				(OneOf
					gCurRoomNum
					100
					105 ; logo
					110
					120
					140
					150
					155
					160
					180
					190
					220
					335
					340 ; testRoom
					350
					355
					360
					370
					400
				)
				(= temp1 2)
			)
			((OneOf gCurRoomNum 460 660 700 710 715 720 730 740)
				(= temp1 4)
			)
			(
				(OneOf
					gCurRoomNum
					335
					340 ; testRoom
					350
					355
					360
					370
					400
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					430
					435
					440
					448
					450
					454
					455
					456 ; magRosetta
					460
					480
					490
					521 ; meanWhile
					600
					610
					620
					630
					640
					650
					666
					660
					700
					710
					715
					720
					730
					740
				)
				(= temp1 3)
			)
			(else
				(= temp1 4)
			)
		)
		(= lsLeft (- left (/ (CelWide 994 temp1 0) 2)))
		(= lsTop (- top (if title 19 else 10)))
		(= lsRight (+ right (/ (CelWide 994 temp1 0) 2)))
		(= lsBottom (Max (+ bottom 3) (+ lsTop (CelHigh 994 temp1 0) 3)))
		(= priority 15)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX top left bottom right 3 global176 15)
		(Graph grDRAW_LINE (- top 1) (- left 1) (- top 1) right global151 15)
		(Graph grDRAW_LINE (- top 1) (- left 1) bottom (- left 1) global151 15)
		(Graph grDRAW_LINE bottom (- left 1) bottom right global151 15)
		(Graph grDRAW_LINE (- top 1) right bottom right global151 15)
		(Graph grUPDATE_BOX top left bottom right 1)
		(Graph
			grUPDATE_BOX
			lsTop
			lsLeft
			(+ lsTop (CelHigh 994 temp1 0))
			(+ lsLeft (CelWide 994 temp1 0))
			1
		)
		(Graph
			grUPDATE_BOX
			lsTop
			(- lsRight (CelWide 994 temp1 0))
			(+ lsTop (CelHigh 994 temp1 0))
			lsRight
			1
		)
		(DrawCel 994 temp1 0 (+ lsLeft 1) (+ lsTop 1) -1)
		(DrawCel
			994
			temp1
			1
			(- (- lsRight (CelWide 994 temp1 0)) 1)
			(+ lsTop 1)
			-1
		)
		(SetPort temp0)
	)
)

