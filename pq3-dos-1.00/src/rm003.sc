;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm003 0
)

(instance rm003 of PQRoom
	(properties
		picture 3
		style 2
	)

	(method (init)
		(LoadMany rsVIEW 107 106 108)
		(super init:)
		(head1 init:)
		(head2 init:)
		(self setRegions: 127 setScript: creditScript) ; intro
	)
)

(instance creditScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(credit0 init: loop: 2 cel: 0 posn: 218 61)
				(= seconds 1)
			)
			(2
				(head1 setCycle: End self)
			)
			(3
				(credit1 init: loop: 2 cel: 1 posn: 215 100)
				(= seconds 1)
			)
			(4
				(head2 setCycle: End self)
			)
			(5
				(credit2 init: loop: 2 cel: 2 posn: 206 140)
				(= seconds 3)
			)
			(6
				(= seconds 2)
			)
			(7
				(head1 dispose:)
				(head2 dispose:)
				(credit0 dispose:)
				(credit1 dispose:)
				(credit2 dispose:)
				(gCurRoom style: 3 drawPic: 2)
				(head3 init:)
				(= cycles 2)
			)
			(8
				(credit0 init: view: 106 loop: 2 cel: 0 posn: 114 59)
				(= seconds 3)
			)
			(9
				(head3 setCycle: End self)
			)
			(10
				(credit1 init: view: 106 loop: 2 cel: 1 posn: 112 106)
				(= seconds 3)
			)
			(11
				(= seconds 2)
			)
			(12
				(credit2 init: view: 106 loop: 2 cel: 2 posn: 106 154)
				(= seconds 3)
			)
			(13
				(= seconds 2)
			)
			(14
				(head3 dispose:)
				(credit0 dispose:)
				(credit1 dispose:)
				(credit2 dispose:)
				(gCurRoom style: 2 drawPic: 3)
				(= cycles 2)
			)
			(15
				(car init: setCycle: End self)
			)
			(16
				(car
					loop: 1
					cel: 1
					x: 14
					y: 61
					priority: 10
					signal: 16
					setCycle: End self
				)
			)
			(17
				(car loop: 2 cel: 0 posn: 42 70 setPri: 14 setCycle: End self)
			)
			(18
				(car setPri: 15 posn: 21 74)
				(= cycles 3)
			)
			(19
				(car posn: 12 78)
				(= cycles 3)
			)
			(20
				(car posn: -20 82)
				(= cycles 3)
			)
			(21
				(car dispose:)
				(= cycles 1)
			)
			(22
				(credit0 init: view: 108 loop: 3 cel: 0 posn: 208 55)
				(= seconds 3)
			)
			(23
				(chaseCar init: setCycle: End self)
			)
			(24
				(chaseCar loop: 5 cel: 0 x: 62 y: 50 setCycle: End self)
			)
			(25
				(credit1 init: view: 108 loop: 3 cel: 1 posn: 205 98)
				(= seconds 3)
			)
			(26
				(= seconds 1)
			)
			(27
				(gLongSong fade:)
				(credit0 dispose:)
				(credit1 dispose:)
				(car dispose:)
				(chaseCar dispose:)
				(gCurRoom drawPic: 98 10)
				(= seconds 2)
			)
			(28
				(gCurRoom style: 10 newRoom: 5)
			)
		)
	)
)

(instance credit0 of Prop
	(properties
		view 107
		signal 1
	)
)

(instance credit1 of Prop
	(properties
		view 107
		signal 1
	)
)

(instance credit2 of Prop
	(properties
		view 107
		signal 1
	)
)

(instance head1 of Prop
	(properties
		x 63
		y 56
		view 107
		loop 1
	)
)

(instance head2 of Prop
	(properties
		x 64
		y 157
		view 107
		signal 16384
	)
)

(instance head3 of Prop
	(properties
		x 261
		y 157
		view 106
	)
)

(instance car of Actor
	(properties
		x 24
		y 63
		view 108
		cycleSpeed 9
	)
)

(instance chaseCar of Actor
	(properties
		x 26
		y 47
		view 108
		loop 4
		cycleSpeed 9
	)
)

