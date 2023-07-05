;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use DText)
(use Str)
(use Array)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	protection 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(return
		(|
			(|
				(| (| (<< param1 $000c) (<< param2 $0009)) (<< param3 $0006))
				(<< param4 $0003)
			)
			param5
		)
	)
)

(procedure (localproc_1)
	(local2 at: 0 (localproc_0 5 5 3 4 4))
	(local2 at: 1 (localproc_0 4 3 4 1 3))
	(local2 at: 2 (localproc_0 1 4 3 5 1))
	(local2 at: 3 (localproc_0 1 3 1 3 4))
	(local2 at: 4 (localproc_0 5 1 5 2 2))
	(local2 at: 5 (localproc_0 2 5 3 2 5))
	(local2 at: 6 (localproc_0 5 4 4 1 1))
	(local2 at: 7 (localproc_0 1 2 5 2 1))
	(local2 at: 8 (localproc_0 4 1 1 4 5))
	(local2 at: 9 (localproc_0 5 5 2 5 5))
	(local2 at: 10 (localproc_0 4 2 4 5 1))
	(local2 at: 11 (localproc_0 1 1 4 1 4))
	(local2 at: 12 (localproc_0 3 1 5 3 5))
	(local2 at: 13 (localproc_0 2 3 1 2 1))
	(local2 at: 14 (localproc_0 1 3 5 1 3))
	(local2 at: 15 (localproc_0 2 5 5 2 4))
	(local2 at: 16 (localproc_0 4 2 3 5 2))
	(local2 at: 17 (localproc_0 3 1 3 2 1))
	(local2 at: 18 (localproc_0 4 5 1 2 2))
	(local2 at: 19 (localproc_0 5 4 2 1 4))
	(local2 at: 20 (localproc_0 3 2 5 5 5))
	(local2 at: 21 (localproc_0 2 3 1 3 2))
	(local2 at: 22 (localproc_0 1 3 1 2 3))
	(local2 at: 23 (localproc_0 2 2 4 2 4))
	(local2 at: 24 (localproc_0 2 5 2 4 5))
	(local2 at: 25 (localproc_0 4 3 3 2 4))
)

(procedure (localproc_2)
	(-- local1)
	((switch local1
			(0 prop1)
			(1 prop2)
			(2 prop3)
			(3 prop4)
			(4 prop5)
		)
		hide:
	)
	(&= local3 (~ (<< $0007 (* 3 (- 4 local1)))))
)

(procedure (localproc_3 param1 &tmp temp0)
	((= temp0
			(switch local1
				(0 prop1)
				(1 prop2)
				(2 prop3)
				(3 prop4)
				(4 prop5)
			)
		)
		x: (+ (* local1 25) 30)
		y: 51
		loop:
			(switch param1
				(aEarth 6)
				(aAir 7)
				(aFire 8)
				(aWater 9)
				(aPizza 10)
			)
		cel: 0
		show:
	)
	(++ local1)
	(protection setScript: popOut 0 temp0)
)

(instance protection of PuzzleBar
	(properties)

	(method (init param1)
		(= local2 (IntArray new: 26))
		(self changeCursor: 999 noHands: 0)
		(super init:)
		(= local0 param1)
		(prop1 init: puzzleCast hide:)
		(prop2 init: puzzleCast hide:)
		(prop3 init: puzzleCast hide:)
		(prop4 init: puzzleCast hide:)
		(prop5 init: puzzleCast hide:)
	)

	(method (dispose)
		(super dispose:)
		(if (== local3 (local2 at: (- local0 1)))
			(local2 dispose:)
			(return 1)
		else
			(local2 dispose:)
			(return 0)
		)
	)

	(method (resetPuzzle &tmp temp0 temp1 temp2 temp3)
		(localproc_1)
		(= local1 0)
		(= local3 0)
		(self
			add:
				(aEarth init: self yourself:)
				(aAir init: self yourself:)
				(aFire init: self yourself:)
				(aWater init: self yourself:)
				(aPizza init: self yourself:)
				(aBackSpace init: self yourself:)
				(bWindow init: self yourself:)
		)
		(= temp1 (Str new: 40))
		(= temp2 (IntArray with: 0 0 0 0))
		(Message msgGET 370 25 4 57 local0 (temp1 data:))
		(TextSize (temp2 data:) (temp1 data:) 300 0)
		(= temp0 (- (temp2 at: 3) (temp2 at: 1)))
		(theText2
			posn: (- (= temp3 (- 60 (/ temp0 2))) 1) 32
			text: (temp1 data:)
			setSize:
			setPri: 254
			init: puzzleCast
		)
		(theText1
			posn: temp3 33
			text: (temp1 data:)
			setSize:
			setPri: 251
			init: puzzleCast
		)
		(temp2 dispose:)
		(temp1 dispose:)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 160
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (helpYou &tmp temp0)
		(= temp0 (Str new:))
		(Message msgGET 370 26 9 0 1 (temp0 data:)) ; "Each potion needs a certain special component. You must select the "elements" which make up that component to help Dr. Cranium create the potion."
		(Print addText: (temp0 data:) y: 150 init:)
		(Message msgGET 370 26 9 0 2 (temp0 data:)) ; "The elements must be specified in the correct order so that they will interact properly."
		(Print addText: (temp0 data:) y: 150 init:)
		(Message msgGET 370 26 9 0 3 (temp0 data:)) ; "There wasn't room to list all the formulae here, but you can find full details about the elements for each ingredient in your game manual."
		(Print addText: (temp0 data:) y: 150 init:)
		(Message msgGET 370 26 9 0 4 (temp0 data:)) ; "The ingredients are listed alphabetically in the manual. If you are looking for one that is early in the alphabet, look near the beginning of the manual, and so on."
		(Print addText: (temp0 data:) y: 150 init:)
		(Message msgGET 370 26 9 0 5 (temp0 data:)) ; "If you did not get a game manual with your copy of Quest for Glory: Shadows of Darkness, then you do not have a complete game. Contact your software retailer or Sierra to purchase a complete copy of Quest for Glory: Shadows of Darkness."
		(Print addText: (temp0 data:) y: 150 init:)
		(temp0 dispose:)
	)
)

(instance popOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(protection noHands: 1)
				(register cycleSpeed: 10 setCycle: End self)
			)
			(1
				(if (== local3 (local2 at: (- local0 1)))
					(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
				else
					(protection noHands: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance theText1 of DText
	(properties
		fore 92
		font 300
	)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

(instance theText2 of DText
	(properties
		fore 1
		font 300
	)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

(instance aEarth of TextIcon
	(properties
		nsLeft 13
		nsTop 66
		x 13
		y 66
		view 379
	)

	(method (select)
		(if (and (super select: &rest) (< local1 5))
			(|= local3 (<< $0001 (* (- 4 local1) 3)))
			(localproc_3 self)
		)
	)
)

(instance aAir of TextIcon
	(properties
		nsLeft 40
		nsTop 66
		x 40
		y 66
		view 379
		loop 1
	)

	(method (select)
		(if (and (super select: &rest) (< local1 5))
			(|= local3 (<< $0002 (* (- 4 local1) 3)))
			(localproc_3 self)
		)
	)
)

(instance aFire of TextIcon
	(properties
		nsLeft 67
		nsTop 66
		x 67
		y 66
		view 379
		loop 2
	)

	(method (select)
		(if (and (super select: &rest) (< local1 5))
			(|= local3 (<< $0003 (* (- 4 local1) 3)))
			(localproc_3 self)
		)
	)
)

(instance aWater of TextIcon
	(properties
		nsLeft 94
		nsTop 66
		x 94
		y 66
		view 379
		loop 3
	)

	(method (select)
		(if (and (super select: &rest) (< local1 5))
			(|= local3 (<< $0004 (* (- 4 local1) 3)))
			(localproc_3 self)
		)
	)
)

(instance aPizza of TextIcon
	(properties
		nsLeft 121
		nsTop 66
		x 121
		y 66
		view 379
		loop 4
	)

	(method (select)
		(if (and (super select: &rest) (< local1 5))
			(|= local3 (<< $0005 (* (- 4 local1) 3)))
			(localproc_3 self)
		)
	)
)

(instance aBackSpace of TextIcon
	(properties
		nsLeft 10
		nsTop 89
		x 10
		y 89
		view 379
		loop 5
	)

	(method (select)
		(if (and (super select: &rest) local1)
			(localproc_2)
		)
	)
)

(instance bWindow of TextIcon
	(properties
		nsLeft 9
		nsTop 28
		x 9
		y 28
		view 379
		loop 11
		cel 0
	)

	(method (highlight))

	(method (select))

	(method (onMe)
		(return 0)
	)
)

(instance prop1 of Prop
	(properties
		priority 55
		fixPriority 1
		view 379
		loop 6
		signal 16385
	)
)

(instance prop2 of Prop
	(properties
		priority 55
		fixPriority 1
		view 379
		loop 7
		signal 16385
	)
)

(instance prop3 of Prop
	(properties
		priority 55
		fixPriority 1
		view 379
		loop 8
		signal 16385
	)
)

(instance prop4 of Prop
	(properties
		priority 55
		fixPriority 1
		view 379
		loop 9
		signal 16385
	)
)

(instance prop5 of Prop
	(properties
		priority 55
		fixPriority 1
		view 379
		loop 10
		signal 16385
	)
)

