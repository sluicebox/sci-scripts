;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 904)
(include sci.sh)
(use Scaler)

(class ScaleTo of Scaler
	(properties
		caller 0
		endScale 0
		step 1
		adjustValue 0
		repCount 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(if argc
			(= client param1)
			(if (>= argc 2)
				(= endScale param2)
				(if (>= argc 3)
					(if (IsObject param3)
						(= caller param3)
					else
						(= step param3)
					)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(client maxScale: (client scaleX:))
		(= temp0 (- (* (> endScale (client maxScale:)) 2) 1))
		(= adjustValue (* step temp0))
		(= repCount (/ (Abs (- endScale (client maxScale:))) step))
	)

	(method (doit &tmp temp0)
		(if repCount
			(if (!= (-- repCount) 0)
				(client maxScale: (+ (client maxScale:) adjustValue))
			else
				(client maxScale: endScale)
			)
		)
		(client scaleX: (client maxScale:) scaleY: (client maxScale:))
		(if (not repCount)
			(self dispose:)
		)
	)

	(method (dispose &tmp temp0)
		(= endScale 0)
		(= step 1)
		(client scaler: 0)
		(if caller
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
		(super dispose: &rest)
	)
)

