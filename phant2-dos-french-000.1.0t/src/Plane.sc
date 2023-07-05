;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64917)
(include sci.sh)
(use Main)
(use Styler)
(use Rectangle)
(use Cel)
(use PlaneManager)

(class Plane of Rectangle
	(properties
		back 0
		priority -1
		bitmap 0
		picture -1
		cast 0
		style 0
		inLeft 0
		inTop 0
		inRight 0
		inBottom 0
		mirrored 0
		vanishingX 0
		vanishingY 0
		oldPri 0
	)

	(method (init)
		(super init: &rest)
		(AddPlane self)
		(gPlanes add: self)
		(if (not cast)
			(= cast ((Cast new:) init: self))
		)
	)

	(method (dispose)
		(if bitmap
			(bitmap dispose:)
			(= bitmap 0)
		)
		(cast dispose:)
		(= cast 0)
		(gPlanes delete: self)
		(DeletePlane self)
		(super dispose:)
	)

	(method (add)
		(cast add: &rest)
	)

	(method (doit)
		(cast doit: &rest)
	)

	(method (drawPic thePic theStyle)
		(= picture thePic)
		(if (> argc 1)
			(= style theStyle)
		)
		(self update:)
		(Styler doit: self style)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(cast handleEvent: event &rest)
		)
	)

	(method (hide)
		(if (!= priority -1)
			(= oldPri priority)
		)
		(self setPri: -1 1)
	)

	(method (posn x y onPlane &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 2])
		(if (< argc 2)
			(PrintDebug {Bad argc in Plane posn\n})
			(Empty self)
		)
		(= temp2 0)
		(= temp3 0)
		(= temp4 gLastScreenX)
		(= temp5 gLastScreenY)
		(if (and (> argc 2) onPlane)
			(= temp2 (onPlane left:))
			(= temp3 (onPlane top:))
			(= temp4 (onPlane right:))
			(= temp5 (onPlane bottom:))
		)
		(= temp0 (- right left))
		(= temp1 (- bottom top))
		(if (== x 35536)
			(= x (+ temp2 (/ (- (- temp4 temp2) temp0) 2)))
		else
			(+= x temp2)
		)
		(if (== y 35536)
			(= y (+ temp3 (/ (- (- temp5 temp3) temp1) 2)))
		else
			(+= y temp3)
		)
		(self setRect: x y (+ x temp0) (+ y temp1) 1)
	)

	(method (setInsetRect)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
	)

	(method (setPri param1 param2)
		(= priority param1)
		(if (gPlanes contains: self)
			(gPlanes update: self)
			(if (and (> argc 1) param2)
				(UpdatePlane self)
			)
		)
	)

	(method (setRect l t r b doUpdate)
		(super setRect: l t r b)
		(self setInsetRect:)
		(if (and (> argc 4) doUpdate)
			(UpdatePlane self)
		)
	)

	(method (show)
		(self setPri: oldPri 1)
	)

	(method (update)
		(UpdatePlane self)
	)

	(method (setBitmapBG param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (CelHigh param1 param2 param3))
		(= temp1 (CelWide param1 param2 param3))
		(= bitmap (Cel new:))
		(bitmap view: param1 loop: param2 cel: param3 init: self)
		(if (and (> argc 3) param4)
			(self
				setRect:
					(self left:)
					(self top:)
					(+ (self left:) temp1)
					(+ (self top:) temp0)
			)
		)
		(self update:)
	)
)

(class HotPlane of Plane
	(properties)

	(method (init)
		(if (not cast)
			(= cast ((HotCast new:) init: self))
		)
		(super init: &rest)
	)

	(method (hotObject param1 &tmp temp0)
		(param1 localize: self)
		(= temp0 (cast hotObject: param1))
		(param1 globalize:)
		(return temp0)
	)
)

