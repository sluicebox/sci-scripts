;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm37 0
)

(instance rm37 of SQRoom
	(properties
		picture 37
		style 8
		horizon 93
		north 38
		east 19
		south 338
		west 138
	)

	(method (init)
		(if (not (IsFlag 68))
			(LoadMany rsSOUND 810 409)
		)
		(shipHull init:)
		(doorway init:)
		(windshield init:)
		(engines init:)
		(rocks init:)
		(ridge init:)
		(ridgeEdge init:)
		(mountains init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 91 303 91 286 102 250 108 223 114 227 117 220 120 194 121 191 128 181 132 169 130 163 129 154 133 148 143 138 147 154 146 164 148 160 159 149 165 140 161 115 163 101 158 58 160 43 155 54 151 28 145 20 141 72 122 78 116 0 96 0 0 319 0
					yourself:
				)
		)
		(Load rsVIEW 10)
		(switch gPrevRoomNum
			(14
				(= style -32761)
				(gEgo
					ignoreActors:
					normal: 0
					view: 12
					init:
					hide:
					loop: 0
					cel: 0
					posn: 161 130
					cycleSpeed: 15
					illegalBits: 0
					signal: 16384
				)
				(self setScript: exitShip)
			)
			(north
				(door cel: 3 init: stopUpd:)
				(gEgo x: 307 init:)
			)
			(else
				(door cel: 3 init: stopUpd:)
				(gEgo init:)
			)
		)
		(self setRegions: 704) ; keronaRegion
		(super init:)
		(if (not (IsFlag 7))
			(SetFlag 7)
			(smoke init: setCycle: Fwd)
		)
		(if (not (gEgo has: 6)) ; Broken_Glass
			(glass init:)
		)
		(if (not (gEgo has: 3)) ; Survival_Kit
			(kit init:)
		)
		(= global166 2)
	)

	(method (newRoom newRoomNumber)
		(if (or (gCast contains: grell) (== newRoomNumber north) (IsFlag 68))
			(super newRoom: newRoomNumber)
		else
			(SetFlag 68)
			(self setScript: grellYells 0 newRoomNumber)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $0002)
				(self setScript: walkAwayFromEdge)
			)
		)
		(super doit: &rest)
	)
)

(instance smoke of Prop
	(properties
		x 195
		y 57
		description {exhaust fumes}
		lookStr {The spent drives of the pod vent fumes after the long escape from the Arcada.}
		view 137
		cycleSpeed 15
		detailLevel 2
	)
)

(instance door of Prop
	(properties
		x 126
		y 98
		description {ship's hatch}
		lookStr {This is the door of the escape pod. Due to its special design, the door retained a reserve cache of power sufficient to open one more time. Now, however, it will no longer function.}
		view 137
		loop 1
		priority 12
		signal 16400
		cycleSpeed 26
	)

	(method (cue)
		(gSoundEffects stop:)
		(self stopUpd:)
		(exitShip cue:)
	)
)

(instance glass of Prop
	(properties
		x 85
		y 152
		description {piece of glass}
		sightAngle 90
		approachX 73
		approachY 162
		lookStr {A chunk of the highly reflective windscreen rests on the sand at the front of the pod. It, along with your teeth, was jarred loose as a result of the the landing's impact.}
		view 137
		loop 2
		cycleSpeed 8
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: getGlass)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grell of Prop
	(properties
		x 248
		y 167
		view 420
		cycleSpeed 8
	)
)

(instance kit of View
	(properties
		x 142
		y 118
		description {emergency survival kit}
		sightAngle 90
		approachX 172
		approachY 125
		lookStr {The rugged landing liberated the survival kit from its mounting fixture.}
		view 137
		loop 3
	)

	(method (init)
		(self approachVerbs: 3) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: getKit)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shipHull of Feature
	(properties
		description {pod's hull}
		onMeCheck 16384
		lookStr {The hull of the pod has an exquisite sheen. Too bad it is destined to remain a monument to your visit.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 37 0) ; "That would be unwise. The pod is still hot from the high-speed entry of the Keronian atmosphere."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorway of Feature
	(properties
		description {hatchway}
		onMeCheck 8192
		lookStr {This is the entry way to the pod.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance ridgeEdge of Feature
	(properties
		description {ridge's edge}
		onMeCheck 2
		lookStr {Your highly-honed preservation instincts tell you that going near the edge would be disasterous.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance windshield of Feature
	(properties
		description {pod's windshield}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 37 1) ; "The fractured windshield is of no value to you."
			)
			(2 ; Look
				(Print 37 2) ; "The pod's windshield is cracked beyond repair. The built-in plasti-seal film between the glass layers managed to keep the shield in place with one minor exception, despite the shocks from the landing (if that's what you want to call it)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance engines of Feature
	(properties
		y 60
		description {pod's engines}
		onMeCheck 2048
		lookStr {The engines seem to have performed their jobs well. They will now stand silent for eternity.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 37 3) ; "That would be unwise. The pod drives are still hot and not suitable for handling by humans."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rocks of Feature
	(properties
		description {rocks}
		onMeCheck 1024
		lookStr {The rocks lying on the ground here are made of crumbling sandstone.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 37 4) ; "The rocks are useless. At the slightest touch, they crumble to dust."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ridge of Feature
	(properties
		description {ridge}
		onMeCheck 512
		lookStr {This ridge of sand helped stop the pod.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance mountains of Feature
	(properties
		description {mountains}
		onMeCheck 128
		lookStr {In the distance rises a unique formation of mountains. They look to be hundreds of kilometers away.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance exitShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door init:)
				(= cycles 3)
			)
			(1
				(gSoundEffects number: 324 loop: 1 play:)
				(door setCycle: CT 2 1 self)
			)
			(2
				(door setCycle: End door)
				(gEgo show: setCycle: End self)
			)
			(3 0)
			(4
				(NormalEgo 0 1 61)
				(gEgo normal: 1 loop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getGlass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 10
					setLoop: 2
					cel: 0
					cycleSpeed: 20
					setCycle: CT 2 1 self
				)
			)
			(2
				(glass dispose:)
				(SetScore 3 141)
				(gEgo get: 6) ; Broken_Glass
				(gEgo setCycle: End self)
			)
			(3
				(HandsOn)
				(NormalEgo 0 1 61)
				(gEgo loop: 3)
				(self dispose:)
			)
		)
	)
)

(instance getKit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 10
					setLoop: 5
					cel: 0
					cycleSpeed: 20
					setCycle: CT 1 1 self
				)
			)
			(2
				(kit dispose:)
				(SetScore 2 140)
				(gEgo get: 3) ; Survival_Kit
				(gEgo cel: 3 setCycle: End self)
			)
			(3
				(HandsOn)
				(NormalEgo 0 1 61)
				(gEgo loop: 1)
				(self dispose:)
			)
		)
	)
)

(instance walkAwayFromEdge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 37 5) ; "Your sense of the ridiculous keeps you from walking off the edge and falling to a certain death on the treacherous rocks below."
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(1
				(Print 37 6) ; "Whew! That was close."
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance grellYells of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 810 loop: 1 play:)
				(grell init: setCycle: End self)
			)
			(1
				(gSoundEffects number: 409 loop: 1 play:)
				(grell cel: 7)
				(= cycles (if gHowFast 7 else 2))
			)
			(2
				(grell setCycle: End self)
			)
			(3
				(grell setCycle: CT 6 -1 self)
			)
			(4
				(grell setCycle: End self)
			)
			(5
				(grell cel: 7)
				(= cycles (if gHowFast 9 else 2))
			)
			(6
				(grell cel: 8)
				(= cycles (if gHowFast 5 else 2))
			)
			(7
				(grell cel: 7)
				(= cycles (if gHowFast 12 else 2))
			)
			(8
				(gCurRoom newRoom: register)
			)
		)
	)
)

