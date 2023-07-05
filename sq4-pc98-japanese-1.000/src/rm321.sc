;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm321 0
)

(local
	[local0 12] = [142 115 144 88 108 114 109 87 80 114 81 86]
	[local12 7]
)

(instance rm321 of SQRoom
	(properties
		picture 321
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
			((= [local12 temp0] (Clone Propeller1))
				init:
				x: [local0 (* temp0 2)]
				y: [local0 (+ (* temp0 2) 1)]
				setCycle: Fwd
			)
		)
		(super init:)
		(Load rsVIEW 322)
		(spotRight init: setCycle: Fwd)
		(theSub init:)
		(theArea init:)
		(spotLeft init: setCycle: Fwd)
		(eel init: setScript: eelScript)
		(self setScript: displayScript)
	)
)

(instance displayScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0 5 4 3 2 6 7)
				(self
					save1:
						(proc0_12
							{You hope these women soon realize that they MUST have the wrong guy.#j\96\e9\9c\de\8e\e0\e1\96\de\a0 \f1\9c\de\e2\e9\9c\de\ec\de\fd\86\a0\ef\e1\96\de\8f\e3\e4\f7\94\e0\e6\a0\e1\96\de\92\e5\92\a4\a0 \n\96\e5\f7\9d\de\a0 \97\96\de\e2\92\e3\98\fa\f9\e4\a0\97\f0\ea\95\f3\8f\e3\f9\fd\e0\de\a1}
							67
							2
							2
							28
							global136
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(1
				(self restore:)
				(= cycles 1)
			)
			(2
				(= cycles 10)
			)
			(3
				(self
					save1:
						(proc0_12
							{"This is Zondra. We are approaching checkpoint six. Prepare to open the tunnel door."#j\9a\e1\f7\ea\a4\bf\de\dd\c4\de\d7\a1\a0 \c1\aa\af\b8\ce\df\b2\dd\c46\e6\9e\8f\97\fd\e1\8d\93\a1\a0 \c4\dd\c8\d9\e9\c4\de\b1\86\a0\91\99\f9\9c\de\8d\fd\eb\de\86\9c\e3\98\e0\de\9b\92\a1}
							67
							2
							2
							28
							(proc0_18 global137 global137)
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(4
				(self restore:)
				(= cycles 1)
			)
			(5
				(= cycles 100)
			)
			(6
				(self
					save1:
						(proc0_12
							{"Activate the door."#j\a2\c4\de\b1\86\a0\91\99\e3\98\e0\de\9b\92\a1\a3}
							67
							2
							2
							28
							(proc0_18 global137 global137)
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(7
				(self restore:)
				(= cycles 1)
			)
			(8
				(cave init: setLoop: 4 setCycle: End self)
			)
			(9
				(gCurRoom newRoom: 329)
			)
		)
	)
)

(instance eelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(eel setLoop: 6 setCycle: Fwd setMotion: MoveTo 50 220 self)
			)
			(2
				(eel z: 1000)
				(= seconds 7)
			)
			(3
				(jellyFish
					init:
					setLoop: 5
					illegalBits: 0
					setCycle: Fwd
					ignoreHorizon:
					setMotion: MoveTo -10 -10 self
				)
			)
			(4
				(jellyFish dispose:)
				(= seconds 5)
			)
		)
	)
)

(instance spotLeft of Prop
	(properties
		x 99
		y 170
		description {ocean floor}
		sightAngle 180
		lookStr {A spotlight illuminates the floor of the cave the sub travels through.}
		view 322
		loop 1
		signal 16384
		cycleSpeed 1
	)
)

(instance spotRight of Prop
	(properties
		x 307
		y 161
		description {ocean floor}
		sightAngle 180
		lookStr {A spotlight illuminates the floor of the cave the sub travels through.}
		view 322
		signal 16384
		cycleSpeed 1
	)
)

(instance eel of Actor
	(properties
		x 345
		y 99
		description {eel}
		sightAngle 180
		lookStr {It looks like a swimming tongue.}
		yStep 4
		view 322
		loop 6
		signal 16384
		xStep 6
	)
)

(instance jellyFish of Actor
	(properties
		x 325
		y 137
		description {jelly fish}
		sightAngle 180
		lookStr {You're not sure what it is, but you bet it would look cool spewing through the propellers.}
		view 322
		loop 5
		signal 16384
		cycleSpeed 2
		xStep 6
	)
)

(instance cave of Prop
	(properties
		x 293
		y 65
		description {cave}
		sightAngle 180
		lookStr {An opening appears ahead.}
		view 322
		loop 4
		cycleSpeed 2
	)
)

(instance Propeller1 of Prop
	(properties
		x -100
		y -100
		sightAngle 180
		lookStr {These are the sub's propellers.}
		view 322
		loop 2
		signal 6144
	)
)

(instance theSub of Feature
	(properties
		x 156
		y 88
		nsTop 48
		nsLeft 60
		nsBottom 128
		nsRight 252
		description {submarine}
		sightAngle 180
		lookStr {This is a sub.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		x 156
		y 88
		nsBottom 200
		nsRight 320
		description {Sea cave.}
		sightAngle 180
		lookStr {This is a sea cave.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

