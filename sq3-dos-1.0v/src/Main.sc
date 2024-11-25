;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use File)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	SQ3 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	NotClose 5
	AlreadyTook 6
	SeeNothing 7
	CantDo 8
	DontHave 9
	RedrawCast 10
	proc0_11 11
	cls 12
	IsItemAt 13
	PutItem 14
	NearControl 15
	EgoDead 17
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
	gVersion = {Space Quest \0b}
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
	global100
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
	global121 = 1000
	global122
	global123
	global124
	; 125
	global125
	global126
	global127
	gView
	global129
	; 130
	global130
	global131
	global132
	global133
	global134
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
	global149 = 2
	; 150
	global150
	global151
	global152
	gLongSong
	global154
	; 155
	gHandsOff
	global156
	global157
	global158
	global159 = 1
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
	global174 = 12
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
	global214 = 75
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
	global541
	global542
	global543
	global544
	; 545
	global545
	global546
	global547
	global548
	global549
	; 550
	global550
	global551
	global552
	global553
	global554
	; 555
	global555
	global556
	global557
	global558
	global559
	; 560
	global560
	global561
	global562
	global563
	global564
	; 565
	global565
	global566
	global567
	global568
	global569
	; 570
	global570
	global571
	global572
	global573
	global574
	; 575
	global575
	global576
	global577
	global578
	global579
	; 580
	global580
	global581
	global582
	global583
	global584
	; 585
	global585
	global586
	global587
	global588
	global589
	; 590
	global590
	global591
	global592
	global593
	global594
	; 595
	global595
	global596
	global597
	global598
	global599
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
		setStep: 3 2
		looper: 0
		illegalBits: $8000
		cycleSpeed: 0
		moveSpeed: 0
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= gHandsOff 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(= gHandsOff 0)
)

(procedure (HaveMem param1) ; UNUSED
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (NotClose)
	(Print 0 35) ; "It's not quite within reach."
)

(procedure (AlreadyTook)
	(Print 0 36) ; "You've accomplished that task."
)

(procedure (SeeNothing) ; UNUSED
	(Print 0 37) ; "You see nothing special."
)

(procedure (CantDo)
	(Print 0 38) ; "That's not possible now."
)

(procedure (DontHave)
	(Print 0 39) ; "You don't have it."
)

(procedure (RedrawCast)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_11 param1 param2) ; UNUSED
	(param1 loop: param2 changeState:)
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (IsItemAt param1 param2)
	(return
		(== ((gInventory at: param1) owner:) (if (== argc 1) gCurRoomNum else param2))
	)
)

(procedure (PutItem param1 param2)
	((gInventory at: param1) owner: (if (== argc 1) gCurRoomNum else param2))
)

(procedure (NearControl param1 param2)
	(if (< argc 2)
		(= param2 5)
	)
	(OnControl
		(- (param1 x:) param2)
		(- (param1 y:) param2)
		(+ (param1 x:) param2)
		(+ (param1 y:) param2)
	)
)

(procedure (EgoDead param1 param2 param3 param4)
	(HandsOff)
	(= global197 1)
	(if (not param1)
		(= global190 901)
	else
		(= global190 param1)
	)
	(= global191 param2)
	(= global192 param3)
	(= global188 param4)
)

(instance statusCode of Code
	(properties)

	(method (doit param1)
		(Format param1 0 0 gScore gPossibleScore 0 1 {Space Quest \0b} 0 1) ; "Score: %d of %d%13s%s%1s"
	)
)

(instance ego of Ego
	(properties)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

(instance logFile of gamefile_sh ; UNUSED
	(properties)
)

(instance SQ3 of Game
	(properties)

	(method (init)
		(super init:)
		(= global598 (Graph grGET_COLOURS))
		(= gVersion {1.0U - 4/13/89})
		(= global193 1)
		(longSong owner: self init:)
		(= gLongSong longSong)
		(User blocks: 0 canControl: 0 x: -1 y: 160)
		(= gEgo ego)
		(User alterEgo: gEgo)
		(SL code: statusCode)
		(gGame setSpeed: 5)
		(TheMenuBar init:)
		(HandsOn)
		(= global54 1)
		(ScriptID 984)
		(= gPossibleScore 738)
		(= gUserFont 300)
		(gInventory
			add:
				Glowing_Gem
				Wire
				Ladder
				Reactor
				Orat_on_a_Stick
				ThermoWeave_Underwear
				Astro_Chicken_Flight_Hat
				Monolith_Decoder_Ring
				Buckazoids
				Metal_Pole
				Thermal_Detonator
				Keycard
				Coveralls
				Vaporizer
				Elmo_s_picture
				a_copy_of_Elmo_s_picture
				Invisibility_Belt
				Bag_of_Fast_Food
		)
		(if (GameIsRestarting)
			(TheMenuBar draw:)
			(SL enable:)
			(= global125 2)
			(self newRoom: 777)
		else
			(TheMenuBar state: 1)
			(= global125 900)
			(self newRoom: 777)
		)
	)

	(method (replay)
		(TheMenuBar draw:)
		(SL enable:)
		(SetMenu 1282 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(super replay:)
	)

	(method (doit &tmp temp0)
		(if (and (!= gCurRoomNum 900) (!= gCurRoomNum 1) (!= gCurRoomNum 155))
			(= temp0 (HaveMouse))
			(if (not global592)
				(cond
					(global159
						(= global230 69)
					)
					((== (User controls:) 0)
						(= temp0 1)
						(= global230 gWaitCursor)
					)
					(else
						(= global230 gNormalCursor)
					)
				)
				(if (!= gTheCursor global230)
					(self setCursor: global230 temp0)
				)
			)
		)
		(if (== global251 1)
			(= global251 0)
			(= global252 1)
			(calc init:)
		)
		(if global197
			(= global159 0)
			(gLongSong number: (Random 23 24) loop: 1 priority: 500 play:)
			(repeat
				(switch global188
					(1
						(= global320 {Deceleration Trauma})
						(= global259
							{It wouldn't be so bad, except for the sudden stop at the end.__Next time, don't get so close to the edge.}
						)
					)
					(2
						(= global320 {New, Improved Quick Tanning Method})
						(= global259
							{You never did care for fondue.__Next time, don't get so close to the edge.}
						)
					)
					(3
						(= global320 {Rats!})
						(= global259
							{You may not be Purina Rat Chow, but you'll do!}
						)
					)
					(4
						(= global320 {It Slices, It Dices...})
						(= global259 {You're a less-than-choice cut, Wilco!})
					)
					(5
						(= global320 {Decompression Blues})
						(= global259 {Sudden Decompression Sucks!})
					)
					(6
						(= global320 {A Slimmer, Trimmer You!})
						(= global259
							{A quick, but painful, way to shed those extra inches.}
						)
					)
					(7
						(= global320 {Learn to Drive That Thing!})
						(= global259
							{Your radar is designed to avoid just such an occurrence.}
						)
					)
					(8
						(= global320 {One Way to Lower Your Blood Pressure.})
						(= global259
							{A brave but fatal attempt at arterial art.}
						)
					)
					(9
						(= global320 {You have blown your `cover'.})
						(= global259
							{You have demonstrated a surprising lack of janitorial skill.__Perhaps this would be an opportune time to `brush up' on your technique with Space Quest I and II.}
						)
					)
					(10
						(= global320 {You have taken the big plunge.})
						(= global259
							{That's one small step for man... One giant leap for janitor-kind.}
						)
					)
					(11
						(= global320 {Sunbathing Not Recommended})
						(= global259
							{It's so hot you could fry a Vorlian phlegmsnake egg.}
						)
					)
					(12
						(= global320 {Don't Trust Guys in Black Spacesuits})
						(= global259
							{A pulselaser blast to the forehead is not your idea of fun.__Fortunately, it didn't hit anything important.}
						)
					)
					(13
						(= global320 {Down for the Count})
						(= global259 {Better hang out at the gym more often.})
					)
					(14
						(= global320 {Hole In One!})
						(= global259
							{Hope you enjoy your new flow-through ventilation system.}
						)
					)
					(15
						(= global320 {Just Like Mom Used to Make})
						(= global259
							{As your life sputters to a close, you decide to cut down on desserts.}
						)
					)
					(20
						(= global320 {Be More Careful With Explosives})
						(= global259
							{Didn't mom always tell you not to play with firecrackers?}
						)
					)
					(else
						(= global320 {Congratulations On Your Recent Death !})
						(= global259
							{Thanks for playing Space Quest ]I[. As usual, you've been a real hoot.}
						)
					)
				)
				(switch
					(Print
						global259
						#icon
						global190
						global191
						global192
						#mode
						1
						#title
						global320
						#button
						{Restore}
						1
						#button
						{Restart}
						2
						#button
						{____Quit____}
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
			(= global219 0)
			(= global223 0)
			(if (!= (= global198 (GetTime 1)) global199) ; SysTime12
				(= global199 global198)
				(+= global226 1)
				(= global219 1)
				(if (>= global226 60)
					(++ global227)
					(= global226 0)
					(= global223 1)
					(if (== global227 60)
						(++ global228)
						(= global227 0)
					)
				)
			)
		)
		(super doit:)
	)

	(method (startRoom roomNum)
		(DisposeScript 985)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				global200
				(Print 0 2 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(super startRoom: roomNum)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 50])
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (== global252 1)
			(event claimed: 1)
			(= global252 0)
			(calc dispose:)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'tp')
						(if (not global200)
							(event claimed: 0)
						else
							(User canControl: 1)
							(= global100 0)
							(if
								(and
									(!= (= temp4 (GetNumber {Teleport to:})) 1)
									(!= temp4 900)
									(!= temp4 155)
								)
								(gLongSong stop:)
								(= global159 0)
								(= global230 gNormalCursor)
								(gGame setCursor: gNormalCursor (HaveMouse))
							)
							(= global189 temp4)
							(= global193 0)
							(gCurRoom newRoom: temp4)
						)
					)
					((Said 'pump,backstage/shark,pass')
						(Print 0 3) ; "OK."
						(= global200 1)
					)
					((Said 'wait')
						(Print 0 4) ; "This isn't a text adventure!"
					)
					((or (Said 'wear/belt') (Said 'drop<on/belt'))
						(if (gEgo has: 16) ; Invisibility_Belt
							(if (not global126)
								(Print 0 5) ; "OK, you wear the belt."
								(= global126 1)
							else
								(Print 0 6) ; "You're already wearing it."
							)
						else
							(DontHave) ; "You don't have it."
						)
					)
					(
						(or
							(Said 'use,activate/belt,invisibility')
							(Said 'turn<on/belt')
							(Said 'press/button/belt')
							(Said 'switch<on/belt')
						)
						(cond
							((not (gEgo has: 16)) ; Invisibility_Belt
								(DontHave) ; "You don't have it."
							)
							((not global126)
								(Print 0 7) ; "First, you need to wear it."
							)
							((== global120 2)
								(Print 0 8) ; "The belt is now completely out of power."
							)
							(else
								(Print 0 9) ; "Looking at the belt, you notice that the power supply is very low. You decide to hold off until you really need it."
							)
						)
					)
					((Said 'wear,(drop<on)/panties')
						(cond
							((not (gEgo has: 5)) ; ThermoWeave_Underwear
								(DontHave) ; "You don't have it."
							)
							(global182
								(Print 0 10) ; "You're already wearing them."
							)
							(else
								(Print 0 11) ; "Not a good idea, considering your location."
							)
						)
					)
					((Said 'wear,(drop<on)/decoder')
						(if (not (gEgo has: 7)) ; Monolith_Decoder_Ring
							(DontHave) ; "You don't have it."
						else
							(Print 0 12) ; "You decide to leave the ring in the relative safety of your pocket."
						)
					)
					(
						(or
							(Said 'remove/attire')
							(Said 'get/naked')
							(Said 'undress')
							(Said 'remove/panties')
						)
						(Print 0 13) ; "I'll get naked if you get naked. You go first."
					)
					((Said 'wear/cap')
						(if (gEgo has: 6) ; Astro_Chicken_Flight_Hat
							(Print 0 14) ; "On second thought, it looks pretty silly. Let's not."
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said 'look/anemometer')
						(if (gEgo has: 9) ; Metal_Pole
							(Print 0 15) ; "It's on the end of your pole."
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said 'look/belt')
						(cond
							((not (gEgo has: 16)) ; Invisibility_Belt
								(DontHave) ; "You don't have it."
							)
							((!= global120 2)
								(Print 0 16) ; "Look out, it's low on power."
							)
							(else
								(Print 0 17) ; "The terminator's invisibility belt is now completely out of power."
							)
						)
					)
					((and (Said 'look>') (= temp0 (gInventory firstTrue: #saidMe)))
						(if (temp0 ownedBy: gEgo)
							(temp0 showSelf:)
						else
							(Print 0 18) ; "You don't have one of those."
						)
					)
					((Said 'eat,drop,use')
						(Print 0 19) ; "Forget it. Think of something else."
					)
					((Said 'get')
						(cond
							(
								(or
									(not global200)
									(not (= temp0 (gInventory firstTrue: #saidMe)))
								)
								(Print 0 20) ; "That doesn't seem to be available."
							)
							((temp0 ownedBy: gEgo)
								(Print 0 21) ; "You already have it."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'smell')
						(Print 0 22) ; "You smell nothing of note."
					)
					((Said 'throw')
						(Print 0 23) ; "Keep it to yourself."
					)
					((Said 'press')
						(Print 0 24) ; "You can't"
					)
					((Said 'jump')
						(Print 0 25) ; "Not now."
					)
					((Said 'jog')
						(Print 0 26) ; "Sorry. We don't do running."
					)
					((Said 'fuck')
						(if (> (++ global185) 25)
							(Print 0 27) ; "Hey, trashmouth! Don't be saying that shit!"
						else
							(Print 0 28) ; "Hey! What kind of talk is that?"
						)
					)
					((or (Said 'inventory') (Said 'look,get/inventory'))
						(gInventory showSelf: gEgo)
					)
				)
			)
			(evMOUSEBUTTON
				(if global200
					(= temp5 (event x:))
					(= temp6 (event y:))
					(cond
						((== (= temp7 (event modifiers:)) $000a) ; emALT | emLEFT_SHIFT
							(event claimed: 1)
							((User alterEgo:) setMotion: JumpTo temp5 temp6)
						)
						((& temp7 emSHIFT)
							(event claimed: 1)
							(= temp1
								(Print
									(Format @temp9 0 29 temp5 temp6) ; "%d/%d"
									#at
									(cond
										((< temp5 20) temp5)
										((< 300 temp5)
											(- temp5 40)
										)
										(else
											(- temp5 20)
										)
									)
									(if (< temp6 16)
										temp6
									else
										(- temp6 6)
									)
									#font
									999
									#dispose
								)
							)
							(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
								(temp2 dispose:)
							)
							(temp1 dispose:)
							(temp2 dispose:)
						)
						((& temp7 emCTRL)
							(event claimed: 1)
							(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
								((User alterEgo:)
									posn: (temp2 x:) (- (temp2 y:) 10)
									setMotion: 0
								)
								(Animate (gCast elements:) 0)
								(temp2 dispose:)
							)
							(temp2 dispose:)
						)
						((& temp7 emALT)
							(event claimed: 1)
							((User alterEgo:) showSelf:)
						)
					)
				)
			)
			(evKEYBOARD
				(if (not global200)
					(return)
				)
				(switch (event message:)
					(KEY_ALT_z
						(if global200
							(event claimed: 1)
							(= gQuit 1)
						)
					)
					(KEY_ALT_e
						(Print
							(Format
								@temp9
								{view: %d loop: %d cel: %d posn: %d %d pri: %d OnControl: $%x Origin on: $%x}
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo x:)
								(gEgo y:)
								(gEgo priority:)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(KEY_ALT_h
						(gGame showMem:)
						(event claimed: 1)
					)
					(KEY_ALT_r
						(Print (Format @temp9 0 30 gCurRoomNum)) ; "curRoomNum = %d"
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_p
						(Show 2)
					)
					(KEY_ALT_y
						(= global402 0)
						(GetInput @global402 8 {Inv. Object})
						(= global351 (ReadNumber @global402))
						(= global402 0)
						(GetInput @global402 12 {Owner})
						(if (not (StrCmp {ego} @global402))
							((gInventory at: global351) moveTo: gEgo)
						else
							((gInventory at: global351)
								moveTo: (ReadNumber @global402)
							)
						)
						(= global402 0)
					)
					(KEY_ALT_c
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= temp2 (Event new: $7ffd)) type:)) ; evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | $0c00
							(temp2 dispose:)
						)
						(temp2 dispose:)
						(Show 1)
					)
				)
			)
		)
	)

	(method (wordFail param1 &tmp [temp0 100])
		(Print (Format @temp0 0 31 param1)) ; "Try another word. Apparently, "%s" isn't in the Andromedan dictionary."
	)

	(method (syntaxFail)
		(Print 0 32) ; "Do me a favor and try rephrasing that thought."
	)

	(method (pragmaFail &tmp [temp0 100])
		(Print 0 33) ; "Pardon me. This program is too stupid to glean your desire from such a wonderfully crafted sentence. Please try something else."
	)
)

(instance Glowing_Gem of InvI
	(properties
		name {Glowing Gem}
		said '/crystal[<glowing]/'
		description {You are still carrying the piece of orium you picked up on Labion during your last adventure. However, it has long since lost its glow.}
		view 242
	)
)

(instance Wire of InvI
	(properties
		said '/cable'
		description {It's a piece of SQ-approved electrical wire.}
		owner 6
		view 242
		cel 1
	)
)

(instance Ladder of InvI
	(properties
		said '/ladder/'
		description {This is a ladder. The evenly spaced rungs allow altitude adjustment.}
		owner 15
		view 242
		cel 2
	)
)

(instance Reactor of InvI
	(properties
		said '/generator/'
		description {This is an auxiliary reactor.}
		owner 15
		view 242
		cel 3
	)
)

(instance Orat_on_a_Stick of InvI
	(properties
		name {Orat on a Stick}
		said '/orat,stick'
		description {Orat on a Stick! You can open his mouth, and close his mouth! Hours of fun for all!}
		owner 470
		view 242
		cel 8
	)
)

(instance ThermoWeave_Underwear of InvI
	(properties
		name {ThermoWeave Underwear}
		said '/panties'
		description {ThermoWeave Shorts.__They keep you cool, and they're oh, so stylish.}
		owner 470
		view 242
		cel 9
	)
)

(instance Astro_Chicken_Flight_Hat of InvI
	(properties
		name {Astro Chicken Flight Hat}
		said '/cap'
		description {Wow! Your Official Astro Chicken Flight Hat!__Man, the babes'll really dig you in this!}
		owner 470
		view 242
		cel 6
	)
)

(instance Monolith_Decoder_Ring of InvI
	(properties
		name {Monolith Decoder Ring}
		said '/decoder,prize'
		description {With this ring, you can decode any secret message!__Well, almost any secret message.}
		owner 29
		view 242
		cel 5
	)
)

(instance Buckazoids of InvI
	(properties
		said '/bill'
		view 242
		cel 7
	)

	(method (showSelf)
		(Print (Format @global402 0 34 global154) #icon view loop cel) ; "You possess %d of these nifty monetary units known as `Buckazoids'."
	)
)

(instance Metal_Pole of InvI
	(properties
		name {Metal Pole}
		said '/pole'
		description {A handy metal pole.}
		owner 69
		view 242
		cel 11
	)
)

(instance Thermal_Detonator of InvI
	(properties
		name {Thermal Detonator}
		said '/detonator'
		description {Used for blowing stuff to little bits.___It has an impact switch, so in other words...DON'T DROP IT!}
		owner 69
		view 242
		cel 12
	)
)

(instance Keycard of InvI
	(properties
		said '/card'
		description {Elmo Pug's personal keycard for opening locked doors.}
		owner 93
		view 242
		loop 1
	)
)

(instance Coveralls of InvI
	(properties
		said '/attire'
		description {A pair of janitor's coveralls. Used for looking the part.}
		owner 90
		view 242
		cel 14
	)
)

(instance Vaporizer of InvI
	(properties
		said '/mrgarbage'
		description {Mr. Garbage: a janitor's best friend. Designed to vaporize all nonorganic biodegradable matter (i.e. trash).}
		owner 90
		view 242
		cel 15
	)
)

(instance Elmo_s_picture of InvI
	(properties
		name {Elmo's picture}
		said '/original'
		description {A fine likeness of Elmo Pug's mug. Elmo Pug is the dashing young owner of ScumSoft, Inc.}
		owner 92
		view 242
		cel 13
	)
)

(instance a_copy_of_Elmo_s_picture of InvI
	(properties
		name {a copy of Elmo's picture}
		said '/copy'
		description {A fine likeness of a likeness of Elmo Pug's mug.}
		owner 92
		view 242
		cel 13
	)
)

(instance Invisibility_Belt of InvI
	(properties
		name {Invisibility Belt}
		said '/belt'
		description {Terminator's invisibility belt.}
		owner -1
		view 242
		cel 10
	)
)

(instance Bag_of_Fast_Food of InvI
	(properties
		name {Bag of Fast Food}
		said '/bag,dinner'
		description {A bag chock-full of gastric delights!}
		owner -1
		view 242
		cel 4
	)
)

(instance calc of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 27
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			setPri: 15
			posn: 159 94
			stopUpd:
		)
	)
)

