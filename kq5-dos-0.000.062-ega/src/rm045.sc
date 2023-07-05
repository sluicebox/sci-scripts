;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use RandCycle)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
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
)

(instance rm045 of Rm
	(properties
		picture 45
		east 47
		south 44
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (proc0_15 newRoomNumber 44 45 46))
			(gGlobalSound fade:)
		)
	)

	(method (init)
		(super init:)
		(if (!= (gGlobalSound number:) 7)
			(gGlobalSound number: 7 loop: -1 vol: 127 play:)
		)
		(gGlobalSound2 number: 786 loop: -1 vol: 127 play:)
		(= global320 147)
		(= global321 99)
		(= global325 {"I'm tired of this place. Let's go somewhere else."})
		(self setRegions: 220 setFeatures: beach rocks rocks2 waterFall) ; boatRegion
		(if
			(and
				(not (IsFlag 55))
				(not (gCurRoom script:))
				(not (IsFlag 106))
			)
			(self setRegions: 202) ; owl
		)
		(proc0_24 128 26 28 30)
		(if (== global81 3)
			(water init:)
			(surf3 setScript: waves)
		)
		(switch gPrevRoomNum
			(east 0)
			(south
				(gEgo posn: (gEgo x:) 186 view: 0 init:)
				(if (and (gCast contains: global322) (not (IsFlag 106)))
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

	(method (doit &tmp temp0 temp1)
		(= temp1 0)
		(cond
			(script
				(script doit:)
			)
			((and (== (gEgo view:) 69) (gEgo cycler:) (gEgo mover:)))
			((and (not (IsFlag 90)) (== global361 45) (gEgo has: 18)) ; Beeswax
				(SetFlag 90)
				(Say 75 45 0 67 10 10 25 8) ; "Look Graham, there is a boat here! Maybe we can use it!"
			)
			((and (& (gEgo onControl: 1) $2000) (!= (gEgo view:) 26))
				(gEgo view: 26)
			)
			(
				(and
					(or
						(& (gEgo onControl: 1) $0200)
						(& (gEgo onControl: 1) $0400)
						(& (gEgo onControl: 1) $0010)
					)
					(!= (gEgo view:) 30)
				)
				(gCurRoom setScript: flail)
			)
			((and (!= (gEgo view:) 0) (& (gEgo onControl: 1) $0002))
				(gEgo setStep: 3 2 view: 0)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (and (gCast contains: global322) (!= temp0 47))
					(gEgo setLoop: -1)
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(SetFlag 108)
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
		(DisposeScript 751)
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
		view 617
		signal 24624
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
		y 147
		x 276
		view 619
		cycleSpeed 2
	)
)

(instance surf2 of Prop
	(properties
		y 187
		x 278
		view 619
		loop 1
		cycleSpeed 2
	)
)

(instance surf3 of Prop
	(properties
		y 103
		x 191
		view 617
		loop 3
		cycleSpeed 2
	)
)

(instance surf4 of Prop
	(properties
		y 124
		x 285
		view 617
		loop 4
		cycleSpeed 2
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 45 1) ; "Jagged rocks surround the waterfall at the base of the cliff and then continue on into the ocean."
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
					(PrintDC 45 2) ; "The narrow beach at the base of the steep, rocky cliff widens here somewhat, while the chilly ocean continues to beat relentlessly upon it."
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 45 3) ; "A cascading waterfall, though very beautiful, nevertheless cuts off further travel to the north."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 45 4) ; "There is little that Graham can do about the waterfall."
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 45 1) ; "Jagged rocks surround the waterfall at the base of the cliff and then continue on into the ocean."
					(event claimed: 1)
				)
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

