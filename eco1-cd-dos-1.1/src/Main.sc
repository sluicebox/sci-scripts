;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n804)
(use eRS)
(use Smopper)
(use EcoWindow)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use Cursor)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Ego)
(use Sound)
(use Game)
(use Inventory)
(use System)

(public
	eco 0
	HandsOff 1
	HandsOn 2
	InitIconBar 3
	SetScore 4
	proc0_5 5
	proc0_6 6
	invC 7
	arrowC 8
	eyeC 9
	helpC 10
	handC 11
	speedORama 12
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
	global18
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
	gEcoApproachCode
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
	gLongSong
	global101 = 1234
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
	global250 = 3
	global251
	global252 = 6
)

(procedure (HandsOff &tmp temp0)
	(gUser canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= temp0 (gTheIconBar curIcon:))
	(gTheIconBar disable: 5 0 1 2 3 4 6 5)
	(gTheIconBar curIcon: temp0)
	(if gPMouse
		(gPMouse stop:)
	)
	(if (not (HaveMouse))
		(= global105 ((gUser curEvent:) x:))
		(= global106 ((gUser curEvent:) y:))
		(gGame setCursor: gWaitCursor)
		(SetCursor 310 180)
	else
		(gGame setCursor: gWaitCursor)
	)
)

(procedure (HandsOn)
	(gUser canControl: 1 canInput: 1)
	(gTheIconBar enable: 5 0 1 2 3 5)
	(if (gTheIconBar curInvIcon:)
		(gTheIconBar enable: 4)
	)
	(if (IsFlag 15)
		(gTheIconBar enable: 6)
	)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 4)
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(SetCursor global105 global106)
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
			(icon9 cursor: helpC yourself:)
		eachElementDo: #init
		eachElementDo: #highlightColor 0
		eachElementDo: #lowlightColor global216
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
	(gTheIconBar curIcon: (gTheIconBar at: 4) curInvIcon: (gInventory at: param1))
	((gTheIconBar at: 4) cursor: ((gInventory at: param1) cursor:))
	(invC
		loop: ((gTheIconBar curInvIcon:) cursorLoop:)
		cel: ((gTheIconBar curInvIcon:) cursorCel:)
	)
	(if (gUser canInput:)
		((gTheIconBar at: 4) signal: (& ((gTheIconBar at: 4) signal:) $fffb))
		(gGame setCursor: invC)
	else
		(gGame setCursor: gTheCursor)
	)
)

(procedure (proc0_6 param1 &tmp [temp0 300] temp300) ; UNUSED
	(cond
		((< param1 100)
			(cond
				((> param1 72)
					(-= param1 72)
					(= temp300 2)
				)
				((> param1 36)
					(-= param1 36)
					(= temp300 1)
				)
				(else
					(= temp300 0)
				)
			)
			(EcoNarrator init: 1 0 temp300 param1 0 3)
		)
		((< param1 200)
			(cond
				((> param1 172)
					(-= param1 172)
					(= temp300 2)
				)
				((> param1 136)
					(-= param1 136)
					(= temp300 1)
				)
				(else
					(-= param1 100)
					(= temp300 0)
				)
			)
			(EcoNarrator init: 2 0 temp300 param1 0 4)
		)
		((< param1 300)
			(cond
				((> param1 272)
					(-= param1 272)
					(= temp300 2)
				)
				((> param1 236)
					(-= param1 236)
					(= temp300 1)
				)
				(else
					(-= param1 200)
					(= temp300 0)
				)
			)
			(EcoNarrator init: 3 0 temp300 param1 0 5)
		)
	)
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
		sightAngle 90
		view 800
	)

	(method (get param1 &tmp temp0 temp1)
		(cond
			((== param1 32)
				(= temp0 (gInventory at: 32)) ; jar
				(switch global233
					(1
						(temp0 loop: 4 cel: 11 cursorCel: 8)
					)
					(2
						(temp0 loop: 6 cel: 1 cursorCel: 9)
					)
				)
			)
			((and (== param1 33) (== global232 3))
				(= temp1 (gInventory at: 33)) ; rag
				(temp1 loop: 2)
				(temp1 cel: 9)
				(temp1 cursorLoop: 0)
				(temp1 cursorCel: 2)
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator init: 1 0 0 1 0 3) ; "Adam gets embarrassed when people stare."
			)
			(2 ; Talk
				((ScriptID 2 1) init: 2 0 0 1 1 0 1) ; Adam, "Talking to myself again, I guess!"
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 2 0 3) ; "Hey! That tickles!"
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 54 0 3)
			)
			(44 ; Inventory
				(switch temp0
					(26
						(if (OneOf gCurRoomNum 380 381)
							(gCurRoom notify:)
						else
							(EcoNarrator init: 2 0 0 51 0 4)
						)
					)
					(28
						(if (IsFlag 68)
							(ClearFlag 68)
							(gCurRoom notify: 68)
						else
							(EcoNarrator init: 1 0 0 55 0 3)
						)
					)
					(12
						(EcoNarrator init: 1 0 0 23 0 3) ; "Adam doesn't need the healing potion himself. He should save it for someone who's in need of a miracle."
					)
					(25
						((ScriptID 2 1) init: 2 0 0 74 1 0 1) ; Adam
					)
					(else
						(super doVerb: theVerb temp0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class Delph of EcoActor
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

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if lookStr
					(EcoNarrator init: global250 0 0 (self lookStr:) 0 gCurRoomNum)
				else
					(EcoNarrator init: 1 0 0 7 0 3) ; "Adam's dolphin pal, Delphineus, always looks like he's grinning."
				)
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 8 0 3) ; "Delphineus will "offer his fin" to Adam when he wants to take him for a ride."
			)
			(6 ; Recycle
				((ScriptID 2 0) init: 1 0 0 2 1 0 1) ; Delphineus, "Phew. Don't put that garbage bag near me!"
			)
			(2 ; Talk
				(cond
					((gCurRoom script:)
						(EcoNarrator init: 1 0 0 56 0 3)
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
								(not (or (gEgo has: 31) (IsFlag 332))) ; steelCable
								(not (or (gEgo has: 30) (IsFlag 331))) ; float
							)
						)
						((ScriptID 2 0) init: 1 0 0 (Random 79 81) 1 0 1) ; Delphineus
					)
					(else
						((ScriptID 2 0) init: 1 0 0 (Random 3 5) 1 0 1) ; Delphineus
					)
				)
			)
			(44 ; Inventory
				((ScriptID 2 0) ; Delphineus
					init:
						1
						0
						0
						(switch temp0
							(29 85)
							(18 86)
							(31 87)
							(12 88)
							(9 89)
							(10 90)
							(else 91)
						)
						1
						0
						1
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
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

(class eco of Game
	(properties)

	(method (play)
		(= gTheCursor (= gWaitCursor waitC))
		(super play: &rest)
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

	(method (init &tmp temp0)
		(= global227 1)
		(= gMsgType 3)
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
		(ScriptID 982)
		RandCycle
		(ScriptID 819)
		(super init:)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode ecoDoVerbCode)
		(= gFtrInitializer ecoFtrInit)
		(= gEcoApproachCode ecoApproachCode)
		((= gKeyDownHandler ecoKeyDownHandler) add:)
		((= gMouseDownHandler ecoMouseDownHandler) add:)
		((= gDirectionHandler ecoDirectionHandler) add:)
		(= gPMouse PseudoMouse)
		((= gEgo ego) setSpeed: global252)
		(self setCursor: gTheCursor 1 304 172)
		(gUser canControl: 0 canInput: 0 alterEgo: gEgo)
		((= gLongSong longSong) owner: self init: flags: 1)
		((= gLongSong2 longSong2) owner: self init:)
		(= gSoundEffects soundEffects)
		(= gVersion {x.yyy})
		(= gNormalCursor arrowC)
		(= gUserFont 4)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= global102 (Graph grGET_COLOURS))
		(ecoWin
			color: global207
			back: global210
			innerBordColor: global207
			midBordColor: global203
			outerBordColor: global208
		)
		(InitIconBar)
		(= gInventory Inv)
		((ScriptID 5 0) init:) ; invCode
		(= global104 (if (GameIsRestarting) 400 else 360))
		(self newRoom: 803) ; speedTest
	)

	(method (replay)
		(ecoStatusLine doit:)
		(if (gUser canControl:)
			(self setCursor: gTheCursor)
		else
			(waitC init:)
		)
		(super replay:)
	)

	(method (quitGame &tmp temp0 [temp1 30] [temp31 30] [temp61 30])
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 0 1 0 0 6 @temp1) ; "Aw! Are you sure you wanna stop playing now?"
		(Message msgGET 0 1 0 0 7 @temp31) ; "Sorry, gotta Quit"
		(Message msgGET 0 1 0 0 8 @temp61) ; "Let's Play some more!"
		(if (& gMsgType $0002)
			(DoAudio audPLAY 0 1 0 0 6)
		)
		(super quitGame: (proc821_1 @temp1 78 @temp31 1 78 @temp61 0))
		(gGame setCursor: temp0 1)
	)

	(method (restart &tmp temp0 [temp1 30] [temp31 30] [temp61 30])
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 0 1 0 0 9 @temp1) ; "Are you sure you want to start all OVER?"
		(Message msgGET 0 1 0 0 10 @temp31) ; "Yup, Restart"
		(Message msgGET 0 1 0 0 8 @temp61) ; "Let's Play some more!"
		(if (& gMsgType $0002)
			(DoAudio audPLAY 0 1 0 0 9)
		)
		(if (proc821_1 @temp1 78 @temp31 1 78 @temp61 0)
			(DrawPic 901 9)
			(ecoStatusLine doit:)
			(super restart:)
		)
		(gGame setCursor: temp0 1)
	)

	(method (startRoom param1)
		(if gPMouse
			(gPMouse stop:)
		)
		(if (and (gLongSong2 number:) (== (gLongSong2 prevSignal:) -1))
			(gLongSong2 number: 0)
		)
		((ScriptID 806) doit: param1) ; disposeCode
		(if (== param1 320)
			(travelC cel: 2)
			(gGame setCursor: travelC)
		)
		(if (== param1 381)
			(travelC cel: 1)
			(gGame setCursor: travelC)
		)
		(super startRoom: param1)
		(if (OneOf param1 803 360)
			(ecoStatusLine disable:)
			(gTheIconBar disable:)
		else
			(ecoStatusLine enable:)
			(gTheIconBar enable:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(event claimed: 1)
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
			(
				(and
					(or (not (gUser controls:)) (& (icon7 signal:) $0004))
					(!= gCurRoomNum 345)
				)
				1
			)
			((== temp0 evKEYBOARD)
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
					(KEY_F1
						(gGame showControls:)
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
				)
			)
		)
	)

	(method (showControls)
		((ScriptID 822 0) init: show: dispose:) ; ecoGameControls
	)

	(method (showAbout)
		((ScriptID 810 0) doit:) ; aboutCode
	)
)

(instance ecoApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(6 16)
				(else -32768)
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
			(= global252 param1)
			(if (gUser canControl:)
				(gEgo setSpeed: global252)
			)
		)
		(return global252)
	)
)

(instance icon0 of EcoIconItem
	(properties
		view 950
		loop 9
		cel 0
		type 20480
		message 3
		signal 65
		maskView 950
		maskLoop 9
		maskCel 2
		noun 1
		helpVerb 46
		helpStr 15
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

(instance icon1 of EcoIconItem
	(properties
		view 950
		loop 1
		cel 0
		message 4
		signal 65
		maskView 950
		maskLoop 1
		maskCel 2
		noun 1
		helpVerb 47
		helpStr 16
	)
)

(instance icon2 of EcoIconItem
	(properties
		view 950
		loop 2
		cel 0
		message 1
		signal 65
		maskView 950
		maskLoop 2
		maskCel 2
		noun 1
		helpVerb 48
		helpStr 17
	)
)

(instance icon3 of EcoIconItem
	(properties
		view 950
		loop 3
		cel 2
		message 6
		signal 69
		maskView 950
		maskLoop 3
		maskCel 3
		noun 1
		helpVerb 49
		helpStr 18
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

(instance icon4 of EcoIconItem
	(properties
		view 950
		loop 4
		cel 0
		signal 65
		maskView 950
		maskLoop 4
		maskCel 2
		noun 1
		helpVerb 50
		helpStr 20
	)

	(method (show)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: self)
		)
		(super show: &rest)
	)
)

(instance icon5 of EcoIconItem
	(properties
		view 950
		loop 5
		cel 0
		type 0
		message 0
		signal 67
		maskView 950
		maskLoop 5
		maskCel 2
		noun 1
		helpVerb 51
		helpStr 21
	)

	(method (select)
		(if (super select: &rest)
			(gInventory showSelf: gEgo)
		)
	)
)

(instance icon6 of EcoIconItem
	(properties
		view 950
		loop 6
		cel 0
		message 2
		signal 65
		maskView 950
		maskLoop 6
		maskCel 2
		noun 1
		helpVerb 52
		helpStr 22
	)
)

(instance icon7 of EcoIconItem
	(properties
		view 950
		loop 7
		cel 0
		message 7
		signal 67
		maskView 950
		maskLoop 7
		maskCel 2
		noun 1
		helpVerb 53
		helpStr 23
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

(instance icon9 of EcoIconItem
	(properties
		view 950
		loop 8
		cel 0
		message 8
		signal 3
		maskView 950
		maskLoop 8
		maskCel 2
		noun 1
		helpVerb 54
		helpStr 24
	)
)

(instance ecoDoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(if (not (OneOf param1 1 4 6 2 3 7 8))
			(= temp0 param1)
			(= param1 44)
		)
		(switch param1
			(1
				(if (and (param2 facingMe: gEgo) (param2 lookStr:))
					(EcoNarrator
						init: global250 0 0 (param2 lookStr:) 0 gCurRoomNum
					)
				)
			)
			(6
				(EcoNarrator init: 2 0 0 (Random 21 24) 0 4)
			)
			(2
				(EcoNarrator init: 2 0 0 (Random 30 34) 0 4)
			)
			(4
				(if (and (== gCurRoomNum 380) (IsFlag 111))
					((ScriptID 2 1) init: 2 0 0 73 1 0 1) ; Adam
				else
					(EcoNarrator init: 2 0 0 (Random 25 29) 0 4)
				)
			)
			(44
				(EcoNarrator init: 2 0 0 (Random 35 39) 0 4)
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

(instance ecoStatusLine of SL
	(properties)

	(method (doit &tmp temp0 [temp1 80])
		(Message msgGET 0 1 0 0 34 @temp1) ; "EcoQuest 1: The Search for Cetus %u of %u pts."
		(= temp0 (Memory memALLOC_CRIT 82))
		(Format temp0 @temp1 gScore gPossibleScore)
		(DrawStatus (if state temp0 else 0) global217 global210)
		(Memory memFREE temp0)
	)
)

