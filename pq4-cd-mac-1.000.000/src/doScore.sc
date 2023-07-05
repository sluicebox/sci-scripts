;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2011)
(include sci.sh)
(use Main)
(use Styler)
(use DText)
(use Str)
(use Print)
(use User)
(use System)

(public
	doScore 0
)

(class Class_2011_0
	(properties
		theName 0
		theScore 0
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (Clone self))
		(temp0 theName: param1 theScore: param2)
		(return temp0)
	)

	(method (dispose param1)
		(param1 delete: self)
		(theName dispose:)
		(DisposeClone self)
	)
)

(instance doScore of Code
	(properties)

	(method (init &tmp [temp0 2] temp2)
		(if (== gCurRoomNum 41) ; skimmerRoom
			(= temp2 (= global167 (List new:)))
		else
			(= temp2 (= global166 (List new:)))
		)
		(temp2
			add:
				(Class_2011_0 new: (Str newWith: 20 {Jason Hickingbottom}) 8000)
			add: (Class_2011_0 new: (Str newWith: 20 {Mike Pickhinke}) 7500)
			add: (Class_2011_0 new: (Str newWith: 20 {Chris Carr}) 7000)
			add: (Class_2011_0 new: (Str newWith: 20 {Dan Woolard}) 6000)
			add: (Class_2011_0 new: (Str newWith: 20 {Larry Laffer}) 5000)
			add: (Class_2011_0 new: (Str newWith: 20 {Sonny Bonds}) 4000)
			add: (Class_2011_0 new: (Str newWith: 20 {Daryl Gates}) 3000)
		)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (== gCurRoomNum 41) ; skimmerRoom
			(= temp6 global167)
		else
			(= temp6 global166)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(= temp3 (temp6 at: temp0))
			(if (>= param1 (temp3 theScore:))
				(= temp2 (Str newWith: 30))
				(Print
					addBitmap: 64994 4 0
					width: 192
					mode: 1
					addText: 18 0 13 1 0 0 0 ; "You have achieved a high score! Enter your name:"
					addEdit: temp2 12 15 50 temp2
					width: 0
					mode: 0
					init:
				)
				(= temp5 (Class_2011_0 new: temp2 param1))
				(if temp0
					(temp6 addAfter: (temp6 at: (- temp0 1)) temp5)
				else
					(temp6 addToFront: temp5)
				)
				((temp6 at: 7) dispose: temp6)
				(break)
			)
		)
		(while (((User curEvent:) new:) type:)
		)
		(gCast eachElementDo: #dispose)
		(if (== gCurRoomNum 41) ; skimmerRoom
			(gCurRoom drawPic: 0 9 1)
		else
			(gCurRoom drawPic: 20100 9 1)
		)
		(= temp1 45)
		(= temp2 (Str newWith: 30))
		(Message msgGET 0 18 0 12 1 (temp2 data:)) ; "High Scores:"
		((= temp5 (DText new:))
			text: (temp2 data:)
			font: 7
			mode: 1
			fore: 13
			back: 0
			skip: 0
			setSize: 320
			fixPriority: 1
			priority: 200
		)
		(= temp4 (- (temp5 nsRight:) (temp5 nsLeft:)))
		(temp5 x: (/ (- 320 temp4) 2) y: 10 init:)
		(temp2 data: 0 dispose:)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(= temp3 (temp6 at: temp0))
			((= temp5 (DText new:))
				x: 25
				y: temp1
				text: (KString 8 ((temp3 theName:) data:)) ; StrDup
				font: 7
				mode: 0
				fore: 13
				back: 0
				skip: 0
				setSize: 320
				fixPriority: 1
				priority: 200
				init:
			)
			(= temp2 (Str newWith: 30 {}))
			(temp2 format: {%d} (temp3 theScore:))
			((= temp5 (DText new:))
				x: 200
				y: temp1
				text: (temp2 data:)
				font: 7
				mode: 0
				fore: 13
				back: 0
				skip: 0
				setSize: 320
				fixPriority: 1
				priority: 200
				init:
			)
			(+= temp1 20)
			(temp2 data: 0 dispose:)
		)
		(FrameOut)
		(while (((User curEvent:) new:) type:)
		)
		(while (not (((User curEvent:) new:) type:))
		)
		(Styler plane: (gCurRoom plane:) back: 0 style: 10 doit: back: -1)
		(FrameOut)
	)
)

