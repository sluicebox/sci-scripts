;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Osc)
(use MCyc)
(use Feature)
(use ForwardCounter)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm341 0
)

(local
	[local0 29] = [5 0 86 157 5 0 82 156 5 0 78 155 5 0 79 151 5 0 80 148 5 0 81 144 5 0 84 144 -32768]
	[local29 29] = [6 0 160 168 6 0 166 167 6 0 173 166 6 0 174 162 6 0 176 158 6 0 177 153 6 0 174 153 -32768]
)

(instance rm341 of SQRoom
	(properties
		picture 341
		south 350
	)

	(method (init)
		(proc0_14 {Space Quest X} global146)
		(super init:)
		(rogerFace init:)
		(leftTentacle init: setCycle: Rev)
		(rightTentacle init: setCycle: Osc)
		(activator init:)
		(belt init:)
		(lSpark init:)
		(rSpark init:)
		(light1 init:)
		(light2 init:)
		(tray init:)
		(self setScript: grabScript)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gIconBar disable: 0)
				(grabScript register: 1)
				(rogerFace setCel: 3)
				(= seconds 2)
			)
			(1
				(belt setCycle: End self)
				(rogerFace setCel: 2)
			)
			(2
				(rightTentacle
					setLoop: 3
					setCel: 0
					x: 182
					y: 86
					cycleSpeed: 0
					setCycle: End
				)
				(leftTentacle
					setLoop: 2
					setCel: 0
					x: 109
					y: 110
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(3
				(grabScript register: 0)
				(= seconds 7)
			)
			(4
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance escapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogerFace setCel: 0)
				(hand init:)
				(= seconds 2)
			)
			(1
				(hand dispose:)
				(rightZap init: setCycle: MCyc @local0)
				(leftZap init: setCycle: MCyc @local29 self)
			)
			(2
				(rightZap setCycle: ForwardCounter 6 self)
				(aSound init: play:)
				(rSpark init: setCycle: ForwardCounter 3)
				(leftZap setCycle: ForwardCounter 6)
				(lSpark init: setCycle: ForwardCounter 3)
			)
			(3
				(aSound stop:)
				(rightTentacle setLoop: 3 setCel: 0 x: 182 y: 86 setCycle: Beg)
				(leftTentacle
					setLoop: 2
					setCel: 0
					x: 109
					y: 110
					setCycle: Beg self
				)
			)
			(4
				(rightTentacle x: 182 y: 89 loop: 1 cel: 0 setCycle: Osc)
				(leftTentacle x: 104 y: 109 loop: 0 cel: 0 setCycle: Fwd)
				(= cycles 3)
			)
			(5
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance rogerFace of Prop
	(properties
		x 159
		y 40
		view 340
		loop 3
		cel 4
	)
)

(instance aSound of Sound
	(properties
		number 141
		loop -1
	)
)

(instance rightZap of Prop
	(properties
		x 150
		y 150
		description {laser}
		sightAngle 90
		lookStr {**ACME laser nodes, for all your torture needs.}
		view 340
		loop 6
		priority 7
		signal 16
	)
)

(instance leftZap of Prop
	(properties
		x 130
		y 150
		description {**laser}
		sightAngle 90
		lookStr {**ACME laser nodes for all your torture needs.}
		view 340
		loop 5
		priority 7
		signal 16
	)
)

(instance belt of Prop
	(properties
		x 145
		y 82
		description {**Man strapper restraint system.}
		sightAngle 90
		lookStr {**Restraining belt.}
		view 340
		loop 8
		cycleSpeed 1
	)
)

(instance hand of Prop
	(properties
		x 118
		y 80
		view 340
		loop 4
		priority 8
	)
)

(instance leftTentacle of Prop
	(properties
		x 104
		y 109
		description {tentacle}
		sightAngle 90
		lookStr {**It's a slimy slug tongue.}
		view 341
		cycleSpeed 1
	)
)

(instance rightTentacle of Prop
	(properties
		x 182
		y 89
		description {tentacle}
		sightAngle 90
		lookStr {**It's a slimy slug tongue.}
		view 341
		loop 1
		cycleSpeed 1
	)
)

(instance activator of Feature
	(properties
		x 86
		y 78
		nsTop 75
		nsLeft 82
		nsBottom 82
		nsRight 91
		description {laser activator}
		sightAngle 180
		lookStr {** laser activator switch}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (grabScript register:)
					(Print 341 0) ; "Desperately you try to push the button but the restraints are just to tight!"
				else
					(HandsOff)
					(gCurRoom setScript: escapeScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light1 of Feature
	(properties
		x 104
		y 14
		nsLeft 79
		nsBottom 28
		nsRight 130
		description {surgical lights}
		sightAngle 180
		lookStr {**Hot lights glare in your face and make you very uncomfortable.}
	)
)

(instance light2 of Feature
	(properties
		x 225
		y 17
		nsLeft 201
		nsBottom 34
		nsRight 250
		description {surgical lights}
		sightAngle 180
		lookStr {**Hot lights glare in your face and make you very uncomfortable.}
	)
)

(instance tray of Feature
	(properties
		x 223
		y 71
		nsTop 62
		nsLeft 198
		nsBottom 80
		nsRight 249
		description {**Surgical tray.}
		sightAngle 180
		lookStr {**Shiny stainless steel instruments cover the surgical tray. Some of them look vaguely familiar as veterinary instruments.}
	)
)

(instance rSpark of Prop
	(properties
		x 166
		y 136
		view 28
	)
)

(instance lSpark of Prop
	(properties
		x 94
		y 125
		view 28
		priority 10
		signal 16
	)
)

