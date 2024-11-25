;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use eRS)
(use Larry)
(use Patti)
(use n175)
(use Interface)
(use PseudoMouse)
(use GameControls)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Timer)
(use Grooper)
(use Window)
(use Sound)
(use Motion)
(use File)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	LSL5 0
	EgoIs 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	StepOn 5
	IsFlag 6
	SetFlag 7
	ClearFlag 8
	RecordTape 9
	Points 10
	Face 11
	NoResponse 12
	SetFFRoom 13
	TPrint 14
	WalkTo 15
	RestoreIB 16
	Delay 17
	Say 18
	gcWin 20
	ll5Win 21
	SetupExit 22
	SaveCurIcon 23
	LoadCurIcon 24
	CenterDisplay 25
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
	gSGrooper
	gGameCode = 1234
	gTheMusic
	gTheMusic2
	gCursorType
	; 105
	gNumColors
	gNumVoices
	gRestartRoom = 100
	gSkateAbility
	gSaveCursorX
	; 110
	gSaveCursorY
	gDebugging
	gVersionIntPhone
	gTapesDegaussed
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
	gColBlack
	gColGray1
	gColGray2
	; 125
	gColGray3
	gColGray4
	gColGray5
	gColWhite
	gColDRed
	; 130
	gColLRed
	gColVLRed
	gColDYellow
	gColYellow
	gColLYellow
	; 135
	gColVDGreen
	gColDGreen
	gColLGreen
	gColVLGreen
	gColDBlue
	; 140
	gColBlue
	gColLBlue
	gColVLBlue
	gColMagenta
	gColLMagenta
	; 145
	gColCyan
	gColLCyan
	gColWindow
	global148
	global149
	; 150
	gCamcorderCharge
	gFfRoom
	gLarryDollars
	gSilvDollars
	gTPed
	; 155
	global155
	gREMState
	gPattiDest
	gFfCueObj
	gBoardWalkDist
	; 160
	gLarryLoc
	gPattiLoc
	gPattiDream
	gPokerJackpot
	gBlondeX
	; 165
	gBlondeLoop
	gRedHeadX
	gRedHeadLoop
	gQuarters
	gIconSettings
	; 170
	gTheTimer
	gRoomBNumber
	gMeanWhiles
	gMonoFont
	gGiantFont
	; 175
	gNiceFont
	gDestination
	gAirplaneSeat
	gDentistState
	gEgoIsLarry
	; 180
	gTalkersOnScreen
	gVersionDate
	gVersionPhone
	gChargeTimer
	gSaveCharge
	; 185
	gTheCurIcon
	gGameFlags
	global187
	global188
	global189
	; 190
	gPointFlags
	global191
	global192
	global193
	global194
	; 195
	global195
	global196
	global197
	gEndGameFlags
	global199
)

(procedure (localproc_0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(= gSaveCharge 0)
	(if (gChargeTimer client:)
		(= gSaveCharge (gChargeTimer seconds:))
		(gChargeTimer client: 0)
	)
	(if (and (IsObject gFastCast) (gFastCast elements:))
		(gFastCast eachElementDo: #dispose 1)
	)
	(gTheIconBar disable:)
)

(procedure (EgoIs who)
	(switch who
		(23
			(= gEgo Larry)
			(= gEgoIsLarry 1)
			(User alterEgo: gEgo)
			(gEgo setUpInv:)
		)
		(24
			(= gEgo Patti)
			(= gEgoIsLarry 0)
			(User alterEgo: gEgo)
			(gEgo setUpInv:)
		)
	)
)

(procedure (HandsOff)
	(SaveCurIcon)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= gIconSettings 0)
	(gTheIconBar eachElementDo: #perform checkIcon)
	(gTheIconBar disable: 0 1 2 3 4 6 7)
	(if (not (HaveMouse))
		(= gSaveCursorX gMouseX)
		(= gSaveCursorY gMouseY)
		(gGame setCursor: gWaitCursor 1 310 185)
	else
		(gGame setCursor: gWaitCursor 1)
	)
)

(procedure (HandsOn)
	(User canControl: 1 canInput: 1)
	(gTheIconBar enable: 0 1 2 3 4 6 7 8)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 6)
	)
	(LoadCurIcon)
	(if (not (HaveMouse))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 gSaveCursorX gSaveCursorY)
	else
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
)

(procedure (HaveMem howMuch)
	(return (u> (MemoryInfo 1) howMuch)) ; FreeHeap
)

(procedure (StepOn who color)
	(if (& (who onControl: 1) color)
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

(procedure (RecordTape who theTape &tmp whichTape)
	(if (== who 1)
		((Inv at: theTape) state: who name: {An Erased Videotape})
	else
		(= whichTape (mod ((Inv at: 0) state:) 100)) ; Camcorder
		((Inv at: whichTape)
			state: who
			name:
				(switch who
					(2 {Michelle Milken})
					(3 {Lana Luscious})
					(4 {Chi Chi Lambada})
				)
		)
	)
)

(procedure (Points val flag)
	(if (and (> argc 1) (SetFlag flag))
		(= val 0)
	)
	(if val
		(gGame changeScore: val)
		(if (> val 0)
			(pointsSound play:)
		)
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

(procedure (SetFFRoom theRoom cueObj)
	(if (not theRoom)
		(= gFfRoom 0)
		(= gFfCueObj 0)
		(gTheIconBar disable: 5)
	else
		(= gFfRoom theRoom)
		(if (and (> argc 1) (== theRoom 1000))
			(= gFfCueObj cueObj)
		)
		(gTheIconBar enable: 5)
	)
)

(procedure (TPrint arg1 arg2 &tmp [str 300] theTime saveCursor)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(if (not (HaveMouse))
		(= saveCursor (gGame setCursor: 69 1))
	)
	(if (u< arg1 1000)
		(GetFarText arg1 arg2 @str)
		(= theTime (Max 3 (/ (* global155 (StrLen @str)) 120)))
		(Print @str #time theTime &rest)
	else
		(= theTime (Max 3 (/ (* global155 (StrLen arg1)) 120)))
		(Print arg1 25 theTime arg2 &rest)
	)
	(if (not (HaveMouse))
		(gGame setCursor: saveCursor 1)
	)
	(return 1)
)

(procedure (WalkTo theObj theVerb &tmp evt)
	(if (< argc 2)
		(= theVerb 1)
	)
	(= evt
		((Event new:) type: evVERB message: theVerb x: (theObj x:) y: (theObj y:))
	)
	(theObj handleEvent: evt)
	(evt dispose:)
)

(procedure (RestoreIB &tmp i)
	(HandsOn)
	(for ((= i 0)) (< i 8) ((++ i))
		(if (& gIconSettings (>> $8000 i))
			(gTheIconBar disable: i)
		)
	)
)

(procedure (Delay howLong delayType whoCares theCode)
	(if (or (< argc 3) (== whoCares 0))
		(= whoCares gTheTimer)
	)
	(if (> argc 3)
		(gTheTimer code: theCode)
	)
	(cond
		((== delayType 1)
			(gTheTimer setCycle: whoCares howLong)
		)
		((== delayType 0)
			(gTheTimer set: whoCares howLong)
		)
		(else
			(gTheTimer setReal: whoCares howLong)
		)
	)
)

(procedure (Say who arg1 arg2 &tmp disposeOrNot who2Cue i [buffer 200])
	(cond
		((u< arg1 1000)
			(GetFarText arg1 arg2 @buffer)
			(= i 2)
		)
		(arg1
			(StrCpy @buffer arg1)
			(= i 1)
		)
		(else
			(= buffer 0)
			(= i 0)
		)
	)
	(= disposeOrNot (= who2Cue 0))
	(if (== who gEgo)
		(if (> i 1)
			(TPrint @buffer #title {You} &rest)
		else
			(TPrint @buffer 80 {You} arg2 &rest)
		)
	else
		(for ((= i i)) (< i argc) ((++ i))
			(switch [arg1 i]
				(108
					(= disposeOrNot 1)
				)
				(139
					(= who2Cue [arg1 (++ i)])
				)
			)
		)
		(if (who underBits:)
			(who say: @buffer 0 0 disposeOrNot who2Cue)
		else
			(who init: say: @buffer 0 0 disposeOrNot who2Cue)
		)
	)
)

(procedure (NoResponse obj verb &tmp [str 40] [fileName 10] [vstr 10])
	(StrCpy
		@vstr
		(switch verb
			(1 {Walk})
			(2 {Look})
			(3 {Do})
			(5 {Talk})
			(10 {Zipper})
			(else {UNKNOWN VERB})
		)
	)
	(Format @fileName 0 24 gCurRoomNum) ; "%d.msg"
	(Format ; ";%s (%s) [%d,%d]:"
		@str
		0
		25
		(obj name:)
		@vstr
		((User curEvent:) x:)
		((User curEvent:) y:)
	)
	(File name: @fileName writeString: @str {\0d\n} close:)
)

(procedure (SetupExit turnOn)
	(if turnOn
		(icon0 loop: 15 cursor: 6)
	else
		(icon0 loop: 0 cursor: 0)
	)
	(if (== (gTheIconBar curIcon:) icon0)
		(gGame setCursor: (icon0 cursor:))
	)
)

(procedure (SaveCurIcon)
	(if (not gTheCurIcon)
		(= gTheCurIcon (gTheIconBar curIcon:))
	)
)

(procedure (LoadCurIcon)
	(if gTheCurIcon
		(gTheIconBar curIcon: gTheCurIcon)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(= gTheCurIcon 0)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
				(not (gTheIconBar curInvIcon:))
			)
			(gTheIconBar advanceCurIcon:)
		)
	)
)

(procedure (CenterDisplay lines theColor &tmp oldPort)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(= oldPort (GetPort))
	(SetPort 0)
	(Display
		&rest
		dsALIGN
		alCENTER
		dsCOLOR
		theColor
		dsFONT
		gNiceFont
		dsWIDTH
		318
		dsCOORD
		1
		(- 89 (/ (* 14 lines) 2))
	)
	(SetPort oldPort)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance hotSound of Sound
	(properties)
)

(class WrapMusic of Obj
	(properties
		firstSound 0
		lastSound 0
	)

	(method (init)
		(super init:)
		(gTheMusic number: firstSound setLoop: 1 play: self)
	)

	(method (cue &tmp num oldVol)
		(if (== (gTheMusic prevSignal:) -1)
			(= num (gTheMusic number:))
			(= oldVol (gTheMusic vol:))
			(if (> (++ num) lastSound)
				(= num firstSound)
			)
			(gTheMusic number: num play: oldVol self)
		)
	)
)

(class ll5Timer of Timer
	(properties
		code 0
	)

	(method (cue)
		(if code
			(code doit:)
			(= code 0)
		)
	)
)

(instance camcorderTimer of Timer
	(properties
		seconds 0
	)

	(method (doit)
		(if (>= ((Inv at: 0) state:) 100) ; Camcorder
			(super doit:)
		)
	)

	(method (cue &tmp cam)
		(TPrint 0 0) ; "You hear a delicate little click from the camcorder as its tiny battery is now completely drained."
		(= cam (Inv at: 0)) ; Camcorder
		(cam state: (- (cam state:) 100))
	)
)

(class Actions of Code
	(properties)

	(method (doVerb)
		(return 0)
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance quitIcon of DCIcon
	(properties)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance ll5KDHandler of EventHandler
	(properties)
)

(instance ll5MDHandler of EventHandler
	(properties)
)

(instance ll5DirHandler of EventHandler
	(properties)
)

(instance LSL5 of Game
	(properties)

	(method (restore &tmp temp0)
		(if (<= gCurRoomNum 150)
			(= temp0 (PasswordTest))
			(DisposeScript 175)
			(if gQuit
				(super quitGame: 1)
			else
				(super restore: &rest)
				(localproc_0)
				(super newRoom: 160 &rest)
			)
		else
			(super restore: &rest)
		)
	)

	(method (init &tmp [temp0 6] temp6 temp7 temp8)
		(= gSGrooper stopGroop)
		StopWalk
		Timer
		Polygon
		PolyPath
		LLRoom
		IconBar
		Inv
		(ScriptID 982)
		(super init:)
		((ScriptID 16 0) init:) ; ll5InitCode
		(DisposeScript 16)
		(= gDoVerbCode ll5DoVerbCode)
		(= gFtrInitializer ll5FtrInit)
		((= gKeyDownHandler ll5KDHandler) add:)
		((= gMouseDownHandler ll5MDHandler) add:)
		((= gDirectionHandler ll5DirHandler) add:)
		(= gPMouse PseudoMouse)
		((= gTheMusic longSong) owner: self flags: 1 init:)
		((= gTheMusic2 longSong2) owner: self flags: 1 init:)
		(= gTheTimer ll5Timer)
		(= gChargeTimer camcorderTimer)
		(if (not (FileIO fiEXISTS {memory.drv}))
			((= temp8 (SysWindow new:)) color: gColBlack back: gColWhite)
			(Print 0 1 #window temp8 #font 0) ; "Can't load MEMORY.DRV"
			(= gQuit 1)
			(return 0)
		)
		(= gVersion {x.yyy.zzz})
		(= gVersionDate {mm/dd/yy})
		(= gVersionPhone {991-999-9999})
		(= gVersionIntPhone {992-999-9999})
		(= temp7 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 11 temp7)
		(FileIO fiREAD_STRING gVersionDate 20 temp7)
		(FileIO fiREAD_STRING gVersionPhone 20 temp7)
		(FileIO fiREAD_STRING gVersionIntPhone 20 temp7)
		(FileIO fiCLOSE temp7)
		((= gTheIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon5 icon6 icon7 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			disable: 6
			disable:
			state: 3072
		)
		(icon7 message: (if (HaveMouse) 3840 else 9))
		(GameControls
			window: gcWin
			add:
				iconOk
				detailSlider
				(volumeSlider theObj: self selector: #masterVolume yourself:)
				(speedSlider theObj: self selector: #setSpeed yourself:)
				textSlider
				(iconSave theObj: self selector: #save yourself:)
				(iconRestore theObj: self selector: #restore yourself:)
				(iconRestart theObj: self selector: #restart yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(iconAbout theObj: (ScriptID 15 0) selector: #doit yourself:) ; aboutCode
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor gColLYellow
			helpIconItem: iconHelp
			curIcon: iconSave
			state: 2048
		)
		(= temp6 23)
		(SetFFRoom 0)
		(if (GameIsRestarting)
			(MemorySegment 1 @gRestartRoom) ; MS_RESTORE_TO
		)
		(= gEgo Larry)
		(= gEgoIsLarry 1)
		(User alterEgo: gEgo verbMessager: 0 canControl: 0 canInput: 0)
		(Inv release:)
		(gEgo setUpInv:)
		(self newRoom: gRestartRoom)
	)

	(method (doit)
		(super doit:)
		(cond
			((== ((Inv at: 0) owner:) (Inv at: 1)) ; Camcorder, Battery_Charger
				(= gCamcorderCharge (Min 2000 (+= gCamcorderCharge 3)))
			)
			((>= ((Inv at: 0) state:) 100) ; Camcorder
				(= gCamcorderCharge (Max 0 (-- gCamcorderCharge)))
			)
		)
	)

	(method (pragmaFail &tmp theVerb theItem [str 30])
		(if (and gModelessDialog (not gTalkersOnScreen))
			(gModelessDialog dispose:)
			(return 1)
		)
		(return
			(and
				(User canInput:)
				(switch (= theVerb ((User curEvent:) message:))
					(2
						(TPrint 0 2) ; "It's not much to look at."
					)
					(5
						(TPrint 0 3) ; "To whom were you trying to speak?"
					)
					(3
						(TPrint 0 4) ; "There's nothing to do there."
					)
					(10
						(cond
							((gCurRoom script:)
								(TPrint 0 5) ; "Now?!"
							)
							(
								(and
									(!= (gEgo view:) 550)
									(!= (gEgo view:) 570)
								)
								(TPrint 0 5) ; "Now?!"
							)
							(gEgoIsLarry
								(TPrint 0 6) ; "You coyly turn your back and relieve yourself. You quickly feel much better. The hint of a smile crosses your lips."
							)
							(else
								(TPrint 0 7) ; "Visions of cucumbers dance through your head."
							)
						)
					)
					(4
						(= theItem (Inv indexOf: (gTheIconBar curInvIcon:)))
						(if gEgoIsLarry
							(switch theItem
								(0
									(TPrint 0 8) ; "Good thinking! Shoot a little tape of that!"
									(TPrint 0 9 #at -1 185) ; "(But is your pocket camcorder working?)"
								)
								(6
									(TPrint 0 10) ; "You wave your napkin in the air. How fun!"
								)
								(7
									(TPrint 0 11) ; "That's one more place that won't accept your AeroDork Gold Card!"
								)
								(10
									(TPrint 0 12) ; "That doesn't look like a vending machine!"
								)
								(12
									(TPrint 0 13) ; "Stop flashing your money around, Larry!"
								)
								(16
									(TPrint 0 14) ; "That's not something you should set afire!"
								)
								(22
									(TPrint 0 15) ; "Your doily would look lovely there, but you'd better keep it instead."
								)
								(else
									(Format ; "Try finding some place else to place %s."
										@str
										0
										16
										((Inv at: theItem) description:)
									)
									(TPrint @str)
								)
							)
						else
							(switch theItem
								(3
									(TPrint 0 17) ; "You wave the fax in the air. You have fun."
									(TPrint 0 18 #at -1 185) ; "(But not much!)"
								)
								(4
									(TPrint 0 19) ; "That's not a good place to pour out your champagne."
								)
								(5
									(TPrint 0 20) ; "Your gold record would get scratched there."
								)
								(7
									(TPrint 0 17) ; "You wave the fax in the air. You have fun."
									(TPrint 0 18 #at -1 185) ; "(But not much!)"
								)
								(13
									(TPrint 0 21) ; "You briefly contemplate firing your bra at that, but decide to hold your "fire.""
								)
								(else
									(Format ; "Try finding some place else to place %s."
										@str
										0
										16
										((Inv at: theItem) description:)
									)
									(TPrint @str)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (restart)
		(gCurRoom style: 6 drawPic: 1 dispose:)
		(gCast eachElementDo: #hide)
		(MemorySegment 0 @gRestartRoom 2) ; MS_SAVE_FROM
		(super restart:)
	)

	(method (quitGame &tmp [str1 10] [str2 8] theFile)
		(if gQuit
			(super quitGame: 1)
		else
			(quitIcon view: 992 loop: 1 cycleSpeed: 9)
			(if
				(Print ; "Fine. Go ahead. Leave! We've got better things to do in here anyway, don't we, Patti?"  "(How's this feel, babe?)"  "(Ooooh, Larry! Let 'em go play with their word processors now!)"
					0
					22
					#title
					{So You're Finally Leaving?}
					#button
					{Okay, you two. Have fun!}
					1
					#button
					{Hey! Back to work!}
					0
					#icon
					quitIcon
					0
					0
				)
				(if ((= theFile (File new:)) name: {MEMORY.DRV} open: 1)
					(theFile readString: @str1 20 close:)
				)
				(if (theFile open: 2)
					(Format @str2 0 23 gPokerJackpot) ; "%d"
					(theFile
						writeString: @str1
						writeString: {\n}
						writeString: @str2
						close:
					)
				)
				(theFile dispose:)
				(super quitGame: 1)
			)
		)
	)

	(method (newRoom)
		(localproc_0)
		(cond
			((== gFfRoom 1155)
				(SetFlag 7) ; fBeenIn150
				(PasswordTest)
				(DisposeScript 175)
				(if gQuit
					(super quitGame: 1)
				else
					(= gFfRoom 160)
					(super newRoom: 160 &rest)
				)
			)
			((> gFfRoom 1000)
				(switch gFfRoom
					(1155
						(SetFlag 7) ; fBeenIn150
					)
					(1480
						(SetFlag 47) ; fFFto480
					)
				)
				(-= gFfRoom 1000)
				(super newRoom: &rest)
			)
			(else
				(super newRoom: &rest)
			)
		)
	)

	(method (setSpeed what)
		(if argc
			(gEgo cycleSpeed: what moveSpeed: what)
			(self egoMoveSpeed: what)
		)
		(gEgo moveSpeed:)
	)

	(method (startRoom roomNum)
		((ScriptID 11) doit: roomNum) ; disposeCode
		(if (OneOf gFfRoom roomNum 1000)
			(SetFFRoom 0)
		)
		(cond
			((== roomNum 200)
				(Inv release:)
				(gEgo setUpInv:)
			)
			(
				(OneOf
					roomNum
					160
					170
					180
					190
					100
					110
					120
					130
					140
					150
					250
					258
					260
					270
					280
					290
					295
					310
					320
					385
					390
					205
					500
					510
					520
					525
					530
					535
					700
					710
					720
					730
					740
					750
					760
					780
					790
					900
					905
					910
					915
					920
				)
				(if (not gEgoIsLarry)
					(DisposeScript 24)
					(Inv release:)
					(gTheIconBar curInvIcon: 0)
					(gTheIconBar curIcon: (gTheIconBar at: 0))
					(EgoIs 23)
				)
			)
			(gEgoIsLarry
				(DisposeScript 23)
				(Inv release:)
				(gTheIconBar curInvIcon: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(EgoIs 24)
			)
		)
		(if (OneOf roomNum 160 170 180 190)
			(ScriptID 40) ; HollywoodRgn
		)
		(gTheIconBar enable:)
		(super startRoom: roomNum)
		(if gSaveCharge
			(gChargeTimer setReal: gChargeTimer gSaveCharge)
		)
		(if
			(and
				(gEgo cycler:)
				(not (gEgo looper:))
				((gEgo cycler:) isKindOf: StopWalk)
			)
			(gEgo setLoop: stopGroop)
		)
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSERELEASE)
			(gMouseDownHandler handleEvent: event)
		else
			(super handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(not
							(OneOf gCurRoomNum 200 460 700 760 660 390 535 320)
						)
						(DoSound sndGET_AUDIO_CAPABILITY)
					)
					(switch (event message:)
						(KEY_F1
							(hotSound number: 482 play:)
						)
						(KEY_F3
							(hotSound number: 483 play:)
						)
						(KEY_F4
							(hotSound number: 484 play:)
						)
						(KEY_F6
							(hotSound number: 851 play:)
						)
						(KEY_F8
							(hotSound number: 526 play:)
						)
						(KEY_F9
							(hotSound number: 161 play:)
						)
						(KEY_F10
							(hotSound number: 892 play:)
						)
					)
				)
				(switch (event message:)
					(KEY_TAB
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if (or gFastCast gTalkersOnScreen)
								(return)
							)
							(gEgo showInv:)
						)
					)
					(KEY_SHIFTTAB
						(if (not (& ((gTheIconBar at: 7) signal:) $0004))
							(if (or gFastCast gTalkersOnScreen)
								(return)
							)
							(gEgo showInv:)
						)
					)
					(KEY_CONTROL
						(gGame quitGame:)
						(event claimed: 1)
					)
					(JOY_RIGHT
						(gTheIconBar hide:)
						(GameControls show:)
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
						(if (not (& ((gTheIconBar at: 8) signal:) $0004))
							(if (or gFastCast gTalkersOnScreen)
								(return)
							)
							(gGame save:)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if (not (& ((gTheIconBar at: 8) signal:) $0004))
							(if (or gFastCast gTalkersOnScreen)
								(return)
							)
							(gGame restore: &rest)
							(event claimed: 1)
						)
					)
					(KEY_ADD
						(if (User controls:)
							(gGame
								setSpeed:
									(Max 0 (- (gGame egoMoveSpeed:) 1))
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
							(gGame setSpeed: 6)
						)
					)
				)
			)
		)
	)
)

(instance pointsSound of Sound
	(properties
		flags 1
		number 10
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 0
		message 1
		signal 65
		helpStr {Use this icon to move your character.}
		maskView 990
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(= lowlightColor gColLMagenta)
		(super init:)
	)

	(method (select &tmp evt)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(if (== cursor 6)
				((= evt (Event new:)) type: evMOUSEBUTTON message: JOY_UP)
				(if (not (gMouseDownHandler handleEvent: evt))
					(gRegions handleEvent: evt)
				)
				(evt dispose:)
			)
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
		cursor 1
		message 2
		signal 65
		helpStr {Use this icon to look at things.}
		maskView 990
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(= lowlightColor gColCyan)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 2
		message 3
		signal 65
		helpStr {Use this icon to do things.}
		maskView 990
		maskLoop 14
	)

	(method (init)
		(= lowlightColor gColLGreen)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 3
		message 5
		signal 65
		helpStr {Use this icon to talk to other characters.}
		maskView 990
		maskLoop 14
		maskCel 3
	)

	(method (init)
		(= lowlightColor gColLRed)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 10
		cel 0
		cursor 5
		message 10
		signal 65
		helpStr {Say! Don't you know what your zipper is for?}
		maskView 990
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(= lowlightColor gColLYellow)
		(super init:)
	)
)

(instance icon5 of IconI
	(properties
		view 990
		loop 11
		cel 0
		cursor 999
		message 0
		signal 67
		helpStr {This icon lets you "Fast Forward" to the next interactive portion of the game.}
		maskView 990
		maskLoop 14
	)

	(method (init)
		(= lowlightColor gColCyan)
		(super init:)
	)

	(method (select)
		(if gFfRoom
			(super select: &rest)
			(gTheIconBar hide:)
			(if (Print 0 26 #title {Fast Forward} #button {Yes} 1 #button {Oops} 0) ; "Do you really want to skip ahead?"
				(if (== gFfRoom 1000)
					(if (IsObject gFfCueObj)
						(gFfCueObj cue:)
						(SetFFRoom 0)
					else
						(Print 0 27) ; "ERROR: Object passed to SetFFRoom -1 ain't."
					)
				else
					(gCurRoom newRoom: gFfRoom)
					(+= gFfRoom 1000)
				)
			)
		else
			(return 0)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		message 4
		signal 65
		helpStr {Select this icon to use your current inventory object.}
		maskView 990
		maskLoop 14
		maskCel 4
	)

	(method (init)
		(= lowlightColor gColLGreen)
		(super init:)
	)

	(method (select relVer &tmp event whichCel cii theX theY)
		(return
			(cond
				((& signal $0004) 0)
				((and argc relVer (& signal $0001))
					(if (= cii (gTheIconBar curInvIcon:))
						(= theX
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(cii view:)
											(+ (cii loop:) 1)
											(cii cel:)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= theY
							(+
								(gTheIconBar y:)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(cii view:)
											(+ (cii loop:) 1)
											(cii cel:)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= whichCel 1) nsLeft nsTop -1)
					(if (= cii (gTheIconBar curInvIcon:))
						(DrawCel
							(cii view:)
							(+ 1 (cii loop:))
							(cii cel:)
							theX
							theY
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
						(event localize:)
						(cond
							((self onMe: event)
								(if (not whichCel)
									(DrawCel
										view
										loop
										(= whichCel 1)
										nsLeft
										nsTop
										-1
									)
									(if (= cii (gTheIconBar curInvIcon:))
										(DrawCel
											(cii view:)
											(+ 1 (cii loop:))
											(cii cel:)
											theX
											theY
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(whichCel
								(DrawCel view loop (= whichCel 0) nsLeft nsTop -1)
								(if (= cii (gTheIconBar curInvIcon:))
									(DrawCel
										(cii view:)
										(+ 1 (cii loop:))
										(cii cel:)
										theX
										theY
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(event dispose:)
					)
					(event dispose:)
					(if (== whichCel 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= cii (gTheIconBar curInvIcon:))
							(DrawCel
								(cii view:)
								(+ 1 (cii loop:))
								(cii cel:)
								theX
								theY
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					whichCel
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
		helpStr {Use this icon to bring up your inventory window.}
		maskView 990
		maskLoop 14
		maskCel 2
	)

	(method (init)
		(= lowlightColor gColYellow)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gEgo showInv:)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 8
		signal 67
		helpStr {This icon brings up the control panel.}
		maskView 990
		maskLoop 14
		maskCel 1
	)

	(method (init)
		(= lowlightColor gColLMagenta)
		(super init:)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(GameControls show:)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 990
		loop 9
		cel 0
		cursor 9
		message 6
		signal 3
		helpStr {To learn about the other icons, first click here, then pass the question mark over the other icons.}
		maskView 990
		maskLoop 14
	)

	(method (init)
		(= lowlightColor gColLRed)
		(super init:)
	)
)

(instance checkIcon of Code
	(properties)

	(method (doit theIcon)
		(if (and (theIcon isKindOf: IconI) (& (theIcon signal:) $0004))
			(|= gIconSettings (>> $8000 (gTheIconBar indexOf: theIcon)))
		)
	)
)

(instance ll5DoVerbCode of Code
	(properties)

	(method (doit theVerb theObj &tmp objDesc theItem [str 100])
		(= objDesc (theObj description:))
		(switch theVerb
			(1
				((User curEvent:) claimed: 0)
			)
			(2
				(if (theObj lookStr:)
					(TPrint (theObj lookStr:))
				else
					(Format @str 0 28 objDesc) ; "Why, look! It's %s."
					(TPrint @str)
				)
			)
			(5
				(Format @str 0 29 objDesc) ; "You engage in a short, but personally meaningful, conversation with %s."
				(TPrint @str)
			)
			(3
				(Format @str 0 30 objDesc) ; "That feels exactly like %s."
				(TPrint @str)
			)
			(4
				(= theItem ((gTheIconBar curInvIcon:) description:))
				(Format @str 0 31 theItem objDesc) ; "It seems %s just doesn't work with %s."
				(TPrint @str)
			)
			(10
				(Format @str 0 32 objDesc) ; "Don't do that to %s!"
				(TPrint @str)
			)
			(else
				(NoResponse theObj theVerb)
			)
		)
	)
)

(instance ll5FtrInit of Code
	(properties)

	(method (doit theObj)
		(if (== (theObj sightAngle:) 26505)
			(theObj sightAngle: 90)
		)
		(if (== (theObj actions:) 26505)
			(theObj actions: 0)
		)
		(if (and (not (theObj approachX:)) (not (theObj approachY:)))
			(theObj approachX: (theObj x:) approachY: (theObj y:))
		)
	)
)

(instance ll5Win of SysWindow
	(properties)
)

(instance gcWin of SysWindow
	(properties)

	(method (open &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 [temp8 4] temp12 temp13 [temp14 15] [temp29 4])
		(= temp12 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			left: (/ (- 320 (+ 191 (CelWide 995 0 1))) 2)
			bottom:
				(+ (CelHigh 995 1 1) 6 (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2))
			right:
				(+
					191
					(CelWide 995 0 1)
					(/ (- 320 (+ 191 (CelWide 995 0 1))) 2)
				)
			priority: temp12
		)
		(super open:)
		(DrawCel
			995
			0
			6
			(+
				(/
					(-
						(- (+ 191 (CelWide 995 0 1)) (+ 4 (CelWide 995 1 1)))
						(CelWide 995 0 6)
					)
					2
				)
				4
				(CelWide 995 1 1)
			)
			6
			temp12
		)
		(DrawCel 995 1 1 4 3 temp12)
		(DrawCel 995 1 0 94 38 temp12)
		(DrawCel 995 1 0 135 38 temp12)
		(DrawCel 995 1 0 175 38 temp12)
		(DrawCel 995 0 4 63 (- 37 (+ (CelHigh 995 0 4) 3)) temp12)
		(DrawCel 995 0 3 101 (- 37 (+ (CelHigh 995 0 4) 3)) temp12)
		(DrawCel 995 0 2 146 (- 37 (+ (CelHigh 995 0 4) 3)) temp12)
		(DrawCel 995 0 5 186 (- 37 (+ (CelHigh 995 0 4) 3)) temp12)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 995 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 995 1 1)))
				(- (+ 191 (CelWide 995 0 1)) (+ 10 (CelWide 995 1 1) 6))
			)
		)
		(= temp6 0)
		(= temp7 1)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 0 33 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			gColGray5
			dsCOORD
			(+
				10
				(CelWide 995 1 1)
				(/
					(-
						(- (+ 191 (CelWide 995 0 1)) (+ 10 (CelWide 995 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 995 0 1) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal 128
		helpStr {Raise this to increase the amount of background animation. Lower it if game play seems sluggish.}
		sliderView 995
		bottomValue 1
		topValue 5
	)

	(method (doit num)
		(if argc
			(gGame detailLevel: num)
		)
		(gGame detailLevel:)
	)
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal 128
		helpStr {This adjusts the volume on some sound boards and synthesizers.}
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal 128
		helpStr {This adjusts Larry and Patti's speed, within the limits of your computer's capabilities.}
		sliderView 995
		bottomValue 15
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

(instance textSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 187
		nsTop 37
		signal 128
		helpStr {Lower this slide to make text remain on the screen longer. Raise it if you are a fast reader.}
		sliderView 995
		bottomValue 24
		topValue 1
	)

	(method (doit num)
		(if argc
			(= global155 num)
		)
		(return global155)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 995
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
		view 995
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
		view 995
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
		view 995
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
		view 995
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 9
		signal 451
		helpStr {Here's where you learn more than you care to know about the creators of this game.}
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 9
		message 6
		signal 387
		helpStr {To learn about the other items in this window, first click here, then pass the question mark over the other items.}
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 9
		message 9
		signal 451
		helpStr {Use this to exit this menu and resume game play.}
	)
)

