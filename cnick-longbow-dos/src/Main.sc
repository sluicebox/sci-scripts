;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use RhIconItem)
(use Interface)
(use n802)
(use rhEgo)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use Osc)
(use DCIcon)
(use Window)
(use Sound)
(use Game)
(use User)
(use System)

(public
	RH_Budget 0
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_11 11
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
	gWaitCursor = 997
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
	gTextSpeed = 2
	; 95
	global95
	global96
	global97
	global98
	global99
	; 100
	gRgnMusic
	global101 = 1234
	global102
	global103
	global104
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
	gSFX
	gSFX2
	; 115
	global115
	global116
	global117
	global118 = 1
	global119 = 2
	; 120
	global120 = 1
	global121 = 5
	global122 = 4
	global123
	global124
	; 125
	global125 = 2
	global126
	global127
	global128
	global129
	; 130
	global130 = 1
	global131
	global132
	global133
	global134
	; 135
	global135
	global136
	global137
	global138 = 50
	global139 = 2000
	; 140
	global140
	global141 = 4
	global142
	global143
	global144
	; 145
	global145
	global146
	global147 = 140
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
	global162 = 180
	global163 = 7
	global164
	; 165
	global165
	global166
	global167
	gRgnMusic2
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
	global199 = 1
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
)

(procedure (proc0_2 param1 param2 param3 &tmp temp0 temp1 temp2) ; UNUSED
	(= temp0
		(switch global126
			(1 36)
			(2 29)
			(3 29)
			(4 33)
			(5 23)
			(6 16)
			(else 0)
		)
	)
	(= temp1
		(switch global126
			(1 37)
			(2 30)
			(3 30)
			(4 34)
			(5 24)
			(6 17)
			(else 1)
		)
	)
	(if argc
		(gEgo sel_3: param1)
		(if (> argc 1)
			(= temp0 param2)
			(if (> argc 2)
				(= temp1 param3)
			)
		)
	)
	(= temp2
		(switch (gEgo sel_3:)
			(6 45)
			(0 90)
			(4 135)
			(2 180)
			(5 225)
			(1 270)
			(7 315)
		)
	)
	(gEgo
		sel_2: temp0
		sel_426:
			(if
				(OneOf
					temp0
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
				1
			else
				0
			)
		sel_598: (OneOf global126 3 2)
		sel_596:
			(if
				(OneOf
					temp0
					0
					1
					3
					12
					13
					29
					30
					245
					33
					34
					23
					24
					16
					17
					702
					703
					25
					245
				)
				1
			else
				0
			)
		sel_155: -1
		sel_162: Unknown_Class_82 temp1
		sel_330: 3 2
		sel_15: -32768
		sel_307: 0
		sel_55: temp2
	)
)

(procedure (proc0_3 &tmp temp0)
	(if global143
		(return)
	)
	(= global143 1)
	(User sel_229: 0 sel_339: 0)
	(= temp0 (gTheIconBar sel_214:))
	(= global157 (gEgo sel_53:))
	(= global165 0)
	(gTheIconBar sel_119: 96 checkIcon)
	(gTheIconBar sel_225: 0 1 2 3 4 5 6)
	(gTheIconBar sel_214: temp0)
	(if (HaveMouse)
		(gGame sel_198: gWaitCursor)
	else
		(= global127 ((User sel_338:) sel_1:))
		(= global128 ((User sel_338:) sel_0:))
		(gGame sel_198: gWaitCursor)
		(SetCursor 310 185)
	)
)

(procedure (proc0_4 param1 &tmp temp0 temp1)
	(if global143
		(= global143 0)
		(gGame sel_344: global157)
		(= global157 global141)
		(User sel_229: 1 sel_339: 1)
	)
	(if (and argc param1)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(if (not (& global165 (>> $8000 temp0)))
				(gTheIconBar sel_178: temp0)
			)
		)
	else
		(if (gTheIconBar sel_217:)
			(gTheIconBar sel_178: (gTheIconBar sel_218:))
		)
		(switch gCurRoomNum
			(100
				(gGame sel_198: 720)
			)
			(200 ; povGladeArchery
				(gTheIconBar sel_178: 0 1 4)
			)
			(190
				(gTheIconBar sel_178: 0 1 4)
			)
			(540
				(gTheIconBar sel_178: 0 2)
			)
			(else
				(gTheIconBar sel_178: 0 1 2 3 6)
			)
		)
	)
	(if
		(and
			(not (gTheIconBar sel_217:))
			(== (gTheIconBar sel_214:) (gTheIconBar sel_64: 5))
		)
		(gTheIconBar sel_223:)
	)
	(if (HaveMouse)
		(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
	else
		(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
		(SetCursor global127 global128)
	)
)

(procedure (proc0_5 param1)
	(return (& [global200 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_6 param1 &tmp temp0)
	(= temp0 (proc0_5 param1))
	(= [global200 (/ param1 16)]
		(| [global200 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (proc0_7 param1 &tmp temp0)
	(= temp0 (proc0_5 param1))
	(= [global200 (/ param1 16)]
		(& [global200 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc0_11 param1)
	(User sel_229: 0 sel_339: 1)
	(if argc
		(gGame sel_198: param1)
	)
)

(instance ego of rhEgo
	(properties
		sel_20 {ego}
	)

	(method (sel_110)
		(super sel_110:)
	)

	(method (sel_292 param1)
		(switch param1
			(3
				(Print 0 0) ; "I feel much the same as I did yesterday."
			)
		)
	)
)

(instance rgnMusic of Sound
	(properties
		sel_20 {rgnMusic}
		sel_99 1
		sel_3 -1
	)
)

(instance rgnMusic2 of Sound
	(properties
		sel_20 {rgnMusic2}
		sel_99 1
		sel_3 -1
	)
)

(instance SFX of Sound
	(properties
		sel_20 {SFX}
		sel_99 1
		sel_3 -1
	)
)

(instance SFX2 of Sound
	(properties
		sel_20 {SFX2}
		sel_99 1
		sel_3 -1
	)
)

(instance MH of EventHandler
	(properties
		sel_20 {MH}
	)
)

(instance KH of EventHandler
	(properties
		sel_20 {KH}
	)
)

(instance DH of EventHandler
	(properties
		sel_20 {DH}
	)
)

(instance rhWindow of SysWindow
	(properties
		sel_20 {rhWindow}
	)
)

(instance quitIcon of DCIcon
	(properties
		sel_20 {quitIcon}
		sel_2 903
		sel_236 18
	)

	(method (sel_110)
		((= sel_237 (Osc sel_109:)) sel_110: self 1)
	)
)

(class RH_Budget of Game
	(properties
		sel_20 {RH Budget}
	)

	(method (sel_606 param1)
		(gTheIconBar sel_214: (gTheIconBar sel_64: param1))
		(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
	)

	(method (sel_110 &tmp temp0 temp1)
		(ScriptID 982)
		(proc802_0)
		(= gSystemWindow rhWindow)
		(super sel_110:)
		(= gPMouse PseudoMouse)
		(= gDoVerbCode DoVerbCode)
		(= gFtrInitializer FtrInit)
		((= gMouseDownHandler MH) sel_118:)
		((= gKeyDownHandler KH) sel_118:)
		((= gDirectionHandler DH) sel_118:)
		((= gEgo ego))
		(User sel_333: gEgo)
		(rgnMusic2 sel_167: self sel_110:)
		(rgnMusic sel_167: self sel_110:)
		(SFX sel_167: self sel_110:)
		(SFX2 sel_167: self sel_110:)
		(= gRgnMusic2 rgnMusic2)
		(= gRgnMusic rgnMusic)
		(= gSFX SFX)
		(= gSFX2 SFX2)
		((= gTheIconBar IconBar)
			sel_118:
				(iconWalk sel_33: walkingIcon sel_117:)
				(iconLook sel_33: lookingIcon sel_117:)
				(iconDo sel_33: doingIcon sel_117:)
				(iconTalk sel_33: talkingIcon sel_117:)
				(iconBow sel_33: bow_Icon sel_117:)
				(iconUse sel_33: use_Icon sel_117:)
				(iconControl sel_33: controlIcon sel_117:)
				(iconWhat sel_33: abouterIcon sel_117:)
			sel_119: 110
			sel_119: 202 global184
			sel_214: iconWalk
			sel_218: iconUse
			sel_219: iconWhat
			sel_225:
		)
		(ok sel_203: temp1 sel_202: temp0) ; UNINIT, UNINIT
		(gTheIconBar sel_211: -100 sel_221: -100 sel_178: sel_225: 0 3 5 6 7 4)
		(proc0_11 gWaitCursor)
		(self sel_390: 100)
	)

	(method (sel_62)
		(super sel_62:)
	)

	(method (sel_198 param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(return
			(if (IsObject param1)
				(param1 sel_110:)
				temp0
			else
				(SetCursor param1 0 0)
				temp0
			)
		)
	)

	(method (sel_100)
		(super
			sel_100:
				(if (== gCurRoomNum 97)
					(Print ; "Alas, we sorrow to see you leave us. Mayhap you wish to try your luck again?"
						0
						1
						77
						{QUIT}
						78
						{Farewell, I must go.}
						1
						78
						{Let me tarry here a while longer.}
						0
						79
						quitIcon
						0
						0
					)
				else
					(Print ; "Alas, must you leave the merry greenwood so soon?"
						0
						2
						77
						{QUIT}
						78
						{Farewell, I must go.}
						1
						78
						{Let me tarry here a while longer.}
						0
						79
						quitIcon
						0
						0
					)
				)
		)
	)

	(method (sel_71 &tmp [temp0 32])
		(if gModelessDialog
			(gModelessDialog sel_111:)
			(return 1)
		)
	)

	(method (sel_133 param1 &tmp [temp0 12])
		(if (== (param1 sel_31:) 4)
			(switch (param1 sel_37:)
				(17
					(gGame sel_100:)
					(param1 sel_73: 1)
				)
				(15360
					(cond
						((gGame sel_395:)
							(gGame sel_395: 0)
						)
						((> global103 1)
							(gGame sel_395: 15)
						)
						(else
							(gGame sel_395: 1)
						)
					)
					(param1 sel_73: 1)
				)
				(17152
					(if (!= gCurRoomNum 100)
						(param1 sel_73: 1)
						(wannaQuit sel_57:)
					)
					(param1 sel_73: 1)
					(return)
				)
				(11520
					(= gQuit 1)
					(param1 sel_73: 1)
				)
				(else 0)
			)
		)
		(if (not (param1 sel_73:))
			(super sel_133: param1)
		)
	)
)

(instance iconWalk of RhIconItem
	(properties
		sel_20 {iconWalk}
		sel_2 781
		sel_3 0
		sel_4 0
		sel_33 0
		sel_37 1
		sel_14 65
		sel_199 781
		sel_200 10
	)
)

(instance iconLook of RhIconItem
	(properties
		sel_20 {iconLook}
		sel_2 781
		sel_3 1
		sel_4 0
		sel_33 1
		sel_37 2
		sel_14 65
		sel_199 781
		sel_200 10
	)
)

(instance iconDo of RhIconItem
	(properties
		sel_20 {iconDo}
		sel_2 781
		sel_3 2
		sel_4 0
		sel_33 2
		sel_37 3
		sel_14 65
		sel_199 781
		sel_200 10
	)
)

(instance iconTalk of RhIconItem
	(properties
		sel_20 {iconTalk}
		sel_2 781
		sel_3 3
		sel_4 0
		sel_33 3
		sel_37 5
		sel_14 65
		sel_199 781
		sel_200 10
	)
)

(instance iconBow of RhIconItem
	(properties
		sel_20 {iconBow}
		sel_2 781
		sel_3 4
		sel_4 0
		sel_33 4
		sel_37 10
		sel_14 65
		sel_199 781
		sel_200 10
	)
)

(instance iconUse of RhIconItem
	(properties
		sel_20 {iconUse}
		sel_2 781
		sel_3 6
		sel_4 0
		sel_33 999
		sel_37 4
		sel_14 65
		sel_199 781
		sel_200 10
		sel_201 1
	)
)

(instance iconControl of RhIconItem
	(properties
		sel_20 {iconControl}
		sel_2 781
		sel_3 8
		sel_4 0
		sel_33 999
		sel_14 67
		sel_199 781
		sel_200 10
	)

	(method (sel_179)
		(if (super sel_179: &rest)
			(gTheIconBar sel_102:)
			(proc13_6 0)
			(GameControls sel_207:)
		)
	)
)

(instance iconWhat of RhIconItem
	(properties
		sel_20 {iconWhat}
		sel_2 781
		sel_3 9
		sel_4 0
		sel_33 6
		sel_37 6
		sel_14 3
		sel_199 781
		sel_200 10
	)
)

(instance ok of IconI
	(properties
		sel_20 {ok}
		sel_2 900
		sel_3 3
		sel_4 0
		sel_7 40
		sel_33 999
		sel_14 67
		sel_203 5
	)
)

(instance invLook of IconI ; UNUSED
	(properties
		sel_20 {invLook}
		sel_2 900
		sel_3 2
		sel_4 0
		sel_33 1
		sel_37 2
		sel_203 5
	)
)

(instance invHand of IconI ; UNUSED
	(properties
		sel_20 {invHand}
		sel_2 900
		sel_3 0
		sel_4 0
		sel_33 2
		sel_37 3
		sel_203 5
	)
)

(instance invHelp of IconI ; UNUSED
	(properties
		sel_20 {invHelp}
		sel_2 900
		sel_3 1
		sel_4 0
		sel_33 6
		sel_37 6
		sel_203 5
	)
)

(instance invSelect of IconI ; UNUSED
	(properties
		sel_20 {invSelect}
		sel_2 900
		sel_3 4
		sel_4 0
		sel_33 999
		sel_203 5
	)
)

(instance detailSlider of Slider ; UNUSED
	(properties
		sel_20 {detailSlider}
		sel_2 950
		sel_3 0
		sel_4 1
		sel_7 89
		sel_6 49
		sel_14 128
		sel_502 950
		sel_512 3
	)
)

(instance volumeSlider of Slider ; UNUSED
	(properties
		sel_20 {volumeSlider}
		sel_2 950
		sel_3 0
		sel_4 1
		sel_7 135
		sel_6 49
		sel_14 128
		sel_502 950
		sel_512 15
	)
)

(instance moveSpeedSlider of Slider ; UNUSED
	(properties
		sel_20 {moveSpeedSlider}
		sel_2 950
		sel_3 0
		sel_4 1
		sel_7 181
		sel_6 49
		sel_14 128
		sel_502 950
		sel_511 15
		sel_512 1
	)

	(method (sel_207)
		(if (not (User sel_335:))
			(= sel_14 132)
			(= sel_503 9)
		else
			(= sel_503 0)
			(= sel_14 128)
		)
		(super sel_207: &rest)
	)

	(method (sel_182)
		(if (User sel_335:)
			(super sel_182: &rest)
		)
	)

	(method (sel_210))
)

(instance arcadeSlider of Slider ; UNUSED
	(properties
		sel_20 {arcadeSlider}
		sel_2 950
		sel_3 0
		sel_4 1
		sel_7 227
		sel_6 49
		sel_14 128
		sel_502 950
		sel_511 1
		sel_512 22
	)

	(method (sel_57 param1)
		(if argc
			(cond
				((<= param1 1)
					(= global125 1)
				)
				((<= param1 8)
					(= global125 2)
				)
				((<= param1 15)
					(= global125 3)
				)
				(else
					(= global125 4)
				)
			)
			(return param1)
		else
			(return global125)
		)
	)

	(method (sel_513 &tmp temp0)
		(= temp0
			(switch global125
				(1 1)
				(2 7)
				(3 15)
				(4 22)
			)
		)
		(super sel_513: temp0)
	)
)

(instance iconSave of ControlIcon ; UNUSED
	(properties
		sel_20 {iconSave}
		sel_2 950
		sel_3 2
		sel_4 0
		sel_7 25
		sel_6 26
		sel_14 451
		sel_203 52
	)
)

(instance iconRestore of ControlIcon ; UNUSED
	(properties
		sel_20 {iconRestore}
		sel_2 950
		sel_3 3
		sel_4 0
		sel_7 25
		sel_6 46
		sel_14 451
		sel_203 60
	)
)

(instance iconRestart of ControlIcon ; UNUSED
	(properties
		sel_20 {iconRestart}
		sel_2 950
		sel_3 4
		sel_4 0
		sel_7 25
		sel_6 66
		sel_14 451
		sel_203 42
	)
)

(instance iconQuit of ControlIcon ; UNUSED
	(properties
		sel_20 {iconQuit}
		sel_2 950
		sel_3 5
		sel_4 0
		sel_7 43
		sel_6 86
		sel_14 451
		sel_203 12
	)
)

(instance iconHelp of IconI ; UNUSED
	(properties
		sel_20 {iconHelp}
		sel_2 950
		sel_3 6
		sel_4 0
		sel_7 25
		sel_6 106
		sel_33 6
		sel_37 6
		sel_14 387
		sel_203 4
	)
)

(instance iconAbout of ControlIcon ; UNUSED
	(properties
		sel_20 {iconAbout}
		sel_2 950
		sel_3 8
		sel_4 0
		sel_7 25
		sel_6 86
		sel_14 387
		sel_203 6
	)
)

(instance iconOk of IconI ; UNUSED
	(properties
		sel_20 {iconOk}
		sel_2 950
		sel_3 7
		sel_4 0
		sel_7 43
		sel_6 106
		sel_14 195
		sel_203 34
	)
)

(instance gcWindow of BorderWindow ; UNUSED
	(properties
		sel_20 {gcWindow}
	)

	(method (sel_192 &tmp temp0 temp1)
		(= temp1 -1)
		(self sel_194: 25 sel_195: 26 sel_196: 166 sel_197: 296 sel_60: -1)
		(super sel_192:)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel 950 1 2 0 0 temp1)
		(DrawCel 950 1 2 54 0 temp1)
		(DrawCel 950 1 2 108 0 temp1)
		(DrawCel 950 1 2 162 0 temp1)
		(DrawCel 950 1 2 216 0 temp1)
		(DrawCel 950 1 2 0 47 temp1)
		(DrawCel 950 1 2 54 47 temp1)
		(DrawCel 950 1 2 108 47 temp1)
		(DrawCel 950 1 2 162 47 temp1)
		(DrawCel 950 1 2 216 47 temp1)
		(DrawCel 950 1 2 0 94 temp1)
		(DrawCel 950 1 2 54 94 temp1)
		(DrawCel 950 1 2 108 94 temp1)
		(DrawCel 950 1 2 162 94 temp1)
		(DrawCel 950 1 2 216 94 temp1)
		(DrawCel 950 0 5 146 9 temp1)
		(DrawCel 950 1 1 14 17 temp1)
		(DrawCel 950 1 0 119 50 temp1)
		(DrawCel 950 1 0 165 50 temp1)
		(DrawCel 950 1 0 211 50 temp1)
		(DrawCel 950 0 4 85 33 temp1)
		(DrawCel 950 0 3 128 33 temp1)
		(DrawCel 950 0 2 180 33 temp1)
		(DrawCel 950 0 6 219 33 temp1)
		(Graph grUPDATE_BOX 0 0 (+ 94 (CelHigh 950 1 2)) (+ 216 (CelWide 950 1 2)) 1)
		(PicNotValid temp0)
	)
)

(instance invWindow of InsetWindow ; UNUSED
	(properties
		sel_20 {invWindow}
		sel_60 -1
	)

	(method (sel_111)
		(super sel_111: &rest)
		(proc13_7)
	)
)

(instance DoVerbCode of Code
	(properties
		sel_20 {DoVerbCode}
	)

	(method (sel_57 param1)
		(switch param1
			(2
				(Print 0 3) ; "I see nothing of interest."
			)
			(3
				(if (!= gCurRoomNum 130)
					(Print 0 4) ; "I needn't do anything with that."
				)
			)
			(5
				(Print 0 5) ; "There is no answer."
			)
			(10
				(Print 0 6) ; "I've no need to shoot at that."
			)
			(4
				(Print 0 7) ; "That would serve no purpose."
			)
		)
	)
)

(instance FtrInit of Code
	(properties
		sel_20 {FtrInit}
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (== (param1 sel_293:) 26505)
			(param1 sel_293: 90)
		)
		(if (== (param1 sel_291:) 26505)
			(param1 sel_291: 0)
		)
		(cond
			((or (param1 sel_1:) (param1 sel_0:) (param1 sel_82:)))
			((not (IsObject (= temp0 (param1 sel_294:))))
				(param1 sel_1: (/ (+ (param1 sel_7:) (param1 sel_9:)) 2))
				(param1 sel_0: (param1 sel_6:))
			)
			(else
				(= temp8 (= temp9 0))
				(= temp6 (= temp7 32767))
				(= temp2 (temp0 sel_87:))
				(= temp1 0)
				(= temp3 (* 4 (temp0 sel_86:)))
				(while (< temp1 temp3)
					(= temp4 (Memory memPEEK (+ temp2 temp1)))
					(= temp5 (Memory memPEEK (+ temp2 temp1 2)))
					(if (<= temp4 temp6)
						(= temp6 temp4)
					)
					(if (<= temp5 temp7)
						(= temp7 temp5)
					)
					(if (>= temp4 temp8)
						(= temp8 temp4)
					)
					(if (>= temp5 temp9)
						(= temp9 temp5)
					)
					(+= temp1 4)
				)
				(param1 sel_1: (/ (+ temp6 temp8) 2))
				(param1 sel_0: temp7)
			)
		)
	)
)

(instance checkIcon of Code
	(properties
		sel_20 {checkIcon}
	)

	(method (sel_57 param1)
		(if (and (param1 sel_114: IconI) (& (param1 sel_14:) $0004))
			(|= global165 (>> $8000 (gTheIconBar sel_132: param1)))
		)
	)
)

(instance walkingIcon of Cursor
	(properties
		sel_20 {walkingIcon}
		sel_2 942
		sel_3 1
	)
)

(instance lookingIcon of Cursor
	(properties
		sel_20 {lookingIcon}
		sel_2 942
		sel_3 1
		sel_4 1
	)
)

(instance doingIcon of Cursor
	(properties
		sel_20 {doingIcon}
		sel_2 942
		sel_3 1
		sel_4 2
	)
)

(instance talkingIcon of Cursor
	(properties
		sel_20 {talkingIcon}
		sel_2 942
		sel_3 1
		sel_4 3
	)
)

(instance bow_Icon of Cursor
	(properties
		sel_20 {bow_Icon}
		sel_2 4
	)
)

(instance use_Icon of Cursor
	(properties
		sel_20 {use_Icon}
		sel_2 781
		sel_3 6
	)
)

(instance invItemIcon of Cursor ; UNUSED
	(properties
		sel_20 {invItemIcon}
		sel_2 781
		sel_3 7
	)
)

(instance controlIcon of Cursor
	(properties
		sel_20 {controlIcon}
		sel_2 781
		sel_3 8
	)
)

(instance abouterIcon of Cursor
	(properties
		sel_20 {abouterIcon}
		sel_2 781
		sel_3 9
	)
)

(instance invisoCursor of Cursor ; UNUSED
	(properties
		sel_20 {invisoCursor}
		sel_2 942
	)
)

(instance wannaQuit of Code
	(properties
		sel_20 {wannaQuit}
	)

	(method (sel_57 &tmp temp0)
		(if global199
			(= temp0 gTheCursor)
			(proc0_11 720)
			(cond
				((== gCurRoomNum 200) ; povGladeArchery
					(if (Print 0 8 78 {Yes} 1 78 {No} 0) ; "Are you sure you wish to leave the glade?"
						(proc0_3)
						(gGame sel_198: gWaitCursor)
						(gCurRoom sel_390: 100)
					else
						(gGame sel_198: temp0)
					)
				)
				((Print 0 9 78 {Yes} 1 78 {No} 0) ; "Are you sure you wish to leave the game?"
					(proc0_3)
					(gGame sel_198: gWaitCursor)
					(gCurRoom sel_390: 100)
				)
				(else
					(gGame sel_198: temp0)
				)
			)
		)
	)
)

