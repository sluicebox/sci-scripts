;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use n802)
(use RegionPath)
(use eRS)
(use SQEgo)
(use Elevator)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Grooper)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	sq1 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	StepOn 5
	IsFlag 6
	SetFlag 7
	ClearFlag 8
	proc0_9 9
	EgoDead 10
	SetScore 11
	proc0_12 12
	Face 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	SpiderList 18
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
	global101
	global102
	global103 = 1
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
	gEgoHead
	gStopGroop
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
	gLongSong2
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
	gBuckazoidCount = 3
	global166 = 1
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
	global176 = 12
	gSoundEffects
	global178 = 2000
	global179
	; 180
	global180
	global181
	global182
	global183 = 7000
	global184
	; 185
	global185
	global186
	global187
	global188
	global189
)

(procedure (NormalEgo param1 param2 param3 &tmp temp0)
	(= temp0 0)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2)
				(= temp0 param3)
			)
		)
	)
	(if (not temp0)
		(= temp0 60)
	)
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: StopWalk temp0
		setStep: 4 2
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 1
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
)

(procedure (HandsOff &tmp temp0)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 7 6 5 4 3 2 1 0)
	(gTheIconBar curIcon: temp0)
	(if (not (HaveMouse))
		(= global114 ((User curEvent:) x:))
		(= global115 ((User curEvent:) y:))
		(gGame setCursor: gWaitCursor 1 310 180)
	else
		(gGame setCursor: gWaitCursor 1)
	)
	(if gPMouse
		(gPMouse stop:)
	)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 0 1 2 3 4 5 6 7)
	(gEgo
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 6)
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global114 global115)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
)

(procedure (HaveMem param1) ; UNUSED
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (StepOn param1 param2) ; UNUSED
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (IsFlag param1)
	(return (& [global118 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global118 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global118 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (proc0_9 param1 &tmp temp0)
	(= temp0 0)
	(if argc
		(= temp0 param1)
	else
		(= temp0 60)
	)
	((= gEgoHead egoHead) init: gEgo view: temp0 cycleSpeed: 40)
)

(procedure (EgoDead param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 300])
	(gSounds eachElementDo: #stop)
	(if argc
		(= temp0 param1)
		(= temp1 param2)
		(= temp2 param3)
		(Format @temp3 &rest)
	else
		(= temp0 944)
		(= temp1 0)
		(= temp2 0)
		(Format @temp3 0 28) ; "Thank you for playing Space Quest I. Too bad you've failed miserably and doomed all of your people to a horrible death at the hands of the Sariens. You quickly glance about the room to see if anyone saw your silly mistake. Better luck next time."
	)
	(gLongSong number: 900 vol: 127 loop: 1 flags: 1 play:)
	(sq1 setCursor: gNormalCursor 1)
	(repeat
		(switch
			(Print
				@temp3
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
				#icon
				temp0
				temp1
				temp2
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

(procedure (SetScore param1 param2)
	(if (not (IsFlag param2))
		(gGame changeScore: param1)
		(SetFlag param2)
		(pointsSound play:)
	)
)

(procedure (proc0_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (== argc 1)
		(Display 0 29 dsRESTOREPIXELS [param1 0])
		(if (not (HaveMouse))
			(gGame setCursor: global113 1)
		)
	else
		(= temp4 (= temp5 -1))
		(= temp0 0)
		(= temp1 68)
		(= temp2 69)
		(= temp3 320)
		(= temp6 global130)
		(= temp7 0)
		(for ((= temp8 1)) (< temp8 argc) ((++ temp8))
			(switch [param1 temp8]
				(30
					(= temp0 [param1 (++ temp8)])
				)
				(33
					(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
				)
				(70
					(= temp3 [param1 (++ temp8)])
				)
				(67
					(= temp4 [param1 (++ temp8)])
					(= temp5 [param1 (++ temp8)])
				)
				(28
					(= temp6 [param1 (++ temp8)])
				)
				(29
					(= temp7 [param1 (++ temp8)])
				)
			)
		)
		(if (not (HaveMouse))
			(= global113 gTheCursor)
			(gGame setCursor: 69 1)
		)
		(= temp8
			(Display
				[param1 0]
				dsCOORD
				temp4
				temp5
				dsCOLOR
				temp7
				dsWIDTH
				temp3
				dsALIGN
				temp0
				dsFONT
				temp2
				dsSAVEPIXELS
			)
		)
		(Display
			[param1 0]
			dsCOORD
			temp4
			temp5
			dsCOLOR
			temp6
			dsWIDTH
			temp3
			dsALIGN
			temp0
			dsFONT
			temp1
		)
		(return temp8)
	)
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

(procedure (proc0_14 param1) ; UNUSED
	(StrCpy @param1 {__Space Quest I - The Sarien Encounter})
	(DrawStatus @param1 0 (proc0_17 global158 global155))
)

(procedure (proc0_15 &tmp temp0 [temp1 2] temp3 temp4 [temp5 5])
	(= global113 (gGame setCursor: 69 1))
	(= temp3 (User curEvent:))
	(redX x: (temp3 x:) y: (+ 300 (temp3 y:)) z: 300 show:)
	((= temp0 (List new:)) add: redX)
	(Animate (temp0 elements:) 1)
	(Animate (gCast elements:) 0)
	(= temp4 (GetTime))
	(while (< (Abs (- temp4 (GetTime))) 40)
		(breakif (OneOf ((= temp3 (Event new:)) type:) evKEYBOARD evMOUSEBUTTON))
		(temp3 dispose:)
	)
	(if (IsObject temp3)
		(temp3 dispose:)
	)
	(redX hide: posn: 1000 -1000)
	(Animate (temp0 elements:) 1)
	(temp0 delete: redX dispose:)
	(gGame setCursor: global113)
)

(procedure (localproc_0 param1 param2 param3 &tmp [temp0 30] [temp30 30] temp60 [temp61 100] [temp161 19] [temp180 30] [temp210 20])
	(= global113 (gGame setCursor: 69 1))
	(if (not (StrLen @gSysLogPath))
		(StrCpy @temp30 {})
		(GetInput @temp30 30 {Enter drive & directory for new response log...})
		(StrCpy @gSysLogPath @temp30)
	)
	(StrCpy @temp0 @gSysLogPath)
	(StrCat @temp0 {newresp.log})
	(if (IsObject param2)
		(StrCpy @temp180 (param2 name:))
	else
		(StrCpy @temp180 {Default Response})
	)
	(Format @temp61 0 30 gCurRoomNum @temp180 ((gTheIconBar curIcon:) helpStr:)) ; "New response: rm%03d %s  %s"
	(if (== param1 4)
		(StrCat @temp61 ((gTheIconBar curInvIcon:) name:))
		(StrCat @temp61 (Format @temp161 {\0d\n(switch theItem (%d} param3))
		(StrCat @temp61 {\0d\n})
	)
	(StrCpy @temp210 {})
	(if (== param1 4)
		(StrCpy @temp210 {verbUse})
	else
		(switch ((gTheIconBar curIcon:) cursor:)
			(19
				(StrCpy @temp210 {verbLook})
			)
			(20
				(StrCpy @temp210 {verbDo})
			)
			(7
				(StrCpy @temp210 {verbTalk})
			)
			(30
				(StrCpy @temp210 {verbSmell})
			)
			(31
				(StrCpy @temp210 {verbTaste})
			)
		)
	)
	(Format @temp161 0 31 @temp210) ; "(%s"
	(StrCat @temp61 @temp161)
	(StrCat @temp61 {\t\t\t(Print\0d\n})
	(StrCat @temp61 {\t\t\t\t"})
	(= temp60 (FileIO fiOPEN @temp0 0))
	(FileIO fiWRITE_STRING temp60 @temp61)
	(repeat
		(= temp61 0)
		(GetInput @temp61 50 {doVerb message:})
		(if (== (StrLen @temp61) 0)
			(FileIO fiWRITE_STRING temp60 {\0d\n\t\t\t\t"\0d\n})
			(FileIO fiWRITE_STRING temp60 {\t\t\t)\0d\n})
			(FileIO fiWRITE_STRING temp60 {\t\t)\0d\n})
			(FileIO fiWRITE_STRING temp60 {\t\t\0d\n\0d\n})
			(FileIO fiCLOSE temp60)
			(break)
		)
		(FileIO fiWRITE_STRING temp60 @temp61)
		(FileIO fiWRITE_STRING temp60 {\0d\n\t\t\t\t})
	)
	(gGame setCursor: global113)
)

(procedure (proc0_16 param1 param2 param3 &tmp [temp0 500]) ; UNUSED
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp0)
	else
		(StrCpy @temp0 param2)
	)
	(babbleIcon view: param1 cycleSpeed: (* (+ gHowFast 1) 4))
	(if (u< param2 1000)
		(Print @temp0 &rest #icon babbleIcon 0 0)
	else
		(Print @temp0 param3 &rest 82 babbleIcon 0 0)
	)
)

(procedure (proc0_17 param1 param2)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (> param2 15)
		(= param2 15)
	)
	(return (if (not (<= 2 global105 16)) param1 else param2))
)

(instance ego of SQEgo
	(properties
		description {Roger Wilco}
		sightAngle 180
		lookStr {It's you, Roger Wilco, janitor sub-extraordinaire.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 0 0) ; "You talk to yourself and, as usual, learn nothing that you didn't already know."
			)
			(3 ; Do
				(Print 0 1) ; "Hey! One shouldn't attempt to manipulate one's self in a family game."
			)
			(11 ; Taste
				(Print 0 2) ; "Better not. You're likely to get a fur ball."
			)
			(12 ; Smell
				(Print 0 3) ; "The odor you're producing causes you to regret skipping last month's shower."
			)
			(4 ; Inventory
				(switch invItem
					(5 ; Dehydrated_Water
						(cond
							((gCurRoom script:)
								(Print 0 4) ; "You're too busy right now."
							)
							(
								(OneOf
									gCurRoomNum
									37
									18
									19
									20
									21
									22
									23
									24
									25
									26
									27
								)
								(gCurRoom setScript: (ScriptID 704 4)) ; drinkScript
							)
							(else
								(Print 0 5) ; "Better save it for when you're thirsty."
							)
						)
					)
					(13 ; Grenade
						(Print 0 6) ; "You don't want to do that here."
					)
					(11 ; Jetpack
						(if (== gCurRoomNum 51)
							(Print 0 7) ; "You wisely strap on the jetpack to allow your self motion control."
						else
							(Print 0 8) ; "The jetpack is useful only in Zero-G situations."
						)
					)
					(4 ; Knife
						(Print 0 9) ; "Don't bother. This knife wouldn't cut hot lard."
					)
					(else
						(switch (Random 1 5)
							(1
								(Print 0 10) ; "Isn't this just the most amazing waste of time?"
							)
							(2
								(Print 0 11) ; "You have to wonder why you're performing such a useless action."
							)
							(3
								(Print 0 12) ; "You wisely decide this is a serious waste of time and energy."
							)
							(4
								(Print 0 13) ; "You ask yourself why you're doing this and are forced to reply that you just don't know."
							)
							(5
								(Print 0 14) ; "Even for you, this isn't bright."
							)
						)
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
		description {Roger Wilco}
		lookStr {This is your brain take-out container.}
		view 60
	)

	(method (doVerb theVerb invItem)
		(gEgo doVerb: theVerb invItem)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance invSound of Sound
	(properties
		flags 1
	)
)

(instance soundEffects of Sound
	(properties)

	(method (check)
		(DoSound sndUPDATE_CUES self)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(cond
				((> (self loop:) 1)
					(self loop: (- (self loop:) 1))
					(DoSound sndPLAY self 0)
				)
				((IsObject client)
					(client cue: self)
				)
			)
		)
	)
)

(instance pointsSound of Sound
	(properties
		flags 1
		number 901
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

(instance babbleIcon of DCIcon
	(properties)

	(method (init)
		((= cycler (RandCycle new:)) init: self 20)
	)
)

(instance sq1KeyDownHandler of EventHandler
	(properties)
)

(instance sq1MouseDownHandler of EventHandler
	(properties)
)

(instance sq1DirectionHandler of EventHandler
	(properties)
)

(instance sq1 of Game
	(properties)

	(method (init &tmp temp0)
		(= global187 0)
		(= gSystemWindow sq1Win)
		(proc802_0)
		(= gStopGroop stopGroop)
		(= global186 (Random 1 20))
		(= gUseSortedFeatures 1)
		(= global112 (SpiderList add:))
		StopWalk
		Polygon
		PolyPath
		SQRoom
		IconBar
		Inv
		(ScriptID 982)
		RandCycle
		(super init: &rest)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode sq1DoVerbCode)
		(= gFtrInitializer sq1FtrInit)
		((= gKeyDownHandler sq1KeyDownHandler) add:)
		((= gMouseDownHandler sq1MouseDownHandler) add:)
		((= gDirectionHandler sq1DirectionHandler) add:)
		(= gPMouse PseudoMouse)
		(self egoMoveSpeed: 5 setSpeed: 0)
		((= gEgo ego)
			_head: (= gEgoHead egoHead)
			moveSpeed: (self egoMoveSpeed:)
			cycleSpeed: (self egoMoveSpeed:)
		)
		(gEgoHead client: gEgo)
		(User canControl: 0 canInput: 0 alterEgo: gEgo)
		((= gLongSong longSong) owner: self init: flags: 1)
		((= gLongSong2 longSong2) owner: self init:)
		(= gSoundEffects soundEffects)
		(= gVersion {x.yyy})
		(= gWaitCursor 997)
		(= gPossibleScore 201)
		(= gUserFont 4)
		(= global106 (DoSound sndGET_POLYPHONY))
		(= global105 (Graph grGET_COLOURS))
		(sq1Win
			color: 0
			back: (proc0_17 global158 global155)
			topBordColor: global130
			lftBordColor: (proc0_17 global159 global130)
			rgtBordColor: (proc0_17 global157 global156)
			botBordColor: global156
		)
		(gcWin
			color: 0
			back: (proc0_17 global158 global155)
			topBordColor: global130
			lftBordColor: (proc0_17 global159 global130)
			rgtBordColor: (proc0_17 global157 global156)
			botBordColor: global156
		)
		(invWin
			topBordHgt: 4
			botBordHgt: 25
			color: 0
			priority: -1
			back: (proc0_17 global156 global155)
			topBordColor: (proc0_17 global158 global130)
			lftBordColor: (proc0_17 global157 global130)
			rgtBordColor: (proc0_17 global155 global156)
			botBordColor: (proc0_17 global155 global156)
			insideColor: (proc0_17 global155 global156)
			topBordColor2: global129
			lftBordColor2: global129
			botBordColor2: (proc0_17 global158 global130)
			rgtBordColor2: (proc0_17 global159 global129)
		)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon6 icon7 icon4 icon5 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (proc0_17 global158 global155)
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(Inv
			init:
			add:
				Cartridge
				keyCard
				Gadget
				Survival_Kit
				Knife
				Dehydrated_Water
				Broken_Glass
				Rock
				Orat_Part
				Skimmer_Key
				buckazoid
				Jetpack
				Pulseray_Laser_Pistol
				Grenade
				Remote
				Widget
				Plant
				Bar_Coupon
				Droids_B_Us_coupon
				Sarien_ID_Card
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (proc0_17 global155 global156)
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(GameControls
			window: gcWin
			add:
				iconOk
				(detailSlider
					theObj: self
					selector: #detailLevel
					topValue: 3
					yStep: (- 3 gHowFast)
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					topValue: (if (> global106 1) 15 else 1)
					bottomValue: 0
					yStep: (- 3 gHowFast)
					yourself:
				)
				(speedSlider
					theObj: speedORama
					selector: #doit
					yStep: (- 3 gHowFast)
					yourself:
				)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 811 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (proc0_17 global157 global156)
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(buckazoid owner: gEgo)
		(= global107 (if (GameIsRestarting) 4 else 1))
		(self newRoom: 803) ; speedTest
	)

	(method (pragmaFail)
		(if (User canInput:)
			(if (and global187 (IsFlag 0))
				(localproc_0)
			else
				(proc0_15)
			)
		)
	)

	(method (replay)
		(Palette palSET_INTENSITY 0 255 100)
		(super replay:)
	)

	(method (quitGame)
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(super
			quitGame:
				(Print ; "Thank you for playing Space Quest I. You've been most entertaining."
					0
					15
					#button
					{Let me out of here!\n(Quit)}
					1
					#button
					{I don't know WHAT\nI was thinking.\nLet's Play!}
					0
					#icon
					babbleIcon
					0
					0
				)
		)
	)

	(method (restart)
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(if
			(Print ; "Are you sure you want to restart?"
				0
				16
				#button
				{Of course I'm sure!}
				1
				#button
				{Changed My Mind.\nLet's Play!}
				0
				#icon
				babbleIcon
				0
				0
			)
			(super restart:)
		)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		(gSounds eachElementDo: #perform soundReset)
		((ScriptID 801) doit: roomNum) ; disposeCode
		(if
			(and
				global187
				global185
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print 0 17 #button {Who cares} 0 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(redX init: hide: setPri: 15 posn: 1000 -1000)
		(if gDebugOn
			(SetDebug)
		)
		(cond
			((OneOf roomNum 3 4 5 6 7 8 9 10 11 12 13 103)
				Elevator
				(ScriptID 700) ; arcadaRegion
			)
			((OneOf roomNum 37 18 19 20 21 22 23 24 25 26 27)
				(ScriptID 704) ; keronaRegion
			)
			((OneOf roomNum 54 55 57 58 59 60 61 62 63 64 65 66 67)
				Elevator
				RegionPath
				(ScriptID 703) ; DeltaurRegion
				(= global102 703)
			)
			(else 0)
		)
		(if (OneOf roomNum 3 35 40 41 42 43 45 46 58 59 60 61 62 63 64 66 68)
			RandCycle
		)
		(if (and global187 (not (OneOf roomNum 999)))
			((ScriptID 800) init:) ; MISSING SCRIPT
		)
		(super startRoom: roomNum)
		(if (gCast contains: gEgo)
			(if
				(and
					(gEgo normal:)
					(not ((gEgo cycler:) isKindOf: StopWalk))
				)
				(gEgo
					setCycle:
						StopWalk
						(switch (gEgo view:)
							(0 60)
							(1 61)
							(416 65)
							(2 62)
						)
				)
			)
			(if (not (gEgo looper:))
				(gEgo setLoop: stopGroop)
			)
			(proc0_9 (egoHead view:))
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
							(Inv showSelf: gEgo)
						)
					)
					(KEY_SHIFTTAB
						(if (not (& (icon5 signal:) $0004))
							(Inv showSelf: gEgo)
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(KEY_F1
						(GameControls show:)
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
						(gGame save:)
						(event claimed: 1)
					)
					(KEY_F7
						(gGame restore:)
						(event claimed: 1)
					)
					(KEY_F9
						(gGame restart:)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance soundReset of Code
	(properties)

	(method (doit param1)
		(if (and (== (param1 prevSignal:) -1) (param1 number:))
			(param1 number: 0)
		)
	)
)

(instance speedORama of Code
	(properties)

	(method (doit param1)
		(if argc
			(gGame egoMoveSpeed: param1)
			(if (User canControl:)
				(gEgo
					moveSpeed: (gGame egoMoveSpeed:)
					cycleSpeed: (gGame egoMoveSpeed:)
				)
			)
		)
		(gGame egoMoveSpeed:)
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		cursor 999
		signal 67
		helpStr {Select this Icon to close this window.}
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (proc0_17 global158 global155))
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
		(self highlightColor: 0 lowlightColor: (proc0_17 global158 global155))
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 20
		message 3
		helpStr {This allows you to do something to an item.}
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (proc0_17 global158 global155))
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
		(self highlightColor: 0 lowlightColor: (proc0_17 global158 global155))
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr {This allows you to select an item.}
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (proc0_17 global158 global155))
		(super init:)
	)
)

(class RInvItem of InvI
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (== (Inv at: invItem) self)
					(Print 0 18) ; "What did you expect them to do, reproduce?"
				else
					(Print view invItem 0)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance Cartridge of RInvItem
	(properties
		view 551
		cursor 1
		signal 2
		description {It's a cartridge from the Arcada's Data Archive.}
		owner 3
	)
)

(instance keyCard of RInvItem
	(properties
		view 550
		cursor 2
		signal 2
		description {This keycard fits an electronic lock someplace on the Arcada.}
		owner 5
	)
)

(instance Gadget of RInvItem
	(properties
		view 552
		cursor 3
		signal 2
		description {This is some sort of gadget. You're not sure what it does exactly, but it has a switch.}
		owner 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:)
						(Print 0 19) ; "You're far too busy for that now."
					)
					((IsFlag 48)
						(ClearFlag 48)
						(invSound number: 902 loop: 1 flags: 1 play:)
						(Print 0 20) ; "You switch the gadget off to conserve its energy."
					)
					(else
						(SetFlag 48)
						(invSound number: 902 loop: 1 flags: 1 play:)
						(Print 0 21) ; "You switch the gadget on."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance Rock of RInvItem
	(properties
		view 557
		cel 1
		cursor 10
		signal 2
		description {It's the cone shaped tip of a stalagmite.}
		owner 30
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:)
						(Print 0 22) ; "You're far to busy for that now."
					)
					((== cel 1)
						(Print 0 23) ; "You scrape that sticky goo from the bottom of the rock."
						(ClearFlag 70)
						(gEgo get: 16) ; Plant
						(self cel: 0)
						(Inv hide: showSelf: gEgo)
					)
					(else
						(Print 0 24) ; "There is nothing you can do to the rock."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance Survival_Kit of RInvItem
	(properties
		name {Survival Kit}
		view 553
		cursor 4
		signal 2
		description {A Survival Kit}
		owner 18
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:)
						(Print 0 19) ; "You're far too busy for that now."
					)
					((IsFlag 61)
						(Print 0 25) ; "You've already opened the survival kit and removed its contents."
					)
					(else
						(SetFlag 61)
						(Print 0 26) ; "Upon opening the survival kit you discover a Xenon army knife and a canister of dehydrated water."
						(gEgo get: 5) ; Dehydrated_Water
						(gEgo get: 4) ; Knife
						(Inv hide: showSelf: gEgo)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance Knife of RInvItem
	(properties
		view 554
		cursor 5
		signal 2
		description {It's a Xenon Army knife}
	)
)

(instance Dehydrated_Water of RInvItem
	(properties
		name {Dehydrated Water}
		view 555
		cursor 8
		signal 2
		description {The can label says "Pelvitron Dehydrated Water (H2) - All you add is air! Makes 10 gallons! Caution - Do not attempt to open or rupture container! Misuse could result in personal injury and/or flash flooding."}
	)
)

(instance Broken_Glass of RInvItem
	(properties
		name {Broken Glass}
		view 556
		cursor 9
		signal 2
		description {It's that highly reflective piece of broken cockpit glass.}
		owner 18
	)
)

(instance Orat_Part of RInvItem
	(properties
		name {Orat Part}
		view 558
		cursor 11
		signal 2
		description {This cute little item is an Orat part - you're not sure what part though.}
		owner 28
	)
)

(instance Skimmer_Key of RInvItem
	(properties
		name {Skimmer Key}
		view 559
		cursor 12
		signal 2
		description {This key operates the skimmer.}
		owner 35
	)
)

(instance buckazoid of RInvItem
	(properties
		view 560
		cursor 13
		signal 2
		description {buckazoid}
	)

	(method (show)
		(= view (if (>= gBuckazoidCount 3) 560 else 574))
		(super show: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 0 27 gBuckazoidCount (if (== gBuckazoidCount 1) {.} else {s.})) ; "You have %d Buckazoid%s"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance Keronian_Ale of RInvItem ; UNUSED
	(properties
		name {Keronian Ale}
		view 561
		cursor 25
		signal 2
		description {Ummm! Keronian Ale!}
		owner 43
	)
)

(instance Jetpack of RInvItem
	(properties
		view 562
		cursor 14
		signal 2
		description {This is a used jetpack. Real used.}
		owner 41
	)
)

(instance Pulseray_Laser_Pistol of RInvItem
	(properties
		name {Pulseray Laser Pistol}
		view 563
		cursor 15
		signal 2
		description {It's a pulseray laser pistol. Remember, this isn't a play toy!}
		owner 58
	)
)

(instance Grenade of RInvItem
	(properties
		view 564
		cursor 16
		signal 2
		description {You have a small innocuous looking grenade.}
		owner 58
	)
)

(instance Remote of RInvItem
	(properties
		view 565
		cursor 17
		signal 2
		description {This is a small single function remote control.}
		owner 64
	)
)

(instance Widget of RInvItem
	(properties
		view 570
		cursor 18
		signal 2
		description {It's a genuine Widget. You're not sure what it does but it's heavy, it looks cool, and it might be magnetic. Please keep this away from the game disks!}
		owner 7
	)
)

(instance Plant of RInvItem
	(properties
		view 571
		cursor 21
		signal 2
		description {This is simply a piece of sticky, stinking, rotting, plant}
		owner 19
	)
)

(instance Bar_Coupon of RInvItem
	(properties
		name {Bar Coupon}
		view 572
		cursor 22
		signal 2
		description {Hey kids! This bar coupon is good for 5 bucakzoids and a free Keronian Ale!}
	)
)

(instance Droids_B_Us_coupon of RInvItem
	(properties
		name {Droids-B-Us coupon}
		view 573
		cursor 23
		signal 2
		description {This coupon gives you a 20% discount at a Droids-B-Us near you! How helpful! Those suckers have the highest droid prices in this universe.}
	)
)

(instance Sarien_ID_Card of RInvItem
	(properties
		name {Sarien ID Card}
		view 569
		cursor 24
		signal 2
		description {In the pocket of this ugly outfit is a Sarien ID card. The name on the card is Butston Freem. You wonder if this is a common Sarien name (and if it is, you're glad you're not Sarien).}
		owner 57
	)
)

(instance redX of View
	(properties
		view 903
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
		maskLoop 14
		maskCel 1
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
		maskLoop 14
		maskCel 1
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
		maskLoop 14
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
		maskLoop 14
		maskCel 3
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
		helpStr {This window displays the current inventory item.}
		maskView 900
		maskLoop 14
		maskCel 4
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
		helpStr {This icon brings up the inventory window.}
		maskView 900
		maskLoop 14
		maskCel 2
	)

	(method (select)
		(if (super select:)
			(Inv showSelf: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 10
		cel 0
		cursor 30
		message 12
		signal 65
		helpStr {This icon is for smelling.}
		maskView 900
		maskLoop 14
	)
)

(instance icon7 of IconI
	(properties
		view 900
		loop 11
		cel 0
		cursor 31
		message 11
		signal 65
		helpStr {This icon is for tasting.}
		maskView 900
		maskLoop 14
		maskCel 1
	)
)

(instance icon8 of IconI
	(properties
		view 900
		loop 7
		cel 0
		cursor 999
		message 8
		signal 67
		helpStr {This icon brings up the control panel.}
		maskView 900
		maskLoop 14
		maskCel 1
	)

	(method (select)
		(if (super select:)
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
		maskLoop 14
	)
)

(instance sq1DoVerbCode of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0)
		(= temp0 (param2 description:))
		(switch param1
			(2
				(if (param2 facingMe: gEgo)
					(cond
						((param2 lookStr:)
							(Print (param2 lookStr:))
						)
						((not (IsFlag 0))
							(proc0_15)
						)
						(else
							(localproc_0 param1 param2)
						)
					)
				)
			)
			(else
				(if (not (IsFlag 0))
					(proc0_15)
				else
					(localproc_0 param1 param2 param3)
				)
			)
		)
	)
)

(instance sq1FtrInit of Code
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

(instance sq1Win of BorderWindow
	(properties)

	(method (open)
		(if (not (HaveMouse))
			(= global113 gTheCursor)
			(gGame setCursor: 69 1)
		)
		(super open: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(if (not (HaveMouse))
			(gGame setCursor: global113 1)
		)
	)
)

(instance invWin of InsetWindow
	(properties)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 15] [temp29 4])
		(= temp12 -1)
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
			priority: temp12
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
			6
			temp12
		)
		(DrawCel 947 1 1 4 3 temp12)
		(DrawCel 947 1 0 94 38 temp12)
		(DrawCel 947 1 0 135 38 temp12)
		(DrawCel 947 0 4 63 (- 37 (+ (CelHigh 947 0 4) 3)) temp12)
		(DrawCel 947 0 3 101 (- 37 (+ (CelHigh 947 0 4) 3)) temp12)
		(DrawCel 947 0 2 146 (- 37 (+ (CelHigh 947 0 4) 3)) temp12)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 947 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp6 0)
		(= temp8 global156)
		(= temp11 (proc0_17 global157 global156))
		(= temp10 (proc0_17 global159 global130))
		(= temp9 global130)
		(= temp1 3)
		(= temp7 1)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grFILL_BOX temp2 temp3 (+ temp2 temp1) temp4 temp7 temp8 temp12)
		(Graph grFILL_BOX (- temp5 temp1) temp3 temp5 temp4 temp7 temp9 temp12)
		(for ((= temp13 0)) (< temp13 temp1) ((++ temp13))
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(+ temp3 temp13)
				(- temp5 (+ temp13 1))
				(+ temp3 temp13)
				temp11
				temp12
				-1
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(- temp4 (+ temp13 1))
				(- temp5 (+ temp13 1))
				(- temp4 (+ temp13 1))
				temp10
				temp12
				-1
			)
		)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 0 32 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			(proc0_17 global159 global130)
			dsCOORD
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 947 0 1) 3)
		)
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
		helpStr {Raises and lowers the level of graphics detail.}
		sliderView 947
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
		helpStr {Adjusts sound volume.}
		sliderView 947
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
		helpStr {Adjusts the speed of the your character's animation (within the limits of your computer's capability).}
		sliderView 947
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
		message 9
		signal 451
		helpStr {Saves your current game.}
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		message 9
		signal 451
		helpStr {Restores a previously saved game.}
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		message 9
		signal 451
		helpStr {Restarts the Game.}
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		message 9
		signal 451
		helpStr {Exits the game.}
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 9
		signal 451
		helpStr {Information about the game.}
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 70
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
		nsTop 106
		cursor 70
		message 9
		signal 451
		helpStr {Exits this menu.}
	)
)

(instance SpiderList of List
	(properties)
)

