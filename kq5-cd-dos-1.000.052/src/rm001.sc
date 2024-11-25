;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use CodeCue)
(use Door)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	[local0 18] = [0 155 0 145 61 138 116 138 116 144 98 150 89 159 78 161 50 153]
	[local18 16] = [259 0 258 115 216 112 208 106 192 106 166 115 165 104 250 27]
	[local34 16] = [253 0 156 107 139 112 112 121 55 129 60 120 0 118 0 0]
	[local50 18] = [319 0 319 189 80 189 104 172 304 175 310 140 305 122 284 121 285 0]
	[local68 16] = [182 125 183 111 187 108 209 109 215 113 209 126 214 131 178 131]
	[local84 8] = [97 126 133 126 133 134 97 134]
	[local92 8] = [29 185 30 189 0 189 0 183]
	[local100 18] = [0 163 32 163 92 167 97 172 98 175 76 176 62 183 30 181 0 174]
	[local118 10] = [301 128 303 141 286 138 283 125 292 127]
	[local128 8] = [174 148 173 156 155 158 156 148]
	[local136 12] = [152 145 144 158 131 164 101 164 106 151 138 140]
	[local148 8] = [261 0 282 0 281 123 262 118]
	local156
	local157
	local158
	local159
	local160
	local161
	local162
	local163
	[local164 9] = [1000 93 46 4 11 24 19 23 30]
	[local173 10] = [1 9106 0 7040 1 9107 0 7041 0 0]
	[local183 9] = [1003 140 100 4 11 25 23 31 31]
)

(instance rm001 of KQ5Room
	(properties
		picture 1
		south 2
		west 8
	)

	(method (init &tmp temp0 temp1 temp2)
		(super init:)
		(= local163
			(if
				(or
					(== gPrevRoomNum 109)
					(== gPrevRoomNum 659) ; cdIntro10
					(== gPrevRoomNum 611) ; introSlide_2
					(== gPrevRoomNum 700)
				)
				(not (GameIsRestarting))
			)
		)
		(NormalEgo)
		(gEgo cycleSpeed: (gEgo moveSpeed:))
		(= global103 0)
		(HandsOn)
		(ClearFlag 22 33)
		(= global320 107)
		(= global321 94)
		(self setRegions: 202) ; owl
		(= global325 3020)
		(if (not (gEgo has: 28)) ; Wand
			(gEgo get: 28) ; Wand
		)
		(gGlobalSound loop: -1 number: 24 play:)
		(if local163
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
		(LoadMany rsVIEW 27 9 0 2)
		(gEgo
			view: (if (== gPrevRoomNum south) 0 else 2)
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
			stopUpd:
		)
		(rail1 init: stopUpd:)
		(rail2 init: stopUpd:)
		(self setFeatures: theWindows ornament well pond bridge smallDoor house)
		(if (== gPrevRoomNum 76)
			(HandsOff)
			(self setScript: leaveCrispins)
		)
		(if local163
			(HandsOff)
			(self setScript: introRoomScript)
		)
		(poly2 points: @local0 size: 9)
		(poly3 points: @local18 size: 8)
		(poly4 points: @local34 size: 8)
		(poly5 points: @local50 size: 9)
		(poly6 points: @local68 size: 8)
		(poly7 points: @local84 size: 4)
		(poly8 points: @local92 size: 4)
		(poly9 points: @local100 size: 9)
		(poly11 points: @local118 size: 5)
		(poly12 points: @local128 size: 4)
		(poly13 points: @local136 size: 6)
		(poly14 points: @local148 size: 4)
		(self
			addObstacle:
				poly2
				poly3
				poly4
				poly5
				poly6
				poly7
				poly8
				poly9
				poly11
				poly12
				poly13
				poly14
		)
		(if (== (gGame detailLevel:) 3)
			(water setCycle: Fwd init:)
			(rippling setCycle: Fwd init:)
			(rippling2 setCycle: Fwd init:)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(cond
			((& (= temp2 (gEgo onControl: 1)) $0008)
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
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
			)
			((or (& temp2 $0010) (& temp2 $0002))
				(gCurRoom setScript: changeSize)
			)
			((& temp2 $01c0)
				(HandsOff)
				(self setScript: falling)
			)
			((gEgo inRect: 80 135 108 141)
				(gEgo setPri: 9)
			)
			((and (& temp2 $0008) (< (gEgo x:) 99))
				(gEgo setPri: 9)
			)
			((and (& temp2 $0008) (< 99 (gEgo x:) 150))
				(gEgo setPri: 12)
			)
			((== (gEgo view:) 0)
				(gEgo setPri: 14)
			)
			((and (& temp2 $0008) (> (gEgo x:) 149))
				(gEgo setPri: -1)
			)
			((& temp2 $0001)
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

(instance leaveCrispins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 160 109 self)
			)
			(1
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
				(= local161 (gEgo view:))
				(= temp0 (gEgo mover:))
				(= local162 (gEgo cycleSpeed:))
				(if (== local161 2)
					(gEgo setPri: 1 illegalBits: 0)
				)
				(if (IsObject temp0)
					(= local159 (temp0 x:))
					(= local160 (temp0 y:))
				)
				(HandsOff)
				(rail1 setPri: 1)
				(if (== local161 2)
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
					setLoop: (if (== local161 2) 0 else 1)
					setStep: 4 3
					illegalBits: 0
					cel: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
				(if (== local161 2)
					(gEgo setMotion: MoveTo 63 186)
				else
					(gEgo setMotion: MoveTo 92 174)
				)
			)
			(2
				(if (== local161 0)
					(gEgo
						view: 2
						setLoop: -1
						setCycle: KQ5SyncWalk
						setPri: 1
						cycleSpeed: local162
						setMotion: PolyPath 100 170 self
					)
					((gEgo head:) show:)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo
					view: (if (== local161 0) 2 else 0)
					cycleSpeed: local162
					cel: 0
					normal: 1
					setCycle: KQ5SyncWalk
					setLoop: -1
					setPri: 12
					illegalBits: $c000
					signal: (& (gEgo signal:) $f7ff)
				)
				((gEgo head:) show:)
				(if (== local161 0)
					(gEgo loop: 7 cel: 3 setStep: 2 1)
				else
					(gEgo loop: 7 cel: 2 setStep: 3 2)
				)
				(if local156
					(gEgo setMotion: PolyPath local157 local158 local156)
				else
					(if
						(and
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
					setCycle: KQ5SyncWalk
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
				(= local157 160)
				(= local158 109)
				(= local156 self)
				(gEgo illegalBits: 0 setMotion: PolyPath 160 109 self)
			)
			(1
				(= local157 0)
				(= local158 0)
				(= local156 0)
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 169 98 self)
			)
			(3
				(SetFlag 37)
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
				(= local157 253)
				(= local158 118)
				(= local156 self)
				(gEgo setMotion: PolyPath 253 118 self)
			)
			(1
				(= local157 0)
				(= local158 0)
				(= local156 0)
				(gEgo loop: 7 cel: 3)
				(= cycles 2)
			)
			(2
				(Say 162)
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
				(= local157 188)
				(= local158 147)
				(= local156 self)
				(gEgo setMotion: PolyPath 188 147 self)
			)
			(1
				(= local157 0)
				(= local158 0)
				(= local156 0)
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
				(Say 9070)
				(gEgo normal: 1 view: 2 setCycle: KQ5SyncWalk cycleSpeed: 0)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance rail1 of Prop
	(properties
		x 94
		y 156
		view 770
		loop 4
		priority 10
		signal 16400
	)
)

(instance rail2 of Prop
	(properties
		x 123
		y 161
		view 770
		loop 4
		cel 1
		priority 12
		signal 16400
	)
)

(instance door of Door
	(properties
		x 170
		y 96
		view 770
		loop 5
	)

	(method (handleEvent event &tmp temp0)
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
					(Say 163)
					(event claimed: 1)
				)
				(3 ; Do
					(if (IsFlag 37)
						(Say 171)
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

(instance theWindows of RFeature
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
					(Say 164)
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
					(Say 165)
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
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 166)
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
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 167)
					(event claimed: 1)
				)
				(3 ; Do
					(proc762_1 @local164 3021)
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
					(Say 168)
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
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 169)
					(event claimed: 1)
				)
				(3 ; Do
					(proc762_1 @local164 3022)
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
					(Say 170)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance water of Prop
	(properties
		x 256
		y 154
		view 770
		priority 1
		signal 16
		cycleSpeed 4
	)
)

(instance rippling of Prop
	(properties
		x 158
		y 168
		view 770
		loop 1
		priority 1
		signal 16400
		cycleSpeed 9
	)
)

(instance rippling2 of Prop
	(properties
		x 79
		y 154
		view 770
		loop 2
		priority 1
		signal 16400
		cycleSpeed 2
	)
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

(instance poly11 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly12 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly13 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly14 of Polygon
	(properties
		type PBarredAccess
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
				(gEgo
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: -1
					setMotion: MoveTo 140 136 self
				)
			)
			(2
				(proc762_0 @local183 @local164 @local173 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

