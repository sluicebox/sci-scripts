;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use eRS)
(use Motion)
(use Actor)
(use System)

(public
	rm010 0
)

(instance rm010 of PQRoom
	(properties
		picture 10
	)

	(method (init)
		(Load rsVIEW 101)
		(Load rsVIEW 100)
		(flag init:)
		(stopLight init:)
		(car1 init:)
		(car2 init:)
		(car3 init:)
		(super init: &rest)
		(self setScript: enterStation)
	)

	(method (dispose)
		(gLongSong2 flags: (| (gLongSong2 flags:) $ffff))
		(super dispose: &rest)
	)
)

(instance enterStation of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== (gLongSong2 prevSignal:) -1)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2
					flags: (& (gLongSong2 flags:) $0000)
					number: 100
					loop: 1
					play:
				)
				(= seconds 2)
				(car1 setMotion: MoveTo 153 41 self)
			)
			(1)
			(2
				(car1 setCycle: End setMotion: MoveTo 328 89)
				(car init: setMotion: MoveTo 44 143 self)
				(stopLight setCycle: Beg)
			)
			(3
				(car cel: 0 setCycle: End self)
				(car2 setMotion: MoveTo -27 22)
				(car3 setMotion: MoveTo -27 22)
			)
			(4
				(car cel: 0 loop: (+ (car loop:) 1) setCycle: End)
			)
			(5
				(car dispose:)
				(car1 dispose:)
				(car2 dispose:)
				(car3 dispose:)
				(gCurRoom newRoom: (if (== gPrevRoomNum 1) 12 else 11))
			)
		)
	)
)

(instance flag of Prop
	(properties
		x 128
		y 17
		view 101
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance stopLight of Prop
	(properties
		x 153
		y 10
		view 101
		loop 3
		cel 3
		priority 2
		signal 16400
	)
)

(instance car of Actor
	(properties
		x 62
		y 163
		view 100
		signal 16384
	)

	(method (init)
		(self
			setLoop:
				(switch global207
					(914 0)
					(105 4)
					(104 2)
				)
		)
		(super init: &rest)
	)
)

(instance car1 of Actor
	(properties
		x 12
		y 2
		view 101
		loop 1
		signal 18448
	)
)

(instance car2 of Actor
	(properties
		x 143
		y 18
		view 101
		loop 4
		signal 18448
	)
)

(instance car3 of Actor
	(properties
		x 171
		y 17
		view 101
		loop 4
		cel 1
		signal 18448
	)
)

