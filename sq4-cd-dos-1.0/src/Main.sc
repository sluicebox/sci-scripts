;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use brain)
(use n802)
(use RegionPath)
(use SQEgo)
(use Sq4Dialog)
(use Sq4Narrator)
(use Print)
(use Sync)
(use PseudoMouse)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use Feature)
(use StopWalk)
(use DCIcon)
(use Timer)
(use Grooper)
(use Sound)
(use Game)
(use Inventory)
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
	waitC 19
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
	gMessageMode = 1
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
	; 195
	global195
	global196
	global197
	global198
	gGameSpeed = 6
	; 200
	global200
	global201
)

(procedure (proc0_16 param1 &tmp temp0)
	(cond
		((== param1 1)
			(switch (= temp0 (Random 0 1))
				(0
					(gNarrator modNum: 0 say: 41) ; "You don't need to look at that."
				)
				(1
					(gNarrator modNum: 65 say: 20) ; "It's very pleasant looking."
				)
			)
		)
		((== param1 2)
			(switch (= temp0 (Random 0 3))
				(0
					(gNarrator modNum: 395 say: 4) ; "There is no reply."
				)
				(1
					(gNarrator modNum: 500 say: 3) ; "You'd better not. Something might answer."
				)
				(2
					(gNarrator modNum: 531 say: 11) ; "You talk to yourself."
				)
				(3
					(gNarrator modNum: 545 say: 10) ; "You talk to yourself, but you don't hear you."
				)
			)
		)
		((== param1 6)
			(switch (= temp0 (Random 0 3))
				(0
					(gNarrator modNum: 50 say: 15) ; "It's probably the most nauseating thing to smell in the whole family of smells."
				)
				(1
					(gNarrator modNum: 55 say: 17) ; "It smells like something that wasn't designed for noses."
				)
				(2
					(gNarrator modNum: 65 say: 13) ; "It smells just as good as it looks."
				)
				(3
					(gNarrator modNum: 371 say: 41) ; "It doesn't smell great, but it smells better than you."
				)
			)
		)
		((== param1 7)
			(switch (= temp0 (Random 0 3))
				(0
					(gNarrator modNum: 40 say: 3) ; "It needs salt."
				)
				(1
					(gNarrator modNum: 371 say: 30) ; "Nah. You'd rather not. You never know where it's been."
				)
				(2
					(gNarrator modNum: 371 say: 37) ; "That's not a very clean habit."
				)
				(3
					(gNarrator modNum: 530 say: 10) ; "It tastes like nothing you'd ever want to put your tongue on again."
				)
			)
		)
		((== param1 4)
			(switch (= temp0 (Random 0 2))
				(0
					(gNarrator modNum: 300 say: 2) ; "You can't do that."
				)
				(1
					(gNarrator modNum: 371 say: 20) ; "Keep your hands to yourself!"
				)
				(2
					(gNarrator modNum: 387 say: 29) ; "Don't mess with it."
				)
			)
		)
		((== param1 3)
			(gNarrator modNum: 0 say: 13) ; "You're far too busy for that now."
		)
		(else
			(switch (= temp0 (Random 0 2))
				(0
					(gNarrator modNum: 0 say: 40) ; "You can't use that here."
				)
				(1
					(gNarrator modNum: 50 say: 14) ; "It would serve no purpose."
				)
				(2
					(gNarrator modNum: 70 say: 2) ; "Nothing happens."
				)
			)
		)
	)
	(gNarrator modNum: -1)
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
		setSpeed: gGameSpeed
	)
)

(procedure (HandsOff)
	(if (not global195)
		(= global195 (gTheIconBar curIcon:))
	)
	(= global196 (gUser canControl:))
	(= global197 (gUser canInput:))
	(gUser canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= global198 0)
	(gTheIconBar eachElementDo: #perform checkIcon)
	(gTheIconBar curIcon: (gTheIconBar at: 8))
	(gTheIconBar disable: 0 1 2 3 4 5 6 7)
	(if (not (HaveMouse))
		(gGame setCursor: 996)
	else
		(gGame setCursor: waitC)
	)
)

(procedure (HandsOn &tmp temp0)
	(gUser canControl: 1 canInput: 1)
	(gTheIconBar enable: 0 1 2 3 4 5 6 7)
	(if (and argc temp0) ; UNINIT
		(localproc_0)
	)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 6)
	)
	(if global195
		(gTheIconBar curIcon: global195)
		(gGame setCursor: (global195 cursor:))
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
				(not (gTheIconBar curInvIcon:))
			)
			(gTheIconBar advanceCurIcon:)
		)
	)
	(= global195 0)
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
)

(procedure (localproc_0 &tmp temp0)
	(gUser canControl: global196 canInput: global197)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (& global198 (>> $8000 temp0))
			(gTheIconBar disable: temp0)
		)
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
	((= gEgoHead egoHead) init: gEgo view: temp0 cycleSpeed: 150)
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
		(Display 0 0 dsRESTOREPIXELS [param1 0])
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
				(27
					(= temp0 [param1 (++ temp8)])
				)
				(30
					(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
				)
				(67
					(= temp3 [param1 (++ temp8)])
				)
				(64
					(= temp4 [param1 (++ temp8)])
					(= temp5 [param1 (++ temp8)])
				)
				(25
					(= temp6 [param1 (++ temp8)])
				)
				(26
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
		((= temp130 (/ (- 326 (- [temp126 3] [temp126 1])) 2)))
		(> temp130 0)
		((-- temp130))
		
		(StrCat @temp26 {\06})
	)
	(StrCat @temp26 @temp1)
	(DrawStatus @temp26 0 global158)
)

(procedure (proc0_17 param1 param2 param3 &tmp [temp0 500]) ; UNUSED
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp0)
	else
		(StrCpy @temp0 param2)
	)
	(babbleIcon view: param1 cycleSpeed: (* (+ gHowFast 1) 4))
	(if (u< param2 1000)
		(Prints @temp0 &rest 79 babbleIcon 0 0)
	else
		(Prints @temp0 param3 &rest 79 babbleIcon 0 0)
	)
)

(procedure (proc0_18 param1 param2)
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
	(return (if (IsFlag 21) param1 else param2))
)

(instance ego of SQEgo
	(properties
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 1) ; "It's you. Roger Wilco, space guy."
			)
			(2 ; Talk
				(gNarrator modNum: 0 say: 2) ; "You talk to yourself but are stumped for a reply."
			)
			(4 ; Do
				(gNarrator modNum: 0 say: 3) ; "Hey! Keep your hands off yourself! This is a family game."
			)
			(7 ; Taste
				(gNarrator modNum: 0 say: 4) ; "I'll bet you wish you could!"
			)
			(6 ; Smell
				(gNarrator modNum: 0 say: 5) ; "Ahhh! The aroma of several adventure games emanates from your person."
			)
			(20 ; cigar
				(gNarrator modNum: 0 say: 6) ; "You slide the pre-smoked tobacco stub in your mouth and, after noticing a hint of grease and cruel breath, decide you'll save it for a special occasion."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance egoHead of Head
	(properties
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
		(super init: &rest)
		(if (== gMessageMode 2)
			((= cycler (MouthSync new:)) init: self 0 99 0 global201 1)
			(DoAudio audPLAY 0 99 0 global201 1)
		else
			((= cycler RandCycle) init: self 20)
		)
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

(class sq4 of Game
	(properties
		parseLang 1
		subtitleLang 0
	)

	(method (play)
		(= gTheCursor (= gWaitCursor waitC))
		(super play: &rest)
	)

	(method (init &tmp temp0)
		(= gSystemWindow sq4Win)
		(Sq4GlobalNarrator noun: 99)
		(= gNarrator Sq4GlobalNarrator)
		(proc802_0)
		(= gStopGroop stopGroop)
		(= gUseSortedFeatures 1)
		(ScriptID 820) ; MISSING EXPORT
		(super init:)
		(= gMessageMode (if (= global83 1) 2 else 1))
		(DoAudio audLANGUAGE 1)
		(DoAudio audRATE 11000)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode sq4DoVerbCode)
		(= gFtrInitializer sq4FtrInit)
		((= gKeyDownHandler sq4KeyDownHandler) add:)
		((= gMouseDownHandler sq4MouseDownHandler) add:)
		((= gDirectionHandler sq4DirectionHandler) add:)
		(= gPMouse PseudoMouse)
		(= gGameSpeed 6)
		(self setCursor: gTheCursor 1 304 172)
		((= gEgo ego) _head: (= gEgoHead egoHead) setSpeed: gGameSpeed)
		((gEgo _head:) client: gEgo)
		(gUser alterEgo: gEgo canControl: 0 canInput: 0)
		((= gLongSong longSong) owner: self init:)
		((= gLongSong2 longSong2) owner: self init:)
		(= gNormalCursor walkCursor)
		(= gPossibleScore 315)
		(= gUserFont 4)
		(= gVersion {x.yyy})
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 21)
		else
			(SetFlag 21)
		)
		(sq4Win
			color: 0
			back: global158
			topBordColor: global130
			lftBordColor: global161
			rgtBordColor: global157
			botBordColor: global156
		)
		(invWin
			color: 0
			back: global156
			topBordColor: global158
			lftBordColor: global157
			rgtBordColor: global155
			botBordColor: global129
			insideColor: global155
			topBordColor2: global129
			lftBordColor2: global129
			botBordColor2: global158
			rgtBordColor2: global161
		)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon6 icon7 icon4 icon5 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor global158
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(= gInventory Inv)
		(gInventory
			init:
			add:
				buckazoid
				rope
				bomb
				rabbit
				battery
				jar
				gum
				tank
				hintbook
				pen
				atmCard
				plug
				cigar
				matches
				diskette
				laptop
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor global155
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(buckazoid owner: gEgo)
		(= global107 (if (GameIsRestarting) 60 else 1))
		(gTheIconBar enable:)
		(self newRoom: 803) ; speedTest
	)

	(method (pragmaFail)
		(if (gUser canInput:)
			(proc0_16)
		)
	)

	(method (save)
		(if
			(and
				(or (== gCurRoomNum 150) (== gCurRoomNum 151) (gRegions contains: 704))
				(> (brain formatting:) 0)
			)
			(= global200 1)
		)
		(super save: &rest)
	)

	(method (replay &tmp [temp0 21])
		(proc0_14 -1)
		(Palette palSET_INTENSITY 0 255 100)
		(super replay: &rest)
	)

	(method (quitGame &tmp temp0 [temp1 70] [temp71 100] [temp171 70])
		(= temp0 (gGame setCursor: 999 1))
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(Message msgGET 0 99 0 7 1 @temp1) ; "See ya on the chronostream, Time Jockey!"
		(Message msgGET 0 97 0 2 1 @temp71) ; "Do something of redeeming  social value (Quit)"
		(Message msgGET 0 97 0 5 1 @temp171) ; "Changed My Mind.  Let's Play!"
		(= global201 7)
		(super
			quitGame:
				(proc816_1 @temp1 78 @temp71 1 78 @temp171 0 79 babbleIcon 0 0)
		)
		(= global201 0)
		(gGame setCursor: temp0 1)
	)

	(method (restart &tmp temp0 [temp1 70] [temp71 100] [temp171 70])
		(= temp0 (gGame setCursor: 999 1))
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(Message msgGET 0 99 0 8 1 @temp1) ; "Are you sure you want to restart?"
		(Message msgGET 0 97 0 4 1 @temp71) ; "Of course I'm sure!  Why else would I have chosen it?"
		(Message msgGET 0 97 0 5 1 @temp171) ; "Changed My Mind.  Let's Play!"
		(= global201 8)
		(if (proc816_1 @temp1 78 @temp71 1 78 @temp171 0 79 babbleIcon 0 0)
			(super restart:)
		)
		(= global201 0)
		(gGame setCursor: temp0 1)
	)

	(method (doit)
		(super doit: &rest)
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

	(method (newRoom newRoomNumber)
		(gGame setCursor: gWaitCursor)
		(gPMouse stop:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (and (IsObject gFastCast) (gFastCast elements:))
			(gFastCast eachElementDo: #dispose 1)
		)
		(if (== ((gInventory at: 12) state:) 1) ; cigar
			(gNarrator modNum: 0 say: 9) ; "The cigar goes out."
			((gInventory at: 12) state: 0) ; cigar
		)
		(gTheIconBar disable:)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom param1)
		((ScriptID 801) doit: param1) ; disposeCode
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
					396
					397
					398
					399
					400
					405
					406
					410
					411
					290
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
		(gTheIconBar enable:)
		(super startRoom: param1)
		(if (gCast contains: gEgo)
			(if
				(and
					(!= gPrevRoomNum 396)
					(gEgo normal:)
					(not (OneOf param1 405 406 410 411))
					(not ((gEgo cycler:) isKindOf: StopWalk))
				)
				(gEgo setCycle: StopWalk 4)
			)
			(if (and (!= gPrevRoomNum 396) (not (gEgo looper:)))
				(gEgo setLoop: stopGroop)
			)
			(AnimateEgoHead (egoHead view:))
		)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 6))
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
	)

	(method (showControls &tmp temp0 temp1)
		((ScriptID 818 0) init:) ; sq4GameControls
		(= temp1 (gGameControls at: 3))
		(temp1 theObj: newSpeedCode selector: #doit)
		((ScriptID 818 0) show: dispose:) ; sq4GameControls
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
							(gInventory showSelf: gEgo)
						)
					)
					(KEY_SHIFTTAB
						(if (not (& (icon5 signal:) $0004))
							(gInventory showSelf: gEgo)
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
						(gGame restart:)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance newSpeedCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(if argc
			(= gGameSpeed param1)
			(for
				((= temp0 (FirstNode (gCast elements:))))
				temp0
				((= temp0 temp2))
				
				(= temp2 (NextNode temp0))
				(if
					(or
						(not (IsObject (= temp1 (NodeValue temp0))))
						(not (temp1 respondsTo: #setSpeed))
					)
				else
					(temp1 setSpeed: param1 &rest)
				)
			)
		)
		(return gGameSpeed)
	)
)

(instance lookCursor of Cursor
	(properties
		view 851
	)
)

(instance talkCursor of Cursor
	(properties
		view 853
	)
)

(instance doCursor of Cursor
	(properties
		view 852
	)
)

(instance walkCursor of Cursor
	(properties
		view 850
	)
)

(instance waitC of Cursor
	(properties
		view 972
	)
)

(instance helpCursor of Cursor
	(properties
		view 856
	)
)

(instance tasteCursor of Cursor
	(properties
		view 854
	)
)

(instance smellCursor of Cursor
	(properties
		view 855
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 98
		helpVerb 40
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 851
		message 1
		noun 98
		helpVerb 41
	)

	(method (init)
		(= cursor lookCursor)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 852
		message 4
		noun 98
		helpVerb 29
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 856
		message 5
		noun 98
		helpVerb 37
	)

	(method (init)
		(super init: &rest)
		(= cursor helpCursor)
		(self highlightColor: 0 lowlightColor: global158)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		noun 98
		helpVerb 30
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance buckazoid of InvI
	(properties
		view 700
		cursor 951
		message 8
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gInventory hide:)
				((ScriptID 819 0) init:) ; zoid
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance jar of InvI
	(properties
		view 700
		cel 1
		cursor 952
		message 13
		signal 2
		owner 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== cel 2)
					(gNarrator modNum: 0 say: 10) ; "You have a jar of green acid."
				else
					(gNarrator modNum: 0 say: 11) ; "You have an empty jar."
				)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance hintbook of InvI
	(properties
		view 700
		cel 4
		cursor 955
		message 16
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 12) ; "An SQ 4 hintbook."
			)
			(4 ; Do
				(cond
					((gCurRoom script:)
						(gNarrator modNum: 0 say: 13) ; "You're far too busy for that now."
					)
					((and (OneOf gCurRoomNum 397 398) (not (IsFlag 31)))
						(gNarrator modNum: 0 say: 14) ; "Hey! This isn't a free hint service. You need to pay for it before you read it!"
					)
					((not (HaveMem 6800))
						(gNarrator modNum: 0 say: 15) ; "Sorry, you don't have enough memory to view the hint book."
					)
					(else
						(gInventory curIcon: (gInventory at: 9) hide:) ; pen
						(gCurRoom setScript: (ScriptID 708 0)) ; hintBookScript
					)
				)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance pen of InvI
	(properties
		view 700
		cel 5
		cursor 956
		message 17
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 16) ; "Yes, it's a Reveal-O-matic electric hint revealer."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance atmCard of InvI
	(properties
		view 700
		cel 6
		cursor 957
		message 18
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 17) ; "An AutoBucks Teller Machine card."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance plug of InvI
	(properties
		view 700
		cel 7
		cursor 958
		message 19
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 18) ; "A PocketPal\05 adaptor plug."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance cigar of InvI
	(properties
		view 700
		cel 8
		cursor 959
		message 20
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; matches
				(if state
					(gNarrator modNum: 0 say: 20) ; "The horrid-smelling smoke eminating from its tip would indicate that the cigar is already lit."
				else
					(gNarrator modNum: 0 say: 21) ; "You slide the conveniently pre-moistened stogie between your lips, apply a lit match, and proceed to nearly hack up a lung."
					(= state 1)
				)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance matches of InvI
	(properties
		view 700
		cel 9
		cursor 960
		message 21
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 22) ; "A book of matches."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance diskette of InvI
	(properties
		view 700
		cel 10
		cursor 961
		message 22
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 23) ; "The label on the diskette reads:     Roger Jr.    Brain Tools    Stunt Flyer"
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance rabbit of InvI
	(properties
		view 700
		cel 11
		cursor 962
		message 11
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((!= view 700)
						(gInventory hide:)
						(self view: 700 loop: 0 cel: 11)
						(gInventory show: gEgo)
					)
					((not ((gInventory at: 4) owner:)) ; battery
						(gInventory hide:)
						(self view: 701 loop: 0 cel: 0)
						(gInventory show: gEgo)
					)
					(else
						(gNarrator modNum: 0 say: 24) ; "A darn cute bunny."
					)
				)
			)
			(4 ; Do
				(if (== view 700)
					0
				else
					(SetScore 67 3)
					(gNarrator modNum: 0 say: 25) ; "You extract the portable power pellet from the back of the bunny's polyplastoid torso."
					(gInventory hide:)
					(gEgo get: 4) ; battery
					(self view: 700 loop: 0 cel: 11)
					(gInventory show: gEgo)
				)
			)
			(12 ; battery
				(gNarrator modNum: 0 say: 26) ; "You clumsily insert the battery into the furry bunny's hollow trunk."
				(gInventory hide:)
				(gEgo put: 4 0) ; battery
				(gInventory curIcon: 0 show: gEgo)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance battery of InvI
	(properties
		view 700
		cel 12
		cursor 963
		message 12
		signal 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 27) ; "A battery."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance tank of InvI
	(properties
		view 700
		cel 13
		cursor 964
		message 15
		signal 2
		owner 335
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 28) ; "An oxygen tank."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance rope of InvI
	(properties
		view 700
		cel 14
		cursor 965
		message 9
		signal 2
		owner 65
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 29) ; "A crummy piece of rope."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance laptop of InvI
	(properties
		view 700
		cel 15
		cursor 966
		message 23
		signal 2
		owner 55
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((!= view 700)
						(gInventory hide:)
						(self view: 700 loop: 0 cel: 15)
						(gInventory show: gEgo)
					)
					((== ((gInventory at: 4) owner:) 1) ; battery
						(gNarrator modNum: 0 say: 31) ; "Your PocketPal now has power. Now all you need is a place to use it."
					)
					(else
						(gInventory hide:)
						(self view: 701 loop: 0 cel: 1)
						(gInventory show: gEgo)
					)
				)
			)
			(4 ; Do
				(if (== ((gInventory at: 4) owner:) 1) ; battery
					(gNarrator modNum: 0 say: 32) ; "You liberate the battery from the PocketPal."
					(gInventory hide:)
					(gEgo get: 4) ; battery
					(gInventory show: gEgo)
				else
					(gNarrator modNum: 0 say: 33) ; "This is just a dumb terminal. It won't do anything by itself."
				)
			)
			(12 ; battery
				(SetScore 72 3)
				(gNarrator modNum: 0 say: 34) ; "You plug the mobile power cylinder into the laptop."
				(gInventory hide:)
				(self view: 700 loop: 0 cel: 15)
				(gEgo put: 4 1) ; battery
				(gInventory curIcon: 0 show: gEgo)
			)
			(19 ; plug
				(SetScore 71 3)
				(gNarrator modNum: 0 say: 35) ; "You attach the plug to the PocketPal."
				(gInventory hide:)
				(gEgo put: 11 1) ; plug
				(gInventory curIcon: 0 show: gEgo)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance gum of InvI
	(properties
		view 700
		loop 2
		cursor 967
		message 14
		signal 2
		owner 297
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if cel
					(gNarrator modNum: 0 say: 37) ; "These symbols look vaguely familiar. Now, where have you seen them?"
				else
					(gNarrator modNum: 0 say: 38) ; "This lumpy paper-wrapped wad looks mighty interesting."
				)
			)
			(4 ; Do
				(if (not cel)
					(gInventory hide:)
					(self view: 700 loop: 2 cel: 1 cursor: 968)
					(gInventory show: gEgo)
				)
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance bomb of InvI
	(properties
		view 700
		cel 3
		cursor 954
		message 10
		signal 2
		owner 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 0 say: 39) ; "A piece of unstable ordnance."
			)
			(else
				(proc0_16 theVerb)
			)
		)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global198 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance speakTimer of Timer ; UNUSED
	(properties)
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
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 31
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
		view 900
		loop 1
		cel 0
		message 1
		signal 65
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 32
	)

	(method (init)
		(= cursor lookCursor)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 2
		cel 0
		message 4
		signal 65
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 33
	)

	(method (init)
		(= cursor doCursor)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 900
		loop 3
		cel 0
		message 2
		signal 65
		maskView 900
		maskLoop 14
		maskCel 3
		noun 98
		helpVerb 34
	)

	(method (init)
		(= cursor talkCursor)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 900
		maskLoop 14
		maskCel 4
		noun 98
		helpVerb 35
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
		maskLoop 14
		maskCel 2
		noun 98
		helpVerb 28
	)

	(method (select)
		(if (super select:)
			(gInventory showSelf: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 10
		cel 0
		message 6
		signal 65
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 36
	)

	(method (init)
		(= cursor smellCursor)
		(super init:)
	)
)

(instance icon7 of IconI
	(properties
		view 900
		loop 11
		cel 0
		message 7
		signal 65
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 38
	)

	(method (init)
		(= cursor tasteCursor)
		(super init:)
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
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 39
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
		view 900
		loop 9
		cel 0
		type 0
		message 5
		signal 3
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 37
	)

	(method (init)
		(= cursor helpCursor)
		(super init:)
	)
)

(instance sq4DoVerbCode of Code
	(properties)

	(method (doit param1)
		(switch param1
			(1
				(if ((CueObj client:) facingMe: gEgo)
					(if ((CueObj client:) noun:)
						(gNarrator
							noun: ((CueObj client:) noun:)
							tVerb: 1
							say: 0
						)
						(gNarrator noun: 99 tVerb: 0)
					else
						(proc0_16 param1)
					)
				)
			)
			(else
				(proc0_16 param1)
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

