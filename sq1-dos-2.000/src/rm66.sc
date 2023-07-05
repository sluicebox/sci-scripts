;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use DeltaurRegion)
(use eRS)
(use SQEgo)
(use Elevator)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm66 0
)

(local
	local0
	local1
	[local2 70] = [0 189 0 0 319 0 319 105 292 105 292 94 307 94 307 45 278 45 278 94 289 94 289 105 221 105 221 96 235 96 235 44 204 44 204 96 217 96 217 105 0 104 0 110 13 110 2 119 2 134 128 134 101 147 91 147 33 176 91 176 147 134 169 134 186 142 319 142 319 189]
	[local72 64] = [0 189 0 0 319 0 319 102 308 105 304 110 286 110 278 105 221 105 221 96 235 96 235 44 204 44 204 96 217 96 217 105 0 104 0 110 13 110 2 119 2 134 128 134 104 149 88 149 39 175 91 175 112 158 144 134 169 134 186 142 319 142 319 189]
)

(instance rm66 of SQRoom
	(properties
		lookStr {You're in a brightly-colored hallway aboard the Deltaur. Two elevators dominate the upper level.}
		picture 66
		east 62
		west 57
	)

	(method (notify)
		(if (or (== gPrevRoomNum 60) (== gPrevRoomNum 67))
			(HandsOff)
		)
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(HandsOff)
		(Load rsSOUND 312)
		(LoadMany rsVIEW 415 66 166 479 419)
		(withG points: @local72 size: 32)
		(withoutG points: @local2 size: 35)
		(if (not (IsFlag 58))
			(self addObstacle: withG)
			(standingSarienHead init: standingSarien setLoop: 8)
			(standingSarien
				init:
				level: 1
				shootEgo: shootTheEgo1
				blastID: blast1
				regionPathID: 0
				dead: 0
				posn: 292 106
				loop: 2
				ignoreActors: 0
			)
			(if (== (DeltaurRegion egoStatus:) 1)
				(standingSarien approachVerbs: 5 12 11) ; Talk, Smell, Taste
			)
		else
			(self addObstacle: withoutG)
		)
		(= global166 1)
		(if (== gPrevRoomNum east)
			(gEgo posn: 310 116 loop: 1)
			(HandsOn)
			(= style 2)
		)
		(gFeatures add: bimActivate eachElementDo: #init)
		(switch gPrevRoomNum
			(57
				(gEgo loop: 0 posn: 9 109)
				(if (== (DeltaurRegion egoStatus:) 0)
					(standingSarien shotsFired: 3)
				)
			)
			(61
				(gEgo posn: 60 175)
			)
		)
		(super init: &rest)
		(DeltaurRegion eDoor2: e2Door)
		(DeltaurRegion eDoor1: e1Door)
		(e1Door
			view: 166
			loop: 0
			posn: 218 100
			description: {left elevator door}
			lookStr:
				{It's an elevator, much like the ones you used to waste time in aboard the Arcada.}
			whereTo: 60
			level: 1
			setPri: 7
			exiting: (or (== gPrevRoomNum 60) (< gPrevRoomNum 10))
			polyCode: 0
			init:
		)
		(e2Door
			view: 166
			loop: 0
			posn: 290 101
			locked: (not (IsFlag 58))
			lockStr:
				{The right elevator is identical to the left except for the ugly green guy standing in front of it.}
			setPri: 7
			lookStr: {This is an elevator.}
			description: {right elevator door}
			whereTo: 67
			level: 1
			exiting: (== gPrevRoomNum 67)
			polyCode: 0
			init:
			approachVerbs: 2 3 ; Look, Do
		)
		(switch gPrevRoomNum
			(57
				(self setScript: fromLaundry)
			)
			(61
				(self setScript: fromHallwayC)
			)
			(else
				(gEgo ignoreActors: 0)
			)
		)
		(gEgo init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((gEgo script:) 0)
			(
				(and
					(gCast contains: standingSarien)
					(not (& (gEgo illegalBits:) $0002))
				)
				(gEgo observeControl: 2)
			)
			(
				(and
					(not (gCast contains: standingSarien))
					(& (gEgo illegalBits:) $0002)
				)
				(gEgo ignoreControl: 2)
			)
			((e1Door inFront:)
				(e1Door open:)
			)
			((e2Door inFront:)
				(e2Door open:)
			)
			((& (= temp0 (gEgo onControl: 1)) $0008)
				(self setScript: toLaundry)
			)
			((& temp0 $0010)
				(gCurRoom newRoom: 61)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gEgo ignoreControl: 2)
		(if (standingSarien dead:)
			(SetFlag 58)
		)
		(super dispose:)
	)
)

(instance withG of Polygon
	(properties
		type PBarredAccess
	)
)

(instance withoutG of Polygon
	(properties
		type PBarredAccess
	)
)

(instance standingSarien of sarienGuard
	(properties
		description 3566
		approachX 269
		approachY 114
		lookStr 3535
	)

	(method (doit)
		(if
			(and
				(not guardLocked)
				(not script)
				(== level global166)
				(not (gEgo script:))
				(not (e1Door busy:))
				(not (e2Door busy:))
				(not dead)
				(!= (DeltaurRegion egoStatus:) 1)
				(not (gCurRoom script:))
			)
			(self setScript: shootEgo)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 12)) ; Inventory, Pulseray_Laser_Pistol
			(e2Door locked: 0)
			((gCurRoom obstacles:) delete: withG)
			(gCurRoom addObstacle: withoutG)
		)
		(super doVerb: theVerb invItem &rest)
	)
)

(instance standingSarienHead of Head
	(properties
		view 66
		loop 8
		cycleSpeed 216
	)
)

(instance blast1 of Prop
	(properties
		view 479
		loop 15
		priority 15
		signal 16400
		cycleSpeed 6
	)
)

(instance e1Door of Elevator
	(properties
		description {elevator door}
		sightAngle 90
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(if (!= global166 level)
			(Print 66 0) ; "You are on the wrong level to do that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance e2Door of Elevator
	(properties
		description {elevator door}
		sightAngle 90
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(if (!= global166 level)
			(Print 66 0) ; "You are on the wrong level to do that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shootTheEgo1 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(client cel: 0 setMotion: 0 view: 415)
				((client _head:) hide:)
				(client setLoop: (proc703_2 client gEgo))
				(= ticks 18)
			)
			(1
				(if (< (+ (client shotsFired:) 1) 5)
					(client shotsFired: (+ (client shotsFired:) 1))
					(= register 0)
				else
					(= register 1)
					(HandsOff)
				)
				(if (== (client view:) 415)
					(sarienShot play:)
					(client cel: (- (client lastCel:) 2) setCycle: End self)
				else
					(client view: 415 setMotion: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(if register
					(= temp0 (gEgo x:))
					(= temp1 (- (gEgo y:) 35))
				else
					(switch (Random 1 2)
						(1
							(= temp0 (- (gEgo nsLeft:) (Random 1 5)))
						)
						(2
							(= temp0 (+ (gEgo nsRight:) (Random 1 5)))
						)
					)
					(switch (Random 1 2)
						(1
							(= temp1 (- (gEgo nsTop:) (Random 1 5)))
						)
						(2
							(= temp1 (+ (gEgo nsBottom:) (Random 1 5)))
						)
					)
				)
				((client blastID:) init:)
				(if (OneOf (client loop:) 0 2 4)
					((client blastID:) setLoop: 1)
				else
					((client blastID:) setLoop: 2)
				)
				((client blastID:)
					ignoreActors: 1
					view: 479
					posn: temp0 temp1
					cel: 0
					setCycle: End self
				)
			)
			(3
				((client blastID:) dispose:)
				(= local0 (client x:))
				(= local1 (client y:))
				(if (and register (not (gEgo script:)))
					(gCurRoom setScript: (ScriptID 707 1)) ; egoShot
				)
				(= seconds 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance fromLaundry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: PolyPath 48 112 self)
			)
			(1
				(if (IsFlag 65)
					(ClearFlag 65)
					(Print 66 1) ; "You close your eyes in hopes your death will be quick, but, to your surprise, the guards do not notice you. In fact, you think your uniform is that of a higher-ranking Sarien officer worth sucking up to. Cool!"
				)
				(gEgo ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toLaundry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo 0 109 self)
			)
			(1
				(gCurRoom newRoom: 57)
			)
		)
	)
)

(instance fromHallwayC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo 90 161 self)
			)
			(1
				(gEgo ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bimWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bim
					posn: -10 189
					setLoop: 1
					setStep: 5 2
					setCycle: Fwd
					setMotion: MoveTo 335 189 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance bimActivate of RegionFeature
	(properties
		onMeCheck 1024
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Taste
				(if (not (bim script:))
					(bim init: setScript: bimWalk)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bim of Actor
	(properties
		view 166
		loop 1
		priority 15
		signal 16400
	)
)

(instance sarienShot of Sound
	(properties
		number 312
	)
)

