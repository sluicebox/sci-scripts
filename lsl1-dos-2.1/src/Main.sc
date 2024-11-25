;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use LLEgo)
(use PseudoMouse)
(use GameControls)
(use IconBar)
(use Feature)
(use StopWalk)
(use DCIcon)
(use Grooper)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	LSL1 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	SteppedOn 5
	IsFlag 6
	SetFlag 7
	ClearFlag 8
	ToggleFlag 9
	GameOver 10
	Points 11
	Face 12
	SteppedFullyOn 14
	Babble 15
	InitEgoHead 17
	LarryHours 18
	LarryMinutes 19
	LarrySeconds 20
	Death 21
	ObjInRoom 22
	spraySound 23
	deathIcon 24
	icon0 25
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
	gTheMusic
	global101
	gTheMusic2
	gCurReg
	gNoCursor = 1
	; 105
	gCursorType
	gNumColors
	gNumVoices
	gRestartRoom
	gDontSave
	; 110
	gSGrooper
	gGameFlags
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	gEndGameFlags
	gSaveCursorX
	; 120
	gSaveCursorY
	gEHead
	gFfRoom
	gColBlack
	gColGray1
	; 125
	gColGray2
	gColGray3
	gColGray4
	gColGray5
	gColWhite
	; 130
	gColDRed
	gColLRed
	gColVLRed
	gColDYellow
	gColYellow
	; 135
	gColLYellow
	gColVDGreen
	gColDGreen
	gColLGreen
	gColVLGreen
	; 140
	gColDBlue
	gColBlue
	gColLBlue
	gColVLBlue
	gColMagenta
	; 145
	gColLMagenta
	gColCyan
	gColLCyan
	gColWindow
	global149
	; 150
	global150
	gActorX = 160
	gActorY = 160
	gLarryTime
	gOldSysTime
	; 155
	gSpraySeconds
	global156
	gSprayCounter
	gLarryDollars
	gDebugging
	; 160
	global160
	gFloorTo
	gTvChannel
	global163
	gCabFareMin = 10
	; 165
	gDeathView = 807
	gDeathLoop = 1
	gTheMusic3
	gDeathCycler
	gLarrySpeed = 4
	; 170
	gYourPart
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
	gVideo
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
	gYourClothing
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
	gTheirName
	global222
	global223
	global224
	; 225
	global225
	global226
	global227
	global228
	global229
	; 230
	gTheirPart
	global231
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
	gTheirClothing
	global241
	global242
	global243
	global244
	; 245
	global245
	global246
	global247
	global248
	global249
	; 250
	gObject
	global251
	global252
	global253
	global254
	; 255
	global255
	global256
	global257
	global258
	global259
	; 260
	gRoom
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267
	global268
	global269
	; 270
	gActivity
	global271
	global272
	global273
	global274
	; 275
	global275
	global276
	global277
	global278
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	global286
	global287
	global288
	global289
	; 290
	gLastByte
	global291
	gGiantFont
	gMonoFont
)

(procedure (NormalEgo theLoop theView swView &tmp stopView)
	(= stopView 0)
	(gEgo view: 800)
	(if (> argc 0)
		(gEgo loop: theLoop)
		(if (> argc 1)
			(gEgo view: theView)
			(if (> argc 2)
				(= stopView swView)
			)
		)
	)
	(if (not stopView)
		(= stopView 809)
	)
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: StopWalk stopView
		setStep: 3 2
		illegalBits: $8000
		ignoreActors: 0
		userSpeed:
	)
)

(procedure (HandsOff &tmp saveIcon)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= saveIcon (gTheIconBar curIcon:))
	(gTheIconBar disable: 0 1 2 3 4 5 6 7)
	(gTheIconBar curIcon: saveIcon)
	(if (not (HaveMouse))
		(= gSaveCursorX ((User curEvent:) x:))
		(= gSaveCursorY ((User curEvent:) y:))
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
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 6)
	)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 gSaveCursorX gSaveCursorY)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
	(gEgo userSpeed:)
)

(procedure (HaveMem howMuch) ; UNUSED
	(return (u> (MemoryInfo 1) howMuch)) ; FreeHeap
)

(procedure (SteppedOn who color)
	(if (& (who onControl: 1) color)
		(return 1)
	)
)

(procedure (SteppedFullyOn who color) ; UNUSED
	(if (== (who onControl:) color)
		(return 1)
	)
)

(procedure (IsFlag flagEnum)
	(return (& [gGameFlags (/ flagEnum 16)] (>> $8000 (mod flagEnum 16))))
)

(procedure (SetFlag flagEnum &tmp oldState)
	(= oldState (IsFlag flagEnum))
	(|= [gGameFlags (/ flagEnum 16)] (>> $8000 (mod flagEnum 16)))
	(return oldState)
)

(procedure (ClearFlag flagEnum &tmp oldState)
	(= oldState (IsFlag flagEnum))
	(&= [gGameFlags (/ flagEnum 16)] (~ (>> $8000 (mod flagEnum 16))))
	(return oldState)
)

(procedure (ToggleFlag flagEnum)
	(if (IsFlag flagEnum)
		(ClearFlag flagEnum)
	else
		(SetFlag flagEnum)
	)
)

(procedure (Death view loop cycler)
	(Load rsSOUND 190)
	(Load rsVIEW (= gDeathView view))
	(= gDeathLoop loop)
	(if (> argc 2)
		(= gDeathCycler cycler)
	)
)

(procedure (GameOver &tmp [str 80])
	(Format @str &rest)
	(gSounds eachElementDo: #stop)
	(gTheMusic number: 190 vol: 127 loop: 1 flags: 1 play:)
	(deathIcon
		view: gDeathView
		loop: gDeathLoop
		cycleSpeed: (* (+ global101 1) 4)
	)
	(gGame setCursor: 999 1)
	(Animate (gCast elements:) 0)
	(repeat
		(switch
			(Print
				@str
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
				deathIcon
				#title
				@gYourPart
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

(procedure (Points flag val)
	(if (not (IsFlag flag))
		(gGame changeScore: val)
		(SetFlag flag)
		(pointsSound play:)
	)
)

(procedure (Face who theObjOrX theY whoCares &tmp theHeading lookX lookY whoToCue)
	(= whoToCue 0)
	(if (IsObject theObjOrX)
		(= lookX (theObjOrX x:))
		(= lookY (theObjOrX y:))
		(if (== argc 3)
			(= whoToCue theY)
		)
	else
		(= lookX theObjOrX)
		(= lookY theY)
		(if (== argc 4)
			(= whoToCue whoCares)
		)
	)
	(= theHeading (GetAngle (who x:) (who y:) lookX lookY))
	(who setHeading: theHeading (and (IsObject whoToCue) whoToCue))
)

(procedure (Babble theView msgS msgO &tmp [buffer 500]) ; UNUSED
	(if (u< msgS 1000)
		(GetFarText msgS msgO @buffer)
	else
		(StrCpy @buffer msgS)
	)
	(babbleIcon view: theView cycleSpeed: (* (+ global101 1) 4))
	(if (u< msgS 1000)
		(Print @buffer &rest #icon babbleIcon 0 0)
	else
		(Print @buffer msgO &rest 82 babbleIcon 0 0)
	)
)

(procedure (InitEgoHead headView &tmp hView)
	(= hView 0)
	(if argc
		(= hView headView)
	else
		(= hView 809)
	)
	((= gEHead egoHead) init: gEgo view: hView cycleSpeed: 24)
)

(procedure (LarryHours &tmp hours)
	(return
		(if (> (= hours (>> gLarryTime $000c)) 9)
			(- hours 10)
		else
			(+ hours 2)
		)
	)
)

(procedure (LarryMinutes)
	(return (& (>> gLarryTime $0006) $003f))
)

(procedure (LarrySeconds)
	(return (& gLarryTime $003f))
)

(procedure (ObjInRoom object theRoom &tmp theOwner)
	(if (> argc 1)
		(= theOwner theRoom)
	else
		(= theOwner gCurRoomNum)
	)
	(return (== ((gInventory at: object) owner:) theOwner))
)

(instance ego of LLEgo
	(properties
		description {you}
		sightAngle 180
		lookStr {You are wearing the latest in fashion -- if you consider 1973 late!}
		view 800
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(5 ; Talk
				(Print 0 0) ; "You talk to yourself, and are amazed to discover you already know what you're going to say."
			)
			(3 ; Do
				(if (IsFlag 43) ; fWearingRubber
					(ClearFlag 43) ; fWearingRubber
					(gEgo put: 8 0) ; lubber
					(Points 87 1)
					(Print 0 1) ; "Good idea. You carefully remove your lubber and dispose of it in a way that will not be described here."
				else
					(Print 0 2) ; "Carefully exploring your leisure suit, you find it stylish but empty."
				)
			)
			(10 ; Zipper
				(Print 0 3) ; "Larry! The whole point of this game was to stop doing that!"
			)
			(11 ; Taste/Smell
				(cond
					((IsFlag 37) ; fSmellsLikeDogPiss
						(Print 0 4) ; "Phew! You smell like a used fire hydrant!"
					)
					((Random 0 1)
						(Print 0 5) ; "Sniffing your leisure suit thoroughly, you conclude there's nothing quite like the fragrance of fresh polyester! Ahhh!"
					)
					(else
						(Print 0 6) ; "Licking your leisure suit leads you to the conclusion that polyester doesn't mean good taste!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(Print 0 7) ; "You pay yourself a few bucks, which you decide to keep in your wallet."
					)
					(1 ; breathSpray
						(cond
							((gCurRoom script:)
								(Print 0 8) ; "Now?!"
							)
							(
								(and
									(!= (gEgo view:) 800)
									(!= (gEgo view:) 809)
								)
								(Print 0 8) ; "Now?!"
							)
							(else
								(gCurRoom setScript: (ScriptID 812 0)) ; egoSprays
							)
						)
					)
					(2 ; watch
						(Print 0 9) ; "You don't need to wind your watch; it's self-winding."
						(Print 0 10 #at -1 140) ; "(And it seems lately, you've been winding it plenty!)"
					)
					(3 ; apple
						(Print 0 11) ; "The apple tastes delicious. You devour it all."
						(gEgo put: 3 0) ; apple
					)
					(4 ; ring
						(Print 0 12) ; "Slipping the magic ring onto your finger gives you powers far beyond those of..."
						(Print 0 13) ; "...Oops. Wrong game."
					)
					(5 ; whiskey
						(gEgo put: 5 110) ; whiskey
						(= gSpraySeconds 10)
						(Print 0 14) ; "You slam down the shot of cheap booze, then with a flourish, break the glass on the floor!"
						(Print 0 15 #at -1 140) ; "(Pretty dramatic, eh?)"
					)
					(6 ; remoteControl
						(Print 0 16) ; "Although it appears to do nothing, aiming the remote control at your groin while rapidly pressing the channel selector does make you feel quite silly."
					)
					(7 ; rose
						(Print 0 17) ; "You prick yourself with the rose."
					)
					(8 ; lubber
						(if (IsFlag 43) ; fWearingRubber
							(ClearFlag 43) ; fWearingRubber
							(gEgo put: 8 0) ; lubber
							(Points 87 1)
							(Print 0 1) ; "Good idea. You carefully remove your lubber and dispose of it in a way that will not be described here."
						else
							(Print 0 18) ; "This is hardly the place for that!"
						)
					)
					(9 ; candy
						(Print 0 19) ; "The candy tastes so delicious, you consume it all. Now you're worried about your acne."
						(gEgo put: 9 0) ; candy
					)
					(11 ; pocketKnife
						(Print 0 20) ; "Come on, Larry! Don't lose hope! There's no need to commit suicide... at least, not yet!"
					)
					(12 ; wine
						(gEgo put: 12 510) ; wine
						(= gSpraySeconds 15)
						(Print 0 21) ; "You quickly down all the cheap wine, crumple the box, and toss it away. Your thirst is gone."
						(Print 0 22 #at -1 140) ; "And your breath is revolting!"
					)
					(14 ; hammer
						(Print 0 23) ; "Pounding yourself with the hammer is ONE idea; it's just not a GOOD idea!"
					)
					(15 ; pills
						(Print 0 24) ; "Without thinking, you swallow the entire bottle of pills. "Say, this stuff is ok!" you think."
						(Print 0 25) ; "But, wait! Soon your breathing becomes heavy. Soon you become horny! Soon you must have relief! You've got to do something, and NOW!"
						(Print 0 26) ; "You wonder about the location of that cute, little dog you met outside."
						(Death 103 0 1)
						(Format @gYourPart 0 27) ; "You've always loved animals!"
						(GameOver 0 28)
					)
					(16 ; ribbon
						(Print 0 29) ; "You wrap the pink ribbon carefully around your head, before deciding the "Shirley Temple look" just isn't your bag!"
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
		description {your head}
		view 809
	)

	(method (doVerb theVerb invItem)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch theVerb
			(2 ; Look
				(Print 0 30) ; "It's a face only a mother could love!"
			)
			(3 ; Do
				(Print 0 31) ; "You stick your finger deep into your ear until that itch goes away. You hope no one is watching!"
			)
			(else
				(gEgo doVerb: theVerb invItem)
			)
		)
	)
)

(instance pointsSound of Sound
	(properties
		flags 1
		number 821
	)
)

(instance spraySound of Sound
	(properties
		flags 1
		number 820
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
		((= cycler (Fwd new:)) init: self)
	)
)

(instance ll1KDHandler of EventHandler
	(properties)
)

(instance ll1MDHandler of EventHandler
	(properties)
)

(instance ll1DirHandler of EventHandler
	(properties)
)

(instance LSL1 of Game
	(properties)

	(method (init &tmp [temp0 7])
		(= gSGrooper stopGroop)
		(= gSystemWindow ll1Win)
		(= gVersion {x.yyy})
		(super init:)
		(= gDoVerbCode ll1DoVerbCode)
		(= gFtrInitializer ll1FtrInit)
		((= gKeyDownHandler ll1KDHandler) add:)
		((= gMouseDownHandler ll1MDHandler) add:)
		((= gDirectionHandler ll1DirHandler) add:)
		(= gPMouse PseudoMouse)
		((= gEgo ego) _head: (= gEHead egoHead))
		((gEgo _head:) client: gEgo)
		((ScriptID 816 0) init:) ; ll1InitCode
		(UnLoad 130 816)
		((= gTheMusic longSong) init: owner: self flags: 1)
		((= gTheMusic2 longSong2) init: owner: self flags: 1)
		((= gTheMusic3 longSong3) init: owner: self flags: 1)
		((ScriptID 814 0) init:) ; invCode
		((= gTheIconBar IconBar)
			invLoop: 0
			add: icon0 icon1 icon2 icon3 icon6 icon7 icon4 icon5 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor gColLBlue
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(gcWin color: 0 back: gColWindow)
		(GameControls
			window: gcWin
			add:
				iconOk
				(detailSlider
					theObj: gGame
					selector: #detailLevel
					topValue: 3
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					theObj: gGame
					selector: #masterVolume
					topValue: (if (> gNumVoices 1) 15 else 1)
					bottomValue: 0
					yourself:
				)
				(speedSlider
					theObj: speedORama
					selector: #doit
					topValue: 0
					bottomValue: 5
					yourself:
				)
				(iconSave theObj: gGame selector: #save yourself:)
				(iconRestore theObj: gGame selector: #restore yourself:)
				(iconRestart theObj: gGame selector: #restart yourself:)
				(iconQuit theObj: gGame selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 811 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			eachElementDo: #highlightColor gColLBlue
			eachElementDo: #lowlightColor gColWindow
			helpIconItem: iconHelp
			curIcon: iconSave
		)
		(if (GameIsRestarting)
			(= gRestartRoom 100)
		else
			(= gRestartRoom 710)
		)
		(theDefaultFeature init:)
		(self newRoom: 803) ; speedTest
	)

	(method (pragmaFail &tmp theVerb theItem)
		(if (User canInput:)
			(= theVerb ((User curEvent:) message:))
			(if (IconBar curInvIcon:)
				(= theItem ((IconBar curInvIcon:) description:))
			else
				(= theItem (theDefaultFeature description:))
			)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(switch theVerb
				(2
					(Print 0 32) ; "It's not much to look at."
				)
				(5
					(Print 0 33) ; "To whom were you trying to speak?"
				)
				(3
					(Print 0 34) ; "There's nothing to do there."
				)
				(4
					(switch theItem
						(((Inv at: 16) description:) ; ribbon
							(Print 0 35) ; "You gaily display your bright pink ribbon for all to see."
						)
						(((Inv at: 11) description:) ; pocketKnife
							(Print 0 36) ; "Kill! Kill! Kill!"
							(Print 0 37 #at -1 140) ; "(Doesn't anybody ---- anymore?)"
						)
						(else
							(Printf 0 38 theItem) ; "Try finding some place else to place %s."
						)
					)
				)
				(10
					(cond
						((gCurRoom script:)
							(Print 0 8) ; "Now?!"
						)
						((and (!= (gEgo view:) 800) (!= (gEgo view:) 809))
							(Print 0 8) ; "Now?!"
						)
						(else
							(Print 0 39) ; "You coyly turn your back and relieve yourself. You quickly feel much better. The hint of a smile crosses your lips."
						)
					)
				)
				(11
					(Print 0 40) ; "You really don't want to put your face near that."
				)
			)
		)
	)

	(method (quitGame)
		(babbleIcon view: 853 loop: 0 cycleSpeed: (* (+ global101 1) 4))
		(gGame setCursor: 999 1)
		(Animate (gCast elements:) 0)
		(super
			quitGame:
				(Print ; "No! Don't leave me all alone inside your computer! You can't imagine the things your CPU does to me when you're not watching!"
					0
					41
					#button
					{Stop Whining}
					1
					#button
					{Oh, All Right}
					0
					#icon
					babbleIcon
					#title
					{Don't give up. It's still early!}
				)
		)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		((ScriptID 801) doit: roomNum) ; disposeCode
		(UnLoad 130 801)
		(if (OneOf roomNum 100 300 400 500 600)
			(ScriptID 700) ; sidewalk
		)
		(if (OneOf roomNum 505 385 355 615 200 250 260 371)
			(icon0 loop: 15 cursor: 106)
		else
			(icon0 loop: 0 cursor: 100)
		)
		(if (== (gTheIconBar curIcon:) icon0)
			(gGame setCursor: (icon0 cursor:) 1)
		)
		(CueObj client: 0 theVerb: 0 theInvItem: 0)
		(super startRoom: roomNum)
		(if (gCast contains: gEgo)
			(if
				(and
					(gEgo normal:)
					(not ((gEgo cycler:) isKindOf: StopWalk))
				)
				(gEgo setCycle: StopWalk 809)
			)
			(if (not (gEgo looper:))
				(gEgo setLoop: stopGroop)
			)
			(InitEgoHead (egoHead view:))
		)
	)

	(method (handleEvent event &tmp saveIcon)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (or (== gCurRoomNum 710) (== gCurRoomNum 720) (== gCurRoomNum 803)) ; speedTest
			(event claimed: 1)
			(return)
		else
			(switch (event type:)
				(evKEYBOARD
					(switch (event message:)
						(KEY_F7
							(gGame restore:)
							(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
							(event claimed: 1)
						)
						(KEY_CONTROL
							(gGame quitGame:)
							(event claimed: 1)
						)
						(KEY_ADD
							(if (> (gGame egoMoveSpeed:) 0)
								(gGame
									egoMoveSpeed: (- (gGame egoMoveSpeed:) 1)
								)
								(if (User canControl:)
									(gEgo egoSpeed: (gGame egoMoveSpeed:))
								)
							)
						)
						(KEY_SUBTRACT
							(if (< (gGame egoMoveSpeed:) 15)
								(gGame
									egoMoveSpeed: (+ (gGame egoMoveSpeed:) 1)
								)
								(if (User canControl:)
									(gEgo egoSpeed: (gGame egoMoveSpeed:))
								)
							)
						)
						($003d ; =
							(gGame egoMoveSpeed: gLarrySpeed)
							(if (User canControl:)
								(gEgo egoSpeed: (gGame egoMoveSpeed:))
							)
						)
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
						(JOY_RIGHT
							(gGame setCursor: 999 1)
							(icon8 select:)
						)
						(KEY_F2
							(cond
								((gGame masterVolume:)
									(gGame masterVolume: 0)
								)
								((> gNumVoices 1)
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
							(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)

	(method (restart)
		(gCurRoom style: 6 drawPic: 720)
		(gCast eachElementDo: #hide)
		(super restart:)
	)

	(method (doit)
		(if (!= gOldSysTime (GetTime 1)) ; SysTime12
			(= gOldSysTime (GetTime 1)) ; SysTime12
			(if
				(and
					(== (& (++ gLarryTime) $003c) 60)
					(==
						(& (= gLarryTime (& (+= gLarryTime 64) $ffc0)) $0f00)
						3840
					)
					(==
						(& (= gLarryTime (& (+= gLarryTime 4096) $f03f)) $d000)
						-12288
					)
				)
				(= gLarryTime 4096)
			)
			(if
				(and
					(> gSpraySeconds 1)
					(!= gCurRoomNum 710)
					(!= gCurRoomNum 720)
					(!= gCurRoomNum 190)
					(not (IsFlag 6)) ; fEveHasApple
					(== (-- gSpraySeconds) 1)
				)
				(= gSpraySeconds 0)
				(SetFlag 20) ; fMouthSmellsBad
				(if (not (IsFlag 5)) ; fEgoUsingSpray
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(switch (Random 1 5)
						(1
							(Print 0 42) ; "Your mouth tastes like the inside of a motorman's glove!"
						)
						(2
							(Print 0 43) ; "Your breath smells like floor sweepings from a rendering plant."
						)
						(3
							(Print 0 44) ; "Your breath is enough to take your breath away."
						)
						(4
							(Print 0 45) ; "Your mouth tastes like drippings from a marathon runner's sock."
						)
						(5
							(Print 0 46) ; "Now you know where old elephants go to die--your mouth!"
						)
					)
				)
			)
			(if (and (< gLarryDollars 1) (not (IsFlag 1))) ; fBetInProgress
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 0 47) ; "Oh, no! You are now penniless. You hock your leisure suit only to spend the rest of your life wandering from town to town, wondering about what "might have been.""
				(Death 807 1)
				(Format @gYourPart 0 48) ; "POOR Larry!"
				(GameOver 0 49)
			)
		)
		(super doit: &rest)
	)
)

(instance speedORama of Code
	(properties)

	(method (doit num)
		(if argc
			(gGame egoMoveSpeed: num)
			(if (User canControl:)
				(gEgo egoSpeed: (gGame egoMoveSpeed:))
			)
		)
		(gGame egoMoveSpeed:)
	)
)

(instance deathIcon of DCIcon
	(properties)

	(method (init)
		(if gDeathCycler
			((= cycler (End new:)) init: self)
		else
			((= cycler (Fwd new:)) init: self)
		)
	)
)

(instance theDefaultFeature of Feature
	(properties
		description {it}
	)
)

(instance icon0 of IconI
	(properties
		view 850
		loop 0
		cel 0
		cursor 100
		message 1
		signal 65
		helpStr {Use this icon to move your character.}
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: gColLMagenta)
		(super init:)
	)
)

(instance icon1 of IconI
	(properties
		view 850
		loop 1
		cel 0
		cursor 101
		message 2
		signal 65
		helpStr {Use this icon to look at things.}
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: gColLCyan)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 850
		loop 2
		cel 0
		cursor 102
		message 3
		signal 65
		helpStr {Use this icon to do things.}
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: gColLGreen)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 850
		loop 3
		cel 0
		cursor 103
		message 5
		signal 65
		helpStr {Use this icon to talk to other characters.}
		maskView 850
		maskLoop 14
		maskCel 3
	)

	(method (init)
		(self lowlightColor: gColLRed)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 850
		loop 4
		cel 0
		cursor 999
		message 4
		signal 65
		helpStr {Select this icon to use the current inventory object.}
		maskView 850
		maskLoop 14
		maskCel 4
	)

	(method (init)
		(self lowlightColor: gColLGreen)
		(super init:)
	)
)

(instance icon5 of IconI
	(properties
		view 850
		loop 5
		cel 0
		cursor 999
		message 0
		signal 67
		helpStr {Use this icon to bring up the inventory window.}
		maskView 850
		maskLoop 14
		maskCel 2
	)

	(method (init)
		(self lowlightColor: gColYellow)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(Inv showSelf: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 850
		loop 10
		cel 0
		cursor 104
		message 10
		signal 65
		helpStr {Larry! You know what this is for!}
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: gColLYellow)
		(super init:)
	)
)

(instance icon7 of IconI
	(properties
		view 850
		loop 11
		cel 0
		cursor 105
		message 11
		signal 65
		helpStr {This icon is for tasting and smelling.}
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: gColLCyan)
		(super init:)
	)
)

(instance icon8 of IconI
	(properties
		view 850
		loop 7
		cel 0
		cursor 999
		message 8
		signal 67
		helpStr {This icon brings up the control panel.}
		maskView 850
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(self lowlightColor: gColLMagenta)
		(super init:)
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
		view 850
		loop 9
		cel 0
		cursor 150
		message 6
		signal 3
		helpStr {This icon tells you about other icons.}
		maskView 850
		maskLoop 14
	)

	(method (init)
		(self lowlightColor: gColLRed)
		(super init:)
	)
)

(instance ll1DoVerbCode of Code
	(properties)

	(method (doit theVerb theObj invNo &tmp objDesc itemDesc)
		(if (theObj description:)
			(= objDesc (theObj description:))
		else
			(= objDesc (theDefaultFeature description:))
		)
		(if (gInventory at: invNo)
			(= itemDesc ((gInventory at: invNo) description:))
		else
			(= itemDesc (theDefaultFeature description:))
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (theObj facingMe: gEgo)
			(switch theVerb
				(2
					(if (theObj lookStr:)
						(Print (theObj lookStr:))
					else
						(Printf 0 50 objDesc) ; "Why, look! It's %s."
					)
				)
				(5
					(Printf 0 51 objDesc) ; "You engage in a short, but personally meaningful conversation with %s."
				)
				(3
					(Printf 0 52 objDesc) ; "That feels exactly like %s."
				)
				(4
					(switch itemDesc
						(((gInventory at: 16) description:) ; ribbon
							(Printf 0 53 objDesc) ; "Perhaps %s is not into velveteen S & M."
						)
						(((gInventory at: 11) description:) ; pocketKnife
							(Print 0 54) ; "You're a lover, not a fighter!"
						)
						(else
							(Printf 0 55 itemDesc objDesc) ; "It seems %s just doesn't work with %s."
						)
					)
				)
				(10
					(Printf 0 56 objDesc) ; "Larry! Don't do that to %s!"
				)
				(11
					(Printf 0 57 objDesc) ; "To you, %s has no distinctive smell or taste."
				)
			)
		)
	)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance longSong3 of Sound
	(properties)
)

(instance ll1FtrInit of Code
	(properties)

	(method (doit theObj)
		(if (== (theObj sightAngle:) 26505)
			(theObj sightAngle: 90)
		)
		(if (== (theObj actions:) 26505)
			(theObj actions: 0)
		)
	)
)

(instance ll1Win of Window
	(properties)
)

(instance gcWin of Window
	(properties)

	(method (open &tmp [temp0 14] [temp14 15] [temp29 4])
		(self
			top: (/ (- 200 (+ (CelHigh 852 1 1) 6)) 2)
			left: (/ (- 320 (+ 151 (CelWide 852 0 1))) 2)
			bottom:
				(+ (CelHigh 852 1 1) 6 (/ (- 200 (+ (CelHigh 852 1 1) 6)) 2))
			right:
				(+
					151
					(CelWide 852 0 1)
					(/ (- 320 (+ 151 (CelWide 852 0 1))) 2)
				)
			priority: 15
		)
		(super open:)
		(DrawCel
			852
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 852 0 1)) (+ 4 (CelWide 852 1 1)))
						(CelWide 852 0 5)
					)
					2
				)
				4
				(CelWide 852 1 1)
			)
			6
			15
		)
		(DrawCel 852 1 1 4 3 15)
		(DrawCel 852 1 0 94 38 15)
		(DrawCel 852 1 0 135 38 15)
		(DrawCel 852 0 4 63 (- 37 (+ (CelHigh 852 0 4) 3)) 15)
		(DrawCel 852 0 3 101 (- 37 (+ (CelHigh 852 0 4) 3)) 15)
		(DrawCel 852 0 2 146 (- 37 (+ (CelHigh 852 0 4) 3)) 15)
		(Format @temp14 0 58 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			gUserFont
			dsCOLOR
			gColBlue
			dsCOORD
			(+
				10
				(CelWide 852 1 1)
				(/
					(-
						(- (+ 151 (CelWide 852 0 1)) (+ 10 (CelWide 852 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 852 0 1) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal 128
		helpStr {Lower this if game play seems sluggish. Raise it to increase the amount of background animation.}
		sliderView 852
		topValue 3
	)
)

(instance volumeSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal 128
		helpStr {This adjusts the volume on some sound boards and synthesizers.}
		sliderView 852
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 852
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal 128
		helpStr {This adjusts Larry's speed, within the limits of your computer's capabilities.}
		sliderView 852
		bottomValue 15
	)
)

(instance iconSave of ControlIcon
	(properties
		view 852
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 9
		signal 451
		helpStr {Use this to save the current state of your game. When you later select Restore, everything will be exactly as it is now.}
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 852
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		message 9
		signal 451
		helpStr {This restores a game you saved earlier.}
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 852
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		message 9
		signal 451
		helpStr {Use this to restart the game from the very beginning.}
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 852
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		message 9
		signal 451
		helpStr {Use this to leave the game.}
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 852
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 9
		signal 451
		helpStr {Here's where you learn more than you care to know about this game.}
	)
)

(instance iconHelp of IconI
	(properties
		view 852
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 150
		message 6
		signal 387
		helpStr {This helps explain the other icons.}
	)
)

(instance iconOk of IconI
	(properties
		view 852
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 999
		message 9
		signal 451
		helpStr {Use this to exit this menu and resume game play.}
	)
)

(class Person of Actor
	(properties
		complained 0
	)

	(method (doit)
		(super doit:)
		(cond
			((IsFlag 40) ; fToiletPaperOnShoe
				(if (< (self distanceTo: gEgo) 30)
					(ClearFlag 40) ; fToiletPaperOnShoe
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 0 59) ; "Hey, dork! You've got toilet paper stuck to your shoe!"
					(Print 0 60) ; "You nonchalantly scrape it off."
				)
			)
			((IsFlag 37) ; fSmellsLikeDogPiss
				(if (< (self distanceTo: gEgo) 30)
					(ClearFlag 37) ; fSmellsLikeDogPiss
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 0 4) ; "Phew! You smell like a used fire hydrant!"
				)
			)
			(
				(and
					(not gSpraySeconds)
					(IsFlag 20) ; fMouthSmellsBad
					(not complained)
					(< (self distanceTo: gEgo) 30)
				)
				(self complained: 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 0 61) ; "Eeeyow! Do something about that breath of yours!"
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 0 62) ; "You'd better not. You might get your face slapped!"
			)
			(4 ; Inventory
				(Printf 0 63 ((Inv at: invItem) description:) description) ; ""I have no use for %s!" says %s."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

