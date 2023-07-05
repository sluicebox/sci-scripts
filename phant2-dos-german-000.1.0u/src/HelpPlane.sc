;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63022)
(include sci.sh)
(use MenuList)
(use Credits)
(use Plane)
(use Rectangle)
(use FlipPoly)
(use Cel)
(use Menu)
(use System)

(class HelpPlane of HotPlane
	(properties
		picture -2
		modNum 2034
		pageArea 0
	)

	(method (init param1 &tmp temp0)
		(= pageArea (Rectangle new: 10 10 299 189))
		(param1 subPlane: self)
		(self setPri: (+ 1 (GetHighPlanePri)))
		(super init: 150 78 500 278)
		(helpSelector init: self)
	)

	(method (dispose)
		(pageArea dispose:)
		(= pageArea 0)
		(helpSelector dispose:)
		(super dispose: &rest)
	)

	(method (done)
		(Send new: self 8)
	)

	(method (handleEvent event &tmp temp0)
		(event localize: self)
		(cast handleEvent: event)
	)
)

(class HelpList of List
	(properties
		back 3
		manager 0
		modNum 2034
		fore 22
		font 7001
		width -1
	)

	(method (new param1 &tmp temp0)
		(= temp0 (super new:))
		(if argc
			(temp0 manager: param1)
		)
		(return temp0)
	)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(= temp3 (+ (manager lineHeight:) 0))
		(= width param4)
		(= temp0 1)
		(= temp2 (+ param3 30))
		(while (< temp0 9)
			(if (Message msgGET modNum 0 0 0 temp0)
				((= temp1 (param1 new:))
					bulletView: 4034
					bulletLoop: (+ temp0 4)
					setText: modNum 0 0 0 temp0
					setSize: self
					posn: param2 temp2
				)
				(+= temp2 (+ (temp1 celHeight:) 0))
				(self addToEnd: temp1)
			)
			(++ temp0)
		)
	)

	(method (dispose)
		(= manager 0)
		(super dispose:)
	)
)

(instance helpSelector of VMultiLineSelector
	(properties
		pageSize 40
		lineHeight 12
		topLineNum 0
	)

	(method (init param1 &tmp temp0)
		((= items (HelpList new: self)) init: CreditSelectItem 10 10 290)
		(items eachElementDo: #init param1)
		(self cue: 0)
		(super init:)
		(= numLines 100)
		(if (> numLines pageSize)
			((= scrollBar helpScroll)
				client: self
				init: param1
				clientMax: 118
				clientPageSize: pageSize
			)
		)
	)

	(method (dispose)
		(= topLineNum 0)
		(super dispose:)
	)
)

(instance helpScroll of Scrollbar
	(properties)

	(method (init param1)
		(= thumbMax (- (tThumb thumbMax:) (tThumb thumbMin:)))
		(= thumbSize 14)
		(super init: param1 dnArr upArr tThumb tDn tUp tBar)
	)

	(method (dispose)
		(forwardArrow dispose:)
		(reverseArrow dispose:)
		(thumbButton dispose:)
		(forwardRegion dispose:)
		(reverseRegion dispose:)
		(physicalBar dispose:)
		(= clientPosition
			(= reverseRegion
				(= physicalBar
					(= client
						(= forwardArrow
							(= reverseArrow (= thumbButton (= forwardRegion 0)))
						)
					)
				)
			)
		)
		(super dispose:)
	)
)

(instance upArr of ScrollbarArrow
	(properties
		x 321
		y 47
		view 4036
		loop 1
	)

	(method (init)
		(= cueSelector 441)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(if (not (not (& state $0020)))
			(++ cel)
		)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance dnArr of ScrollbarArrow
	(properties
		x 320
		y 179
		view 4036
		loop 2
	)

	(method (init)
		(= cueSelector 440)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(if (not (not (& state $0020)))
			(++ cel)
		)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tThumb of Thumb
	(properties
		x 322
		y 61
		view 4036
		thumbMax 161
		thumbMin 61
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)

	(method (update)
		(= cel 0)
		(UpdateScreenItem self)
		(self setRect:)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tBar of Cel
	(properties
		x 319
		y 60
		view 4036
		loop 3
	)

	(method (init)
		(self setPri: 40)
		(super init: &rest)
	)
)

(instance tUp of PageRegion
	(properties
		x 320
		y 61
		celHeight 0
		celWidth 14
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

(instance tDn of PageRegion
	(properties
		type 1
		x 320
		y 75
		celHeight 100
		celWidth 14
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(super press: param1 &rest)
		(if (and argc param1)
			(self hilite: 1)
		)
	)
)

