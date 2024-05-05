;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use BrainWindow)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use LoadMany)
(use DCIcon)
(use Ego)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	Brain 0
	proc0_1 1
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
	gCMusic
	global101 = 1234
	global102
	gCSoundFX
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
	gDifficulty
	; 115
	global115 = 1
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
	gArtWin
	global128
	global129
	; 130
	global130
	global131 = 5
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
	global175 = 99
	global176 = 59
	global177 = 59
	global178 = 99
	global179 = 59
	; 180
	global180 = 59
	global181 = 99
	global182 = 59
	global183 = 59
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

(procedure (proc0_1)
	(gTheIconBar select: (gTheIconBar at: 2) curIcon: (gTheIconBar at: 2))
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
)

(instance cMusic of Sound
	(properties
		flags 1
		number 1
	)

	(method (play)
		(if (<= (DoSound sndGET_POLYPHONY) 11)
			(= number (+ (mod number 1000) 1000))
		)
		(super play: &rest)
	)
)

(instance cSoundFX of Sound
	(properties
		flags 1
		number 101
	)
)

(instance statLn of Code
	(properties)

	(method (doit param1)
		(Format ; "Island of Dr. Brain    %s Level"
			param1
			0
			0
			(switch gDifficulty
				(0 {Novice}) ; Novice
				(1 {Standard}) ; Standard
				(2 {Expert}) ; Expert
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
		(= gUserFont 999)
		(= gTextSpeed 8)
		PuzzleBar
		CodeIcon
		(Narrator back: 19 font: gUserFont)
		RandCycle
		(Print font: gUserFont)
		(= gSystemWindow BrainWindow)
		(= gUseSortedFeatures 0)
		(= gDoVerbCode BrainVerbCode)
		(= gInventory Inv)
		(= gNormalCursor 900)
		(= gMsgType 1)
		(= gMessager bMessager)
		(= gNarrator Narrator)
		(= gUserFont 999)
		(gGame masterVolume: 14)
		(TextColors 12 35 52 26 28 51)
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
			disable: icon4 leftBorderIcon rightBorderIcon
			state: (| (IconBar state:) $0800)
			init:
		)
		(= gEgo Ego)
		(User alterEgo: gEgo canControl: 1 canInput: 1 x: -1 y: 150)
		(self setCursor: gWaitCursor 1 304 172)
		(= gPossibleScore 390)
		(= gEatMice 10)
		(= gVersion {x.yyy____})
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 7 temp0)
		(FileIO fiCLOSE temp0)
		(= global105 (Graph grGET_COLOURS))
		(= gCMusic (cMusic owner: self init: yourself:))
		(= gCSoundFX (cSoundFX owner: self init: yourself:))
		(gTheIconBar
			add:
				leftBorderIcon
				icon1
				icon2
				icon4
				icon5
				icon6
				icon8
				icon9
				icon10
				rightBorderIcon
			eachElementDo: #init
			eachElementDo: #modNum 1
			eachElementDo: #helpVerb 39
			helpIconItem: icon9
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(= gIcon2 icon2)
		(Inv
			normalHeading: {You are carrying}
			add:
				hintCharge
				achievementBoard
				numberSheet
				bookcaseKey
				sheetMusic
				patternPeices
				appleBucket
				watermellon
				cornBucket
				geneticMaterial
				hanoiDisks
				blackBag
				cart0
				cart1
				cart2
				elevatorKey
			eachElementDo: #view 700
			eachElementDo: #lowlightColor 35
			eachElementDo: #modNum 1
			eachElementDo: #signal 2
			add: invLook invSelect invHelp ok
			eachElementDo: #init
			window: InsetWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(InsetWindow insideColor: 35)
		(hintCharge owner: gEgo)
		(achievementBoard owner: gEgo)
		(= global107 (if (GameIsRestarting) 100 else 500))
		Print
		(self newRoom: 100)
	)

	(method (doit)
		(if global167
			((ScriptID 40 0) init: show: dispose:) ; theBoard
			(DisposeScript 40)
			(= global167 0)
			(proc5_12 0)
			(proc0_1)
		)
		(super doit: &rest)
	)

	(method (detailLevel param1)
		(if argc
			(= gDifficulty (/ param1 5))
			(SL doit:)
		)
		(return (* gDifficulty 7))
	)

	(method (quitGame &tmp temp0)
		(= temp0 (self setCursor: 999 1))
		(Print
			first: 2
			addText: 37 4 0 1 100 0 1 ; "Must you leave so soon? There are many exciting and wonderful discoveries still awaiting you on my island. Please hurry back."
			addButton: 1 {Quit for Now} 125 53
			addButton: 2 {Keep Solving} 205 53
			addIcon: 1 0 0 4 2
			init:
		)
		(self setCursor: temp0 1)
		(if (== (Print retValue:) 1)
			(super quitGame: 1)
			(gCMusic fade:)
		)
	)

	(method (save)
		(super save: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (newRoom)
		(if global131
			(gCMusic fade: 0 8 global131 1)
		)
		(= global131 5)
		(super newRoom: &rest)
	)

	(method (startRoom roomNum)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self setCursor: gWaitCursor 1)
		(LoadMany 0 973 978 934 5 30 929 25 800 805)
		(if
			(and
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(Print
					addText: {Memory Fragmented}
					addButton: 0 {Who cares} 0 12
					addButton: 1 {Debug} 54 12
					init:
				)
			)
			(SetDebug)
		)
		(if gDebugOn
			(SetDebug)
		)
		(if (OneOf gCurRoomNum 500 802)
			(SL disable:)
			(gTheIconBar disable:)
		else
			(SL enable:)
			(gTheIconBar enable:)
		)
		(ScriptID 982)
		(super startRoom: roomNum)
		(proc0_1)
	)

	(method (handleEvent event &tmp temp0 [temp1 20])
		(= temp0 (event type:))
		(cond
			((or (not (User controls:)) (event claimed:))
				(if (== temp0 evKEYBOARD)
					(Format @temp1 0 1 800) ; "%d.scr"
					(if (FileIO fiEXISTS @temp1)
						(event claimed: 0)
						(if (== (event message:) KEY_ALT_t)
							(HandsOn)
							(Palette palSET_INTENSITY 0 255 100)
						)
						((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
					)
				)
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
								(gGame masterVolume: 15)
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
					($003d ; =
						(if (User controls:)
							(gGame setSpeed: 6)
						)
					)
					(KEY_ALT_n
						(Format @temp1 0 1 800) ; "%d.scr"
						(if (and (FileIO fiEXISTS @temp1) (proc5_3 1536))
							((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
						)
					)
					(else
						(Format @temp1 0 1 800) ; "%d.scr"
						(if (FileIO fiEXISTS @temp1)
							(event claimed: 0)
							(if (== (event message:) KEY_ALT_t)
								(Palette palSET_INTENSITY 0 255 100)
							)
							((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
						)
					)
				)
			)
			((and (not (event claimed:)) (& (event type:) evVERB))
				(self pragmaFail: event)
			)
		)
	)

	(method (setCursor param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (< param1 100)
			(Printf {WARNING: cursor %d} param1)
		)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(if (IsObject param1)
			(param1 init:)
		else
			(SetCursor param1 0 0)
		)
		(if (and (> argc 1) (> argc 2))
			(SetCursor param3 param4)
			(if (> argc 4)
				(SetCursor param1 0 0 param5 param6)
			)
		)
		(return temp0)
	)

	(method (pragmaFail param1 &tmp temp0)
		(if (or (== (= temp0 (param1 message:)) 1) (== temp0 4))
			(gMessager say: 1 temp0 0 (Random 1 (proc15_6 1 1 temp0 0)) 0 1)
		else
			(gMessager say: 1 temp0 0 0 0 1)
		)
	)
)

(instance brainSaysBye of DCIcon ; UNUSED
	(properties
		view 902
		cycleSpeed 10
	)
)

(instance ok of IconI
	(properties
		view 11
		loop 3
		cel 0
		nsLeft 40
		cursor 900
		signal 67
		lowlightColor 14
		noun 31
	)
)

(instance invLook of IconI
	(properties
		view 11
		loop 2
		cel 0
		cursor 901
		message 1
		lowlightColor 14
		noun 27
	)
)

(instance invHelp of IconI
	(properties
		view 11
		loop 1
		cel 0
		cursor 906
		message 8
		lowlightColor 14
		noun 29
	)
)

(instance invSelect of IconI
	(properties
		view 11
		loop 0
		cel 0
		cursor 900
		message 4
		lowlightColor 14
		noun 29
	)
)

(instance hintCharge of InvI
	(properties
		loop 1
		cursor 925
		message 50
		noun 2
	)

	(method (doVerb theVerb &tmp [temp0 30])
		(switch theVerb
			(1
				(if global115
					(Message msgGET 1 noun 1 1 1 @temp0)
					(gMessager sayFormat: 99 @temp0 global115)
				else
					(gMessager say: noun 1 2 0 0 1) ; "Your Hint Watch Battery has no more hint charges left."
				)
			)
			(4
				(if global115
					(gMessager say: noun 4 1 0 0 1) ; "Sorry, you'll have to leave your Hint Watch Battery in your inventory."
				else
					(gMessager say: noun 4 2 0 0 1) ; "Your Hint Watch Battery is out of charges. To charge it up, solve another puzzle."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance achievementBoard of InvI
	(properties
		cursor 900
		noun 3
	)

	(method (select)
		(= global167 1)
		(Inv state: (& (Inv state:) $ffdf))
	)
)

(instance numberSheet of InvI
	(properties
		cel 1
		cursor 919
		message 28
		noun 5
	)
)

(instance bookcaseKey of InvI
	(properties
		cel 3
		cursor 921
		message 30
		noun 7
	)
)

(instance sheetMusic of InvI
	(properties
		cel 5
		cursor 923
		message 31
		noun 8
	)
)

(instance patternPeices of InvI
	(properties
		cel 6
		cursor 924
		message 32
		noun 9
	)
)

(instance appleBucket of InvI
	(properties
		cel 7
		cursor 914
		message 33
		noun 10
		owner 260
	)
)

(instance watermellon of InvI
	(properties
		cel 8
		cursor 916
		message 34
		noun 11
		owner 260
	)
)

(instance cornBucket of InvI
	(properties
		cel 9
		cursor 915
		message 35
		noun 12
		owner 260
	)
)

(instance geneticMaterial of InvI
	(properties
		cel 14
		cursor 910
		message 36
		noun 13
		owner 300
	)
)

(instance hanoiDisks of InvI
	(properties
		cel 15
		cursor 918
		message 37
		noun 14
		owner 160
	)
)

(instance blackBag of InvI
	(properties
		cel 10
		cursor 917
		message 38
		noun 15
		owner 200
	)
)

(instance cart0 of InvI
	(properties
		cel 11
		cursor 911
		message 42
		noun 19
		owner 300
	)
)

(instance cart1 of InvI
	(properties
		cel 12
		cursor 912
		message 43
		noun 20
		owner 300
	)
)

(instance cart2 of InvI
	(properties
		cel 13
		cursor 913
		message 44
		noun 21
		owner 300
	)
)

(instance elevatorKey of InvI
	(properties
		cel 4
		cursor 922
		message 45
		noun 23
		owner 300
	)
)

(instance leftBorderIcon of IconI
	(properties
		view 10
		loop 9
		cel 0
		cursor 900
		message 0
		signal 4
		maskView 10
		maskLoop 9
	)
)

(instance rightBorderIcon of IconI
	(properties
		view 10
		loop 9
		cel 1
		cursor 900
		message 0
		signal 4
		maskView 10
		maskLoop 9
		maskCel 1
	)
)

(instance icon1 of IconI
	(properties
		view 10
		loop 0
		cel 0
		cursor 901
		message 1
		signal 65
		maskView 10
		maskLoop 8
		maskCel 2
		lowlightColor 14
		noun 27
	)
)

(instance icon2 of IconI
	(properties
		view 10
		loop 1
		cel 0
		cursor 900
		message 4
		signal 65
		maskView 10
		maskLoop 8
		maskCel 1
		lowlightColor 14
		noun 26
	)
)

(instance icon4 of IconI
	(properties
		view 10
		loop 2
		cel 0
		state 4
		cursor 999
		message 7
		signal 65
		maskView 10
		maskLoop 8
		maskCel 3
		lowlightColor 14
		noun 32
	)
)

(instance icon5 of IconI
	(properties
		view 10
		loop 3
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 10
		maskLoop 8
		maskCel 3
		lowlightColor 14
		noun 24
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
		view 10
		loop 4
		cel 0
		cursor 900
		type 0
		message 0
		signal 67
		maskView 10
		maskLoop 8
		maskCel 2
		lowlightColor 14
		noun 25
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(if (= temp0 (gCurRoom south:))
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 10
		loop 5
		cel 0
		cursor 900
		signal 67
		maskView 10
		maskLoop 8
		maskCel 1
		lowlightColor 14
		noun 28
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(Load rsSCRIPT 25)
			(= gGameControls (ScriptID 25 0)) ; controlBox
			((ScriptID 25 0) init: show: release: dispose:) ; controlBox
		)
	)
)

(instance icon9 of IconI
	(properties
		view 10
		loop 6
		cel 0
		cursor 906
		signal 3
		maskView 10
		maskLoop 8
		lowlightColor 14
		noun 29
	)
)

(instance icon10 of IconI
	(properties
		view 10
		loop 7
		cel 0
		cursor 900
		signal 3
		maskView 10
		maskLoop 8
		lowlightColor 14
		noun 30
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gMessager say: (gCurRoom noun:) 9 0 0)
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

(instance BrainVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(if (Message msgGET gCurRoomNum (param2 noun:) param1 0 0)
			(gMessager say: (param2 noun:) param1)
		else
			(gMessager say: 22 param1 0 0 0 1)
		)
	)
)

(instance bMessager of Messager
	(properties
		disposeWhenDone 0
		oneOnly 1
	)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(1
						(ScriptID 120 1) ; brainTalker120
					)
					(4
						(ScriptID 420 1) ; drTalker
					)
					(2
						(ScriptID 349 1) ; bustTalker
					)
					(3
						(ScriptID 30 0) ; brainTalker
					)
					((IsObject (ScriptID gCurRoomNum 1))
						(ScriptID gCurRoomNum 1)
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

