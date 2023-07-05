;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use RandCycle)
(use Sound)
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
		(proc0_14 10)
		(switch gPrevRoomNum
			(340
				(eyebrows init:)
				(mouth init:)
				(arm init:)
				(coil init:)
				(wizz init:)
				(wizzSfx init:)
				(armSFX init:)
				(self setScript: threatScript)
			)
			(else
				(eyebrows init:)
				(mouth init:)
				(arm init:)
				(coil init:)
				(wizz init:)
				(wizzSfx init:)
				(armSFX init:)
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
				(gLongSong hold: 0)
				(HandsOff)
				(= seconds 3)
			)
			(1
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 25)
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
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 6)
			)
			(3
				(gLongSong pause: 1)
				(armSFX play:)
				(arm z: 0 setPri: 13 setCycle: Beg)
				(= cycles 30)
			)
			(4
				(armSFX dispose:)
				(gLongSong pause: 0)
				(wizzSfx play:)
				(= cycles 1)
			)
			(5
				(= start state)
				(coil z: 0 setPri: 14 setCel: 1)
				(wizz z: 0 setCycle: End self)
				(= cycles 5)
			)
			(6
				(coil setCel: 0)
				(wizz setCycle: Beg self)
			)
			(7
				(if (< (++ register) 10)
					(self init:)
				else
					(wizz dispose:)
					(wizzSfx dispose:)
					(= cycles 1)
				)
			)
			(8
				(eyebrows setCel: 0)
				(mouth setCycle: RandCycle 35)
				(self
					save1:
						(proc0_12
							{"This is the EpiRip 357, the most powerful hand hair remover in the universe and it's capable of shaving your legs clean off."}
							67
							2
							1
							28
							global130
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(10
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 35)
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
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(12
				(eyebrows setCel: 1)
				(mouth setCycle: RandCycle 25)
				(self
					save1:
						(proc0_12
							{"Now you will know the meaning of the word PAIN."}
							67
							2
							1
							28
							global130
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 8)
			)
			(14
				(self setScript: shockScript)
			)
			(else
				(self restore:)
				(mouth setCycle: 0)
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
				(roarSFX init: play:)
				(face init:)
				(arm z: -1000)
				(= seconds 4)
			)
			(1
				(gLongSong init: number: 2 loop: -1 vol: 127 flags: 1 playBed:)
				(= cycles 20)
			)
			(2
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance wizzSfx of Sound
	(properties
		number 157
		loop -1
	)
)

(instance roarSFX of Sound
	(properties
		number 828
	)
)

(instance armSFX of Sound
	(properties
		number 866
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
		priority 13
	)
)

(instance coil of Prop
	(properties
		x 136
		y 148
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

