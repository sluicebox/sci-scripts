;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use VCycle)
(use SaveManager)
(use n1111)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Messager)
(use Talker)
(use Feature)
(use Cursor)
(use Timer)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Scary 0
	SetFlag 1
	ClearFlag 2
	IsFlag 3
	proc0_4 4
	takeLastStep 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	lookIcon 9
	fastForward 10
	overlayPlane 11
	exitButt 14
	globalDisplay 15
	globalTimer 16
	proc0_17 17
	helpIcon 18
	intHSCode 19
	proc0_20 20
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
	global105
	gChapter
	global107
	global108
	gInvCursor
	; 110
	global110
	global111
	global112 = 160
	global113 = 153
	global114
	; 115
	global115
	global116
	gGSound2
	global118
	global119
	; 120
	gCurrentControl
	global121
	gPInvHoles
	gTheControlList
	global124
	; 125
	global125
	global126 = 4
	global127 = 12
	global128 = 8
	global129
	; 130
	global130 = 6
	global131 = 10
	global132 = 2
	global133 = 14
	global134 = 7
	; 135
	global135 = 9
	global136 = 5
	global137 = 11
	global138 = 3
	global139 = 13
	; 140
	global140 = 1
	global141 = 15
	global142 = 3
	global143 = 14
	global144 = 6
	; 145
	global145 = 12
	global146
	global147 = 10
	global148 = 4
	global149 = 8
	; 150
	global150 = 2
	global151 = 9
	global152 = 5
	global153 = 11
	global154 = 1
	; 155
	global155 = 13
	global156 = 7
	global157 = 15
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
	gPhonoSound
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
	gVideoSpeed
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
	global187 = 15
	global188 = 127
	global189
	; 190
	global190
	gSaveManager
	global192
	global193
	gInterfaceHotCast
	; 195
	global195
	global196
	global197
	global198
	global199
	; 200
	global200 = -1
	global201
	global202
	global203 = -1
	global204
	; 205
	global205
	global206
	global207
	gTextHelp
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
	global227 = 200
	global228
	global229
	; 230
	gGDacSound
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
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: (ScriptID 0 11)) ; overlayPlane
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(procedure (SetFlag param1)
	(if (and (== param1 121) (global116 contains: fastForward))
		(fastForward dispose:)
	)
	(if (and (== param1 248) (controlPanelButton scratch:))
		(controlPanelButton setHotspot: 0)
	)
	(= [global250 (/ param1 16)]
		(| [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (ClearFlag param1)
	(if
		(and
			(== param1 121)
			gCurRoom
			(gCurRoom script:)
			(global116 size:)
			(not (global116 contains: fastForward))
		)
		(fastForward init: global116)
	)
	(if (== param1 248)
		(controlPanelButton setHotspot: 4 3) ; Do, Move
	)
	(= [global250 (/ param1 16)]
		(& [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (IsFlag param1)
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_7 param1 param2 param3)
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc0_8 param1 param2)
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (proc0_4 param1 param2 param3 &tmp temp0 temp1) ; UNUSED
	(= temp1 (if (== argc 3) param3 else 0))
	(= temp0 (GetAngle (param1 x:) (param1 y:) (param2 x:) (param2 y:)))
	(cond
		((> (Abs (- temp0 (gEgo heading:))) 23)
			(param1 setHeading: temp0 temp1)
		)
		(temp1
			(temp1 cue:)
		)
	)
)

(procedure (proc0_6 param1)
	(return (or global207 (InRect 0 0 292 129 param1)))
)

(procedure (proc0_20)
	(if (Robot 6) ; Exists
		(Robot 10) ; Pause
	)
	(if (IsFlag 145)
		(Print mode: 1 addText: 0 0 0 2 0 0 0 init:) ; "If you quit now you'll have to start your chase over again."
	else
		(Print mode: 1 addText: 0 0 0 6 0 0 0 init:) ; "If you quit now you will have to restore back to your last bookmark."
	)
	(Print
		mode: 1
		addText: 0 0 0 3 0 0 0 ; "Are you sure you want to quit?"
		addButton: 1 0 0 0 4 0 11 1 0 ; MISSING MESSAGE
		addButton: 0 0 0 0 5 0 26 1 0 ; MISSING MESSAGE
		init:
	)
)

(procedure (proc0_17 param1 &tmp temp0)
	(= temp0 1)
	(switch param1
		(1
			(if (not (gGame script:))
				(= global197 0)
			else
				(= temp0 0)
			)
			(if (not (gCurRoom script:))
				(= global195 0)
			else
				(= temp0 0)
			)
			(if temp0
				(if (gTimers contains: textTimer1)
					(textTimer1 dispose: delete:)
				)
				(if (display1 text:)
					(display1 dispose: 1 text: 0)
				)
			else
				(textTimer1 setTicks: textTimer1 240)
			)
		)
		(2
			(if (display2 text:)
				(display2 dispose: 1 text: 0)
			)
		)
		(3
			(if (not (gEgo robot:))
				(= global198 0)
			else
				(= temp0 0)
			)
			(if (< (gEgo view:) 16)
				(= global200 -1)
			else
				(= temp0 0)
			)
			(if temp0
				(if (gTimers contains: textTimer3)
					(textTimer3 dispose: delete:)
				)
				(if (display3 text:)
					(display3 dispose: 1 text: 0)
				)
			else
				(textTimer3 setTicks: textTimer3 240)
			)
		)
		(4
			(if (not (gEgo script:))
				(= global196 0)
			)
			(if (display4 text:)
				(display4 dispose: 1 text: 0)
			)
		)
		(5
			(if (gTimers contains: globalTimer)
				(globalTimer dispose: delete:)
			)
			(if (globalDisplay text:)
				(globalDisplay dispose: 1 text: 0)
			)
		)
		(0
			(gTimers eachElementDo: #dispose)
			(gTimers eachElementDo: #delete)
			(if (globalDisplay text:)
				(globalDisplay dispose: 1 text: 0)
			)
			(if (display1 text:)
				(display1 dispose: 1 text: 0)
			)
			(if (display2 text:)
				(display2 dispose: 1 text: 0)
			)
			(if (display3 text:)
				(display3 dispose: 1 text: 0)
			)
			(if (display4 text:)
				(display4 dispose: 1 text: 0)
			)
			(= global198 0)
			(= global200 -1)
			(= global196 0)
			(= global195 0)
			(= global197 0)
			(= global199 0)
		)
	)
)

(instance overlayPlane of Plane
	(properties)
)

(instance interfaceCast of Cast
	(properties)
)

(instance gameHotCast of Cast
	(properties)
)

(instance interfaceHotCast of Cast
	(properties)
)

(instance egoViewList of List
	(properties)
)

(instance doResCheck of Code
	(properties)

	(method (doit param1)
		(proc1111_14 128 (param1 view:))
	)
)

(instance gDacSound of Sound
	(properties)
)

(instance gSound1 of Sound
	(properties)
)

(instance gSound2 of Sound
	(properties)
)

(instance phonoSound of Sound
	(properties)
)

(instance intHSCode of Code
	(properties)

	(method (doit param1)
		(if (and argc param1)
			(gInventory eachElementDo: #setHotspot 0)
			(controlPanelButton setHotspot: 0)
			(if (global116 contains: exitButt)
				(exitButt setHotspot: 0)
			)
			(gTheControlList eachElementDo: #setHotspot 0)
		else
			(gInventory eachElementDo: #setHotspot 4 3)
			(controlPanelButton setHotspot: 4 3) ; Do, Move
			(if (global116 contains: exitButt)
				(exitButt setHotspot: 4 3) ; Do, Move
			)
			(gTheControlList
				eachElementDo:
					#setHotspot
					4
					3
					0
					8
					6
					7
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					22
					23
					25
					26
					27
					28
					34
					37
					35
			)
		)
	)
)

(class ScaryRoom of Room
	(properties
		stepSound 0
		baseView 7000
		intensity 100
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== modNum -1) (== (= modNum (gCurRoom modNum:)) -1))
			(= modNum gCurRoomNum)
		)
		(return
			(if
				(and
					(ResCheck rsMESSAGE modNum)
					(Message msgGET modNum noun theVerb case 1)
				)
				(gMessager say: noun theVerb case 0 0 modNum)
				1
			else
				0
			)
		)
	)

	(method (init)
		(if
			(or
				(not (interfaceCast size:))
				(not (interfaceCast contains: lookIcon))
			)
			(gTheControlList eachElementDo: #init interfaceCast)
			(gInventory eachElementDo: #init interfaceCast)
			(gPInvHoles eachElementDo: #plane overlayPlane)
			(gPInvHoles eachElementDo: #init)
			(controlPanelButton init:)
		)
		(super init:)
		(self loadEgoViews:)
	)

	(method (loadEgoViews &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(and
				(gCast contains: gEgo)
				(OneOf (gEgo view:) 0 1 2 3 4 5 6 7)
				(= temp4 (Collect new:))
			)
			(for ((= temp0 0)) (< temp0 (global160 size:)) ((++ temp0))
				(= temp1 (global160 at: temp0))
				(cond
					(
						(or
							(>
								(= temp2
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(temp1 approachX:)
										(temp1 approachY:)
									)
								)
								338
							)
							(< temp2 24)
						)
						(= temp3 (+ 7003 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 23 temp2 69)
						(= temp3 (+ 7006 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 68 temp2 115)
						(= temp3 (+ 7000 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 114 temp2 160)
						(= temp3 (+ 7004 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 159 temp2 205)
						(= temp3 (+ 7002 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 204 temp2 250)
						(= temp3 (+ 7005 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
					((< 249 temp2 295)
						(= temp3 (+ 7001 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(Load rsVIEW temp3)
						)
					)
					(else
						(= temp3 (+ 7007 (* (gEgo view:) 100)))
						(if (not (egoViewList contains: temp3))
							(egoViewList add: temp3)
							(temp4 add: temp3)
							(Load rsVIEW temp3)
						)
					)
				)
			)
			(for ((= temp0 0)) (< temp0 (egoViewList size:)) ((++ temp0))
				(= temp1 (egoViewList at: temp0))
				(if (not (temp4 contains: temp1))
					(egoViewList delete: temp1)
				)
			)
			(temp4 release: dispose:)
		)
	)

	(method (drawPic param1)
		(if (not (IsFlag 357))
			(proc0_17 5)
		)
		(if (== style -1)
			(= style 0)
		)
		(super drawPic: param1 &rest)
		(self overlay:)
	)

	(method (overlay)
		(if (not global121)
			(= global121 1)
			(gThePlane setRect: 13 11 305 140)
			(overlayPlane drawPic: 900)
		)
	)

	(method (setInset param1 param2 param3 param4)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
					(if (>= argc 4) param4 else 0)
			)
		)
		(ClearFlag 64)
	)

	(method (dispose)
		((ScriptID 30) dispose:) ; FidgetCode
		(= global163 0)
		(ClearFlag 362)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 91) ; saveRest
			(global116 eachElementDo: #setHotspot 0)
			(global116 release:)
		)
		(global160 release:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (reflectPosn))

	(method (setScript param1)
		(if argc
			(cond
				(param1
					(if
						(and
							(not (IsFlag 121))
							(not (global116 contains: fastForward))
						)
						(fastForward init: global116)
					)
				)
				((global116 contains: fastForward)
					(fastForward dispose:)
				)
			)
			(super setScript: param1 &rest)
		else
			(if (global116 contains: fastForward)
				(fastForward dispose:)
			)
			(super setScript:)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit: &rest)
		(if
			(and
				(not script)
				(not global207)
				(not (CueObj client:))
				(global116 contains: fastForward)
			)
			(fastForward dispose:)
		)
		(if (and (IsFlag 338) (not (-- global227)))
			(= global227 200)
			(gCast eachElementDo: #perform doResCheck)
		)
		(if (and (> gCurRoomNum 999) (IsFlag 47))
			(= temp1 0)
			(= temp0 (Str new: 250))
			(cond
				(
					(and
						(gGame script:)
						(or
							(not (display1 text:))
							(!= global197 (gGame script:))
						)
					)
					(= global197 (gGame script:))
					(temp0 format: {theGame script: %s} (global197 name:))
					(= temp1 1)
				)
				(
					(and
						(not (gCurRoom script:))
						(display4 text:)
						(not (gEgo script:))
					)
					(proc0_17 4)
				)
				(
					(and
						(gEgo script:)
						(or
							(not (display4 text:))
							(!= global196 (gEgo script:))
						)
					)
					(= global196 (gEgo script:))
					(temp0 format: {ego script: %s} (global196 name:))
					(= temp1 4)
				)
				(
					(and
						(gCurRoom script:)
						(or
							(not (display1 text:))
							(!= global195 (gCurRoom script:))
						)
					)
					(= global195 (gCurRoom script:))
					(temp0
						format:
							{%s script: %s}
							(gCurRoom name:)
							(global195 name:)
					)
					(= temp1 1)
				)
				(
					(and
						(or
							(= temp3
								(gFeatures firstTrue: #onMe gMouseX gMouseY)
							)
							(= temp3 (gCast firstTrue: #perform findObj))
						)
						(!= global199 temp3)
					)
					(= global199 temp3)
					(temp0 format: {onMe: %s} (global199 name:))
					(= temp1 2)
				)
				((and (gEgo robot:) (!= global198 ((gEgo robot:) robot:)))
					(= global198 ((gEgo robot:) robot:))
					(temp0
						format:
							{%s pic: %d robot: %hu}
							(gCurRoom name:)
							(gCurRoom picture:)
							global198
					)
					(= temp1 3)
				)
				(
					(and
						global199
						(not
							(or
								(= temp3
									(gFeatures
										firstTrue: #onMe gMouseX gMouseY
									)
								)
								(= temp3 (gCast firstTrue: #perform findObj))
							)
						)
					)
					(proc0_17 2)
					(= global199 0)
				)
				((and global197 (not (gGame script:)))
					(= global197 0)
					(textTimer1 setTicks: textTimer1 240)
				)
				((and global195 (not (gCurRoom script:)))
					(= global195 0)
					(textTimer1 setTicks: textTimer1 240)
				)
				((and global196 (not (gEgo script:)))
					(= global196 0)
					(proc0_17 4)
				)
				((and global198 (not (gEgo robot:)))
					(= global198 0)
					(textTimer3 setTicks: textTimer3 240)
				)
				((and (!= global200 -1) (!= global203 -1))
					(= global200 -1)
					(= global203 -1)
					(textTimer3 setTicks: textTimer3 240)
				)
				(
					(and
						(not (gEgo robot:))
						(not global198)
						(or (gCurRoom script:) (gEgo script:))
						(or
							(!= (gEgo view:) global203)
							(!= (gEgo cel:) global200)
						)
					)
					(= global200 (gEgo cel:))
					(= global203 (gEgo view:))
					(temp0
						format:
							{%s pic: %d view: %d x: %d y: %d L: %d C: %d }
							(gCurRoom name:)
							(gCurRoom picture:)
							(gEgo view:)
							(gEgo x:)
							(gEgo y:)
							(gEgo loop:)
							(gEgo cel:)
					)
					(= temp1 3)
				)
				((and (not (gEgo script:)) (gCurRoom script:))
					(temp0
						format: {script state: %d} ((gCurRoom script:) state:)
					)
					(= temp1 4)
				)
			)
			(if temp1
				(proc0_17 temp1)
			)
			(switch temp1
				(0)
				(1
					(display1
						text: (KString 8 (temp0 data:)) ; StrDup
						setSize: 250
						plane: overlayPlane
						init: global116
					)
				)
				(2
					(display2
						text: (KString 8 (temp0 data:)) ; StrDup
						setSize: 250
						plane: overlayPlane
						init: global116
					)
				)
				(3
					(display3
						text: (KString 8 (temp0 data:)) ; StrDup
						setSize: 250
						plane: overlayPlane
						init: global116
					)
				)
				(4
					(display4
						text: (KString 8 (temp0 data:)) ; StrDup
						setSize: 250
						plane: gThePlane
						init:
					)
				)
			)
			(temp0 dispose:)
		)
	)
)

(class ScaryCursor of Cursor
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(if (and gCast gTheCursor (not (and global105 (== global206 2))))
			((= temp0 (invisoView new:))
				view: view
				init: (if (== global206 2) global116 else gCast)
			)
		)
	)
)

(instance invisoView of View
	(properties
		scaleX 1
		scaleY 1
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(if (== global206 2)
			(gCast delete: self)
			(gTheDoits add: self)
		)
		(= yStep 2)
	)

	(method (doit)
		(if (not (-- yStep))
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(class Scary of Game
	(properties
		fadeSpeed 100
		intensity 100
	)

	(method (getDisc param1 param2 &tmp temp0 temp1)
		(= gNumCD param1)
		(while (!= -1 (= temp0 (CD 0 param1))) ; Check
			(if (!= temp0 param1)
				(if (and (> argc 1) param2)
					(= temp1 (Str new:))
					(Message msgGET 0 0 0 0 7 (temp1 data:)) ; "Please insert CD #%d then press ENTER to continue."
					(Printf (temp1 data:) param1)
				else
					(= temp1 (Str new:))
					(Message msgGET 0 0 0 0 1 (temp1 data:)) ; "Please insert CD #%d then press ENTER to continue or ESC to return to menu."
					(if (not (Printf (temp1 data:) param1))
						(= temp0 99)
						(temp1 dispose:)
						(break)
					)
				)
			else
				(break)
			)
			(temp1 dispose:)
		)
		(if (== temp0 99)
			(CD 0 0) ; Check
			(= global108 91)
			(gCurRoom newRoom: 900)
		)
		(return temp0)
	)

	(method (doRemap param1)
		(RemapColors param1 &rest)
	)

	(method (setIntensity param1 param2)
		(Palette 2 85 235 param1) ; PalIntensity
		(gEgo setIntensity: param1 0)
		(if (and (> argc 1) param2)
			(FrameOut)
		)
	)

	(method (fade param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp1 (User curEvent:))
		(cond
			((< param1 param2)
				(for
					((= temp0 (+ param1 param3)))
					(<= temp0 param2)
					((+= temp0 param3))
					
					(self setIntensity: temp0 1)
					(temp1 new:)
					(if (& (temp1 type:) evMOUSEKEYBOARD)
						(break)
					)
				)
			)
			((!= param1 param2)
				(for
					((= temp0 (- param1 param3)))
					(>= temp0 param2)
					((-= temp0 param3))
					
					(self setIntensity: temp0 1)
					(temp1 new:)
					(if (& (temp1 type:) evMOUSEKEYBOARD)
						(break)
					)
				)
			)
		)
		(self setIntensity: param2 1)
		(if (and (> argc 3) param4)
			(param4 cue:)
		)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (Str new:))
		(= gSysLogPath (Str new:))
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(egoViewList add: 0)
		(self init:)
		(while 1
			(switch gQuit
				(0
					(self doit:)
				)
				(1
					(break)
				)
				(2
					(if (proc0_20)
						(break)
					else
						(if
							(and
								(Robot 6) ; Exists
								(not (IsFlag 297))
								(not (gCurRoom inset:))
							)
							(Robot 4) ; Play
						)
						(= gQuit 0)
					)
				)
			)
		)
		(proc1111_15)
	)

	(method (masterVolume param1)
		(if argc
			(DoAudio audVOLUME (<< param1 $0003))
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= gWaitCursor theWaitCursor)
		(= gNormalCursor arrowCursor)
		(= gInvCursor invCursor)
		(= global209 0)
		(self setCursor: gWaitCursor 1)
		(Lock rsFONT 2207 1)
		(Lock rsVIEW 9930 1)
		(Lock rsVIEW 9960 1)
		(Lock rsVIEW 9961 1)
		(Lock 140 900 1) ; WAVE
		(Font 1 630 450) ; SetFontRes
		(= gUserFont 2207)
		(= gSmallFont 2207)
		(Print font: gUserFont)
		(SetPalStyleRange 0 54)
		(DoAudio audRATE 22050)
		(super init: &rest)
		(SetFlag 236)
		(if (== (Platform) 1)
			(= temp1 (Str new:))
			(GetConfig {videospeed} temp1)
			(= gVideoSpeed (temp1 asInteger:))
			(temp1 dispose:)
			(= temp1 (Str new:))
			(GetConfig {cpu} temp1)
			(= temp2 (temp1 asInteger:))
			(temp1 dispose:)
			(= temp1 (Str new:))
			(GetConfig {cpuspeed} temp1)
			(= temp3 (temp1 asInteger:))
			(temp1 dispose:)
			(if (and (== temp2 486) (< temp3 30))
				(= gVideoSpeed 400)
			)
		else
			(= gVideoSpeed (GetSierraProfileInt {config} {videospeed} 425))
		)
		(if (> gVideoSpeed 425)
			(SetFlag 127)
		else
			(ClearFlag 127)
		)
		(proc1111_16)
		(PasswordFile init:)
		(if (== (PasswordFile hasPassword:) 3)
			(ClearFlag 63)
		else
			(SetFlag 63)
		)
		(gThePlane setRect: 0 0 319 199 priority: 4)
		(= gSystemPlane Plane)
		(Print fore: 24 back: 0)
		(= gMsgType 2)
		(= gEgo (ScriptID 20 0)) ; ego
		(User alterEgo: gEgo canControl: 1 canInput: 0)
		(= global116 (interfaceCast add:))
		(overlayPlane init: 0 0 319 199 priority: 3 addCast: interfaceCast)
		(interfaceCast plane: overlayPlane)
		((= global160 gameHotCast) add:)
		((= gInterfaceHotCast interfaceHotCast) add:)
		((= gSaveManager SaveManager) init: {phantsg.dir})
		(= gEatMice 6)
		(= gDoVerbCode scaryDVC)
		(= gApproachCode pApproachCode)
		(= gFtrInitializer ftrInit)
		(= gPMouse 0)
		(= gMessager scaryMessager)
		(= gUseSortedFeatures 1)
		(= global103 (DoSound sndGET_POLYPHONY))
		(= gPossibleScore 999)
		(= gUserFont 2207)
		(= gVersion {x.yyy.zzz})
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 10 temp0)
		(FileIO fiCLOSE temp0)
		((= gNarrator scaryNarrator) font: gUserFont fore: 0 back: 49)
		(= gMouseX 160)
		(= gMouseY 100)
		((= gGDacSound gDacSound) flags: 4 owner: self init:)
		((= gGSound1 gSound1) owner: self init:)
		((= gGSound2 gSound2) owner: self init:)
		((= gPhonoSound phonoSound) owner: self)
		(= global118 0)
		(= temp1 (Str newWith: 128 gCurSaveDir))
		(temp1 cat: {21.scr})
		(if (FileIO fiEXISTS (temp1 data:))
			(= gDebugging 1)
		else
			(= gDebugging 0)
		)
		(temp1 dispose:)
		(if (== (Platform) 2)
			(= global105 1)
		)
		((= gTheControlList theControlList) add: lookIcon helpIcon)
		(= gCurrentControl CurrentControl)
		(gCurrentControl select: 3 gNormalCursor)
		((ScriptID 28 0) doit:) ; scaryInvInit
		(= temp1 (Str newWith: 128 gCurSaveDir))
		(temp1 cat: {24.scr})
		(if (FileIO fiEXISTS (temp1 data:))
			(= global108 24)
		else
			(= global108 90)
		)
		(temp1 dispose:)
		(self
			handsOffCode: scaryHandsOffCode
			handsOnCode: scaryHandsOnCode
			newRoom: 33 ; speedRoom
		)
	)

	(method (newRoom &tmp temp0 temp1)
		(gTimers eachElementDo: #dispose)
		(gTimers eachElementDo: #delete)
		(if gDebugging
			((ScriptID 21 0) dispose:) ; debugRm
		)
		(= temp1 (gTheDoits contains: helpIcon))
		(= temp0 (gTheDoits contains: lookIcon))
		(super newRoom: &rest)
		(if temp1
			(gTheDoits add: helpIcon)
		)
		(if temp0
			(gTheDoits add: lookIcon)
		)
		(if (and (not (IsFlag 85)) (>= (- (GetTime 1) global169) 4096)) ; SysTime12
			(SetFlag 85)
		)
		(if
			(and
				(gEgo has: 21) ; invFigurine
				(not (IsFlag 111))
				(>= (- (GetTime 1) global169) 2048) ; SysTime12
			)
			(SetFlag 118)
		)
	)

	(method (startRoom param1 &tmp temp0)
		(if gPMouse
			(gPMouse stop:)
		)
		(if gDebugging
			((ScriptID 21 0) init:) ; debugRm
		)
		(if
			(and
				(OneOf
					((= temp0 (gCurrentControl cursor:)) view:)
					9621
					9631
					9641
					9651
					9661
					9671
					9681
					9691
					9701
					9711
					9721
					9731
					9741
					9751
					9761
					9771
					9781
					9791
					9811
					9821
					9831
					9841
					9861
					9871
				)
				(or (!= (temp0 loop:) 0) (!= (temp0 cel:) 1))
			)
			(temp0 loop: 0 cel: 1)
		)
		(gWaitCursor view: 9960 loop: 7 cel: 0)
		((ScriptID 43) init:) ; soundRegion
		(gRegions add: (ScriptID 43)) ; soundRegion
		(if global184
			((ScriptID 46) init:) ; phonoReg
			(gRegions add: (ScriptID 46)) ; phonoReg
		)
		(if gDebugOn
			(Empty)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID param1)))
		(proc0_17 0)
		(Purge (gCurRoom purge:))
		(= global210 0)
		(gCurRoom init:)
		(= global210 1)
	)

	(method (showControls)
		(SetFlag 64)
		(self setScript: (ScriptID 910 0)) ; controlPanelScr
	)

	(method (save)
		(= global192 0)
		(= global118 0)
		(= global193 0)
		(gSaveManager save: &rest)
	)

	(method (restore)
		(= global192 0)
		(= global118 0)
		(= global193 0)
		(gTheControlList eachElementDo: #init interfaceCast)
		(gInventory eachElementDo: #init interfaceCast)
		(gPInvHoles eachElementDo: #plane overlayPlane)
		(gPInvHoles eachElementDo: #init)
		(controlPanelButton init:)
		(gSaveManager restore: &rest)
	)

	(method (pragmaFail &tmp [temp0 3])
		(if global206
			((ScriptID 26 1) state: 0) ; movieScr
		)
	)
)

(instance theControlList of Set
	(properties)
)

(class ScaryIcon of Prop
	(properties
		sightAngle 360
		hiliteState 0
		enabled 1
		firstView 0
		lastView 0
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(self
			setPri: 254
			ignoreActors: 1
			plane: overlayPlane
			cycleSpeed: (Min (- 10 gHowFast) 4)
		)
		(for ((= temp0 firstView)) (<= temp0 lastView) ((++ temp0))
			(Load rsVIEW temp0)
			(Lock rsVIEW temp0 1)
		)
		(self
			setHotspot:
				4 ; Do
				3 ; Move
				0
				8 ; invLibKey
				6 ; invMoney
				7 ; invNail
				9 ; invNewspaper
				10 ; invPoker
				11 ; invHammer
				12 ; invStairKey
				13 ; invVampBook
				14 ; invMatch
				15 ; invTarot
				16 ; invBrooch
				17 ; invPhoto
				18 ; invLensPiece
				19 ; invDrainCln
				20 ; invCrucifix
				22 ; invBeads
				23 ; invSpellBook
				25 ; invXmasOrn
				26 ; invStone
				27 ; invCutter
				28 ; invDogBone
				34 ; invFigurine
				35 ; ???
				37 ; ???
		)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 firstView)) (<= temp0 lastView) ((++ temp0))
			(Lock rsVIEW temp0 0)
		)
		(gTheDoits delete: self)
		(super dispose: &rest)
	)

	(method (cue)
		(self view: firstView loop: 0 cel: 0 setCycle: 0)
		(UpdateScreenItem self)
		(gTheDoits delete: self)
	)

	(method (setHotspot)
		(super setHotspot: &rest)
		(global160 delete: self)
		(gInterfaceHotCast add: self)
	)

	(method (handleEvent event)
		(if (not cycler)
			(self doit:)
		)
		(cond
			((event claimed:)
				(return 0)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					scratch
				)
				(if
					(and
						(!= (event message:) (scratch theVerb:))
						(not (scratch respondsTo: (event message:)))
					)
					(return 0)
				)
				(self doVerb: (event message:))
				(event claimed: 1)
				(return)
			)
			(else
				(super handleEvent: event)
				(return)
			)
		)
	)

	(method (doit)
		(if enabled
			(cond
				(
					(self
						onMe:
							((gUser curEvent:) x:)
							((gUser curEvent:) y:)
					)
					(if (not hiliteState)
						(self setCycle: VFwd firstView lastView hiliteState: 1)
						(gTheDoits add: self)
					)
				)
				(hiliteState
					(self
						setCycle: 0
						hiliteState: 0
						view: firstView
						loop: 0
						cel: 0
					)
					(gTheDoits delete: self)
				)
			)
			(super doit:)
		)
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
			(if hiliteState
				(self setCycle: 0 hiliteState: 0 view: firstView loop: 0 cel: 0)
				(gTheDoits delete: self)
			)
		else
			(= enabled 1)
		)
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)
)

(instance helpIcon of ScaryIcon
	(properties
		x 31
		y 153
		view 9920
		cycleSpeed 2
		firstView 9920
		lastView 9923
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 3 21 1) ; Move, Exit, ???
			(= theVerb 4) ; Do
		)
		(if (or enabled (> argc 1))
			(self setCycle: 0)
			(= view firstView)
			(= loop (= cel 0))
			(UpdateScreenItem self)
			(gTheDoits delete: self)
			(= temp0 (ScriptID 37)) ; henryHelp
			(if (> argc 1)
				(temp0 init: [theVerb 0] [theVerb 1] [theVerb 2])
			else
				(temp0 init: theVerb)
			)
		else
			(gGame pragmaFail:)
		)
	)
)

(instance lookIcon of ScaryIcon
	(properties
		x 245
		y 153
		view 9925
		firstView 9925
		lastView 9927
	)

	(method (onMe)
		(if (or (not global161) (not enabled))
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (doVerb theVerb)
		(if
			(and
				(not (gCurRoom inset:))
				(!= theVerb 3) ; Move
				global161
				enabled
				(gUser canInput:)
			)
			(intHSCode doit: 1)
			(SetFlag 64)
			(gCurRoom setInset: (ScriptID 1 0) 0 0 (gInventory indexOf: global161)) ; invInset
		else
			(gGame pragmaFail:)
		)
	)

	(method (doit)
		(if (not (gCurRoom inset:))
			(super doit: &rest)
		)
	)
)

(instance controlPanelButton of View
	(properties
		sightAngle 360
		x 145
		y 157
		view 9930
		loop 1
	)

	(method (init)
		(super init: global116)
		(|= signal $1000)
		(self ignoreActors: 1 plane: overlayPlane setPri: 254)
		(gKeyDownHandler add: self)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (setHotspot)
		(super setHotspot: &rest)
		(global160 delete: self)
		(gInterfaceHotCast add: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			((not (self scratch:))
				(gGame pragmaFail:)
			)
			(
				(or
					(IsFlag 248)
					(gCurRoom inset:)
					(not (gUser canInput:))
					(and
						scratch
						(!= theVerb (scratch theVerb:))
						(not (scratch respondsTo: theVerb))
					)
				)
				(gGame pragmaFail:)
			)
			((not (localproc_0 self 1)) 0)
			(
				(and
					(not (IsFlag 248))
					(not (gCurRoom inset:))
					(== theVerb 4) ; Do
					(gUser canInput:)
				)
				(intHSCode doit: 1)
				(gGame showControls:)
			)
			(else
				(gGame pragmaFail:)
			)
		)
	)

	(method (handleEvent event)
		(event globalize:)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evKEYBOARD) (self onMe: event))
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(self doVerb: (gUser message:))
				(event claimed: 1)
				(return)
			)
			(
				(and
					(not (event type:))
					scratch
					(scratch respondsTo: (gUser message:))
				)
				(super handleEvent: event)
			)
		)
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)
)

(instance fastForward of View
	(properties
		sightAngle 360
		x 149
		y 146
		view 9930
	)

	(method (init)
		(super init: global116)
		(if (global116 contains: exitButt)
			(exitButt hide:)
		)
		(self ignoreActors: 1 plane: overlayPlane setPri: 254)
	)

	(method (dispose)
		(if (global116 contains: exitButt)
			(exitButt show:)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			((not (localproc_0 self 1)) 0)
			(global207
				(= global207 0)
				((ScriptID 37 1) dispose:) ; tlkHenry
				(if global206
					((ScriptID 26 1) state: 0) ; movieScr
				)
			)
			((gCurRoom inset:) 0)
			((IsFlag 135)
				(SetFlag 390)
				(proc1111_6 0 0)
				(((gCurRoom script:) script:) dispose:)
				(SetFlag 121)
			)
			((and global206 (== gChapter 7))
				((ScriptID 26 1) state: 0) ; movieScr
			)
			((and global206 (!= gChapter 7)))
			((IsFlag 121)
				(= global115 0)
			)
			((CueObj client:)
				(= global115 1)
				(CueObj state: 0 cue:)
				(return)
			)
			((and (gCurRoom script:) ((gCurRoom script:) script:) (not global115))
				(= global115 1)
				(if (not (IsFlag 139))
					(((gCurRoom script:) script:) changeState: 0)
				)
			)
			((and (gCurRoom script:) (not global115))
				(= global115 1)
				(if (not (IsFlag 139))
					((gCurRoom script:) changeState: 0)
				)
			)
			(
				(and
					(gCurRoom inset:)
					((gCurRoom inset:) script:)
					(((gCurRoom inset:) script:) script:)
					(not global115)
				)
				(= global115 1)
				(if (not (IsFlag 139))
					((((gCurRoom inset:) script:) script:) changeState: 0)
				)
			)
			((and (gCurRoom inset:) ((gCurRoom inset:) script:) (not global115))
				(= global115 1)
				(if (not (IsFlag 139))
					(((gCurRoom inset:) script:) changeState: 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(event globalize:)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evKEYBOARD) (self onMe: event))
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(self doVerb: 3)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(not (event type:))
					scratch
					(scratch respondsTo: (gUser message:))
				)
				(super handleEvent: event)
			)
		)
	)

	(method (hide)
		(if (global116 contains: exitButt)
			(exitButt show:)
		)
		(if (not (global116 contains: self))
			(return)
		else
			(super hide: &rest)
		)
	)

	(method (show)
		(if (global116 contains: exitButt)
			(exitButt hide:)
		)
		(if (not (global116 contains: self))
			(self init: global116)
		else
			(super show: &rest)
		)
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
	)
)

(instance exitButt of View
	(properties
		sightAngle 360
		x 149
		y 146
		view 9930
		loop 2
	)

	(method (init)
		(if (global116 contains: fastForward)
			(fastForward hide:)
		)
		(super init: global116)
		(self ignoreActors: 1 plane: overlayPlane setPri: 254)
		(gGame setCursor: (gCurrentControl cursor:) 1 160 153)
		(gKeyDownHandler add: self)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (setHotspot)
		(super setHotspot: &rest)
		(global160 delete: self)
		(gInterfaceHotCast add: self)
	)

	(method (dispose)
		(super dispose:)
		(if (global116 contains: fastForward)
			(fastForward show:)
		)
		(gKeyDownHandler delete: self)
	)

	(method (doVerb)
		(cond
			((not (self scratch:)) 0)
			((not (localproc_0 self 1)) 0)
			((not (gCurRoom inset:))
				(gCurRoom notify:)
				(self dispose:)
			)
			(else
				(gGame pragmaFail:)
			)
		)
	)

	(method (handleEvent event)
		(event globalize:)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evKEYBOARD) (self onMe: event))
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(self doVerb: 3)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(not (event type:))
					scratch
					(scratch respondsTo: (gUser message:))
				)
				(super handleEvent: event)
			)
		)
	)

	(method (notFacing &tmp temp0)
		(CueObj client: self state: 0 cycles: 0 cue:)
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
				(21 16)
				(30 32)
				(32 64)
				(8 16384)
				(6 16384)
				(7 16384)
				(9 16384)
				(10 16384)
				(11 16384)
				(12 16384)
				(13 16384)
				(14 16384)
				(15 16384)
				(16 16384)
				(17 16384)
				(18 16384)
				(19 16384)
				(20 16384)
				(22 16384)
				(23 16384)
				(25 16384)
				(26 16384)
				(27 16384)
				(28 16384)
				(34 16384)
				(else 32768)
			)
		)
	)
)

(instance scaryDVC of Code
	(properties)

	(method (doit)
		(gGame pragmaFail:)
	)
)

(instance ftrInit of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 global158)
		(if (param1 respondsTo: #cycleSpeed)
			(param1 cycleSpeed: temp0)
		)
		(if (param1 respondsTo: #moveSpeed)
			(param1 moveSpeed: temp0)
		)
		(if (== (param1 sightAngle:) 26505)
			(param1 sightAngle: 25)
		)
		(if (== (param1 actions:) 26505)
			(param1 actions: 0)
		)
		(if
			(and
				(not (param1 x:))
				(not (param1 y:))
				(not (param1 respondsTo: #view))
			)
			(param1
				x:
					(+
						(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
						(param1 nsLeft:)
					)
				y: (param1 nsBottom:)
			)
		)
		(if (and (not (param1 approachX:)) (not (param1 approachY:)))
			(param1 approachX: (param1 x:) approachY: (param1 y:))
		)
	)
)

(instance scaryHandsOffCode of Code
	(properties)

	(method (doit param1 param2)
		(++ global209)
		(cond
			(argc
				(gGame setCursor: gWaitCursor 1 param1 param2)
			)
			((and (not (IsFlag 121)) (proc0_6 (gUser curEvent:)))
				(= global112 (+ ((gUser curEvent:) x:) 12))
				(= global113 (+ ((gUser curEvent:) y:) 10))
				(gGame setCursor: gWaitCursor 1 160 153)
			)
			(else
				(= global112 -99)
				(gGame setCursor: gWaitCursor 1)
			)
		)
		(User canControl: 0 canInput: 0)
		(gTheControlList eachElementDo: #enable 0)
		(gInventory eachElementDo: #enable 0)
		(= global162 1)
	)
)

(instance scaryHandsOnCode of Code
	(properties)

	(method (doit)
		(cond
			((== global112 -99)
				(gGame setCursor: (gCurrentControl cursor:) 0)
			)
			(
				(and
					((gUser curEvent:) globalize:)
					(< 155 ((gUser curEvent:) x:) 165)
					(< 148 ((gUser curEvent:) y:) 158)
				)
				(gGame setCursor: (gCurrentControl cursor:) 0 global112 global113)
			)
			(else
				(gGame setCursor: (gCurrentControl cursor:) 0)
			)
		)
		(User canControl: (if argc 0 else 1) canInput: 1)
		(if gEgo
			(gEgo setSpeed: global158)
		)
		(= global162 1)
		(gTheControlList eachElementDo: #enable 1)
		(if (IsFlag 234)
			(lookIcon enable: 0)
		)
		(gInventory eachElementDo: #enable 1)
		(if global210
			((gUser curEvent:) new:)
			(while ((gUser curEvent:) type:)
				((gUser curEvent:) new:)
			)
			(gUser doit:)
		)
		(gGame setCursor: (gCurrentControl cursor:) 1)
	)
)

(instance takeLastStep of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo cel: 0 setCycle: End self)
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setCycle: 0 cel: (gEgo lastCel:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance arrowCursor of ScaryCursor
	(properties
		view 9960
		cel 1
	)
)

(instance theWaitCursor of ScaryCursor
	(properties
		view 9960
		loop 7
	)
)

(instance invCursor of ScaryCursor
	(properties)
)

(instance scaryNarrator of Narrator
	(properties)
)

(instance scaryMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(99 gNarrator)
					(1 gNarrator)
					(2 gNarrator)
					(3
						(ScriptID 37 1) ; tlkHenry
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

(class CurrentControl of Obj
	(properties
		type 0
		verb 0
		cursor 0
	)

	(method (select param1 param2)
		(= verb param1)
		(= cursor param2)
		(= type 16384)
		(if (== verb 3)
			(|= type $1000)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(event type: (self type:) message: (self verb:))
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event type: (self type:) message: (self verb:))
				)
			)
		)
	)
)

(instance globalTimer of Timer
	(properties)

	(method (cue)
		(proc0_17 5)
	)
)

(instance textTimer1 of Timer
	(properties)

	(method (cue)
		(proc0_17 1)
	)
)

(instance textTimer3 of Timer
	(properties)

	(method (cue)
		(proc0_17 3)
	)
)

(instance globalDisplay of DText
	(properties)
)

(instance display1 of DText
	(properties
		x 12
		y 143
		priority 5
		fixPriority 1
		fore 24
		font 0
	)
)

(instance display2 of DText
	(properties
		x 12
		y 147
		priority 5
		fixPriority 1
		fore 47
		font 0
	)
)

(instance display3 of DText
	(properties
		x 130
		y 143
		priority 5
		fixPriority 1
		fore 24
		font 0
	)
)

(instance display4 of DText
	(properties
		x 1
		y 125
		priority 300
		fixPriority 1
		back 24
		font 0
	)
)

(instance findObj of Code
	(properties)

	(method (doit param1)
		(if (not (param1 isKindOf: DText))
			(param1 onMe: gMouseX gMouseY)
		)
	)
)

(class PasswordFile of File
	(properties
		password 0
		maxChars 20
	)

	(method (init)
		(= scratch (Str with: gCurSaveDir))
		(scratch cat: {BUTTON})
		(= name (scratch data:))
		(scratch data: 0 dispose:)
	)

	(method (setPassword param1 &tmp temp0)
		(= temp0 password)
		(= password (param1 data:))
		(param1 data: temp0 dispose:)
	)

	(method (hasPassword &tmp temp0 temp1 temp2 temp3)
		(if (self readPassword:)
			(= temp0 (Str with: password))
			(temp0 upper:)
			(if scratch
				(= temp3 3)
			else
				(= temp3 2)
			)
			(= scratch 0)
			(= temp1 -1)
			(while (= temp2 (temp0 at: (++ temp1)))
				(if (not (<= 65 temp2 90))
					(= temp3 1)
					(break)
				)
			)
			(self setPassword: temp0)
			(return temp3)
		else
			(return 0)
		)
		(return (temp0 dispose:)) ; UNINIT
	)

	(method (readPassword &tmp temp0 temp1 temp2 temp3)
		(if (self open: 1)
			(= temp0 (Str new: 80))
			(self read: temp0 (+ maxChars 6))
			(self close:)
			(for ((= temp3 (- (temp0 size:) 1))) (> temp3 0) ((-- temp3))
				(temp0
					at:
						temp3
						(^ (^ (temp0 at: temp3) (temp0 at: (- temp3 1))) $0039)
				)
			)
			(temp0 at: 0 (^ (^ (temp0 at: 0) $0093) $0039))
			(if (== (temp0 at: 0) 84)
				(= scratch 1)
			else
				(= scratch 0)
			)
			(if (> (= temp2 (temp0 size:)) 6)
				(= temp1 (temp0 right: (- temp2 6) 0))
				(temp0 dispose:)
				(self setPassword: temp1)
				(return 1)
			else
				(temp0 dispose:)
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (newPassword param1 &tmp temp0 temp1 temp2 temp3)
		(if (IsFlag 63)
			(= temp0 (Str with: {Fpass=}))
		else
			(= temp0 (Str with: {Tpass=}))
		)
		(if argc
			(temp0 cat: param1)
		else
			(if (not password)
				(self readPassword:)
			)
			(= temp1 (Str with: password))
			(temp0 cat: temp1)
			(temp1 dispose:)
		)
		(= temp3 147)
		(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
			(temp0 at: temp2 (^ (^ temp3 (temp0 at: temp2)) $0039))
			(= temp3 (temp0 at: temp2))
		)
		(self open: 2)
		(self write: temp0 (temp0 size:))
		(self close:)
		(temp0 dispose:)
		(if (not argc)
			(return)
		)
		(= temp0 (Str copy: param1))
		(self setPassword: temp0)
	)

	(method (checkPassword param1 &tmp temp0 temp1)
		(if (self readPassword:)
			(= temp0 (Str with: password))
			(= temp1 (param1 compare: temp0))
			(temp0 dispose:)
			(return temp1)
		else
			(Prints {Error: No readable password could be found})
		)
	)

	(method (dispose)
		(if password
			(KString 4 password) ; StrFree
			(= password 0)
		)
		(super dispose: &rest)
	)
)

