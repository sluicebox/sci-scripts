;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use rmnScript)
(use SQRoom)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm345 0
)

(instance rm345 of SQRoom
	(properties
		picture 345
	)

	(method (init)
		(proc0_14 {Space Quest X} global146)
		(switch gPrevRoomNum
			(340
				(eyebrows init:)
				(mouth init:)
				(arm init:)
				(coil init:)
				(wizz init:)
				(self setScript: threatScript)
			)
			(else
				(eyebrows init:)
				(mouth init:)
				(arm init:)
				(coil init:)
				(wizz init:)
				(self setScript: threatScript)
			)
		)
		(super init:)
	)
)

(instance threatScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 11)
				(self
					save1:
						(proc0_12
							{"Let me introduce you to a friend of mine."}
							67
							2
							1
							28
							global130
							29
							global155
							30
							1
							70
							315
						)
				)
				(= seconds 15)
			)
			(3
				(arm z: 0 setCycle: Beg self)
			)
			(4
				(= start state)
				(coil z: 0 setPri: 15 setCel: 1)
				(wizz z: 0 setCycle: End self)
				(= cycles 5)
			)
			(5
				(coil setCel: 0)
				(wizz setCycle: Beg self)
			)
			(6
				(if (< (++ register) 4)
					(self init:)
				else
					(wizz dispose:)
					(= cycles 1)
				)
			)
			(7
				(eyebrows setCel: 0)
				(mouth setCycle: RandCycle 25)
				(self
					save1:
						(proc0_12
							{"This is the EpiRip 357 the most powerful hand hair remover in the universe and capable of shaving your legs clean off."}
							67
							2
							1
							28
							global130
							29
							global155
							30
							1
							70
							315
						)
				)
				(= seconds 15)
			)
			(9
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 20)
				(self
					save1:
						(proc0_12
							{"I've always wanted to see a man shave with one of these, but I guess you'll do."}
							67
							2
							1
							28
							global130
							29
							global155
							30
							1
							70
							315
						)
				)
				(= seconds 15)
			)
			(11
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 10)
				(self
					save1:
						(proc0_12
							{"Now you will know the meaning of the word, PAIN."}
							67
							2
							1
							28
							global130
							29
							global155
							30
							1
							70
							315
						)
				)
				(= seconds 15)
			)
			(13
				(self setScript: shockScript)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance shockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wizz dispose:)
				(gCurRoom overlay: 346)
				(gLongSong init: number: 2 loop: -1 vol: 127 playBed:)
				(= cycles 8)
			)
			(1
				(face init:)
				(arm z: -1000)
				(= cycles 5)
			)
			(2
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance face of Prop
	(properties
		x 142
		y 88
		view 345
		loop 2
	)
)

(instance eyebrows of Prop
	(properties
		x 138
		y 62
		view 345
	)
)

(instance mouth of Prop
	(properties
		x 146
		y 87
		view 345
		loop 1
	)
)

(instance arm of Prop
	(properties
		x 109
		y 189
		z -1000
		view 345
		loop 3
		cel 3
	)
)

(instance coil of Prop
	(properties
		x 136
		y 149
		z -1000
		view 345
		loop 4
		cel 1
	)
)

(instance wizz of Prop
	(properties
		x 176
		y 86
		z -1000
		view 345
		loop 5
	)
)

