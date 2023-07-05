;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n096)
(use n098)
(use SpeakWindow)
(use Interface)
(use n411)
(use PAvoider)
(use PseudoMouse)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	MG 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_16 16
	proc0_17 17
	proc0_18 18
	proc0_19 19
	proc0_20 20
	proc0_21 21
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
	gLongSong
	global103
	global104 = 1
	; 105
	global105
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
	global118 = 1
	global119
	; 120
	global120
	gMaid2
	global122
	global123
	global124
	; 125
	global125
	global126
	gInvBut
	global128
	global129
	; 130
	global130
	global131
	global132
	global133
	gShell2
	; 135
	gShell3
	gShell4
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	gStdWalkIn
	gStdWalkOut
	; 145
	global145
	gStdClimbOut
	global147
	global148
	global149
	; 150
	global150
	gPlace
	gTheHead
	global153
	global154
	; 155
	global155
	gGControls
	global157 = 1
	global158
	global159
	; 160
	gSfx
	global161
	gDoInvBut
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
	global176 = 1
	global177 = 1
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
	global200 = -1
	global201 = -1
	global202
	global203 = -1
	global204 = -1
	; 205
	global205 = -1
	global206
	global207 = -1
	global208
	global209 = -1
	; 210
	global210 = -1
	global211
	global212 = -1
	global213 = -1
	global214
	; 215
	global215 = -1
	global216
	global217
	global218 = -1
	global219
	; 220
	global220
	global221 = -1
	global222
	global223 = -1
	global224 = -1
	; 225
	global225 = -1
	global226 = -1
	global227 = -1
	global228
	global229
	; 230
	global230
	global231 = -1
	global232 = -1
	global233 = -1
	global234
	; 235
	global235
	global236 = -1
	global237 = -1
	global238 = -1
	global239
	; 240
	global240
	global241 = -1
	global242 = -1
	global243 = -1
	global244
	; 245
	global245 = -1
	global246
	global247
	global248
	gGoals
	; 250
	global250 = 1
	global251 = 49
	global252 = 33
	global253 = 34
	global254 = 81
	; 255
	global255 = 1
	global256 = 49
	global257 = 133
	global258 = 134
	global259 = 181
	; 260
	global260 = 1
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
	global301
	global302
	global303
	global304
	; 305
	global305
	global306
	global307
	global308
	global309
	; 310
	global310
	global311
	global312
	global313
	global314
	; 315
	global315
	global316
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
	global325
	global326
	global327
	global328
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
	gWave
)

(procedure (proc0_13 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (proc0_14 param1 param2 param3)
	(if (< param1 param2 param3)
		(if (< param2 (/ (+ param1 param3) 2))
			(= param2 param1)
		else
			(= param2 param3)
		)
	)
	(return param2)
)

(procedure (proc0_1 param1 param2)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
		)
	)
	(gEgo
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: Walk
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
	)
)

(procedure (proc0_2)
	(User canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= global340 0)
	(gGame setCursor: 8)
	(= global103 1)
)

(procedure (proc0_3)
	(= global104 0)
	(User canControl: 1 canInput: 1)
	(= global340 1)
	(= global103 0)
)

(procedure (proc0_4 param1) ; UNUSED
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (proc0_5)
	(Animate (gCast elements:) 0)
)

(procedure (proc0_6)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(procedure (proc0_8 param1 param2 param3 param4)
	(= global115 param3)
	(= global116 param4)
	(place x: param1 y: param2)
	(if (and global129 (or (> global130 47) (!= global145 (gCurRoom script:))))
		(global129 init:)
	)
	(if global150
		(global150 init: 1)
		(= global165 (if (== (global150 view:) 45) 30 else 20))
	)
)

(procedure (proc0_9)
	(Load rsFONT 8)
	(Load rsFONT 9)
	(= global130 0)
	(if (not global172)
		(invBut draw:)
	)
	(= global107 0)
	(= global104 1)
)

(procedure (proc0_10 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 17) ((++ temp0))
		(if ((gGoals at: temp0) egoHas:)
			(break)
		)
	)
	((gGoals at: temp0) egoHas: 0)
	(if (== global123 (+ temp0 1))
		(= global123 0)
	)
	(if (not global172)
		(gGame changeScore: 1)
	)
	(if (and global129 (!= gCurRoomNum 23))
		(global129 dispose:)
	)
	(= global129 0)
	(= global104 0)
)

(procedure (proc0_11))

(procedure (proc0_19 param1 param2 param3 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait param3)
	)
)

(procedure (proc0_17 param1)
	(return
		(switch param1
			(41 601)
			(42 602)
			(44 608)
			(45 603)
			(46 609)
			(47 604)
			(60 606)
			(else 605)
		)
	)
)

(procedure (proc0_16 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if global153
		(Display {} dsRESTOREPIXELS global154)
		(Display {} dsRESTOREPIXELS global153)
		(= global153 0)
	)
	(if (and global118 param1)
		(= temp1 (if (and (> argc 1) (>= param2 0)) param2 else 5))
		(= temp0 (if (and (> argc 2) (>= param3 0)) param3 else 5))
		(= temp2 (if (and (> argc 3) (>= param4 0)) param4 else 0))
		(= global153
			(Display
				param1
				dsWIDTH
				(- 260 temp0)
				dsCOORD
				temp0
				temp1
				dsALIGN
				alLEFT
				dsFONT
				9
				dsCOLOR
				temp2
				dsSAVEPIXELS
			)
		)
		(= global154
			(Display
				param1
				dsWIDTH
				(- 260 temp0)
				dsCOORD
				temp0
				temp1
				dsALIGN
				alLEFT
				dsFONT
				8
				dsCOLOR
				7
				dsSAVEPIXELS
			)
		)
	)
)

(procedure (proc0_7 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(param1
		loop: 13
		cel:
			(= temp1
				(if (< temp0 45)
					3
				else
					(/ (- temp0 45) 90)
				)
			)
	)
	(if (and (== (= temp3 (* (+ temp1 1) 90)) 360) (< temp0 180))
		(= temp3 0)
	)
	(= temp2 (- temp0 temp3))
	(if (and (param1 respondsTo: #head) (param1 head:))
		(cond
			((< temp2 -20)
				((param1 head:) loop: (+ (* temp1 2) 4))
			)
			((> temp2 20)
				((param1 head:) loop: (+ (* temp1 2) 6))
			)
			(else
				((param1 head:) loop: (+ (* temp1 2) 5))
			)
		)
	)
	(param1 doit:)
	(if (== argc 3)
		(proc0_7 param2 param1)
	)
)

(procedure (proc0_21 param1)
	(= gSystemWindow SysWindow)
	(if param1
		(Printf &rest)
	else
		(Print &rest)
	)
	(= gSystemWindow SpeakWindow)
)

(procedure (proc0_18 param1 param2) ; UNUSED
	(return
		(and
			(== (param2 type:) 1)
			(>= (param2 x:) (param1 nsLeft:))
			(<= (param2 x:) (param1 nsRight:))
			(>= (param2 y:) (param1 nsTop:))
			(<= (param2 y:) (param1 nsBottom:))
		)
	)
)

(procedure (proc0_20)
	(= global104 1)
)

(procedure (proc0_12)
	(return 1)
)

(procedure (localproc_0 param1 &tmp temp0 [temp1 40] [temp41 40] temp81)
	(= temp81 (Memory memALLOC_CRIT (if 0 200 else 80)))
	(= temp0 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @temp1)
	(DeviceInfo diGET_CURRENT_DEVICE @temp41)
	(if
		(and
			(DeviceInfo diIS_FLOPPY @temp41)
			(or
				(DeviceInfo diPATHS_EQUAL @temp1 @temp41)
				(not (DeviceInfo 6 (gGame name:))) ; SaveDirMounted
			)
		)
		(Format temp81 0 5 (if param1 {SAVE GAME} else {GAME}) @temp1) ; "Please insert your %s disk in drive %s."
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(if
			(==
				(= temp0
					(if param1
						(proc0_21
							temp81
							30
							0
							78
							{OK}
							1
							78
							{Cancel}
							0
							78
							{Change Directory}
							2
						)
					else
						(proc0_21 temp81 30 0 78 {OK} 1)
					)
				)
				2
			)
			(= temp0 (proc990_0 gCurSaveDir))
		)
	)
	(Memory memFREE temp81)
	(return temp0)
)

(instance ego of Body
	(properties
		illegalBits 0
	)

	(method (init)
		(= view global114)
		(super init:)
		(if
			(and
				(!= [global200 gCurRoomNum] 45)
				(!= global130 45)
				(not (and (== gCurRoomNum 23) ((gGoals at: 2) egoReturned:)))
			)
			(self setAvoider: PAvoider)
		)
	)

	(method (onMe)
		(return 0)
	)
)

(instance gControls of Controls
	(properties)
)

(instance longSong of Sound
	(properties
		flags 1
		number 600
	)
)

(instance sfx of Sound
	(properties
		number 600
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

(instance MG of Game
	(properties)

	(method (setCursor param1 param2 param3 param4 &tmp temp0)
		(= temp0 gTheCursor)
		(if (>= argc 3)
			(if (< param3 0)
				(= param3 0)
			)
			(if (< param4 0)
				(= param4 0)
			)
			(= gTheCursor param1)
			(SetCursor 895 0 param1)
			(SetCursor param3 param4)
		else
			(= gTheCursor param1)
			(if (> param1 10)
				(SetDebug)
			)
			(SetCursor 895 0 param1)
		)
		(return temp0)
	)

	(method (play)
		(= gWaitCursor 8)
		(= gNormalCursor 1)
		(= global75 0)
		(super play:)
	)

	(method (init)
		(= gPMouse PseudoMouse)
		(= gStdWalkIn stdWalkIn)
		(= gStdWalkOut stdWalkOut)
		(= global145 stdClimbIn)
		(= gStdClimbOut stdClimbOut)
		(= gPlace place)
		(= gEgo ego)
		(= gLongSong longSong)
		(= gSfx sfx)
		(= gGControls gControls)
		(= gInvBut invBut)
		(= gVersion {0.0arf})
		((= gKeyDownHandler KH) add:)
		((= gDirectionHandler DH) add:)
		((= gMouseDownHandler MH) add:)
		(= global169 (proc0_12))
		(super init: &rest)
		(= global344 (> (Graph grGET_COLOURS) 16))
		(= global157 (DoAudio audLANGUAGE))
		(gGame masterVolume: 14)
		(= gSystemWindow SpeakWindow)
		((ScriptID 600) init:) ; Goals
		(gLongSong owner: gGame init:)
		(gSfx owner: gGame init:)
		(gControls add: speedBut soundBut stopBut lipsBut mapBut invBut)
		(proc98_0)
		(if (GameIsRestarting)
			(self newRoom: 104) ; night
		else
			(self newRoom: 99) ; fredRm
		)
		(DisposeScript 98)
	)

	(method (changeScore param1 &tmp temp0 temp1)
		(if (<= gScore 17)
			(= global124 (GetPort))
			(SetPort 0)
			(if (not param1)
				(DrawCel 147 1 0 0 164 0 -1)
			)
			(for ((= temp0 0)) (< temp0 gScore) ((++ temp0))
				(DrawCel 147 0 8 [global261 temp0] [global280 temp0] 0 -1)
			)
			(Graph grUPDATE_BOX 164 0 200 98 1)
			(if param1
				(gSfx number: 34 play:)
				(for ((= temp1 0)) (<= temp1 8) ((++ temp1))
					(= global108 (Graph grSAVE_BOX 159 0 200 104 1))
					(Wait 3)
					(DrawCel
						147
						0
						temp1
						[global261 gScore]
						[global280 gScore]
						0
						-1
					)
					(Graph grRESTORE_BOX global108)
				)
				(if (< (+= gScore 1) gPossibleScore)
					(= global342 1)
				)
			)
			(SetPort global124)
		)
	)

	(method (replay &tmp temp0)
		(MemorySegment 1 @global190)
		(= global170 (StrAt @global190 0))
		(= gHowFast (- (StrAt @global190 1) 32))
		(StrAt gCurSaveDir 0 (- (StrAt @global190 2) 1))
		(= global179 (- (StrAt @global190 3) 32))
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gSFeatures release:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic
			(gCurRoom curPic:)
			(if (== (gCurRoom style:) -1)
				100
			else
				(| $0064 (& (gCurRoom style:) $6000))
			)
			1
			global40
		)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom controls:)
			((gCurRoom controls:) draw:)
		)
		(gAddToPics doit:)
		(gGame
			setCursor:
				(if (and gTheIconBar (gTheIconBar curIcon:))
					((gTheIconBar curIcon:) cursor:)
				else
					gNormalCursor
				)
				(HaveMouse)
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(gGame changeScore: 0)
		(gGControls eachElementDo: #draw)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 10))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 1)
		)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= global248 (+ (GetTime) gSpeed -1))
		(= temp0 1)
		(= temp3 (Event new: -1))
		(temp3 localize:)
		(if (not global107)
			(cond
				(global104
					(= global105 7)
				)
				((== (User controls:) 0)
					(= temp0 1)
					(= global105 8)
				)
				(
					(and
						(< 1 (= temp4 (temp3 x:)) 258)
						(< 13 (= temp5 (temp3 y:)) 155)
					)
					(if (!= gCurRoomNum 45) ; mapRoom
						(= global105 1)
					else
						(= global105 0)
					)
				)
				((> temp4 257)
					(if
						(or
							(speedBut check: temp3)
							(soundBut check: temp3)
							(stopBut check: temp3)
						)
						(= global105 6)
					else
						(= global105 2)
					)
				)
				((< temp4 1)
					(= global105 4)
				)
				((> temp5 154)
					(if
						(or
							(lipsBut check: temp3)
							(mapBut check: temp3)
							(invBut check: temp3)
						)
						(= global105 6)
					else
						(= global105 3)
					)
				)
				((< temp5 14)
					(= global105 5)
				)
				(else
					(= global105 1)
				)
			)
			(if (and (== gCurRoomNum 45) (!= global105 6) (not global104)) ; mapRoom
				(= global105 0)
			)
			(if (!= gTheCursor global105)
				(self setCursor: global105 temp0)
			)
		)
		(temp3 dispose:)
		(if
			(and
				(IsObject global150)
				(!= (global150 view:) 0)
				(> (gEgo priority:) 0)
			)
			(cond
				(
					(and
						(< (= temp2 (gEgo distanceTo: global150)) global165)
						(!= global166 1)
					)
					(= global165 0)
					(global150 get:)
					(if global129
						(global129 put:)
					)
					(= temp1 global150)
					(= global150 global129)
					(= global130
						(if (= global129 temp1)
							(global129 view:)
						else
							0
						)
					)
					(invBut draw:)
					(gSfx number: 30 play:)
				)
				((> temp2 80)
					(= global165 (if (== (global150 view:) 45) 30 else 20))
					(if (> [global200 gCurRoomNum] 47)
						(global150 ignoreActors:)
					)
				)
			)
		)
		(if (and global342 (not (gCurRoom script:)))
			(= global188 1)
			(= global342 0)
			(gGame save:)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5 temp6 temp7)
		(= global341 0)
		(gAddToPics eachElementDo: #dispose eachElementDo: #delete release:)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose)
		(if global344
			(if (not global176)
				(= temp7 10)
				(for ((= temp6 100)) (>= temp6 -1) ((-= temp6 temp7))
					(if (== temp6 50)
						(Animate (gCast elements:) 0)
						(= temp7 20)
					)
					(Palette palSET_INTENSITY 64 255 temp6)
					(Wait 1)
				)
				(Palette palSET_INTENSITY 64 255 0)
				(Wait 1)
			)
		else
			(DrawPic 804 6 1)
			(Animate (gCast elements:) 0)
		)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(gTheDoits release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(self startRoom: gCurRoomNum checkAni:)
		(Empty gRegions)
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (startRoom param1 &tmp temp0 temp1 temp2 [temp3 2])
		(LoadMany
			0
			985
			986
			97
			101
			102
			103
			602
			601
			403
			605
			970
			400
			973
			946
			945
			927
			929
			971
			930
			934
		)
		(= global344 (> (Graph grGET_COLOURS) 16))
		(= global157 (DoAudio audLANGUAGE))
		(= global345 0)
		(= gWave 0)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(| $0001 (Palette palSET_INTENSITY 0 255 100))
				(proc0_21 0 0 0 78 {Quit} 1)
			)
			(SetDebug)
		)
		(if
			(and
				(<= gCurRoomNum 44)
				(!= [global200 gCurRoomNum] 0)
				(!= [global200 gCurRoomNum] -1)
			)
			(= global150 (ScriptID (proc0_17 [global200 gCurRoomNum])))
		else
			(= global150 0)
		)
		(if
			(and
				global130
				(== (= global129 (ScriptID (proc0_17 global130))) global150)
			)
			(= global129 (global150 new:))
		)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID param1)))
		(gCurRoom init:)
		(if global176
			(return)
		)
		(Animate 0)
		(Wait 0)
		(for ((= temp2 0)) (< temp2 (gCast size:)) ((++ temp2))
			(DrawCel ((gCast at: temp2) view:) 0 0 400 0 0 -1)
		)
		(= temp1 20)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 temp1))
			(if (== temp0 40)
				(Animate (gCast elements:) 1)
				(= temp1 10)
			)
			(Palette palSET_INTENSITY 64 255 temp0)
			(Wait 1)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 5] temp6 temp7 temp8 [temp9 2] [temp11 50] temp61)
		(if (event claimed:)
			(return)
		)
		(event localize:)
		(event globalize:)
		(if (event claimed:)
			(return)
		)
		(= temp0 (event type:))
		(= temp61 (event message:))
		(cond
			((and (== temp0 evKEYBOARD) (== temp61 KEY_CONTROL))
				(= gQuit 1)
			)
			((and (== temp0 evKEYBOARD) (== temp61 KEY_F2))
				(cond
					((gGame masterVolume:)
						(gGame masterVolume: 0)
					)
					((> (DoAudio audLANGUAGE) 1)
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
			((== temp0 evKEYBOARD)
				(switch temp61
					(KEY_F10
						(Format @temp11 0 1 107) ; "%d.scr"
						(if (FileIO fiEXISTS @temp11)
							(proc96_0)
							(DisposeScript 96)
						)
					)
					(else
						(if
							(and
								(not (gKeyDownHandler handleEvent: event))
								(Format @temp11 0 1 107) ; "%d.scr"
								(FileIO fiEXISTS @temp11)
							)
							((ScriptID 107) handleEvent: event) ; MISSING SCRIPT
						)
					)
				)
			)
			(
				(and
					(== temp0 evMOUSEBUTTON)
					(not (gMouseDownHandler handleEvent: event))
					(Format @temp11 0 1 107) ; "%d.scr"
					(FileIO fiEXISTS @temp11)
				)
				((ScriptID 107) handleEvent: event) ; MISSING SCRIPT
			)
		)
		(if (and (== (event type:) evMOUSEBUTTON) global100)
			(event localize:)
			(= temp6 (event x:))
			(= temp7 (event y:))
			(= temp8 (event modifiers:))
		)
		(super handleEvent: event)
	)

	(method (save &tmp [temp0 32] temp32 temp33 [temp34 276])
		(Load rsFONT gSmallFont)
		(= temp33 (Sound pause: 1))
		(if (localproc_0 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (>= global179 13)
				(proc0_21 0 0 2 30 0 78 {OK} 1)
			else
				(if (!= global179 -1)
					(= temp32 (self setCursor: gWaitCursor 1))
					(if (not (SaveGame name global179 (+ @global190 4) gVersion))
						(proc0_21 0 0 3 30 0 78 {OK} 1)
					else
						(proc0_21 1 0 4 (+ @global190 6))
					)
					(self setCursor: temp32 (HaveMouse))
				)
				(localproc_0 0)
			)
		)
		(Sound pause: temp33)
	)

	(method (restore &tmp [temp0 21] temp21 temp22 temp23)
		(if (localproc_0 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(gCast eachElementDo: #dispose)
			(Load rsFONT gSmallFont)
			(= temp21 (self setCursor: gNormalCursor))
			(= temp22 (Sound pause: 1))
			(self setCursor: gWaitCursor 1)
			(if (CheckSaveGame name global179 gVersion)
				(RestoreGame name global179 gVersion)
			)
			(localproc_0 0)
		)
		(Sound pause: temp22)
		(gLongSong number: 600 loop: -1 play:)
	)
)

(class idiotBut of DIcon
	(properties
		sLeft 0
		sRight 0
		sTop 0
		sBottom 0
	)

	(method (check param1)
		(return
			(and
				(& state $0001)
				(User canControl:)
				(>= (param1 x:) sLeft)
				(>= (param1 y:) sTop)
				(<= (param1 x:) sRight)
				(<= (param1 y:) sBottom)
			)
		)
	)
)

(instance lipsBut of idiotBut
	(properties
		state 1
		nsTop 163
		nsLeft 205
		nsBottom 198
		nsRight 264
		view 801
		loop 6
		sLeft 208
		sRight 256
		sTop 172
		sBottom 193
	)

	(method (track param1 &tmp temp0 temp1)
		(if (== (param1 type:) evMOUSEBUTTON)
			(repeat
				(= param1 (Event new:))
				(param1 localize:)
				(if (= temp0 (self check: param1))
					(= cel 1)
				else
					(= cel 2)
				)
				(= temp1 (== (param1 type:) evMOUSERELEASE))
				(self draw:)
				(param1 dispose:)
				(breakif temp1)
			)
			(= cel 0)
			(self draw:)
			(return temp0)
		else
			(return self)
		)
	)

	(method (doit &tmp [temp0 2])
		(cond
			((gCurRoom script:) 0)
			(global341
				(gCurRoom setScript: global341)
			)
			(else
				(gCurRoom setScript: saySomething)
			)
		)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(super draw:)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance saySomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setHeading: 180 self)
				(= cycles 2)
			)
			(1
				(proc411_0 (gEgo head:))
				((gEgo head:) loop: 7)
				(= cycles 2)
			)
			(2
				(gEgo say: (+ 524 (Random 0 49)) self)
			)
			(3
				(proc411_1)
				(= cycles 2)
			)
			(4
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance speedBut of idiotBut
	(properties
		state 1
		nsTop 41
		nsLeft 266
		nsBottom 116
		nsRight 318
		key 49
		value 13
		view 801
		loop 1
		cel 6
		sLeft 276
		sRight 304
		sTop 58
		sBottom 93
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (= temp3 (== evMOUSEBUTTON (param1 type:))) (== (param1 message:) KEY_RETURN))
			(if temp3
				(gGame setCursor: 9)
			else
				(gGame setCursor: 9 1 285 (- 83 (* (/ value 2) 3)))
			)
			(= temp2 0)
			(repeat
				(= param1 (Event new:))
				(param1 localize:)
				(MapKeyToDir param1)
				(cond
					(temp3
						(= temp0 (* (/ (= temp0 (param1 y:)) 3) 3))
						(= temp1
							(*
								(/
									(= temp1
										(- (= temp1 (+ nsTop 44)) (* cel 3))
									)
									3
								)
								3
							)
						)
						(if (and value (> temp0 temp1))
							(-- value)
							(self draw:)
						)
						(if (and (< value 15) (< temp0 temp1))
							(++ value)
							(self draw:)
						)
					)
					((== (param1 message:) JOY_DOWN)
						(if value
							(-- value)
							(= temp4 (- 83 (* (/ value 2) 3)))
							(gGame setCursor: gTheCursor 1 285 temp4)
							(self draw:)
						)
					)
					((and (== (param1 message:) JOY_UP) value)
						(++ value)
						(= temp4 (- 83 (* (/ value 2) 3)))
						(gGame setCursor: gTheCursor 1 285 temp4)
						(self draw:)
					)
				)
				(= temp2
					(or
						(== (param1 type:) evJOYDOWN)
						(== (param1 message:) KEY_RETURN)
						(== (param1 type:) evMOUSERELEASE)
					)
				)
				(param1 dispose:)
				(breakif temp2)
				(if (not temp3)
					(Wait 0)
					(Wait 2)
				)
			)
			(if (and global129 (<= global130 47))
				(global129 moveSpeed: (- 7 cel))
			)
			(return self)
		)
	)

	(method (doit)
		((User alterEgo:) moveSpeed: (- 7 cel))
		(return 1)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(= value (proc0_13 1 value 15))
		(= cel (/ value 2))
		(= sTop (+ nsTop 41))
		(-= sTop (* cel 3))
		(= sBottom (+ sTop 9))
		(super draw:)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance soundBut of idiotBut
	(properties
		state 1
		nsTop 160
		nsLeft 275
		nsBottom 197
		nsRight 308
		value 13
		view 801
		loop 2
		cel 6
		sLeft 277
		sRight 304
		sTop 159
		sBottom 189
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or (= temp3 (== evMOUSEBUTTON (param1 type:))) (== (param1 message:) KEY_RETURN))
			(if temp3
				(gGame setCursor: 9)
			else
				(gGame setCursor: 9 1 285 (- 184 (* (/ value 2) 3)))
			)
			(= temp2 0)
			(repeat
				(= param1 (Event new:))
				(param1 localize:)
				(MapKeyToDir param1)
				(cond
					(temp3
						(= temp0 (* (/ (= temp0 (param1 y:)) 3) 3))
						(= temp1
							(*
								(/
									(= temp1
										(- (= temp1 (+ nsTop 27)) (* cel 3))
									)
									3
								)
								3
							)
						)
						(if (and value (> temp0 temp1))
							(-- value)
							(self draw:)
						)
						(if (and (< value 15) (< temp0 temp1))
							(++ value)
							(self draw:)
						)
					)
					((== (param1 message:) JOY_DOWN)
						(if value
							(-- value)
							(= temp4 (- 184 (* (/ value 2) 3)))
							(gGame setCursor: gTheCursor 1 285 temp4)
							(self draw:)
						)
					)
					((and (== (param1 message:) JOY_UP) value)
						(++ value)
						(= temp4 (- 184 (* (/ value 2) 3)))
						(gGame setCursor: gTheCursor 1 285 temp4)
						(self draw:)
					)
				)
				(= temp2
					(or
						(== (param1 type:) evJOYDOWN)
						(== (param1 message:) KEY_RETURN)
						(== (param1 type:) evMOUSERELEASE)
					)
				)
				(param1 dispose:)
				(breakif temp2)
				(if (not temp3)
					(Wait 0)
					(Wait 2)
				)
			)
			(if (and global129 (<= global130 47))
				(global129 moveSpeed: (- 7 cel))
			)
			(return self)
		)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(= value (proc0_13 1 value 15))
		(= cel (/ value 2))
		(= sTop (+ nsTop 22))
		(-= sTop (* cel 3))
		(gGame masterVolume: (= global125 (- value 1)))
		(= sBottom (+ sTop 9))
		(super draw:)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance stopBut of idiotBut
	(properties
		state 1
		nsLeft 266
		nsBottom 38
		nsRight 318
		view 801
		sLeft 273
		sRight 309
		sTop 4
		sBottom 35
	)

	(method (track param1 &tmp temp0 temp1)
		(if (== (param1 type:) evMOUSEBUTTON)
			(repeat
				(= param1 (Event new:))
				(param1 localize:)
				(if (= temp0 (self check: param1))
					(= cel 1)
				else
					(= cel 2)
				)
				(= temp1 (== (param1 type:) evMOUSERELEASE))
				(self draw:)
				(param1 dispose:)
				(breakif temp1)
			)
			(= cel 0)
			(self draw:)
			(return temp0)
		else
			(return self)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 ((ScriptID 410) show:)) ; stopCh
		((ScriptID 410) dispose:) ; stopCh
		(DisposeScript 410)
		(if temp1
			(LoadMany 0 997 934)
			(gGame save:)
			(= global340 0)
			(= gQuit 1)
		)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(super draw:)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance mapBut of idiotBut
	(properties
		state 1
		nsTop 167
		nsLeft 150
		nsBottom 197
		nsRight 202
		view 801
		loop 4
		sLeft 149
		sRight 200
		sTop 167
		sBottom 193
	)

	(method (track param1 &tmp temp0 temp1)
		(if (== (param1 type:) evMOUSEBUTTON)
			(repeat
				(= param1 (Event new:))
				(param1 localize:)
				(if (= temp0 (self check: param1))
					(= cel 1)
				else
					(= cel 2)
				)
				(= temp1 (== (param1 type:) evMOUSERELEASE))
				(param1 dispose:)
				(self draw:)
				(breakif temp1)
			)
			(= cel 0)
			(self draw:)
			(return temp0)
		else
			(return self)
		)
	)

	(method (doit &tmp [temp0 3])
		(if (not (gCurRoom script:))
			(if (== gCurRoomNum 45) ; mapRoom
				(gCurRoom newRoom: gPrevRoomNum)
				(invBut state: 0)
				(lipsBut state: 1)
			else
				(gCurRoom newRoom: 45) ; mapRoom
				(invBut state: 1)
				(lipsBut state: 0)
			)
		)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(super draw:)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance invBut of idiotBut
	(properties
		nsTop 162
		nsLeft 97
		nsBottom 200
		nsRight 148
		view 202
		sLeft 105
		sRight 140
		sTop 168
		sBottom 189
	)

	(method (doit)
		(if gDoInvBut
			(gDoInvBut doit:)
		)
	)

	(method (draw &tmp temp0)
		(= global124 (GetPort))
		(SetPort 0)
		(super draw:)
		(if (== global130 0)
			(DrawCel view loop cel nsLeft nsTop 15 -1)
		else
			(= temp0 (+ global130 56))
			(DrawCel
				temp0
				loop
				15
				(+ 103 (/ (- 39 (CelWide temp0 loop 15)) 2))
				(+ 167 (/ (- 29 (CelHigh temp0 loop 15)) 2))
				15
				-1
			)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(SetPort global124)
	)
)

(instance place of Feature
	(properties)
)

(instance stdWalkIn of Script
	(properties
		register 50
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(switch (= state newState)
			(0
				(gEgo edgeHit: 0)
				(proc0_2)
				(= temp6 (gCurRoom roomToEdge: gPrevRoomNum))
				(= temp5
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp4
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(switch temp6
					(3
						(= temp0 temp2)
						(= temp1 (+ global59 temp5))
					)
					(2
						(= temp1 temp3)
						(= temp0 (+ global60 temp4))
					)
					(4
						(= temp1 temp3)
						(= temp0 (- global61 temp4))
					)
					(1
						(= temp0 temp2)
						(= temp1 (- temp3 2))
					)
				)
				(gEgo
					posn: temp0 temp1
					init:
					setLoop: -1
					ignoreActors: 1
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(proc0_3)
				(gEgo ignoreActors: 0)
				(if
					(and
						(< register 50)
						((gGoals at: register) egoHas:)
						(or register (== gCurRoomNum 9))
					)
					(client setScript: global341)
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance stdWalkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(1
						(-= temp1 10)
					)
					(3
						(+= temp1 20)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(proc0_2)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(proc0_3)
				(client setScript: 0)
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
			)
		)
	)
)

(instance stdClimbIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(+
						temp2
						4
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					setPri: 0
					setLoop: 1
					y: temp1
					init:
					ignoreActors: 1
					setMotion: MoveTo temp0 temp2 self
				)
			)
			(1
				(= temp1
					(+
						temp2
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					setPri: -1
					setLoop: -1
					setMotion: MoveTo temp0 temp1 self
				)
				(if (and (!= global130 0) (<= global130 47))
					(= global166 1)
					(if (== global130 45)
						(global129 init:)
					else
						(global129 init: setScript: followOver)
					)
				)
			)
			(2
				(gEgo ignoreActors: 0)
				(proc0_3)
				(if
					(and
						(< register 50)
						((gGoals at: register) egoHas:)
						(or register (== gCurRoomNum 9))
					)
					(client setScript: global341)
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance stdClimbOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(+
						temp2
						4
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
					)
				)
				(gEgo
					init:
					setPri: 0
					setLoop: 3
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo temp0 temp1 self
				)
				(if (<= 1 global130 47)
					(if (== global130 45)
						(= global166 2)
					else
						(global129
							illegalBits: -32768
							setMotion: MoveTo (gEgo x:) (gEgo y:) self
						)
					)
				)
			)
			(1
				(if
					(and
						(<= 1 global130 47)
						(!= global130 45)
						(not (global129 mover:))
					)
					(global129
						setPri: 1
						setLoop: 3
						setMotion: MoveTo (gEgo x:) (gEgo y:)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(proc0_3)
				(if (and (<= 1 global130 47) (!= global130 45))
					(global129 setPri: -1 setLoop: -1)
				)
				(= global166 0)
				(client setScript: 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance followOver of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp2 (gEgo y:))
		(switch (= state newState)
			(0
				(= temp1
					(+
						temp2
						4
						(CelHigh
							(global129 view:)
							(global129 loop:)
							(global129 cel:)
						)
					)
				)
				(global129
					ignoreActors: 1
					setPri: 0
					setLoop: 1
					illegalBits: 0
					posn: temp0 temp1
					setMotion: MoveTo temp0 temp2 self
				)
			)
			(1
				(= global166 0)
				(global129
					signal: (| (global129 signal:) $4000)
					setPri: -1
					setLoop: -1
					setMotion: MoveTo temp0 (- temp2 5) self
				)
			)
			(2
				(global129
					illegalBits: -32764
					setMotion: NewFollow gEgo 30
					setScript: (if (IsObject gWave) gWave else 0)
				)
			)
		)
	)
)

(instance RU of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (param1 underBits:)
			(= temp0 (& (= temp0 (| (= temp0 (param1 signal:)) $0001)) $fffb))
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance fDC of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1 signal: (& (param1 signal:) $ffdf) dispose: delete:)
		else
			(param1 dispose:)
		)
	)
)

