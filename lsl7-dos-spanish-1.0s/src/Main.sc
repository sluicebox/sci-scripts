;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use oMainMenu)
(use TPSound)
(use oMessager)
(use oInvHandler)
(use L7TalkWindow)
(use DisabledPlanes)
(use NewUser)
(use PushButton)
(use soFlashCyberSniff)
(use PArray)
(use Plane)
(use Str)
(use File)
(use Actor)
(use System)

(public
	L7 0
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
	global201
	global202
	gOMusic1
	gOSound1
	; 205
	global205 = 240
	global206 = 60
	global207
	global208
	global209
	; 210
	global210 = 101
	global211
	global212 = 1
	global213
	gOAmbience
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
	global224 = 320
	; 225
	global225 = 300
	global226
	global227 = 65
	global228 = 60
	global229 = 100
	; 230
	global230
	global231
	global232
	global233
	global234 = 1
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
	global268 = 2510
	global269 = 1
	; 270
	global270 = 2510
	global271 = 2
	global272
	global273 = 64
	global274
	; 275
	global275 = 60012
	global276 = 60013
	global277 = 60014
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
	global289 = 60019
	; 290
	global290 = 60020
	global291
	global292
	global293
	global294
	; 295
	global295
	global296 = 1
	global297
	global298
	global299
	; 300
	global300
	global301
	global302 = -1
	global303 = -1
	global304 = -1
	; 305
	global305 = -1
	global306
	global307
	global308
	global309
	; 310
	global310
	global311
	global312
	global313
	global314 = 1
	; 315
	global315
	global316 = 20
	global317
	global318
	global319
	; 320
	global320
	global321
	global322
	global323
	global324
	; 325
	global325 = 1
	global326
	global327
	global328
	global329 = 1
	; 330
	global330
	gToShamara
	global332
	global333
	global334
	; 335
	global335
	global336
	gToVicki
	global338
	global339
	; 340
	global340
	global341
	gToWang
	gToDick
	global344
	; 345
	global345
	gToJulia
	gToGraham
	gToPaul
	gToWaitress
	; 350
	gToBonds
	gToCroupier
	global352
	global353
	global354
	; 355
	global355
	gToX
	global357
	global358
	global359
	; 360
	global360
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if gVersion
		(proc64896_7 gVersion)
		(= gVersion 0)
	)
	(= temp0 (Str new:))
	(temp0 format: {%s%s} gCurSaveDir {version})
	(if (= temp1 (File new:))
		(temp1 name: (temp0 data:))
		(if (temp1 open: 1)
			(if (= gVersion (Str newWith: 200 {}))
				(temp1 readString: gVersion 199)
			)
			(temp1 close:)
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)
	(if (or (not gVersion) (not (gVersion size:)))
		(= gVersion (Str with: {develop}))
	)
)

(procedure (localproc_1 &tmp temp0)
	(if (not global294)
		(switch (Platform 0)
			(2
				(= global294
					(GetSierraProfileInt {Config} {VideoSpeed} global294)
				)
			)
			(1
				(= temp0 (Str new: 100))
				(GetConfig {VideoSpeed} temp0)
				(= global294 (/ (temp0 asInteger:) 5))
				(temp0 dispose:)
			)
			(0
				(= temp0 (Str new: 100))
				(GetConfig {VideoSpeed} temp0)
				(= global294 (temp0 asInteger:))
				(temp0 dispose:)
			)
			(else
				(= global294 0)
			)
		)
		(proc64000_3)
	)
)

(procedure (localproc_2)
	(poNull setScript: soShowScore)
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

(instance oTestFile of File ; UNUSED
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

(instance oAmbience of TPSound
	(properties)
)

(instance L7 of NewGame
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= global238 0)
		(= global239 0)
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
		(DoAudio 13 2) ; AudChannels
		(DoAudio audRATE 22050)
		(DoAudio 10 16) ; AudBits
		(= gSystemPlane (Plane new:))
		((= gUser oUser) alterEgo: (= gEgo (ScriptID 64007 0))) ; ego
		(super init:)
		((ScriptID 0 1) ; oBackgroundPlane
			picture: -2
			priority: 0
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(if (and (gThePlane oMyFeatures:) (!= (gThePlane oMyFeatures:) gFeatures))
			((gThePlane oMyFeatures:) dispose:)
			(gThePlane oMyFeatures: gFeatures)
		)
		((= gOMusic1 oMusic1) owner: self flags: 1)
		((= gOSound1 oSound1) owner: self flags: 5)
		((= gOAmbience oAmbience) owner: self flags: 5)
		(= global114 (Str new:))
		(= global115 (Str new:))
		(global115 copy: gCurSaveDir)
		(if (not (= global288 (MakeMessageText 0 0 3 1 14)))
			(= global288 (Str with: {Continue}))
		)
		(= gApproachCode oApproachCode)
		(= global101 1)
		((ScriptID 64017 0) init:) ; oFlags
		((= gOEventHandler oEventHandler)
			init:
			registerKeyHandler: (ScriptID 64010 0) ; oMainKeyHandler
			registerGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
		)
		(proc64040_0)
		(proc64032_2)
		((= gMessager (ScriptID 64032 1)) init:) ; oMessager
		(= gMsgType 3)
		(localproc_0)
		(self handsOnCode: oHandsOnCode handsOffCode: oHandsOffCode)
		((= global100 (PArray new: 0)) add: 1 60009)
		(= global101 1)
		(proc64037_1)
		(= global208 (Set new:))
		(for ((= temp1 0)) (< temp1 255) ((++ temp1))
			(if (proc64037_3 temp1)
				(global208 add: temp1)
			)
		)
		(global208
			add:
				135
				87
				64
				81
				229
				186
				67
				92
				5
				80
				90
				222
				7
				234
				152
				91
				61
				253
				79
				160
				97
				71
				78
				88
				8
				4
				89
				6
				82
				63
				189
		)
		((ScriptID 64038 0) init:) ; oPopupMenuHandler
		((ScriptID 64000 0) init:) ; oMainMenu
		((ScriptID 60 0) setReal: (ScriptID 60 0) 60) ; oFidgetTimer, oFidgetTimer
		(gOEventHandler registerGlobalHandler: (ScriptID 60 2)) ; oFidgetClickHandler
		(proc64000_4)
		(localproc_1)
		(= temp0 (Str new: 100))
		(GetConfig {language} temp0)
		(= global325 (temp0 asInteger:))
		(temp0 dispose:)
		(if (not global325)
			(= global325 1)
		)
		(if (FileIO fiEXISTS {classes})
			(= global106 1)
		else
			(= temp0 (Str newWith: 100 { }))
			(GetConfig {TorinDebug} temp0)
			(temp0 lower:)
			(if (== (= temp1 (temp0 at: 0)) 116)
				(= global106 1)
			)
			(temp0 dispose:)
		)
		(if (FileIO fiEXISTS {autotp})
			(= global243 1)
		)
		(if global106
			((ScriptID 64014 0) init:) ; Debugger
		)
		(= temp0 (Str newWith: 100 { }))
		(GetConfig {LeakDump} temp0)
		(if (temp0 size:)
			(temp0 lower:)
			(if (== (= temp1 (temp0 at: 0)) 116)
				(= global202 1)
			)
		)
		(temp0 dispose:)
		(= temp0 (Str newWith: 100 { }))
		(GetConfig {StartRoom} temp0)
		(= gNewRoomNum (temp0 asInteger:))
		(temp0 dispose:)
		(if (!= gNewRoomNum 0)
			(return)
		)
		(= gNewRoomNum 100) ; ro100
	)

	(method (changeScore param1)
		(soShowScore nOldScore: global201)
		(+= global201 param1)
		(localproc_2)
	)

	(method (doit)
		(if (voScore plane:)
			(soShowScore doit:)
		)
		(super doit: &rest)
	)
)

(instance oHandsOffCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (gUser canControl:))
		(= temp1 (if argc param1))
		(gUser canControl: 0 canInput: 0)
		(if (!= gTheCursor gWaitCursor)
			(gGame setCursor: gWaitCursor)
		)
		(if temp0
			(if (ScriptID 64000 0) ; oMainMenu
				((ScriptID 64000 0) disable:) ; oMainMenu
			)
			(gOEventHandler killAllEventHogs:)
		)
		(if temp1
			(= global238 gMouseX)
			(= global239 gMouseY)
			(SetCursor 415 363)
			(= global245 1)
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
				global245
				(< (Abs (- gMouseX 415)) 12)
				(< (Abs (- gMouseY 363)) 12)
			)
			(SetCursor global238 global239)
		)
		(= global245 0)
	)
)

(instance oApproachCode of Code
	(properties)

	(method (doit param1)
		(return 32768)
	)
)

(instance poNull of Prop
	(properties)
)

(instance oScorePlane of Plane
	(properties
		priority 800
		picture -2
	)

	(method (init)
		(super init: 10 450 180 479 &rest)
	)
)

(instance voScore of TextItem
	(properties
		back 237
		priority 750
		fixPriority 1
		font 2510
		fore 64
		skip 255
	)

	(method (init &tmp temp0)
		(= temp0 (MakeMessageText 0 0 59 1 14))
		(= text (Str format: {%s: %d} (temp0 data:) (soShowScore nOldScore:)))
		(temp0 dispose:)
		(oScorePlane init:)
		(super init: oScorePlane &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(oScorePlane dispose:)
	)
)

(class soShowScore of Script
	(properties
		nOldScore 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voScore init:)
				(= ticks 80)
			)
			(1
				(if (== nOldScore global201)
					(= ticks 110)
				else
					(voScore dispose:)
					(if (> global201 nOldScore)
						(++ nOldScore)
					else
						(-- nOldScore)
					)
					(voScore init:)
					(= ticks 10)
					(-- state)
				)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (voScore plane:)
			(voScore dispose:)
		)
		(super dispose: &rest)
	)
)

