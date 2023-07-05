;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use AnimatingCursor)
(use LightInv)
(use VMDPlayer)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Messager)
(use Talker)
(use Osc)
(use WalkieTalkie)
(use Cursor)
(use Timer)
(use Ego)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Lite 0
	DoRobot 1
	KillRobot 2
	sDepress 3
	gRobot 4
	IsFlag 5
	SetFlag 6
	ClearFlag 7
	proc0_8 8
	proc0_9 9
	dummyProp 10
	blackPlane 11
	monsterTimer 12
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
	gBackMusic
	gMySoundFX
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
	gTheInvisCursor
	global202
	global203
	global204
	; 205
	global205
	global206
	global207 = 3
	global208
	global209 = 3
	; 210
	global210
	global211
	global212
	global213
	gIRandomMusic
	; 215
	gControlPanel
	global216
	gTheControlNormalCursor
	gTheControlWaitCursor
	gPortal
	; 220
	gBackMusic2
	global221
	global222
	global223
	global224
	; 225
	global225
	global226 = 2
	global227 = 2
	global228
	global229
	; 230
	global230
	global231
	global232 = 500
	global233
	gTGlobalTimer
	; 235
	global235
	global236
	global237 = 2
	global238 = -1
	global239
	; 240
	global240
	global241
	global242 = 16
	global243
	global244
	; 245
	global245
	global246
	global247
	global248
	gGlobalVMD
	; 250
	global250
	global251
	global252
	global253
	gPplFullLetterPlane
	; 255
	global255
	global256
	gInsetPanelPlane
	global258
)

(procedure (DoRobot param1 param2 &tmp temp0 temp1 temp2)
	(if (or global102 gPortal)
		(= global102 0)
		(= gPortal 0)
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(if (> argc 1)
			(= temp2 param2)
			(WalkieTalkie killRobot: temp1 temp2)
		else
			(WalkieTalkie killRobot: temp1)
		)
	)
)

(procedure (KillRobot param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	(WalkieTalkie
		doRobot:
			param1
			temp1
			temp2
			(if (not (> argc 7)) self else 0)
			(if (> argc 3) param4 else 0)
			(if (> argc 4) param5 else -1)
			(if (> argc 5) param6 else 0)
	)
	(= global102 param1)
)

(procedure (proc0_9 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	(if (> argc 3)
		(= temp3 param4)
	else
		(= temp3 -1)
	)
	(= global202 param1)
	(= global203 temp1)
	(= global204 temp2)
	(= global205 temp3)
	(WalkieTalkie doRobot: global202 temp1 temp2 WalkieTalkie 0 temp3)
	(= global102 param1)
)

(procedure (IsFlag param1 &tmp temp0)
	(= temp0 (& [global116 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(= [global116 (/ param1 16)]
		(| [global116 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global116 (/ param1 16)]
		(& [global116 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc0_8 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp1 0)
	(gGlobalVMD putOptions: 256 boostRGB: 0)
	(if (> argc 1)
		(gGlobalVMD x: param2 y: param3)
	else
		(gGlobalVMD x: 70 y: 75)
	)
	(if (> argc 3)
		(= temp0 param4)
	else
		(= temp0 1)
	)
	(if
		(and
			(gPanels contains: (ScriptID 9 3)) ; PlCompass
			(not (gPanels contains: (ScriptID 9 4))) ; InvInset
		)
		((ScriptID 9 3) hide:) ; PlCompass
	)
	(gGlobalVMD number: param1 init: play:)
	(if
		(and
			(gPanels contains: (ScriptID 9 3)) ; PlCompass
			(not (gPanels contains: (ScriptID 9 4))) ; InvInset
		)
		((ScriptID 9 3) show:) ; PlCompass
	)
	(if temp0
		(gGlobalVMD close:)
	)
)

(instance lightTextList of List
	(properties)
)

(instance lightDText of DText
	(properties)

	(method (dispose)
		(lightTextList delete: self)
		(super dispose: &rest)
	)
)

(instance theNormalCursor of Cursor
	(properties
		view 999
	)
)

(instance theControlNormalCursor of Cursor
	(properties
		view 998
	)
)

(instance theInvisCursor of Cursor
	(properties
		loop 1
		view 999
	)
)

(instance theControlWaitCursor of Cursor
	(properties
		view 9998
	)
)

(instance theWaitCursor of AnimatingCursor
	(properties
		view 9999
	)

	(method (init)
		(self cycleSpeed: 7 loop: 0 cel: 0 setCycle: Fwd)
		(super init: &rest)
	)
)

(class Lite of Game
	(properties
		cursHidden 0
		liteInterface 0
		compassFace 0
		gameRestored 0
		isHandsOn 0
		language 1
		changedLang 0
		oneMoreDoit 0
		normalizeCode -1
		comment 0
	)

	(method (normalizeCursor)
		(= gNormalCursor theNormalCursor)
		(if (== normalizeCode -1)
			(gUser curVerb: 5)
			(gNormalCursor view: 999 loop: 0 cel: 0)
			(gGame cursHidden: 0)
			(gGame setCursor: gNormalCursor 1)
		else
			(normalizeCode doit:)
		)
	)

	(method (hideCursor)
		(gUser curVerb: 5)
		(= gTheInvisCursor theInvisCursor)
		(gTheInvisCursor view: 999 loop: 1 cel: 0)
		(gGame cursHidden: 1)
		(gGame setCursor: gTheInvisCursor 1)
	)

	(method (init)
		(= comment (Str new:))
		(= gScreenWidth 640)
		(= gScreenHeight 480)
		(= gUser User)
		(gUser alterEgo: lightEgo)
		(= gEgo lightEgo)
		(= gMsgType 2)
		(= gNarrator Narrator)
		(= gMessager lhMessager)
		(= gNormalCursor theNormalCursor)
		(= gTheControlNormalCursor theControlNormalCursor)
		(= gWaitCursor theWaitCursor)
		(= gTheControlWaitCursor theControlWaitCursor)
		(= gTheInvisCursor theInvisCursor)
		(self normalizeCursor:)
		(= gInventory ((ScriptID 9 0) new:)) ; LightInv
		(= gPanels (Set new:))
		(= global206 (Set new:))
		(= gDoVerbCode lightDoVerbCode)
		(= gVersion {xx.yyy.zzz})
		(= gTGlobalTimer tGlobalTimer)
		(= gGlobalVMD globalVMD)
		(= gUseSortedFeatures 1)
		Narrator
		(super init:)
		(= gSystemPlane Plane)
		(Print fore: 0 back: 255)
		((= gBackMusic BackMusic) owner: self flags: 1 init: yourself:)
		((= gBackMusic2 BackMusic2) owner: self flags: 1 init: yourself:)
		((= gMySoundFX mySoundFX) flags: 5 owner: self init: yourself:)
		((= gIRandomMusic IRandomMusic) flags: 5 owner: self init: yourself:)
		(gThePlane setRect: 70 75 569 374)
		(DoAudio 12 0) ; AudMixCheck
		(dummyProp init:)
		(= global216 (IntArray with: 4485 0 0 0 12 1 1 4483 3 2 384 201 0))
		(= gPplFullLetterPlane 0)
		(SetFlag 269)
		(SetFlag 361)
		(SetFlag 358)
		(SetFlag 270)
		(SetFlag 272)
		(SetFlag 273)
		(SetFlag 277)
		(SetFlag 278)
		(SetFlag 281)
		(SetFlag 282)
		(SetFlag 335)
		(SetFlag 336)
		(SetFlag 338)
		(SetFlag 340)
		(SetFlag 341)
		(SetFlag 342)
		(SetFlag 348)
		(SetFlag 250)
		(SetFlag 301)
		(if (ResCheck 150 121) ; ROBOT
			(= global224 (= gNumCD 2))
		else
			(= global224 (= gNumCD 1))
		)
		(self newRoom: 6) ; whereTo
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if panelObj
			(= temp1 panelObj)
			(= temp2 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp1 temp2)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if (not gControlPanel)
			(gTimers eachElementDo: #doit)
			(gCast doit:)
			(if script
				(script doit:)
			)
			(if (dummyProp script:)
				((dummyProp script:) doit:)
			)
			(gRegions eachElementDo: #doit)
			(gTheDoits doit:)
		)
		(gSounds eachElementDo: #check)
		(if gAutoRobot
			(gAutoRobot doit:)
		)
		(if (and (not global221) gPanels)
			(gPanels eachElementDo: #doit)
		)
		(FrameOut)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(gTimers eachElementDo: #delete)
		(if changedLang
			(if oneMoreDoit
				(self changedLang: 0 oneMoreDoit: 0)
			)
			(self oneMoreDoit: 1)
		)
		(if (IsFlag 163)
			(ClearFlag 163)
			(gControlPanel dispose:)
			(FrameOut)
			(gGame normalizeCursor:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and gPanels gInventory (gPanels contains: InvInset))
			(InvInset dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for
			((= temp4 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp1 (KList 8 temp4)) ; NodeValue
			(AddPlane temp1)
			(for
				((= temp5 (KList 3 ((temp1 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp2 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp2 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (KList 6 temp6)) ; NextNode
					(= temp3 (KList 8 temp6)) ; NodeValue
					(if (& (temp3 Info:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(self gameRestored: 1)
		(self setCursor: gTheControlNormalCursor 1)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(if (or gAutoRobot global208 gPortal)
			(Robot 1 (Robot 11)) ; DisplayFrame, FrameNum
		)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (handsOff)
		(if isHandsOn
			(if handsOffCode
				(handsOffCode doit:)
			else
				(= isHandsOn 0)
				(gUser canControl: 0 canInput: 0)
				(if (== gCurRoomNum 5)
					(gGame setCursor: gTheControlWaitCursor 1)
				else
					(gGame setCursor: gWaitCursor 1)
					(gTheDoits add: (gWaitCursor init: setCycle: Osc -1 yourself:))
				)
			)
		)
	)

	(method (handsOn)
		(if (not isHandsOn)
			(if handsOnCode
				(handsOnCode doit:)
			else
				(= isHandsOn 1)
				(gUser canControl: 1 canInput: 1)
				(gTheDoits delete: gWaitCursor)
				(gGame normalizeCursor:)
			)
		)
	)

	(method (getDisc param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= gNumCD param1)
		(= temp3 (= temp2 0))
		(if (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
			(gGame hideCursor:)
			(Palette 2 0 255 0) ; PalIntensity
			(FrameOut)
			(= temp3 (Cast new:))
			((= temp2 (Plane new:))
				picture: 0
				back: 0
				init: 0 0 639 479
				priority: (+ (GetHighPlanePri) 1)
				addCast: (temp3 plane: temp2 yourself:)
			)
			(if gPortal
				(gPortal stopSound:)
			)
			(switch gNumCD
				(1
					(switch (gGame language:)
						(1
							(= temp4 1111)
						)
						(33
							(= temp4 1113)
						)
						(49
							(= temp4 1115)
						)
					)
					(Load rsAUDIO temp4)
					(discSound number: temp4 setLoop: 0)
				)
				(2
					(switch (gGame language:)
						(1
							(= temp4 1112)
						)
						(33
							(= temp4 1114)
						)
						(49
							(= temp4 1116)
						)
					)
					(Load rsAUDIO temp4)
					(numberView setCel: 0 init: temp3)
					(discSound number: temp4 setLoop: 0)
				)
			)
			(gGame hideCursor:)
			(changeView init: temp3)
			(UpdateScreenItem changeView)
			(if (!= gNumCD 1)
				(UpdateScreenItem numberView)
			)
			(UpdatePlane temp2)
			(Palette 2 0 255 100) ; PalIntensity
			(FrameOut)
			(while (and (!= -1 (= temp0 (CD 0 param1))) (!= temp0 param1)) ; Check
				(discSound play:)
				(while ((= temp1 (Event new:)) type:)
					(temp1 dispose:)
				)
				(temp1 dispose:)
				(for
					((= temp1 (Event new:)))
					(and (!= (temp1 message:) KEY_RETURN) (not (& (temp1 type:) evKEYBOARD)))
					((= temp1 (Event new:)))
					
					(temp1 dispose:)
				)
				(discSound stop:)
				(temp1 dispose:)
			)
			(temp2 dispose:)
		)
		(SetFlag 9)
		(return temp0)
	)

	(method (save &tmp temp0 temp1 temp2 temp3)
		(if (not (FileIO 19 (KArray 9 gCurSaveDir))) ; ValidPath, ArrayGetData
			(= temp3 (Str new:))
			(= temp1 (Str new:))
			(temp3 format: temp1 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addBitmap: 1203 5 0
				addButtonBM: -1 0 0 1 {OK} 0 30
				init:
			)
			(GetDirectory gCurSaveDir)
			(temp3 dispose:)
			(temp1 dispose:)
		)
		(ScriptID 64990)
		(self setCursor: gTheControlNormalCursor 1)
		(Sound pause: 1)
		(switch (= temp0 (Save doit: comment))
			(-1)
			(-2
				(= temp1 (Str new:))
				(= temp2 (Str new:))
				(if
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addBitmap: 1203 5 0
						addButtonBM: 64990 0 0 0 temp2 0 40
						addButtonBM: 64990 2 0 1 {Change Dir} 55 40
						init:
					)
					(GetDirectory gCurSaveDir)
				)
				(temp1 dispose:)
				(temp2 dispose:)
			)
			(else
				(if gNumCD
					(self getDisc: gNumCD)
				)
				(self setCursor: gTheControlWaitCursor 1)
				(if
					(not
						(Save 0 name temp0 (comment data:) (KArray 9 gVersion)) ; SaveGame, ArrayGetData
					)
					(= temp1 (Str new:))
					(= temp2 (Str new:))
					(Print
						font: 999
						fore: 0
						back: (Palette 3 127 127 127) ; PalMatch
						addBitmap: 1203 5 0
						addButtonBM: -1 0 0 1 temp2 0 40
						init:
					)
					(temp1 dispose:)
					(temp2 dispose:)
				)
				(self setCursor: gTheControlNormalCursor 1)
			)
		)
		(Sound pause: 0)
	)

	(method (restore &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= temp4 (Str new:))
		(if (not (FileIO 19 (KArray 9 gCurSaveDir))) ; ValidPath, ArrayGetData
			(temp4 format: temp2 gCurSaveDir)
			(Print
				font: 999
				fore: 0
				back: (Palette 3 127 127 127) ; PalMatch
				addText: temp4
				addButtonBM: -1 0 0 1 {OK} 0 30
				init:
			)
			(GetDirectory gCurSaveDir)
		)
		(ScriptID 64990)
		(self setCursor: gTheControlNormalCursor 1)
		(= temp1 (self setCursor:))
		(if gPortal
			(gPortal stopSound:)
		)
		(if (!= (= temp0 (Restore doit: &rest)) -1)
			(for
				((= temp9 (KList 3 (gPlanes elements:)))) ; FirstNode
				temp9
				((= temp9 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (KList 6 temp9)) ; NextNode
				(= temp5 (KList 8 temp9)) ; NodeValue
				(for
					((= temp10 (KList 3 ((temp5 casts:) elements:)))) ; FirstNode
					temp10
					((= temp10 ((temp5 casts:) nextNode:)))
					
					((temp5 casts:) nextNode: (KList 6 temp10)) ; NextNode
					(= temp6 (KList 8 temp10)) ; NodeValue
					(for
						((= temp11 (KList 3 (temp6 elements:)))) ; FirstNode
						temp11
						((= temp11 (temp6 nextNode:)))
						
						(temp6 nextNode: (KList 6 temp11)) ; NextNode
						(= temp7 (KList 8 temp11)) ; NodeValue
						(if (= temp8 (& (temp7 Info:) $0010))
							(DeleteScreenItem temp7)
							(temp7 signal: (| (temp7 signal:) temp8))
						)
					)
				)
				(DeletePlane temp5)
			)
			(self setCursor: gTheControlWaitCursor 1)
			(if (Save 3 name temp0 (KArray 9 gVersion)) ; CheckSaveGame, ArrayGetData
				(self getDisc: (CD 1)) ; GetSaveCD
				(Sound pause: 1)
				(temp2 dispose:)
				(temp3 dispose:)
				(temp4 dispose:)
				(Save 1 name temp0 gVersion) ; RestoreGame
			else
				(for
					((= temp9 (KList 3 (gPlanes elements:)))) ; FirstNode
					temp9
					((= temp9 (gPlanes nextNode:)))
					
					(gPlanes nextNode: (KList 6 temp9)) ; NextNode
					(= temp5 (KList 8 temp9)) ; NodeValue
					(AddPlane temp5)
					(for
						((= temp10 (KList 3 ((temp5 casts:) elements:)))) ; FirstNode
						temp10
						((= temp10 ((temp5 casts:) nextNode:)))
						
						((temp5 casts:) nextNode: (KList 6 temp10)) ; NextNode
						(= temp6 (KList 8 temp10)) ; NodeValue
						(for
							((= temp11 (KList 3 (temp6 elements:)))) ; FirstNode
							temp11
							((= temp11 (temp6 nextNode:)))
							
							(temp6 nextNode: (KList 6 temp11)) ; NextNode
							(= temp7 (KList 8 temp11)) ; NodeValue
							(if (& (temp7 signal:) $0010)
								(AddScreenItem temp7)
								(temp7 signal: (& (temp7 signal:) $0000))
							)
						)
					)
				)
				(Print
					font: 999
					fore: 0
					back: (Palette 3 127 127 127) ; PalMatch
					addText: (temp2 data:)
					addButtonBM: -1 0 0 1 (temp3 data:) 0 40
					init:
				)
				(self setCursor: temp1 (HaveMouse))
				(FrameOut)
			)
		)
		(Sound pause: 0)
		(self setCursor: theControlWaitCursor 1)
		(FrameOut)
		(temp2 dispose:)
		(temp3 dispose:)
		(temp4 dispose:)
	)

	(method (restart &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if global246
			(proc9_92 0)
			(Sound pause: 0)
			(FrameOut)
			(self setCursor: gTheControlNormalCursor 1)
			(= global246 0)
			(= panelSelector (= panelObj 0))
			(gGame handsOn:)
			(return)
		)
		(for
			((= temp0 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp0
			((= temp0 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp0)) ; NextNode
			(= temp6 (KList 8 temp0)) ; NodeValue
			(for
				((= temp1 (KList 3 ((temp6 casts:) elements:)))) ; FirstNode
				temp1
				((= temp1 ((temp6 casts:) nextNode:)))
				
				((temp6 casts:) nextNode: (KList 6 temp1)) ; NextNode
				(= temp5 (KList 8 temp1)) ; NodeValue
				(for
					((= temp2 (KList 3 (temp5 elements:)))) ; FirstNode
					temp2
					((= temp2 (temp5 nextNode:)))
					
					(temp5 nextNode: (KList 6 temp2)) ; NextNode
					(= temp3 (KList 8 temp2)) ; NodeValue
					(if (= temp4 (& (temp3 Info:) $0010))
						(DeleteScreenItem temp3)
						(temp3 signal: (| (temp3 signal:) temp4))
					)
				)
			)
			(DeletePlane temp6)
		)
		(= temp7 (Str new:))
		(FileIO 18 (temp7 data:)) ; GetCWD
		(gCurSaveDir copy: temp7)
		(if (Save 3 {rst} 0 (KArray 9 gVersion)) ; CheckSaveGame, ArrayGetData
			(gGame hideCursor:)
			(self getDisc: 1)
			(Sound pause: 1)
			(temp7 dispose:)
			(Save 1 {rst} 0 gVersion) ; RestoreGame
		else
			(for
				((= temp0 (KList 3 (gPlanes elements:)))) ; FirstNode
				temp0
				((= temp0 (gPlanes nextNode:)))
				
				(gPlanes nextNode: (KList 6 temp0)) ; NextNode
				(= temp6 (KList 8 temp0)) ; NodeValue
				(AddPlane temp6)
				(for
					((= temp1 (KList 3 ((temp6 casts:) elements:)))) ; FirstNode
					temp1
					((= temp1 ((temp6 casts:) nextNode:)))
					
					((temp6 casts:) nextNode: (KList 6 temp1)) ; NextNode
					(= temp5 (KList 8 temp1)) ; NodeValue
					(for
						((= temp2 (KList 3 (temp5 elements:)))) ; FirstNode
						temp2
						((= temp2 (temp5 nextNode:)))
						
						(temp5 nextNode: (KList 6 temp2)) ; NextNode
						(= temp3 (KList 8 temp2)) ; NodeValue
						(if (& (temp3 signal:) $0010)
							(AddScreenItem temp3)
							(temp3 signal: (& (temp3 signal:) $0000))
						)
					)
				)
			)
		)
		(temp7 dispose:)
		(FrameOut)
	)

	(method (setLanguage param1)
		(cond
			((and argc (OneOf param1 1 33 49))
				(self language: param1 changedLang: 1)
			)
			((not argc)
				(switch language
					(1
						(self language: 33 changedLang: 1)
						(SetLanguage {FRENCH})
					)
					(33
						(self language: 49 changedLang: 1)
						(SetLanguage {GERMAN})
					)
					(49
						(self language: 1 changedLang: 1)
						(SetLanguage)
					)
				)
			)
			(else
				(PrintDebug {\nThat language is not currently supported.\n})
			)
		)
	)

	(method (makeText param1 param2 param3 param4 &tmp [temp0 2])
		(lightTextList
			add:
				((lightDText new:)
					text: (KArray 8 param1) ; ArrayDup
					font: param4
					fore: 206
					back: -2
					x: (+ param2 2)
					y: (+ param3 2)
					setSize: 400
					setPri: 504
					init:
					yourself:
				)
				((lightDText new:)
					text: (KArray 8 param1) ; ArrayDup
					font: param4
					fore: 217
					back: -2
					x: param2
					y: param3
					setSize: 400
					setPri: 505
					init:
					yourself:
				)
		)
	)

	(method (disposeText &tmp temp0)
		(lightTextList dispose:)
	)
)

(instance lightDoVerbCode of Code
	(properties)

	(method (doit param1)
		(PrintDebug
			{\nThe game tried to find the .MSG file for this room and couldn't. No cause for\nalarm. Thank you and have a nice day. \n}
		)
		(gCurRoom doVerb: param1)
	)
)

(instance sDepress of Script
	(properties)

	(method (dispose)
		(gUser canInput: 1)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(= caller client)
				(caller setCel: 1)
				(depressSound number: 14 setLoop: 0 play: self)
			)
			(1
				(client setCel: 0)
				(= ticks 10)
			)
			(2
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance lightEgo of Ego
	(properties)
)

(instance dummyProp of Prop
	(properties
		x 999
		view 999
	)

	(method (setScript param1)
		(not param1)
		(super setScript: param1 &rest)
	)
)

(class cSoundFX of Sound
	(properties
		number 100
	)

	(method (do param1 param2)
		(if (> argc 1)
			(self stop: setLoop: 1 number: param1 play: param2)
		else
			(self stop: setLoop: 1 number: param1 play:)
		)
	)
)

(instance mySoundFX of cSoundFX
	(properties)
)

(instance BackMusic of Sound
	(properties
		number 100
	)

	(method (fade)
		(Lock rsAUDIO (self number:) 0)
		(super fade: &rest)
	)
)

(instance BackMusic2 of Sound
	(properties
		number 100
	)

	(method (fade)
		(Lock rsAUDIO (self number:) 0)
		(super fade: &rest)
	)
)

(class RandomMusic of Sound
	(properties
		number 100
		musicOne 0
		musicTwo 0
		musicThree 0
		musicFour 0
	)

	(method (play param1 param2 param3)
		(if (OneOf number 0 100)
			(= number musicOne)
		else
			(= number param3)
		)
		(= vol 127)
		(= client self)
		(if argc
			(if (== argc 1)
				(= client self)
			else
				(= client self)
				(= vol (& param1 $007f))
			)
		)
		(if (> argc 2)
			(= number param3)
		else
			(= number musicOne)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound sndPLAY self)
	)

	(method (cue)
		(cond
			((== number musicOne)
				(if musicTwo
					(self number: musicTwo play: 127 self musicTwo)
				else
					(self number: musicOne play: 127 self musicOne)
				)
			)
			((== number musicTwo)
				(if musicThree
					(self number: musicThree play: 127 self musicThree)
				else
					(self number: musicOne play: 127 self musicOne)
				)
			)
			((== number musicThree)
				(if musicFour
					(self number: musicFour play: 127 self musicFour)
				else
					(self number: musicOne play: 127 self musicOne)
				)
			)
			((== number musicFour)
				(self number: musicOne play: 127 self musicOne)
			)
		)
	)

	(method (fade)
		(= musicFour (= musicThree (= musicTwo (= musicOne 0))))
		(super fade: &rest)
	)

	(method (stop)
		(= musicFour (= musicThree (= musicTwo (= musicOne 0))))
		(super stop: &rest)
	)
)

(instance IRandomMusic of RandomMusic
	(properties)
)

(instance lhMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(==
				(= temp0
					(switch param1
						(4
							(ScriptID 15 0) ; lirylTalker
						)
						(7
							(ScriptID 15 0) ; lirylTalker
						)
						(6
							(ScriptID 15 0) ; lirylTalker
						)
						(3
							(ScriptID 380 1) ; krickTalker
						)
						(else gNarrator)
					)
				)
				gNarrator
			)
			(gNarrator modeless: 2)
		else
			(gNarrator modeless: 0)
		)
		(if temp0
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance gRobot of WalkieTalkie
	(properties)

	(method (dispose)
		(= global102 0)
		(super dispose: &rest)
	)
)

(instance blackPlane of Plane
	(properties)
)

(instance depressSound of Sound
	(properties)
)

(instance discSound of Sound
	(properties
		flags 5
	)
)

(instance changeView of View
	(properties
		view 20
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1000)
	)
)

(instance numberView of View
	(properties
		loop 1
		view 20
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1001)
	)
)

(class ExitCode of Code
	(properties
		nextScene -1
	)

	(method (cue)
		(gCurRoom changeScene: nextScene (gCurRoom compassDir:))
	)
)

(instance globalVMD of VMDPlayer
	(properties
		x 70
		y 75
		buffSize 1024
		palStart 0
		palEnd 199
		putOptions 256
	)

	(method (play &tmp temp0)
		(if (not (gInventory disabled:))
			(= temp0 1)
			(gInventory disable: 1)
		)
		(super play: &rest)
		(if temp0
			(gInventory disable: 0)
		)
	)
)

(instance tGlobalTimer of Timer
	(properties)

	(method (init)
		(cond
			((IsFlag 428)
				(SetFlag 172)
				(SetFlag 290)
				(switch gCurRoomNum
					(330
						(gBackMusic2 number: 176 loop: -1 play: 40 0)
					)
					(350
						(gBackMusic2 number: 176 loop: -1 play: 40 0)
					)
					(320
						(gBackMusic2 number: 176 loop: -1 play: 70 0)
					)
					(else
						(gBackMusic2 number: 176 loop: -1 play: 35 0)
					)
				)
			)
			((IsFlag 267)
				(Load rsAUDIO 177)
				(gBackMusic2 number: 177 loop: -1 play: 0 0)
				(switch gCurRoomNum
					(330
						(gBackMusic2 fade: 40 10 5 0 0)
					)
					(350
						(gBackMusic2 fade: 40 10 5 0 0)
					)
					(320
						(gBackMusic2 fade: 70 10 5 0 0)
					)
					(else
						(gBackMusic2 fade: 35 10 5 0 0)
					)
				)
			)
			(else
				(SetFlag 266)
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(cond
			((IsFlag 428)
				(if gPortal
					(gPortal kill:)
				else
					(ClearFlag 290)
					(ClearFlag 172)
				)
				(gBackMusic2 stop:)
			)
			((IsFlag 267)
				(ClearFlag 267)
				(SetFlag 162)
				(SetFlag 428)
				(self setReal: self 30)
			)
			(else
				(SetFlag 267)
				(self setReal: self 120)
			)
		)
	)
)

(instance monsterTimer of Timer
	(properties)

	(method (cue)
		(ClearFlag 344)
	)
)

