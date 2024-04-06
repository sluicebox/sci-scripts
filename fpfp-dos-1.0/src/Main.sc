;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use fpInv)
(use eRS)
(use ego_19)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use Osc)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use System)

(public
	FP 0
	proc0_1 1
	IsFlag 2
	SetFlag 3
	ClearFlag 4
	Face 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	fpWin 10
	SetScore 11
	horsePlopTimer 12
	deathTimer 13
	gasMaskTimer 14
	proc0_15 15
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
	gFpApproachCode
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
	gAltPolys
	global96
	global97
	global98
	global99
	; 100
	gStopGroop
	global101 = 6
	gGameMusic1
	gGameMusic2
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
	gCurPuzzle
	; 120
	gAct = 1
	global121
	global122
	global123 = 1
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
	global134 = 34
	; 135
	global135 = 673
	global136
	global137
	global138
	global139
	; 140
	global140
	global141 = 250
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
)

(procedure (proc0_1 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (IsFlag param1)
	(return (& [global186 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global186 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global186 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc0_7 &tmp temp0)
	(gUser canControl: global108 canInput: global109)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (& global114 (>> $8000 temp0))
			(gTheIconBar disable: temp0)
		)
	)
)

(procedure (proc0_6 param1 param2 &tmp [temp0 120])
	(cond
		((OneOf param2 4 3 2 1)
			(gMessager say: 0 param2 0 0 0 0)
		)
		((Message msgGET gCurRoomNum (param1 noun:) 6 0 1 @temp0)
			(gMessager say: (param1 noun:) 6 0 0 0 gCurRoomNum)
		)
		((Message msgGET (param1 modNum:) (param1 noun:) 6 0 1 @temp0)
			(gMessager say: (param1 noun:) 6 0 0 0 (param1 modNum:))
		)
		(else
			(gMessager say: 0 6 0 0 0 0) ; "That just doesn't work like that."
		)
	)
)

(procedure (proc0_8 param1)
	(if param1
		(gTheIconBar delete: icon0 addToFront: (icon10 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon0)
			(gTheIconBar curIcon: icon10 walkIconItem: 0)
			(gGame setCursor: (icon10 cursor:))
		)
	else
		(gTheIconBar delete: icon10 addToFront: (icon0 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon10)
			(gTheIconBar curIcon: icon0 walkIconItem: icon0)
			(gGame setCursor: (icon0 cursor:))
		)
	)
)

(procedure (SetScore param1) ; UNUSED
	(if param1
		(gTheIconBar delete: icon0 addToFront: (icon11 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon0)
			(gTheIconBar curIcon: icon11 walkIconItem: 0)
			(gGame setCursor: (icon11 cursor:))
		)
	else
		(gTheIconBar delete: icon11 addToFront: (icon0 init: yourself:))
		(if (== (gTheIconBar curIcon:) icon11)
			(gTheIconBar curIcon: icon0 walkIconItem: icon0)
			(gGame setCursor: (icon0 cursor:))
		)
	)
)

(procedure (proc0_9 param1 param2)
	(if (not param1)
		(= global127 0)
		(= global128 0)
		(gTheIconBar disable: 4)
	else
		(= global127 param1)
		(if (and (> argc 1) (== param1 1000))
			(= global128 param2)
		)
		(gTheIconBar enable: 4)
	)
)

(procedure (proc0_15 param1 param2 param3 &tmp temp0 temp1)
	(if (or (< argc 2) (== param2 0))
		(= param2 1)
	)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(Palette palSET_INTENSITY 0 256 temp0)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(Palette palSET_INTENSITY 0 256 temp0)
		)
	)
	(if (and (== argc 3) param3)
		(param3 cue:)
	)
)

(class FPSound of Sound
	(properties)

	(method (play)
		(if (and (not (<= 0 (- number 2000) 999)) (<= (DoSound sndGET_POLYPHONY) 11))
			(= number (+ (mod number 1000) 1000))
		)
		(super play: &rest)
	)
)

(instance gameMusic1 of FPSound
	(properties
		flags 1
	)
)

(instance gameMusic2 of FPSound
	(properties
		flags 1
	)
)

(instance pointsSound of FPSound
	(properties
		flags 1
		number 2141
	)

	(method (check)
		(super check: &rest)
		(if (== prevSignal -1)
			(self dispose:)
		)
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance walkCursor of Cursor
	(properties)
)

(instance lookCursor of Cursor
	(properties
		view 1
	)
)

(instance doCursor of Cursor
	(properties
		view 2
	)
)

(instance talkCursor of Cursor
	(properties
		view 3
	)
)

(instance exitCursor of Cursor
	(properties
		view 6
	)
)

(instance gunCursor of Cursor
	(properties
		view 10
	)
)

(class FP of Game
	(properties
		printLang 0
	)

	(method (init &tmp [temp0 22])
		Print
		DButton
		StopWalk
		Polygon
		PolyPath
		Timer
		FPRoom
		ego
		IconBar
		Inv
		FPIconItem
		(ScriptID 982)
		Narrator
		Osc
		(super init:)
		(= gVersion {x.yyy.zzz})
		(= global111 {991-999-9999})
		(= global112 {9999-999999})
		(= global113 {992-999-9999})
		((ScriptID 14 0) init:) ; fpInitCode
		(DisposeScript 14)
		((ScriptID 15 0) init:) ; fpInv
		(= gNormalCursor walkCursor)
		(= gDoVerbCode fpDoVerbCode)
		(= gFtrInitializer fpFtrInit)
		(= gFpApproachCode fpApproachCode)
		(= gStopGroop stopGroop)
		(= gMessager fpMessager)
		((= gAltPolys (List new:)) name: {altPolys} add:)
		(= gPMouse PseudoMouse)
		((= gGameMusic1 gameMusic1) owner: self init:)
		((= gGameMusic2 gameMusic2) owner: self init:)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9 icon5
			eachElementDo: #init
			eachElementDo: #highlightColor 37
			eachElementDo: #lowlightColor 33
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			walkIconItem: icon0
			disable: 5
			disable:
			state: 3072
		)
		(gTheIconBar disable: 9)
		(proc0_9 0)
		(if (FileIO fiEXISTS {10.scr})
			(= global110 1)
		else
			(= global110 0)
		)
		(cond
			((GameIsRestarting)
				(MemorySegment 1 @global107)
			)
			((FileIO fiEXISTS {29.scr})
				(= global107 29)
			)
			(else
				(= global107 28)
			)
		)
		(gTheIconBar enable:)
		(= gEgo ego)
		(gUser alterEgo: gEgo canControl: 0 canInput: 0)
		(gEgo get: -1 16) ; Door_Key
		(self newRoom: global107)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
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
			(if (< param3 0)
				(= param3 0)
			)
			(if (< param4 0)
				(= param4 0)
			)
			(SetCursor param3 param4)
		)
		(return temp0)
	)

	(method (pragmaFail)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (gUser canInput:)
			(gMessager say: 0 ((gUser curEvent:) message:))
		)
	)

	(method (save &tmp temp0 temp1 temp2)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super save: &rest)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar curIcon:) cursor:)) 999)
			(gGame setCursor: gWaitCursor)
		else
			(gGame setCursor: temp2)
		)
	)

	(method (restore &tmp temp0 temp1 temp2 temp3)
		(= temp1 gNormalCursor)
		(= gNormalCursor 999)
		(= temp0 gSystemWindow)
		(= gSystemWindow SysWindow)
		(super restore: &rest)
		(= gSystemWindow temp0)
		(= gNormalCursor temp1)
		(if (== (= temp2 ((gTheIconBar curIcon:) cursor:)) 999)
			(gGame setCursor: gWaitCursor)
		else
			(gGame setCursor: temp2)
		)
	)

	(method (replay &tmp temp0)
		(= gSystemWindow fpWin)
		(= gNormalCursor walkCursor)
		(super replay: &rest)
	)

	(method (restart)
		(if (OneOf gCurRoomNum 29 99) ; deathRoom
			(gGame setCursor: 997 1 304 172)
			(gCurRoom style: 6 drawPic: 780)
			(gCast eachElementDo: #hide)
			(Animate (gCast elements:) 0)
			(MemorySegment 0 @global107 2)
			(super restart:)
		else
			(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
			(gGame setCursor: 999 1 124 115)
			(if
				(Print
					font: gUserFont
					addTitle: 18 0 4 1 0
					addText: 18 0 1 1 0 3 0 ; "Do you really want to start the game over again from the very beginning?"
					addButton: 1 18 0 5 1 90 35 0 ; "Restart"
					addButton: 0 18 0 6 1 50 35 0 ; "Oops"
					init:
				)
				(PalVary pvUNINIT)
				(Palette palSET_INTENSITY 0 256 100)
				(gGame setCursor: 997 1 304 172)
				(gCurRoom style: 6 drawPic: 780)
				(gCast eachElementDo: #hide)
				(Animate (gCast elements:) 0)
				(MemorySegment 0 @global107 2)
				(SetVideoMode 0)
				(super restart:)
			else
				(gGame setCursor: gNormalCursor)
			)
		)
	)

	(method (quitGame)
		((ScriptID 31 0) init: show: dispose:) ; fpQuitGameControls
	)

	(method (newRoom newRoomNumber)
		(gGame setCursor: gWaitCursor)
		(gPMouse stop:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (and (IsObject gFastCast) (gFastCast elements:))
			(gFastCast eachElementDo: #dispose 1)
		)
		(gNarrator
			x: -1
			y: -1
			disposeWhenDone: 1
			talkWidth: 0
			keepWindow: 0
			modeless: 0
			showTitle: 0
			name: {Narrator}
		)
		(gTheIconBar disable:)
		(if (> global127 1000)
			(switch global127
				(1610
					(= global138 0)
					(ClearFlag 84)
					(= gCurPuzzle 13)
					((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				)
				(1230
					(SetFlag 80)
				)
				(1250
					(SetFlag 80)
				)
				(1630
					(SetFlag 80)
				)
				(1240
					(SetFlag 80)
				)
				(1026
					(if (!= gGameMusic1 638)
						(gGameMusic1 fade:)
					)
					(gGameMusic2 fade:)
				)
			)
			(-= global127 1000)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp temp0 temp1 [temp2 2])
		((ScriptID 11) doit: roomNum) ; disposeCode
		(for ((= temp1 0)) (< temp1 (gTimers size:)) ((++ temp1))
			(gTimers delete: (= temp0 (gTimers at: 0)))
			(gTimers add: temp0)
		)
		(if
			(and
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print
					addText: 1 0 0 1 0 0 10 ; "Memory fragmented"
					addButton: 0 1 0 1 1 0 12 10 ; "So what?"
					addButton: 1 1 0 2 1 70 12 10 ; "Debug"
					init:
				)
			)
			(SetDebug)
		)
		(cond
			(
				(or
					(and (>= gCurPuzzle 7) (<= gCurPuzzle 9))
					(> gCurPuzzle 21)
					(IsFlag 1)
				)
				(ClearFlag 59)
			)
			((not (IsFlag 59))
				(SetFlag 59)
				(SetFlag 71)
			)
		)
		(if (and (IsFlag 59) (OneOf roomNum 220 230 235 240 250))
			(ScriptID 90) ; streetRgn
		)
		(if (and (== gCurPuzzle 22) (OneOf roomNum 220 235 240 250 400))
			(ScriptID 91) ; rowdyRgn
		)
		(if (and global110 (not (OneOf roomNum 100)))
			((ScriptID 10 0) init:) ; MISSING SCRIPT
		)
		(if (OneOf global127 roomNum 1000)
			(proc0_9 0)
		)
		(gTheIconBar enable:)
		(super startRoom: roomNum)
		(if
			(and
				(gEgo cycler:)
				(not (gEgo looper:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo setLoop: stopGroop)
		)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 5))
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_TAB
						(if (not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							((ScriptID 15 2) doit: gEgo) ; resetInv
							(gEgo showInv:)
							(event claimed: 1)
						)
					)
					(KEY_SHIFTTAB
						(if (not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							((ScriptID 15 2) doit: gEgo) ; resetInv
							(gEgo showInv:)
							(event claimed: 1)
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(JOY_RIGHT
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(= temp0 gNormalCursor)
							(= gNormalCursor 999)
							(gGame showControls:)
							(= gNormalCursor temp0)
							(if (== (= temp1 ((gTheIconBar curIcon:) cursor:)) 999)
								(gGame setCursor: gWaitCursor)
							else
								(gGame setCursor: temp1)
							)
							(event claimed: 1)
						)
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
								(gGame masterVolume: 1)
							)
						)
						(event claimed: 1)
					)
					(KEY_F5
						(if
							(not
								(or
									(& ((gTheIconBar at: 7) signal:) $0004)
									(& (gTheIconBar state:) $0004)
								)
							)
							(if gFastCast
								(return gFastCast)
							)
							(gGame save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if
							(not
								(or
									(& ((gTheIconBar at: 7) signal:) $0004)
									(& (gTheIconBar state:) $0004)
								)
							)
							(if gFastCast
								(return gFastCast)
							)
							(gGame restore:)
							(event claimed: 1)
						)
					)
					(KEY_F9
						(if
							(not
								(or
									(& ((gTheIconBar at: 7) signal:) $0004)
									(& (gTheIconBar state:) $0004)
								)
							)
							(gGame restart:)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (gUser controls:)
							(gEgo
								setSpeed:
									(Max 0 (- (gEgo moveSpeed:) 1))
							)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(gEgo setSpeed: (+ (gEgo moveSpeed:) 1))
						)
					)
					($003d ; =
						(if (gUser controls:)
							(gEgo setSpeed: 6)
						)
					)
				)
			)
		)
	)

	(method (handsOff)
		(if (not global125)
			(= global125 (gTheIconBar curIcon:))
		)
		(= global108 (gUser canControl:))
		(= global109 (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(= global114 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar curIcon: (gTheIconBar at: 7))
		(gTheIconBar disable: 0 1 2 3 5 6)
		(if (not (HaveMouse))
			(gGame setCursor: 996)
		else
			(gGame setCursor: gWaitCursor)
		)
	)

	(method (handsOn param1)
		(gUser canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 5 6)
		(if (not (gCurRoom inset:))
			(gTheIconBar enable: 7)
		)
		(if (and argc param1)
			(proc0_7)
		)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 5)
		)
		(if
			(and
				global125
				(or (!= global125 icon10) (== (gTheIconBar at: 0) icon10))
			)
			(gTheIconBar curIcon: global125)
			(gGame setCursor: (global125 cursor:))
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 5))
					(not (gTheIconBar curInvIcon:))
				)
				(gTheIconBar advanceCurIcon:)
			)
		)
		(= global125 0)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (points param1 param2)
		(if (and (> argc 1) (SetFlag param2))
			(= param1 0)
		)
		(if param1
			(pointsSound play:)
			(gGame changeScore: param1)
		)
	)

	(method (showControls &tmp temp0)
		((ScriptID 24 0) init: show: dispose:) ; fpGameControls
	)

	(method (showAbout)
		((ScriptID 13 0) doit:) ; aboutCode
	)
)

(instance horsePlopTimer of Timer
	(properties)

	(method (cue)
		(ClearFlag 29)
		(if (not (IsFlag 14))
			(ClearFlag 53)
			(switch (Random 0 2)
				(0
					(= global141 220)
				)
				(1
					(= global141 230)
				)
				(2
					(= global141 250)
				)
			)
			(if (== global141 gCurRoomNum)
				(switch gCurRoomNum
					(220
						(= global141 230)
					)
					(230
						(= global141 250)
					)
					(250
						(= global141 220)
					)
				)
			)
		)
		(if (== gCurRoomNum 660)
			(gCurRoom notify:)
		)
	)
)

(instance deathTimer of Timer
	(properties)

	(method (cue)
		(switch gCurPuzzle
			(8
				(= global122 1)
			)
			(9
				(= global122 20)
			)
			(10
				(= global122 16)
			)
			(13
				(= global122 19)
			)
			(14
				(= global122 17)
			)
			(20
				(= global122 15)
			)
			(else
				(if (IsFlag 146)
					(self setReal: self 0 15)
				else
					(= global122 18)
				)
			)
		)
		(if (not (IsFlag 146))
			(gCurRoom newRoom: 99) ; deathRoom
		)
	)
)

(instance gasMaskTimer of Timer
	(properties)

	(method (cue)
		(if (IsFlag 70)
			(= global122 1)
			(gCurRoom newRoom: 99) ; deathRoom
		else
			(gMessager say: 22 0 0 0 0 0) ; "You're feeling a little light-headed. Better use your gas mask!"
			(SetFlag 70)
			(self setReal: self 40)
		)
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		type 20480
		message 3
		signal 65
		maskView 990
		maskLoop 9
		noun 1
		helpVerb 7
	)

	(method (init)
		(= cursor walkCursor)
		(super init:)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon1 of IconI
	(properties
		view 990
		loop 1
		cel 0
		message 1
		signal 65
		maskView 990
		maskLoop 9
		noun 2
		helpVerb 7
	)

	(method (init)
		(= cursor lookCursor)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		message 4
		signal 65
		maskView 990
		maskLoop 9
		noun 3
		helpVerb 7
	)

	(method (init)
		(= cursor doCursor)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		message 2
		signal 65
		maskView 990
		maskLoop 9
		noun 4
		helpVerb 7
	)

	(method (init)
		(= cursor talkCursor)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		message 0
		signal 67
		maskView 990
		maskLoop 9
		maskCel 2
		noun 13
		helpVerb 7
	)

	(method (select)
		(if global127
			(super select: &rest)
			(gTheIconBar hide:)
			(if
				(Print
					posn: 49 82
					width: 220
					addTitle: 5 0 4 1 0
					addText: 5 0 1 1 0 0 0 ; "Do you really want to skip ahead and possibly miss the best part of the whole game (heh, heh, heh)?"
					addButton: 0 5 0 3 1 180 28 0 ; "Oops"
					addButton: 1 5 0 2 1 133 28 0 ; "Yes"
					init:
				)
				(if (== global127 1000)
					(if (IsObject global128)
						(global128 cue:)
						(proc0_9 0)
					else
						(Prints
							{ERROR: Object passed to SetFFRoom isn't an object you silly person!}
						)
					)
				else
					(gCurRoom newRoom: global127)
					(+= global127 1000)
				)
			)
		else
			(return 0)
		)
	)
)

(instance icon5 of IconI
	(properties
		view 990
		loop 11
		cel 0
		cursor 999
		signal 67
		maskView 990
		maskLoop 11
		noun 14
		helpVerb 7
	)

	(method (show &tmp [temp0 7] [temp7 4])
		(super show: &rest)
		(Format @temp0 0 0 gScore gPossibleScore) ; "%d/%d"
		(TextSize @temp7 @temp0 global121 0)
		(Display
			@temp0
			dsCOLOR
			25
			dsFONT
			global121
			dsCOORD
			(+ (- nsLeft 3) (/ (- 50 [temp7 3]) 2))
			(+ nsTop 16)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 990
		maskLoop 9
		maskCel 1
		noun 9
		helpVerb 7
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(if (= temp2 (gTheIconBar curInvIcon:))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(temp2 view:)
											(- (temp2 loop:) 1)
											(temp2 cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(temp2 view:)
											(- (temp2 loop:) 1)
											(temp2 cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel
							(temp2 view:)
							(- (temp2 loop:) 1)
							(temp2 cel:)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(DrawCel
										view
										loop
										(= temp1 1)
										nsLeft
										nsTop
										-1
									)
									(if (= temp2 (gTheIconBar curInvIcon:))
										(DrawCel
											(temp2 view:)
											(- (temp2 loop:) 1)
											(temp2 cel:)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= temp2 (gTheIconBar curInvIcon:))
									(DrawCel
										(temp2 view:)
										(- (temp2 loop:) 1)
										(temp2 cel:)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= temp2 (gTheIconBar curInvIcon:))
							(DrawCel
								(temp2 view:)
								(- (temp2 loop:) 1)
								(temp2 cel:)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance icon7 of IconI
	(properties
		view 990
		loop 6
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 990
		maskLoop 9
		noun 6
		helpVerb 7
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 15 2) doit: gEgo) ; resetInv
			(gEgo showInv:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 7
		signal 67
		maskView 990
		maskLoop 9
		noun 7
		helpVerb 7
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gGame showControls:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 990
		loop 8
		cel 0
		cursor 9
		type 8192
		message 7
		signal 3
		maskView 990
		maskLoop 9
		noun 8
		helpVerb 7
	)
)

(instance icon10 of IconI
	(properties
		view 990
		loop 10
		cel 0
		message 8
		signal 65
		maskView 990
		maskLoop 9
		noun 10
		helpVerb 7
	)

	(method (init)
		(= cursor exitCursor)
		(self highlightColor: 37 lowlightColor: 33)
		(super init:)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon11 of IconI
	(properties
		view 990
		loop 12
		cel 0
		message 3
		signal 65
		maskView 990
		maskLoop 9
		noun 3
		helpVerb 7
	)

	(method (init)
		(= cursor gunCursor)
		(self highlightColor: 37 lowlightColor: 33)
		(super init:)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global114 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance fpDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(proc0_6 param2 param1)
	)
)

(instance fpFtrInit of Code
	(properties)

	(method (doit param1)
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

(instance fpMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(49
						(ScriptID 1800 49) ; Freddy
					)
					(55
						(ScriptID 1801 55) ; Lever_Bros
					)
					(40
						(ScriptID 1802 40) ; Srini
					)
					(43
						(ScriptID 1803 43) ; Barber
					)
					(48
						(ScriptID 1804 48) ; Doc
					)
					(45
						(ScriptID 1805 45) ; Purity
					)
					(44
						(ScriptID 1806 44) ; Chastity
					)
					(46
						(ScriptID 1807 46) ; Virtue
					)
					(3
						(ScriptID 1808 3) ; Sam_Andreas
					)
					(59
						(ScriptID 1809 59) ; Smithie
					)
					(50
						(ScriptID 1810 50) ; Gambler
					)
					(53
						(ScriptID 1811 53) ; Helen_Back
					)
					(56
						(ScriptID 1812 56) ; Penelope
					)
					(58
						(ScriptID 1813 58) ; Sheriff
					)
					(57
						(ScriptID 1814 57) ; Willy
					)
					(54
						(ScriptID 1815 54) ; Kenny
					)
					(52
						(ScriptID 1816 52) ; Jim_Laffer
					)
					(47
						(ScriptID 1817 47) ; Madame
					)
					(51
						(ScriptID 1818 51) ; Judge
					)
					(42
						(ScriptID 1819 42) ; PHBalance
					)
					(5
						(ScriptID 1826 5) ; Kid
					)
					(6
						(ScriptID 1832 6) ; Man
					)
					(29
						(ScriptID 1834 7) ; Woman
					)
					(8
						(ScriptID 1827 8) ; Miner
					)
					(9
						(ScriptID 1839 9) ; Indian1
					)
					(10
						(ScriptID 1840 10) ; Indian2
					)
					(11
						(ScriptID 1841 11) ; Indian3
					)
					(12
						(ScriptID 1844 12) ; Chinese
					)
					(2
						(ScriptID 1845 2) ; Chester
					)
					(1
						(ScriptID 1846 1) ; Billy_
					)
					(15
						(ScriptID 90 1) ; wanderTalker
					)
					(20
						(ScriptID 90 1) ; wanderTalker
					)
					(13
						(ScriptID 90 1) ; wanderTalker
					)
					(19
						(ScriptID 90 1) ; wanderTalker
					)
					(23
						(ScriptID 90 1) ; wanderTalker
					)
					(17
						(ScriptID 90 1) ; wanderTalker
					)
					(27
						(ScriptID 90 1) ; wanderTalker
					)
					(7
						(ScriptID 90 1) ; wanderTalker
					)
					(21
						(ScriptID 90 1) ; wanderTalker
					)
					(14
						(ScriptID 90 1) ; wanderTalker
					)
					(25
						(ScriptID 90 1) ; wanderTalker
					)
					(26
						(ScriptID 90 1) ; wanderTalker
					)
					(16
						(ScriptID 90 1) ; wanderTalker
					)
					(18
						(ScriptID 90 1) ; wanderTalker
					)
					(4
						(ScriptID 90 1) ; wanderTalker
					)
					(24
						(ScriptID 90 1) ; wanderTalker
					)
					(22
						(ScriptID 90 1) ; wanderTalker
					)
					(28
						(ScriptID 90 1) ; wanderTalker
					)
					(30
						(ScriptID 1847 30) ; Olga
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance fpApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(8 16)
				(else -32768)
			)
		)
	)
)

(instance fpWin of SysWindow
	(properties
		type 128
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4)
		(switch gAct
			(1
				(= temp1 0)
			)
			(2
				(if (IsFlag 1)
					(= temp1 2)
				else
					(= temp1 1)
				)
			)
			(3
				(= temp1 3)
			)
			(4
				(= temp1 4)
			)
			(5
				(= temp1 4)
			)
		)
		(= lsLeft (- (- left 3) 15))
		(= lsTop (- (- top 3) (if title 25 else 15)))
		(= lsRight (+ right 3 15))
		(= lsBottom (Max (+ bottom 3) (+ lsTop (CelHigh 994 temp1 0) 3)))
		(= priority 15)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grFILL_BOX top left bottom right 3 global134 15)
		(if title
			(-= top 10)
		)
		(Graph grDRAW_LINE (- top 1) (- left 1) (- top 1) right 17 15)
		(Graph grDRAW_LINE (- top 1) (- left 1) bottom (- left 1) 17 15)
		(Graph grDRAW_LINE bottom (- left 1) bottom right 17 15)
		(Graph grDRAW_LINE (- top 1) right bottom right 17 15)
		(Graph grDRAW_LINE (- top 2) (- left 2) (- top 2) (+ right 1) 19 15)
		(Graph grDRAW_LINE (- top 2) (- left 2) (+ bottom 1) (- left 2) 19 15)
		(Graph grDRAW_LINE (+ bottom 1) (- left 2) (+ bottom 1) (+ right 1) 19 15)
		(Graph grDRAW_LINE (- top 2) (+ right 1) (+ bottom 1) (+ right 1) 19 15)
		(Graph grDRAW_LINE (- top 3) (- left 3) (- top 3) (+ right 2) 16 15)
		(Graph grDRAW_LINE (- top 3) (- left 3) (+ bottom 2) (- left 3) 16 15)
		(Graph grDRAW_LINE (+ bottom 2) (- left 3) (+ bottom 2) (+ right 2) 16 15)
		(Graph grDRAW_LINE (- top 3) (+ right 2) (+ bottom 2) (+ right 2) 16 15)
		(Graph grUPDATE_BOX (- top 3) (- left 3) (+ bottom 3) (+ right 3) 1)
		(switch gAct
			(1
				(= temp3 (+ lsLeft 2))
				(= temp4 (- (- lsRight 15) 14))
				(= temp2 lsTop)
			)
			(2
				(if (IsFlag 1)
					(= temp3 lsLeft)
					(= temp4 (- (- lsRight 15) 13))
					(= temp2 (+ lsTop 2))
				else
					(= temp3 (+ lsLeft 8))
					(= temp4 (- (- lsRight 15) 14))
					(= temp2 (+ lsTop 4))
				)
			)
			(3
				(= temp3 (+ lsLeft 6))
				(= temp4 (- (- lsRight 15) 40))
				(= temp2 (+ lsTop 11))
			)
			(4
				(= temp3 (+ lsLeft 7))
				(= temp4 (- (- lsRight 15) 14))
				(= temp2 (+ lsTop 8))
			)
			(5
				(= temp3 (+ lsLeft 7))
				(= temp4 (- (- lsRight 15) 14))
				(= temp2 (+ lsTop 8))
			)
		)
		(DrawCel 994 temp1 0 temp3 temp2 -1)
		(DrawCel 994 temp1 1 temp4 temp2 -1)
		(SetPort temp0)
	)
)

