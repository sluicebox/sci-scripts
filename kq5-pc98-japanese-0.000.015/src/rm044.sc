;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
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
	rm044 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 2]
	[local7 34] = [235 0 198 73 236 93 230 124 170 152 89 136 87 126 179 109 179 96 96 76 147 65 121 65 92 58 81 52 184 44 173 40 174 0]
	[local41 30] = [110 42 108 47 9 58 64 66 65 61 102 64 78 75 20 76 54 132 118 179 90 189 0 189 0 0 155 0 155 38]
	[local71 10] = [132 91 156 94 139 104 85 104 76 94]
	[local81 8] = [319 186 242 186 233 176 319 176]
)

(instance rm044 of KQ5Room
	(properties
		picture 44
		north 45
		east 47
		south 46
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo illegalBits: -32768)
		(if (not (OneOf newRoomNumber 44 45 46))
			(gGlobalSound fade:)
		)
	)

	(method (init)
		(super init:)
		(= global325
			{"Come on, Graham! Let's explore the beach!"}
		)
		(= global320 15)
		(= global321 72)
		(if (not (gEgo has: 30)) ; Iron_Bar
			(ironBar init: ignoreActors: setPri: 2)
		)
		(self setRegions: 220 setFeatures: path44 beach ocean) ; boatRegion
		(if (== global361 45)
			(smallBoat init: setPri: 1)
		)
		(if
			(and
				(not (IsFlag 54))
				(not (gCurRoom script:))
				(not (IsFlag 105))
			)
			(self setRegions: 202) ; owl
		)
		(if (== (gGame detailLevel:) 3)
			(waterFall
				x: 242
				y: 50
				init:
				view: 614
				setLoop: 1
				setPri: 0
				cycleSpeed: 4
				setCycle: Fwd
			)
			(surf1 setScript: waves)
		)
		(LoadMany rsVIEW 0 26 28)
		(switch gPrevRoomNum
			(south
				(gEgo view: 0 posn: 130 187)
				(if (and (gCast contains: global322) (not (IsFlag 105)))
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(north
				(gEgo view: 0 posn: 246 114)
				(if (gCast contains: global322)
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(east 0)
			(43
				(gEgo posn: -10 160)
			)
			(else
				(gEgo posn: 146 150)
			)
		)
		(gFeatures eachElementDo: #init)
		(if (== gPrevRoomNum 43)
			(gEgo
				init:
				signal: 24576
				illegalBits: 0
				cycleSpeed: 2
				posn: -10 160
				setCycle: Fwd
				setPri: (+ (eagle priority:) 1)
				normal: 0
				view: 616
				setLoop: 1
			)
			((gEgo head:) hide:)
			(self setScript: flyIn)
		else
			(gEgo init: illegalBits: -32768)
			(if (!= (gGlobalSound number:) 7)
				(gGlobalSound number: 7 loop: -1 vol: 127 play:)
			)
		)
		(poly1 points: @local7 size: 17)
		(poly2 points: @local41 size: 15)
		(poly3 points: @local71 size: 5)
		(poly4 points: @local81 size: 4)
		(self addObstacle: poly1 poly2 poly3 poly4)
		(if (and (IsFlag 105) (!= gCurRoom global361) (not (gCurRoom script:)))
			(self setScript: walkThru)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $0400)
				(if (> (gEgo x:) 99)
					(self setScript: changeDown)
				else
					(self setScript: changeUp)
				)
			)
			((& (gEgo onControl: 0) $4000)
				(if (gCast contains: global322)
					((ScriptID 202 2) register: 1) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: 45)
				)
			)
			((and (& (gEgo onControl: 1) $2000) (!= (gEgo view:) 26))
				(gEgo view: 26)
			)
			(
				(and
					(!= (gEgo view:) 0)
					(!= (gEgo view:) 2)
					(not (gEgo script:))
					(not (& (gEgo onControl: 0) $2000))
					(not (& (gEgo onControl: 0) $0040))
				)
				(gEgo view: 0)
			)
			((& (gEgo onControl: 0) $0002)
				(gCurRoom setScript: fall)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (and (gCast contains: global322) (!= temp0 47))
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(SetFlag 107)
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
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance walkThru of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: setMotion: PolyPath 237 105 self)
			)
			(1
				(gCurRoom newRoom: 45)
			)
		)
	)
)

(instance changeUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 9
					setLoop: 1
					setCycle: End self
					illegalBits: 0
					moveSpeed: 0
					cel: 0
					posn: 73 54
					setMotion: MoveTo 123 43
				)
				((gEgo head:) hide:)
			)
			(1
				(gEgo
					view: 2
					setCycle: KQ5SyncWalk
					setLoop: -1
					setPri: 1
					illegalBits: -32768
					moveSpeed: (gGame egoMoveSpeed:)
					setMotion: MoveTo 123 43 self
				)
				((gEgo head:) show:)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance changeDown of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 9
					setLoop: 0
					setCycle: End self
					cel: 0
					moveSpeed: 0
					illegalBits: 0
					posn: 113 44
					setMotion: MoveTo 68 55
				)
				((gEgo head:) hide:)
			)
			(1
				(gEgo
					view: 0
					setCycle: KQ5SyncWalk
					setLoop: -1
					setPri: -1
					illegalBits: -32768
					moveSpeed: (gGame egoMoveSpeed:)
					setMotion: MoveTo 68 55 self
				)
				((gEgo head:) show:)
			)
			(2
				(gEgo setMotion: PolyPath 69 60 self)
			)
			(3
				(HandsOn)
				(if (gEgo script:)
					(gEgo setScript: getBar)
				)
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
					setPri: 2
					ignoreActors:
					cycleSpeed: 10
				)
				(surf2
					init:
					setCycle: RandCycle
					setPri: 2
					ignoreActors:
					cycleSpeed: 10
				)
				(surf3
					init:
					setCycle: RandCycle
					setPri: 2
					ignoreActors:
					cycleSpeed: 10
				)
				(surf4
					init:
					setCycle: RandCycle
					setPri: 2
					ignoreActors:
					cycleSpeed: 10
				)
			)
			(1
				(surf1 setCycle: Beg self)
				(surf2 setCycle: Beg)
				(surf3 setCycle: Beg)
				(surf4 setCycle: Beg)
			)
			(2
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance fall of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(if (== (gEgo loop:) 1)
					(= local4 1)
				else
					(= local4 0)
				)
				(if (< (gEgo y:) 90)
					(= local3 1)
				else
					(= local3 0)
				)
				(gEgo
					view: (if (== (gEgo view:) 0) 100 else 97)
					normal: 0
					setStep: 2 7
					cycleSpeed: (if local3 1 else 1)
					setPri: (if local3 2 else 10)
					illegalBits: 0
					posn: (+ (gEgo x:) 10) (gEgo y:)
					ignoreActors:
					setLoop: 0
					cel: 0
					setCycle: CT 3 1
				)
				(= cycles 1)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(if local4
							(- (gEgo x:) 25)
						else
							(+ (gEgo x:) 15)
						)
						(if local3
							(+ (gEgo y:) 35)
						else
							(+ (gEgo y:) 28)
						)
						self
				)
			)
			(2
				(gGlobalSound3 number: 78 loop: 1 vol: 127 play:)
				(= seconds 3)
			)
			(3
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					setLoop: (+ local4 6)
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 1)
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(5
				(if (== (gEgo view:) 97)
					(gEgo
						view: 2
						setLoop: -1
						loop: 3
						setCycle: KQ5SyncWalk
						setStep: 3 2
						cycleSpeed: 0
						setMotion: MoveTo 205 119 self
					)
					((gEgo head:) show:)
				else
					(= cycles 1)
				)
			)
			(6
				(if local3
					(gEgo
						normal: 1
						view: 0
						setLoop: -1
						loop: 3
						setCycle: KQ5SyncWalk
						setStep: 3 2
						cycleSpeed: 0
						setMotion: MoveTo 235 125 self
					)
					((gEgo head:) show:)
				else
					(= cycles 1)
				)
			)
			(7
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					setPri: -1
					illegalBits: -32768
					loop: 3
					setCycle: KQ5SyncWalk
					setStep: 3 2
					cycleSpeed: 0
				)
				(gEgo loop: 2)
				((gEgo head:) show:)
				(HandsOn)
				(= cycles 1)
			)
			(8
				(client setScript: 0)
			)
		)
	)
)

(instance flyIn of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local1 1)
			(gEgo posn: (+ (eagle x:) 1) (- (eagle y:) 4))
		)
		(if (== (gGlobalSound prevSignal:) -1)
			(gGlobalSound number: 7 loop: -1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
				(HandsOff)
				(eagle setPri: 0 init:)
				(= local1 1)
			)
			(1
				(eagle setCycle: Fwd setMotion: MoveTo 160 5 self)
			)
			(2
				(= local1 0)
				(gEgo
					init:
					setLoop: 2
					cel: 0
					setPri: 2
					cycleSpeed: 0
					setStep: 3 4
					setCycle: End
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(3
				(gGlobalSound3 number: 892 loop: 1 vol: 127 play:)
				(eagle setLoop: 3 setPri: 15 setMotion: MoveTo 340 0 self)
			)
			(4
				((gEgo head:) show:)
				(gEgo
					view: 2
					setCycle: KQ5SyncWalk
					posn: (gEgo x:) (+ (gEgo y:) 33)
					setPri: -1
					setLoop: -1
					setMotion: PolyPath 102 47 self
				)
			)
			(5
				((gEgo head:) hide:)
				(gEgo view: 9 setLoop: 0)
				(gGlobalSound fade:)
				(= cycles 1)
			)
			(6
				(gEgo
					setCycle: End self
					setMotion:
						MoveTo
						(- (gEgo x:) 40)
						(+ (gEgo y:) 10)
						self
				)
			)
			(7
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setCycle: KQ5SyncWalk
					setLoop: -1
					setMotion: PolyPath 70 79 self
				)
			)
			(8
				(gEgo view: 0 loop: 7 cel: 2 setPri: -1)
				(= cycles 5)
			)
			(9
				(eagle dispose:)
				(proc0_28 75 44 0 67 10 90 25 5) ; "Graham, where have you been? I've been looking all over for you!"
				(= cycles 1)
			)
			(10
				(cls)
				(proc0_28 160 44 1 67 60 90 25 5) ; "You'd never believe it, Cedric. You'd never believe it."
				(= cycles 1)
			)
			(11
				(HandsOn)
				(gEgo illegalBits: -32768)
				(cls)
				(self dispose:)
			)
		)
	)
)

(instance getBar of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (& (gEgo onControl: 1) $2000))
				(not (& (gEgo onControl: 1) $0040))
				(!= (gEgo view:) 56)
				(or (== (gEgo view:) 26) (== (gEgo view:) 28))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 150 170 self
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo view: 56 loop: 0 cel: 0 normal: 0 cycleSpeed: 1)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(ironBar dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo get: 30) ; Iron_Bar
				(gEgo
					view: 0
					normal: 1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					illegalBits: -32768
				)
				((gEgo head:) show:)
				(SetScore 2)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance ocean of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $2000))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 44 2) ; "A narrow strand of beach skirts the bottom of the steep cliffs while the cold water of the ocean seems to cunningly steal what little is left."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path44 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 44 3) ; "A short path, starting from a ledge up the cliffside, winds snakelike down to a narrow beach."
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
				(not (& (OnControl CONTROL (event x:) (event y:)) $0100))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 44 2) ; "A narrow strand of beach skirts the bottom of the steep cliffs while the cold water of the ocean seems to cunningly steal what little is left."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance waterFall of Prop
	(properties
		x 237
		y 50
		view 614
		loop 1
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
					(PrintDC 44 4) ; "Further up the beach, Graham can see a lovely waterfall cascading down the cliffs and falling into the cold, blue ocean."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance ironBar of Prop
	(properties
		x 160
		y 172
		view 893
		loop 1
		cel 5
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
					(PrintDC 44 5) ; "Graham notices a rusty iron bar lying on the sand near the bottom of the winding path."
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setScript: getBar)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance eagle of Actor
	(properties
		x -18
		y 13
		view 616
		priority 14
		signal 24576
		cycleSpeed 3
		illegalBits 0
	)
)

(instance surf1 of Prop
	(properties
		x 275
		y 189
		view 614
	)
)

(instance surf2 of Prop
	(properties
		x 261
		y 74
		view 614
		loop 2
	)
)

(instance surf3 of Prop
	(properties
		x 299
		y 121
		view 614
		loop 3
	)
)

(instance surf4 of Prop
	(properties
		x 298
		y 152
		view 614
	)
)

(instance poly1 of Polygon
	(properties)
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

(instance smallBoat of View
	(properties
		x 221
		y 37
		view 614
		loop 4
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
					(PrintDC 44 6) ; "Graham notices a boat in the distance."
					(event claimed: 1)
				)
			)
		)
	)
)

