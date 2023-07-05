;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use RandCycle)
(use MCyc)
(use Feature)
(use Sound)
(use Motion)
(use Actor)

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
		(rogerFace init:)
		(zondraFace init:)
		(rogerLegs init:)
		(rightZap init:)
		(leftZap init:)
		(pantsSfx init:)
		(theArea init:)
		(self setScript: tortureScript)
	)
)

(instance tortureScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gLongSong hold: 3)
				(zondraFace init: setCycle: RandCycle)
				(self
					save1:
						(proc0_12
							{"Comfy, Mr. Wilco?"#j\a2\f7\98\e6\9c\e3\f9\96\92\fe\a0 \b3\a8\d9\ba\9b\fd\a1\a3}
							67
							2
							1
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 5)
			)
			(4
				(rogerFace setCel: 2)
				(zondraArm cycleSpeed: 1 setCycle: End)
				(= cycles 3)
			)
			(5
				(zondraArm setCycle: Beg)
				(rightZap setCycle: MCyc @local29)
				(leftZap setCycle: MCyc @local0 self)
			)
			(6
				(= start state)
				(rogerFace setCel: 3)
				(rightZap setCycle: Beg)
				(aSound init: play:)
				(leftZap setCycle: Beg self)
				(= cycles 5)
			)
			(7
				(if (< (++ register) 5)
					(self init:)
				else
					(aSound stop:)
					(pantsSfx play:)
					(rogerLegs setCycle: End)
				)
			)
			(8
				(= cycles 1)
			)
			(9
				(rogerFace setCycle: RandCycle 4)
				(self
					save1:
						(proc0_12
							{"Hey! What are you doing?"#j\a2\95\92\ff\a0 \e5\e6\86\9c\e3\92\f9\fd\e0\de\ff\fe\a3}
							67
							2
							1
							28
							global190
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 6)
			)
			(11
				(rogerFace setCycle: RandCycle 4)
				(self
					save1:
						(proc0_12
							{"Let me go b. . . witch!"#j\a2\9a\e9\a5\a5\a5\a5\ea\e5\9e\ff\ff\a0 \98\a5\a5\a5\a5\ef\9c\de\8e\f2\ff\a3}
							67
							2
							1
							28
							global190
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 6)
			)
			(13
				(rogerFace stopUpd:)
				(zondraFace setCycle: RandCycle)
				(self
					save1:
						(proc0_12
							{"Shut up! Your whimpering sickens me!"#j\a2\95\e0\de\ef\f8\ff\a0 \b7\de\ac\b0\b7\de\ac\b0\e4\a0\93\f9\9b\98\e3\e0\ef\f7\e5\92\f6\ff\a3}
							67
							2
							1
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 8)
			)
			(15
				(zondraFace setCycle: RandCycle)
				(self
					save1:
						(proc0_12
							{"I'll teach you not to run out on ME!"#j\a2\e6\99\de\e0\de\9b\e5\92\e0\f2\e6\a4\92\92\9a\e4\86\a0\95\9c\94\e3\91\99\de\f9\fc\ff\a3}
							67
							2
							1
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 7)
			)
			(17
				(zondraFace setCycle: RandCycle)
				(self
					save1:
						(proc0_12
							{"Thoreen is quite knowledgeable in the ways of torture."#j\a2\bf\d8\b0\dd\ea\a4\9a\de\93\f3\fd\e9\a0\9e\f2\96\e0\e6\a0\98\fc\9c\92\e9\f6\a1\a3}
							67
							2
							1
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 8)
			)
			(19
				(zondraFace setCycle: RandCycle)
				(self
					save1:
						(proc0_12
							{"I'll let you two get acquainted. Thoreen, do your stuff."#j\a2\bf\d8\b0\dd\e4\e5\96\f6\98\a0\e5\f8\e5\9b\92\a1\9b\91\a4\bf\d8\b0\dd\a0 \f4\8f\e3\92\92\fc\f6\a1\a3}
							67
							2
							1
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 8)
			)
			(21
				(thoreenFace init: setCycle: RandCycle 10)
				(self
					save1:
						(proc0_12
							{"With PLEASURE, Zondra."#j\a2\f6\fb\9a\fd\e3\de\a1\a0 \bf\de\dd\c4\de\d7\9b\ef\a1\a3}
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
			(23
				(gCurRoom newRoom: 345)
			)
			(else
				(self restore:)
				(rogerFace setCycle: 0)
				(zondraFace setCycle: 0)
				(thoreenFace setCycle: 0)
				(= cycles 1)
			)
		)
	)
)

(instance thoreenFace of Prop
	(properties
		x 271
		y 34
		view 340
		loop 2
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

(instance zondraFace of Prop
	(properties
		x 50
		y 40
		view 340
		loop 1
	)

	(method (setCycle)
		(if cel
			(self cel: 0)
		)
		(super setCycle: &rest)
	)
)

(instance zondraArm of Prop
	(properties
		x 35
		y 38
		view 340
	)
)

(instance rogerFace of Prop
	(properties
		x 159
		y 40
		view 340
		loop 3
	)
)

(instance rogerLegs of Prop
	(properties
		x 136
		y 94
		view 340
		loop 7
		priority 10
		signal 16
	)
)

(instance rightZap of Prop
	(properties
		x 150
		y 168
		description {laser}
		view 340
		loop 6
		priority 7
		signal 16
	)
)

(instance leftZap of Prop
	(properties
		x 130
		y 166
		description {laser}
		view 340
		loop 5
		priority 7
		signal 16
	)
)

(instance theArea of Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		description {sea cave}
		sightAngle 180
		lookStr {How do I get into these situations?}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

