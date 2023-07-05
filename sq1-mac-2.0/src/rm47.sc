;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm47 0
)

(instance rm47 of SQRoom
	(properties
		lookStr {You are outside the Droids-B-Us store.}
		picture 47
		south 42
		west 46
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 49 213 49 319 137 285 149 292 153 275 164 237 168 163 164 148 158 133 158 154 176 126 179 121 176 111 177 42 180 0 179
					yourself:
				)
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(south
				(= style 10)
			)
			(west
				(= style 12)
				(gEgo x: 20)
				(HandsOn)
			)
			(else
				(= style 8)
				(self setScript: outaDBU)
			)
		)
		(self setRegions: 702) ; ulenceRegion
		(super init:)
		(radar init: setCycle: Fwd)
		(robot1 init: setCycle: Fwd)
		(robot2 init: setCycle: Osc)
		(neonhand init: setCycle: Osc)
		(lefteye init: setCycle: Osc)
		(righteye init: setCycle: Osc)
		(pickupArea init:)
		(store init:)
		(bigSign init:)
		(smallSign init:)
		(storeWindow init:)
		(if (and (IsFlag 33) (== gPrevRoomNum 48))
			((ScriptID 702 1) posn: 117 184) ; robot
		)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl:) $0002)
				(gCurRoom setScript: intoDBU)
			)
		)
		(super doit:)
	)
)

(instance outaDBU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 132 170 setMotion: MoveTo 198 174 self)
				(if (IsFlag 33)
					((ScriptID 702 1) posn: 28 179) ; robot
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance intoDBU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 163 168 self)
			)
			(1
				(gEgo setMotion: MoveTo 152 164 self)
			)
			(2
				(gEgo setMotion: MoveTo 123 166 self)
			)
			(3
				(gCurRoom newRoom: 48)
			)
		)
	)
)

(instance radar of Prop
	(properties
		x 310
		y 115
		description {force field sensor}
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel undesirables, such as the grell, which thrive below the sands. It will allow only airborne vehicles in or out.}
		view 147
		loop 2
		cel 4
		priority 2
		signal 16
		cycleSpeed 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 47 0) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 47 1) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 47 0) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 47 0) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance robot1 of Prop
	(properties
		x 35
		y 142
		description {robot}
		lookStr {This robot is a security droid. He can scan an area in infra-red, ultra-violet, and infra-ultra-chartreuse.}
		view 452
		cel 1
		priority 10
		signal 16
		cycleSpeed 11
		detailLevel 2
	)
)

(instance robot2 of Prop
	(properties
		x 66
		y 144
		description {robot}
		lookStr {It's a robot that seems to be saying, "Buy me. Take me home."}
		view 452
		loop 1
		cel 2
		priority 10
		signal 16
		cycleSpeed 9
		detailLevel 1
	)
)

(instance neonhand of Prop
	(properties
		x 124
		y 116
		description {neon hand}
		lookStr {The neon hand waves "Hello" to you.}
		view 147
		loop 3
		priority 13
		signal 16
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 47 2) ; "Shaking hands could be a shocking experience."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lefteye of Prop
	(properties
		x 136
		y 98
		description {eye}
		lookStr {It's just part of the animated sign.}
		view 147
		cel 2
		priority 14
		signal 16
		cycleSpeed 7
		detailLevel 2
	)
)

(instance righteye of Prop
	(properties
		x 158
		y 97
		description {eye}
		lookStr {It's just part of the animated sign.}
		view 147
		loop 1
		cel 2
		priority 14
		signal 16
		cycleSpeed 7
		detailLevel 2
	)
)

(instance pickupArea of Feature
	(properties
		description {Droids-B-Us warehouse and pickup area}
		onMeCheck 4
		lookStr {That is the Droids-B-Us warehouse and pickup area.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance store of Feature
	(properties
		description {Droids-B-Us store}
		onMeCheck 16
		lookStr {This is the Droids-B-Us storefront.  They sell droids for all purposes.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance bigSign of Feature
	(properties
		description {Droids-B-Us sign}
		onMeCheck 8
		lookStr {The big sign over the door says "Droids-B-Us".}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance smallSign of Feature
	(properties
		description {small posted sign}
		onMeCheck 32
		lookStr {The sign says "ALL SALES FINAL!" in 1,438 languages.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance storeWindow of Feature
	(properties
		description {window}
		onMeCheck 64
		lookStr {You can see only bits and pieces of droids through the small window.  But it looks safe enough in there.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

