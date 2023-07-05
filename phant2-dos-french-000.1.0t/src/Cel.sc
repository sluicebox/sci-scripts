;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64940)
(include sci.sh)
(use Main)
(use Rectangle)

(class Cel of Rectangle
	(properties
		state 1024
		plane 0
		priority -1
		x 0
		y 0
		view -1
		loop 0
		cel 0
		bitmap 0
		fixPriority 0
		signal 9
		inLeft 0
		inTop 0
		inRight 0
		inBottom 0
		lsLeft 0
		magnifier 0
	)

	(method (isHot)
		(return 0)
	)

	(method (init param1)
		(= plane
			(cond
				(argc param1)
				(plane plane)
				(else gThePlane)
			)
		)
		((plane cast:) add: self)
		(&= signal $fff7)
		(AddScreenItem self)
		(self setRect:)
	)

	(method (dispose)
		((plane cast:) delete: self)
		(if (not (& signal $0008))
			(DeleteScreenItem self)
			(|= signal $0008)
		)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= plane (= bitmap 0))
		(super dispose:)
	)

	(method (hide)
		(if (not (& signal $0008))
			(|= signal $0008)
			(DeleteScreenItem self)
		)
	)

	(method (isHidden)
		(return (& signal $0008))
	)

	(method (isVisible)
		(return (not (& signal $0008)))
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (lastLoop)
		(return (- (NumLoops self) 1))
	)

	(method (posn param1 param2 param3)
		(if argc
			(= x param1)
			(if (> argc 1)
				(= y param2)
			)
		)
		(if (and (> argc 2) param3)
			(self update:)
		)
	)

	(method (setBitmap param1 param2)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
		)
		(= bitmap param1)
		(if (and (> argc 1) param2)
			(self update:)
		)
	)

	(method (setCel param1 param2)
		(= cel param1)
		(if (and (> argc 1) param2)
			(self update:)
		)
	)

	(method (setLoop param1 param2)
		(= loop param1)
		(if (and (> argc 1) param2)
			(self update:)
		)
	)

	(method (setPri param1 param2)
		(cond
			((not argc)
				(|= signal $0010)
			)
			((== param1 -1)
				(&= signal $ffef)
			)
			(else
				(= priority param1)
				(|= signal $0010)
			)
		)
		(= fixPriority (& signal $0010))
		(if (and (> argc 1) param2)
			(self update:)
		)
	)

	(method (setRect)
		(if (== argc 4)
			(super setRect: &rest)
		else
			(SetNowSeen self)
		)
	)

	(method (show)
		(if (& signal $0008)
			(&= signal $fff7)
			(AddScreenItem self)
		)
	)

	(method (update)
		(UpdateScreenItem self)
		(self setRect:)
	)
)

