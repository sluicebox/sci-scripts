;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm010 0
)

(local
	local0
)

(instance rm010 of PQRoom
	(properties
		picture 10
	)

	(method (init)
		(if (>= global105 18)
			(gCurRoom picture: 11)
		)
		(super init:)
		(HandsOff)
		(if
			(OneOf
				(gEgo view:)
				0
				1
				3
				8
				10
				11
				12
				16
				124
				125
				127
				165
				315
				333
			)
			(= local0 110)
		else
			(= local0 111)
		)
		(LoadMany rsVIEW 114 local0 (+ local0 2))
		(LoadMany rsSOUND 910 939)
		(flag setCycle: Fwd init:)
		(stopLight init: stopUpd:)
		(bkSound number: 913 loop: -1 play:)
		(proc0_17 5)
		(switch gPrevRoomNum
			(21
				(proc0_17 10)
				(self setScript: exitStation)
			)
			(12
				(self setScript: exitStation)
			)
			(41
				(self setScript: enterStation)
			)
			(else
				(self setScript: enterStation)
			)
		)
	)
)

(instance enterStation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
				(theme play:)
				(car view: local0 posn: 46 141 setLoop: 0 cel: 0 init:)
			)
			(1
				(ShowClock 1)
				(car
					view: local0
					posn: 46 141
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(car cel: 0 setLoop: 1 cycleSpeed: 6 setCycle: CT 3 1 self)
			)
			(3
				(if
					(OneOf
						(gEgo view:)
						0
						1
						3
						8
						10
						11
						12
						16
						124
						125
						127
						165
						315
						333
					)
					(skid number: 910 play:)
				)
				(= cycles 1)
			)
			(4
				(car setCycle: CT 6 1 self)
			)
			(5
				(skid stop:)
				(= cycles 1)
			)
			(6
				(car setCycle: End self)
			)
			(7
				(= seconds 1)
				(bkSound fade:)
			)
			(8
				(ShowClock 0)
				(switch gPrevRoomNum
					(5
						(gLongSong fade:)
						(gCurRoom newRoom: 18)
					)
					(41
						(gCurRoom newRoom: 21)
					)
					(else
						(gCurRoom newRoom: 12)
					)
				)
			)
		)
	)
)

(instance exitStation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(car
					view: (+ local0 2)
					loop: 0
					cel: 0
					posn: 34 138
					cycleSpeed: 6
					setCycle: End self
					init:
				)
				(skid number: 701 play:)
			)
			(4
				(car loop: 1 cel: 0 setCycle: End self)
				(bkSound fade:)
			)
			(5
				(ShowClock 0)
				(= global129 7)
				(= global130 5)
				(= global131 25)
				(= global132 180)
				(= global133 30)
				(if (== gPrevRoomNum 21)
					(gCurRoom newRoom: 41)
				else
					(gCurRoom newRoom: 25)
				)
			)
		)
	)
)

(instance car of Actor
	(properties)
)

(instance flag of Prop
	(properties
		x 128
		y 17
		view 114
		loop 4
		priority 15
		signal 16
		detailLevel 3
	)
)

(instance stopLight of Prop
	(properties
		x 153
		y 10
		view 114
		loop 3
		priority 15
		signal 16
	)
)

(instance skid of Sound
	(properties
		number 910
	)
)

(instance bkSound of Sound
	(properties)
)

(instance theme of Sound
	(properties
		flags 1
		number 939
	)
)

