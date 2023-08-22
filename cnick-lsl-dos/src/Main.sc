;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use LLEgo)
(use PseudoMouse)
(use GameControls)
(use IconBar)
(use n940)
(use Feature)
(use DCIcon)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	LSL1 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_6 6
	proc0_7 7
	proc0_8 8
	deathIcon 24
	icon0 25
	proc0_26 26
	proc0_27 27
	proc0_28 28
	proc0_29 29
	proc0_30 30
	proc0_31 31
	proc0_32 32
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
	gTextSpeed = 2
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	gLongSong
	global101 = 1234
	gLongSong2
	global103
	global104 = 1
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
	global151 = 160
	global152 = 160
	global153
	global154
	; 155
	global155
	global156
	global157
	global158 = 100
	global159
	; 160
	global160
	global161
	global162
	global163
	global164 = 10
	; 165
	global165 = 807
	global166 = 1
	gLongSong3
	global168
	global169 = 4
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
)

(procedure (proc0_28 param1 param2 &tmp [temp0 300] temp300 temp301)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(if (not (HaveMouse))
		(= temp301 (gGame setCursor: 5))
	)
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
		(= temp300 (Max 3 (/ (* gTextSpeed (StrLen @temp0)) 120)))
		(Print @temp0 #time temp300 &rest)
	else
		(= temp300 (Max 3 (/ (* gTextSpeed (StrLen param1)) 120)))
		(Print param1 22 temp300 param2 &rest)
	)
	(if (not (HaveMouse))
		(gGame setCursor: temp301)
	)
	(return 1)
)

(procedure (proc0_1 param1 param2 param3 &tmp temp0) ; UNUSED
	(= temp0 0)
	(gEgo view: 800)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2)
				(= temp0 param3)
			)
		)
	)
	(if (not temp0)
		(= temp0 809)
	)
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Unknown_Class_82 temp0
		setStep: 3 2
		illegalBits: -32768
		ignoreActors: 0
		userSpeed:
	)
)

(procedure (proc0_2 &tmp temp0)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 0 1 2 3 4 5 6 7)
	(gTheIconBar curIcon: temp0)
	(if (not (HaveMouse))
		(= global119 ((User curEvent:) x:))
		(= global120 ((User curEvent:) y:))
		(gGame setCursor: gWaitCursor)
		(SetCursor 310 180)
	else
		(SetCursor gWaitCursor 0 0)
	)
	(if gPMouse
		(gPMouse stop:)
	)
)

(procedure (proc0_3)
	(User canControl: 1 canInput: 1)
	(if (!= gCurRoomNum 100)
		(gTheIconBar enable: 0 1 2 3 4 5 6 7)
	)
	(gTheIconBar
		height: -100
		activateHeight: -100
		curIcon: (gTheIconBar at: 2)
		disable: 3 6 7 4 0 9 5 8
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(SetCursor global119 global120)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
	(gEgo userSpeed:)
)

(procedure (proc0_32 param1)
	(User canControl: 0 canInput: 1)
	(if argc
		(SetCursor param1 0 0)
	)
)

(procedure (proc0_4 param1) ; UNUSED
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (proc0_6 param1)
	(return (& [global111 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_7 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global111 (/ param1 16)]
		(| [global111 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (proc0_8 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global111 (/ param1 16)]
		(& [global111 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc0_26 param1 param2 param3 param4 param5)
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

(procedure (proc0_27)
	(proc0_26 1026 1040 1051 1051 852)
)

(procedure (proc0_29 &tmp [temp0 200])
	(cond
		(
			(and
				(> global149 1)
				(> (- global158 50) (* global149 100))
				(== gCurRoomNum 100)
			)
			(repeat
				(switch (Print 0 24 #button {Yes} 1 #button {No} 2) ; "Do you wish to pay back your entire loan?"
					(1
						(proc0_30 {Before payback})
						(-= global158 (* global149 100))
						(= global149 0)
						(proc0_30 {After payback})
						(Print 0 25) ; "You're all paid up!"
						(break)
					)
					(2
						(Print 0 26) ; "Ok, just asking."
						(loseSound play:)
						(-= global158 100)
						(-- global149)
						(Print 0 27) ; "However, you must pay back something. So we'll garnish your funds for the amount of one (1) loan."
						(proc0_30)
						(break)
					)
				)
			)
		)
		((and global149 (>= global158 200))
			(loseSound play:)
			(-= global158 100)
			(-- global149)
			(Print 0 28) ; "Hey! Remember that loan you took out? Well, it's time to pay it back!!"
			(Format @temp0 0 29 global149 (* global149 100) (- 10 global149)) ; "Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
			(Print
				@temp0
				27
				1
				77
				{Loan Shark's Office}
				32
				SysWindow
				78
				{ Done }
			)
			(Printf 0 30 global158) ; "You now have 100 less Larry Dollars leaving you with $%d.00 Larry Dollars."
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0 [temp1 30]) ; UNUSED
	(Format @temp1 0 31 param1) ; "%s"
	(if (FileIO fiEXISTS @temp1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc0_30 param1 &tmp [temp0 200])
	(if (not argc)
		(Format @temp0 0 32 global149 (* global149 100) (- 10 global149)) ; "Loan Status: Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
	else
		(Format @temp0 0 33 param1 global149 (* global149 100) (- 10 global149)) ; "Loan Status - (%s):  Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
	)
	(Print @temp0 27 1 77 {Loan Shark's Office} 32 SysWindow 78 { Done })
)

(procedure (proc0_31)
	(gLongSong
		number: 310
		setVol: (if (!= gCurRoomNum 100) 40 else 20)
		loop: -1
		play:
	)
)

(instance ego of LLEgo
	(properties
		sightAngle 180
		view 800
	)
)

(instance pointsSound of Sound ; UNUSED
	(properties
		flags 1
		number 821
	)
)

(instance babbleIcon of DCIcon
	(properties)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance ll1KDHandler of EventHandler
	(properties)
)

(instance ll1MDHandler of EventHandler
	(properties)
)

(instance ll1DirHandler of EventHandler
	(properties)
)

(instance LSL1 of Game
	(properties)

	(method (init &tmp [temp0 7])
		(= gSystemWindow ll1Win)
		(= gVersion {x.yyy})
		(super init:)
		(= gDoVerbCode ll1DoVerbCode)
		(= gFtrInitializer ll1FtrInit)
		((= gKeyDownHandler ll1KDHandler) add:)
		((= gMouseDownHandler ll1MDHandler) add:)
		((= gDirectionHandler ll1DirHandler) add:)
		(= gPMouse PseudoMouse)
		((= gEgo ego))
		(User alterEgo: gEgo)
		((ScriptID 816 0) init:) ; LL1InitCode
		((= gLongSong longSong) init: owner: self flags: 1)
		((= gLongSong2 longSong2) init: owner: self flags: 1)
		((= gLongSong3 longSong3) init: owner: self flags: 1)
		((= gTheIconBar IconBar)
			add:
				(icon0 cursor: walkingIcon yourself:)
				(icon1 cursor: lookingIcon yourself:)
				(icon2 cursor: doingIcon yourself:)
				(icon3 cursor: talkingIcon yourself:)
				(icon6 cursor: 4 yourself:)
				(icon7 cursor: tasterSmellerIcon yourself:)
				(icon4 cursor: invItemIcon yourself:)
				(icon5 cursor: 7 yourself:)
				(icon8 cursor: controlIcon yourself:)
				(icon9 cursor: abouterIcon yourself:)
			eachElementDo: #init
			eachElementDo: #highlightColor global142
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(proc0_2)
		(gcWin color: 0 back: global148)
		((= gGameControls budgetControls)
			window: gcWin
			add:
				iconOk
				(detailSlider
					theObj: gGame
					selector: #detailLevel
					topValue: 3
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					theObj: gGame
					selector: #masterVolume
					topValue: (if (> global107 1) 15 else 1)
					bottomValue: 0
					yourself:
				)
				(speedSlider
					theObj: speedORama
					selector: #doit
					topValue: 0
					bottomValue: 5
					yourself:
				)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 811 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			eachElementDo: #highlightColor global142
			eachElementDo: #lowlightColor global148
			helpIconItem: iconHelp
			curIcon: iconSave
		)
		(gTheIconBar
			height: -100
			activateHeight: -100
			enable:
			curIcon: icon0
			disable: 0 3 6 7 4 8 5
		)
		(proc0_8 103)
		(proc0_32 gWaitCursor)
		(self newRoom: 100)
	)

	(method (setCursor param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(return
			(if (IsObject param1)
				(param1 init:)
				temp0
			)
		)
	)

	(method (pragmaFail &tmp [temp0 2])
		(if (User canInput:)
		)
	)

	(method (quitGame)
		(if (!= gCurRoomNum 100)
			(babbleIcon view: 853 loop: 0 cycleSpeed: (* (+ gHowFast 1) 4))
			(gGame setCursor: 999 1)
			(Animate (gCast elements:) 0)
			(super
				quitGame:
					(Print ; "No! Don't leave me all alone inside your computer! You can't imagine the things your CPU does to me when you're not watching!"
						0
						0
						#button
						{Stop Whining}
						1
						#button
						{Oh, All Right}
						0
						#icon
						babbleIcon
						#title
						{Don't give up. It's still early!}
					)
			)
		)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		((ScriptID 801) doit: roomNum) ; disposeCode
		(super startRoom: roomNum)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_F1
						(requestHelp init:)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global107 1)
								(gGame masterVolume: 15)
							)
							(else
								(gGame masterVolume: 1)
							)
						)
					)
					(KEY_F4
						(proc0_30)
						(event claimed: 1)
					)
					(KEY_F6
						(proc0_30)
						(event claimed: 1)
					)
					(KEY_ALT_x
						(= gQuit 1)
						(event claimed: 1)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(JOY_RIGHT
						(gGame setCursor: 999 1)
						(icon8 select:)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (!= global154 (= temp0 (GetTime 1))) ; SysTime12
			(= global154 temp0)
			(if (and (< global158 1) (not (proc0_6 1)))
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (and (not (proc0_6 103)) (== gCurRoomNum 100))
					(proc0_7 103)
					(Wait 5)
					(Print 0 1) ; "Oh, no! You are now penniless."
				)
			)
		)
		(super doit: &rest)
	)
)

(instance speedORama of Code
	(properties)

	(method (doit)
		(gEgo moveSpeed:)
	)
)

(instance deathIcon of DCIcon
	(properties)

	(method (init)
		(if global168
			((= cycler (End new:)) init: self)
		else
			((= cycler (Fwd new:)) init: self)
		)
	)
)

(instance theDefaultFeature of Feature ; UNUSED
	(properties)
)

(instance icon0 of IconI
	(properties
		view 850
		loop 0
		cel 0
		cursor 100
		message 7
		signal 65
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: global145)
		(super init:)
	)
)

(instance icon1 of IconI
	(properties
		view 850
		loop 1
		cel 0
		cursor 101
		message 1
		signal 65
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: global147)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 850
		loop 2
		cel 0
		cursor 102
		message 2
		signal 65
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: global138)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 850
		loop 3
		cel 0
		cursor 103
		message 4
		signal 65
		maskView 850
		maskLoop 14
		maskCel 3
	)

	(method (init)
		(self lowlightColor: global131)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 850
		loop 4
		cel 0
		cursor 999
		message 5
		signal 65
		maskView 850
		maskLoop 14
		maskCel 4
	)

	(method (init)
		(self lowlightColor: global138)
		(super init:)
	)
)

(instance icon5 of IconI
	(properties
		view 850
		loop 5
		cel 0
		cursor 999
		message 0
		signal 67
		maskView 850
		maskLoop 14
		maskCel 2
	)

	(method (init)
		(self lowlightColor: global134)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(Inv showSelf: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 850
		loop 10
		cel 0
		cursor 104
		message 8
		signal 65
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: global135)
		(super init:)
	)
)

(instance icon7 of IconI
	(properties
		view 850
		loop 11
		cel 0
		cursor 105
		message 6
		signal 65
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: global147)
		(super init:)
	)
)

(instance icon8 of IconI
	(properties
		view 850
		loop 7
		cel 0
		cursor 999
		message 8
		signal 67
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: global145)
		(super init:)
	)

	(method (select)
		(if (super select:)
			(gTheIconBar hide:)
			(gGameControls show:)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 850
		loop 9
		cel 0
		cursor 150
		message 6
		signal 3
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: global131)
		(super init:)
	)
)

(instance ll1DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (param2 facingMe: gEgo)
			(switch param1
				(1 0)
				(4
					(Printf 0 2 temp0) ; "You engage in a short, but personally meaningful conversation with %s.", UNINIT
				)
				(2
					(Printf 0 3) ; "That feels exactly like it looks."
				)
				(8
					(Print 0 4) ; "Don't do that!!"
				)
				(6
					(Print 0 5) ; "To you, it has no distinctive smell or taste."
				)
			)
		)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance longSong3 of Sound
	(properties)
)

(instance ll1FtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 40)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
	)
)

(instance ll1Win of Window
	(properties)
)

(instance gcWin of Window
	(properties)

	(method (open &tmp [temp0 14] [temp14 25] [temp39 4])
		(self
			top: (/ (- 200 (+ (CelHigh (proc0_27) 1 1) 6)) 2)
			left:
				(/
					(-
						320
						(+ 147 (CelWide (proc0_27) 0 1) 4 (proc0_26 0 12 0 0 0))
					)
					2
				)
			bottom:
				(+
					(CelHigh (proc0_27) 1 1)
					6
					(/ (- 200 (+ (CelHigh (proc0_27) 1 1) 6)) 2)
				)
			right:
				(+
					147
					(CelWide (proc0_27) 0 1)
					4
					(proc0_26 0 12 0 0 0)
					(/
						(-
							320
							(+
								147
								(CelWide (proc0_27) 0 1)
								4
								(proc0_26 0 12 0 0 0)
							)
						)
						2
					)
				)
			priority: 15
		)
		(super open:)
		(DrawCel
			(proc0_27)
			0
			5
			(+
				(/
					(-
						(-
							(+
								147
								(CelWide (proc0_27) 0 1)
								4
								(proc0_26 0 12 0 0 0)
							)
							(+ 4 (CelWide (proc0_27) 1 1))
						)
						(CelWide (proc0_27) 0 5)
					)
					2
				)
				4
				(CelWide (proc0_27) 1 1)
			)
			6
			15
		)
		(DrawCel (proc0_27) 1 1 4 3 15)
		(DrawCel (proc0_27) 1 0 94 38 15)
		(DrawCel (proc0_27) 1 0 135 38 15)
		(DrawCel (proc0_27) 0 4 63 (- 37 (+ (CelHigh (proc0_27) 0 4) 3)) 15)
		(DrawCel
			(proc0_27)
			0
			3
			(- 107 (proc0_26 6 9 6 6 6))
			(- 37 (+ (CelHigh (proc0_27) 0 4) 3))
			15
		)
		(DrawCel
			(proc0_27)
			0
			2
			(- 147 (proc0_26 12 8 1 1 1))
			(- 37 (+ (CelHigh (proc0_27) 0 4) 3))
			15
		)
		(Format @temp14 0 6 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp39 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			gUserFont
			dsCOLOR
			global141
			dsCOORD
			(+
				10
				(CelWide (proc0_27) 1 1)
				(/
					(-
						(-
							(-
								(+
									147
									(CelWide (proc0_27) 0 1)
									4
									(proc0_26 0 12 0 0 0)
								)
								(+ 10 (CelWide (proc0_27) 1 1) 6)
							)
							(proc0_26 0 20 0 0 0)
						)
						[temp39 3]
					)
					2
				)
			)
			(+ 46 (CelHigh (proc0_27) 0 1) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal 128
		sliderView 852
		topValue 3
	)

	(method (show)
		(= sliderView (proc0_27))
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance volumeSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal 128
		sliderView 852
		topValue 15
	)

	(method (show)
		(= sliderView (proc0_27))
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal 128
		sliderView 852
		bottomValue 15
	)

	(method (show)
		(= sliderView (proc0_27))
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 852
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 852
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 852
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 852
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 852
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconHelp of IconI
	(properties
		view 852
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 150
		message 6
		signal 387
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance iconOk of IconI
	(properties
		view 852
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 999
		message 9
		signal 451
	)

	(method (show)
		(= view (proc0_27))
		(super show: &rest)
	)
)

(instance requestHelp of Obj
	(properties)

	(method (init param1 param2 param3 param4)
		(= param3 (gSystemWindow color:))
		(= param4 (gSystemWindow back:))
		(gGame masterVolume: 0)
		(super init:)
		(self doit: param1 param2 param3 param4)
	)

	(method (doit param1 param2)
		(repeat
			(gSystemWindow color: 0 back: 42)
			(switch
				(= param2
					(PrintD
						{Select...}
						109
						78
						{Game Help}
						1
						109
						78
						{Credits}
						2
						109
						78
						{Sierra}
						4
						109
						78
						{Quit About}
						3
					)
				)
				(1
					(gSystemWindow color: 0 back: 42)
					(Print ; "Using the Keyboard: To position the on-screen cursor using a keyboard, use the "Direction" (arrow) keys on your numeric keypad. You can quickly press and release the direction keys, to move the cursor one increment at a time or press and hold down the keys, releasing them when the cursor reaches the desired screen location. To move the cursor in even smaller increments, hold down the "Shift" key while using the "Direction" keys."
						0
						7
						32
						cluckWindow
						27
						1
						77
						{Game Help}
						78
						{ More }
					)
					(Print ; "In many requester windows, the "Tab" key may be used, in leu of the "Direction" keys, to cycle the cursor through the various selections. Once you reach the desired location, press the "Enter" or "Return" key to select or implement. Press "5" on the numeric keypad to cycle through the available cursors."
						0
						8
						32
						cluckWindow
						27
						1
						77
						{Game Help (Con't)}
						78
						{ More }
					)
					(Print ; "Using a Mouse: To position the on-screen cursor, move the mouse to the desired position.  To execute a command, click the mouse button (multi-button mouse users, click the left button). Click the right mouse button to cycle through the available cursors, on multi-button mice. On a single button mouse, hold down the "Shift" key while clicking the button."
						0
						9
						32
						cluckWindow
						27
						1
						77
						{Game Help (Con't)}
						78
						{ More }
					)
				)
				(2
					(displayCredits doit:)
					(break)
				)
				(3
					(break)
				)
				(4
					(Print ; "This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
						0
						10
						32
						cluckWindow
						27
						1
						77
						{Other great products...}
						78
						{ More }
					)
					(Print ; "...More fun and games. Sometimes it seems that life with Larry is all fun and games, well hang on, there's more. Singles' scene strike-out king; fashion disaster, computer age cult hero, Larry constantly tries to get as much out of life as possible. When you plunge into the Leisure Suit Larry series, Larry will take you undercover (and under the covers), you'll explore exotic and erotic islands and you'll always be treated to a healthy serving of sex, thugs and rock 'n' roll."
						0
						11
						32
						cluckWindow
						27
						1
						77
						{Other great products...}
						78
						{ Done }
					)
				)
			)
		)
		(gSystemWindow color: 0 back: 42)
		(gGame masterVolume: 13)
	)
)

(instance displayCredits of Code
	(properties)

	(method (doit)
		(gGame masterVolume: 0)
		(gSystemWindow color: 50 back: 42)
		(Print 0 12 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Leisure Suit Larry 's Casino Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
		(Print 0 13 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Leisure Suit Larry 's Casino Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 0 14 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Game Designer: Al Lowe Producer: Guruka Singh Khalsa"
		(Print 0 15 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Production Designer: Andy Hoyos Art Designer: Jane Cardinal Lead Programmer: Brian K. Hughes Composer: Craig Safan"
		(Print 0 16 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Art Team Manager: Cheryl Loyd Animators: Barry T. Smith, Roger Hardy, Jr., Dana M. Dean, Karin Young, Marc Hudgins, Eric Kasner, Richard Powell, Phyllis Cucchiara, Terry C. Falls, Michael Hutchison, Desie Hartman, Willis Wong Background Artists: Maurice Morgan, Jay Friedman, Jennifer Shontz, Gloria Garland"
		(Print 0 17 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Programmers: Carlos Escobar, Steve Conrad, John Hartin, Oliver Breslford Music Director: Mark Seibert Additional Music: Chris Braymen"
		(Print 0 18 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) System Development: Jeff Stephenson, Robert E. Heitman, Dan Foy, Larry Scott, John Rettig, J. Mark Hood, Christopher Smith, Terry McHenry, Eric Hart, Chad Bye, Mark Wilden, Ken Koch, John Crane"
		(Print 0 19 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Game Designer: Al Lowe Producer: Stuart Moulder"
		(Print 0 20 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Art Designer: William D. Skirvin Lead Programmer: Oliver Breslford Music Director: Mark Seibert"
		(Print 0 21 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Animators: Barry T. Smith, Jennifer Shontz, Roger Hardy, Jr., Eric Apel, Russell Truelove, Desie Hartman Background Artists: Jay Allan Friedmann, Jennifer Shontz, Jane Cardinal, Maurice Morgan"
		(Print 0 22 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Programmer: Mike Larsen Composer: Chris Braymen System Development: J. Mark Hood, Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, Mark Wilden, Eric Hart, Christopher Smith"
		(Print 0 23 77 {Credits} 27 1 78 { Done } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Sound Effects: Chris Braymen, Orpheus Hanley Quality Assurance: Mike Pickhinke"
		(gGame masterVolume: 12)
	)
)

(instance walkingIcon of Cursor
	(properties
		view 850
		cel 2
	)
)

(instance lookingIcon of Cursor
	(properties
		view 850
		loop 1
		cel 2
	)
)

(instance doingIcon of Cursor
	(properties
		view 850
		loop 2
		cel 2
	)
)

(instance talkingIcon of Cursor
	(properties
		view 850
		loop 3
		cel 2
	)
)

(instance invItemIcon of Cursor
	(properties
		view 850
		loop 4
	)
)

(instance _7 of Cursor ; UNUSED
	(properties
		name {7}
		view 850
		loop 5
	)
)

(instance _4 of Cursor ; UNUSED
	(properties
		name {4}
		view 850
		loop 10
		cel 2
	)
)

(instance tasterSmellerIcon of Cursor
	(properties
		view 850
		loop 11
		cel 2
	)
)

(instance controlIcon of Cursor
	(properties
		view 850
		loop 7
	)
)

(instance abouterIcon of Cursor
	(properties
		view 850
		loop 9
	)
)

(instance budgetControls of GameControls
	(properties)

	(method (hide)
		(if window
			(window dispose:)
		)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
	)
)

(instance loseSound of Sound
	(properties
		flags 2
		number 726
	)
)

(instance cluckWindow of SysWindow
	(properties
		back 42
	)
)

