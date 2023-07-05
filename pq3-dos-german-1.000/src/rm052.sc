;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm052 0
)

(instance rm052 of PQRoom
	(properties
		lookStr {PHEEW! It's still a little on the toasty side in here. The stench of burnt carpet and upholstry coils the hairs in your nose.}
		picture 52
	)

	(method (init)
		(LoadMany rsVIEW 4 547 546 545)
		(sAfterFire setVol: 10 play: 10 fade: 127 25 10 0)
		(super init:)
		(HandsOff)
		(walls init:)
		(furniture init:)
		(floor init:)
		(cushion init:)
		(bluePatch init:)
		(hallway init:)
		(if (not (gEgo has: 6)) ; photo
			(smallpic init:)
			(picInset init: hide:)
		)
		(glow1 init: setCycle: Fwd)
		(glow2 init: setCycle: Fwd)
		(glow3 init: setCycle: Fwd)
		(drip init: setCycle: Fwd)
		(smoke init: setCycle: Fwd)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 43 223 43 156 76 137 75 140 87 76 109 66 106 0 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 113 66 113 74 138 81 143 228 145 251 126 250 90 171 77 221 51 319 51 319 189 0 189
					yourself:
				)
		)
		(gEgo normal: 1 view: 4 setStep: 3 2)
		(if (== gPrevRoomNum 53)
			(gEgo posn: 188 62 init:)
			(self setScript: enterStageRight)
		else
			(gEgo posn: 80 125 init:)
			(self setScript: enterStageLeft)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(HandsOff)
				(self setScript: exitStageRight)
			)
			((& temp0 $1000)
				(HandsOff)
				(self setScript: exitStageLeft)
			)
		)
		(super doit:)
	)
)

(instance mBurning of Sound
	(properties
		flags 1
		number 510
		vol 10
		loop -1
	)
)

(instance sAfterFire of Sound
	(properties
		flags 1
		number 520
		vol 10
		loop -1
	)
)

(instance pickUpPhoto of Sound
	(properties
		flags 1
		number 232
	)
)

(instance pickUpSting of Sound
	(properties
		flags 1
		number 521
	)
)

(instance exitStageLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 56 110 self)
			)
			(1
				(mBurning fade: self)
				(sAfterFire fade: self)
				(gLongSong fade:)
			)
			(2
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance exitStageRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 188 62 self)
			)
			(1
				(mBurning fade: self)
				(sAfterFire fade: self)
				(gLongSong fade:)
			)
			(2
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance enterStageLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 90 115 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterStageRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mBurning play:)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(gEgo setMotion: MoveTo 154 97 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getPicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(- (smallpic x:) 5)
						(- (smallpic y:) 2)
						self
				)
			)
			(2
				(gEgo
					normal: 0
					view: 545
					x: (+ (gEgo x:) 8)
					y: (+ (gEgo y:) 1)
					setLoop: 0
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(3
				(smallpic dispose:)
				(pickUpPhoto play:)
				(= cycles 2)
			)
			(4
				(picInset show:)
				(Print 52 0 #at 40 20) ; "It looks like a photograph. You pick it up."
				(gEgo get: 6) ; photo
				(SetFlag 67 57)
				(mBurning dispose:)
				(sAfterFire dispose:)
				(= cycles 1)
			)
			(5
				(= cycles 1)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(pickUpSting play: self)
			)
			(8
				(sAfterFire play:)
				(mBurning play:)
				(Print 52 1 #at 40 20) ; "It takes you a moment to realize what you're seeing. You feel goosebumps crawl up your back."
				(= cycles 1)
			)
			(9
				(Print 52 2 #at 40 20) ; "The man on the left is none other than your one-time arch nemesis, Jessie Bains. The man on the right bears a striking resemblance to him."
				(= cycles 1)
			)
			(10
				(Print 52 3 #at 40 20) ; "You don't believe this! The Bains brothers, Michael and Jessie."
				(= cycles 1)
			)
			(11
				(SetScore 179 5)
				(picInset hide:)
				(gEgo x: (- (gEgo x:) 7) y: (- (gEgo y:) 2) cel: 4)
				(NormalEgo 4 9)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance glow1 of Actor
	(properties
		x 102
		y 148
		view 547
		loop 1
		priority 15
		signal 16400
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(walls doVerb: theVerb &rest)
	)
)

(instance glow2 of Actor
	(properties
		x 111
		y 66
		view 547
		cel 2
		priority 15
		signal 16400
		cycleSpeed 7
	)

	(method (doVerb theVerb invItem)
		(walls doVerb: theVerb &rest)
	)
)

(instance glow3 of Actor
	(properties
		x 181
		y 147
		view 547
		loop 3
		cel 1
		priority 15
		signal 16400
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(walls doVerb: theVerb &rest)
	)
)

(instance picInset of View
	(properties
		x 237
		y 189
		sightAngle 90
		view 546
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(picInset hide:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 93
		y 102
		sightAngle 90
		view 547
		loop 5
		priority 14
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb invItem)
		(floor doVerb: theVerb &rest)
	)
)

(instance drip of Prop
	(properties
		x 148
		y 96
		sightAngle 90
		view 547
		loop 4
		signal 16384
		cycleSpeed 8
	)
)

(instance smallpic of View
	(properties
		x 151
		y 113
		sightAngle 90
		view 545
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: getPicScript)
			)
			(2 ; Look
				(Print 52 4 #width 240) ; "You notice something shiny sticking out from under a mound of burnt refuse."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls of Feature
	(properties
		x 128
		y 39
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 52 5) ; "The walls are marred by fire."
			)
			(3 ; Do
				(Print 52 6) ; "You don't want to touch that. Some of this stuff is still hot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance furniture of Feature
	(properties
		x 94
		y 81
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 52 7) ; "The ugly old couch is soaked and smoldering. The smell of burnt upholstery stings your nose."
			)
			(3 ; Do
				(Print 52 8) ; "The smoking couch does not interest you."
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
		y 103
		onMeCheck 28672
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 52 9 #width 240) ; "The carpet has melted in places into a molten polyester mess."
			)
			(3 ; Do
				(Print 52 10) ; "You search this area but find nothing."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cushion of Feature
	(properties
		x 129
		y 97
		onMeCheck 128
		lookStr {A sofa cushion is on the floor.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 52 11) ; "The cushion doesn't interest you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bluePatch of Feature
	(properties
		x 142
		y 116
		onMeCheck 256
		lookStr {Just something else that was melted by the intense heat of the fire.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 52 12) ; "The melted glob doesn't interest you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hallway of Feature
	(properties
		x 173
		y 47
		onMeCheck 512
		lookStr {A hallway leads off from what's left of the living room.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 52 13) ; "Just walk there."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

