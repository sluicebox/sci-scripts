;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Kq6IconBar)
(use Kq6Sound)
(use EgoGroop)
(use KQ6Print)
(use Interface)
(use KQ6Room)
(use Kq6Talker)
(use Kq6Window)
(use n913)
(use Body)
(use Print)
(use Dialog)
(use Messager)
(use Conversation)
(use Talker)
(use PseudoMouse)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Game)
(use User)
(use System)

(public
	Kq6 0
	EgoDead 1
	proc0_2 2
	emberTimer 4
	beastTimer 5
	CharonTimer 6
	lettuceTimer 7
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
	gKq6ApproachCode
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
	gGlobalSound
	gGlobalSound2
	gGlobalSound3
	; 105
	gGlobalSound4
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
	gEgoGroop
	global152
	gAct
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
)

(procedure (EgoDead param1)
	(= global160 param1)
	(SetFlag 44)
	(gCurRoom newRoom: 640)
)

(procedure (proc0_2 param1 param2) ; UNUSED
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
	(return (if (>= global107 32) param1 else param2))
)

(class Kq6Points of Kq6Sound
	(properties)

	(method (check)
		(super check: &rest)
		(if (== prevSignal -1)
			(self dispose:)
		)
	)
)

(instance ego of Body
	(properties
		noun 1
		modNum 0
		sightAngle 45
		view 900
	)

	(method (init)
		(super init: &rest)
		(|= scaleSignal $0004)
		(|= state $0002)
	)

	(method (handleEvent event)
		(if (& (event type:) $0040) ; direction
			(return 0)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; egg
				(gCurRoom setScript: 908) ; eggScript
			)
			(14 ; potion
				(if (and (!= gCurRoomNum 280) (IsFlag 153))
					(gMessager say: 1 14 18 0 0 0) ; "Alexander already has a pretty good idea what that potion does, and he doesn't want to waste the rest of it."
				else
					(gCurRoom setScript: 87) ; egoDrinks
				)
			)
			(31 ; flute
				(gCurRoom setScript: 85) ; playTheFlute
			)
			(42 ; boringBook
				(gCurRoom setScript: 88) ; boringBookScript
			)
			(27 ; riddleBook
				(gCurRoom setScript: 90) ; beginScript
			)
			(83 ; ink
				(if (IsFlag 151)
					(gMessager say: 1 83 17 0 0 0) ; "Alexander doesn't want to waste his invisible ink! A thing like that might come in handy!"
				else
					(gCurRoom setScript: 92) ; inkScript
				)
			)
			(37 ; nightingale
				(gCurRoom setScript: 93) ; nightScript
			)
			(28 ; spellBook
				(gCurRoom setScript: 190) ; openBook
			)
			(32 ; poem
				(if (gCurRoom script:)
					(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
				else
					(gCurRoom setScript: 97) ; readPoem
				)
			)
			(65 ; note
				(if (gCurRoom script:)
					(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
				else
					(gCurRoom setScript: 96) ; readNote
				)
			)
			(61 ; letter
				(if (gCurRoom script:)
					(gMessager say: 7 0 16 0 0 0) ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
				else
					(gCurRoom setScript: 101) ; readNote
				)
			)
			(67 ; peppermint
				(gEgo put: 31 0) ; peppermint
				(gMessager say: noun theVerb 0 1 0 0) ; "Alexander eats the peppermint. Yum!"
			)
			(24 ; sacredWater
				(gEgo put: 40 0) ; sacredWater
				(gMessager say: noun theVerb 0 1 0 0) ; "Alexander drinks the Oracle's sacred water. The vial disintegrates as it's drained."
			)
			(62 ; milk
				(gEgo put: 22 470) ; milk
				(gMessager say: noun theVerb 0 1 0 0) ; "Alexander drinks the milk and discards the bottle. Yum!"
			)
			(63 ; mint
				(gEgo put: 23 280) ; mint
				(gMessager say: noun theVerb 0 1 0 0) ; "Alexander eats the mint. Hmmm...not bad. A little stale, perhaps."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class NewSound of Sound
	(properties
		flags 1
		newPiece 0
		newLoop 0
		fadeTicks 15
		fadeStep 10
		volSwitch 50
	)

	(method (init)
		(super init: &rest)
		(= prevSignal -1)
	)

	(method (fadeTo param1)
		(= newLoop 0)
		(if (and argc (>= argc 1))
			(= newPiece [param1 0])
			(if (>= argc 2)
				(= newLoop [param1 1])
			)
		)
		(if (== prevSignal -1)
			(self cue:)
		else
			(self client: self fade: volSwitch fadeTicks fadeStep 1)
		)
	)

	(method (cue)
		(if (== prevSignal -1)
			(self
				number: newPiece
				loop: newLoop
				play: volSwitch
				fade: 127 fadeTicks fadeStep 0
			)
		)
	)
)

(instance globalSound of NewSound
	(properties)
)

(instance globalSound2 of Kq6Sound
	(properties)
)

(instance globalSound3 of Kq6Sound
	(properties)
)

(instance globalSound4 of Kq6Sound
	(properties)
)

(instance kq6KeyDownHandler of EventHandler
	(properties)
)

(instance kq6MouseDownHandler of EventHandler
	(properties)
)

(instance kq6DirectionHandler of EventHandler
	(properties)
)

(instance kq6WalkHandler of EventHandler
	(properties)
)

(class Kq6 of Game
	(properties
		isHandsOn 1
		oldCurIcon 0
	)

	(method (init &tmp [temp0 33])
		(ScriptID 982)
		DText
		DButton
		Polygon
		PolyPath
		KQ6Room
		Kq6Talker
		Talker
		RandCycle
		Conversation
		Scaler
		(super init: &rest)
		(gTimers
			add:
				(emberTimer client: emberTimer yourself:)
				(beastTimer client: beastTimer yourself:)
				(CharonTimer client: CharonTimer yourself:)
				(lettuceTimer client: lettuceTimer yourself:)
		)
		(if (and (FileIO fiEXISTS {KQ6CD}) (DoAudio audLANGUAGE))
			(= gMsgType 2)
			(DoAudio audRATE 22050)
		else
			(= gMsgType 1)
		)
		(= global107 (Graph grGET_COLOURS))
		(= gSystemWindow Kq6Window)
		(= gTheCursor theGameCursor)
		(= gWaitCursor theWaitCursor)
		(= gNormalCursor arrowCursor)
		(= gUserFont 4)
		(self setCursor: (gWaitCursor posn: 300 180 yourself:))
		(= gNarrator Kq6Narrator)
		(= gMessager Kq6Messager)
		((ScriptID 902) init:) ; ColorInit
		(DisposeScript 902)
		(= gEgoGroop EgoGroop)
		(= gUseSortedFeatures 1)
		(StrCpy @gSysLogPath {})
		(= gDoVerbCode kq6DoVerbCode)
		(= gFtrInitializer kq6FtrInit)
		(= gKq6ApproachCode kq6ApproachCode)
		((= gKeyDownHandler kq6KeyDownHandler) add:)
		((= gMouseDownHandler kq6MouseDownHandler) add:)
		((= gDirectionHandler kq6DirectionHandler) add:)
		((= gWalkHandler kq6WalkHandler) add:)
		(= gPMouse kq6PseudoMouse)
		(= gEgo ego)
		(User alterEgo: gEgo canControl: 0 canInput: 0)
		((= gGlobalSound globalSound) owner: self init:)
		((= gGlobalSound2 globalSound2) owner: self init:)
		((= gGlobalSound3 globalSound3) owner: self init:)
		((= gGlobalSound4 globalSound4) owner: self init:)
		(= gPossibleScore 231)
		(= gVersion {x.yyy.zzz})
		(Format @temp0 0 0 911) ; "%d.scr"
		(if (FileIO fiEXISTS @temp0)
			(= global100 1)
		else
			(= global100 0)
		)
		(if (and (== (Platform 4) 2) (== global107 256))
			(= global169 1)
		)
		(gEgo setSpeed: 6 currentSpeed: 6)
		(= global108 (DoSound sndGET_POLYPHONY))
		((= gTheIconBar Kq6IconBar)
			add:
				(icon0 cursor: cIcon0 yourself:)
				(icon1 cursor: cIcon1 yourself:)
				(icon2 cursor: cIcon2 yourself:)
				(icon3 cursor: cIcon3 yourself:)
				icon4
				icon5
				icon6
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor 53
			curIcon: icon0
			useIconItem: icon4
			walkIconItem: icon0
			disable: icon4
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		((ScriptID 907) init:) ; KqInv
		(= global136 (if (GameIsRestarting) 200 else 100))
		(= gEatMice 2)
		(Load rsVIEW 998)
		(Lock rsVIEW 998 1)
		(self newRoom: 99) ; speedRoom
	)

	(method (setCursor param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(if (> argc 2)
			(= temp1 (if (< param3 0) 0 else param3))
			(= temp2 (if (< param4 0) 0 else param4))
			(SetCursor temp1 temp2)
		)
		(if (IsObject param1)
			(if argc
				((= gTheCursor param1) init:)
			)
			(param1 init:)
		else
			(SetCursor param1 0 0)
		)
		(return temp0)
	)

	(method (save)
		(if (and (not (IsFlag 49)) (>= (MemoryInfo 0) 1500)) ; LargestPtr
			(super save: &rest)
			(self
				setCursor:
					(if (or (gUser canControl:) (gUser canInput:))
						((gTheIconBar curIcon:) cursor:)
					else
						gWaitCursor
					)
			)
		else
			(gMessager say: 7 0 15 0 0 0) ; "Sorry! There's not enough memory to do that right now. Try it a little later and/or on another screen."
		)
	)

	(method (restore)
		(if (or (not (IsFlag 49)) (>= (MemoryInfo 0) 1500)) ; LargestPtr
			(super restore: &rest)
			(self
				setCursor:
					(cond
						((or (gUser canControl:) (gUser canInput:))
							((gTheIconBar curIcon:) cursor:)
						)
						((IsFlag 44) gNormalCursor)
						(else gWaitCursor)
					)
			)
		else
			(gMessager say: 7 0 15 0 0 0) ; "Sorry! There's not enough memory to do that right now. Try it a little later and/or on another screen."
		)
	)

	(method (pragmaFail param1 &tmp temp0)
		(if (User canInput:)
			(= temp0 (Random 1 3))
			(if (== (gKq6ApproachCode doit: param1) -32768)
				(= param1 0)
			)
			(gMessager say: 0 param1 0 temp0 0 0)
		)
	)

	(method (refresh param1)
		(if (and param1 argc)
			(if (and gFastCast (not (& (gInventory state:) $0020)))
				(Animate (gCast elements:) 0)
			)
		else
			(= global170 1)
		)
	)

	(method (quitGame &tmp temp0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if
			(or
				(and (== gCurRoomNum 640) (IsFlag 44))
				(and (== gCurRoomNum 740) (== gMsgType 2) (== gPrevRoomNum 180))
			)
			(DoAudio audCD 3)
			(= gQuit 1)
		else
			(= temp0 (gGame setCursor: gNormalCursor))
			(if
				(not
					(= gQuit
						(KQ6Print
							posn: 59 70
							font: 4
							addButton: 1 4 0 12 0 0 36 0 ; "Yes! I've had it!"
							addButton: 0 4 0 11 0 85 36 0 ; "NO! I must quest on!"
							font: 1
							say: 1 4 0 0 0 0 0 0 ; "Taking off your adventurer's cap so soon?"
							init:
						)
					)
				)
				(gGame setCursor: temp0)
			)
		)
	)

	(method (restart param1 &tmp temp0 temp1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (not argc)
			(= temp1 (gGame setCursor: gNormalCursor))
			(if
				(= temp0
					(KQ6Print
						posn: 59 70
						font: 4
						addButton: 1 5 0 13 0 0 36 0 ; "Yes. Restart already."
						addButton: 0 5 0 14 0 115 36 0 ; "Oops. Cancel restart."
						font: 1
						say: 1 5 0 0 0 0 0 0 ; "Are you sure you want to clear your game and restart?"
						init:
					)
				)
				(super restart: &rest)
			else
				(gGame setCursor: temp1)
			)
		else
			(super restart: &rest)
		)
	)

	(method (startRoom param1 &tmp temp0)
		(= temp0
			(if global169
				(Platform 6)
			)
		)
		(if gPMouse
			(gPMouse stop:)
		)
		((ScriptID 919) doit: param1) ; disposeCode
		(if temp0
			(Portrait 2 0)
		)
		(if
			(and
				global100
				(not (IsFlag 38))
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(switch
					(Print
						font: gUserFont
						addText: {*** Memory fragmented.}
						addButton: 0 {Who cares} 0 20
						addButton: 1 {Debug} 0 34
						init:
					)
					(0
						(SetFlag 38)
					)
					(1
						(SetDebug)
					)
				)
			)
		)
		(if gDebugOn
			(SetDebug)
		)
		(cond
			((OneOf param1 200 210 220 230 240 250 260 270 280 290)
				(ScriptID 10) ; rgCrown
				((ScriptID param1) setRegions: 10) ; rgCrown
			)
			((OneOf param1 300 310 320 330 340 350 370 380 390)
				(ScriptID 20) ; rSacred
				(if (OneOf param1 300 320)
					(ScriptID 21) ; rCliffs
					((ScriptID param1) setRegions: 21) ; rCliffs
				)
				((ScriptID param1) setRegions: 20) ; rSacred
			)
			(
				(OneOf
					param1
					400
					405
					410
					415
					420
					425
					430
					435
					440
					406
					407
					408
					409
					411
				)
				(ScriptID 30) ; rLab
				((ScriptID param1) setRegions: 30) ; rLab
			)
			((OneOf param1 450 460 461 470 475 480 490)
				(ScriptID 40) ; rWonder
				((ScriptID param1) setRegions: 40) ; rWonder
			)
			((OneOf param1 500 510 520 530 540)
				(ScriptID 50) ; rBeast
				((ScriptID param1) setRegions: 50) ; rBeast
			)
			((OneOf param1 550 560 570 580)
				(ScriptID 60) ; rMist
				((ScriptID param1) setRegions: 60) ; rMist
			)
			((OneOf param1 600 605 615 620 630 640 650 660 670 680 690)
				(ScriptID 70) ; rgDead
				((ScriptID param1) setRegions: 70) ; rgDead
			)
			(
				(OneOf
					param1
					700
					710
					720
					730
					740
					750
					760
					770
					780
					781
					790
					800
					810
					820
					840
					850
					860
					870
					880
					180
					743
				)
				(ScriptID 80) ; rgCastle
				(if (OneOf param1 840 710 720 770 820 780)
					(ScriptID 81) ; RgBasement
					((ScriptID param1) setRegions: 81) ; RgBasement
				)
				((ScriptID param1) setRegions: 80) ; rgCastle
			)
			(else 0)
		)
		(super startRoom: param1)
		(CueObj client: 0 state: 0)
		(if (and (gCast contains: gEgo) (not (gEgo looper:)))
			(gEgo setLoop: EgoGroop)
		)
		(if temp0
			((ScriptID 109 0) doit: param1) ; loadTalker
		)
	)

	(method (handsOff)
		(= isHandsOn 0)
		(if (not argc)
			(gEgo setMotion: 0)
		)
		(if (not oldCurIcon)
			(= oldCurIcon (gTheIconBar curIcon:))
		)
		(gEgo oldXStep: (gEgo xStep:))
		(gEgo oldYStep: (gEgo yStep:))
		(if
			(and
				(& (gEgo scaleSignal:) $0003)
				(not (gEgo oldScaleSignal:))
			)
			(gEgo oldScaleSignal: (& (gEgo scaleSignal:) $fffb))
			(cond
				((& (gEgo oldScaleSignal:) $0002)
					(gEgo oldMaxScale: (gEgo maxScale:))
				)
				((IsObject (gEgo scaler:))
					(gEgo
						oldMaxScale: ((gEgo scaler:) frontSize:)
						oldBackSize: ((gEgo scaler:) backSize:)
						oldFrontY: ((gEgo scaler:) frontY:)
						oldBackY: ((gEgo scaler:) backY:)
					)
				)
			)
		)
		(gTheIconBar disable: (gTheIconBar at: 0) icon1 icon2 icon3 icon4 icon5)
		(User canControl: 0 canInput: 0)
		(gGame setCursor: gWaitCursor)
		(if gPMouse
			(gPMouse stop:)
		)
	)

	(method (handsOn &tmp temp0)
		(= isHandsOn 1)
		(User canControl: 1 canInput: 1)
		(if (IsObject oldCurIcon)
			(gTheIconBar curIcon: oldCurIcon)
		)
		(= oldCurIcon 0)
		(gTheIconBar enable: (gTheIconBar at: 0) icon1 icon2 icon3 icon4 icon5)
		(if (not (gTheIconBar curInvIcon:))
			(gTheIconBar disable: icon4)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (givePoints param1)
		(+= gScore param1)
		((Kq6Points new:) flags: 1 number: 900 play:)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(self init:)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if global100
			(switch (event type:)
				(evKEYBOARD
					(switch (event message:)
						(KEY_TAB
							(if (not (& (icon5 signal:) $0004))
								((ScriptID 907 1) init: gEgo) ; pageCode
								(event claimed: 1)
							)
						)
						(KEY_SHIFTTAB
							(if (not (& (icon5 signal:) $0004))
								((ScriptID 907 1) init: gEgo) ; pageCode
								(event claimed: 1)
							)
						)
						(KEY_CONTROL
							(gGame quitGame:)
							(event claimed: 1)
						)
						(KEY_F2
							(cond
								((gGame masterVolume:)
									(self masterVolume: 0)
								)
								((> global108 1)
									(self masterVolume: 15)
								)
								(else
									(self masterVolume: 1)
								)
							)
							(event claimed: 1)
						)
						(KEY_F5
							(self save:)
							(event claimed: 1)
						)
						(KEY_F7
							(self restore:)
							(event claimed: 1)
						)
						(KEY_F9
							(self restart:)
							(event claimed: 1)
						)
						(else
							(event claimed: 1)
							(if
								(and
									global100
									(not
										(OneOf
											gCurRoomNum
											440
											450
											480
											270
											280
											470
											490
											670
											750
											740
										)
									)
								)
								(event claimed: 0)
								((ScriptID 911) handleEvent: event) ; MISSING SCRIPT
								((ScriptID 911) dispose:) ; MISSING SCRIPT
								(DisposeScript 911)
							)
						)
					)
				)
			)
		)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((& (event type:) evVERB)
				(self pragmaFail: (event message:))
			)
		)
		(event claimed:)
	)

	(method (killSound param1)
		(if (and argc param1)
			(gSounds eachElementDo: #pause 1)
			(= global163 gSounds)
			((= gSounds globalSounds) add:)
		else
			(globalSounds dispose:)
			(= gSounds global163)
			(= global163 0)
			(gSounds eachElementDo: #pause 0)
		)
	)
)

(instance globalSounds of Sounds
	(properties)
)

(class Kq6Messager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(21
						(ScriptID 1000 21) ; Aeriel
					)
					(2
						(ScriptID 1001 2) ; Alex
					)
					(87 gNarrator)
					(62
						(ScriptID 1063 62) ; Allaria
					)
					(20
						(ScriptID 1002 20) ; Azure
					)
					(56
						(ScriptID 1057 56) ; Beast
					)
					(17
						(ScriptID 1003 17) ; Beauty
					)
					(33
						(ScriptID 1034 33) ; Bookshop_Owner
					)
					(43
						(ScriptID 1044 43) ; BookWorm
					)
					(77
						(ScriptID 1050 77) ; tlkBoyGhost
					)
					(82
						(ScriptID 1015 6) ; tlkGuardDog1
					)
					(88
						(ScriptID 1039 71) ; BabyTears
					)
					(71
						(ScriptID 1039 71) ; BabyTears
					)
					(48
						(ScriptID 1049 48) ; Bump
					)
					(46
						(ScriptID 1047 46) ; Widow
					)
					(11
						(ScriptID 1004 11) ; Caliphim
					)
					(28
						(ScriptID 1005 28) ; Cassima
					)
					(93 gNarrator)
					(4
						(ScriptID 1006 4) ; Celeste
					)
					(57
						(ScriptID 1010 57) ; tlkCook
					)
					(73
						(ScriptID 1040 73) ; ClingingVines
					)
					(9
						(ScriptID 1007 9) ; Participle
					)
					(79
						(ScriptID 1025 79) ; tlkDeadSouls
					)
					(45
						(ScriptID 1046 45) ; Dipthong
					)
					(69
						(ScriptID 1016 69) ; Dogwood
					)
					(83
						(ScriptID 1060 83) ; Door_Master
					)
					(59
						(ScriptID 1033 59) ; Priest
					)
					(60
						(ScriptID 1033 60) ; Priest
					)
					(23
						(ScriptID 1008 23) ; Ferryman
					)
					(58
						(ScriptID 1061 58) ; Gate
					)
					(14
						(ScriptID 1009 14) ; tlkGateGuard1
					)
					(15
						(ScriptID 1009 15) ; tlkGateGuard2
					)
					(27
						(ScriptID 1011 27) ; Genie
					)
					(32
						(ScriptID 1012 32) ; tlkGeniePage
					)
					(55
						(ScriptID 1056 55) ; The_Genie_Gardener
					)
					(29
						(ScriptID 1013 29) ; Genie
					)
					(34
						(ScriptID 1035 34) ; tlkGoldMan
					)
					(30
						(ScriptID 1014 30) ; GoldLady
					)
					(36
						(ScriptID 1037 36) ; Gnomes
					)
					(94
						(ScriptID 1065 94) ; Graham
					)
					(8
						(ScriptID 1015 8) ; tlkGuardDog
					)
					(6
						(ScriptID 1015 6) ; tlkGuardDog1
					)
					(7
						(ScriptID 1015 7) ; tlkGuardDog2
					)
					(1
						(ScriptID 1018 1) ; Genie
					)
					(22
						(ScriptID 1019 22) ; tlkGyoungBoy
					)
					(26
						(ScriptID 1033 26) ; Priest
					)
					(38
						(ScriptID 1041 38) ; HoleInWall
					)
					(5
						(ScriptID 1020 5) ; Jollo_the_Clown
					)
					(16
						(ScriptID 1021 16) ; Lampseller
					)
					(78
						(ScriptID 1024 78) ; Lord_of_the_Dead
					)
					(3
						(ScriptID 1022 3) ; Minotaur
					)
					(40
						(ScriptID 1064 40) ; MotherGhost
					)
					(99 gNarrator)
					(80
						(ScriptID 1062 80) ; NightMareTalker
					)
					(19
						(ScriptID 1023 19) ; Oracle
					)
					(44
						(ScriptID 1045 44) ; Oxymoron
					)
					(35
						(ScriptID 1036 35) ; Pawnshop_Owner
					)
					(97 -1)
					(42
						(ScriptID 1017 42) ; PussyWillows
					)
					(13
						(ScriptID 1026 13) ; Saladin
					)
					(10
						(ScriptID 1027 10) ; tlkStepmother
					)
					(75
						(ScriptID 1055 75) ; RedKnight
					)
					(95
						(ScriptID 1067 95) ; Rosella
					)
					(53
						(ScriptID 490 53) ; Red_Queen
					)
					(50
						(ScriptID 1051 50) ; Tomato
					)
					(92 gNarrator)
					(81
						(ScriptID 1015 7) ; tlkGuardDog2
					)
					(74
						(ScriptID 1031 74) ; SnapDragons
					)
					(86
						(ScriptID 1028 86) ; tlkServingWoman
					)
					(68
						(ScriptID 1037 68) ; GSight
					)
					(65
						(ScriptID 1037 65) ; GSound
					)
					(72
						(ScriptID 1042 72) ; SourGrapes
					)
					(61
						(ScriptID 1037 61) ; GSmell
					)
					(47
						(ScriptID 1048 47) ; Stick
					)
					(25
						(ScriptID 1059 25) ; Bear
					)
					(37
						(ScriptID 1038 37) ; Oyster
					)
					(66
						(ScriptID 1037 66) ; GTaste
					)
					(70
						(ScriptID 1051 50) ; Tomato
					)
					(67
						(ScriptID 1037 67) ; GTouch
					)
					(51
						(ScriptID 1052 51) ; TomatoVines
					)
					(41 gNarrator)
					(12
						(ScriptID 1066 12) ; Valanice
					)
					(24
						(ScriptID 1029 24) ; The_Vizier
					)
					(91 gNarrator)
					(49
						(ScriptID 1058 49) ; tlkWaiter
					)
					(90 gNarrator)
					(39
						(ScriptID 1043 39) ; WallFlowers
					)
					(76
						(ScriptID 1055 76) ; WhiteKnight
					)
					(18
						(ScriptID 1030 18) ; WingedOne1
					)
					(31
						(ScriptID 1030 31) ; WingedOne2
					)
					(52
						(ScriptID 490 52) ; White_Queen
					)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance kq6DoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(cond
			(
				(and
					(== (kq6ApproachCode doit: param1) -32768)
					(Message msgGET (param2 modNum:) (param2 noun:) 0 0 1)
				)
				(gMessager say: (param2 noun:) 0 0 0 0 (param2 modNum:))
			)
			((not (gCurRoom doVerb: param1))
				(gGame pragmaFail: param1)
			)
		)
	)
)

(instance kq6FtrInit of Code
	(properties)

	(method (doit param1)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if
			(and
				(!= (param1 onMeCheck:) 26505)
				(not (IsObject (param1 onMeCheck:)))
			)
			(param1 state: (| (param1 state:) $0004))
		)
	)
)

(instance kq6ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(5 8)
				(else -32768)
			)
		)
	)
)

(instance kq6PseudoMouse of PseudoMouse
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (& (event type:) $0040) ; direction
			(= temp0 (gTheIconBar curIcon:))
			(gTheIconBar curIcon: 0)
			(super handleEvent: event)
			(gTheIconBar curIcon: temp0)
		)
	)
)

(instance icon0 of Kq6IconItem
	(properties
		loop 0
		cel 0
		type 20480
		message 3
		signal 65
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon1 of Kq6IconItem
	(properties
		loop 1
		cel 0
		message 5
		signal 65
		maskLoop 1
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon2 of Kq6IconItem
	(properties
		loop 2
		cel 0
		message 1
		signal 65
		maskLoop 2
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon3 of Kq6IconItem
	(properties
		loop 3
		cel 0
		message 2
		signal 65
		maskLoop 3
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon4 of Kq6IconItem
	(properties
		loop 4
		cel 0
		message 0
		signal 64
		maskLoop 4
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)
)

(instance icon5 of Kq6IconItem
	(properties
		loop 5
		cel 0
		type 0
		message 0
		signal 67
		maskLoop 5
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)

	(method (doit)
		((ScriptID 907 1) init: gEgo) ; pageCode
	)
)

(instance icon6 of Kq6IconItem
	(properties
		loop 6
		cel 0
		message 0
		signal 67
		maskLoop 6
		maskCel 2
	)

	(method (init)
		(= maskView (= view 980))
		(super init: &rest)
	)

	(method (doit)
		(if (and (Cursor hidden:) (>= (MemoryInfo 0) 1500)) ; LargestPtr
			((ScriptID 903) init: show: dispose:) ; kq6Controls
		else
			(gMessager say: 7 0 15 0 0 0) ; "Sorry! There's not enough memory to do that right now. Try it a little later and/or on another screen."
		)
	)

	(method (select)
		(return
			(if (super select: &rest)
				(gGame setCursor: gWaitCursor)
				(gTheIconBar hide:)
				1
			else
				0
			)
		)
	)
)

(instance theGameCursor of Cursor
	(properties
		view 998
		loop 1
		cel 7
	)
)

(instance theWaitCursor of Cursor
	(properties
		view 998
		loop 1
		cel 8
	)
)

(instance cIcon0 of Cursor
	(properties
		view 998
		loop 1
	)
)

(instance cIcon1 of Cursor
	(properties
		view 998
		loop 1
		cel 2
	)
)

(instance cIcon2 of Cursor
	(properties
		view 998
		loop 1
		cel 1
	)
)

(instance cIcon3 of Cursor
	(properties
		view 998
		loop 1
		cel 3
	)
)

(instance arrowCursor of Cursor
	(properties
		view 998
		loop 1
		cel 7
	)
)

(instance emberTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

(instance beastTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)
)

(instance CharonTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)
)

(instance lettuceTimer of Timer
	(properties)

	(method (doit)
		(if (!= client self)
			(super doit: &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(= client self)
	)

	(method (delete)
		(if (not client)
			(= client self)
		)
		(super delete:)
	)
)

