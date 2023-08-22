;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use n804)
(use eRS)
(use Smopper)
(use EcoWindow)
(use n819)
(use Cursor)
(use Talker)
(use Language)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	eco 0
	HandsOff 1
	HandsOn 2
	InitIconBar 3
	SetScore 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
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
	global101 = 4
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	gStopGroop
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
	gSoundEffects
	global118 = 1
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
	gDelph
	global227
	global228
	global229
	; 230
	global230
	gLongSong2
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
	global241
	global242
	global243 = 100
	global244
	; 245
	global245
	global246 = 1
	global247 = 1
	global248
	global249 = 42
	; 250
	global250
)

(procedure (HandsOff &tmp temp0)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 5 0 1 2 3 4 6 5)
	(gTheIconBar curIcon: temp0)
	(if gPMouse
		(gPMouse stop:)
	)
	(if (not (HaveMouse))
		(= global105 ((User curEvent:) x:))
		(= global106 ((User curEvent:) y:))
		(gGame setCursor: gWaitCursor 1)
		(MoveCursor 310 180)
	else
		(gGame setCursor: gWaitCursor 1)
	)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 5 0 1 2 3 5)
	(if (gTheIconBar curInvIcon:)
		(gTheIconBar enable: 4)
	)
	(if (IsFlag 15)
		(gTheIconBar enable: 6)
	)
	(gEgo
		moveSpeed: (gGame egoMoveSpeed:)
		cycleSpeed: (gGame egoMoveSpeed:)
	)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 4)
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(MoveCursor global105 global106)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
)

(procedure (InitIconBar)
	((= gTheIconBar IconBar)
		add:
			(icon0 cursor: travelC yourself:)
			(icon2 cursor: eyeC yourself:)
			(icon1 cursor: handC yourself:)
			(icon6 cursor: talkC yourself:)
			(icon4 cursor: invC yourself:)
			(icon5 cursor: arrowC yourself:)
			(icon3 cursor: bagC yourself:)
			(icon7 cursor: arrowC yourself:)
			(icon9 cursor: helpC 114)
		eachElementDo: #init
		eachElementDo: #highlightColor 0
		eachElementDo: #lowlightColor (proc819_8 global216 global216)
		curIcon: icon0
		useIconItem: icon4
		helpIconItem: icon9
		disable:
	)
	(icon5 message: (if (HaveMouse) 3840 else 9))
)

(procedure (SetScore param1 param2)
	(if (not (IsFlag param2))
		(gGame changeScore: param1)
		(ecoStatusLine doit:)
		(SetFlag param2)
		(pointsSound play:)
	)
)

(procedure (proc0_5 param1)
	(gTheIconBar curIcon: (gTheIconBar at: 4) curInvIcon: (Inv at: param1))
	((gTheIconBar at: 4) cursor: ((Inv at: param1) cursor:))
	(invC
		loop: ((gTheIconBar curInvIcon:) cursorLoop:)
		cel: ((gTheIconBar curInvIcon:) cursorCel:)
	)
	(if (User canInput:)
		((gTheIconBar at: 4) signal: (& ((gTheIconBar at: 4) signal:) $fffb))
		(gGame setCursor: invC 1)
	else
		(gGame setCursor: gTheCursor 1)
	)
)

(procedure (localproc_0 param1 &tmp [temp0 300])
	(proc932_8
		99
		(cond
			((< param1 100) 3)
			((< param1 200) 4)
			(else 5)
		)
		param1
		@temp0
	)
	(Print @temp0 #at -1 115)
)

(procedure (proc0_6 param1 param2 param3 param4 param5)
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

(procedure (proc0_7)
	(proc0_6 1026 1040 1051 1050 952)
)

(procedure (proc0_8)
	(ecoStatusLine doit:)
)

(instance arrowC of Cursor
	(properties
		view 957
		cel 8
	)
)

(instance nonC of Cursor ; UNUSED
	(properties
		view 957
		cel 9
	)
)

(instance eyeC of Cursor
	(properties
		view 957
	)
)

(instance travelC of Cursor
	(properties
		view 957
		cel 1
	)
)

(instance handC of Cursor
	(properties
		view 957
		cel 3
	)
)

(instance bagC of Cursor
	(properties
		view 957
		cel 4
	)
)

(instance talkC of Cursor
	(properties
		view 957
		cel 5
	)
)

(instance helpC of Cursor
	(properties
		view 957
		cel 6
	)
)

(instance waitC of Cursor
	(properties
		view 957
		cel 7
	)
)

(instance invC of Cursor
	(properties
		view 958
	)
)

(instance ego of Ego
	(properties
		sightAngle 180
		view 800
	)

	(method (get param1)
		(cond
			((== param1 23)
				(switch global233
					(1
						(jar loop: 4 cel: 11 cursorCel: 8)
					)
					(2
						(jar loop: 6 cel: 1 cursorCel: 9)
					)
				)
			)
			((and (== param1 4) (== global232 3))
				(rag loop: 2)
				(rag cel: 9)
				(rag cursorLoop: 0)
				(rag cursorCel: 2)
			)
		)
		(super get: param1 &rest)
		(proc0_5 param1)
	)

	(method (put param1 &tmp temp0)
		(super put: param1 &rest)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: 4)
		)
		(gTheIconBar curIcon: (gTheIconBar at: 0) advanceCurIcon:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 3) ; "Adam gets embarrassed when people stare."
			)
			(5 ; Talk
				((ScriptID 2 1) init: 1 1 0 1) ; Adam, "Talking to myself again, I guess!"
			)
			(3 ; Do
				(Narrator init: 2 0 3) ; "Hey! That tickles!"
			)
			(10 ; Recycle
				(Narrator init: 54 0 3) ; "Adam tries to stuff himself into the garbage bag but thinks better of it!"
			)
			(4 ; Inventory
				(switch invItem
					(8 ; scubaGear
						(if (OneOf gCurRoomNum 380 381)
							(gCurRoom notify:)
						else
							(Narrator init: 151 0 4) ; "Adam doesn't need the scuba gear until he's ready to go in the water."
						)
					)
					(9 ; airTanks
						(if (IsFlag 68)
							(ClearFlag 68)
							(gCurRoom notify: 68)
						else
							(Narrator init: 55 0 3) ; "Adam doesn't need to breathe through the airtanks yet."
						)
					)
					(21 ; healingPotion
						(Narrator init: 23 0 3) ; "Adam doesn't need the healing potion himself. He should save it for someone who's in need of a miracle."
					)
					(7 ; mackeral
						((ScriptID 2 1) init: 74 1 0 1) ; Adam, "Ugh!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class Delph of Actor
	(properties
		talkScript 0
	)
)

(instance delph of Delph
	(properties)

	(method (setHeading param1)
		(if (!= heading param1)
			(super setHeading: param1 &rest)
		else
			(return heading)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 8 0 3) ; "Delphineus will "offer his fin" to Adam when he wants to take him for a ride."
			)
			(2 ; Look
				(if lookStr
					(super doVerb: theVerb invItem &rest)
				else
					(Narrator init: 7 0 3) ; "Adam's dolphin pal, Delphineus, always looks like he's grinning."
				)
			)
			(4 ; Inventory
				((ScriptID 2 0) ; Delphineus
					init:
						(switch invItem
							(12 85) ; trident
							(11 86) ; conchShell
							(22 87) ; hermetShell
							(21 88) ; healingPotion
							(10 89) ; bikeCage
							(20 90) ; starFish
							(else 91)
						)
						1
						0
						1
				)
			)
			(10 ; Recycle
				((ScriptID 2 0) init: 2 1 0 1) ; Delphineus, "Phew. Don't put that garbage bag near me!"
			)
			(5 ; Talk
				(cond
					((gCurRoom script:)
						(Narrator init: 56 0 3) ; "There's no time to talk to Delphineus now."
					)
					((and talkScript (IsObject talkScript))
						(gCurRoom setScript: talkScript)
					)
					((IsFlag 107)
						(gCurRoom setScript: (ScriptID 1 0)) ; jokeScript
					)
					(
						(and
							(IsFlag 143)
							(not (IsFlag 334))
							(or
								(not (or (gEgo has: 26) (IsFlag 332))) ; steelCable
								(not (or (gEgo has: 27) (IsFlag 331))) ; float
							)
						)
						((ScriptID 2 0) init: (Random 79 81) 1 0 1) ; Delphineus
					)
					(else
						((ScriptID 2 0) init: (Random 3 5) 1 0 1) ; Delphineus
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
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
			(gEgo view: ((gEgo cycler:) vStopped:))
		)
		(super doit: &rest)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance soundEffects of Sound
	(properties)

	(method (check)
		(DoSound sndUPDATE_CUES self)
		(if (self signal:)
			(self prevSignal: (self signal:) signal: 0)
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
		number 900
		priority 15
	)
)

(instance ecoKeyDownHandler of EventHandler
	(properties)
)

(instance ecoMouseDownHandler of EventHandler
	(properties)
)

(instance ecoDirectionHandler of EventHandler
	(properties)
)

(instance eco of Game
	(properties
		printLang 0
	)

	(method (setCursor param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(if (IsObject param1)
			(param1 init:)
		else
			(arrowC init:)
		)
		(return temp0)
	)

	(method (init &tmp temp0 [temp1 5] [temp6 5])
		(StrSplit @temp1 @temp6 0)
		(= global250 (self printLang:))
		(= global227 1)
		(= gScore 0)
		(= gPossibleScore 725)
		(= gSystemWindow ecoWin)
		(proc804_3)
		(= gDelph delph)
		(= gStopGroop stopGroop)
		(= gUseSortedFeatures 1)
		Smopper
		Polygon
		PolyPath
		EcoRoom
		IconBar
		Inv
		(ScriptID 982)
		RandCycle
		(super init:)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode ecoDoVerbCode)
		(= gFtrInitializer ecoFtrInit)
		((= gKeyDownHandler ecoKeyDownHandler) add:)
		((= gMouseDownHandler ecoMouseDownHandler) add:)
		((= gDirectionHandler ecoDirectionHandler) add:)
		(= gPMouse PseudoMouse)
		(self egoMoveSpeed: 3 setSpeed: 0)
		((= gEgo ego)
			moveSpeed: (self egoMoveSpeed:)
			cycleSpeed: (self egoMoveSpeed:)
		)
		(User canControl: 0 canInput: 0 alterEgo: gEgo)
		((= gLongSong longSong) owner: self init: flags: 1)
		((= gLongSong2 longSong2) owner: self init:)
		(= gSoundEffects soundEffects)
		(= gVersion {x.yyy})
		(= gWaitCursor waitC)
		(= gNormalCursor arrowC)
		(= gUserFont 4)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global102 (Graph grGET_COLOURS))
		(ecoWin
			color: 24
			back: 25
			innerBordColor: 15
			midBordColor: 7
			outerBordColor: 20
		)
		(gcWin
			color: (proc819_8 global224 global211)
			back: (proc819_8 global224 global211)
		)
		(invWin
			topBordHgt: 5
			botBordHgt: 26
			color: 0
			priority: -1
			back: (proc819_8 global210 global210)
			topBordColor: (proc819_8 global217 global201)
			lftBordColor: (proc819_8 global217 global216)
			rgtBordColor: (proc819_8 global216 global216)
			botBordColor: (proc819_8 global213 global213)
			insideColor: (proc819_8 global215 global215)
			topBordColor2: (proc819_8 global213 global213)
			lftBordColor2: (proc819_8 global216 global220)
			botBordColor2: (proc819_8 global217 global201)
			botBordColor2: (proc819_8 global217 global201)
			rgtBordColor2: (proc819_8 global217 global218)
		)
		(InitIconBar)
		(Inv
			init:
			add:
				sodaCan
				certificate
				card
				beaker
				rag
				dishSoap
				frisbee
				mackeral
				scubaGear
				airTanks
				bikeCage
				conchShell
				trident
				sharpShell
				tweezers
				urchins
				waterPump
				spine
				screws
				goldMask
				starFish
				healingPotion
				hermetShell
				jar
				mirror
				boxKey
				steelCable
				float
				sawFishHead
				fishLure
				hackSaw
				sixPackRing
				transmitter
				scroll
				waterBottle
			eachElementDo: #highlightColor global207
			eachElementDo: #lowlightColor (invWin insideColor:)
			add: invLook invHand invSelect invHelp ok
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
					topValue: (if (> global103 1) 15 else 1)
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
				(iconAbout theObj: (ScriptID 810 0) selector: #doit yourself:) ; aboutCode
				(iconHelp cursor: helpC)
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			helpIconItem: iconHelp
			curIcon: iconRestore
		)
		(= global104 (if (GameIsRestarting) 400 else 360))
		(self newRoom: 803) ; speedTest
	)

	(method (replay)
		(Palette palSET_INTENSITY 0 255 100)
		(if (== gCurRoomNum 540)
			(gCurRoom notify: 1)
		)
		(ecoStatusLine doit:)
		(if (User canControl:)
			(self setCursor: gTheCursor)
		else
			(waitC init:)
		)
		(super replay:)
	)

	(method (quitGame &tmp [temp0 30] [temp30 30] [temp60 30])
		(proc932_8 98 0 6 @temp0)
		(proc932_8 98 0 7 @temp30)
		(proc932_8 98 0 8 @temp60)
		(super quitGame: (Print @temp0 #button @temp30 1 #button @temp60 0 #icon 813 0 0))
	)

	(method (restart &tmp [temp0 30] [temp30 30] [temp60 30])
		(proc932_8 98 0 9 @temp0)
		(proc932_8 98 0 10 @temp30)
		(proc932_8 98 0 8 @temp60)
		(if (Print @temp0 #button @temp30 1 #button @temp60 0 #icon 813 0 0)
			(Palette palSET_INTENSITY 0 255 100)
			(ecoStatusLine doit:)
			(super restart:)
		)
	)

	(method (startRoom roomNum &tmp temp0 [temp1 20])
		(if gPMouse
			(gPMouse stop:)
		)
		(if (and (gLongSong2 number:) (== (gLongSong2 prevSignal:) -1))
			(gLongSong2 number: 0)
		)
		((ScriptID 806) doit: roomNum) ; disposeCode
		(Format @temp1 0 0 800) ; "%d.scr"
		(if
			(and
				(= temp0
					(if global227
						(FileIO fiEXISTS @temp1)
					)
				)
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print 0 1 #button {Who cares} 0 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(if temp0
			((ScriptID 800) init:) ; MISSING SCRIPT
		)
		(if (== roomNum 320)
			(travelC cel: 2)
			(gGame setCursor: travelC)
		)
		(if (== roomNum 381)
			(travelC cel: 1)
			(gGame setCursor: travelC)
		)
		(super startRoom: roomNum)
		(if (OneOf roomNum 803 360) ; speedTest
			(ecoStatusLine disable:)
			(gTheIconBar disable:)
		else
			(ecoStatusLine enable:)
			(gTheIconBar enable:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 20])
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(event claimed: 1)
		(Format @temp3 0 0 800) ; "%d.scr"
		(= temp2
			(if global227
				(FileIO fiEXISTS @temp3)
			)
		)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(cond
			((and (== temp0 evKEYBOARD) (== temp1 KEY_CONTROL))
				(gGame quitGame:)
			)
			((and (== temp0 evKEYBOARD) (== temp1 KEY_F2))
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
			)
			((or (not (User controls:)) (& (icon7 signal:) $0004)) 1)
			((== temp0 evKEYBOARD)
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
					(KEY_F1
						(GameControls show:)
					)
					(KEY_F5
						(gGame save:)
					)
					(KEY_F7
						(gGame restore:)
					)
					(KEY_F9
						(gGame restart:)
					)
					(KEY_ALT_n
						(if temp2
							(if (proc804_1 1536)
								((ScriptID 952) doit: @gSysLogPath 0) ; sysLogger
							else
								(Print 0 2) ; "Not Enough Memory!!"
							)
						)
					)
					(else
						(if temp2
							(event claimed: 0)
							((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
						)
					)
				)
			)
			((and (== temp0 evMOUSEBUTTON) temp2)
				(event claimed: 0)
				((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
			)
		)
	)
)

(instance soundReset of Code ; UNUSED
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
			(gEgo
				moveSpeed: (gGame egoMoveSpeed:)
				cycleSpeed: (gGame egoMoveSpeed:)
			)
		)
		(gGame egoMoveSpeed:)
	)
)

(instance ok of IconI
	(properties
		view 951
		loop 4
		cel 0
		nsLeft 40
		signal 67
		helpStr 11
	)

	(method (init)
		(self
			cursor: arrowC
			highlightColor: 0
			lowlightColor: (proc819_8 global216 global216)
		)
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 951
		loop 0
		cel 0
		message 2
		helpStr 12
	)

	(method (init)
		(self
			cursor: eyeC
			highlightColor: 0
			lowlightColor: (proc819_8 global216 global216)
		)
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 951
		loop 1
		cel 0
		message 3
		helpStr 13
	)

	(method (init)
		(self
			cursor: handC
			highlightColor: 0
			lowlightColor: (proc819_8 global216 global216)
		)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 951
		loop 3
		cel 0
		message 6
	)

	(method (init)
		(self
			cursor: helpC
			highlightColor: 0
			lowlightColor: (proc819_8 global216 global216)
		)
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 951
		loop 2
		cel 0
		helpStr 14
	)

	(method (init)
		(self
			cursor: arrowC
			highlightColor: 0
			lowlightColor: (proc819_8 global216 global216)
		)
		(super init:)
	)
)

(class RInvItem of InvI
	(properties
		view 900
		signal 2
		cursorLoop 0
		cursorCel 0
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1)
		(if (== theVerb 4) ; Inventory
			(= temp1
				(cond
					(
						(<
							(= temp0
								(if (== invItem (gInventory indexOf: self))
									220
								else
									(switch invItem
										(10 10) ; bikeCage
										(20 14) ; starFish
										(19 11) ; goldMask
										(21 27) ; healingPotion
										(18 25) ; screws
										(16 30) ; waterPump
										(14 32) ; tweezers
										(15 35) ; urchins
										(13 38) ; sharpShell
										(11 28) ; conchShell
										(0 153) ; sodaCan
										(1 173) ; certificate
										(2 171) ; card
										(3 152) ; beaker
										(34 165) ; waterBottle
										(6 160) ; frisbee
										(7 161) ; mackeral
										(8 164) ; scubaGear
										(5 154) ; dishSoap
										(9 163) ; airTanks
										(12 189) ; trident
										(17 193) ; spine
										(22 196) ; hermetShell
										(24 197) ; mirror
										(25 198) ; boxKey
										(33 212) ; scroll
										(28 204) ; sawFishHead
										(29 205) ; fishLure
										(30 207) ; hackSaw
										(32 209) ; transmitter
										(27 ; float
											(if (== (float cel:) 6)
												203
											else
												215
											)
										)
										(26 ; steelCable
											(if (== (steelCable cel:) 11)
												219
											else
												51
											)
										)
										(23 ; jar
											(switch global233
												(0 155)
												(1 156)
												(else 157)
											)
										)
										(4 ; rag
											(switch global232
												(2 169)
												(0 167)
												(else 6)
											)
										)
										(else 42)
									)
								)
							)
							100
						)
						3
					)
					((< temp0 200) 4)
					(else 5)
				)
			)
			(Narrator init: temp0 0 temp1)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)

	(method (select)
		(if (super select: &rest)
			(invC cel: cursorCel)
			(invC loop: cursorLoop)
		)
	)

	(method (init)
		(= cursor invC)
		(super init: &rest)
	)
)

(instance sodaCan of RInvItem
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 67 0 3) ; "Adam's picked up an empty soda can. It's made of aluminum and is recyclable."
			)
			(3 ; Do
				(Narrator init: 68 0 3) ; "Adam could be a he-man and crush the can, but that's a little bit silly, don't you think?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance certificate of RInvItem
	(properties
		cel 1
		owner 400
		cursorLoop 1
		cursorCel 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 147 0 4) ; "Certificate     Apprentice Dolphin Handler  The bearer, ADAM GREENE, has completed a 50 hour course in animal husbandry and rescue techniques.  Felicitations, Adam!"
			)
			(3 ; Do
				(Narrator init: 172 0 4) ; "There's nothing on the back of the certificate."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of RInvItem
	(properties
		cel 2
		cursorLoop 1
		cursorCel 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 146 0 4) ; "ADAM GREENE is a lifetime member of The WorldWide Dolphin Society.        signed,          Natalie Duvalle,          Acting ChairPerson"
			)
			(3 ; Do
				(Narrator init: 170 0 4) ; "There's nothing on the back of the membership card."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beaker of RInvItem
	(properties
		cel 4
		owner 400
		cursorCel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 158 0 4) ; "Don't go shaking that!"
			)
			(2 ; Look
				(if (IsFlag 8)
					(Narrator init: 19 0 3) ; "The flask of fertilizer solution is empty."
				else
					(Narrator init: 213 0 5) ; "Adam's carrying a flask of his father's experimental fertilizer solution. The solution helps create bacteria that eat oil. Unfortunately, it still has a long way to go before it can be used to really impact large spills."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rag of RInvItem
	(properties
		cel 6
		owner 400
		cursorCel 2
	)

	(method (show)
		(switch global232
			(1
				(= loop 2)
				(= cel 3)
			)
			(2
				(= loop 0)
				(= cel 11)
			)
			(3
				(= loop 2)
				(= cel 9)
			)
			(4
				(= loop 2)
				(= cel 3)
			)
			(else
				(= loop 0)
				(= cel 6)
			)
		)
		(if (== global232 2)
			(= cursorLoop 2)
			(= cursorCel 4)
		else
			(= cursorLoop 0)
			(= cursorCel 2)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1)
		(switch theVerb
			(2 ; Look
				(= temp1
					(cond
						(
							(<
								(= temp0
									(switch global232
										(1 3)
										(2 143)
										(3 142)
										(4 3)
										(else 142)
									)
								)
								100
							)
							3
						)
						((< temp0 200) 4)
						(else 5)
					)
				)
				(Narrator init: temp0 0 temp1)
			)
			(3 ; Do
				(switch global232
					(2
						(Narrator init: 168 0 4) ; "Hmmm. Squdgy!"
					)
					(0
						(Narrator init: 166 0 4) ; "The rag feels cool and soft."
					)
					(else
						(Narrator init: 4 0 3) ; "If you want Adam to use the rag, click it on an object on the main screen."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; dishSoap
						(if (== global232 0)
							(Inv hide:)
							(= global232 2)
							(SetScore 5 202)
							(localproc_0 187)
							(gEgo put: 5) ; dishSoap
							(Inv showSelf: gEgo)
						)
					)
					(22 ; hermetShell
						(if (IsFlag 273)
							(Narrator init: 141 0 4) ; "The shell is already clean!"
						else
							(Inv hide:)
							(= global232 4)
							(SetScore 5 273)
							(localproc_0 5)
							(Inv showSelf: gEgo)
						)
					)
					(25 ; boxKey
						(Narrator init: 57 0 3) ; "It's not the key which needs oiling."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dishSoap of RInvItem
	(properties
		cel 7
		cursorCel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 144 0 4) ; "This is a kinder, gentler detergent."
			)
			(3 ; Do
				(Narrator init: 159 0 4) ; "Shaking the soap makes it nice and bubbly. Whee!"
			)
			(4 ; Inventory
				(if (== invItem 4) ; rag
					(SetScore 5 202)
					(if (== global232 0)
						(Inv highlightedIcon: rag hide: gEgo)
						(= global232 2)
						(gEgo put: 5) ; dishSoap
						(localproc_0 187)
						(Inv showSelf: gEgo)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance frisbee of RInvItem
	(properties
		cel 8
		cursorCel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 70 0 3) ; "Adam is carrying a frisbee."
			)
			(3 ; Do
				(Narrator init: 71 0 3) ; "Adam would like to play frisbee, but who could he play with?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mackeral of RInvItem
	(properties
		cel 9
		cursorCel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 72 0 3) ; "Adam is carrying a fish. Holy mackerel!"
			)
			(3 ; Do
				(Narrator init: 73 0 3) ; "Adam feels the fish. Ooh! Slimy!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scubaGear of RInvItem
	(properties
		loop 2
		cursorLoop 3
		cursorCel 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 109 0 4) ; "Adam is carrying his scuba gear: swim fins, mask, diving gloves and flippers. They help him swim underwater."
			)
			(3 ; Do
				(if (== gCurRoomNum 381)
					(Narrator init: 110 0 4) ; "Adam doesn't need to put on his scuba gear until he's ready to go in the water."
				else
					(Narrator init: 111 0 4) ; "Adam will need to put on the scuba gear to swim, but you'll have to select the scuba gear, then click the gear on Adam on the main screen."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance airTanks of RInvItem
	(properties
		loop 2
		cel 1
		cursorCel 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 78 0 3) ; "Adam is carrying oxygen tanks. The tanks provide air for Adam while he's underwater."
			)
			(3 ; Do
				(Narrator init: 81 0 3) ; "Adam will need to put on the oxygen tanks to dive, but you'll have to select the tanks, then click the tanks on Adam on the main screen."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bikeCage of RInvItem
	(properties
		loop 2
		cel 4
		owner 180
		cursorCel 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 298)
					(Narrator init: 15 0 5) ; "The steel cage looks as though it might have once been a bicycle basket. Although it was dumped as trash, Adam thinks he might be able to find a new use for the cage. There are four screws attached to the steel cage."
				else
					(Narrator init: 15 0 3) ; "The steel cage looks as though it might have once been a bicycle basket. Although it was dumped as trash, Adam thinks he might be able to find a new use for the cage."
				)
			)
			(3 ; Do
				(Narrator init: 13 0 3) ; "If you want Adam to use the steel cage, click it on an object on the main screen."
			)
			(4 ; Inventory
				(switch invItem
					(18 ; screws
						(gEgo put: 18) ; screws
						(SetFlag 42)
						(Inv hide:)
						(localproc_0 48)
						(SetScore 5 298)
						(Inv showSelf: gEgo)
						(proc0_5 10)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance conchShell of RInvItem
	(properties
		loop 2
		cel 5
		owner 140
		cursorCel 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 20 0 3) ; "Adam is carrying a large bronze conch shell. Conch shells have been valued for centuries because of the deep, resonate sound they produce when blown."
			)
			(3 ; Do
				(Narrator init: 21 0 3) ; "Adam would like to blow the mighty conch, but he can't take out his regulator."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trident of RInvItem
	(properties
		loop 2
		cel 6
		owner 120
		cursorCel 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 16 0 3) ; "The bronze trident has a long handle and three prongs on one end. The three prongs have pointed tips."
			)
			(3 ; Do
				(Narrator init: 17 0 3) ; "Adam turns the trident around and looks at the prongs from another direction. Hmmmm. The shape of the three tips looks kind of familiar."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sharpShell of RInvItem
	(properties
		loop 2
		cel 7
		owner 222
		cursorCel 12
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 37 0 3) ; "Adam is carrying one of Epidermis' shells. It's a small, sharp shell - as sharp as the diving knife Adam's father usually carries."
			)
			(3 ; Do
				(Narrator init: 39 0 3) ; "Watch out for the shell's sharp edge!"
			)
			(4 ; Inventory
				(if (== invItem 31) ; sixPackRing
					(SetScore 5 289)
					(gEgo put: 31) ; sixPackRing
					(Inv hide:)
					(localproc_0 192)
					(gInventory showSelf: gEgo)
					(proc0_5 13)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tweezers of RInvItem
	(properties
		loop 2
		cel 8
		owner 223
		cursorCel 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 31 0 3) ; "Adam is carrying fish-bone tweezers that were given to him by Hippocrates in thanks for getting a set of six-pack rings off his snout."
			)
			(3 ; Do
				(Narrator init: 33 0 3) ; "Twang!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance urchins of RInvItem
	(properties
		loop 4
		owner 221
		cursorCel 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 34 0 3) ; "Adam is carrying sea urchins given to him by Narcissus in thanks for saving him from a plastic baggie. The sea urchins are small creatures that eat algae."
			)
			(3 ; Do
				(Narrator init: 36 0 3) ; "Watch out for those sea urchin's spines!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterPump of RInvItem
	(properties
		loop 4
		cel 1
		owner 335
		cursorCel 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 29 0 3) ; "Adam is carrying a water pump."
			)
			(3 ; Do
				(Narrator init: 30 0 3) ; "If you want Adam to use the water pump, you'll need to click the pump on an object on the screen."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spine of RInvItem
	(properties
		loop 4
		cel 2
		owner 226
		cursorLoop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 40 0 3) ; "Adam's carrying one of Olympia's lionfish spines. The spines contain a powerful poison that will kill smaller fish but probably only stun large sea creatures."
			)
			(3 ; Do
				(Narrator init: 41 0 3) ; "Adam knows better than to play with that poisonous lionfish spine!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screws of RInvItem
	(properties
		loop 4
		cel 3
		owner 224
		cursorLoop 1
		cursorCel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 24 0 3) ; "Adam is carrying four metal screws that Erroneous gave him for pulling the balloon from his throat."
			)
			(3 ; Do
				(Narrator init: 26 0 3) ; "Adam examines the screws but finds nothing unusual."
			)
			(4 ; Inventory
				(if (== invItem 10) ; bikeCage
					(gEgo put: 18 0) ; screws
					(SetFlag 42)
					(Inv highlightedIcon: bikeCage hide:)
					(localproc_0 48)
					(SetScore 5 298)
					(Inv showSelf: gEgo)
					(proc0_5 10)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance goldMask of RInvItem
	(properties
		loop 4
		cel 4
		owner 160
		cursorLoop 1
		cursorCel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 9 0 3) ; "The beautiful gold mask was given to Adam by Superfluous, the Mayor. It's a sign of his gratitude for gathering the citizens of Eluria."
			)
			(3 ; Do
				(Narrator init: 194 0 4) ; "Adam finger buffs the gold mask to a high shine."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance starFish of RInvItem
	(properties
		loop 4
		cel 5
		owner 160
		cursorLoop 1
		cursorCel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 12 0 3) ; "The starfish badge is a real, live starfish. Superfluous gave it to Adam as a kind of deputy badge."
			)
			(3 ; Do
				(Narrator init: 195 0 4) ; "The starfish badge feels rough and rubbery."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance healingPotion of RInvItem
	(properties
		loop 4
		cel 6
		owner 180
		cursorLoop 1
		cursorCel 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 22 0 3) ; "Adam is carrying the healing potion that Demeter, the Guardian of the Greens, gave him. According to Demeter, this is the last dose of a miraculous potion that was made of now-extinct sea plants."
			)
			(3 ; Do
				(Narrator init: 23 0 3) ; "Adam doesn't need the healing potion himself. He should save it for someone who's in need of a miracle."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hermetShell of RInvItem
	(properties
		loop 4
		cel 8
		owner 180
		cursorLoop 1
		cursorCel 6
	)

	(method (show)
		(switch global232
			(4
				(= loop 4)
				(= cel 7)
				(= cursorCel 5)
			)
			(else
				(= loop 4)
				(= cel 8)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 273)
					(Narrator init: 43 0 3 store: 44) ; "Adam's carrying a nice roomy shell."
				else
					(Narrator init: 43 0 3 store: 45) ; "Adam's carrying a nice roomy shell."
				)
			)
			(3 ; Do
				(if (IsFlag 273)
					(Narrator init: 47 0 3) ; "The shell is already clean."
				else
					(Narrator init: 46 0 3) ; "Adam can't clean off the oil and tar with his hands!"
				)
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(if (IsFlag 273)
							(Narrator init: 141 0 4) ; "The shell is already clean!"
						else
							(Inv hide:)
							(= cel 7)
							(= global232 4)
							(SetScore 5 273)
							(localproc_0 5)
							(Inv showSelf: gEgo)
						)
					)
					(3 ; beaker
						(Narrator init: 19 0 3) ; "The flask of fertilizer solution is empty."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance jar of RInvItem
	(properties
		loop 4
		cel 9
		owner 420
		cursorLoop 1
		cursorCel 7
	)

	(method (show)
		(switch global233
			(1
				(= loop 4)
				(= cel 11)
				(= cursorCel 8)
			)
			(2
				(= loop 6)
				(= cel 1)
				(= cursorCel 9)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch global233
					(1
						(Narrator init: 58 0 3) ; "The clear glass jar is now open. It's still empty, though."
					)
					(2
						(if (== gCurRoomNum 540)
							(Narrator init: 245 0 5) ; "The glowfish sheds some light on the cave from inside the bottle. However, the glass dulls some of the brightness."
						else
							(Narrator init: 60 0 3) ; "The jar glows with the flashlight fish's light."
						)
					)
					(else
						(Narrator init: 61 0 3) ; "Adam is carrying a clear glass jar. There's a lid on the jar."
					)
				)
			)
			(3 ; Do
				(switch global233
					(0
						(Narrator init: 66 0 3) ; "Adam struggles to remove the lid of the jar but it's stuck on fast! It will take a stronger grip than Adam's to remove that lid."
					)
					(2
						(if (== gCurRoomNum 540)
							(Inv hide:)
							(gCurRoom notify:)
						else
							(Narrator init: 214 0 5) ; "Adam decides to leave the flashlight fish in the jar until he can set it free in a nice, dark place."
						)
					)
					(else
						(Narrator init: 62 0 3) ; "The lid of the jar has already been removed!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mirror of RInvItem
	(properties
		loop 6
		cel 2
		owner 420
		cursorLoop 1
		cursorCel 13
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 85 0 3) ; "Adam is carrying a mirror. In the mirror he sees... himself!"
			)
			(3 ; Do
				(Narrator init: 86 0 3) ; "Adam looks at himself critically in the mirror. He thinks he looks pretty good for a cartoon character!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance boxKey of RInvItem
	(properties
		loop 6
		cel 4
		owner 460
		cursorLoop 1
		cursorCel 14
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 89 0 3) ; "Adam is carrying an anemone-regurgitated key. It looks like it goes to a pretty big lock."
			)
			(4 ; Inventory
				(switch invItem
					(4 ; rag
						(Narrator init: 57 0 3) ; "It's not the key which needs oiling."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(3 ; Do
				(Narrator init: 90 0 3) ; "Adam feels the key. It feels like any other anemone-barfed-up key."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance steelCable of RInvItem
	(properties
		loop 6
		cel 5
		owner 480
		cursorLoop 1
		cursorCel 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch cel
					(11
						(Narrator init: 201 0 5) ; "The cable now has the 'float' and transmitter attached to it. The float will make one end of the cable rise to the surface while the other end can be attached to something on the ocean floor. The transmitter will produce a satellite signal."
					)
					(12
						(Narrator init: 200 0 5) ; "The cable now has the 'float' attached to it. This will make one end of the cable rise to the surface while the other end can be attached to something on the ocean floor."
					)
					(else
						(Narrator init: 91 0 3) ; "Adam is carrying a shielded cable - the 'Gleaming Wire' from the Oracle's prophecy!"
					)
				)
			)
			(3 ; Do
				(switch cel
					(11
						(Narrator init: 216 0 5) ; "Adam checks the satellite buoy he devised. It looks ready to go."
					)
					(12
						(Narrator init: 218 0 5) ; "Adam checks the float and cable. It looks ready to go."
					)
					(else
						(Narrator init: 92 0 3) ; "Adam tugs and pulls on the cable. Yup, that's a shielded cable alright."
					)
				)
			)
			(4 ; Inventory
				(if (and (== cel 12) (!= invItem 32)) ; transmitter
					(Narrator init: 219 0 5) ; "There's no reason to attach that to the float and cable."
				else
					(switch invItem
						(27 ; float
							(Inv hide:)
							(gEgo put: 27) ; float
							(SetScore 5 331)
							(if (== (float cel:) 10)
								(= cel 11)
								(localproc_0 199)
							else
								(= cel 12)
								(localproc_0 50)
							)
							(Inv showSelf: gEgo)
						)
						(32 ; transmitter
							(if (== cel 12)
								(Inv hide:)
								(= cel 11)
								(SetScore 5 330)
								(gEgo put: 32) ; transmitter
								(localproc_0 210)
								(Inv showSelf: gEgo)
							else
								(Narrator init: 49 0 3) ; "The cable is too thin to hold the transmitter."
							)
						)
						(30 ; hackSaw
							(Narrator init: 103 0 4) ; "Adam doesn't want to cut up the cable!"
						)
						(else
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

(instance float of RInvItem
	(properties
		loop 6
		cel 6
		owner 500
		cursorLoop 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== cel 10)
					(Narrator init: 202 0 5) ; "Adam has attached the transmitter to the float. This will allow the transmitter to ride on the ocean's surface and transmit its signal."
				else
					(Narrator init: 93 0 3) ; "Adam is carrying a toilet bulb. Who would have ever guessed that the Oracle's 'floating orb' would turn out to be a toilet bulb?"
				)
			)
			(3 ; Do
				(if (== cel 10)
					(Narrator init: 217 0 5) ; "Adam checks the transmitter and float. They look ready to attach to a line of some sort."
				else
					(Narrator init: 94 0 3) ; "Flush, flush!"
				)
			)
			(4 ; Inventory
				(switch invItem
					(26 ; steelCable
						(Inv highlightedIcon: steelCable hide:)
						(gEgo put: 27) ; float
						(SetScore 5 331)
						(if (== cel 10)
							(steelCable cel: 11)
							(localproc_0 199)
						else
							(steelCable cel: 12)
							(localproc_0 50)
						)
						(Inv showSelf: gEgo)
					)
					(32 ; transmitter
						(Inv hide:)
						(= cel 10)
						(SetScore 5 330)
						(gEgo put: 32) ; transmitter
						(localproc_0 52)
						(Inv showSelf: gEgo)
					)
					(else
						(if (== (float cel:) 6)
							(Narrator init: 203 0 5) ; "There's no reason to float that."
						else
							(Narrator init: 53 0 3) ; "That won't work with the float."
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

(instance sawFishHead of RInvItem
	(properties
		loop 6
		cel 8
		owner 343
		cursorLoop 2
		cursorCel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator store: 98 init: 97 0 3) ; "Adam is carrying the saw-like snout from a sawfish skeleton. Sawfish teeth are like little sharp blades set into the snout. The teeth on this snout are slightly dulled but it's still kinda cool."
			)
			(3 ; Do
				(Narrator init: 99 0 3) ; "Yeow! Those teeth might be dulled but that snout is still no toy!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fishLure of RInvItem
	(properties
		loop 8
		cel 10
		owner 343
		cursorLoop 1
		cursorCel 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 100 0 4) ; "The brightly colored fishing lure has lost its hook and is now harmless. It still looks like dinner to fish, though!"
			)
			(3 ; Do
				(Narrator init: 101 0 4) ; "Does that feel just exactly like a fishing lure, or what?!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hackSaw of RInvItem
	(properties
		loop 6
		cel 9
		owner 500
		cursorLoop 2
		cursorCel 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 102 0 4) ; "The hacksaw is still surprisingly sharp and sturdy. It looks like it could cut through solid steel!"
			)
			(3 ; Do
				(Narrator init: 104 0 4) ; "Adam handles the saw carefully. It's a useful tool, but can be dangerous if not used properly."
			)
			(4 ; Inventory
				(if (== invItem 31) ; sixPackRing
					(Narrator init: 208 0 5) ; "That's a bit of an overkill, isn't it?"
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sixPackRing of RInvItem
	(properties
		loop 8
		cel 5
		cursorLoop 2
		cursorCel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 190 0 4) ; "Adam is carrying six pack rings. Now why would those be here unless there was something more to do to them?"
			)
			(3 ; Do
				(Narrator init: 191 0 4) ; "Adam stretches the plastic but the rings don't break."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; sharpShell
						(SetScore 5 289)
						(Inv highlightedIcon: sharpShell hide:)
						(localproc_0 192)
						(gEgo put: 31) ; sixPackRing
						(gInventory showSelf: gEgo)
					)
					(30 ; hackSaw
						(Narrator init: 208 0 5) ; "That's a bit of an overkill, isn't it?"
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

(instance transmitter of RInvItem
	(properties
		loop 2
		cel 2
		owner 400
		cursorCel 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 105 0 4) ; "Adam's carrying a transmitter from Dad's lab. This transmitter is the kind Dad uses with a buoy and cable to mark underwater hazards for clean-up by a salvage team."
			)
			(3 ; Do
				(Narrator init: 106 0 4) ; "Adam tests the radio transmitter. It appears to be working just fine."
			)
			(4 ; Inventory
				(switch invItem
					(26 ; steelCable
						(if (== (steelCable cel:) 12)
							(Inv highlightedIcon: steelCable hide:)
							(steelCable cel: 11)
							(SetScore 5 330)
							(gEgo put: 32) ; transmitter
							(localproc_0 210)
							(Inv showSelf: gEgo)
						else
							(Narrator init: 49 0 3) ; "The cable is too thin to hold the transmitter."
						)
					)
					(27 ; float
						(Inv highlightedIcon: steelCable hide:)
						(float cel: 10)
						(SetScore 5 330)
						(gEgo put: 32) ; transmitter
						(localproc_0 52)
						(Inv showSelf: gEgo)
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

(instance scroll of RInvItem
	(properties
		loop 8
		cel 7
		owner 140
		cursorLoop 2
		cursorCel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((or (== gCurRoomNum 345) (gCurRoom script:))
						(Narrator init: 64 0 3) ; "Adam can't look at the scroll right now, he's busy. Try again later."
					)
					((proc804_1 370)
						(Inv hide:)
						(gCurRoom setScript: (ScriptID 816 0)) ; scrollScript
					)
					(else
						(Narrator init: 64 0 3) ; "Adam can't look at the scroll right now, he's busy. Try again later."
					)
				)
			)
			(3 ; Do
				(Narrator init: 211 0 5) ; "To open the scroll and read it, just click the 'eye' on the scroll."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterBottle of RInvItem
	(properties
		loop 8
		cel 9
		owner 620
		cursorCel 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 112 0 4) ; "Adam is carrying the gerbil's water bottle. Bet the gerbil doesn't like that!"
			)
			(3 ; Do
				(Narrator init: 113 0 4) ; "Slurp, slurp. Adam has the sensation of begin a small furry creature with webbed toes for a moment... then it passes."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance icon0 of IconI
	(properties
		view 950
		loop 9
		cel 0
		message 1
		signal 65
		helpStr 15
		maskView 950
		maskCel 2
	)
)

(instance icon1 of IconI
	(properties
		view 950
		loop 1
		cel 0
		message 3
		signal 65
		helpStr 16
		maskView 950
		maskLoop 1
		maskCel 2
	)
)

(instance icon2 of IconI
	(properties
		view 950
		loop 2
		cel 0
		message 2
		signal 65
		helpStr 17
		maskView 950
		maskLoop 2
		maskCel 2
	)
)

(instance icon3 of IconI
	(properties
		view 950
		loop 3
		cel 2
		message 10
		signal 69
		helpStr 18
		maskView 950
		maskLoop 3
		maskCel 3
	)

	(method (show)
		(if (IsFlag 15)
			(self loop: 3 cel: 0 maskLoop: 3 maskCel: 3 helpStr: 18)
			(if (& (icon0 signal:) $0004)
				(gTheIconBar disable: 6)
			else
				(gTheIconBar enable: 6)
			)
		else
			(self loop: 3 cel: 2 maskLoop: 3 maskCel: 3 helpStr: 19)
			(gTheIconBar disable: self)
		)
		(super show: &rest)
	)
)

(instance icon4 of IconI
	(properties
		view 950
		loop 4
		cel 0
		message 4
		signal 65
		helpStr 20
		maskView 950
		maskLoop 4
		maskCel 2
	)

	(method (show)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: self)
		)
		(super show: &rest)
	)
)

(instance icon5 of IconI
	(properties
		view 950
		loop 5
		cel 0
		type 0
		message 0
		signal 67
		helpStr 21
		maskView 950
		maskLoop 5
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
		view 950
		loop 6
		cel 0
		message 5
		signal 65
		helpStr 22
		maskView 950
		maskLoop 6
		maskCel 2
	)
)

(instance icon7 of IconI
	(properties
		view 950
		loop 7
		cel 0
		message 7
		signal 67
		helpStr 23
		maskView 950
		maskLoop 7
		maskCel 2
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
		view 950
		loop 8
		cel 0
		message 6
		signal 3
		helpStr 24
		maskView 950
		maskLoop 8
		maskCel 2
	)
)

(instance ecoDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(if (and (param2 facingMe: gEgo) (param2 lookStr:))
					(Narrator init: (param2 lookStr:))
				)
			)
			(10
				(Narrator init: (Random 121 124) 0 4)
			)
			(5
				(Narrator init: (Random 130 134) 0 4)
			)
			(3
				(if (and (== gCurRoomNum 380) (IsFlag 111))
					((ScriptID 2 1) init: 73 1 0 1) ; Adam, "Rats! I almost caught it!"
				else
					(Narrator init: (Random 125 129) 0 4)
				)
			)
			(4
				(Narrator init: (Random 135 139) 0 4)
			)
		)
	)
)

(instance ecoFtrInit of Code
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

(instance ecoWin of EcoWindow
	(properties)
)

(instance invWin of InsetWindow
	(properties)
)

(instance gcWin of SysWindow
	(properties)

	(method (open &tmp [temp0 22])
		(self top: 39 left: 64 bottom: 140 right: 253 priority: 15)
		(super open:)
		(DrawCel (proc0_7) 8 0 0 0 15)
	)
)

(instance detailSlider of Slider
	(properties
		loop 7
		cel 0
		nsLeft 142
		nsTop 37
		signal 128
		helpStr 25
		sliderLoop 7
		sliderCel 1
		topValue 3
	)

	(method (show)
		(= view (proc0_7))
		(= sliderView (proc0_7))
		(super show: &rest)
	)
)

(instance volumeSlider of Slider
	(properties
		loop 7
		cel 0
		nsLeft 27
		nsTop 37
		signal 128
		helpStr 26
		sliderLoop 7
		sliderCel 1
		topValue 15
	)

	(method (show)
		(= view (proc0_7))
		(= sliderView (proc0_7))
		(super show: &rest)
	)
)

(instance speedSlider of Slider
	(properties
		loop 7
		cel 0
		nsLeft 88
		nsTop 25
		signal 128
		helpStr 27
		sliderLoop 7
		sliderCel 1
		bottomValue 15
	)

	(method (show)
		(= view (proc0_7))
		(= sliderView (proc0_7))
		(super show: &rest)
	)
)

(instance iconSave of ControlIcon
	(properties
		loop 0
		cel 0
		nsTop 9
		message 8
		signal 451
		helpStr 28
	)

	(method (show)
		(= view (proc0_7))
		(= nsLeft (proc0_6 12 7 9 12 12))
		(super show: &rest)
	)
)

(instance iconRestore of ControlIcon
	(properties
		loop 1
		cel 0
		nsLeft 77
		nsTop 9
		message 8
		signal 451
		helpStr 29
	)

	(method (show)
		(= view (proc0_7))
		(= nsLeft (proc0_6 77 51 61 58 54))
		(super show: &rest)
	)
)

(instance iconRestart of ControlIcon
	(properties
		loop 2
		cel 0
		nsTop 9
		message 8
		signal 451
		helpStr 30
	)

	(method (show)
		(= view (proc0_7))
		(= nsLeft (proc0_6 119 114 122 127 119))
		(super show: &rest)
	)
)

(instance iconQuit of ControlIcon
	(properties
		loop 6
		cel 0
		nsTop 78
		message 8
		signal 451
		helpStr 31
	)

	(method (show)
		(= view (proc0_7))
		(= nsLeft (proc0_6 141 141 138 141 141))
		(super show: &rest)
	)
)

(instance iconAbout of ControlIcon
	(properties
		loop 4
		cel 0
		nsLeft 66
		nsTop 78
		message 8
		signal 451
		helpStr 32
	)

	(method (show)
		(= view (proc0_7))
		(super show: &rest)
	)
)

(instance iconHelp of IconI
	(properties
		loop 5
		cel 0
		nsLeft 103
		nsTop 78
		message 6
		signal 387
	)

	(method (show)
		(= view (proc0_7))
		(super show: &rest)
	)

	(method (init)
		(= cursor helpC)
		(super init: &rest)
	)
)

(instance iconOk of IconI
	(properties
		loop 3
		cel 0
		nsLeft 12
		nsTop 78
		message 8
		signal 451
		helpStr 33
	)

	(method (show)
		(= view (proc0_7))
		(super show: &rest)
	)

	(method (init)
		(= cursor arrowC)
		(super init: &rest)
	)
)

(instance ecoStatusLine of SL
	(properties)

	(method (doit &tmp temp0 [temp1 80])
		(proc932_8 98 0 34 @temp1)
		(= temp0 (Memory memALLOC_CRIT 82))
		(Format temp0 @temp1 gScore gPossibleScore)
		(DrawStatus (if state temp0 else 0) global217 global210)
		(Memory memFREE temp0)
	)
)

