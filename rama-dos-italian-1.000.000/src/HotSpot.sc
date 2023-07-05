;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Array)
(use System)

(public
	HotSpot 0
)

(class HotSpot of Obj
	(properties
		hotVerbs 0
	)

	(method (respondVerbs param1 &tmp temp0)
		(if hotVerbs
			(hotVerbs dispose:)
			(= hotVerbs 0)
		)
		(if argc
			(= hotVerbs (ByteArray new:))
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(hotVerbs at: temp0 [param1 temp0])
			)
		)
	)

	(method (respondsTo param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (hotVerbs size:)) ((++ temp0))
			(if (== (hotVerbs at: temp0) param1)
				(return 1)
			)
		)
		(return 0)
	)

	(method (dispose)
		(if hotVerbs
			(hotVerbs dispose:)
			(= hotVerbs 0)
		)
		(super dispose:)
	)
)

