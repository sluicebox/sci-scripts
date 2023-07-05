;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm003 0
)

(local
	local0
	local1
	[local2 6] = [232 189 6 72 189 80]
	[local8 38] = [135 131 304 131 304 189 212 189 211 166 219 161 231 157 230 153 223 150 172 163 163 156 140 164 124 150 115 150 100 150 75 150 81 142 116 140 133 136]
	[local46 38] = [116 133 70 134 70 130 62 128 49 123 40 123 32 117 32 109 38 103 92 88 97 78 91 71 72 62 55 58 48 54 48 5 319 5 319 126 127 126]
	[local84 18] = [0 183 0 131 14 132 45 155 62 155 64 159 48 159 51 164 53 184]
	[local102 24] = [0 15 45 15 44 49 46 55 60 62 75 66 86 78 80 88 55 93 24 93 26 97 0 102]
	[local126 10] = [93 158 106 159 114 163 97 168 72 167]
)

(procedure (localproc_0 param1 param2) ; UNUSED
	(if (< argc 2)
		(= param2 5)
	)
	(OnControl
		CONTROL
		(- (param1 x:) param2)
		(- (param1 y:) param2)
		(+ (param1 x:) param2)
		(+ (param1 y:) param2)
	)
)

(instance rm003 of KQ5Room
	(properties
		picture 3
		horizon 65
		north 2
		east 4
		west 6
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 29 loop: -1 play:)
		(gGlobalSound2 number: 886 loop: -1 play: 80)
		(Load rsVIEW 48)
		(cedric init:)
		(if (== (gGame detailLevel:) 3)
			(wheel setCycle: Fwd init:)
			(water init:)
			(cow init: setScript: cowScript)
			(smoke setCycle: Fwd init:)
		else
			(cow init: stopUpd:)
			(wheel init: stopUpd:)
			(self setFeatures: cow wheel)
			(smoke init: stopUpd:)
		)
		(= global325 {"Let's DO something, Graham!"})
		(switch gPrevRoomNum
			(west
				(gEgo view: 6 posn: 4 118)
				(cedric setScript: cedricLand)
			)
			(north
				(gEgo view: 42 posn: 79 68)
				(cedric setScript: cedricLand)
			)
			(else
				(HandsOff)
				(gEgo view: 6 posn: 150 128)
				(self setScript: enterFromTown)
			)
		)
		(self setFeatures: townPath town1 town2 river mountains)
		(gEgo normal: 1 setStep: 1 1 illegalBits: -32768 init:)
		((gEgo head:) hide:)
		(poly1 points: @local8 size: 19)
		(poly2 points: @local46 size: 19)
		(poly3 points: @local84 size: 9)
		(poly4 points: @local102 size: 12)
		(poly5 points: @local126 size: 5)
		(self addObstacle: poly1 poly2 poly3 poly4 poly5)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((= local0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: cedricFly)
			)
			((& (gEgo onControl: 0) $4000)
				(if (not (IsFlag 29))
					(SetFlag 29)
					(proc0_28 75 3 0) ; "If you go on into town I'll wait for you here. I had a nasty run-in with a dog once and I'd feel safer out here."
				)
				(HandsOff)
				(self setScript: enterTown)
			)
			((& (gEgo onControl: 0) $2000)
				(HandsOff)
				(self setScript: drownHim)
			)
			((< (gEgo y:) 95)
				(gEgo view: 42)
			)
			((> (gEgo y:) 95)
				(gEgo view: 6)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (not (== (event type:) evVERB)))
			(return)
		)
	)

	(method (dispose)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(gGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance cedricLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric cel: 0 setCycle: End self)
			)
			(1
				(cedric stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance cedricFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric setCycle: Beg self)
			)
			(1
				(gGlobalSound fade:)
				(gCurRoom newRoom: local0)
			)
		)
	)
)

(instance drownHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_28 75 3 1 67 20 20) ; "Wait, Graham! Be careful...!"
				(gEgo
					normal: 0
					view: 48
					setPri: 15
					loop: (if (< (gEgo loop:) 4) 0 else 1)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gGlobalSound3 number: 68 loop: 1 play:)
				(cls)
				(gEgo
					setLoop: 2
					posn:
						(if (== (gEgo loop:) 0)
							(+ (gEgo x:) 15)
						else
							(- (gEgo x:) 23)
						)
						(+ (gEgo y:) 9)
					setCycle: Fwd
					setStep: 2 1
					setMotion: PolyPath -5 200 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(= global330
					{This ain't no swimmin' hole, Graham!}
				)
				(EgoDead)
			)
		)
	)
)

(instance enterFromTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 110 138 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 150 128 self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 4)
			)
		)
	)
)

(instance cowScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cow cycleSpeed: 2 setCycle: Beg)
				(= seconds (Random 5 10))
				(= state -1)
			)
		)
	)
)

(instance town1 of RFeature
	(properties
		nsTop 18
		nsLeft 165
		nsBottom 107
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 2 #at 50 50) ; "The quaint little town of Serenia nestles at the base of a great snowcapped mountain range which rises sharply to the east."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance town2 of RFeature
	(properties
		nsTop 59
		nsLeft 103
		nsBottom 151
		nsRight 224
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 2) ; "The quaint little town of Serenia nestles at the base of a great snowcapped mountain range which rises sharply to the east."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance river of RFeature
	(properties)

	(method (handleEvent event)
		(if (or (event claimed:) (not (== (event type:) evVERB)))
			(return)
		else
			(switch (event message:)
				((and (& (OnControl CONTROL (event x:) (event y:)) $2000) 2)
					(PrintDC 3 3) ; "A wild river tumbles down from the eastern mountains and flows swiftly below the small town."
					(event claimed: 1)
				)
				((and (& (OnControl CONTROL (event x:) (event y:)) $2000) 3)
					(HandsOff)
					(gEgo setMotion: PolyPath (event x:) (event y:))
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mountains of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 4) ; "Any journey across the great mountains promises to be perilous indeed."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance townPath of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 5) ; "A rutted road leads into the town from the west while a smaller path joins it from the north."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wheel of Prop
	(properties
		x 280
		y 167
		view 150
		priority 14
		signal 16
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 6) ; "A small tributary of the larger river powers an old waterwheel as it flows through the town."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cow of Prop
	(properties
		x 145
		y 151
		view 150
		loop 1
		priority 9
		signal 16
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 7) ; "Secure within a small pen, a pretty cow quietly chews her cud."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 3 8) ; "The cow doesn't have anything to say. Her mouth is too full of cud."
					(event claimed: 1)
				)
				(3 ; Do
					(proc0_28 75 3 9) ; "Come on, Graham! Don't waste your time with that cow!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cedric of Prop
	(properties
		x 42
		y 129
		view 141
		loop 4
		cel 13
		priority 14
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 3 10) ; "Cedric waits for Graham just outside the small town."
					(event claimed: 1)
				)
				(5 ; Talk
					(if (not local1)
						(++ local1)
						(proc0_28 75 3 11) ; "If you follow this road along the river you'll come to the town bakehouse. You might find something delicious...I mean, useful there."
					else
						(switch (Random 0 3)
							(0
								(PrintDC 3 12) ; "Cedric isn't listening to Graham at the moment."
							)
							(1
								(PrintDC 3 13) ; "Cedric isn't paying any attention to Graham."
							)
							(2
								(PrintDC 3 14) ; "Cedric isn't in the mood to talk right now."
							)
							(else
								(PrintDC 3 15) ; "Cedric doesn't have anything important to say at the moment."
							)
						)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 3 16) ; "Cedric doesn't need anything at the moment."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 202
		y 20
		view 150
		loop 2
		cycleSpeed 5
	)
)

(instance water of Waters
	(properties
		x 1000
		y 1000
		view 148
		priority 1
		cycleSpeed 5
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

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

