;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)
(use Actor)

(public
	rm10 0
)

(local
	girl
	body
	face
	hair
	ear
	page
	phone
	room
	testing
	testRoom
	aBody
	aFace
	aHair
	aEar
)

(instance rm10 of Rm
	(properties
		picture 10
		style 8
	)

	(method (init &tmp i)
		(HandsOff)
		(if gDebugging
			(if (<= (= testRoom (GetNumber {Starting Room})) 0)
				(= testRoom 90)
			else
				(TheMenuBar draw:)
				(SL enable:)
			)
		)
		(Load rsVIEW 60)
		(super init:)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 0
			posn: 72 52
			setPri: 1
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 1
			posn: 122 36
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 2
			posn: 141 35
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 3
			posn: 161 35
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 4
			posn: 190 35
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 4
			posn: 221 35
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 4
			cel: 5
			posn: 252 35
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 5
			cel: 0
			posn: 13 113
			setPri: 7
			addToPic:
		)
		((View new:)
			view: 60
			ignoreActors:
			loop: 6
			cel: 0
			posn: 306 113
			setPri: 7
			addToPic:
		)
		((= aBody (View new:))
			view: 60
			loop: 0
			cel: 0
			setPri: 1
			posn: 154 981
			init:
		)
		((= aFace (View new:))
			view: 60
			loop: 1
			cel: 5
			setPri: 2
			posn: 154 981
			init:
		)
		((= aHair (View new:))
			view: 60
			loop: 2
			cel: 1
			setPri: 3
			posn: 154 981
			init:
		)
		((= aEar (View new:))
			view: 60
			loop: 3
			cel: 4
			setPri: 4
			posn: 154 981
			init:
		)
		(switch (= girl (Random 1 16))
			(1
				(= body 0)
				(= face 5)
				(= hair 1)
				(= ear 4)
				(= page 7)
				(= phone {555-7448})
			)
			(2
				(= body 1)
				(= face 5)
				(= hair 2)
				(= ear 4)
				(= page 6)
				(= phone {555-5968})
			)
			(3
				(= body 2)
				(= face 5)
				(= hair 3)
				(= ear 1)
				(= page 8)
				(= phone {555-3425})
			)
			(4
				(= body 1)
				(= face 2)
				(= hair 2)
				(= ear 4)
				(= page 8)
				(= phone {555-8487})
			)
			(5
				(= body 2)
				(= face 1)
				(= hair 1)
				(= ear 2)
				(= page 11)
				(= phone {555-3787})
			)
			(6
				(= body 0)
				(= face 4)
				(= hair 2)
				(= ear 4)
				(= page 6)
				(= phone {555-2737})
			)
			(7
				(= body 0)
				(= face 3)
				(= hair 3)
				(= ear 1)
				(= page 12)
				(= phone {555-2867})
			)
			(8
				(= body 1)
				(= face 1)
				(= hair 1)
				(= ear 4)
				(= page 11)
				(= phone {555-3825})
			)
			(9
				(= body 2)
				(= face 0)
				(= hair 0)
				(= ear 3)
				(= page 14)
				(= phone {555-2868})
			)
			(10
				(= body 1)
				(= face 3)
				(= hair 2)
				(= ear 4)
				(= page 12)
				(= phone {555-3425})
			)
			(11
				(= body 0)
				(= face 5)
				(= hair 0)
				(= ear 0)
				(= page 6)
				(= phone {555-3642})
			)
			(12
				(= body 2)
				(= face 2)
				(= hair 2)
				(= ear 3)
				(= page 8)
				(= phone {555-5464})
			)
			(13
				(= body 1)
				(= face 1)
				(= hair 3)
				(= ear 5)
				(= page 14)
				(= phone {555-6262})
			)
			(14
				(= body 0)
				(= face 1)
				(= hair 1)
				(= ear 0)
				(= page 14)
				(= phone {555-8627})
			)
			(15
				(= body 2)
				(= face 4)
				(= hair 0)
				(= ear 2)
				(= page 6)
				(= phone {555-5633})
			)
			(16
				(= body 1)
				(= face 1)
				(= hair 3)
				(= ear 2)
				(= page 13)
				(= phone {555-5834})
			)
		)
		(aBody posn: 154 81 setLoop: 0 setCel: body)
		(aFace posn: 154 81 setLoop: 1 setCel: face)
		(aHair posn: 154 81 setLoop: 2 setCel: hair)
		(aEar posn: 154 81 setLoop: 3 setCel: ear)
		(RedrawCast)
		(Display 10 0 dsCOORD 60 176 dsCOLOR 1 dsBACKGROUND 3) ; "\04 1988 by Sierra On-Line, Inc."
	)

	(method (doit &tmp i)
		(if (and gDebugging (!= testRoom 10))
			(self newRoom: testRoom)
			(return)
		)
		(Format @gString 10 1) ; "555-"
		(Print 10 2 #at -1 144 #width 248 #font gSmallFont #edit @gString 11) ; "Please find this girl's picture in your little black book, then type her telephone number here:"
		(cls)
		(= i (ReadNumber @gString))
		(if (not (StrCmp @gString phone))
			(gCurRoom newRoom: 90)
		else
			(Print 10 3) ; "Sorry, but you need to spend more time staring at beautiful women! In order to play this game, you must have the original documentation. If you've lost your little black book, please telephone Sierra's Customer Support Department at the number printed on your disks."
			(if testing
				(Print 10 4) ; "Well, ok. Since it's you, you get another chance."
			else
				(= gQuit 1)
			)
		)
	)
)

