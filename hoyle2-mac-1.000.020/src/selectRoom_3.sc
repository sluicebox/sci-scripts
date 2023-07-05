;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	selectRoom 0
)

(class CardBack of Feature
	(properties
		number 0
		view 200
	)

	(method (init)
		(cardbacks add: self)
		(gMainKeyMouseList add: self)
		(proc0_1 view 0 number x y 8)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= (event type:) $0040) ; direction
				(<= x (event x:) (+ x 35))
				(<= y (event y:) (+ y 43))
			)
			(= global300 number)
			(outline x: x y: y init:)
		)
	)
)

(class BackGround of Feature
	(properties
		number 0
		view 210
	)

	(method (init)
		(backgrounds add: self)
		(gMainKeyMouseList add: self)
		(proc0_1 view 0 number x y 8)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= (event type:) $0040) ; direction
				(<= x (event x:) (+ x 35))
				(<= y (event y:) (+ y 21))
			)
			(= global679 number)
			(outline2 x: x y: y init:)
		)
	)
)

(instance selectRoom of Rm
	(properties)

	(method (init)
		(= picture 12)
		(super init:)
		(= global686 1)
		(cardbacks add:)
		(backgrounds add:)
		(cardBack1 init:)
		(cardBack2 init:)
		(cardBack3 init:)
		(cardBack4 init:)
		(cardBack5 init:)
		(cardBack6 init:)
		(cardBack7 init:)
		(cardBack8 init:)
		(cardBack9 init:)
		(cardBack10 init:)
		(cardBack11 init:)
		(cardBack12 init:)
		(cardBack13 init:)
		(cardBack14 init:)
		(cardBack15 init:)
		(cardBack16 init:)
		(background1 init:)
		(background2 init:)
		(background3 init:)
		(background4 init:)
		(background5 init:)
		(background6 init:)
		(background7 init:)
		(background8 init:)
		(background9 init:)
		(background10 init:)
		(background11 init:)
		(background12 init:)
		(background13 init:)
		(background14 init:)
		(background15 init:)
		(background16 init:)
		(= global638 3)
		(= global639 8)
		(outline
			x: ((cardbacks at: global300) x:)
			y: ((cardbacks at: global300) y:)
			init:
		)
		(outline2
			x: ((backgrounds at: global679) x:)
			y: ((backgrounds at: global679) y:)
			init:
		)
		(ok init:)
		(Display
			(Format @global100 3 0) ; "Select Deck"
			dsFONT
			100
			dsCOLOR
			(if global679 15 else 0)
			dsBACKGROUND
			-1
			dsWIDTH
			300
			dsCOORD
			10
			3
			dsALIGN
			alCENTER
		)
		(Display
			(Format @global100 3 0) ; "Select Deck"
			dsFONT
			0
			dsCOLOR
			(if global679 0 else 7)
			dsBACKGROUND
			-1
			dsWIDTH
			300
			dsCOORD
			10
			3
			dsALIGN
			alCENTER
		)
		(Display
			(Format @global100 3 1) ; "Select Background"
			dsFONT
			100
			dsCOLOR
			(if global679 15 else 0)
			dsBACKGROUND
			-1
			dsWIDTH
			300
			dsCOORD
			10
			109
			dsALIGN
			alCENTER
		)
		(Display
			(Format @global100 3 1) ; "Select Background"
			dsFONT
			0
			dsCOLOR
			(if global679 0 else 7)
			dsBACKGROUND
			-1
			dsWIDTH
			300
			dsCOORD
			10
			109
			dsALIGN
			alCENTER
		)
	)

	(method (doit)
		(super doit:)
		(Wait 5)
	)

	(method (handleEvent event)
		(cardbacks eachElementDo: #handleEvent event)
		(backgrounds eachElementDo: #handleEvent event)
		(ok handleEvent: event)
	)

	(method (dispose)
		(gMainKeyMouseList empty:)
		(cardbacks eachElementDo: #dispose)
		(backgrounds eachElementDo: #dispose)
		(cardbacks dispose:)
		(backgrounds dispose:)
		(CardBack dispose:)
		(BackGround dispose:)
		(super dispose:)
	)
)

(instance cardbacks of List
	(properties)
)

(instance backgrounds of List
	(properties)
)

(instance outline of View
	(properties
		view 200
		loop 4
	)

	(method (init)
		(self posn: x y setPri: 8 setLoop: loop)
		(super init:)
	)
)

(instance outline2 of View
	(properties
		view 200
		loop 4
		cel 1
	)

	(method (init)
		(self posn: x y setPri: 8 setLoop: loop)
		(super init:)
	)
)

(instance ok of View
	(properties
		y 175
		x 144
		view 200
		loop 3
	)

	(method (init)
		(self posn: x y setPri: 8 setLoop: loop)
		(gMainKeyMouseList add: self)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(and
				(!= (event type:) $0040) ; direction
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(gOptions_sol doit: 1)
			(= gNewRoomNum 2) ; selectRoom
		)
	)
)

(instance cardBack1 of CardBack
	(properties
		y 15
		x 10
	)
)

(instance cardBack2 of CardBack
	(properties
		y 15
		x 48
		number 1
	)
)

(instance cardBack3 of CardBack
	(properties
		y 15
		x 86
		number 2
	)
)

(instance cardBack4 of CardBack
	(properties
		y 15
		x 124
		number 3
	)
)

(instance cardBack5 of CardBack
	(properties
		y 15
		x 162
		number 4
	)
)

(instance cardBack6 of CardBack
	(properties
		y 15
		x 200
		number 5
	)
)

(instance cardBack7 of CardBack
	(properties
		y 15
		x 238
		number 6
	)
)

(instance cardBack8 of CardBack
	(properties
		y 15
		x 276
		number 7
	)
)

(instance cardBack9 of CardBack
	(properties
		y 62
		x 10
		number 8
	)
)

(instance cardBack10 of CardBack
	(properties
		y 62
		x 48
		number 9
	)
)

(instance cardBack11 of CardBack
	(properties
		y 62
		x 86
		number 10
	)
)

(instance cardBack12 of CardBack
	(properties
		y 62
		x 124
		number 11
	)
)

(instance cardBack13 of CardBack
	(properties
		y 62
		x 162
		number 12
	)
)

(instance cardBack14 of CardBack
	(properties
		y 62
		x 200
		number 13
	)
)

(instance cardBack15 of CardBack
	(properties
		y 62
		x 238
		number 14
	)
)

(instance cardBack16 of CardBack
	(properties
		y 62
		x 276
		number 15
	)
)

(instance background1 of BackGround
	(properties
		y 121
		x 10
	)
)

(instance background2 of BackGround
	(properties
		y 121
		x 48
		number 1
	)
)

(instance background3 of BackGround
	(properties
		y 121
		x 86
		number 2
	)
)

(instance background4 of BackGround
	(properties
		y 121
		x 124
		number 3
	)
)

(instance background5 of BackGround
	(properties
		y 121
		x 162
		number 4
	)
)

(instance background6 of BackGround
	(properties
		y 121
		x 200
		number 5
	)
)

(instance background7 of BackGround
	(properties
		y 121
		x 238
		number 6
	)
)

(instance background8 of BackGround
	(properties
		y 121
		x 276
		number 7
	)
)

(instance background9 of BackGround
	(properties
		y 146
		x 10
		number 8
	)
)

(instance background10 of BackGround
	(properties
		y 146
		x 48
		number 9
	)
)

(instance background11 of BackGround
	(properties
		y 146
		x 86
		number 10
	)
)

(instance background12 of BackGround
	(properties
		y 146
		x 124
		number 11
	)
)

(instance background13 of BackGround
	(properties
		y 146
		x 162
		number 12
	)
)

(instance background14 of BackGround
	(properties
		y 146
		x 200
		number 13
	)
)

(instance background15 of BackGround
	(properties
		y 146
		x 238
		number 14
	)
)

(instance background16 of BackGround
	(properties
		y 146
		x 276
		number 15
	)
)

