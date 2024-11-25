;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use n098)
(use Interface)
(use SpeakWindow)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	MG 0
	NormalEgo 1
	HandsOff 2
	HandsOn 3
	HaveMem 4
	RedrawCast 5
	clr 6
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
	gShowStyle = 7
	gAniInterval
	gTheCursor
	; 20
	gNormalCursor = 999
	gWaitCursor = 997
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gModelessDialog
	gBigFont = 1
	gVolume = 14
	gVersion = {ego}
	gLocales
	; 30
	gCurSaveDir
	global31
	global32
	global33
	global34
	; 35
	global35
	global36
	global37
	global38
	global39
	; 40
	global40
	global41
	global42
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	gAniThreshold = 10
	gPerspective
	gFeatures
	gSortedFeatures
	global54
	; 55
	global55
	global56
	global57 = -1
	global58
	gSpeakWindow
	; 60
	global60 = 40
	global61 = 189
	global62 = 319
	global63
	global64 = 4
	; 65
	global65
	global66
	global67
	global68
	global69
	; 70
	global70
	global71
	global72
	gSync
	global74
	; 75
	global75
	global76 = 3
	global77
	global78
	global79
	; 80
	global80
	global81
	global82
	global83
	global84
	; 85
	global85
	global86
	global87
	global88
	global89
	; 90
	global90
	global91
	global92
	global93
	global94
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	global100
	global101
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
	global118
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
	global134
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
	global176 = 1
	global177 = 1
	global178
	gSaveSlot
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

(procedure (NormalEgo param1 param2)
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
		illegalBits: $8000
		ignoreActors: 0
	)
)

(procedure (HandsOff)
	(User canControl: 0)
	(gEgo setMotion: 0)
	(TheMenuBar state: 0)
	(= global103 1)
)

(procedure (HandsOn)
	(= global104 0)
	(User canControl: 1)
	(TheMenuBar state: 1)
	(= global103 0)
)

(procedure (HaveMem param1) ; UNUSED
	(return (> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (RedrawCast) ; UNUSED
	(Animate (gCast elements:) 0)
)

(procedure (clr)
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
	(if global129
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

(procedure (proc0_18 param1 param2)
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
	(if (> global125 3)
		(DoSound sndMASTER_VOLUME (- global125 3))
	else
		(DoSound sndMASTER_VOLUME 0)
	)
	(= global104 1)
	(Load rsCURSOR 69)
)

(procedure (proc0_12 param1 &tmp temp0)
	(if (> global169 100)
		(-= global169 100)
	)
	(for
		((= temp0 0))
		(and (< temp0 5) (!= [global250 temp0] global169))
		((++ temp0))
	)
	(if (== (+= temp0 param1) 5)
		(= temp0 0)
	)
	(= global169 [global250 temp0])
	(cond
		((mod global114 2)
			(+= global169 100)
			(if (!= (DoAudio audLANGUAGE global169) global169)
				(-= global169 100)
				(if (!= (DoAudio audLANGUAGE global169) global169)
					(return (proc0_12 1))
				)
			)
		)
		((!= (DoAudio audLANGUAGE global169) global169)
			(return (proc0_12 1))
		)
	)
	(return temp0)
)

(instance ego of Body
	(properties)

	(method (init)
		(= view global114)
		(super init:)
	)
)

(instance gControls of Controls
	(properties)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

(instance MG of Game
	(properties)

	(method (init)
		(= gStdWalkIn stdWalkIn)
		(= gStdWalkOut stdWalkOut)
		(= global145 stdClimbIn)
		(= gStdClimbOut stdClimbOut)
		(= gPlace place)
		(= gEgo ego)
		(= gLongSong longSong)
		(= gGControls gControls)
		(= gInvBut invBut)
		(= gVersion {0.0arf})
		(super init:)
		(= gSpeakWindow SpeakWindow)
		((ScriptID 600) init:) ; Goals
		(TheMenuBar init: state: 1)
		(gLongSong owner: gGame init:)
		(gControls
			window: 0
			add: speedBut soundBut stopBut lipsBut mapBut invBut
		)
		(proc98_0)
		(if (GameIsRestarting)
			(self newRoom: 104) ; night
		else
			(self newRoom: 99) ; intro
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
				(DoAudio audPLAY 34)
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
				(+= gScore 1)
			)
			(SetPort global124)
		)
	)

	(method (replay)
		(MemorySegment 1 @global190) ; MS_RESTORE_TO
		(= global170 (StrAt @global190 0))
		(= global157 (- (StrAt @global190 1) 32))
		(StrAt gCurSaveDir 0 (- (StrAt @global190 2) 1))
		(= gSaveSlot (- (StrAt @global190 3) 32))
		(DoAudio audLANGUAGE global169)
		(super replay:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= global248 (+ (GetTime) gSpeed -1))
		(= temp0 (HaveMouse))
		(= temp3 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
		(if (not global107)
			(cond
				(global104
					(= global105 69)
				)
				((== (User controls:) 0)
					(= temp0 1)
					(= global105 900)
				)
				((> (temp3 x:) 261)
					(if
						(or
							(speedBut check: temp3)
							(soundBut check: temp3)
							(stopBut check: temp3)
						)
						(= global105 15)
					else
						(= global105 11)
					)
				)
				((> (temp3 y:) 157)
					(if
						(or
							(lipsBut check: temp3)
							(mapBut check: temp3)
							(invBut check: temp3)
						)
						(= global105 15)
					else
						(= global105 12)
					)
				)
				((< (temp3 x:) 5)
					(= global105 13)
				)
				((< (temp3 y:) 14)
					(= global105 14)
				)
				(else
					(= global105 10)
				)
			)
			(if (and (== gCurRoomNum 45) (!= global105 15) (not global104)) ; mapRoom
				(= global105 10)
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
					(DoAudio audPLAY 30)
				)
				((> temp2 80)
					(= global165 (if (== (global150 view:) 45) 30 else 20))
					(if (> [global200 gCurRoomNum] 47)
						(global150 ignoreActors:)
					)
				)
			)
		)
		(super doit:)
	)

	(method (startRoom roomNum)
		(DisposeScript 985)
		(DisposeScript 986)
		(DisposeScript 97)
		(DisposeScript 101)
		(DisposeScript 102)
		(DisposeScript 103)
		(DisposeScript 602)
		(DisposeScript 601)
		(DisposeScript 403)
		(DisposeScript 605)
		(DisposeScript 979)
		(DisposeScript 400)
		(if gDebugOn
			(= gDebugOn 0)
			(SetDebug)
		)
		(if
			(and
				(u> (MemoryInfo 1) (+ 20 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(| $0001 (Palette palSET_INTENSITY 0 255 100))
				(Print 0 0 #button {Quit} 1) ; "Memory fragmented."
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
		(super startRoom: roomNum)
	)

	(method (handleEvent event &tmp [temp0 5] temp5 temp6 temp7 [temp8 52])
		(if (event claimed:)
			(return)
		)
		(event localize:)
		(gCast handleEvent: event)
		(event globalize:)
		(if (event claimed:)
			(return)
		)
		(if (and (>= gCurRoomNum 1) (<= gCurRoomNum 45)) ; mapRoom
			(gControls handleEvent: event)
		)
		(if (and (== (event type:) evMOUSEBUTTON) global100)
			(event localize:)
			(= temp5 (event x:))
			(= temp6 (event y:))
			(= temp7 (event modifiers:))
		)
		(super handleEvent: event)
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
		nsTop 165
		nsLeft 206
		nsBottom 198
		nsRight 264
		view 801
		loop 3
		sLeft 216
		sRight 250
		sTop 177
		sBottom 193
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 0 type: evVERB)
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
		sLeft 277
		sRight 304
		sTop 64
		sBottom 73
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3)
		(if (== 1 (param1 type:))
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize:)
				(= temp0 (* (/ (= temp0 (param1 y:)) 3) 3))
				(= temp2
					(* (/ (= temp2 (- (= temp2 (+ nsTop 44)) (* cel 3))) 3) 3)
				)
				(if (and value (> temp0 temp2))
					(-- value)
					(self draw:)
				)
				(if (and (< value 15) (< temp0 temp2))
					(++ value)
					(self draw:)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
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
		sTop 164
		sBottom 173
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3)
		(if (== 1 (param1 type:))
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize:)
				(= temp0 (* (/ (= temp0 (param1 y:)) 3) 3))
				(= temp2
					(* (/ (= temp2 (- (= temp2 (+ nsTop 27)) (* cel 3))) 3) 3)
				)
				(if (and value (> temp0 temp2))
					(-- value)
					(self draw:)
				)
				(if (and (< value 15) (< temp0 temp2))
					(++ value)
					(self draw:)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
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
		(DoSound sndMASTER_VOLUME (= global125 (- value 1)))
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
		sLeft 277
		sRight 307
		sTop 10
		sBottom 30
	)

	(method (track param1 &tmp temp0)
		(repeat
			(= param1 (Event new: evPEEK))
			(param1 localize:)
			(if (and (= temp0 (self check: param1)) (< cel 2))
				(++ value)
				(self draw:)
			)
			(if (and (not temp0) (> cel 0))
				(-- value)
				(self draw:)
			)
			(param1 dispose:)
			(breakif (not (StillDown)))
		)
		(= temp0 (if value self else 0))
		(= value 0)
		(self draw:)
		(return temp0)
	)

	(method (doit &tmp temp0)
		(if ((ScriptID 410) draw:) ; stopCh
			(if (and (= temp0 (StrAt gCurSaveDir 0)) (ValidPath gCurSaveDir))
				(if (and (!= temp0 97) (!= temp0 65))
					(StrAt gCurSaveDir 2 0)
				)
				(DisposeScript 410)
				(gGame save:)
			)
			(TheMenuBar state: 0)
			(= gQuit 1)
		)
		(DisposeScript 410)
	)

	(method (draw)
		(= global124 (GetPort))
		(SetPort 0)
		(= cel value)
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
		sLeft 160
		sRight 190
		sTop 177
		sBottom 193
	)

	(method (track param1 &tmp temp0)
		(repeat
			(= param1 (Event new: evPEEK))
			(param1 localize:)
			(if (and (= temp0 (self check: param1)) (< cel 2))
				(++ value)
				(self draw:)
			)
			(if (and (not temp0) (> cel 0))
				(-- value)
				(self draw:)
			)
			(param1 dispose:)
			(breakif (not (StillDown)))
		)
		(= temp0 (if value self else 0))
		(= value 0)
		(self draw:)
		(return temp0)
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
		(= cel value)
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
		(if (not global162)
			(= global162 1)
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
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(gEgo edgeHit: EDGE_NONE)
				(HandsOff)
				(= register (gCurRoom roomToEdge: gPrevRoomNum))
				(= temp5
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp4
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(switch register
					(3
						(= temp0 temp2)
						(= temp1 (+ global61 temp5))
					)
					(2
						(= temp1 temp3)
						(= temp0 (+ global62 temp4))
					)
					(4
						(= temp1 temp3)
						(= temp0 (- global63 temp4))
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
				(HandsOn)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
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
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(HandsOn)
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
				(HandsOff)
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
						(global129 setScript: followOver)
					)
				)
			)
			(2
				(gEgo ignoreActors: 0)
				(HandsOn)
				(client setScript: 0)
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
				(HandsOff)
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
						(global129 setMotion: MoveTo (gEgo x:) (gEgo y:))
					)
				)
			)
			(1
				(HandsOn)
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
				(= register (| (global129 signal:) $bfff))
				(global129
					ignoreActors: 1
					setPri: 0
					setLoop: 1
					illegalBits: 0
					init:
					posn: temp0 temp1
					setMotion: MoveTo temp0 temp2 self
				)
			)
			(1
				(global129
					signal: (& (global129 signal:) register)
					setPri: -1
					setLoop: -1
					illegalBits: $8000
					setMotion: NewFollow gEgo 30 species 0
				)
				(= global166 0)
			)
		)
	)
)

