;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n012)
(use Smopper)
(use SQEgo)
(use ScrollableInventory)
(use ScrollInsetWindow)
(use DColorButton)
(use RegPolyPath)
(use SpeakWindow)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use PseudoMouse)
(use Scaler)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use File)
(use Game)
(use User)
(use System)

(public
	SQ5 0
	IsFlag 1
	SetFlag 2
	ClearFlag 3
	proc0_4 4
	StepOn 5
	NormalEgo 6
	proc0_7 7
	Face 8
	EgoDead 9
	SetScore 10
	proc0_11 11
	Localize 12
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
	gLb2ApproachCode
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
	global100
	global101 = 1234
	global102
	global103
	global104 = 100
	; 105
	global105
	gStopGroop
	global107
	global108
	global109
	; 110
	global110
	global111
	global112
	gEurekaLocation
	global114
	; 115
	global115
	gSpeakWindow
	gSq5Win
	global118
	global119
	; 120
	gSq5Music1
	gSq5Music2
	global122
	global123
	global124
	; 125
	global125
	gSpikeState
	gGarbagePickupCount
	global128
	global129
	; 130
	gCliffyState
	global131
	global132
	gGoliathFloorNum
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
	gAct
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
	global161 = 1
	global162
	global163
	gBeaState
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	gWD40State
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
)

(procedure (Localize param1 param2 param3 param4 param5)
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

(procedure (IsFlag param1)
	(return (& [global183 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global183 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global183 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (proc0_4 &tmp temp0)
	(gUser canControl: global109 canInput: global110)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if (& global111 (>> $8000 temp0))
			(gTheIconBar disable: temp0)
		)
	)
)

(procedure (StepOn param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (NormalEgo param1 param2)
	(if (and (> argc 0) (!= param1 -1))
		(gEgo view: param1)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	else
		(gEgo view: global161)
		(if (and (> argc 1) (!= param2 -1))
			(gEgo loop: param2)
		)
	)
	(if (gEgo looper:)
		((gEgo looper:) dispose:)
	)
	(gEgo
		setStep: 5 2
		illegalBits: 0
		ignoreActors: 0
		setSpeed: global123
		signal: (| (gEgo signal:) $1000)
		heading:
			(switch (gEgo loop:)
				(0 90)
				(1 270)
				(2 180)
				(3 0)
				(4 135)
				(5 225)
				(6 45)
				(7 315)
			)
	)
	(gEgo
		setLoop: -1
		setLoop: stopGroop
		setCycle: egoStopWalk -1 2 0
		setPri: -1
		setMotion: 0
		state: (| (gEgo state:) $0002)
	)
)

(procedure (proc0_7 param1 param2 &tmp [temp0 100] [temp100 10] [temp110 10]) ; UNUSED
	(StrCpy
		@temp110
		(switch param2
			(17 {BUCKAZOIDS V })
			(12 {CLOAK })
			(11 {CLOAK ORD })
			(24 {COMMAND })
			(10 {DAMAGE ORD })
			(4 {DO })
			(15 {FORGET ORD })
			(23 {FROC V })
			(8 {GAME V })
			(13 {GREET })
			(5 {HELP })
			(16 {KEY V })
			(21 {KIZ BRANCH V })
			(22 {KIZ FRUIT V })
			(1 {LOOK })
			(9 {LOWER ORD })
			(25 {OXYGEN TANK V })
			(14 {RAISE ORD })
			(20 {SAFETY CONES V})
			(18 {SCRUBBER V })
			(2 {TALK })
			(3 {WALK })
			(else {UNKNOWN VERB})
		)
	)
	(Format @temp100 0 0 gCurRoomNum) ; "%d.nor"
	(Format @temp0 0 1 (param1 name:)) ; ";OBJECT NAME: %s"
	(File name: @temp100 writeString: @temp0 {\0d\n})
	(if (param1 respondsTo: #noun)
		(Format @temp0 0 2 (param1 noun:)) ; "; OBJECT NOUN: %d"
	else
		(Format @temp0 0 3) ; "; OBJECT NOUN: The game's default."
	)
	(File name: @temp100 writeString: @temp0 {\0d\n})
	(Format @temp0 0 4 @temp110) ; "; THE VERB: %s"
	(File name: @temp100 writeString: @temp0 {\0d\n})
	(Format @temp0 0 5 gMouseX gMouseY) ; "; MOUSE [X,Y]: [%d,%d]"
	(File name: @temp100 writeString: @temp0 {\0d\n})
	(Format @temp0 0 6 gCurRoomNum) ; "; MESSAGE FILE: %d"
	(File name: @temp100 writeString: @temp0 {\0d\n})
	(Format @temp0 0 7) ; "****************"
	(File name: @temp100 writeString: @temp0 {\0d\n} close:)
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

(procedure (EgoDead param1)
	(if (not argc)
		(= global119 1)
	else
		(= global119 param1)
	)
	(gCurRoom newRoom: 20) ; deathRoom
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param1))
		(+= gScore param2)
		(sq5StatusLineCode doit:)
		(SetFlag param1)
		(rm0Sound priority: 15 number: 1000 loop: 1 flags: 1 play:)
	)
)

(procedure (proc0_11 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort -1)
	(Graph grFILL_BOX 0 0 10 320 1 0 -1 -1)
	(Graph grUPDATE_BOX 0 0 10 320 1)
	(SetPort temp0)
)

(instance sq5Music1 of Sound
	(properties
		flags 1
	)
)

(instance sq5Music2 of Sound
	(properties
		flags 1
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance sQ5Narrator of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(self back: global159)
		(super init: &rest)
	)
)

(instance ego of SQEgo
	(properties)
)

(instance sq5Win of BorderWindow
	(properties
		back 7
	)
)

(instance sq5StatusLineCode of Code
	(properties)

	(method (doit &tmp [temp0 50] [temp50 50] temp100)
		(= temp100 (GetPort))
		(SetPort -1)
		(Graph grFILL_BOX 0 0 10 320 1 5 -1 -1)
		(Graph grUPDATE_BOX 0 0 10 320 1)
		(Message msgGET 0 29 0 0 1 @temp0) ; "SPACE QUEST: The Next Mutation            Score:"
		(Format @temp50 {%s %d} @temp0 gScore)
		(Display @temp50 dsCOORD 4 1 dsFONT gUserFont dsCOLOR 6)
		(Display @temp50 dsCOORD 6 3 dsFONT gUserFont dsCOLOR 4)
		(Display @temp50 dsCOORD 5 2 dsFONT gUserFont dsCOLOR 0)
		(Graph grDRAW_LINE 0 0 0 319 7 -1 -1)
		(Graph grDRAW_LINE 0 0 9 0 6 -1 -1)
		(Graph grDRAW_LINE 9 0 9 319 4 -1 -1)
		(Graph grDRAW_LINE 0 319 9 319 3 -1 -1)
		(Graph grUPDATE_BOX 0 0 10 319 1)
		(SetPort temp100)
	)
)

(instance sq5IconBar of IconBar
	(properties)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (= temp2 0))
		(= temp3 (GetPort))
		(= temp4 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize:)
			)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(temp2 modNum:)
							modeless: 1
							init:
						)
						(Animate (gCast elements:) 0)
						(SetPort temp3)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
					(Animate (gCast elements:) 0)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(gSystemWindow eraseOnly: temp4)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
			(Animate (gCast elements:) 0)
		)
		(SetPort temp3)
		(if (not (helpIconItem onMe: temp0))
			(self dispatchEvent: temp0)
		)
	)

	(method (show)
		(if (IsObject curInvIcon)
			(curInvIcon loop: 2)
		)
		(super show:)
		(if (IsObject curInvIcon)
			(curInvIcon loop: 1)
		)
	)

	(method (hide)
		(super hide: &rest)
		(gGame setCursor: gTheCursor 1)
	)
)

(class SQ5 of Game
	(properties)

	(method (init &tmp [temp0 7] temp7)
		Print
		DButton
		DColorButton
		Smopper
		SQEgo
		StopWalk
		BorderWindow
		SpeakWindow
		Polygon
		PolyPath
		Timer
		IconBar
		ScrollInsetWindow
		ScrollableInventory
		(ScriptID 982)
		RTRandCycle
		Scaler
		Narrator
		((ScriptID 15 0) init:) ; invCode
		(super init:)
		(= gEgo ego)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		(= gMsgType 1)
		(= gUseSortedFeatures 1)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= gPossibleScore 5000)
		(= gUserFont 1605)
		(= gVersion {x.yyy.zzz})
		(= temp7 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp7)
		(FileIO fiCLOSE temp7)
		(= global123 6)
		(TextFonts 1605 999 1005 1007 1008 2106 1307 2306 5220)
		(TextColors 0 15 26 31 34 52 63)
		(= global163 (regWalkList add:))
		(= gNarrator sQ5Narrator)
		(= gSystemWindow sq5Win)
		(= gSq5Win sq5Win)
		(proc12_0)
		(= gEatMice 30)
		(= gTextSpeed 2)
		(gGame setCursor: gTheCursor 1 304 172 detailLevel: 3)
		((= gSq5Music1 sq5Music1) number: 1 owner: self flags: 1 init:)
		((= gSq5Music2 sq5Music2) number: 1 owner: self flags: 1 init:)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global102 (Graph grGET_COLOURS))
		(= gSpeakWindow (SpeakWindow new:))
		(gSystemWindow color: 0 back: global159)
		(= gTheIconBar sq5IconBar)
		(gTheIconBar
			add: icon0 icon1 icon2 icon3 icon4 icon6 icon7 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 5
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			walkIconItem: icon0
			disable: 5
			disable:
			state: 3072
		)
		(DisposeScript 12)
		(= gNormalCursor 999)
		(= gDoVerbCode lb2DoVerbCode)
		(= gFtrInitializer lb2FtrInit)
		(= gLb2ApproachCode lb2ApproachCode)
		(= gMessager testMessager)
		(= gStopGroop stopGroop)
		(= gPMouse PseudoMouse)
		(= global105 1)
		(gEgo setLoop: gStopGroop)
		(self newRoom: 100)
	)

	(method (quitGame &tmp temp0 temp1)
		(= temp1 ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 999)
		(if
			(= temp0
				(Print
					font: gUserFont
					width: 75
					mode: 1
					addText: 19 1 0 1 0 0 0 ; "Are You Sure?"
					addColorButton: 1 19 1 0 2 0 20 0 ; "YES"
					addColorButton: 0 19 1 0 3 0 30 0 ; "NO"
					init:
				)
			)
			(Print addText: 19 1 0 4 0 0 0 init:) ; "Thank You for Playing: |f5|Space Quest: The Next Mutation"
			(super quitGame: &rest)
		else
			(gGame setCursor: temp1)
		)
	)

	(method (restart &tmp temp0 temp1)
		(= temp1 ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 999)
		(if
			(= temp0
				(Print
					font: gUserFont
					width: 75
					window: gSystemWindow
					mode: 1
					addText: 20 1 0 1 0 0 0 ; "Are you sure you want to restart?"
					addColorButton: 1 20 1 0 2 0 30 0 ; "Yes"
					addColorButton: 0 20 1 0 3 0 40 0 ; "No"
					init:
				)
			)
			(super restart: &rest)
		else
			(gGame setCursor: temp1)
		)
	)

	(method (restore &tmp temp0 temp1)
		(super restore: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(if (gSounds size:)
			(for ((= temp0 0)) (< temp0 (gSounds size:)) ((++ temp0))
				(= temp1 (gSounds at: temp0))
				(temp1 play:)
			)
		)
	)

	(method (save)
		(super save: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1 init:)
		(self setCursor: 996 1)
		(while (not gQuit)
			(self doit:)
		)
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
			(SetCursor param3 param4)
		)
		(return temp0)
	)

	(method (pragmaFail)
		(if (User canControl:)
			(switch ((gUser curEvent:) message:)
				(4
					(gMessager say: 0 4 0 (Random 1 2) 0 0)
				)
				(2
					(gMessager say: 0 2 0 (Random 1 2) 0 0)
				)
				(else
					(if (not (OneOf ((gUser curEvent:) message:) 24 1))
						(gMessager say: 0 7 0 (Random 2 3) 0 0)
					)
				)
			)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(if (OneOf gCurRoomNum 100 104 110 106 107)
				(proc0_11)
			else
				(sq5StatusLineCode doit:)
			)
		)
		(super doit: &rest)
	)

	(method (startRoom roomNum &tmp [temp0 2] temp2 temp3)
		(if (OneOf roomNum 100 104 110 106 107)
			(proc0_11)
		else
			(sq5StatusLineCode doit:)
		)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 11) doit: roomNum) ; disposeCode
		(= temp2 (- (MemoryInfo 1) 10)) ; FreeHeap
		(= temp3 (MemoryInfo 0)) ; LargestPtr
		(if
			(and
				(> temp2 temp3)
				(Print
					addText: {You have a Memory FRAG} 0 14
					addTextF: {FreeHeap: %x, Largest Pointer: %x} temp2 temp3
					addButton: 0 {Who Cares:} 10 85
					addButton: 1 {Debug on:} 10 70
					init:
				)
			)
			(SetDebug)
		)
		(if gDebugOn
			(SetDebug)
		)
		(cond
			(
				(OneOf
					roomNum
					106
					107
					200
					201
					202
					203
					204
					205
					206
					212
					213
					215
					222
					225
					226
					228
					230
					240
					250
					280
					290
					295
				)
				(ScriptID 210) ; eureka
			)
			(
				(OneOf
					roomNum
					110
					115
					117
					119
					121
					122
					123
					125
					127
					132
					133
					135
					137
					165
					166
					195
				)
				RegPolyPath
				(ScriptID 109) ; starCon
			)
			((OneOf roomNum 300 305 310 315 320 325 330 335)
				(ScriptID 350) ; kiz
			)
			((OneOf roomNum 500 510 520 530)
				(ScriptID 505) ; sbar
			)
			((OneOf roomNum 730 740 750 760 770 790)
				(ScriptID 31) ; genetix
			)
		)
		(super startRoom: roomNum)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_TAB
						(if (not (& ((gTheIconBar at: 6) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(gInventory showSelf: gEgo)
							(event claimed: 1)
						)
					)
					(KEY_CONTROL
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(gGame quitGame:)
							(event claimed: 1)
						)
					)
					(JOY_RIGHT
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							((ScriptID 24 0) init:) ; gameControlCode
						)
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
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(= temp0 gTheCursor)
							(gGame save:)
							(gGame setCursor: temp0 1)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if gFastCast
								(return gFastCast)
							)
							(= temp0 gTheCursor)
							(gGame restore:)
							(gGame setCursor: temp0 1)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (gUser controls:)
							(= global123 (gEgo moveSpeed:))
							(= global123 (Max 0 (-- global123)))
							(gEgo setSpeed: global123)
						)
					)
					(KEY_SUBTRACT
						(if (gUser controls:)
							(= global123 (gEgo moveSpeed:))
							(++ global123)
							(gEgo setSpeed: global123)
						)
					)
					($003d ; =
						(if (gUser controls:)
							(gEgo setSpeed: 6)
						)
					)
					(else
						(if global105
							((ScriptID 10) handleEvent: event) ; debugHandler
							((ScriptID 10) dispose:) ; debugHandler
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)

	(method (handsOff)
		(if (not global108)
			(= global108 (gTheIconBar curIcon:))
		)
		(= global109 (gUser canControl:))
		(= global110 (gUser canInput:))
		(gUser canControl: 0 canInput: 0)
		(gEgo setMotion: 0)
		(= global111 0)
		(gTheIconBar eachElementDo: #perform checkIcon)
		(gTheIconBar curIcon: (gTheIconBar at: 7))
		(gTheIconBar disable:)
		(gTheIconBar disable: 0 1 2 3 4 5 6 7)
		(gGame setCursor: 996)
	)

	(method (handsOn param1)
		(gTheIconBar enable:)
		(gUser canControl: 1 canInput: 1)
		(if
			(and
				(OneOf (gCurRoom number:) 730 740 750 760 770 790)
				(IsFlag 22)
			)
			(gTheIconBar enable: 0 1 3 7)
		else
			(gTheIconBar enable: 0 1 2 3 4 5 6 7)
		)
		(if (and argc param1)
			(proc0_4)
		)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 5)
		)
		(if global108
			(gTheIconBar curIcon: global108)
			(gGame setCursor: (global108 cursor:))
			(= global108 0)
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 5))
					(not (gTheIconBar curInvIcon:))
				)
				(gTheIconBar advanceCurIcon:)
			)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(= gTheCursor ((gTheIconBar curIcon:) cursor:))
	)

	(method (showAbout)
		((ScriptID 13 0) doit:) ; aboutCode
		(DisposeScript 13)
	)

	(method (showControls &tmp temp0)
		(= temp0 ((gTheIconBar curIcon:) cursor:))
		((ScriptID 24 0) doit:) ; gameControlCode
		(gGameControls dispose:)
		(gGame setCursor: temp0 1)
	)
)

(instance walkCursor of Cursor
	(properties
		view 980
	)

	(method (init)
		(cond
			((IsFlag 22)
				(= loop 1)
			)
			((and (== gCurRoomNum 119) (== (gEgo view:) 136))
				(= loop 3)
			)
			(else
				(= loop 0)
			)
		)
		(super init: &rest)
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 980
		type 20480
		message 3
		signal 65
		maskView 990
		maskLoop 13
		noun 28
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(= cursor walkCursor)
		(super init:)
	)

	(method (show)
		(cond
			((IsFlag 22)
				(= loop 14)
			)
			((and (== gCurRoomNum 119) (== (gEgo view:) 136))
				(= loop 15)
			)
			(else
				(= loop 0)
			)
		)
		(super show: &rest)
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
		view 990
		loop 1
		cel 0
		cursor 981
		message 1
		signal 65
		maskView 990
		maskLoop 13
		noun 16
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 982
		message 4
		signal 65
		maskView 990
		maskLoop 13
		noun 6
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 983
		message 2
		signal 65
		maskView 990
		maskLoop 13
		maskCel 4
		noun 26
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 10
		cel 1
		cursor 984
		message 24
		signal 65
		maskView 990
		maskLoop 13
		maskCel 4
		noun 2
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		message 0
		signal 65
		maskView 990
		maskLoop 13
		maskCel 4
		noun 4
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
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
										(CelWide (temp2 view:) 2 (temp2 cel:))
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
										(CelHigh (temp2 view:) 2 (temp2 cel:))
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= temp2 (gTheIconBar curInvIcon:))
						(DrawCel (temp2 view:) 2 (temp2 cel:) temp3 temp4 -1)
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
											2
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
										2
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
								2
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

(instance icon7 of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		type 0
		message 0
		signal 67
		maskView 990
		maskLoop 13
		noun 15
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gInventory showSelf: gEgo)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 7
		signal 67
		maskView 990
		maskLoop 13
		noun 3
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(super init:)
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
		view 990
		loop 9
		cel 0
		cursor 989
		type 8192
		message 5
		signal 3
		maskView 990
		maskLoop 13
		noun 7
		helpVerb 5
	)

	(method (init)
		(= lowlightColor global160)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super init:)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= global111 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance lb2DoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(if (User canControl:)
			(if (== param2 gEgo)
				(if (Message msgSIZE 0 22 param1 0 1)
					(gMessager say: 22 param1 0 0 0 0)
				else
					(gMessager say: 22 0 0 (Random 1 2) 0 0)
				)
			else
				(switch param1
					(4
						(gMessager say: 0 4 0 (Random 1 2) 0 0)
					)
					(2
						(gMessager say: 0 2 0 (Random 1 2) 0 0)
					)
					(else
						(if (not (OneOf param1 24 1))
							(gMessager say: 0 7 0 (Random 2 3) 0 0)
						)
					)
				)
			)
		)
	)
)

(instance lb2FtrInit of Code
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

(instance testMessager of Messager
	(properties)

	(method (say param1 &tmp temp0 temp1 temp2 temp3 [temp4 20] temp24)
		(= temp0 (= temp1 (= temp2 (= curSequence 0))))
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
		)
		(if (== (= temp0 [param1 0]) -1)
			(if (and (> argc 1) (IsObject [param1 1]))
				(= caller [param1 1])
			)
			(self sayNext:)
		else
			(if (and (> argc 1) [param1 1])
				(= temp1 [param1 1])
			)
			(if (and (> argc 2) [param1 2])
				(= temp2 [param1 2])
			)
			(if (and (> argc 3) [param1 3])
				(= oneOnly 1)
				(= curSequence [param1 3])
			else
				(= curSequence 1)
			)
			(= temp24 4)
			(if
				(and
					(> argc 4)
					[param1 temp24]
					(not (IsObject [param1 temp24]))
				)
				(= lastSequence [param1 temp24])
				(++ temp24)
				(= oneOnly 0)
			else
				(= lastSequence 0)
			)
			(if (and (> argc temp24) [param1 temp24])
				(= caller [param1 temp24])
			else
				(= caller 0)
			)
			(= temp3 (if (> argc (++ temp24)) [param1 temp24] else gCurRoomNum))
			(= global138 temp0)
			(= global139 temp1)
			(= global140 temp2)
			(= global141 lastSequence)
			(if
				(or
					(and
						(& gMsgType $0001)
						(Message msgGET temp3 temp0 temp1 temp2 curSequence)
					)
					0
				)
				(self sayNext: temp3 temp0 temp1 temp2 curSequence)
			else
				(Print
					addTextF:
						{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
						temp3
						temp0
						temp1
						temp2
						curSequence
					init:
				)
				(self dispose:)
			)
		)
	)

	(method (findTalker param1 &tmp temp0)
		(= global122 param1)
		(if
			(= temp0
				(switch param1
					(99
						(if (== gCurRoomNum 666)
							(ScriptID 666 1) ; MISSING SCRIPT
						else
							gNarrator
						)
					)
					(47
						(if (OneOf gCurRoomNum 201 206)
							(if (== gCurRoomNum 201)
								(ScriptID 209 18) ; viewPortTalker
							else
								(ScriptID gCurRoomNum 18)
							)
						else
							(ScriptID 1882 26) ; Bea
						)
					)
					(26
						(if (OneOf gCurRoomNum 119 127 240 1041 660)
							(ScriptID gCurRoomNum 10)
						else
							(ScriptID 1882 26) ; Bea
						)
					)
					(8
						(ScriptID 109 7) ; cadetsTalker
					)
					(29
						(ScriptID 125 1) ; daveTalker
					)
					(23
						(if (OneOf gCurRoomNum 530 730 666 240)
							(ScriptID gCurRoomNum 11)
						else
							(ScriptID 1884 23) ; tkrCliffy
						)
					)
					(18
						(ScriptID 127 3) ; danteTalker
					)
					(4
						(ScriptID 850 1) ; dTalker
					)
					(21
						(if (OneOf gCurRoomNum 201 520 1041)
							(ScriptID gCurRoomNum 12)
						else
							(ScriptID 1885 21) ; Droole
						)
					)
					(27
						(ScriptID 135 2) ; dumbTalker
					)
					(36
						(if (== gCurRoomNum 801)
							(ScriptID 801 1) ; alien1Tkr
						else
							(ScriptID 109 7) ; cadetsTalker
						)
					)
					(37
						(if (== gCurRoomNum 801)
							(ScriptID 801 2) ; alien2Tkr
						else
							(ScriptID 109 7) ; cadetsTalker
						)
					)
					(22
						(if
							(OneOf
								gCurRoomNum
								201
								760
								520
								620
								640
								660
								1040
								1041
							)
							(if (!= (gCurRoom curPic:) 110)
								(ScriptID gCurRoomNum 13)
							else
								(ScriptID 1886 22) ; Flo
							)
						else
							(ScriptID 1886 22) ; Flo
						)
					)
					(25
						(if (OneOf gCurRoomNum 104 119 127 201 206 520 850)
							(if (== gCurRoomNum 201)
								(ScriptID 209 14) ; viewPortTalker
							else
								(ScriptID gCurRoomNum 14)
							)
						else
							(ScriptID 1883 25) ; Quirk
						)
					)
					(3
						(ScriptID gCurRoomNum 14)
					)
					(1
						(if (== gCurRoomNum 119)
							(ScriptID 119 2) ; quirkTalker2
						else
							(ScriptID gCurRoomNum 14)
						)
					)
					(7
						(ScriptID 1040 5) ; tkrRoger
					)
					(19
						(if
							(OneOf
								gCurRoomNum
								104
								119
								125
								135
								165
								201
								228
								230
								240
								520
								530
								730
								750
								760
								1041
								666
								850
								660
								440
								620
								640
							)
							(if
								(and
									(OneOf gCurRoomNum 730 740 760 790)
									(not (IsFlag 22))
								)
								(ScriptID 1880 19) ; tkrRoger
							else
								(ScriptID gCurRoomNum 15)
							)
						else
							(switch gCurRoomNum
								(510
									(ScriptID 510 1) ; genTalker
								)
								(else
									(ScriptID 1880 19) ; tkrRoger
								)
							)
						)
					)
					(17
						(ScriptID 119 1) ; genTalker
					)
					(28
						(ScriptID 135 1) ; smartTalker
					)
					(24
						(if (OneOf gCurRoomNum 201 999)
							(if (== gCurRoomNum 201)
								(if (== gWD40State 2)
									(ScriptID 1887 24) ; tkrWD40
								else
									(ScriptID 209 16) ; viewPortTalker
								)
							else
								(ScriptID gCurRoomNum 16)
							)
						else
							(ScriptID 1887 24) ; tkrWD40
						)
					)
					(38
						(if (OneOf gCurRoomNum 520)
							(ScriptID gCurRoomNum 17)
						else
							(ScriptID 1891 38) ; MISSING SCRIPT
						)
					)
					(46
						(if (OneOf gCurRoomNum 450 440)
							(ScriptID gCurRoomNum 19)
						else
							(ScriptID 1895 46) ; MISSING SCRIPT
						)
					)
					(5
						(ScriptID 115 2) ; guardTalker
					)
					(6
						(ScriptID 117 2) ; guardTalker
					)
					(42
						(ScriptID 510 1) ; genTalker
					)
					(43
						(ScriptID 510 1) ; genTalker
					)
					(45
						(ScriptID 520 1) ; bTalker
					)
					(49
						(ScriptID 500 10) ; genTalker
					)
					(9
						(ScriptID 500 10) ; genTalker
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance lb2ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(31 16)
				(24 32)
				(29 64)
				(25 128)
				(else -32768)
			)
		)
	)
)

(instance egoStopWalk of FiddleStopWalk
	(properties)
)

(instance regWalkList of List
	(properties)
)

(instance rm0Sound of Sound
	(properties
		priority 15
	)
)

