;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Actor)
(use System)

(class BulletDrawCel of View
	(properties)

	(method (init)
		(= bitmap (Bitmap 0 (- nsRight nsLeft) (- nsBottom nsTop) 0 0)) ; Create
		(self setPri: 600)
		(&= signal $efff)
		(super init: &rest)
	)

	(method (dispose)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(super dispose: &rest)
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)

	(method (drawCel param1 param2 param3 param4 &tmp temp0)
		(if (> argc 1)
			(= temp0 (CelHigh param2 param3 param4))
			(param1
				y:
					(Min
						(- nsBottom temp0)
						(Max (+ nsTop temp0) (param1 y:))
					)
			)
			(Bitmap
				3 ; AddCel
				bitmap
				param2
				param3
				param4
				(- (param1 x:) x)
				(- (param1 y:) y)
			)
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (handleEvent event)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT JOY_UPLEFT $000a)
			(self drawCel: event)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)
)

