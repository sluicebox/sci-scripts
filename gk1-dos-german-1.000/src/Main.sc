;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use GKIconbar)
(use n013)
(use GKInvItem)
(use GKEgo)
(use DButton)
(use DText)
(use Print)
(use Messager)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Cursor)
(use Timer)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	GK 0
	globeCursor 1
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
	gGStopGroop
	global101 = 1234
	gGkMusic1
	gGkMusic2
	global104
	; 105
	global105
	global106
	global107 = 100
	global108
	global109
	; 110
	global110
	global111
	global112
	global113
	global114
	; 115
	global115 = 6
	global116
	global117
	global118
	global119
	; 120
	global120
	global121
	global122
	gDay
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
	global177 = 2
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
	gGk1Exits
	gGkSound1
	gGkSound2
	global209
	; 210
	global210
	gGkSound3
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
)

(instance theWaitCursor of Cursor ; UNUSED
	(properties
		view 997
	)
)

(instance theNormalCursor of Cursor
	(properties
		view 999
	)
)

(instance takeCursor of Cursor
	(properties
		view 958
	)
)

(instance openCursor of Cursor
	(properties
		view 958
		loop 2
	)
)

(instance walkCursor of Cursor
	(properties
		view 958
		loop 4
	)
)

(instance lookCursor of Cursor
	(properties
		view 958
		loop 5
	)
)

(instance operCursor of Cursor
	(properties
		view 958
		loop 1
	)
)

(instance moveCursor of Cursor
	(properties
		view 958
		loop 3
	)
)

(instance askCursor of Cursor
	(properties
		view 958
		loop 6
	)
)

(instance talkCursor of Cursor
	(properties
		view 958
		loop 7
	)
)

(instance helpCursor of Cursor
	(properties
		view 958
		loop 8
	)
)

(instance globeCursor of Cursor
	(properties
		view 999
	)
)

(instance gkKDHandler of EventHandler
	(properties)

	(method (handleEvent event)
		(if
			(OneOf
				(event message:)
				KEY_TAB
				KEY_ESCAPE
				KEY_F1
				KEY_F2
				KEY_F3
				KEY_F4
				KEY_F5
				KEY_F6
				KEY_F7
				KEY_F8
				KEY_F9
				KEY_F10
				$4500
				$4600
			)
			(return 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance gkMDHandler of EventHandler
	(properties)
)

(instance gkDirHandler of EventHandler
	(properties)
)

(instance gkWalkHandler of EventHandler
	(properties)
)

(instance gkPrints of EventHandler
	(properties)

	(method (handleEvent event &tmp temp0)
		(if
			(or
				(== (= temp0 (event message:)) KEY_TAB)
				(== temp0 KEY_ESCAPE)
				(<= temp0 KEY_F1 $4600)
			)
			(return 1)
		else
			(super handleEvent: event)
		)
	)
)

(class GK of Game
	(properties
		keepBar 0
		isHandsOn 1
		oldCurIcon 0
		currentSpeed 6
		barUp 0
	)

	(method (play)
		(SetCursor 0)
		(SetFlag 220)
		(super play: &rest)
	)

	(method (init &tmp [temp0 9] temp9)
		(ScriptID 64982)
		DText
		DButton
		Print
		IconBar
		Inv
		Polygon
		PolyPath
		(ScriptID 18) ; GKEgo
		(ScriptID 22) ; GKNarrator
		Timer
		(Load rsVIEW 959)
		(= global101 1234)
		(super init:)
		((= gPrints gkPrints) add:)
		((ScriptID 11 0) doit:) ; colorInit
		((ScriptID 10 0) doit:) ; gKInitCode
		(gkDummy init:)
		(gkMusic1 type: 0 owner: self musicVolume: 127 flags: 1 init:)
		(gkMusic2 type: 0 owner: self musicVolume: 127 flags: 1 init:)
		(gkSound1 type: 1 flags: 1 owner: self init:)
		(gkSound2 type: 1 flags: 1 owner: self init:)
		(gkSound3 type: 1 flags: 1 owner: self init:)
		(= gVersion {xx.yyy.zzz})
		(= temp9 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp9)
		(FileIO fiCLOSE temp9)
		(= gEgo GKEgo)
		(= gTheCursor takeCursor)
		(= gNormalCursor arrowCursor)
		(= gGStopGroop (ScriptID 18 1)) ; gStopGroop
		(= gPMouse PseudoMouse)
		(= gDoVerbCode gkDoVerbCode)
		(= gApproachCode gkApproachCode)
		(= gMessager gkMessager)
		(= gNarrator (ScriptID 22 0)) ; GKNarrator
		((= gKeyDownHandler gkKDHandler) add:)
		((= gMouseDownHandler gkMDHandler) add:)
		((= gWalkHandler gkWalkHandler) add:)
		((= gDirectionHandler gkDirHandler) add:)
		(= gGkSound1 gkSound1)
		(= gGkSound2 gkSound2)
		(= gGkSound3 gkSound3)
		(= gGkMusic1 gkMusic1)
		(= gGkMusic2 gkMusic2)
		(= isHandsOn 0)
		(SetCursor 0 0 319 155)
		((= gTheIconBar (ScriptID 12 0)) ; GKIconbar
			add:
				icon2
				icon0
				icon1
				icon3
				icon4
				icon5
				icon6
				icon7
				icon8
				icon9
				icon10
				icon11
				icon12
				icon13
			eachElementDo: #lowlightColor 2
			eachElementDo: #highlightColor global220
			init:
			curIcon: icon3
			useIconItem: icon12
			walkIconItem: icon2
			helpIconItem: icon5
			state: 3072
			disableIcon: icon12
		)
		(gTheIconBar disable:)
		(GKInventory init:)
		((ScriptID 14 0) init:) ; GKControls
		(self newRoom: 17) ; speedRoom
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (and (!= newRoomNumber 17) (gTalkers size:)) ; speedRoom
			(gMessager caller: 0 cue:)
			(gPMouse stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum &tmp temp0 temp1 [temp2 2])
		((ScriptID 19 0) doit:) ; disposeCode
		(for ((= temp1 0)) (< temp1 (gTimers size:)) ((++ temp1))
			(gTimers delete: (= temp0 (gTimers at: 0)))
			(gTimers add: temp0)
		)
		(if (OneOf gPrevRoomNum 50) ; interrogation
			(gTheIconBar enable:)
		)
		(if (OneOf roomNum 50) ; interrogation
			(gTheIconBar erase: disable:)
		)
		(if (and (!= roomNum 17) (!= roomNum 94) (!= roomNum 375)) ; speedRoom, titleRoom
			(gGame handsOn:)
		)
		(if (OneOf roomNum 700 710)
			(ScriptID 701) ; Africa
			((ScriptID roomNum) setRegions: 701) ; Africa
		)
		(if (OneOf roomNum 410 420 430 440 400) ; neJackson, nwJackson, seJackson, swJackson
			(ScriptID 401) ; JacksonSq
			((ScriptID roomNum) setRegions: 401) ; JacksonSq
		)
		(if (OneOf roomNum 300 310 320 302)
			(ScriptID 301) ; Cemetery
			((ScriptID roomNum) setRegions: 301) ; Cemetery
		)
		(if (OneOf roomNum 500 510 520 530 540 550)
			(ScriptID 501) ; Germany
			((ScriptID roomNum) setRegions: 501) ; Germany
		)
		(gGkSound1 setLoop: 1)
		(gGkSound2 setLoop: 1)
		(gGkSound3 setLoop: 1)
		(super startRoom: roomNum)
		(if
			(and
				(gEgo cycler:)
				(not (gEgo looper:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo setLooper: (ScriptID 18 1)) ; gStopGroop
		)
		(if (and (!= roomNum 17) (!= roomNum 94) (!= roomNum 375)) ; speedRoom, titleRoom
			(ClearFlag 220)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and global110 (== (event type:) evKEYBOARD))
			((ScriptID 99) handleEvent: event) ; MISSING SCRIPT
			((ScriptID 99) dispose:) ; MISSING SCRIPT
			(DisposeScript 99)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evVERB) (User canControl:))
				(self pragmaFail: (event message:))
				(event claimed: 1)
			)
		)
		(event claimed:)
	)

	(method (pragmaFail param1 &tmp temp0 temp1)
		(if (== (gCurRoom modNum:) -1)
			(= temp0 gCurRoomNum)
		else
			(= temp0 (gCurRoom modNum:))
		)
		(= temp1 (Random 1 3))
		(if (and gMsgType (gCurRoom noun:) (gUser canInput:))
			(cond
				((Message msgGET temp0 (gCurRoom noun:) param1 0 1)
					(gMessager say: (gCurRoom noun:) param1 0 0 0 temp0)
				)
				((OneOf param1 8 6 12 10 11 9 7 13)
					(gMessager say: 0 param1 0 temp1 0 0)
				)
				((Message msgGET temp0 (gCurRoom noun:) 0 0 1)
					(gMessager say: (gCurRoom noun:) 0 0 0 0 temp0)
				)
				(else
					(gMessager say: 0 param1 0 1 0 0)
				)
			)
		else
			(Prints {error g0})
		)
	)

	(method (save &tmp [temp0 6] temp6)
		(= temp6 (gGame setCursor: theNormalCursor 1 195 80))
		(SetCursor -2)
		(super save:)
		(SetCursor 0 0 319 155)
		(gGame setCursor: temp6)
		(Print font: gSmallFont)
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
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(SetCursor 0 0 319 155)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (quitGame &tmp temp0)
		(= temp0 (self setCursor: theNormalCursor 1))
		(if
			(myP
				addIcon: 966 0 0 0 0
				addButtonBM: 966 1 0 1 {} 21 27
				addButtonBM: 966 2 0 0 {} 21 49
				init:
			)
			(super quitGame:)
		else
			(self setCursor: temp0 1)
		)
	)

	(method (setCursor param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (not (IsFlag 220))
			(= gTheCursor param1)
			(param1 init:)
			(if (> argc 1)
				(if param2
					(gTheCursor show:)
				else
					(gTheCursor hide:)
				)
				(if (> argc 2)
					(SetCursor param3 param4)
					(if (> argc 4)
						(SetCursor param1 0 0 param5 param6)
					)
				)
			)
		)
		(return temp0)
	)

	(method (restore &tmp temp0 [temp1 227])
		(= temp0 (gGame setCursor: theNormalCursor 1))
		(SetCursor -2)
		(super restore:)
		(SetCursor 0 0 319 155)
		(gGame setCursor: temp0)
		(Print font: gSmallFont)
	)

	(method (keepIconBar)
		(if keepBar
			(gTheIconBar draw:)
			(= barUp 1)
		else
			(= barUp 0)
			(gTheIconBar erase:)
		)
	)

	(method (handsOff &tmp temp0)
		(= temp0 0)
		(if isHandsOn
			(= isHandsOn 0)
			(if (not argc)
				(gEgo setMotion: 0)
			)
			(if (not oldCurIcon)
				(= oldCurIcon (gTheIconBar curIcon:))
			)
			(= global116 0)
			(if (not (IsFlag 220))
				(SetFlag 220)
				(= temp0 1)
			)
			(gTheIconBar disable: 1 2 0 3 4 6 7 8 9 10 12)
			(User canControl: 0 canInput: 0)
			(if temp0
				(ClearFlag 220)
			)
			(gGame setCursor: gWaitCursor 1)
			(if gPMouse
				(gPMouse stop:)
			)
		)
	)

	(method (handsOn &tmp temp0)
		(if (not isHandsOn)
			(= isHandsOn 1)
			(User canControl: 1 canInput: 1)
			(if oldCurIcon
				(gTheIconBar curIcon: oldCurIcon)
			)
			(= oldCurIcon 0)
			(gTheIconBar enable: 1 2 0 3 4 6 7 8 9 10 12)
			(if (not (gTheIconBar curInvIcon:))
				(if (== (gTheIconBar curIcon:) icon12)
					(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
				)
				(gTheIconBar disableIcon: icon12)
			)
			(gGame setCursor: (gTheIconBar getCursor:))
		)
	)

	(method (showAbout)
		((ScriptID 92 2) doit:) ; xaboutStuff
	)
)

(instance icon0 of GKIconItem
	(properties
		noun 4
		x 92
		y 2
		signal 65
		message 12
		mainView 960
		mainLoop 4
		maskView 960
		maskLoop 4
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: takeCursor)
		(= topIcon (= bottomIcon icon6))
		(= leftIcon icon3)
		(= rightIcon icon1)
		(super init: &rest)
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

(instance icon1 of GKIconItem
	(properties
		noun 3
		x 113
		y 2
		signal 65
		message 6
		mainView 960
		mainLoop 5
		maskView 960
		maskLoop 5
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: openCursor)
		(= topIcon (= bottomIcon icon7))
		(= leftIcon icon0)
		(= rightIcon icon4)
		(super init: &rest)
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

(instance icon2 of GKIconItem
	(properties
		noun 13
		x 46
		y 2
		signal 65
		type 20480
		message 13
		mainView 960
		maskView 960
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: walkCursor)
		(= topIcon (= bottomIcon icon8))
		(= leftIcon icon5)
		(= rightIcon icon3)
		(super init: &rest)
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

(instance icon3 of GKIconItem
	(properties
		noun 6
		x 67
		y 2
		signal 65
		message 7
		mainView 960
		mainLoop 1
		maskView 960
		maskLoop 1
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: lookCursor)
		(= topIcon (= bottomIcon icon9))
		(= leftIcon icon2)
		(= rightIcon icon0)
		(super init: &rest)
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

(instance icon4 of GKIconItem
	(properties
		noun 9
		x 144
		signal 67
		type 0
		message 0
		mainView 960
		mainLoop 8
		maskView 960
		maskLoop 8
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: theNormalCursor)
		(= topIcon (= bottomIcon icon10))
		(= leftIcon icon1)
		(= rightIcon icon5)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(GKInventory showSelf: 1)
		else
			(return 0)
		)
	)
)

(instance icon5 of GKIconItem
	(properties
		noun 1
		x 254
		signal 3
		type 8192
		message 68
		mainView 960
		mainLoop 10
		maskView 960
		maskLoop 10
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: helpCursor)
		(= topIcon (= bottomIcon icon11))
		(= leftIcon icon12)
		(= rightIcon icon0)
		(super init: &rest)
	)
)

(instance icon6 of GKIconItem
	(properties
		noun 2
		x 92
		y 16
		signal 65
		message 8
		mainView 960
		mainLoop 6
		maskView 960
		maskLoop 6
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: operCursor)
		(= topIcon (= bottomIcon icon0))
		(= leftIcon icon9)
		(= rightIcon icon7)
		(super init: &rest)
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

(instance icon7 of GKIconItem
	(properties
		noun 5
		x 113
		y 16
		signal 65
		message 9
		mainView 960
		mainLoop 7
		maskView 960
		maskLoop 7
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: moveCursor)
		(= topIcon (= bottomIcon icon1))
		(= leftIcon icon6)
		(= rightIcon icon10)
		(super init: &rest)
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

(instance icon8 of GKIconItem
	(properties
		noun 8
		x 46
		y 16
		signal 65
		message 10
		mainView 960
		mainLoop 2
		maskView 960
		maskLoop 2
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: askCursor)
		(= topIcon (= bottomIcon icon2))
		(= leftIcon icon11)
		(= rightIcon icon9)
		(super init: &rest)
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

(instance icon9 of GKIconItem
	(properties
		noun 7
		x 67
		y 16
		signal 65
		message 11
		mainView 960
		mainLoop 3
		maskView 960
		maskLoop 3
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: talkCursor)
		(= topIcon (= bottomIcon icon3))
		(= leftIcon icon8)
		(= rightIcon icon6)
		(super init: &rest)
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

(instance icon10 of GKIconItem
	(properties
		noun 10
		x 144
		y 16
		signal 67
		message 0
		mainView 960
		mainLoop 9
		maskView 960
		maskLoop 9
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: theNormalCursor)
		(= topIcon (= bottomIcon icon4))
		(= leftIcon icon7)
		(= rightIcon icon12)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 91 0) doit: dispose:) ; Walkman
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon11 of GKIconItem
	(properties
		noun 14
		x 254
		y 16
		signal 67
		message 0
		mainView 960
		mainLoop 11
		maskView 960
		maskLoop 11
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: theNormalCursor)
		(= topIcon (= bottomIcon icon5))
		(= leftIcon icon10)
		(= rightIcon icon8)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gTheIconBar hide:)
			((ScriptID 14 0) showSelf:) ; GKControls
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon12 of GKIconItem
	(properties
		noun 11
		x 173
		signal 65
		message 0
		mainView 959
		mainLoop 2
		maskView 959
		maskLoop 2
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: theNormalCursor)
		(= topIcon (= bottomIcon self))
		(= leftIcon icon4)
		(= rightIcon icon11)
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (and (gTheIconBar curInvIcon:) (super select: &rest))
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)

	(method (mask)
		(if (gTheIconBar curInvIcon:)
			(= fixPriority 1)
			(= priority 150)
			(super mask:)
		)
	)
)

(instance icon13 of IconI
	(properties
		noun 12
		x 224
		signal 4
		mainView 959
		mainLoop 3
		helpVerb 68
	)

	(method (mask))
)

(instance gkDoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(if (== (param2 modNum:) -1)
			(= temp0 gCurRoomNum)
		else
			(= temp0 (param2 modNum:))
		)
		(if
			(and
				gMsgType
				(param2 noun:)
				(not (OneOf param1 8 6 12 10 11 9 7 13))
				(Message msgGET temp0 (param2 noun:) 0 0 1)
			)
			(gMessager say: (param2 noun:) 0 0 0 0 temp0)
		else
			(gGame pragmaFail: param1)
		)
	)
)

(instance gkApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(7 1)
				(11 2)
				(13 4)
				(9 8)
				(6 16)
				(12 32)
				(8 64)
				(else 32768)
			)
		)
	)
)

(instance gkMessager of Messager
	(properties)

	(method (say)
		(if (and gNarrator (gNarrator initialized:))
			(gNarrator cueVal: 1 dispose:)
		)
		(super say: &rest)
	)

	(method (sayRange)
		(if (and gNarrator (gNarrator initialized:))
			(gNarrator cueVal: 1 dispose:)
		)
		(super sayRange: &rest)
	)

	(method (findTalker param1 &tmp temp0)
		(= temp0 gNarrator)
		(= global180 param1)
		(if (or (== param1 3) (== param1 47))
			(return -1)
		)
		(if (== gCurRoomNum 50) ; interrogation
			(= temp0
				(switch param1
					(1
						(ScriptID 1100) ; egoInterrogater
					)
					(2
						(ScriptID 1101) ; graceInterrogater
					)
					(6
						(ScriptID 1102) ; sargeInterrogater
					)
					(8
						(ScriptID 1051 2) ; tkMose
					)
					(26
						(ScriptID 1051 3) ; tkGran
					)
					(34
						(ScriptID 1052 2) ; tkBartender
					)
					(11
						(ScriptID 1052 3) ; tkWilly
					)
					(5
						(ScriptID 1053 2) ; tkMalia
					)
					(25
						(ScriptID 1053 3) ; tkDrJohn
					)
					(32
						(ScriptID 1054 2) ; tkGrave
					)
					(27
						(ScriptID 1054 3) ; tkMoon
					)
					(40
						(ScriptID 1055 2) ; tkHart
					)
					(12
						(ScriptID 1055 3) ; tkCaz
					)
					(10
						(ScriptID 1056 2) ; tkCrash
					)
					(46
						(ScriptID 1056 3) ; tkWolf
					)
					(45
						(ScriptID 1057 1) ; tkGerde
					)
					(else gNarrator)
				)
			)
		)
		(if temp0
			(return temp0)
		else
			(super findTalker: param1)
		)
	)
)

(class GKSound of Sound
	(properties
		type 0
		musicVolume 127
		soundVolume 127
	)
)

(instance gkDummy of GKSound
	(properties)
)

(instance gkMusic1 of GKSound
	(properties)
)

(instance gkMusic2 of GKSound
	(properties)
)

(instance gkSound1 of GKSound
	(properties)
)

(instance gkSound2 of GKSound
	(properties)
)

(instance gkSound3 of GKSound
	(properties)
)

(instance arrowCursor of Cursor
	(properties
		view 999
	)
)

(instance myP of Print
	(properties)

	(method (init)
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(dialog mouseHiliting: 1)
		(plane picture: -2)
		(super init: &rest)
	)
)

