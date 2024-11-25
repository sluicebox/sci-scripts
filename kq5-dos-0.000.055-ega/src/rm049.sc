;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm049 0
)

(local
	[local0 3] = [21 43 -32768]
	[local3 5] = [50 56 73 72 -32768]
	[local8 5] = [94 98 114 119 -32768]
	[local13 5] = [120 122 135 122 -32768]
	[local18 9] = [157 111 185 100 238 67 347 20 -32768]
	[local27 11] = [17 63 62 77 106 97 139 107 160 115 -32768]
	[local38 9] = [164 115 185 104 207 90 227 73 -32768]
	[local47 11] = [75 62 137 75 224 76 294 65 332 53 -32768]
	local58
	[local59 10] = [114 145 126 153 151 149 172 131 150 129]
	[local69 36] = [0 0 225 0 225 91 166 107 114 89 109 108 70 112 62 124 130 125 149 131 172 131 163 139 162 158 179 158 211 108 319 95 319 189 0 189]
	[local105 20] = [0 145 21 144 48 132 70 112 109 108 113 89 166 107 225 91 225 0 0 0]
	[local125 14] = [86 189 171 176 142 158 179 158 211 108 319 95 319 189]
	local139
)

(instance rm049 of Rm
	(properties
		picture 49
		east 50
		south 48
		west 48
	)

	(method (init)
		(Load rsVIEW 654)
		(super init:)
		(self setFeatures: arch beach)
		(gEgo view: 6 illegalBits: $8000 init:)
		(switch gPrevRoomNum
			(east
				(proc0_24 128 667 22 23 21)
				(if (IsFlag 56)
					(gGlobalSound number: 814 loop: -1 vol: 127 playBed:)
				)
				((gEgo head:) hide:)
				(gEgo
					posn: 215 100
					setStep: 1 1
					view: (if (IsFlag 75) 661 else 6)
				)
				(theBoat init: x: 143 y: 140 ignoreActors: 1 setPri: 10)
				(sail
					init:
					setLoop: 2
					setCel: 0
					setPri: 11
					x: (theBoat x:)
					y: (theBoat y:)
				)
				(if (and (not (IsFlag 75)) (not (IsFlag 56)))
					(cedric
						posn: (+ (theBoat x:) 16) (theBoat y:) 8
						view: 650
						setLoop: 2
						setCel: 6
						init:
					)
				)
			)
			(else
				(HandsOff)
				(= global103 0)
				(self setScript: sailInScript)
			)
		)
		(if (IsFlag 55)
			(harpy1 init: setScript: harpyInitScript)
		)
		(if (not (gEgo has: 23)) ; Shell
			(shell init:)
			(glint init: posn: (shell x:) (shell y:) 0 setScript: glintScript)
		)
		(if (== global81 3)
			(wave0 init: setCycle: Fwd)
			(wave1 init: setCycle: Fwd)
			(wave2 init: setCycle: Fwd)
		)
		(if (== (gEgo view:) 661)
			(poly2 points: @local69 size: 18)
			(self addObstacle: poly2)
		else
			(poly1 points: @local59 size: 5)
			(poly3 points: @local105 size: 10)
			(poly4 points: @local125 size: 7)
			(self addObstacle: poly1 poly3 poly4)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(gCurRoom newRoom: 50)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
		(cond
			(local139 0)
			((and (!= (gEgo view:) 21) (& (gEgo onControl: 1) $0400))
				(gEgo view: 21)
			)
			((and (!= (gEgo view:) 23) (& (gEgo onControl: 1) $0040))
				(gEgo view: 23)
			)
			((and (!= (gEgo view:) 22) (& (gEgo onControl: 1) $2000))
				(cond
					((!= (gEgo view:) 661)
						(gEgo view: 22)
					)
					(local58 0)
					(else
						(if (not script)
							(PrintDC 49 0) ; "Cedric is near death. Taking him for a swim could be fatal."
						)
						(= local58 1)
					)
				)
			)
			(
				(and
					(!= (gEgo view:) 6)
					(!= (gEgo view:) 661)
					(not (& (gEgo onControl: 0) $2000))
					(not (& (gEgo onControl: 0) $0040))
					(not (& (gEgo onControl: 0) $0400))
				)
				(gEgo view: 6)
			)
			(else
				(= local58 0)
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
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance sailInScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local139 1)
				(self doit:)
				(theBoat init: setMotion: MoveTo 143 140 self)
				(sail init: setCel: 0)
				(wake init: setCycle: Fwd cycleSpeed: 1 setLoop: 0)
				(if (IsObject (gEgo head:))
					((gEgo head:) dispose:)
				)
				(gEgo normal: 0 view: 654 setLoop: 1 z: 0 setCel: 0)
				(if (not (IsFlag 56))
					(if (IsFlag 55)
						(= temp0 650)
						(= temp1 2)
						(= temp2 6)
					else
						(= temp0 654)
						(= temp1 2)
						(= temp2 0)
					)
					(cedric init: view: temp0 setLoop: temp1 setCel: temp2 z: 8)
				)
			)
			(1
				(sail setCycle: End)
				(wake dispose:)
				(if (not (IsFlag 55))
					(gCurRoom setScript: captureScript)
				else
					(gCurRoom setScript: getOffBoatScript)
				)
			)
		)
	)

	(method (doit)
		(if (theBoat mover:)
			((theBoat mover:) doit:)
		)
		(sail posn: (theBoat x:) (theBoat y:))
		(wake posn: (+ (theBoat x:) 20) (- (theBoat y:) 7))
		(gEgo posn: (- (theBoat x:) 8) (+ (theBoat y:) 3))
		(cedric posn: (+ (theBoat x:) 16) (theBoat y:))
		(super doit:)
	)
)

(instance getOffBoatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_24 128 22 23 21)
				(gEgo
					view: 23
					setLoop: -1
					setCycle: Walk
					setStep: 1 1
					normal: 1
					posn: (gEgo x:) (- (gEgo y:) 5)
					setMotion:
						MoveTo
						(- (theBoat x:) 13)
						(- (theBoat y:) 1)
						self
				)
			)
			(1
				(= local139 0)
				(gEgo setPri: -1)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance captureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 815 loop: -1 vol: 90 playBed:)
				(harpy3 init: setScript: harpy3Script)
				(harpy1 init: setCycle: Fwd setMotion: getEgo1 self)
			)
			(1
				(Say 75 49 1 67 -1 30 25 4) ; "Graham, I don't like the looks of this!"
				(harpy1 setMotion: getEgo2 self)
			)
			(2
				(Say 160 49 2 67 -1 30 25 3) ; "Me neither!"
				(harpy1 setPri: (+ (sail priority:) 1) setMotion: getEgo3 self)
				(harpy2 init: setScript: harpy2Script)
			)
			(3
				(harpy1 setMotion: getEgo4 self)
				(gEgo setPri: 11 setCycle: End self)
			)
			(4 0)
			(5
				(gEgo z: 0 dispose:)
				(harpy1 setPri: 11 setLoop: 3 setMotion: takeEgo self)
			)
			(6
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance harpy2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(harpy2 setCycle: Fwd setMotion: getCed self)
			)
			(1
				(Say 75 49 3 67 10 50 25 3) ; "Graham! Help me!"
				(harpy2 setLoop: 4 setCel: 0 setCycle: End self)
				(cedric dispose:)
			)
			(2
				(harpy2 setLoop: 5 setCycle: Fwd setMotion: takeCed)
			)
		)
	)
)

(instance harpy3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 25)
			)
			(1
				(harpy3 setCycle: Walk setMotion: guard)
			)
		)
	)
)

(instance harpyInitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (Random 1 100) 50)
					0
				else
					(self dispose:)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0002)
			(HandsOff)
			(gCurRoom setScript: harpyScript)
			(self dispose:)
		)
	)
)

(instance harpyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 815 loop: -1 vol: 90 playBed:)
				(harpy1
					init:
					setStep: 5 5
					setPri: 11
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 26) self
				)
			)
			(1
				(if (IsObject (gEgo head:))
					((gEgo head:) dispose:)
				)
				(gEgo z: 0 dispose:)
				(harpy1 setLoop: 3 setMotion: MoveTo 350 20 self)
			)
			(2
				(= global103 0)
				(= global330
					{Hate to harp on the subject, but... Graham's dead!}
				)
				(EgoDead 247)
			)
		)
	)
)

(instance castOffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 150 129 self)
			)
			(1
				(if (and (not (IsFlag 75)) (not (IsFlag 56)))
					(self setScript: grabCedScript self)
					(= register 1)
				else
					(= cycles 1)
				)
			)
			(2
				(= local139 1)
				(if register
					(self setScript: depositCedScript self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					setMotion:
						MoveTo
						(+ (theBoat x:) 11)
						(- (theBoat y:) 6)
						self
				)
			)
			(4
				(gEgo
					normal: 0
					view: 650
					setLoop: 2
					setCel: 4
					setCycle: 0
					setPri: 10
					posn: (+ (theBoat x:) 11) (theBoat y:) 5
				)
				(= cycles 1)
			)
			(5
				(sail setPri: 11 loop: 8)
				(= cycles 5)
			)
			(6
				(sail loop: 0)
				(= cycles 5)
			)
			(7
				(sail loop: 4)
				(= cycles 5)
			)
			(8
				(sail loop: 6)
				(= cycles 5)
			)
			(9
				(sail loop: 10)
				(= cycles 5)
			)
			(10
				(sail loop: 7)
				(= cycles 5)
			)
			(11
				(sail loop: 5)
				(= cycles 5)
			)
			(12
				(self doit:)
				(theBoat setPri: 10)
				(gEgo setPri: 11)
				(cedric setPri: 11)
				(sail setPri: 12)
				(wake init: setCycle: Fwd cycleSpeed: 1 setLoop: 1 setPri: 11)
				(theBoat setMotion: MoveTo -35 182 self)
				(if (IsObject (gEgo head:))
					((gEgo head:) dispose:)
				)
			)
			(13
				(gEgo setPri: -1)
				(SetFlag 55)
				(ClearFlag 75)
				(HandsOn)
				(= global103 0)
				(gCurRoom newRoom: 48)
			)
		)
	)

	(method (doit)
		(if (== state 12)
			(if (theBoat mover:)
				((theBoat mover:) doit:)
			)
			(sail x: (theBoat x:) y: (theBoat y:))
			(wake posn: (- (theBoat x:) 14) (+ (theBoat y:) 10))
			(gEgo posn: (+ (theBoat x:) 11) (theBoat y:) 5)
			(cedric posn: (- (theBoat x:) 9) (+ (theBoat y:) 5))
		)
		(super doit:)
	)
)

(instance grabCedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(+ (theBoat x:) 11)
						(- (theBoat y:) 6)
						self
				)
			)
			(1
				(cedric z: 1000)
				(self dispose:)
			)
		)
	)
)

(instance depositCedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (+ (theBoat x:) 5) (- (theBoat y:) 8) self
				)
			)
			(1
				(gEgo
					view: 667
					setLoop: 0
					setMotion: MoveTo (- (theBoat x:) 11) (theBoat y:) self
				)
			)
			(2
				(cedric
					init:
					ignoreActors: 1
					posn: (- (theBoat x:) 9) (+ (theBoat y:) 5) 0
					view: 650
					setLoop: 2
					setCel: 6
				)
				(gEgo setLoop: 1 setCycle: Walk)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance getShellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 654)
					(self setScript: getOffBoatScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 665)
				(gEgo
					setMotion: PolyPath (+ (shell x:) 1) (+ (shell y:) 1) self
				)
			)
			(2
				(= local139 1)
				(= register (gEgo view:))
				(gEgo
					normal: 0
					view: 665
					setLoop: 1
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(shell dispose:)
				(glint dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					normal: 1
					view: register
					setLoop: -1
					setCycle: Walk
					get: 23 ; Shell
				)
				(SetScore 2)
				(PrintDC 49 4) ; "Graham bends over and picks up the beautifully-colored shell."
				(= local139 0)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance glintScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(glint setCycle: End self)
			)
			(2
				(glint setCycle: 0)
				(self init:)
			)
		)
	)
)

(instance getEgo1 of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance getEgo2 of Path
	(properties)

	(method (at param1)
		(return [local3 param1])
	)
)

(instance getEgo3 of Path
	(properties)

	(method (at param1)
		(return [local8 param1])
	)
)

(instance getEgo4 of Path
	(properties)

	(method (at param1)
		(return [local13 param1])
	)
)

(instance takeEgo of Path
	(properties)

	(method (at param1)
		(return [local18 param1])
	)
)

(instance getCed of Path
	(properties)

	(method (at param1)
		(return [local27 param1])
	)
)

(instance takeCed of Path
	(properties)

	(method (at param1)
		(return [local38 param1])
	)
)

(instance guard of Path
	(properties)

	(method (at param1)
		(return [local47 param1])
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

(instance harpy1 of Act
	(properties
		y 38
		x -11
		view 654
		priority 12
		signal 26752
		illegalBits 0
	)
)

(instance harpy2 of Act
	(properties
		y 58
		x -12
		view 654
		signal 26624
		illegalBits 0
	)
)

(instance harpy3 of Act
	(properties
		y 49
		x -13
		view 654
		signal 26624
		illegalBits 0
	)
)

(instance cedric of Act
	(properties
		view 654
		loop 2
		signal 30720
	)
)

(instance theBoat of Act
	(properties
		y 182
		x -35
		yStep 1
		view 650
		loop 2
		signal 30976
		xStep 1
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
					(PrintDC 49 5) ; "The small sailboat seems to wait expectantly for Graham."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom
						setScript: castOffScript 0 (== (gEgo view:) 661)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wake of Prop
	(properties
		view 633
		signal 24576
	)
)

(instance sail of Prop
	(properties
		y 133
		x 146
		view 649
		loop 2
		signal 30976
	)
)

(instance shell of Prop
	(properties
		y 100
		x 120
		view 652
		loop 3
		signal 24576
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
					(PrintDC 49 6) ; "Graham notices a large conch shell lying delicately upon the sandy beach."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getShellScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		view 652
		loop 4
		signal 24576
		cycleSpeed 3
	)
)

(instance wave0 of Prop
	(properties
		y 146
		x 33
		view 652
		priority 1
		signal 16400
		cycleSpeed 15
	)
)

(instance wave1 of Prop
	(properties
		y 154
		x 108
		view 652
		loop 1
		priority 1
		signal 16400
		cycleSpeed 15
	)
)

(instance wave2 of Prop
	(properties
		y 180
		x 164
		view 652
		loop 2
		priority 1
		signal 16400
		cycleSpeed 15
	)
)

(instance beach of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not
					(or
						(& (OnControl CONTROL (event x:) (event y:)) $0004)
						(& (OnControl CONTROL (event x:) (event y:)) $0040)
						(& (OnControl CONTROL (event x:) (event y:)) $2000)
						(& (OnControl CONTROL (event x:) (event y:)) $0400)
					)
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 49 7) ; "A small bay laps gently upon a coarse sand beach of the rocky island."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance arch of RFeature
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
					(PrintDC 49 8) ; "Through a natural rock arch, Graham can see a sandy path leading up toward the island's interior."
					(event claimed: 1)
				)
			)
		)
	)
)

