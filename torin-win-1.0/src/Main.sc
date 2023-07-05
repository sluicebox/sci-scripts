;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use oMainMenu)
(use TPSound)
(use n64036)
(use DisabledPlanes)
(use NewUser)
(use n64896)
(use PArray)
(use Plane)
(use Str)
(use System)

(public
	Torin 0
	oBackgroundPlane 1
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gThePlane
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gPlanes
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gTextCode
	gCuees
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gEventMask = 32767
	gBigFont = 1
	gVersion
	gAutoRobot
	gCurSaveDir
	; 30
	gNumCD
	gPerspective
	gFeatures
	gPanels
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemPlane
	gSaveFileSelText
	; 40
	global40
	global41
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
	gEndSysLogPath
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gApproachCode
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
	gSpeechHandler
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	gExtMouseHandler
	gTalkers
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
	gAltPolyList
	gScreenWidth = 320
	gScreenHeight = 200
	gLastScreenX = 319
	gLastScreenY = 199
	; 100
	global100
	global101
	gInventItem
	global103
	global104
	; 105
	gOEventHandler
	global106
	gScrollPlane
	global108 = 1
	global109 = 25
	; 110
	global110 = 25
	global111 = 1
	global112 = 40
	global113 = -1
	global114
	; 115
	global115
	gDisabledPlanes
	gOPlaneStack
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
	goConsolePattern
	gnChapter = 2
	goMusic1
	goSound1
	; 205
	gnEgoScrollBorderX = 240
	gnEgoScrollBorderY = 60
	gTileDirections
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
	gTilePositions
	global217
	global218
	global219
	; 220
	global220
	global221
	global222
	global223
	gPlaceholder
	; 225
	gnSnailTalk = 1
	gnHermanTalker
	gMusicVol = 40
	gSFXVol = 60
	gAudioVol = 100
	; 230
	gZaxTalk
	gnPlantTalk
	gnTreeTalk
	gnRabbitTalker
	goCrystX
	; 235
	goCrystY
	goCrystZ
	gnCentipedeTalker
	gnCursorSaveX
	gnCursorSaveY
	; 240
	gtTorin
	gtArchivist
	gbTeleport
	gbDebugTeleport
	gnGameSpeed
	; 245
	gtSmetana
	gbMovedCursor
	gtLeenah
	gbCatapultEastSide
	gnBallsInCatapult
	; 250
	gnBallsInSeeSawLeft
	gnBallsInSeeSawRight
	gPrismArray1 = 1
	gPrismArray2 = 2
	gPrismArray3 = 3
	; 255
	gPrismArray4 = 4
	gPrismArray5 = 5
	gPrismArray6 = 6
	gPrismArray7
	gnLastHelpLevel
	; 260
	gnLastHelpCase
	gnLastHelpSeq
	gnVulturesTalk
	gnVederTalk
	gnSkunkTalk
	; 265
	gnInvHandler
	gtViscera
	gtTripe
	gnDialogFont = 2510
	gnDialogLeading = 1
	; 270
	gnButtonFont = 2510
	gnButtonLeading = 2
	gnButtonUpColor = 234
	gnButtonDownColor = 210
	gnTextColor = 234
	; 275
	gvDialogTile = 60012
	gvButtonUpTile = 60013
	gvButtonDownTile = 60014
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
	goDismissString
	gnMrsBitterTalk
	; 290
	gtSam
	gtMax
	gtVeder
	gnKingTalk
	gnVideoSpeed
	; 295
	gnCPUSpeed
	gbTipOfTheDay = 1
	gtKurtzwell
	gtSoldier
	gtPecand
	; 300
	gtLycentia
	gtDreep
	gnSpeedPosX = -1
	gnSpeedPosY = -1
	gnVolumePosX = -1
	; 305
	gnVolumePosY = -1
	gnHintTimerPosX = -1
	gnHintTimerPosY = -1
	gnHintTime = 5
	gnHintElapsed
	; 310
	gnHintTickCounter
	gtCop
	gtArcher
	gtCarpenter
	gnNextTip = 1
	; 315
	gbInterfaceInitted
	gtMrsBitter
	gtBobbyBitter
	gtKing
	gtQueen
	; 320
	gtQueenToKing
	gtKingDi
	gtPhace
	gtZippy
	gtTree
	; 325
	gnLanguage = 1
	gbUnflattenBoogle
	gnBoogleInBagMsg
	gbScrollInited
	global329
	; 330
	global330
	global331
	global332
	global333
	global334
	; 335
	global335
	global336
	global337
	global338
	global339
	; 340
	global340
	global341
	global342
	global343
	global344
	; 345
	global345
	global346
	global347
	global348
	global349
	; 350
	global350
)

(procedure (InitSpeed &tmp cfgBuf)
	(if (not gnVideoSpeed)
		(switch (Platform 0)
			(2
				(= gnVideoSpeed
					(GetSierraProfileInt {Config} {VideoSpeed} gnVideoSpeed)
				)
			)
			(1
				(= cfgBuf (Str new: 100))
				(GetConfig {VideoSpeed} cfgBuf)
				(= gnVideoSpeed (/ (cfgBuf asInteger:) 5))
				(cfgBuf dispose:)
			)
			(0
				(= cfgBuf (Str new: 100))
				(GetConfig {VideoSpeed} cfgBuf)
				(= gnVideoSpeed (cfgBuf asInteger:))
				(cfgBuf dispose:)
			)
			(else
				(= gnVideoSpeed 0)
			)
		)
		(SavePrefs)
	)
)

(instance oUser of NewUser
	(properties)
)

(instance oEventHandler of NewEventHandler
	(properties)
)

(instance oBackgroundPlane of Plane
	(properties)
)

(instance oMusic1 of TPSound
	(properties
		type 1
	)
)

(instance oSound1 of TPSound
	(properties)
)

(instance Torin of NewGame
	(properties)

	(method (init &tmp cfgBuf i)
		(= gnCursorSaveX 0)
		(= gnCursorSaveY 0)
		(gGame handsOff:)
		(= gScreenHeight 480)
		(= gScreenWidth 640)
		(= gLastScreenX 639)
		(= gLastScreenY 479)
		(= gPerspective 60)
		(= gUserFont 999)
		(= gSmallFont 999)
		(= gBigFont 2510)
		(= gInputFont 999)
		(DoAudio 12 0) ; AudMixCheck
		(= gSystemPlane (Plane new:))
		((= gUser oUser) alterEgo: (= gEgo (ScriptID 64007 0))) ; oTPEgo
		(super init:)
		((= goMusic1 oMusic1) owner: self flags: 1)
		((= goSound1 oSound1) owner: self flags: 5)
		(= global114 (Str new:))
		(= global115 (Str new:))
		(global115 copy: gCurSaveDir)
		(for ((= i 0)) (< i 9) ((++ i))
			(= [gTilePositions i] -1)
			(= [gTileDirections i] (& i $0003))
		)
		(= gnHintTickCounter gGameTime)
		(if (not (= goDismissString (MakeMessageText 0 0 1 1 0)))
			(= goDismissString (Str with: {Continue}))
		)
		(LoadPrefs)
		(InitSpeed)
		(= gApproachCode oApproachCode)
		(= global101 1)
		((ScriptID 64017 0) init:) ; oFlags
		((= gOEventHandler oEventHandler)
			init:
			registerKeyHandler: (ScriptID 64010 0) ; oMainKeyHandler
			registerGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
		)
		(SetVersionString)
		(self handsOnCode: oHandsOnCode)
		(self handsOffCode: oHandsOffCode)
		((= global100 (PArray new: 0)) add: 1 60009 80 60357 75 60360 81 60342)
		(= gNewRoomNum 61000) ; roSierraLogo
	)

	(method (changeScore delta)
		((ScriptID 64002 3) addScore: delta) ; oScoreKeeper
	)

	(method (doit)
		(while (u> (- gGameTime gnHintTickCounter) 3600)
			(+= gnHintTickCounter 3600)
			(+= gnHintElapsed 1)
		)
		(super doit: &rest)
	)
)

(instance oHandsOffCode of Code
	(properties)

	(method (doit bMoveParm &tmp bInHandsOn bMoveCursor)
		(= bInHandsOn (gUser canControl:))
		(= bMoveCursor (or (not argc) (== bMoveParm 1)))
		(gUser canControl: 0 canInput: 0)
		(if (!= gTheCursor gWaitCursor)
			(gGame setCursor: gWaitCursor)
		)
		(if (and bInHandsOn bMoveCursor)
			(if (ScriptID 64000 0) ; oMainMenu
				((ScriptID 64000 0) disable:) ; oMainMenu
			)
			(gOEventHandler killAllEventHogs:)
			(= gnCursorSaveX gMouseX)
			(= gnCursorSaveY gMouseY)
			(SetCursor 415 363)
			(= gbMovedCursor 1)
		)
	)
)

(instance oHandsOnCode of Code
	(properties)

	(method (doit)
		(gUser canControl: 1 canInput: 1)
		(if (ScriptID 64000 0) ; oMainMenu
			((ScriptID 64000 0) enable:) ; oMainMenu
		)
		(if
			(and
				gbMovedCursor
				(< (Abs (- gMouseX 415)) 12)
				(< (Abs (- gMouseY 363)) 12)
			)
			(SetCursor gnCursorSaveX gnCursorSaveY)
		)
		(= gbMovedCursor 0)
	)
)

(instance oApproachCode of Code
	(properties)

	(method (doit verb)
		(switch verb
			(1
				(return 1)
			)
			(else
				(return 32768)
			)
		)
	)
)

