;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use GK2Ego)
(use n011)
(use invInitCode)
(use Notebook)
(use Walkman)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use Talker)
(use IconBar)
(use PanelPlane)
(use PolyPath)
(use Polygon)
(use Cursor)
(use Timer)
(use Grooper)
(use Sound)
(use Game)
(use User)
(use Actor)
(use System)

(public
	GK2 0
	interfacePlane 1
	respondSet 2
	inventoryButton 4
	recButton 5
	mapHintButton 6
	movieButton 7
	bottomPlane 8
	logo 9
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
	gScreenWidth = 640
	gScreenHeight = 480
	gLastScreenX = 639
	gLastScreenY = 479
	; 100
	gGrooper
	global101 = 1234
	gGk2Music
	gGk2Sound
	global104
	; 105
	global105 = 14
	global106
	gInterfacePlane
	gDebugging
	global109
	; 110
	global110
	global111
	global112 = 6
	gTheInvCursor
	gTheUseObjCursor
	; 115
	gChapter = 1
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
	gGk2RespondCode
	global126
	global127
	gCurInvView
	gTopMessage
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
	global139 = 430
	; 140
	global140 = 250
	global141
	global142 = 1
	global143 = 1
	global144
	; 145
	global145
	gSoundManager
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
	gStr
	global249
	; 250
	global250 = -1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Actor new:))
	(temp0 view: 64980 loop: 0 cel: 0 init: posn: 200 240)
	(= temp2 0)
	(= temp3 -1)
	(= temp4 (Plane new:))
	(temp4 init: picture: -1 priority: 1000)
	(UpdatePlane temp4)
	(FrameOut)
	(= temp1 (+ (GetTime) 120))
	(while (< (GetTime) temp1)
		(*= temp3 -1)
		(temp0 x: (+ (temp0 x:) temp3))
		(UpdateScreenItem temp0)
		(FrameOut)
		(++ temp2)
	)
	(temp4 dispose:)
	(gGame detailLevel: (- (/ temp2 25) 1))
	(return temp2)
)

(procedure (localproc_1 param1 &tmp temp0) ; UNUSED
	(Str format: {%s%s} gCurSaveDir param1)
)

(instance topInfoPlane of PanelPlane
	(properties)

	(method (init)
		(= priority 200)
		(super init: 0 0 640 14)
		(topInfoBar init: self)
		(TopMessage init: self)
		(vmdText init: self)
		(scoreText init: self)
	)
)

(instance topInfoBar of PanelView
	(properties
		view 121
	)
)

(instance leftPlane of PanelPlane
	(properties)

	(method (init)
		(= priority 201)
		(super init: 0 12 11 351)
		(leftBorder init: self)
	)
)

(instance leftBorder of PanelView
	(properties
		view 121
		loop 2
	)
)

(instance rightPlane of PanelPlane
	(properties)

	(method (init)
		(= priority 201)
		(super init: 628 12 640 351)
		(rightBorder init: self)
	)
)

(instance rightBorder of PanelView
	(properties
		view 121
		loop 3
	)
)

(instance bottomPlane of PanelPlane
	(properties)

	(method (init)
		(= priority 199)
		(super init: 0 349 640 480)
		(bottomBorder init: self)
	)
)

(instance bottomBorder of PanelView
	(properties
		view 121
		loop 1
	)
)

(class TopMessage of PanelText
	(properties
		x 50
		fore 13
		back 1
		skip 1
		font 50
		width 500
		height 28
		textTop 2
		oldBitmap 0
	)

	(method (init)
		(= gTopMessage self)
		(super init: &rest)
	)

	(method (toggleText &tmp temp0)
		(if (vmdText text:)
			(vmdText newText: 0)
		else
			(vmdText newText: {Click mouse to skip scene})
		)
	)

	(method (dispose)
		(if (and oldBitmap (!= oldBitmap bitmap))
			(Bitmap 1 oldBitmap) ; Dispose
		)
		(= oldBitmap 0)
		(super dispose: &rest)
	)

	(method (restore)
		(if (!= bitmap oldBitmap)
			(if oldBitmap
				(if bitmap
					(Bitmap 1 bitmap) ; Dispose
				)
				(= bitmap oldBitmap)
			else
				(self newText: 0)
			)
			(UpdateScreenItem self)
		)
	)

	(method (save param1)
		(if (and oldBitmap (!= oldBitmap bitmap))
			(Bitmap 1 oldBitmap) ; Dispose
		)
		(= oldBitmap (if (or (not argc) param1) bitmap else 0))
	)

	(method (setBitmap)
		(if (== oldBitmap bitmap)
			(= bitmap 0)
		)
		(super setBitmap: &rest)
	)
)

(instance vmdText of PanelText
	(properties
		x 350
		fore 13
		back 1
		skip 1
		width 200
		height 28
		textTop 2
	)
)

(instance sceneText of PanelText ; UNUSED
	(properties
		x 55
		y 5
		fore 13
		back 1
		skip 1
		width 200
		height 28
	)
)

(instance scoreText of PanelText
	(properties
		x 520
		fore 13
		back 1
		skip 1
		width 120
		height 28
		textTop 2
	)
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

(instance theHotCursor of Cursor ; UNUSED
	(properties
		view 996
	)
)

(instance theInvCursor of Cursor
	(properties
		view 135
	)
)

(instance theUseObjCursor of Cursor
	(properties
		view 999
	)
)

(instance theBadCursor of Cursor ; UNUSED
	(properties
		view 999
		loop 1
	)
)

(class GK2 of Game
	(properties
		isHandsOn 0
		currentSpeed 4
		oldCurs 0
		speedRating 0
	)

	(method (updateFrames)
		(if (> (topInfoBar view:) 0)
			(Lock rsVIEW (topInfoBar view:) 0)
			(Lock rsVIEW (leftBorder view:) 0)
			(Lock rsVIEW (rightBorder view:) 0)
			(Lock rsVIEW (bottomBorder view:) 0)
		)
		(topInfoBar view: (+ 120 gChapter))
		(leftBorder view: (+ 120 gChapter))
		(rightBorder view: (+ 120 gChapter))
		(bottomBorder view: (+ 120 gChapter))
		(UpdateScreenItem topInfoBar)
		(UpdateScreenItem leftBorder)
		(UpdateScreenItem rightBorder)
		(UpdateScreenItem bottomBorder)
		(Lock rsVIEW (topInfoBar view:) 1)
		(Lock rsVIEW (leftBorder view:) 1)
		(Lock rsVIEW (rightBorder view:) 1)
		(Lock rsVIEW (bottomBorder view:) 1)
	)

	(method (initFrames)
		(topInfoPlane init:)
		(leftPlane init:)
		(rightPlane init:)
		(bottomPlane init:)
		(interfacePlane priority: 200 init: 4 352 640 480)
		(= gInterfacePlane interfacePlane)
	)

	(method (changeScore param1 &tmp [temp0 2])
		(if argc
			(if (IsFlag param1)
				(return 0)
			)
			(SetFlag param1)
			(+=
				gScore
				(switch gChapter
					(1
						(cond
							((<= 820 param1 848) 1)
							((<= 849 param1 859) 2)
							((== param1 860) 4)
							((<= 861 param1 863) 5)
							((OneOf param1 864 865) 10)
						)
					)
					(2
						(cond
							((<= 866 param1 872) 1)
							((<= 873 param1 891) 2)
							((== 892 param1) 3)
							((== param1 893) 4)
							((<= 894 param1 898) 5)
						)
					)
					(3
						(cond
							((<= 925 param1 956) 1)
							((<= 957 param1 966) 2)
							((<= 967 param1 972) 3)
							((<= 973 param1 977) 5)
						)
					)
					(4
						(cond
							((<= 981 param1 1025) 1)
							((<= 1026 param1 1044) 2)
							((<= 1045 param1 1046) 3)
							((<= 1047 param1 1048) 5)
							((<= 1049 param1 1050) 10)
						)
					)
					(5
						(cond
							((<= 1055 param1 1072) 1)
							((<= 1073 param1 1082) 2)
							((<= 1083 param1 1086) 3)
							((<= 1087 param1 1094) 5)
							((<= 1095 param1 1096) 7)
							((<= 1097 param1 1099) 10)
						)
					)
					(6
						(cond
							((<= 1105 param1 1139) 1)
							((<= 1140 param1 1148) 2)
							((<= 1149 param1 1156) 3)
							((== 1157 param1) 4)
							((<= 1158 param1 1168) 5)
							((== 1169 param1) 10)
							((== 1170 param1) 20)
						)
					)
				)
			)
		)
		(return
			(scoreText newText: (Str format: {Score: %d out of 679} gScore))
		)
	)

	(method (play &tmp [temp0 4])
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(= gStr (Str new:))
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(self setCursor: gWaitCursor init:)
		(while 1
			(switch gQuit
				(0
					(self doit:)
				)
				(1
					(break)
				)
				(2
					(= gQuit 1)
				)
			)
		)
	)

	(method (init &tmp [temp0 9] temp9 [temp10 2])
		(ScriptID 64982)
		DText
		DButton
		Print
		Polygon
		PolyPath
		(super init: &rest)
		((ScriptID 25 0) doit:) ; gk2InitCode
		(GKHotCursor initialize:)
		(= gLastVolume 63)
		(gk2Music owner: self init:)
		(gk2Sound flags: 4 owner: self init:)
		(respondSet add:)
		((ScriptID 20 0) doit:) ; invInitCode
		(= gSystemPlane Plane)
		(= gVersion {xx.yyy.zzz})
		(if (!= (= temp9 (FileIO fiOPEN {version} 1)) -1)
			(FileIO fiREAD_STRING gVersion 11 temp9)
		)
		(FileIO fiCLOSE temp9)
		(= gEgo GabeEgo)
		(User alterEgo: gEgo)
		(= gTheCursor theNormalCursor)
		(= gNormalCursor theNormalCursor)
		(= gWaitCursor theWaitCursor)
		(= gTheInvCursor theInvCursor)
		(= gTheUseObjCursor theUseObjCursor)
		(= oldCurs gNormalCursor)
		(= gGrooper Grooper)
		(= gDoVerbCode gk2DoVerbCode)
		(= gApproachCode gk2ApproachCode)
		(= gGk2RespondCode gk2RespondCode)
		(= gMessager gk2Messager)
		((= gNarrator Narrator) modeless: 2)
		(= gGk2Sound gk2Sound)
		(= gGk2Music gk2Music)
		(= isHandsOn 0)
		(= global118 (MemoryInfo 0))
		(= speedRating (localproc_0))
		(= global135 1)
		(switch gDebugging
			(0
				(self newRoom: 34) ; demoRm
			)
			(1
				(self initFrames:)
				(self newRoom: 24) ; whereTo
			)
		)
	)

	(method (startRoom roomNum &tmp [temp0 4])
		((ScriptID 37) init:) ; soundRegion
		(gRegions add: (ScriptID 37)) ; soundRegion
		(super startRoom: roomNum)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (handleEvent event)
		(if (and gDebugging (& (event type:) evKEYBOARD))
			(if (== gCurRoomNum 98)
				(gCurRoom handleEvent: event)
				(return 1)
			)
			(switch (event message:)
				(KEY_ESCAPE
					(gUser curVerb: 62)
					((gUser hotCursor:) update:)
				)
				(KEY_F7
					(gGame restore:)
					(event claimed: 1)
				)
				(KEY_F5
					(gGame save:)
					(event claimed: 1)
				)
				(KEY_ADD
					(if (gUser controls:)
						(= global112 (Max 1 (-- global112)))
						(gGame currentSpeed: global112)
						(gEgo setSpeed: global112)
					)
				)
				(KEY_SUBTRACT
					(if (gUser controls:)
						(++ global112)
						(gGame currentSpeed: global112)
						(gEgo setSpeed: global112)
					)
				)
				($003d ; =
					(if (gUser controls:)
						(= global112 6)
						(gEgo setSpeed: 6)
					)
				)
				(KEY_ALT_l
					((ScriptID 64952) doit:) ; sysLogger
					(event claimed: 1)
				)
				(else
					((ScriptID 99) handleEvent: event) ; debugRm
					((ScriptID 99) dispose:) ; debugRm
					(DisposeScript 99)
				)
			)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((gUser canControl:)
				(if (and script (script handleEvent: event))
					(return 1)
				else
					(if (& (event type:) evVERB)
						(self pragmaFail:)
					)
					(return 1)
				)
			)
		)
	)

	(method (pragmaFail &tmp [temp0 3])
		((gUser hotCursor:) flashBad:)
	)

	(method (handsOff)
		(gUser canControl: 0 canInput: 0)
		(if isHandsOn
			(= isHandsOn 0)
			((gUser hotCursor:) showWait:)
		)
		(gk2Messager scratch: 0)
	)

	(method (handsOn param1 &tmp temp0)
		(gUser canControl: (and argc param1) canInput: 1)
		(if (not isHandsOn)
			(= isHandsOn 1)
			((gUser hotCursor:) update:)
		)
		(while ((= temp0 (Event new: evMOUSE)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 3])
		(FrameOut)
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
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(if
			(OneOf
				gCurRoomNum
				15001
				15002
				15003
				15004
				15005
				15006
				15007
				15008
				15009
				15010
				15011
				15012
			)
			(gCurRoom refresh:)
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
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while 1
			(switch gQuit
				(0
					(self doit:)
				)
				(1
					(break)
				)
				(2
					(= gQuit 1)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if panelObj
			(= temp1 panelObj)
			(= temp2 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp1 temp2)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if global135
			(gSounds eachElementDo: #check)
			(gTimers eachElementDo: #doit)
		)
		(if gAutoRobot
			(gAutoRobot doit:)
		)
		(if gPanels
			(gPanels eachElementDo: #doit)
		)
		(if global135
			(gCast doit:)
		)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: #motionCue)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(if (and script global135)
			(script doit:)
		)
		(if global135
			(gRegions eachElementDo: #doit)
		)
		(FrameOut)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(if global135
			(gTheDoits doit:)
		)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(if global135
			(gTimers eachElementDo: #delete)
		)
	)

	(method (setCursor param1)
		(cond
			((or (not gUser) (not (gUser hotCursor:)))
				(super setCursor: param1 &rest)
			)
			((== param1 gWaitCursor)
				((gUser hotCursor:) showWait:)
			)
			((== param1 oldCurs)
				((gUser hotCursor:) update:)
			)
			(else
				((gUser hotCursor:) update:)
			)
		)
	)

	(method (disableInventory param1)
		(inventoryButton mask: (or (not argc) param1))
		(curInvView mask: (or (not argc) param1))
	)

	(method (quitGame)
		(if ((ScriptID 27 0) casts:) ; controlPlane
			((ScriptID 27 0) dispose:) ; controlPlane
		)
		(= gQuit
			(Print
				y: 150
				font: 50
				back: 4
				fore: 14
				addTitle: {Thank you for playing!}
				addText: {Are you sure you want to quit?} 0 3
				addButton: 1 { Yes } 55 20
				addButton: 0 { No } 95 20
				init:
			)
		)
		(FrameOut)
	)
)

(instance gk2DoVerbCode of Code
	(properties)

	(method (doit)
		(gGame pragmaFail:)
		(return 0)
	)
)

(instance gk2ApproachCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				(5 1)
				(4 4)
				(62 8)
				(else 32768)
			)
		)
	)
)

(class gk2Messager of Messager
	(properties)

	(method (say)
		(super say: &rest)
	)

	(method (sayRange)
		(super sayRange: &rest)
	)

	(method (findTalker &tmp temp0)
		(return gNarrator)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance gk2Music of Sound
	(properties)
)

(instance gk2Sound of Sound
	(properties)
)

(instance gk2RespondCode of Code
	(properties)

	(method (doit param1)
		(return
			(switch param1
				((respondSet at: 0) 1)
				((respondSet at: 1) 2)
				((respondSet at: 2) 4)
				((respondSet at: 3) 8)
				((respondSet at: 4) 16)
				((respondSet at: 5) 32)
				((respondSet at: 6) 64)
				((respondSet at: 7) 128)
				((respondSet at: 8) 256)
				((respondSet at: 9) 512)
				((respondSet at: 10) 1024)
				((respondSet at: 11) 2048)
				((respondSet at: 12) 4096)
				((respondSet at: 13) 8192)
				((respondSet at: 14) 16384)
				(else 32768)
			)
		)
	)
)

(instance respondSet of Set
	(properties)
)

(instance globalTimer of Timer ; UNUSED
	(properties)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

(instance dummyIconBar of IconBar ; UNUSED
	(properties)
)

(instance interfacePlane of PanelPlane
	(properties
		picture -2
	)

	(method (init)
		(inventoryBorderPlane init:)
		(super init: &rest)
		(inventoryBox init: self)
		(= gCurInvView curInvView)
		(curInvView init: self 1 1)
		(inventoryButton init: self 1 1)
		(movieButton init: self 1 1)
		(recButton init: self 1 1)
		(logo init: self 1 1)
	)

	(method (dispose)
		(inventoryBorderPlane dispose:)
		(super dispose: &rest)
	)

	(method (show)
		(inventoryBorderPlane priority: 202)
		(UpdatePlane inventoryBorderPlane)
		(super show: &rest)
	)

	(method (hide)
		(inventoryBorderPlane priority: -1)
		(UpdatePlane inventoryBorderPlane)
		(super hide: &rest)
	)
)

(instance inventoryBox of PanelView
	(properties
		x 474
		y 9
		view 130
		loop 9
	)
)

(instance inventoryBorderPlane of PanelPlane
	(properties
		picture -2
		priority 202
	)

	(method (init)
		(super init: 4 0 46 351)
		(inventoryBorder init: self)
	)
)

(instance inventoryBorder of PanelView
	(properties
		view 130
		loop 10
	)
)

(instance curInvView of CurrInvItem
	(properties
		sightAngle 180
		x 534
		y 69
		view 135
	)

	(method (init)
		(super init: &rest)
		(gInventory button: self)
	)

	(method (doVerb theVerb)
		(if (== itemNumber -1)
			(InvPrint init:)
		else
			(cond
				((== theVerb 62) ; Do
					(gUser curVerb: verb)
				)
				((not (OneOf (gUser curVerb:) 111 135))
					(gUser curVerb: 62)
				)
			)
			((gUser hotCursor:) update:)
		)
	)

	(method (update param1 &tmp temp0)
		(if (and argc param1)
			(self posn: 476 9)
			(if (= view (param1 view:))
				(= loop (param1 loop:))
				(= cel (param1 cel:))
			else
				(= temp0 (param1 number:))
				(= view 995)
				(= loop (<< (>> temp0 $0004) $0001))
				(= cel (& temp0 $000f))
			)
		else
			(self posn: 534 69)
			(= view 135)
			(= loop (= cel 0))
		)
		(super update:)
	)
)

(instance inventoryButton of PanelButton
	(properties
		x 574
		y 15
		view 130
	)

	(method (mask param1)
		(if (and argc (not param1))
			(= cel 0)
			(= active 1)
		else
			(= cel 3)
			(= active 0)
		)
	)

	(method (doVerb)
		(cond
			(
				(OneOf
					gCurRoomNum
					15001
					15002
					15003
					15004
					15005
					15006
					15007
					15008
					15009
					15010
					15011
					15012
				)
				(= global142 (gCurRoom curDir:))
				(= global143 (gCurRoom roomNum:))
				(if (not (IsFlag 816))
					(SetFlag 816)
					(PlayScene 912)
				)
				(gCurRoom newRoom: 11871)
			)
			((== gCurRoomNum 11871) 0)
			(else
				(InvPrint init:)
			)
		)
	)
)

(instance movieButton of PanelButton
	(properties
		x 574
		y 49
		view 130
		loop 1
	)

	(method (doVerb)
		((ScriptID 36 0) init: 0 0 640 480) ; moviePlane
	)

	(method (mask param1)
		(if (and argc (not param1))
			(= cel 0)
			(= active 1)
		else
			(= cel 3)
			(= active 0)
		)
	)
)

(instance recButton of PanelButton
	(properties
		x 574
		y 83
		view 130
		loop 7
	)

	(method (highlight)
		(= loop (if (== gEgo GraceEgo) 7 else 2))
		(super highlight: &rest)
	)

	(method (mask param1)
		(if (and argc (not param1))
			(= cel 0)
			(= active 1)
		else
			(= cel 3)
			(= active 0)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (== gChapter 6)
				(return)
			)
			(cond
				((== gEgo GraceEgo)
					(gCurRoom setInset: Notebook)
				)
				((gEgo has: 6) ; invTapeRecorder
					(gCurRoom setInset: Walkman)
				)
				(else
					(return)
				)
			)
		else
			(return)
		)
	)
)

(instance mapHintButton of PanelButton
	(properties
		x 574
		y 15
		view 130
		loop 16
	)

	(method (doVerb)
		(gCurRoom hintMode:)
	)
)

(instance logo of PanelButton
	(properties
		view 130
		loop 8
	)

	(method (doVerb)
		(if (not (OneOf gCurRoomNum 200 800)) ; MunichMapRm, bavMapRm
			((ScriptID 27 0) init:) ; controlPlane
		)
	)
)

