;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use station)
(use egoSitsDown)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm015 0
	chair1 1
	girlChair 2
	manChair1 3
	manChair2 4
	manChair3 5
	newspaper 6
	briefingRoomDoor 7
)

(local
	local0
)

(instance rm015 of PQRoom
	(properties
		noun 7
		picture 15
		vanishingX 224
		vanishingY 62
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 72 122 190 152 202 152 255 98 146 81 67 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 158 100 176 89 212 95 195 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 100 123 136 100 219 119 191 147 144 134 145 126 134 132
					yourself:
				)
		)
		(boardF init:)
		(yourSeat init:)
		(chalkBoard init:)
		(lectrn init:)
		(lightSwitch init:)
		(steveHole init:)
		(jackHole init:)
		(yourHole init:)
		(tables init:)
		(pidgeonHoles init:)
		(gEgo init: posn: 72 96)
		(NormalEgo -1 4)
		(briefingRoomDoor init:)
		(girlChair init:)
		(manChair1 init:)
		(manChair2 init:)
		(manChair3 init:)
		(chair1 init:)
		(super init: &rest)
		(cond
			((< global211 2)
				(newspaper init:)
				(board init: ignoreActors: 1 addToPic:)
			)
			((== global211 39)
				(proc152_6)
			)
			((>= global211 62)
				(board init:)
			)
		)
		(self setScript: enterRoom)
	)

	(method (notify &tmp [temp0 20])
		(gEgo setScript: (ScriptID 152 1)) ; egoSitsDown
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 93 109 self)
			)
			(1
				(briefingRoomDoor startUpd: setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(3
				(briefingRoomDoor stopUpd:)
				(cond
					((< global211 2)
						(= next (ScriptID 152 4)) ; timeOutEntry
					)
					((== global211 39)
						(= next (ScriptID 152 7)) ; bugEgoToSit
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 87 106 self)
			)
			(1
				(proc134_3 self)
			)
			(2
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(3
				(briefingRoomDoor startUpd: setCycle: End self)
			)
			(4
				(NormalEgo -1)
				(gEgo setLoop: 7 setMotion: MoveTo 72 96 self)
			)
			(5
				(gLongSong2 stop:)
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance getMemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 21)
				(gEgo setHeading: 0 self)
			)
			(1
				(proc134_3 self)
				(SetScore 110 1)
			)
			(2
				(gMessager say: 13 4 12 0 self) ; "The hand-written note says: Sonny, how's about a 11-98 at Carol's later in the shift? Steve."
			)
			(3
				(NormalEgo -1 3)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chair1 of View
	(properties
		x 131
		y 127
		noun 14
		approachX 135
		approachY 134
		view 131
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf global211 1 39)
					(gEgo setScript: (ScriptID 152 1)) ; egoSitsDown
				else
					(gMessager say: noun 4 31 0) ; "You don't have time to sit around now. Get out there and write some tickets."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance newspaper of View
	(properties
		x 130
		y 100
		noun 5
		approachX 116
		approachY 127
		view 136
		loop 1
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(or
						(not (gCurRoom script:))
						(== (gCurRoom script:) (ScriptID 152 4)) ; timeOutEntry
					)
					(gCurRoom setScript: (ScriptID 152 3)) ; getPaper
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance girlChair of View
	(properties
		x 100
		y 168
		noun 25
		view 131
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance manChair1 of View
	(properties
		x 171
		y 135
		noun 25
		view 131
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance manChair2 of View
	(properties
		x 79
		y 158
		noun 25
		view 131
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance manChair3 of View
	(properties
		x 237
		y 150
		noun 25
		view 131
		loop 8
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance board of View
	(properties
		x 174
		y 41
		noun 9
		view 135
	)

	(method (init)
		(cond
			((< global211 2)
				(= loop 1)
			)
			((>= global211 40)
				(= loop 0)
			)
		)
		(super init: &rest)
	)
)

(instance boardF of Feature
	(properties
		x 114
		y 58
		noun 8
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance yourSeat of Feature
	(properties
		x 114
		y 58
		noun 14
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(chair1 doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chalkBoard of Feature
	(properties
		x 205
		y 57
		noun 9
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lectrn of Feature
	(properties
		x 114
		y 58
		noun 10
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lightSwitch of Feature
	(properties
		x 114
		y 58
		noun 11
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pidgeonHoles of Feature
	(properties
		x 114
		y 58
		noun 12
		sightAngle 40
		onMeCheck 8192
		approachX 164
		approachY 91
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance steveHole of Feature
	(properties
		x 114
		y 58
		noun 21
		sightAngle 40
		onMeCheck 32
		approachX 164
		approachY 91
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance jackHole of Feature
	(properties
		x 114
		y 58
		noun 20
		sightAngle 40
		onMeCheck 64
		approachX 164
		approachY 91
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance yourHole of Feature
	(properties
		x 114
		y 58
		noun 13
		sightAngle 40
		onMeCheck 128
		approachX 164
		approachY 91
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 21))
					(gEgo setScript: getMemo)
				else
					(gMessager say: 13 4 14 0) ; "Hmm, a little dust in there, but nothing else."
				)
			)
			(1 ; Look
				(if (not (IsFlag 21))
					(gMessager say: 13 1 0 0) ; "It's your pigeonhole. It looks like there's a hand-written note inside."
				else
					(gMessager say: 13 1 14 0) ; "Your pigeonhole is empty."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tables of Feature
	(properties
		x 114
		y 58
		noun 22
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance briefingRoomDoor of Prop
	(properties
		x 87
		y 55
		noun 4
		approachX 87
		approachY 106
		view 886
		loop 2
		signal 24576
	)

	(method (init)
		(self cel: (self lastCel:))
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (and cel (not local0))
			(= local0 1)
			(gLongSong2 number: 120 loop: -1 setVol: 48 play:)
		)
		(if (and (not cel) local0)
			(= local0 0)
			(gLongSong2 stop:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (gEgo view:) 131)
						(gMessager say: 26 4 32) ; "Not now!"
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: exitRoom)
					)
					(else
						(gMessager say: noun 4 1 0) ; "Whatever you had in mind, it's too late, Bonds; the briefing will start shortly."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

