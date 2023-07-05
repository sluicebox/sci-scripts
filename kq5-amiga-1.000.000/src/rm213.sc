;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Follow)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm213 0
)

(local
	local0
	local1
	[local2 10] = [171 119 229 123 233 127 164 127 148 124]
	[local12 34] = [199 48 194 6 110 6 98 58 142 111 85 112 68 108 64 112 36 113 11 107 0 109 0 0 319 0 319 120 278 115 242 112 185 115]
)

(procedure (localproc_0 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(instance rm213 of KQ5Room
	(properties
		picture 213
		horizon 98
		north 214
		east 212
		south 15
		west 212
	)

	(method (init)
		(super init:)
		(gEgo view: 2 setPri: -1 setStep: 2 1 init:)
		(gGlobalSound number: 2 loop: -1 vol: 127 play:)
		(gGlobalSound2 number: 3 loop: -1 vol: 127 play:)
		(switch gPrevRoomNum
			(214
				(gEgo loop: 2 posn: (localproc_0 141 (gEgo x:) 181) 114)
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 1))
			)
			(15
				(gEgo posn: 160 186)
			)
			(212
				(gEgo posn: (gEgo x:) (localproc_0 121 (gEgo y:) 200))
			)
			(else
				(gEgo posn: 160 160)
			)
		)
		(LoadMany rsVIEW 364 366 378 376)
		(cond
			((and (IsFlag 52) (not (IsFlag 32)) (== gPrevRoomNum 214))
				(gEgo posn: global110 global111)
				(SetFlag 32)
				(HandsOff)
				(guard1 init: setScript: rideOut)
				(guard2 init: setScript: rideOut2)
			)
			((not (IsFlag 32))
				(guard1 init: setScript: rideIn)
			)
		)
		(self setFeatures: pond sands temple rock cliff)
		(poly1 points: @local2 size: 5)
		(poly2 points: @local12 size: 17)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((not (IsFlag 43))
				(SetFlag 43)
				(SetScore 3)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(++ global322)
				(switch (gEgo edgeHit:)
					(3
						(++ global315)
					)
					(4
						(++ global314)
					)
					(2
						(-- global314)
					)
					(1 0)
				)
				(HandsOn)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOn)
				(gGlobalSound fade:)
				(gGlobalSound2 fade:)
				(gCurRoom newRoom: north)
			)
			((== local0 2)
				(gGlobalSound fade:)
				(gGlobalSound2 fade:)
				(= global110 (gEgo x:))
				(= global111 (gEgo y:))
				(SetFlag 52)
				(gCurRoom newRoom: north)
			)
		)
	)

	(method (handleEvent event)
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
		(if gGlobalSound
			(gGlobalSound fade:)
		)
		(if gGlobalSound3
			(gGlobalSound3 fade:)
		)
		(DisposeScript 971)
		(super dispose:)
	)
)

(instance getDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 188 130 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 45
					loop: 3
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo loop: (+ (gEgo loop:) 4) cel: 0 setCycle: End self)
			)
			(3
				(= cycles 20)
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo loop: (- (gEgo loop:) 4) cel: 3 setCycle: Beg self)
			)
			(6
				(= global322 0)
				(PrintDC 213 0) ; "Ah! Life-giving water! Nectar of the gods! Graham can now feel renewal flowing through him."
				(gEgo normal: 1 view: 2 setCycle: KQ5SyncWalk cycleSpeed: 0)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance rideIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(PrintDC 213 1) ; "From across the desert sands, Graham can hear the sound of approaching hoofbeats."
				(gGlobalSound2 stop:)
				(gGlobalSound number: 47 loop: 1 vol: 127 playBed:)
				(= seconds 8)
			)
			(3
				(HandsOff)
				(if (not (& (gEgo onControl: 1) $0002))
					(LoadMany rsVIEW 380)
					(gCurRoom setScript: attack)
				else
					(= cycles 1)
				)
			)
			(4
				(SetScore 2)
				(guard2 init: setScript: rideIn2)
				(guard1
					setStep: 6 6
					setCycle: Walk
					setMotion: MoveTo 125 125 self
				)
			)
			(5
				(guard1
					posn: 135 119
					cel: 0
					setLoop: 1
					setMotion: MoveTo 142 115
					setCycle: End self
				)
			)
			(6
				(guard1
					view: 366
					setLoop: 0
					cel: 0
					setStep: 3 10
					setMotion: MoveTo (+ (guard1 x:) 10) 121
					setCycle: End self
				)
			)
			(7
				(++ local0)
				(client setScript: 0)
			)
		)
	)
)

(instance rideIn2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard2
					setStep: 6 6
					setCycle: Walk
					setMotion: MoveTo 125 135 self
				)
			)
			(1
				(guard2
					posn: 135 129
					cel: 0
					setLoop: 1
					setMotion: MoveTo 140 125
					setCycle: End self
				)
			)
			(2
				(guard2
					view: 378
					setLoop: 0
					cel: 0
					setStep: 3 10
					setMotion: MoveTo (+ (guard2 x:) 10) 130
					setCycle: End self
				)
			)
			(3
				(++ local0)
				(client setScript: 0)
			)
		)
	)
)

(instance rideOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound3 number: 47 loop: 1 vol: 127 playBed:)
				(guard1
					view: 366
					setLoop: 1
					cel: 0
					setStep: 1 1
					posn: 143 110
					setMotion: MoveTo 143 145
					setCycle: End self
				)
			)
			(1
				(guard1
					view: 364
					posn: (+ (guard1 x:) 6) (+ (guard1 y:) 8)
					setStep: 6 6
					cel: 0
					setLoop: 2
					setMotion: MoveTo 125 145
					setCycle: End self
				)
			)
			(2
				(guard1
					setLoop: 3
					posn: (- (guard1 x:) 7) (+ (guard1 y:) 9)
					setCycle: Walk
					setMotion: MoveTo -60 (guard1 y:) self
				)
			)
			(3
				(gGlobalSound3 fade: self)
			)
			(4
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance rideOut2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard2
					view: 378
					setLoop: 6
					cel: 0
					setStep: 1 1
					posn: 141 115
					setMotion: MoveTo 141 155
					setCycle: End self
				)
			)
			(1
				(guard2
					view: 376
					posn: (+ (guard2 x:) 6) (+ (guard2 y:) 8)
					setStep: 6 6
					cel: 0
					setLoop: 2
					setMotion: MoveTo 123 155
					setCycle: End self
				)
			)
			(2
				(guard2
					setCycle: Walk
					posn: (- (guard2 x:) 7) (+ (guard2 y:) 9)
					setLoop: 3
					setMotion: MoveTo -60 160 self
				)
			)
			(3
				(gGlobalSound3 fade:)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance attack of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (<= (Abs (- (guard2 x:) (gEgo x:))) 3)
			((gEgo head:) hide:)
			(gEgo
				normal: 0
				view: 380
				loop: 3
				cel: 0
				cycleSpeed: 2
				setCycle: End
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PrintDC 213 2 #at 20 20 #dispose) ; "A spy! Get him!"
				(guard2 setStep: 6 6 setCycle: Walk init:)
				(if (< (gEgo y:) 132)
					(guard2
						setMotion:
							MoveTo
							(- (gEgo x:) 70)
							(+ (gEgo y:) 10)
							self
					)
				else
					(guard2
						setMotion:
							MoveTo
							(- (gEgo x:) 70)
							(- (gEgo y:) 5)
							self
					)
				)
				(guard1
					posn: -80 125
					setStep: 6 6
					setCycle: Walk
					ignoreActors: 1
					setMotion: Follow guard2 30
					init:
				)
			)
			(1
				(guard2
					view: 380
					setCycle: End self
					setMotion: MoveTo (+ (guard2 x:) 300) (guard2 y:) self
				)
			)
			(2
				(guard2 setCycle: Walk view: 376 setLoop: 0)
			)
			(3
				(cls)
				(= global330 {Watch out for bad guys, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance sands of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 213 3) ; "Looking south, the desert seems to extend forever."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance temple of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 213 4) ; "The facade of a magnificent temple has been carved into the cliffs by some unknown ancient civilization."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rock of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
				)
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 213 5) ; "Graham finds the unusual shape of the two rocks at the cliff base interesting."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 213 6) ; "The rocks look interesting but too large to do anything with."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cliff of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 213 7) ; "Sheer rock cliffs rise straight up from the desert floor forming a plateau at the top."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 213 8) ; "Graham contemplates attempting to climb the rocky cliff but wisely chooses not to."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance pond of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 213 9) ; "A small oasis has formed in the space between the two rocks."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((and (== (guard1 script:) rideIn) (rideIn state:))
							(PrintDC 213 10) ; "That wouldn't be a wise idea now."
						)
						((not local1)
							(++ local1)
							(HandsOff)
							(gCurRoom setScript: getDrink)
						)
						(else
							(PrintDC 213 11) ; "Graham has drank all the water he needs for now."
						)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance guard1 of Actor
	(properties
		x -60
		y 120
		view 364
	)
)

(instance guard2 of Actor
	(properties
		x -80
		y 130
		view 376
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

