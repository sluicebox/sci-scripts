;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Sound)
(use Motion)
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
		(thoreenMouth init:)
		(thoreenEyes init:)
		(thoreenTalker init: 0 thoreenEyes thoreenMouth)
		(arm init:)
		(coil init:)
		(wizz init:)
		(wizzSfx init:)
		(armSFX init:)
		(self setScript: threatScript)
		(super init:)
	)
)

(instance threatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong hold: 0)
				(HandsOff)
				(= seconds 3)
			)
			(1
				(thoreenTalker ; "Let me introduce you to a friend of mine."
					say:
						3
						self
						2
						64
						2
						1
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(2
				(gLongSong pause: 1)
				(armSFX play:)
				(arm z: 0 setPri: 13 setCycle: Beg)
				(= cycles 30)
			)
			(3
				(armSFX dispose:)
				(gLongSong pause: 0)
				(wizzSfx play:)
				(= cycles 1)
			)
			(4
				(= start state)
				(coil z: 0 setPri: 14 setCel: 1)
				(wizz z: 0 setCycle: End self)
				(= cycles 5)
			)
			(5
				(coil setCel: 0)
				(wizz setCycle: Beg self)
			)
			(6
				(if (< (++ register) 10)
					(self init:)
				else
					(wizz dispose:)
					(wizzSfx dispose:)
					(= cycles 1)
				)
			)
			(7
				(thoreenTalker ; "This is the EpiRip 357, the most powerful hand hair remover in the universe and it's capable of shaving your legs clean off."
					say:
						4
						self
						2
						64
						2
						1
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(8
				(thoreenTalker ; "I've always wanted to see a man shave with one of these, but I guess you'll do."
					say:
						5
						self
						2
						64
						2
						1
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(9
				(thoreenTalker ; "Now you will know the meaning of the word PAIN."
					say:
						6
						self
						2
						64
						2
						1
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(10
				(self setScript: shockScript)
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
				(thoreenTalker dispose:)
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

(instance face of Sq4Prop
	(properties
		x 142
		y 88
		view 345
		loop 2
		priority 12
		signal 16400
	)
)

(instance arm of Sq4Prop
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

(instance coil of Sq4Prop
	(properties
		x 136
		y 148
		z -1000
		view 345
		loop 4
		cel 1
	)
)

(instance wizz of Sq4Prop
	(properties
		x 176
		y 86
		z -1000
		view 345
		loop 5
	)
)

(instance thoreenTalker of FaceTalker
	(properties
		modNum 322
		talkerNum 21
	)
)

(instance thoreenEyes of Sq4Prop
	(properties
		x 138
		y 62
		view 1345
		priority 8
		signal 16400
	)
)

(instance thoreenMouth of Sq4Prop
	(properties
		x 146
		y 87
		view 1345
		loop 1
		priority 7
		signal 16400
	)
)

