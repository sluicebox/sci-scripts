;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	LSL2 0
	LookAt 1
	NormalEgo 2
	NearControl 3
	AddActorToPic 4
	HandsOff 5
	HandsOn 6
	Notify 7
	HaveMem 8
	RedrawCast 9
	SoundLoops 10
	cls 11
	Ok 12
	ItIs 13
	YouAre 14
	NotNow 15
	NotClose 16
	AlreadyTook 17
	SeeNothing 18
	CantDo 19
	DontHave 20
	SetRgTimer 21
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gSpeed
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
	gShowStyle
	gAniInterval
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont
	gSmallFont
	gLastEvent
	; 25
	gModelessDialog
	gBigFont
	gVolume
	gVersion
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
	gAniThreshold
	gPerspective
	gFeatures
	gSortedFeatures
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
	gDebugging
	gCurrentStatus
	gCurrentEgoView
	gCurrentHenchView
	gGameSeconds
	; 105
	gGameMinutes
	gGameHours
	gRank
	gRgTimer
	global109
	; 110
	gCurrentTimer
	gForceAtest
	global112
	gOldTime
	global114
	; 115
	gSecondsInRoom
	gLoadDebugNext
	gDebugMenu
	gShowFrag
	gLogging
	; 120
	gMachineSpeed
	gLAhaircut
	gLAhenchAfterEgo
	gFilthLevel
	gScoredSunscreen
	; 125
	gWearingSunscreen
	gLoweredLifeboats
	gHenchOnScreen
	gTimesInRm33
	gWearingWig
	; 130
	gBlondHair
	gBodyWaxed
	gRmAfter40
	gBraContents
	gTimesInRm40
	; 135
	gTalkedToMD
	gConfusedKrishnas
	gSeenCustomsJoke
	gBombStatus
	gMissedPlane
	; 140
	gTimesInRm50
	gBoreStatus
	gWearingParachute
	gAirplaneDoorStatus
	gPastBees
	; 145
	gSnakeState
	gPastQuicksand
	gPastPiranha
	gIslandStatus
	global149
	; 150
	gTpBuffer
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
	gTritePhrase
	; 170
	gString
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
	gLaffer
	gScoredKnothole
	gScoredChaise
	gScoredLifeboat
	gScoredRm102Sit
	; 475
	gScoredRm43Sit
	gScoredJogger
	gScoredWoreSunscreen
	gScoredRosella
	gReappliedSunscreen
)

(procedure (LookAt actor1 actor2)
	(DirLoop actor1 (GetAngle (actor1 x:) (actor1 y:) (actor2 x:) (actor2 y:)))
	(if (== argc 3)
		(DirLoop
			actor2
			(GetAngle (actor2 x:) (actor2 y:) (actor1 x:) (actor1 y:))
		)
	)
)

(procedure (NearControl actor distance) ; UNUSED
	(if (< argc 2)
		(= distance 5)
	)
	(switch (actor loop:)
		(0
			(OnControl
				(actor x:)
				(actor y:)
				(+ (actor x:) distance)
				(+ (actor y:) 1)
			)
			(return)
		)
		(1
			(OnControl
				(- (actor x:) distance)
				(actor y:)
				(actor x:)
				(+ (actor y:) 1)
			)
			(return)
		)
		(2
			(OnControl
				(actor x:)
				(actor y:)
				(+ (actor x:) 1)
				(+ (actor y:) distance)
			)
			(return)
		)
		(3
			(OnControl
				(actor x:)
				(- (actor y:) distance)
				(+ (actor x:) 1)
				(actor y:)
			)
			(return)
		)
	)
)

(procedure (NormalEgo theLoop)
	(if (> argc 0)
		(gEgo loop: theLoop)
	)
	(gEgo
		view: gCurrentEgoView
		setLoop: -1
		setPri: -1
		setMotion: 0
		setStep: 3 2
		setCycle: Walk
		illegalBits: -32768
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
	(= gCurrentStatus 0)
	(User canControl: 1 canInput: 1)
)

(procedure (AddActorToPic whom)
	(if whom
		((View new:)
			view: (whom view:)
			loop: (whom loop:)
			cel: (whom cel:)
			priority: (whom priority:)
			posn: (whom x:) (whom y:)
			addToPic:
		)
		(whom posn: (whom x:) (+ 1000 (whom y:)))
	)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gEgo setMotion: 0)
)

(procedure (Notify whom)
	(= whom (ScriptID whom))
	(whom notify: &rest)
)

(procedure (HaveMem howMuch)
	(return (> (MemoryInfo 1) howMuch)) ; FreeHeap
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (SoundLoops who howMany) ; UNUSED
	(who loop: howMany changeState:)
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (Ok)
	(Print 0 127) ; "Ok."
)

(procedure (ItIs)
	(Print 0 128) ; "It is."
)

(procedure (YouAre)
	(Print 0 129) ; "You are."
)

(procedure (NotNow)
	(Print 0 130) ; "Not now!"
)

(procedure (NotClose)
	(Print 0 131) ; "You're not close enough."
)

(procedure (AlreadyTook)
	(Print 0 132) ; "You already took it."
)

(procedure (SeeNothing)
	(Print 0 133) ; "You see nothing special."
)

(procedure (CantDo)
	(Print 0 134) ; "You can't do that here; at least, not now."
)

(procedure (DontHave)
	(Print 0 135) ; "You don't have it."
)

(procedure (SetRgTimer name minutes seconds)
	(= gCurrentTimer name)
	(= gRgTimer (* 10 (+ seconds (* minutes 60))))
)

(instance LSL2 of Game
	(properties)

	(method (init &tmp testRoom)
		(super init:)
		(= gVolume 15)
		(DoSound sndVOLUME 15)
		(SL code: statusCode)
		(TheMenuBar init:)
		(scoreSnd init:)
		(deadSnd init:)
		(User echo: 32)
		(= gBigFont 0)
		(= gPossibleScore 500)
		(= gCurrentEgoView 100)
		(= gFilthLevel 4)
		(= gRank {Novice})
		(= gLaffer {"My name is Larry; Larry Laffer."})
		(= gTritePhrase (Format @gTpBuffer 0 0)) ; "Have a nice day."
		(= gVersion {1.000.011})
		(Load rsFONT gSmallFont)
		(Load rsFONT gUserFont)
		(Load rsFONT gBigFont)
		(Load rsCURSOR gNormalCursor)
		(Load rsCURSOR gWaitCursor)
		(gEgo view: 100 setCycle: Walk)
		(Inv
			empty: {Your leisure suit is empty!}
			add:
				NoInv
				Dollar_Bill
				Lottery_Ticket
				Cruise_Ticket
				Million_Dollar_Bill
				Swimsuit
				Wad_O__Dough
				Passport
				Grotesque_Gulp
				Sunscreen
				Onklunk
				Fruit
				Sewing_Kit
				Spinach_Dip
				Wig
				Bikini_Top
				Bikini_Bottom
				Knife
				Soap
				Matches
				Flower
				Hair_Rejuvenator
				Suitcase
				Airline_Ticket
				Parachute
				Bobby_Pin
				Pamphlet
				Airsick_Bag
				Stout_Stick
				Vine
				Ashes
				Sand
		)
		(if (GameIsRestarting)
			(SL disable:)
			(TheMenuBar hide:)
			(self newRoom: 99)
		else
			(self newRoom: 10)
		)
	)

	(method (replay)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu 1282 52 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(super replay:)
	)

	(method (changeScore n)
		(if (> n 25)
			(= gRank {Big Hero})
		else
			(if (> n 0)
				(scoreSnd play:)
			)
			(switch (Random 1 22)
				(1
					(= gRank {Novice})
				)
				(2
					(= gRank {Kumquat})
				)
				(3
					(= gRank {Dork})
				)
				(4
					(= gRank {Putz})
				)
				(5
					(= gRank {Lame-o})
				)
				(6
					(= gRank {Schmuck})
				)
				(7
					(= gRank {Pinhead})
				)
				(8
					(= gRank {Dweeb})
				)
				(9
					(= gRank {Nerd})
				)
				(10
					(= gRank {Minion})
				)
				(11
					(= gRank {Low-life})
				)
				(12
					(= gRank {Sleeze})
				)
				(13
					(= gRank {Slug})
				)
				(14
					(= gRank {Cretin})
				)
				(15
					(= gRank {Dullard})
				)
				(16
					(= gRank {Schlemiel})
				)
				(17
					(= gRank {Boor})
				)
				(18
					(= gRank {Creep})
				)
				(19
					(= gRank {Dim Bulb})
				)
				(20
					(= gRank {Jerk})
				)
				(21
					(= gRank {Hoser})
				)
				(22
					(= gRank {Nimrod})
				)
			)
		)
		(super changeScore: n)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 991)
		(DisposeScript 988)
		(DisposeScript 3)
		(DisposeScript 6)
		(DisposeScript 4)
		(= gHenchOnScreen 0)
		(= gShowStyle (Random 0 5))
		(= gSecondsInRoom 0)
		(super newRoom: newRoomNumber)
		(if gDebugging
			(gCurRoom setLocales: 5)
		)
	)

	(method (startRoom n &tmp newRegion)
		(super startRoom: n)
	)

	(method (doit &tmp systime)
		(super doit:)
		(if (!= gOldTime (= systime (GetTime 1))) ; SysTime12
			(= gOldTime systime)
			(++ gSecondsInRoom)
			(if (== 60 (++ gGameSeconds))
				(= gGameSeconds 0)
				(if (== 60 (++ gGameMinutes))
					(= gGameMinutes 0)
					(++ gGameHours)
				)
			)
		)
		(if (and gCurrentTimer (> gRgTimer 0))
			(-- gRgTimer)
		)
		(if (== gCurrentStatus 1001)
			(gCurRoom setScript: dyingScript)
		)
	)

	(method (wordFail word)
		(Print (Format @gString 0 1 word)) ; "Don't you ever say "%s" to me again!"
	)

	(method (syntaxFail)
		(Print 0 2) ; "Perhaps you can understand that sentence, but I have graphics to worry about!"
	)

	(method (pragmaFail)
		(if (<= gFilthLevel 4)
			(Print 0 3) ; "The heck you say!"
		else
			(Print 0 4) ; "The hell you say!"
		)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 3])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'praise/lord')
			(if (^= gDebugging $0001)
				(Print 0 5) ; "Amen, brother!"
			else
				(Print 0 6) ; "Go in peace."
			)
		)
		(cond
			((and (gEgo has: 6) (Said 'count/buck')) ; Wad_O__Dough
				(Print 0 7) ; "You have more money than you can count!"
			)
			((or (Said 'give/bill,wad,million,buck') (Said 'bribe'))
				(cond
					((gEgo has: 6) ; Wad_O__Dough
						(Print 0 8) ; ""Here. Take some money," you say in a vain attempt to buy friendship!"
						(Print 0 9 #at -1 152) ; "(It doesn't work.)"
					)
					((gEgo has: 1) ; Dollar_Bill
						(Print 0 10) ; ""Want a dollar?" you ask."
						(Print 0 11) ; "There is no reply."
					)
					((gEgo has: 4) ; Million_Dollar_Bill
						(Print 0 12) ; ""Hey, have you got change for a million?" you ask."
						(Print 0 13 #at -1 152) ; "(Evidently not.)"
					)
					(else
						(DontHave) ; "You don't have it."
					)
				)
			)
			(
				(and
					(or (gEgo has: 5) (gEgo has: 15) (gEgo has: 16)) ; Swimsuit, Bikini_Top, Bikini_Bottom
					(or
						(Said 'get/dress')
						(Said 'get<dress')
						(Said
							'wear,alter,(get<off),drain,(drop<on)/job,bra,bra,bikini'
						)
					)
				)
				(Print 0 14) ; "You can't change here!"
			)
			((and (gEgo has: 7) (Said 'look/passport/*')) ; Passport
				(Print 0 15) ; "You're the only one interested in your passport photo!"
			)
			((and (gEgo has: 8) (Said 'drink,apply/coke,coke')) ; Grotesque_Gulp
				(Print 0 16) ; "Ok. As you slowly drain the entire 32-gallon contents of your Grotesque Gulp, you begin searching feverishly for a fire hydrant."
				(gEgo hide: put: 8 -1) ; Grotesque_Gulp
				(Print 0 17 #draw) ; "Your exploding bladder prevents you from finding one!"
				(= gCurrentStatus 1001)
			)
			((and (gEgo has: 11) (Said 'look,look/note,basket')) ; Fruit
				(Fruit showSelf:)
			)
			((and (gEgo has: 10) (Said 'give/onklunk')) ; Onklunk
				(Print 0 18) ; "You easily give away the hopes of the free world! Way to go, traitor! Next time, hang onto your onklunk!"
				(= gCurrentStatus 1001)
			)
			((and (gEgo has: 10) (Said 'play,apply/music,music,onklunk')) ; Onklunk
				(Print 0 19) ; "You beat your onklunk in a frenzied rendition of an old country classic!"
				(Print 0 20 #at -1 152) ; "(But, which country?)"
			)
			((and (gEgo has: 17) (or (Said 'apply/gun') (Said 'hit'))) ; Knife
				(Print 0 21) ; "Hey! We want our R rating for sex, not violence!"
			)
			((and (gEgo has: 19) (Said 'apply,burn/match')) ; Matches
				(if (gEgo has: 21) ; Hair_Rejuvenator
					(HandsOff)
					(Ok) ; "Ok."
					(= gCurrentStatus 17)
					(gCurRoom newRoom: 152)
				else
					(Print 0 22) ; "You light the book of matches and watch it go up in flames. Whee!"
					(gEgo put: 19 -1) ; Matches
					(gGame changeScore: -2)
				)
			)
			(
				(and
					(gEgo has: 21) ; Hair_Rejuvenator
					(Said
						'drop,(drop<on),drain,apply,drop,caress,wear/rejuvenator>'
					)
				)
				(cond
					((Said '[/!]')
						(Print 0 23) ; "On what?"
					)
					((Said '/me,head,hair')
						(Print 0 24) ; "You've had enough problems with your hair. You don't need to wear explosives, too!"
					)
					(else
						(event claimed: 1)
						(Print 0 25) ; "Ok. It's gone now."
						(gEgo put: 21 -1) ; Hair_Rejuvenator
						(gGame changeScore: -2)
					)
				)
			)
			(
				(and
					(gEgo has: 21) ; Hair_Rejuvenator
					(gEgo has: 27) ; Airsick_Bag
					(or (Said 'drop/bag/bottle') (Said 'drop/bottle/bag'))
				)
				(Print 0 26) ; "Good idea. But this is not the place."
			)
			((and (gEgo has: 21) (Said 'burn,burn/bottle,rejuvenator')) ; Hair_Rejuvenator
				(if (gEgo has: 19) ; Matches
					(HandsOff)
					(Ok) ; "Ok."
					(= gCurrentStatus 17)
					(gCurRoom newRoom: 152)
				else
					(Print 0 27) ; "Fortunately, you have no matches with which to immolate yourself!"
				)
			)
			((Said 'open,(look<in)>')
				(= temp1 (gInventory saidMe:))
				(cond
					((Said '[/!]')
						(Print 0 28) ; "What do you want to inspect?"
					)
					((not temp1)
						(event claimed: 1)
						(CantDo) ; "You can't do that here; at least, not now."
					)
					((not (temp1 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(switch (gInventory indexOf: temp1)
							(3
								(Print 0 29) ; "If it's a good cruise, it's a Wonder!"
							)
							(5
								(if (== gCurrentEgoView 132)
									(Print 0 30) ; "Pervert!"
								else
									(Print 0 31) ; "Hand wash only."
								)
							)
							(6
								(Print 0 32) ; "You only find more money."
							)
							(7
								(Print 0 33 #icon 7 1 0) ; "Nice photo, Larry!"
							)
							(10
								(Print 0 34) ; "You can't find the microfiche in there."
								(Print 0 35 #at -1 152) ; "(It's a secret and you don't know about it!)"
							)
							(12
								(Print 0 36) ; "Nothing in the sewing kit is of use to you."
							)
							(14
								(Print 0 37) ; "Made in Taiwan"
							)
							(15
								(Print 0 38) ; "40D"
							)
							(16
								(Print 0 39) ; "XL"
							)
							(21
								(Print 0 40) ; "Slosh."
								(Print 0 40) ; "Slosh."
							)
							(23
								(Print 0 41) ; "You have no rights. (Just ask us!)"
							)
							(24
								(Print 0 42) ; "You open the parachute and it spills out everywhere. Since you know nothing about parachute folding, you throw it away."
								(gEgo put: 24 -1) ; Parachute
								(gGame changeScore: -3)
							)
							(26
								(Print 0 43) ; "Repent!"
								(Print 0 44) ; "And send money."
							)
							(27
								(Print 0 45) ; "You look inside the bag and see nothing."
							)
							(else
								(SeeNothing) ; "You see nothing special."
							)
						)
					)
				)
			)
			((Said 'hello')
				(Print 0 46) ; "Hi."
			)
			((or (Said '/bye') (Said 'bye'))
				(Print 0 47) ; "Goodbye."
			)
			((Said 'thank')
				(Print 0 48) ; "You're welcome."
			)
			((Said 'bang')
				(Print 0 49) ; "Knock, knock."
				(Print 0 50 #at -1 152) ; "(Nobody wants to play now, Larry!)"
			)
			((Said 'hit')
				(Print 0 21) ; "Hey! We want our R rating for sex, not violence!"
			)
			((or (Said 'board/bathroom') (Said 'leak') (Said 'get/leak'))
				(if (== 100 (gEgo view:))
					(Print 0 51) ; "A warm feeling spreads down your leg. Your suit is not as white as it was!"
				else
					(NotNow) ; "Not now!"
				)
			)
			((Said 'climb>')
				(if (Said '/brick,building')
					(Print 0 52) ; "Climbing the walls already?"
				else
					(Print 0 53) ; "That would be unbecoming a man of leisure."
					(event claimed: 1)
				)
			)
			((Said 'hop')
				(Print 0 54) ; "Whee!"
			)
			((Said 'yell')
				(Print 0 55) ; "HELP!"
			)
			((Said 'daydream')
				(Print 0 56) ; "Zzzzzz."
			)
			((Said 'rob')
				(Print 0 57) ; "That's against the law!"
			)
			((Said 'cheat')
				(Print 0 58) ; "Ok, you win.\05"
				(Print 0 59 #at -1 152) ; "(Game over.)"
				(= gQuit 1)
			)
			((Said '(drop<on),wear>')
				(cond
					((Said '[/!]')
						(Print 0 60) ; "What do you want to wear?"
					)
					((= temp1 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						else
							(Print 0 61) ; "You'd look better if you didn't!"
						)
					)
					(else
						(Print 0 62) ; "You can't wear what is not yours."
						(event claimed: 1)
					)
				)
			)
			((Said 'drop>')
				(cond
					((Said '[/!]')
						(Print 0 63) ; "What do you want to drop?"
					)
					((= temp1 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						else
							(Print 0 64) ; "Nah. Better not!"
						)
					)
					(else
						(Print 0 65) ; "It's not yours to drop."
						(event claimed: 1)
					)
				)
			)
			((Said 'throw>')
				(cond
					((Said '[/!]')
						(Print 0 66) ; "What do you want to throw?"
					)
					((= temp1 (gInventory saidMe:))
						(if (not (gEgo has: (gInventory indexOf: temp1)))
							(DontHave) ; "You don't have it."
						else
							(Print 0 64) ; "Nah. Better not!"
						)
					)
					(else
						(Print 0 67) ; "That doesn't belong to you."
						(event claimed: 1)
					)
				)
			)
			((Said 'smell')
				(Print 0 68) ; "Sniff, sniff."
			)
			((Said 'wear/crown')
				(Print 0 69) ; "You'll have to buy "King's Quest IV" to do that!"
			)
			((Said '/microfiche')
				(Print 0 70) ; "Shh! You're not supposed to know about that."
			)
			((Said 'whistle')
				(Print 0 71) ; "You whistle a happy tune."
				(Print 0 72 #at -1 152) ; "(You envision Opie on a dirt road.)"
			)
			((Said 'laugh')
				(Print 0 73) ; "Ha, ha!"
			)
			((Said 'eat')
				(Print 0 74) ; "Once you tasted it, you wouldn't do that any more!"
			)
			((Said 'lie,bath,nap')
				(Print 0 75) ; "There's no time!"
			)
			((Said 'aid')
				(Print 0 76) ; "Don't whine!"
			)
			((Said 'explore>')
				(if (Said '/bra,me')
					(Print 0 77) ; "Searching through your pockets you find..."
					(gInventory showSelf: gEgo)
				else
					(event claimed: 1)
					(Print 0 78) ; "You find nothing."
				)
			)
			((or (Said '/key') (Said 'unbolt,bolt'))
				(Print 0 79) ; "You can't. There's no key in this game!"
			)
			((or (Said '/fuck/you') (Said 'fuck/you'))
				(Print 0 80) ; "Same to you, buddy!"
			)
			((Said 'fuck/*')
				(Print 0 81) ; "Yeah, you probably would, too!"
			)
			((Said 'jack')
				(Print 0 82) ; "Aren't your palms hairy enough?"
			)
			((Said 'caress,caress,embrace,look/clit')
				(Print 0 83) ; "Obviously, restraint is no problem for you, Larry."
			)
			((Said 'eat/woman')
				(Print 0 84) ; "That comes later."
			)
			((Said 'drink')
				(Print 0 85) ; "Nobody's THAT thirsty!"
			)
			((Said 'embrace')
				(Print 0 86) ; "Wouldn't you rather just remain friends?"
			)
			(
				(or
					(Said 'eat,fuck/me')
					(Said 'clit,shit,leak,fuck,fart,boob,ass,asshole')
				)
				(Print 0 87) ; "Tsk, tsk."
			)
			((Said '/hell')
				(Print 0 88) ; "That's probably where you'll end up!"
			)
			((Said '/heck')
				(Print 0 89) ; "Aren't we the little prissy one!"
			)
			((Said 'look>')
				(cond
					((Said '/*/man,woman,children>')
						(cond
							((not (= temp1 (gInventory saidMe:)))
								(event claimed: 1)
								(Print 0 90) ; "It's not yours."
							)
							((not (temp1 ownedBy: gEgo))
								(DontHave) ; "You don't have it."
							)
							(else
								(Print 0 91) ; "You have no reason to do that."
								(event claimed: 1)
							)
						)
					)
					((Said '/bra,me')
						(if (== 100 (gEgo view:))
							(Print 0 92) ; "You're wearing the latest in fashion."
							(Print 0 93 #at -1 152) ; "(If you consider 1971 "late")!"
						)
						(Print 0 77) ; "Searching through your pockets you find..."
						(gInventory showSelf: gEgo)
					)
					(
						(Said
							'/billfold,(spray[<breath]),(lint[<bra]),(watch[<wrist])'
						)
						(Print 0 94) ; "Oops, wrong game! If you want to see that, you'll have to buy "Lounge Lizards.""
					)
					((Said '/bush,palm')
						(Print 0 95) ; "You see many leaves."
					)
					((Said '/man,woman,children')
						(Print 0 96) ; "Where?"
					)
					((Said '/brick,building')
						(Print 0 97) ; "Staring at the walls already?"
					)
					((Said '/carpet,down')
						(Print 0 98) ; "It just lies there, under your feet."
					)
					((Said '/cloud,ceiling')
						(Print 0 99) ; "It's still up there!"
					)
					((Said '<in/cup')
						(Print 0 100) ; "This game does not encourage voyeurs!"
					)
					((Said '/bikini')
						(if (or (gEgo has: 15) (gEgo has: 16)) ; Bikini_Top, Bikini_Bottom
							(if (gEgo has: 15) ; Bikini_Top
								(Bikini_Top showSelf:)
							)
							(if (gEgo has: 16) ; Bikini_Bottom
								(Bikini_Bottom showSelf:)
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said '/bill,million,buck,wad')
						(cond
							((gEgo has: 1) ; Dollar_Bill
								(Dollar_Bill showSelf:)
							)
							((gEgo has: 4) ; Million_Dollar_Bill
								(Million_Dollar_Bill showSelf:)
							)
							((gEgo has: 6) ; Wad_O__Dough
								(Wad_O__Dough showSelf:)
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
					)
					((Said '/ticket')
						(cond
							((gEgo has: 2) ; Lottery_Ticket
								(Lottery_Ticket showSelf:)
							)
							((gEgo has: 3) ; Cruise_Ticket
								(Cruise_Ticket showSelf:)
							)
							((gEgo has: 23) ; Airline_Ticket
								(Airline_Ticket showSelf:)
							)
							(else
								(DontHave) ; "You don't have it."
							)
						)
					)
					((= temp1 (gInventory saidMe:))
						(if (temp1 ownedBy: gEgo)
							(temp1 showSelf:)
						else
							(DontHave) ; "You don't have it."
						)
					)
					(else
						(switch (Random 42 44)
							(42
								(Print 0 101) ; "It's just as it appears."
							)
							(43
								(Print 0 102) ; "It doesn't look interesting."
							)
							(44
								(SeeNothing) ; "You see nothing special."
							)
						)
						(event claimed: 1)
					)
				)
			)
			((or (Said 'apply,buy/bill,million,buck,wad') (Said 'buy'))
				(if (or (gEgo has: 1) (gEgo has: 6) (gEgo has: 4)) ; Dollar_Bill, Wad_O__Dough, Million_Dollar_Bill
					(Print 0 103) ; "There's nothing worth buying here."
				else
					(Print 0 104) ; "You're broke!"
				)
			)
			((Said 'apply>')
				(= temp1 (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '/ticket')
						(if
							(or
								(gEgo has: 2) ; Lottery_Ticket
								(gEgo has: 3) ; Cruise_Ticket
								(gEgo has: 23) ; Airline_Ticket
							)
							(Print 0 105) ; "There's no need to use the ticket here."
						else
							(Print 0 106) ; "What ticket?"
						)
					)
					((Said '[/!]')
						(Print 0 107) ; "What do you want to use?"
					)
					((not temp1)
						(event claimed: 1)
						(CantDo) ; "You can't do that here; at least, not now."
					)
					((not (temp1 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 0 108) ; "There's no need to use it here."
						(event claimed: 1)
					)
				)
			)
			((Said 'give>')
				(= temp1 (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '/*[/!]')
						(Print 0 109) ; "To whom?"
					)
					((Said '[/!]')
						(Print 0 110) ; "What do you want to give?"
					)
					((not temp1)
						(event claimed: 1)
						(Print 0 111) ; "It's not yours to give."
					)
					((not (temp1 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					(else
						(Print 0 91) ; "You have no reason to do that."
						(event claimed: 1)
					)
				)
			)
			((Said 'get>')
				(cond
					((Said '[/!]')
						(Print 0 112) ; "What do you want to take?"
					)
					((and (= temp1 (gInventory saidMe:)) (temp1 ownedBy: gEgo))
						(Print 0 113) ; "You already have it."
					)
					(else
						(switch (Random 33 35)
							(33
								(Print 0 114) ; "It's of no use."
							)
							(34
								(Print 0 115) ; "You don't need it."
							)
							(35
								(Print 0 116) ; "There's no reason to take it."
							)
						)
						(event claimed: 1)
					)
				)
			)
			((= temp1 (gInventory saidMe:))
				(if (not (temp1 ownedBy: gEgo))
					(DontHave) ; "You don't have it."
				else
					(Print 0 117) ; "You can't do that now."
				)
			)
			((Said 'talk>')
				(if (Said '[/!]')
					(Print 0 109) ; "To whom?"
				else
					(Print 0 118) ; ""Hello," you say."
					(Print 0 119 #at -1 152) ; "(There is no response.)"
					(event claimed: 1)
				)
			)
			(
				(or
					(Said '/clit,shit,leak,fuck,asshole,boob,ass,asshole')
					(Said '//clit,shit,leak,fuck,asshole,boob,ass,asshole')
				)
				(Print 0 120) ; "Ok, but I don't usually do that!"
			)
			((or (Said '//woman') (Said '/woman/') (Said '/woman'))
				(Print 0 121) ; "She's not interested in that!"
			)
		)
	)
)

(class Iitem of InvI
	(properties)

	(method (showSelf)
		(Print 2 view #title name #icon view 0 0)
	)
)

(instance NoInv of Iitem
	(properties)
)

(instance Dollar_Bill of Iitem
	(properties
		name {Dollar Bill}
		said '/(bill<buck)'
		owner 23
		view 1
	)
)

(instance Lottery_Ticket of Iitem
	(properties
		name {Lottery Ticket}
		said '/ticket[<bucko]'
		owner 114
		view 2
	)
)

(instance Cruise_Ticket of Iitem
	(properties
		name {Cruise Ticket}
		said '/ticket[<cruise]'
		owner 103
		view 3
	)
)

(instance Million_Dollar_Bill of Iitem
	(properties
		name {Million Dollar Bill}
		said '/((bill<buck)<million),(buck<million)'
		owner 104
		view 4
	)
)

(instance Swimsuit of Iitem
	(properties
		said '/job'
		owner 116
		view 5
	)
)

(instance Wad_O__Dough of Iitem
	(properties
		name {Wad O' Dough}
		said '/buck,wad'
		owner 116
		view 6
	)
)

(instance Passport of Iitem
	(properties
		said '/passport'
		owner 23
		view 7
	)
)

(instance Grotesque_Gulp of Iitem
	(properties
		name {Grotesque Gulp}
		said '/coke[<grotesque]'
		owner 114
		view 8
	)
)

(instance Sunscreen of Iitem
	(properties
		said '/lotion'
		owner 118
		view 9
	)
)

(instance Onklunk of Iitem
	(properties
		said '/onklunk'
		owner 115
		view 10
	)
)

(instance Fruit of Iitem
	(properties
		said '/basket'
		owner 32
		view 11
	)
)

(instance Sewing_Kit of Iitem
	(properties
		name {Sewing Kit}
		said '/kit[<sew]'
		owner 33
		view 12
	)
)

(instance Spinach_Dip of Iitem
	(properties
		name {Spinach Dip}
		said '/bread[<spinach]'
		owner 35
		view 13
	)
)

(instance Wig of Iitem
	(properties
		said '/wig'
		owner 37
		view 14
	)
)

(instance Bikini_Top of Iitem
	(properties
		name {Bikini Top}
		said '/lid[<bikini]'
		owner 134
		view 15
	)
)

(instance Bikini_Bottom of Iitem
	(properties
		name {Bikini Bottom}
		said '/bottom[<bikini]'
		owner 41
		view 16
	)
)

(instance Knife of Iitem
	(properties
		said '/gun'
		owner 43
		view 17
	)
)

(instance Soap of Iitem
	(properties
		said '/soap'
		owner 44
		view 18
	)
)

(instance Matches of Iitem
	(properties
		said '/match'
		owner 44
		view 19
	)
)

(instance Flower of Iitem
	(properties
		said '/flower'
		owner 40
		view 20
	)
)

(instance Hair_Rejuvenator of Iitem
	(properties
		name {Hair Rejuvenator}
		said '/rejuvenator[<hair]'
		owner 45
		view 21
	)
)

(instance Suitcase of Iitem
	(properties
		said '/baggage'
		owner 54
		view 22
	)
)

(instance Airline_Ticket of Iitem
	(properties
		name {Airline Ticket}
		said '/ticket[<airline,airline]'
		owner 52
		view 23
	)
)

(instance Parachute of Iitem
	(properties
		said '/parachute'
		owner 55
		view 24
	)
)

(instance Bobby_Pin of Iitem
	(properties
		name {Bobby Pin}
		said '/bobbypin[<bobby]'
		owner 55
		view 25
	)
)

(instance Pamphlet of Iitem
	(properties
		said '/pamphlet'
		owner 57
		view 26
	)
)

(instance Airsick_Bag of Iitem
	(properties
		name {Airsick Bag}
		said '/bag[<airsick]'
		owner 62
		view 27
	)
)

(instance Stout_Stick of Iitem
	(properties
		name {Stout Stick}
		said '/stick'
		owner 71
		view 28
	)
)

(instance Vine of Iitem
	(properties
		said '/landscape'
		owner 74
		view 29
	)
)

(instance Ashes of Iitem
	(properties
		said '/ash'
		owner 77
		view 30
	)
)

(instance Sand of Iitem
	(properties
		said '/beach'
		owner 75
		view 31
	)
)

(instance dyingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gCurrentStatus 1002)
				(HandsOff)
				(Load rsSOUND 103)
				(= seconds 3)
			)
			(1
				(gSounds eachElementDo: #dispose)
				(deadSnd play:)
				(if
					(Print ; "Well, Larry, you've screwed up again! What'dya say we do it just one more time?"
						0
						122
						#title
						{Oh, no! Not again?!}
						#font
						gBigFont
						#icon
						112
						0
						0
						#button
						{Keep On Muddling}
						0
						#button
						{Order A Hintbook}
						1
					)
					(Print 0 123) ; "Dial (209) 683-6858 from 8-5 Pacific Time. Have your credit card handy."
				)
				(repeat
					(switch
						(Print ; "Remember save early, save often!"
							0
							124
							#title
							{Al says:}
							#font
							gBigFont
							#button
							{Restore}
							1
							#button
							{Restart}
							2
							#button
							{  Quit  }
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
			)
		)
	)
)

(instance statusCode of Code
	(properties)

	(method (doit str)
		(Format str 0 125 gScore gPossibleScore 0 126 gRank 0 126) ; "Score: %d of %d%15s Rank: %s%10s"
	)
)

(instance scoreSnd of Sound
	(properties
		number 7
		priority -10
		owner -1
	)
)

(instance deadSnd of Sound
	(properties
		number 103
		priority 255
	)
)

