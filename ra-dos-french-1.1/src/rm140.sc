;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use PolyPath)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm140 0
)

(instance rm140 of LBRoom
	(properties
		picture 140
		style 10
		vanishingX 7
		vanishingY 54
	)

	(method (init)
		(LoadMany rsVIEW 151 830 142)
		(LoadMany rsSOUND 140)
		(self setRegions: 92) ; intro
		(gEgo
			init:
			view: 830
			loop: 3
			cel: 1
			posn: 167 158
			setScale: Scaler 125 0 190 24
			cycleSpeed: 6
		)
		(super init:)
		(dad init:)
		(gGameMusic1 number: 140 flags: 1 loop: -1 play:)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1880 1) ; Dad
					disposeWhenDone: 0
					x: 5
					y: 5
					textX: 10
					textY: 140
					talkWidth: 280
				)
				((ScriptID 1881 2) ; Laura
					disposeWhenDone: 0
					x: 211
					y: 5
					textX: -196
					textY: 140
					talkWidth: 280
				)
				(= cycles 1)
			)
			(1
				(gNarrator x: 60 y: 100 keepWindow: 0)
				(gMessager say: 1 0 0 0 self) ; "New Orleans -- One Week Later"
			)
			(2
				(gEgo setMotion: PolyPath 167 145 self)
			)
			(3
				(gEgo hide:)
				(dad loop: 0 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(dad setCycle: Beg self)
			)
			(6
				(gEgo show: setLoop: 4 setMotion: MoveTo 299 340 self)
				(= cycles 1)
			)
			(7
				(dad
					loop: 1
					cel: 0
					posn: 168 143
					cycleSpeed: 10
					setCycle: CT 6 1 self
				)
			)
			(8
				(= ticks 20)
			)
			(9
				(dad setCycle: CT 4 -1 self)
			)
			(10
				(= ticks 20)
			)
			(11
				(dad setCycle: CT 6 1 self)
			)
			(12
				(dad setCycle: Beg self)
			)
			(13 0)
			(14
				(dad addToPic:)
				(creditTitle init: setPri: 15 setMotion: MoveTo 50 82 self)
				(creditName init: setPri: 15 setMotion: MoveTo 107 125 self)
			)
			(15 0)
			(16
				(= seconds 3)
			)
			(17
				(creditTitle setMotion: MoveTo -200 82 self)
				(creditName setMotion: MoveTo 107 209 self)
			)
			(18 0)
			(19
				(gCurRoom newRoom: 150)
				(self dispose:)
			)
		)
	)
)

(instance dad of Actor
	(properties
		x 170
		y 143
		view 142
		loop 1
		signal 16384
		cycleSpeed 10
	)
)

(instance creditTitle of Actor
	(properties
		x 50
		y -2
		view 151
		loop 3
		signal 26624
		moveSpeed 0
	)
)

(instance creditName of Actor
	(properties
		x 230
		y 125
		view 151
		loop 3
		cel 1
		signal 26624
		moveSpeed 0
	)
)

