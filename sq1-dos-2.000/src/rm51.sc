;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use Inertia)
(use eRS)
(use RandCycle)
(use Feature)
(use LoadMany)
(use SmoothLooper)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm51 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
	(cond
		((or (== param5 1) (== param5 2))
			(= temp0 (- param4 5))
			(= temp1 (- param1 5))
			(= temp2 (+ param2 5))
			(= temp3 (+ param3 5))
		)
		((== param5 3)
			(= temp0 (- param2 5))
			(= temp1 (- param1 5))
			(= temp2 (+ param4 5))
			(= temp3 (+ param3 5))
		)
		((== param5 4)
			(= temp0 (- param4 5))
			(= temp1 (- param3 5))
			(= temp2 (+ param2 5))
			(= temp3 (+ param1 5))
		)
	)
	(gSoundEffects number: 312 loop: 1 play:)
	(= local2 (Graph grSAVE_BOX temp0 temp1 temp2 temp3 1))
	(Graph grDRAW_LINE param2 param1 param4 param3 global152 0 0)
	(Graph grREDRAW_BOX temp0 temp1 temp2 temp3)
	(Graph grRESTORE_BOX local2)
	(Graph grREDRAW_BOX temp0 temp1 temp2 temp3)
	(= local2 0)
)

(instance rm51 of SQRoom
	(properties
		lookStr {You're next to a large hatch in the side of this ship.}
		picture 51
		north 52
		east 52
		south 52
		west 52
	)

	(method (init)
		(LoadMany rsVIEW 34 64 152 82 83 151 54)
		(Load rsSCRIPT 968 809)
		(= gUseObstacles 0)
		(gEgo
			view: 34
			ignoreActors: 1
			setLoop: -1
			setCel: -1
			cycleSpeed: 24
			ignoreHorizon:
			normal: 0
			setPri: 14
			posn: 327 -10
			init:
		)
		(shadow init:)
		(HandsOff)
		(door init: stopUpd:)
		(airLockHandle init:)
		(self setScript: zoomIn)
		(super init:)
		(if (!= (gLongSong number:) 501)
			(gLongSong number: 501 loop: -1 play:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 ((User alterEgo:) edgeHit:))
				(HandsOff)
				(self setScript: whatGun 0 temp0)
			)
		)
	)

	(method (dispose)
		(DisposeScript 968)
		(DisposeScript 809)
		(super dispose: &rest)
	)
)

(instance changeMyDirection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 34
					setLoop:
						(switch (gEgo loop:)
							(0 2)
							(1 2)
							(2 0)
							(3 1)
							(4 0)
							(5 1)
							(6 3)
							(7 3)
						)
					cel: 0
				)
				(= cycles 7)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance southExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
					(= state 4)
				)
				(officer init: x: 158 y: 90 setPri: 1 cel: 0 setLoop: 7)
				(trooper
					init:
					x: 121
					y: 98
					setPri: 1
					cel: 4
					setLoop: 5
					setCycle: Beg
				)
				(= cycles 3)
			)
			(1
				(gEgo
					show:
					x: 123
					y: -10
					setCycle: RandCycle
					setMotion: MoveTo 105 2
				)
				(= cycles 3)
			)
			(2
				(officer setCycle: End self)
			)
			(3
				(localproc_0 117 11 (gEgo x:) (gEgo y:) 4)
				(= cycles 3)
			)
			(4
				(if (== (gEgo loop:) 0)
					(gEgo setLoop: 7 cel: 0)
				else
					(gEgo setLoop: 10 cel: 0)
				)
				(gEgo cycleSpeed: 9 setCycle: End self)
				(= state 8)
			)
			(5
				(gEgo
					show:
					x: 204
					y: -10
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 280 33
				)
				(= cycles 39)
			)
			(6
				(officer setCycle: End self)
			)
			(7
				(localproc_0 236 43 (gEgo x:) (gEgo y:) 1)
				(= cycles 3)
			)
			(8
				(if (== (gEgo loop:) 2)
					(gEgo setLoop: 9 cel: 0)
				else
					(gEgo setLoop: 8 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
			)
			(9
				(officer setCycle: Beg self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance eastExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
					(= state 4)
				)
				(officer init: x: 122 y: 101 setPri: 1 cel: 0 setLoop: 8)
				(trooper
					init:
					x: 162
					y: 93
					setPri: 1
					cel: 0
					setLoop: 5
					setCycle: CT 2 1
				)
				(= cycles 3)
			)
			(1
				(gEgo
					show:
					x: 0
					y: 90
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 23 64
				)
				(= cycles 12)
			)
			(2
				(officer setCycle: End self)
			)
			(3
				(localproc_0 60 62 (gEgo x:) (gEgo y:) 4)
				(= cycles 3)
			)
			(4
				(if (== (gEgo loop:) 0)
					(gEgo setLoop: 7 cel: 0)
				else
					(gEgo setLoop: 10 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
				(= state 8)
			)
			(5
				(gEgo
					show:
					x: 0
					y: 30
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 23 64
				)
				(= cycles 12)
			)
			(6
				(officer setCycle: End self)
			)
			(7
				(localproc_0 60 62 (gEgo x:) (gEgo y:) 4)
				(= cycles 3)
			)
			(8
				(if (== (gEgo loop:) 2)
					(gEgo setLoop: 9 cel: 0)
				else
					(gEgo setLoop: 8 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
			)
			(9
				(officer setCycle: Beg self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance westExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
					(= state 4)
				)
				(officer init: x: 185 y: 94 setPri: 1 cel: 0 setLoop: 8)
				(trooper
					init:
					x: 133
					y: 93
					setPri: 1
					cel: 0
					setLoop: 4
					setCycle: CT 2 1
				)
				(= cycles 3)
			)
			(1
				(gEgo
					show:
					x: 317
					y: -4
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 280 33
				)
				(= cycles 24)
			)
			(2
				(officer setCycle: End self)
			)
			(3
				(localproc_0 237 42 (gEgo x:) (gEgo y:) 1)
				(= cycles 3)
			)
			(4
				(if (== (gEgo loop:) 0)
					(gEgo setLoop: 7 cel: 0)
				else
					(gEgo setLoop: 10 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
				(= state 8)
			)
			(5
				(gEgo
					show:
					x: 317
					y: 76
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 280 33
				)
				(= cycles 24)
			)
			(6
				(officer setCycle: End self)
			)
			(7
				(localproc_0 237 42 (gEgo x:) (gEgo y:) 1)
				(= cycles 3)
			)
			(8
				(if (== (gEgo loop:) 2)
					(gEgo setLoop: 9 cel: 0)
				else
					(gEgo setLoop: 8 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
			)
			(9
				(officer setCycle: Beg self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance northExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
					(= state 4)
				)
				(officer init: x: 147 y: 116 setPri: 1 cel: 0 setLoop: 8)
				(trooper
					init:
					x: 124
					y: 97
					setPri: 1
					cel: 4
					setLoop: 5
					setCycle: Beg
				)
				(= cycles 3)
			)
			(1
				(gEgo
					show:
					x: 179
					y: 189
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 250 156
				)
				(= cycles 24)
			)
			(2
				(officer setCycle: End self)
			)
			(3
				(localproc_0 184 91 (gEgo x:) (gEgo y:) 3)
				(= cycles 3)
			)
			(4
				(if (== (gEgo loop:) 0)
					(gEgo setLoop: 7 cel: 0)
				else
					(gEgo setLoop: 10 cel: 0)
				)
				(gEgo cycleSpeed: 9 setCycle: End self)
				(= state 8)
			)
			(5
				(gEgo
					show:
					x: 275
					y: 189
					cel: 0
					setCycle: RandCycle
					setMotion: MoveTo 250 156
				)
				(= cycles 24)
			)
			(6
				(officer setCycle: End self)
			)
			(7
				(localproc_0 184 91 (gEgo x:) (gEgo y:) 3)
				(= cycles 3)
			)
			(8
				(if (== (gEgo loop:) 2)
					(gEgo setLoop: 9 cel: 0)
				else
					(gEgo setLoop: 8 cel: 0)
				)
				(gEgo cycleSpeed: 14 moveSpeed: 8 setCycle: End self)
			)
			(9
				(officer setCycle: Beg self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance whatGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(spaceInertia dispose:)
				(gLongSong fade:)
				(gEgo
					xStep: 4
					yStep: 3
					looper: 0
					setMotion: 0
					setLoop: (gEgo loop:)
				)
				(gCast eachElementDo: #hide)
				(gEgo posn: -100 -100)
				(gun1 init:)
				(gun2 init:)
				(gun3 init:)
				(gun4 init:)
				(if (== (gEgo view:) 64)
					(gEgo setScript: changeMyDirection)
				)
				(gCurRoom drawPic: 52 -32758)
				(shadow show:)
				(self
					setScript:
						(switch register
							(1 northExit)
							(2 eastExit)
							(3 southExit)
							(else westExit)
						)
						self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(EgoDead 948 0 0 51 0) ; "The inhabitants of this vessel apparently do not appreciate your desire to sight-see. I guess it's a good idea not to be wandering around the outside this ship. You were a carbon-based being. Now your just carbon."
				(self dispose:)
			)
		)
	)
)

(instance officer of Prop
	(properties
		x 121
		y 98
		view 152
		loop 5
		cel 5
		cycleSpeed 8
	)
)

(instance trooper of Prop
	(properties
		x 151
		y 87
		view 152
		loop 6
		cycleSpeed 9
	)
)

(instance shadow of Actor
	(properties
		priority 13
		signal 24592
	)

	(method (doit &tmp temp0)
		(if local0
			(= temp0
				(switch (gEgo onControl: 1)
					(8 28)
					(2 35)
					(else 22)
				)
			)
			(= x (gEgo x:))
			(= y (+ (gEgo y:) temp0))
		)
		(= view
			(switch (gEgo view:)
				(34 82)
				(64 83)
			)
		)
		(= loop (gEgo loop:))
		(= cel (gEgo cel:))
		(super doit: &rest)
	)
)

(instance gun1 of View
	(properties
		x 214
		y 79
		view 152
	)
)

(instance gun2 of View
	(properties
		x 86
		y 96
		view 152
		loop 1
	)
)

(instance gun3 of View
	(properties
		x 170
		y 107
		view 152
		loop 2
	)
)

(instance gun4 of View
	(properties
		x 134
		y 61
		view 152
		loop 3
	)
)

(instance zoomIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
				(= local0 0)
			)
			(1
				(shadow
					posn: 300 180
					moveSpeed: 6
					setStep: 8 8
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 210 100
				)
				(gEgo setLoop: 4 cel: 1 setMotion: MoveTo 308 70 self)
			)
			(2
				(gEgo cel: 2 setMotion: MoveTo 284 86 self)
			)
			(3
				(gEgo cel: 0 setMotion: MoveTo 262 98 self)
			)
			(4
				(gEgo setLoop: 5 cel: 1 setMotion: MoveTo 244 84 self)
			)
			(5
				(gEgo cel: 2 setMotion: MoveTo 236 80 self)
			)
			(6
				(gEgo cel: 3 setMotion: MoveTo 224 77 self)
			)
			(7
				(gEgo setMotion: MoveTo 210 70 self)
			)
			(8
				(= local0 1)
				(gEgo
					setLoop: 3
					setStep: 2 2
					posn: 177 78
					cycleSpeed: 24
					setCycle: Fwd
					setMotion: MoveTo 149 64 self
				)
			)
			(9
				(Print 51 1) ; "You are floating in space just outside the biggest darn spaceship you've ever seen. You see a door. Perhaps it is a way in?"
				(HandsOn)
				(spaceInertia init: gEgo)
				(gEgo
					setLoop: -1
					setStep: 1 1
					moveSpeed: 5
					cycleSpeed: 40
					looper: flyingLooper
				)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 110
		y 99
		sightAngle 45
		onMeCheck 2
		lookStr {airlock door}
		view 151
		priority 8
		signal 16400
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 51 2) ; "It appears to be a standard airlock. There is a handle off to the side."
			)
			(3 ; Do
				(Print 51 3) ; "Its too big to move by hand. There must be a better way."
			)
			(11 ; Taste
				(Print 51 4) ; "Not through your helmet."
			)
			(12 ; Smell
				(Print 51 5) ; "You would have to take your helmet off first, and that's not a very good idea."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flyingLooper of SmoothLooper
	(properties
		vNormal 34
		vChangeDir 64
	)
)

(instance spaceInertia of Inertia
	(properties
		maxInertia 2
	)
)

(instance airLockHandle of Feature
	(properties
		x 52
		y 115
		z 4
		nsTop 103
		nsLeft 40
		nsBottom 120
		nsRight 65
		description {airlock handle}
		sightAngle 45
		onMeCheck 4
		lookStr {airlock handle}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 51 6) ; "It's a handle."
			)
			(3 ; Do
				(gCurRoom setScript: goInside)
			)
			(11 ; Taste
				(Print 51 4) ; "Not through your helmet."
			)
			(12 ; Smell
				(Print 51 7) ; "You'd have to take your helmet off first and that would prove fatal."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(spaceInertia dispose:)
				(= cycles 15)
			)
			(1
				(gEgo setMotion: MoveTo 45 100 self)
			)
			(2
				(cond
					((== (gEgo loop:) 1)
						(gEgo view: 64 setLoop: 1 cel: 0 setCycle: End self)
					)
					((== (gEgo loop:) 3)
						(gEgo view: 64 setLoop: 4 cel: 0 setCycle: End self)
					)
					(else
						(= cycles 3)
					)
				)
			)
			(3
				(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 2))
					(gEgo view: 64 setLoop: 2 cel: 0 setCycle: End self)
				else
					(= cycles 3)
				)
			)
			(4
				(gEgo
					view: 34
					loop: 6
					cel: 0
					setPri: 14
					cycleSpeed: 18
					moveSpeed: 4
					setCycle: CT 6 1 self
				)
			)
			(5
				(gLongSong2 number: 504 loop: 1 play: hold: 1)
				(gSoundEffects number: 503 loop: 1 play:)
				(gEgo cel: 2 setCycle: CT 6 1 self)
			)
			(6
				(door cel: 1 forceUpd:)
				(gEgo cel: 2 setCycle: CT 6 1 self)
			)
			(7
				(door cel: 2 forceUpd:)
				(gEgo cel: 2 setCycle: CT 6 1 self)
			)
			(8
				(door cel: 3 forceUpd:)
				(gEgo cel: 2 setCycle: CT 6 1 self)
			)
			(9
				(door dispose:)
				(gLongSong2 hold: 0)
				(gEgo setCycle: End self)
			)
			(10
				(shadow setPri: 6)
				(gEgo
					setLoop: 0
					setCycle: RandCycle 4
					setPri: 10
					setMotion: MoveTo 112 76 self
				)
			)
			(11
				(gSoundEffects number: 505 loop: 1 play:)
				(gEgo setLoop: 11 setCycle: End self)
			)
			(12
				(gLongSong fade:)
				(gEgo
					x: 140
					y: 112
					view: 54
					setLoop: 0
					cel: 0
					setPri: 8
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 177 173 self
				)
				(shadow dispose:)
			)
			(13
				(HandsOn)
				(= gUseObstacles 1)
				(gCurRoom newRoom: 53)
			)
		)
	)
)

