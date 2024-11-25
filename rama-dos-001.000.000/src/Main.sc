;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use HotCursor)
(use InvInitialize)
(use SaveManager)
(use RamaInterface)
(use SoundManager)
(use QuitDialog)
(use n1111)
(use SpeedTest)
(use Styler)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Messager)
(use Talker)
(use WalkieTalkie)
(use Cursor)
(use Ego)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rama 0
	ramanNormalCursor 1
	ramanWaitCursor 2
	ramanFingerCursor 3
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
	global101 = 1234
	global102
	global103
	global104
	; 105
	global105
	global106
	global107
	global108
	gGSound
	; 110
	global110
	gTesterSound
	global112
	gVMDMovie
	global114
	; 115
	global115
	global116
	global117
	gLeftExit
	gRightExit
	; 120
	gUpExit
	gDownExit
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
	gCatalogFile
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
	gSoundManager
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
	global157 = 160
	global158 = 153
	global159
	; 160
	global160
	global161
	global162
	global163 = 1
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
	global176 = 15
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
	global188 = -1
	global189
	; 190
	global190
	global191
	global192 = 1940
	global193 = 1240
	global194 = 2
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
	gSound
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
	global217 = -1
	global218 = -1
	global219 = -1
	; 220
	global220 = -1
	global221 = -1
	global222 = -1
	global223
	global224
	; 225
	global225
	global226
	global227
	global228
	global229
	; 230
	global230
	global231
	global232 = 2
	global233
	global234 = 5
	; 235
	global235
	global236 = 2
	global237
	global238
	global239
	; 240
	global240
	global241
	global242 = 1139
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
	global255 = 16
	global256 = 2
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
	global266 = -1
	global267 = -1
	global268 = -1
	global269 = 1
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
	global291 = 1
	global292 = 1
	global293 = 1
	global294 = 1
	; 295
	global295 = 1
	global296 = 1
	global297
	global298
	global299 = 60926
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
	global346
	global347
	global348
	global349
	; 350
	global350
	global351
	global352
	global353
	global354
	; 355
	global355
	global356
	global357
	global358
	global359
	; 360
	global360
	global361
	global362
	global363
	global364
	; 365
	global365
	global366
	global367
	global368
	global369
	; 370
	global370
	global371
	global372
	global373
	global374
	; 375
	global375
	global376
	global377
	global378
	global379
	; 380
	global380
	global381
	global382
	global383
	global384
	; 385
	global385
	global386
	global387
	global388
	global389
	; 390
	global390
	global391
	global392
	global393
	global394
	; 395
	global395
	global396
	global397
	global398
	global399
	; 400
	global400
	global401 = 52986
	global402 = 2
	global403 = 7
	global404 = 8
	; 405
	global405 = 3
	global406 = 1
	global407 = 4
	global408 = 6
	global409 = 5
	; 410
	global410
	global411
	global412
	global413
)

(class Rama of Game
	(properties
		oldCursor 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= gScreenWidth 640)
		(= gScreenHeight 480)
		(= gGSound gSound)
		(super init:)
		(= global179 (Random 19 22))
		(= gNumCD 1)
		(Styler divisions: 10 addExclusionRange: 0 191)
		(= _detailLevel 0)
		(= global188 (Platform 1))
		(gThePlane setRect: 0 0 639 479 priority: 2)
		(= gVersion {xx.yyy.zzz})
		(= gSystemPlane Plane)
		(= gEgo (Ego new:))
		(= global126 (Str newWith: 128 {}))
		(KArray 4 (global126 data:)) ; ArrayFree
		(global126 data: (Save 2)) ; GetSaveDir
		(= global115 (Str format: {%s} (global126 data:)))
		(= temp0 (Str newWith: 128 global126))
		(temp0 cat: {PREF.DAT})
		(if (FileIO fiEXISTS (temp0 data:))
			(proc1111_33)
		else
			(= global177 0)
			(= global176 15)
			(= gCurSaveDir (Str newWith: 128 global126))
		)
		(SaveManager init:)
		(= gFtrInitializer RamaFtrInitializer)
		(temp0 dispose:)
		(= temp0 (Str newWith: 128 global126))
		(temp0 cat: {10.csc})
		(if (FileIO fiEXISTS (temp0 data:))
			(= global150 1)
		else
			(= global150 0)
		)
		(temp0 dispose:)
		(Palette 4 global177) ; PalSetGamma
		(gGame masterVolume: (Min (* global176 8) 127))
		(if (== (Platform) 2)
			(= global152 1)
		)
		(if (>= (Platform 2) 3)
			(= temp2 (Str newWith: 50 {}))
			(= temp3 (Str newWith: 200 {}))
			(Message msgGET 0 1 0 0 1 (temp2 data:)) ; "Suggested Configuration"
			(Message msgGET 0 2 0 0 1 (temp3 data:)) ; "RAMA was designed to play in 256 color mode only.  It is highly recommended that you reset your  screen properties to play in 256 color mode or  performance problems may be encountered."
			(MessageBox (temp3 data:) (temp2 data:) 48)
			(temp2 dispose:)
			(temp3 dispose:)
		)
		(Font 1 630 450) ; SetFontRes
		(= gUserFont 2207)
		(= gSmallFont 2207)
		(Print fore: 0 back: 255)
		(Print font: gUserFont)
		(User alterEgo: gEgo canControl: 1 canInput: 0)
		(Lock rsVIEW 600 1)
		(Lock rsMESSAGE 90 1)
		(Lock rsVIEW 201 1)
		(Lock rsVIEW 202 1)
		(Lock rsVIEW 203 1)
		(DoAudio 13 2) ; AudChannels
		(DoAudio audRATE 22050)
		(DoAudio 12 0) ; AudMixCheck
		(ramanCursor init: ramanNormalCursor)
		(RemapColors 2 244 60) ; ByPercent
		((= gNarrator Narrator) modeless: 2)
		(= gMessager ramanMessager)
		(= gMsgType 2)
		(= oldCursor (gGame setCursor: ramanCursor))
		(= gCurRoomNum -1)
		(= gHowFast (SpeedTest))
		(self newRoom: 1015) ; easyPickins
	)

	(method (newGame param1)
		(if argc
			(gCurRoom newRoom: param1)
		else
			(gCurRoom newRoom: 1099) ; ShuttleRide
		)
		(= global123 RamaInterface)
	)

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5 temp6)
		(if global150
			((ScriptID 10 0) dispose:) ; debugRm
		)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(= global175 (if (and gCurRoom (== (gCurRoom exitStyle:) 13)) 1 else 0))
		(if (and gCurRoom (!= (= temp6 (gCurRoom exitStyle:)) -1))
			(Styler
				plane: (gCurRoom plane:)
				back:
					(cond
						((& temp6 $0100) 0)
						((& temp6 $0200) 7)
						(else 0)
					)
				style: (& temp6 $00ff)
				doit:
			)
			(FrameOut)
			(Styler back: -1)
		)
		(PalCycle 4) ; Off
		(RemapColors 0) ; Off
		(RemapColors 2 244 60) ; ByPercent
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform Ramaroom_DNKR newRoomNumber release:)
		(gTheDoits release:)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(cond
			((OneOf newRoomNumber 24 1015 95 1300) 0) ; whereTo, easyPickins, morgue, creditRoom
			((OneOf newRoomNumber 96 89 88 15) ; arthurQuestions, videoMenu, ramaWatch, prologue
				(gGame getDisc: 3)
			)
			(
				(or
					(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
					(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
					(== gNewRoomNum 6000) ; avianShaft
					(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
					(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
					(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
					(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
					(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
					(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
					(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
				)
				(gGame getDisc: 2)
			)
			(else
				(gGame getDisc: 1)
			)
		)
		(if (== gQuit 1)
			(return)
		)
		(NewRoom gNewRoomNum)
		(self startRoom: gCurRoomNum)
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (handsOff)
		(super handsOff:)
		(gTheCursor setTempCursor: ramanWaitCursor 150)
	)

	(method (handsOn)
		(super handsOn:)
		(if (gTheCursor invItem:)
			(gTheCursor setInvCursor:)
		else
			(gTheCursor setNormalCursor:)
		)
		(gTheCursor show:)
	)

	(method (startRoom roomNum)
		(proc1111_29 roomNum)
		((ScriptID 94 0) doit:) ; dispCode
		(DisposeScript 94)
		((ScriptID roomNum) setRegions: 92) ; SoundManager
		(cond
			(
				(and
					(not (OneOf gCurRoomNum 1015 15)) ; easyPickins, prologue
					(not
						(or
							(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
							(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
							(== gNewRoomNum 6000) ; avianShaft
							(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
							(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
							(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
							(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
							(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
							(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
							(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
						)
					)
				)
				((ScriptID roomNum) setRegions: 200) ; cplainRegion
				(cond
					(
						(or
							(<= 1000 gNewRoomNum 1014) ; hubCamp0, hubCampBomb
							(== gNewRoomNum 1020) ; hubCableCar
							(== gNewRoomNum 1016) ; hubCampLocker4
						)
						((ScriptID roomNum) setRegions: 205) ; HubCampRegion
					)
					((<= 2001 gNewRoomNum 2009) ; baseCampTent1, baseCampTable
						((ScriptID roomNum) setRegions: 211) ; baseCampRegion
					)
					(
						(or
							(<= 2080 gNewRoomNum 2082) ; CPBangkok1, CPBangkok3
							(== gNewRoomNum 4000) ; bkPorch
							(== gNewRoomNum 4002) ; bkPorchDoor
						)
						((ScriptID roomNum) setRegions: 206) ; bangkokRegion
					)
					((<= 4003 gNewRoomNum 4230) ; bkPuzPorchDoor, bk3MusNWCU3
						((ScriptID roomNum) setRegions: 213) ; BangkokInsideRegion
					)
					((<= 2040 gNewRoomNum 2055) ; BeamRgn1, trashBin
						((ScriptID roomNum) setRegions: 207) ; beamRegion
					)
					((<= 2100 gNewRoomNum 2109) ; CPIceport1, icemobileCU
						((ScriptID roomNum) setRegions: 208) ; iceportRegion
					)
					(
						(or
							(<= 2060 gNewRoomNum 2065) ; CPLondon1, CPLondon6
							(OneOf gNewRoomNum 3001 3009) ; london_1, london_Door_1
						)
						((ScriptID roomNum) setRegions: 209) ; londonRegion
					)
					((and (not (== gNewRoomNum 3009)) (<= 3002 gNewRoomNum 3071)) ; london_Door_1, london_2, london_Attack
						((ScriptID roomNum) setRegions: 212) ; londonInsideRegion
					)
					((<= 2010 gNewRoomNum 2039) ; wheelRgn1, wheelHubLadder
						((ScriptID roomNum) setRegions: 210) ; wheelRegion
					)
				)
			)
			(
				(or
					(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
					(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
					(== gNewRoomNum 6000) ; avianShaft
					(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
					(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
					(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
					(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
					(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
					(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
					(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
				)
				((ScriptID roomNum) setRegions: 201) ; newYorkRegion
				(cond
					((<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
						((ScriptID roomNum) setRegions: 202) ; AvianRegion
					)
					((<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
						((ScriptID roomNum) setRegions: 203) ; OctoRegion
					)
					((<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
						((ScriptID roomNum) setRegions: 204) ; HumanRegion
					)
					((or (<= 5001 gNewRoomNum 5030) (== gNewRoomNum 6000)) ; NYAvian1, NYAvianTetraCU, avianShaft
						((ScriptID roomNum) setRegions: 214) ; AvianPlazaRegion
					)
					((<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
						((ScriptID roomNum) setRegions: 215) ; OctoPlazaRegion
					)
					((or (<= 5202 gNewRoomNum 5215) (<= 5401 gNewRoomNum 5419)) ; humanPlazaRm2, NY_Human_Plaza_15, NY_Subway_1, puzzleIconCU
						((ScriptID roomNum) setRegions: 216) ; HumanPlazaRegion
					)
				)
			)
		)
		(gRegions eachElementDo: #init)
		(if
			(and
				(not (OneOf gCurRoomNum 1015 88 96 89 15 1300)) ; easyPickins, ramaWatch, arthurQuestions, videoMenu, prologue, creditRoom
				(not (SetFlag 11))
			)
			(RamaInterface init:)
			((ScriptID 70 0) doit:) ; InvInitialize
			(proc70_1 112 1)
		)
		(super startRoom: roomNum &rest)
		(if (SoundManager initialized:)
			(SoundManager updateSFXLocs:)
		)
	)

	(method (save)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(gTheCursor setTempCursor: ramanNormalCursor 150)
		(Sound pause: 1)
		(self saveRobot: 1)
		(SaveManager save:)
		(gGame handsOn:)
		(Sound pause: 0)
		(self saveRobot: 0)
		(DisposeScript 85)
	)

	(method (restore &tmp [temp0 2])
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(gTheCursor setTempCursor: ramanNormalCursor 150)
		(Sound pause: 1)
		(self saveRobot: 1)
		(if (SaveManager restore:)
			(if (SoundManager initialized:)
				(SoundManager updateSFXLocs:)
			)
		else
			(self saveRobot: 0)
			(gGame handsOn:)
		)
		(Sound pause: 0)
		(DisposeScript 85)
	)

	(method (autoSave param1)
		(if (and argc param1)
			(gGame handsOff:)
			(self saveRobot: 1)
			(SaveManager autoSave: &rest)
			(gGame handsOn:)
			(Sounds pause: 0)
			(self saveRobot: 0)
			(DisposeScript 85)
		else
			(gTheCursor setTempCursor: ramanNormalCursor)
			(SaveManager autoRestore: &rest)
			(if (SoundManager initialized:)
				(SoundManager updateSFXLocs:)
			)
			(DisposeScript 85)
		)
	)

	(method (replay &tmp [temp0 7])
		(SetDebug)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(self setCursor: gWaitCursor init:)
		(while (!= gQuit 1)
			(switch gQuit
				(0
					(self doit:)
				)
				(2
					(QuitDialog doit:)
				)
			)
		)
		(proc1111_32)
		(global115 dispose:)
		((Styler pFadeArray:) dispose:)
	)

	(method (saveRobot param1 &tmp temp0)
		(cond
			((or (not argc) param1)
				(if global165
					(if gAutoRobot
						(= temp0 (IntArray new: 4))
						(= global168
							(Max
								0
								(Min
									(Robot 11) ; FrameNum
									(- (Robot 2 (temp0 data:)) 1) ; FrameInfo
								)
							)
						)
						(temp0 dispose:)
						(gAutoRobot terminate: caller: 0 dispose: 0)
						(= gAutoRobot (= global107 0))
					else
						(WalkieTalkie terminate:)
					)
				)
			)
			(global165
				(= global107 global165)
				(if global174
					(WalkieTalkie
						doRobot:
							global165
							global166
							global167
							global168
							global170
							global173
							global169
							global171
					)
				else
					(WalkieTalkie
						showFrame:
							global165
							global168
							global166
							global167
							global169
							global172
					)
				)
			)
		)
	)

	(method (serialize param1 &tmp temp0 temp1 temp2)
		(gGame handsOff:)
		(if (and argc param1)
			(proc1111_32)
			(if (== gCurRoomNum 1015) ; easyPickins
				(= global123 RamaInterface)
				(RamaInterface init:)
				((ScriptID 55 1) add:) ; savedVidMail
				((ScriptID 70 0) doit:) ; InvInitialize
				(Lock rsPIC 60 1)
				(proc70_1 112 1)
			)
			(if gCuees
				(gCuees dispose:)
				(= gCuees 0)
			)
			(gFeatures eachElementDo: #dispose release:)
			(gCast eachElementDo: #dispose)
			(gTimers eachElementDo: #delete)
			(gRegions eachElementDo: #dispose)
			(Sounds eachElementDo: #dispose)
			(gTheDoits release:)
			(DisposeScript 100)
			(DisposeScript gCurRoomNum)
			(gTheCursor setNormalCursor:)
			(gTheCursor setTempCursor: ramanWaitCursor 150)
			(= gCurRoomNum (SaveManager readWord:))
			(= gPrevRoomNum (SaveManager readWord:))
			(= gNewRoomNum (SaveManager readWord:))
			(= gScore (SaveManager readWord:))
			(= gNumCD (SaveManager readWord:))
			(= gGameTime (SaveManager readWord:))
			(self getDisc: gNumCD)
			(if (== gQuit 1)
				(return)
			)
			(for ((= temp0 150)) (<= temp0 413) ((++ temp0))
				(= [gEgo temp0] (SaveManager readWord:))
			)
			(proc1111_33)
			(global123 serialize: 1)
			((ScriptID 55 6) serialize: 1) ; ChoiceManager
			(= gCurRoom (ScriptID gCurRoomNum 0))
			(gCurRoom number: gCurRoomNum)
			(SoundManager serialize: 1 1)
			(= temp1 (SaveManager readWord:))
			(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
				(= temp2 (SaveManager readWord:))
				((ScriptID temp2 0) number: temp2)
				((ScriptID temp2 0) serialize: 1)
			)
			(gGame handsOn:)
			((ScriptID gCurRoomNum 0) init:)
		else
			(SaveManager writeWord: gCurRoomNum)
			(SaveManager writeWord: gPrevRoomNum)
			(SaveManager writeWord: gNewRoomNum)
			(SaveManager writeWord: gScore)
			(SaveManager writeWord: gNumCD)
			(SaveManager writeWord: gGameTime)
			(for ((= temp0 150)) (<= temp0 413) ((++ temp0))
				(SaveManager writeWord: [gEgo temp0])
			)
			(global123 serialize: 0)
			((ScriptID 55 6) serialize: 0) ; ChoiceManager
			(SoundManager serialize: 0 1)
			(SaveManager writeWord: (- (gRegions size:) 1))
			(gRegions eachElementDo: #serialize 0)
			(gGame handsOn:)
		)
	)

	(method (getDisc param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= gNumCD param1)
		(= temp3 (= temp2 0))
		(if (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
			(Load rsVIEW (ramanNormalCursor view:))
			(Load rsVIEW (ramanWaitCursor view:))
			(= temp3 (Cast new:))
			((= temp2 (Plane new:))
				picture: -1
				init: 0 0 640 480
				priority: (+ (GetHighPlanePri) 100)
				addCast: (temp3 plane: temp2 yourself:)
			)
			((= temp4 (View new:))
				view: 1000
				loop: 1
				cel: (Max 0 (- gNumCD 1))
				x: 326
				y: 186
				init: temp3
			)
			(UpdatePlane temp2)
			(FrameOut)
			(while (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
				(gTheCursor setTempCursor: (ScriptID 0 1)) ; ramanNormalCursor
				(while ((= temp1 (Event new:)) type:)
					(temp1 dispose:)
				)
				(temp1 dispose:)
				(FrameOut)
				(= temp1 (Event new:))
				(while
					(and (!= (temp1 message:) KEY_RETURN) (not (& (temp1 type:) evKEYBOARD)))
					(temp1 dispose:)
					(= temp1 (Event new:))
					(if (== gQuit 2)
						(QuitDialog doit:)
						(if (== gQuit 1)
							(return 0)
						)
					)
				)
				(temp1 dispose:)
				(gTheCursor setTempCursor: ramanWaitCursor 150)
			)
			(temp2 dispose:)
			(gTheCursor setTempCursor:)
		)
		(return temp0)
	)

	(method (masterVolume param1)
		(if argc
			(SoundManager setMusicVolume: param1)
		else
			(SoundManager setMusicVolume:)
		)
	)

	(method (quitGame param1)
		(if (or (not argc) param1)
			(= gQuit 2)
		)
	)

	(method (restart param1 &tmp temp0)
		(if
			(and
				(!= gCurRoomNum 1300) ; creditRoom
				(!= gCurRoomNum 95) ; morgue
				(or (not argc) param1)
				(MainMenuDialog doit:)
			)
			(gGame save:)
		)
		(gCast eachElementDo: #dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(gRegions eachElementDo: #dispose)
		(Sounds eachElementDo: #dispose)
		(if (gTheCursor invItem:)
			(proc70_3)
		)
		(for ((= temp0 1)) (< temp0 799) ((++ temp0))
			(ClearFlag temp0)
		)
		(= gCurRoom 0)
		(= global175 0)
		(= global178 0)
		(= global179 (Random 19 22))
		(= global180 0)
		(= global181 0)
		(= global182 0)
		(= global183 0)
		(= global184 0)
		(= global185 0)
		(= global186 0)
		(= global187 0)
		(= global244 0)
		(= global189 0)
		(= global190 0)
		(= global191 0)
		(= global194 2)
		(= global200 0)
		(= global201 0)
		(= global216 0)
		(= global230 0)
		(= global231 0)
		(= global232 2)
		(= global233 0)
		(= global234 5)
		(= global242 1139)
		(= global243 0)
		(= global255 16)
		(= global256 2)
		(= global257 0)
		(= global258 0)
		(= global259 0)
		(= global260 0)
		(= global261 0)
		(= global262 0)
		(= global263 0)
		(= global264 0)
		(= global265 0)
		(= global266 -1)
		(= global267 -1)
		(= global268 -1)
		(= global245 0)
		(= global246 0)
		(= global247 0)
		(= gSound 0)
		(= global248 0)
		(= global249 0)
		(= global207 0)
		(= global269 1)
		(= global270 0)
		(= global271 0)
		(= global272 0)
		(= global297 0)
		(= global298 0)
		(= global411 0)
		(= global412 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global210 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global217 temp0] -1)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [global223 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(= [global227 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(= [global235 temp0] 0)
		)
		(= [global235 1] 2)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global273 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global279 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global285 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [global291 temp0] 1)
		)
		((ScriptID 70 15) doit:) ; InvDispose
		(if global123
			(global123 dispose: 1)
		)
		(= global123 0)
		(DisposeScript 90)
		(DisposeScript 70)
		(DisposeScript 44)
		((ScriptID 55 1) dispose:) ; savedVidMail
		(= gInventory 0)
		(gGame newRoom: 1015) ; easyPickins
	)
)

(instance RamaFtrInitializer of Code
	(properties)

	(method (doit param1)
		(if
			(and
				gCurRoomNum
				(not (param1 isKindOf: InventoryHole))
				(not (param1 plane:))
			)
			(param1 plane: global116)
		)
	)
)

(instance ramanNormalCursor of View
	(properties
		cel 9
		view 600
	)
)

(instance ramanWaitCursor of View
	(properties
		view 997
	)
)

(instance ramanFingerCursor of View
	(properties
		cel 11
		view 600
	)
)

(instance ramanCursor of HotCursor
	(properties)
)

(instance theWaitCursor of Cursor
	(properties
		view 997
	)
)

(instance theNormalCursor of Cursor
	(properties
		view 999
	)
)

(instance Ramaroom_DNKR of Code
	(properties
		name {Ramaroom DNKR}
	)

	(method (doit param1 param2)
		(if (param1 respondsTo: #setKeep)
			(param1 setKeep: param2)
		)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance gSound of Sound
	(properties)
)

(instance ramanMessager of Messager
	(properties
		oneOnly 1
		killed 1
	)

	(method (findTalker &tmp temp0)
		(return gNarrator)
	)

	(method (say)
		(if (gTalkers size:)
			(self cue: 1)
		)
		(super say: &rest)
	)
)

