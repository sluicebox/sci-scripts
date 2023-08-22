;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n010)
(use Tactor)
(use DisplayStart)
(use goGet)
(use Interface)
(use n401)
(use CDActor)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use LoadMany)
(use Window)
(use Sound)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Tales 0
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
	global100
	global101 = 1234
	global102
	global103 = 16
	gJackStory
	; 105
	gCindStory
	gBremenStory
	gSnowStory
	gBeautyStory
	gStorySet
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
	gEgoTravCodeSet
	gFriendTravCodeSet
	gBookEnd
	global129 = 4
	; 130
	global130 = 220
	global131 = 240
	global132 = 250
	global133 = 300
	global134 = 4
	; 135
	global135 = 150
	global136 = 200
	global137 = 260
	global138 = 210
	global139
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145
	gTalkerIcon
	global147
	global148
	global149
	; 150
	gGlobalMusic
	gGlobalMusic2
	global152 = 48
	global153 = 34
	global154 = 51
	; 155
	global155 = 25
	global156 = 49
	global157 = 19
	global158 = 42
	global159 = 34
	; 160
	global160 = 44
	global161 = 25
	global162 = 43
	global163 = 23
	global164 = 42
	; 165
	global165 = 32
	global166 = 44
	global167 = 23
	global168 = 43
	global169 = 20
	; 170
	global170 = 43
	global171 = 31
	global172 = 45
	global173 = 24
	global174 = 44
	; 175
	global175 = 19
	global176 = 44
	global177 = 30
	global178 = 47
	global179 = 23
	; 180
	global180 = 45
	global181 = 18
	global182 = 42
	global183 = 30
	global184 = 46
	; 185
	global185 = 24
	global186 = 43
	global187 = 16
	global188 = 29
	global189 = 34
	; 190
	global190 = 29
	global191 = 25
	global192 = 28
	global193 = 19
	global194 = 36
	; 195
	global195 = 34
	global196 = 35
	global197 = 25
	global198 = 34
	global199 = 23
	; 200
	global200 = 34
	global201 = 32
	global202 = 35
	global203 = 23
	global204 = 34
	; 205
	global205 = 20
	global206 = 34
	global207 = 31
	global208 = 34
	global209 = 24
	; 210
	global210 = 33
	global211 = 19
	global212 = 33
	global213 = 30
	global214 = 32
	; 215
	global215 = 23
	global216 = 32
	global217 = 18
	global218 = 33
	global219 = 30
	; 220
	global220 = 34
	global221 = 24
	global222 = 33
	global223 = 16
	global224
	; 225
	global225
	gWalkMusic
	global227
	global228
	global229 = 1
	; 230
	gGlobalSoundEffect
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
	global240
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
	global250
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
	global260
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
	global270
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
	global290
	global291
	global292
	global293
	global294
	; 295
	global295
	global296
	global297
	global298
	global299
	; 300
	global300
)

(procedure (localproc_0 param1 param2 &tmp [temp0 400] [temp400 21] temp421 temp422 temp423 temp424)
	(= temp421 (GetSaveFiles (gGame name:) @temp0 @temp400))
	((= temp423 (File new:))
		name: (DeviceInfo 7 param2 (gGame name:)) ; MakeSaveDirName
		open: 2
	)
	(= temp424 2570)
	(for ((= temp422 0)) (< temp422 temp421) ((++ temp422))
		(if (!= temp422 param1)
			(temp423 write: @[temp400 temp422] 2)
			(temp423 writeString: @[temp0 (* temp422 18)])
			(temp423 write: @temp424 1)
		)
	)
	(= temp424 -1)
	(temp423 write: @temp424 2 close: dispose:)
	(DeviceInfo 8 param2 (gGame name:) [temp400 param1]) ; MakeSaveFileName
	(FileIO fiUNLINK param2)
	(DisposeScript 993)
)

(procedure (localproc_1 &tmp temp0 [temp1 400] [temp401 21] temp422 temp423)
	(= temp0 (GetSaveFiles (gGame name:) @temp1 @temp401))
	(for ((= temp422 1)) 1 ((++ temp422))
		(for ((= temp423 0)) (< temp423 temp0) ((++ temp423))
			(breakif (== temp422 [temp401 temp423]))
		)
		(if (== temp423 temp0)
			(break)
		)
	)
	(return temp422)
)

(procedure (localproc_2 param1)
	(cond
		((param1 selected:)
			(Print 0 13) ; "Story already selected."
		)
		((param1 selectCode:)
			((param1 selectCode:) doit:)
		)
		(else
			(Print 0 14) ; "You have selected the wrong story."
		)
	)
	(storyControls hide:)
)

(instance ego of Body
	(properties
		description {cute little kid}
		lookStr {Why, it's YOU!}
		talkerID 1
	)

	(method (init)
		((= talkerObj egoTalkObj) setUp: egoBust egoEyes egoMouth)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 0 0) ; "You see yourself."
			)
			(5 ; Do
				(if (IsObject doCode)
					(doCode doit: theVerb)
				else
					(Print 0 1) ; "There is no one here to talk to."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (<= x 10)
			(= edgeHit 4)
		)
		(if (>= x 310)
			(= edgeHit 2)
		)
		(if (>= y 166)
			(= edgeHit 3)
		)
	)

	(method (onMe &tmp temp0 temp1)
		(= temp0 (super onMe: &rest))
		(gCast delete: self)
		(= temp1 (gCast firstTrue: #onMe &rest))
		(gCast addToFront: self)
		(if (and temp1 (< y (temp1 y:)))
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance egoTalkObj of TalkerObj
	(properties
		x -1
		y 87
		nsTop 10
		nsLeft 110
	)

	(method (setUp &tmp temp0 temp1)
		(super setUp: &rest)
		(= view (+ global139 10))
		(if (== facingDir 7)
			(= temp0 36)
		else
			(= temp0 0)
		)
		(= temp1 (* global139 6))
		(mouth
			nsLeft: [global152 (+ temp1 temp0)]
			nsTop: [global152 (+ temp1 temp0 1)]
			view: view
		)
		(eyes
			nsLeft: [global152 (+ temp1 temp0 2)]
			nsTop: [global152 (+ temp1 temp0 3)]
			view: view
		)
		(bust
			nsLeft: [global152 (+ temp1 temp0 4)]
			nsTop: [global152 (+ temp1 temp0 5)]
			view: view
		)
	)
)

(instance egoBust of View
	(properties
		loop 6
	)
)

(instance egoEyes of Prop
	(properties
		loop 4
		cycleSpeed 36
	)
)

(instance egoMouth of Prop
	(properties
		loop 2
		cycleSpeed 12
	)
)

(instance BookEnd of Tactor
	(properties
		description {Bookend}
		view 762
		talkerID 19
	)

	(method (setUp)
		((= talkerObj bookEndTalkObj)
			setUp: bookEndBust bookEndEyes bookEndMouth
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsObject doCode)
					(doCode doit: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookEndTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 761
	)
)

(instance bookEndBust of View
	(properties
		nsTop 10
		nsLeft 42
		view 761
		loop 6
	)
)

(instance bookEndEyes of Prop
	(properties
		nsTop 16
		nsLeft 44
		view 761
		loop 4
		cycleSpeed 36
	)
)

(instance bookEndMouth of Prop
	(properties
		nsTop 28
		nsLeft 42
		view 761
		loop 2
		cycleSpeed 12
	)
)

(instance MH of EventHandler
	(properties)
)

(instance KH of EventHandler
	(properties)
)

(instance DH of EventHandler
	(properties)
)

(instance Tales of Game
	(properties
		egoMoveSpeed 6
	)

	(method (init &tmp temp0 [temp1 20])
		(= global103 (Graph grGET_COLOURS))
		(SysWindow color: (proc10_30 37 1) back: (proc10_30 34 11))
		(= gSystemWindow SysWindow)
		(proc91_0)
		(= global140 0)
		(super init:)
		(StrCpy @gSysLogPath {})
		(proc10_14)
		(= gEgo ego)
		(= gBookEnd BookEnd)
		(User alterEgo: gEgo verbMessager: 0 canControl: 0 canInput: 0)
		(LoadMany rsSCRIPT 10 930 945 946 982 927 968 939)
		(= global17 0)
		(= gDoVerbCode DoVerbCode)
		(= gFtrInitializer FtrInit)
		(= gPMouse PseudoMouse)
		((= gKeyDownHandler KH) add:)
		((= gDirectionHandler DH) add:)
		((= gMouseDownHandler MH) add:)
		(= gUseSortedFeatures 0)
		(self setCursor: gTheCursor 1 0 0)
		(= gWaitCursor 89)
		(= gPossibleScore 100)
		(= gUserFont 82)
		(globalMusic owner: self init:)
		(globalMusic2 owner: self init:)
		(= gGlobalMusic globalMusic)
		(= gGlobalMusic2 globalMusic2)
		(= gGlobalSoundEffect globalSoundEffect)
		(= gWalkMusic walkMusic)
		(= gVersion {x.yyy    })
		(= global229 (DoSound sndGET_POLYPHONY))
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 9 temp0)
		(FileIO fiCLOSE temp0)
		((= gTheIconBar IconBar)
			add: iconDo iconLook iconUse iconBook iconMap iconControl iconWhat
			eachElementDo: #init
			eachElementDo: #highlightColor (proc10_30 5 31)
			eachElementDo: #lowlightColor (proc10_30 69 8)
			curIcon: iconDo
			useIconItem: iconUse
			helpIconItem: iconWhat
			state: (| (IconBar state:) $0800)
		)
		(GameControls
			window: gcWindow
			add:
				(iconSave theObj: self selector: #save yourself:)
				iconOk
				(iconAbout theObj: aboutCode selector: #doit yourself:)
				(iconQuit theObj: self selector: #quitGame yourself:)
				(volumeSlider
					theObj: self
					selector: #masterVolume
					topValue: 15
					bottomValue: 0
					yStep: 2
					yourself:
				)
				(dummyIcon
					nsBottom: (+ (CelHigh 947 1 1) 6)
					nsRight: (- (+ 124 (CelWide 947 0 1)) 8)
					yourself:
				)
			eachElementDo: #highlightColor (proc10_30 5 31)
			eachElementDo: #lowlightColor (proc10_30 58 9)
		)
		(= temp0 100)
		(HandsOn)
		(self newRoom: temp0)
	)

	(method (quitGame)
		(self save: 0)
		(proc10_11)
	)

	(method (startRoom roomNum)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(HandsOn 1)
		(self setCursor: gWaitCursor 1)
		(if gPMouse
			(gPMouse stop:)
		)
		(if (storyControls size:)
			(storyControls dispose:)
		)
		(LoadMany 0 946 982 951 961 973 927 956)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(Print 0 2 #button {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(= global148 0)
		(= global147 (not (OneOf roomNum 1 100 360 480 500))) ; Phono
		(super startRoom: roomNum)
		(if global147
			(gTheIconBar show: enable:)
		else
			(gTheIconBar hide: disable:)
		)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1 160 87)
	)

	(method (handleEvent event &tmp [temp0 2] temp2 temp3)
		(= temp2 (event type:))
		(= temp3 (event message:))
		(cond
			((and (== temp2 evKEYBOARD) (== temp3 KEY_CONTROL))
				(gGame quitGame:)
			)
			((and (== temp2 evKEYBOARD) (== temp3 KEY_F2))
				(cond
					((gGame masterVolume:)
						(gGame masterVolume: 0)
					)
					((> global229 1)
						(gGame masterVolume: 15)
					)
					(else
						(gGame masterVolume: 1)
					)
				)
				(event claimed: 1)
			)
			((or (not (User controls:)) (event claimed:))
				(event claimed: 1)
			)
			((== temp2 evKEYBOARD)
				(switch temp3
					(KEY_F5
						(if
							(and
								(not (& ((gTheIconBar at: 5) signal:) $0004))
								(not gFastCast)
							)
							(gGame save: 0)
							(event claimed: 1)
						)
					)
					(KEY_F7
						(if
							(and
								(not (& ((gTheIconBar at: 5) signal:) $0004))
								(not gFastCast)
							)
							(gGame restore: &rest)
							(event claimed: 1)
						)
					)
					(else
						(gKeyDownHandler handleEvent: event)
					)
				)
			)
			((== temp2 evMOUSEBUTTON)
				(gMouseDownHandler handleEvent: event)
			)
			((and (== temp2 evVERB) (== (event message:) JOY_DOWN))
				(event type: evMOUSEBUTTON)
				(gEgo handleEvent: event)
			)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(if global147
				(proc10_27)
				(gTheIconBar show:)
			)
			(gTheIconBar select: (gTheIconBar at: 0) curIcon: (gTheIconBar at: 0))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			(HandsOn 1)
		)
		(super doit: &rest)
	)

	(method (restore &tmp temp0 temp1)
		(= temp0 (gSystemWindow back:))
		(= temp1 (gSystemWindow color:))
		(gSystemWindow back: (proc10_30 59 11) color: (proc10_30 66 0))
		(super restore: &rest)
		(gSystemWindow back: temp0 color: temp1)
		(gTheIconBar select: (gTheIconBar at: 0) curIcon: (gTheIconBar at: 0))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(HandsOn 1)
	)

	(method (save param1 &tmp [temp0 400] [temp400 21] [temp421 18] [temp439 41] [temp480 70] temp550 temp551 temp552 temp553 temp554 temp555)
		(HandsOff)
		(GetCWD @temp480)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
		(Format @temp439 0 3 @global110) ; "%s's game"
		(= temp552 0)
		(= temp551 -1)
		(for ((= temp553 0)) (< temp553 temp550) ((++ temp553))
			(if (not (= temp552 (StrCmp @temp439 @[temp0 (* temp553 18)])))
				(= temp551 temp553)
				(break)
			)
		)
		(if (>= temp551 0)
			(localproc_0 temp551 @temp439)
			(for
				((= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400)))
				(and (> temp550 0) (not (CheckFreeSpace @temp480)))
				((= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400)))
				
				(localproc_0 (- temp550 1) @[temp0 (* (- temp550 1) 18)])
			)
			(if (CheckFreeSpace @temp480)
				(Format @temp421 0 3 @global110) ; "%s's game"
				(= temp554 (localproc_1))
				(if (not (SaveGame name temp554 @temp421 gVersion))
					(Print 0 4) ; "Save Error"
					(return)
				else
					(if (not (and argc param1))
						(Print 0 5) ; "Game Saved."
					)
					(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
				)
			else
				(Print 0 6) ; "Your disk is full. Please call your parents or teacher."
				(return)
			)
		else
			(while
				(and
					(> temp550 0)
					(or (not (CheckFreeSpace @temp480)) (>= temp550 20))
				)
				(localproc_0 (- temp550 1) @[temp0 (* (- temp550 1) 18)])
				(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
			)
			(Format @temp421 0 3 @global110) ; "%s's game"
			(= temp554 (localproc_1))
			(if (not (SaveGame name temp554 @temp421 gVersion))
				(Print 0 7) ; "Save Error."
				(return)
			else
				(if (not (and argc param1))
					(Print 0 5) ; "Game Saved."
				)
				(= temp550 (GetSaveFiles (gGame name:) @temp0 @temp400))
			)
		)
		(while ((= temp555 (Event new:)) type:)
			(temp555 dispose:)
		)
		(temp555 dispose:)
		(HandsOn)
	)
)

(class FairyIcon of IconI
	(properties
		signal 67
	)

	(method (highlight param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& signal $0020))
			(return)
		)
		(= temp4
			(cond
				((>= argc 2) param2)
				((and argc param1) highlightColor)
				(else lowlightColor)
			)
		)
		(= temp0 (+ nsTop 1))
		(= temp1 (+ nsLeft 1))
		(= temp2 (- nsBottom 2))
		(= temp3 (- nsRight 3))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph
			grDRAW_LINE
			temp2
			temp3
			temp2
			temp1
			(if (and argc param1)
				temp4
			else
				(proc10_30 (- temp4 2) temp4)
			)
			-1
			-1
		)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)
)

(instance iconBook of FairyIcon
	(properties
		view 900
		loop 6
		cel 0
		cursor 80
		helpStr {Click here to choose the title of this story.}
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (select &tmp [temp0 3] temp3)
		(if (= temp3 (super select: &rest))
			(gTheIconBar state: (| (gTheIconBar state:) $0004))
			(if (storyControls size:)
				(storyControls show:)
			else
				(storyControls init: show:)
			)
			(gTheIconBar state: (& (gTheIconBar state:) $fffb))
		)
		(return temp3)
	)
)

(instance iconMap of FairyIcon
	(properties
		view 900
		loop 5
		cel 0
		cursor 80
		message 2
		helpStr {Click here to look at the map.}
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(HandsOff)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(proc401_0)
			(gTheIconBar curIcon: iconDo)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
		(return 1)
	)
)

(instance iconDo of FairyIcon
	(properties
		view 900
		loop 1
		cel 0
		nsLeft 42
		nsTop 0
		nsRight 77
		nsBottom 26
		cursor 80
		message 5
		signal 193
		helpStr {Click here to do something or talk to someone.}
		maskView 900
		maskLoop 8
		maskCel 1
	)
)

(instance iconLook of FairyIcon
	(properties
		view 900
		loop 2
		cel 0
		cursor 19
		message 2
		signal 65
		helpStr {Click here to look at something.}
		maskView 900
		maskLoop 8
		maskCel 1
	)
)

(instance iconUse of FairyIcon
	(properties
		view 900
		loop 4
		cel 0
		cursor 80
		message 4
		helpStr {Click here to find out what you are carrying.}
		maskView 900
		maskLoop 8
		maskCel 3
	)

	(method (select param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp1 0)
		(cond
			((& signal $0004) 0)
			((and argc param1 (& signal $0001))
				(= temp1 1)
				(self highlight: 1 9)
				(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
					(temp0 localize:)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(self highlight: 1 9)
							)
						)
						(temp1
							(self highlight: 0)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
			)
			(else
				(= temp1 1)
			)
		)
		(if temp1
			(self highlight: 0)
			(if (== (= temp2 (gTheIconBar curInvIcon:)) 0)
				(Print 0 8) ; "Your hands are empty."
			else
				(= temp3 (temp2 loop:))
				(= temp4 (temp2 view:))
				(= temp5 (temp2 cel:))
				(if (== temp4 800)
					(= temp3 0)
				else
					(++ temp3)
				)
				(repeat
					(if
						(proc10_22
							(temp2 description:)
							35
							SysWindow
							82
							temp4
							temp3
							temp5
						)
						(break)
					)
				)
			)
		)
		(return temp1)
	)
)

(instance iconControl of FairyIcon
	(properties
		view 900
		loop 3
		cel 0
		cursor 80
		helpStr {Click here to end the game or to change game settings.}
		maskView 900
		maskLoop 8
		maskCel 1
	)

	(method (select)
		(if (super select:)
			(GameControls show:)
		)
		(return 0)
	)
)

(instance iconWhat of FairyIcon
	(properties
		view 900
		loop 7
		cel 0
		cursor 29
		message 6
		helpStr {Click here to find out what things in the menu do.}
		maskView 900
		maskLoop 8
		maskCel 1
	)
)

(instance DoVerbCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(cond
			((== param1 5)
				((User curEvent:) claimed: 0)
			)
			((and (= temp0 (param2 description:)) (== param1 2))
				(if (and (param2 facingMe: gEgo) (param2 lookStr:))
					(= temp2 (param2 x:))
					(proc10_24 gUserFont temp0)
					(if (< temp2 160)
						(+= temp2 20)
					else
						(-= temp2 (+ global227 20))
					)
					(= temp3 (param2 y:))
					(if (> (param2 y:) 140)
						(= temp3 140)
					)
					(if (< (param2 y:) 35)
						(= temp3 35)
					)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(= temp4 (- temp2 5))
					(= temp6 (+ temp2 8 global227))
					(= temp5 (- temp3 35))
					(= temp7 (+ temp3 -27 global228))
					(= temp1 (Graph grSAVE_BOX temp5 temp4 temp7 temp6 1))
					(Graph grFILL_BOX temp5 temp4 temp7 temp6 1 (SysWindow back:) -1 -1)
					(= temp8 (SysWindow color:))
					(Graph grDRAW_LINE temp5 temp4 temp5 (- temp6 1) temp8 -1 -1)
					(Graph
						grDRAW_LINE
						temp5
						(- temp6 1)
						(- temp7 1)
						(- temp6 1)
						temp8
						-1
						-1
					)
					(Graph grDRAW_LINE temp5 temp4 (- temp7 1) temp4 temp8 -1 -1)
					(Graph
						grDRAW_LINE
						(- temp7 1)
						temp4
						(- temp7 1)
						(- temp6 1)
						temp8
						-1
						-1
					)
					(Graph grUPDATE_BOX temp5 temp4 temp7 temp6 1)
					(Display
						temp0
						dsCOORD
						temp2
						(- temp3 30)
						dsFONT
						gUserFont
						dsCOLOR
						(SysWindow color:)
					)
					(proc10_24 gUserFont (param2 lookStr:))
					(if (> global228 16)
						(proc10_23 (param2 lookStr:) 70 240)
					else
						(proc10_23 (param2 lookStr:))
					)
					(Graph grRESTORE_BOX temp1)
					(Graph grUPDATE_BOX temp5 temp4 temp7 temp6 1)
				)
			)
			(else
				(proc10_12)
			)
		)
	)
)

(instance FtrInit of Code
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

	(method (open &tmp [temp0 28])
		(self
			top: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			left: (/ (- 320 (- (+ 124 (CelWide 947 0 1)) 8)) 2)
			bottom:
				(+ (CelHigh 947 1 1) 6 (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2))
			right:
				(+
					(- (+ 124 (CelWide 947 0 1)) 8)
					(/ (- 320 (- (+ 124 (CelWide 947 0 1)) 8)) 2)
				)
			priority: 15
			back: (proc10_30 59 9)
			color: (proc10_30 59 9)
			topBordColor: (proc10_30 54 11) 54
			lftBordColor: (proc10_30 54 11) 54
			rgtBordColor: (proc10_30 0 1) 0
			botBordColor: (proc10_30 0 1) 0
		)
		(super open:)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 107 16 15)
		(DrawCel 947 0 3 76 (- 15 (+ (CelHigh 947 0 4) 3)) 15)
	)

	(method (dispose)
		(super dispose:)
		(gGame setCursor: 80 1 160 87)
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 80
		nsTop 15
		signal 128
		helpStr {Adjusts sound volume.}
		sliderView 947
		topValue 15
	)
)

(instance iconSave of ControlIcon
	(properties
		view 947
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		signal 451
		helpStr {Saves your current game.}
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
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
		nsTop 46
		signal 451
		helpStr {Information about the game.}
	)
)

(instance iconOk of IconI
	(properties
		view 947
		loop 8
		cel 0
		nsLeft 8
		nsTop 26
		cursor 29
		signal 451
		helpStr {Exits this menu.}
	)
)

(instance dummyIcon of IconI
	(properties)

	(method (highlight))

	(method (select))

	(method (show))
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 300])
		(Print (Format @temp0 0 9 gVersion) #mode 1 #width 120 #font 3) ; "Mixed-Up Fairy Tales Version %s Designed, Written, and Directed by Lori Ann Cole Art Design by Andy Hoyos Lead Artist Douglas Herring Lead Programmer Corey Cole"
		(Print 0 10 #mode 1 #width 120 #font 3) ; "Art and Animation by Andy Hoyos Bob Gleason Vasken Nokhoudian Douglas Herring Dana Dean Deena Krutak Diana Wilson Jerry Jesserun Jeff Starling Music and Sound Effects by Mark Seibert Paul Aleman Chris Braymen Orpheus Hanley"
		(Print 0 11 #mode 1 #width 120 #font 3) ; "Programmed by John Magne' Kevin Ray John Wentworth Brett Miller Steve Conrad Development System by Jeff Stephenson Robert E. Heitman Pablo Ghenis J. Mark Hood Larry Scott Dan Foy Mark Wilden Eric Hart"
		(Print 0 12 #mode 1 #width 120 #font 3) ; "Quality Assurance lead by Sharon Smith Gordon Owens"
	)
)

(instance iconJack of CodeIcon
	(properties
		view 840
		loop 1
		cel 0
		nsLeft 2
		nsTop 62
		cursor 80
		signal 449
		helpStr {This icon is for selecting an ego.}
		maskView 840
		maskLoop 1
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(localproc_2 gJackStory)
		)
	)

	(method (show)
		(super show: &rest)
		(= nsRight (+ nsLeft 177))
		(= nsBottom (+ nsTop 18))
	)
)

(instance iconCind of CodeIcon
	(properties
		view 840
		loop 2
		cel 0
		nsLeft 2
		nsTop 81
		cursor 80
		signal 449
		helpStr {This icon is for selecting an ego.}
		maskView 840
		maskLoop 2
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(localproc_2 gCindStory)
		)
	)

	(method (show)
		(super show: &rest)
		(= nsRight (+ nsLeft 177))
		(= nsBottom (+ nsTop 18))
	)
)

(instance iconSnow of CodeIcon
	(properties
		view 840
		loop 3
		cel 0
		nsLeft 2
		nsTop 100
		cursor 80
		signal 449
		helpStr {This icon is for selecting an ego.}
		maskView 840
		maskLoop 3
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(localproc_2 gSnowStory)
		)
	)

	(method (show)
		(super show: &rest)
		(= nsRight (+ nsLeft 177))
		(= nsBottom (+ nsTop 18))
	)
)

(instance iconBeauty of CodeIcon
	(properties
		view 840
		loop 4
		cel 0
		nsLeft 2
		nsTop 119
		cursor 80
		signal 449
		helpStr {This icon is for selecting an ego.}
		maskView 840
		maskLoop 4
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(localproc_2 gBeautyStory)
		)
	)

	(method (show)
		(super show: &rest)
		(= nsRight (+ nsLeft 177))
		(= nsBottom (+ nsTop 18))
	)
)

(instance iconBremen of CodeIcon
	(properties
		view 840
		loop 5
		cel 0
		nsLeft 2
		nsTop 138
		cursor 80
		signal 449
		helpStr {This icon is for selecting an ego.}
		maskView 840
		maskLoop 5
		maskCel 1
	)

	(method (select)
		(if (super select: &rest)
			(localproc_2 gBremenStory)
		)
	)

	(method (show)
		(super show: &rest)
		(= nsRight (+ nsLeft 177))
		(= nsBottom (+ nsTop 18))
	)
)

(instance storyControls of GameControls
	(properties)

	(method (init)
		(= window storyWindow)
		(self
			add: iconJack iconCind iconSnow iconBeauty iconBremen
			eachElementDo: #highlightColor (proc10_30 5 11)
			eachElementDo: #lowlightColor (proc10_30 58 6)
		)
		(super init: &rest)
	)

	(method (show &tmp temp0)
		(= highlightedIcon 0)
		(if
			(and
				(not (& (iconJack signal:) $0004))
				(== (gJackStory selected:) 1)
			)
			(iconJack signal: (| (iconJack signal:) $0004))
		)
		(if (and (== (gJackStory done:) 1) (!= (iconJack maskCel:) 2))
			(iconJack maskCel: 2)
		)
		(if
			(and
				(not (& (iconCind signal:) $0004))
				(== (gCindStory selected:) 1)
			)
			(iconCind signal: (| (iconCind signal:) $0004))
		)
		(if (and (== (gCindStory done:) 1) (!= (iconCind maskCel:) 2))
			(iconCind maskCel: 2)
		)
		(if
			(and
				(not (& (iconSnow signal:) $0004))
				(== (gSnowStory selected:) 1)
			)
			(iconSnow signal: (| (iconSnow signal:) $0004))
		)
		(if (and (== (gSnowStory done:) 1) (!= (iconSnow maskCel:) 2))
			(iconSnow maskCel: 2)
		)
		(if
			(and
				(not (& (iconBeauty signal:) $0004))
				(== (gBeautyStory selected:) 1)
			)
			(iconBeauty signal: (| (iconBeauty signal:) $0004))
		)
		(if (and (== (gBeautyStory done:) 1) (!= (iconBeauty maskCel:) 2))
			(iconBeauty maskCel: 2)
		)
		(if
			(and
				(not (& (iconBremen signal:) $0004))
				(== (gBremenStory selected:) 1)
			)
			(iconBremen signal: (| (iconBremen signal:) $0004))
		)
		(if (and (== (gBremenStory done:) 1) (!= (iconBremen maskCel:) 2))
			(iconBremen maskCel: 2)
		)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(super show: &rest)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)

	(method (dispatchEvent event &tmp temp0)
		(= temp0
			(or
				(== (event type:) evMOUSEBUTTON)
				(== (event type:) evJOYDOWN)
				(and
					(== (event type:) evKEYBOARD)
					(or (== (event message:) KEY_RETURN) (== (event message:) KEY_ESCAPE))
				)
			)
		)
		(super dispatchEvent: event &rest)
		(if temp0
			(return 1)
		)
	)
)

(instance storyWindow of SysWindow
	(properties
		top 11
		left 70
		bottom 169
		right 251
	)

	(method (open)
		(super open: &rest)
		(DrawCel 840 0 0 0 0 15)
	)
)

(instance globalMusic of Sound
	(properties
		flags 1
	)
)

(instance globalMusic2 of Sound
	(properties
		flags 1
	)
)

(instance globalSoundEffect of Sound
	(properties
		flags 1
	)
)

(instance walkMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (++ global231) 3)
					(= global231 1)
				)
				(self changeState: global231)
			)
			(1
				(gGlobalMusic2 number: 6 setLoop: 1 play: self)
			)
			(2
				(gGlobalMusic2 number: 7 play: self)
			)
			(3
				(gGlobalMusic2 number: 11 play: self)
			)
			(4
				(gGlobalMusic2 number: 11 play: self)
			)
			(5
				(= global231 0)
				(self changeState: 0)
			)
		)
	)
)

