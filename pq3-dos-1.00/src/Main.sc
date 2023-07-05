;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use SpeakWindow)
(use Body)
(use eRS)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use PolyPath)
(use Polygon)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	pq3 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	EgoDead 5
	SetScore 6
	proc0_7 7
	proc0_8 8
	SetFlag 9
	IsFlag 10
	ClearFlag 11
	Face 14
	proc0_15 15
	Say 16
	proc0_17 17
	ShowClock 18
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
	gWaitCursor = 20
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
	global39 = 3
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
	gMsgType
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	gLongSong
	global101 = 1
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
	gDay
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
	gTrunk
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
)

(procedure (NormalEgo param1 param2)
	(if (> argc 0)
		(if (!= param1 -1)
			(gEgo view: param1)
		)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	)
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: Walk
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
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
	(if (and (not (HaveMouse)) (!= global115 -1))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global115 global116)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
	(= global115 (= global116 -1))
)

(procedure (HaveMem param1) ; UNUSED
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (EgoDead param1 &tmp [temp0 80])
	(if (or (not argc) (== argc 1))
		(if (or (not argc) (< param1 0) (>= param1 32))
			(= param1 -1)
		)
		(= global151 param1)
		(gCurRoom newRoom: 877) ; deathRm
	else
		(Format @temp0 &rest)
		(repeat
			(switch
				(Print
					@temp0
					#mode
					1
					#button
					{Restore}
					1
					#button
					{Restart}
					2
					#button
					{    Quit    }
					3
				)
				(1
					(gGame restore:)
				)
				(2
					(gGame restart:)
				)
				(3
					(= gQuit 1)
					(break)
				)
			)
		)
	)
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param1))
		(+= gScore param2)
		(SetFlag param1)
		(rm0Sound priority: 15 number: 65 loop: 1 flags: 1 play:)
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
				(&= [global165 temp2] (~ temp3))
			)
			(0
				(|= [global165 temp2] temp3)
			)
			(3
				(^= [global165 temp2] temp3)
			)
		)
	)
	(return (& [global165 temp2] temp3))
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

(procedure (proc0_15 param1 param2)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (and (> param2 15) (!= param2 31))
		(= param2 15)
	)
	(return (if (IsFlag 2) param1 else param2))
)

(procedure (proc0_7)
	(egoHead init: gEgo view: (gEgo view:) cycleSpeed: 60)
)

(procedure (proc0_8 &tmp [temp0 3] temp3 temp4 temp5 [temp6 5])
	(= temp3 (gGame setCursor: 69 1))
	(= temp4 (User curEvent:))
	(redX x: (temp4 x:) y: (+ 300 (temp4 y:)) z: 300 show:)
	(redXList add: redX)
	(Animate (redXList elements:) 1)
	(Animate (gCast elements:) 0)
	(= temp5 (GetTime))
	(while (< (Abs (- temp5 (GetTime))) 40)
		(breakif (OneOf ((= temp4 (Event new:)) type:) evKEYBOARD evMOUSEBUTTON))
		(temp4 dispose:)
	)
	(if (IsObject temp4)
		(temp4 dispose:)
	)
	(redX hide: posn: 1000 -1000)
	(Animate (redXList elements:) 1)
	(redXList delete: redX)
	(gGame setCursor: temp3)
)

(procedure (Say param1 &tmp [temp0 4] temp4 [temp5 200])
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Animate (gCast elements:) 0)
	(= temp4 SpeakWindow)
	(temp4 speakObj: [param1 0])
	(Wait 30)
	(if (u< [param1 1] 1000)
		(GetFarText [param1 1] [param1 2] @temp5)
	else
		(StrCpy @temp5 [param1 1])
	)
	(Print @temp5 #window temp4 #dispose)
)

(procedure (proc0_17 param1 &tmp temp0)
	(if (not argc)
		(= param1 0)
	)
	(= temp0 0)
	(= temp0 (/ param1 60))
	(= param1 (mod param1 60))
	(+= global105 temp0)
	(+= global106 param1)
	(if (> (++ global106) 59)
		(-= global106 59)
		(if (> (++ global105) 23)
			(= global105 0)
		)
	)
	(if (>= global105 24)
		(-= global105 24)
	)
)

(procedure (ShowClock param1 param2 param3 &tmp [temp0 3] temp3 temp4)
	(if (and argc param1)
		(= temp3 10)
		(= temp4 10)
		(if (and (>= argc 2) (!= param2 -1))
			(= temp3 param2)
		)
		(if (and (>= argc 3) (!= param3 -1))
			(= temp3 param3)
		)
		(Format ; "%s%d%s%d"
			@temp0
			0
			5
			(if (< global105 10) {0} else {})
			global105
			(if (< global106 10) {0} else {})
			global106
		)
		(= global157
			(Display @temp0 dsCOORD (+ temp3 2) (+ temp4 1) dsALIGN alLEFT dsFONT 500 dsCOLOR 0 dsSAVEPIXELS)
		)
		(= global156
			(Display @temp0 dsCOORD temp3 temp4 dsALIGN alLEFT dsFONT 500 dsCOLOR global137 dsSAVEPIXELS)
		)
		(clockSound setLoop: 3 play: 63)
	else
		(Display 0 6 dsRESTOREPIXELS global156)
		(Display 0 6 dsRESTOREPIXELS global157)
	)
)

(instance ego of Body
	(properties
		description {Sonny Bonds}
		sightAngle 180
		lookStr {It's you, Sonny.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(if (and (gEgo has: 9) (>= gCurRoomNum 55)) ; judicialOrder
							((gInventory at: 1) ; gun
								state: (not ((gInventory at: 1) state:)) ; gun
							)
							(if ((gInventory at: 1) state:) ; gun
								((gTheIconBar at: 4) cursor: 50)
								((gInventory at: 1) cursor: 50) ; gun
							else
								((gTheIconBar at: 4) cursor: 15)
								((gInventory at: 1) cursor: 15) ; gun
							)
						else
							(Print 0 0) ; "You can't pull your gun here, Bonds."
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoHead of Head
	(properties
		description {Sonny Bonds}
		lookStr {It's you, Sonny.}
	)

	(method (doVerb theVerb invItem)
		(gEgo doVerb: theVerb invItem)
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

(instance longSong of Sound
	(properties)
)

(instance redX of View
	(properties
		view 942
	)
)

(instance redXList of List
	(properties)
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

(instance pq3Win of BorderWindow
	(properties)

	(method (open)
		(if (not (HaveMouse))
			(= global182 (gGame setCursor: 69 1))
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

(instance invWin of InsetWindow
	(properties)
)

(instance pq3 of Game
	(properties)

	(method (init)
		PolyPath
		Polygon
		PQRoom
		(ScriptID 982)
		(ScriptID 883) ; MISSING EXPORT
		(super init:)
		(= gVersion {x.yyy.zzz})
		(= gEgo ego)
		((ScriptID 879 0) doit: pq3Win invWin gcWin) ; initCode
		((= gKeyDownHandler kDHandler) add:)
		((= gMouseDownHandler mDHandler) add:)
		((= gDirectionHandler dirHandler) add:)
		(= gPMouse PseudoMouse)
		(redXList add:)
		(= gFtrInitializer FtrInit)
		(= gDoVerbCode DoVerbCode)
		(gEgo
			head: egoHead
			moveSpeed: (self egoMoveSpeed:)
			cycleSpeed: (self egoMoveSpeed:)
		)
		((= gLongSong longSong) owner: self priority: 15 init:)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon5 icon8 icon9 icon6
			eachElementDo: #init
			eachElementDo: #highlightColor global137
			eachElementDo: #lowlightColor (proc0_15 global123 global120)
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			activateHeight: -1
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(gTheIconBar disable: 8)
		(Inv
			init:
			add:
				compRequest
				gun
				handcuff
				theKeys
				flashlight
				musicBox
				photo
				camera
				warrant
				judicialOrder
				calibration
				envelope
				toiletPaper
				gunKey
				battery
				flares
				nightStick
				knife
				patMemo
				wallet
				ticketBook
				compCard
				tracker
				license
				ticket
				cultBook
				miltaryRecord
				murderFile
				noteBook
				necklace
				whitePaint
				goldPaint
				bronzeStar
				skinHair
				cultRing
				article
				rose
				locket
				busCard
				scraper
				toothpick
				bloodHair
				sampleEnv
				remoteControl
				invLook
				invSelect
				invHelp
				invOk
			eachElementDo: #highlightColor global137
			eachElementDo: #lowlightColor global155
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: invOk
		)
		(wallet state: 4)
		(gEgo get: 1 19 2) ; gun
		(GameControls
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
				(iconAbout theObj: (ScriptID 878 0) selector: #doit yourself:) ; aboutCode
			helpIconItem: iconHelp
			curIcon: iconRestore
			eachElementDo: #highlightColor global137
			eachElementDo: #lowlightColor (proc0_15 global122 global120)
		)
		(self newRoom: 99) ; speedTest
	)

	(method (setSpeed param1)
		(if (not (User canControl:))
			(return)
		)
		(if argc
			(if (< (= egoMoveSpeed param1) 0)
				(= egoMoveSpeed 0)
			)
			(if (> egoMoveSpeed 15)
				(= egoMoveSpeed 15)
			)
			(gEgo cycleSpeed: param1 moveSpeed: param1)
		)
		(return egoMoveSpeed)
	)

	(method (startRoom param1)
		(if gPMouse
			(gPMouse stop:)
		)
		(DisposeScript 699)
		(DisposeScript 941)
		(cond
			((OneOf param1 12 13 14 15 16 17 18 19 20 21 22 23 24)
				(ScriptID 891) ; station
			)
			((OneOf param1 1 2 3 5)
				(ScriptID 127) ; intro
			)
			((== param1 25)
				(ScriptID 130) ; carStuff
				(if (== gDay 1)
					(ScriptID 132) ; carDay1Reg
				else
					(ScriptID 133) ; carDayXReg
				)
			)
		)
		(ScriptID 699) ; MISSING EXPORT
		(super startRoom: param1)
		(if (gCast contains: gEgo)
			(if (not (gEgo looper:))
				(gEgo setLoop: stopGroop)
			)
			(proc0_7)
			(egoHead y: 1000)
		)
		(redX init: hide: setPri: 15 posn: 1000 -1000)
	)

	(method (quitGame)
		(super quitGame: (Print 0 1 #button {QUIT} 1 #button {PLAY} 0)) ; "Going off duty?"
	)

	(method (restart)
		(if (Print 0 2 #button {RESTART} 1 #button {PLAY} 0) ; "You want to start over?"
			(super restart:)
		)
	)

	(method (pragmaFail)
		(if (User canInput:)
			(proc0_8)
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
						(if (not (& (icon5 signal:) $0004))
							(icon5 select:)
						)
						(event claimed: 1)
					)
					(KEY_SHIFTTAB
						(if (not (& (icon5 signal:) $0004))
							(icon5 select:)
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
						(if (IsFlag 3)
							(Print 0 3) ; "You can't save right now."
						else
							(gGame save:)
						)
						(event claimed: 1)
					)
					(KEY_F7
						(if (IsFlag 3)
							(Print 0 4) ; "You can't restore right now."
						else
							(gGame restore:)
						)
						(event claimed: 1)
					)
					(KEY_F9
						(gGame restart:)
						(event claimed: 1)
					)
					(KEY_ADD
						(gGame setSpeed: (- (gGame egoMoveSpeed:) 1))
					)
					(KEY_SUBTRACT
						(gGame setSpeed: (+ (gGame egoMoveSpeed:) 1))
					)
					($003d ; =
						(gGame setSpeed: 3)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance clockSound of Sound
	(properties
		number 700
	)
)

(instance invOk of IconI
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		cursor 999
		signal 67
		helpStr 11387
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120)
		)
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 19
		message 2
		helpStr {Select this Icon then select an inventory item you'd like a description of.}
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120)
		)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 29
		message 6
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120)
		)
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr {Allows you to select an item.}
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120)
		)
		(super init:)
	)
)

(instance compRequest of InvI
	(properties
		view 700
		cel 5
		cursor 1
		signal 2
		description {A Computer ID request form.}
		owner 20
	)
)

(instance gun of InvI
	(properties
		view 700
		loop 2
		cel 12
		cursor 15
		signal 2
		description {Your Baretta nine millimeter handgun.}
	)
)

(instance handcuff of InvI
	(properties
		view 700
		loop 2
		cel 11
		cursor 2
		description {Your handcuffs are made of stainless steel.}
		owner 16
	)
)

(instance theKeys of InvI
	(properties
		view 700
		loop 2
		cel 13
		cursor 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf ; "You have %s"
					0
					7
					(cond
						((& state $0002) {the nut's keys.})
						((& state $0008)
							(cond
								((& state $0001) {Pat's keys and the duplicate key.})
								((& state $0004) {Rocklin's keys and the duplicate key.})
								((& state $0008) {the duplicate key.})
							)
						)
						((& state $0001) {Pat's keys.})
						((& state $0004) {Rocklin's keys.})
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance flashlight of InvI
	(properties
		view 700
		loop 2
		cel 7
		cursor 18
		description {Your regulation flashlight.}
		owner 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(14 ; battery
						(Print 0 8) ; "You put the batteries in the flashlight."
						(self state: 1)
						(Inv hide:)
						(gEgo put: 14 0) ; battery
						(SetScore 127 2)
						(Inv curIcon: invSelect showSelf: gEgo)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance musicBox of InvI
	(properties
		view 700
		cel 10
		cursor 14
		description {Music box.}
		owner 40
	)
)

(instance photo of InvI
	(properties
		view 700
		loop 4
		cel 6
		cursor 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 0 9 #icon 546 0 0) ; "You shudder again as you look at the photograph of Jessie and Michael Bains."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance camera of InvI
	(properties
		view 700
		loop 4
		cel 1
		cursor 11
		description {Camera.}
		owner 881
	)
)

(instance warrant of InvI
	(properties
		view 700
		cel 5
		cursor 5
		description {Search warrant.}
	)
)

(instance judicialOrder of InvI
	(properties
		view 700
		loop 2
		cel 5
		cursor 3
		description {judicial order.}
	)
)

(instance calibration of InvI
	(properties
		view 700
		loop 2
		cel 2
		cursor 4
		description {Calibration chart.}
	)
)

(instance envelope of InvI
	(properties
		view 700
		cel 8
		cursor 16
		description {A manila envelope.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 0 10) ; "Inside the the envelope you find:  A cult ring.  A cult book.  Marie's locket. You remove these and discard the envelope."
				(Inv hide:)
				(gEgo put: 11 get: 25 34 37) ; envelope, cultBook
				(Inv curIcon: 0 showSelf: gEgo)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance toiletPaper of InvI
	(properties
		view 700
		loop 2
		cel 4
		cursor 17
		description {Toilet paper.}
		owner 16
	)
)

(instance gunKey of InvI
	(properties
		view 700
		loop 4
		cel 10
		cursor 21
		description {Gun locker key.}
		owner 12
	)
)

(instance battery of InvI
	(properties
		view 700
		loop 4
		cel 2
		cursor 22
		description {Flashlight batteries.}
		owner 15
	)
)

(instance flares of InvI
	(properties
		view 700
		cel 12
		cursor 23
		description {Highway flares.}
		owner 15
	)
)

(instance nightStick of InvI
	(properties
		view 700
		loop 4
		cel 5
		cursor 25
		description {PR24 night stick.}
		owner 16
	)
)

(instance knife of InvI
	(properties
		view 700
		loop 2
		cursor 26
		description {A knife.}
		owner 28
	)
)

(instance patMemo of InvI
	(properties
		view 700
		cel 6
		cursor 27
		description {It's the complaint form that was filed against Officer Morales.}
		owner 20
	)
)

(instance wallet of InvI
	(properties
		view 700
		loop 4
		cel 11
		cursor 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(switch state
					(1
						(Print 0 11) ; "You have $2.50"
					)
					(2
						(Print 0 12) ; "You have $5.00"
					)
					(3
						(Print 0 13) ; "You have $7.50"
					)
					(4
						(Print 0 14) ; "You have $10.00"
					)
					(else
						(Print 0 15) ; "You're flat broke!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ticketBook of InvI
	(properties
		view 700
		cel 13
		cursor 30
		description {Ticket book.}
		owner 16
	)
)

(instance compCard of InvI
	(properties
		view 700
		loop 4
		cel 4
		cursor 34
		description {Computer access card.}
	)
)

(instance tracker of InvI
	(properties
		view 700
		loop 4
		cel 12
		cursor 35
		description {Electronic tracking device.}
	)
)

(instance license of InvI
	(properties
		view 700
		loop 2
		cel 3
		cursor 36
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch state
					(1
						(Print 0 16) ; "This is Juan Ruiz's license - #434301."
					)
					(2
						(Print 0 17) ; "This is Orpheus' license - #522341."
					)
					(3
						(Print 0 18) ; "This is the drunk' ID card."
					)
					(4
						(Print 0 19) ; "This is Brian Forbes's license - #789612."
					)
					(5
						(Print 0 20) ; "This is Andrew Dent's license - 980453."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(28 ; noteBook
						(if (== ((gInventory at: 23) state:) 5) ; license
							(SetFlag 82)
						else
							(super doVerb: theVerb invItem)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance ticket of InvI
	(properties
		view 700
		loop 2
		cel 1
		cursor 37
		description {A ticket.}
	)
)

(instance cultBook of InvI
	(properties
		view 700
		cel 2
		cursor 38
		description {Cult book.}
	)
)

(instance miltaryRecord of InvI
	(properties
		view 700
		cursor 39
		description {Michael Bains' military record.}
	)
)

(instance murderFile of InvI
	(properties
		view 700
		cursor 39
		description {Murder file.}
	)
)

(instance noteBook of InvI
	(properties
		view 700
		loop 2
		cel 6
		cursor 40
		description {Note Book.}
		owner 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(23 ; license
						(if (and (OneOf gCurRoomNum 45 46) (not (IsFlag 82)))
							(Print 0 21) ; "You log Andrew Dent's license information in your notebook."
							(SetFlag 82)
						else
							(Print 0 22) ; "You already have the information in your notebook."
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance necklace of InvI
	(properties
		view 700
		cel 7
		cursor 41
		description {A broken chain.}
	)
)

(instance whitePaint of InvI
	(properties
		view 700
		loop 4
		cel 9
		cursor 32
		description {Sample envelope with a white paint sample in it.}
	)
)

(instance goldPaint of InvI
	(properties
		view 700
		loop 4
		cel 8
		cursor 32
		description {Sample envelope with a gold paint sample in it.}
	)
)

(instance skinHair of InvI
	(properties
		view 700
		loop 4
		cel 7
		cursor 32
		description {Sample envelope with skin & hair samples in it.}
	)
)

(instance bloodHair of InvI
	(properties
		view 700
		loop 4
		cel 7
		cursor 32
		description {Sample envelope with blood & hair samples in it.}
	)
)

(instance sampleEnv of InvI
	(properties
		view 700
		loop 4
		cel 13
		cursor 32
		description {Empty sample envelopes.}
		owner 881
	)
)

(instance bronzeStar of InvI
	(properties
		view 700
		loop 2
		cel 10
		cursor 42
		description {On the back of the bronze star is a number:\n       09987.}
		owner 30
	)
)

(instance cultRing of InvI
	(properties
		view 700
		cel 1
		cursor 43
		description {Cult ring.}
	)
)

(instance article of InvI
	(properties
		view 700
		cel 3
		cursor 44
		description {News article about you.  A pentagram has been drawn over your face}
	)
)

(instance rose of InvI
	(properties
		view 700
		cel 9
		cursor 45
		description {A rose.}
	)
)

(instance locket of InvI
	(properties
		view 700
		cel 11
		cursor 46
		description {Marie's locket.}
	)
)

(instance busCard of InvI
	(properties
		view 700
		loop 2
		cel 9
		cursor 47
		description {The reporter's business card.\nHis phone number is 555-0707.}
	)
)

(instance scraper of InvI
	(properties
		view 700
		cel 14
		cursor 31
		description {Scraper for evidence gathering.}
		owner 881
	)
)

(instance toothpick of InvI
	(properties
		view 700
		loop 4
		cel 14
		cursor 48
		description {Toothpicks for evidence gathering.}
		owner 881
	)
)

(instance remoteControl of InvI
	(properties
		view 700
		loop 4
		cel 15
		cursor 51
		description {TV Remote Control}
		owner 56
	)
)

(instance icon0 of IconI
	(properties
		view 900
		loop 0
		cel 0
		cursor 6
		message 1
		signal 65
		helpStr {This icon is for walking.}
		maskView 900
		maskLoop 10
	)
)

(instance icon1 of IconI
	(properties
		view 900
		loop 1
		cel 0
		cursor 19
		message 2
		signal 65
		helpStr {This icon is for looking.}
		maskView 900
		maskLoop 10
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 2
		cel 0
		cursor 20
		message 3
		signal 65
		helpStr {This icon is for doing.}
		maskView 900
		maskLoop 10
		maskCel 1
	)
)

(instance icon3 of IconI
	(properties
		view 900
		loop 3
		cel 0
		cursor 7
		message 5
		signal 65
		helpStr {This icon is for talking.}
		maskView 900
		maskLoop 10
		maskCel 2
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 4
		signal 65
		helpStr {This icon shows the currently selected inventory item.}
		maskView 900
		maskLoop 10
		maskCel 3
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
		helpStr {This icon displays the inventory window.}
		maskView 900
		maskLoop 10
		maskCel 4
	)

	(method (select)
		(if (super select: &rest)
			(if (IsObject gTrunk)
				(gTrunk cue: 0)
			)
			(Animate (gCast elements:) 0)
			(Inv showSelf: gEgo)
			(if (IsObject gTrunk)
				(gTrunk cue: 1)
			)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 8
		cel 0
		cursor 999
		signal 67
		helpStr {This icon displays your current score.}
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (show &tmp [temp0 7] [temp7 4] temp11)
		(super show: &rest)
		(= temp11 30)
		(Format @temp0 0 23 gScore gPossibleScore) ; "%d of %d"
		(TextSize @temp7 @temp0 temp11 0)
		(Display
			@temp0
			dsCOLOR
			global137
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
		helpStr {This icon displays the control panel.}
		maskView 900
		maskLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(GameControls show:)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 900
		loop 9
		cel 0
		cursor 29
		message 6
		signal 3
		helpStr {This icon tells you about other icons.}
		maskView 900
		maskLoop 10
		maskCel 1
	)
)

(instance DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 (param2 description:))
		(switch param1
			(2
				(if (param2 facingMe: gEgo)
					(if (param2 lookStr:)
						(Print (param2 lookStr:))
					else
						(proc0_8)
					)
				)
			)
			(else
				(proc0_8)
			)
		)
	)
)

(instance FtrInit of Code
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

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp [temp0 11] temp11 [temp12 20])
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
		signal 640
		helpStr {The graphics detail level.}
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
		helpStr {Overall sound volume.}
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
		signal 640
		helpStr {The speed at which Sonny moves.}
		sliderView 947
		yStep 2
		bottomValue 15
	)

	(method (doit param1)
		(if argc
			(gGame egoMoveSpeed: param1)
			(gEgo
				moveSpeed: (gGame egoMoveSpeed:)
				cycleSpeed: (gGame egoMoveSpeed:)
			)
		)
		(gGame egoMoveSpeed:)
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
		signal 451
		helpStr {Allows you to save your game.}
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
		helpStr {Allows you to restore a previously saved game.}
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
		helpStr {Allows you to restart the game.}
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
		helpStr {Allows you to quit the game.}
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
		helpStr {Information about the game.}
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 8
		nsTop 106
		cursor 29
		message 6
		signal 387
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
		helpStr {Returns you to the game.}
	)
)

