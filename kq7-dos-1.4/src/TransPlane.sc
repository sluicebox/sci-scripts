;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50000)
(include sci.sh)
(use Plane)
(use Actor)
(use System)

(class TransPlane of Plane
	(properties
		picture -2
		style 9
		transView 23
		myList 0
	)

	(method (setScale param1 param2 &tmp temp0)
		((View new:)
			view: transView
			loop: 0
			cel: 0
			x: 0
			y: 0
			setPri: (+ priority 5)
			scaleSignal: 1
			scaleX: param1
			scaleY: param2
			init: myList
		)
		((View new:)
			view: transView
			loop: 0
			cel: 0
			x: 0
			y: 0
			setPri: (+ priority 5)
			scaleSignal: 1
			scaleX: param1
			scaleY: 128
			init: myList
		)
		((View new:)
			view: transView
			loop: 0
			cel: 0
			x: 0
			y: 0
			setPri: (+ priority 5)
			scaleSignal: 1
			scaleX: 128
			scaleY: param2
			init: myList
		)
		((View new:)
			view: transView
			loop: 0
			cel: 0
			x: 0
			y: (- (- bottom top) 1)
			setPri: (+ priority 5)
			scaleSignal: 1
			scaleX: param1
			scaleY: 128
			init: myList
		)
		((View new:)
			view: transView
			loop: 0
			cel: 0
			x: (- (- right left) 1)
			y: 0
			setPri: (+ priority 5)
			scaleSignal: 1
			scaleX: 128
			scaleY: param2
			init: myList
		)
	)

	(method (init)
		(super init: &rest)
		(= myList (Cast new:))
		(self addCast: myList)
		(self setScale: (* (- right left) 128) (* (- bottom top) 128))
	)

	(method (dispose)
		(myList eachElementDo: #dispose release:)
		(super dispose: &rest)
	)
)

