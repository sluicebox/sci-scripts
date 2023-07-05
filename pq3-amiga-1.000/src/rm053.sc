;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm053 0
)

(instance rm053 of PQRoom
	(properties
		lookStr {This back room looks to have been used as a gathering place for some kind of ritual. The large red pentagram looks all to familiar.}
		picture 53
	)

	(method (init)
		(Load rsVIEW 557)
		(super init:)
		(HandsOff)
		(mAlter play: 10 fade: 127 25 10 0)
		(gLongSong number: 0 stop:)
		(mAfterFire play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 319 85 222 85 222 100 199 100 199 79 186 76 186 86 164 86 164 70 152 67 143 69 143 87 123 87 123 73 86 93 86 136 215 136 233 115 319 115
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 183 99 183 113 163 113 163 99
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 127 90 127 105 106 105 106 90
					yourself:
				)
		)
		(walls init:)
		(Blood init:)
		(glow setCycle: Fwd init:)
		(glow2 setCycle: Fwd init:)
		(drip setCycle: Fwd init:)
		(backwalldrip setCycle: Fwd init:)
		(pipe init:)
		(candles init:)
		(floor init:)
		(gEgo normal: 1 view: 4 setStep: 3 2 posn: 260 106 init:)
		(self setScript: enterRoom)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $4000)
				(HandsOff)
				(gCurRoom setScript: exitRoom)
			)
		)
		(super doit:)
	)
)

(instance mAlter of Sound
	(properties
		flags 1
		number 530
		loop -1
	)
)

(instance mAfterFire of Sound
	(properties
		flags 1
		number 520
		loop -1
	)
)

(instance sScraper of Sound
	(properties
		number 938
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 215 105 self)
			)
			(1
				(if 0
					(Print 53 0) ; "This appears to some sort of altar room. You get the feeling you're not dealing with kids and ouija boards here."
					(SetFlag 56)
				)
				(= cycles 1)
			)
			(2
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
				(gEgo setMotion: PolyPath 260 106 self)
			)
			(1
				(mAfterFire fade: self)
				(mAlter fade: self)
			)
			(2 0)
			(3
				(gCurRoom newRoom: 52)
			)
		)
	)
)

(instance getBlood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 157 91 self)
			)
			(1
				(Print 53 1) ; "You carefully scrape off some of the dried blood and hair and put them in an envelope."
				(gEgo setLoop: 2)
				(= cycles 1)
			)
			(2
				(gEgo
					normal: 0
					view: 555
					cel: 0
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(3
				(sScraper play:)
				(gEgo setCycle: CT 10 1 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(NormalEgo 4 2)
				(gEgo get: 41) ; bloodHair
				(SetScore 180 5)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance glow of Prop
	(properties
		x 103
		y 127
		view 557
		cel 2
		priority 15
		signal 16400
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(coals doVerb: theVerb invItem)
	)
)

(instance glow2 of Prop
	(properties
		x 142
		y 136
		view 557
		loop 1
		signal 16400
		cycleSpeed 9
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(coals doVerb: theVerb invItem)
	)
)

(instance drip of Actor
	(properties
		x 225
		y 136
		view 557
		loop 2
		cel 2
		priority 16
		signal 16400
		cycleSpeed 8
		detailLevel 2
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(floor doVerb: theVerb invItem)
	)
)

(instance backwalldrip of Actor
	(properties
		x 182
		y 66
		view 557
		loop 3
		cel 1
		signal 16384
		cycleSpeed 8
		detailLevel 2
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(walls doVerb: theVerb invItem)
	)
)

(instance Blood of Feature
	(properties
		x 160
		y 90
		onMeCheck 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(39 ; scraper
						(cond
							((gEgo has: 41) ; bloodHair
								(Print 53 2) ; "You don't need another sample."
							)
							((gEgo has: 42) ; sampleEnv
								(gCurRoom setScript: getBlood)
							)
							(else
								(Print 53 3) ; "You need something with which to collect a clean sample."
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Print 53 4) ; "Even the idea of touching this sicko stuff disgusts you."
			)
			(2 ; Look
				(Print 53 5) ; "A pentagram has been carefully painted on the wooden floor with red paint."
				(Print 53 6) ; "As you study the floor within the altar you notice a dried puddle of blood and hair. It appears to be the remains of some sick sacrificial ritual. Your stomach turns."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls of Feature
	(properties
		x 140
		y 46
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 53 7) ; "The walls are marred by fire."
			)
			(3 ; Do
				(Print 53 8) ; "You don't want to touch that. Some of this stuff is still hot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coals of Feature
	(properties
		x 118
		y 124
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 53 9) ; "The last embers of the fire cast an eerie red glow throughout the smokey house."
			)
			(3 ; Do
				(Print 53 8) ; "You don't want to touch that. Some of this stuff is still hot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		x 162
		y 90
		onMeCheck 1024
		lookStr {The room's wooden floor seems to have escaped the fire.}
	)
)

(instance candles of Feature
	(properties
		x 162
		y 90
		onMeCheck 16
		lookStr {Large white candles mark the points of a large pentagram painted on the floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 53 4) ; "Even the idea of touching this sicko stuff disgusts you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pipe of Feature
	(properties
		x 211
		y 108
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 53 10) ; "The pipe doesn't interest you."
			)
			(2 ; Look
				(Print 53 11) ; "Exposed water pipes and charred studs are all that remain of some of the interior walls."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

