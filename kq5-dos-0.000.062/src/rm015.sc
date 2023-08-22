;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	local0
	[local1 4] = [15 16 210 211]
	local5
	local6
	[local7 7] = [2 0 3 1 2 0 0]
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 8] = [208 208 220 207 109 117 148 143]
	[local29 8] = [172 130 174 100 178 120 154 107]
	[local37 10] = [212 166 187 168 187 172 215 172 235 166]
	[local47 8] = [122 154 144 160 180 155 172 152]
	[local55 8] = [168 142 202 142 201 148 173 148]
	[local63 8] = [185 154 292 150 304 158 183 158]
	[local71 10] = [222 156 165 154 160 145 279 145 279 148]
	[local81 8] = [182 163 226 164 217 169 179 169]
	[local89 8] = [140 137 193 137 188 141 134 141]
	[local97 8] = [226 132 279 139 244 142 203 138]
	[local105 16] = [161 157 162 166 148 174 106 175 75 169 43 163 50 159 80 152]
	[local121 10] = [65 171 74 175 74 178 55 179 49 176]
	[local131 10] = [65 143 86 139 122 143 118 147 96 151]
	[local141 10] = [162 139 198 135 233 140 232 150 162 150]
	[local151 12] = [111 122 137 122 166 124 162 128 132 131 111 131]
	[local163 8] = [174 131 200 129 181 124 165 127]
	[local171 8] = [185 117 200 122 215 120 199 116]
	[local179 10] = [119 119 167 119 137 114 85 112 76 118]
	[local189 8] = [1 1 2 1 2 2 1 2]
	[local197 10] = [26 126 85 144 106 159 69 162 2 143]
	local207
	local208
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

(procedure (localproc_1 &tmp temp0 temp1)
	(gEgo setMotion: 0 setCycle: 0 cel: (gEgo loop:) loop: 7)
	((gEgo head:)
		x: (gEgo x:)
		y: (gEgo y:)
		z: (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
	)
	(RedrawCast)
	(= local18 0)
	(if
		(or
			(localproc_2 4 3)
			(localproc_2 3 7)
			(localproc_2 6 6)
			(localproc_2 9 4)
		)
		(gGlobalSound3 number: 6 loop: -1 vol: 127 play:)
		(gGlobalSound2 stop:)
		(gGlobalSound stop:)
		(= local20 1)
	else
		(= local20 0)
		(gGlobalSound3 stop:)
		(gGlobalSound number: 2 loop: -1 vol: 127 play:)
		(gGlobalSound2 number: 3 loop: -1 vol: 127 play:)
	)
	(cond
		((and (not global314) (> global315 3))
			(gCurRoom newRoom: 211)
		)
		((not global314)
			(gCurRoom newRoom: 14)
		)
		((== global315 1)
			(= global322 (++ local17))
			(gCurRoom newRoom: (if (== global314 7) 213 else 212))
		)
		((localproc_2 10 7)
			(= global322 (++ local17))
			(gCurRoom newRoom: 216)
		)
		(else
			(= temp0 [local1 (= temp1 (mod (+ global314 global315) 4))])
			(++ local17)
			(gCurRoom drawPic: temp0)
			(oasis
				loop:
					(switch temp0
						(15 0)
						(16 1)
						(210 2)
						(else 3)
					)
				cel: local20
				setPri:
					(if local20
						(switch temp0
							(15 12)
							(16 11)
							(210 12)
							(else 11)
						)
					else
						-1
					)
				x: [local21 (+ (* temp1 2) local20)]
				y: [local29 (+ (* temp1 2) local20)]
			)
			(dummy
				x:
					(switch temp0
						(15 178)
						(16 222)
						(210 210)
						(else 140)
					)
				y:
					(switch temp0
						(15 156)
						(16 155)
						(210 164)
						(else 137)
					)
			)
			(if (localproc_2 3 7)
				(rope init:)
			else
				(rope dispose:)
			)
			(if (localproc_2 6 4)
				(skeleton init:)
				(if (not local207)
					(gGlobalSound3 number: 64 loop: 1 vol: 127 play:)
					(++ local207)
				)
				(if (== ((gInventory at: 8) owner:) 15) ; Shoe
					(bootInSand init:)
				)
			else
				(skeleton dispose:)
				(bootInSand dispose:)
			)
			(switch local5
				(1
					(gEgo
						view: 0
						offset: 3
						setStep: 3 2
						setPri: 14
						y: 186
						looper: MyLooper
						posn: (gEgo x:) 186
					)
					(= local6 1)
				)
				(3
					(gEgo
						view: 2
						offset: 2
						setStep: 2 1
						setPri: 4
						x: (gEgo x:)
						y:
							(switch temp0
								(15 115)
								(16 77)
								(210 103)
								(else 94)
							)
					)
					(= local6 3)
				)
				(2
					(gEgo
						view: 0
						setStep: 3 2
						offset: 3
						setPri: 14
						looper: MyLooper
						posn: 5 170
					)
					(= local6 1)
				)
				(else
					(gEgo
						view: 0
						setStep: 3 2
						offset: 3
						setPri: 14
						looper: MyLooper
						posn: 315 170
					)
					(= local6 1)
				)
			)
			(if local20
				(if (== local6 1)
					(gEgo setPri: -1)
					(gCurRoom
						obstacles:
							(switch temp0
								(15 polyList15)
								(16 polyList16)
								(210 polyList210)
								(211 polyList211)
							)
					)
				)
				(if (== global81 3)
					(oasisWater
						loop:
							(switch temp0
								(15 0)
								(16 1)
								(211 2)
							)
						x:
							(switch temp0
								(15 213)
								(16 225)
								(211 129)
							)
						y:
							(switch temp0
								(15 165)
								(16 167)
								(211 154)
							)
						setCycle: Fwd
						init:
					)
				)
			else
				(oasisWater dispose:)
				(if (localproc_2 6 4)
					(gCurRoom obstacles: polyList1)
				else
					(gCurRoom obstacles: 0)
				)
			)
			(gEgo forceUpd:)
			((gEgo head:)
				x: (gEgo x:)
				y: (gEgo y:)
				z: (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
			)
			(= local5 0)
			(gEgo edgeHit: EDGE_NONE)
			(= local0 0)
		)
	)
)

(procedure (localproc_2 param1 param2)
	(if (and (== param1 global314) (== param2 global315))
		(return 1)
	else
		(return 0)
	)
)

(instance rm015 of Rm
	(properties
		picture 15
	)

	(method (init &tmp temp0)
		(self
			setFeatures: desert
			picture: [local1 (= temp0 (mod (+ global314 global315) 4))]
		)
		(super init:)
		(gGlobalSound number: 2 loop: -1 vol: 127 play:)
		(gGlobalSound2 number: 3 loop: -1 vol: 127 play:)
		(if (== gPrevRoomNum 14)
			(++ local17)
		)
		(= local20 0)
		(oasis
			loop:
				(switch (self picture:)
					(15 0)
					(16 1)
					(210 2)
					(else 3)
				)
			cel: local20
			setPri: (if local20 10 else -1)
			x: [local21 (+ (* temp0 2) local20)]
			y: [local29 (+ (* temp0 2) local20)]
			init:
		)
		(dummy
			x:
				(switch (self picture:)
					(15 178)
					(16 224)
					(210 210)
					(else 140)
				)
			y:
				(switch (self picture:)
					(15 153)
					(16 157)
					(210 164)
					(else 153)
				)
			init:
		)
		(switch gPrevRoomNum
			(212
				(= local17 global322)
				(= local6 3)
				(gEgo
					view: 2
					setPri: 4
					x: 160
					y:
						(switch (gCurRoom picture:)
							(15 115)
							(16 77)
							(210 103)
							(else 94)
						)
					offset: 2
					init:
				)
			)
			(213
				(= local17 global322)
				(= local6 3)
				(gEgo
					view: 2
					setPri: 4
					x: 160
					y:
						(switch (gCurRoom picture:)
							(15 115)
							(16 77)
							(210 103)
							(else 94)
						)
					offset: 2
					init:
				)
			)
			(216
				(= local17 global322)
				(gEgo y: 170 offset: 3 setPri: 14 init:)
				(= local6 1)
			)
			(else
				(= local17 global322)
				(gEgo y: 170 offset: 3 setPri: 14 init:)
				(= local6 1)
			)
		)
		(Load rsVIEW 2 26 28)
		(poly1 points: @local37 size: 5)
		(poly2 points: @local47 size: 4)
		(poly3 points: @local55 size: 4)
		(poly4 points: @local63 size: 4)
		(poly5 points: @local71 size: 5)
		(poly6 points: @local81 size: 4)
		(poly7 points: @local89 size: 4)
		(poly8 points: @local97 size: 4)
		(poly9 points: @local105 size: 8)
		(poly10 points: @local121 size: 5)
		(poly11 points: @local131 size: 5)
		(poly12 points: @local141 size: 5)
		(poly13 points: @local151 size: 6)
		(poly14 points: @local163 size: 4)
		(poly15 points: @local171 size: 4)
		(poly16 points: @local179 size: 5)
		(poly17 points: @local189 size: 4)
		(poly18 points: @local197 size: 5)
		(polyList15 add: poly1 poly2 poly3 poly4)
		(polyList16 add: poly5 poly6 poly7 poly8)
		(polyList210 add: poly9 poly10)
		(polyList211 add: poly11 poly12 poly13 poly14 poly15 poly16)
		(polyList0 add: poly17)
		(polyList1 add: poly18)
	)

	(method (doit)
		(if (and local20 (== (self curPic:) 211))
			(cond
				((gEgo inRect: 136 127 156 157 136)
					(if (!= (oasis priority:) 9)
						(oasis setPri: 9 forceUpd:)
					)
				)
				((!= (oasis priority:) 11)
					(oasis setPri: 11 forceUpd:)
				)
			)
		)
		(if (and local20 (== (self curPic:) 16) (== local6 1))
			(if (< (gEgo y:) 100)
				(gEgo setPri: 5)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			((and (& (gEgo onControl: 0) $0002) (== local6 1))
				(gCurRoom obstacles: polyList0)
				(= local6 2)
				(if (IsObject (gEgo mover:))
					(if global324
						(= local15 400)
						(= local14 global323)
					else
						(= local15
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local14 ((gEgo mover:) x:))
					)
				else
					(= local15 (gEgo y:))
					(= local14 (gEgo x:))
				)
				(if (== local15 (gEgo y:))
					(+= local15 5)
				)
				(gEgo y: (+ (gEgo y:) 7) looper: duneLooper setPri: 4)
				(if (not (& (OnControl CONTROL local14 local15) $0002))
					(gEgo setMotion: MoveTo local14 local15 local208)
				)
			)
			((and (== local6 2) (& (gEgo onControl: 0) $0004))
				(= local6 3)
				(if (IsObject (gEgo mover:))
					(if global324
						(= local15 global324)
						(= local14 global323)
					else
						(= local15
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local14 ((gEgo mover:) x:))
					)
				else
					(= local15 (gEgo y:))
					(= local14 (gEgo x:))
				)
				(if (== local15 (gEgo y:))
					(-= local15 5)
				)
				(gEgo
					view: 2
					offset: 2
					posn: (gEgo x:) (- (gEgo y:) 5)
				)
				(RedrawCast)
				(gEgo setStep: 2 1 looper: MyLooper setPri: 4)
				(if (not (& (OnControl CONTROL local14 local15) $0004))
					(gEgo setMotion: MoveTo local14 local15 local208)
				)
			)
			((and (& (gEgo onControl: 0) $0002) (== local6 2))
				(= local6 1)
				(if (IsObject (gEgo mover:))
					(if global324
						(= local15 global324)
						(= local14 global323)
					else
						(= local15
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local14 ((gEgo mover:) x:))
					)
				else
					(= local15 (gEgo y:))
					(= local14 (gEgo x:))
				)
				(if (== local15 (gEgo y:))
					(+= local15 5)
				)
				(if local20
					(gCurRoom
						obstacles:
							(switch (gCurRoom curPic:)
								(15 polyList15)
								(16 polyList16)
								(210 polyList210)
								(211 polyList211)
							)
					)
				)
				(if (gCast contains: skeleton)
					(gCurRoom obstacles: polyList1)
				)
				(gEgo
					y: (+ (gEgo y:) 5)
					looper: MyLooper
					setPri: (if local20 -1 else 14)
					moveSpeed: 0
				)
				(if (not (& (OnControl CONTROL local14 local15) $0002))
					(gEgo setMotion: PolyPath local14 local15 local208)
				)
			)
			((and (== local6 3) (& (gEgo onControl: 0) $0004))
				(= local6 2)
				(if (IsObject (gEgo mover:))
					(if global324
						(= local15 -400)
						(= local14 global323)
					else
						(= local15
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local14 ((gEgo mover:) x:))
					)
				else
					(= local15 (gEgo y:))
					(= local14 (gEgo x:))
				)
				(if (== local15 (gEgo y:))
					(-= local15 5)
				)
				(gEgo
					view: 2
					offset: 2
					posn: (gEgo x:) (- (gEgo y:) 5)
				)
				(RedrawCast)
				(gEgo
					offset: 3
					view: 0
					looper: duneLooper
					xStep: 3
					yStep: 2
					setMotion: MoveTo local14 local15 local208
					setPri: 4
				)
				(if (not (& (OnControl CONTROL local14 local15) $0004))
					(gEgo setMotion: MoveTo local14 local15 local208)
				)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((and (== local17 5) (not local19))
				(= local19 1)
				(PrintDC 15 0) ; "The hot sun and choking sands are taking their toll on Graham. He must drink...soon!"
			)
			((and (& (gEgo onControl: 0) $0008) (== local6 3))
				(-- global315)
				(= local5 1)
				(gGame setCursor: gWaitCursor 1)
				(localproc_1)
				(gEgo setCycle: Walk)
				(gGame
					setCursor:
						global119
						(| (HaveMouse) (!= global70 (gUIcons at: 0)))
				)
			)
			(
				(and
					local20
					(!= (gCurRoom curPic:) 210)
					(== local6 1)
					(& (gEgo onControl: 1) $0200)
				)
				(gEgo view: 26)
			)
			(
				(and
					local20
					(!= (gCurRoom curPic:) 210)
					(== local6 1)
					(& (gEgo onControl: 1) $0400)
				)
				(gEgo view: 28)
			)
			(
				(and
					local20
					(== local6 1)
					(not (& (gEgo onControl: 1) $0200))
					(not (& (gEgo onControl: 1) $0400))
					(not (== (gEgo view:) 0))
				)
				(gEgo view: 0)
			)
			(
				(and
					(> local17 6)
					(== (gEgo view:) 0)
					(== local6 1)
					(not local20)
				)
				(gEgo
					looper: MyLooper
					offset: 3
					setPri: 14
					moveSpeed: (+ (gEgo moveSpeed:) 1)
				)
				(self setScript: dying)
			)
			((and (not local0) (= local5 (gEgo edgeHit:)))
				(gGame setCursor: gWaitCursor 1)
				(= local0 1)
				(switch local5
					(3
						(++ global315)
					)
					(2
						(-- global314)
					)
					(4
						(++ global314)
					)
				)
				(localproc_1)
				(gGame
					setCursor:
						global119
						(| (HaveMouse) (!= global70 (gUIcons at: 0)))
				)
				(gEgo setCycle: Walk)
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
		(polyList0 dispose:)
		(polyList1 dispose:)
		(polyList15 dispose:)
		(polyList16 dispose:)
		(polyList210 dispose:)
		(polyList211 dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound stop:)
		(gGlobalSound2 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance duneLooper of Script
	(properties)

	(method (doit)
		(gEgo loop: [local7 (/ (+ (gEgo heading:) 13) 90)])
	)
)

(instance dying of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGlobalSound2 number: 785 loop: 1 play:)
				(User canControl: 0 canInput: 0)
				(gEgo setPri: 14 setMotion: PolyPath 163 160 self)
			)
			(2
				(PrintDC 15 1 #at 20 20 #dispose) ; "Too late! Graham collapses and dies of extreme thirst in the hot desert sun. If only he could have found an oasis!"
				(gEgo
					view: 358
					cel: 0
					cycleSpeed: 2
					normal: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(3
				(switch (gEgo loop:)
					(0
						(= temp0 25)
					)
					(else
						(= temp0 60)
					)
				)
				(buzzard2 init: setScript: dying2)
				(buzzard
					init:
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) temp0) (gEgo y:) self
				)
			)
			(4
				(buzzard setLoop: 4 cel: 4 setCycle: Beg self)
			)
			(5
				(gGlobalSound fade:)
				(gGlobalSound2 fade:)
				(buzzard setLoop: 0 cel: 0)
				(= seconds 3)
			)
			(6
				(cls)
				(= global330 {DYING for a drink, Graham?})
				(EgoDead 264 0 End 20)
			)
		)
	)
)

(instance dying2 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(switch (gEgo loop:)
					(0
						(= temp1 60)
					)
					(else
						(= temp1 25)
					)
				)
				(buzzard2
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) temp1) (gEgo y:) self
				)
			)
			(1
				(buzzard2 setLoop: 5 cel: 4 setCycle: Beg self)
			)
			(2
				(buzzard2 setLoop: 1 cel: 0)
			)
		)
	)
)

(instance getDrink of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local6 1)
			(cond
				((& (gEgo onControl: 1) $0200)
					(gEgo view: 26)
				)
				((& (gEgo onControl: 1) $0400)
					(gEgo view: 28)
				)
				((== state 0)
					(gEgo view: 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local208 self)
				(gEgo
					setMotion:
						PolyPath
						(switch (gCurRoom curPic:)
							(15
								(= global323 178)
							)
							(16
								(= global323 158)
							)
							(210
								(= global323 210)
							)
							(else
								(= global323 150)
							)
						)
						(switch (gCurRoom curPic:)
							(15
								(= global324 168)
							)
							(16
								(= global324 158)
							)
							(210
								(= global324 164)
							)
							(else
								(= global324 159)
							)
						)
						self
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 40 cel: 0 cycleSpeed: 3)
				(= cycles 1)
			)
			(2
				(proc0_7 gEgo dummy 5)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: (+ (gEgo loop:) 4) cel: 0 setCycle: End self)
			)
			(4
				(= cycles 20)
			)
			(5
				(gEgo cel: 0 setCycle: End self)
			)
			(6
				(PrintDC 15 2) ; "Ah! Life-giving water! Nectar of the gods! Graham can now feel renewal flowing through him."
				(gEgo loop: (- (gEgo loop:) 4) cel: 3 setCycle: Beg self)
			)
			(7
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					setLoop: -1
					cycleSpeed: 0
				)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(8
				(proc0_7 gEgo dummy 5)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance useWell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= local6 1)
					(= local208 self)
					(= global323 145)
					(= global324 175)
				)
				(gEgo setMotion: PolyPath 145 175 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 357
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(rope hide:)
			)
			(2
				(gEgo loop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gEgo loop: 6 cel: 0)
				(rope loop: 4 setCycle: Fwd show:)
				(= seconds 4)
			)
			(4
				(gGlobalSound4 number: 68 loop: 1 vol: 127 play:)
				(rope loop: 5 setCycle: 0)
				(gEgo setCycle: Fwd)
				(= seconds 4)
			)
			(5
				(gEgo loop: 7 cel: 0 setCycle: End)
				(= seconds 4)
			)
			(6
				(PrintDC 15 2) ; "Ah! Life-giving water! Nectar of the gods! Graham can now feel renewal flowing through him."
				(gEgo loop: 8 cel: 0 setCycle: End self)
			)
			(7
				(rope loop: 0 cel: 1)
				(gEgo loop: 1 cel: 1 setCycle: Beg self)
			)
			(8
				(gEgo view: 0 loop: 7 cel: 1 cycleSpeed: 0 setCycle: Walk)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(9
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getBoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= local6 1)
					(= local208 self)
					(= global323 61)
					(= global324 170)
					(gEgo setMotion: MoveTo 61 170 self)
				else
					(gEgo setMotion: PolyPath 61 170 self)
				)
			)
			(1
				(= local208 0)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gEgo get: 8) ; Shoe
				(SetScore 2)
				(bootInSand dispose:)
				(gEgo setCycle: Beg self)
			)
			(3
				(PrintDC 15 3) ; "Uneasily, Graham reaches down and removes the old shoe from the desert sand."
				(gEgo normal: 1 view: 0 setCycle: Walk loop: 7 cel: 1)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance desert of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(if local20
						(PrintDC 15 4) ; "All around him, Graham sees nothing but more desert. How much further can he go on? Thankfully, though, a nearby pool of water can relieve Graham's overwhelming thirst."
					else
						(PrintDC 15 5) ; "The scorching sun burns down on the dry desert as Graham struggles through the hot sand. He looks around, but all he can see is...more desert!"
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance skeleton of Prop
	(properties
		y 160
		x 50
		view 354
		loop 4
		priority 13
		signal 16401
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
					(PrintDC 15 6) ; "Oh, oh! A picked-clean and sun-bleached skeleton of a man lies in the sand of the hot, dry desert. What happened? Who can say...but it makes Graham uneasy nevertheless."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 15 7) ; "Graham can't do much to help the poor man now...and vice versa!"
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 15 8) ; "It's too late for conversation now!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bootInSand of Prop
	(properties
		y 175
		x 50
		view 354
		loop 4
		cel 1
		priority 14
		signal 16401
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
					(PrintDC 15 9) ; "An old shoe lies, forgotten, near the poor man's skeleton."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getBoot)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance buzzard of Act
	(properties
		y 48
		x -17
		view 360
		priority 14
		signal 16400
		cycleSpeed 2
	)
)

(instance buzzard2 of Act
	(properties
		y 74
		x 337
		view 360
		priority 14
		signal 16400
		cycleSpeed 2
	)
)

(instance rope of Prop
	(properties
		y 173
		x 112
		view 357
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not local20)
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 15 10) ; "A rope and water basket sit near a small well."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local18)
						(HandsOff)
						(++ local18)
						(= local17 0)
						(if (not (IsFlag 43))
							(SetFlag 43)
							(SetScore 2)
						)
						(gCurRoom setScript: useWell)
					else
						(PrintDC 15 11) ; "Graham has drank all the water he needs for now."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dummy of Prop
	(properties
		y 100
		x 207
		view 354
		loop 5
		priority 1
		signal 16401
	)
)

(instance oasisWater of Prop
	(properties
		view 353
		priority 5
		signal 16400
		cycleSpeed 4
	)
)

(instance oasis of Prop
	(properties
		y 100
		x 207
		view 354
		priority 10
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
				)
				(not local20)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== (gCurRoom curPic:) 210)
						(PrintDC 15 12) ; "A small well! Graham's hot, thirsty body is irresistibly drawn to it."
					else
						(PrintDC 15 13) ; "A small oasis! Its tantalizing water, so sparkling in the desert sun! Graham's hot, thirsty body is irresistibly drawn to it."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local18)
						(HandsOff)
						(++ local18)
						(= local17 0)
						(= local19 0)
						(if (not (IsFlag 43))
							(SetFlag 43)
							(SetScore 2)
						)
						(if (== (gCurRoom curPic:) 210)
							(gCurRoom setScript: useWell)
						else
							(gCurRoom setScript: getDrink)
						)
					else
						(PrintDC 15 11) ; "Graham has drank all the water he needs for now."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance polyList0 of List
	(properties)
)

(instance polyList1 of List
	(properties)
)

(instance polyList15 of List
	(properties)
)

(instance polyList16 of List
	(properties)
)

(instance polyList210 of List
	(properties)
)

(instance polyList211 of List
	(properties)
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

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
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

(instance poly10 of Polygon
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

(instance poly15 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly16 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly17 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly18 of Polygon
	(properties
		type PBarredAccess
	)
)

