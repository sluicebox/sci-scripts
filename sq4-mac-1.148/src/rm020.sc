;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm020 0
)

(local
	local0
)

(instance rm020 of SQRoom
	(properties
		picture 20
		style 10
	)

	(method (init &tmp [temp0 50])
		(LoadMany rsVIEW 20 21)
		(super init:)
		(self setRegions: 707) ; intro
		(switch gPrevRoomNum
			(15
				(tr
					view: 21
					setLoop: 0
					cel: 0
					posn: 237 94
					setCycle: Walk
					init:
				)
				(roger
					view: 21
					setLoop: 2
					cel: 0
					posn: 254 91
					setCycle: Walk
					init:
				)
				(self setScript: firstTimeScript)
			)
			(else
				(roger view: 20 setLoop: 5 setCel: 0 posn: 174 111 init:)
				(tr view: 20 setLoop: 0 cel: 0 posn: 195 116 init:)
				(self setScript: ripScript)
			)
		)
	)
)

(instance ripScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 8)
			(roger x: (- (roger x:) register))
			(++ register)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= local0
					(proc0_12
						{"We've got to do this\nfast! Shield your eyes!"}
						67
						60
						15
						70
						250
						28
						global136
						29
						global129
						30
						1
					)
				)
				(= seconds 3)
			)
			(2
				(gLongSong2 number: 121 loop: 1 vol: 127 play:)
				(roger setCycle: End)
				(tr setPri: (+ (roger priority:) 1) setCycle: End self)
			)
			(3
				(proc0_12 local0)
				(tr setLoop: 1 cel: 0 setCycle: End self)
				(gLongSong2 number: 821 play:)
				(rip init: cycleSpeed: 0 setCycle: Fwd)
			)
			(4
				(tr stopUpd:)
				(roger stopUpd:)
				(= seconds 3)
			)
			(5
				(proc0_12
					{"Jump into the Time Rip! Do it NOW! You've got to! If I take the time to explain we're both parking lot pizza! You'll understand soon!"}
					67
					30
					15
					70
					280
					28
					global136
					29
					global129
					30
					1
				)
				(gLongSong2 number: 822 play:)
				(rip setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(rip setLoop: 4 setCel: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(7
				(roger setLoop: 6 cel: 0 setCycle: End self)
			)
			(8
				(rip setPri: 11)
				(roger setPri: 12 setStep: 7 1 setMotion: MoveTo 105 115 self)
			)
			(9
				(rip setLoop: 3 cel: 16 setCycle: Beg self)
			)
			(10
				(gLongSong2 fade:)
				(rip dispose:)
				(= cycles 3)
			)
			(11
				(gCurRoom newRoom: (if (== gPrevRoomNum 19) 21 else 19))
			)
		)
	)
)

(instance firstTimeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tr setMotion: MoveTo 196 110 self)
				(roger setMotion: MoveTo 174 113 self)
			)
			(1
				(tr view: 5 setLoop: 4 posn: 196 108)
			)
			(2
				(roger view: 20 setLoop: 5 setCel: 0 posn: 174 111)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 19)
			)
		)
	)
)

(instance tr of Actor
	(properties
		view 21
		priority 11
		signal 16400
		xStep 4
	)
)

(instance roger of Actor
	(properties
		priority 12
		signal 16
		illegalBits 0
		xStep 4
	)
)

(instance rip of Prop
	(properties
		x 122
		y 92
		view 20
		loop 2
		priority 14
		signal 16
	)
)

