;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use Scaler)

(class ScaleTo of Scaler
	(properties
		caller 0
		endScale 0
		step 6
		waitCount 1
		scaleDir 0
		saveWaitCount 0
	)

	(method (init who whereToScale theStep theTime whoCares)
		(if argc
			(= client who)
			(if (>= argc 2)
				(= endScale whereToScale)
				(if (>= argc 3)
					(if (IsObject theStep)
						(= caller theStep)
					else
						(= step theStep)
						(if (>= argc 4)
							(if (IsObject theTime)
								(= caller theTime)
							else
								(= waitCount theTime)
								(if (>= argc 5)
									(= caller whoCares)
								)
							)
						)
					)
				)
			)
		)
		(= saveWaitCount waitCount)
		(= scaleDir (if (<= (client maxScale:) endScale) 1))
	)

	(method (doit &tmp theValue)
		(if (> (- gGameTime waitCount) 0)
			(= theValue
				(if scaleDir
					(+ (client maxScale:) step)
				else
					(- (client maxScale:) step)
				)
			)
			(client maxScale: theValue scaleX: theValue scaleY: theValue)
			(cond
				(scaleDir
					(if (>= (client maxScale:) endScale)
						(self dispose:)
					)
				)
				((<= (client maxScale:) endScale)
					(self dispose:)
				)
			)
			(= waitCount (+ saveWaitCount gGameTime))
		)
	)

	(method (dispose &tmp whoToCue)
		(= endScale 0)
		(= step 6)
		(= waitCount 1)
		(client scaler: 0)
		(if caller
			(= whoToCue caller)
			(= caller 0)
			(whoToCue cue:)
		)
		(super dispose:)
	)
)

