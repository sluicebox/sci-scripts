;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n076)
(use fileScr)
(use LL6Inv)
(use ButtonBar)
(use LarryTalker)
(use debugHandler)
(use ScrollerWindow)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use Talker)
(use Scaler)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Cursor)
(use Timer)
(use Grooper)
(use Sound)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	LSL6 0
	controlSet 1
	icon0 3
	icon1 4
	icon2 5
	icon3 6
	icon4 7
	icon5 8
	icon6 9
	icon7 10
	iconExit 11
	sTimer 12
	talkerSet 13
	dialSet 14
	globalSound1 15
	globalSound2 16
	scrollBar 17
	scrollBarUpIcon 18
	scrollBarDownIcon 19
	textScroller 20
	larry6Title 21
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
	global189
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
	gControlPlane
	gTalkerPlane
	gGraphMenuBar
	; 205
	global205
	global206
	global207
	gTextScroller
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

(instance funFx of Sound
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

(instance controlSet of Cast
	(properties)
)

(instance talkerSet of Cast
	(properties)
)

(instance dialSet of Cast
	(properties)
)

(class LSL6 of Game
	(properties
		isHandsOff 0
		controlsVisible 0
	)

	(method (newRoom)
		(if (gCast contains: (ScriptID 825 1)) ; tram
			((ScriptID 825 1) dispose:) ; tram
		)
		(if global205
			(proc79_7)
		)
		(if gCuees
			(gCuees eachElementDo: #dispose)
			(gCuees release:)
		)
		(super newRoom: &rest)
		(if
			(not
				(or
					(IsFlag 53)
					(IsFlag 35)
					(IsFlag 23)
					(OneOf gPrevRoomNum 100 110 120 130 140)
				)
			)
			((ScriptID 825 1) ; tram
				init:
				baseSetter: (ScriptID 825 3) ; tramBase
				setMotion: (ScriptID 825 0) ; theTramPath
			)
		)
	)

	(method (drawControls)
		(if controlsVisible
			(return)
		)
		(= controlsVisible 1)
		(UpdateScreenItem
			((View new:) view: 960 cel: 0 posn: 0 0 init: controlSet yourself:)
		)
		(UpdateScreenItem
			(larry6Title
				view: 960
				loop: 3
				cel: 0
				posn: 82 8
				setPri: 201
				init: talkerSet
				yourself:
			)
		)
		(UpdateScreenItem
			((View new:)
				view: 960
				cel: 1
				posn: 160 0
				init: controlSet
				yourself:
			)
		)
		(UpdateScreenItem
			((View new:) view: 960 loop: 1 posn: 0 0 init: talkerSet yourself:)
		)
		(UpdateScreenItem
			((View new:)
				view: 960
				loop: 1
				cel: 1
				posn: 160 0
				init: talkerSet
				yourself:
			)
		)
		(UpdatePlane (gTalkerPlane priority: (+ (GetHighPlanePri) 1) yourself:))
		(UpdatePlane (gControlPlane priority: (+ (GetHighPlanePri) 1) yourself:))
		((ScriptID 88 0) show: update:) ; PointGauge
		(gTheIconBar enable: show:)
		(UpdatePlane ((gTheIconBar plane:) picture: -2 yourself:))
		(gInventory state: (| (gInventory state:) $0020) show: gEgo)
		(UpdateScreenItem
			((ScriptID 92 3) setPri: 200 init: talkerSet yourself:) ; larryTBust
		)
		(gGraphMenuBar show:)
		(if (not (IsFlag 105))
			(textScroller show:)
		)
	)

	(method (hideControls)
		(if (not controlsVisible)
			(return)
		)
		(if (not (IsFlag 105))
			(textScroller hide:)
		)
		((ScriptID 88 0) hide:) ; PointGauge
		(gTheIconBar hide:)
		(gInventory hide:)
		(gGraphMenuBar hide:)
		(talkerSet eachElementDo: #dispose)
		(gTalkerPlane priority: -1)
		(UpdatePlane gTalkerPlane)
		(gControlPlane priority: -1)
		(UpdatePlane gControlPlane)
		(controlSet eachElementDo: #dispose)
		(= controlsVisible 0)
	)

	(method (init &tmp [temp0 3] temp3)
		(Platform
			0
			0
			998
			999
			98
			1
			2
			3
			4
			5
			6
			7
			8
			9
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
			21
			22
			23
			24
			25
			26
			27
			28
			29
			30
			31
			32
			33
			34
			35
			36
			37
			38
			39
			40
			41
			42
			43
			44
			45
			46
			47
			48
			49
			50
			51
			52
			53
		)
		(ScriptID 64982)
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
		(= gTheCursor theGameCursor)
		(= gNormalCursor theArrowCursor)
		(= gWaitCursor theWaitCursor)
		(= gMsgType 3)
		((= gSystemPlane (Plane new:)) name: {systemPlane})
		(super init: &rest)
		(= gUserFont 2308)
		(= gBigFont 4115)
		(= gSmallFont 2308)
		(= gTextSpeed 9)
		(= gEatMice 2)
		(= global177 (Str new: 100))
		(= gVersion (Str new: 20))
		(= gVersion {2.0})
		(= gMessager larryMessager)
		(= handsOnCode larryHandsOn)
		(= handsOffCode larryHandsOff)
		(= gNarrator LarryNarrator)
		(= gApproachCode larryApproachCode)
		(= gDoVerbCode larryDoVerbCode)
		((= gKeyDownHandler lKeyDownHandler) add:)
		((= gMouseDownHandler lMouseDownHandler) add:)
		((= gDirectionHandler lDirectionHandler) add:)
		((= gWalkHandler lWalkHandler) add:)
		((ScriptID 71 0) init:) ; initCode
		(DisposeScript 71)
		((= gTheIconBar ButtonBar)
			add:
				(icon0 setCursor: cIcon0 yourself:)
				(icon1 setCursor: cIcon1 yourself:)
				(icon2 setCursor: cIcon2 yourself:)
				(icon3 setCursor: cIcon3 yourself:)
				(icon4 setCursor: cIcon4 yourself:)
				(icon6 setCursor: cIcon5 yourself:)
				icon5
			x: 72
			y: 2
			eachElementDo: #mainView 981
			eachElementDo: #maskView 981
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 27
			curIcon: icon0
			walkIconItem: icon0
			showInvAfter: icon6
			init:
			disable:
		)
		(if global100
			(SetCursor 200 70)
			(self newRoom: (proc911_1 1))
		else
			(= temp3 (Event new:))
			(GetEvent 32767 temp3)
			(temp3 dispose:)
			(self newRoom: 100)
		)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for
			((= temp4 (FirstNode (gPlanes elements:))))
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (NextNode temp4))
			(= temp1 (NodeValue temp4))
			(AddPlane temp1)
			(for
				((= temp5 (FirstNode ((temp1 casts:) elements:))))
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (NextNode temp5))
				(= temp2 (NodeValue temp5))
				(for
					((= temp6 (FirstNode (temp2 elements:))))
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (NextNode temp6))
					(= temp3 (NodeValue temp6))
					(if (& (temp3 -info-:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
		)
		(gTextScroller kWindow: (ScrollWindow 0 gTextScroller (gTextScroller maxItems:))) ; ScrollCreate
		(ScrollWindow 19 (gTextScroller kWindow:) global258) ; ScrollReconstruct
		(ScrollWindow 8 (gTextScroller kWindow:)) ; ScrollEnd
		(if global210
			(gTextScroller show:)
			(= global210 0)
			((ScriptID 0 17) pageUp:) ; scrollBar
		)
		(if (gTheIconBar contains: (ScriptID 0 11)) ; iconExit
			(AddScreenItem (ScriptID 0 3)) ; icon0
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 15 16 17 18))
				(gCurRoom style:)
			else
				0
			)
		)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(DoSound sndMASTER_VOLUME global259)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(= global176 -1)
		(LarryNarrator curText: 0)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 80) doit: roomNum) ; disposeCode
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(Purge (gCurRoom purge:))
		(cond
			(
				(or
					(gCurRoom showControls:)
					(and
						(not (gGame controlsVisible:))
						(not (gCurRoom noControls:))
					)
				)
				(gGame drawControls:)
			)
			((and (gCurRoom noControls:) (gGame controlsVisible:))
				(gGame hideControls:)
			)
		)
		(gCurRoom init:)
		(CueObj client: 0 state: 0)
		(= global178 0)
	)

	(method (play)
		(= gGame self)
		(if (or (IsHiRes) (Platform 2))
			(= gCurSaveDir (Str new:))
			(= gSysLogPath (Str new:))
			(gCurSaveDir data: (GetSaveDir))
			(self init:)
			(while (not gQuit)
				(self doit:)
			)
			(= global182 (Str new: 255))
			(if (not (IsFlag 97))
				(Message msgGET 0 7 0 0 (Random 1 15) (global182 data:))
			else
				(Message msgGET 0 7 0 0 16 (global182 data:)) ; "(c) 1993 Sierra On-Line, Inc. Thank you for playing Leisure Suit Larry 6: "Shape Up or Slip Out!"  What did you think you were going to see, you pervert? Gotcha!"
			)
			(SetQuitStr (global182 data:))
		else
			(= global182 (Str new: 255))
			(Message msgGET 0 13 0 0 1 (global182 data:)) ; "Leisure Suit Larry 6 requires a 640x480-resolution, 256-color, VESA driver.  You must run it before you run the game.  Read the manual that came with your video card or computer.  It should tell you how."
			(SetQuitStr (global182 data:))
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(JOY_DOWNLEFT
						(= global178 2)
					)
					(KEY_CAPITAL
						(cond
							((not controlsVisible))
							((IsFlag 105)
								(gTextScroller show:)
								(ClearFlag 105)
							)
							(else
								(gTextScroller hide:)
								(SetFlag 105)
							)
						)
					)
					(KEY_F1
						(if (gUser canControl:)
							(funFx number: 576 play:)
						)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(self masterVolume: 0)
								(= gMasterVolume 0)
							)
							((>= global104 1)
								(self masterVolume: 10)
								(= gMasterVolume 10)
							)
							(else
								(self masterVolume: 5)
								(= gMasterVolume 5)
							)
						)
						(event claimed: 1)
					)
					(KEY_ADD
						(if (gUser canControl:)
							(gEgo
								setSpeed:
									(= global167
										(Max
											1
											(- (gEgo moveSpeed:) 1)
										)
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
					(KEY_F4
						(if (gUser canControl:)
							(funFx number: 516 play:)
						)
					)
					(KEY_F5
						(self save:)
						(event claimed: 1)
					)
					(KEY_F6
						(if (gUser canControl:)
							(funFx number: 631 play:)
						)
					)
					(KEY_F7
						(self restore:)
						(event claimed: 1)
					)
					(KEY_F8
						(if (gUser canControl:)
							(funFx number: 633 play:)
						)
					)
					(KEY_F9
						(if (and (not (== gCurRoomNum 620)) (not (gCurRoom inset:)))
							(self restart:)
							(event claimed: 1)
						else
							(event claimed: 1)
						)
					)
					(KEY_F10
						(if (gUser canControl:)
							(funFx number: 41 play:)
						)
					)
					(KEY_1
						(if (gUser canControl:)
							(funFx number: 576 play:)
						)
					)
					(KEY_2
						(if (gUser canControl:)
							(funFx number: 357 play:)
						)
					)
					(KEY_3
						(if (gUser canControl:)
							(funFx number: 652 play:)
						)
					)
					(KEY_4
						(if (gUser canControl:)
							(funFx number: 516 play:)
						)
					)
					(KEY_5
						(if (gUser canControl:)
							(funFx number: 908 play:)
						)
					)
					(KEY_6
						(if (gUser canControl:)
							(funFx number: 631 play:)
						)
					)
					(KEY_7
						(if (gUser canControl:)
							(funFx number: 9999 play:)
						)
					)
					(KEY_8
						(if (gUser canControl:)
							(funFx number: 633 play:)
						)
					)
					(KEY_9
						(if (gUser canControl:)
							(funFx number: 327 play:)
						)
					)
					(KEY_0
						(if (gUser canControl:)
							(funFx number: 1041 play:)
						)
					)
					(else
						(event claimed: 1)
						(if global100
							(event claimed: 0)
							((ScriptID 911) handleEvent: event) ; debugHandler
							((ScriptID 911) dispose:) ; debugHandler
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
						(FrameOut)
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
			(if (== (gApproachCode doit: param1) 32768)
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
						(scoreSfx number: 1001 loop: 1 play:)
					)
					((and (>= argc 1) (> param1 9))
						(scoreSfx number: 1002 loop: 1 play:)
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
		(if (IsFlag 86)
			(Print
				width: 150
				font: gUserFont
				addTitle: 0 0 23 1 0
				addText: 0 0 25 1 0 0 0 ; "Sorry, but you can't restart the game at this time. Please try again later."
				init:
			)
		else
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (Print dialog:)
				((Print dialog:) dispose:)
			)
			(= global213 gTheCursor)
			(gGame setCursor: gNormalCursor)
			(SetCursor 230 105)
			(if
				(==
					(Print
						font: gUserFont
						width: 110
						addTitle: 6 0 4 1 0
						addText: 6 0 0 1 50 3 0 ; "Do you really want to start over again from the very beginning?"
						addButton: 200 6 0 3 1 50 35 0 ; "Oops"
						addButton: 100 6 0 2 1 140 35 0 ; "Yep"
						addIcon: 1909 0 0 2 2
						init:
					)
					100
				)
				(if (gCurRoom inset:)
					((gCurRoom inset:) dispose:)
				)
				(PalVary 3) ; PalVaryKill
				(gTextScroller hide:)
				(gGame setCursor: gWaitCursor 1)
				(gTimers eachElementDo: #dispose)
				(gTimers eachElementDo: #delete)
				(gGlobalSound1 stop: dispose:)
				(gGlobalSound2 stop: dispose:)
				(gFeatures eachElementDo: #dispose release:)
				(gCast eachElementDo: #dispose)
				(gTheDoits release:)
				(PalCycle 4) ; Off
				(RemapColors 0) ; Off
				(global186 dispose:)
				(global177 dispose:)
				(global190 dispose:)
				(gFlags dispose:)
				((ScriptID 92 3) view: 1900 loop: 1 dispose:) ; larryTBust
				(gTheIconBar hide:)
				(gInventory
					hide:
					curIcon: 0
					delete: (ScriptID 85 5) ; selectorRect
					eachElementDo: #owner 0
					eachElementDo: #state 0
				)
				(gControlPlane dispose:)
				(gTalkerPlane dispose:)
				((ScriptID 0 13) dispose:) ; talkerSet
				((ScriptID 0 1) dispose:) ; controlSet
				((ScriptID 914 0) dispose:) ; hiResMenu
				(= controlsVisible 0)
				((ScriptID 88 0) dispose:) ; PointGauge
				(UpdatePlane
					(gThePlane setRect: 0 0 320 200 drawPic: -1 yourself:)
				)
				(for ((= temp0 100)) (<= temp0 260) ((++ temp0))
					(if (!= temp0 208)
						(= [gEgo temp0] 0)
					)
				)
				((ScriptID 71 0) init:) ; initCode
				(DisposeScript 71)
				(= gScore 0)
				((ScriptID 88 0) update:) ; PointGauge
				(if (gCast contains: (ScriptID 825 1)) ; tram
					((ScriptID 825 1) setMotion: 0 dispose:) ; tram
				)
				((ScriptID 825 0) completed: 1 value: -1 initialized: 0) ; theTramPath
				(= gCurRoomNum 820)
				(= isHandsOff 1)
				(= global166 (ScriptID 0 3)) ; icon0
				(gGame handsOn: newRoom: 200)
			else
				(gGame setCursor: global213)
			)
		)
	)

	(method (quitGame param1 &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gNormalCursor 1)
		(SetCursor 230 105)
		(if
			(or
				(and argc param1)
				(Print
					font: gUserFont
					width: 110
					addTitle: 5 0 4 1 0
					addText: 5 0 0 1 50 3 0 ; "Hey, don't go! What am I supposed to do inside here while you're gone?"
					addButton: 0 5 0 3 1 50 35 0 ; "Oops"
					addButton: 1 5 0 2 1 135 35 0 ; "Quit"
					addIcon: 1908 0 0 2 2
					init:
				)
			)
			(= gQuit 1)
		)
		(gGame setCursor: temp0)
	)

	(method (save param1 &tmp [temp0 3])
		(= global195 gTheCursor)
		(cond
			((or (gTalkers size:) (Print dialog:)))
			((or (IsFlag 86) (& (gGraphMenuBar state:) $0004))
				(Print
					width: 150
					font: gUserFont
					addTitle: 0 0 23 1 0
					addText: 0 0 15 1 0 0 0 ; "Sorry, but you can't save your game at this time. Please try again later."
					init:
				)
			)
			((== gCurRoomNum 740)
				(gMessager say: 0 0 20 0 0 0) ; "This game is over. Wait until Larry 7 to save your game!"
			)
			((and argc (== param1 1))
				(if (or (gCurRoom script:) isHandsOff)
					((ScriptID 0 12) setReal: gGame 10) ; sTimer
				else
					(gGame setCursor: gNormalCursor)
					(switch
						(Print
							addTitle: 8 0 4 1 0
							addText: 8 0 0 1 50 1 0 ; "It's been a while since you saved your game. Would you like to save now?"
							addIcon: 972 0 0 0 0
							addButton: 1 8 0 2 1 50 33 0 ; "Save"
							addButton: 0 8 0 3 1 85 33 0 ; "Screw It"
							addButton: 2 8 0 6 1 125 33 0 ; "Change Interval"
							init: revertCursor
						)
						(1
							(super save: &rest)
							(if (!= ((ScriptID 0 12) seconds:) -1) ; sTimer
								((ScriptID 0 12) setReal: gGame 0 global183) ; sTimer
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
			(else
				(gGame setCursor: gWaitCursor)
				(super save: &rest)
			)
		)
		(gGame setCursor: global195)
	)

	(method (restore &tmp temp0)
		(cond
			((or (Print dialog:) (gTalkers size:)))
			(
				(and
					(not (OneOf gCurRoomNum 100 110 120))
					(or (IsFlag 86) (& (gGraphMenuBar state:) $0004))
				)
				(Print
					width: 150
					font: gUserFont
					addTitle: 0 0 23 1 0
					addText: 0 0 19 1 0 0 0 ; "Sorry, but you can't restore a game at this time. Please try again later."
					init:
				)
			)
			(else
				(= temp0 gTheCursor)
				(super restore: &rest)
				(gGame setCursor: temp0)
			)
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
		(Platform 0 2 0)
		(if (not (gGame isHandsOff:))
			(return)
		)
		(gGame isHandsOff: 0)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enableIcon: icon1 icon2 icon3 icon4 icon6 (gTheIconBar at: 0))
		(if global170
			(gTheIconBar enableIcon: icon5)
		)
		(if global166
			(gTheIconBar curIcon: global166)
			(= global166 0)
		else
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
		(if (== (gTheIconBar getCursor:) -1)
			(gTheIconBar advanceCurIcon:)
		)
		(= temp0 (gTheIconBar curIcon:))
		(if (and (temp0 isKindOf: LL6InvItem) (!= (temp0 owner:) gEgo))
			(gTheIconBar curIcon: (gTheIconBar at: 0))
			(if (!= (gTheIconBar at: 0) (ScriptID 0 3)) ; icon0
				(gTheIconBar advanceCurIcon:)
			)
		)
		(gTheIconBar show:)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
	)
)

(instance larryHandsOff of Code
	(properties)

	(method (doit)
		(Platform 0 2 1)
		(if (gGame isHandsOff:)
			(return)
		)
		(gGame isHandsOff: 1)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(if ((gTheIconBar curIcon:) isKindOf: LL6InvItem)
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
		(= global166 (gTheIconBar curIcon:))
		(gTheIconBar disableIcon: icon1 icon2 icon3 icon4 icon6)
		(if (not global170)
			(gTheIconBar disableIcon: icon5)
		)
		(gTheIconBar disableIcon: (gTheIconBar at: 0))
		(User canControl: 0 canInput: 0)
		(if (& (gTheIconBar state:) $0020)
			(gTheIconBar show:)
		)
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
		(proc79_8 param1)
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
					(ScriptID 610 1) ; unknown_610_15
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
				(98
					(ScriptID 1826 98) ; talkInvNar
				)
				(9
					(ScriptID 1592 9) ; Carlos_the_Concierge
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
				(else 32768)
			)
		)
	)
)

(instance icon0 of IconI
	(properties
		type 20480
		message 3
		mainView 981
		maskView 981
		maskCel 2
	)
)

(instance icon1 of IconI
	(properties
		message 1
		mainView 981
		mainLoop 1
		maskView 981
		maskLoop 1
		maskCel 2
	)
)

(instance icon2 of IconI
	(properties
		message 4
		mainView 981
		mainLoop 2
		maskView 981
		maskLoop 2
		maskCel 2
	)
)

(instance icon3 of IconI
	(properties
		message 5
		mainView 981
		mainLoop 3
		maskView 981
		maskLoop 3
		maskCel 2
	)
)

(instance icon4 of IconI
	(properties
		message 2
		mainView 981
		mainLoop 4
		maskView 981
		maskLoop 4
		maskCel 2
	)
)

(instance icon5 of IconI
	(properties
		signal 7
		type 0
		message 0
		mainView 981
		mainLoop 7
		maskView 981
		maskLoop 7
		maskCel 2
	)

	(method (select &tmp temp0)
		(if global170
			(gTheIconBar disableIcon: self show:)
			(= temp0 global170)
			(= global170 0)
			(temp0 cue:)
		)
	)
)

(instance icon6 of IconI
	(properties
		message 6
		mainView 981
		mainLoop 5
		maskView 981
		maskLoop 5
		maskCel 2
	)
)

(instance icon7 of IconI
	(properties
		signal 3
		type 0
		message 0
		mainView 981
		mainLoop 6
		maskView 981
		maskLoop 6
		maskCel 2
	)

	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(if (and global110 (== gCurRoomNum 330))
					(gMessager say: 0 0 21 1 0 0) ; "You're too busy right now to access the control panel. Try again later."
				else
					(= temp0 gTheCursor)
					(gGame setCursor: gNormalCursor)
					((ScriptID 94) init:) ; ll6ControlPanel
					(gGame setCursor: temp0)
				)
				1
			)
		)
	)
)

(instance iconExit of IconI
	(properties
		signal 3
		type 0
		message 0
		mainView 981
		mainLoop 6
		maskView 981
		maskLoop 6
		maskCel 2
	)

	(method (init param1)
		(= message (if argc param1))
		(gTheIconBar prevIcon: 0 delete: (ScriptID 0 3) addToFront: self) ; icon0
		(super init: gTheIconBar)
		(gTheIconBar show:)
		(cond
			((not (gGame isHandsOff:))
				(if (== (gTheIconBar curIcon:) (ScriptID 0 3)) ; icon0
					(gTheIconBar curIcon: (ScriptID 0 4)) ; icon1
				)
				(gTheIconBar enableIcon: self show:)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
			)
			((== global166 (ScriptID 0 3)) ; icon0
				(= global166 (ScriptID 0 4)) ; icon1
			)
		)
	)

	(method (select)
		(return
			(if (and (super select: &rest) message)
				(message cue:)
				1
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gTheIconBar enableIcon: (ScriptID 0 11)) ; iconExit
		(gTheIconBar
			delete: (ScriptID 0 11) ; iconExit
			addToFront: (ScriptID 0 3) ; icon0
			curIcon: (ScriptID 0 3) ; icon0
			highlightedIcon: 0
			show:
		)
		(if (not (gGame isHandsOff:))
			(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		)
		(= global166 (ScriptID 0 3)) ; icon0
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

(instance sTimer of Timer
	(properties)

	(procedure (localproc_0)
		(= client 0)
		(if
			(or
				(gCurRoom script:)
				(not (gPrints isEmpty:))
				(not (gTalkers isEmpty:))
				(== gCurRoomNum 740)
			)
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

(instance scrollBarUpIcon of IconI
	(properties
		x 2
		y 1
		priority 15
		fixPriority 1
		mainView 963
		mainLoop 1
	)
)

(instance scrollBarDownIcon of IconI
	(properties
		x 2
		y 35
		priority 15
		fixPriority 1
		mainView 963
		mainLoop 2
	)
)

(instance scrollBar of WindowScrollBar
	(properties
		x 4
		y 6
		priority 14
		fixPriority 1
		view 963
		thumbView 963
		thumbCel 1
		minPosn 6
		maxPosn 32
	)
)

(instance textScroller of ScrollerWindow
	(properties
		fore 0
		back 61
		font 2308
		borderColor 61
		nsLeft 40
		nsTop 157
		nsRight 269
		nsBottom 195
		maxItems 50
	)

	(method (init)
		(super init: &rest)
		(UpdateScreenItem ((scroller thumb:) setPri: 15 yourself:))
	)
)

(instance version of File ; UNUSED
	(properties)
)

(instance larry6Title of View
	(properties)
)

