;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Osc)
(use System)

(class Swing of Osc
	(properties
		swingSpeed 1
		countSwings 0
		startFull 0
		startSwingCel 0
		stopSwingCel 0
		cycleSound 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(= cycleSound param4)
		(= temp0 (param1 lastCel:))
		(if (>= argc 4)
			(= swingSpeed param2)
			(if (>= argc 5)
				(= startFull param3)
			)
		)
		(if startFull
			(= startSwingCel 0)
			(= stopSwingCel temp0)
		else
			(= startSwingCel (- (/ temp0 2) 1))
			(= stopSwingCel (/ temp0 2))
		)
		(param1 cel: startSwingCel)
		(= countSwings swingSpeed)
		(super init: param1 &rest)
	)

	(method (dispose)
		(swingSound dispose:)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(if (!= (client cel:) temp0)
			(cond
				(
					(and
						startFull
						(or (== temp0 stopSwingCel) (== temp0 startSwingCel))
					)
					(if (== countSwings 0)
						(= countSwings swingSpeed)
						(if (!= startSwingCel (/ (client lastCel:) 2))
							(++ startSwingCel)
						)
						(if (!= stopSwingCel (/ (client lastCel:) 2))
							(-- stopSwingCel)
						)
					else
						(-- countSwings)
					)
					(= cycleDir (- cycleDir))
					(if (!= cycleSound 0)
						(swingSound number: cycleSound play:)
					)
					(client
						cel:
							(if
								(or
									(== temp0 (- startSwingCel 1))
									(== temp0 startSwingCel)
								)
								startSwingCel
							else
								stopSwingCel
							)
					)
				)
				((or (> temp0 stopSwingCel) (< temp0 startSwingCel))
					(if
						(and
							(OneOf
								startSwingCel
								stopSwingCel
								(- stopSwingCel 1)
							)
							(> howManyCycles 0)
						)
						(-- howManyCycles)
					)
					(if (== countSwings 0)
						(= countSwings swingSpeed)
						(if (> startSwingCel 0)
							(-- startSwingCel)
						)
						(if (< stopSwingCel (client lastCel:))
							(++ stopSwingCel)
						)
					else
						(-- countSwings)
					)
					(= cycleDir (- cycleDir))
					(self cycleDone:)
				)
				(else
					(client cel: temp0)
				)
			)
		)
	)
)

(instance swingSound of FPSound
	(properties
		flags 1
	)
)

