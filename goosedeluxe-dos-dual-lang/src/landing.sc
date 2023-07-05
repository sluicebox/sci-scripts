;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use MGNarrator)
(use Head)
(use n411)
(use ROsc)
(use Motion)
(use Actor)
(use System)

(public
	landing 0
)

(instance landing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mother init:)
				(momHead
					init:
						mother
						(CelHigh (mother view:) (mother loop:) (mother cel:))
				)
				(FakeEgo init: setCycle: Fwd setMotion: MoveTo 266 22 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(FakeEgo
					view: (+ global114 21)
					illegalBits: 0
					setCel: 1
					posn: 289 106
					setPri: -1
					setLoop: 1 1
					cycleSpeed: 6
					moveSpeed: 2
					xStep: 2
					setPri: 14
					setMotion: MoveTo 198 124 self
				)
			)
			(3
				(FakeEgo
					setCycle: 0
					setLoop: 2
					setCel: 0
					posn: (+ (FakeEgo x:) -10) 141
					setPri: -1
					setMotion: MoveTo 134 141
				)
				(= ticks 66)
			)
			(4
				(FakeEgo setCycle: End self)
			)
			(5
				(FakeEgo setMotion: 0)
				(= ticks 18)
			)
			(6
				(FakeEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(gLongSong fade:)
				(gEgo
					view: global114
					setCycle: 0
					posn: (FakeEgo x:) (FakeEgo y:)
					init:
				)
				(proc0_7 gEgo mother)
				(global109 init: posn: (+ (FakeEgo x:) 1) (+ (FakeEgo y:) 2))
				(FakeEgo dispose:)
				(= cycles 10)
			)
			(8
				(global109
					setMotion:
						MoveTo
						(+ (global109 x:) 35)
						(+ (global109 y:) 5)
						self
				)
			)
			(9
				(gLongSong stop:)
				(global109
					setMotion: MoveTo (global109 x:) (- (global109 y:) 10) self
				)
				(= cycles 1)
			)
			(10
				(global109
					setMotion: MoveTo (- (global109 x:) 5) (global109 y:) self
				)
			)
			(11
				(= global516 gNarrator)
				(= gNarrator mgNarrator)
				(gMessager say: 1 1 26 0 self 0) ; "Hello. I'm Mother Goose. I'm so glad you came! My nursery rhymes are all mixed up. Can you help me fix them?"
			)
			(12
				(= gNarrator global516)
				(proc411_1)
				(momHead dispose:)
				(mother setCycle: Walk setMotion: MoveTo 82 135 self)
			)
			(13
				(mother loop: 3)
				(global111 setCycle: End self)
				(gSfx number: 38 play:)
			)
			(14
				(mother setMotion: MoveTo 82 116 self)
			)
			(15
				(mother setPri: 113 setMotion: MoveTo 108 116 self)
			)
			(16
				(global111 setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(17
				(mother dispose:)
				(= cycles 3)
			)
			(18
				(gLongSong number: 600 loop: -1 play:)
				(= cycles 3)
			)
			(19
				(gGame handsOn:)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance FakeEgo of Actor
	(properties
		x 190
		y 22
		view 16
		signal 26625
		cycleSpeed 4
		illegalBits 0
		xStep 1
		moveSpeed 1
	)
)

(instance mother of Actor
	(properties
		x 80
		y 141
		view 92
		loop 4
		illegalBits 0
	)
)

(instance momHead of Head
	(properties
		x 84
		y 103
		view 92
		loop 5
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z
				(-
					(+
						(client z:)
						(CelHigh (client view:) (client loop:) (client cel:))
					)
					1
				)
			)
		)
		(super doit:)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(26
				(momHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(26
				(momHead cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

