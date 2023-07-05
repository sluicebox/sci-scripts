;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm860 0
)

(instance rm860 of LLRoom
	(properties
		picture 860
		south 870
	)

	(method (init)
		(LoadMany rsVIEW 860)
		(LoadMany rsSOUND 861 862 853 800 801 802)
		(super init:)
		(HandsOff)
		(elevator init:)
		(SetFFRoom 870)
		(self setScript: sCartoon)
	)

	(method (doit)
		(switch (elevator y:)
			(32
				(TPrint 860 0 67 -1 15 70 280) ; "Your "elevator" descends through the K-RAP atrium, past floor after floor of offices. At least there are no workers here to see you! This is just like a recurring nightmare of yours...."
				(zwooshSound play:)
				(heads2 init: setScript: sPeeping)
			)
			(76
				(zwooshSound play:)
				(heads3 init: setScript: sPeeping)
			)
			(94
				(zwooshSound play:)
				(heads5 init: setScript: sPeeping)
				(heads7 init: setScript: sPeeping)
				(heads9 init: setScript: sPeeping)
			)
			(120
				(zwooshSound play:)
				(heads8 init: setScript: sPeeping)
				(heads10 init: setScript: sPeeping)
			)
			(138
				(zwooshSound play:)
				(heads4 init: setScript: sPeeping)
			)
			(148
				(zwooshSound play:)
				(heads1 init: setScript: sPeeping)
				(heads6 init: setScript: sPeeping)
			)
			(178
				(TPrint 860 1) ; "Oh, Patti! You're so em-bare-assed!!"
			)
		)
	)
)

(instance elevator of Actor
	(properties
		x 153
		view 860
		moveSpeed 8
	)
)

(instance heads1 of Prop
	(properties
		x 116
		y 129
		view 860
		loop 1
	)
)

(instance heads2 of Prop
	(properties
		x 130
		y 23
		view 860
		loop 2
	)
)

(instance heads3 of Prop
	(properties
		x 178
		y 45
		view 860
		loop 3
	)
)

(instance heads4 of Prop
	(properties
		x 188
		y 129
		view 860
		loop 4
	)
)

(instance heads5 of Prop
	(properties
		x 285
		y 53
		view 860
		loop 5
	)
)

(instance heads6 of Prop
	(properties
		x 42
		y 96
		view 860
		loop 6
	)
)

(instance heads7 of Prop
	(properties
		x 12
		y 53
		view 860
		loop 7
	)
)

(instance heads8 of Prop
	(properties
		x 220
		y 98
		view 860
		loop 8
	)
)

(instance heads9 of Prop
	(properties
		x 118
		y 70
		view 860
		loop 1
	)
)

(instance heads10 of Prop
	(properties
		x 83
		y 100
		view 860
		loop 1
	)
)

(instance zwooshSound of Sound
	(properties
		number 862
		priority 9
	)
)

(instance wolfSound of Sound
	(properties
		number 861
		priority 10
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elevator
					setCycle: 0
					setLoop: 0
					setPri: 1
					setMotion: MoveTo 153 242 self
				)
			)
			(1
				(gCurRoom newRoom: 870)
			)
		)
	)
)

(instance sPeeping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(wolfSound play:)
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

