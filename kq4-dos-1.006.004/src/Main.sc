;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	KQ4 0
	smallBase 1
	NearControl 2
	LookAt 3
	timer1 4
	timer2 5
	timer3 6
	NormalEgo 7
	HandsOff 8
	HandsOn 9
	Notify 10
	proc0_11 11
	HaveMem 12
	NotClose 13
	AlreadyTook 14
	SeeNothing 15
	CantDo 16
	DontHave 17
	RedrawCast 18
	SoundLoops 19
	proc0_20 20
	cls 21
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
	gVersion = {newInvItem}
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
	gSysWindow
	; 60
	global60
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
	gNight
	gIndoors
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	global108
	gAct
	; 110
	global110
	global111
	global112
	gShovelCount
	global114
	; 115
	global115
	global116
	global117
	gMinstrelRoom
	gMinstrelActor
	; 120
	global120
	global121
	gDwarfEscortOut
	gUnicornState
	gUnicornRoom
	; 125
	gUnicornActor
	gTrollChasing
	gDeathFlag
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
	gSeenOgressDeerFlag
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
	gProp
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
	gRavenActor
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
	gIntroSc
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
)

(procedure (proc0_20 param1 &tmp temp0)
	(= temp0 (liteState state:))
	(if argc
		(liteState changeState: param1)
	)
	(return temp0)
)

(procedure (NearControl param1 param2)
	(if (< argc 2)
		(= param2 5)
	)
	(switch (param1 loop:)
		(0
			(OnControl
				CONTROL
				(param1 x:)
				(param1 y:)
				(+ (param1 x:) param2)
				(+ (param1 y:) 1)
			)
			(return)
		)
		(1
			(OnControl
				CONTROL
				(- (param1 x:) param2)
				(param1 y:)
				(param1 x:)
				(+ (param1 y:) 1)
			)
			(return)
		)
		(2
			(OnControl
				CONTROL
				(param1 x:)
				(param1 y:)
				(+ (param1 x:) 1)
				(+ (param1 y:) param2)
			)
			(return)
		)
		(3
			(OnControl
				CONTROL
				(param1 x:)
				(- (param1 y:) param2)
				(+ (param1 x:) 1)
				(param1 y:)
			)
			(return)
		)
	)
)

(procedure (LookAt param1 param2)
	(DirLoop param1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(if (== argc 3)
		(DirLoop
			param2
			(GetAngle (param2 x:) (param2 y:) (param1 x:) (param1 y:))
		)
	)
)

(procedure (NormalEgo param1 param2)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
		)
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Walk
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
	(User canControl: 1 canInput: 1)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= global204 1)
	(= global114 global189)
	(= global189 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gEgo setMotion: 0)
	(= global204 0)
	(= global189 global114)
)

(procedure (Notify param1 &tmp temp0)
	(= temp0 (ScriptID param1))
	(temp0 notify: &rest)
)

(procedure (proc0_11)
	(return (or (== (gEgo view:) 2) (== (gEgo view:) 4)))
)

(procedure (HaveMem param1)
	(return (> (MemoryInfo 0) param1)) ; LargestPtr
)

(procedure (NotClose)
	(Print 0 130) ; "You're not close enough."
)

(procedure (AlreadyTook)
	(Print 0 131) ; "You already took it."
)

(procedure (SeeNothing)
	(Print 0 132) ; "You see nothing special."
)

(procedure (CantDo)
	(Print 0 133) ; "You can't do that now."
)

(procedure (DontHave)
	(Print 0 134) ; "You don't have it."
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (SoundLoops param1 param2)
	(param1 loop: param2 changeState:)
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(class newInvItem of InvI
	(properties)

	(method (showSelf)
		(Print 0 0 #title name #icon view loop cel)
	)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 1 gScore gPossibleScore { KQ\n__The Perils of Rosella}) ; "Score: %d of %d %s"
	)
)

(instance ego of Ego
	(properties)
)

(instance getItemMusic of Sound
	(properties
		number 48
		priority 2
		owner -1
	)
)

(instance tweet of Sound
	(properties
		number 76
		priority -1
		owner -1
	)
)

(instance KQ4 of Game
	(properties)

	(method (init)
		(= gSysWindow SysWindow)
		(super init:)
		(= gEgo ego)
		(User alterEgo: gEgo)
		(= gAniThreshold 7)
		(= global221 0)
		(Inv
			add:
				Silver_Flute
				Diamond_Pouch
				Talisman
				Lantern__unlit_
				Pandora_s_Box
				Gold_Ball
				Witches__Glass_Eye
				Obsidian_Scarab
				Peacock_Feather
				Lute
				Small_Crown
				Frog
				Silver_Baby_Rattle
				Gold_Coins
				Cupid_s_Bow
				Shovel
				Axe
				Fishing_Pole
				Shakespeare_Book
				Worm
				Skeleton_Key
				Golden_Bridle
				Board
				Bone
				Dead_Fish
				Magic_Fruit
				Sheet_Music
				Silver_Whistle
				Locket
				Medal
				Toy_Horse
				Glass_Bottle
				Gold_Key
				Magic_Hen
				Rose
				Note
		)
		(= gShowStyle 0)
		(= gUserFont (= gBigFont 1))
		(= global169 1)
		(= gVersion {1.006.004})
		(liteState init: Lantern__unlit_)
		(TheMenuBar init:)
		(getItemMusic init:)
		(tweet init:)
		(= gMinstrelRoom (Random 1 3))
		(User canInput: 0 canControl: 0 echo: 32)
		(= global205 1)
		(SL code: statusCode)
		(= gPossibleScore 230)
		(= global116 1)
		(= global157 0)
		(= global105 0)
		(= global160 8)
		(gEgo view: 2 x: 100 y: 120)
		(if (GameIsRestarting)
			(TheMenuBar draw:)
			(SL enable:)
			(self newRoom: 99)
			(= gUserFont gBigFont)
		else
			(self newRoom: 701) ; copyProtect
		)
	)

	(method (replay)
		(= gUserFont gBigFont)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu 1283 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(super replay:)
	)

	(method (doit)
		(cond
			((and global224 (!= global221 2))
				(= global221 2)
				(self setCursor: 666 (HaveMouse))
			)
			((and (== global221 2) (not global224))
				(self setCursor: gNormalCursor (HaveMouse))
				(= global221 0)
			)
			((and (== (User controls:) 0) (== global221 0))
				(= global221 1)
				(self setCursor: gWaitCursor 1)
			)
			((and (== global221 1) (== (User controls:) 1))
				(self setCursor: gNormalCursor (HaveMouse))
				(= global221 0)
			)
		)
		(if gDeathFlag
			(gSounds eachElementDo: #dispose)
			((Sound new:) number: 49 play:)
			(self setCursor: gNormalCursor (HaveMouse))
			(if (HaveMem 800)
				(repeat
					(switch
						(Print ; "Thank you for playing King's Quest IV, `The Perils of Rosella.' Next time... be more careful!"
							0
							2
							#icon
							100
							0
							0
							#mode
							1
							#title
							{Roberta says:}
							#button
							{__Restore__}
							1
							#button
							{__Restart__}
							2
							#button
							{___Quit___}
							3
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart:)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			else
				(Print 0 3) ; "Press [ENTER] to restart your game. After restarting, you may restore your game."
				(gGame restart:)
			)
		else
			(if global182
				(= global182 0)
				(getItemMusic play:)
			)
			(if (!= (= global156 (GetTime 1)) global157) ; SysTime12
				(= global157 global156)
				(if (>= (+= global158 4) 60)
					(++ global159)
					(-= global158 60)
					(if (and (== global160 31) (== global159 59))
						(gCurRoom setScript: (ScriptID 302 0)) ; timeOut
					)
					(if (and (== global160 20) (== (mod global159 15) 0))
						(Print 0 4) ; "It's getting late, Rosella. It will be dark soon."
					)
					(if (== global159 60)
						(++ global160)
						(= global159 0)
					)
				)
			)
		)
		(super doit:)
	)

	(method (wordFail param1)
		(Print (Format @global228 0 5 param1)) ; "This game does not understand "%s.""
	)

	(method (syntaxFail)
		(Print 0 6) ; "Try that one again. I couldn't make much sense of it."
	)

	(method (pragmaFail)
		(switch (Random 1 3)
			(1
				(Print 0 7) ; "That is not understood."
			)
			(2
				(Print 0 8) ; "That is not clear."
			)
			(3
				(Print 0 9) ; "Try another way to say that."
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (or global204 (and (not global205) (== (User canControl:) 0)))
			(return)
		)
		(if
			(and
				(== gNight 0)
				(== gIndoors 0)
				(not (< 30 newRoomNumber 77))
				(< newRoomNumber 300)
				(or
					(< 20 global160 30)
					(and
						(>= gAct 3)
						(gEgo has: 7) ; Obsidian_Scarab
						(gEgo has: 25) ; Magic_Fruit
						(< global160 30)
					)
				)
			)
			(= gNight 1)
			(= global188 newRoomNumber)
			(if (< global160 21)
				(= global160 21)
				(= global159 0)
			)
			(= newRoomNumber 697)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp temp0)
		(if (and global216 (HaveMem 1200))
			(= global216 0)
			((= global202 (ScriptID 801)) init:) ; DebugMenu
		)
		(DisposeScript 985)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(= temp0
				(switch roomNum
					(68 603)
					(120 520) ; intro
					(54 601)
					(49 602)
					(92 604)
					(71 605)
					(73 605)
					(55 600)
					(else 0)
				)
			)
			((ScriptID temp0) init:)
		)
		(super startRoom: roomNum)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 50])
		(if (and global215 (not (event claimed:)) (== (event type:) evMOUSEBUTTON))
			(cond
				((& (event modifiers:) emSHIFT)
					(event claimed: 1)
					(= temp2
						(Print
							(Format @temp4 0 10 (event x:) (event y:)) ; "%d/%d"
							#at
							150
							100
							#font
							999
							#dispose
						)
					)
					(while (!= evMOUSERELEASE ((= temp3 (Event new:)) type:))
						(temp3 dispose:)
					)
					(temp2 dispose:)
					(temp3 dispose:)
				)
				((& (event modifiers:) emCTRL)
					(event claimed: 1)
					(while (!= evMOUSERELEASE ((= temp3 (Event new:)) type:))
						((User alterEgo:)
							posn: (temp3 x:) (- (temp3 y:) 10)
							setMotion: 0
						)
						(Animate (gCast elements:) 0)
						(temp3 dispose:)
					)
					(temp3 dispose:)
				)
				((& (event modifiers:) emALT)
					(event claimed: 1)
					((User alterEgo:) showSelf:)
				)
			)
			(if (event claimed:)
				(return 1)
			)
		)
		(if (== gCurRoomNum gNewRoomNum)
			(super handleEvent: event)
		)
		(if (== (event type:) evSAID)
			(if (Said 'get/mem')
				(gGame showMem:)
			)
			(if global215
				(cond
					((Said 'enter/night')
						(= gSeenOgressDeerFlag 1)
						(= gAct 3)
						(= global131 1)
						(gEgo get: 3) ; Lantern__unlit
						(gEgo get: 16) ; Axe
						(gEgo get: 15) ; Shovel
						(gEgo get: 25) ; Magic_Fruit
						(gEgo get: 14) ; Cupid_s_Bow
						(= gNight 1)
						((Inv at: 14) loop: 1 cel: 0) ; Cupid_s_Bow
						(= global169 1)
						(= global160 21)
						(= global159 1)
						(= global110 5)
						(= gMinstrelRoom -1)
						(= gUnicornState 99)
						(= gUnicornRoom 99)
						(Print 0 11) ; "Night falls..."
					)
					((Said 'tp')
						(= global228 0)
						(Print {TP to:} #at -1 20 #edit @global228 6)
						(= gNewRoomNum (ReadNumber @global228))
					)
				)
			)
			(cond
				((or (Said 'fuck') (Said '/fuck') (Said '//fuck'))
					(Print 0 12) ; "Perhaps you need to purchase a copy of "Leisure Suit Larry?""
				)
				((Said 'blow/whistle')
					(if (gEgo has: 27) ; Silver_Whistle
						(tweet play:)
						(Print 0 13) ; "Tweeeeeeeeeet!"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((or (Said 'open,(look<in)/bottle') (Said 'get/letter'))
					(cond
						((gEgo has: 35) ; Note
							(Print 0 14) ; "You already have the note."
						)
						((gEgo has: 31) ; Glass_Bottle
							(Print 0 15) ; "You open the glass bottle and retrieve the imprisoned note."
							((Inv at: 31) cel: 0) ; Glass_Bottle
							(= global182 1)
							(gEgo get: 35) ; Note
						)
						(else
							(DontHave) ; "You don't have it."
						)
					)
				)
				((Said 'drink/bottle')
					(if (gEgo has: 31) ; Glass_Bottle
						(Print 0 16) ; "That would not accomplish anything."
					else
						(DontHave) ; "You don't have it."
					)
				)
				(
					(or
						(Said 'break,hit,cut/branch,forest,arm,branch')
						(Said 'swing,wave/ax')
					)
					(if (gEgo has: 16) ; Axe
						(Print 0 17) ; "Not here."
					else
						(CantDo) ; "You can't do that now."
					)
				)
				((and (gEgo has: 16) (Said 'cut,hit')) ; Axe
					(Print 0 18) ; "You have better things to do than that!"
				)
				(
					(or
						(Said 'detach,(get<off)/dress')
						(Said 'undress')
						(Said 'get/undressed')
					)
					(Print 0 19) ; "Not in front of the game players!"
				)
				((Said 'play,bounce/ball')
					(if (gEgo has: 5) ; Gold_Ball
						(Print 0 20) ; "The golden ball is too heavy to play with."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'dig')
					(if (gEgo has: 15) ; Shovel
						(Print 0 17) ; "Not here."
					else
						(Print 0 21) ; "Using what?"
					)
				)
				((Said 'launch')
					(cond
						((not (gEgo has: 14)) ; Cupid_s_Bow
							(Print 0 22) ; "You don't have anything to shoot."
						)
						((>= ((Inv at: 14) loop:) 2) ; Cupid_s_Bow
							(Print 0 23) ; "You have no arrows."
						)
						((and (not global189) (proc0_11) (HaveMem 850))
							(= global164 (gEgo script:))
							(gEgo setScript: (ScriptID 305 0)) ; shootBow
						)
						(else
							(CantDo) ; "You can't do that now."
						)
					)
				)
				((Said 'polish>')
					(cond
						((not (= temp1 (gInventory saidMe:)))
							(if (Said '/me')
								(Print 0 24) ; "Ahhh. You feel better now."
							else
								(Print 0 25) ; "There's no need to rub that."
							)
						)
						((not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						)
						(else
							(switch (gInventory indexOf: temp1)
								(2
									(Print 0 26) ; "Ok. You rub the magic talisman. Nothing happens."
								)
								(3
									(Print 0 27) ; "Ok. You rub the lantern. Nothing happens."
								)
								(6
									(Print 0 28) ; "Ok. You rub the glass eye. Nothing happens."
								)
								(7
									(Print 0 29) ; "Ok. You rub the charm. Nothing happens."
								)
								(else
									(Print 0 30) ; "Why would you want to rub a thing like that?"
								)
							)
						)
					)
					(event claimed: 1)
				)
				((Said 'kiss>')
					(= temp1 (gInventory saidMe:))
					(event claimed: 1)
					(cond
						((not temp1)
							(Print 0 31) ; "Why would you want to kiss a thing like that?"
						)
						((not (gEgo has: (gInventory indexOf: temp1)))
							(Print 0 32) ; "Your pucker isn't working right now."
						)
						((== (gInventory indexOf: temp1) 2)
							(Print 0 33) ; "Ok. You kiss the magic talisman, but nothing happens."
						)
						(else
							(Print 0 31) ; "Why would you want to kiss a thing like that?"
						)
					)
				)
				((Said 'wish>')
					(cond
						((not (= temp1 (gInventory saidMe:)))
							(Print 0 34) ; "That wouldn't accomplish anything."
						)
						((not (gEgo has: (gInventory indexOf: temp1)))
							(CantDo) ; "You can't do that now."
						)
						((== (gInventory indexOf: temp1) 2)
							(Print 0 35) ; "Ok. You wish as hard as you can, but nothing happens."
						)
						(else
							(Print 0 36) ; "Why would you want to wish on a thing like that?"
						)
					)
					(event claimed: 1)
				)
				((or (Said 'bait/hook,pole') (Said 'place/earthworm/hook,pole'))
					(if (and (gEgo has: 19) (gEgo has: 17)) ; Worm, Fishing_Pole
						(Print 0 37) ; "Scrunching up your delicate nose, you gingerly bait the hook of the fishing pole with the large earthworm."
						((Inv at: 19) moveTo: 666) ; Worm
						((Inv at: 17) loop: 1) ; Fishing_Pole
						(gGame changeScore: 1)
					else
						(Print 0 38) ; "With what?"
					)
				)
				(
					(and
						(gEgo has: 24) ; Dead_Fish
						(Said '/fish>')
						(cond
							((Said 'smell')
								(Print 0 39) ; "PHEW!!"
								1
							)
							((Said 'eat')
								(Print 0 40) ; "Yuck!!"
								1
							)
						)
					)
					1
				)
				((Said 'eat/earthworm')
					(if (gEgo has: 19) ; Worm
						(Print 0 41) ; "That's disgusting!"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'eat/bone')
					(if (gEgo has: 23) ; Bone
						(Print 0 42) ; "You don't want to do that!"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'eat/fruit')
					(if (gEgo has: 25) ; Magic_Fruit
						(Print 0 43) ; "You take a bite of the luscious-looking fruit. Mmmmm! Delicious! Before you know it, you have eaten the whole thing. Wow! A feeling of vigor and vitality courses through your body, giving you boundless energy and that wonderful glow of good health."
						(gEgo put: 25 999) ; Magic_Fruit
						(gGame changeScore: -10)
					else
						(DontHave) ; "You don't have it."
					)
				)
				((and (gEgo has: 28) (Said 'wear,(place<on)/locket')) ; Locket
					(Print 0 44) ; "Fine. You wear the locket."
				)
				((and (gEgo has: 29) (Said 'wear,(place<on)/badge')) ; Medal
					(Print 0 45) ; "Ok. You wear the Medal of Honor."
				)
				((Said 'wear,(place<on)/amulet')
					(if (gEgo has: 2) ; Talisman
						(Print 0 46) ; "Ok."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'wear,(place<on)/crown')
					(cond
						((not (gEgo has: 10)) ; Small_Crown
							(DontHave) ; "You don't have it."
						)
						(global189
							(Print 0 47) ; "That's not a good idea now."
						)
						((and (HaveMem 1400) (proc0_11))
							(= global164 (gEgo script:))
							(gEgo setScript: (ScriptID 301 0)) ; wearCrown
						)
						(else
							(CantDo) ; "You can't do that now."
						)
					)
				)
				((Said 'read/letter')
					(cond
						((not (gEgo has: 35)) ; Note
							(DontHave) ; "You don't have it."
						)
						((HaveMem 2000)
							((ScriptID 306 1) cue:) ; readNote
						)
						(else
							(CantDo) ; "You can't do that now."
						)
					)
				)
				((Said 'play/flute')
					(cond
						((not (gEgo has: 0)) ; Silver_Flute
							(DontHave) ; "You don't have it."
						)
						(global189
							(Print 0 48) ; "That wouldn't be a good idea right now."
						)
						((and (proc0_11) (HaveMem 800))
							(= global164 (gEgo script:))
							(gEgo setScript: (ScriptID 304 0)) ; playFlute
						)
						(else
							(CantDo) ; "You can't do that now."
						)
					)
				)
				((Said 'play/lute')
					(cond
						((not (gEgo has: 9)) ; Lute
							(DontHave) ; "You don't have it."
						)
						(global189
							(CantDo) ; "You can't do that now."
						)
						((and (proc0_11) (HaveMem 800))
							(= global164 (gEgo script:))
							(gEgo setScript: (ScriptID 303 0)) ; playIt
						)
						(else
							(CantDo) ; "You can't do that now."
						)
					)
				)
				((Said 'play,shake/rattle')
					(if (gEgo has: 12) ; Silver_Baby_Rattle
						(Print 0 49) ; "Ok. You playfully shake the silver baby rattle. Actually, you feel a little silly doing this."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'unlatch/door')
					(if (or (gEgo has: 20) (gEgo has: 32)) ; Skeleton_Key, Gold_Key
						(Print 0 50) ; "You do not have the right key to unlock this door."
					else
						(Print 0 51) ; "You don't have any keys!"
					)
				)
				(
					(and
						(Said '/music>')
						(cond
							((Said 'read,open')
								(if (gEgo has: 26) ; Sheet_Music
									(Print 0 52) ; "You can barely make out the old song written on the sheet music."
								else
									(DontHave) ; "You don't have it."
								)
								1
							)
							((Said 'play')
								(Print 0 53) ; "This is strictly organ music."
								1
							)
						)
					)
					1
				)
				((and (gEgo has: 30) (Said 'play/horse')) ; Toy_Horse
					(Print 0 54) ; "Ok. You play with the toy horse."
					(Print 0 55) ; "Now don't you feel silly?"
				)
				(
					(and
						(Said '/book>')
						(cond
							((Said 'close')
								(cond
									((not (gEgo has: 18)) ; Shakespeare_Book
										(Print 0 56) ; "What book?"
									)
									(global154
										(Print 0 46) ; "Ok."
										(= global154 0)
									)
									(else
										(Print 0 57) ; "The book isn't open."
									)
								)
								1
							)
							((Said 'read')
								(cond
									((not (gEgo has: 18)) ; Shakespeare_Book
										(Print 0 58) ; "You don't have any books to read."
									)
									((HaveMem 2000)
										((ScriptID 306 0) ; readBook
											changeState: (Random 1 30)
										)
									)
									(else
										(CantDo) ; "You can't do that now."
									)
								)
								1
							)
							(else 0)
						)
					)
					1
				)
				((Said 'smell/rose')
					(if (gEgo has: 34) ; Rose
						(Print 0 59) ; "You take a good whiff of the rose. Mmmmm! What a wonderful fragrance!"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'get,detach/thorn')
					(if (gEgo has: 34) ; Rose
						(Print 0 60) ; "The rose thorns will do you no good."
					else
						(DontHave) ; "You don't have it."
					)
				)
				(
					(or
						(Said 'lay[/!*]')
						(Said 'lay,get,rob/egg')
						(Said 'command/chicken')
					)
					(if (gEgo has: 33) ; Magic_Hen
						(Print 0 61) ; "Not now! Only one golden egg per day."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'talk/chicken')
					(if (gEgo has: 33) ; Magic_Hen
						(Print 0 62 #title {Magic Hen} #icon 431 0 0) ; "Cluck, cluck."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'eat/chicken')
					(if (gEgo has: 33) ; Magic_Hen
						(Print 0 63) ; "Come on! Be serious! This hen lays golden eggs!"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'eat')
					(Print 0 64) ; "That would not taste good."
				)
				(
					(and
						(Said '/chandelier,lantern[<oil]>')
						(cond
							((Said 'light,ignite,(turn<on)')
								(cond
									((not (gEgo has: 3)) ; Lantern__unlit
										(Print 0 65) ; "It helps if you have a lantern to ignite..."
									)
									((proc0_20)
										(Print 0 66) ; "The lantern is already lit."
									)
									((proc0_11)
										(proc0_20 1)
									)
									(else
										(Print 0 67) ; "This wouldn't be a good time to do that."
									)
								)
								1
							)
							((Said 'extinguish,(turn<off)')
								(if (gEgo has: 3) ; Lantern__unlit
									(if (proc0_20)
										(proc0_20 0)
									else
										(Print 0 68) ; "The lantern is already extinguished."
									)
								)
								1
							)
						)
					)
					1
				)
				(
					(and
						(gEgo has: 6) ; Witches__Glass_Eye
						(Said '/eye>')
						(cond
							((Said 'look<through,in')
								(Print 0 69) ; "You attempt to look through the glass eye, but it doesn't help you at all."
								1
							)
							((Said 'break')
								(Print 0 70) ; "That is probably not a good idea."
								1
							)
						)
					)
					1
				)
				((and (gEgo has: 7) (Said 'wear,place/charm')) ; Obsidian_Scarab
					(Print 0 71) ; "You can't wear the scarab. Just carry it with you."
				)
				((Said 'hop')
					(Print 0 34) ; "That wouldn't accomplish anything."
				)
				((Said 'kill')
					(Print 0 72) ; "You are NOT a murderous girl, Rosella!"
				)
				((Said 'rob')
					(Print 0 73) ; "You are NOT a thievish girl, Rosella!"
				)
				((Said 'hit')
					(Print 0 74) ; "You are NOT a violent girl, Rosella!"
				)
				((Said 'climb')
					(Print 0 75) ; "It's difficult to climb while wearing that dress!"
				)
				((Said 'laugh')
					(Print 0 76) ; "This is not a humorous game, Rosella!"
				)
				((Said 'throw')
					(Print 0 16) ; "That would not accomplish anything."
				)
				((Said 'talk')
					(switch (Random 1 2)
						(1
							(Print 0 77) ; "Who would listen?"
						)
						(2
							(Print 0 78) ; "There's no one nearby."
						)
					)
				)
				((Said 'close/door')
					(Print 0 79) ; "You don't need to."
				)
				((Said 'listen')
					(Print 0 80) ; "You listen intently."
				)
				((Said 'sit')
					(Print 0 81) ; "You don't have time for that."
				)
				((Said 'smell')
					(Print 0 82) ; "Sniff, sniff."
				)
				((Said 'open,(look<in)>')
					(= temp1 (gInventory saidMe:))
					(cond
						((Said '[/!*]')
							(Print 0 83) ; "What do you want to inspect?"
						)
						((not temp1)
							(event claimed: 1)
							(CantDo) ; "You can't do that now."
						)
						((not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						)
						(else
							(switch (gInventory indexOf: temp1)
								(1
									(Print 0 84 #icon 401 0 0) ; "You open the diamond pouch and look inside. Many diamonds flash and sparkle from within. Carefully, you close it again so as not to lose any."
								)
								(3
									(Print 0 85) ; "There's no need to do that."
								)
								(12
									(Print 0 86) ; "There is no reason to open the silver rattle."
								)
								(13
									(Print 0 87) ; "You open the bag, look inside, and see many shiny gold coins. You close the bag so as not to loose any."
								)
								(28
									(Print 0 88) ; "Opening the locket reveals the handsome face of a dashing young man."
								)
								(4
									(if
										(or
											(and
												(!= (gEgo view:) 2)
												(!= (gEgo view:) 4)
											)
											(< (MemoryInfo 1) 4500) ; FreeHeap
											global189
										)
										(Print 0 89) ; "This would not be the appropriate time or place!"
									else
										(gEgo loop: 0)
										(if
											(&
												(= global168
													(NearControl gEgo 30)
												)
												$8000
											)
											(Print 0 90) ; "Try another spot"
										else
											(gEgo
												setScript: (ScriptID 307 0) ; openPbox
											)
										)
									)
								)
								(18
									(Print 0 91) ; "You open the Shakespeare book and thumb through its pages. Contained within it, are all the wonderful plays of the playwright, William Shakespeare."
									(= global154 1)
								)
								(else
									(Print 0 92) ; "You can't open that."
								)
							)
						)
					)
					(event claimed: 1)
				)
				((Said 'look>')
					(cond
						((Said '/me')
							(Print 0 93) ; "You see a poor, but beautiful, peasant girl."
						)
						((Said '/letter')
							(cond
								((gEgo has: 35) ; Note
									(Print 0 94 #icon 435 0 0) ; "Gee! There seems to be writing on the note!"
								)
								((gEgo has: 31) ; Glass_Bottle
									(Print 0 95) ; "The note is inside the glass bottle."
								)
								(else
									(DontHave) ; "You don't have it."
								)
							)
						)
						((Said '/key')
							(event claimed: 0)
							(cond
								((Said '/*<gold')
									(if (gEgo has: 32) ; Gold_Key
										((Inv at: 32) showSelf:) ; Gold_Key
									else
										(Print 0 96) ; "You don't have that."
									)
								)
								((Said '/*<skeleton')
									(if (gEgo has: 20) ; Skeleton_Key
										((Inv at: 20) showSelf:) ; Skeleton_Key
									else
										(Print 0 96) ; "You don't have that."
									)
								)
								((Said '/*[<!*]')
									(cond
										(
											(and
												(gEgo has: 20) ; Skeleton_Key
												(gEgo has: 32) ; Gold_Key
											)
											(Print 0 97) ; "Please be more specific about which key you mean."
										)
										((gEgo has: 20) ; Skeleton_Key
											((Inv at: 20) showSelf:) ; Skeleton_Key
										)
										((gEgo has: 32) ; Gold_Key
											((Inv at: 32) showSelf:) ; Gold_Key
										)
										(else
											(Print 0 98) ; "You don't have any keys."
										)
									)
								)
							)
						)
						((Said '/moon,moon')
							(cond
								(gIndoors
									(Print 0 99) ; "It's difficult when you're inside."
								)
								(gNight
									(Print 0 100) ; "It's a beautiful night."
								)
								(else
									(Print 0 100) ; "It's a beautiful night."
								)
							)
						)
						((Said '/cloud')
							(cond
								(gIndoors
									(Print 0 101) ; "How could you do that now?"
								)
								(gNight
									(Print 0 102) ; "You can't see any clouds now."
								)
								(else
									(Print 0 103) ; "Billowy clouds float serenely in the blue sky."
								)
							)
						)
						((Said '/wall')
							(Print 0 104) ; "There are no walls here."
						)
						((Said '<in/bottle')
							(cond
								((not (gEgo has: 31)) ; Glass_Bottle
									(CantDo) ; "You can't do that now."
								)
								((gEgo has: 35) ; Note
									(Print 0 105) ; "The bottle is empty."
								)
								(else
									(Print 0 106) ; "There is a note in the bottle!"
								)
							)
						)
						((or (Said '/dirt,dirt') (Said '<down'))
							(Print 0 107) ; "You see nothing of importance."
						)
						((or (Said '<up') (Said '/sky'))
							(cond
								(gIndoors
									(Print 0 108) ; "You look up, but see nothing special."
								)
								(gNight
									(Print 0 109) ; "It's easy to see by the light of a full moon."
								)
								(else
									(Print 0 110) ; "The sky is nice and blue."
								)
							)
						)
						(
							(and
								(gEgo has: 17) ; Fishing_Pole
								(== ((Inv at: 17) loop:) 1) ; Fishing_Pole
								(Said '/earthworm')
							)
							(Print 0 111) ; "The worm is baited on the fishing pole."
						)
						((= temp1 (gInventory saidMe:))
							(if (gEgo has: (gInventory indexOf: temp1))
								(temp1 showSelf:)
							else
								(DontHave) ; "You don't have it."
							)
						)
						(
							(or
								(Said
									'/troll,bard,dwarf,pan,giant,goon,person,man'
								)
								(Said
									'/hag,woman,fairies,genesta,lolotte,giantess,woman'
								)
								(Said '/unicorn,bird,bulldog,fisherman,whale')
							)
							(Print 0 112) ; "You don't see anyone."
						)
						(else
							(Print 800 4) ; "You see nothing special."
							(event claimed: 1)
						)
					)
				)
				((Said 'use>')
					(cond
						((not (= temp1 (gInventory saidMe:)))
							(Print 0 113) ; "You can't use that here right now!"
						)
						((not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						)
						(else
							(Print (Format @global228 0 114 (temp1 name:))) ; "What do you want to do with the %s?"
						)
					)
					(event claimed: 1)
				)
				((Said 'give>')
					(cond
						((Said '/*[/!*]')
							(Print 0 115) ; "To whom?"
						)
						((Said '[/!*]')
							(Print 0 116) ; "What do you want to give?"
						)
						((= temp1 (gInventory saidMe:))
							(if (not (gEgo has: (gInventory indexOf: temp1)))
								(DontHave) ; "You don't have it."
							else
								(Print 0 117) ; "You have no reason to do that."
							)
						)
						(else
							(Print 0 118) ; "It's not yours to give."
							(event claimed: 1)
						)
					)
				)
				((Said 'get>')
					(cond
						((Said '/water')
							(Print 0 119) ; "You don't need to carry water."
						)
						((Said '[/!*]')
							(Print 0 120) ; "What do you want to get?"
						)
						((not (= temp1 (gInventory saidMe:)))
							(event claimed: 1)
							(Print 0 121) ; "You can't get that."
						)
						((gEgo has: (gInventory indexOf: temp1))
							(switch (gInventory indexOf: temp1)
								(1
									(AlreadyTook) ; "You already took it."
								)
								(13
									(Print 0 122) ; "You already have the gold coins."
								)
								(else
									(Print 800 0) ; "You already took it."
								)
							)
						)
						(else
							(switch (gInventory indexOf: temp1)
								(3
									(Print 0 123) ; "It belongs to the dwarfs."
								)
								(else
									(Print 0 124) ; "You'll have to take a different approach."
								)
							)
						)
					)
				)
				((and (Said 'show>') (= temp1 (gInventory saidMe:)))
					(if (gEgo has: (gInventory indexOf: temp1))
						(Print 0 125) ; "Could it be a gift?"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'overtime/nosleep')
					(= global215 1)
					(= global216 1)
					(SeeNothing) ; "You see nothing special."
				)
				(
					(and
						(= temp1 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
							1
						else
							(CantDo) ; "You can't do that now."
							1
						)
					)
					1
				)
			)
		)
	)
)

(instance Silver_Flute of newInvItem
	(properties
		name {Silver Flute}
		said '/flute'
		owner 201
		view 413
	)
)

(instance Diamond_Pouch of newInvItem
	(properties
		name {Diamond Pouch}
		said '/(pouch[<diamond]),diamond'
		view 401
	)
)

(instance Talisman of newInvItem
	(properties
		said '/amulet,amulet'
		owner 82
		view 411
	)
)

(instance Lantern__unlit_ of newInvItem
	(properties
		name {Lantern (unlit)}
		said '/lantern,chandelier'
		owner 56
		view 428
	)
)

(instance Pandora_s_Box of newInvItem
	(properties
		name {Pandora's Box}
		said '/box'
		owner 69
		view 425
	)
)

(instance Gold_Ball of newInvItem
	(properties
		name {Gold Ball}
		said '/ball'
		owner 21
		view 400
	)
)

(instance Witches__Glass_Eye of newInvItem
	(properties
		name {Witches' Glass Eye}
		said '/eye'
		owner 57
		view 423
	)
)

(instance Obsidian_Scarab of newInvItem
	(properties
		name {Obsidian Scarab}
		said '/charm'
		owner 57
		view 403
	)
)

(instance Peacock_Feather of newInvItem
	(properties
		name {Peacock Feather}
		said '/feather'
		owner 888
		view 429
	)
)

(instance Lute of newInvItem
	(properties
		said '/lute'
		owner 203
		view 414
	)
)

(instance Small_Crown of newInvItem
	(properties
		name {Small Crown}
		said '/crown'
		owner 200
		view 402
	)
)

(instance Frog of newInvItem
	(properties
		said '/frog'
		owner 15
		view 432
	)
)

(instance Silver_Baby_Rattle of newInvItem
	(properties
		name {Silver Baby Rattle}
		said '/rattle'
		owner 88
		view 405
	)
)

(instance Gold_Coins of newInvItem
	(properties
		name {Gold Coins}
		said '/gold,(bag[<gold]),(bag[<gold,bag])'
		owner 88
		view 406
	)
)

(instance Cupid_s_Bow of newInvItem
	(properties
		name {Cupid's Bow}
		said '/arrow[<cupid]'
		owner 202
		view 415
	)
)

(instance Shovel of newInvItem
	(properties
		said '/shovel'
		owner 66
		view 420
	)

	(method (ownedBy param1)
		(if loop
			(= name {Broken Shovel})
		else
			(= name {Shovel})
		)
		(super ownedBy: param1)
	)

	(method (showSelf)
		(Print
			0
			0
			#title
			(if (self loop:) {Broken Shovel} else {Shovel})
			#icon
			view
			loop
			cel
		)
	)
)

(instance Axe of newInvItem
	(properties
		said '/ax'
		owner 48
		view 418
	)
)

(instance Fishing_Pole of newInvItem
	(properties
		name {Fishing Pole}
		said '/pole[<fish]'
		owner 204
		view 421
	)

	(method (ownedBy param1)
		(if loop
			(= name {Baited Fishing Pole})
		else
			(= name {Fishing Pole})
		)
		(super ownedBy: param1)
	)

	(method (showSelf)
		(Print
			0
			0
			#title
			(if (self loop:) {Baited Fishing Pole} else {Fishing Pole})
			#icon
			view
			loop
			cel
		)
	)
)

(instance Shakespeare_Book of newInvItem
	(properties
		name {Shakespeare Book}
		said '/book[<shakespeare]'
		owner 67
		view 416
	)
)

(instance Worm of newInvItem
	(properties
		said '/earthworm'
		owner 206
		view 433
	)
)

(instance Skeleton_Key of newInvItem
	(properties
		name {Skeleton Key}
		said '/key<skeleton'
		owner 58
		view 424
	)
)

(instance Golden_Bridle of newInvItem
	(properties
		name {Golden Bridle}
		said '/bit'
		owner 43
		view 426
	)
)

(instance Board of newInvItem
	(properties
		said '/board'
		owner 70
		view 430
	)
)

(instance Bone of newInvItem
	(properties
		said '/bone'
		owner 71
		view 419
	)
)

(instance Dead_Fish of newInvItem
	(properties
		name {Dead Fish}
		said '/fish[<dead]'
		owner 95
		view 422
	)
)

(instance Magic_Fruit of newInvItem
	(properties
		name {Magic Fruit}
		said '/fruit'
		owner 78
		view 412
	)
)

(instance Sheet_Music of newInvItem
	(properties
		name {Sheet Music}
		said '/music'
		owner 63
		view 417
	)
)

(instance Silver_Whistle of newInvItem
	(properties
		name {Silver Whistle}
		said '/whistle'
		owner 207
		view 427
	)
)

(instance Locket of newInvItem
	(properties
		said '/locket'
		owner 88
		view 404
	)
)

(instance Medal of newInvItem
	(properties
		said '/badge'
		owner 88
		view 407
	)
)

(instance Toy_Horse of newInvItem
	(properties
		name {Toy Horse}
		said '/toy,(horse[<toy])'
		owner 88
		view 408
	)
)

(instance Glass_Bottle of newInvItem
	(properties
		name {Glass Bottle}
		said '/bottle'
		owner 44
		view 434
		cel 1
	)
)

(instance Gold_Key of newInvItem
	(properties
		name {Gold Key}
		said '/key<gold'
		owner 83
		view 410
	)
)

(instance Magic_Hen of newInvItem
	(properties
		name {Magic Hen}
		said '/chicken'
		owner 48
		view 431
	)
)

(instance Rose of newInvItem
	(properties
		said '/rose'
		description {What a beautiful red rose! What's this?! Why, there is a little gold key attached to this rose!}
		owner 85
		view 409
	)

	(method (showSelf)
		(if loop
			(Print 0 126 #icon view loop cel) ; "What a beautiful red rose!"
		else
			(Print 0 127 #icon view loop cel) ; "What a beautiful red rose! What's this?! Why, there is a little gold key attached to this rose!"
		)
	)
)

(instance Note of newInvItem
	(properties
		said '/letter'
		owner 999
		view 435
	)
)

(instance liteState of Script
	(properties
		state 0
	)

	(method (init param1)
		(= client param1)
		(client script: self)
	)

	(method (changeState newState)
		(if (!= state newState)
			(switch (= state newState)
				(0
					(Print 0 128) ; "You extinguish the oil lantern."
					(client
						description:
							{The lantern is off.\nThe oil lantern looks well-used.}
						name: {Lantern (unlit)}
						loop: 0
					)
				)
				(1
					(Print 0 129) ; "Using a flint attached to the oil lantern, you light it. The lantern burns with a bright glow."
					(client
						description:
							{The lantern is on.\nThe oil lantern looks well-used.}
						name: {Lantern (lit)}
						loop: 1
					)
				)
			)
		)
	)
)

(instance smallBase of Code
	(properties)

	(method (doit param1)
		(param1 brTop: (- (param1 y:) (param1 yStep:)))
		(param1 brLeft: (- (param1 x:) (/ (param1 xStep:) 2)))
		(param1 brBottom: (param1 y:))
		(param1 brRight: (+ (param1 x:) (/ (param1 xStep:) 2)))
	)
)

(instance timer1 of Timer
	(properties)
)

(instance timer2 of Timer
	(properties)
)

(instance timer3 of Timer
	(properties)
)

