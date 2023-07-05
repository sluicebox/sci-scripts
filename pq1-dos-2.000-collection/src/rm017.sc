;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Inset)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm017 0
	Russ 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm017 of PQRoom
	(properties
		noun 5
		picture 17
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 90 108 8 137 28 189 175 163
					yourself:
				)
		)
		(wire init:)
		(desk init:)
		(inSlot init:)
		(super init: &rest)
		(russGuy init:)
		(gEgo init: posn: 37 163)
		((ScriptID 896 1) next: gabStuff) ; sWI
		(self posn: 79 134 setScript: (ScriptID 896 1)) ; sWI
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(self posn: 58 147 setScript: (ScriptID 896 2) 0 12) ; sWO
			)
		)
		(super doit: &rest)
	)
)

(instance gabStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc134_4 russGuy 152 4)
				(russGuy setPri: 5 setMotion: MoveTo 184 129 self)
			)
			(1
				(russGuy setHeading: 225 self)
			)
			(2
				(cond
					((< global211 2)
						(gMessager say: 1 2 7 0 self) ; "Hey, guy. On your way to briefing? Better hurry, you don't want Dooley bustin' your chops, guy."
					)
					((< global211 40)
						(gMessager say: 1 2 8 0 self) ; "You better get moving, guy."
					)
					((< global211 52)
						(gMessager say: 2 0 13 0 self) ; "Sonny, I'm sorry, but you know you don't have access to those materials, guy. Only Narcotics officers can see that stuff. Sorry, dude."
					)
					((and (gEgo has: 13) (>= global211 79)) ; Hoffman_File
						(gMessager say: 1 2 1 0 self) ; "Hey, guy, what can I do ya for?"
					)
					(else
						(gMessager say: 1 2 9 0 self) ; "Go bother someone else, Sonny. I'm on a donut break."
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getEvidence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 111
					cel: 0
					loop:
						(switch global206
							(0 2)
							(else 0)
						)
					setCycle:
						CT
						(switch global206
							(0 4)
							(else 3)
						)
						1
						self
				)
			)
			(1
				(local0 hide:)
				(gEgo setCycle: End self)
			)
			(2
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 3 4 2)
				(gCurRoom setInset: evidenceInset self)
			)
			(3
				(HandsOff)
				(gEgo
					setCycle:
						CT
						(switch global206
							(0 4)
							(else 3)
						)
						-1
						self
				)
			)
			(4
				(local0 show:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					posn:
						(switch global206
							(0 118)
							(else 110)
						)
						143
					loop: 6
				)
				(NormalEgo -1 6)
				(self dispose:)
			)
		)
	)
)

(instance selectEvidence of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 register)
				(= local1 (local0 x:))
				(= local2 (local0 y:))
				(if
					(or
						(!=
							(gEgo x:)
							(switch global206
								(0 118)
								(else 110)
							)
						)
						(!= (gEgo y:) 143)
					)
					(gEgo
						setMotion:
							PolyPath
							(switch global206
								(0 118)
								(else 110)
							)
							143
							self
					)
				else
					(+= state 1)
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gMessager say: (local0 noun:) 4 14 0 self)
			)
			(3
				(gMessager say: 2 4 14 (Random 1 2) self)
			)
			(4
				(russGuy
					setMotion: MoveTo (+ (local0 x:) 24) (+ (local0 y:) 28) self
				)
			)
			(5
				(russGuy setHeading: 225 self)
			)
			(6
				(if (Random 0 2)
					(= cycles 1)
				else
					(self setScript: answerPhone self)
				)
			)
			(7
				(russGuy
					view: 153
					loop: 3
					cel: 0
					posn: (+ (local0 x:) 23) (+ (local0 y:) 26)
					setCycle: CT 3 1 self
				)
			)
			(8
				(local0 startUpd: setPri: -1 posn: 153 106)
				(russGuy setCycle: End self)
			)
			(9
				(russGuy loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(local0 setMotion: MoveTo 139 112 self)
			)
			(11
				(self setScript: getEvidence self)
			)
			(12
				(local0 setMotion: MoveTo 153 106 self)
			)
			(13
				(russGuy setCycle: Beg self)
			)
			(14
				(russGuy loop: 3 cel: (russGuy lastCel:) setCycle: CT 3 -1 self)
			)
			(15
				(local0 setPri: 7 posn: local1 local2)
				(russGuy setCycle: Beg self)
			)
			(16
				(russGuy
					view: 152
					posn: (+ (local0 x:) 24) (+ (local0 y:) 28)
					loop: 5
					heading: 225
				)
				(local0 stopUpd:)
				(proc134_4 russGuy)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance showFolder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global211 79)
					(= global211 80)
				)
				(if
					(or
						(!=
							(gEgo x:)
							(switch global206
								(0 118)
								(else 110)
							)
						)
						(!= (gEgo y:) 143)
					)
					(gEgo
						setMotion:
							PolyPath
							(switch global206
								(0 118)
								(else 110)
							)
							143
							self
					)
				else
					(+= state 1)
					(= cycles 1)
				)
			)
			(1
				(russGuy setMotion: MoveTo 184 129 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(russGuy setHeading: 225 self)
				(gEgo
					view: 111
					loop:
						(switch global206
							(0 2)
							(else 0)
						)
					cel: (gEgo lastCel:)
					setCycle:
						CT
						(switch global206
							(0 4)
							(else 3)
						)
						-1
						self
				)
			)
			(4)
			(5
				(folder init:)
				(gEgo setCycle: Beg self)
			)
			(6
				(folder setMotion: MoveTo 153 106 self)
			)
			(7
				(russGuy
					view: 153
					loop: 4
					cel: 0
					posn: 184 129
					setCycle: CT 2 1 self
				)
			)
			(8
				(russGuy setCycle: End self)
				(folder hide:)
			)
			(9
				(gMessager say: 9 0 5 1 self) ; "I got two items for that case, Sonny. Do you want the revolver or the black book?"
			)
			(10
				(russGuy setCycle: CT 2 -1 self)
			)
			(11
				(folder show:)
				(russGuy setCycle: Beg self)
			)
			(12
				(folder setMotion: MoveTo 139 112 self)
			)
			(13
				(gEgo
					cel: 0
					loop:
						(switch global206
							(0 2)
							(else 0)
						)
					setCycle:
						CT
						(switch global206
							(0 4)
							(else 3)
						)
						1
						self
				)
			)
			(14
				(folder dispose:)
				(gEgo setCycle: End self)
			)
			(15
				(gEgo
					posn:
						(switch global206
							(0 118)
							(else 110)
						)
						143
					loop: 6
				)
				(NormalEgo -1 6)
				(proc134_4 russGuy 152 5 184 129 5)
				(russGuy setMotion: MoveTo 247 121 self)
			)
			(16
				(= seconds 3)
			)
			(17
				(russGuy setMotion: MoveTo 184 129 self)
			)
			(18
				(russGuy
					view: 153
					loop: 0
					cel: 0
					posn: 184 129
					setCycle: End self
				)
			)
			(19
				(gun init:)
				(book init:)
				(proc134_4 russGuy 152 5 184 129 5)
				(= cycles 3)
			)
			(20
				(gMessager say: 9 0 5 2 self) ; "Here you go, guy."
			)
			(21
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance answerPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(russGuy setMotion: MoveTo 184 129 self)
			)
			(1
				(russGuy view: 153 loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(gMessager say: 2 0 16 0 self) ; "Hold on a sec, guy. Phone's ringing."
			)
			(3
				(russGuy setCycle: End self)
			)
			(4
				(russGuy view: 152 posn: 184 129 loop: 5 heading: 225)
				(proc134_4 russGuy)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wire of Feature
	(properties
		x 160
		noun 10
		sightAngle 40
		onMeCheck 8192
	)
)

(instance desk of Feature
	(properties
		x 160
		noun 6
		sightAngle 40
		onMeCheck 4096
	)
)

(instance inSlot of Feature
	(properties
		x 160
		y 100
		noun 7
		sightAngle 40
		onMeCheck 16384
	)
)

(instance Russ of Narrator
	(properties
		x 160
		y 130
		talkWidth 130
		showTitle 1
		back 43
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance russGuy of Actor
	(properties
		x 156
		y 88
		noun 1
		view 152
		loop 4
		priority 5
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (Random 0 1)
			(self posn: 247 121)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; Hoffman_File
				(cond
					((!= global206 1)
						(gMessager say: 1 2 9 0) ; "Go bother someone else, Sonny. I'm on a donut break."
					)
					((and (not (gCurRoom script:)) (gCast contains: book))
						(gMessager say: 1 0 17 0) ; "All the evidence for that case is already on the counter."
					)
					(else
						(gCurRoom setScript: showFolder)
					)
				)
			)
			(2 ; Talk
				(if (not local4)
					(= local4 1)
					(cond
						((< global211 2)
							(gMessager say: 1 2 7 0) ; "Hey, guy. On your way to briefing? Better hurry, you don't want Dooley bustin' your chops, guy."
						)
						((< global211 40)
							(gMessager say: 1 2 8 0) ; "You better get moving, guy."
						)
						((< global211 52)
							(gMessager say: 2 0 13 0) ; "Sonny, I'm sorry, but you know you don't have access to those materials, guy. Only Narcotics officers can see that stuff. Sorry, dude."
						)
						(else
							(gMessager say: 1 2 9 0) ; "Go bother someone else, Sonny. I'm on a donut break."
						)
					)
				else
					(switch local4
						(1
							(= local4 2)
							(gMessager say: 1 2 2 0) ; "Hope you found what you were lookin' for, guy. See ya!"
						)
						(2
							(gMessager say: 1 2 6 0) ; "Russ is busy girding his loins for another donut...he's working on his second box of the day."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book of Actor
	(properties
		x 161
		y 103
		noun 4
		view 153
		loop 7
		cel 1
		priority 7
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: selectEvidence 0 self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gun of Actor
	(properties
		x 165
		y 107
		noun 3
		view 153
		loop 7
		priority 7
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: selectEvidence 0 self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance folder of Actor
	(properties
		x 139
		y 112
		view 153
		loop 7
		cel 3
		signal 18432
	)
)

(instance evidenceInset of Inset
	(properties
		priority 15
		disposeNotOnMe 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun 1 15 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(switch local0
			(gun
				(self view: 368 loop: 0 noun: 3 x: 68 y: 43)
			)
			(book
				(self view: 683 loop: 0 noun: 4 x: 184 y: 140)
			)
		)
		(super init: &rest)
	)
)

