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
	KQ5 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	RedrawCast 5
	cls 6
	proc0_7 7
	proc0_8 8
	SetFlag 10
	ClearFlag 11
	proc0_12 12
	IsFlag 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
	proc0_21 21
	proc0_22 22
	proc0_23 23
	proc0_24 24
	proc0_25 25
	proc0_26 26
	EgoDead 27
	SetScore 28
	Say 29
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
	gWaitCursor = 994
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVolume = 14
	gVersion = {ego}
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
	gUIcons
	global56
	global57 = -1
	global58
	gMyWindow
	; 60
	global60 = 40
	global61 = 189
	global62 = 319
	global63
	global64 = 4
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
	global76 = 3
	global77
	global78
	global79
	; 80
	global80
	global81 = 3
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
	gGlobalSound
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
	global289 = 2
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
	global319 = 15
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
)

(procedure (proc0_17 param1 param2 param3)
	(cond
		((< param2 param1)
			(= param2 param1)
		)
		((> param2 param3)
			(= param2 param3)
		)
	)
	(return param2)
)

(procedure (proc0_14 param1 param2 param3)
	(if (< param1 param2 param3)
		(if (< param2 (/ (+ param1 param3) 2))
			(= param2 param1)
		else
			(= param2 param3)
		)
	)
	(return param2)
)

(procedure (proc0_20 &tmp temp0)
	(repeat
		(breakif (!= (= temp0 (GetNumber {Teleport to:})) -1))
	)
	(= global103 0)
	(gGame
		setCursor:
			(= global106 global119)
			(| (HaveMouse) (!= global70 (gUIcons at: 0)))
	)
	(&= global71 $fffb)
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
		moveSpeed: global289
		setCycle: Walk
		cycleSpeed: 0
		setStep: 3 2
		offset: 3
		normal: 1
		illegalBits: -32768
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(TheIconBar state: 0)
	(= global102 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(TheIconBar state: 1)
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

(procedure (proc0_19 param1 param2 param3 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
		(Palette palSET_INTENSITY param1 param2 temp0)
		(Wait param3)
	)
)

(procedure (proc0_16 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if global156
		(Display 0 19 dsRESTOREPIXELS global157)
		(Display 0 19 dsRESTOREPIXELS global156)
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
				7
				dsSAVEPIXELS
			)
		)
	)
)

(procedure (proc0_7 param1 param2 param3 &tmp temp0)
	(proc0_25
		param1
		(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
		param3
	)
	(if (== argc 4)
		(proc0_7 param2 param1 param3)
	)
)

(procedure (proc0_25 param1 param2 param3 &tmp temp0)
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
	)
)

(procedure (proc0_18 param1 param2)
	(if
		(and
			(> (param2 x:) (param1 nsLeft:))
			(< (param2 x:) (param1 nsRight:))
			(> (param2 y:) (param1 nsTop:))
			(< (param2 y:) (param1 nsBottom:))
		)
		(return 1)
	else
		(return 0)
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

(procedure (proc0_21 param1 &tmp temp0)
	(if (== (param1 message:) 5)
		(switch global69
			(28
				(PrintDC 0 20) ; "Graham gives the wand a good shake, but it only fizzles and dies."
			)
			(35
				(PrintDC 0 21) ; "Graham waves Mordack's glowing wand...but nothing happens. Could it be that Crispin was right? That wands only respond to their owner...like a pet?"
			)
			(else
				(localproc_0 942 3 12)
			)
		)
	else
		(localproc_0 942 3 12)
	)
)

(procedure (proc0_22) ; UNUSED
	(localproc_0 942 3 12)
)

(procedure (localproc_0 param1 param2 param3)
	(if (User canInput:)
		(gGame setCursor: 5 1)
		(= global126 0)
		(signalView
			view: param1
			loop: param2
			cel: param3
			posn: global122 (+ 289 (CelHigh 942 3 12))
		)
		(signalView
			posn: global122 (signalView y:) (- (signalView y:) global123)
			forceUpd:
			show:
		)
		(Animate (gCast elements:) 0)
		(proc0_23)
		(signalView posn: 1000 1000 hide:)
		(proc0_26 (| (HaveMouse) (!= global70 (gUIcons at: 0))))
	)
)

(procedure (proc0_23 &tmp temp0 temp1)
	(= temp0 (GetTime))
	(while (< (Abs (- temp0 (GetTime))) 40)
		(breakif (proc0_15 ((= temp1 (Event new:)) type:) 4 1))
		(temp1 dispose:)
	)
	(if (IsObject temp1)
		(temp1 dispose:)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3)
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
	(localproc_1 0 &rest)
)

(procedure (IsFlag)
	(localproc_1 1 &rest)
)

(procedure (ClearFlag)
	(localproc_1 2 &rest)
)

(procedure (proc0_12) ; UNUSED
	(localproc_1 3 &rest)
)

(procedure (proc0_15 param1 param2 &tmp temp0 temp1)
	(= temp1 (- argc 1))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(breakif (== param1 [param2 temp0]))
	)
	(return (< temp0 temp1))
)

(procedure (proc0_24 param1 param2 &tmp temp0 temp1)
	(-= argc 2)
	(for ((= temp0 0)) (<= temp0 argc) ((++ temp0))
		(= temp1 [param2 temp0])
		(switch param1
			(0
				(DisposeScript temp1)
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

(procedure (EgoDead param1 param2 param3 param4)
	(HandsOff)
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
)

(procedure (SetScore param1)
	(rm0Sound priority: 15 number: 65 loop: 1 play:)
	(if argc
		(+= gScore param1)
	)
)

(procedure (Say param1 param2 param3 &tmp [temp0 500])
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp0)
	else
		(StrCpy @temp0 param2)
	)
	(talkerIcon
		view: param1
		cycler: Fwd
		cycleSpeed: 6
		count: (+ (/ (StrLen @temp0) 20) 1)
		talker: 1
	)
	(if (u< param2 1000)
		(Print @temp0 &rest #icon talkerIcon 0 0)
	else
		(Print @temp0 param3 &rest 82 talkerIcon 0 0)
	)
)

(procedure (proc0_26 param1 &tmp temp0 temp1)
	(if (and (not (HaveMouse)) (not (User canInput:)) gModelessDialog)
		(return)
	)
	(= temp1 (gUIcons at: 0))
	(= temp0 (gUIcons at: 1))
	(cond
		((== param1 -32768)
			(= global104 global106)
			(= gTheCursor -1)
		)
		(global103
			(= global104 5)
		)
		((== (User controls:) 0)
			(cond
				((== (User canInput:) 0)
					(= param1 1)
					(= global104 gWaitCursor)
				)
				((proc0_15 global119 996 6)
					(= param1 1)
					(= global104 995)
				)
				(else
					(= global104 global106)
				)
			)
			(temp1 state: (& (temp1 state:) $fffe))
			(temp0 state: (& (temp0 state:) $fffe))
		)
		(
			(and
				(== (User controls:) 1)
				(or
					(not (& (temp1 state:) $0001))
					(not (& (temp0 state:) $0001))
				)
			)
			(if (== (global65 eMessage:) 0)
				(= global119 (if (== global65 temp0) 6 else 996))
			)
			(= global104
				(= global106
					(if (and (== global119 996) (not (HaveMouse)))
						5
					else
						global119
					)
				)
			)
			(temp1 state: (| (temp1 state:) $0001))
			(temp0 state: (| (temp0 state:) $0001))
		)
		(else
			(= global104 global106)
		)
	)
	(if (!= gTheCursor global104)
		(if (== (global65 eMessage:) 0)
			(&= global71 $fffb)
		)
		(gGame setCursor: global104 (| (& global71 $0004) param1))
	)
)

(instance ego of Body
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(!= (event type:) evVERB)
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (IsFlag 75)
						(PrintDC 0 0) ; "Graham gently carries his friend Cedric, who has been wounded by the horrible harpies."
					else
						(PrintDC 0 1) ; "King Graham, heavy of heart, searches far and wide for his beloved family who've been stolen by an evil wizard."
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(cond
						((== global69 10) ; Harp
							(if (and (!= gCurRoomNum 90) (!= gCurRoomNum 85))
								(rm0Sound number: 52 loop: 1 play:)
								(PrintDC
									{Having learned to play the harp long ago, Graham now plays beautifully.}
								)
								(rm0Sound stop:)
								(event claimed: 1)
							)
						)
						((== global69 26) ; Cloak
							(cond
								((IsFlag 16)
									(PrintDC 0 2) ; "Graham is already wearing the warm cloak."
									(event claimed: 1)
								)
								((not (proc0_15 gCurRoomNum 29 30))
									(PrintDC 0 3) ; "Here, the air is too warm to be wearing heavy outer garments."
									(event claimed: 1)
								)
							)
						)
						((== global69 34) ; Tambourine
							(if
								(or
									(IsFlag 16)
									(not (proc0_15 gCurRoomNum 29 30 85 2 90))
									(and (== gCurRoomNum 2) (IsFlag 48))
								)
								(rm0Sound number: 50 loop: 1 play:)
								(PrintDC
									{Graham hits and shakes the tambourine with much ruckus, but finds it doesn't accomplish anything.}
								)
								(event claimed: 1)
							)
						)
						((== global69 17) ; Honeycomb
							(if (!= gCurRoomNum 24)
								(PrintDC
									{Graham has no desire to put the dirty honeycomb in his mouth no matter how tempting the honey may be!}
								)
								(event claimed: 1)
							)
						)
						(
							(proc0_15
								global69
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
							(switch global69
								(2 ; Pie
									(SetFlag 17)
									(PrintDC 0 4) ; "Mmmmmmm! That was the best custard pie Graham has ever eaten!"
									((gInventory at: 2) moveTo: 1) ; Pie
									(event claimed: 1)
								)
								(19 ; Leg_of_Lamb
									(if (== (++ global316) 1)
										(SetScore 4)
										(SetFlag 17)
										(PrintDC 0 5) ; "Graham finds the leg of lamb a bit tough, but tasty enough. Filling up quickly, he saves the other half for later."
										((gInventory at: 19) ; Leg_of_Lamb
											cel: 7
											cursor: 52
											moveTo: gCurRoomNum
										)
										(gEgo get: 19) ; Leg_of_Lamb
									else
										(PrintDC 0 6) ; "Feeling a bit hungry, Graham finishes off the other half of the leg of lamb."
										((gInventory at: 19) moveTo: 1) ; Leg_of_Lamb
									)
									(event claimed: 1)
								)
								(27 ; Amulet
									(if (IsFlag 85)
										(PrintDC
											{Graham is already wearing the amulet around his neck.}
										)
									else
										(PrintDC
											{The magic amulet begins to glow softly as Graham slips it over his head. He then carefully tucks the amulet into the front of his tunic, hiding it from sight.}
										)
										(rm0Sound
											priority: 15
											number: 65
											loop: 1
											play:
										)
										(SetFlag 85)
									)
									(event claimed: 1)
								)
								(else
									(if
										(or
											(IsFlag 16)
											(not (proc0_15 gCurRoomNum 29 30))
										)
										(PrintDC
											(switch global69
												(32 {The moldy cheese is not fit for eating.}) ; Moldy_Cheese
												(15 {Unfortunately Graham is all thumbs when it comes to operating a spinning wheel.}) ; Spinning_Wheel
												(33 {Even though these are a very fine pair of shoes, Graham finds them too small for his own feet.}) ; Elf_Shoes
												(12 {Graham is too old to play with toys!}) ; Marionette
												(22 {Nothing would be accomplished by using the hammer here.}) ; Hammer
												(25 {Wearing the delicate locket would detract from Graham's "manly" appearance.}) ; Locket
												(36 {Graham would look silly wearing that hairpin!}) ; Hairpin
												(8 {Wearing one old shoe would do Graham no good at all!}) ; Shoe
												(18 {The lump of beeswax has become soft and sticky from the warmth of Graham's body.}) ; Beeswax
												(else {The smelly old fish is much too disgusting for human consumption.})
											)
										)
										(event claimed: 1)
									)
								)
							)
						)
					)
				)
				(4 ; Talk
					(if (IsFlag 75)
						(PrintDC 0 7) ; "Cedric is in too much pain to carry on a conversation right now."
					else
						(PrintDC 0 8) ; "Talking to yourself again, Graham?"
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (IsFlag 75)
						(PrintDC 0 9) ; "Poor Cedric is hurt and needs help. How can Graham help him?"
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
		priority 1
	)
)

(instance globalSound2 of Sound
	(properties
		priority 2
	)
)

(instance globalSound3 of Sound
	(properties
		priority 3
	)
)

(instance globalSound4 of Sound
	(properties
		priority 4
	)
)

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

(instance KQ5 of Game
	(properties)

	(method (init &tmp [temp0 270])
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(= global159 0)
		else
			(= global159 1)
		)
		((= gMyWindow myWindow)
			color: (if global159 8 else 0)
			back: (if global159 23 else 7)
			lineColor: (if global159 19 else 4)
		)
		(= global330 {Thanks for playing King's Quest V.})
		(gGame setSpeed: 2)
		(= global60 40)
		(= global62 319)
		(= global61 189)
		(= global63 0)
		(super init:)
		(= gVersion {0.000.062})
		(if (== (StrAt gVersion 0) 120)
			(= global100 1)
		else
			(= global100 0)
		)
		(= gShowStyle 30)
		(User
			blocks: 0
			canControl: 0
			x: -1
			y: 150
			init: (User inputLineAddr:) 30
		)
		((= gEgo ego) looper: MyLooper)
		(User alterEgo: gEgo)
		(HandsOn)
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
		(DoSound sndSET_SOUND 1)
		(cls)
		(TheIconBar
			barColor: (if global159 41 else 3)
			shadowColor: (if global159 0 else 0)
			selBoxColor: (if global159 7 else 31)
			height: (CelHigh 942 3 2)
			state: 1
		)
		(UIcons
			add:
				icon0
				icon1
				icon2
				icon3
				icon4
				icon5
				icon6
				icon7
				icon8
				icon9
				icon10
			eachElementDo: #init
		)
		(Inv
			add:
				Ok
				Key
				Pie
				Golden_Needle
				Coin
				Fish
				Brass_Bottle
				Staff
				Shoe
				Heart
				Harp
				Gold_Coin
				Marionette
				Pouch
				Emeralds
				Spinning_Wheel
				Stick
				Honeycomb
				Beeswax
				Leg_of_Lamb
				Rope
				Crystal
				Hammer
				Shell
				Bag_of_Peas
				Locket
				Cloak
				Amulet
				Wand
				Sled
				Iron_Bar
				Fishhook
				Moldy_Cheese
				Elf_Shoes_
				Tambourine
				Mordack_s_Wand
				Hairpin
				Cat_Fish
				Mongoose_Spell
				Bunny_Spell
				Rain_Spell
				Tiger_Spell
		)
		(Inv
			color: (if global159 8 else 0)
			back: (if global159 23 else 7)
			lineColor: (if global159 19 else 4)
			textColor: (if global159 17 else 1)
		)
		(= global103 0)
		(= global106 (= global119 (= gNormalCursor 6)))
		(self setCursor: global119 1 159 94)
		(= global72 1)
		((= global65 (gUIcons at: 1)) cursor: gNormalCursor)
		(= global70 (= global66 global65))
		(if (GameIsRestarting)
			(= global322 1)
		)
		(self newRoom: 99)
	)

	(method (replay)
		(super replay:)
	)

	(method (doit &tmp temp0 temp1 [temp2 2])
		(if
			(and
				(!=
					(= temp0 (gEgo loop:))
					(= temp1 (- (NumLoops gEgo) 1))
				)
				(not (IsFlag 23))
				(not (gEgo avoider:))
				(gEgo normal:)
				(or (not (gEgo mover:)) (gEgo isBlocked:))
			)
			(gEgo loop: temp1 cel: temp0 setMotion: 0)
		)
		((gUIcons at: 6) eMessage: (if (HaveMouse) 3840 else 9))
		(proc0_26 (| (HaveMouse) (!= global70 (gUIcons at: 0))))
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and gModelessDialog (gModelessDialog dontErase:))
			(UnLoad 133 ((gModelessDialog window:) underBits:))
			((gModelessDialog window:) underBits: 0)
		)
		(cls)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp temp0)
		(gGlobalSound3 stop:)
		(gGlobalSound4 stop:)
		(proc0_24 136 996 6 7 8 9)
		(Load rsFONT 4)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(super startRoom: roomNum)
		(if (not (IsFlag 34))
			(signalView init: posn: 1000 1000 setPri: 15 hide:)
		)
		(= global124 160)
		(= global125 105)
		(gFeatures eachElementDo: #init)
		(if (and (!= global65 (gUIcons at: 0)) (!= global65 (gUIcons at: 1)))
			((= temp0 (Event new:)) type: evKEYBOARD message: KEY_INSERT)
			(TheIconBar handleEvent: temp0)
			(temp0 dispose:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 255])
		(if (event claimed:)
			(return)
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
				(if (and (not (event claimed:)) (not global327))
					(event claimed: 1)
					(switch (event message:)
						(KEY_TAB
							(&= global71 $fffd)
							(Inv showSelf: gEgo)
						)
						(KEY_SHIFTTAB
							(if (HaveMouse)
								(Inv showSelf: gEgo)
							)
						)
						(KEY_F1
							((ScriptID 753) doit:) ; help
						)
						(else
							(if global100
								(switch (event message:)
									(KEY_F4
										(Show 4)
										(Animate (gCast elements:))
										(while
											(==
												evNULL
												((= event (Event new: 32765))
													type:
												)
											)
											(event dispose:)
										)
										(event dispose:)
										(Show 1)
									)
									(KEY_F6
										(Show 2)
									)
									(KEY_F10
										(Show 1)
									)
									(KEY_ALT_c
										(repeat
											(breakif
												(!=
													(= temp0
														(GetNumber
															{Clear Flag#: }
														)
													)
													-1
												)
											)
										)
										(ClearFlag temp0)
									)
									(KEY_ALT_f
										(gGame showMem:)
									)
									(KEY_ALT_i
										(= temp5 (Sound pause: 1))
										(= temp8 0)
										(GetInput @temp8 8 {Inv. Object})
										(= temp7 (ReadNumber @temp8))
										(= temp8 0)
										(GetInput @temp8 12 {Owner})
										(if (not (StrCmp {ego} @temp8))
											((gInventory at: temp7)
												moveTo: gEgo
											)
										else
											((gInventory at: temp7)
												moveTo: (ReadNumber @temp8)
											)
										)
										(= temp8 0)
										(Sound pause: temp5)
									)
									(KEY_ALT_r
										(Printf 0 10 gCurRoomNum) ; "This is room %d."
									)
									(KEY_ALT_s
										(repeat
											(breakif
												(!=
													(= temp0
														(GetNumber
															{Set Flag#: }
														)
													)
													-1
												)
											)
										)
										(SetFlag temp0)
									)
									(KEY_ALT_t
										(User canControl: 1)
										(= gPrevRoomNum 0)
										(proc0_20)
									)
									(KEY_ALT_w
										(Unknown_Class_83 doit:)
									)
									(KEY_F5
										(if (IsFlag 0)
											(Print 0 11) ; "You cannot save a game right now."
										else
											(gGame save:)
										)
									)
									(KEY_F7
										(if (IsFlag 0)
											(Print 0 12) ; "You cannot restore a game right now."
										else
											(gGame restore:)
										)
									)
									(KEY_F9
										(= temp5 (Sound pause: 1))
										(if
											(Print ; "Do you wish to start over?"
												0
												13
												#font
												0
												#button
												{__Restart__}
												1
												#button
												{ Continue }
												0
											)
											(gGame restart:)
										)
										(Sound pause: temp5)
									)
									(KEY_ALT_x
										(= gQuit 1)
									)
									(KEY_ALT_z
										(= gQuit
											(Print ; "Do you really want to quit?"
												0
												14
												#font
												0
												#button
												{____Quit____}
												1
												#button
												{ Continue }
												0
											)
										)
									)
									(else
										(event claimed: 0)
									)
								)
							)
						)
					)
				)
			)
			(evVERB
				(if (not (event claimed:))
					(event claimed: 1)
					(switch (event message:)
						($000a
							(switch
								(= temp6
									(Print ; "King's Quest V"
										0
										15
										#font
										1
										#button
										{About KQV}
										1
										#button
										{Help}
										2
										#button
										{Cancel}
										0
									)
								)
								(1
									(Format @temp8 0 16 gVersion) ; "King's Quest V by Roberta Williams Version: %s (c) 1990 Sierra On-Line, Inc."
									(Print @temp8 #mode 1)
								)
								(2
									(= global360 1)
									(proc0_8 self 4 15104 0)
								)
							)
						)
						(KEY_TAB
							((ScriptID 755) doit:) ; setControls
						)
						(7
							(switch
								(= temp6
									(Print ; "King's Quest V"
										0
										17
										#font
										1
										#button
										{Save Game}
										1
										#button
										{Restore Game}
										2
										#button
										{Cancel}
										0
									)
								)
								(1
									(if 0
										(Print 0 11) ; "You cannot save a game right now."
									else
										(gGame save:)
									)
								)
								(2
									(if 0
										(Print 0 12) ; "You cannot restore a game right now."
									else
										(gGame restore:)
									)
								)
							)
						)
						(8
							(= temp5 (Sound pause: 1))
							(= temp6
								(Print ; "King's Quest V"
									0
									18
									#font
									1
									#button
									{Continue}
									0
									#button
									{Start New Game}
									1
									#button
									{Quit}
									2
								)
							)
							(Sound pause: temp5)
							(switch temp6
								(1
									(gGame restart:)
								)
								(2
									(= gQuit 1)
								)
							)
						)
						(else
							(event claimed: 0)
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
		loop 3
	)
)

(instance icon0 of IconI
	(properties
		view 942
		loop 3
		cel 0
		cursor 996
		eMessage 0
	)
)

(instance icon1 of IconI
	(properties
		view 942
		loop 3
		cel 1
		cursor 6
		eMessage 0
	)
)

(instance icon2 of IconI
	(properties
		view 942
		loop 3
		cel 2
		state 5
		cursor 7
		eMessage 2
	)
)

(instance icon3 of IconI
	(properties
		view 942
		loop 3
		cel 3
		state 5
		cursor 8
		eMessage 3
	)
)

(instance icon4 of IconI
	(properties
		view 942
		loop 3
		cel 4
		cursor 9
		eMessage 4
	)
)

(instance icon5 of IconI
	(properties
		view 942
		loop 3
		cel 5
		state 0
		eMessage 5
	)
)

(instance icon6 of IconI
	(properties
		view 942
		loop 3
		cel 6
		state 21
		cursor 999
		eType 4
	)
)

(instance icon7 of IconI
	(properties
		view 942
		loop 3
		cel 7
		state 17
		eMessage 7
	)
)

(instance icon8 of IconI
	(properties
		view 942
		loop 3
		cel 8
		state 17
		eMessage 8
	)
)

(instance icon9 of IconI
	(properties
		view 942
		loop 3
		cel 9
		state 17
		eMessage 9
	)
)

(instance icon10 of IconI
	(properties
		view 942
		loop 3
		cel 10
		state 17
		eMessage 10
	)
)

(instance Ok of InvI
	(properties
		view 941
		state 8
	)
)

(instance Key of InvI
	(properties
		description {It is a tiny brass key.}
		owner 23
		view 941
		loop 1
		cel 7
		cursor 15
	)
)

(instance Pie of InvI
	(properties
		description {Mmmmmm. The custard pie looks delicious!}
		owner 206
		view 941
		cel 13
		cursor 16
	)
)

(instance Golden_Needle of InvI
	(properties
		name {Golden Needle}
		description {This is a large golden needle.}
		owner 27
		view 941
		cel 14
		cursor 17
	)
)

(instance Coin of InvI
	(properties
		description {It is a common silver coin.}
		owner 4
		view 941
		cel 3
		cursor 18
	)
)

(instance Fish of InvI
	(properties
		description {Whew! This smelly old fish is disgusting!}
		owner 4
		view 941
		cel 12
		cursor 19
	)
)

(instance Brass_Bottle of InvI
	(properties
		name {Brass Bottle}
		description {This is an old, tarnished brass bottle.}
		owner 18
		view 941
		loop 1
		cel 6
		cursor 20
	)

	(method (doit)
		(gCurRoom newRoom: 208) ; releaseGenie
		(return 1)
	)
)

(instance Staff of InvI
	(properties
		description {The jeweled staff is obviously the work of an expert craftsman.}
		owner 17
		view 941
		loop 1
		cel 4
		cursor 21
	)
)

(instance Shoe of InvI
	(properties
		description {The worn old shoe is cracked and dry from the desert sun.}
		owner 15
		view 941
		cel 8
		cursor 51
	)
)

(instance Heart of InvI
	(properties
		description {The small heart is made of pure gold.}
		owner 21
		view 941
		loop 1
		cel 10
		cursor 22
	)
)

(instance Harp of InvI
	(properties
		description {It is a small harp of beautifully carved mahogany.}
		owner 9
		view 941
		cel 9
		cursor 23
	)
)

(instance Gold_Coin of InvI
	(properties
		name {Gold Coin}
		description {It is a shiny gold coin.}
		owner 18
		view 941
		loop 1
		cel 5
		cursor 18
	)
)

(instance Marionette of InvI
	(properties
		description {The craftsmanship of the marionette is superb.}
		view 941
		cel 10
		cursor 25
	)
)

(instance Pouch of InvI
	(properties
		owner 23
		view 941
		loop 2
		cel 11
		cursor 26
	)

	(method (showSelf &tmp [temp0 50])
		(cond
			((== global312 -1)
				(PrintDC {The small leather pouch is drawn tightly closed.})
			)
			(global312
				(StrCpy @temp0 {This leather pouch contains })
				(StrCat
					@temp0
					(switch global312
						(3 {three})
						(2 {two})
						(1 {one})
					)
				)
				(StrCat @temp0 { beautiful emerald})
				(StrCat @temp0 (if (> global312 1) {s.} else {.}))
				(PrintDC @temp0)
			)
			(else
				(PrintDC {The pouch is empty.})
			)
		)
	)

	(method (doit)
		(if (== global312 -1)
			(= global312 3)
			(ShowView
				{Upon opening the leather pouch, Graham discovers three sparkling emeralds.}
				941
				2
				9
			)
			(self loop: 1 cel: 8)
			((gInventory at: 14) moveTo: gEgo) ; Emeralds
			(proc995_0 gEgo (gInventory at: 14)) ; Emeralds
		else
			(PrintDC {The pouch is already open.})
		)
		(return 0)
	)
)

(instance Emeralds of InvI
	(properties
		view 941
		loop 2
		cel 9
		cursor 27
	)

	(method (showSelf &tmp [temp0 50])
		(StrCpy @temp0 {The })
		(StrCat
			@temp0
			(switch global312
				(3 {trio of })
				(2 {pair of })
				(1 {})
			)
		)
		(StrCat @temp0 {sparkling emerald})
		(StrCat @temp0 (if (> global312 1) {s} else {}))
		(StrCat @temp0 { dazzle})
		(StrCat @temp0 (if (> global312 1) {} else {s}))
		(StrCat @temp0 { the eyes.})
		(PrintDC @temp0)
	)
)

(instance Spinning_Wheel of InvI
	(properties
		name {Spinning Wheel}
		description {This appears to be a small, intricately-constructed spinning wheel.}
		owner 23
		view 941
		loop 1
		cel 9
		cursor 28
	)
)

(instance Stick of InvI
	(properties
		description {It appears to be an average stick of wood.}
		owner 11
		view 941
		loop 1
		cel 1
		cursor 29
	)
)

(instance Honeycomb of InvI
	(properties
		description {Honey drips at the edges of the honeycomb chunk.}
		owner 11
		view 941
		cel 15
		cursor 30
	)
)

(instance Beeswax of InvI
	(properties
		description {Graham carries a softened lump of beeswax.}
		view 941
		loop 1
		cursor 31
	)
)

(instance Leg_of_Lamb of InvI
	(properties
		name {Leg of Lamb}
		owner 28
		view 941
		cel 6
		cursor 32
	)

	(method (showSelf &tmp [temp0 50])
		(StrCpy @temp0 {This is a })
		(StrCat
			@temp0
			(if global316 {left-over, half} else {large, mouthwatering})
		)
		(StrCat @temp0 { leg of lamb.})
		(PrintDC @temp0)
	)
)

(instance Rope of InvI
	(properties
		description {A good strong rope is a handy item to have!}
		owner 86
		view 941
		cel 11
		cursor 33
	)
)

(instance Crystal of InvI
	(properties
		description {The brilliant crystal shard feels smooth in Graham's hands.}
		owner 38
		view 941
		loop 1
		cel 12
		cursor 34
	)
)

(instance Hammer of InvI
	(properties
		description {A cobbler would normally use this small hammer to make shoes.}
		view 941
		loop 2
		cel 6
		cursor 35
	)
)

(instance Shell of InvI
	(properties
		description {Graham can almost hear the ocean inside the spiral shell of the conch.}
		view 941
		loop 1
		cel 15
		cursor 36
	)
)

(instance Bag_of_Peas of InvI
	(properties
		name {Bag of Peas}
		description {The bag is full of round, dried peas.}
		owner 56
		view 941
		loop 2
		cel 2
		cursor 37
	)

	(method (showSelf)
		(if (IsFlag 64)
			(PrintDC 0 22) ; "A brown empty sack."
		else
			(PrintDC description)
		)
	)
)

(instance Locket of InvI
	(properties
		description {It is a lovely golden locket on a delicate chain.}
		view 941
		loop 1
		cel 13
		cursor 38
	)

	(method (doit)
		(PrintDC
			{Upon opening the locket, Graham sees a portrait of an older couple in regal attire. So as not to damage the picture, he quickly closes it again.}
		)
		(return 0)
	)
)

(instance Cloak of InvI
	(properties
		description {This fine cloak is thick and warm.}
		owner 203
		view 941
		cel 4
		cursor 39
	)
)

(instance Amulet of InvI
	(properties
		description {The amulet is attached to a soft leather thong.}
		view 941
		loop 1
		cel 2
		cursor 40
	)

	(method (showSelf)
		(if (IsFlag 85)
			(PrintDC 0 23) ; "The amulet glows softly with a power of its own."
		else
			(PrintDC description)
		)
	)
)

(instance Wand of InvI
	(properties
		description {The old wand doesn't seem to have any vitality left in it.}
		view 941
		cel 2
		cursor 41
	)

	(method (showSelf)
		(if (IsFlag 61)
			(PrintDC 0 24) ; "Crispin's wand glows brightly with renewed power."
		else
			(PrintDC description)
		)
	)

	(method (useit)
		(if (IsFlag 61)
			(PrintDC 0 25) ; "Graham waves Crispin's wand which now pulsates with renewed power, but nothing happens."
		else
			(PrintDC 0 20) ; "Graham gives the wand a good shake, but it only fizzles and dies."
		)
		(return 0)
	)

	(method (moveTo)
		(if (and (IsFlag 61) (!= cursor 53))
			(= loop 2)
			(= cel 12)
			(= cursor 53)
		)
		(super moveTo: &rest)
	)
)

(instance Sled of InvI
	(properties
		description {This is a small, well-crafted sled.}
		owner 204
		view 941
		cel 5
		cursor 42
	)
)

(instance Iron_Bar of InvI
	(properties
		name {Iron Bar}
		description {The heavy iron bar is a bit rusted from being out in the weather.}
		owner 44
		view 941
		loop 1
		cel 14
		cursor 43
	)
)

(instance Fishhook of InvI
	(properties
		description {This is a rusted old fishhook.}
		owner 54
		view 941
		loop 2
		cursor 44
	)
)

(instance Moldy_Cheese of InvI
	(properties
		name {Moldy Cheese}
		description {Green mold covers the small piece of cheese.}
		owner 67
		view 941
		loop 2
		cel 4
		cursor 45
	)
)

(instance Elf_Shoes_ of InvI
	(properties
		name {Elf Shoes }
		description {This is the finest pair of shoes Graham has ever seen, although a bit small for his feet.}
		owner 83
		view 941
		loop 1
		cel 11
		cursor 46
	)
)

(instance Tambourine of InvI
	(properties
		description {It is an ordinary tambourine.}
		owner 13
		view 941
		loop 1
		cel 3
		cursor 47
	)
)

(instance Mordack_s_Wand of InvI
	(properties
		name {Mordack's Wand}
		description {Mordack's wand glows brightly with restrained power.}
		owner 13
		view 941
		loop 2
		cel 5
		cursor 48
	)

	(method (showSelf)
		(if (IsFlag 61)
			(PrintDC 0 26) ; "Mordack's wand doesn't seem to have much life left in it."
		else
			(PrintDC description)
		)
	)
)

(instance Hairpin of InvI
	(properties
		description {The hairpin is made of a carved piece of bone with a sharp metal clip attached to it.}
		owner 55
		view 941
		loop 2
		cel 1
		cursor 49
	)
)

(instance Cat_Fish of InvI
	(properties
		name {Cat Fish}
		description {Whew! This smelly old fish is disgusting!}
		owner 51
		view 941
		loop 2
		cel 10
		cursor 19
	)
)

(instance Mongoose_Spell of InvI
	(properties
		name {Mongoose Spell}
		owner 65
		view 712
		loop 2
		cursor 53
	)

	(method (useit)
		(Print 0 27) ; "Choose the inventory icon to select a spell."
		(return 0)
	)
)

(instance Bunny_Spell of InvI
	(properties
		name {Bunny Spell}
		owner 65
		view 712
		loop 2
		cel 1
		cursor 53
	)

	(method (useit)
		(Print 0 27) ; "Choose the inventory icon to select a spell."
		(return 0)
	)
)

(instance Rain_Spell of InvI
	(properties
		name {Rain Spell}
		owner 65
		view 712
		loop 2
		cel 2
		cursor 53
	)

	(method (useit)
		(Print 0 27) ; "Choose the inventory icon to select a spell."
		(return 0)
	)
)

(instance Tiger_Spell of InvI
	(properties
		name {Tiger Spell}
		owner 65
		view 712
		loop 2
		cel 3
		cursor 53
	)

	(method (useit)
		(Print 0 27) ; "Choose the inventory icon to select a spell."
		(return 0)
	)
)

(instance deathIcon of DCIcon
	(properties)
)

(instance talkerIcon of DCIcon
	(properties)
)

