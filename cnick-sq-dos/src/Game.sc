;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] str [buf1 40] [buf2 10] [buf3 5])
	(= str (Memory memALLOC_CRIT (if 0 200 else 80)))
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if
		(and
			(DeviceInfo diIS_FLOPPY @curDevice)
			(or
				(DeviceInfo diPATHS_EQUAL @saveDevice @curDevice)
				(not (DeviceInfo 6 (gGame sel_20:))) ; SaveDirMounted
			)
		)
		(Message msgGET 994 6 0 0 1 @buf1)
		(Message msgGET 994 7 0 0 1 @buf2)
		(Message msgGET 994 8 0 0 1 @buf3)
		(Format str @buf1 (if saveDisk @buf2 else @buf3) @saveDevice)
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(Message msgGET 994 2 0 0 1 @buf1)
		(Message msgGET 994 4 0 0 1 @buf2)
		(Message msgGET 994 5 0 0 1 @buf3)
		(if
			(==
				(= ret
					(if saveDisk
						(Print
							str
							30
							0
							78
							@buf1
							1
							78
							@buf2
							0
							78
							@buf3
							2
						)
					else
						(Print str 30 0 78 @buf1 1)
					)
				)
				2
			)
			(= ret (proc990_0 gCurSaveDir))
		)
	)
	(Memory memFREE str)
	(return ret)
)

(instance cast of EventHandler
	(properties
		sel_20 {cast}
	)
)

(instance features of EventHandler
	(properties
		sel_20 {features}
	)
)

(instance theDoits of EventHandler
	(properties
		sel_20 {theDoits}
	)
)

(instance sFeatures of EventHandler
	(properties
		sel_20 {sFeatures}
	)

	(method (sel_81 param1)
		(super sel_81: param1)
		(if
			(and
				gUseSortedFeatures
				(param1 sel_114: Collect)
				(not (OneOf param1 gRegions gLocales))
			)
			(param1 sel_125: sel_111:)
		)
	)
)

(class Sounds of EventHandler
	(properties
		sel_20 {Sounds}
	)

	(method (sel_169 param1)
		(self sel_119: 96 mayPause (if argc param1 else 1))
	)
)

(instance mayPause of Code
	(properties
		sel_20 {mayPause}
	)

	(method (sel_57 param1 param2)
		(if (not (& (param1 sel_99:) $0001))
			(param1 sel_169: param2)
		)
	)
)

(instance regions of EventHandler
	(properties
		sel_20 {regions}
	)
)

(instance locales of EventHandler
	(properties
		sel_20 {locales}
	)
)

(instance addToPics of EventHandler
	(properties
		sel_20 {addToPics}
	)

	(method (sel_57)
		(self sel_119: 96 aTOC)
		(AddToPic sel_24)
	)
)

(instance controls of Controls
	(properties
		sel_20 {controls}
	)
)

(instance timers of Set
	(properties
		sel_20 {timers}
	)
)

(instance aTOC of Code
	(properties
		sel_20 {aTOC}
	)

	(method (sel_57 param1 &tmp temp0 temp1)
		(if (not (| (param1 sel_14:) $4000))
			(= temp0 (+ (gEgo sel_51:) (/ (CelWide (gEgo sel_2:) 2 0) 2)))
			(= temp1 (* (gEgo sel_52:) 2))
			(gCurRoom
				sel_388:
					((Unknown_Class_36 sel_109:)
						sel_110:
							(- (param1 sel_17:) temp0)
							(- (CoordPri 1 (CoordPri (param1 sel_0:))) temp1)
							(+ (param1 sel_19:) temp0)
							(- (CoordPri 1 (CoordPri (param1 sel_0:))) temp1)
							(+ (param1 sel_19:) temp0)
							(+ (param1 sel_0:) temp1)
							(- (param1 sel_17:) temp0)
							(+ (param1 sel_0:) temp1)
						sel_117:
					)
			)
		)
	)
)

(class Game of Obj
	(properties
		sel_20 {Game}
		sel_142 0
		sel_83 1
		sel_84 1
		sel_85 0
		sel_389 3
	)

	(method (sel_39)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self sel_198: gWaitCursor 1 sel_110:)
		(self sel_198: gNormalCursor 1)
		(while (not gQuit)
			(self sel_57:)
		)
	)

	(method (sel_100 param1)
		(if (or (not argc) param1)
			(= gQuit 1)
		)
	)

	(method (sel_395 param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (sel_312 param1)
		(if argc
			(= sel_389 param1)
			(gCast sel_119: 310)
		)
		(return sel_389)
	)

	(method (sel_62)
		(if gLastEvent
			(gLastEvent sel_111:)
		)
		(gSFeatures sel_125:)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(gCast sel_119: 96 RU)
		(gGame sel_198: gWaitCursor 1)
		(DrawPic (gCurRoom sel_396:) 100 1 global40)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom sel_335:)
			((gCurRoom sel_335:) sel_80:)
		)
		(gAddToPics sel_57:)
		(gGame
			sel_198:
				(if (and gTheIconBar (gTheIconBar sel_214:))
					((gTheIconBar sel_214:) sel_33:)
				else
					gNormalCursor
				)
				(HaveMouse)
		)
		(SL sel_57:)
		(DoSound sndRESTORE)
		(Sound sel_169: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self sel_57:)
		)
	)

	(method (sel_110)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) sel_118:)
		((= gFeatures features) sel_118:)
		((= gSFeatures sFeatures) sel_118:)
		((= gSounds Sounds) sel_118:)
		((= gRegions regions) sel_118:)
		((= gLocales locales) sel_118:)
		((= gAddToPics addToPics) sel_118:)
		((= gTimers timers) sel_118:)
		((= gTheDoits theDoits) sel_118:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
		(Inv sel_110:)
		(if (not gUser)
			(= gUser User)
		)
		(gUser sel_110:)
	)

	(method (sel_57 &tmp temp0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast sel_119: 57)
				(if (and ((= temp0 (Event sel_109:)) sel_31:) gFastCast)
					(gFastCast sel_120: 133 temp0)
				)
				(temp0 sel_111:)
				(= gGameTime (+ gTickOffset (GetTime)))
			)
		)
		(if gPrints
			(gPrints sel_119: 57)
			(if (not gModelessDialog)
				(if (and ((= temp0 (Event sel_109:)) sel_31:) gPrints)
					(gPrints sel_120: 133 temp0)
				)
				(temp0 sel_111:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(return)
			)
		)
		(gSounds sel_119: 175)
		(gTimers sel_119: 57)
		(if gModelessDialog
			(gModelessDialog sel_175:)
		)
		(Animate (gCast sel_24:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast sel_119: 235)
		)
		(if sel_142
			(sel_142 sel_57:)
		)
		(gRegions sel_119: 57)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser sel_57:)
		)
		(gTheDoits sel_57:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self sel_390: gNewRoomNum)
		)
		(gTimers sel_119: 81)
		(GameIsRestarting 0)
	)

	(method (sel_390 param1 &tmp [temp0 5] temp5)
		(gAddToPics sel_119: 111 sel_125:)
		(gFeatures sel_119: 96 fDC sel_125:)
		(gCast sel_119: 111 sel_119: 81)
		(gTimers sel_119: 81)
		(gRegions sel_119: 96 DNKR sel_125:)
		(gLocales sel_119: 111 sel_125:)
		(gTheDoits sel_125:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum param1)
		(= gNewRoomNum param1)
		(FlushResources param1)
		(self sel_391: gCurRoomNum sel_393:)
		(Empty gRegions)
		(while ((= temp5 (Event sel_109: 3)) sel_31:)
			(temp5 sel_111:)
		)
		(temp5 sel_111:)
	)

	(method (sel_393 &tmp temp0)
		(Animate (gCast sel_24:) 0)
		(Wait 0)
		(Animate (gCast sel_24:) 0)
		(while (> (Wait 0) global30)
			(breakif (== (= temp0 (gCast sel_120: 309)) 0))
			(temp0 sel_308:)
			(Animate (gCast sel_24:) 0)
			(gCast sel_119: 81)
		)
	)

	(method (sel_391 param1)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions sel_129: (= gCurRoom (ScriptID param1)))
		(gCurRoom sel_110:)
	)

	(method (sel_133 param1)
		(cond
			((param1 sel_73:) 1)
			((and sel_142 (sel_142 sel_133: param1)) 1)
			((& (param1 sel_31:) $4000)
				(self sel_71:)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_380 param1)
		(+= gScore param1)
		(SL sel_57:)
	)

	(method (sel_101)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(RestartGame)
	)

	(method (sel_75 &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5])
		(= temp22 sel_83)
		(= sel_83 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990) ; MISSING SCRIPT
		(= temp21 (self sel_198: gNormalCursor))
		(Sound sel_169: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog sel_111:)
			)
			(if (!= (= temp20 (Unknown_Class_62 sel_57: @temp0)) -1)
				(= sel_83 temp22)
				(= temp21 (self sel_198: gWaitCursor 1))
				(if (not (SaveGame sel_20 temp20 @temp0 gVersion))
					(Message msgGET 994 1 0 0 1 @temp23)
					(Message msgGET 994 2 0 0 1 @temp123)
					(Print @temp23 30 0 78 @temp123 1)
				)
				(self sel_198: temp21 (HaveMouse))
			)
			(PromptForDiskChange 0)
		)
		(Sound sel_169: 0)
		(= sel_83 temp22)
	)

	(method (sel_76 &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5])
		(= temp22 sel_83)
		(= sel_83 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990) ; MISSING SCRIPT
		(= temp21 (self sel_198: gNormalCursor))
		(Sound sel_169: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog sel_111:)
			)
			(if (!= (= temp20 (Unknown_Class_61 sel_57: &rest)) -1)
				(self sel_198: gWaitCursor 1)
				(if (CheckSaveGame sel_20 temp20 gVersion)
					(RestoreGame sel_20 temp20 gVersion)
				else
					(Message msgGET 994 3 0 0 1 @temp23)
					(Message msgGET 994 2 0 0 1 @temp123)
					(Print @temp23 30 0 78 @temp123 1)
					(self sel_198: temp21 (HaveMouse))
					(= sel_83 temp22)
				)
			else
				(= sel_83 temp22)
			)
			(PromptForDiskChange 0)
		)
		(Sound sel_169: 0)
	)

	(method (sel_344 param1 &tmp temp0)
		(= temp0 gSpeed)
		(= gSpeed param1)
		(return temp0)
	)

	(method (sel_198 param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (IsObject param1)
			(= gTheCursor param1)
			(param1 sel_110:)
		else
			(SetCursor param1 0 0)
		)
		(if (> argc 1)
			(SetCursor param2)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor param1 0 0 param5 param6)
				)
			)
		)
		(return temp0)
	)

	(method (sel_392)
		(Printf
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
	)

	(method (sel_71))

	(method (sel_394))

	(method (sel_146 param1)
		(if sel_142
			(sel_142 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_145)
		(if sel_142
			(sel_142 sel_145:)
		)
	)
)

(class Rgn of Obj
	(properties
		sel_20 {Rgn}
		sel_142 0
		sel_40 0
		sel_205 0
		sel_204 0
		sel_135 0
		sel_397 0
		sel_398 0
	)

	(method (sel_110)
		(if (not sel_398)
			(= sel_398 1)
			(if (not (gRegions sel_122: self))
				(gRegions sel_130: self)
			)
			(super sel_110:)
		)
	)

	(method (sel_57)
		(if sel_142
			(sel_142 sel_57:)
		)
	)

	(method (sel_133 param1)
		(cond
			((param1 sel_73:) 1)
			(
				(not
					(and
						sel_142
						(or (sel_142 sel_133: param1) 1)
						(param1 sel_73:)
					)
				)
				(param1 sel_73: (self sel_292: (param1 sel_37:)))
			)
		)
		(param1 sel_73:)
	)

	(method (sel_292 param1 &tmp temp0)
		(if (not sel_205)
			(= sel_205 gCurRoomNum)
		)
		(if (Message msgGET sel_205 sel_204 param1 0 1)
			(gMessager sel_287: sel_204 param1 0 0 0 sel_205)
		else
			(return 0)
		)
	)

	(method (sel_111)
		(gRegions sel_81: self)
		(if (IsObject sel_142)
			(sel_142 sel_111:)
		)
		(if (IsObject sel_135)
			(sel_135 sel_111:)
		)
		(gSounds sel_119: 176 self)
		(DisposeScript sel_40)
	)

	(method (sel_146 param1)
		(if (IsObject sel_142)
			(sel_142 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_145)
		(if sel_142
			(sel_142 sel_145:)
		)
	)

	(method (sel_390))

	(method (sel_394))
)

(class Rm of Rgn
	(properties
		sel_20 {Rm}
		sel_399 0
		sel_28 -1
		sel_332 0
		sel_335 0
		sel_400 0
		sel_401 0
		sel_402 0
		sel_403 0
		sel_396 0
		sel_404 0
		sel_107 160
		sel_108 -30000
		sel_251 0
		sel_357 0
	)

	(method (sel_110 &tmp temp0)
		(= sel_40 gCurRoomNum)
		(= sel_335 controls)
		(= gPerspective sel_404)
		(if sel_399
			(self sel_408: sel_399)
		)
		(self sel_410: (gUser sel_333:) ((gUser sel_333:) sel_341:))
		((gUser sel_333:) sel_341: 0)
	)

	(method (sel_410 param1 param2)
		(switch param2
			(1
				(param1 sel_0: 188)
			)
			(4
				(param1 sel_1: (- 319 (param1 sel_51:)))
			)
			(3
				(param1 sel_0: (+ sel_332 (param1 sel_52:)))
			)
			(2
				(param1 sel_1: 1)
			)
		)
	)

	(method (sel_57 &tmp temp0)
		(if sel_142
			(sel_142 sel_57:)
		)
		(if (= temp0 (self sel_411: ((gUser sel_333:) sel_341:)))
			(self sel_390: temp0)
		)
	)

	(method (sel_411 param1)
		(return
			(switch param1
				(1 sel_400)
				(2 sel_401)
				(3 sel_402)
				(4 sel_403)
			)
		)
	)

	(method (sel_412 param1)
		(return
			(switch param1
				(sel_400 1)
				(sel_402 3)
				(sel_401 2)
				(sel_403 4)
			)
		)
	)

	(method (sel_111)
		(if sel_335
			(sel_335 sel_111:)
		)
		(if sel_251
			(sel_251 sel_111:)
		)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(or
			(and sel_357 (sel_357 sel_133: param1))
			(super sel_133: param1)
			(and sel_335 (sel_335 sel_133: param1))
		)
		(param1 sel_73:)
	)

	(method (sel_413 param1 param2 param3)
		(if sel_357
			(sel_357 sel_111:)
		)
		(if (and argc param1)
			(param1
				sel_110:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)

	(method (sel_405 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(= temp2 (ScriptID temp1))
			(temp2 sel_40: temp1)
			(gRegions sel_118: temp2)
			(if (not (temp2 sel_398:))
				(temp2 sel_110:)
			)
		)
	)

	(method (sel_407 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			((= temp2 (ScriptID temp1)) sel_40: temp1)
			(gLocales sel_118: temp2)
			(temp2 sel_110:)
		)
	)

	(method (sel_406 param1 &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures sel_118: [param1 temp0])
		)
	)

	(method (sel_388 param1)
		(if (not (IsObject sel_251))
			(= sel_251 (List sel_109:))
		)
		(sel_251 sel_118: param1 &rest)
	)

	(method (sel_390 param1)
		(gRegions sel_81: self sel_119: 390 param1 sel_129: self)
		(= gNewRoomNum param1)
		(super sel_390: param1)
	)

	(method (sel_408 param1 param2)
		(if gAddToPics
			(gAddToPics sel_119: 111 sel_125:)
		)
		(= sel_396 param1)
		(= gOverlays -1)
		(DrawPic
			param1
			(cond
				((== argc 2) param2)
				((!= sel_28 -1) sel_28)
				(else global17)
			)
			1
			global40
		)
	)

	(method (sel_409 param1 param2)
		(= gOverlays param1)
		(DrawPic
			param1
			(cond
				((== argc 2) param2)
				((!= sel_28 -1) sel_28)
				(else global17)
			)
			0
			global40
		)
	)
)

(class Locale of Obj
	(properties
		sel_20 {Locale}
		sel_40 0
	)

	(method (sel_133 param1)
		(param1 sel_73:)
	)

	(method (sel_111)
		(gLocales sel_81: self)
		(DisposeScript sel_40)
	)
)

(class SL of Obj
	(properties
		sel_20 {SL}
		sel_29 0
		sel_320 0
	)

	(method (sel_57 &tmp temp0)
		(if sel_320
			(= temp0 (Memory memALLOC_CRIT (if 0 240 else 82)))
			(sel_320 sel_57: temp0)
			(DrawStatus (if sel_29 temp0 else 0))
			(Memory memFREE temp0)
		)
	)

	(method (sel_178)
		(= sel_29 1)
		(self sel_57:)
	)

	(method (sel_225)
		(= sel_29 0)
		(self sel_57:)
	)
)

(instance RU of Code
	(properties
		sel_20 {RU}
	)

	(method (sel_57 param1 &tmp temp0)
		(if (param1 sel_5:)
			(= temp0 (& (= temp0 (| (= temp0 (param1 sel_14:)) $0001)) $fffb))
			(param1 sel_5: 0 sel_14: temp0)
		)
	)
)

(instance DNKR of Code
	(properties
		sel_20 {DNKR}
	)

	(method (sel_57 param1)
		(if (not (param1 sel_397:))
			(param1 sel_111:)
		)
	)
)

(instance fDC of Code
	(properties
		sel_20 {fDC}
	)

	(method (sel_57 param1)
		(if (param1 sel_116: 81)
			(param1 sel_14: (& (param1 sel_14:) $ffdf) sel_111: sel_81:)
		else
			(param1 sel_111:)
		)
	)
)

