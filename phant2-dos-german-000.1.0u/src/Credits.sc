;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63021)
(include sci.sh)
(use Main)
(use MenuList)
(use Plane)
(use Rectangle)
(use Menu)
(use System)

(local
	local0
)

(class Credits of HotPlane
	(properties
		pageArea 0
		curY -17
	)

	(method (doit &tmp temp0)
		(if (> (- (= gGameTime (+ gTickOffset (GetTime))) local0) 3)
			(= local0 gGameTime)
			(creditsSelector
				cue:
					(if (> (++ curY) 520)
						(= curY -17)
					else
						curY
					)
			)
		)
		(UpdatePlane self)
		(FrameOut)
		(super doit: &rest)
	)

	(method (init &tmp temp0)
		(= curY -17)
		(= pageArea (Rectangle new: 10 10 289 229))
		(= picture -2)
		(self setPri: (+ 1 (GetHighPlanePri)))
		(super init: 180 81 465 309)
		(creditsSelector init: self)
	)

	(method (dispose)
		(pageArea dispose:)
		(= pageArea 0)
		(creditsSelector dispose:)
		(super dispose: &rest)
	)

	(method (done)
		(Send new: self 8)
	)
)

(class CreditsList of List
	(properties
		back 3
		manager 0
		modNum 2035
		fore 22
		font 12311
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
		(= temp3 (manager lineHeight:))
		(= width param4)
		(= temp0 1)
		(= temp2 param3)
		(while (< temp0 9)
			(if (Message msgGET 2035 0 0 0 temp0)
				((= temp1 (param1 new:))
					setText: 2035 0 0 0 temp0
					setSize: self
					posn: param2 temp2
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

(class CreditSelectItem of SelectItem
	(properties
		bulletView 0
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance creditsSelector of VMultiLineSelector
	(properties
		pageSize 20
		lineHeight 12
		topLineNum 0
	)

	(method (init param1 &tmp temp0)
		(= pageSize 20)
		(= topLineNum 0)
		(= lineHeight 12)
		((= items (CreditsList new: self)) init: CreditSelectItem 10 10 280)
		(items eachElementDo: #init param1)
		(self cue: -17)
		(super init:)
	)

	(method (dispose)
		(= topLineNum 0)
		(super dispose:)
	)
)

