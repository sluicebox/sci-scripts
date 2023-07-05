;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use User)
(use System)

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

(class sounds of EventHandler
	(properties
		sel_20 {sounds}
	)

	(method (sel_160 param1)
		(self sel_119: 96 mayPause (if argc param1 else 1))
	)
)

(instance mayPause of Code
	(properties
		sel_20 {mayPause}
	)

	(method (sel_57 param1 param2)
		(if (not (& (param1 sel_99:) $0001))
			(param1 sel_160: param2)
		)
	)
)

(instance regions of EventHandler
	(properties
		sel_20 {regions}
	)
)

(instance addToPics of EventHandler
	(properties
		sel_20 {addToPics}
	)

	(method (sel_57)
		(AddToPic sel_24)
	)
)

(instance timers of Set
	(properties
		sel_20 {timers}
	)
)

(class Game of Obj
	(properties
		sel_20 {Game}
		sel_141 0
		sel_83 1
		sel_84 1
		sel_85 0
		sel_356 3
		sel_357 0
	)

	(method (sel_39)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self sel_191: gWaitCursor 1 sel_110: sel_191: gNormalCursor (HaveMouse))
		(while (not gQuit)
			(self sel_57:)
		)
	)

	(method (sel_100 param1)
		(if (or (not argc) param1)
			(= gQuit 1)
		)
	)

	(method (sel_365 param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (sel_291 param1)
		(if argc
			(= sel_356 param1)
			(gCast sel_119: 290)
		)
		(return sel_356)
	)

	(method (sel_62))

	(method (sel_110)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) sel_118:)
		((= gFeatures features) sel_118:)
		((= gSounds sounds) sel_118:)
		((= gRegions regions) sel_118:)
		((= gAddToPics addToPics) sel_118:)
		((= gTimers timers) sel_118:)
		((= gTheDoits theDoits) sel_118:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
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
					(gFastCast sel_120: 132 temp0)
				)
				(temp0 sel_111:)
			)
		else
			(gSounds sel_119: 167)
			(gTimers sel_119: 57)
			(if gModelessDialog
				(gModelessDialog sel_167:)
			)
			(Animate (gCast sel_24:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast sel_119: 222)
			)
			(if sel_141
				(sel_141 sel_57:)
			)
			(gRegions sel_119: 57)
			(if (== gNewRoomNum gCurRoomNum)
				(gUser sel_57:)
			)
			(gTheDoits sel_57:)
			(if (!= gNewRoomNum gCurRoomNum)
				(self sel_358: gNewRoomNum)
			)
			(gTimers sel_119: 81)
			(GameIsRestarting 0)
		)
	)

	(method (sel_358 param1 &tmp [temp0 5] temp5)
		(gAddToPics sel_119: 111 sel_125:)
		(gFeatures sel_119: 96 fDC sel_125:)
		(gCast sel_119: 111 sel_119: 81)
		(gTimers sel_119: 81)
		(gRegions sel_119: 96 DNKR sel_125:)
		(gTheDoits sel_125:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum param1)
		(= gNewRoomNum param1)
		(FlushResources param1)
		(self sel_359: gCurRoomNum sel_363:)
		(Empty gRegions)
		(while ((= temp5 (Event sel_109: 3)) sel_31:)
			(temp5 sel_111:)
		)
		(temp5 sel_111:)
	)

	(method (sel_363 &tmp temp0)
		(Animate (gCast sel_24:) 0)
		(Wait 0)
		(Animate (gCast sel_24:) 0)
		(while (> (Wait 0) global30)
			(breakif (== (= temp0 (gCast sel_120: 289)) 0))
			(temp0 sel_288:)
			(Animate (gCast sel_24:) 0)
			(gCast sel_119: 81)
		)
	)

	(method (sel_359 param1)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions sel_128: (= gCurRoom (ScriptID param1)))
		(gCurRoom sel_110:)
	)

	(method (sel_132 param1)
		(cond
			((param1 sel_73:) 1)
			((and sel_141 (sel_141 sel_132: param1)) 1)
			((== (param1 sel_31:) 16384)
				(self sel_71:)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_360 param1)
		(+= gScore param1)
	)

	(method (sel_101)
		(if gModelessDialog
			(gModelessDialog sel_111:)
		)
		(RestartGame)
	)

	(method (sel_75 &tmp [temp0 23]))

	(method (sel_76 &tmp [temp0 23]))

	(method (sel_362 param1 &tmp temp0)
		(= temp0 gSpeed)
		(= gSpeed param1)
		(return temp0)
	)

	(method (sel_191 param1 &tmp temp0)
		(= temp0 gTheCursor)
		(= gTheCursor param1)
		(SetCursor param1 &rest)
		(return temp0)
	)

	(method (sel_361))

	(method (sel_71))

	(method (sel_364))

	(method (sel_145 param1)
		(if sel_141
			(sel_141 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_144)
		(if sel_141
			(sel_141 sel_144:)
		)
	)
)

(class Rgn of Obj
	(properties
		sel_20 {Rgn}
		sel_141 0
		sel_40 0
		sel_134 0
		sel_366 0
		sel_367 0
		sel_276 0
	)

	(method (sel_110)
		(if (not sel_367)
			(= sel_367 1)
			(if (not (gRegions sel_122: self))
				(gRegions sel_129: self)
			)
			(super sel_110:)
		)
	)

	(method (sel_57)
		(if sel_141
			(sel_141 sel_57:)
		)
	)

	(method (sel_132 param1)
		(cond
			((param1 sel_73:) 1)
			(
				(not
					(and
						sel_141
						(or (sel_141 sel_132: param1) 1)
						(param1 sel_73:)
					)
				)
				(param1
					sel_73:
						(self
							sel_277:
								(param1 sel_37:)
								(and
									gInventory
									gTheIconBar
									(== (param1 sel_37:) 4)
									(gInventory sel_131: (gTheIconBar sel_213:))
								)
						)
				)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_277 param1)
		(if (and (== param1 2) sel_276)
			(Printf 994 0 sel_276) ; "%s"
			(return 1)
		else
			(return 0)
		)
	)

	(method (sel_111)
		(gRegions sel_81: self)
		(if (IsObject sel_141)
			(sel_141 sel_111:)
		)
		(if (IsObject sel_134)
			(sel_134 sel_111:)
		)
		(gSounds sel_119: 168 self)
		(DisposeScript sel_40)
	)

	(method (sel_145 param1)
		(if (IsObject sel_141)
			(sel_141 sel_111:)
		)
		(if param1
			(param1 sel_110: self &rest)
		)
	)

	(method (sel_144)
		(if sel_141
			(sel_141 sel_144:)
		)
	)

	(method (sel_358))

	(method (sel_364))
)

(class Rm of Rgn
	(properties
		sel_20 {Rm}
		sel_368 0
		sel_28 -1
		sel_369 0
		sel_311 0
		sel_370 0
		sel_371 0
		sel_372 0
		sel_373 0
		sel_374 0
		sel_375 0
		sel_107 160
		sel_108 -30000
		sel_308 0
	)

	(method (sel_110 &tmp temp0)
		(= sel_40 gCurRoomNum)
		(= gPerspective sel_375)
		(if sel_368
			(self sel_379: sel_368)
		)
		(self sel_382: (gUser sel_309:) ((gUser sel_309:) sel_322:))
		((gUser sel_309:) sel_322: 0)
	)

	(method (sel_382))

	(method (sel_57 &tmp temp0)
		(if sel_141
			(sel_141 sel_57:)
		)
	)

	(method (sel_383))

	(method (sel_384))

	(method (sel_111)
		(if sel_311
			(sel_311 sel_111:)
		)
		(if sel_308
			(sel_308 sel_111:)
		)
		(super sel_111:)
	)

	(method (sel_132 param1)
		(or (super sel_132: param1) (and sel_311 (sel_311 sel_132: param1)))
		(param1 sel_73:)
	)

	(method (sel_376 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(= temp2 (ScriptID temp1))
			(temp2 sel_40: temp1)
			(gRegions sel_118: temp2)
			(if (not (temp2 sel_367:))
				(temp2 sel_110:)
			)
		)
	)

	(method (sel_378 &tmp [temp0 3]))

	(method (sel_377 param1 &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures sel_118: [param1 temp0])
		)
	)

	(method (sel_381))

	(method (sel_358 param1)
		(gRegions sel_81: self sel_119: 358 param1 sel_128: self)
		(= gNewRoomNum param1)
		(super sel_358: param1)
	)

	(method (sel_379 param1 param2)
		(if gAddToPics
			(gAddToPics sel_119: 111 sel_125:)
		)
		(= sel_374 param1)
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

	(method (sel_380 param1 param2)
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

(instance DNKR of Code
	(properties
		sel_20 {DNKR}
	)

	(method (sel_57 param1)
		(if (not (param1 sel_366:))
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

