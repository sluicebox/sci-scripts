;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)

(public
	Room170 0
)

(local
	local0
	local1
	local2
	[local3 200]
)

(procedure (localproc_0)
	(chimney init:)
	(gate init:)
	(sign1 init:)
	(door init:)
	(window1 init:)
	(shop init:)
	(roof init:)
	(wall init:)
	(barrel init:)
	(house init:)
)

(instance Room170 of FRoom
	(properties
		lookStr {This must be the town.}
		picture 170
		style 0
		horizon 61
		north 120
		east 180
		south 220
		west 160
		northX 200
		northY 16
		southX 300
		southY 172
		eastX 338
		eastY 160
		westY 77
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(Load rsSOUND 148)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 90 57 99 82 98 137 160 207 160 242 149 277 158 286 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 41 66 31 62 0 62 0 0 156 0 159 59 144 66 156 76 148 91 100 81
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 131 296 131 286 91 211 90 211 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 310 173 310 162 319 162 319 173 311 173
					yourself:
				)
		)
		(sign1 setPri: 3 ignoreActors: 1 stopUpd: init:)
		(pump setPri: 4 ignoreActors: 1 init:)
		(smoke setCycle: Fwd ignoreActors: 1 setPri: 7 init:)
		(localproc_0)
		(if (and (not (IsFlag 2)) (IsFlag 5))
			(gBookEnd init: setScript: escape)
		)
	)

	(method (cue)
		(super cue:)
		(if (= local0 (proc10_17 InvFriend))
			((= local1 (local0 regActor:))
				setCycle: StopWalk
				setHeading: 270
				init:
			)
			(if (== gPrevRoomNum 220)
				(local1 setHeading: 0)
			)
			(gEgo setHeading: 270)
			(switch local0
				((gInventory at: 4)
					(local1 setCycle: Walk)
					(self setScript: leaveWithRooster)
				)
				((gInventory at: 5)
					(self setScript: leaveWithCat)
				)
				((gInventory at: 7)
					(self setScript: leaveWithDonkey)
				)
				((gInventory at: 10)
					(self setScript: leaveWithSnowWhite)
				)
				((gInventory at: 11)
					(self setScript: leaveWithPrince)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((not (IsFlag 5)) 0)
			((IsFlag 2) 0)
			((not (gEgo mover:)) 0)
			((<= (Abs (- (gEgo heading:) 90)) 20)
				(self setScript: bookChase)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 5)
			(SetFlag 2)
		)
		(super dispose: &rest)
	)
)

(instance bookChase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 300 141 self)
			)
			(1
				(gEgo setMotion: PolyPath 300 199 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance escape of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBookEnd
					setCycle: Walk
					setStep: 7 3
					posn: 295 130
					setMotion: PolyPath 295 200 self
				)
			)
			(1
				(gBookEnd dispose:)
				(self dispose:)
			)
		)
	)
)

(instance leaveWithRooster of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(local1
					setMotion:
						PolyPath
						(gCurRoom southX:)
						(+ (gCurRoom eastY:) 10)
						self
				)
			)
			(2
				(proc10_13 3 local1 gEgo self 0 170 0)
			)
			(3
				(proc10_13 3 local1 gEgo self 1 170 1)
			)
			(4
				(self setScript: leaveEast self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance leaveWithCat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(local1
					setMotion:
						PolyPath
						(gCurRoom southX:)
						(+ (gCurRoom eastY:) 10)
						self
				)
			)
			(2
				(proc10_13 3 local1 gEgo -1 0 170 2)
				(proc10_13 0 local1 gEgo self 1 170 3)
			)
			(3
				(self setScript: leaveEast self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance leaveWithDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(local1
					setMotion:
						PolyPath
						(gCurRoom southX:)
						(+ (gCurRoom eastY:) 20)
						self
				)
			)
			(2
				(proc10_13 0 local1 gEgo -1 0 170 4)
				(proc10_13 0 local1 gEgo self 1 170 5)
			)
			(3
				(self setScript: leaveEast self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance leaveWithSnowWhite of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (> (local1 x:) 317)
					(local1 setMotion: MoveTo 317 (local1 y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(proc10_13
					3
					local1
					gEgo
					self
					1
					(Format @local3 170 6 @global110) ; "%s, I know the Dwarves don't live in town. Let's look somewhere else."
				)
			)
			(3
				(self setScript: leaveSouth self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance leaveWithPrince of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (> (local1 x:) 317)
					(local1 setMotion: MoveTo 317 (local1 y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(proc10_13 3 local1 gEgo -1 0 170 7)
				(proc10_13 2 local1 gEgo -1 0 170 8)
				(proc10_13 0 local1 gEgo -1 0 170 9)
				(proc10_13 0 local1 gEgo self 1 170 10)
			)
			(3
				(self setScript: leaveSouth self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance leaveEast of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setMotion: PolyPath 350 (gCurRoom eastY:) self)
			)
			(1
				(gEgo setMotion: PolyPath 319 (gCurRoom eastY:) self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance pumpSound of Sound
	(properties
		flags 1
		number 148
	)
)

(instance pumpWater of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 72 self)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 1)
			)
			(2
				(pumpSound play:)
				(pump setCycle: End self)
			)
			(3
				(pumpSound play:)
				(pump setCycle: End self)
			)
			(4
				(proc10_23 170 11)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance signMove of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sign1 setCycle: End self)
			)
			(1
				(sign1 setCycle: CT 0 -1 self)
			)
			(2
				(sign1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance leaveSouth of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1
					setMotion:
						PolyPath
						(- (gCurRoom southX:) 10)
						(+ (gCurRoom southY:) 60)
						self
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(- (gCurRoom southX:) 10)
						(gCurRoom southY:)
						self
				)
			)
			(2
				(local1 dispose:)
				(= cycles 10)
			)
			(3
				(gCurRoom newRoom: 220)
				(self dispose:)
			)
		)
	)
)

(instance pump of Prop
	(properties
		x 134
		y 63
		description {Pump}
		sightAngle 90
		lookStr {The pump is used to get water.}
		view 170
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (pump script:))
					(pump setScript: pumpWater)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 20
		y 65
		view 170
		loop 2
	)

	(method (doVerb theVerb)
		(chimney doVerb: theVerb)
	)
)

(instance sign1 of Prop
	(properties
		x 51
		y 14
		description {Sign}
		sightAngle 90
		lookStr {The sign is moved by the wind.}
		view 170
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (sign1 script:))
					(sign1 setScript: signMove)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chimney of Feature
	(properties
		x 17
		y 107
		description {Chimney}
		sightAngle 90
		onMeCheck 2
		lookStr {Smoke rises from the chimney.}
	)
)

(instance gate of Feature
	(properties
		x 254
		y 81
		description {Gate}
		sightAngle 90
		onMeCheck 4
		lookStr {The gate to the town is large.}
	)
)

(instance door of Feature
	(properties
		x 61
		y 68
		description {Door}
		sightAngle 90
		onMeCheck 32
		lookStr {This is the door into a shop.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(Print 170 12) ; "You hear a voice say, "I'm sorry, we're closed.""
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance window1 of Feature
	(properties
		x 94
		y 66
		description {Window}
		sightAngle 90
		onMeCheck 64
		lookStr {The window lets light into the room.}
	)
)

(instance shop of Feature
	(properties
		x 117
		y 46
		description {Shop}
		sightAngle 90
		onMeCheck 128
		lookStr {This shop is closed.}
	)
)

(instance roof of Feature
	(properties
		x 68
		y 128
		description {Roof}
		sightAngle 90
		onMeCheck 256
		lookStr {The roof is made of wood.}
	)
)

(instance wall of Feature
	(properties
		x 24
		y 170
		description {Wall}
		sightAngle 90
		onMeCheck 512
		lookStr {The wall is made of stone.}
	)
)

(instance barrel of Feature
	(properties
		x 120
		y 85
		description {Barrel}
		sightAngle 90
		onMeCheck 1024
		lookStr {Barrels are used to catch rain.}
	)
)

(instance house of Feature
	(properties
		x 195
		y 35
		description {House}
		sightAngle 90
		onMeCheck 2048
		lookStr {There is a nice house to the north.}
	)
)

