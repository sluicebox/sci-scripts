;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(local
	[inputLine 23]
	inputLen
)

(instance uEvt of Event
	(properties
		sel_20 {uEvt}
	)
)

(class User of Obj
	(properties
		sel_20 {User}
		sel_309 0
		sel_310 0
		sel_311 0
		sel_312 32
		sel_313 0
		sel_314 {Enter input}
		sel_315 0
		sel_1 -1
		sel_0 -1
		sel_316 1
		sel_317 0
		sel_318 0
	)

	(method (sel_110 param1 param2)
		(= sel_315 (if argc param1 else @inputLine))
		(= inputLen (if (== argc 2) param2 else 45))
		(= sel_317 uEvt)
	)

	(method (sel_321 param1)
		(if argc
			(= sel_310 param1)
		)
		(return sel_310)
	)

	(method (sel_57)
		(sel_317
			sel_31: 0
			sel_37: 0
			sel_61: 0
			sel_0: 0
			sel_1: 0
			sel_73: 0
			sel_146: 0
		)
		(GetEvent 32767 sel_317)
		(self sel_132: sel_317)
	)

	(method (sel_132 param1 &tmp temp0 temp1)
		(= gMouseX (param1 sel_1:))
		(= gMouseY (param1 sel_0:))
		(if (param1 sel_31:)
			(= gLastEvent param1)
			(if sel_316
				(MapKeyToDir param1)
			)
			(if (== (param1 sel_31:) 256)
				(param1
					sel_31: 4
					sel_37: (if (& (param1 sel_61:) $0003) 27 else 13)
					sel_61: 0
				)
			)
			(= temp0 (param1 sel_31:))
			(param1 sel_147:)
			(cond
				((& (param1 sel_31:) $0040)
					(or
						(and gPMouse (gPMouse sel_132: param1))
						(and gDirectionHandler (gDirectionHandler sel_132: param1))
						(and sel_309 sel_311 (sel_309 sel_132: param1))
						(and gTheIconBar (gTheIconBar sel_132: param1))
					)
				)
				((== temp0 4)
					(if gKeyDownHandler
						(gKeyDownHandler sel_132: param1)
					)
				)
				((and (== temp0 1) gMouseDownHandler)
					(gMouseDownHandler sel_132: param1)
				)
			)
		)
		(if (not (param1 sel_73:))
			(if gTheIconBar
				(gTheIconBar sel_132: param1)
			)
			(if (and (== (param1 sel_31:) 16384) sel_310)
				(cond
					(
						(and
							(== (param1 sel_37:) 1)
							sel_311
							(sel_309 sel_132: param1)
						)
						1
					)
					((gCast sel_132: param1) 1)
					((gFeatures sel_132: param1) 1)
				)
				(cond
					((param1 sel_73:) 1)
					((gRegions sel_132: param1) 1)
				)
			)
			(if (and (param1 sel_31:) (not (param1 sel_73:)))
				(gGame sel_132: param1)
			)
		)
	)

	(method (sel_320 &tmp temp0))

	(method (sel_319 param1)
		(if argc
			(= sel_311 param1)
			(= sel_313 0)
		)
		(return sel_311)
	)

	(method (sel_72 &tmp temp0))
)

(class Ego of Actor
	(properties
		sel_20 {Ego}
		sel_14 8192
		sel_322 0
	)
)

(class OnMeAndLowY of Code
	(properties
		sel_20 {OnMeAndLowY}
		sel_325 0
		sel_326 -1
	)

	(method (sel_110)
		(= sel_325 0)
		(= sel_326 -1)
	)

	(method (sel_57 param1 param2)
		(if (and (param1 sel_200: param2) (> (param1 sel_0:) sel_326))
			(= sel_325 param1)
			(= sel_326 (sel_325 sel_0:))
		)
	)
)

