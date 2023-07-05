;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use System)

(public
	PalCycle 0
)

(class PalCycle of Code
	(properties
		palSave 0
		numInt 0
		intLo 0
		intHi 0
		loIntLevel 0
		hiIntLevel 100
		cycleSpeed 0
		lastCycleSpeed 0
		oscPal 0
		oscInt 0
		palDir 1
		intDir 1
		seconds 0
		oldSeconds 0
		lastSeconds 0
		lastIntensity 0
		oldCycles 0
		cycles 0
		done 0
		cycleInt 0
		cyclePal 0
	)

	(method (dispose)
		(gTheDoits delete: self)
		(Palette palRESTORE palSave)
		(super dispose:)
	)

	(method (restorePal)
		(Palette palRESTORE palSave)
		(Palette palSET_INTENSITY 0 255 100)
	)

	(method (savePal)
		(= palSave (Palette palSAVE))
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (not done)
			(if cyclePal
				(self palCycle:)
			)
			(if cycleInt
				(for ((= temp0 0)) (< temp0 (* numInt 2)) ((+= temp0 2))
					(self atInt: temp0)
					(Palette palSET_INTENSITY intLo intHi lastIntensity)
				)
				(if
					(or
						(>= (+= lastIntensity intDir) hiIntLevel)
						(<= lastIntensity loIntLevel)
					)
					(if oscInt
						(= intDir (- intDir))
						(+= lastIntensity intDir)
					else
						(= cycleInt 0)
					)
				)
			)
		)
	)

	(method (palCycle))

	(method (atInt))

	(method (init)
		(= loIntLevel (= done 0))
		(= hiIntLevel 100)
		(= lastIntensity hiIntLevel)
		(super init: &rest)
		(= palSave (Palette palSAVE))
		(gTheDoits add: self)
	)
)

