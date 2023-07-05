;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63007)
(include sci.sh)
(use MenuList)
(use Credits)
(use Plane)
(use Rectangle)
(use FlipPoly)
(use Cel)
(use Menu)
(use System)

(class AboutPlane of HotPlane
	(properties
		picture -2
		pageArea 0
	)

	(method (init param1 &tmp temp0)
		(= pageArea (Rectangle new: 10 10 299 189))
		(self setPri: (+ 1 (GetHighPlanePri)))
		(super init: 150 75 500 263)
		(aboutSelector init: self param1)
	)

	(method (dispose)
		(pageArea dispose:)
		(= pageArea 0)
		(aboutSelector dispose:)
		(super dispose: &rest)
	)

	(method (done)
		(Send new: self 8)
	)

	(method (handleEvent event param2)
		(event localize: self)
		(if (or (!= argc 2) (!= param2 self))
			(super handleEvent: event)
			(return)
		)
		(if (pageArea onMe: event)
			(aboutSelector doit: (event x:) (event y:))
		else
			(aboutSelector doit: 0)
		)
	)
)

(class AboutList of List
	(properties
		back 3
		manager 0
		modNum -1
		fore 22
		font 7001
		width -1
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new:))
		(= modNum param2)
		(if argc
			(temp0 manager: param1)
		)
		(return temp0)
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(= temp3 (manager lineHeight:))
		(= width param5)
		(= modNum param2)
		(= temp0 1)
		(= temp2 param4)
		(while (< temp0 3)
			(if (Message msgGET modNum 0 0 0 temp0)
				((= temp1 (param1 new:))
					setText: modNum 0 0 0 temp0
					setSize: self
					posn: param3 temp2
				)
				(+= temp2 (temp1 celHeight:))
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

(instance aboutSelector of VMultiLineSelector
	(properties
		pageSize 20
		lineHeight 12
		topLineNum 0
	)

	(method (init param1 param2 &tmp temp0)
		((= items (AboutList new: self))
			init: CreditSelectItem param2 10 10 290
		)
		(items eachElementDo: #init param1)
		(self cue: 0)
		(super init:)
		(+= numLines 5)
		(if (> numLines pageSize)
			((= scrollBar aboutScroll)
				client: self
				init: param1
				clientMax: (- numLines pageSize)
				clientPageSize: pageSize
			)
		)
	)

	(method (dispose)
		(= topLineNum 0)
		(super dispose:)
	)
)

(instance aboutScroll of Scrollbar
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
		x 320
		y 27
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
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)
)

(instance dnArr of ScrollbarArrow
	(properties
		x 320
		y 159
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
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)
)

(instance tThumb of Thumb
	(properties
		x 322
		y 41
		view 4036
		thumbMax 142
		thumbMin 41
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
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)
)

(instance tBar of Cel
	(properties
		x 319
		y 40
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
		y 41
		celHeight 0
		celWidth 14
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)
)

(instance tDn of PageRegion
	(properties
		type 1
		x 320
		y 55
		celHeight 100
		celWidth 14
	)

	(method (init)
		(self setPri: 400)
		(super init: &rest)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
		)
		(super press: param1 &rest)
	)
)

