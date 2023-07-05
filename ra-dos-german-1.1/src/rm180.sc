;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm180 0
)

(instance rm180 of LBRoom
	(properties
		picture 180
		style 10
		vanishingX 145
		vanishingY 126
	)

	(method (init)
		(LoadMany rsVIEW 151 181 185)
		(LoadMany rsSOUND 94 180)
		(self setRegions: 92) ; intro
		(gEgo
			view: 185
			setLoop: 5
			x: 325
			y: 195
			xStep: 1
			yStep: 1
			setPri: -1
			init:
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 305 189 222 168 319 175 319 189
					yourself:
				)
		)
		(nyCar3 addToPic:)
		(nyCar4 addToPic:)
		(WrapMusic init: 0 180 94)
		(nyCar1 init: setScript: sCarGo1)
		(p1 init: setScript: sP1Walk)
		(p2 init: setLoop: 1 setCycle: Walk setMotion: PolyPath 31 220)
		(p3 init: setLoop: 2 setCycle: Walk setMotion: PolyPath 137 172)
		(p4 init: setLoop: 4 setCycle: Walk setMotion: PolyPath 206 206)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 224 168 self)
			)
			(1
				((ScriptID 1881 2) modeless: 1) ; Laura
				(gMessager say: 1 0 0 0 self) ; "I'm not going to let a little bad luck ruin my day! Hello, New York! Laura Bow has arrived!"
			)
			(2
				(gEgo setLoop: 6 setMotion: PolyPath 245 168 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo dispose:)
				(creditTitle
					init:
					posn: 48 -20
					setPri: 15
					setMotion: MoveTo 48 93 self
				)
				(creditName
					init:
					posn: 62 245
					setPri: 15
					setMotion: MoveTo 62 132 self
				)
			)
			(5 0)
			(6
				(= seconds 3)
			)
			(7
				(creditTitle setMotion: MoveTo 48 -20 self)
				(creditName setMotion: MoveTo 62 210 self)
			)
			(8 0)
			(9
				(creditTitle
					loop: 8
					posn: -190 102
					setPri: -1
					setMotion: MoveTo 50 102 self
				)
				(creditName
					loop: 8
					posn: -190 138
					setPri: -1
					setMotion: MoveTo 50 138 self
				)
			)
			(10 0)
			(11
				(= seconds 3)
			)
			(12
				(creditTitle setMotion: MoveTo 465 102 self)
				(creditName setMotion: MoveTo 456 138 self)
			)
			(13 0)
			(14
				(gCurRoom newRoom: 190)
				(gGame setCursor: gNormalCursor)
				(self dispose:)
			)
		)
	)
)

(instance sCarGo1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nyCar1 setMotion: MoveTo -25 168 self)
			)
			(1
				(nyCar1
					loop: 0
					cel: 2
					posn: -25 182
					setMotion: MoveTo 120 158 self
				)
			)
			(2
				(nyCar1 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance sP1Walk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(p1 setLoop: 0 setCycle: Walk setMotion: PolyPath 136 170 self)
			)
			(1
				(p1 setLoop: 3 posn: 158 170 setMotion: PolyPath 220 220 self)
			)
			(2
				(p1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance nyCar1 of Actor
	(properties
		x 155
		y 153
		view 181
		loop 3
		cel 4
		signal 18432
	)
)

(instance p1 of Actor
	(properties
		x 197
		y 198
		yStep 1
		view 185
		xStep 1
	)
)

(instance p2 of Actor
	(properties
		x 138
		y 168
		yStep 1
		view 185
		loop 1
		xStep 1
	)
)

(instance p3 of Actor
	(properties
		x 186
		y 198
		yStep 1
		view 185
		loop 2
		xStep 1
	)
)

(instance p4 of Actor
	(properties
		x 155
		y 166
		yStep 1
		view 185
		loop 4
		xStep 1
	)
)

(instance creditTitle of Actor
	(properties
		x -156
		y 102
		view 151
		loop 7
		signal 26624
		moveSpeed 0
	)
)

(instance creditName of Actor
	(properties
		x -190
		y 138
		view 151
		loop 7
		cel 1
		signal 26624
		moveSpeed 0
	)
)

(instance nyCar3 of View
	(properties
		x 235
		y 153
		view 181
		loop 2
		signal 18432
	)
)

(instance nyCar4 of View
	(properties
		x 230
		y 200
		view 181
		loop 5
		cel 1
		signal 18432
	)
)

