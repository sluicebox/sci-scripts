;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use n802)
(use RegionPath)
(use MoveToY)
(use SQEgo)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use StopWalk)
(use Grooper)
(use Sound)
(use Game)
(use Inventory)
(use User)
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
	gSq4FtrInit
	; 55
	gSq4DoVerbCode
	global56
	global57 = 1
	global58
	gIconBar
	; 60
	global60
	global61
	gSq4KeyDownHandler
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	global66
	gUseObstacles
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
	gEatMice
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
	gATMBuckazoidCount
	; 170
	global170
	global171
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
	(= temp0 (gIconBar curIcon:))
	(gIconBar disable: 0 1 4 5 2 3 6 7)
	(gIconBar curIcon: temp0)
	(gGame setCursor: gWaitCursor 1)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gIconBar enable: 0 1 4 5 2 3 6 7)
	(gGame setCursor: ((gIconBar curIcon:) cursor:))
)

(procedure (HaveMem param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (StepOn param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (localproc_0 param1 param2) ; UNUSED
	(param1 param2: &rest)
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

(procedure (EgoDead &tmp [temp0 80])
	(if argc
		(Format @temp0 &rest)
	else
		(Format @temp0 0 25) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
	)
	(gLongSong number: 826 vol: 127 loop: 1 play:)
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

(procedure (SetScore param1 param2) ; UNUSED
	(if (not (IsFlag param1))
		(gGame changeScore: param2)
		(SetFlag param1)
	)
)

(procedure (proc0_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (== argc 1)
		(Display 0 26 dsRESTOREPIXELS [param1 0])
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

(procedure (proc0_14 param1 param2 &tmp [temp0 100] [temp100 4] temp104)
	(TextSize @temp100 param1 0 0)
	(StrCpy @temp0 {\06})
	(for
		((= temp104 (/ (- 326 (- [temp100 3] [temp100 0])) 2)))
		(> temp104 0)
		((-- temp104))
		
		(StrCat @temp0 {\06})
	)
	(StrCat @temp0 param1)
	(DrawStatus @temp0 param2 0)
)

(instance ego of SQEgo
	(properties
		description {Roger Wilco}
		lookStr {Roger Wilco, space guy.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 0 0) ; "You talk to yourself but are stumped for a reply."
			)
			(4 ; Do
				(Print 0 1) ; "Hey! Keep your hands off yourself! This is a family game."
			)
			(3 ; Taste
				(Print 0 2) ; "I'll bet you wish you could!"
			)
			(2 ; Smell
				(Print 0 3) ; "Ahhh! The aroma of several adventure games emanates from your person."
			)
			(6 ; Inventory
				(switch invItem
					(13 ; cigar
						(Print 0 4) ; "You slide the pre-smoked tobacco tube in your mouth and, after noticing a hint of grease and cruel breath, decide you'll save it for a special occasion."
					)
					(else 0)
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
		view 4
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

(instance sq4KeyDownHandler of EventHandler
	(properties)
)

(instance sq4MouseDownHandler of EventHandler
	(properties)
)

(class sq4DirHandler of EventHandler
	(properties
		cursorInc 2
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((super handleEvent: event))
			((and (!= (self indexOf: (gIconBar curIcon:)) 0) (User canInput:))
				(= temp0 (event x:))
				(= temp1 (event y:))
				(cond
					((& (event modifiers:) emSHIFT)
						(if (> (Abs cursorInc) 2)
							(= cursorInc 2)
						)
					)
					((< cursorInc 20)
						(= cursorInc 20)
					)
				)
				(switch (event message:)
					(JOY_UP
						(-= temp1 cursorInc)
					)
					(JOY_UPRIGHT
						(+= temp0 cursorInc)
						(-= temp1 cursorInc)
					)
					(JOY_RIGHT
						(+= temp0 cursorInc)
					)
					(JOY_DOWNRIGHT
						(+= temp0 cursorInc)
						(+= temp1 cursorInc)
					)
					(JOY_DOWN
						(+= temp1 cursorInc)
					)
					(JOY_DOWNLEFT
						(-= temp0 cursorInc)
						(+= temp1 cursorInc)
					)
					(JOY_LEFT
						(-= temp0 cursorInc)
					)
					(JOY_UPLEFT
						(-= temp0 cursorInc)
						(-= temp1 cursorInc)
					)
					(JOY_NULL
						(= cursorInc 2)
					)
				)
				(gGame setCursor: gTheCursor 1 temp0 temp1)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance sq4 of Game
	(properties)

	(method (init)
		(= gSystemWindow BorderWindow)
		(proc802_0)
		(= gStopGroop stopGroop)
		(= gUseSortedFeatures 1)
		MoveToX
		(super init:)
		(StrCpy @gSysLogPath {})
		(= gSq4DoVerbCode sq4DoVerbCode)
		(= gSq4FtrInit sq4FtrInit)
		((= gSq4KeyDownHandler sq4KeyDownHandler) add:)
		((= gGameControls sq4MouseDownHandler) add: gCast gFeatures)
		((= gFtrInitializer sq4DirHandler) add:)
		(self egoMoveSpeed: 0 setCursor: gTheCursor 1 304 172)
		((= gEgo ego)
			_head: (= gEgoHead egoHead)
			moveSpeed: (self egoMoveSpeed:)
			cycleSpeed: (self egoMoveSpeed:)
		)
		((gEgo _head:) client: gEgo)
		(User
			alterEgo: gEgo
			verbMessager: 0
			blocks: 0
			canControl: 0
			canInput: 0
		)
		((= gLongSong longSong) owner: self init:)
		((= gLongSong2 longSong2) owner: self init:)
		(= gWaitCursor 997)
		(= gPossibleScore 69)
		(= gUserFont 4)
		(= gVersion {x.yyy})
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(ClearFlag 23)
		else
			(SetFlag 23)
		)
		((= gIconBar IconBar)
			add: icon0 icon1 icon6 icon7 icon2 icon3 icon4 icon5 icon8 icon9
			eachElementDo: #init
			curIcon: icon0
			useIconItem: icon4
			disable: 6
			helpIconItem: icon9
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
				spCard
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
			window: InsetWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(GameControls
			window: gcWindow
			add:
				iconOk
				(detailSlider
					theObj: self
					selector: #detailLevel
					maxValue: 3
					minValue: 0
					yourself:
				)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					maxValue: 15
					minValue: 0
					yourself:
				)
				(moveSpeedSlider
					theObj: self
					selector: #setSpeed
					maxValue: 15
					minValue: 0
					yourself:
				)
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 811 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(buckazoid owner: gEgo)
		(= global107 (if (GameIsRestarting) 59 else 1))
		(self newRoom: 803) ; speedTest
	)

	(method (quitGame)
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
					946
					2
					0
				)
		)
	)

	(method (setSpeed param1)
		(= param1 (Abs (- param1 15)))
		(super setSpeed: param1)
	)

	(method (doit)
		(super doit:)
		((ScriptID 808 0) doit:) ; nosePick
	)

	(method (startRoom param1)
		((ScriptID 801) doit: param1) ; disposeCode
		(if
			(and
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(Print 0 6 #button {Who cares} 0 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
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
				)
			)
			(ScriptID 808) ; nosePick
		)
		(ScriptID 982)
		(super startRoom: param1)
		(UnLoad 131 -1)
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
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (== (event message:) KEY_TAB)
					(Inv showSelf: gEgo)
				)
				(if (and (== (event message:) KEY_SHIFTTAB) (HaveMouse))
					(Inv showSelf: gEgo)
				)
				(if (and (not (event claimed:)) (== (event message:) KEY_ALT_n))
					(if (HaveMem 1536)
						((ScriptID 952) doit: @gSysLogPath) ; sysLogger
					else
						(Print 0 7) ; "Not Enough Memory!!"
					)
					(event claimed: 1)
				else
					(gSq4KeyDownHandler handleEvent: event)
				)
				(if (not (event claimed:))
					((ScriptID 800) handleEvent: event) ; debugHandler
				)
			)
			(evMOUSEBUTTON
				(if (gGameControls handleEvent: event)
				else
					((ScriptID 800) handleEvent: event) ; debugHandler
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
		lowlightColor 5
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 19
		message 1
		helpStr {Select this Icon then select an inventory item you'd like a description of.}
		lowlightColor 5
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 20
		message 4
		helpStr {This allows you to do something to an item.}
		lowlightColor 5
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 29
		message 9
		lowlightColor 5
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr {This allows you to select an item.}
		lowlightColor 5
	)
)

(instance buckazoid of InvI
	(properties
		view 700
		cursor 1
		signal 2
		lowlightColor 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Printf 0 8 gBuckazoidCount) ; "You have %d recession-riddled Buckazoids."
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
		lowlightColor 2
		description {glass jar}
		owner 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (self cel:) 2)
					(Print 0 9) ; "You have a jar of green acid."
				else
					(Print 0 10) ; "You have an empty jar."
				)
			)
		)
	)
)

(instance spCard of InvI
	(properties
		view 700
		cel 3
		cursor 14
		signal 2
		lowlightColor 2
		description {keycard}
	)
)

(instance hintbook of InvI
	(properties
		view 700
		cel 4
		cursor 18
		signal 2
		lowlightColor 2
		description {An SQ 4 hintbook.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(Inv curIcon: (gInventory at: 10) hide:) ; pen
					(gCurRoom setScript: (ScriptID 708 0)) ; hintBookScript
				else
					(Print 0 11) ; "You're far too busy for that now."
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
		lowlightColor 2
		description {Yes, it's a Reveal-O-matic electric hint revealer.}
	)
)

(instance atmCard of InvI
	(properties
		view 700
		cel 6
		cursor 2
		signal 2
		lowlightColor 2
		description {An AutoBucks Teller Machine card.}
	)
)

(instance plug of InvI
	(properties
		view 700
		cel 7
		cursor 5
		signal 2
		lowlightColor 2
		description {A PocketPal(tm) adaptor plug.}
	)
)

(instance cigar of InvI
	(properties
		view 700
		cel 8
		cursor 3
		signal 2
		lowlightColor 2
		description {An obviously used stogie.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(6 ; Inventory
				(if (== invItem 14) ; matches
					(if state
						(Print 0 12) ; "The horrid-smelling smoke eminating from its tip would indicate that the cigar is already lit."
					else
						(Print 0 13) ; "You light the cigar."
						(= state 1)
					)
				)
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
		lowlightColor 2
		description {A book of matches.}
	)
)

(instance diskette of InvI
	(properties
		view 700
		cel 10
		signal 2
		lowlightColor 2
		description {A diskette.}
	)
)

(instance rabbit of InvI
	(properties
		view 700
		cel 11
		cursor 9
		signal 2
		lowlightColor 2
		description {cute bunny}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (== view 700)
					(if (not ((gInventory at: 4) owner:)) ; battery
						(Inv hide:)
						(self view: 701 loop: 0 cel: 0)
						(Inv showSelf: gEgo)
					else
						(Print 0 14) ; "A darn cute bunny."
					)
				else
					(Inv hide:)
					(self view: 700 loop: 0 cel: 11)
					(Inv showSelf: gEgo)
				)
			)
			(4 ; Do
				(if (== view 700)
					0
				else
					(Print 0 15) ; "You extract the portable power pellet from the rear confines of the hare's polyplastoid torso."
					(Inv hide:)
					(gEgo get: 4) ; battery
					(self view: 700 loop: 0 cel: 11)
					(Inv showSelf: gEgo)
				)
			)
			(6 ; Inventory
				(switch invItem
					(4 ; battery
						(Print 0 16) ; "You clumsily insert the battery into the fury burrow inhabitant's hollow trunk."
						(Inv hide:)
						(gEgo put: 4 0) ; battery
						(Inv showSelf: gEgo)
					)
					(else
						(Print 0 17) ; "That won't work on the bunny."
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
		lowlightColor 2
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
		lowlightColor 2
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
		lowlightColor 2
		description {A crummy piece of rope}
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
		lowlightColor 2
		description {A handy Dandy PocketPal portable terminal.}
		owner 55
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (== view 700)
					(if (== ((gInventory at: 4) owner:) 1) ; battery
						(Print 0 18) ; "Your PocketPal now has power. Now all you need is a place to use it."
					else
						(Inv hide:)
						(self view: 701 loop: 0 cel: 1)
						(Inv showSelf: gEgo)
					)
				else
					(Inv hide:)
					(self view: 700 loop: 0 cel: 15)
					(Inv showSelf: gEgo)
				)
			)
			(4 ; Do
				(if (== ((gInventory at: 4) owner:) 1) ; battery
					(Print 0 19) ; "You liberate the battery from the PocketPal."
					(Inv hide:)
					(gEgo get: 4) ; battery
					(Inv showSelf: gEgo)
				else
					(Print 0 20) ; "This is just a dumb terminal. It won't do anything by itself."
				)
			)
			(6 ; Inventory
				(switch invItem
					(4 ; battery
						(Print 0 21) ; "You plug the mobile power cylinder into the laptop."
						(Inv hide:)
						(self view: 700 loop: 1 cel: 15)
						(gEgo put: 4 1) ; battery
						(Inv showSelf: gEgo)
					)
					(12 ; plug
						(Print 0 22) ; "You attach the plug to the PocketPal."
						(gEgo put: 12 1) ; plug
						((Inv window:) dispose:)
						(Inv showSelf: gEgo)
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
		lowlightColor 2
		description {Paper-wrapped gum - a Pinedale dining delight.}
		owner 297
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if cel
					(Print 0 23) ; "These symbols look vaguely familiar. Now, where have you seen them?"
				else
					(Print 0 24) ; "Ummm! This lumpy paper-wrapped wad looks mighty interesting."
				)
			)
			(4 ; Do
				(if (not cel)
					(Inv hide:)
					(self view: 700 loop: 2 cel: 1)
					(Inv showSelf: gEgo)
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
		loop 2
		cel 2
		cursor 22
		signal 2
		lowlightColor 2
		description {A piece of unstable ordnance.}
		owner 40
	)
)

(instance icon0 of IconI
	(properties
		view 900
		loop 0
		cel 0
		cursor 6
		type 1
		message 0
		signal 65
		helpStr {This icon is for walking.}
		maskView 900
		maskLoop 14
		maskCel 1
		lowlightColor 5
	)
)

(instance icon1 of IconI
	(properties
		view 900
		loop 1
		cel 0
		cursor 19
		message 1
		signal 65
		helpStr {This icon is for looking.}
		maskView 900
		maskLoop 14
		maskCel 1
		lowlightColor 5
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 2
		cel 0
		cursor 20
		message 4
		signal 65
		helpStr {This icon is for doing.}
		maskView 900
		maskLoop 14
		lowlightColor 5
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
		lowlightColor 5
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 6
		signal 65
		helpStr {This icon is for current inv item.}
		maskView 900
		maskLoop 14
		maskCel 4
		lowlightColor 5
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
		helpStr {This icon brings up the inv window.}
		maskView 900
		maskLoop 14
		maskCel 2
		lowlightColor 5
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
		message 2
		signal 65
		helpStr {This icon is for smelling.}
		maskView 900
		maskLoop 14
		lowlightColor 5
	)
)

(instance icon7 of IconI
	(properties
		view 900
		loop 11
		cel 0
		cursor 31
		message 3
		signal 65
		helpStr {This icon is for tasting.}
		maskView 900
		maskLoop 14
		maskCel 1
		lowlightColor 5
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
		lowlightColor 5
	)

	(method (select)
		(if (super select:)
			(gIconBar hide:)
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
		message 9
		signal 3
		helpStr {This icon tells you about other icons.}
		maskView 900
		maskLoop 14
		lowlightColor 5
	)
)

(instance sq4DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(= temp0 (param2 description:))
		(switch param1
			(1
				(if (param2 facingMe: gEgo)
					(if (param2 lookStr:)
						(Print (param2 lookStr:))
					else
						(Printf 0 27 temp0) ; "It is, as you assumed, a %s."
					)
				)
			)
			(5
				(Printf 0 28 temp0) ; "You engage in a meaningful conversation with the %s."
			)
			(4)
			(6
				(Printf 0 29 temp0) ; "I guess that just doesn't work with the %s."
			)
			(2
				(switch (Random 0 1)
					(0
						(Print 0 30) ; "You've smelled better."
					)
					(1
						(Print 0 31) ; "You smell nothing of interest."
					)
				)
			)
			(3
				(Printf 0 32 temp0) ; "That's funny, no taste."
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

(instance gcWindow of BorderWindow
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
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 94 16 15)
		(DrawCel 947 1 0 135 16 15)
		(DrawCel 947 0 4 63 (- 15 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 3 101 (- 15 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 2 146 (- 15 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp5 (+ (= temp2 (+ 25 (CelHigh 947 0 1))) 30))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 global156)
		(= temp11 global157)
		(= temp10 global161)
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
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(- temp4 (+ temp13 1))
				(- temp5 (+ temp13 1))
				(- temp4 (+ temp13 1))
				temp10
				temp12
			)
		)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 0 33 gScore gPossibleScore) ; "Score: %d out of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			global161
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
			(+ 25 (CelHigh 947 0 1) 3)
		)
		(Format @temp14 0 34 gVersion) ; "Version: %s"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			global161
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
			(+ 25 (CelHigh 947 0 1) 3 16)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 67
		nsTop 15
		signal 128
		helpStr {Raises and lowers the level of graphics detail.}
		sliderView 947
		maxValue 3
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 107
		nsTop 15
		signal 128
		helpStr {Adjusts sound volume.}
		sliderView 947
		maxValue 15
	)
)

(instance moveSpeedSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 147
		nsTop 15
		signal 128
		helpStr {Adjusts the speed of the game's animation (within the limits of your computer's capability).}
		sliderView 947
		maxValue 15
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
		signal 387
		helpStr {Saves your current game.}
		lowlightColor 4
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
		signal 387
		helpStr {Restores a previously saved game.}
		lowlightColor 4
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
		signal 387
		helpStr {Restarts the Game.}
		lowlightColor 4
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
		lowlightColor 4
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
		lowlightColor 4
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
		signal 387
		lowlightColor 4
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
		lowlightColor 4
	)
)

