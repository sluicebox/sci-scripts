;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
)

(instance rm150 of LBRoom
	(properties
		picture 150
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 151 150)
		(LoadMany rsSOUND 150)
		(self setRegions: 92) ; intro
		(super init:)
		(gGameMusic1 number: 150 flags: 1 loop: -1 play:)
		(lauraTrain init:)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lauraTrain setMotion: MoveTo -245 56 self)
				(= seconds 2)
			)
			(1
				(creditTitle init: setMotion: MoveTo 35 107 self)
				(creditName init: setMotion: MoveTo 35 151 self)
			)
			(2 0)
			(3
				(= seconds 3)
			)
			(4
				(creditTitle setMotion: MoveTo -232 107 self)
				(creditName setMotion: MoveTo -250 151 self)
			)
			(5 0)
			(6
				(= seconds 3)
			)
			(7
				(creditTitle
					posn: 333 130
					loop: 5
					setMotion: MoveTo -479 130 self
				)
				(creditName
					posn: 590 130
					loop: 5
					setMotion: MoveTo -222 130 self
				)
			)
			(8 0)
			(9
				(= seconds 3)
			)
			(10
				(creditTitle
					posn: -236 119
					loop: 6
					setMotion: MoveTo 42 119 self
				)
				(creditName
					posn: -135 146
					loop: 6
					setMotion: MoveTo 143 146 self
				)
			)
			(11 0)
			(12
				(= seconds 3)
			)
			(13
				(creditTitle setMotion: MoveTo -246 119 self)
				(creditName setMotion: MoveTo -145 146 self)
			)
			(14 0)
			(15 0)
			(16
				(gCurRoom newRoom: 155)
				(self dispose:)
			)
		)
	)
)

(instance lauraTrain of Actor
	(properties
		x 300
		y 56
		view 150
		moveSpeed 10
	)
)

(instance creditTitle of Actor
	(properties
		x 35
		y 200
		view 151
		loop 4
		signal 26624
		moveSpeed 0
	)
)

(instance creditName of Actor
	(properties
		x 35
		y 244
		view 151
		loop 4
		cel 1
		signal 26624
		moveSpeed 0
	)
)

