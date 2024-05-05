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
	proc0_19 19
	proc0_20 20
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

(procedure (EgoDead param1 &tmp [temp0 120])
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
					{____Quit____}
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

(procedure (proc0_15 param1 param2 param3)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param3 0)
		(= param3 0)
	)
	(if (> param3 31)
		(= param3 31)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (and (> param2 15) (!= param2 31))
		(= param2 15)
	)
	(if (== global102 32)
		(return param3)
	)
	(if (== global102 256)
		(return param1)
	)
	(if (== global102 16)
		(return param2)
	)
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

(procedure (Say param1 &tmp [temp0 4] temp4 [temp5 300])
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
			6
			(if (< global105 10) {0} else {})
			global105
			(if (< global106 10) {0} else {})
			global106
		)
		(= global157
			(Display @temp0 dsCOORD (+ temp3 2) (+ temp4 1) dsALIGN alLEFT dsFONT 500 dsCOLOR 0 dsSAVEPIXELS)
		)
		(= global156
			(Display
				@temp0
				dsCOORD
				temp3
				temp4
				dsALIGN
				alLEFT
				dsFONT
				500
				dsCOLOR
				(proc0_15 global137 global183 global137)
				dsSAVEPIXELS
			)
		)
		(clockSound setLoop: 3 play: 63)
	else
		(Display 0 7 dsRESTOREPIXELS global156)
		(Display 0 7 dsRESTOREPIXELS global157)
	)
)

(procedure (proc0_19)
	(proc0_20 1026 1040 1051 1050 947)
)

(procedure (proc0_20 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(instance ego of Body
	(properties
		description {Sonny Bonds}
		sightAngle 180
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 0 0) ; "It's you, Sonny."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(cond
							((and (gEgo has: 9) (>= gCurRoomNum 55)) ; judicialOrder
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
							)
							((== gCurRoomNum 28)
								(super doVerb: theVerb)
							)
							(else
								(Print 0 1) ; "You can't pull your gun here, Bonds."
							)
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
	(properties
		printLang 0
	)

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
			eachElementDo:
				#lowlightColor
				(proc0_15 global123 global120 global120)
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
		(= global102 (Graph grGET_COLOURS))
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
				(iconAbout selector: #doit yourself:)
			helpIconItem: iconHelp
			curIcon: iconRestore
			eachElementDo: #highlightColor global137
			eachElementDo:
				#lowlightColor
				(proc0_15 global122 global120 global120)
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

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		(DisposeScript 699)
		(DisposeScript 941)
		(cond
			((OneOf roomNum 12 13 14 15 16 17 18 19 20 21 22 23 24)
				(ScriptID 891) ; station
			)
			((OneOf roomNum 1 2 3 5)
				(ScriptID 127) ; intro
			)
			((== roomNum 25)
				(ScriptID 130) ; carStuff
				(if (== gDay 1)
					(ScriptID 132) ; carDay1Reg
				else
					(ScriptID 133) ; carDayXReg
				)
			)
		)
		(ScriptID 699) ; MISSING EXPORT
		(super startRoom: roomNum)
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
		(super
			quitGame:
				(Print 0 2 #button {QUIT} 1 #button {PLAY} 0) ; "Going off duty?"
		)
	)

	(method (restart)
		(if (Print 0 3 #button {RESTART} 1 #button {PLAY} 0) ; "You want to start over?"
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
							(Print 0 4) ; "You can't save right now."
						else
							(gGame save:)
						)
						(event claimed: 1)
					)
					(KEY_F7
						(if (IsFlag 3)
							(Print 0 5) ; "You can't restore right now."
						else
							(gGame restore: &rest)
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

(class PQ3IconItem of IconI
	(properties
		helpModule 850
	)
)

(class PQ3Slider of Slider
	(properties
		helpModule 850
	)
)

(class PQ3ControlIcon of ControlIcon
	(properties
		helpModule 850
	)
)

(class PQ3InvItem of InvI
	(properties
		helpModule 849
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print helpModule description)
			)
		)
	)
)

(instance invOk of PQ3IconItem
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		cursor 999
		signal 67
		helpStr 1
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120 global120)
		)
		(super init:)
	)
)

(instance invLook of PQ3IconItem
	(properties
		view 901
		loop 2
		cel 0
		cursor 19
		message 2
		helpStr 2
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120 global120)
		)
		(super init:)
	)
)

(instance invHelp of PQ3IconItem
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
			lowlightColor: (proc0_15 global123 global120 global120)
		)
		(super init:)
	)
)

(instance invSelect of PQ3IconItem
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr 3
	)

	(method (init)
		(self
			highlightColor: global137
			lowlightColor: (proc0_15 global123 global120 global120)
		)
		(super init:)
	)
)

(instance compRequest of PQ3InvItem
	(properties
		view 700
		cel 5
		cursor 1
		signal 2
		description 1
		owner 20
	)
)

(instance gun of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 12
		cursor 15
		signal 2
		description 2
	)
)

(instance handcuff of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 11
		cursor 2
		description 3
		owner 16
	)
)

(instance theKeys of PQ3InvItem
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
					8
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
					(cond
						((& state $0002) {die Schl\81ssel des Verr\81ckten.})
						((& state $0008)
							(cond
								((& state $0001) {Pat's Schl\81ssel und dessen Duplikat.})
								((& state $0004) {Rocklin's Schl\81ssel und das Duplikat.})
								((& state $0008) {das Duplikat.})
							)
						)
						((& state $0001) {Pat's Schl\81ssel.})
						((& state $0004) {Rocklin's Schl\81ssel.})
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance flashlight of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 7
		cursor 18
		description 4
		owner 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(14 ; battery
						(Print 0 9) ; "You put the batteries in the flashlight."
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

(instance musicBox of PQ3InvItem
	(properties
		view 700
		cel 10
		cursor 14
		description 5
		owner 40
	)
)

(instance photo of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 6
		cursor 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 0 10 #icon 546 0 0) ; "You shudder again as you look at the photograph of Jessie and Michael Bains."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance camera of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 1
		cursor 11
		description 6
		owner 881
	)
)

(instance warrant of PQ3InvItem
	(properties
		view 700
		cel 5
		cursor 5
		description 7
	)
)

(instance judicialOrder of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 5
		cursor 3
		description 8
	)
)

(instance calibration of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 2
		cursor 4
		description 9
	)
)

(instance envelope of PQ3InvItem
	(properties
		view 700
		cel 8
		cursor 16
		description 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 0 11) ; "Inside the the envelope you find:  A cult ring.  A cult book.  Marie's locket. You remove these and discard the envelope."
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

(instance toiletPaper of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 4
		cursor 17
		description 11
		owner 16
	)
)

(instance gunKey of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 10
		cursor 21
		description 12
		owner 12
	)
)

(instance battery of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 2
		cursor 22
		description 13
		owner 15
	)
)

(instance flares of PQ3InvItem
	(properties
		view 700
		cel 12
		cursor 23
		description {Highway flares.}
		owner 15
	)
)

(instance nightStick of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 5
		cursor 25
		description 15
		owner 16
	)
)

(instance knife of PQ3InvItem
	(properties
		view 700
		loop 2
		cursor 26
		description 16
		owner 28
	)
)

(instance patMemo of PQ3InvItem
	(properties
		view 700
		cel 6
		cursor 27
		description 17
		owner 20
	)
)

(instance wallet of PQ3InvItem
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
						(Print 0 12) ; "You have $2.50"
					)
					(2
						(Print 0 13) ; "You have $5.00"
					)
					(3
						(Print 0 14) ; "You have $7.50"
					)
					(4
						(Print 0 15) ; "You have $10.00."
					)
					(else
						(Print 0 16) ; "You're flat broke!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ticketBook of PQ3InvItem
	(properties
		view 700
		cel 13
		cursor 30
		description 18
		owner 16
	)
)

(instance compCard of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 4
		cursor 34
		description 19
	)
)

(instance tracker of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 12
		cursor 35
		description 20
	)
)

(instance license of PQ3InvItem
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
						(Print 0 17) ; "This is Juan Ruiz's license - #434301."
					)
					(2
						(Print 0 18) ; "This is Orpheus' license - #522341."
					)
					(3
						(Print 0 19) ; "This is the drunk's ID card."
					)
					(4
						(Print 0 20) ; "This is Brian Forbes' license - #789612."
					)
					(5
						(Print 0 21) ; "This is Andrew Dent's license - 980453."
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

(instance ticket of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 1
		cursor 37
		description 21
	)
)

(instance cultBook of PQ3InvItem
	(properties
		view 700
		cel 2
		cursor 38
		description 22
	)
)

(instance miltaryRecord of PQ3InvItem
	(properties
		view 700
		cursor 39
		description 23
	)
)

(instance murderFile of PQ3InvItem
	(properties
		view 700
		cursor 39
		description 24
	)
)

(instance noteBook of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 6
		cursor 40
		description 25
		owner 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(23 ; license
						(if (and (OneOf gCurRoomNum 45 46) (not (IsFlag 82)))
							(Print 0 22) ; "You log Andrew Dent's license information in your notebook."
							(SetFlag 82)
						else
							(Print 0 23) ; "You already have the information in your notebook."
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

(instance necklace of PQ3InvItem
	(properties
		view 700
		cel 7
		cursor 41
		description 26
	)
)

(instance whitePaint of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 9
		cursor 32
		description 27
	)
)

(instance goldPaint of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 8
		cursor 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 2)
					(Print 0 24) ; "Sample envelope with a gold paint sample in it."
				else
					(Print 0 25) ; "Sample envelope with a light red paint sample in it."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance skinHair of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 7
		cursor 32
		description 28
	)
)

(instance bloodHair of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 7
		cursor 32
		description 29
	)
)

(instance sampleEnv of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 13
		cursor 32
		description 30
		owner 881
	)
)

(instance bronzeStar of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 10
		cursor 42
		description 31
		owner 30
	)
)

(instance cultRing of PQ3InvItem
	(properties
		view 700
		cel 1
		cursor 43
		description 32
	)
)

(instance article of PQ3InvItem
	(properties
		view 700
		cel 3
		cursor 44
		description 33
	)
)

(instance rose of PQ3InvItem
	(properties
		view 700
		cel 9
		cursor 45
		description 34
	)
)

(instance locket of PQ3InvItem
	(properties
		view 700
		cel 11
		cursor 46
		description 35
	)
)

(instance busCard of PQ3InvItem
	(properties
		view 700
		loop 2
		cel 9
		cursor 47
		description 36
	)
)

(instance scraper of PQ3InvItem
	(properties
		view 700
		cel 14
		cursor 31
		description 37
		owner 881
	)
)

(instance toothpick of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 14
		cursor 48
		description 38
		owner 881
	)
)

(instance remoteControl of PQ3InvItem
	(properties
		view 700
		loop 4
		cel 15
		cursor 51
		description 39
		owner 56
	)
)

(instance icon0 of PQ3IconItem
	(properties
		view 900
		loop 0
		cel 0
		cursor 6
		message 1
		signal 65
		helpStr 4
		maskView 900
		maskLoop 10
	)
)

(instance icon1 of PQ3IconItem
	(properties
		view 900
		loop 1
		cel 0
		cursor 19
		message 2
		signal 65
		helpStr 5
		maskView 900
		maskLoop 10
	)
)

(instance icon2 of PQ3IconItem
	(properties
		view 900
		loop 2
		cel 0
		cursor 20
		message 3
		signal 65
		helpStr 6
		maskView 900
		maskLoop 10
		maskCel 1
	)
)

(instance icon3 of PQ3IconItem
	(properties
		view 900
		loop 3
		cel 0
		cursor 7
		message 5
		signal 65
		helpStr 7
		maskView 900
		maskLoop 10
		maskCel 2
	)
)

(instance icon4 of PQ3IconItem
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 4
		signal 65
		helpStr 8
		maskView 900
		maskLoop 10
		maskCel 3
	)
)

(instance icon5 of PQ3IconItem
	(properties
		view 900
		loop 5
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		helpStr 9
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

(instance icon6 of PQ3IconItem
	(properties
		view 900
		loop 8
		cel 0
		cursor 999
		signal 67
		helpStr 10
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (show &tmp [temp0 20] [temp20 4] temp24)
		(super show: &rest)
		(= temp24 30)
		(Format @temp0 0 26 gScore gPossibleScore gScore gPossibleScore) ; "%d of %d"
		(TextSize @temp20 @temp0 temp24 0)
		(Display
			@temp0
			dsCOLOR
			global137
			dsFONT
			temp24
			dsCOORD
			(+ nsLeft 5 (/ (- 50 [temp20 3]) 2))
			(+ nsTop 14)
		)
	)
)

(instance icon8 of PQ3IconItem
	(properties
		view 900
		loop 7
		cel 0
		cursor 999
		message 6
		signal 67
		helpStr 11
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

(instance icon9 of PQ3IconItem
	(properties
		view 900
		loop 9
		cel 0
		cursor 29
		message 6
		signal 3
		helpStr 12
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

	(method (open &tmp [temp0 11] temp11 [temp12 5])
		(= temp11 -1)
		(self
			top: (/ (- 200 (+ (CelHigh (proc0_19) 1 1) 6)) 2)
			left:
				(/
					(-
						320
						(+
							151
							(CelWide (proc0_19) 0 1)
							(proc0_20 10 10 10 10 0)
						)
					)
					2
				)
			bottom:
				(+
					(CelHigh (proc0_19) 1 1)
					6
					(/ (- 200 (+ (CelHigh (proc0_19) 1 1) 6)) 2)
				)
			right:
				(+
					151
					(CelWide (proc0_19) 0 1)
					(proc0_20 10 10 10 10 0)
					(/
						(-
							320
							(+
								151
								(CelWide (proc0_19) 0 1)
								(proc0_20 10 10 10 10 0)
							)
						)
						2
					)
				)
			priority: temp11
		)
		(super open:)
		(DrawCel
			(proc0_19)
			0
			5
			(+
				(/
					(-
						(-
							(+
								151
								(CelWide (proc0_19) 0 1)
								(proc0_20 10 10 10 10 0)
							)
							(+ 4 (CelWide (proc0_19) 1 1))
						)
						(CelWide (proc0_19) 0 5)
					)
					2
				)
				4
				(CelWide (proc0_19) 1 1)
			)
			3
			temp11
		)
		(DrawCel (proc0_19) 1 1 4 3 temp11)
		(DrawCel (proc0_19) 1 0 94 38 temp11)
		(DrawCel (proc0_19) 1 0 135 38 temp11)
		(DrawCel
			(proc0_19)
			0
			4
			(- 67 (proc0_20 0 0 2 4 4))
			(- (- 37 (+ (CelHigh (proc0_19) 0 4) 3)) (proc0_20 -4 0 4 0 0))
			temp11
		)
		(DrawCel
			(proc0_19)
			0
			3
			(- 107 (proc0_20 3 6 6 6 6))
			(- (- 37 (+ (CelHigh (proc0_19) 0 4) 3)) (proc0_20 -4 0 4 0 0))
			temp11
		)
		(DrawCel
			(proc0_19)
			0
			2
			(- 147 (proc0_20 14 5 5 1 1))
			(- (- 37 (+ (CelHigh (proc0_19) 0 4) 3)) (proc0_20 -4 0 4 0 0))
			temp11
		)
		(Graph
			grUPDATE_BOX
			(+ (proc0_20 2 6 6 6 6) 6)
			1
			(+ (proc0_20 2 6 6 6 6) 6 3)
			(+ 151 (CelWide (proc0_19) 0 1) (proc0_20 10 10 10 10 0))
			1
		)
	)
)

(instance detailSlider of PQ3Slider
	(properties
		loop 0
		cel 1
		signal 640
		helpStr 13
		yStep 2
		topValue 3
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 67)
		(= nsTop 37)
		(= sliderView (proc0_19))
		(super show: &rest)
	)
)

(instance volumeSlider of PQ3Slider
	(properties
		loop 0
		cel 1
		signal 128
		helpStr 14
		yStep 2
		topValue 15
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 107)
		(= nsTop 37)
		(= sliderView (proc0_19))
		(super show: &rest)
	)
)

(instance speedSlider of PQ3Slider
	(properties
		loop 0
		cel 1
		signal 640
		helpStr 15
		yStep 2
		bottomValue 15
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 147)
		(= nsTop 37)
		(= sliderView (proc0_19))
		(super show: &rest)
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

(instance iconSave of PQ3ControlIcon
	(properties
		loop 2
		cel 0
		message 7
		signal 451
		helpStr 16
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 6)
		(super show: &rest)
	)
)

(instance iconRestore of PQ3ControlIcon
	(properties
		loop 3
		cel 0
		message 7
		signal 451
		helpStr 17
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 26)
		(super show: &rest)
	)
)

(instance iconRestart of PQ3ControlIcon
	(properties
		loop 4
		cel 0
		nsTop 46
		signal 451
		helpStr 18
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 46)
		(super show: &rest)
	)
)

(instance iconQuit of PQ3ControlIcon
	(properties
		loop 5
		cel 0
		message 7
		signal 451
		helpStr 19
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 66)
		(super show: &rest)
	)
)

(instance iconAbout of PQ3ControlIcon
	(properties
		loop 6
		cel 0
		message 7
		signal 451
		helpStr 20
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 106)
		(super show: &rest)
	)

	(method (select)
		(if (super select: &rest)
			((ScriptID 878 0) doit:) ; aboutCode
		)
	)
)

(instance iconHelp of PQ3IconItem
	(properties
		loop 7
		cel 0
		cursor 29
		message 6
		signal 387
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 34)
		(= nsTop 106)
		(super show: &rest)
	)
)

(instance iconOk of PQ3IconItem
	(properties
		loop 8
		cel 0
		message 7
		signal 451
		helpStr 21
	)

	(method (show)
		(= view (proc0_19))
		(= nsLeft 8)
		(= nsTop 86)
		(super show: &rest)
	)
)

