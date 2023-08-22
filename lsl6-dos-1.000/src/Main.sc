;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n076)
(use n079)
(use LarryRoom)
(use LL6Inv)
(use ButtonBar)
(use ego_90)
(use LarryTalker)
(use Interface)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use User)
(use System)

(public
	LSL6 0
	proc0_1 1
	proc0_2 2
	icon0 3
	icon1 4
	icon2 5
	icon3 6
	icon4 7
	icon5 8
	icon6 9
	icon7 10
	iconExit 11
	saveTimer 12
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
	gLarryApproachCode
	gUseObstacles = 1
	gMenuBar
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
	gGlobalSound1
	gGlobalSound2
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
	gFlags
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
	global167 = 6
	global168
	global169
	; 170
	global170
	global171 = 1
	global172
	global173
	global174
	; 175
	global175
	global176 = -1
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
	global189 = -1
	; 190
	global190
	global191
	global192
	global193
	gMasterVolume
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200
	global201
)

(procedure (proc0_1)
	(larryWindow brBottom: 139)
)

(procedure (proc0_2)
	(larryWindow brBottom: 190)
)

(instance globalSound1 of Sound
	(properties
		flags 1
	)
)

(instance globalSound2 of Sound
	(properties
		flags 1
	)
)

(instance scoreSfx of Sound
	(properties
		flags 1
	)
)

(instance lKeyDownHandler of EventHandler
	(properties)
)

(instance lMouseDownHandler of EventHandler
	(properties)
)

(instance lDirectionHandler of EventHandler
	(properties)
)

(instance lWalkHandler of EventHandler
	(properties)
)

(instance interfaceList of Set ; UNUSED
	(properties)
)

(class LSL6 of Game
	(properties
		isHandsOff 0
		controlsVisible 0
	)

	(method (newRoom)
		((ScriptID 825 1) dispose:) ; tram
		(ClearFlag 22)
		(super newRoom: &rest)
		(if
			(not
				(or
					(IsFlag 53)
					(IsFlag 35)
					(IsFlag 23)
					(OneOf gPrevRoomNum 99 100 110 120 130 140) ; speedRoom
				)
			)
			((ScriptID 825 1) ; tram
				init:
				baseSetter: (ScriptID 825 3) ; tramBase
				setMotion: (ScriptID 825 0) ; theTramPath
			)
		)
	)

	(method (drawControls param1 &tmp temp0)
		(if controlsVisible
			(return)
		)
		(SetPort 0 0 190 320 10 0)
		(= controlsVisible 1)
		(if (or (not argc) (and argc (not param1)))
			(gMenuBar draw:)
		)
		(DrawCel 955 0 0 0 139 -1 0)
		(DrawCel 955 1 0 (CelWide 955 0 0) 139 -1 0)
		(SetPort 0 0 139 320 10 0)
		(gTheIconBar enable: show:)
		((ScriptID 88 0) show: update:) ; PointGauge
		(gInventory state: (| (gInventory state:) $0020) show: gEgo)
	)

	(method (hideControls)
		(if (not controlsVisible)
			(return)
		)
		(gTheIconBar disable:)
		((ScriptID 88 0) hide:) ; PointGauge
		(gInventory state: (& (gInventory state:) $ffdf))
		(= controlsVisible 0)
		(SetPort 0 0 190 320 10 0)
		(Graph grFILL_BOX_FOREGROUND 140 0 199 320 0)
		(Graph grUPDATE_BOX 140 0 199 320 1)
	)

	(method (init &tmp [temp0 33] temp33)
		(ScriptID 982)
		DText
		DButton
		Polygon
		PolyPath
		LarryNarrator
		Talker
		RandCycle
		Scaler
		Timer
		Grooper
		(super init: &rest)
		(Load rsVIEW 998)
		(Lock rsVIEW 998 1)
		(self setCursor: theWaitCursor)
		(= global110 (== (Platform 4) 2))
		(= global105 (Graph grGET_COLOURS))
		(= gSystemWindow larryWindow)
		(= gMessager larryMessager)
		(= handsOnCode larryHandsOn)
		(= handsOffCode larryHandsOff)
		(= gNarrator LarryNarrator)
		(= gLarryApproachCode larryApproachCode)
		(= gDoVerbCode larryDoVerbCode)
		((= gKeyDownHandler lKeyDownHandler) add:)
		((= gMouseDownHandler lMouseDownHandler) add:)
		((= gDirectionHandler lDirectionHandler) add:)
		((= gWalkHandler lWalkHandler) add:)
		(= gTheCursor theGameCursor)
		(= gWaitCursor theWaitCursor)
		(= gNormalCursor theArrowCursor)
		(= gVersion {x.yyy.zzz})
		(= global136 200)
		(= gUserFont 2306)
		(= gBigFont 4115)
		(= gSmallFont 1005)
		(= gTextSpeed 9)
		(= gEatMice 2)
		(User alterEgo: (= gEgo ego) canControl: 0 canInput: 0)
		((ScriptID 81) init:) ; ColorInit
		(DisposeScript 81)
		(= gUseSortedFeatures 1)
		(StrCpy @gSysLogPath {})
		((= gGlobalSound1 globalSound1) owner: self init:)
		((= gGlobalSound2 globalSound2) owner: self init:)
		(= temp33 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp33)
		(FileIO fiCLOSE temp33)
		(Format @temp0 0 0 911) ; "%d.scr"
		(if (FileIO fiEXISTS @temp0)
			(= global100 1)
			(= global167 1)
		else
			(= global100 0)
		)
		(gEgo setSpeed: global167)
		(= global104 (DoSound sndGET_POLYPHONY))
		((= gTheIconBar ButtonBar)
			nsLeft: 35
			nsTop: 141
			add:
				(icon0 cursor: cIcon0 yourself:)
				(icon1 cursor: cIcon1 yourself:)
				(icon2 cursor: cIcon2 yourself:)
				(icon3 cursor: cIcon3 yourself:)
				(icon4 cursor: cIcon4 yourself:)
				(icon6 cursor: cIcon5 yourself:)
				icon7
				icon5
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 27
			disable: icon5
			curIcon: icon0
			walkIconItem: icon0
			lastIcon: icon6
			disable:
		)
		(= gMenuBar ((ScriptID 93 0) init: yourself:)) ; menuBar
		((ScriptID 85) init: 22 163 298 187) ; LL6Inv
		(gTimers
			add:
				((ScriptID 85 1) client: (ScriptID 85 1) yourself:) ; mTimer, mTimer
				((ScriptID 85 2) client: (ScriptID 85 2) yourself:) ; cTimer, cTimer
				((ScriptID 85 4) client: (ScriptID 85 4) yourself:) ; wTimer, wTimer
				(saveTimer client: saveTimer yourself:)
		)
		(= global186 (Memory memALLOC_CRIT 40))
		(= global177 (Memory memALLOC_CRIT 70))
		(= global190 (Memory memALLOC_CRIT 70))
		(SetFlag 9)
		((ScriptID 88 0) init:) ; PointGauge
		(saveTimer setReal: self 0 (= global183 10))
		(gGame detailLevel: 5)
		(gGame masterVolume: 12)
		(= global193 13)
		(= gMasterVolume 11)
		(self newRoom: 99) ; speedRoom
	)

	(method (replay)
		(if (and (not (gCurRoom noControls:)) (gCurRoom isKindOf: LarryRoom))
			(= controlsVisible 0)
			(if ((gInventory leftScroller:) underBits:)
				((gInventory leftScroller:) hide:)
			)
			(if ((gInventory rightScroller:) underBits:)
				((gInventory rightScroller:) hide:)
			)
			(gGame drawControls:)
		)
		(= global176 -1)
		(super replay: &rest)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 gTheCursor)
		(= gTheCursor (if (== param1 -1) gNormalCursor else param1))
		(if (> argc 2)
			(= temp1 (if (< param3 0) 0 else param3))
			(= temp2 (if (< param4 0) 0 else param4))
			(SetCursor temp1 temp2)
		)
		(if (IsObject gTheCursor)
			(if argc
				(gTheCursor init:)
			else
				(= gTheCursor temp0)
			)
		else
			(SetCursor param1 0 0)
		)
		(return temp0)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 80) doit: roomNum) ; disposeCode
		(if
			(and
				global100
				(not (IsFlag 1))
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(switch
					(Print
						font: gUserFont
						addText: {*** Memory fragmented.}
						addButton: 0 {Who cares} 0 20
						addButton: 1 {Debug} 0 34
						init:
					)
					(0
						(SetFlag 1)
					)
					(1
						(SetDebug)
					)
				)
			)
		)
		(if gDebugOn
			(SetDebug)
		)
		(super startRoom: roomNum)
		(CueObj client: 0 state: 0)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(self init:)
		(while (not gQuit)
			(self doit:)
		)
		(= global182 (Memory memALLOC_NONCRIT 100))
		(if (not (IsFlag 97))
			(Message msgGET 0 7 0 0 (Random 1 15) global182)
		else
			(Message msgGET 0 7 0 0 16 global182) ; "(c) 1993 Sierra On-Line, Inc. Thank you for playing Leisure Suit Larry 6: "Shape Up or Slip Out!"  What did you think you were going to see, you pervert? Gotcha!"
		)
		(SetQuitStr global182)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (or (event claimed:) gModelessDialog)
			(event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(JOY_DOWNLEFT
						(= global178 2)
					)
					(JOY_RIGHT
						(icon7 doit:)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(self masterVolume: 0)
								(= gMasterVolume 0)
							)
							((> global104 1)
								(self masterVolume: 15)
								(= gMasterVolume 13)
							)
							(else
								(self masterVolume: 1)
								(= gMasterVolume 1)
							)
						)
						(event claimed: 1)
					)
					(KEY_ADD
						(if (gUser canControl:)
							(gEgo
								setSpeed:
									(= global167
										(Max 1 (- (gEgo moveSpeed:) 1))
									)
							)
						)
					)
					(KEY_SUBTRACT
						(if (gUser canControl:)
							(gEgo
								setSpeed:
									(= global167 (+ (gEgo moveSpeed:) 1))
							)
						)
					)
					($003d ; =
						(if (gUser canControl:)
							(gEgo setSpeed: (= global167 6))
						)
					)
					(KEY_F3
						(self save: 0)
						(event claimed: 1)
					)
					(KEY_F5
						(self save:)
						(event claimed: 1)
					)
					(KEY_F7
						(self restore:)
						(event claimed: 1)
					)
					(KEY_F9
						(self restart:)
						(event claimed: 1)
					)
					(KEY_F1
						(if (gUser canControl:)
							(funFx number: 576 play:)
						)
					)
					(KEY_F4
						(if (gUser canControl:)
							(funFx number: 516 play:)
						)
					)
					(KEY_F6
						(if (gUser canControl:)
							(funFx number: 631 play:)
						)
					)
					(KEY_F8
						(if (gUser canControl:)
							(funFx number: 633 play:)
						)
					)
					(KEY_F10
						(if (gUser canControl:)
							(funFx number: 41 play:)
						)
					)
					(else
						(event claimed: 1)
						(if (and global100 (not (OneOf gCurRoomNum 510 400)))
							(event claimed: 0)
							((ScriptID 911) handleEvent: event) ; debugHandler
							((ScriptID 911) dispose:) ; debugHandler
							(DisposeScript 911)
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if (and global100 (& (event modifiers:) emALT))
					(event claimed: 1)
					(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
						((User alterEgo:)
							posn: (temp0 x:) (- (temp0 y:) 10)
							setMotion: 0
						)
						(Animate (gCast elements:) 0)
						(temp0 dispose:)
					)
					(temp0 dispose:)
				)
			)
		)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((& (event type:) evVERB)
				(self pragmaFail: (event message:))
			)
		)
		(event claimed:)
	)

	(method (pragmaFail param1)
		(if (User canInput:)
			(if (== (gLarryApproachCode doit: param1) -32768)
				(= param1 15)
			)
			(gMessager say: 0 param1 0 1 0 0)
		)
	)

	(method (changeScore param1 param2)
		(return
			(if (or (<= argc 1) (not (SetFlag param2)))
				(cond
					((and (>= argc 1) (> param1 0) (< param1 10))
						(scoreSfx number: 1 loop: 1 play:)
					)
					((and (>= argc 1) (> param1 9))
						(scoreSfx number: 2 loop: 1 play:)
					)
				)
				(super changeScore: param1 &rest)
				(if (< gScore 0)
					(= gScore 0)
				)
				1
			)
		)
	)

	(method (restart &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 270 95)
		(if
			(Print
				addTitle: 6 0 4 1 0
				addText: 6 0 0 1 70 2 0 ; "Do you really want to start over again from the very beginning?"
				addButton: 1 6 0 2 1 220 51 0 ; "Yep"
				addButton: 0 6 0 3 1 72 51 0 ; "Oops"
				addIcon: 1909 0 0 2 2
				init:
			)
			(if global100
				(= global136 99)
			)
			(super restart: &rest)
		)
		(gGame setCursor: temp0)
	)

	(method (quitGame param1 &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 250 95)
		(if
			(or
				(and argc param1)
				(Print
					addTitle: 5 0 4 1 0
					addText: 5 0 0 1 70 2 0 ; "Hey, don't go! What am I supposed to do inside here while you're gone?"
					addButton: 1 5 0 2 1 190 51 0 ; "Quit"
					addButton: 0 5 0 3 1 72 51 0 ; "Oops"
					addIcon: 1908 0 0 2 2
					init:
				)
			)
			(= gQuit 1)
		)
		(gGame setCursor: temp0)
	)

	(method (doit &tmp temp0)
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
				((ScriptID 88 0) doit:) ; PointGauge
				(return)
			)
		)
		(if (not gFastCast)
			((ScriptID 88 0) doit:) ; PointGauge
		)
		(super doit: &rest)
	)

	(method (save param1 &tmp [temp0 100] [temp100 50])
		(= global195 gTheCursor)
		(cond
			((IsFlag 86)
				(gMessager say: 0 0 15 0 0 0) ; "There's not enough free low memory to save at this time. Please try again later."
			)
			((== gCurRoomNum 740)
				(gMessager say: 0 0 20 0 0 0) ; "This game is over. Wait until Larry 7 to save your game!"
			)
			((and argc (== param1 1))
				(if (or gModelessDialog (gCurRoom script:) isHandsOff)
					(saveTimer setReal: gGame 10)
				else
					(gGame setCursor: gNormalCursor)
					(switch
						(Print
							addTitle: 8 0 4 1 0
							addText: 8 0 0 1 10 0 0 ; "It's been a while since you saved your game. Would you like to save now?"
							addButton: 1 8 0 2 1 0 30 0 ; "Save"
							addButton: 0 8 0 3 1 38 30 0 ; "Screw It"
							addButton: 2 8 0 6 1 91 30 0 ; "Change Interval"
							init: revertCursor
						)
						(1
							(super save: &rest)
							(if (!= (saveTimer seconds:) -1)
								(saveTimer setReal: gGame 0 global183)
							)
							(gGame setCursor: global195)
						)
						(2
							(proc76_0)
							(gGame setCursor: global195)
						)
					)
				)
				(return)
			)
			((and argc (== param1 0) (!= global176 -1))
				(if (not (ValidPath global190))
					(Message msgGET 0 12 0 16 1 @temp100) ; "Invalid save game directory:"
					(Format @temp0 @temp100 global190)
					(Print font: 0 addText: @temp0 init:)
					(return)
				)
				(gGame setCursor: gWaitCursor)
				(StrCpy gCurSaveDir global190)
				(if (not (SaveGame name global176 global177 gVersion))
					(Print
						font: 0
						addText: 12 0 17 1 0 0 0 ; "Your disk is full. Delete some save games and try again."
						addButton: 1 12 0 18 1 0 40 0 ; "OK"
						init:
					)
				else
					(Message msgGET 0 12 0 0 1 @temp0) ; "Your game was saved successfully as "%s.""
					(Print addTitle: 12 0 4 1 0 addTextF: @temp0 global177 init:)
				)
				(if (!= (saveTimer seconds:) -1)
					(saveTimer setReal: gGame 0 global183)
				)
			)
			(else
				(SetPort 0 0 190 320 10 0)
				(super save:)
				(SetPort 0)
				(SetPort 0 0 139 320 10 0)
				(if (!= (saveTimer seconds:) -1)
					(saveTimer setReal: gGame 0 global183)
				)
			)
		)
		(gGame setCursor: global195)
	)

	(method (restore &tmp temp0)
		(if (IsFlag 86)
			(gMessager say: 0 0 19 0 0 0) ; "There's not enough free low memory to restore at this time. Please try again later."
		else
			(= temp0 gTheCursor)
			(SetPort 0 0 190 320 10 0)
			(super restore: &rest)
			(if (not (OneOf gCurRoomNum 140 740))
				(SetPort 0)
				(SetPort 0 0 139 320 10 0)
			)
			(gGame setCursor: temp0)
		)
	)
)

(instance larryDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(
				(and
					(not (OneOf param1 4 1 2 5 6))
					(Message
						msgGET
						(param2 modNum:)
						(param2 noun:)
						15
						(param2 case:)
						1
					)
				)
				(gMessager
					say: (param2 noun:) 15 (param2 case:) 0 0 (param2 modNum:)
				)
			)
			((Message msgGET (param2 modNum:) (param2 noun:) 0 (param2 case:) 1)
				(gMessager
					say: (param2 noun:) 0 (param2 case:) 0 0 (param2 modNum:)
				)
			)
			((not (gCurRoom doVerb: param1))
				(gGame pragmaFail: param1)
			)
		)
	)
)

(instance larryHandsOn of Code
	(properties)

	(method (doit &tmp temp0)
		(if (not (gGame isHandsOff:))
			(return)
		)
		(gGame isHandsOff: 0)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable: icon1 icon2 icon3 icon4 icon6)
		(gTheIconBar enable: (gTheIconBar at: 0))
		(if global170
			(gTheIconBar enable: icon5)
		)
		(if (IsObject global166)
			(gTheIconBar curIcon: global166)
		else
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
		(= global166 0)
		(= temp0 (gTheIconBar curIcon:))
		(if (and (temp0 isKindOf: LL6InvItem) (!= (temp0 owner:) gEgo))
			(gTheIconBar curIcon: (gTheIconBar at: 0))
			(if (!= (gTheIconBar at: 0) (ScriptID 0 3)) ; icon0
				(gTheIconBar advanceCurIcon:)
			)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
)

(instance larryHandsOff of Code
	(properties)

	(method (doit)
		(if (gGame isHandsOff:)
			(return)
		)
		(gGame isHandsOff: 1)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(= global166 (gTheIconBar curIcon:))
		(gTheIconBar disable: icon1 icon2 icon3 icon4 icon6)
		(if (not global170)
			(gTheIconBar disable: icon5)
		)
		(gTheIconBar disable: (gTheIconBar at: 0))
		(User canControl: 0 canInput: 0)
		(gGame setCursor: gWaitCursor)
	)
)

(instance theGameCursor of Cursor
	(properties
		view 998
		cel 7
	)
)

(instance theWaitCursor of Cursor
	(properties
		view 998
		cel 8
	)
)

(instance theArrowCursor of Cursor
	(properties
		view 998
		cel 7
	)
)

(instance larryWindow of SysWindow
	(properties
		back 7
		brBottom 139
		brRight 319
	)
)

(instance revertCursor of Script
	(properties)

	(method (cue)
		(if (== gTheCursor gNormalCursor)
			(gGame setCursor: global195)
		)
	)
)

(instance larryMessager of Messager
	(properties)

	(method (sayNext)
		(gSounds pause: 1)
		(super sayNext: &rest)
	)

	(method (dispose)
		(gSounds pause: 0)
		(super dispose:)
	)

	(method (findTalker param1 &tmp temp0)
		(return
			(switch param1
				(1
					(ScriptID 1800 1) ; You
				)
				(2
					(ScriptID 1801 2) ; Gammie
				)
				(3
					(ScriptID 1802 3) ; Cavaricchi
				)
				(7
					(ScriptID 610 1) ; unknown_610_16
				)
				(11
					(ScriptID 1803 11) ; Thunderbird
				)
				(6
					(ScriptID 1804 6) ; Burgundy
				)
				(21
					(ScriptID 1805 21) ; Rose
				)
				(13
					(ScriptID 1806 13) ; Merrily
				)
				(18
					(ScriptID 1807 18) ; Gary_a
				)
				(15
					(ScriptID 1808 15) ; Kenny
				)
				(8
					(ScriptID 1809 8) ; Daryl
				)
				(22
					(ScriptID 1810 22) ; Bartender
				)
				(12
					(ScriptID 1811 12) ; Char
				)
				(10
					(ScriptID 1812 10) ; Shablee
				)
				(17
					(ScriptID 1230 17) ; Billy_Dee
				)
				(16
					(ScriptID 1813 16) ; Art
				)
				(20
					(ScriptID 1242 20) ; Waitress
				)
				(25
					(ScriptID 1146 25) ; Shalo
				)
				(26
					(ScriptID 1814 26) ; You
				)
				(23
					(ScriptID 1815 23) ; Mark
				)
				(24
					(ScriptID 1144 24) ; Biff_Stiff
				)
				(14
					(ScriptID 1816 14) ; Shamara
				)
				(28
					(ScriptID 1817 28) ; You
				)
				(29
					(ScriptID 1818 29) ; You
				)
				(30
					(ScriptID 1819 30) ; You
				)
				(31
					(ScriptID 1820 31) ; You
				)
				(32
					(ScriptID 1821 32) ; talkTitleNar
				)
				(27
					(ScriptID 1807 27) ; Gary_b
				)
				(5
					(ScriptID 1822 5) ; Female_Voice
				)
				(4
					(ScriptID 1822 4) ; Male_Voice
				)
				(33
					(ScriptID 1823 33) ; Voice_Over_Announcer
				)
				(34
					(ScriptID 1824 34) ; You
				)
				(35
					(ScriptID 1825 35) ; You
				)
				(else gNarrator)
			)
		)
	)
)

(instance larryApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(5 16)
				(6 32)
				(else -32768)
			)
		)
	)
)

(instance icon0 of BarIconI
	(properties
		loop 0
		cel 0
		type 20480
		message 3
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon1 of BarIconI
	(properties
		loop 1
		cel 0
		message 1
		maskLoop 1
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon2 of BarIconI
	(properties
		loop 2
		cel 0
		message 4
		maskLoop 2
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon3 of BarIconI
	(properties
		loop 3
		cel 0
		message 5
		maskLoop 3
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon4 of BarIconI
	(properties
		loop 4
		cel 0
		message 2
		maskLoop 4
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon5 of BarIconI
	(properties
		loop 7
		cel 0
		type 0
		message 0
		signal 3
		maskLoop 7
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(cond
			((not global170) 0)
			((not (IsObject global170))
				(gTheIconBar disable: (ScriptID 0 8)) ; icon5
				(= temp0 global170)
				(= global170 0)
				(gCurRoom newRoom: temp0)
			)
			(else
				(gTheIconBar disable: (ScriptID 0 8)) ; icon5
				(= temp0 global170)
				(= global170 0)
				(temp0 cue:)
			)
		)
	)
)

(instance icon6 of BarIconI
	(properties
		loop 5
		cel 0
		message 6
		maskLoop 5
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon7 of BarIconI
	(properties
		loop 6
		cel 0
		type 0
		message 0
		signal 3
		maskLoop 6
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(if (and global110 (== gCurRoomNum 330))
			(gMessager say: 0 0 21 1 0 0) ; "You're too busy right now to access the control panel. Try again later."
		else
			(= temp0 gTheCursor)
			(gGame setCursor: gNormalCursor)
			((ScriptID 94) init:) ; ll6ControlPanel
			(gGame setCursor: temp0)
		)
	)
)

(instance iconExit of BarIconI
	(properties
		loop 8
		cel 0
		type 0
		message 0
		signal 3
		maskLoop 8
		maskCel 2
	)

	(method (init param1)
		(= message (if argc param1))
		(self view: 980 maskView: 980)
		(gTheIconBar prevIcon: 0 delete: (ScriptID 0 3) addToFront: self show:) ; icon0
		(cond
			((not (gGame isHandsOff:))
				(if (== (gTheIconBar curIcon:) (ScriptID 0 3)) ; icon0
					(gTheIconBar curIcon: (ScriptID 0 4)) ; icon1
				)
				(self enable:)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			((== global166 (ScriptID 0 3)) ; icon0
				(= global166 (ScriptID 0 4)) ; icon1
			)
		)
	)

	(method (doit)
		(cond
			((not message) 0)
			((not (IsObject message))
				(gTheIconBar curIcon: (ScriptID 0 3)) ; icon0
				(gCurRoom newRoom: message)
			)
			(else
				(message cue:)
			)
		)
	)

	(method (dispose)
		(gTheIconBar
			delete: (ScriptID 0 11) ; iconExit
			addToFront: (ScriptID 0 3) ; icon0
			curIcon: (ScriptID 0 3) ; icon0
			show:
		)
		(if (not (gGame isHandsOff:))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		)
	)
)

(instance cIcon0 of Cursor
	(properties
		view 998
	)
)

(instance cIcon1 of Cursor
	(properties
		view 998
		cel 1
	)
)

(instance cIcon2 of Cursor
	(properties
		view 998
		cel 2
	)
)

(instance cIcon3 of Cursor
	(properties
		view 998
		cel 3
	)
)

(instance cIcon4 of Cursor
	(properties
		view 998
		cel 4
	)
)

(instance cIcon5 of Cursor
	(properties
		view 998
		cel 5
	)
)

(instance saveTimer of Timer
	(properties)

	(procedure (localproc_0)
		(= client 0)
		(if (gCurRoom script:)
			(= seconds 5)
		else
			(gGame save: 1)
		)
	)

	(method (delete)
		(if (and (not client) global183)
			(self setReal: gGame 0 global183)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((== client self) 0)
			((!= cycleCnt -1)
				(if (not (-- cycleCnt))
					(localproc_0)
				)
			)
			((!= seconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- seconds))
						(localproc_0)
					)
				)
			)
			((> (- gGameTime ticks) 0)
				(localproc_0)
			)
		)
	)
)

(instance funFx of Sound
	(properties)
)

