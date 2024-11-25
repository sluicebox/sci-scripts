;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use TwistyWindow)
(use TwistyIconItem)
(use TwistyInsetWindow)
(use pepper)
(use ADRoom)
(use Print)
(use Messager)
(use PAvoider)
(use Talker)
(use PseudoMouse)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Window)
(use Sound)
(use File)
(use Game)
(use User)
(use System)

(public
	twisty 0
	HaveMem 2
	proc0_3 3
	SetFlag 4
	IsFlag 5
	ClearFlag 6
	Face 7
	statusCode 9
	dictionary 10
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
	gDictionary
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
	gTwistyApproachCode
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
	gLongSong
	global101 = 1234
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
	gLongSong2
	global114 = 1
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
	gAct = 1
	global194
	; 195
	global195
	global196
	global197 = 6
	gExHandler
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
	global213 = 12
	global214
	; 215
	gDictionaryWord
	global216
	global217
	global218 = 1
	global219 = 1
	; 220
	global220 = 1
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
)

(procedure (HaveMem param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
		(= temp2 (/ (= temp1 [param2 temp0]) 16))
		(= temp3 (<< $0001 (mod temp1 16)))
		(switch param1
			(1
				(break)
			)
			(2
				(&= [global134 temp2] (~ temp3))
			)
			(0
				(|= [global134 temp2] temp3)
			)
			(3
				(^= [global134 temp2] temp3)
			)
		)
	)
	(return (& [global134 temp2] temp3))
)

(procedure (SetFlag)
	(localproc_0 0 &rest)
)

(procedure (IsFlag)
	(localproc_0 1 &rest)
)

(procedure (ClearFlag)
	(localproc_0 2 &rest)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp3 0)
	(= temp4 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (> argc 2)
			(if (IsObject param3)
				(= temp3 param3)
			else
				(= temp4 param3)
			)
			(if (== argc 4)
				(= temp3 param4)
			)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(if temp4
		(Face param2 param1)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc0_3 param1 param2 &tmp [temp0 40] [temp40 10] [temp50 10])
	(StrCpy
		@temp50
		(switch param2
			(7 {Do})
			(83 {Help})
			(6 {Look})
			(85 {Talk})
			(3 {Walk})
			(83 {Help})
			(86 {NOSE})
			(128 {Exit})
			(30 {PAW})
			(89 {TEETH})
			(84 {TRIVIA})
			(else {UNKNOWN VERB})
		)
	)
	(Format @temp40 0 1 gCurRoomNum) ; "%d.nor"
	(Format @temp0 0 2 (param1 name:) @temp50 gMouseX gMouseY) ; ";%s (%s) [%d,%d]:"
	(File name: @temp40 writeString: @temp0 {\0d\n} close:)
)

(class TwistySound of Sound
	(properties
		change 0
		nextSong 0
		loopTwice 0
		holdVal 0
	)

	(method (check)
		(if handle
			(DoSound sndUPDATE_CUES self)
		)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(if change
				(= change 0)
				(self play: vol client)
			else
				(if (IsObject client)
					(client cue: self)
				)
				(if (and nextSong (== prevSignal -1))
					(= number nextSong)
					(= nextSong 0)
					(self setLoop: -1 play: vol)
				)
				(if (== prevSignal 126)
					(if loopTwice
						(= loopTwice 0)
						(self play: vol)
						(if holdVal
							(self hold: holdVal)
						)
					else
						(= loopTwice 1)
					)
				)
			)
		)
	)

	(method (changeTo param1 param2)
		(= number param1)
		(= change 1)
		(if (> argc 1)
			(= client param2)
		)
	)
)

(instance longSong of TwistySound
	(properties
		flags 1
	)
)

(instance longSong2 of TwistySound
	(properties
		flags 1
	)
)

(instance kDHandler of EventHandler
	(properties)
)

(instance dirHandler of EventHandler
	(properties)
)

(instance mDHandler of EventHandler
	(properties)
)

(instance wHandler of EventHandler
	(properties)
)

(instance exHandler of EventHandler
	(properties)
)

(class twisty of Game
	(properties
		saveCursorX -1
		saveCursorY -1
	)

	(method (restore)
		(= global216 gNormalCursor)
		(= gNormalCursor 999)
		(= gSystemWindow SysWindow)
		(gSystemWindow back: 41 color: 15)
		(super restore: &rest)
		(= gNormalCursor global216)
		(= gSystemWindow TwistyWindow)
		(gGame setCursor: gNormalCursor 1)
	)

	(method (replay)
		(= gSystemWindow TwistyWindow)
		(= gNormalCursor global216)
		(statusCode doit:)
		(super replay:)
	)

	(method (save)
		(= global216 gNormalCursor)
		(= gNormalCursor 999)
		(= gSystemWindow SysWindow)
		(gSystemWindow back: 41 color: 15)
		(super save: &rest)
		(= gNormalCursor global216)
		(= gSystemWindow TwistyWindow)
		(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
		(gGame setCursor: gNormalCursor 1)
	)

	(method (setEgo param1 &tmp temp0)
		(= temp0 0)
		(if (gCast contains: gEgo)
			(= temp0 gEgo)
			(gCast delete: temp0)
		)
		((= gEgo param1) forceUpd: startUpd:)
		(if (not (gCast contains: gEgo))
			(gEgo init:)
		)
		(gUser alterEgo: gEgo)
		(if temp0
			(gCast addAfter: gEgo temp0)
		)
		(gTheIconBar curInvIcon: 0)
		(proc883_5)
	)

	(method (init &tmp temp0 temp1 [temp2 20])
		Print
		(ScriptID 894) ; invCode
		DText
		ego
		StopWalk
		PolyPath
		Polygon
		PAvoider
		TwistyInsetWindow
		TwistyWindow
		(ScriptID 982)
		Narrator
		ADRoom
		(ScriptID 883)
		statusCode
		(super init:)
		((ScriptID 879 0) doit:) ; initCode
		((ScriptID 894 0) init:) ; invCode
		((ScriptID 888 0) init:) ; theControls
		(gSystemWindow color: global125 back: global130)
		(= gVersion {x.yyy.zzz})
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiCLOSE temp1)
		(Format @temp2 0 0 880) ; "%d.scr"
		(if (FileIO fiEXISTS @temp2)
			(= global108 1)
		else
			(= global108 0)
		)
		(proc883_0)
		(= gEgo (ScriptID 895 0)) ; pepper
		(gUser alterEgo: (ScriptID 895 0)) ; pepper
		(proc883_5)
		((= gKeyDownHandler kDHandler) add:)
		((= gMouseDownHandler mDHandler) add:)
		((= gDirectionHandler dirHandler) add:)
		((= gWalkHandler wHandler) add:)
		(= gPMouse TWPseudoMouse)
		((= gExHandler exHandler) add:)
		(gMouseDownHandler addToFront: exHandler)
		(gKeyDownHandler addToFront: exHandler)
		(= gDoVerbCode twistyDoVerbCode)
		(= gFtrInitializer twistyFtrInit)
		(= gTwistyApproachCode twistyApproachCode)
		((= gNarrator Narrator) font: gUserFont back: global130 color: global125)
		(= gMsgType 1)
		(= gMessager twistyMessager)
		((= gLongSong longSong) owner: self priority: 15 init:)
		((= gLongSong2 longSong2) owner: self priority: 15 init:)
		(= gNormalCursor ((gTheIconBar at: 0) cursor:))
		(SetFlag 77)
		(= gAct 0)
		(self handsOff: setCursor: 999 1 newRoom: 100)
	)

	(method (doit)
		(if
			(and
				(gExHandler size:)
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
			)
			(gExHandler eachElementDo: #doit)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (gExHandler size:)
			(gExHandler eachElementDo: #dispose)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handsOff &tmp temp0)
		(if global201
			(return 0)
		else
			(= global201 1)
		)
		(User canControl: 0 canInput: 0)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(= temp0 (gTheIconBar curIcon:))
		(if (== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
			(gTheIconBar disable: 0 1 2 3 4 7 5 8 9)
		else
			(gTheIconBar disable: 0 1 2 3 4 5 8 6 8 9)
		)
		(gTheIconBar curIcon: temp0)
		(gGame setCursor: gWaitCursor 1)
		(return (and gPMouse (gPMouse stop:)))
	)

	(method (handsOn)
		(= global201 0)
		(User canControl: 1 canInput: 1)
		(if (== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
			(gTheIconBar enable: 0 1 2 3 4 5 6 7 8 9)
		else
			(gTheIconBar enable: 0 1 2 3 4 5 6 7 8 9)
		)
		(if (not (gTheIconBar curInvIcon:))
			(if (== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
				(gTheIconBar disable: 5)
			else
				(gTheIconBar disable: 6)
			)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(if (OneOf gCurRoomNum 120 135 140 150)
			(if (== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
				(gTheIconBar disable: (gTheIconBar at: 8))
			else
				(gTheIconBar disable: (gTheIconBar at: 9))
			)
		)
	)

	(method (points param1 param2)
		(if (not (IsFlag param1))
			(+= gScore param2)
			(SetFlag param1)
			(rm0Sound number: (+ param2 935) loop: 1 flags: 1 play:)
			(statusCode doit:)
		)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0 [temp1 20])
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

	(method (startRoom roomNum)
		((ScriptID 2000 3) ; PepperTalker
			winX: 0
			winY: 0
			cSpeed: 6
			dontUpd: 1
			talkLoop: -1
			forceWidth: 0
			talkWidth: 0
			offX: 0
			offY: 0
		)
		((ScriptID 2004 0) ; LockjawTalker
			winX: 0
			winY: 0
			cSpeed: 6
			dontUpd: 1
			talkLoop: -1
			forceWidth: 0
			talkWidth: 0
			offX: 0
			offY: 0
		)
		(gNarrator x: -1 y: -1)
		((ScriptID 895 0) normal: 1) ; pepper
		((ScriptID 895 1) normal: 0) ; lockjaw
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 898) doit: roomNum) ; disposeCode
		(if
			(and
				(> (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print
					font: gUserFont
					addText: {Memory Fragmented}
					addButton: 0 {Who cares} 0 12
					addButton: 1 {Debug} 50 12
					init:
				)
			)
			(SetDebug)
		)
		(if gDebugOn
			(SetDebug)
		)
		(statusCode doit:)
		(super startRoom: roomNum)
	)

	(method (quitGame)
		(= global216 gTheCursor)
		(self setCursor: 999 1)
		(super
			quitGame:
				(Print
					font: gUserFont
					addText: {Are You Sure?}
					addButton: 1 {QUIT} 0 12
					addButton: 0 {PLAY} 50 12
					init:
				)
		)
		(self setCursor: global216 1)
	)

	(method (restart)
		(= global216 gTheCursor)
		(self setCursor: 999 1)
		(if (not argc)
			(if
				(Print
					font: gUserFont
					addText: {You want to start over?}
					addButton: 1 {RESTART} 10 20
					addButton: 0 {PLAY} 85 20
					init:
				)
				(SetFlag 77)
				(statusCode doit:)
				(super restart:)
			else
				(self setCursor: global216 1)
			)
		else
			(SetFlag 77)
			(statusCode doit:)
			(super restart:)
		)
	)

	(method (pragmaFail)
		(if (User canInput:)
			(if (== gEgo (ScriptID 895 0)) ; pepper
				(gMessager say: 0 88 0 0 0 0) ; "Pepper can't use that here."
			else
				(gMessager say: 0 90 0 0 0 0) ; "That wouldn't do Lockjaw any good."
			)
			(if global108
				(proc0_3 gGame ((gUser curEvent:) message:))
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_TAB
						(if
							(and
								(not (IsFlag 2))
								(not (& (global192 signal:) $0004))
							)
							(global192 select:)
						)
						(event claimed: 1)
					)
					(KEY_SHIFTTAB
						(if
							(and
								(not (IsFlag 2))
								(not (& (global192 signal:) $0004))
							)
							(global192 select:)
						)
						(event claimed: 1)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global103 1)
								(gGame masterVolume: 15)
							)
							(else
								(gGame masterVolume: 1)
							)
						)
						(event claimed: 1)
					)
					(KEY_F5
						(if (and (not gModelessDialog) (not (IsFlag 2)))
							(gGame save:)
						)
						(event claimed: 1)
					)
					(KEY_F7
						(if (and (not gModelessDialog) (not (IsFlag 2)))
							(gGame restore:)
						)
						(event claimed: 1)
					)
					(KEY_F9
						(if (and (not gModelessDialog) (not (IsFlag 2)))
							(gGame restart:)
						)
						(event claimed: 1)
					)
					(KEY_ADD
						(if (gUser controls:)
							(= global197
								(Max 0 (- (gEgo moveSpeed:) 1))
							)
							(gEgo setSpeed: global197)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(= global197 (+ (gEgo moveSpeed:) 1))
							(gEgo setSpeed: global197)
						)
					)
					($003d ; =
						(if (gUser controls:)
							(= global197 6)
							(gEgo setSpeed: 6)
						)
					)
					(else
						(if global108
							((ScriptID 880) handleEvent: event) ; debugHandler
							((ScriptID 880) dispose:) ; debugHandler
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance twistyDoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp [temp0 300] temp300 temp301 temp302 temp303 [temp304 400])
		(if (== param1 3)
			((User curEvent:) claimed: 0)
		else
			(= temp301 0)
			(if (not (= temp302 (param2 modNum:)))
				(= temp302 0)
			)
			(switch param2
				((ScriptID 895 0) ; pepper
					(= temp300 31)
					(if (== param1 6)
						(if (== gEgo (ScriptID 895 0)) ; pepper
							(= temp301 2)
						else
							(= temp301 3)
						)
					)
				)
				((ScriptID 895 1) ; lockjaw
					(= temp300 23)
					(if (== param1 6)
						(if (== gEgo (ScriptID 895 0)) ; pepper
							(= temp301 1)
						else
							(= temp301 2)
						)
					)
				)
				(else
					(= temp300 (param2 noun:))
				)
			)
			(cond
				((not (OneOf param1 7 6 86 30 85 89 84))
					(if (== gEgo (ScriptID 895 0)) ; pepper
						(= temp303 88)
						(if (== param2 (ScriptID 895 1)) ; lockjaw
							(= temp303 90)
						)
					else
						(= temp303 90)
					)
					(cond
						((Message msgGET temp302 temp300 param1 temp301 1 @temp0)
							(gMessager say: temp300 param1 temp301 0 0 temp302)
						)
						((Message msgGET temp302 temp300 temp303 temp301 1 @temp0)
							(gMessager say: temp300 temp303 temp301 0 0 temp302)
						)
						((== (gCurRoom modNum:) -1)
							(gMessager say: 0 temp303 temp301 0 0 0)
						)
						(
							(Message
								msgGET
								(param2 modNum:)
								(param2 noun:)
								param1
								0
								1
								@temp0
							)
							(gMessager
								say:
									(param2 noun:)
									param1
									0
									1
									0
									(param2 modNum:)
							)
						)
						(
							(Message
								msgGET
								(gCurRoom modNum:)
								(gCurRoom noun:)
								param1
								0
								1
								@temp0
							)
							(gMessager
								say:
									(gCurRoom noun:)
									param1
									0
									1
									0
									(gCurRoom modNum:)
							)
						)
						(
							(and
								(== (gCurRoom modNum:) gCurRoomNum)
								(Message
									msgGET
									gCurRoomNum
									(gCurRoom noun:)
									param1
									0
									1
									@temp0
								)
							)
							(gMessager
								say: (gCurRoom noun:) param1 0 1 0 gCurRoomNum
							)
						)
						(else
							(gMessager say: 0 temp303 temp301 0 0 0)
						)
					)
				)
				((Message msgGET temp302 temp300 param1 temp301 1 @temp0)
					(gMessager say: temp300 param1 temp301 0 0 temp302)
				)
				((Message msgGET gCurRoomNum (gCurRoom noun:) param1 0 1 @temp0)
					(gMessager say: (gCurRoom noun:) param1 0 1 0 gCurRoomNum)
				)
				((Message msgGET 0 temp300 param1 temp301 1 @temp0)
					(gMessager say: temp300 param1 temp301 0 0 0)
				)
				((Message msgGET 0 0 param1 temp301 1 @temp0)
					(gMessager say: 0 param1 temp301 0 0 0)
				)
				(else
					(Prints {No Response})
					(proc0_3 param2 param1)
				)
			)
		)
	)
)

(instance twistyFtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance twistyMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(= global194 param1)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(91
						(ScriptID gCurRoomNum 15)
					)
					(45
						(ScriptID 2000 3) ; PepperTalker
					)
					(47
						(ScriptID 2000 3) ; PepperTalker
					)
					(48
						(ScriptID 2000 3) ; PepperTalker
					)
					(1
						((ScriptID 2000 1) doit: param1) ; setUpPepper
						(ScriptID 2000 0) ; pepperHeadTalk
					)
					(12
						((ScriptID 2000 1) doit: param1) ; setUpPepper
						(ScriptID 2000 0) ; pepperHeadTalk
					)
					(23
						((ScriptID 2000 1) doit: param1) ; setUpPepper
						(ScriptID 2000 0) ; pepperHeadTalk
					)
					(49
						(ScriptID 2000 3) ; PepperTalker
					)
					(34
						(ScriptID 2000 2) ; pepperBalloon
					)
					(50
						(ScriptID 2004 0) ; LockjawTalker
					)
					(15
						(ScriptID 2006 0) ; pughHeadTalk
					)
					(16
						(ScriptID gCurRoomNum 13)
					)
					(2
						(ScriptID gCurRoomNum 19)
					)
					(3
						(ScriptID 121 1) ; momText
					)
					(4
						(ScriptID 121 2) ; dadText
					)
					(5
						(ScriptID 2012 0) ; richardHeadTalk
					)
					(6
						(ScriptID gCurRoomNum 4)
					)
					(9
						(ScriptID gCurRoomNum 3)
					)
					(10
						((ScriptID 2014 2) doit: param1) ; setUpBen
						(ScriptID 2014 0) ; benHeadTalk
					)
					(98
						((ScriptID 2014 2) doit: param1) ; setUpBen
						(ScriptID 2014 0) ; benHeadTalk
					)
					(13
						((ScriptID 2014 2) doit: param1) ; setUpBen
						(ScriptID 2014 0) ; benHeadTalk
					)
					(14
						(ScriptID gCurRoomNum 16)
					)
					(7
						(ScriptID 2016 0) ; deborahTalker
					)
					(8
						(ScriptID gCurRoomNum 17)
					)
					(17
						(ScriptID 2018 0) ; imaHeadTalk
					)
					(18
						(ScriptID 2018 1) ; imaText
					)
					(19
						(ScriptID 2020 0) ; percyHeadTalk
					)
					(20
						(ScriptID gCurRoomNum 14)
					)
					(51
						(ScriptID 2020 0) ; percyHeadTalk
					)
					(21
						(ScriptID gCurRoomNum 1)
					)
					(24
						(ScriptID gCurRoomNum 5)
					)
					(25
						(ScriptID gCurRoomNum 6)
					)
					(26
						(ScriptID gCurRoomNum 1)
					)
					(27
						(ScriptID gCurRoomNum 2)
					)
					(28
						(ScriptID gCurRoomNum 3)
					)
					(30
						(ScriptID gCurRoomNum 6)
					)
					(32
						(ScriptID gCurRoomNum 10)
					)
					(33
						(ScriptID gCurRoomNum 9)
					)
					(36
						(ScriptID gCurRoomNum 4)
					)
					(29
						(ScriptID gCurRoomNum 5)
					)
					(39
						(ScriptID gCurRoomNum 11)
					)
					(40
						(ScriptID gCurRoomNum 12)
					)
					(41
						(ScriptID gCurRoomNum 2)
					)
					(43
						(ScriptID gCurRoomNum 2)
					)
					(44
						(ScriptID gCurRoomNum 2)
					)
					(31
						(ScriptID gCurRoomNum 7)
					)
					(37
						(ScriptID gCurRoomNum 8)
					)
					(38
						(ScriptID gCurRoomNum 3)
					)
					(22
						(ScriptID gCurRoomNum 1)
					)
					(52
						(ScriptID gCurRoomNum 2)
					)
					(11
						(ScriptID gCurRoomNum 18)
					)
					(35
						(ScriptID gCurRoomNum 2)
					)
					(else
						(ScriptID gCurRoomNum 1)
					)
				)
			)
			(return)
		else
			(if global108
				(Printf {Error in findTalker\ntalker num: %d} param1)
			)
			(super findTalker: param1)
		)
	)
)

(instance twistyApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(6 1)
				(85 2)
				(3 4)
				(7 8)
				(30 16)
				(86 32)
				(89 64)
				(84 128)
				(else 256)
			)
		)
	)
)

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

(instance statusCode of Code
	(properties)

	(method (doit &tmp [temp0 80] [temp80 80])
		(Message msgGET 0 35 0 4 1 @temp0) ; "Score: %d"
		(Message msgGET 0 35 0 4 2 @temp80) ; "%d"
		(Format @temp80 @temp0 gScore)
		(if (not (IsFlag 77))
			(DrawStatus @temp80 21 0)
		else
			(DrawStatus @temp80 0 0)
		)
	)
)

(instance TWPseudoMouse of PseudoMouse
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) $0040) ; direction
			(= temp0 (gTheIconBar curIcon:))
			(gTheIconBar curIcon: 0)
			(super handleEvent: event)
			(gTheIconBar curIcon: temp0)
		)
	)
)

(instance dictionary of Code
	(properties)

	(method (doit &tmp temp0 [temp1 1500] temp1501 temp1502 temp1503 temp1504 temp1505 temp1506)
		(= temp1505 ((User curEvent:) x:))
		(= temp1506 ((User curEvent:) y:))
		(= global216 gTheCursor)
		(SetCursor 996 0 0)
		(if
			(OneOf
				gDictionaryWord
				8
				9
				12
				14
				15
				18
				19
				21
				22
				26
				44
				49
				50
				55
				57
				58
				68
				71
				72
				74
				75
				83
				97
				100
				103
			)
			(= temp1501 200)
			(= temp1503 80)
			(= temp1504 100)
		else
			(= temp1501 160)
			(= temp1503 90)
			(= temp1504 120)
		)
		(Message msgPUSH)
		(= temp1502 (TwistyWindow new:))
		(if (not (Message msgGET 801 1 0 gDictionaryWord 1 @temp1))
			(Format @temp1 {ERROR: Vocab word not defined!})
		)
		(if (== gDictionaryWord 58)
			(gLongSong2 number: 927 setLoop: 1 play:)
		)
		((Print new:)
			width: temp1501
			window: temp1502
			font: gUserFont
			x: temp1503
			y: temp1504
			addText: @temp1
			init:
		)
		(Message msgPOP)
		(UnLoad 143 801)
		(gGame setCursor: global216 1 temp1505 temp1506)
	)
)

