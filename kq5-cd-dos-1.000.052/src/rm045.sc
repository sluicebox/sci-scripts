;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use CodeCue)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm045 0
)

(local
	[local0 2]
	[local2 22] = [144 2 80 93 2 80 94 52 80 400 0 80 400 0 80 400 0 80 400 0 80 1]
	[local24 40] = [0 189 0 0 319 0 319 92 293 90 275 78 207 81 159 76 128 85 136 91 114 95 126 99 76 109 106 110 103 117 63 120 78 124 24 146 40 166 22 189]
	[local64 8] = [147 110 176 114 154 120 120 114]
	[local72 8] = [154 129 173 125 189 129 171 131]
	[local80 8] = [254 88 294 94 260 98 243 94]
	[local88 9] = [1000 130 50 4 11 24 19 23 30]
)

(instance rm045 of KQ5Room
	(properties
		picture 45
		east 47
		south 44
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (OneOf newRoomNumber 44 45 46))
			(gGlobalSound fade:)
		)
	)

	(method (init)
		(super init:)
		(= global320 147)
		(= global321 99)
		(= global325 3068)
		(self setRegions: 220 setFeatures: beach rocks rocks2 waterFall) ; boatRegion
		(if
			(and
				(not (IsFlag 54))
				(not (gCurRoom script:))
				(not (IsFlag 105))
			)
			(self setRegions: 202) ; owl
		)
		(if (not (IsFlag 89))
			(gGame setScript: boatHereGraham)
		)
		(LoadMany rsVIEW 26 28 30)
		(gGlobalAudio doNotStop: 1 number: 7054 loop: -1 play:)
		(if (== (gGame detailLevel:) 3)
			(water init:)
		)
		(surf3 setScript: waves)
		(switch gPrevRoomNum
			(east 0)
			(south
				(gEgo posn: (gEgo x:) 186 view: 0 init:)
				(if (and (gCast contains: global322) (not (IsFlag 105)))
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(else
				(gEgo posn: 84 186 init:)
			)
		)
		(if (gCast contains: global322)
			(global322 setPri: 8)
		)
		(poly1 points: @local24 size: 20)
		(poly2 points: @local64 size: 4)
		(poly3 points: @local72 size: 4)
		(poly4 points: @local80 size: 4)
		(self addObstacle: poly1 poly2 poly3 poly4)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(cond
			(script
				(script doit:)
			)
			((and (== (gEgo view:) 69) (gEgo cycler:) (gEgo mover:)))
			(
				(and
					(& (= temp2 (gEgo onControl: 1)) $2000)
					(!= (gEgo view:) 26)
				)
				(gEgo view: 26)
			)
			((and (& temp2 $0610) (!= (gEgo view:) 30))
				(gCurRoom setScript: flail)
			)
			((and (!= (gEgo view:) 0) (& temp2 $0002))
				(gEgo setStep: 3 2 view: 0)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(if (and (gCast contains: global322) (!= temp0 47))
					(gEgo setLoop: -1)
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(SetFlag 107)
					(gEgo setLoop: -1)
					(gCurRoom newRoom: temp0)
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gGlobalSound2 fade:)
		(DisposeScript 401)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance flail of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					view: 69
					setLoop: 4
					illegalBits: 0
					setCycle: Fwd
					setStep: 4 2
					setMotion: PolyPath 340 100 self
				)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance waves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(surf1
					init:
					show:
					setCycle: End self
					setPri: 1
					ignoreActors:
					cycleSpeed: 10
				)
				(surf2
					init:
					setCycle: RandCycle
					setPri: 1
					ignoreActors:
					cycleSpeed: 10
				)
				(surf3
					init:
					setCycle: Fwd
					setPri: 1
					ignoreActors:
					cycleSpeed: 3
				)
				(surf4
					init:
					setCycle: Fwd
					setPri: 1
					ignoreActors:
					cycleSpeed: 6
				)
			)
			(1
				(surf1 setCycle: Beg self)
				(surf2 setCycle: Beg)
			)
			(2
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance cedricScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322
					view: 618
					setLoop: 11
					setCycle: Fwd
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 5 5
					setMotion: MoveTo (Random 1 100) 50 self
				)
			)
			(1
				(global322
					setLoop: 12
					setMotion: MoveTo (Random 200 320) 50 self
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance water of Waters
	(properties
		x 144
		y 2
		view 617
		signal 24624
		detailLevel 3
	)

	(method (getLoop)
		(= x [local2 pos])
		(= y [local2 (++ pos)])
		(= cel [local2 (++ pos)])
	)

	(method (saveLoop)
		(= [local2 pos] cel)
		(++ pos)
	)
)

(instance surf1 of Prop
	(properties
		x 276
		y 147
		view 619
		cycleSpeed 2
		detailLevel 3
	)
)

(instance surf2 of Prop
	(properties
		x 278
		y 187
		view 619
		loop 1
		cycleSpeed 2
		detailLevel 3
	)
)

(instance surf3 of Prop
	(properties
		x 191
		y 103
		view 617
		loop 3
		cycleSpeed 2
		detailLevel 3
	)
)

(instance surf4 of Prop
	(properties
		x 285
		y 124
		view 617
		loop 4
		cycleSpeed 2
		detailLevel 3
	)
)

(instance rocks2 of RFeature
	(properties
		nsTop 24
		nsLeft 181
		nsBottom 85
		nsRight 319
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 511)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance beach of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $2000))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 512)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance waterFall of RFeature
	(properties
		nsLeft 102
		nsBottom 68
		nsRight 179
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 513)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 514)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rocks of RFeature
	(properties
		nsBottom 113
		nsRight 97
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 511)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance boatHereGraham of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(SetFlag 89)
				(proc762_1 @local88 3069 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

