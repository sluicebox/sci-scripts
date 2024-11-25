;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	[local0 48] = [261 117 262 0 282 0 281 123 269 127 272 130 282 129 281 137 253 143 284 144 295 149 295 154 283 156 278 165 210 170 142 170 117 162 111 166 99 164 104 151 119 144 218 141 243 132 244 120]
	[local48 18] = [50 153 78 161 89 159 98 150 116 144 116 138 61 138 0 145 0 155]
	[local66 16] = [259 0 258 115 216 112 208 106 192 106 166 115 165 104 250 27]
	[local82 16] = [253 0 156 107 139 112 112 121 55 129 60 120 0 118 0 0]
	[local98 16] = [285 0 284 121 301 124 304 175 104 172 80 189 319 189 319 0]
	[local114 16] = [178 131 214 131 209 126 215 113 209 109 187 108 183 111 182 125]
	[local130 8] = [97 134 133 134 133 126 97 126]
	[local138 8] = [0 183 0 189 30 189 29 185]
	[local146 18] = [0 174 30 181 62 183 76 176 98 175 97 172 92 167 32 163 0 163]
	local164
	local165
	local166
	local167
	local168
	local169
	local170
)

(instance rm001 of Rm
	(properties
		picture 1
		south 2
		west 8
	)

	(method (init &tmp temp0 temp1 temp2)
		(super init:)
		(NormalEgo)
		(= global103 0)
		(HandsOn)
		(gGame setSpeed: 2)
		(ClearFlag 23 34)
		(= global320 107)
		(= global321 94)
		(self setRegions: 202) ; owl
		(= global325 {"Come ON, Graham! There's nothing here. Let's go!"})
		(if (not (gEgo has: 28)) ; Wand
			(gEgo get: 28) ; Wand
		)
		(gGlobalSound loop: -1 number: 24 play:)
		(if (and (== gPrevRoomNum 109) (not (GameIsRestarting))) ; intro10
			(= temp0 160)
			(= temp1 108)
		else
			(switch gPrevRoomNum
				(south
					(= temp0 60)
					(= temp1 187)
				)
				(east
					(= temp0 74)
					(= temp1 159)
				)
				(west
					(= temp1 (gEgo y:))
					(= temp0 0)
					(if (< temp1 168)
						(HandsOff)
						(self setScript: enterFromTree)
					else
						(gEgo
							setMotion: MoveTo (+ (gEgo x:) 3) (gEgo y:)
						)
					)
				)
				(76
					(= temp0 169)
					(= temp1 98)
				)
				(else
					(= temp0 140)
					(= temp1 136)
				)
			)
		)
		(proc0_24 128 27 9 0 2)
		(gEgo
			view:
				(if
					(or
						(== gPrevRoomNum south)
						(and (== gPrevRoomNum west) (> (gEgo y:) 149))
					)
					0
				else
					2
				)
			offset: 2
			posn: temp0 temp1
			setStep: 2 1
			setLoop: -1
			illegalBits: $c000
			init:
		)
		(door
			setPri: 1
			cel:
				(if (== gPrevRoomNum 76)
					(- (NumCels door) 1)
				else
					0
				)
			init:
		)
		(rail1 init: stopUpd:)
		(rail2 init: stopUpd:)
		(self setFeatures: windows ornament well pond bridge smallDoor house)
		(if (== gPrevRoomNum 76)
			(HandsOff)
			(self setScript: leaveCrispins)
		)
		(if (and (== gPrevRoomNum 109) (not (GameIsRestarting))) ; intro10
			(HandsOff)
			(self setScript: introRoomScript)
		)
		(poly1 points: @local0 size: 24)
		(poly2 points: @local48 size: 9)
		(poly3 points: @local66 size: 8)
		(poly4 points: @local82 size: 8)
		(poly5 points: @local98 size: 8)
		(poly6 points: @local114 size: 8)
		(poly7 points: @local130 size: 4)
		(poly8 points: @local138 size: 4)
		(poly9 points: @local146 size: 9)
		(self
			addObstacle: poly1 poly2 poly3 poly4 poly5 poly6 poly7 poly8 poly9
		)
		(if (== global81 3)
			(water setCycle: Fwd init:)
			(rippling setCycle: Fwd init:)
			(rippling2 setCycle: Fwd init:)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((& (gEgo onControl: 1) $0008)
				(gEgo view: 27)
			)
			((== (gEgo view:) 27)
				(gEgo view: 2)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			(
				(and
					(not (gCurRoom script:))
					(or
						(and
							(or
								(< (= temp1 (gEgo heading:)) 90)
								(> temp1 270)
							)
							(& (gEgo onControl: 1) $0010)
						)
						(and
							(& (gEgo onControl: 1) $0002)
							(> temp1 89)
							(< temp1 271)
						)
					)
				)
				(gCurRoom setScript: changeSize)
			)
			(
				(or
					(& (gEgo onControl: 1) $0080)
					(& (gEgo onControl: 1) $0100)
					(& (gEgo onControl: 1) $0040)
				)
				(HandsOff)
				(self setScript: falling)
			)
			((gEgo inRect: 80 135 108 141)
				(gEgo setPri: 9)
			)
			((and (& (gEgo onControl: 1) $0008) (< (gEgo x:) 99))
				(gEgo setPri: 9)
			)
			(
				(and
					(& (gEgo onControl: 1) $0008)
					(> (gEgo x:) 99)
					(< (gEgo x:) 150)
				)
				(gEgo setPri: 12)
			)
			((== (gEgo view:) 0)
				(gEgo setPri: 14)
			)
			((and (& (gEgo onControl: 1) $0008) (> (gEgo x:) 149))
				(gEgo setPri: -1)
			)
			((& (gEgo onControl: 1) $0001)
				(gEgo setPri: -1)
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
		(gEgo illegalBits: $8000)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance enterFromTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 47 143 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance introRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 1) (+ (gEgo y:) 1)
				)
				(= cycles 15)
			)
			(1
				(gEgo setLoop: -1 setMotion: MoveTo 140 136 self)
			)
			(2
				(Say 75 1 0 67 10 10 25 8) ; "I suggest we visit the town first. How about it, Your Majesty?"
				(RedrawCast)
				(Say 160 1 1 67 90 90 25 10) ; "Please don't call me Your Majesty, Cedric. It's much too formal. I'd like it if you'd just call me Graham."
				(RedrawCast)
				(Say 75 1 2 67 10 10 25 12) ; "I'd be delighted to...Graham. Anyway...what was I talking about...Oh, yes! The town! You might be able to find some supplies there. It's just over a little hill to the south; not too far."
				(RedrawCast)
				(Say 160 1 3 67 90 90 25 6) ; "Well then, let's get going, Cedric."
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leaveCrispins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 160 109 self)
			)
			(1
				(gGlobalSound3 number: 123 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance changeSize of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local169 (gEgo view:))
				(= temp0 (gEgo mover:))
				(= local170 (gEgo cycleSpeed:))
				(if (== local169 2)
					(gEgo setPri: 1 illegalBits: 0)
				)
				(if (IsObject temp0)
					(= local167 (temp0 x:))
					(= local168 (temp0 y:))
				)
				(HandsOff)
				(rail1 setPri: 1)
				(if (== local169 2)
					(gEgo
						signal: (| (gEgo signal:) $4810)
						setMotion: PolyPath 95 181 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 9
					normal: 0
					cycleSpeed: (gEgo moveSpeed:)
					setPri: -1
					setLoop: (if (== local169 2) 0 else 1)
					setStep: 4 3
					illegalBits: 0
					cel: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
				(if (== local169 2)
					(gEgo setMotion: MoveTo 63 186)
				else
					(gEgo setMotion: MoveTo 92 174)
				)
			)
			(2
				(if (== local169 0)
					((gEgo head:) show:)
					(gEgo
						view: 2
						setLoop: -1
						setCycle: Walk
						setPri: 1
						cycleSpeed: local170
						setMotion: PolyPath 100 170 self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					view: (if (== local169 0) 2 else 0)
					cycleSpeed: local170
					cel: 0
					normal: 1
					setCycle: Walk
					setLoop: -1
					setPri: 12
					illegalBits: $c000
					offset: 3
					signal: (& (gEgo signal:) $f7ff)
				)
				((gEgo head:) show:)
				(if (== local169 0)
					(gEgo loop: 7 cel: 3 setStep: 2 1)
				else
					(gEgo loop: 7 cel: 2 setStep: 3 2)
				)
				(if local164
					(gEgo setMotion: PolyPath local165 local166 local164)
				else
					(if
						(and
							(== (global70 cursor:) 6)
							(not (& (OnControl CONTROL global323 global324) $0002))
							(not (& (OnControl CONTROL global323 global324) $0010))
							(not (& (OnControl CONTROL global323 global324) $0020))
							(not (& (OnControl CONTROL global323 global324) $0800))
						)
						(gEgo setMotion: PolyPath global323 global324)
					)
					(HandsOn)
				)
				(rail1 setPri: 10)
				(client setScript: 0)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 90
					ignoreControl: -32768
					cel: 0
					setCycle: End self
					setMotion: JumpTo 196 133 self
				)
			)
			(1)
			(2
				(gEgo
					normal: 1
					view: 2
					setCycle: Walk
					observeControl: -32768
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local165 160)
				(= local166 109)
				(= local164 self)
				(gEgo setMotion: PolyPath 160 109 self)
			)
			(1
				(= local165 0)
				(= local166 0)
				(= local164 0)
				(gGlobalSound3 number: 122 loop: 1 play:)
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 169 98 self)
			)
			(3
				(SetFlag 38)
				(gCurRoom newRoom: 76)
			)
		)
	)
)

(instance lookWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local165 253)
				(= local166 118)
				(= local164 self)
				(gEgo setMotion: PolyPath 253 118 self)
			)
			(1
				(= local165 0)
				(= local166 0)
				(= local164 0)
				(gEgo loop: 7 cel: 3)
				(= cycles 2)
			)
			(2
				(PrintDC 1 4 #at 10 10) ; "Graham gazes down into Crispin's well, but sees nothing of interest."
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local165 188)
				(= local166 147)
				(= local164 self)
				(gEgo setMotion: PolyPath 188 147 self)
			)
			(1
				(= local165 0)
				(= local166 0)
				(= local164 0)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 45
					loop: 2
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
				(PrintDC 1 5) ; "The cool pond water quenches Graham's thirst."
				(gEgo normal: 1 view: 2 setCycle: Walk cycleSpeed: 0)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance rail1 of Prop
	(properties
		y 156
		x 94
		view 770
		loop 4
		priority 10
		signal 16400
	)
)

(instance rail2 of Prop
	(properties
		y 161
		x 123
		view 770
		loop 4
		cel 1
		priority 12
		signal 16400
	)
)

(instance door of Prop
	(properties
		y 96
		x 170
		view 770
		loop 5
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 1 6) ; "The hand-hewn, wooden door is recessed within a small porch."
					(event claimed: 1)
				)
				(3 ; Do
					(if (IsFlag 38)
						(PrintDC 1 7) ; "The door to Crispin's house is now locked."
					else
						(HandsOff)
						(gEgo setScript: openDoor)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance windows of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 1 8) ; "Thick-paned windows adorn the small house. It is difficult to see through them."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance house of RFeature
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
					(PrintDC 1 9) ; "Nestled among the trees of the forest sits the wizard Crispin's worn, but cozy, cottage."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance well of RFeature
	(properties
		nsTop 89
		nsLeft 246
		nsBottom 109
		nsRight 264
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
					(PrintDC 1 10) ; "A small well is located near the cottage."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gEgo setScript: lookWell)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance ornament of RFeature
	(properties
		nsTop 95
		nsLeft 105
		nsBottom 128
		nsRight 125
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
					(PrintDC 1 11) ; "An unusual ornament decorates Crispin's front yard. Crispin being a wizard, it must have some magical significance which Graham could never understand."
					(event claimed: 1)
				)
				(3 ; Do
					(Say 75 1 12) ; "That's Crispin's Universe Interpreter. Be careful! You might accidentally realign the stars!"
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
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 1 13) ; "A tiny pond adds charm to Crispin's forested home."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gEgo setScript: getDrink)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance smallDoor of RFeature
	(properties
		nsTop 111
		nsLeft 186
		nsBottom 129
		nsRight 209
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
					(PrintDC 1 14) ; "A small cellar door is located under the house."
					(event claimed: 1)
				)
				(3 ; Do
					(Say 75 1 15) ; "Oh, don't bother with the cellar door; there's nothing there. Besides, it's locked."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bridge of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $1000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 1 16) ; "A small stone bridge crosses the pond below Crispin's house."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance water of Prop
	(properties
		y 154
		x 256
		view 770
		priority 1
		signal 16
		cycleSpeed 4
	)
)

(instance rippling of Prop
	(properties
		y 168
		x 158
		view 770
		loop 1
		priority 1
		signal 16400
		cycleSpeed 9
	)
)

(instance rippling2 of Prop
	(properties
		y 154
		x 79
		view 770
		loop 2
		priority 1
		signal 16400
		cycleSpeed 2
	)
)

(instance poly1 of Polygon
	(properties)
)

(instance poly2 of Polygon
	(properties)
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

(instance poly6 of Polygon
	(properties)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly9 of Polygon
	(properties
		type PBarredAccess
	)
)

