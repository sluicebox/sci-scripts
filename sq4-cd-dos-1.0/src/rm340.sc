;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use Sound)
(use Motion)
(use System)

(public
	rm340 0
)

(local
	[local0 29] = [5 0 86 157 5 0 82 156 5 0 78 155 5 0 79 151 5 0 80 148 5 0 81 144 5 0 84 144 -32768]
	[local29 29] = [6 0 160 168 6 0 166 167 6 0 173 166 6 0 174 162 6 0 175 158 6 0 176 153 6 0 172 153 -32768]
)

(instance rm340 of SQRoom
	(properties
		picture 340
	)

	(method (init)
		(super init:)
		(zondraArm init:)
		(zondraEyes init:)
		(zondraMouth init:)
		(thoreenMouth init:)
		(rogerMouth init:)
		(rogerTalker init: 0 0 rogerMouth)
		(rogerLegs init:)
		(rightZap init:)
		(leftZap init:)
		(pantsSfx init:)
		(self setScript: tortureScript)
	)
)

(instance tortureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerLegs stopUpd:)
				(rightZap stopUpd:)
				(leftZap stopUpd:)
				(= seconds 3)
			)
			(1
				(gLongSong hold: 3)
				(zondraTalker ; "Comfy, Mr. Wilco?"
					init: 0 zondraEyes zondraMouth
					say: 8 self 2 64 2 170 25 global136 26 global129 27 0 67 315
				)
			)
			(2
				(zondraArm cycleSpeed: 12 setCycle: End)
				(= cycles 3)
			)
			(3
				(zondraArm setCycle: Beg)
				(rightZap setCycle: MCyc @local29)
				(leftZap setCycle: MCyc @local0 self)
			)
			(4
				(= start state)
				(rightZap setCycle: Beg)
				(aSound init: play:)
				(leftZap setCycle: Beg self)
			)
			(5
				(if (< (++ register) 5)
					(self init:)
				else
					(aSound stop:)
					(pantsSfx play:)
					(rogerLegs setCycle: End self)
				)
			)
			(6
				(rogerLegs stopUpd:)
				(rightZap stopUpd:)
				(leftZap stopUpd:)
				(= cycles 2)
			)
			(7
				(rogerTalker ; "Hey! What are you doing?"
					say: 3 self 2 64 2 170 25 global137 26 global129 27 1 67 315
				)
			)
			(8
				(rogerTalker ; "Let me go b. . . witch!"
					say: 4 self 2 64 2 170 25 global137 26 global129 27 1 67 315
				)
			)
			(9
				(zondraTalker ; "Shut up! Your whimpering sickens me!"
					say: 9 self 2 64 2 170 25 global136 26 global129 27 0 67 315
				)
			)
			(10
				(zondraTalker ; "I'll teach you not to run out on ME!"
					say:
						10
						self
						2
						64
						2
						170
						25
						global136
						26
						global129
						27
						0
						67
						315
				)
			)
			(11
				(zondraTalker ; "Thoreen is quite knowledgeable in the ways of torture."
					say:
						11
						self
						2
						64
						2
						170
						25
						global136
						26
						global129
						27
						0
						67
						315
				)
			)
			(12
				(zondraTalker ; "I'll let you two get acquainted. Thoreen, do your stuff."
					say:
						12
						self
						2
						64
						2
						170
						25
						global136
						26
						global129
						27
						0
						67
						315
				)
			)
			(13
				(thoreenTalker ; "With PLEASURE, Zondra."
					modNum: 322
					init: 0 0 thoreenMouth
					say: 2 self 2 64 170 170
				)
			)
			(14
				(zondraTalker dispose:)
				(thoreenTalker dispose:)
				(rogerTalker dispose:)
				(gCurRoom newRoom: 345)
			)
		)
	)
)

(instance aSound of Sound
	(properties
		number 141
		loop -1
	)
)

(instance pantsSfx of Sound
	(properties
		number 151
	)
)

(instance zondraArm of Sq4Prop
	(properties
		x 35
		y 38
		view 1340
	)
)

(instance rogerLegs of Sq4Prop
	(properties
		x 136
		y 94
		view 1340
		loop 7
		priority 10
		signal 16
	)
)

(instance rightZap of Sq4Prop
	(properties
		x 150
		y 168
		view 1340
		loop 6
		priority 7
		signal 16
	)
)

(instance leftZap of Sq4Prop
	(properties
		x 130
		y 166
		view 1340
		loop 5
		priority 7
		signal 16
	)
)

(instance zondraTalker of FaceTalker
	(properties
		noun 19
		modNum 322
		talkerNum 19
	)
)

(instance zondraMouth of Sq4Prop
	(properties
		x 25
		y 7
		view 1341
		priority 14
		signal 16400
	)
)

(instance zondraEyes of Sq4Prop
	(properties
		x 44
		y 17
		view 1341
		loop 1
		priority 14
		signal 16400
	)
)

(instance thoreenTalker of FaceTalker
	(properties
		noun 21
		modNum 322
		talkerNum 21
		tpType 2
	)
)

(instance thoreenMouth of Sq4Prop
	(properties
		x 260
		y 11
		view 1342
		priority 14
		signal 16400
	)
)

(instance rogerTalker of FaceTalker
	(properties
		noun 7
		modNum 322
		talkerNum 7
		tpType 2
	)
)

(instance rogerMouth of Sq4Prop
	(properties
		x 149
		y 12
		view 1343
		priority 14
		signal 16400
	)
)

