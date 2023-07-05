;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use LoadMany)
(use Grooper)
(use Window)
(use Ego)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	TheGame 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	runScript 4
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
	global100
	global101 = 1234
	gDemoSound
	global103 = 1
	global104 = 1
	; 105
	global105 = 1
	global106 = 1
	global107
	global108
	global109
	; 110
	global110
	global111 = 7
	gPSound
	global113
	global114
	; 115
	gStopGroop
	global116
	global117 = 1
	global118 = 12
	global119
	; 120
	global120
	global121
	global122
	global123 = -1
	global124 = 175
	; 125
	global125 = 280
	global126 = 360
	global127 = 470
	global128 = 590
	global129 = 685
	; 130
	global130 = 785
	global131 = 865
	global132 = 975
	global133 = 1080
	global134 = 1165
	; 135
	global135 = 1275
	global136
	global137
	global138
	global139
	; 140
	global140
	gLongSong
	gLongSong2
	global143
	gLongSong3
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

(procedure (proc0_1 param1)
	(= [global250 (/ param1 16)]
		(| [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (proc0_2 param1)
	(= [global250 (/ param1 16)]
		(& [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (proc0_3 param1) ; UNUSED
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(instance demoSound of Sound
	(properties)
)

(instance pSound of Sound
	(properties
		flags 1
		number 907
	)
)

(instance egoObj of Ego
	(properties)
)

(instance TheGame of Game
	(properties)

	(method (handsOff)
		(super handsOff:)
		(gUser canInput: 0 canControl: 0)
		(if (not (HaveMouse))
			(gGame setCursor: 996)
		else
			(gGame setCursor: gWaitCursor)
		)
	)

	(method (handsOn)
		(super handsOn:)
		(self setCursor: 999 1)
		(gUser canInput: 1)
		(gUser canControl: 0)
	)

	(method (init &tmp temp0 temp1 [temp2 100] temp102 [temp103 20])
		(LoadMany rsSCRIPT 982)
		(super init:)
		(StrCpy @gSysLogPath {})
		(= gVersion {x.yyy.zzz})
		(= global107 {mm/dd/yy})
		(= global108 {991-999-9999})
		(= global109 {992-999-9999})
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiREAD_STRING global108 20 temp1)
		(FileIO fiREAD_STRING global109 20 temp1)
		(FileIO fiREAD_STRING global108 20 temp1)
		(FileIO fiCLOSE temp1)
		(= gSystemWindow SysWindow)
		(= gUserFont 4)
		(Print font: 4)
		((= gNarrator Narrator) font: gUserFont back: 11 keepWindow: 1)
		(= gMsgType 1)
		(= gUseSortedFeatures 1)
		(= gEatMice 30)
		(= gTextSpeed 2)
		(= gPMouse PseudoMouse)
		(= global113 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global114 (Graph grGET_COLOURS)) 2) (<= global114 16))
			(proc0_2 1)
		else
			(proc0_1 1)
		)
		(gSystemWindow color: global110 back: global111)
		(= gStopGroop stopGroop)
		(self setCursor: 999 1 160 160)
		(= gEgo egoObj)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(= gDemoSound demoSound)
		(= gMessager gameMessager)
		((= gMouseDownHandler MH) add:)
		((= gKeyDownHandler KH) add:)
		((= gDirectionHandler DH) add:)
		((= gPSound pSound) owner: self init:)
		((= gLongSong longSong) owner: self priority: 15 init:)
		((= gLongSong2 longSong2) owner: self priority: 15 init:)
		((= gLongSong3 longSong3) owner: self priority: 15 init:)
		(gKeyDownHandler addToFront: TheGame)
		(if (FileIO fiEXISTS {880.scr})
			(while 1
				(= temp103 0)
				(= temp102
					(Print
						font: gSmallFont
						addText: {Enter room number...} 0 0
						addEdit: @temp103 5 125 0
						init:
					)
				)
				(if temp103
					(= temp102 (ReadNumber @temp103))
				)
				(if (> temp102 0)
					(break)
				)
			)
			(gGame masterVolume: 15)
			(if (!= (Platform 4 0) 1)
				(= global143 1)
			)
			(if (< temp102 13)
				(= global106 temp102)
			)
			(self newRoom: temp102)
		else
			(self newRoom: 812)
		)
	)

	(method (startRoom param1)
		(if gPMouse
			(gPMouse stop:)
		)
		(rightArrow dispose: delete:)
		(leftArrow dispose: delete:)
		(stopButton dispose: delete:)
		(LoadMany
			0
			813
			814
			815
			816
			922
			982
			255
			929
			941
			961
			806
			805
			807
			808
			809
			874
			830
			991
			948
		)
		(gKeyDownHandler delete: TheGame)
		(if (u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(Prints {Memory fragmented.})
			(SetDebug)
		)
		(gKeyDownHandler addToFront: TheGame)
		(if (not (OneOf gCurRoomNum 812 804 111 801 802 803))
			(= global119 [global123 gCurRoomNum])
		else
			(= global119 9)
		)
		(if (!= gCurRoomNum 13)
			(stopButton view: global119 init: stopUpd:)
			(leftArrow view: global119 init: stopUpd:)
			(rightArrow view: global119 init: stopUpd:)
		)
		(super startRoom: param1)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(if (IsObject param1)
			(gTheCursor init:)
		else
			((= gTheCursor cursorObj)
				view: 990
				loop: 0
				setCel:
					(switch param1
						(999 10)
						(998 11)
						(997 12)
						(996 0)
						(else param1)
					)
				init:
			)
		)
		(if (and (> argc 1) (not param2))
			((= gTheCursor cursorObj) view: 996 loop: 0 setCel: 0 init:)
		)
		(if (> argc 2)
			(gTheCursor posn: param3 param4)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
				(not (== gCurRoomNum 801))
				(== global120 1)
			)
			(= global120 0)
			(super handleEvent: event)
		)
		(cond
			(
				(and
					(== (gTheCursor cel:) 10)
					(== (event type:) evKEYBOARD)
					(== (User canInput:) 1)
				)
				(switch (event message:)
					(KEY_SPACE
						(if (!= gCurRoomNum 111)
							(event claimed: 1)
							(stopButton setScript: stopButtonScript)
						)
					)
					(KEY_f
						(if (not (OneOf gCurRoomNum 801 802 803 812 817))
							(event claimed: 1)
							(rightArrow setScript: rightArrowScript)
						)
					)
					(KEY_b
						(if (not (OneOf gCurRoomNum 801 803 812 817))
							(event claimed: 1)
							(leftArrow setScript: leftArrowScript)
						)
					)
					(KEY_p
						(= global120 0)
						(event claimed: 1)
					)
					(KEY_r
						(= global120 1)
						(event claimed: 1)
						(rightArrow setScript: rightArrowScript)
					)
					(KEY_RETURN
						(cond
							((and (< (event x:) 15) (> (event y:) 185))
								(event claimed: 1)
								(leftArrow setScript: leftArrowScript)
							)
							((and (> (event x:) 308) (> (event y:) 185))
								(event claimed: 1)
								(rightArrow setScript: rightArrowScript)
							)
							((== (OnControl CONTROL (event x:) (event y:)) 8)
								(event claimed: 1)
								(stopButton setScript: stopButtonScript)
							)
						)
					)
					(else
						(if (FileIO fiEXISTS {880.SCR})
							(event claimed: 0)
							((ScriptID 880) handleEvent: event) ; MISSING SCRIPT
							((ScriptID 880) dispose:) ; MISSING SCRIPT
							(DisposeScript 880)
						)
					)
				)
			)
			(
				(and
					(== (gTheCursor cel:) 10)
					(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
					(== (User canInput:) 1)
				)
				(cond
					((and (< (event x:) 20) (> (event y:) 175))
						(event claimed: 1)
						(leftArrow setScript: leftArrowScript)
					)
					((and (> (event x:) 300) (> (event y:) 175))
						(event claimed: 1)
						(rightArrow setScript: rightArrowScript)
					)
					((== (OnControl CONTROL (event x:) (event y:)) 8)
						(event claimed: 1)
						(stopButton setScript: stopButtonScript)
					)
				)
			)
			((FileIO fiEXISTS {880.SCR})
				(event claimed: 0)
				((ScriptID 880) handleEvent: event) ; MISSING SCRIPT
				((ScriptID 880) dispose:) ; MISSING SCRIPT
				(DisposeScript 880)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance MH of EventHandler
	(properties)
)

(instance KH of EventHandler
	(properties)
)

(instance DH of EventHandler
	(properties)
)

(instance gameMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(else gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance cursorObj of Cursor
	(properties)
)

(instance leftArrow of Prop
	(properties
		x 11
		y 196
		priority 15
		signal 16
	)
)

(instance rightArrow of Prop
	(properties
		x 308
		y 196
		loop 1
		priority 15
		signal 16
	)
)

(instance stopButton of Prop
	(properties
		x 158
		y 158
		loop 2
		priority 15
		signal 16
	)
)

(instance leftArrowScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 10] temp10)
		(switch (= state newState)
			(0
				(if (OneOf gCurRoomNum 13 111 801 803 812 817)
					(self dispose:)
				else
					(gGame handsOff:)
					(= temp10 global106)
					(leftArrow view: global119 setCel: 1)
					(= cycles 2)
				)
			)
			(1
				(mySound number: 910 loop: 1 play:)
				(= ticks 24)
			)
			(2
				(leftArrow setCel: 0)
				(= ticks 6)
			)
			(3
				(if (== global106 1)
					(self cue:)
				else
					(-- global106)
				)
				(if (not (== gCurRoomNum 801))
					(switch gCurRoomNum
						(1
							(gCurRoom newRoom: 801)
						)
						(else
							(gCurRoom newRoom: global106)
						)
					)
				else
					(gCurRoom newRoom: 801)
				)
			)
		)
	)
)

(instance rightArrowScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 10] temp10)
		(switch (= state newState)
			(0
				(if (OneOf gCurRoomNum 812 804 111 801 802 803 817)
					(self dispose:)
				else
					(gGame handsOff:)
					(= temp10 global106)
					(rightArrow view: global119 setCel: 1)
					(= cycles 2)
				)
			)
			(1
				(mySound number: 910 loop: 1 play:)
				(= ticks 24)
			)
			(2
				(rightArrow setCel: 0)
				(= ticks 6)
			)
			(3
				(if (== global106 global118)
					(== global106 global118)
				else
					(++ global106)
				)
				(if (not (== gCurRoomNum 801))
					(switch gCurRoomNum
						(12
							(gCurRoom newRoom: 804)
						)
						(else
							(gCurRoom newRoom: global106)
						)
					)
				else
					(gCurRoom newRoom: 801)
				)
			)
		)
	)
)

(instance stopButtonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(stopButton view: global119 setCel: 1)
				(= cycles 2)
			)
			(1
				(mySound number: 910 loop: 1 play:)
				(= ticks 24)
			)
			(2
				(stopButton setCel: 0)
				(= ticks 6)
			)
			(3
				(if (not (== gCurRoomNum 801))
					(gCurRoom newRoom: 801)
				else
					(gCurRoom newRoom: 803)
				)
			)
		)
	)
)

(instance runScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(if global120
					(= ticks 250)
				else
					(self dispose:)
				)
			)
			(1
				(if global120
					(mySound number: 910 loop: 1 play:)
					(rightArrow view: global119 setCel: 1 init:)
					(= ticks 24)
				)
			)
			(2
				(rightArrow setCel: 0)
				(= ticks 6)
			)
			(3
				(if (== global106 global118)
					(gCurRoom newRoom: 801)
				else
					(++ global106)
				)
				(gGame handsOff:)
				(gCurRoom newRoom: global106)
				(self dispose:)
			)
		)
	)
)

(instance longSong of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance longSong2 of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance longSong3 of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance mySound of Sound
	(properties)
)

