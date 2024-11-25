;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use SQRoom)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
)

(instance rm330 of SQRoom
	(properties
		picture 330
		style 41
	)

	(method (init)
		(Load rsVIEW 330)
		(LoadMany rsSOUND 126 133)
		(super init:)
		(proc0_14 {Space Quest X} global146)
		(guard init:)
		(sub setScript: subScript)
	)
)

(instance subScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sub setCycle: Fwd init: setMotion: MoveTo 106 101)
				(subTop init: setMotion: MoveTo 103 103 self)
			)
			(1
				(gLongSong2 stop:)
				(soundFX play:)
				(= seconds 3)
			)
			(2
				(soundFX number: 133 play:)
				(hatch init: setCycle: End self)
			)
			(3
				(= cycles 10)
			)
			(4
				(gEgo
					init:
					normal: 0
					view: 321
					x: 120
					y: 109
					loop: 8
					cel: 0
					cycleSpeed: 0
					setPri: 6
					illegalBits: 0
					setCycle: End self
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					posn: 134 104
					illegalBits: 0
					setPri: 6
					illegalBits: $1f40
					setCycle: Walk
					setMotion: MoveTo 202 91
				)
				(= cycles 20)
			)
			(6
				(zondra init: setCycle: End self)
			)
			(7
				(zondra
					view: 331
					setLoop: 2
					setCycle: Walk
					setPri: 6
					posn: 137 99
					setMotion: MoveTo 205 87 self
				)
				(gEgo setMotion: MoveTo 335 96)
			)
			(8
				(zondra setMotion: MoveTo 340 96)
				(guard
					view: 331
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 345 96 self
				)
				(= cycles 1)
			)
			(9
				(= cycles 25)
			)
			(10
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance sub of Actor
	(properties
		x -22
		y 101
		description {submarine}
		lookStr {This is the submarine which you cruised in aboard.}
		yStep 1
		view 330
		priority 3
		signal 18448
		xStep 2
	)
)

(instance subTop of Actor
	(properties
		x -25
		y 103
		description {submarine}
		lookStr {This is the submarine which you cruised in aboard.}
		yStep 1
		view 330
		loop 1
		cel 4
		priority 3
		signal 22544
		xStep 2
	)
)

(instance hatch of Prop
	(properties
		x 125
		y 104
		description {hatch}
		lookStr {It's a nifty entry/exit device.}
		view 330
		loop 2
		priority 5
		signal 18448
		cycleSpeed 1
	)
)

(instance guard of Actor
	(properties
		x 227
		y 103
		description {latex babe}
		lookStr {Hmm. I wonder if she has a boyfriend.}
		yStep 3
		view 331
		priority 6
		xStep 4
	)
)

(instance zondra of Actor
	(properties
		x 114
		y 85
		description {latex babe}
		lookStr {What a babe!}
		yStep 3
		view 321
		loop 9
		priority 7
		signal 16
		xStep 4
	)
)

(instance soundFX of Sound
	(properties
		number 126
	)
)

