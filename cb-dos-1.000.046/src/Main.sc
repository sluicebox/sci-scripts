;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use DCIcon)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	CB1 0
	Say 1
	LookAt 2
	HandsOff 3
	HandsOn 4
	SetFlag 5
	ClearFlag 6
	IsFlag 7
	HaveMem 8
	NotClose 9
	AlreadyTook 10
	SeeNothing 11
	CantDo 12
	DontHave 13
	RedrawCast 14
	cls 15
	AlreadyOpen 16
	AlreadyClosed 17
	NotHere 18
	EgoDead 19
	IsFirstTimeInRoom 20
	LoadMany 21
	Ok 22
	proc0_23 23
	proc0_24 24
	DoLook 25
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
	gMyWindow
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
	gElevatorState
	; 110
	global110
	global111 = 42
	global112
	global113
	global114
	; 115
	gJeevesChoresState
	global116
	global117
	gMustDos
	gCaneLocation
	; 120
	global120
	gWilburCorpseRoomNum
	global122
	gCorpseFlags
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
	global136 = 7
	global137
	gTombBarred
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
	gClarenceWilburState
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
	gAct
	global166
	global167
	gCigarButtLocation
	global169
	; 170
	gEthelCorpseRoomNum
	global171
	global172
	gSpyFlags
	global174
	; 175
	global175
	gMMSaidsAnchor
	gGertieRoomState
	global178
	global179
	; 180
	global180
	global181
	global182
	gConMusic
	global184
	; 185
	global185
	gHour = 6
	gMinute = 3
	global188
	global189
	; 190
	global190
	global191
	gFifiState
	global193
	global194
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	gEthelState
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
	gMmMouseDownHandler
	global219
	; 220
	global220
	global221
	global222
	gDetailLevel
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
	gCycleTimers
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
	gAtticFirstTime
	gGate
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
	gCellar
	gGetItemMusic
)

(procedure (LookAt param1 param2)
	(DirLoop param1 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(if (== argc 3)
		(LookAt param2 param1)
	)
)

(procedure (HandsOff)
	(localproc_0 0)
)

(procedure (HandsOn)
	(localproc_0 1)
)

(procedure (localproc_0 param1)
	(User canControl: param1 canInput: param1)
	(gEgo setMotion: 0)
)

(procedure (HaveMem param1)
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (NotClose)
	(Print 0 9) ; "You're not close enough."
)

(procedure (AlreadyTook)
	(Print 0 10) ; "You already took it."
)

(procedure (AlreadyOpen)
	(Print 0 11) ; "It is already open."
)

(procedure (AlreadyClosed)
	(Print 0 12) ; "It is already closed."
)

(procedure (SeeNothing)
	(Print 0 13) ; "You see nothing special."
)

(procedure (CantDo)
	(Print 0 14) ; "You can't do that."
)

(procedure (DontHave)
	(Print 0 15) ; "You don't have it."
)

(procedure (NotHere)
	(Print 0 16) ; "You don't see it here."
)

(procedure (Ok)
	(Print 0 17) ; "Okay."
)

(procedure (RedrawCast) ; UNUSED
	(Animate (gCast elements:) 0)
)

(procedure (proc0_24) ; UNUSED
	(Print 0 18) ; "It is very difficult to talk to two people at once."
)

(procedure (cls)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (EgoDead param1 param2)
	(gSounds eachElementDo: #dispose)
	((Sound new:) number: 100 play:)
	(= global221 999)
	(gGame setCursor: 999 1)
	(repeat
		(switch
			(Print
				param1
				param2
				#icon
				global128
				global129
				global130
				#mode
				1
				#width
				240
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
				(= global132 0)
				(break)
			)
		)
	)
)

(procedure (IsFirstTimeInRoom &tmp temp0 temp1)
	(if (not (& global152 $8000))
		(|= global152 $8000)
		(= temp0 (/ gCurRoomNum 16))
		(= temp1 (<< $0001 (mod gCurRoomNum 16)))
		(if (not (& [global148 temp0] temp1))
			(return (|= [global148 temp0] temp1))
		)
	)
	(return 0)
)

(procedure (Say param1 &tmp temp0 [temp1 500])
	(if (and (== global213 5) (== gAct 4) (== gCurRoomNum 74))
		(= temp0 928)
	else
		(= temp0 (+ global213 899))
	)
	(= global132 param1)
	(GetFarText &rest @temp1)
	(myIcon view: temp0 cycleSpeed: 8 count: (+ (/ (StrLen @temp1) 18) 1))
	(Print &rest #icon myIcon 0 0)
	(= global132 0)
)

(procedure (proc0_23)
	(= global213 12)
	(Say 1 &rest)
)

(procedure (localproc_1 &tmp temp0)
	(= global172
		(= global178
			(= global179
				(= global180
					(= gMustDos (= global116 (= global117 (= gSpyFlags 0))))
				)
			)
		)
	)
	(if (== (++ gAct) 5)
		(SetFlag 47)
	)
	(&= global166 (<< $0001 gAct))
	(for ((= temp0 0)) (< temp0 148) ((++ temp0))
		(= [global225 temp0] 0)
	)
)

(procedure (DoLook param1 &tmp temp0)
	(StrCpy (User inputLineAddr:) {Look })
	(StrCat (User inputLineAddr:) param1)
	((= temp0 (Event new:)) type: evSAID)
	(Parse (User inputLineAddr:) temp0)
	(User said: temp0)
	(temp0 dispose:)
)

(procedure (LoadMany param1 param2 &tmp temp0 temp1)
	(-= argc 2)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= temp1 [param2 temp0])
		(switch param1
			(0
				(DisposeScript temp1)
			)
			(142
				(Load rsVIEW (+ temp1 899))
			)
			(143
				(Load rsSCRIPT temp1)
				(Load rsTEXT temp1)
			)
			(else
				(Load param1 temp1)
			)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(= temp0 (/ param2 16))
	(= temp1 (<< $0001 (mod param2 16)))
	(switch param1
		(0
			(|= [global440 temp0] temp1)
		)
		(1
			(return (& [global440 temp0] temp1))
		)
		(2
			(&= [global440 temp0] (~ temp1))
		)
	)
)

(procedure (SetFlag param1)
	(localproc_2 0 param1)
)

(procedure (IsFlag param1)
	(localproc_2 1 param1)
)

(procedure (ClearFlag param1)
	(localproc_2 2 param1)
)

(instance MMSaidsAnchor of Prop
	(properties)
)

(instance myIcon of DCIcon
	(properties)

	(method (init)
		(if global132
			((= cycler (Fwd new:)) init: self)
		)
	)
)

(class newInvItem of InvI
	(properties)

	(method (showSelf)
		(Print 0 0 #title name #icon view 0 0)
	)
)

(instance statusCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(StrCpy param1 0 1)
	)
)

(instance ego of Ego
	(properties)
)

(instance conMusic of Sound
	(properties
		number 93
	)
)

(instance getItemMusic of Sound
	(properties
		number 93
		priority 2
		owner -1
	)
)

(class myWindow of SysWindow
	(properties
		color 15
		back 8
		type 129
		underBits 0
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp7 (CelHigh 657 0 0))
		(= temp5 (CelHigh 657 0 1))
		(= temp6 (CelHigh 657 1 0))
		(= temp8 (CelWide 657 0 0))
		(SetPort 0)
		(= temp1 (- top 8))
		(= temp2 (- left 8))
		(= temp3 (+ bottom 8))
		(= temp4 (+ right 8))
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= underBits (Graph grSAVE_BOX temp1 temp2 temp3 temp4 temp0))
		(Graph grFILL_BOX temp1 temp2 temp3 temp4 temp0 back priority)
		(DrawCel 657 0 0 temp2 temp1 -1)
		(DrawCel 657 0 1 temp2 (- temp3 temp5) -1)
		(DrawCel 657 1 0 (- temp4 temp6) temp1 -1)
		(DrawCel 657 1 2 (- temp4 temp6) (- temp3 temp5) -1)
		(Graph grDRAW_LINE temp1 (+ temp2 temp8) temp1 (- temp4 temp8) 31 -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 2)
			(+ temp2 temp8)
			(+ temp1 2)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 1)
			(+ temp2 temp8)
			(- temp3 1)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 3)
			(+ temp2 temp8)
			(- temp3 3)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph grDRAW_LINE (+ temp1 temp7) temp2 (- temp3 temp7) temp2 31 -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(+ temp2 2)
			(- temp3 temp7)
			(+ temp2 2)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 1)
			(- temp3 temp7)
			(- temp4 1)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 3)
			(- temp3 temp7)
			(- temp4 3)
			31
			-1
			-1
		)
		(Graph grUPDATE_BOX temp1 temp2 temp3 temp4 1)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grREDRAW_BOX (- top 8) (- left 8) (+ bottom 8) (+ right 8))
		(DisposeWindow window)
		(DisposeClone self)
	)
)

(instance mmMouseDownHandler of EventHandler
	(properties)
)

(instance CB1 of Game
	(properties)

	(method (init)
		(= global190 1)
		(= gMMSaidsAnchor MMSaidsAnchor)
		(= gMyWindow myWindow)
		(if (< (Graph grGET_COLOURS) 16)
			(gMyWindow color: 15 back: 0)
		)
		(User alterEgo: (= gEgo ego))
		(super init:)
		((= gMmMouseDownHandler mmMouseDownHandler) add:)
		(= global221 999)
		(Inv
			add:
				necklace_
				monocle_
				lantern_
				oilcan_
				rolling_pin_
				skeleton_key_
				poker_
				crowbar_
				cigar_butt_
				broken_record_
				notebook___pencil_
				_7_crackers________
				soup_bone_
				valve_handle_
				bullet_
				derringer__
				matches_
				carrot_
				brass_key_
				diary_
				crank_
				cane_
				pouch_
				handkerchief_
		)
		(= global181 1)
		(= gShowStyle 0)
		(= gUserFont (= gBigFont 1))
		(= gVersion {1.000.046})
		(TheMenuBar init: draw: state: 0 hide:)
		(getItemMusic init:)
		(= gGetItemMusic getItemMusic)
		(conMusic owner: self init:)
		(= gConMusic conMusic)
		(= global157 0)
		(SetCursor 997 0 320 200)
		(gEgo view: 0 x: 100 y: 120)
		(if (GameIsRestarting)
			(= gPossibleScore 1)
			(SetCursor 997 0 320 200)
			(TheMenuBar draw: state: 1 hide:)
		)
		(self newRoom: 99)
	)

	(method (replay)
		(= gUserFont gBigFont)
		(SetMenu 1283 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(TheMenuBar draw: hide:)
		(super replay:)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(
				(and
					(not global101)
					(== (= temp1 (gEgo view:)) 0)
					(not (gEgo avoider:))
					(or (not (gEgo mover:)) (gEgo isBlocked:))
					(== (gEgo x:) (gEgo xLast:))
					(== (gEgo y:) (gEgo yLast:))
				)
				(gEgo view: 11 setMotion: 0)
			)
			((and (== temp1 11) (gEgo mover:))
				(gEgo view: 0)
			)
		)
		(if global182
			(= global182 0)
			(getItemMusic play:)
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (> [gCycleTimers temp0] 1)
				(-- [gCycleTimers temp0])
			)
		)
		(if (> global161 0)
			(-- global161)
		)
		(if (> global220 0)
			(-- global220)
		)
		(cond
			((and (== (User controls:) 0) (== global221 999))
				(= global221 997)
				(gGame setCursor: 997 1)
			)
			((and (== global221 997) (== (User controls:) 1))
				(= global221 999)
				(gGame setCursor: 999 1)
			)
		)
		(super doit:)
	)

	(method (startRoom roomNum &tmp temp0 temp1)
		(= global216 0)
		(LoadMany 0 978 990)
		(gMmMouseDownHandler release:)
		(gMmMouseDownHandler add: gCast gFeatures)
		(HandsOn)
		(cls)
		(&= global152 $7fff)
		(= global195 (= global208 (= global214 0)))
		(for ((= temp1 0)) (< temp1 11) ((++ temp1))
			(= [global377 temp1] 0)
		)
		(if (== gMustDos 15)
			(localproc_1)
		)
		(super startRoom: roomNum)
		(Load rsVIEW 911)
		(Load rsSCRIPT 413)
		(LoadMany rsMESSAGE 407 410)
		(cond
			((or (< roomNum 31) (== roomNum 65))
				(gCurRoom setRegions: 208) ; outsideReg
				(if (and (& gCorpseFlags $0040) (!= roomNum 16)) ; Lillian
					(gCurRoom setRegions: 400) ; barkReg
				)
			)
			(
				(or
					(< roomNum 51)
					(== roomNum 74)
					(== roomNum 73)
					(== roomNum 75)
					(== roomNum 76)
					(== roomNum 53)
					(== roomNum 63)
				)
				(if (and (& gCorpseFlags $0040) (!= gCurRoomNum 74)) ; Lillian
					(gCurRoom setRegions: 401) ; scuffReg
				)
				(gCurRoom setRegions: 210) ; insideReg
			)
		)
		(= global216 1)
		(if
			(not
				(or
					(== roomNum 36)
					(and
						(== roomNum 38)
						(== gAct 0)
						(not (& gSpyFlags $0002))
					)
					(and (== roomNum 32) (< gAct 4))
					(and (== roomNum 44) (== gAct 0))
					(and (== roomNum 75) (& gCorpseFlags $0040)) ; Lillian
				)
			)
			(= temp0 (ScriptID 990))
		)
	)

	(method (handleEvent event &tmp [temp0 18])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			((super handleEvent: event))
			(evMOUSEBUTTON
				(if (not (event claimed:))
					(gMmMouseDownHandler handleEvent: event)
				)
			)
			(evSAID
				(if (and (not (event claimed:)) global219)
					(MMSaidsAnchor setScript: (ScriptID 410 0)) ; InvSaids
					((MMSaidsAnchor script:) handleEvent: event)
				)
				(if (not (event claimed:))
					(MMSaidsAnchor setScript: (ScriptID 407 0)) ; MMSaids
					((MMSaidsAnchor script:) handleEvent: event)
				)
			)
		)
		(= global213 0)
	)
)

(instance necklace_ of newInvItem
	(properties
		name {necklace }
		said '/necklace'
		owner 99
		view 602
	)
)

(instance monocle_ of newInvItem
	(properties
		name {monocle }
		said '/monocle'
		view 604
	)
)

(instance lantern_ of newInvItem
	(properties
		name {lantern }
		said '/lantern'
		owner 69
		view 613
	)

	(method (showSelf)
		(Print 0 0 #icon 613 0 (if global137 1 else 0))
	)
)

(instance oilcan_ of newInvItem
	(properties
		name {oilcan }
		said '/can'
		owner 61
		view 611
	)
)

(instance rolling_pin_ of newInvItem
	(properties
		name {rolling pin }
		said '/pin'
		owner 25
		view 626
	)
)

(instance skeleton_key_ of newInvItem
	(properties
		name {skeleton key }
		said '/key<skeleton'
		owner 58
		view 620
	)
)

(instance poker_ of newInvItem
	(properties
		name {poker }
		said '/poker'
		owner 32
		view 627
	)
)

(instance crowbar_ of newInvItem
	(properties
		name {crowbar }
		said '/crowbar'
		owner 61
		view 607
	)
)

(instance cigar_butt_ of newInvItem
	(properties
		name {cigar butt }
		said '/butt,butt'
		view 628
	)
)

(instance broken_record_ of newInvItem
	(properties
		name {broken record }
		said '/record'
		owner 36
		view 625
	)
)

(instance notebook___pencil_ of newInvItem
	(properties
		name {notebook & pencil }
		said '/notebook,pencil'
		owner 44
		view 601
	)
)

(instance _7_crackers________ of newInvItem
	(properties
		name {7 crackers________}
		said '/cracker,box'
		owner 53
		view 603
	)

	(method (ownedBy)
		(switch global136
			(0
				(Format (_7_crackers________ name:) 0 2 0 3) ; "%s"
				(_7_crackers________ view: 643)
			)
			(1
				(Format (_7_crackers________ name:) 0 4 global136 0 5) ; "%u%s"
			)
			(else
				(Format (_7_crackers________ name:) 0 4 global136 0 6) ; "%u%s"
			)
		)
		(super ownedBy: &rest)
	)
)

(instance soup_bone_ of newInvItem
	(properties
		name {soup bone }
		said '/bone'
		owner 35
		view 605
	)
)

(instance valve_handle_ of newInvItem
	(properties
		name {valve handle }
		said '/valve,handle'
		owner 37
		view 606
	)
)

(instance bullet_ of newInvItem
	(properties
		name {bullet }
		said '/bullet'
		owner 65
		view 618
	)
)

(instance derringer__ of newInvItem
	(properties
		name {derringer__}
		said '/derringer'
		owner 31
		view 617
	)

	(method (ownedBy)
		(if global185
			(Format (derringer__ name:) 0 2 0 7) ; "%s"
		else
			(Format (derringer__ name:) 0 2 0 8) ; "%s"
		)
		(super ownedBy: &rest)
	)
)

(instance matches_ of newInvItem
	(properties
		name {matches }
		said '/match'
		owner 67
		view 614
	)
)

(instance carrot_ of newInvItem
	(properties
		name {carrot }
		said '/carrot'
		owner 59
		view 615
	)
)

(instance brass_key_ of newInvItem
	(properties
		name {brass key }
		said '/key'
		owner 42
		view 619
	)
)

(instance diary_ of newInvItem
	(properties
		name {diary }
		said '/diary'
		owner 44
		view 616
	)
)

(instance crank_ of newInvItem
	(properties
		name {crank }
		said '/control'
		owner 3
		view 621
	)
)

(instance cane_ of newInvItem
	(properties
		name {cane }
		said '/cane'
		view 612
	)
)

(instance pouch_ of newInvItem
	(properties
		name {pouch }
		said '/diamond'
		owner 57
		view 622
	)
)

(instance handkerchief_ of newInvItem
	(properties
		name {handkerchief }
		said '/handkerchief'
		owner 47
		view 630
	)
)

