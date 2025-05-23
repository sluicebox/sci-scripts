;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm027 0
)

(local
	[local0 16] = [0 155 52 158 93 154 200 164 238 159 319 157 319 189 0 189]
	[local16 40] = [133 0 112 22 125 60 91 101 89 116 110 122 160 122 160 126 114 126 140 140 172 143 183 149 239 148 239 101 248 101 250 148 279 148 300 138 319 136 319 0]
	[local56 18] = [117 0 117 16 104 29 96 92 85 106 65 109 81 128 0 129 0 0]
	[local74 8] = [224 165 242 172 211 175 207 171]
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

(procedure (localproc_1 &tmp temp0)
	(signCel init:)
	(RedrawCast)
	(while (not (proc0_15 ((= temp0 (Event new:)) type:) 1 4))
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(signCel dispose:)
)

(instance rm027 of Rm
	(properties
		picture 27
		horizon 45
		north 10
		east 6
		west 11
	)

	(method (init)
		(super init:)
		(= global320 168)
		(= global321 100)
		(gEgo normal: 1 setStep: 2 2 offset: 3 view: 2 init:)
		(self
			setFeatures: FakeDoor signPost path27 river hayStack house barn
			setRegions: 202 ; owl
		)
		(= global325 {"This is getting tedious, Graham. Can we go now?"})
		(FDoor init:)
		(SDoor init:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 314 162)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo view: 4 offset: 2 posn: 111 47)
				(HandsOff)
				(self setScript: walkDown)
			)
			(west
				(gEgo posn: 5 150)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(28
				(gEgo illegalBits: 0 posn: 126 124)
				(SDoor cel: 3)
				(HandsOff)
				(self setScript: fromKitchen)
			)
			(85
				(HandsOff)
				(self setScript: outDoor)
			)
			(else
				(gEgo posn: 245 155)
			)
		)
		(Load rsVIEW 71)
		(if (!= (gGlobalSound number:) 883)
			(gGlobalSound number: 883 loop: -1 vol: 127 playBed:)
		)
		(gGlobalSound2 number: 24 loop: -1 vol: 127 play:)
		(smoke1 init:)
		(smoke2 init:)
		(if (== global81 3)
			(river1 setCycle: Fwd init:)
			(river2 setCycle: Fwd init:)
			(smoke1 setCycle: Fwd)
			(smoke2 setCycle: Fwd)
		)
		(poly1 points: @local0 size: 8)
		(poly2 points: @local16 size: 20)
		(poly3 points: @local56 size: 9)
		(poly4 points: @local74 size: 4)
		(self addObstacle: poly2 poly3 poly4)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			((& (gEgo onControl: 0) $0004)
				(HandsOff)
				(self setScript: drownHim)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(self setScript: enterInn)
			)
			((and (& (gEgo onControl: 0) $0040) (IsFlag 80))
				(HandsOff)
				(self setScript: enterKitchen)
			)
			((& (gEgo onControl: 0) $0010)
				(HandsOff)
				(self setScript: walkUp)
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

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (!= newRoomNumber 6)
			(gGlobalSound fade:)
		)
		(if (== newRoomNumber 85)
			(gGlobalSound2 fade:)
		)
	)
)

(instance fromKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SDoor z: 1000)
				(gEgo setMotion: MoveTo 104 124 self)
			)
			(1
				(gGlobalSound3 number: 124 loop: 1 vol: 100 play:)
				(SDoor cel: 3 z: 0 setCycle: Beg self)
			)
			(2
				(gEgo illegalBits: $8000)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkDown of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl: 1) $0400)
				(gEgo view: 4)
			)
			((& (gEgo onControl: 1) $0080)
				(gEgo view: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 89 113 self)
				(global322 view: 140 loop: 2 cel: 0 cycleSpeed: 3 setCycle: End)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkUp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0400)
			(gEgo view: 4 offset: 2)
			((gEgo head:) view: 4)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 111 47 self)
			)
			(1
				(HandsOn)
				((ScriptID 202 2) register: 1) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			(2
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance enterInn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 245 148 self)
			)
			(1
				(Say 75 27 0) ; "I'll wait for you out here. I don't like that place."
				(proc0_7 gEgo FDoor 5)
				(gGlobalSound3 number: 122 loop: 1 vol: 80 play:)
				(FDoor setCycle: End self)
			)
			(2
				(gEgo illegalBits: 0 setMotion: MoveTo 245 139 self)
			)
			(3
				(FDoor setCycle: Beg self)
			)
			(4
				(gGlobalSound3 number: 124 loop: 1 vol: 80 play:)
				(gEgo illegalBits: $8000)
				(gCurRoom newRoom: 85)
			)
		)
	)
)

(instance enterKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 112 124 self)
			)
			(1
				(proc0_7 gEgo SDoor 5)
				(= cycles 4)
			)
			(2
				(cond
					(register
						(PrintDC 27 1) ; "The key won't fit this lock."
						(HandsOn)
						(self register: 0)
						(client setScript: 0)
					)
					((not (IsFlag 80))
						(PrintDC 27 2) ; "The door is locked."
						(HandsOn)
						(client setScript: 0)
					)
					(else
						(proc0_7 gEgo SDoor 5)
						(gGlobalSound3 number: 123 loop: 1 play:)
						(SDoor setCycle: End self)
					)
				)
			)
			(3
				(SDoor dispose:)
				(gEgo illegalBits: 0 setMotion: MoveTo 139 124 self)
			)
			(4
				(gEgo illegalBits: $8000)
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance searchHay of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (> state 8) (< state 11) (gModelessDialog))
			(if (proc0_15 ((= temp0 (Event new:)) type:) 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 52 131 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo view: 293 normal: 0 loop: 0 setCycle: End self)
			)
			(2
				(gEgo loop: 1 cycleSpeed: 4 setCycle: Fwd)
				(= cycles 20)
			)
			(3
				(gEgo loop: 0 cel: 3 setCycle: Beg self)
			)
			(4
				(if
					(and
						(or
							(== ((gInventory at: 16) owner:) 12) ; Stick
							(== ((gInventory at: 8) owner:) 12) ; Shoe
							(== ((gInventory at: 19) owner:) 12) ; Leg_of_Lamb
						)
						(== ((gInventory at: 3) owner:) 27) ; Golden_Needle
					)
					(gGlobalSound3 number: 40 loop: -1 play:)
					(PrintDC 27 3 #at 20 20 #width 270 #dispose) ; "Graham watches with surprise as a contingent of ants marches into the haystack and begins to swarm through it."
					(gEgo
						normal: 1
						view: 2
						loop: 7
						cel: 3
						cycleSpeed: 0
						setCycle: Walk
					)
					((gEgo head:) show:)
					(gEgo setPri: 10)
					(ants1 cycleSpeed: 3 setCycle: End init:)
					(= seconds 8)
				else
					(PrintDC 27 4) ; "Carefully, Graham searches through the haystack but doesn't see anything of importance."
					(HandsOn)
					(gEgo
						normal: 1
						view: 2
						loop: 7
						cel: 3
						cycleSpeed: 0
						setCycle: Walk
					)
					((gEgo head:) show:)
					(client setScript: 0)
				)
			)
			(5
				(ants1 loop: 6 setCycle: Fwd)
				(ants2 cycleSpeed: 3 setCycle: End self init:)
			)
			(6
				(cls)
				(ants2 loop: 8 setCycle: Fwd)
				(= seconds 7)
			)
			(7
				(global322 setPri: 10)
				(cloud init: setCycle: End self)
			)
			(8
				(cloud hide:)
				(kingAnt init:)
				(blink init: setScript: (moveScript new:))
				(wArm init:)
				(eArm init:)
				(wAnt init: setScript: (moveScript new:))
				(eAnt init: setScript: (moveScript new:))
				(signCel
					view: 325
					loop: 3
					cel: 7
					posn: 50 52
					setPri: 14
					init:
					setCycle: Fwd
				)
				(pin init:)
				(= cycles 5)
			)
			(9
				(PrintDC 27 5 #at 105 10 #dispose) ; "I'm glad to see there was a way that we could be of help to you. Look here...we found a golden needle in the haystack. I'd like to present it to you. Perhaps you can find a use for it."
				(= seconds 17)
			)
			(10
				(pin dispose:)
				(signCel setCycle: 0)
				(cls)
				(Say 160 27 6 67 100 100 25 6) ; "Why, thank you, King Antony. I'm honored."
				(signCel setCycle: Fwd)
				(wArm setScript: (moveScript new:))
				(eArm setScript: (moveScript new:))
				(PrintDC 27 7 #at 100 20 #dispose) ; "Good luck in your travels, King Graham. And be careful."
				(= seconds 6)
			)
			(11
				(cloud show: setCycle: Beg self)
				(gGlobalSound3 fade:)
				(kingAnt dispose:)
				(signCel dispose:)
				(wAnt dispose:)
				(eAnt dispose:)
				(wArm dispose:)
				(eArm dispose:)
				(blink dispose:)
				(signCel hide:)
				(cls)
			)
			(12
				(ants2 loop: 7 cel: (- (NumCels ants2) 1) setCycle: Beg self)
			)
			(13
				(ants2 dispose:)
				(ants1 loop: 5 cel: (- (NumCels ants1) 1) setCycle: Beg self)
			)
			(14
				(cls)
				(ants1 dispose:)
				(gEgo setPri: -1 get: 3) ; Golden_Needle
				(SetScore 2)
				(HandsOn)
				(gEgo
					normal: 1
					view: 2
					loop: 7
					cel: 3
					cycleSpeed: 0
					setCycle: Walk
				)
				((gEgo head:) show:)
				(signCel view: 292 loop: 9 cel: 0 posn: 160 100 setPri: 15)
				(client setScript: 0)
			)
		)
	)
)

(instance drownHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 75 27 8 67 20 20 25 3) ; "No, don't...!"
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 71
					cel: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gGlobalSound3 number: 68 loop: 1 play:)
				(gEgo
					setLoop: 2
					posn: (- (gEgo x:) 8) (+ (gEgo y:) 10)
					setCycle: Fwd
					setStep: 3 1
					setMotion: MoveTo -15 185 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(cls)
				(= global330 {This ain't no swimmin' hole, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= cycles 10)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 3 10))
			)
		)
	)
)

(instance outDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 9
					illegalBits: 0
					posn: 245 138
					setMotion: MoveTo 245 140
				)
				(FDoor cycleSpeed: 2 setCycle: End self)
			)
			(1
				(gGlobalSound3 number: 122 vol: 80 loop: 1 play:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
			)
			(2
				(FDoor setCycle: Beg self)
				(gEgo setPri: -1 illegalBits: $8000)
			)
			(3
				(gGlobalSound3 number: 124 vol: 80 loop: 1 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance path27 of RFeature
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
					(PrintDC 27 9) ; "Narrowing to the west, the dirt road widens as it heads eastward."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance river1 of Prop
	(properties
		y 188
		x 233
		view 471
		priority 5
		signal 16400
		cycleSpeed 5
	)
)

(instance river2 of Prop
	(properties
		y 188
		x 74
		view 471
		loop 1
		priority 5
		signal 16400
		cycleSpeed 5
	)
)

(instance river of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 27 10) ; "The brisk river rushes swiftly by the quaint country inn."
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath (gEgo x:) 189)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hayStack of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 27 11) ; "A large haystack dominates the area in front of the barn."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: searchHay)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance barn of RFeature
	(properties
		nsTop 31
		nsBottom 119
		nsRight 81
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
					(PrintDC 27 12) ; "An old, uninteresting barn is located behind the country inn."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 27 13) ; "Graham can see an unbreakable padlock on the barn door."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance house of RFeature
	(properties
		nsTop 11
		nsLeft 129
		nsBottom 136
		nsRight 311
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
					(PrintDC 27 14) ; "Just off a rutted dirt road, a country inn overlooks the picturesque rushing river."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance FDoor of Prop
	(properties
		y 143
		x 253
		view 292
		signal 16385
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
					(PrintDC 27 15) ; "Weary travelers can enter through the inn's front door."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: enterInn)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance SDoor of Prop
	(properties
		y 127
		x 124
		view 292
		loop 1
		signal 16385
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
					(PrintDC 27 16) ; "This is a side entrance of the country inn."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: enterKitchen)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(1 ; Key
							(HandsOff)
							(enterKitchen register: 1)
							(gCurRoom setScript: enterKitchen)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance FakeDoor of RFeature
	(properties
		nsTop 83
		nsLeft 117
		nsBottom 126
		nsRight 142
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
					(PrintDC 27 16) ; "This is a side entrance of the country inn."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (IsFlag 80))
						(PrintDC 27 2) ; "The door is locked."
					else
						(gCurRoom setScript: enterKitchen)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance signPost of RFeature
	(properties
		nsTop 107
		nsLeft 163
		nsBottom 122
		nsRight 192
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
					(localproc_1)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		y 3
		x 187
		view 292
		loop 3
		cycleSpeed 3
	)
)

(instance smoke2 of Prop
	(properties
		y 7
		x 294
		view 292
		loop 4
		cycleSpeed 3
	)
)

(instance signCel of Prop
	(properties
		y 100
		x 160
		view 292
		loop 9
		priority 15
		signal 16
	)
)

(instance ants1 of Prop
	(properties
		y 132
		x 29
		view 292
		loop 5
		priority 9
		signal 16
	)
)

(instance ants2 of Prop
	(properties
		y 135
		x 30
		view 292
		loop 7
		priority 9
		signal 16
	)
)

(instance kingAnt of Prop
	(properties
		y 80
		x 51
		view 325
		priority 13
		signal 17
	)
)

(instance blink of Prop
	(properties
		y 43
		x 49
		view 325
		loop 4
		priority 14
		signal 16
	)
)

(instance wArm of Prop
	(properties
		y 69
		x 31
		view 325
		loop 5
		cel 6
		priority 14
		signal 16
	)
)

(instance eArm of Prop
	(properties
		y 74
		x 76
		view 325
		loop 6
		cel 6
		priority 14
		signal 16
	)
)

(instance pin of Prop
	(properties
		y 55
		x 53
		view 325
		cel 1
		priority 14
		signal 16
	)
)

(instance cloud of Prop
	(properties
		y 52
		x 51
		view 214
		priority 12
		signal 16
	)
)

(instance wAnt of Prop
	(properties
		y 24
		x 31
		view 325
		loop 1
		cel 4
		priority 14
		signal 16400
	)
)

(instance eAnt of Prop
	(properties
		y 26
		x 64
		view 325
		loop 2
		cel 4
		priority 14
		signal 16400
	)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
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

