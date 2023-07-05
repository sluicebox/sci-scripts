;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room300 0
)

(local
	local0
)

(procedure (localproc_0)
	(tree init:)
	(rock init:)
	(road init:)
	(wall init:)
	(grass init:)
	(hole init:)
)

(instance Room300 of FRoom
	(properties
		lookStr {You feel like you are being watched here.}
		picture 300
		style 0
		horizon 56
		north 250
		south 350
		invX 97
		invY 109
		northX 138
		northY 43
		southX 89
		southY 174
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(Load rsSOUND 152)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 -26 76 -26 76 56 106 76 111 82 106 89 107 98 94 108 95 117 9 169 7 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 95 199 96 173 108 169 116 162 113 151 197 114 196 94 179 92 181 85 178 74 188 63 144 56 143 51 128 51 128 0 319 0 319 199
					yourself:
				)
		)
		(localproc_0)
		(= local0 0)
	)

	(method (cue)
		(super cue:)
	)
)

(instance owlSound of Sound
	(properties
		flags 1
		number 152
	)
)

(instance seeOwl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 300 0 #time 5 #at -1 160 #dispose) ; "You see an owl."
				(= local0 1)
				(owlSound play:)
				(owl x: 237 y: 64 loop: 0 cel: 0 setCycle: CT 8 1 self init:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance flyOwl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owlSound play:)
				(owl setCycle: End self)
			)
			(1
				(owl
					setLoop: 1
					setCel: 0
					setPri: 15
					setStep: 6 2
					setCycle: Fwd
					setMotion: MoveTo 0 64 self
				)
			)
			(2
				(= local0 0)
				(owl dispose:)
				(self dispose:)
			)
		)
	)
)

(instance owl of Actor
	(properties
		description {Owl}
		lookStr {An owl watches you.}
		view 300
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (owl script:))
					(owl setScript: flyOwl)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hole of Feature
	(properties
		x 265
		y 80
		description {Hole}
		sightAngle 90
		onMeCheck 64
		lookStr {The owl has a nest inside the hole.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((owl script:) 0)
					((not local0)
						(owl setScript: seeOwl)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 31
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {The trees here are very twisted.}
	)
)

(instance rock of Feature
	(properties
		x 174
		y 135
		description {Rock}
		sightAngle 90
		onMeCheck 4
		lookStr {The rocks here are big and rough to the touch.}
	)
)

(instance road of Feature
	(properties
		x 137
		y 97
		description {Road}
		sightAngle 90
		onMeCheck 8
		lookStr {The road goes north and south.}
	)
)

(instance wall of Feature
	(properties
		x 15
		y 77
		description {Wall}
		sightAngle 90
		onMeCheck 16
		lookStr {The high wall is made from rocks.}
	)
)

(instance grass of Feature
	(properties
		x 105
		y 80
		description {Grass}
		sightAngle 90
		onMeCheck 32
		lookStr {The grass feels wet when you touch it.}
	)
)

