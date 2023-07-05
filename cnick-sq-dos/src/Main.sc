;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use Interface)
(use n802)
(use SQEgo)
(use Messager)
(use PseudoMouse)
(use GameControls)
(use BorderWindow)
(use IconBar)
(use n940)
(use RandCycle)
(use DCIcon)
(use Window)
(use Sound)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	sq4 0
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_12 12
	proc0_14 14
	proc0_16 16
	proc0_17 17
	proc0_18 18
	doingIcon 19
	proc0_20 20
	proc0_21 21
	proc0_22 22
	proc0_23 23
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
	gLongSong
	global101 = 1234
	global102
	global103 = 1
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
	gEgoHead
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
	gLongSong2
	; 155
	global155
	global156
	global157
	global158
	global159 = 59
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
	global169 = 2001
	; 170
	global170
	global171
	global172
	global173 = 10
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
	gHiddenCursor
)

(procedure (proc0_2 &tmp temp0)
	(User sel_229: 0 sel_339: 0)
	(gEgo sel_303: 0)
	(gTheIconBar sel_225: 6 1 2 3 4 5 0 7 sel_214: (gTheIconBar sel_64: 0))
	(gGame sel_198: gWaitCursor)
	(if (not (HaveMouse))
		(= global192 ((User sel_338:) sel_1:))
		(= global193 ((User sel_338:) sel_0:))
		(SetCursor 304 172)
	)
	(if gPMouse
		(gPMouse sel_168:)
	)
)

(procedure (proc0_3)
	(User sel_229: 1 sel_339: 1)
	(gTheIconBar sel_178: 0 1 2)
	(gGame sel_198: ((gTheIconBar sel_214:) sel_33:))
	(if (not (HaveMouse))
		(SetCursor global192 global193)
	)
)

(procedure (proc0_6 param1)
	(return (& [global114 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc0_7 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global114 (/ param1 16)]
		(| [global114 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (proc0_8 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global114 (/ param1 16)]
		(& [global114 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc0_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (== argc 1)
		(Display 0 21 dsRESTOREPIXELS [param1 0])
	else
		(= temp4 (= temp5 -1))
		(= temp0 0)
		(= temp1 68)
		(= temp2 69)
		(= temp3 -1)
		(= temp6 global130)
		(= temp7 0)
		(for ((= temp8 1)) (< temp8 argc) ((++ temp8))
			(switch [param1 temp8]
				(27
					(= temp0 [param1 (++ temp8)])
				)
				(30
					(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
				)
				(67
					(= temp3 [param1 (++ temp8)])
				)
				(64
					(= temp4 [param1 (++ temp8)])
					(= temp5 [param1 (++ temp8)])
				)
				(25
					(= temp6 [param1 (++ temp8)])
				)
				(26
					(= temp7 [param1 (++ temp8)])
				)
			)
		)
		(= temp8
			(Display
				[param1 0]
				dsCOORD
				temp4
				temp5
				dsCOLOR
				temp7
				dsWIDTH
				temp3
				dsALIGN
				temp0
				dsFONT
				temp2
				dsSAVEPIXELS
			)
		)
		(Display
			[param1 0]
			dsCOORD
			temp4
			temp5
			dsCOLOR
			temp6
			dsWIDTH
			temp3
			dsALIGN
			temp0
			dsFONT
			temp1
		)
		(return temp8)
	)
)

(procedure (proc0_14 param1 &tmp temp0 [temp1 25] [temp26 100] [temp126 4] temp130)
	(if (!= param1 -1)
		(= global188 param1)
	)
	(StrCpy @temp1 {Space Quest })
	(switch global188
		(1
			(StrCat @temp1 {\1b - The Sarien Encounter})
		)
		(3
			(StrCat @temp1 {\1c - The Pirates of Pestulon})
		)
		(4
			(StrCat @temp1 {\1a - Roger Wilco and The Time Rippers})
		)
		(10
			(StrCat @temp1 {\1e - Latex Babes of Estros})
		)
		(12
			(StrCat @temp1 {\1d - Vohaul's Revenge \1f})
			(= temp0 global148)
		)
	)
	(TextSize @temp126 @temp1 0 -1)
	(StrCpy @temp26 {\06})
	(for
		((= temp130 (/ (- 326 (- [temp126 3] [temp126 1])) 2)))
		(> temp130 0)
		((-- temp130))
		
		(StrCat @temp26 {\06})
	)
	(StrCat @temp26 @temp1)
	(DrawStatus @temp26 0 (proc0_18 global158 global155))
)

(procedure (proc0_16 &tmp temp0 [temp1 2] temp3 temp4 temp5 [temp6 5])
	(= temp3 (gGame sel_198: hiddenCursor))
	(= temp4 (User sel_338:))
	(redX
		sel_1: (temp4 sel_1:)
		sel_0: (+ 300 (temp4 sel_0:))
		sel_82: 300
		sel_207:
	)
	((= temp0 (List sel_109:)) sel_118: redX)
	(Animate (temp0 sel_24:) 1)
	(Animate (gCast sel_24:) 0)
	(= temp5 (GetTime))
	(while (< (Abs (- temp5 (GetTime))) 40)
		(breakif (OneOf ((= temp4 (Event sel_109:)) sel_31:) 4 1))
		(temp4 sel_111:)
	)
	(if (IsObject temp4)
		(temp4 sel_111:)
	)
	(redX sel_102: sel_153: 1000 -1000)
	(Animate (temp0 sel_24:) 1)
	(temp0 sel_81: redX sel_111:)
	(gGame sel_198: temp3)
)

(procedure (proc0_17 param1 param2 param3 &tmp [temp0 500]) ; UNUSED
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp0)
	else
		(StrCpy @temp0 param2)
	)
	(babbleIcon sel_2: param1 sel_236: (* (+ gHowFast 1) 4))
	(if (u< param2 1000)
		(Print @temp0 &rest 79 babbleIcon 0 0)
	else
		(Print @temp0 param3 &rest 79 babbleIcon 0 0)
	)
)

(procedure (proc0_18 param1 param2)
	(if (< param1 0)
		(= param1 0)
	)
	(if (> param1 255)
		(= param1 255)
	)
	(if (< param2 0)
		(= param2 0)
	)
	(if (> param2 15)
		(= param2 15)
	)
	(return (if (proc0_6 21) param1 else param2))
)

(procedure (proc0_4 param1) ; UNUSED
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (proc0_20 param1 &tmp temp0 [temp1 30])
	(Format @temp1 0 23 param1) ; "%s"
	(if (FileIO fiEXISTS @temp1)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc0_21)
	(if (and (!= gCurRoomNum 100) (!= gCurRoomNum 200) (not (GameIsRestarting)))
		(repeat
			(switch
				(if argc
					(Print ; "Select your destination..."
						0
						24
						78
						{ Start Over }
						1
						78
						{ Main Menu }
						2
						78
						{Oops}
						0
						77
						{Restart ??}
						32
						SysWindow
					)
				else
					(Print ; "Select your destination..."
						0
						24
						78
						{ Play Again }
						1
						78
						{ Main Menu }
						2
						77
						{Restart ??}
						32
						SysWindow
					)
				)
				(0
					(if argc
						(break)
					)
				)
				(1
					(gCurRoom sel_390: 200)
					(break)
				)
				(2
					(gGame sel_101:)
					(break)
				)
			)
		)
	)
)

(procedure (proc0_22 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 5])
	(= temp2 (proc0_18 global158 global155))
	(= temp8 14)
	(= temp4 (proc0_18 global130 global130))
	(= temp7 (proc0_18 global161 global130))
	(= temp6 (proc0_18 global157 global156))
	(= temp5 (proc0_18 global156 global156))
	(= temp1 3)
	(= temp9 2)
	(= temp3 3)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) temp3 temp2 temp8)
	(-= param1 temp1)
	(-= param2 temp1)
	(+= param4 temp1)
	(+= param3 temp1)
	(Graph grFILL_BOX param1 param2 (+ param1 temp1) param4 temp3 temp4 temp8)
	(Graph grFILL_BOX (- param3 temp1) param2 param3 param4 temp3 temp5 temp8)
	(for ((= temp10 0)) (< temp10 temp1) ((++ temp10))
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(+ param2 temp10)
			(- param3 (+ temp10 1))
			(+ param2 temp10)
			temp7
			temp8
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(- param4 (+ temp10 1))
			(- param3 (+ temp10 1))
			(- param4 (+ temp10 1))
			temp6
			temp8
		)
	)
	(Graph
		grFILL_BOX
		(+ param1 temp9)
		param4
		(+ param3 temp9)
		(+ param4 temp9)
		temp3
		0
		temp8
	)
	(Graph grFILL_BOX param3 (+ param2 temp9) (+ param3 temp9) param4 temp3 0 temp8)
	(Graph grUPDATE_BOX param1 param2 (+ param3 2) (+ param4 2) 1)
	(SetPort temp0)
)

(procedure (proc0_23 param1)
	(User sel_229: 0 sel_339: 1)
	(if argc
		(gGame sel_198: param1)
	)
)

(instance ego of SQEgo
	(properties
		sel_20 {ego}
		sel_293 180
	)
)

(instance egoHead of Head
	(properties
		sel_20 {egoHead}
		sel_2 4
	)

	(method (sel_292 param1)
		(gEgo sel_292: param1)
	)
)

(instance longSong of Sound
	(properties
		sel_20 {longSong}
		sel_40 1
	)

	(method (sel_39)
		(super sel_39: &rest)
		(self sel_63: 0)
	)
)

(instance longSong2 of Sound
	(properties
		sel_20 {longSong2}
		sel_40 1
	)

	(method (sel_39)
		(super sel_39: &rest)
		(self sel_63: 50)
	)

	(method (sel_168)
		(= sel_3 0)
		(super sel_168: &rest)
	)

	(method (sel_175)
		(DoSound sndUPDATE_CUES self)
		(if (self sel_14:)
			(self sel_166: (self sel_14:) sel_14: 0)
			(cond
				((> (self sel_3:) 1)
					(self sel_3: (- (self sel_3:) 1))
					(DoSound sndPLAY self 0)
				)
				((IsObject sel_42)
					(sel_42 sel_145: self)
				)
			)
		)
	)
)

(instance babbleIcon of DCIcon
	(properties
		sel_20 {babbleIcon}
	)

	(method (sel_110)
		((= sel_237 (RandCycle sel_109:)) sel_110: self 20)
	)
)

(instance sq4KeyDownHandler of EventHandler
	(properties
		sel_20 {sq4KeyDownHandler}
	)
)

(instance sq4MouseDownHandler of EventHandler
	(properties
		sel_20 {sq4MouseDownHandler}
	)
)

(instance sq4DirectionHandler of EventHandler
	(properties
		sel_20 {sq4DirectionHandler}
	)
)

(instance sq4WalkHandler of EventHandler
	(properties
		sel_20 {sq4WalkHandler}
	)
)

(instance sq4 of Game
	(properties
		sel_20 {sq4}
	)

	(method (sel_110 &tmp [temp0 21])
		(= gSystemWindow sq4Win)
		(= gMsgType 0)
		(= gMessager sq4Messager)
		(= gNormalCursor gWaitCursor)
		(proc802_0)
		(DisposeScript 802)
		(= gUseSortedFeatures 1)
		(super sel_110:)
		(= gDoVerbCode sq4DoVerbCode)
		(= gFtrInitializer sq4FtrInit)
		((= gKeyDownHandler sq4KeyDownHandler) sel_118:)
		((= gMouseDownHandler sq4MouseDownHandler) sel_118:)
		((= gDirectionHandler sq4DirectionHandler) sel_118:)
		((= gWalkHandler sq4WalkHandler) sel_118:)
		(= gPMouse PseudoMouse)
		((= gEgo ego) sel_568: (= gEgoHead egoHead) sel_53: 0 sel_236: 0)
		((gEgo sel_568:) sel_42: gEgo)
		(User sel_333: gEgo sel_229: 0 sel_339: 0)
		((= gLongSong longSong) sel_167: self)
		((= gLongSong2 longSong2) sel_167: self)
		(= gHiddenCursor hiddenCursor)
		(= gPossibleScore 315)
		(= gUserFont 4)
		(= gVersion {x.yyy})
		(= global106 (DoSound sndGET_POLYPHONY))
		(if (and (>= (= global105 (Graph grGET_COLOURS)) 2) (<= global105 16))
			(proc0_8 21)
		else
			(proc0_7 21)
		)
		(sq4Win
			sel_25: 0
			sel_26: (proc0_18 global158 global155)
			sel_359: global130
			sel_360: (proc0_18 global161 global130)
			sel_361: (proc0_18 global157 global156)
			sel_362: global156
		)
		(gcWin
			sel_25: 0
			sel_26: (proc0_18 global158 global155)
			sel_359: global130
			sel_360: (proc0_18 global161 global130)
			sel_361: (proc0_18 global157 global156)
			sel_362: global156
		)
		((= gTheIconBar IconBar)
			sel_118:
				(icon0 sel_33: genericCursor sel_117:)
				(icon1 sel_33: lookingIcon sel_117:)
				(icon2 sel_33: doingIcon sel_117:)
				(icon3 sel_33: talkingIcon sel_117:)
				(icon6 sel_33: smellerIcon sel_117:)
				(icon7 sel_33: tasterIcon sel_117:)
				(icon4 sel_33: genericCursor sel_117:)
				(icon5 sel_33: genericCursor sel_117:)
				(icon8 sel_33: genericCursor sel_117:)
				(icon9 sel_33: abouterIcon sel_117:)
			sel_119: 110
			sel_119: 202 0
			sel_119: 203 (proc0_18 global158 global155)
			sel_214: icon0
			sel_220: icon0
			sel_218: icon4
			sel_219: icon9
			sel_225:
		)
		(icon5 sel_37: (if (HaveMouse) 3840 else 9))
		((= gGameControls budgetControls)
			sel_32: gcWin
			sel_118:
				iconOk
				(detailSlider
					sel_340: self
					sel_510: 312
					sel_512: 3
					sel_511: 0
					sel_117:
				)
				(volumeSlider
					sel_340: self
					sel_510: 395
					sel_512: (if (> global106 1) 15 else 1)
					sel_511: 0
					sel_117:
				)
				(speedSlider
					sel_340: gEgo
					sel_510: 236
					sel_512: 1
					sel_511: 15
					sel_117:
				)
				(iconSave sel_340: self sel_510: 75 sel_510: 75 sel_117:)
				(iconRestore sel_340: self sel_510: 76 sel_510: 76 sel_117:)
				(iconRestart sel_340: self sel_510: 101 sel_117:)
				(iconQuit sel_340: self sel_510: 100 sel_117:)
				(iconAbout sel_340: (ScriptID 811 0) sel_510: 57 sel_117:) ; aboutCode
				iconHelp
			sel_119: 202 0
			sel_119: 203 (proc0_18 global157 global156)
			sel_219: iconHelp
			sel_214: iconRestore
		)
		(gTheIconBar
			sel_211: -100
			sel_221: -100
			sel_178:
			sel_225: icon0 icon1 icon2 icon3 icon4 icon5 icon6 icon7 icon8 icon9
		)
		(gTheIconBar sel_225: 0)
		(gGame sel_198: gWaitCursor)
		(self sel_390: 100)
	)

	(method (sel_71))

	(method (sel_62)
		(proc0_14 -1)
		(Palette palSET_INTENSITY 0 255 100)
		(super sel_62:)
	)

	(method (sel_100)
		(babbleIcon sel_2: 946 sel_236: (* (+ gHowFast 1) 4))
		(super
			sel_100:
				(Print ; "See ya on the chronostream, Time Jockey!"
					0
					0
					78
					{Do something of redeeming\nsocial value (Quit)}
					1
					78
					{Changed My Mind.\nLet's Play!}
					0
					79
					babbleIcon
					0
					0
				)
		)
	)

	(method (sel_198 param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(if (IsObject param1)
			(param1 sel_110:)
		else
			(SetCursor param1 0 0)
		)
		(return temp0)
	)

	(method (sel_391 param1)
		((ScriptID 801) sel_57: param1) ; disposeCode
		(if
			(and
				0
				(u> (MemoryInfo 1) (+ 10 (MemoryInfo 0))) ; FreeHeap, LargestPtr
				(!= (- (MemoryInfo 1) 2) (MemoryInfo 0)) ; FreeHeap, LargestPtr
				(Print 0 1 78 {Who cares} 0 78 {Debug} 1) ; "Memory fragmented."
			)
			(SetDebug)
		)
		(if gDebugOn
			(SetDebug)
		)
		(super sel_391: param1)
		(redX sel_110: sel_102: sel_63: 15 sel_153: 1000 -1000)
	)

	(method (sel_133 param1)
		(super sel_133: param1)
		(if (param1 sel_73:)
			(return 1)
		)
		(return
			(switch (param1 sel_31:)
				(4
					(switch (param1 sel_37:)
						(15104
							(requestHelp sel_110:)
							(param1 sel_73: 1)
						)
						(17
							(gGame sel_100:)
							(param1 sel_73: 1)
						)
						(7680
							(if
								(and
									(proc0_20 {volume.dat})
									(> (gGame sel_395:) 0)
								)
								(gGame sel_395: (- (gGame sel_395:) 1))
							)
						)
						(7936
							(if
								(and
									(proc0_20 {volume.dat})
									(< (gGame sel_395:) 15)
								)
								(gGame sel_395: (+ (gGame sel_395:) 1))
							)
						)
						(15360
							(cond
								((gGame sel_395:)
									(gGame sel_395: 0)
								)
								((> global106 1)
									(gGame sel_395: 15)
								)
								(else
									(gGame sel_395: 1)
								)
							)
							(param1 sel_73: 1)
						)
						(17152
							(proc0_21 1)
							(param1 sel_73: 1)
						)
						(11520
							(= gQuit 1)
						)
					)
				)
			)
		)
	)
)

(instance ok of IconI ; UNUSED
	(properties
		sel_20 {ok}
		sel_2 901
		sel_3 3
		sel_4 0
		sel_7 40
		sel_33 999
		sel_14 67
	)

	(method (sel_110)
		(self sel_202: 0 sel_203: (proc0_18 global158 global155))
		(super sel_110:)
	)
)

(instance invLook of IconI ; UNUSED
	(properties
		sel_20 {invLook}
		sel_2 901
		sel_3 2
		sel_4 0
		sel_33 19
		sel_37 1
	)

	(method (sel_110)
		(self sel_202: 0 sel_203: (proc0_18 global158 global155))
		(super sel_110:)
	)
)

(instance invHand of IconI ; UNUSED
	(properties
		sel_20 {invHand}
		sel_2 901
		sel_3 0
		sel_4 0
		sel_33 997
		sel_37 2
	)

	(method (sel_110)
		(self sel_202: 0 sel_203: (proc0_18 global158 global155))
		(super sel_110:)
	)
)

(instance invHelp of IconI ; UNUSED
	(properties
		sel_20 {invHelp}
		sel_2 901
		sel_3 1
		sel_4 0
		sel_33 29
		sel_37 3
	)

	(method (sel_110)
		(self sel_202: 0 sel_203: (proc0_18 global158 global155))
		(super sel_110:)
	)
)

(instance invSelect of IconI ; UNUSED
	(properties
		sel_20 {invSelect}
		sel_2 901
		sel_3 4
		sel_4 0
		sel_33 999
	)

	(method (sel_110)
		(self sel_202: 0 sel_203: (proc0_18 global158 global155))
		(super sel_110:)
	)
)

(instance requestHelp of Obj
	(properties
		sel_20 {requestHelp}
	)

	(method (sel_110 param1 param2 param3 param4)
		(= param3 (gSystemWindow sel_25:))
		(= param4 (gSystemWindow sel_26:))
		(gGame sel_395: 0)
		(super sel_110:)
		(self sel_57: param1 param2 param3 param4)
	)

	(method (sel_57 param1 param2 param3 param4)
		(repeat
			(gSystemWindow sel_25: 0 sel_26: 4)
			(switch
				(= param2
					(PrintD
						{Select...}
						109
						78
						{Game Help}
						1
						109
						78
						{Credits}
						2
						109
						78
						{Sierra}
						4
						109
						78
						{Quit About}
						3
					)
				)
				(1
					(= param1 0)
					(= param3 (gSystemWindow sel_25:))
					(= param4 (gSystemWindow sel_26:))
					(gSystemWindow sel_25: 0 sel_26: 4)
					(repeat
						(switch
							(= param1
								(PrintD
									{Select game to receive help on:}
									109
									78
									{ Ms. Astro Chicken }
									290
									109
									78
									{ Monolith Burger }
									387
									109
									78
									{ Sand Skimmer }
									36
									109
									78
									{ Exit Help }
									417
									77
									{Help}
								)
							)
							(290
								(Print ; "The object of Ms. Astro Chicken is to prevent your chicken from being shot down by the crazed farmer, or being eaten by the rabid dog. You avoid these terrible fates by flying overhead and dropping eggs on the offending pair. You also have a flying weasel to watch out for! To replenish your egg supply, you need to eat the corn when it appears on the screen. You can use a mouse, or a keyboard to control your chicken. With a mouse, Point and click your LEFT mouse button to where you want your chicken to go. Clicking the RIGHT mouse button releases the eggs. With a keyboard, use the ARROW keys to direct your chicken. The ENTER or RETURN keys will release your eggs."
									0
									2
									32
									SysWindow
									27
									1
									77
									{Help on Ms. Astro Chicken}
									78
									{ More }
								)
								(Print ; "Remember that your egg supply is limited. You can run out unless you refill by eating corn! Press the "F9" key to quit."
									0
									3
									32
									SysWindow
									27
									1
									77
									{Help on Ms. Astro Chicken (Con't)}
									78
									{ Done }
								)
							)
							(387
								(Print ; "The object of Monolith Burger Builder is to make complete burgers by putting all the condiments on the patty as it moves down the conveyor belt, and putting a bun on top when it gets to the end. You can put the condiments on in any order, but you MUST make sure to put the bun on last. If your burger isn't complete by the time Master Burger 2000 inspects it, the burger will be rejected and zapped. If you make too many rejects, you'll be fired. To play the game, click the LEFT mouse button on each condiment to pick it up. You can then move the condiment by moving your mouse. To drop the condiment on your burger, click the burger with the condiment icon. Click on the "Instructions" button for more information."
									0
									4
									32
									SysWindow
									27
									1
									77
									{Help on Monolith Burger Builder}
									78
									{ More }
								)
								(Print ; "Using the Keyboard: Use the "Direction" (Arrow) keys on your numeric keypad to position the cursor over the various condiments. Press the "Enter" or "Return" key to pick up the condiment. Then use the "Direction" keys, once again, to position the condiment on the burger. Press the "Enter" or "Return" key to drop the condiment on the burger. Use the "F9" key to quit. Press "R" to activate the "Instructions" button."
									0
									5
									32
									SysWindow
									27
									1
									77
									{Help on Monolith Burger Builder (Con't)}
									78
									{ Done }
								)
							)
							(36
								(Print ; "The object of Sand Skimmer is to move your skimmer across the sand, avoiding the obstacles, as you make your way to Ulence Flats. To play the game, slalom your mouse to either the right of left and then click your mouse button to position your sand skimmer. If you hit any of the smaller rocks, your skimmer will be damaged. The damage meter will indicate how much damage you have taken. Watch out for the large rocks. As the game says, "...they cut you NO slack!""
									0
									6
									32
									SysWindow
									27
									1
									77
									{Help on Sand Skimmer}
									78
									{ More }
								)
								(Print ; "Using a keyboard: To position your Sandskimmer using a keyboard, press either the left or right arrow direction keys on the numeric keypad. To stop your Sandskimmer from moving too far one way or the other, press the same direction key again. Press the "F9" key to quit."
									0
									7
									32
									SysWindow
									27
									1
									77
									{Help on Sand Skimmer (Con't)}
									78
									{ Done }
								)
							)
							(417
								(break 2)
							)
						)
					)
				)
				(2
					(displayCredits sel_57:)
					(break)
				)
				(3
					(gSystemWindow sel_25: 0 sel_26: 52)
					(break)
				)
				(4
					(Print ; "This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
						0
						8
						32
						SysWindow
						27
						1
						77
						{Other great products...}
						78
						{ More }
					)
					(Print ; "...More fun and games. Imagine exploring an entire universe of game fun and action. Sierra's Space Quest series is wild, satirical and insanely brilliant (or is that brilliantly insane?). You'll blast-off with Roger Wilco, sanitation engineer turned swashbuckler, battle bizarre aliens, stumble through a galaxy of spine-tingling suspense and side-splitting mishaps. You'll love every outrageous episode in the Space Quest series."
						0
						9
						32
						SysWindow
						27
						1
						77
						{Other great products...}
						78
						{ Done }
					)
				)
			)
		)
		(gSystemWindow sel_25: 0 sel_26: 4)
		(gGame sel_395: 15)
	)
)

(instance displayCredits of Code
	(properties
		sel_20 {displayCredits}
	)

	(method (sel_57)
		(gSystemWindow sel_25: 50 sel_26: 42)
		(Print 0 10 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Roger Wilco's Spaced Out Game Pack Team: Director: Bill Davis Producers: Tony Caudill Tammy Dargan Software Supervisor: J. Mark Hood"
		(Print 0 11 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Roger Wilco's Spaced Out Game Pack Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 0 12 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco in the Sarien Encounter Team: Executive Producer: Ken Williams Creative Director: Bill Davis Directors: Scott Murphy Douglas Herring"
		(Print 0 13 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Producer: Stuart Moulder Game Designers: Scott Murphy Mark Crowe Art Designer: Douglas Herring"
		(Print 0 14 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Lead Programmer: Jerry Shaw Composer: Ken Allen Animators: Vas Nokhoudian, Nathan Larsen, Arturo Sinclair, Deena Krutak, Desie Hartman, Jerry Jessurun, Russell Truelove, Diana R. Wilson"
		(Print 0 15 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Background Artists: Nathan Larsen, Arturo Sinclair, Suzi Livengood, Eric Kasner, Willis Wong, Jay Friedmann, Jennifer Shontz, Andy Hoyos Programmers: Randy MacNeill, Dave Jamriska, Hugh Diedrichs"
		(Print 0 16 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Music Director: Mark Seibert System Development: Christopher Smith, Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, J. Mark Hood, Mark Wilden, Eric Hart Sound Effects: Mark Seibert, Orpheus Hanley"
		(Print 0 17 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco and the Time Rippers Team: Executive Producer: Ken Williams Creative Director: Bill Davis Producer: Guruka Singh Khalsa Game Designers: Mark Crowe Scott Murphy"
		(Print 0 18 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco and the Time Rippers Team: (Con't) Art Designer: Mark Crowe Lead Programmer: Scott Murphy Music Director: Mark Seibert"
		(Print 0 19 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco and the Time Rippers Team: (Con't) Animators: Jon Bock, Jane Cardinal, Jeff Crowe, Desie Hartman, Eric Kasner, Jim Larsen, Nathan Larsen, Suzi Livengood, Cheryl Loyd, Michael A. Milo, Gerald Moore, Cheryl Sweeney, Willis Wong Background Artists: Jon Bock, Jane Cardinal, Jennifer Shontz, Cheryl Sweeney Programmers: Oliver Breslford, Carlos Escobar, Brian K. Hughes, Mike Larsen, Randy MacNeill, Doug Oldfield, Raoul Said, Jerry Shaw"
		(Print 0 20 77 {Credits} 27 1 78 { Done } 25 50 26 42 32 SysWindow) ; "Original Roger Wilco and the Time Rippers Team: (Con't) System Development: Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, Terry McHenry, John Rettig, Corey Cole, J. Mark Hood, Mark Wilden, Eric Hart, John Hartin Quality Assurance: Mike Harian, Dan Scott"
	)
)

(instance redX of View
	(properties
		sel_20 {redX}
		sel_2 942
		sel_3 1
		sel_4 9
	)
)

(instance icon0 of IconI
	(properties
		sel_20 {icon0}
		sel_2 900
		sel_3 0
		sel_4 0
		sel_33 6
		sel_31 20480
		sel_14 65
		sel_199 900
		sel_200 14
		sel_201 1
	)
)

(instance icon1 of IconI
	(properties
		sel_20 {icon1}
		sel_2 900
		sel_3 1
		sel_4 0
		sel_33 19
		sel_37 1
		sel_14 65
		sel_199 900
		sel_200 14
		sel_201 1
	)
)

(instance icon2 of IconI
	(properties
		sel_20 {icon2}
		sel_2 900
		sel_3 2
		sel_4 0
		sel_33 997
		sel_37 2
		sel_14 65
		sel_199 900
		sel_200 14
	)
)

(instance icon3 of IconI
	(properties
		sel_20 {icon3}
		sel_2 900
		sel_3 3
		sel_4 0
		sel_33 7
		sel_37 4
		sel_14 65
		sel_199 900
		sel_200 14
		sel_201 3
	)
)

(instance icon4 of IconI
	(properties
		sel_20 {icon4}
		sel_2 900
		sel_3 4
		sel_4 0
		sel_33 999
		sel_37 5
		sel_14 65
		sel_199 900
		sel_200 14
		sel_201 4
	)
)

(instance icon5 of IconI
	(properties
		sel_20 {icon5}
		sel_2 900
		sel_3 5
		sel_4 0
		sel_33 999
		sel_31 0
		sel_37 0
		sel_14 67
		sel_199 900
		sel_200 14
		sel_201 2
	)

	(method (sel_179)
		(if (super sel_179:)
			(Inv sel_113: gEgo)
		)
	)
)

(instance icon6 of IconI
	(properties
		sel_20 {icon6}
		sel_2 900
		sel_3 10
		sel_4 0
		sel_33 30
		sel_37 7
		sel_14 65
		sel_199 900
		sel_200 14
	)
)

(instance icon7 of IconI
	(properties
		sel_20 {icon7}
		sel_2 900
		sel_3 11
		sel_4 0
		sel_33 31
		sel_37 6
		sel_14 65
		sel_199 900
		sel_200 14
		sel_201 1
	)
)

(instance icon8 of IconI
	(properties
		sel_20 {icon8}
		sel_2 900
		sel_3 7
		sel_4 0
		sel_33 999
		sel_37 0
		sel_14 67
		sel_199 900
		sel_200 14
		sel_201 1
	)

	(method (sel_179)
		(if (super sel_179:)
			(gTheIconBar sel_102:)
			(gGameControls sel_207:)
		)
	)
)

(instance icon9 of IconI
	(properties
		sel_20 {icon9}
		sel_2 900
		sel_3 9
		sel_4 0
		sel_33 29
		sel_37 3
		sel_14 3
		sel_199 900
		sel_200 14
	)
)

(instance sq4DoVerbCode of Code
	(properties
		sel_20 {sq4DoVerbCode}
	)

	(method (sel_57)
		(proc0_16)
	)
)

(instance sq4FtrInit of Code
	(properties
		sel_20 {sq4FtrInit}
	)

	(method (sel_57 param1)
		(if (== (param1 sel_293:) 26505)
			(param1 sel_293: 90)
		)
		(if (== (param1 sel_291:) 26505)
			(param1 sel_291: 0)
		)
	)
)

(instance sq4Win of BorderWindow
	(properties
		sel_20 {sq4Win}
	)
)

(instance invWin of InsetWindow ; UNUSED
	(properties
		sel_20 {invWin}
	)
)

(instance gcWin of BorderWindow
	(properties
		sel_20 {gcWin}
	)

	(method (sel_192 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 15] [temp29 4])
		(self
			sel_194: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			sel_195: (/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
			sel_196:
				(+ (CelHigh 947 1 1) 6 (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2))
			sel_197:
				(+
					151
					(CelWide 947 0 1)
					(/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
				)
			sel_60: 15
		)
		(super sel_192:)
		(DrawCel
			947
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 947 0 1)) (+ 4 (CelWide 947 1 1)))
						(CelWide 947 0 5)
					)
					2
				)
				4
				(CelWide 947 1 1)
			)
			6
			15
		)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 94 38 15)
		(DrawCel 947 1 0 135 38 15)
		(DrawCel 947 0 4 63 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 3 101 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 2 146 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 947 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 947 1 1)))
				(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
			)
		)
		(= temp12 15)
		(= temp6 0)
		(= temp8 global156)
		(= temp11 (proc0_18 global157 global156))
		(= temp10 (proc0_18 global161 global130))
		(= temp9 global130)
		(= temp1 3)
		(= temp7 3)
		(Graph grFILL_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) temp7 temp6 temp12)
		(-= temp2 temp1)
		(-= temp3 temp1)
		(+= temp4 temp1)
		(+= temp5 temp1)
		(Graph grFILL_BOX temp2 temp3 (+ temp2 temp1) temp4 temp7 temp8 temp12)
		(Graph grFILL_BOX (- temp5 temp1) temp3 temp5 temp4 temp7 temp9 temp12)
		(for ((= temp13 0)) (< temp13 temp1) ((++ temp13))
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(+ temp3 temp13)
				(- temp5 (+ temp13 1))
				(+ temp3 temp13)
				temp11
				temp12
				-1
			)
			(Graph
				grDRAW_LINE
				(+ temp2 temp13)
				(- temp4 (+ temp13 1))
				(- temp5 (+ temp13 1))
				(- temp4 (+ temp13 1))
				temp10
				temp12
				-1
			)
		)
		(Graph grUPDATE_BOX temp2 temp3 (+ temp5 1) (+ temp4 1) 1)
		(Format @temp14 0 22 gScore gPossibleScore) ; "Score: %d of %d"
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			(proc0_18 global161 global130)
			dsCOORD
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(- (+ 151 (CelWide 947 0 1)) (+ 10 (CelWide 947 1 1) 6))
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 947 0 1) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		sel_20 {detailSlider}
		sel_2 947
		sel_3 0
		sel_4 1
		sel_7 67
		sel_6 37
		sel_14 128
		sel_502 947
		sel_512 3
	)
)

(instance volumeSlider of Slider
	(properties
		sel_20 {volumeSlider}
		sel_2 947
		sel_3 0
		sel_4 1
		sel_7 107
		sel_6 37
		sel_14 128
		sel_502 947
		sel_512 15
	)
)

(instance speedSlider of Slider
	(properties
		sel_20 {speedSlider}
		sel_2 947
		sel_3 0
		sel_4 1
		sel_7 147
		sel_6 37
		sel_14 128
		sel_502 947
		sel_511 15
	)

	(method (sel_57 param1)
		(if argc
			(gEgo sel_236: param1 sel_53: param1)
		)
		(gEgo sel_236:)
	)
)

(instance iconSave of ControlIcon
	(properties
		sel_20 {iconSave}
		sel_2 947
		sel_3 2
		sel_4 0
		sel_7 8
		sel_6 6
		sel_37 9
		sel_14 451
	)
)

(instance iconRestore of ControlIcon
	(properties
		sel_20 {iconRestore}
		sel_2 947
		sel_3 3
		sel_4 0
		sel_7 8
		sel_6 26
		sel_37 9
		sel_14 451
	)
)

(instance iconRestart of ControlIcon
	(properties
		sel_20 {iconRestart}
		sel_2 947
		sel_3 4
		sel_4 0
		sel_7 8
		sel_6 46
		sel_37 9
		sel_14 451
	)
)

(instance iconQuit of ControlIcon
	(properties
		sel_20 {iconQuit}
		sel_2 947
		sel_3 5
		sel_4 0
		sel_7 8
		sel_6 66
		sel_37 9
		sel_14 451
	)
)

(instance iconAbout of ControlIcon
	(properties
		sel_20 {iconAbout}
		sel_2 947
		sel_3 6
		sel_4 0
		sel_7 8
		sel_6 86
		sel_37 9
		sel_14 451
	)
)

(instance iconHelp of ControlIcon
	(properties
		sel_20 {iconHelp}
		sel_2 947
		sel_3 7
		sel_4 0
		sel_7 34
		sel_6 86
		sel_33 70
		sel_37 0
		sel_14 387
	)
)

(instance iconOk of IconI
	(properties
		sel_20 {iconOk}
		sel_2 947
		sel_3 8
		sel_4 0
		sel_7 8
		sel_6 106
		sel_33 70
		sel_37 9
		sel_14 451
	)
)

(instance genericCursor of Cursor
	(properties
		sel_20 {genericCursor}
		sel_2 20
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

(instance smellerIcon of Cursor
	(properties
		sel_20 {smellerIcon}
		sel_2 942
		sel_3 1
		sel_4 5
	)
)

(instance tasterIcon of Cursor
	(properties
		sel_20 {tasterIcon}
		sel_2 942
		sel_3 1
		sel_4 6
	)
)

(instance abouterIcon of Cursor
	(properties
		sel_20 {abouterIcon}
		sel_2 942
		sel_3 1
		sel_4 4
	)
)

(instance hiddenCursor of Cursor
	(properties
		sel_20 {hiddenCursor}
		sel_2 942
	)
)

(instance sq4Messager of Messager
	(properties
		sel_20 {sq4Messager}
	)
)

(instance budgetControls of GameControls
	(properties
		sel_20 {budgetControls}
	)

	(method (sel_102)
		(if sel_32
			(sel_32 sel_111:)
		)
		(if (& sel_29 $0020)
			(gSounds sel_169: 0)
			(&= sel_29 $ffdf)
		)
	)
)

(instance mainMenu of Obj ; UNUSED
	(properties
		sel_20 {mainMenu}
	)

	(method (sel_110)
		(ScriptID 940)
		(super sel_110:)
		(self sel_57:)
	)

	(method (sel_57 &tmp temp0)
		(= temp0 0)
		(repeat
			(gSystemWindow sel_25: 49 sel_26: 7)
			(switch
				(= temp0
					(PrintD
						{Select game to play:}
						109
						78
						{ Ms. Astro Chicken }
						290
						109
						78
						{ Monolith Burger Builder }
						387
						109
						78
						{ Sand Skimmer }
						36
						109
						78
						{ About Games }
						330
						109
						78
						{ Quit }
						417
					)
				)
				(417
					(= gQuit 1)
					(break)
				)
				(330
					(requestHelp sel_110:)
				)
				(else
					(break)
				)
			)
		)
		(if (!= temp0 417)
			(gSystemWindow sel_25: 0 sel_26: 4)
			(gGame sel_390: temp0)
		)
	)
)

(instance foolWindow of SysWindow ; UNUSED
	(properties
		sel_20 {foolWindow}
		sel_25 49
		sel_26 7
	)
)

