;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use SyncedView)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm225 0
)

(local
	local0
	local1
)

(instance rm225 of Room
	(properties
		noun 7
		picture 225
	)

	(method (init)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 14 69 29 69 42 118 67 115 32 67 14 67
					yourself:
				)
		)
		(super init: &rest)
		(buckets init:)
		(counter init:)
		(wall init:)
		(if (== gPrevRoomNum 230)
			(gGlobalSound0 number: 1024 setLoop: -1 setVol: 64 play:)
			(= local1 1)
			(gEgo
				setHeading: 270
				normalize: 0
				x: 133
				y: 108
				setScaler: Scaler 100 30 122 66
				init:
			)
			(bullets init:)
			(darrin init:)
			(self setScript: doneFire)
		else
			(bullets init:)
			(darrin init: setScript: loadBullets)
			(gEgo
				setHeading: 90
				normalize: 0
				x: 17
				y: 69
				setScaler: Scaler 100 30 122 66
				init:
				setMotion: PolyPath 70 50 self
				setScript: headGearOn
			)
		)
	)

	(method (cue)
		(cond
			((!= gPrevRoomNum 230)
				(gGame handsOn:)
			)
			((< (gEgo x:) 16)
				(gCurRoom newRoom: 220)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (not (gEgo mover:))
			(cond
				((< (gEgo x:) 16)
					(if (== gPrevRoomNum 220)
						(gMessager say: 1 4 1) ; "Hold on, Carey. You're here to shoot. It's not time to leave."
						(gEgo setMotion: 0 x: 16)
					else
						(gGame handsOff:)
						(gEgo setMotion: MoveTo 5 (gEgo y:) self)
					)
				)
				((position onMe: gEgo)
					(cond
						((== gPrevRoomNum 230)
							(if (not local1)
								(= local1 1)
								(gMessager say: 0 76 2) ; "Your shooting session is over for today."
							)
						)
						(
							(and
								(gEgo script:)
								(<= ((gEgo script:) state:) 1)
							)
							((gEgo script:) state: 3 cue:)
						)
					)
				)
				(else
					(= local1 0)
				)
			)
		)
	)
)

(instance door of Feature ; UNUSED
	(properties
		noun 1
		nsLeft 13
		nsTop 40
		nsRight 17
		nsBottom 66
		sightAngle 40
		approachX 15
		approachY 53
		approachDist 0
		x 15
		y 53
	)

	(method (doVerb theVerb)
		(cond
			((== gPrevRoomNum 220)
				(if (Message msgSIZE 225 noun theVerb 1 1)
					(gMessager say: noun theVerb 1)
				else
					(super doVerb: theVerb)
				)
			)
			((Message msgSIZE 225 noun theVerb 2 1)
				(gMessager say: noun theVerb 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance darrin of Actor
	(properties
		noun 3
		x 103
		y 138
		priority 150
		fixPriority 1
		view 227
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance bullets of Actor
	(properties
		x 126
		y 75
		priority 145
		fixPriority 1
		view 227
		loop 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance position of Feature
	(properties
		nsLeft 57
		nsTop 97
		nsRight 111
		nsBottom 115
		sightAngle 40
		x 87
		y 106
	)
)

(instance buckets of Feature
	(properties
		noun 4
		x 50
		y 152
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 23 79 29 79 29 89 27 89 27 94 25 110 25 114 25 117 30 119 29 121 29 125 30 132 37 133 37 139 36 152 15 152 13 144 9 143 8 142 10 119 9 115 12 113 13 110 12 96 13 94 14 89 13 86 14 84 17 81 22 81
					yourself:
				)
		)
	)
)

(instance counter of Feature
	(properties
		noun 2
		x 99
		y 88
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 99 65 126 65 139 71 139 86 97 71
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 191 80 319 112 319 154 169 98 176 88 190 88
					yourself:
				)
		)
	)
)

(instance wall of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 16 0 16 10 16 66 4 152 0 152
					yourself:
				)
		)
	)
)

(instance darrinPrompt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(darrin setScript: 0)
				(if (darrin cel:)
					(darrin setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(darrin view: 228 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 3 2 3 0 self) ; "Quit fooling around, let's get on with this. Take your position!"
			)
			(3
				(darrin setCycle: Beg self)
			)
			(4
				(darrin view: 227 setScript: loadBullets)
				(self dispose:)
			)
		)
	)
)

(instance headGearOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(clicker init:)
				(= register 1)
				(= ticks 120)
			)
			(1
				1
				(gMessager say: 0 0 4 0 self) ; "Officers! Take your field positions please."
			)
			(2
				2
				(if (not (position onMe: gEgo))
					(switch register
						(1
							(= state 0)
							(++ register)
							(= seconds 15)
						)
						(2
							(= state 1)
							(++ register)
							(= seconds 10)
						)
						(3
							(= state 1)
							(++ register)
							(self setScript: darrinPrompt self)
						)
						(4
							(= state 1)
							(++ register)
							(= seconds 5)
						)
						(5
							(gMessager say: 0 0 6 0 self) ; "Carey! This is a direct order. Take your field position NOW!"
						)
					)
				else
					(= state 3)
					(self cue:)
				)
			)
			(3
				3
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 67 115 self)
			)
			(4
				4
				(gEgo setHeading: 90 self)
				(= seconds 0)
			)
			(5
				5
				(if local0
					(self cue:)
				else
					(gGame handsOn:)
					(gTheIconBar disable: 0)
					(gEgo setLoop: 0 1)
					(= ticks 10)
					(= register 1)
				)
			)
			(6
				6
				(gMessager say: 0 0 5 0 self) ; "Officers, headgear on!"
			)
			(7
				7
				(if local0
					(self cue:)
				else
					(switch register
						(1
							(= state 5)
							(++ register)
							(= seconds 10)
						)
						(2
							(= state 5)
							(++ register)
							(= seconds 5)
						)
						(3
							(self cue:)
						)
					)
				)
			)
			(8
				8
				(clicker dispose:)
				(self setScript: goShoot)
			)
		)
	)
)

(instance clicker of Feature
	(properties)

	(method (init)
		(gEgo actions: self)
	)

	(method (dispose)
		(gEgo actions: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 55) ; protectors
			(gGame points: 1)
			(if (<= ((gEgo script:) state:) 2)
				((gEgo script:) state: 2 seconds: 0 cue:)
				(= local0 1)
			else
				(= local0 1)
				((gEgo script:) seconds: 0 ticks: 0 cue:)
			)
		else
			(gEgo doVerb: theVerb)
		)
	)
)

(instance goShoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 9257 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gEgo view: 0 setLoop: 0 1 setCycle: Walk)
				(= register (SyncedView new:))
				(register offset: 9225 init: gEgo)
				(gEgo setMotion: MoveTo 195 (gEgo y:) self)
			)
			(4
				(FrameOut)
				(= cycles 2)
			)
			(5
				(gEgo view: 9259 loop: 0 cel: 0 setCycle: End self)
				(register dispose:)
			)
			(6
				(= cycles 60)
			)
			(7
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance darrinDoneFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(darrin view: 231 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(darrin loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(darrin view: 227 loop: 0 cel: 0 setScript: loadBullets)
			)
		)
	)
)

(instance doneFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(darrin setScript: darrinDoneFire)
				(gEgo view: 0 setLoop: 1 1 setCycle: Walk)
				(= register (SyncedView new:))
				(register offset: 9225 init: gEgo)
				(gEgo setMotion: MoveTo 50 112 self)
			)
			(1
				(gEgo view: 9257 loop: 3)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
				(register dispose:)
			)
			(2
				(gEgo loop: 1)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(3
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance loadBullets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(darrin setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(darrin setCycle: Beg self)
			)
			(3
				(= ticks 30)
			)
			(4
				(self init:)
			)
		)
	)
)

