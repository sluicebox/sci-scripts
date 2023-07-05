;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use RegionPath)
(use eRS)
(use Print)
(use Messager)
(use PAvoider)
(use Talker)
(use PseudoMouse)
(use Slider)
(use BorderWindow)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use GameControls)
(use Window)
(use Sound)
(use File)
(use Game)
(use User)
(use System)

(public
	pq1 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	EgoDead 5
	SetScore 6
	proc0_8 8
	SetFlag 9
	IsFlag 10
	ClearFlag 11
	Face 12
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
	gPq1ApproachCode
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
	global115 = -1
	global116 = -1
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
	global193
	global194
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200 = 500
	global201 = 500
	global202 = 500
	global203 = 50
	global204 = 5
	; 205
	global205
	global206
	global207
	global208
	global209
	; 210
	gLongSong2
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
	global221 = 600
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
	global245 = 11
	global246 = 10
	global247 = 2
	global248 = 2
	global249 = -1
	; 250
	global250
	global251
	global252
	global253
	global254
)

(procedure (NormalEgo param1 param2)
	(if (and (> argc 0) (!= param1 -1))
		(gEgo view: param1)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	else
		(gEgo view: global206)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	)
	(gEgo
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: egoStopWalk -1
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
		setSpeed: gSpeed 14 (| (gEgo signal:) $1000)
	)
)

(procedure (HandsOff &tmp temp0)
	(User canControl: 0 canInput: 0)
	(if (not argc)
		(gEgo setMotion: 0)
	)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 0 1 2 3 4 5)
	(gTheIconBar curIcon: temp0)
	(if (not (HaveMouse))
		(= global115 ((User curEvent:) x:))
		(= global116 ((User curEvent:) y:))
		(gGame setCursor: gWaitCursor 1 304 172)
	else
		(gGame setCursor: gWaitCursor 1)
	)
	(if gPMouse
		(gPMouse stop:)
	)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 0 1 2 3 4 5)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 4)
	)
	(if (and (not (HaveMouse)) (!= global115 -1))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global115 global116)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
	(= global115 (= global116 -1))
)

(procedure (HaveMem param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (EgoDead param1)
	(if (not argc)
		(= param1 3)
	)
	(= global212 param1)
	(gCurRoom newRoom: 200) ; endgame
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param1))
		(+= gScore param2)
		(SetFlag param1)
		(rm0Sound priority: 15 number: 942 loop: 1 flags: 1 play:)
	)
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

(procedure (proc0_8 param1 param2 &tmp [temp0 40] [temp40 10] [temp50 10]) ; UNUSED
	(StrCpy
		@temp50
		(switch param2
			(4 {Do})
			(8 {Help})
			(1 {Look})
			(2 {Talk})
			(3 {Walk})
			(25 {Black Book})
			(13 {Bullets})
			(22 {Camero Keys})
			(6 {Close Locker})
			(30 {Computer Card})
			(15 {Gun Locker Key})
			(9 {Gun})
			(21 {Hand Cuffs})
			(8 {Help})
			(27 {Hoffman File})
			(28 {Hotel disguise})
			(18 {License})
			(20 {Note Book})
			(16 {Night Stick})
			(5 {Open})
			(10 {Pen})
			(29 {Hair Bleach})
			(12 {Patrol Keys})
			(11 {Radio})
			(42 {Ran Stop Light})
			(24 {Smith Wesson Gun})
			(14 {Ticket Book})
			(19 {Ticket})
			(23 {Unmarked Keys})
			(17 {Wallet})
			(26 {Warrant})
			(else {UNKNOWN VERB})
		)
	)
	(Format @temp40 0 0 gCurRoomNum) ; "%d.nor"
	(Format @temp0 0 1 (param1 name:) @temp50 gMouseX gMouseY) ; ";%s (%s) [%d,%d]:"
	(File name: @temp40 writeString: @temp0 {\r\n} close:)
)

(instance longSong of Sound
	(properties
		flags -1
	)
)

(instance longSong2 of Sound
	(properties
		flags -1
	)
)

(instance walkCursor of Cursor
	(properties
		view 606
	)

	(method (init)
		(= loop
			(switch global206
				(1 1)
				(2 2)
				(177 3)
				(124 4)
				(125 5)
				(else 0)
			)
		)
		(super init: &rest)
	)
)

(instance egoStopWalk of StopWalk
	(properties)
)

(instance ego of Ego
	(properties
		noun 6
		sightAngle 40
	)

	(method (init)
		(= view global206)
		(super init: &rest)
		(self setCycle: egoStopWalk -1)
	)

	(method (facingMe)
		(return 1)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(if (OneOf (gEgo view:) 0 1 2 124)
				(super handleEvent: event)
			else
				(event claimed: 1)
				(return)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 9 21 1 32 10 11 13 2) ; Do, Service_Revolver, Handcuffs, Look, ???, Pen, Extender, Bullets, Talk
			(gMessager say: 6 theVerb 0 0 0 0)
		else
			(gMessager say: 6 0 0 (+ (= global222 (mod (++ global222) 3)) 1) 0 0)
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

	(method (doit)
		(if
			(and
				(== (gEgo loop:) (- (NumLoops gEgo) 1))
				(not (& (gEgo signal:) $0800))
			)
			(gEgo loop: (gEgo cel:))
		)
		(super doit: &rest)
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

(instance pq1Win of SysWindow
	(properties)

	(method (open)
		(if (not (HaveMouse))
			(= global182 (gGame setCursor: 601 1))
		)
		(super open: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(if (not (HaveMouse))
			(gGame setCursor: global182 1)
		)
	)
)

(instance narratorWin of BorderWindow
	(properties)

	(method (open)
		(if (not (HaveMouse))
			(= global182 (gGame setCursor: 601 1))
		)
		(super open: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(if (not (HaveMouse))
			(gGame setCursor: global182 1)
		)
	)
)

(instance theNarrator of Narrator
	(properties
		back 5
	)

	(method (init)
		(= gSystemWindow narratorWin)
		(= font gUserFont)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow pq1Win)
		(super dispose: &rest)
	)
)

(instance pq1 of Game
	(properties)

	(method (init &tmp temp0 temp1 [temp2 50])
		Print
		StopWalk
		PolyPath
		Timer
		Polygon
		PQRoom
		PAvoider
		(ScriptID 982)
		Narrator
		(super init:)
		(Palette palSET_FROM_RESOURCE 999 2)
		(= gVersion {x.yyy.zzz})
		(= global113 {991-999-9999})
		(= global114 {9999-999999})
		(= gVersion {x.yyy.zzz})
		(= temp1 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp1)
		(FileIO fiCLOSE temp1)
		(= gEgo ego)
		((ScriptID 879 0) doit: pq1Win gcWin) ; initCode
		(= gNormalCursor 608)
		((= gKeyDownHandler kDHandler) add:)
		((= gMouseDownHandler mDHandler) add:)
		((= gDirectionHandler dirHandler) add:)
		((= gWalkHandler wHandler) add:)
		(= gPMouse PseudoMouse)
		(= gDoVerbCode pq1DoVerbCode)
		(= gFtrInitializer pq1FtrInit)
		(= gPq1ApproachCode pq1ApproachCode)
		(= gMsgType 1)
		(= gMessager pq1Messager)
		(= gNarrator theNarrator)
		((= gLongSong longSong) owner: self priority: 15 init:)
		((= gLongSong2 longSong2) owner: self priority: 15 init:)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon5 icon8 icon9 icon6
			eachElementDo: #init
			eachElementDo: #highlightColor global126
			eachElementDo: #lowlightColor global123
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			walkIconItem: icon0
			disable: 4
			activateHeight: -1
			state: 1024
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(gTheIconBar disable: 8)
		((= gGameControls GameControls)
			window: gcWin
			add:
				(detailSlider theObj: self selector: #detailLevel yourself:)
				(volumeSlider theObj: self selector: #masterVolume yourself:)
				(speedSlider theObj: self selector: #setSpeed yourself:)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				iconOk
				iconHelp
				(iconAbout selector: #doit yourself:)
			helpIconItem: iconHelp
			curIcon: iconRestore
			eachElementDo: #highlightColor global126
			eachElementDo: #lowlightColor global122
			state: 2048
		)
		(if (FileIO fiEXISTS {702.scr})
			(= global108 1)
		else
			(= global108 0)
		)
		(self newRoom: 1)
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

	(method (startRoom param1)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 898) doit: param1) ; disposeCode
		(if
			(and
				(> (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print
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
		(cond
			((OneOf param1 10 11 12 13 14 15 16 17 18 19 20 21 34 35)
				RegionPath
				(ScriptID 134) ; station
			)
			((OneOf param1 51 53)
				(ScriptID 151) ; hotel
			)
		)
		(= global224 {Not supported by this room.})
		(super startRoom: param1)
		(if (and (gCast contains: gEgo) (not (gEgo looper:)))
			(gEgo setLoop: stopGroop)
		)
	)

	(method (quitGame)
		(super
			quitGame:
				(Print
					addText: {Going off duty?}
					addButton: 1 {QUIT} 0 12
					addButton: 0 {PLAY} 50 12
					init:
				)
		)
	)

	(method (restart &tmp temp0)
		(if (not argc)
			(= temp0 gTheCursor)
			(gGame setCursor: 999)
			(cond
				(
					(Print
						addText: {You want to start over?}
						addButton: 1 {RESTART} 10 25
						addButton: 0 {PLAY} 90 25
						init:
					)
					(super restart:)
				)
				((== temp0 -31970)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				)
				(else
					(gGame setCursor: temp0)
				)
			)
		else
			(super restart:)
		)
	)

	(method (setSpeed param1)
		(if argc
			(super setSpeed: param1)
			(gEgo setSpeed: gSpeed)
		)
		(if (== gCurRoomNum 300)
			(gCurRoom notify:)
		)
		(return gSpeed)
	)

	(method (pragmaFail)
		(if (User canControl:)
			(gMessager say: 0 53 0 3 0 0) ; "That's not necessary."
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 20])
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
								(not gFastCast)
								(not (IsFlag 1))
								(not (& (icon5 signal:) $0004))
							)
							(= temp0 gTheCursor)
							(icon5 select:)
							(if (== temp0 -31970)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:)
								)
							else
								(gGame setCursor: temp0)
							)
						)
						(event claimed: 1)
					)
					(KEY_SHIFTTAB
						(if
							(and
								(not gFastCast)
								(not (IsFlag 1))
								(not (& (icon5 signal:) $0004))
							)
							(= temp0 gTheCursor)
							(icon5 select:)
							(if (== temp0 -31970)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:)
								)
							else
								(gGame setCursor: temp0)
							)
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
						(if (and (not gFastCast) (not (IsFlag 1)))
							(= temp0 gTheCursor)
							(gGame save:)
							(if (== temp0 -31970)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:)
								)
							else
								(gGame setCursor: temp0)
							)
						)
						(event claimed: 1)
					)
					(KEY_F7
						(if (and (not gFastCast) (not (IsFlag 1)))
							(= temp0 gTheCursor)
							(gGame restore:)
							(if (== temp0 -31970)
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:)
								)
							else
								(gGame setCursor: temp0)
							)
						)
						(event claimed: 1)
					)
					(KEY_F9
						(if (and (not gFastCast) (not (IsFlag 1)))
							(gGame restart:)
						)
						(event claimed: 1)
					)
					(KEY_ALT_n
						(cond
							((not global108)
								(event claimed: 0)
							)
							((HaveMem 1536)
								((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
								(event claimed: 1)
							)
							(else
								(Prints {Not Enough Memory!!})
								(event claimed: 1)
							)
						)
					)
					(KEY_ADD
						(if (gUser controls:)
							(self
								setSpeed:
									(Max 0 (- (gEgo moveSpeed:) 1))
							)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(self setSpeed: (+ (gEgo moveSpeed:) 1))
						)
					)
					($003d ; =
						(if (gUser controls:)
							(self setSpeed: 6)
						)
					)
					(else
						(if global108
							((ScriptID 702) handleEvent: event) ; MISSING SCRIPT
							((ScriptID 702) dispose:) ; MISSING SCRIPT
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance icon0 of IconI
	(properties
		view 900
		loop 0
		cel 0
		type 20480
		message 3
		signal 65
		maskView 900
		maskLoop 10
		noun 23
		helpVerb 8
	)

	(method (init)
		(= cursor walkCursor)
		(super init:)
	)
)

(instance icon1 of IconI
	(properties
		view 900
		loop 1
		cel 0
		cursor 608
		message 1
		signal 65
		maskView 900
		maskLoop 10
		noun 16
		helpVerb 8
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 2
		cel 0
		cursor 609
		message 4
		signal 65
		maskView 900
		maskLoop 10
		maskCel 1
		noun 5
		helpVerb 8
	)
)

(instance icon3 of IconI
	(properties
		view 900
		loop 3
		cel 0
		cursor 607
		message 2
		signal 65
		maskView 900
		maskLoop 10
		maskCel 2
		noun 20
		helpVerb 8
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 7
		signal 65
		maskView 900
		maskLoop 10
		maskCel 3
		noun 4
		helpVerb 8
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
											(+ (temp2 loop:) 1)
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
											(+ (temp2 loop:) 1)
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
							(+ 1 (temp2 loop:))
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
											(+ 1 (temp2 loop:))
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
										(+ 1 (temp2 loop:))
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
								(+ 1 (temp2 loop:))
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

(instance icon5 of IconI
	(properties
		view 900
		loop 5
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 900
		maskLoop 10
		maskCel 4
		noun 12
		helpVerb 8
	)

	(method (init)
		(= lowlightColor global122)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gInventory showSelf: gEgo)
		)
		(return 1)
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 8
		cel 0
		cursor 999
		signal 67
		maskView 900
		maskLoop 8
		maskCel 1
		noun 19
		helpVerb 8
	)

	(method (show &tmp [temp0 7] [temp7 4] temp11 [temp12 2])
		(super show: &rest)
		(= temp11 30)
		(Message msgGET 0 19 1 2 1 @temp12) ; "of"
		(Format @temp0 0 2 gScore @temp12 gPossibleScore) ; "%d %s %d"
		(TextSize @temp7 @temp0 temp11 0)
		(Display
			@temp0
			dsCOLOR
			global126
			dsFONT
			temp11
			dsCOORD
			(+ nsLeft 5 (/ (- 50 [temp7 3]) 2))
			(+ nsTop 14)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 900
		loop 7
		cel 0
		cursor 999
		message 6
		signal 67
		maskView 900
		maskLoop 10
		noun 3
		helpVerb 8
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(GameControls window: gcWin show:)
		)
		(return 1)
	)
)

(instance icon9 of IconI
	(properties
		view 900
		loop 9
		cel 0
		cursor 610
		message 8
		signal 3
		maskView 900
		maskLoop 10
		maskCel 1
		noun 8
		helpVerb 8
	)
)

(instance pq1DoVerbCode of Code
	(properties)

	(method (doit param1)
		(if (User canControl:)
			(if
				(OneOf
					param1
					13
					22
					9
					21
					54
					27
					28
					18
					32
					10
					29
					12
					11
					14
					19
					23
					17
					26
					1
					4
					2
				)
				(gMessager say: 0 param1 0 0 0 0)
			else
				(gMessager say: 0 53 0 3 0 0) ; "That's not necessary."
			)
		)
	)
)

(instance pq1FtrInit of Code
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

(instance pq1Messager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(2
						(ScriptID 896 4) ; sonny
					)
					(20
						(ScriptID 17 1) ; Russ
					)
					(36
						(ScriptID 51 1) ; Ken
					)
					(61
						(ScriptID 151 8) ; Danny_Anglin
					)
					(47
						(ScriptID 151 5) ; frankT
					)
					(58
						(ScriptID 151 6) ; Gene
					)
					(57
						(ScriptID 151 7) ; Otto
					)
					(3
						(ScriptID 1016 0) ; Dooley
					)
					(44
						(ScriptID 1449 0) ; Alex
					)
					(4
						(ScriptID 1017 0) ; morgan
					)
					(6
						(ScriptID 1021 0) ; laura
					)
					(8
						(ScriptID 1272 0) ; marie
					)
					(65
						(ScriptID 555 1) ; phoneT
					)
					(64
						(ScriptID 55 1) ; Bouncer
					)
					(63
						(ScriptID 54 1) ; Chip
					)
					(46
						(ScriptID 54 2) ; Joe_Taber
					)
					(13
						(ScriptID 1356 0) ; drunkTalker
					)
					(17
						(ScriptID 1373 0) ; hoffman
					)
					(56
						(ScriptID 34 1) ; suspectTalker
					)
					(68
						(ScriptID 67 3) ; Suspect
					)
					(32
						(ScriptID 35 1) ; Paul
					)
					(10
						(ScriptID 1247 0) ; carol
					)
					(35
						(ScriptID 54 3) ; doorT
					)
					(7
						(if (== gCurRoomNum 47)
							(ScriptID gCurRoomNum 2)
						else
							(ScriptID 1018 0) ; steve
						)
					)
					(5
						(if
							(or
								(OneOf
									gCurRoomNum
									10
									11
									12
									13
									14
									15
									16
									17
									18
									19
									20
									21
									34
									35
								)
								(!= gCurRoomNum 38)
							)
							(ScriptID 1019 0) ; Jack
						else
							(ScriptID gCurRoomNum 1)
						)
					)
					(38
						(switch gCurRoomNum
							(14
								(ScriptID 14 2) ; Officer
							)
							(15
								(ScriptID 152 5) ; Officer
							)
							(13
								(ScriptID 13 1) ; officerT
							)
							(else
								(ScriptID 134 1) ; MISSING EXPORT
							)
						)
					)
					(37
						(ScriptID 134 1) ; MISSING EXPORT
					)
					(40
						(ScriptID gCurRoomNum 2)
					)
					(39
						(ScriptID gCurRoomNum 3)
					)
					(41
						(ScriptID gCurRoomNum 4)
					)
					(42
						(ScriptID gCurRoomNum 5)
					)
					(55
						(ScriptID gCurRoomNum 2)
					)
					(56
						(ScriptID gCurRoomNum 3)
					)
					(54
						(ScriptID gCurRoomNum 4)
					)
					(29
						(ScriptID 1341 0) ; Cherie
					)
					(27
						(ScriptID 41 1) ; tawneeT
					)
					(15
						(ScriptID 1399) ; Colby
					)
					(16
						(ScriptID 1399 1) ; Simms
					)
					(26
						(ScriptID gCurRoomNum 2)
					)
					(25
						(ScriptID gCurRoomNum 3)
					)
					(51
						(ScriptID gCurRoomNum 1)
					)
					(67
						(ScriptID gCurRoomNum 1)
					)
					(52
						(ScriptID gCurRoomNum 2)
					)
					(1
						(ScriptID gCurRoomNum 1)
					)
					(23
						(ScriptID 14 3) ; Morris_Fudley
					)
					(66
						(ScriptID 502 1) ; MISSING SCRIPT
					)
					(else
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

(instance pq1ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(else -32768)
			)
		)
	)
)

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp [temp0 11] temp11 [temp12 5])
		(= temp11 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			left: (/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
			bottom:
				(+ (CelHigh 947 1 1) 6 (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2))
			right:
				(+
					151
					(CelWide 947 0 1)
					(/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
				)
			priority: temp11
		)
		(super open:)
		(DrawCel
			947
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 947 0 1)) (+ 4 (CelWide 947 1 1)))
						(CelWide 947 0 5)
					)
					2
				)
				4
				(CelWide 947 1 1)
			)
			3
			temp11
		)
		(DrawCel 947 1 1 4 3 temp11)
		(DrawCel 947 1 0 94 38 temp11)
		(DrawCel 947 1 0 135 38 temp11)
		(DrawCel 947 0 4 63 (- 37 (+ (CelHigh 947 0 4) 3)) temp11)
		(DrawCel 947 0 3 101 (- 37 (+ (CelHigh 947 0 4) 3)) temp11)
		(DrawCel 947 0 2 146 (- 37 (+ (CelHigh 947 0 4) 3)) temp11)
		(Graph grUPDATE_BOX 12 1 15 (+ 151 (CelWide 947 0 1)) 1)
	)
)

(instance detailSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal 128
		noun 27
		helpVerb 8
		sliderView 947
		yStep 2
		topValue 3
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal 128
		noun 26
		helpVerb 8
		sliderView 947
		yStep 2
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal 128
		noun 28
		helpVerb 8
		sliderView 947
		yStep 2
		bottomValue 15
	)
)

(instance iconSave of ControlIcon
	(properties
		view 947
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 7
		signal 450
		maskView 947
		maskLoop 2
		maskCel 2
		noun 24
		helpVerb 8
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		message 7
		signal 451
		maskView 947
		maskLoop 2
		maskCel 2
		noun 18
		helpVerb 8
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		message 7
		signal 451
		noun 25
		helpVerb 8
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		message 7
		signal 451
		noun 29
		helpVerb 8
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		nsLeft 34
		nsTop 106
		message 7
		signal 451
		noun 1
		helpVerb 8
	)

	(method (select)
		(if (super select: &rest)
			(gGameControls hide:)
			((ScriptID 878 0) doit:) ; aboutScript
		)
		(return 1)
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 8
		nsTop 106
		cursor 610
		message 8
		signal 387
		noun 8
		helpVerb 8
	)
)

(instance iconOk of IconI
	(properties
		view 947
		loop 8
		cel 0
		nsLeft 8
		nsTop 86
		message 7
		signal 451
		noun 14
		helpVerb 8
	)
)

