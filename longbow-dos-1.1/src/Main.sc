;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n013)
(use RhIconItem)
(use Interface)
(use n802)
(use rhEgo)
(use Denomination)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use Osc)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	Longbow 0
	statLine 1
	NormalEgo 2
	HandsOff 3
	HandsOn 4
	IsFlag 5
	SetFlag 6
	ClearFlag 7
	Face 9
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gMachineSpeedZeroOrSix = 6
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
	gRgnMusic
	global101 = 1234
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	gEgoEdgeHit
	gEgoHead
	; 110
	global110
	global111
	gForestRoomNum
	gSFX
	gSFX2
	; 115
	global115
	global116
	global117
	global118 = 1
	global119 = 2
	; 120
	global120 = 1
	global121 = 5
	global122 = 4
	global123
	global124
	; 125
	global125 = 2
	gDisguiseNum
	global127
	global128
	global129
	; 130
	gDay = 1
	global131
	global132
	gPennies
	gHapennies
	; 135
	gFarthings
	global136
	gForestSweepRoomCount
	gOutlaws = 50
	gRansom = 2000
	; 140
	global140
	global141 = 4
	global142
	global143
	global144
	; 145
	gDeathNum
	global146
	global147 = 140
	global148
	global149
	; 150
	global150
	global151
	gMoney
	global153
	global154
	; 155
	gRoomCount
	global156
	global157
	global158
	global159
	; 160
	gBlowCount
	gEgoBeard
	global162 = 180
	global163 = 7
	global164
	; 165
	global165
	global166
	global167
	gRgnMusic2
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
)

(procedure (NormalEgo param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0
		(switch gDisguiseNum
			(1 36) ; beggar
			(2 29) ; jewler (no rouge)
			(3 29) ; jewler (rouge)
			(4 33) ; yeoman
			(5 23) ; abbey monk
			(6 16) ; fens monk
			(else 0)
		)
	)
	(= temp1
		(switch gDisguiseNum
			(1 37) ; beggar
			(2 30) ; jewler (no rouge)
			(3 30) ; jewler (rouge)
			(4 34) ; yeoman
			(5 24) ; abbey monk
			(6 17) ; fens monk
			(else 1)
		)
	)
	(if argc
		(gEgo loop: param1)
		(if (> argc 1)
			(= temp0 param2)
			(if (> argc 2)
				(= temp1 param3)
			)
		)
	)
	(= temp2
		(switch (gEgo loop:)
			(6 45)
			(0 90)
			(4 135)
			(2 180)
			(5 225)
			(1 270)
			(7 315)
		)
	)
	(gEgo
		view: temp0
		normal:
			(if
				(OneOf
					temp0
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
				1
			else
				0
			)
		abnormal: (OneOf gDisguiseNum 3 2) ; jewler (rouge), jewler (no rouge)
		moveHead:
			(if
				(OneOf
					temp0
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
				1
			else
				0
			)
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setCycle: StopWalk temp1
		setStep: 3 2
		illegalBits: -32768
		ignoreActors: 0
		heading: temp2
	)
	(cond
		(
			(not
				(OneOf
					(gEgo view:)
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
			)
			(egoHead dispose:)
		)
		((gCast contains: egoHead)
			(egoHead normalize:)
		)
		((gCast contains: gEgo)
			(localproc_0)
		)
	)
	(cond
		((not (OneOf gDisguiseNum 3 2)) ; jewler (rouge), jewler (no rouge)
			(egoBeard dispose:)
		)
		((gCast contains: gEgo)
			(localproc_1)
		)
	)
	(if (and (OneOf gDisguiseNum 0 4) (not global143)) ; outlaw, yeoman
		(gTheIconBar enable: 4)
	else
		(gTheIconBar disable: 4)
	)
)

(procedure (HandsOff &tmp temp0)
	(if global143
		(return)
	)
	(= global143 1)
	(User canControl: 0 canInput: 0)
	(= temp0 (gTheIconBar curIcon:))
	(= global157 (gGame egoMoveSpeed:))
	(= global165 0)
	(gTheIconBar eachElementDo: #perform checkIcon)
	(gTheIconBar disable: 0 1 2 3 4 5 6 7)
	(gTheIconBar curIcon: temp0)
	(if (HaveMouse)
		(gGame setCursor: gWaitCursor 1)
	else
		(= global127 ((User curEvent:) x:))
		(= global128 ((User curEvent:) y:))
		(gGame setCursor: gWaitCursor 1 310 185)
	)
)

(procedure (HandsOn param1 &tmp temp0 temp1)
	(if global143
		(= global143 0)
		(gGame setSpeed: global157)
		(= global157 global141)
		(User canControl: 1 canInput: 1)
	)
	(if (and argc param1)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (not (& global165 (>> $8000 temp0)))
				(gTheIconBar enable: temp0)
			)
		)
	else
		(if (gTheIconBar curInvIcon:)
			(gTheIconBar enable: (gTheIconBar useIconItem:))
		)
		(gTheIconBar enable: 0 1 2 3 7)
		(if (OneOf gDisguiseNum 0 4) ; outlaw, yeoman
			(gTheIconBar enable: 4)
		)
		(if (OneOf gCurRoomNum 100 260 630 450)
			(gTheIconBar disable: 2 3 4 5 6 7)
		)
		(if
			(OneOf
				gCurRoomNum
				260
				220 ; forest
				110
				120
				150
				180
				190
				210
				250
				590
				600
				580
				450
				440
				350
				390
				270
				280
				290
				300
				310
				455
				460
				470
				480
				45 ; hedge4
				640
				280
				290
				300
				310
			)
			(gTheIconBar enable: 5)
		)
	)
	(if
		(and
			(not (gTheIconBar curInvIcon:))
			(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
		)
		(gTheIconBar advanceCurIcon:)
	)
	(if (HaveMouse)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global127 global128)
	)
)

(procedure (IsFlag param1)
	(return (& [global200 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global200 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global200 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
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
	(cond
		((> (Abs (- temp0 (gEgo heading:))) 23)
			(param1 setHeading: temp0 (and (IsObject temp3) temp3))
		)
		((IsObject temp3)
			(temp3 cue:)
		)
	)
)

(procedure (localproc_0)
	((= gEgoHead egoHead)
		view:
			(if (OneOf (gEgo view:) 1 13 30 34 24 17 703)
				(gEgo view:)
			else
				(+ (gEgo view:) 1)
			)
		init: gEgo
		cycleSpeed: 180
		normalize:
	)
)

(procedure (localproc_1)
	((= gEgoBeard egoBeard)
		init: gEgo
		view: (if (== gDisguiseNum 3) 77 else 76) ; jewler (rouge)
	)
)

(instance ego of rhEgo
	(properties)

	(method (init)
		(super init:)
		(if
			(and
				(OneOf
					view
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
				(not (gCast contains: egoHead))
				normal
			)
			(localproc_0)
		)
		(if
			(and
				(OneOf gDisguiseNum 3 2) ; jewler (rouge), jewler (no rouge)
				(not (gCast contains: egoBeard))
				abnormal
			)
			(localproc_1)
		)
	)

	(method (doVerb theVerb invItem)
		((ScriptID 804) doit: theVerb invItem) ; egoSez
	)
)

(instance egoHead of Head
	(properties
		view 1
	)
)

(instance egoBeard of Beard
	(properties
		view 77
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance rgnMusic of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance rgnMusic2 of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance SFX of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance SFX2 of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance moneySound of Sound
	(properties
		flags 1
		number 914
	)
)

(instance stopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler:) vWalking:))
		)
		(super doit: &rest)
	)
)

(instance money of Money
	(properties
		view 771
		loop 5
		keepStr {KEEP}
		giveStr {GIVE}
		number 0
		title {My Purse}
	)

	(method (doit)
		(moneySound play:)
		(super doit: &rest)
	)
)

(instance pennies of Denomination
	(properties
		value 4
	)
)

(instance hapennies of Denomination
	(properties
		value 2
	)
)

(instance farthings of Denomination
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

(instance rhWindow of SysWindow
	(properties)
)

(instance statLine of Code
	(properties)

	(method (doit &tmp [temp0 70] [temp70 100] [temp170 8] [temp178 12] [temp190 10] [temp200 6] [temp206 4] [temp210 4] [temp214 4] [temp218 4] [temp222 4] temp226)
		(StrCpy @temp170 {Ransom: })
		(StrCpy @temp178 {_____Outlaws: })
		(StrCpy @temp190 {_____Score: })
		(Format @temp200 0 0 gRansom) ; "%u"
		(Format @temp206 0 1 gOutlaws) ; "%d"
		(Format @temp210 0 1 gScore) ; "%d"
		(StrCpy @temp214 { of })
		(Format @temp218 0 1 gPossibleScore) ; "%d"
		(Format ; "%s%s%s%s%s%s%s%s"
			@temp0
			0
			2
			@temp170
			@temp200
			@temp178
			@temp206
			@temp190
			@temp210
			@temp214
			@temp218
		)
		(TextSize @temp222 @temp0 0 -1)
		(StrCpy @temp70 {\06})
		(for
			((= temp226 (/ (- 326 (- [temp222 3] [temp222 1])) 2)))
			(> temp226 0)
			((-- temp226))
			
			(StrCat @temp70 {\06})
		)
		(StrCat @temp70 @temp0)
		(DrawStatus @temp70 global182 0)
	)
)

(instance quitIcon of DCIcon
	(properties
		view 903
		cycleSpeed 18
	)

	(method (init)
		((= cycler (Osc new:)) init: self 1)
	)
)

(instance Longbow of Game
	(properties)

	(method (init &tmp temp0 temp1)
		StopWalk
		PolyPath
		Polygon
		(ScriptID 982)
		(proc802_0)
		(super init:)
		(= gDoVerbCode DoVerbCode)
		(= gFtrInitializer FtrInit)
		((= gMouseDownHandler MH) add:)
		((= gKeyDownHandler KH) add:)
		((= gDirectionHandler DH) add:)
		((= gEgo ego)
			_head: (= gEgoHead egoHead)
			beard: (= gEgoBeard egoBeard)
		)
		((gEgo _head:) client: gEgo)
		((gEgo beard:) client: gEgo)
		(User alterEgo: gEgo)
		(rgnMusic2 owner: self init:)
		(rgnMusic owner: self init:)
		(SFX owner: self init:)
		(SFX2 owner: self init:)
		(= gRgnMusic2 rgnMusic2)
		(= gRgnMusic rgnMusic)
		(= gSFX SFX)
		(= gSFX2 SFX2)
		((= gTheIconBar IconBar)
			add:
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconBow
				iconMap
				iconUse
				iconInvSel
				iconControl
				iconWhat
			eachElementDo: #init
			eachElementDo: #highlightColor global184
			curIcon: iconWalk
			useIconItem: iconUse
			helpIconItem: iconWhat
			disable:
		)
		(iconInvSel message: (if (HaveMouse) 3840 else 9))
		(GameControls
			window: gcWindow
			add:
				(detailSlider
					theObj: self
					selector: #detailLevel
					yStep: 5
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					topValue: (if (> (DoSound sndGET_POLYPHONY) 1) 15 else 1)
					yourself:
				)
				(moveSpeedSlider
					theObj: self
					selector: #setSpeed
					yStep: 5
					yourself:
				)
				(arcadeSlider yStep: 5 yourself:)
				(iconSave
					theObj: self
					selector: #save
					lowlightColor: global179
					yourself:
				)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart
					theObj: self
					selector: #restart
					lowlightColor: global181
					yourself:
				)
				(iconQuit
					theObj: self
					selector: #quitGame
					lowlightColor: global174
					yourself:
				)
				(iconAbout
					theObj: (ScriptID 809 0) ; aboutCode
					selector: #doit
					lowlightColor: global178
					yourself:
				)
				(iconOk lowlightColor: global180)
				(iconHelp lowlightColor: global177)
			eachElementDo: #highlightColor global184
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(gInventory
			normalHeading: {I am carrying}
			empty: {nothing.}
			init:
			add:
				bucks
				horn
				halfHeart
				slipper
				net
				pipe
				gems
				jewels
				rouge
				message
				fireRing
				cask
				puzzleBox
				robes
				amethyst
				comb
				fulkScroll
				handScroll
				waterRing
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor global184
			eachElementDo: #lowlightColor global170
			window: invWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(= temp0 (if (<= 2 (Graph grGET_COLOURS) 16) global184 else global174))
		(= temp1 (if (<= 2 (Graph grGET_COLOURS) 16) global182 else global187))
		(invLook lowlightColor: temp1 highlightColor: temp0)
		(invHand lowlightColor: temp1 highlightColor: temp0)
		(invSelect lowlightColor: temp1 highlightColor: temp0)
		(invHelp lowlightColor: temp1 highlightColor: temp0)
		(ok lowlightColor: temp1 highlightColor: temp0)
		(= gFarthings farthings)
		(= gHapennies hapennies)
		(= gPennies pennies)
		((= gMoney money)
			color: global184
			owner: gEgo
			init: gPennies gHapennies gFarthings
		)
		((ScriptID 808 0) doit: rhWindow gcWindow invWindow) ; initGame
	)

	(method (setSpeed param1)
		(if argc
			(gEgo
				moveSpeed: (= egoMoveSpeed param1)
				cycleSpeed: egoMoveSpeed
			)
		)
		(return egoMoveSpeed)
	)

	(method (replay)
		(statLine doit:)
		(super replay:)
	)

	(method (restart &tmp temp0)
		(if (IsObject gModelessDialog)
			(if (IsObject (= temp0 (gModelessDialog caller:)))
				(gModelessDialog caller: 0)
			)
			(gModelessDialog dispose:)
		)
		(repeat
			(switch
				(Print ; "Do you truly wish to start from the beginning again?"
					0
					3
					#title
					{RESTART}
					#mode
					1
					#button
					{Aye, start from scratch.}
					1
					#button
					{Nay, go back to where I was.}
					2
					#icon
					quitIcon
					1
					0
				)
				(1
					(super restart:)
				)
				(2
					(if (IsObject temp0)
						(temp0 cue:)
					)
					(return)
				)
			)
		)
	)

	(method (quitGame)
		(super
			quitGame:
				(if (== gCurRoomNum 97) ; theEnd
					(Print ; "Alas, we sorrow to see you leave us. Mayhap you wish to try your luck again?"
						0
						4
						#title
						{QUIT}
						#button
						{Farewell, I must go.}
						1
						#button
						{Let me tarry here a while longer.}
						0
						#icon
						quitIcon
						0
						0
					)
				else
					(Print ; "Alas, must you leave the merry greenwood so soon?"
						0
						5
						#title
						{QUIT}
						#button
						{Farewell, I must go.}
						1
						#button
						{Let me tarry here a while longer.}
						0
						#icon
						quitIcon
						0
						0
					)
				)
		)
	)

	(method (pragmaFail &tmp temp0 [temp1 31])
		(if gModelessDialog
			(gModelessDialog dispose:)
			(return 1)
		)
		(return
			(and
				(User canInput:)
				(switch (= temp0 ((User curEvent:) message:))
					(2
						(Say 1000 75 1) ; "I see nothing of interest."
					)
					(3
						(Say 1000 76 1) ; "I needn't do anything with that."
					)
					(5
						(Say 1000 77 1) ; "There is no answer."
					)
					(10
						(Say 1000 78 1) ; "I've no need to shoot at that."
					)
					(4
						(Say 1000 79 1) ; "That would serve no purpose."
					)
				)
			)
		)
	)

	(method (newRoom)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: &rest)
	)

	(method (startRoom roomNum)
		((ScriptID 808 1) doit: roomNum) ; startUpRoom
		(super startRoom: roomNum)
		(if (not (OneOf roomNum 97 98 96 95 803)) ; theEnd, logo, cred, open, speedTest
			(statLine doit:)
		)
		(if (and (User controls:) (User input:))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		)
	)

	(method (handleEvent event &tmp [temp0 2] [temp2 10])
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_TAB
					(if
						(not
							(or global143 (& ((gTheIconBar at: 7) signal:) $0004))
						)
						(gInventory showSelf:)
					)
				)
				(KEY_SHIFTTAB
					(if
						(not
							(or global143 (& ((gTheIconBar at: 7) signal:) $0004))
						)
						(gInventory showSelf:)
					)
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
					(if
						(not
							(or
								(& ((gTheIconBar at: 8) signal:) $0004)
								(& (gTheIconBar state:) $0004)
							)
						)
						(if (and (IsObject gFastCast) (gFastCast elements:))
							(return)
						)
						(gGame save:)
						(event claimed: 1)
					)
				)
				(KEY_F7
					(if
						(not
							(or
								(& ((gTheIconBar at: 8) signal:) $0004)
								(& (gTheIconBar state:) $0004)
							)
						)
						(if (and (IsObject gFastCast) (gFastCast elements:))
							(return)
						)
						(gGame restore:)
						(event claimed: 1)
					)
				)
				(KEY_F9
					(gGame restart:)
					(event claimed: 1)
				)
				(KEY_ADD
					(if (User controls:)
						(gGame
							setSpeed:
								(Max 1 (- (gGame egoMoveSpeed:) 1))
						)
					)
				)
				(KEY_SUBTRACT
					(if (User controls:)
						(gGame setSpeed: (+ (gGame egoMoveSpeed:) 1))
					)
				)
				($003d ; =
					(if (User controls:)
						(gGame setSpeed: global141)
					)
				)
				(else
					(Format @temp2 0 6 800) ; "%d.scr"
					(if (and global102 (FileIO fiEXISTS @temp2))
						((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
					)
				)
			)
		)
		(if (not (event claimed:))
			(super handleEvent: event)
		)
	)
)

(instance iconWalk of RhIconItem
	(properties
		view 781
		loop 0
		cel 0
		cursor 0
		message 1
		signal 65
		helpStr {This icon is for walking.}
		maskView 781
		maskLoop 10
	)
)

(instance iconLook of RhIconItem
	(properties
		view 781
		loop 1
		cel 0
		cursor 1
		message 2
		signal 65
		helpStr {This icon is for looking.}
		maskView 781
		maskLoop 10
	)
)

(instance iconDo of RhIconItem
	(properties
		view 781
		loop 2
		cel 0
		cursor 2
		message 3
		signal 65
		helpStr {This icon is for doing.}
		maskView 781
		maskLoop 10
	)
)

(instance iconTalk of RhIconItem
	(properties
		view 781
		loop 3
		cel 0
		cursor 3
		message 5
		signal 65
		helpStr {This icon is for talking.}
		maskView 781
		maskLoop 10
	)
)

(instance iconBow of RhIconItem
	(properties
		view 781
		loop 4
		cel 0
		cursor 4
		message 10
		signal 65
		helpStr {This icon is for using your longbow.}
		maskView 781
		maskLoop 10
	)
)

(instance iconMap of RhIconItem
	(properties
		view 781
		loop 5
		cel 0
		cursor 5
		message 11
		signal 67
		helpStr {This icon will take you back to the map.}
		maskView 781
		maskLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((== gCurRoomNum 220) ; forest
					(SetFlag 170)
					(gCurRoom newRoom: 100)
				)
				(
					(OneOf
						gCurRoomNum
						260
						220 ; forest
						110
						120
						150
						180
						190
						210
						250
						590
						600
						580
					)
					(gCurRoom newRoom: 100)
				)
				((OneOf gCurRoomNum 450 440 350 390 270 280 290 300 310)
					(gCurRoom newRoom: 260)
				)
				((OneOf gCurRoomNum 455 460 470 480 45) ; hedge4
					(gCurRoom newRoom: 450)
				)
				((OneOf gCurRoomNum 640)
					(gCurRoom newRoom: 630)
				)
				(else
					(Say 1000 6) ; "*** You shouldn't be able to use the map here!"
				)
			)
		)
	)
)

(instance iconUse of RhIconItem
	(properties
		view 781
		loop 6
		cel 0
		cursor 999
		message 4
		signal 65
		helpStr {This icon selects the current inventory item.}
		maskView 781
		maskLoop 10
		maskCel 1
	)
)

(instance iconInvSel of RhIconItem
	(properties
		view 781
		loop 7
		cel 0
		cursor 2
		type 0
		message 0
		signal 67
		helpStr {This icon brings up the inventory window.}
		maskView 781
		maskLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(gInventory showSelf:)
		)
	)
)

(instance iconControl of RhIconItem
	(properties
		view 781
		loop 8
		cel 0
		cursor 999
		signal 67
		helpStr {This icon brings up the control panel.}
		maskView 781
		maskLoop 10
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(SetMessageColor 0)
			(GameControls show:)
		)
	)
)

(instance iconWhat of RhIconItem
	(properties
		view 781
		loop 9
		cel 0
		cursor 6
		message 6
		signal 3
		helpStr {This icon allows you to find out what the other icons do.}
		maskView 781
		maskLoop 10
	)
)

(instance ok of IconI
	(properties
		view 900
		loop 3
		cel 0
		nsLeft 40
		cursor 999
		signal 67
		helpStr {Select this icon to resume playing the game.}
		lowlightColor 5
	)

	(method (select)
		(if (super select: &rest)
			(if (not (gems cel:))
				(gems owner: gEgo loop: 2 cel: 7)
			)
			(if (== (fulkScroll cel:) 3)
				(fulkScroll cel: 2)
			)
			(if (== (handScroll cel:) 5)
				(handScroll cel: 4)
			)
			(if (== (message cel:) 7)
				(message cel: 6)
			)
			(if (== (rouge cel:) 14)
				(rouge cel: 13)
			)
			(if (jewels loop:)
				(jewels loop: 0 cel: 15)
			)
			(return 1)
		)
	)
)

(instance invLook of IconI
	(properties
		view 900
		loop 2
		cel 0
		cursor 1
		message 2
		helpStr {Select this icon to get a description of one of the objects you are carrying.}
		lowlightColor 5
	)
)

(instance invHand of IconI
	(properties
		view 900
		loop 0
		cel 0
		cursor 2
		message 3
		helpStr {Selecting this icon will allow you to do something with one of the objects you are carrying.}
		lowlightColor 5
	)
)

(instance invHelp of IconI
	(properties
		view 900
		loop 1
		cel 0
		cursor 6
		message 6
		lowlightColor 5
	)
)

(instance invSelect of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		helpStr {Use this icon to select an object to use in the game.}
		lowlightColor 5
	)
)

(instance bucks of InvI
	(properties
		view 771
		loop 2
		cel 3
		cursor 104
		signal 2
	)

	(method (doVerb theVerb &tmp [temp0 12] [temp12 15] [temp27 15] [temp42 3] [temp45 6] [temp51 55])
		(switch (gPennies number:)
			(0
				(Format @temp0 0 7)
			)
			(1
				(Format @temp0 0 8) ; "1 penny"
			)
			(else
				(Format @temp0 0 9 (gPennies number:)) ; "%d pennies"
			)
		)
		(switch (gHapennies number:)
			(0
				(Format @temp12 0 7)
			)
			(1
				(Format @temp12 0 10) ; "1 ha'penny"
			)
			(else
				(Format @temp12 0 11 (gHapennies number:)) ; "%d ha'pennies"
			)
		)
		(switch (gFarthings number:)
			(0
				(Format @temp27 0 7)
			)
			(1
				(Format @temp27 0 12) ; "1 farthing"
			)
			(else
				(Format @temp27 0 13 (gFarthings number:)) ; "%d farthings"
			)
		)
		(cond
			((and (gPennies number:) (gHapennies number:) (gFarthings number:))
				(Format @temp42 0 14) ; ","
				(Format @temp45 0 15) ; ", and"
			)
			(
				(and
					(gPennies number:)
					(gHapennies number:)
					(not (gFarthings number:))
				)
				(Format @temp42 0 16) ; "and"
				(Format @temp45 0 7)
			)
			(
				(and
					(gPennies number:)
					(not (gHapennies number:))
					(gFarthings number:)
				)
				(Format @temp42 0 7)
				(Format @temp45 0 16) ; "and"
			)
			(
				(and
					(not (gPennies number:))
					(gHapennies number:)
					(gFarthings number:)
				)
				(Format @temp42 0 7)
				(Format @temp45 0 16) ; "and"
			)
			(else
				(Format @temp42 0 7)
				(Format @temp45 0 7)
			)
		)
		(switch theVerb
			(2 ; Look
				(proc13_1
					(Format @temp51 0 17 @temp0 @temp42 @temp12 @temp45 @temp27) ; "I have %s%s%s%s%s."
				)
			)
			(3 ; Do
				(Say 1000 16) ; "It is good to have silver in one's purse."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance horn of InvI
	(properties
		view 771
		loop 2
		cel 5
		cursor 100
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 17) ; "With this horn I can summon my men in time of need."
			)
			(3 ; Do
				(Say 1000 18) ; "It feels smooth and worn from much use."
			)
		)
	)
)

(instance halfHeart of InvI
	(properties
		view 771
		cel 10
		cursor 127
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 19) ; "It is half a heart, carved of emerald."
			)
			(3 ; Do
				(Say 1000 20) ; "How warm and alive this gem feels!"
			)
		)
	)
)

(instance slipper of InvI
	(properties
		view 771
		cel 12
		cursor 121
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 21) ; "Marian's slipper is made of fine, soft leather."
			)
			(3 ; Do
				(Say 1000 22) ; "Would that I had the woman to touch and not merely her slipper."
			)
		)
	)
)

(instance net of InvI
	(properties
		view 771
		cursor 102
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 23) ; "The Widow's gift is a net made of gold."
			)
			(3 ; Do
				(Say 1000 24) ; "How fine and supple this golden mesh is."
			)
		)
	)
)

(instance pipe of InvI
	(properties
		view 771
		cel 1
		cursor 130
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 25) ; "'Tis a whistle, made from a marsh reed, which the Fens Monk was carrying."
			)
			(3 ; Do
				(Say 1000 26) ; "It is very light, hardly weighs a thing."
			)
		)
	)
)

(instance gems of InvI
	(properties
		view 771
		loop 2
		cel 7
		cursor 120
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== loop 2)
					(Say 1000 27) ; "It is the Fens Monk's pouch."
				else
					(Say 1000 28) ; "The Monk's pouch contains nine gemstones."
				)
			)
			(3 ; Do
				(gInventory hide:)
				(if cel
					(self owner: gGame loop: 4 cel: 0)
					(gInventory show: gGame)
				else
					(self owner: gEgo loop: 2 cel: 7)
					(gInventory show: gEgo)
				)
			)
		)
	)
)

(instance jewels of InvI
	(properties
		view 771
		cel 15
		cursor 132
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if loop
					(Say 1000 29) ; "One of the jeweler's most cunning pieces of work is this pennanular brooch."
				else
					(Say 1000 30) ; "The jeweler's samples are wrapped in red velvet."
				)
			)
			(3 ; Do
				(if loop
					(Say 1000 31) ; "I'll wrap the samples in the velvet again for protection."
					(= loop 0)
					(= cel 15)
				else
					(Say 1000 32) ; "I'll unwrap the velvet and have a look at the jeweler's samples."
					(= loop 2)
					(= cel 1)
				)
				(gInventory hide:)
				(gInventory show: gEgo)
			)
		)
	)
)

(instance rouge of InvI
	(properties
		view 771
		cel 13
		cursor 131
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== cel 13)
					(Say 1000 33) ; "It is a small, round wooden box which the jeweler carried with his goods."
				else
					(Say 1000 34) ; "Inside is a rough reddish powder called jeweler's rouge."
				)
			)
			(3 ; Do
				(gInventory hide:)
				(= cel (if (== cel 13) 14 else 13))
				(gInventory show: gEgo)
			)
		)
	)
)

(instance message of InvI
	(properties
		view 771
		cel 6
		cursor 123
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== cel 6)
					(Say 1000 35) ; "The letter the false Knight carried bears the Prior's seal."
				else
					(Say 1000 36) ; "The message reads: 'I have advised the Prince that we have succeeded in our mission. The cub is taken. The lion is caged.' It's signed by the Prior of the Monastery and addressed to the Sheriff of Nottingham."
				)
			)
			(3 ; Do
				(if (== cel 6)
					(Say 1000 37) ; "I'll open the false Knight's message."
					(= cel 7)
				else
					(Say 1000 38) ; "I'll close the false Knight's message."
					(= cel 6)
				)
				(gInventory hide:)
				(gInventory show: gEgo)
			)
		)
	)
)

(instance fireRing of InvI
	(properties
		view 771
		cel 11
		cursor 101
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 39) ; "The Ring That Commands Fire has a blazing ruby set in gold."
			)
			(3 ; Do
				(switch global115
					(0
						(Say 1000 40) ; "I feel the power of the Ring that Commands Fire upon my hand."
						(= global115 2)
						(SetFlag 168)
						(gInventory hide:)
						(= cel 8)
						(= loop 2)
						(gInventory show: gEgo)
					)
					(2
						(Say 1000 41) ; "I'll remove the Ring that Commands Fire and keep it out of sight until I need it."
						(= global115 0)
						(ClearFlag 168)
						(gInventory hide:)
						(= cel 11)
						(= loop 0)
						(gInventory show: gEgo)
					)
					(1
						(Say 1000 42) ; "Some power keeps me from donning both rings at once. As Fulk warned me, their natures are in conflict and refuse to be worn at the same time by one man."
					)
				)
			)
		)
	)
)

(instance cask of InvI
	(properties
		view 771
		loop 2
		cel 4
		cursor 128
		signal 2
		owner 460
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 43) ; "This cask has carried many mugs of ale."
			)
			(3 ; Do
				(Say 1000 44) ; "I'll leave the cask alone lest I break the tap."
			)
		)
	)
)

(instance puzzleBox of InvI
	(properties
		view 771
		loop 2
		cel 6
		cursor 126
		signal 2
		owner 460
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 45) ; "This wooden box is cleverly made. It is locked, but with no lock that I can see."
			)
			(3 ; Do
				(gInventory hide:)
				(gGame setScript: (ScriptID 853 1)) ; cursorPause
			)
		)
	)
)

(instance robes of InvI
	(properties
		view 771
		loop 2
		cursor 125
		signal 2
		owner 455
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 46) ; "These Abbey Monks have the softest of wool for their robes, and strong silk sashes for belts."
			)
			(3 ; Do
				(Say 1000 47) ; "I have the robes and belts folded as small as possible."
			)
		)
	)
)

(instance amethyst of InvI
	(properties
		view 771
		cel 9
		cursor 129
		signal 2
		owner 540
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 48) ; "'Tis a crystal of amethyst."
			)
			(3 ; Do
				(Say 1000 49) ; "The crystals are sharp-edged."
			)
		)
	)
)

(instance comb of InvI
	(properties
		view 771
		cel 8
		cursor 124
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 50) ; "'Tis a silver comb."
			)
			(3 ; Do
				(Say 1000 51) ; "The silver is cool to the touch."
			)
		)
	)
)

(instance fulkScroll of InvI
	(properties
		view 771
		cel 2
		cursor 133
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== cel 2)
					(Say 1000 52) ; "On this scroll are Fulk's scribbled bits of doggerel."
				else
					(gInventory hide:)
					(gGame setScript: (ScriptID 806 7)) ; verseScript
				)
			)
			(3 ; Do
				(if (gRegions contains: 625)
					(Say 1000 53) ; "I'd best keep this well hidden until I'm out of the Monastery."
				else
					(if (== cel 2)
						(= cel 3)
						(Say 1000 54) ; "I'll open Fulk's Scroll."
					else
						(= cel 2)
						(Say 1000 55) ; "I'll close Fulk's Scroll."
					)
					(gInventory hide:)
					(gInventory show: gEgo)
				)
			)
		)
	)
)

(instance handScroll of InvI
	(properties
		view 771
		cel 4
		cursor 122
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== cel 4)
					(Say 1000 56) ; "It is the scroll I took from the Scribes' room."
				else
					(Say 1000 57) ; "This scroll bears the outline of a hand."
				)
			)
			(3 ; Do
				(if (gRegions contains: 625)
					(Say 1000 58) ; "I'd best keep this well hidden until I'm out of the Monastery."
				else
					(if (== cel 4)
						(Say 1000 59) ; "I'll open the Hand Scroll."
						(= cel 5)
					else
						(Say 1000 60) ; "I'll close the Hand Scroll."
						(= cel 4)
					)
					(gInventory hide:)
					(gInventory show: gEgo)
				)
			)
		)
	)
)

(instance waterRing of InvI
	(properties
		view 771
		loop 2
		cel 2
		cursor 101
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1000 61) ; "Lapis lazuli is set in a ring of silver."
			)
			(3 ; Do
				(switch global115
					(0
						(Say 1000 62) ; "The Ring that Commands Water slips easily onto my finger."
						(= global115 1)
						(gInventory hide:)
						(= cel 9)
						(= loop 2)
						(gInventory show: gEgo)
					)
					(1
						(Say 1000 63) ; "I'll remove the Ring that Commands Water and keep it hidden from sight for now."
						(= global115 0)
						(gInventory hide:)
						(= loop (= cel 2))
						(gInventory show: gEgo)
					)
					(2
						(Say 1000 64) ; "Some power keeps me from donning both rings at once. As Fulk warned me, their natures are in conflict and refuse to be worn at the same time by one man."
					)
				)
			)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 950
		loop 0
		cel 1
		nsLeft 89
		nsTop 49
		signal 128
		helpStr {Raises and lowers the level of graphics detail (animation level).__Setting the slider to a low level may increase the speed of game play on slower machines.}
		sliderView 950
		topValue 3
	)
)

(instance volumeSlider of Slider
	(properties
		view 950
		loop 0
		cel 1
		nsLeft 135
		nsTop 49
		signal 128
		helpStr {Adjusts the overall sound volume (simply ON or OFF for single-voice systems, such as the IBM PC).}
		sliderView 950
		topValue 15
	)
)

(instance moveSpeedSlider of Slider
	(properties
		view 950
		loop 0
		cel 1
		nsLeft 181
		nsTop 49
		signal 128
		helpStr {Adjusts the speed of the game's animation (within the limits of your computer's capability).}
		sliderView 950
		bottomValue 15
		topValue 1
	)

	(method (show)
		(if (not (User controls:))
			(= signal 132)
			(= sliderLoop 9)
		else
			(= sliderLoop 0)
			(= signal 128)
		)
		(super show: &rest)
	)

	(method (move)
		(if (User controls:)
			(super move: &rest)
		)
	)

	(method (mask))
)

(instance arcadeSlider of Slider
	(properties
		view 950
		loop 0
		cel 1
		nsLeft 227
		nsTop 49
		signal 128
		helpStr {Adjusts the level of difficulty during arcade sequences.__Set the slider to its lowest level to "win" and bypass these sequences.}
		sliderView 950
		bottomValue 1
		topValue 22
	)

	(method (doit param1)
		(if argc
			(cond
				((<= param1 1)
					(= global125 1)
				)
				((<= param1 8)
					(= global125 2)
				)
				((<= param1 15)
					(= global125 3)
				)
				(else
					(= global125 4)
				)
			)
			(return param1)
		else
			(return global125)
		)
	)

	(method (valueToPosn &tmp temp0)
		(= temp0
			(switch global125
				(1 1)
				(2 7)
				(3 15)
				(4 22)
			)
		)
		(super valueToPosn: temp0)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 950
		loop 2
		cel 0
		nsLeft 25
		nsTop 26
		signal 451
		helpStr {Saves your current Game.}
		lowlightColor 52
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 950
		loop 3
		cel 0
		nsLeft 25
		nsTop 46
		signal 451
		helpStr {Restores a previously saved Game.}
		lowlightColor 60
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 950
		loop 4
		cel 0
		nsLeft 25
		nsTop 66
		signal 451
		helpStr {Restarts the Game from the beginning.}
		lowlightColor 42
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 950
		loop 5
		cel 0
		nsLeft 43
		nsTop 86
		signal 451
		helpStr {Quits the game.}
		lowlightColor 12
	)
)

(instance iconHelp of IconI
	(properties
		view 950
		loop 6
		cel 0
		nsLeft 25
		nsTop 106
		cursor 6
		message 6
		signal 387
		lowlightColor 4
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 950
		loop 8
		cel 0
		nsLeft 25
		nsTop 86
		signal 387
		helpStr {Information about the game.}
		lowlightColor 6
	)
)

(instance iconOk of IconI
	(properties
		view 950
		loop 7
		cel 0
		nsLeft 43
		nsTop 106
		signal 195
		helpStr {Resumes game play.}
		lowlightColor 34
	)
)

(instance gcWindow of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1)
		(= temp1 -1)
		(self top: 25 left: 26 bottom: 166 right: 296 priority: -1)
		(super open:)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel 950 1 2 0 0 temp1)
		(DrawCel 950 1 2 54 0 temp1)
		(DrawCel 950 1 2 108 0 temp1)
		(DrawCel 950 1 2 162 0 temp1)
		(DrawCel 950 1 2 216 0 temp1)
		(DrawCel 950 1 2 0 47 temp1)
		(DrawCel 950 1 2 54 47 temp1)
		(DrawCel 950 1 2 108 47 temp1)
		(DrawCel 950 1 2 162 47 temp1)
		(DrawCel 950 1 2 216 47 temp1)
		(DrawCel 950 1 2 0 94 temp1)
		(DrawCel 950 1 2 54 94 temp1)
		(DrawCel 950 1 2 108 94 temp1)
		(DrawCel 950 1 2 162 94 temp1)
		(DrawCel 950 1 2 216 94 temp1)
		(DrawCel 950 0 5 146 9 temp1)
		(DrawCel 950 1 1 14 17 temp1)
		(DrawCel 950 1 0 119 50 temp1)
		(DrawCel 950 1 0 165 50 temp1)
		(DrawCel 950 1 0 211 50 temp1)
		(DrawCel 950 0 4 85 33 temp1)
		(DrawCel 950 0 3 128 33 temp1)
		(DrawCel 950 0 2 180 33 temp1)
		(DrawCel 950 0 6 219 33 temp1)
		(Graph grUPDATE_BOX 0 0 (+ 94 (CelHigh 950 1 2)) (+ 216 (CelWide 950 1 2)) 1)
		(PicNotValid temp0)
	)
)

(instance invWindow of InsetWindow
	(properties
		priority -1
	)

	(method (dispose)
		(super dispose: &rest)
		(proc13_7)
	)
)

(instance DoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(cond
					((not (param2 lookStr:))
						(Say 1000 75 1) ; "I see nothing of interest."
					)
					((u>= (param2 lookStr:) 1000)
						(proc13_1 (param2 lookStr:))
					)
					(else
						(Say (+ gCurRoomNum 1000) (param2 lookStr:) 1)
					)
				)
			)
			(3
				(Say 1000 76 1) ; "I needn't do anything with that."
			)
			(5
				(Say 1000 77 1) ; "There is no answer."
			)
			(10
				(Say 1000 78 1) ; "I've no need to shoot at that."
			)
			(4
				(Say 1000 79 1) ; "That would serve no purpose."
			)
		)
	)
)

(instance FtrInit of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(cond
			((or (param1 x:) (param1 y:) (param1 z:)))
			((not (IsObject (= temp0 (param1 onMeCheck:))))
				(param1 x: (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
				(param1 y: (param1 nsTop:))
			)
			(else
				(= temp8 (= temp9 0))
				(= temp6 (= temp7 32767))
				(= temp2 (temp0 points:))
				(= temp1 0)
				(= temp3 (* 4 (temp0 size:)))
				(while (< temp1 temp3)
					(= temp4 (Memory memPEEK (+ temp2 temp1)))
					(= temp5 (Memory memPEEK (+ temp2 temp1 2)))
					(if (<= temp4 temp6)
						(= temp6 temp4)
					)
					(if (<= temp5 temp7)
						(= temp7 temp5)
					)
					(if (>= temp4 temp8)
						(= temp8 temp4)
					)
					(if (>= temp5 temp9)
						(= temp9 temp5)
					)
					(+= temp1 4)
				)
				(param1 x: (/ (+ temp6 temp8) 2))
				(param1 y: temp7)
			)
		)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global165 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

