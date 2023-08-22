;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use ego_7)
(use PQIconItem)
(use TransPlane)
(use n045)
(use Styler)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use Talker)
(use IconBar)
(use PolyPath)
(use Polygon)
(use Timer)
(use Grooper)
(use Flags)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	pq4 0
	StickTimer 1
	MirrorTimer 2
	Face 3
	proc0_4 4
	transPlane 5
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gThePlane
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gPlanes
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gTextCode
	gCuees
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gEventMask = 32767
	gBigFont = 1
	gVersion
	gAutoRobot
	gCurSaveDir
	; 30
	gNumCD
	gPerspective
	gFeatures
	gPanels
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemPlane
	gSaveFileSelText
	; 40
	global40
	global41
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
	gEndSysLogPath
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gApproachCode
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
	gSpeechHandler
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	gExtMouseHandler
	gTalkers
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
	gAltPolyList
	gScreenWidth
	gScreenHeight
	gLastScreenX
	gLastScreenY
	; 100
	global100
	global101 = 1234
	global102
	gGlobalSound0
	gGlobalSound1
	; 105
	global105
	global106
	global107
	global108
	gDButton
	; 110
	global110
	global111 = 3
	global112
	global113
	gPqFlags
	; 115
	gPqPointFlags
	global116
	global117
	global118
	global119
	; 120
	gDay
	gCaseInv
	global122
	global123
	global124
	; 125
	global125 = -1
	global126 = -1
	global127 = -1
	global128 = -1
	global129 = -1
	; 130
	global130
	global131
	gProp
	global133
	global134
	; 135
	global135 = -1
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
	gTheInvisCursor
	gTheArrowCursor
	global148
	global149 = 99
	; 150
	global150
	global151
	global152
	gFlags
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
	global164 = 5000
	; 165
	gExitArrow
	global166
	global167
	global168
	global169
	; 170
	global170
	global171 = 11
	global172
	global173 = -1
	global174 = -1
	; 175
	global175 = 316
	global176 = 1
	global177
	global178
	global179
	; 180
	global180
	global181
	gGlobalSound2
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
)

(procedure (Face param1 param2 param3 &tmp temp0 temp1)
	(= temp1 (if (== argc 3) param3 else 0))
	(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(cond
		((> (Abs (- temp0 (gEgo heading:))) 23)
			(param1 setHeading: temp0 temp1)
		)
		(temp1
			(temp1 cue:)
		)
	)
)

(procedure (proc0_4 param1)
	(if param1
		(gPqFlags set: 1)
		(gTheIconBar disable: 6)
	else
		(gPqFlags clear: 1)
		(gTheIconBar enable: 6)
	)
)

(instance globalSound0 of Sound
	(properties)
)

(instance globalSound1 of Sound
	(properties)
)

(instance globalSound2 of Sound
	(properties)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance doUpdates of Code
	(properties)

	(method (doit param1)
		(if (param1 isNotHidden:)
			(UpdateScreenItem param1)
		)
	)
)

(class pq4 of Game
	(properties
		fadeSpeed 10
		lastTicks 0
		intensity 100
		remapOn 0
	)

	(method (save &tmp temp0)
		(= temp0 0)
		(if (gGlobalSound2 number:)
			(= temp0 (gGlobalSound2 number:))
			(gGlobalSound2 number: 0 stop:)
		)
		(super save: &rest)
		(if (and (not (gGlobalSound2 handle:)) temp0)
			(gGlobalSound2 number: temp0 play:)
		)
	)

	(method (doRemap param1)
		(RemapColors param1 &rest)
	)

	(method (setIntensity param1 param2)
		(Palette 2 69 236 param1) ; PalIntensity
		(gEgo setIntensity: param1 0)
		(if (and (> argc 1) param2)
			(FrameOut)
		)
	)

	(method (fade param1 param2 param3 param4 &tmp temp0 temp1)
		(if (> argc 3)
			(= temp1 param4)
		else
			(= temp1 0)
		)
		(if (and (< gHowFast 7) (> (self detailLevel:) 7))
			(cond
				((< param1 param2)
					(for
						((= temp0 (+ param1 param3)))
						(<= temp0 param2)
						((+= temp0 param3))
						
						(self setIntensity: temp0 1)
					)
				)
				((!= param1 param2)
					(for
						((= temp0 (- param1 param3)))
						(>= temp0 param2)
						((-= temp0 param3))
						
						(self setIntensity: temp0 1)
					)
				)
			)
			(self setIntensity: param2 1)
		else
			(self doRemap: 0)
			(cond
				((< param1 param2)
					(gCast eachElementDo: #perform doUpdates)
					(for
						((= temp0 (+ param1 param3)))
						(<= temp0 param2)
						((+= temp0 param3))
						
						(self setIntensity: temp0 1)
					)
				)
				((!= param1 param2)
					(for
						((= temp0 (- param1 param3)))
						(>= temp0 param2)
						((-= temp0 param3))
						
						(self setIntensity: temp0 1)
					)
				)
			)
			(gCurRoom doRemap:)
			(gCast eachElementDo: #perform doUpdates)
			(self setIntensity: param2 1)
		)
		(if temp1
			(temp1 cue:)
		)
	)

	(method (points param1 param2)
		(if (and (> argc 1) (gPqPointFlags test: param2))
			(return)
		)
		(if param1
			(+= gScore param1)
			(scoreSfx number: 2 loop: 1 play:)
			(if (and (> argc 1) param2)
				(gPqPointFlags set: param2)
			)
		)
	)

	(method (play &tmp temp0 temp1 temp2 temp3)
		(super play: &rest)
		(= temp0 0)
		(while (Message msgSIZE 0 12 0 0 (++ temp0))
		)
		(= temp0 (Random 1 (- temp0 1)))
		(= temp1
			(Str
				newWith:
					(= temp3
						(+ (Message msgSIZE 0 12 0 0 temp0) (Message msgSIZE 0 12 0 7 1)) ; "Copyright (c) 1994 Sierra On-Line Inc.  Thank you for playing Police Quest IV: Open Season."
					)
					{}
			)
		)
		(= temp2 (Str newWith: temp3 {}))
		(Message msgGET 0 12 0 0 temp0 (temp1 data:))
		(Message msgGET 0 12 0 7 1 (temp2 data:)) ; "Copyright (c) 1994 Sierra On-Line Inc.  Thank you for playing Police Quest IV: Open Season."
		(temp2 cat: temp1)
		(SetQuitStr (temp2 data:))
	)

	(method (init)
		Flags
		Print
		StopWalk
		Polygon
		PolyPath
		Timer
		IconBar
		Inv
		PqInv
		PQInvItem
		(ScriptID 64982)
		Narrator
		(ScriptID 64255)
		ego
		(if (IsHiRes)
			(SetFontRes 640 480)
			(= gUserFont 2308)
		)
		(= global119 1)
		(= gDay 1)
		(Styler priority: 300)
		(User alterEgo: (= gEgo ego) canControl: 0 canInput: 0)
		(super init:)
		(gTimers
			add:
				((ScriptID 0 1) client: (ScriptID 0 1) yourself:) ; StickTimer, StickTimer
				((ScriptID 0 2) client: (ScriptID 0 2) yourself:) ; MirrorTimer, MirrorTimer
		)
		(gWalkHandler name: {wh})
		(gMouseDownHandler name: {mh})
		(gDirectionHandler name: {dh})
		(gKeyDownHandler name: {kh})
		(= gSystemPlane Plane)
		((ScriptID 26 0) init:) ; pqInv
		(= global122 (gInventory at: 3)) ; evidenceCase
		((ScriptID 27 0) init:) ; caseInv
		((gCaseInv at: 0) owner: global122)
		((gCaseInv at: 4) owner: global122)
		((gCaseInv at: 5) owner: global122)
		((gCaseInv at: 6) owner: global122)
		((gCaseInv at: 1) owner: global122)
		((gCaseInv at: 2) owner: global122)
		((gCaseInv at: 3) owner: global122)
		(= gMessager pqMessager)
		(= handsOffCode pqHandsOff)
		(= handsOnCode pqHandsOn)
		(= gDoVerbCode pqDoVerbCode)
		(= gFtrInitializer pqFtrInit)
		(= gApproachCode pqApproachCode)
		(= gPqFlags pqFlags)
		(= gPqPointFlags pqPointFlags)
		(gGame setCursor: (ScriptID 25 1)) ; walkCursor
		(= gVersion {x.yyy.zzz})
		(gPqFlags init: set: 25 13 22 23)
		(gPqPointFlags init:)
		((= gTheIconBar (ScriptID 25 0)) init:) ; pqIconBar
		(gThePlane picture: 0 setRect: 0 0 319 199 1)
		((ScriptID 4) doit:) ; initCode
		(= gNarrator Narrator)
		((= gGlobalSound0 globalSound0) owner: self flags: 5 init:)
		((= gGlobalSound1 globalSound1) owner: self flags: 5 init:)
		((= gGlobalSound2 globalSound2) number: 0 owner: self flags: 5 init:)
		(Narrator fore: 13)
		(self newRoom: 6) ; speedRoom
		(self doRemap: 5 0 38)
		(self doRemap: 2 254 75)
		(self doRemap: 2 253 75)
	)

	(method (doit)
		(if (gPqFlags test: 52)
			(gPqFlags clear: 52)
			(if (> (Abs (- gGameTime lastTicks)) 30)
				(ResetLastTicks doit: self)
				(ResetLastTicks doit: gCurRoom)
				(if gCast
					(gCast eachElementDo: #perform ResetLastTicks)
				)
				(if gTheDoits
					(gTheDoits eachElementDo: #perform ResetLastTicks)
				)
			)
		)
		(= lastTicks gGameTime)
		(super doit:)
	)

	(method (startRoom roomNum &tmp temp0)
		(Narrator y: 15)
		(gMouseDownHandler release:)
		(gKeyDownHandler release:)
		(gDirectionHandler release:)
		(if gDebugOn
			(SetDebug)
		)
		(globalSound0 client: 0)
		(globalSound1 client: 0)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(Purge (gCurRoom purge:))
		(gCurRoom init:)
		(if global105
			((ScriptID 1) init:) ; debugRoom
		)
		(if (and (== gPrevRoomNum 6) (!= roomNum 3)) ; speedRoom, titleScreen
			(gTheIconBar show: 0)
		)
		(cond
			((OneOf (gCurRoom style:) 0 -1)
				(gCurRoom
					drawPic:
						(gCurRoom picture:)
						(if (== (gCurRoom style:) -1)
							0
						else
							(gCurRoom style:)
						)
				)
				(FrameOut)
				(self fade: 0 intensity fadeSpeed)
			)
			((not (OneOf (gCurRoom style:) 16 15 17 18))
				(self setIntensity: intensity 0)
				(gCurRoom drawPic: (gCurRoom picture:) (gCurRoom style:))
				(gCurRoom doRemap:)
				(gCast eachElementDo: #perform doUpdates)
				(FrameOut)
			)
		)
		(= fadeSpeed 10)
		(= intensity 100)
		(gTheIconBar state: (& (gTheIconBar state:) $bfff) show: 0)
	)

	(method (newRoom newRoomNumber)
		(if (and global162 (<= global162 4))
			(++ global162)
		)
		(gTheIconBar state: (| (gTheIconBar state:) $4000) hide:)
		(= global130 0)
		(if
			(and
				gCurRoom
				(not (OneOf (gCurRoom style:) 16 15 17 18))
				(== (gCurRoom exitStyle:) -1)
				(!= newRoomNumber 17) ; MapRoom
			)
			(self fade: intensity 0 fadeSpeed)
		)
		(if (gTheDoits size:)
			(gTheDoits eachElementDo: #dispose 1 release:)
		)
		(if (and gCuees (gCuees size:))
			(gCuees eachElementDo: #dispose release: dispose:)
			(= gCuees 0)
		)
		(gTalkers
			eachElementDo: #caller 0
			eachElementDo: #cueVal 1
			eachElementDo: #dispose
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (quitGame)
		(= global179 gTheCursor)
		(gGame setCursor: gNormalCursor 1)
		(SetCursor 155 81)
		(proc45_1)
		(while 1
			(switch
				(Print
					fore: 0
					addBitmap: 64994 1 0
					addText: 14 0 0 1 5 2 0 ; "Request Code Seven"
					addButtonBM: 64994 0 0 0 14 0 11 1 12 33 0
					addButtonBM: 64994 0 0 1 14 0 10 1 12 57 0
					init:
				)
				(0
					(break)
				)
				(1
					(= gQuit 1)
					(break)
				)
			)
		)
		(proc45_2)
		(gGame setCursor: global179 1)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (& (event type:) evKEYBOARD)
			(event claimed: 1)
			(cond
				((== (event message:) KEY_ALT_l)
					((ScriptID 64952) doit:) ; sysLogger
				)
				((OneOf (event message:) KEY_CONTROL KEY_ALT_x KEY_ALT_q)
					(gGame quitGame:)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (restart param1 &tmp temp0 temp1 temp2 temp3)
		(= global179 gTheCursor)
		(gGame setCursor: gNormalCursor 1)
		(SetCursor 155 80)
		(proc45_1)
		(if (not argc)
			(while 1
				(switch
					(Print
						addBitmap: 64994 1 0
						addText: 17 0 0 1 5 2 0 ; "Do you really want to restart?"
						addButtonBM: 64994 0 0 0 17 0 11 1 12 33 0
						addButtonBM: 64994 0 0 1 17 0 10 1 12 57 0
						init:
					)
					(0
						(return 0)
					)
					(1
						(break)
					)
				)
			)
		)
		(proc45_2)
		(gGame setCursor: global179 1)
		(gThePlane setRect: 0 0 319 199)
		(gCurRoom drawPic: 0 0)
		(gCast eachElementDo: #dispose)
		(PalVary 3) ; PalVaryKill
		(gSounds eachElementDo: #stop)
		(gGame setCursor: gWaitCursor setScript: 0)
		(for
			((= temp0 (gInventory first:)))
			temp0
			((= temp0 (gInventory next: temp0)))
			
			(if ((= temp1 (NodeValue temp0)) isKindOf: InvI)
				(temp1 owner: 0)
			)
		)
		(gWalkHandler release:)
		(gMouseDownHandler release:)
		(gKeyDownHandler release:)
		(gDirectionHandler release:)
		(gPqFlags dispose: init: set: 25 13 22 23 133)
		(gPqPointFlags dispose: init:)
		(= gDebugOn 0)
		(= gScore 0)
		(= gPossibleScore 0)
		(= global102 0)
		(= global105 0)
		(= global110 0)
		(= global112 0)
		(= global113 0)
		(= global116 0)
		(= global117 0)
		(= global118 0)
		(= global119 0)
		(= gDay 1)
		(= global123 0)
		(= global124 0)
		(= global125 -1)
		(= global126 -1)
		(= global127 -1)
		(= global128 -1)
		(= global129 -1)
		(= global130 0)
		(= global131 0)
		(= gProp 0)
		(= global133 0)
		(= global134 0)
		(= global135 -1)
		(= global136 0)
		(= global137 0)
		(= global138 0)
		(= global139 0)
		(= global140 0)
		(= global141 0)
		(= global142 0)
		(= global143 0)
		(= global144 0)
		(= global145 0)
		(= global148 0)
		(= global149 99)
		(= global150 0)
		(= global151 0)
		(= temp2 (Str newWith: 10 {}))
		(= temp3 (Str newWith: 10 {}))
		(Message msgGET 0 1 0 0 1 (temp2 data:)) ; "%d.scr"
		(temp3 format: (temp2 data:) 1)
		(if (FileIO fiEXISTS (temp3 data:))
			(= global105 1)
		)
		(Message msgGET 0 13 0 0 1 (temp2 data:)) ; "cd.dat"
		(= gMsgType 2)
		(gGame detailLevel: 5)
		(= global110 (DoSound sndGET_POLYPHONY))
		(temp2 dispose:)
		(temp3 dispose:)
		(gThePlane setRect: 0 0 319 152)
		(gTheIconBar
			locked: 0
			curIcon: (gTheIconBar at: 0)
			highlightedIcon: 0
			curInvIcon: 0
			enable:
		)
		((gTheIconBar at: 9) cel: 0)
		(if (and argc param1)
			(= global111 param1)
		else
			(= global111 100)
		)
		(return (self newRoom: 6)) ; speedRoom
	)
)

(instance pqHandsOff of Code
	(properties)

	(method (doit)
		(if (not global113)
			(= global113 (gTheIconBar curIcon:))
		)
		(= global117 (gUser canControl:))
		(= global118 (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(= global116 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar curIcon: (gTheIconBar at: 7))
		(gTheIconBar disable: 0 1 2 3 4 5 7 6 disable:)
		(if (not (HaveMouse))
			(gGame setCursor: 996 1)
		else
			(gGame setCursor: gWaitCursor 1)
		)
		(gTheIconBar show: 0)
	)
)

(instance pqHandsOn of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(gUser canControl: 1 canInput: 1)
		(= temp2 (gTheIconBar at: 4))
		(if (gTheIconBar curInvIcon:)
			(temp2 signal: (& (temp2 signal:) $fffb))
		else
			(temp2 signal: (| (temp2 signal:) $0004))
		)
		(gTheIconBar enable: 0 1 2 3 5 enable:)
		(if (gPqFlags test: 1)
			(gTheIconBar disable: 6)
		else
			(gTheIconBar enable: 6)
		)
		(if (not (gCurRoom inset:))
			(gTheIconBar enable: 7)
		)
		(if (and argc param1)
			(gUser canControl: global117 canInput: global118)
			(= temp1 0)
			(for
				((= temp0 (gTheIconBar first:)))
				temp0
				((= temp0 (gTheIconBar next: temp0)))
				
				(if (& global116 (>> $8000 temp1))
					(gTheIconBar disable: temp1)
				)
				(++ temp1)
			)
		)
		(if global113
			(gTheIconBar curIcon: global113)
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
					(not (gTheIconBar curInvIcon:))
				)
				(gTheIconBar advanceCurIcon:)
			)
		)
		(= global113 0)
		(gGame setCursor: (gTheIconBar getCursor:) 1)
		(gEgo setSpeed: global112)
		(gTheIconBar show: 0)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global116 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance pqMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(= global181 param1)
		(= temp0
			(switch param1
				(64
					(ScriptID 44 0) ; invTalker
				)
				(62
					(ScriptID 43 0) ; computerTalker
				)
				(63
					(ScriptID 42 0) ; signTalker
				)
				(99
					(if (== gCurRoomNum 130)
						(ScriptID 130 2) ; rmTalker
					else
						gNarrator
					)
				)
				(1
					(ScriptID 24 0) ; ibTalker
				)
				(2
					(ScriptID 19 1) ; screenTalker
				)
				(97 Narrator)
				(41
					(ScriptID 270 1) ; markTalker
				)
				(46
					(ScriptID 515 1) ; teddyTalker
				)
				(20
					(ScriptID 315 1) ; barbieTalker
				)
				(13
					(if (== gCurRoomNum 190)
						(ScriptID 190 2) ; momTalker
					else
						gNarrator
					)
				)
				(21
					(if (== gCurRoomNum 220)
						(ScriptID 220 1) ; bertTalker
					else
						gNarrator
					)
				)
				(9
					(switch gCurRoomNum
						(115
							(ScriptID 115 2) ; bildenTalker
						)
						(505
							(ScriptID 505 1) ; kristyTalker
						)
						(240
							(ScriptID 240 1) ; bildenTalker
						)
						(else gNarrator)
					)
				)
				(42 gNarrator)
				(7
					(switch gCurRoomNum
						(545
							(ScriptID 545 1) ; blockTalker
						)
						(395
							(ScriptID 395 1) ; blockTalker
						)
						(else gNarrator)
					)
				)
				(8 gNarrator)
				(12
					(if (== gCurRoomNum 115)
						(ScriptID 115 1) ; kimTalker
					else
						gNarrator
					)
				)
				(11
					(ScriptID 532 1) ; chiefTalker
				)
				(43
					(ScriptID 100 13) ; cop1Talker
				)
				(38
					(ScriptID 100 14) ; cop2Talker
				)
				(6
					(switch gCurRoomNum
						(100
							(ScriptID 100 2) ; coronerTalker
						)
						(275
							(ScriptID 275 1) ; samTalker
						)
						(else gNarrator)
					)
				)
				(25
					(switch gCurRoomNum
						(100
							(ScriptID 100 3) ; crimTalker
						)
						(580
							(ScriptID 580 1) ; chesterTalker
						)
						(else gNarrator)
					)
				)
				(18
					(switch gCurRoomNum
						(810
							(ScriptID 810 1) ; dannyTalker
						)
						(860
							(ScriptID 860 1) ; dannyTalker
						)
						(else gNarrator)
					)
				)
				(3
					(if global130
						global130
					else
						(egoT
							x:
								(Max
									30
									(Min (- (gEgo x:) 75) 220)
								)
						)
						egoT
					)
				)
				(24 gNarrator)
				(27
					(if (== gCurRoomNum 140)
						(ScriptID 140 1) ; emmoTalker
					else
						gNarrator
					)
				)
				(28
					(if (== gCurRoomNum 140)
						(ScriptID 140 2) ; gangTalker
					else
						gNarrator
					)
				)
				(16
					(if (gPqFlags test: 0)
						(ScriptID 840 1) ; MISSING EXPORT
					else
						(ScriptID 850 1) ; girlFriend
					)
				)
				(31
					(switch gCurRoomNum
						(355
							(ScriptID 355 1) ; impoundTalker
						)
						(360
							(ScriptID 360 1) ; impoundTalker
						)
						(else gNarrator)
					)
				)
				(37
					(switch gCurRoomNum
						(100
							(ScriptID 100 6) ; jackTalker
						)
						(110
							(ScriptID 110 1) ; jackTalker
						)
						(else gNarrator)
					)
				)
				(10 gNarrator)
				(14
					(switch gCurRoomNum
						(180
							(ScriptID 180 1) ; lasondraTalker
						)
						(190
							(ScriptID 190 1) ; lasondraTalker
						)
						(else gNarrator)
					)
				)
				(19 gNarrator)
				(5
					(switch gCurRoomNum
						(605
							(ScriptID 605 1) ; mitchTalker
						)
						(610
							(ScriptID 610 1) ; mitchTalker
						)
						(else gNarrator)
					)
				)
				(23 gNarrator)
				(34 gNarrator)
				(33
					(if (== gCurRoomNum 340)
						(ScriptID 340 1) ; paulTalker
					else
						gNarrator
					)
				)
				(35 gNarrator)
				(15
					(switch gCurRoomNum
						(100
							(ScriptID 100 7) ; spiffTalker
						)
						(110
							(ScriptID 110 2) ; spiffTalker
						)
						(else gNarrator)
					)
				)
				(22
					(ScriptID 270 1) ; markTalker
				)
				(40
					(switch gCurRoomNum
						(240
							(ScriptID 240 2) ; sherryTalker
						)
						(250
							(ScriptID 250 1) ; sherryTalker
						)
						(275
							(ScriptID 275 2) ; sherryTalker
						)
						(else gNarrator)
					)
				)
				(36 gNarrator)
				(29 gNarrator)
				(30 gNarrator)
				(26 gNarrator)
				(39 gNarrator)
				(4
					(if (== gCurRoomNum 130)
						(ScriptID 130 1) ; varazTalker
					else
						gNarrator
					)
				)
				(32
					(ScriptID 360 1) ; impoundTalker
				)
				(17 gNarrator)
				(else gNarrator)
			)
		)
		(if (== param1 3)
			(temp0 fore: 17)
		)
		(if (and (== param1 25) (not (gPqFlags test: 163)))
			(gPqFlags set: 163)
		)
		(return temp0)
	)
)

(instance egoT of Narrator
	(properties
		y 25
		talkWidth 150
		modeless 2
	)
)

(instance pqFlags of Flags
	(properties
		size 256
	)
)

(instance pqPointFlags of Flags
	(properties
		size 128
	)
)

(instance pqDoVerbCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0
			(if (> (gCurRoom modNum:) 0)
				(gCurRoom modNum:)
			else
				gCurRoomNum
			)
		)
		(cond
			((Message msgSIZE temp0 0 param1 0 1)
				(gMessager say: 0 param1 0 0 0 temp0)
			)
			((Message msgSIZE temp0 (gCurRoom noun:) param1 0 1)
				(gMessager say: (gCurRoom noun:) param1 0 0 0 temp0)
			)
			(else
				(gMessager say: 0 param1 0 0 0 0)
			)
		)
	)
)

(instance pqFtrInit of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 (- 10 gHowFast))
		(= temp0 (Min temp0 4))
		(if (!= param1 gEgo)
			(if (param1 respondsTo: #cycleSpeed)
				(param1 cycleSpeed: temp0)
			)
			(if (param1 respondsTo: #moveSpeed)
				(param1 moveSpeed: temp0)
			)
		)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 40)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance pqApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(22 16)
				(23 32)
				(else 32768)
			)
		)
	)
)

(instance ResetLastTicks of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(cond
			((not (param1 respondsTo: #script))
				(return)
			)
			((= temp0 (param1 script:))
				(if (temp0 respondsTo: #lastTicks)
					(temp0 lastTicks: gGameTime)
					(self doit: temp0)
				else
					(return)
				)
			)
			(else
				(return)
			)
		)
	)
)

(instance StickTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance MirrorTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance scoreSfx of Sound
	(properties
		flags 5
	)
)

(instance transPlane of TransPlane
	(properties)
)

