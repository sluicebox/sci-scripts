;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use n802)
(use RegionPath)
(use SQEgo)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use RandCycle)
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
	sq4 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	StepOn 5
	IsFlag 6
	SetFlag 7
	ClearFlag 8
	AnimateEgoHead 9
	EgoDead 10
	SetScore 11
	proc0_12 12
	Face 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
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
	gMessageMode
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
	global101 = 1234
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
	gEgoHead
	gStopGroop
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
	gBuckazoidCount = 59
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
	gATMBuckazoidCount = 2001
	; 170
	global170
	global171
	global172
	global173 = 10
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
		(= temp0 4)
	)
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: StopWalk temp0
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
)

(procedure (HandsOff &tmp temp0)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 0 1 2 3 4 5 6 7)
	(gTheIconBar curIcon: temp0)
	(if (not (HaveMouse))
		(= global192 ((User curEvent:) x:))
		(= global193 ((User curEvent:) y:))
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
	(gTheIconBar enable: 0 1 2 3 4 5 6 7)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 global192 global193)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
)

(procedure (HaveMem param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (StepOn param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (proc0_15 param1 param2) ; UNUSED
	(if (== (param1 onControl:) param2)
		(return 1)
	)
)

(procedure (IsFlag param1)
	(return (& [global114 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global114 (/ param1 16)]
		(| [global114 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global114 (/ param1 16)]
		(& [global114 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (AnimateEgoHead param1 &tmp temp0)
	(= temp0 0)
	(if argc
		(= temp0 param1)
	else
		(= temp0 4)
	)
	((= gEgoHead egoHead) init: gEgo view: temp0 cycleSpeed: 24)
)

(procedure (EgoDead param1 param2)
	(if (> argc 0)
		(= global186 param1)
		(if (OneOf (gEgo view:) 373 374 993)
			(if (== global186 0)
				(= global186 7)
			)
			(if (== global186 8)
				(= global186 9)
			)
		)
	else
		(= global186 0)
	)
	(if (> argc 1)
		(= global187 param2)
	else
		(= global187 0)
	)
	(gCurRoom newRoom: 900)
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param1))
		(gGame changeScore: param2)
		(SetFlag param1)
		(pointsSound play:)
	)
)

(procedure (proc0_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (== argc 1)
		(Display 0 27 dsRESTOREPIXELS [param1 0])
	else
		(= temp4 (= temp5 -1))
		(= temp0 0)
		(= temp1 68)
		(= temp2 69)
		(= temp3 -1)
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

(procedure (proc0_14 param1 &tmp temp0 [temp1 25] [temp26 100] [temp126 4] temp130)
	(if (!= param1 -1)
		(= global188 param1)
	)
	(StrCpy @temp1 {Space Quest })
	(switch global188
		(1
			(StrCat @temp1 {\1b - The Sarien Encounter})
		)
		(3
			(StrCat @temp1 {\1c - The Pirates of Pestulon})
		)
		(4
			(StrCat @temp1 {\1a - Roger Wilco and The Time Rippers})
		)
		(10
			(StrCat @temp1 {\1e - Latex Babes of Estros})
		)
		(12
			(StrCat @temp1 {\1d - Vohaul's Revenge \1f})
			(= temp0 global148)
		)
	)
	(TextSize @temp126 @temp1 0 -1)
	(StrCpy @temp26 {\06})
	(for
		((= temp130 (/ (- 320 (- [temp126 3] [temp126 1])) 2)))
		(> temp130 0)
		((-- temp130))
		
		(StrCat @temp26 {\06})
	)
	(StrCat @temp26 @temp1)
	(DrawStatus @temp26 0 (proc0_18 global158 global155 global155))
)

(procedure (proc0_16 &tmp temp0 [temp1 2] temp3 temp4 temp5 [temp6 5])
	(= temp3 (gGame setCursor: 69 1))
	(= temp4 (User curEvent:))
	(redX x: (temp4 x:) y: (+ 300 (temp4 y:)) z: 300 show:)
	((= temp0 (List new:)) add: redX)
	(Animate (temp0 elements:) 1)
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
	(Animate (temp0 elements:) 1)
	(temp0 delete: redX dispose:)
	(gGame setCursor: temp3)
)

(procedure (proc0_17 param1 param2 param3 &tmp [temp0 500]) ; UNUSED
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

(procedure (proc0_18 param1 param2 param3)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (and (> param2 15) (== global105 16))
		(= param2 15)
	)
	(if (> param2 31)
		(= param2 31)
	)
	(if (< param3 0)
		(= param3 0)
	)
	(if (> param3 31)
		(= param3 31)
	)
	(if (== global105 256)
		(return param1)
	)
	(if (== global105 16)
		(return param2)
	)
	(if (== global105 32)
		(return param3)
	)
)

(instance ego of SQEgo
	(properties
		description {Roger Wilco}
		sightAngle 180
		lookStr {It's you. Roger Wilco, space guy.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 0 0) ; "You talk to yourself but are stumped for a reply."
			)
			(3 ; Do
				(Print 0 1) ; "Hey! Keep your hands off yourself!  This is a family game."
			)
			(10 ; Taste
				(Print 0 2) ; "I'll bet you wish you could!"
			)
			(11 ; Smell
				(Print 0 3) ; "Ahhh! The aroma of several adventure games emanates from your person."
			)
			(4 ; Inventory
				(switch invItem
					(12 ; cigar
						(Print 0 4) ; "You slide the pre-smoked tobacco tube in your mouth and, after noticing a hint of grease and cruel breath, decide you'll save it for a special occasion."
					)
					(else
						(proc0_16)
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
		lookStr {Roger Wilco, space guy.}
		view 4
	)

	(method (doVerb theVerb invItem)
		(gEgo doVerb: theVerb invItem)
	)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

(instance longSong2 of Sound
	(properties
		number 1
	)
)

(instance pointsSound of Sound
	(properties
		flags 1
		number 888
		priority 15
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

(instance sq4KeyDownHandler of EventHandler
	(properties)
)

(instance sq4MouseDownHandler of EventHandler
	(properties)
)

(instance sq4DirectionHandler of EventHandler
	(properties)
)

(instance sq4 of Game
	(properties)

	(method (init &tmp temp0)
		(= gSystemWindow sq4Win)
		(proc802_0)
		(= gStopGroop stopGroop)
		(= gUseSortedFeatures 1)
		(super init:)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode sq4DoVerbCode)
		(= gFtrInitializer sq4FtrInit)
		((= gKeyDownHandler sq4KeyDownHandler) add:)
		((= gMouseDownHandler sq4MouseDownHandler) add:)
		((= gDirectionHandler sq4DirectionHandler) add:)
		(= gPMouse PseudoMouse)
		(self egoMoveSpeed: 0 setCursor: gTheCursor 1 304 172)
		((= gEgo ego)
			_head: (= gEgoHead egoHead)
			moveSpeed: (self egoMoveSpeed:)
			cycleSpeed: (self egoMoveSpeed:)
		)
		((gEgo _head:) client: gEgo)
		(User alterEgo: gEgo verbMessager: 0 canControl: 0 canInput: 0)
		((= gLongSong longSong) owner: self init:)
		((= gLongSong2 longSong2) owner: self init:)
		(= gWaitCursor 997)
		(= gPossibleScore 315)
		(= gUserFont 4)
		(= gVersion {x.yyy})
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 32))
			(ClearFlag 21)
		else
			(SetFlag 21)
		)
		(sq4Win
			color: 0
			back: (proc0_18 global158 global155 global157)
			topBordColor: global130
			lftBordColor: (proc0_18 global161 global130 global130)
			rgtBordColor: (proc0_18 global157 global156 global156)
			botBordColor: (proc0_18 global156 global156 global155)
		)
		(gcWin
			color: 0
			back: (proc0_18 global158 global155 global157)
			topBordColor: global130
			lftBordColor: (proc0_18 global161 global130 global130)
			rgtBordColor: (proc0_18 global157 global156 global156)
			botBordColor: (proc0_18 global156 global156 global155)
		)
		(invWin
			color: 0
			back: (proc0_18 global156 global155 global156)
			topBordColor: (proc0_18 global158 global130 global130)
			lftBordColor: (proc0_18 global157 global130 global157)
			rgtBordColor: (proc0_18 global155 global156 global156)
			botBordColor: (proc0_18 global129 global156 global155)
			insideColor: (proc0_18 global155 global156 global156)
			topBordColor2: global129
			lftBordColor2: global129
			botBordColor2: (proc0_18 global158 global130 global130)
			rgtBordColor2: (proc0_18 global161 global130 global130)
		)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon6 icon7 icon4 icon5 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo:
				#lowlightColor
				(proc0_18 global158 global155 global157)
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(Inv
			init:
			add:
				buckazoid
				rope
				bomb
				rabbit
				battery
				jar
				paper_with_gum
				oxygen_tank
				hintbook
				pen
				atmCard
				plug
				cigar
				matches
				diskette
				laptop_computer
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor 0
			eachElementDo:
				#lowlightColor
				(proc0_18 global155 global156 global156)
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
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					topValue: (if (> global106 1) 15 else 1)
					bottomValue: 0
					yourself:
				)
				(speedSlider
					theObj: self
					selector: #setSpeed
					topValue: 1
					bottomValue: 15
					yourself:
				)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 811 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo:
				#lowlightColor
				(proc0_18 global157 global156 global156)
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(buckazoid owner: gEgo)
		(= global107 (if (GameIsRestarting) 60 else 1))
		(self newRoom: 803) ; speedTest
	)

	(method (pragmaFail)
		(if (User canInput:)
			(proc0_16)
		)
	)

	(method (replay)
		(proc0_14 -1)
		(Palette palSET_INTENSITY 0 255 100)
		(super replay:)
	)

	(method (quitGame)
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(super
			quitGame:
				(Print ; "See ya on the chronostream, Time Jockey!"
					0
					5
					#button
					{Do something of redeeming\nsocial value (Quit)}
					1
					#button
					{Changed My Mind.\nLet's Play!}
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
				6
				#button
				{Of course I'm sure!\nWhy else would I have\nchosen it?}
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

	(method (doit)
		(super doit:)
		(if
			(not
				(OneOf
					gCurRoomNum
					803 ; speedTest
					1
					6
					9
					10
					15
					16
					17
					19
					20
					21
					59
					119
					120
					150
					321
					329
					330
					335
					340
					345
					350
					355
					371
					376
					398
					500
					505
					510
					514
					515
					520
					525
					531
					541
					615
				)
			)
			((ScriptID 808 0) doit:) ; nosePick
		)
	)

	(method (newRoom)
		(if (== ((gInventory at: 12) state:) 1) ; cigar
			(Print 0 7) ; "The cigar goes, as cigars often do, out."
			((gInventory at: 12) state: 0) ; cigar
		)
		(super newRoom: &rest)
	)

	(method (startRoom param1)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 801) doit: param1) ; disposeCode
		(if gDebugOn
			(SetDebug)
		)
		(cond
			(
				(OneOf
					param1
					370
					371
					375
					376
					380
					381
					385
					386
					387
					390
					391
					395
					397
					398
					399
					400
					405
					406
					410
					411
				)
				RegionPath
				(ScriptID 700) ; mall
				(= global102 700)
				(if (OneOf param1 405 406 410 411)
					(ScriptID 809) ; MISSING EXPORT
				)
			)
			((OneOf param1 25 30 35 40 45 50 55 60 65)
				RegionPath
				(ScriptID 701) ; street
				(= global102 701)
				(if (OneOf param1 25 30 35 40 45 50 55 60 65)
					(ScriptID 705) ; bunny
				)
			)
			((OneOf param1 75 80 85 90 95 100 105 110 115)
				(ScriptID 702) ; sewer
			)
			((OneOf param1 609 610 611 612 613 614 615 620)
				(ScriptID 706) ; ulence
			)
			((OneOf param1 299 300 305 306 310 315 320 298)
				(ScriptID 703) ; butte
			)
			((OneOf param1 150 500 505 510 514 515 520 525 541 544 545)
				RegionPath
				(ScriptID 704) ; brain
				(= global102 704)
			)
			((OneOf param1 1 6 9 10 15 16 17 19 20 21)
				(ScriptID 707) ; intro
			)
			((OneOf param1 530 535 540)
				(ScriptID 709) ; rgLanding
			)
		)
		(if
			(not
				(OneOf
					param1
					803
					1
					6
					9
					10
					15
					16
					17
					19
					20
					21
					59
					119
					120
					150
					321
					329
					330
					335
					340
					345
					350
					355
					371
					376
					398
					500
					505
					510
					514
					515
					520
					525
					531
					541
					615
				)
			)
			(ScriptID 808) ; nosePick
		)
		(ScriptID 982)
		(super startRoom: param1)
		(if (gCast contains: gEgo)
			(if
				(and
					(gEgo normal:)
					(not (OneOf param1 405 406 410 411))
					(not ((gEgo cycler:) isKindOf: StopWalk))
				)
				(gEgo setCycle: StopWalk 4)
			)
			(if (not (gEgo looper:))
				(gEgo setLoop: stopGroop)
			)
			(AnimateEgoHead (egoHead view:))
		)
		(redX init: hide: setPri: 15 posn: 1000 -1000)
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
						(if (not (& (gTheIconBar state:) $0004))
							(gGame restart:)
							(event claimed: 1)
						)
					)
				)
			)
		)
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
		(self
			highlightColor: 0
			lowlightColor: (proc0_18 global158 global155 global157)
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
			highlightColor: 0
			lowlightColor: (proc0_18 global158 global155 global157)
		)
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
		(self
			highlightColor: 0
			lowlightColor: (proc0_18 global158 global155 global157)
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
			highlightColor: 0
			lowlightColor: (proc0_18 global158 global155 global157)
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
		helpStr {This allows you to select an item.}
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor: (proc0_18 global158 global155 global157)
		)
		(super init:)
	)
)

(instance buckazoid of InvI
	(properties
		view 700
		cursor 1
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf 0 8 gBuckazoidCount (if (== gBuckazoidCount 1) {.} else {s.})) ; "You have %d recession-riddled Buckazoid%s"
			)
		)
	)
)

(instance jar of InvI
	(properties
		view 700
		cel 1
		cursor 15
		signal 2
		description {glass jar}
		owner 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== cel 2)
					(Print 0 9) ; "You have a jar of green acid."
				else
					(Print 0 10) ; "You have an empty jar."
				)
			)
		)
	)
)

(instance hintbook of InvI
	(properties
		view 700
		cel 4
		cursor 18
		signal 2
		description {An SQ 4 hintbook.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((gCurRoom script:)
						(Print 0 11) ; "You're far too busy for that now."
					)
					((and (OneOf gCurRoomNum 397 398) (not (IsFlag 31)))
						(Print 0 12) ; "Hey! This isn't a free hint service. You need to pay for it before you read it!"
					)
					((not (HaveMem 6800))
						(Print 0 13) ; "Sorry, you don't have enough memory to view the hint book."
					)
					(else
						(Inv curIcon: (gInventory at: 9) hide:) ; pen
						(gCurRoom setScript: (ScriptID 708 0)) ; hintBookScript
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pen of InvI
	(properties
		view 700
		cel 5
		cursor 8
		signal 2
		description {Yes, it's a Reveal-O-matic electric hint revealer.}
	)
)

(instance atmCard of InvI
	(properties
		view 700
		cel 6
		cursor 2
		signal 2
		description {An AutoBucks Teller Machine card.}
	)
)

(instance plug of InvI
	(properties
		view 700
		cel 7
		cursor 5
		signal 2
		description {A PocketPal\05 adaptor plug.}
	)
)

(instance cigar of InvI
	(properties
		view 700
		cel 8
		cursor 3
		signal 2
		description {An obviously used stogie.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(cond
					((!= invItem 13) 0) ; matches
					(state
						(Print 0 14) ; "The horrid-smelling smoke eminating from its tip would indicate that the cigar is already lit."
					)
					(else
						(Print 0 15) ; "You slide the conveniently pre-moistened stogie between your lips, apply fire via a match, and proceed to nearly hack up a lung."
						(= state 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matches of InvI
	(properties
		view 700
		cel 9
		cursor 4
		signal 2
		description {A book of matches.}
	)
)

(instance diskette of InvI
	(properties
		view 700
		cel 10
		cursor 11
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 0 16) ; "The label on the diskette reads:    Roger Jr.   Brain Tools   Stunt Flyer"
			)
		)
	)
)

(instance rabbit of InvI
	(properties
		view 700
		cel 11
		cursor 9
		signal 2
		description {cute bunny}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((!= view 700)
						(Inv hide:)
						(self view: 700 loop: 0 cel: 11)
						(Inv show: gEgo)
					)
					((not ((gInventory at: 4) owner:)) ; battery
						(Inv hide:)
						(self view: 701 loop: 0 cel: 0)
						(Inv show: gEgo)
					)
					(else
						(Print 0 17) ; "A darn cute bunny."
					)
				)
			)
			(3 ; Do
				(if (== view 700)
					0
				else
					(SetScore 67 3)
					(Print 0 18) ; "You extract the portable power pellet from the rear confines of the hare's polyplastoid torso."
					(Inv hide:)
					(gEgo get: 4) ; battery
					(self view: 700 loop: 0 cel: 11)
					(gGame setCursor: 20 1)
					(Inv show: gEgo)
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; battery
						(Print 0 19) ; "You clumsily insert the battery into the furry burrow inhabitant's hollow trunk."
						(Inv hide:)
						(gEgo put: 4 0) ; battery
						(Inv curIcon: 0 show: gEgo)
						(gGame setCursor: 999 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance battery of InvI
	(properties
		view 700
		cel 12
		cursor 13
		signal 2
		description {A battery.}
	)
)

(instance oxygen_tank of InvI
	(properties
		name {oxygen tank}
		view 700
		cel 13
		cursor 12
		signal 2
		description {An oxygen tank.}
		owner 335
	)
)

(instance rope of InvI
	(properties
		view 700
		cel 14
		cursor 10
		signal 2
		description {A crummy piece of rope.}
		owner 65
	)
)

(instance laptop_computer of InvI
	(properties
		name {laptop computer}
		view 700
		cel 15
		cursor 17
		signal 2
		description {A handy Dandy PocketPal portable terminal.}
		owner 55
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((!= view 700)
						(Inv hide:)
						(self view: 700 loop: 0 cel: 15)
						(Inv show: gEgo)
					)
					((== ((gInventory at: 4) owner:) 1) ; battery
						(Print 0 20) ; "Your PocketPal now has power. Now all you need is a place to use it."
					)
					(else
						(Inv hide:)
						(self view: 701 loop: 0 cel: 1)
						(Inv show: gEgo)
					)
				)
			)
			(3 ; Do
				(if (== ((gInventory at: 4) owner:) 1) ; battery
					(Print 0 21) ; "You liberate the battery from the PocketPal."
					(Inv hide:)
					(gEgo get: 4) ; battery
					(Inv show: gEgo)
				else
					(Print 0 22) ; "This is just a dumb terminal. It won't do anything by itself."
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; battery
						(SetScore 72 3)
						(Print 0 23) ; "You plug the mobile power cylinder into the laptop."
						(Inv hide:)
						(self view: 700 loop: 0 cel: 15)
						(gEgo put: 4 1) ; battery
						(Inv curIcon: 0 show: gEgo)
						(gGame setCursor: 999 1)
					)
					(11 ; plug
						(SetScore 71 3)
						(Print 0 24) ; "You attach the plug to the PocketPal."
						(Inv hide:)
						(gEgo put: 11 1) ; plug
						(Inv curIcon: 0 show: gEgo)
					)
				)
			)
		)
	)
)

(instance paper_with_gum of InvI
	(properties
		name {paper with gum}
		view 700
		loop 2
		cursor 21
		signal 2
		description {It's Paper-wrapped gum - a Coarsegold dining delight.}
		owner 297
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if cel
					(Print 0 25) ; "These symbols look vaguely familiar. Now, where have you seen them?"
				else
					(Print 0 26) ; "Ummm! This lumpy paper-wrapped wad looks mighty interesting."
				)
			)
			(3 ; Do
				(if (not cel)
					(Inv hide:)
					(self view: 700 loop: 2 cel: 1)
					(Inv show: gEgo)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bomb of InvI
	(properties
		view 700
		cel 3
		cursor 22
		signal 2
		description {A piece of unstable ordnance.}
		owner 40
	)
)

(instance redX of View
	(properties
		view 942
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
		message 11
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
		message 10
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

(instance sq4DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 (param2 description:))
		(switch param1
			(2
				(if (param2 facingMe: gEgo)
					(if (param2 lookStr:)
						(Print (param2 lookStr:))
					else
						(proc0_16)
					)
				)
			)
			(else
				(proc0_16)
			)
		)
	)
)

(instance sq4FtrInit of Code
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

(instance sq4Win of BorderWindow
	(properties)
)

(instance invWin of InsetWindow
	(properties)
)

(instance gcWin of BorderWindow
	(properties)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 15] [temp29 4])
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
			priority: 15
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
			15
		)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 94 38 15)
		(DrawCel 947 1 0 135 38 15)
		(DrawCel 947 0 4 63 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 3 101 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 2 146 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 947 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 global156)
		(= temp11 (proc0_18 global157 global156 global156))
		(= temp10 (proc0_18 global161 global130 global157))
		(= temp9 global130)
		(= temp1 3)
		(= temp7 3)
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
		(Format @temp14 0 28 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			(proc0_18 global161 global130 global157)
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
		helpStr {Adjusts the speed of the game's animation (within the limits of your computer's capability).}
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

