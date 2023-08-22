;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use SQInventory)
(use Styler)
(use DButton)
(use Plane)
(use Str)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use PseudoMouse)
(use IconBar)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Cursor)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use System)

(public
	SQ6 0
	SetFlag 1
	ClearFlag 2
	IsFlag 3
	Face 4
	proc0_5 5
	proc0_6 6
	Fade 7
	RandomNumber 8
	reformTimer 9
	bartenderTimer 10
	nowServingTimer 11
	magnumEatingTimer 12
	sFidget 13
	fidgetTimer 14
	fidgetWhistle 15
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
	gDebugging
	global101 = 1234
	global102
	global103
	gGSound1
	; 105
	gGSound2
	global106
	gWalkCursor
	gLookCursor
	gDoCursor
	; 110
	gTalkCursor
	gDefaultCursor
	gTheExitCursor
	gTheExitNCursor
	gTheExitSCursor
	; 115
	gTheExitECursor
	gTheExitWCursor
	gTheExitNoneCursor
	gHelpCursor
	gComPostNextRoomNum
	; 120
	gAct = 1
	global121
	gTextScroller
	global123
	global124 = 1
	; 125
	global125 = 2
	global126 = 3
	global127 = 4
	global128
	global129 = 1
	; 130
	global130 = 2
	global131 = 3
	global132 = 4
	global133
	global134 = 1
	; 135
	global135 = 2
	global136 = 3
	global137 = 4
	global138
	global139 = 1
	; 140
	global140 = 2
	global141 = 3
	global142 = 4
	global143
	global144 = 1
	; 145
	global145 = 2
	global146 = 3
	global147 = 4
	gShuttleRoomNum = 450
	gTalkedToDjurkwhad
	; 150
	gBuckazoidCount
	global151
	gFileRoomRow
	gNowServingNumber = 4
	gPolygon
	; 155
	gSidneyTalkCount
	global156
	global157
	gEgoSpeed
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
	gShuttleStatus
	gLookedAtNigelFile
	gCurrentMnM = -1
	global173 = 3
	global174
	; 175
	gDeepshipLocation
	global176
	gETTouchCount
	global178
	gStr
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
	global226
	global227
	global228
	global229
	; 230
	global230
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
	gFlags
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
	global300 = 100
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [gFlags (/ param1 16)]
		(| [gFlags (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [gFlags (/ param1 16)]
		(& [gFlags (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (IsFlag param1)
	(return (& [gFlags (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_5 param1 param2 param3) ; UNUSED
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc0_6 param1 param2) ; UNUSED
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (Fade param1 param2 param3 param4 &tmp temp0 temp1)
	(if (or (< argc 2) (== param2 0))
		(= param2 1)
	)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(if (and (== argc 4) param4)
				(Palette 2 0 256 temp0) ; PalIntensity
			else
				(Palette 2 0 79 temp0) ; PalIntensity
				(Palette 2 87 256 temp0) ; PalIntensity
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(if (and (== argc 4) param4)
				(Palette 2 0 256 temp0) ; PalIntensity
			else
				(Palette 2 0 79 temp0) ; PalIntensity
				(Palette 2 87 256 temp0) ; PalIntensity
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(gCast doit:)
			(FrameOut)
		)
	)
	(cond
		((== param1 1)
			(if (and (== argc 4) param4)
				(Palette 2 0 256 0) ; PalIntensity
			else
				(Palette 2 0 79 0) ; PalIntensity
				(Palette 2 87 256 0) ; PalIntensity
			)
		)
		((and (== argc 4) param4)
			(Palette 2 0 256 100) ; PalIntensity
		)
		(else
			(Palette 2 0 79 100) ; PalIntensity
			(Palette 2 87 256 100) ; PalIntensity
		)
	)
	(FrameOut)
	(if (and (>= argc 3) param3)
		(param3 cue:)
	)
)

(procedure (RandomNumber param1 param2)
	(return
		(+ param1 (mod (+ (* 25173 (GetTime)) 13849) (+ (- param2 param1) 1)))
	)
)

(procedure (Face param1 param2 param3 &tmp temp0 [temp1 2] temp3)
	(if (== argc 3)
		(= temp3 param3)
	else
		(= temp3 0)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(param1 setHeading: temp0 temp3)
)

(instance gSound1 of Sound
	(properties)
)

(instance gSound2 of Sound
	(properties)
)

(instance fidgetWhistle of Sound
	(properties
		number 119
		loop -1
	)
)

(class SQ6 of Game
	(properties)

	(method (init &tmp temp0 [temp1 2])
		(Font 1 640 480) ; SetFontRes
		Print
		DButton
		StopWalk
		Polygon
		PolyPath
		Timer
		IconBar
		Inv
		Narrator
		(super init: &rest)
		(Styler init:)
		(gThePlane setRect: 0 0 319 138 priority: 4)
		((= gAltPolyList (List new:)) name: {altPolys} add:)
		(= gMsgType 3)
		(= gEgo (ScriptID 20 0)) ; ego
		(User alterEgo: gEgo canControl: 1 canInput: 0 mapKeyToDir: 0)
		(= gSystemPlane Plane)
		(= gEatMice 6)
		(= gDoVerbCode sq6DVC)
		(= gApproachCode pApproachCode)
		(= gPMouse PseudoMouse)
		(= gMessager sq6Messager)
		(= gUseSortedFeatures 1)
		(= global103 6)
		(= gPossibleScore 999)
		(= gUserFont 70)
		(= gVersion {x.yyy.zzz})
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 10 temp0)
		(FileIO fiCLOSE temp0)
		(= gEgoSpeed 4)
		(= gWaitCursor theWaitCursor)
		(= gNormalCursor arrowCursor)
		(= gWalkCursor walkCursor)
		(= gDoCursor doCursor)
		(= gLookCursor lookCursor)
		(= gTalkCursor talkCursor)
		(= gHelpCursor helpCursor)
		(= gTheExitCursor theExitCursor)
		(= gTheExitNCursor theExitNCursor)
		(= gTheExitSCursor theExitSCursor)
		(= gTheExitECursor theExitECursor)
		(= gTheExitWCursor theExitWCursor)
		(= gTheExitNoneCursor theExitNoneCursor)
		(= gDefaultCursor defaultCursor)
		(self setCursor: gWaitCursor 1 160 120)
		(= gMouseX 160)
		(= gMouseY 80)
		((= gGSound1 gSound1) owner: self init:)
		((= gGSound2 gSound2) owner: self init:)
		(= gDebugging 0)
		(if (== (Platform 4) 2)
			(= global106 1)
		)
		((ScriptID 32 0) init:) ; SQ6Controls
		(SQInventory init:)
		(if gDebugging
			(= global300 24)
		)
		(SetPalStyleRange 80 86)
		(Styler addInclusionRange: 0 79)
		(Styler addInclusionRange: 87 255)
		(Styler changeDivisions: 15)
		(self
			handsOffCode: sq6HandsOffCode
			handsOnCode: sq6HandsOnCode
			newRoom: 33 ; speedRoom
		)
		(Dialog mouseHiliting: 1)
		((= gNarrator Narrator)
			x: 15
			y: 160
			talkWidth: 225
			font: gUserFont
			fore: 82
			back: 0
		)
		(Print fore: 84 back: 86)
		(fidgetTimer setReal: fidgetTimer 60)
	)

	(method (startRoom roomNum)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gDebugging
			((ScriptID 21 0) init:) ; debugRm
		)
		(super startRoom: roomNum)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(ClearFlag 181)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (gUser canInput:) (!= gCurRoomNum 100) (== (event type:) evKEYBOARD))
			(switch (event message:)
				(KEY_TAB
					(if (not (& ((gTheIconBar at: 4) signal:) $0004))
						((gTheIconBar at: 4) select:)
						(event claimed: 1)
					)
				)
				(KEY_SHIFTTAB
					(if (not (& ((gTheIconBar at: 4) signal:) $0004))
						((gTheIconBar at: 4) select:)
						(event claimed: 1)
					)
				)
				(KEY_CONTROL
					(gGame quitGame:)
					(event claimed: 1)
				)
				(KEY_ALT_x
					(gGame quitGame:)
					(event claimed: 1)
				)
				(KEY_F2
					(cond
						((gGame masterVolume:)
							(gGame masterMusicVolume: 0 masterAudioVolume: 0)
						)
						((> global103 1)
							(gGame
								masterMusicVolume: 5
								masterAudioVolume: 127
							)
						)
						(else
							(gGame masterMusicVolume: 1 masterAudioVolume: 8)
						)
					)
					(event claimed: 1)
				)
				(KEY_F5
					(if
						(and
							(not (& (gTheIconBar state:) $0004))
							(not (& ((gTheIconBar at: 6) signal:) $0004))
							(gTalkers isEmpty:)
						)
						(self save:)
						(event claimed: 1)
					)
				)
				(KEY_F7
					(if
						(and
							(not (& (gTheIconBar state:) $0004))
							(not (& ((gTheIconBar at: 6) signal:) $0004))
							(gTalkers isEmpty:)
						)
						(self restore:)
						(event claimed: 1)
					)
				)
				(KEY_ADD
					(if (gUser controls:)
						(gEgo
							setSpeed:
								(= gEgoSpeed
									(Max 0 (- (gEgo moveSpeed:) 1))
								)
						)
					)
				)
				(KEY_SUBTRACT
					(if (and (gUser controls:) (< gEgoSpeed 11))
						(gEgo
							setSpeed: (= gEgoSpeed (+ (gEgo moveSpeed:) 1))
						)
					)
				)
				($003d ; =
					(if (gUser controls:)
						(gEgo setSpeed: 6)
					)
				)
			)
		)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((& (event type:) evVERB)
				(if (gUser canInput:)
					(sq6DVC doit: (event message:))
				else
					(gGame pragmaFail:)
				)
			)
		)
		(event claimed:)
	)

	(method (save &tmp temp0 temp1)
		(= temp0 gTheCursor)
		(gTheIconBar showTextScroller: 0)
		(super save:)
		(gTheIconBar showTextScroller: 1)
		(gGame setCursor: temp0)
	)

	(method (restore &tmp temp0 temp1)
		(= temp0 gTheCursor)
		(if (and (!= gCurRoomNum 100) (!= gCurRoomNum 24)) ; whereTo
			(gTheIconBar showTextScroller: 0)
		)
		(cond
			(gGSound1
				(gGSound1 stop:)
			)
			(gGSound2
				(gGSound1 stop:)
			)
		)
		(super restore:)
		(cond
			((and (gGSound1 number:) (gGSound1 signal:))
				(gGSound1 play:)
			)
			((and (gGSound2 number:) (gGSound1 signal:))
				(gGSound2 play:)
			)
		)
		(if (and (!= gCurRoomNum 100) (!= gCurRoomNum 24)) ; whereTo
			(gTheIconBar showTextScroller: 1)
		)
		(gGame setCursor: temp0)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
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
					(if (& (temp3 -info-:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(if (gEgo code:)
			(= temp7 (gEgo code:))
			(gEgo code: 0)
		else
			(= temp7 0)
		)
		(gCurRoom buildPic:)
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(SL doit:)
		(= gTickOffset (- gGameTime (GetTime)))
		(gTheIconBar showTextScroller: 1 show:)
		(if temp7
			(FrameOut)
			(gEgo code: temp7)
		)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (showMem &tmp temp0 temp1 temp2)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(= temp2 (Str new:))
		(Message msgGET 30 2 0 0 1 (temp1 data:)) ; "Free Memory:"
		(Message msgGET 30 2 0 0 2 (temp2 data:)) ; "kBytes"
		(temp0 format: {%s %u %s} temp1 (MemoryInfo 0) temp2)
		(temp1 dispose:)
		(temp2 dispose:)
		(return temp0)
	)

	(method (showAbout &tmp temp0 temp1 temp2)
		(= temp2 (Str new:))
		(= temp1 (Str new:))
		(Message msgGET 30 3 0 0 1 (temp1 data:)) ; "Version:"
		(temp2 format: {%s %s} temp1 gVersion)
		((Print new:)
			mode: 1
			font: 71
			fore: 81
			back: 0
			addBitmap: 978 0 0
			addText: 1 0 0 1 39 5 30
			addText: 1 0 0 2 42 14 30
			addText: 1 0 0 3 30 21 30
			addText: (temp2 data:) 36 34
			addButtonBM: 978 1 0 1 { } 43 58
			init:
		)
		(temp1 dispose:)
		(temp2 dispose:)
	)

	(method (showControls)
		((ScriptID 32 0) showSelf:) ; SQ6Controls
	)

	(method (points param1 param2)
		(if (and (> argc 1) (SetFlag param2))
			(= param1 0)
		)
		(if param1
			(gGame changeScore: param1)
			(gTheIconBar updateScore: param1)
		)
	)

	(method (masterMusicVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (masterAudioVolume param1)
		(if argc
			(DoAudio audVOLUME param1)
		else
			(DoAudio audVOLUME)
		)
	)

	(method (muteMusic param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME 5)
		)
	)

	(method (pragmaFail &tmp temp0 temp1)
		(if (gUser input:)
			(= temp0 (self setCursor: theFailCursor))
			(for ((= temp1 0)) (< temp1 15000) ((++ temp1))
			)
			(self setCursor: temp0)
		)
	)
)

(instance pApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(1 1)
				(2 2)
				(3 4)
				(4 8)
				(7 16)
				(8 32)
				(9 64)
				(10 128)
				(6 16384)
				(else 32768)
			)
		)
	)
)

(instance sq6DVC of Code
	(properties)

	(method (doit param1)
		(cond
			((== param1 1)
				(gMessager say: 0 1 0 (RandomNumber 1 8) 0 0)
			)
			((== param1 4)
				(gMessager say: 0 4 0 (RandomNumber 1 7) 0 0)
			)
			((== param1 2)
				(gMessager say: 0 2 0 (RandomNumber 1 7) 0 0)
			)
			((not (OneOf param1 3 1 4 2 17 11 5 7 9 10 8))
				(gMessager say: 0 26 0 (RandomNumber 1 6) 0 0)
			)
			(else
				(gGame pragmaFail:)
			)
		)
	)
)

(instance sq6HandsOffCode of Code
	(properties)

	(method (doit param1 param2)
		(if (not global121)
			(= global121 (gTheIconBar curIcon:))
		)
		(if (& (gTheIconBar state:) $0004)
			(gTheIconBar enable:)
		)
		(if (or (gUser canControl:) (gUser canInput:))
			(gTheIconBar updateSettings:)
		)
		(User canControl: 0 canInput: 0)
		(gTheIconBar curIcon: (gTheIconBar at: 6) disable: 0 1 2 3 4 5 6)
		(if
			(and
				(gTheIconBar curInvIcon:)
				(not (& ((gTheIconBar at: 7) signal:) $0004))
			)
			(gTheIconBar disable: 7)
			((gTheIconBar at: 7) highlight: 0)
		)
		(if argc
			(gGame setCursor: theWaitCursor 1 param1 param2)
		else
			(gGame setCursor: theWaitCursor 1)
		)
		(if gEgo
			(gEgo setMotion: 0)
		)
	)
)

(instance sq6HandsOnCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable: 0 1 2 3 4 5 6)
		(if (gTheIconBar curInvIcon:)
			(gTheIconBar enable: 7)
			((gTheIconBar at: 7) highlight: 1)
		)
		(if global121
			(gTheIconBar curIcon: global121 highlight: global121)
		)
		(= global121 0)
		(if argc
			(gGame
				setCursor: ((gTheIconBar curIcon:) getCursor:) 1 param1 param2
			)
		else
			(gGame setCursor: ((gTheIconBar curIcon:) getCursor:) 1)
		)
		(if gEgo
			(gEgo setSpeed: gEgoSpeed)
		)
	)
)

(instance defaultCursor of Cursor
	(properties
		view 999
	)
)

(instance arrowCursor of Cursor
	(properties
		view 999
	)
)

(instance walkCursor of Cursor
	(properties
		view 953
		loop 2
	)
)

(instance lookCursor of Cursor
	(properties
		view 953
		loop 1
	)
)

(instance doCursor of Cursor
	(properties
		view 953
	)
)

(instance talkCursor of Cursor
	(properties
		view 953
		loop 3
	)
)

(instance helpCursor of Cursor
	(properties
		view 953
		loop 4
	)
)

(instance useCursor of Cursor ; UNUSED
	(properties
		view 999
	)
)

(instance theWaitCursor of Cursor
	(properties
		view 997
	)
)

(instance theFailCursor of Cursor
	(properties
		view 954
		loop 5
	)
)

(instance theExitCursor of Cursor
	(properties
		view 954
		loop 4
	)
)

(instance theExitSCursor of Cursor
	(properties
		view 954
		loop 3
	)
)

(instance theExitNCursor of Cursor
	(properties
		view 954
		loop 2
	)
)

(instance theExitECursor of Cursor
	(properties
		view 954
		loop 1
	)
)

(instance theExitWCursor of Cursor
	(properties
		view 954
	)
)

(instance theExitNoneCursor of Cursor
	(properties
		view 954
		loop 5
	)
)

(instance sq6Messager of Messager
	(properties)

	(method (say)
		(if (not (IsFlag 193))
			(= scratch gTheCursor)
			(gGame setCursor: gWaitCursor)
			(SetFlag 193)
			(if (& gMsgType $0002)
				(gNarrator curVolume: (gGame masterMusicVolume:))
				(cond
					((> (gNarrator curVolume:) 6)
						(gGame muteMusic: (- (gNarrator curVolume:) 6))
					)
					((== (gNarrator curVolume:) 0)
						(gGame muteMusic: 0)
					)
					(else
						(gGame muteMusic: 1)
					)
				)
			)
		else
			(SetFlag 204)
			(gTalkers eachElementDo: #dispose)
		)
		(super say: &rest)
	)

	(method (sayRange)
		(if (not (IsFlag 193))
			(= scratch gTheCursor)
			(gGame setCursor: gWaitCursor)
			(SetFlag 193)
			(if (& gMsgType $0002)
				(gNarrator curVolume: (gGame masterMusicVolume:))
				(cond
					((> (gNarrator curVolume:) 6)
						(gGame muteMusic: (- (gNarrator curVolume:) 6))
					)
					((== (gNarrator curVolume:) 0)
						(gGame muteMusic: 0)
					)
					(else
						(gGame muteMusic: 1)
					)
				)
			)
		else
			(SetFlag 204)
			(gTalkers eachElementDo: #dispose)
		)
		(super sayRange: &rest)
	)

	(method (dispose)
		(if (not (IsFlag 204))
			(ClearFlag 193)
			(if (!= scratch gWaitCursor)
				(gGame setCursor: scratch)
			)
			(= scratch 0)
			(if (& gMsgType $0002)
				(gGame masterMusicVolume: (gNarrator curVolume:))
			)
			(super dispose: &rest)
		else
			(ClearFlag 204)
		)
	)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(25
						(switch gCurRoomNum
							(380
								(ScriptID 380 2) ; Stellar_b
							)
							(420
								(if (IsFlag 111)
									(ScriptID 420 3) ; Stellar_b
								else
									(ScriptID 420 1) ; Stellar_a
								)
							)
							(460
								(if (IsFlag 110)
									(ScriptID 460 3) ; Stellar
								else
									(ScriptID 460 1) ; Stellar_Santiago
								)
							)
							(520
								(ScriptID 520 2) ; Stellar
							)
							(540
								(ScriptID 540 3) ; Stellar
							)
						)
					)
					(13
						(ScriptID 200 1) ; Djurkwhad
					)
					(6
						(ScriptID 222 1) ; Blaine
					)
					(7
						(ScriptID 222 2) ; Elmo
					)
					(5
						(ScriptID 240 1) ; Manager
					)
					(20
						(ScriptID 250 1) ; Fester_Blatz
					)
					(15
						(switch gCurRoomNum
							(260
								(ScriptID 260 1) ; Singent
							)
							(220
								(ScriptID 220 1) ; Singent
							)
						)
					)
					(14
						(switch gCurRoomNum
							(270
								(ScriptID 270 1) ; Nigel
							)
							(220
								(ScriptID 220 2) ; Nigel
							)
						)
					)
					(22
						(switch gCurRoomNum
							(490
								(ScriptID 490 2) ; Manuel_Auxveride
							)
							(480
								(ScriptID 480 1) ; Manuel_Auxveride
							)
						)
					)
					(10
						(ScriptID 280 1) ; Pa_Conshohoken
					)
					(8
						(ScriptID 300 1) ; Bartender
					)
					(39
						(switch gCurRoomNum
							(360
								(ScriptID 360 1) ; Admiral_Toolman
							)
							(100
								(ScriptID 100 3) ; starconTalker
							)
						)
					)
					(28
						(switch gCurRoomNum
							(360
								(ScriptID 360 2) ; Sharpei
							)
							(520
								(ScriptID 520 1) ; Sharpei
							)
							(770
								(ScriptID 770 1) ; Sharpei
							)
						)
					)
					(40
						(ScriptID 360 3) ; Chief_Engineer
					)
					(41
						(ScriptID 400 1) ; Ptooie
					)
					(33
						(switch gCurRoomNum
							(100
								(if (== (gCurRoom curPic:) 80)
									(ScriptID 100 1) ; Commander_Kielbasa
								else
									(ScriptID 100 2) ; KielbasaTalker
								)
							)
							(360
								(ScriptID 360 4) ; Commander_Kielbasa
							)
							(380
								(ScriptID 380 3) ; Commander_Kielbasa
							)
							(490
								(ScriptID 490 1) ; Commander_Kielbasa
							)
							(510
								(ScriptID 510 2) ; Commander_Kielbasa
							)
							(460
								(ScriptID 460 2) ; Commander_Kielbasa
							)
						)
					)
					(2
						(ScriptID 360 5) ; Computer
					)
					(42
						(ScriptID 330 1) ; Bouncer
					)
					(26
						(ScriptID 410 1) ; Chaplain
					)
					(19
						(cond
							((== gCurRoomNum 370)
								(ScriptID 370 1) ; Dorff
							)
							((== gCurRoomNum 455)
								(ScriptID 455 1) ; Storm_Pooper
							)
						)
					)
					(17
						(ScriptID 380 1) ; Jebba_the_Hop_b
					)
					(4
						(cond
							((== gCurRoomNum 510)
								(ScriptID 510 1) ; Dr__Beleauxs
							)
							((== gCurRoomNum 540)
								(ScriptID 540 1) ; Dr_Beleauxs
							)
						)
					)
					(27
						(ScriptID 470 1) ; Wriggley
					)
					(29
						(ScriptID 430 1) ; Sidney
					)
					(30
						(ScriptID 570 1) ; Sis_Inny
					)
					(23
						(ScriptID 290 1) ; Endodroid
					)
					(1
						(cond
							((== gCurRoomNum 100)
								(ScriptID 100 4) ; rogerNHTalker
							)
							((== gCurRoomNum 410)
								(ScriptID 410 2) ; Roger
							)
							((== gCurRoomNum 470)
								(ScriptID 470 2) ; Roger
							)
							((== gCurRoomNum 490)
								(ScriptID 490 3) ; Roger
							)
							((IsFlag 112)
								(ScriptID 420 4) ; Roger
							)
							((and (== gCurRoomNum 510) (IsFlag 205))
								(ScriptID 510 3) ; Roger
							)
							((== gCurRoomNum 540)
								(ScriptID 540 4) ; Roger
							)
							((== gCurRoomNum 770)
								(if (IsFlag 208)
									(= global156 5)
									(ScriptID 20 1) ; Roger
								else
									(= global156 1)
									(ScriptID 20 1) ; Roger
								)
							)
							(else
								(= global156 1)
								(ScriptID 20 1) ; Roger
							)
						)
					)
					(34
						(= global156 0)
						(ScriptID 20 1) ; Roger
					)
					(36
						(= global156 1)
						(ScriptID 20 1) ; Roger
					)
					(35
						(= global156 2)
						(ScriptID 20 1) ; Roger
					)
					(37
						(= global156 3)
						(ScriptID 20 1) ; Roger
					)
					(43
						(= global156 4)
						(ScriptID 20 1) ; Roger
					)
					(44
						(= global156 5)
						(ScriptID 20 1) ; Roger
					)
					(else gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance fidgetTimer of Timer
	(properties)

	(method (setTicks)
		(Prints {Don't})
	)

	(method (cue)
		(cond
			((or (== gCurRoomNum 210) (== gCurRoomNum 250))
				(self setReal: self 60)
			)
			((IsFlag 181)
				(self setReal: self 60)
			)
			(
				(and
					(not (gEgo script:))
					(not (gCurRoom script:))
					(gTalkers isEmpty:)
					(not (gCurRoom inset:))
					(== (gEgo view:) 901)
					(not (gEgo mover:))
					(gUser canInput:)
					(gUser canControl:)
					(OneOf (gEgo loop:) 0 1 6)
					(gCast contains: gEgo)
					(gEgo isNotHidden:)
					(== (gEgo z:) 0)
				)
				(if (== gCurRoomNum 570)
					(self setReal: self 20)
				else
					(self setReal: self 60)
				)
				(gEgo setScript: sFidget)
			)
			(else
				(self setReal: self 60)
			)
		)
	)
)

(instance reformTimer of Timer
	(properties)

	(method (doit)
		(if (gUser input:)
			(super doit: &rest)
		)
	)

	(method (setTicks)
		(Prints {Don't})
	)

	(method (cue)
		(cond
			((or (== gCurRoomNum 210) (== gCurRoomNum 250))
				(self setReal: self 30)
			)
			((IsFlag 181)
				(self setReal: self 15)
			)
			(
				(and
					(not (gEgo script:))
					(not (gCurRoom script:))
					(gTalkers isEmpty:)
					(not (gCurRoom inset:))
					(or (== (gEgo view:) 900) (== (gEgo view:) 901))
				)
				(gEgo setScript: (ScriptID 20 2)) ; endroidReforms
			)
			(else
				(self setReal: self 5)
			)
		)
	)
)

(instance bartenderTimer of Timer
	(properties)

	(method (cue)
		(ClearFlag 42)
		(cond
			((== gCurRoomNum 300)
				(gCurRoom notify:)
			)
			((IsFlag 15)
				(ClearFlag 20)
				(ClearFlag 15)
				(SetFlag 39)
				(SetFlag 40)
			)
		)
	)
)

(instance nowServingTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (IsFlag 183)) (> (++ gNowServingNumber) 99))
			(= gNowServingNumber 0)
		)
		(if (== gCurRoomNum 570)
			(if
				(and
					(gTalkers isEmpty:)
					(gUser input:)
					(gUser canControl:)
					(not (gCurRoom inset:))
				)
				(ClearFlag 183)
				(gCurRoom notify:)
				(self setReal: self 60)
			else
				(SetFlag 183)
				(self setTicks: self 60)
			)
		)
	)
)

(instance RogerLateTimer of Timer ; UNUSED
	(properties)

	(method (cue)
		(SetFlag 117)
	)
)

(instance magnumEatingTimer of Timer
	(properties)

	(method (cue)
		(SetFlag 156)
		(SetFlag 155)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global176 (gEgo cycleSpeed:))
				(switch (gEgo loop:)
					(0
						(gEgo setLoop: 0 1)
					)
					(1
						(gEgo setLoop: 1 1)
					)
					(6
						(if (< (Random 0 99) 50)
							(gEgo setLoop: 4 1)
						else
							(gEgo setLoop: 5 1)
						)
					)
				)
				(gEgo view: 578 setCel: 0 setSpeed: 12 setCycle: End self)
			)
			(1
				(switch (gEgo loop:)
					(0
						(gEgo setLoop: 2 setCel: 0 setCycle: Fwd)
						(fidgetWhistle play:)
					)
					(1
						(gEgo setLoop: 3 setCel: 0 setCycle: Fwd)
						(fidgetWhistle play:)
					)
					(else
						(gEgo setSpeed: global176 normalize: 6)
					)
				)
				(self dispose:)
			)
		)
	)
)

