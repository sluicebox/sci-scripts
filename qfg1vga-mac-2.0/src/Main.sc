;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n001)
(use dartScript)
(use n101)
(use n102)
(use GloryWindow)
(use n814)
(use n896)
(use Print)
(use Messager)
(use PseudoMouse)
(use Slider)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use GameControls)
(use Ego)
(use Sound)
(use Motion)
(use Game)
(use User)
(use System)

(public
	Glory 0
	stopGroop 1
	HandsOff 2
	HandsOn 3
	SetFlag 5
	ClearFlag 6
	IsFlag 7
	mainIconBar 8
	statusCode 9
	gcWin 10
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	global3
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
	global17
	gSet
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
	global30
	gPerspective
	gFeatures
	global33
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
	gQg1ApproachCode
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
	gMsgType = 1
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
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
	global103
	global104
	; 105
	global105
	gLongSong
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
	gClock
	gNight
	gDay
	gTimeOfDay
	; 120
	global120
	global121
	gHeroType
	global123
	global124
	; 125
	gEgoStats
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
	global177 = 2
	global178 = 2
	global179 = 3
	; 180
	global180 = 3
	global181 = 3
	global182 = 4
	global183 = 5
	global184 = 5
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
	gList
	global194
	; 195
	global195
	global196
	global197 = 20
	global198 = 15
	gFreeMeals
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
	global231 = 180
	global232
	global233 = 45
	global234 = 90
	; 235
	global235 = 135
	global236 = 180
	global237 = 225
	global238 = 270
	global239 = 315
	; 240
	global240
	global241
	global242
	global243
	global244
	; 245
	global245
	global246 = -1
	global247
	global248
	global249
	; 250
	global250
	global251
	global252
	global253 = 42
	global254 = 54
	; 255
	global255
	global256 = -3
	global257
	global258
	global259
	; 260
	global260 = -32768
	global261 = -1
	global262
	gKobold
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
	global275 = 26
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
	gEgoGait
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
	global410 = 160
	global411 = 120
	global412 = 93
	global413 = 1000
	global414
	; 415
	global415 = 5
	gLongSong2
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
	global453 = 1
	global454
)

(procedure (HandsOff)
	(if global102
		(return)
	)
	(= global102 1)
	(proc814_30)
	(User canControl: 0 canInput: 0)
	(= global123 global100)
	(= global418 0)
	(gTheIconBar eachElementDo: #perform checkIcon)
	(Platform 0 4 3 1 2 3 4 5 6 7 8)
	(gTheIconBar disable: 1 2 3 4 5 6 7 8)
	(gGame setCursor: gWaitCursor 1)
)

(procedure (HandsOn &tmp temp0)
	(if global102
		(= global102 0)
		(gGame setSpeed: global123)
		(User canControl: 1 canInput: 1)
	)
	(Platform 0 4 2 -1)
	(Platform 0 4 2 1 2 3 4 5 6 7 8 9)
	(gTheIconBar enable: 1 2 3 4 5 6 7 8 9)
	(gEgo signal: (| (gEgo signal:) $1000))
	(proc814_31)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 7)
	)
	(if
		(or
			(not [gEgoStats 12]) ; magic
			(not
				(for ((= temp0 17)) (<= temp0 24) ((++ temp0))
					(if (gEgo knows: temp0)
						(return 1)
						(DisposeScript 814)
					)
				)
			)
		)
		(gTheIconBar disable: 6)
	)
	(if
		(and
			(not (gTheIconBar curInvIcon:))
			(== (gTheIconBar curIcon:) (gTheIconBar at: 7))
		)
		(gTheIconBar advanceCurIcon:)
	)
	(return (gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1))
)

(procedure (SetFlag param1)
	(|= [global290 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (ClearFlag param1)
	(&= [global290 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (IsFlag param1)
	(return (& [global290 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(class ego of Ego
	(properties
		noun 1
		modNum 120
		view 0
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 81 11 16 17 20 22 23 24 25 29 32 33 34 38 39 40) ; flameDartSpell, rations, dagger, lockPick, rock, healingPotion, manaPotion, staminaPotion, disenchant, ghostOil, fruit, vegetables, acorn, fairyDust, flyingWater, mushroom
				((ScriptID 120) doit: theVerb) ; egoSez
			)
			((== theVerb 1) ; Look
				(SetFlag 360)
				((ScriptID 204) doit:) ; theCharSheet
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (has param1)
		((gInventory at: param1) amount:)
	)

	(method (get param1 param2 &tmp temp0 temp1 temp2 temp3 [temp4 60])
		(= temp0 ((ScriptID 206 0) at: param1)) ; gloryInv
		(= temp1 (if (== argc 1) 1 else param2))
		(= temp2 (temp0 amount:))
		(= temp3 (+ (WtCarried) (/ (+ 59 (* temp1 (temp0 weight:))) 60)))
		(if (not gModelessDialog)
			(cond
				((> temp3 (MaxLoad))
					(if (not (IsFlag 205))
						(Message msgGET 999 15 0 0 1 @temp4) ; "You are carrying so much that you can hardly move. You'd better drop something soon."
						(Print addText: @temp4 init:)
						(SetFlag 205)
					)
				)
				((IsFlag 205)
					(ClearFlag 205)
					(Message msgGET 999 15 0 3 1 @temp4) ; "You are no longer overloaded. That's a load off your mind!"
					(Print addText: @temp4 init:)
				)
			)
		)
		(if (<= (+= temp1 temp2) 0)
			(= temp1 0)
			(if (== (gTheIconBar curInvIcon:) temp0)
				(gTheIconBar disable: (gTheIconBar useIconItem:))
			)
			(Platform 0 4 4 8 -1)
		)
		(temp0 amount: temp1)
		(return (- temp1 temp2))
	)

	(method (use param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (gInventory at: param1))
		(if (> (= temp0 (if (== argc 1) 1 else param2)) (temp2 amount:))
			(= temp0 (temp2 amount:))
		)
		(self get: param1 (- 0 temp0))
		(if (and (== param1 30) (not ((gInventory at: 30) amount:))) ; mushroom
			(ClearFlag 148)
		)
		(if (and (not (temp2 amount:)) (== (gTheIconBar curInvIcon:) temp2))
			(gTheIconBar curInvIcon: 0)
			(gTheIconBar curIcon: (gTheIconBar at: 3))
			(gGame setCursor: 942)
			(Platform 0 4 4 8 -1)
		)
		(return temp0)
	)

	(method (knows param1)
		(return [gEgoStats param1])
	)

	(method (learn param1 param2 &tmp temp0)
		(= temp0 (if (== argc 1) 5 else param2))
		(if (and [gEgoStats 12] (> temp0 [gEgoStats param1])) ; magic
			(= [gEgoStats param1] temp0)
			(|=
				global191
				(switch (- param1 17)
					(0 1)
					(1 2)
					(2 4)
					(3 8)
					(4 16)
					(5 32)
					(6 64)
					(7 128)
				)
			)
			(gTheIconBar enable: 6)
		)
		(return [gEgoStats param1])
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler:) vWalking:))
		)
		(super doit: &rest)
	)
)

(instance statusCode of Code
	(properties)
)

(class qg1Timer of Timer
	(properties
		code 0
	)

	(method (cue)
		(if code
			(code doit:)
			(= code 0)
		)
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance KH of EventHandler
	(properties)
)

(instance MH of EventHandler
	(properties)
)

(instance DH of EventHandler
	(properties)
)

(instance hSW of GloryWindow
	(properties)
)

(instance qg1Walkers of EventHandler
	(properties)
)

(instance qg1Messager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(6 gNarrator)
					(11 gNarrator)
					(47
						(ScriptID 170 1) ; f1
					)
					(48
						(ScriptID 170 2) ; f2
					)
					(49
						(ScriptID 170 3) ; f3
					)
					(50
						(ScriptID 170 4) ; f4
					)
					(51
						(ScriptID 170 5) ; f5
					)
					(4
						(ScriptID 301 3) ; abdullaTalker
					)
					(26
						(ScriptID 21 1) ; babaTalker
					)
					(9
						(ScriptID 342 0) ; bartenderTalker
					)
					(18
						(ScriptID 141 1) ; baronTalker
					)
					(14
						(ScriptID 333 1) ; beggarTalker
					)
					(19
						(ScriptID 141 2) ; bernieTalker
					)
					(46
						(ScriptID 171 1) ; bernieTalker
					)
					(32
						(ScriptID 58 1) ; brauggiTalker
					)
					(35
						(ScriptID 73 1) ; brutusTalker
					)
					(34
						(ScriptID 73 2) ; brunoTalker
					)
					(39
						(ScriptID 65 1) ; bruno65Talker
					)
					(12 gNarrator)
					(5
						(ScriptID 332 1) ; chiefThiefTalker
					)
					(13 gNarrator)
					(22 gNarrator)
					(42
						(ScriptID 76 1) ; dryadTalker
					)
					(27
						(ScriptID 97 1) ; elsa97Talker
					)
					(16
						(ScriptID 31 1) ; erasmus
					)
					(17
						(ScriptID 31 2) ; fenrus
					)
					(25
						(ScriptID 67 1) ; foxTalker
					)
					(23
						(ScriptID 29 1) ; gargoyleTalker
					)
					(40
						(ScriptID 55 1) ; healerTalker
					)
					(38
						(ScriptID 53 1) ; centaurTalker
					)
					(43
						(ScriptID 83 1) ; hermitTalker
					)
					(8
						(ScriptID 320 1) ; hildeTalker
					)
					(10
						(ScriptID 37 1) ; karlTalker
					)
					(33
						(ScriptID 39 4) ; masterTalker
					)
					(7
						(ScriptID 160 0) ; meepTalker
					)
					(28
						(ScriptID 95 1) ; MISSING EXPORT
					)
					(3
						(ScriptID 301 1) ; shameenTalker
					)
					(2
						(ScriptID 301 2) ; shemaTalker
					)
					(41
						(ScriptID 300 1) ; sheriffTalker
					)
					(21
						(ScriptID 322 1) ; shopKeeperTalker
					)
					(29
						(ScriptID 22 1) ; skullTalker
					)
					(15
						(ScriptID 334 1) ; slinkTalker
					)
					(45 gNarrator)
					(1
						(ScriptID 311 1) ; wolfgangTalker
					)
					(30
						(ScriptID 96 4) ; yorickTalker
					)
					(31
						(ScriptID 97 2) ; yorick97Talker
					)
					(20
						(ScriptID 314 1) ; zaraTalker
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)

	(method (say)
		(Print mode: 1)
		(super say: &rest)
	)

	(method (sayNext)
		(Print mode: 1)
		(super sayNext: &rest)
	)
)

(instance Glory of Game
	(properties)

	(method (init &tmp temp0 temp1)
		StopWalk
		PolyPath
		Polygon
		(ScriptID 1)
		(ScriptID 982)
		(= gSystemWindow hSW)
		(= gEgo ego)
		(= temp0 StopWalk)
		(super init:)
		(= gVersion {x.yyy.zzz})
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiCLOSE temp1)
		(= gFtrInitializer hq1FtrInit)
		(= gDoVerbCode hq1DoVerbCode)
		(= gQg1ApproachCode qg1ApproachCode)
		(= gMessager qg1Messager)
		(= gGameControls GameControls)
		((= gKeyDownHandler KH) add:)
		((= gMouseDownHandler MH) add:)
		((= gDirectionHandler DH) add:)
		((= gWalkHandler qg1Walkers) add:)
		((ScriptID 206 0) init:) ; gloryInv
		(HaveMem 999)
		(= gPMouse PseudoMouse)
		(= global196 4)
		((= gLongSong longSong) owner: self flags: 1 init:)
		((= gLongSong2 longSong2) owner: self flags: 1 init:)
		((= gTheIconBar mainIconBar)
			init:
			disable: 7 iconLeft iconRight
			curIcon: iconLook
		)
		(gGameControls
			window: gcWin
			add:
				(detailSlider
					theObj: self
					selector: #detailLevel
					yStep: 3
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					yStep: 3
					yourself:
				)
				(speedSlider
					theObj: self
					selector: #setSpeed
					yStep: 3
					yourself:
				)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 556 0) selector: #doit yourself:) ; aboutCode
				iconGCHelp
				iconOk
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			helpIconItem: iconGCHelp
			curIcon: iconSave
			state: 2048
		)
		(Platform
			0
			4
			0
			10
			iconLeft
			iconWalk
			iconLook
			iconDo
			iconTalk
			iconActions
			iconCast
			iconUseIt
			iconInventory
			iconControlPanel
		)
		(InitGame)
	)

	(method (cue)
		(EgoDead 118 119) ; "Because you failed to meet Baba Yaga's DEADline, her curse turns you into a frog on the spot, and you are forced to live out your years dodging Sauruses (Saurii?) with large feet."
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (IsFlag 328)
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= global121 temp0)
				(= global121 temp0)
				(++ gClock)
				(if (and (>= gDay 7) (& gClock $0001))
					(++ gClock)
				)
				(if (>= gClock 3600)
					(= gClock 0)
					(NextDay)
				)
				(if (== gEgoGait 2) ; sneaking
					(SkillUsed 8 1) ; stealth
				)
				(if
					(and
						(IsFlag 326)
						(> gDay global109)
						(not gFastCast)
						(> gClock 750)
					)
					(HandsOff)
					(ClearFlag 326)
					(gMessager say: 15 0 2 0 self 999) ; "Suddenly, you hear voices, seeming to come from everywhere at once. They all sound like Baba Yaga, and they all say:"
				)
				(if global281
					(-- global281)
				)
				(if (not (mod gClock 150))
					(switch gClock
						(300
							(= gTimeOfDay 7)
						)
						(750
							(if (== gNight 1)
								(PalVary pvREVERSE 1)
								(= gNight 0)
								(= gTimeOfDay 0)
								(ClearFlag 217)
							)
						)
						(1050
							(EatMeal)
						)
						(1200
							(= gTimeOfDay 1)
						)
						(1650
							(= gTimeOfDay 2)
						)
						(2100
							(= gTimeOfDay 3)
						)
						(2400
							(EatMeal)
						)
						(2550
							(= gTimeOfDay 4)
						)
						(3000
							(= gTimeOfDay 5)
							(FixTime 20)
						)
						(3450
							(SetFlag 296)
							(= gTimeOfDay 6)
						)
					)
				)
				(if (and (IsFlag 296) (not gModelessDialog))
					(ClearFlag 296)
					(if (== (++ global247) 1)
						(gMessager say: 1 0 0 8 0 814) ; "You are getting tired."
					else
						(gMessager say: 1 0 0 9 0 814) ; "You are exhausted from lack of sleep."
					)
				)
				(if (IsFlag 168)
					(switch (-- global200)
						(24
							(if gFastCast
								(= global200 30)
							else
								(gMessager say: 15 0 0 2 0 999) ; "The tingling sensation is wearing off."
							)
						)
						(0
							(if gFastCast
								(= global200 5)
							else
								(ClearFlag 168)
								(if (not gModelessDialog)
									(gMessager say: 15 0 0 3 0 999) ; "The tingling sensation is gone."
								)
							)
						)
					)
				)
				(if (not (-- global197))
					(if gFastCast
						(= global197 5)
					else
						(= global197 20)
						(cond
							((or (> global247 1) (IsFlag 125) (IsFlag 205))
								(UseStamina 5)
							)
							((== gEgoGait 1) ; running
								(UseStamina 2)
							)
							((and (not (IsFlag 124)) (not global247))
								(UseStamina -1)
							)
						)
					)
					(if (not (-- global415))
						(= global415 5)
						(UseMana -1)
					)
					(if (not (-- global198))
						(= global198 15)
						(TakeDamage -1)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp [temp0 20])
		(proc814_30)
		(gGame setCursor: gWaitCursor 1)
		(proc896_0 roomNum)
		StopWalk
		Cycle
		(super startRoom: roomNum)
		(if (not global102)
			(proc814_31)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
	)

	(method (quitGame)
		(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
		(Platform 0 4 3 -1)
		(gGame setCursor: 999 1)
		(gTheIconBar hide:)
		(super
			quitGame:
				(Print
					font: gUserFont
					mode: 1
					width: 180
					addText: 15 0 4 1 0 0 999 ; "Hope we'll see you again soon!"
					addButton: 1 15 0 4 3 55 15 999 ; "Quit"
					addButton: 0 15 0 4 4 40 35 999 ; "Don't Quit"
					init:
				)
				(and (== gNight 1) (PalVary pvUNINIT))
		)
		(gGame setCursor: gNormalCursor)
		(Platform 0 4 2 -1)
	)

	(method (setSpeed param1)
		(if argc
			(= global100 param1)
			(if (User controls:)
				(gEgo cycleSpeed: param1 moveSpeed: param1)
			)
		)
		(gEgo moveSpeed:)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(if (not (IsFlag 359))
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
				(SetCursor param3 param4)
			)
			(return temp0)
		)
	)

	(method (save)
		(gTheIconBar hide:)
		(super save:)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (handleEvent event &tmp [temp0 2] [temp2 20])
		(if (== (event type:) evMOUSERELEASE)
			(gMouseDownHandler handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_TAB
						(if
							(not
								(or
									global102
									(& ((gTheIconBar at: 8) signal:) $0004)
									(& (gTheIconBar state:) $0004)
								)
							)
							((ScriptID 206 1) init:) ; pageCode
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(KEY_PAUSE
						(if (not (& (gTheIconBar state:) $0004))
							(cond
								((not (HaveMem 2000))
									(gMessager say: 15 0 0 4 0 999) ; "Sorry, there's not enough room to see that here."
								)
								((not global102)
									(gGame setCursor: gTheCursor 0)
									(SetFlag 359)
									((ScriptID 204) doit:) ; theCharSheet
								)
							)
						)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global196 1)
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
							(not
								(or
									(& (gTheIconBar state:) $0004)
									(& ((gTheIconBar at: 9) signal:) $0004)
								)
							)
							(if gFastCast
								(return gFastCast)
							)
							(gGame save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if
							(not
								(or
									(& (gTheIconBar state:) $0004)
									(& ((gTheIconBar at: 9) signal:) $0004)
								)
							)
							(if gFastCast
								(return gFastCast)
							)
							(gGame restore:)
							(event claimed: 1)
						)
					)
					(KEY_F9
						(gGame restart:)
						(event claimed: 1)
					)
					(KEY_ADD
						(if (User controls:)
							(gGame setSpeed: (Max 1 (- global100 1)))
						)
					)
					(KEY_SUBTRACT
						(if (User controls:)
							(gGame setSpeed: (+ global100 1))
						)
					)
					($003d ; =
						(if (User controls:)
							(gGame setSpeed: 6)
						)
					)
					(else
						(Message msgGET 999 15 0 1 1 @temp2) ; "%d.scr"
						(Format @temp2 298)
					)
				)
			)
			(evMOUSEBUTTON
				(Message msgGET 999 15 0 1 1 @temp2) ; "%d.scr"
				(Format @temp2 298)
			)
		)
		(if (not (event claimed:))
		)
	)

	(method (replay &tmp temp0 temp1 temp2)
		(Platform 0 4 2 -1)
		(for
			((= temp1 (FirstNode (gTheIconBar elements:))))
			temp1
			((= temp1 temp2))
			
			(= temp2 (NextNode temp1))
			(= temp0 (NodeValue temp1))
			(if (& (temp0 signal:) $0004)
				(Platform 0 4 3 (temp0 iconIndex:))
			else
				(Platform 0 4 2 (temp0 iconIndex:))
			)
		)
		(if (IsObject (gTheIconBar curIcon:))
			(Platform 0 4 4 8 (gInventory indexOf: (gInventory curIcon:)))
		else
			(Platform 0 4 4 8 -1)
		)
		(SetPort 0 0 190 320 10 0)
		(if (== gCurRoomNum 32) ; wizGame
			(ClearFlag 359)
			(gGame setCursor: 942 1)
			(SetFlag 359)
		)
		(if (== gNight 1)
			(PalVary pvUNINIT)
			(PalVary pvINIT (gCurRoom picture:) 0)
		)
		(super replay:)
	)

	(method (restart &tmp temp0)
		(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
		(Platform 0 4 3 -1)
		(gTheIconBar hide:)
		(gGame setCursor: 999 1)
		(if
			(= temp0
				(Print
					font: gUserFont
					mode: 1
					width: 180
					addText: 15 0 5 1 0 0 999 ; "Are you sure you want to restart?"
					addButton: 1 15 0 5 2 55 15 999 ; "Restart"
					addButton: 0 15 0 5 3 40 35 999 ; "Don't Restart"
					init:
				)
			)
			(Platform 0 4 4 8 -1)
			(super restart: &rest)
		else
			(Platform 0 4 2 -1)
			(gGame setCursor: gNormalCursor)
		)
	)

	(method (pragmaFail)
		((ScriptID 121) doit:) ; pragFail
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global418 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance gcWin of GloryWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 15] [temp22 15])
		(= temp6 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			left: (/ (- 320 (+ 149 (CelWide 995 0 1))) 2)
			bottom:
				(+ (CelHigh 995 1 1) 6 (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2))
			right:
				(+
					149
					(CelWide 995 0 1)
					(/ (- 320 (+ 149 (CelWide 995 0 1))) 2)
				)
			priority: temp6
		)
		(super open:)
		(DrawCel 995 1 0 95 28 temp6)
		(DrawCel 995 1 0 131 28 temp6)
		(DrawCel 995 1 0 167 28 temp6)
		(DrawCel 995 0 4 64 (- 24 (+ (CelHigh 995 0 4) 3)) temp6)
		(DrawCel 995 0 3 100 (- 24 (+ (CelHigh 995 0 4) 3)) temp6)
		(DrawCel 995 0 2 136 (- 24 (+ (CelHigh 995 0 4) 3)) temp6)
		(= temp3 (+ (= temp0 (+ 34 (CelHigh 995 0 1))) 10))
		(= temp2
			(+
				(= temp1 (+ 4 (CelWide 995 1 1)))
				(- (+ 149 (CelWide 995 0 1)) (+ 4 (CelWide 995 1 1) 10))
			)
		)
		(= temp4 0)
		(= temp5 1)
		(Graph grFILL_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) temp5 temp4 temp6)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1)
		(Message msgGET 999 19 0 0 1 @temp7) ; "%d of %d"
		(Format @temp22 @temp7 gScore gPossibleScore)
		(DrawCel
			995
			0
			5
			(+ 4 (CelWide 995 1 1) 8)
			(+ 34 (CelHigh 995 0 1) 2)
			temp6
		)
		(Display
			@temp22
			dsFONT
			999
			dsCOLOR
			52
			dsCOORD
			(+ (CelWide 995 0 5) 4 (CelWide 995 1 1) 13)
			(+ 34 (CelHigh 995 0 1) 2 1)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 67
		nsTop 24
		signal 128
		noun 6
		modNum 999
		helpVerb 9
		sliderView 995
		bottomValue 1
		topValue 5
	)

	(method (doit param1)
		(if argc
			(gGame detailLevel: param1)
		)
		(gGame detailLevel:)
	)
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 103
		nsTop 24
		signal 128
		noun 14
		modNum 999
		helpVerb 9
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 139
		nsTop 24
		signal 128
		noun 13
		modNum 999
		helpVerb 9
		sliderView 995
		bottomValue 15
		topValue 1
	)

	(method (show)
		(if (not (User controls:))
			(= signal 132)
			(= sliderLoop 10)
		else
			(= sliderLoop 0)
			(= signal 128)
		)
		(super show: &rest)
	)

	(method (move)
		(if (User controls:)
			(super move: &rest)
		)
	)

	(method (mask))
)

(instance iconSave of ControlIcon
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 10
		signal 451
		noun 12
		modNum 999
		helpVerb 9
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 8
		nsTop 23
		message 10
		signal 451
		noun 11
		modNum 999
		helpVerb 9
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 8
		nsTop 40
		message 10
		signal 451
		noun 10
		modNum 999
		helpVerb 9
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 8
		nsTop 57
		message 10
		signal 451
		noun 9
		modNum 999
		helpVerb 9
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 8
		nsTop 74
		message 10
		signal 451
		noun 5
		modNum 999
		helpVerb 9
	)
)

(instance iconGCHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 8
		nsTop 91
		cursor 949
		message 9
		signal 387
		noun 7
		modNum 999
		helpVerb 9
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 8
		nsTop 108
		cursor 949
		message 10
		signal 451
		noun 8
		modNum 999
		helpVerb 9
	)
)

(instance hq1DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 [temp2 50] temp52)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if
			(or
				(and
					(User controls:)
					(or
						(== param1 81)
						(== param1 20)
						(== param1 16)
						(param2 facingMe: gEgo)
					)
				)
				(not (User controls:))
			)
			(switch param1
				(3
					((User curEvent:) claimed: 0)
				)
				(1
					(gMessager say: 15 0 0 5 0 999) ; "You've seen it before."
				)
				(2
					(gMessager say: 15 0 0 6 0 999) ; "You get no response."
				)
				(4
					(gMessager say: 15 0 0 7 0 999) ; "You can't do much with that."
				)
				(81
					(CastDart
						0
						0
						((= temp52 (Event new:)) x:)
						(+ (temp52 y:) 24)
					)
					(temp52 dispose:)
				)
				(else
					(if (= temp0 (gTheIconBar curInvIcon:))
						(switch (= temp1 (gInventory indexOf: temp0))
							(10
								(ThrowRock 0)
								(return 1)
							)
							(6
								(ThrowKnife 0)
							)
							(else
								(gMessager say: 15 0 0 8 0 999) ; "It doesn't work."
							)
						)
					)
				)
			)
		)
	)
)

(instance hq1FtrInit of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 40)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(cond
			((or (param1 x:) (param1 y:) (param1 z:)))
			((not (IsObject (= temp0 (param1 onMeCheck:))))
				(param1 x: (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
				(param1 y: (param1 nsTop:))
			)
			(else
				(= temp8 (= temp9 0))
				(= temp6 (= temp7 32767))
				(= temp2 (temp0 points:))
				(= temp1 0)
				(= temp3 (* 4 (temp0 size:)))
				(while (< temp1 temp3)
					(= temp4 (Memory memPEEK (+ temp2 temp1)))
					(= temp5 (Memory memPEEK (+ temp2 temp1 2)))
					(if (<= temp4 temp6)
						(= temp6 temp4)
					)
					(if (<= temp5 temp7)
						(= temp7 temp5)
					)
					(if (>= temp4 temp8)
						(= temp8 temp4)
					)
					(if (>= temp5 temp9)
						(= temp9 temp5)
					)
					(+= temp1 4)
				)
				(param1 x: (/ (+ temp6 temp8) 2))
				(param1 y: temp7)
			)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance mainIconBar of IconBar
	(properties)

	(method (init)
		(self
			add:
				iconLeft
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconActions
				iconCast
				iconUseIt
				iconInventory
				iconControlPanel
				iconHelp
				iconRight
			eachElementDo: #init
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			useIconItem: iconUseIt
			helpIconItem: iconHelp
			walkIconItem: iconWalk
			state: 3072
		)
		(iconHelp view: 990 loop: 9)
	)

	(method (show)
		(super show: &rest)
	)

	(method (handleEvent event)
		(if (> (gEgo z:) 900)
			(event claimed: 0)
		else
			(super handleEvent: event &rest)
		)
		(if (IsFlag 361)
			((ScriptID 206 1) init:) ; pageCode
		)
	)

	(method (swapCurIcon &tmp temp0)
		(cond
			((& state $0004)
				(return)
			)
			((and (!= curIcon iconWalk) (not (& (iconWalk signal:) $0004)))
				(= prevIcon curIcon)
				(= curIcon iconWalk)
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

(instance iconLeft of IconI
	(properties
		view 990
		loop 12
		cel 1
		cursor 996
		maskView 990
		maskLoop 12
		modNum 999
		iconIndex 0
	)

	(method (show)
		(super show: -5 0)
	)

	(method (select)
		(return 0)
	)
)

(instance iconRight of IconI
	(properties
		view 990
		loop 13
		cel 1
		cursor 996
		maskView 990
		maskLoop 13
		modNum 999
	)

	(method (select)
		(return 0)
	)
)

(instance iconWalk of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 940
		type 20480
		message 3
		signal 65
		maskView 990
		maskLoop 14
		noun 25
		modNum 999
		helpVerb 9
		iconIndex 1
	)

	(method (select)
		(return
			(if (super select: &rest)
				1
				(gTheIconBar curIcon: (gTheIconBar at: 1))
				(gGame
					setCursor:
						(switch gEgoGait
							(0 940) ; walking
							(1 937) ; running
							(2 947) ; sneaking
						)
				)
			else
				0
			)
		)
	)
)

(instance iconLook of IconI
	(properties
		view 990
		loop 1
		cel 0
		cursor 941
		message 1
		signal 65
		maskView 990
		maskLoop 14
		noun 18
		modNum 999
		helpVerb 9
		iconIndex 2
	)

	(method (select)
		(return
			(if (super select: &rest)
				1
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 941)
			else
				0
			)
		)
	)
)

(instance iconDo of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 942
		message 4
		signal 65
		maskView 990
		maskLoop 14
		noun 4
		modNum 999
		helpVerb 9
		iconIndex 3
	)

	(method (select)
		(return
			(if (super select: &rest)
				1
				(gTheIconBar curIcon: (gTheIconBar at: 3))
				(gGame setCursor: 942)
			else
				0
			)
		)
	)
)

(instance iconTalk of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 943
		message 2
		signal 65
		maskView 990
		maskLoop 14
		noun 23
		modNum 999
		helpVerb 9
		iconIndex 4
	)

	(method (select)
		(return
			(if (super select: &rest)
				1
				(gTheIconBar curIcon: (gTheIconBar at: 4))
				(gGame setCursor: 943)
			else
				0
			)
		)
	)
)

(instance iconActions of IconI
	(properties
		view 990
		loop 10
		cel 0
		cursor 999
		message 0
		signal 67
		maskView 990
		maskLoop 14
		noun 1
		modNum 999
		helpVerb 9
		iconIndex 5
	)

	(method (select)
		(if (super select: &rest)
			(proc814_30)
			(gTheIconBar hide:)
			((ScriptID 557) init: show:) ; actionBar
			(return 1)
		)
	)
)

(instance iconCast of IconI
	(properties
		view 990
		loop 11
		cel 0
		message 0
		signal 67
		maskView 990
		maskLoop 14
		noun 2
		modNum 999
		helpVerb 9
		iconIndex 6
	)

	(method (select)
		(if (super select: &rest)
			(if
				(OneOf
					gCurRoomNum
					300
					301
					302
					310
					311
					313
					314
					318
					320
					321
					322
					330
					331
					332
					333
					334
					340
				)
				(gTheIconBar hide:)
				(gMessager say: 20 0 0 0 0 999) ; "Your spells don't seem to work here."
				(return 1)
			else
				(Platform 0 4 3 -1)
				(if (!= ((gTheIconBar curIcon:) cursor:) 948)
					(proc814_30)
				)
				(gGame setCursor: 999)
				(gTheIconBar hide:)
				((ScriptID 558) init: showSelf:) ; glorySpells
				(return 1)
			)
		)
	)
)

(instance iconUseIt of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		signal 65
		maskView 990
		maskLoop 14
		maskCel 1
		noun 24
		modNum 999
		helpVerb 9
		iconIndex 7
	)

	(method (select)
		(if (super select:)
			(gTheIconBar curIcon: (gTheIconBar useIconItem:))
			(gGame setCursor: ((gTheIconBar useIconItem:) cursor:))
		)
	)
)

(instance iconInventory of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 990
		maskLoop 14
		noun 17
		modNum 999
		helpVerb 9
		iconIndex 8
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(Platform 0 4 3 -1)
			(gGame setCursor: 999)
			(gTheIconBar hide:)
			((ScriptID 206 1) init:) ; pageCode
			(return 1)
		)
	)
)

(instance iconControlPanel of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 9
		signal 67
		maskView 990
		maskLoop 14
		noun 3
		modNum 999
		helpVerb 9
		iconIndex 9
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(= temp0 ((gTheIconBar curIcon:) cursor:))
			(proc814_30)
			(gGame setCursor: 999)
			(Platform 0 4 3 -1)
			(gTheIconBar hide:)
			(gGameControls window: gcWin show:)
			(gGame setCursor: temp0)
		)
	)
)

(instance iconHelp of IconI
	(properties
		view 990
		loop 9
		cel 0
		cursor 949
		message 9
		signal 3
		maskView 990
		maskLoop 14
		noun 16
		modNum 999
		helpVerb 9
	)
)

(instance invCursor of Cursor ; UNUSED
	(properties
		view 950
	)
)

(instance qg1ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(10 16)
				(else -32768)
			)
		)
	)
)

