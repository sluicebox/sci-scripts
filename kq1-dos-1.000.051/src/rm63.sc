;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm63 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(HandsOff)
	((ScriptID 0 23) fade:) ; backSound
	(if (IsFlag 1)
		(Print 63 13) ; "As you fall, the magic ring slips from your finger."
		(gEgo put: 5) ; Magic_Ring
		(gGame changeScore: -3)
	)
	(gEgo
		view: 57
		illegalBits: 0
		loop: param1
		cel: 0
		setMotion: 0
		cycleSpeed: 1
	)
)

(procedure (localproc_1)
	((ScriptID 0 23) number: 17 loop: 1 play:) ; backSound
)

(instance rm63 of Rm
	(properties
		picture 63
		horizon 62
		south 14
	)

	(method (init)
		(LoadMany rsVIEW 57 48)
		(LoadMany rsSOUND 17)
		(self style: 4)
		(super init:)
		(self setScript: climbUp)
		(if (not (or (IsFlag 94) (gEgo has: 15))) ; Gold_Egg
			(goldEgg init: setPri: 4)
		)
		(ClearFlag 46)
		(nest init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(tree8 init:)
		(tree9 init:)
		(tree10 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 8)
				(self setScript: longFallRight)
			)
			((== (gEgo onControl: 1) 16)
				(self setScript: longFallLeft)
			)
			((== (gEgo onControl: 1) 2048)
				(self setScript: longFrontFallLeft)
			)
			((== (gEgo onControl: 1) 256)
				(self setScript: fallSEast)
			)
			((== (gEgo onControl: 1) 2)
				(self setScript: longFallSWest)
			)
			((== (gEgo onControl: 1) 1024)
				(self setScript: longFallBack)
			)
			((== (gEgo onControl: 1) 16384)
				(self setScript: longFallFront)
			)
			((and (== (gEgo onControl: 1) 512) (IsFlag 1) (not local0))
				(= local0 1)
				(Print 63 0) ; "You can't climb down the tree when you're invisible."
				(gEgo setMotion: 0 illegalBits: -32256)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(FadeBackSound)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'climb,climb/ceder')
				(Print 63 1) ; "You should be able to walk on the tree trunk from here, if you're very careful!"
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,ceder,branch]')
						(Print 63 2) ; "Far out on a huge branch, there is a nest."
					)
					((Said '<down')
						(Print 63 3) ; "Don't look down from here! You might get dizzy and loose your footing."
					)
					((Said '/egg[<gold]')
						(cond
							((gEgo has: 15) ; Gold_Egg
								(event claimed: 0)
							)
							(
								(and
									(== ((gInventory at: 15) owner:) gCurRoomNum) ; Gold_Egg
									(< (gEgo distanceTo: goldEgg) 50)
								)
								(Print 63 4) ; "There is a perfect, shimmering golden egg lying in the nest."
							)
							((not (< (gEgo distanceTo: goldEgg) 50))
								(Print 63 5) ; "You're too far away from the nest to see it clearly."
							)
							(else
								(Print 63 6) ; "You're looking at an empty nest."
							)
						)
					)
					((Said '/nest')
						(cond
							((not (gEgo inRect: 150 75 236 110))
								(Print 63 7) ; "You're not close enough to the nest."
							)
							((or (gEgo has: 15) (IsFlag 94)) ; Gold_Egg
								(Print 63 8) ; "There's nothing at all in the nest."
							)
							(else
								(Print 63 9) ; "Among the branches sits a small nest with a beautiful golden egg."
							)
						)
					)
				)
			)
			((Said 'get,get/nest')
				(Print 63 10) ; "One of the birds may need it, but you won't. Leave it alone."
			)
			((Said 'get,get/egg')
				(cond
					((not (gEgo inRect: 188 75 236 94))
						(Print 63 7) ; "You're not close enough to the nest."
					)
					((or (gEgo has: 15) (IsFlag 94)) ; Gold_Egg
						(Print 63 11) ; "You've already taken the only egg in the nest."
					)
					(else
						(self setScript: getEgg)
					)
				)
			)
		)
	)
)

(instance climbUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 48 posn: 50 201 init: setCycle: End self)
			)
			(1
				(proc0_1)
				(gEgo view: 0 setMotion: MoveTo 50 184 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 206 85 self)
			)
			(1
				(gEgo loop: 3)
				(self cue:)
			)
			(2
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(Print 63 12) ; "You carefully lift the golden egg out of the nest."
				(gEgo get: 15) ; Gold_Egg
				(goldEgg dispose:)
				(SetScore 94 6)
				(self dispose:)
			)
		)
	)
)

(instance goldEgg of View
	(properties
		x 206
		y 66
		description {golden egg}
		view 633
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 63 4) ; "There is a perfect, shimmering golden egg lying in the nest."
			)
		)
	)
)

(instance fallSEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 1 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallSWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 0)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 1 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 0)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 5 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 8)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 9 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(swoosh
					posn: (gEgo x:) (+ (gEgo y:) 50)
					cycleSpeed: 1
					setPri: 3
					init:
				)
				(gEgo setPri: 3 setCycle: CT 6 1 self)
			)
			(3
				(gEgo setCycle: End)
				(swoosh setCycle: End self)
			)
			(4
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fallNorth of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 8)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 9 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 1 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 4)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 6 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 1 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 5)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 7 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 1 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance longFrontFallLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 5)
				(gEgo setCycle: End self)
			)
			(1
				(localproc_1)
				(gEgo loop: 7 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setPri: 5 setCycle: End self)
			)
			(3
				(self setScript: fellOffTree)
			)
		)
	)
)

(instance fellOffTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 46)
				(gCurRoom newRoom: 14)
				(self dispose:)
			)
		)
	)
)

(instance crater of View ; UNUSED
	(properties
		x 210
		y 161
		description {hole}
		view 34
	)
)

(instance swoosh of Prop
	(properties
		description {swoosh}
		view 57
		loop 9
		cel 4
	)
)

(instance tree1 of NewFeature
	(properties
		x 60
		y 107
		noun '/ceder,branch'
		nsTop 89
		nsLeft 50
		nsBottom 126
		nsRight 70
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 65
		y 145
		noun '/ceder,branch'
		nsTop 126
		nsLeft 54
		nsBottom 164
		nsRight 76
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 136
		y 84
		noun '/ceder,branch'
		nsTop 76
		nsLeft 121
		nsBottom 92
		nsRight 152
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 151
		y 106
		noun '/ceder,branch'
		nsTop 92
		nsLeft 133
		nsBottom 120
		nsRight 169
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 175
		y 89
		noun '/ceder,branch'
		nsTop 81
		nsLeft 152
		nsBottom 98
		nsRight 198
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree6 of NewFeature
	(properties
		x 217
		y 84
		noun '/ceder,branch'
		nsTop 79
		nsLeft 197
		nsBottom 90
		nsRight 238
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree7 of NewFeature
	(properties
		x 142
		y 134
		noun '/ceder,branch'
		nsTop 120
		nsLeft 124
		nsBottom 148
		nsRight 161
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree8 of NewFeature
	(properties
		x 123
		y 154
		noun '/ceder,branch'
		nsTop 139
		nsLeft 100
		nsBottom 169
		nsRight 146
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree9 of NewFeature
	(properties
		x 76
		y 165
		noun '/ceder,branch'
		nsTop 152
		nsLeft 52
		nsBottom 178
		nsRight 101
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance tree10 of NewFeature
	(properties
		x 47
		y 183
		noun '/ceder,branch'
		nsTop 178
		nsLeft 25
		nsBottom 189
		nsRight 69
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Up here in the tree, the main trunk is bent enough to allow you to walk carefully along its length. The leaves and branches hide the ground from view.}
	)
)

(instance nest of NewFeature
	(properties
		x 205
		y 68
		noun '/nest[<bird]'
		nsTop 64
		nsLeft 198
		nsBottom 72
		nsRight 213
		description {nest}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {}
	)

	(method (doLook)
		(cond
			(
				(and
					(== ((gInventory at: 15) owner:) gCurRoomNum) ; Gold_Egg
					(<= (GetDistance (gEgo x:) (gEgo y:) 206 66 60) 50)
				)
				(Print 63 4) ; "There is a perfect, shimmering golden egg lying in the nest."
			)
			((>= (GetDistance (gEgo x:) (gEgo y:) 206 66 60) 50)
				(Print 63 5) ; "You're too far away from the nest to see it clearly."
			)
			(else
				(Print 63 6) ; "You're looking at an empty nest."
			)
		)
	)
)

