;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use ego_3)
(use eRS)
(use Eco2Talker)
(use invSetupCode)
(use Docks)
(use Jungle)
(use Village)
(use Cibola)
(use Bats)
(use Flood)
(use Gold)
(use Print)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Window)
(use Flags)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	Rain 0
	proc0_1 1
	IsFlag 2
	SetFlag 3
	ClearFlag 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	stopGroop 8
	eco2Cursor 9
	proc0_10 10
	SetEcorderFlag 11
	IsEcorderFlag 12
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
	gEco2ApproachCode
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
	global100 = 100
	global101 = 1234
	global102
	gGameSound1
	gGameSound2
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
	gEH
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
	gCurrentRegionFlags
	gCheckEcorderIcon
	gWriteEcorderData
	global153
	global154
	; 155
	global155
	global156
	global157
	global158
)

(procedure (proc0_1 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (IsFlag param1)
	(return (& [global110 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1)
	(= [global110 (/ param1 16)]
		(| [global110 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (ClearFlag param1)
	(= [global110 (/ param1 16)]
		(& [global110 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (SetEcorderFlag param1)
	(= [global124 (/ param1 16)]
		(| [global124 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (IsEcorderFlag param1)
	(return (& [global124 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_5 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
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
	(cond
		((> (Abs (- temp0 (gEgo heading:))) 23)
			(param1 setHeading: temp0 (and (IsObject temp3) temp3))
		)
		((IsObject temp3)
			(temp3 cue:)
		)
	)
)

(procedure (proc0_6 param1 &tmp [temp0 60]) ; UNUSED
	(Printf {Clicking on the %s produces no response.} (param1 name:))
)

(procedure (proc0_7 param1) ; UNUSED
	(if param1
		(gTheIconBar delete: iconWalk addToFront: (iconExit init: yourself:))
		(if (== (gTheIconBar curIcon:) iconWalk)
			(gTheIconBar curIcon: iconExit walkIconItem: 0)
			(gGame setCursor: (iconExit cursor:))
		)
	else
		(gTheIconBar delete: iconExit addToFront: (iconWalk init: yourself:))
		(if (== (gTheIconBar curIcon:) iconExit)
			(gTheIconBar curIcon: iconWalk walkIconItem: iconWalk)
			(gGame setCursor: (iconWalk cursor:))
		)
	)
)

(procedure (proc0_10 param1 &tmp temp0)
	(if (>= argc 2)
		(= temp0 (Inv at: param1))
		(gTheIconBar select: (gTheIconBar at: 5) curInvIcon: temp0)
	else
		(= temp0 (gTheIconBar at: param1))
		(gTheIconBar select: temp0)
	)
	(gGame setCursor: (temp0 cursor:) 1)
)

(instance gameSound1 of Sound
	(properties)
)

(instance gameSound2 of Sound
	(properties)
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

(instance eco2Cursor of Cursor
	(properties
		view 960
	)
)

(instance KH of EventHandler
	(properties)
)

(instance MH of EventHandler
	(properties)
)

(instance DH of EventHandler
	(properties)
)

(instance WH of EventHandler
	(properties)
)

(instance EH of EventHandler
	(properties)
)

(class Rain of Game
	(properties
		pointSound 0
	)

	(method (init &tmp [temp0 7])
		Flags
		Print
		StopWalk
		Polygon
		PolyPath
		Timer
		Eco2Room
		ego
		Eco2Talker
		EcoI
		EcoInvI
		IconBar
		Inv
		(ScriptID 982)
		Narrator
		(ScriptID 922) ; MISSING EXPORT
		(super init:)
		(= gNormalCursor eco2Cursor)
		(= gSystemWindow eco2Win)
		(= handsOnCode HOnC)
		(= handsOffCode HOffC)
		(= gVersion {x.yyy.zzz})
		(= global131 {mm/dd/yy})
		(= global132 {991-999-9999})
		(= global133 {992-999-9999})
		((ScriptID 1 0) init:) ; eco2InitCode
		(DisposeScript 1)
		(= gDoVerbCode eco2DoVerbCode)
		(= gFtrInitializer eco2FtrInit)
		(= gEco2ApproachCode eco2ApproachCode)
		(= gTheCursor eco2Cursor)
		(= gMessager eco2Messager)
		(= gCheckEcorderIcon checkEcorderIcon)
		(= gWriteEcorderData writeEcorderData)
		((= gKeyDownHandler KH) add:)
		((= gMouseDownHandler MH) add:)
		((= gDirectionHandler DH) add:)
		((= gWalkHandler WH) add:)
		((= gEH EH) add:)
		(= gPMouse PseudoMouse)
		((= gGameSound1 gameSound1) owner: self flags: 1 init:)
		((= gGameSound2 gameSound2) owner: self flags: 1 init:)
		(gGame
			pointSound:
				((Sound new:) owner: self flags: 1 number: 96 init: yourself:)
		)
		((= gTheIconBar ecoIconBar)
			add:
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconEcorder
				iconUse
				iconInventory
				iconBag
				iconControls
				iconHelp
			eachElementDo: #init
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			curIcon: iconWalk
			useIconItem: iconUse
			helpIconItem: iconHelp
			walkIconItem: iconWalk
			disable: 5
			disable:
		)
		(gTheIconBar enable:)
		(= global154 (gTheIconBar curIcon:))
		(gUser alterEgo: (= gEgo ego) canControl: 0 canInput: 0)
		(self newRoom: 10) ; speedRoom
	)

	(method (doit)
		(if
			(and
				(gEH size:)
				(not (IsFlag 5))
				(User controls:)
				(or
					(== (gTheIconBar curIcon:) iconWalk)
					(and
						(OneOf gCurRoomNum 200 220 240 280 260 290)
						(== (gTheIconBar curIcon:) iconDo)
					)
				)
			)
			(gEH eachElementDo: #doit)
		)
		(if (GameIsRestarting)
			(statusCode doit:)
		)
		(super doit:)
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(= temp0 param1)
		(= global153 0)
		(cond
			((IsFlag 1)
				(if (and (> argc 1) (not param2))
					((= gTheCursor eco2Cursor) view: 960 loop: 10 cel: 14 init:)
				)
			)
			((not (IsObject param1))
				((= gTheCursor eco2Cursor)
					view: 960
					loop: 10
					cel:
						(switch param1
							(999 5)
							(998 6)
							(997 8)
							(996 14)
							(else param1)
						)
					init:
				)
			)
			(
				(and
					gCurRoomNum
					(HaveMouse)
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(IsObject (gTheIconBar curInvIcon:))
				)
				((= gTheCursor param1)
					view: 960
					loop: ((gTheIconBar curInvIcon:) loop:)
					cel: ((gTheIconBar curInvIcon:) cel:)
					init:
				)
			)
			(else
				((= gTheCursor param1) init:)
				(cond
					(
						(and
							(not (HaveMouse))
							(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							(IsObject (gTheIconBar curInvIcon:))
						)
						((= gTheCursor param1)
							view: 960
							loop: ((gTheIconBar curInvIcon:) loop:)
							cel: ((gTheIconBar curInvIcon:) cel:)
							init:
						)
					)
					((!= (gTheCursor cel:) 14) 0)
					((IsObject ((gTheIconBar curIcon:) cursor:))
						(gTheCursor
							loop: ((gTheIconBar curInvIcon:) loop:)
							cel: ((gTheIconBar curInvIcon:) cel:)
						)
					)
					(else
						(gTheCursor cel: ((gTheIconBar curIcon:) cursor:))
					)
				)
			)
		)
		(if (> argc 2)
			(gTheCursor posn: param3 param4)
		)
		(return temp0)
	)

	(method (pragmaFail)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (gUser canInput:)
			(gMessager say: 14 ((gUser curEvent:) message:) 0 0 0 999)
		)
	)

	(method (restart)
		((ScriptID 17) doit: 1) ; restartCode
	)

	(method (quitGame)
		((ScriptID 17) doit: 0) ; restartCode
	)

	(method (newRoom newRoomNumber &tmp [temp0 5])
		(gGame setCursor: gWaitCursor 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (and (IsObject gFastCast) (gFastCast elements:))
			(gFastCast eachElementDo: #dispose 1)
		)
		(if (gEH size:)
			(gEH eachElementDo: #dispose)
		)
		(gNarrator
			x: -1
			y: -1
			caller: 0
			modNum: -1
			disposeWhenDone: 1
			ticks: 0
			talkWidth: 0
			keepWindow: 1
			modeless: 0
			font: gUserFont
			color: 57
			back: 68
			cueVal: 0
			initialized: 0
			showTitle: 0
			curVolume: 0
			saveCursor: 0
		)
		(gTheIconBar disable:)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom param1 &tmp temp0 temp1 temp2 temp3)
		((ScriptID 6) doit: param1) ; disposeCode
		(for ((= temp2 0)) (< temp2 (gTimers size:)) ((++ temp2))
			(gTimers delete: (= temp0 (gTimers at: 0)))
			(gTimers add: temp0)
		)
		(for ((= temp2 0)) (< temp2 (gInventory size:)) ((++ temp2))
			(gInventory delete: (= temp1 (gInventory at: 0))) ; buckazoid
			(gInventory add: temp1)
		)
		(statusCode doit:)
		(cond
			((OneOf param1 160 100)
				Docks
				((ScriptID 199 1) init:) ; dockFlags
				((ScriptID param1) setRegions: 199) ; Docks
			)
			((OneOf param1 200 220 240 280 260 290)
				(ScriptID 91) ; loadCode2
				(ScriptID 92) ; loadCode3
				Jungle
				((ScriptID 299 1) init:) ; jungleFlags
				((ScriptID param1) setRegions: 299) ; Jungle
			)
			((OneOf param1 300 330 360 380 390 400 420 430 440 16)
				(ScriptID 91) ; loadCode2
				(ScriptID 92) ; loadCode3
				(ScriptID 93) ; loadCode4
				Village
				((ScriptID 399 1) init:) ; villageFlags
				((ScriptID param1) setRegions: 399) ; Village
			)
			((OneOf param1 530 560 500 501 580 590)
				(ScriptID 93) ; loadCode4
				(ScriptID 94) ; loadCode5
				Cibola
				((ScriptID 599 1) init:) ; cibolaFlags
				((ScriptID param1) setRegions: 599) ; Cibola
			)
			((OneOf param1 600 630 640 680)
				(ScriptID 93) ; loadCode4
				(ScriptID 94) ; loadCode5
				(ScriptID 95) ; loadCode6
				(ScriptID 96) ; loadCode7
				Bats
				((ScriptID 699 1) init:) ; batFlags
				((ScriptID param1) setRegions: 699) ; Bats
			)
			((OneOf param1 700 701 702 730)
				(ScriptID 90) ; loadCode1
				(ScriptID 93) ; loadCode4
				(ScriptID 94) ; loadCode5
				(ScriptID 95) ; loadCode6
				(ScriptID 96) ; loadCode7
				Flood
				((ScriptID 799 1) init:) ; floodFlags
				((ScriptID param1) setRegions: 799) ; Flood
			)
			((OneOf param1 800 840 820 860 870 880)
				(ScriptID 90) ; loadCode1
				(ScriptID 93) ; loadCode4
				(ScriptID 94) ; loadCode5
				(ScriptID 95) ; loadCode6
				Gold
				((ScriptID 899 1) init:) ; goldFlags
				((ScriptID param1) setRegions: 899) ; Gold
			)
		)
		(gTheIconBar enable:)
		(super startRoom: param1)
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
		(if (not (IsObject (gTheIconBar curInvIcon:)))
			(gTheIconBar curInvIcon: 0 disable: 5)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_TAB
					(cond
						((IsFlag 3)
							((gGame script:) report:)
						)
						((not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gEgo showInv:)
							(event claimed: 1)
						)
					)
				)
				(KEY_SHIFTTAB
					(if (not (& ((gTheIconBar at: 6) signal:) $0004))
						(if gFastCast
							(return gFastCast)
						)
						(gEgo showInv:)
						(event claimed: 1)
					)
				)
				(KEY_CONTROL
					(gGame quitGame:)
					(event claimed: 1)
				)
				(JOY_RIGHT
					(if
						(and
							(not (& ((gTheIconBar at: 8) signal:) $0004))
							(not (IsFlag 7))
						)
						(gGame showControls:)
					)
				)
				(KEY_F2
					(cond
						((gGame masterVolume:)
							(gGame masterVolume: 0)
						)
						((> global105 1)
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
						(and
							(not (& ((gTheIconBar at: 8) signal:) $0004))
							(not (IsFlag 7))
							(!= gCurRoomNum 390)
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
						(and
							(not (& ((gTheIconBar at: 8) signal:) $0004))
							(not (IsFlag 7))
							(!= gCurRoomNum 390)
						)
						(if gFastCast
							(return gFastCast)
						)
						(gGame restore:)
						(event claimed: 1)
					)
				)
				(KEY_F9
					(if (not (& ((gTheIconBar at: 8) signal:) $0004))
						(if gFastCast
							(return gFastCast)
						)
						(gGame restart:)
						(event claimed: 1)
					)
				)
				(KEY_ADD
					(if (gUser controls:)
						(= global136 (Max 0 (-- global136)))
						(gEgo setSpeed: global136)
					)
				)
				(KEY_SUBTRACT
					(if (gUser controls:)
						(++ global136)
						(gEgo setSpeed: global136)
					)
				)
				($003d ; =
					(if (gUser controls:)
						(gEgo setSpeed: 6)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (points param1 param2)
		(if (and (> argc 1) (IsFlag param2))
			(return)
		)
		(if param1
			(gGame changeScore: param1)
			(if param2
				(SetFlag param2)
			)
			(if (and (> param1 0) pointSound)
				(pointSound play:)
				(statusCode doit:)
			)
		)
	)

	(method (showControls)
		(gGame setCursor: 999)
		((ScriptID 5 0) init: show: dispose:) ; eco2GameControls
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (save)
		(super save: &rest)
		(self setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (showAbout)
		((ScriptID 7) doit:) ; aboutCode
	)
)

(instance statusCode of Code
	(properties)

	(method (doit &tmp [temp0 50] [temp50 50])
		(if (not (OneOf gCurRoomNum 10 40)) ; speedRoom, intro
			(Message msgGET 999 19 0 0 1 @temp0) ; "Lost Secret of the Rainforest Score: %d of 1000"
			(Message msgGET 999 19 0 0 2 @temp50)
			(Format @temp50 @temp0 gScore)
			(DrawStatus @temp50 67 0)
		)
	)
)

(instance iconWalk of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 0
		type 20480
		message 3
		signal 65
		maskView 990
		maskLoop 10
		maskCel 2
		noun 22
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconLook of IconI
	(properties
		view 990
		loop 1
		cel 0
		cursor 1
		message 1
		signal 65
		maskView 990
		maskLoop 10
		noun 17
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconDo of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 2
		message 4
		signal 65
		maskView 990
		maskLoop 10
		maskCel 1
		noun 3
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconTalk of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 3
		message 2
		signal 65
		maskView 990
		maskLoop 10
		noun 20
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconEcorder of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 990
		maskLoop 10
		maskCel 1
		noun 1
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(cond
			((IsFlag 3)
				(if gFastCast
					(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
					(return 0)
				else
					(if (== ((gGame script:) register:) self)
						(= temp0 (super select: &rest))
						((gGame script:) cue:)
					else
						((gGame script:) report:)
					)
					(return temp0)
				)
			)
			((super select: &rest)
				(gMessager say: 14 0 16 (Random 1 36) 0 999)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance iconUse of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 990
		maskLoop 10
		noun 21
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconInventory of IconI
	(properties
		view 990
		loop 6
		cel 0
		cursor 999
		type 0
		message 69
		signal 67
		maskView 990
		maskLoop 10
		maskCel 1
		noun 16
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(if (IsFlag 3)
			(SetPort -1)
		)
		(= temp0 0)
		(cond
			((IsFlag 3)
				(if gFastCast
					(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
					(return 0)
				else
					(if (== ((gGame script:) register:) self)
						(= temp0 (super select: &rest))
						((gGame script:) cue:)
						(gEgo showInv:)
					else
						((gGame script:) report:)
					)
					(return temp0)
				)
			)
			((not (super select: &rest))
				(return 0)
			)
			(else
				(gEgo showInv:)
				(return 1)
			)
		)
	)
)

(instance iconBag of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 7
		message 53
		signal 65
		maskView 990
		maskLoop 10
		noun 24
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconControls of IconI
	(properties
		view 990
		loop 8
		cel 0
		cursor 999
		message 0
		signal 67
		maskView 990
		maskLoop 10
		maskCel 1
		noun 2
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(cond
			((IsFlag 3)
				(if gFastCast
					(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
					(return 0)
				else
					(if (== ((gGame script:) register:) self)
						(= temp0 (super select: &rest))
						((gGame script:) cue:)
					else
						((gGame script:) report:)
					)
					(return temp0)
				)
			)
			((super select: &rest)
				(gTheIconBar hide:)
				(gGame showControls:)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance iconHelp of IconI
	(properties
		view 990
		loop 9
		cel 0
		cursor 9
		type 8192
		message 6
		signal 3
		maskView 990
		maskLoop 10
		noun 15
		modNum 999
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(= temp1 ((Event new:) type: evKEYBOARD message: KEY_RETURN yourself:))
				(gFastCast firstTrue: #handleEvent temp1)
				(temp1 dispose:)
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance iconExit of IconI
	(properties
		view 990
		loop 13
		cel 0
		cursor 10
		message 54
		signal 65
		maskView 990
		maskLoop 10
		noun 25
		helpVerb 6
	)

	(method (select &tmp temp0 temp1)
		(= temp0 0)
		(if (IsFlag 3)
			(if gFastCast
				(gFastCast firstTrue: #handleEvent temp1) ; UNINIT
				(return 0)
			else
				(if (== ((gGame script:) register:) self)
					(= temp0 (super select: &rest))
					((gGame script:) cue:)
				else
					((gGame script:) report:)
				)
				(return temp0)
			)
		else
			(return (super select: &rest))
		)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global108 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance eco2DoVerbCode of Code
	(properties)

	(method (doit param1)
		(if (gUser canInput:)
			(gMessager say: 14 param1 0 0 0 999)
		)
	)
)

(instance eco2FtrInit of Code
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

(instance eco2Messager of Messager
	(properties)

	(method (sayNext)
		(Print mode: 1)
		(super sayNext: &rest)
	)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(1
						(ScriptID 1039) ; Slaughter
					)
					(8
						(ScriptID 1109) ; Customs
					)
					(39
						(ScriptID 1129) ; Boatman
					)
					(10
						(ScriptID 1139) ; Grandpa
					)
					(9
						(ScriptID 1149) ; Peddler
					)
					(6
						(ScriptID 1229) ; Sloth
					)
					(17
						(ScriptID 1248) ; paBird
					)
					(18
						(ScriptID 1249) ; MaBird
					)
					(5
						(ScriptID 1269) ; Hoatzin
					)
					(23
						(ScriptID 1319) ; Potter
					)
					(27
						(ScriptID 1329) ; Chief
					)
					(32
						(ScriptID 1337) ; Hag1
					)
					(33
						(ScriptID 1338) ; Hag2
					)
					(34
						(ScriptID 1339) ; Hag3
					)
					(31
						(ScriptID 1349) ; Gardener
					)
					(24
						(ScriptID 1359) ; Weaver
					)
					(29
						(ScriptID 1369) ; Drumboy
					)
					(26
						(ScriptID 1379) ; Idler
					)
					(30
						(ScriptID 1389) ; Quiri
					)
					(19
						(ScriptID 1619) ; Firebat
					)
					(40
						(ScriptID 1621) ; Fishbat
					)
					(42
						(ScriptID 1625) ; Tentbat
					)
					(41
						(ScriptID 1627) ; Punkbat
					)
					(43
						(ScriptID 1629) ; Tailbat
					)
					(21
						(ScriptID 1669) ; Chirop
					)
					(22
						(ScriptID 1749) ; Harpy
					)
					(35
						(ScriptID 1877) ; Orchid1
					)
					(36
						(ScriptID 1878) ; Orchid2
					)
					(2
						(ScriptID 1009) ; EgoTalker
					)
					(59
						(ScriptID 440 1) ; EgoTalker
					)
					(7
						(ScriptID 1029) ; Noah
					)
					(1
						(ScriptID 1039) ; Slaughter
					)
					(60
						(ScriptID 440 3) ; Slauter
					)
					(3
						(ScriptID 1049) ; Gonzales
					)
					(20
						(ScriptID 1059) ; Paquita
					)
					(58
						(ScriptID 440 2) ; Paquita
					)
					(57
						(ScriptID 1060) ; PaquitaSick
					)
					(25
						(ScriptID 1069) ; Shaman
					)
					(16
						(ScriptID 1089) ; Howler
					)
					(14
						(ScriptID 1078) ; Orpheus
					)
					(15
						(ScriptID 1079) ; Morpheus
					)
					(47
						(ScriptID gCurRoomNum (if (== gCurRoomNum 260) 1 else 9))
					)
					(46
						(ScriptID 260 2) ; cockTalker
					)
					(44
						(ScriptID gCurRoomNum 3)
					)
					(46
						(ScriptID 260 2) ; cockTalker
					)
					(49
						(ScriptID 240 1) ; toucanTalker
					)
					(51
						(ScriptID 240 2) ; boaTalker
					)
					(50
						(ScriptID 240 4) ; hyacinthTalker
					)
					(52
						(ScriptID 240 5) ; fredTalker
					)
					(48
						(ScriptID 240 6) ; ethelTalker
					)
					(53
						(ScriptID 240 7) ; lucyTalker
					)
					(54
						(ScriptID 240 8) ; rickyTalker
					)
					(55
						(ScriptID 1671) ; EgoTalker
					)
					(56
						(ScriptID 1670) ; Chirop
					)
					(4
						(ScriptID 420 1) ; FHTalker
					)
					(66
						(ScriptID 430 1) ; FHTalker2
					)
					(61
						(ScriptID 1881) ; Adam_in_Plane
					)
					(62
						(ScriptID 1880) ; Noah_in_Plane
					)
					(63
						(ScriptID 1882) ; Intro_bat_1
					)
					(64
						(ScriptID 1883) ; Intro_bat_2
					)
					(45
						(ScriptID 100 1) ; gossipTalker
					)
					(12
						(ScriptID 160 1) ; Bandanna_Man
					)
					(13
						(ScriptID 160 2) ; Small_Man
					)
					(65
						(ScriptID 580 1) ; paquitaPrint
					)
					(67
						(ScriptID 300 1) ; babyTalker
					)
					(68
						(ScriptID 280 1) ; darterTalker
					)
					(else gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance eco2ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(53 16)
				(55 0)
				(else -32768)
			)
		)
	)
)

(instance checkEcorderIcon of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (eco2Cursor loop:))
		(= temp1 (eco2Cursor cel:))
		(cond
			((!= temp0 8))
			(
				(and
					(not global153)
					(== temp1 8)
					(param1 onMe: gMouseX (- gMouseY 10))
				)
				(= global153 param1)
				(eco2Cursor cel: 10 init:)
			)
			(
				(and
					(== global153 param1)
					(== temp1 10)
					(not (param1 onMe: gMouseX (- gMouseY 10)))
				)
				(= global153 0)
				(eco2Cursor cel: 8 init:)
			)
		)
	)
)

(instance writeEcorderData of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 [temp2 15] [temp17 30])
		(if (and (== param2 55) (not (IsEcorderFlag param3)))
			(SetEcorderFlag param3)
			(cond
				((<= param3 18)
					(= temp0 5)
					(= temp1 param3)
				)
				((<= param3 44)
					(= temp0 2)
					(= temp1 (- param3 18))
				)
				((<= param3 55)
					(= temp0 6)
					(= temp1 (- param3 44))
				)
				((<= param3 72)
					(= temp0 7)
					(= temp1 (- param3 55))
				)
				(else
					(= temp0 8)
					(= temp1 (- param3 72))
				)
			)
			(Message msgGET 999 14 0 14 1 @temp2) ; "ECORDING:  %s."
			(Message msgGET 50 13 0 temp0 temp1 @temp17)
			(gSystemWindow color: 8 back: 23)
			(Print addTextF: @temp2 @temp17 ticks: 5 init: ticks: 0)
			(gSystemWindow color: 57 back: 68)
			(eco2Cursor cel: 8 init:)
			(= global153 0)
			(gGame points: 1)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance eco2Win of SysWindow
	(properties
		color 57
		back 68
	)
)

(instance ecoIconBar of IconBar
	(properties)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (not (IsFlag 4))
			(gSounds pause:)
			(|= state $0020)
			(gGame setCursor: 999 1)
			(= height
				(CelHigh
					((= temp0 (self at: 0)) view:)
					(temp0 loop:)
					(temp0 cel:)
				)
			)
			(= port (GetPort))
			(SetPort -1)
			(= underBits (Graph grSAVE_BOX y 0 (+ y height) 320 1))
			(= temp1 (PicNotValid))
			(PicNotValid 1)
			(= temp3 0)
			(= temp4 y)
			(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
				(= temp6 (NextNode temp5))
				(if (not (IsObject (= temp7 (NodeValue temp5))))
					(return)
				)
				(if (<= (temp7 nsRight:) 0)
					(temp7 show: temp3 temp4)
					(= temp3 (temp7 nsRight:))
				else
					(temp7 show:)
				)
			)
			(if curInvIcon
				(if (gEgo has: (gInventory indexOf: curInvIcon))
					(= temp3
						(+
							(/
								(-
									(-
										(useIconItem nsRight:)
										(useIconItem nsLeft:)
									)
									(CelWide
										(curInvIcon view:)
										(curInvIcon loop:)
										(curInvIcon cel:)
									)
								)
								2
							)
							(useIconItem nsLeft:)
						)
					)
					(= temp4
						(+
							y
							(/
								(-
									(-
										(useIconItem nsBottom:)
										(useIconItem nsTop:)
									)
									(CelHigh
										(curInvIcon view:)
										(curInvIcon loop:)
										(curInvIcon cel:)
									)
								)
								2
							)
							(useIconItem nsTop:)
						)
					)
					(DrawCel
						(curInvIcon view:)
						(+ (curInvIcon loop:) 1)
						(curInvIcon cel:)
						temp3
						temp4
						-1
					)
					(if (& (useIconItem signal:) $0004)
						(useIconItem mask:)
					)
				else
					(= curInvIcon 0)
				)
			)
			(PicNotValid temp1)
			(Graph grUPDATE_BOX y 0 (+ y height) 320 1)
			(self highlight: curIcon)
		else
			(SetPort -1)
		)
		(if
			(and
				(gGame script:)
				(IsFlag 3)
				(== ((gGame script:) register:) self)
			)
			(SetFlag 4)
			((gGame script:) cue:)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 50] temp57 temp58 temp59)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp57 (temp4 cursor:))
			(= temp58 (temp4 signal:))
			(= temp59 (== temp4 helpIconItem))
		)
		(if (& temp2 $0040) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
			)
		else
			(switch temp2
				(evNULL
					(cond
						((not (and (<= 0 temp0 (+ y height)) (<= 0 temp1 320)))
							(if
								(and
									(& state $0400)
									(or
										(not (IsObject helpIconItem))
										(not (& (helpIconItem signal:) $0010))
									)
								)
								(= oldMouseY 0)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 highlightedIcon))
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(if temp59
							(if temp57
								(gGame setCursor: temp57)
							)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= temp5 (& temp58 $0040))
						)
						(temp4 doit:)
					)
				)
				(evKEYBOARD
					(switch temp3
						(KEY_ESCAPE
							(= temp5 1)
						)
						(KEY_DELETE
							(= temp5 1)
						)
						(KEY_RETURN
							(if (not temp4)
								(= temp4 highlightedIcon)
							)
							(cond
								((and temp4 (== temp4 helpIconItem))
									(if (IsFlag 3)
										(self select: temp4 1)
										(= temp5 (& temp58 $0040))
									else
										(if (!= temp57 -1)
											(gGame setCursor: temp57)
										)
										(if helpIconItem
											(helpIconItem
												signal:
													(|
														(helpIconItem signal:)
														$0010
													)
											)
										)
									)
								)
								((and (IsObject temp4) (self select: temp4))
									(temp4 doit:)
									(= temp5 (& temp58 $0040))
								)
							)
						)
						(KEY_SHIFTTAB
							(self retreat:)
						)
						(KEY_TAB
							(self advance:)
						)
					)
				)
				($6000 ; evVERB | evHELP
					(if (and temp4 (temp4 helpVerb:))
						(= temp6 (GetPort))
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp4 noun:)
								(temp4 helpVerb:)
								0
								1
								0
								0
								(temp4 modNum:)
							init:
						)
						(SetPort temp6)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: 999)
				)
			)
		)
		(return temp5)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(event localize:)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			(
				(or
					(and
						(not temp1)
						(& state $0400)
						(<= -10 (event y:) height)
						(<= 0 (event x:) 320)
						(not (= temp0 0))
					)
					(and
						(== temp1 evKEYBOARD)
						(or
							(== (event message:) KEY_ESCAPE)
							(== (event message:) KEY_DELETE)
						)
						(= temp0 1)
					)
				)
				(if (IsFlag 7)
					(event claimed: 1)
					(return)
				)
				(event globalize:)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(gGame setCursor: 999)
				(if temp0
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(curIcon nsLeft:)
								(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
							)
							(- (curIcon nsBottom:) 3)
					)
				)
				(self doit:)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(curIcon cursor:)
					else
						gWaitCursor
					)
				)
				(if temp0
					(gGame setCursor: temp3 1 oldMouseX oldMouseY)
				else
					(gGame
						setCursor:
							temp3
							1
							((event new:) x:)
							(Max (event y:) (+ 1 height))
					)
				)
				(if (not (IsFlag 4))
					(self hide:)
				)
			)
			((& temp1 evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(cond
							((not (IsObject curIcon)))
							((or (!= curIcon useIconItem) curInvIcon)
								(event
									type: (curIcon type:)
									message:
										(if (== curIcon useIconItem)
											(curInvIcon message:)
										else
											(curIcon message:)
										)
								)
							)
							(else
								(event type: evNULL)
							)
						)
					)
					(KEY_INSERT
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					(JOY_NULL
						(if (& (event type:) $0040) ; direction
							(self advanceCurIcon:)
							(event claimed: 1)
						)
					)
				)
			)
			((& temp1 evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					((IsObject curIcon)
						(event
							type: (curIcon type:)
							message:
								(if (== curIcon useIconItem)
									(curInvIcon message:)
								else
									(curIcon message:)
								)
						)
					)
				)
			)
		)
	)
)

(instance HOffC of Code
	(properties)

	(method (doit)
		(if (not global154)
			(= global154 (gTheIconBar curIcon:))
		)
		(= global106 (gUser canControl:))
		(= global107 (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(= global108 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar curIcon: (gTheIconBar at: 8))
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(if (not (HaveMouse))
			(gGame setCursor: 996)
		else
			(gGame setCursor: gWaitCursor)
		)
	)
)

(instance HOnC of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(gUser canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6 8 7)
		(if (and argc param1)
			(gUser canControl: global106 canInput: global107)
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(if (& global108 (>> $8000 temp0))
					(gTheIconBar disable: temp0)
				)
			)
		)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 5)
		)
		(if
			(and
				(IsObject global154)
				(or (!= global154 iconExit) (== (gTheIconBar at: 0) iconExit))
			)
			(gTheIconBar curIcon: global154)
			(gGame setCursor: (global154 cursor:))
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 5))
					(not (gTheIconBar curInvIcon:))
				)
				(gTheIconBar advanceCurIcon:)
			)
		)
		(= global154 0)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(gEgo setSpeed: global136)
	)
)

