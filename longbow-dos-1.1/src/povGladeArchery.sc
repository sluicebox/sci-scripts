;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n013)
(use RTEyeCycle)
(use Osc)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	povGladeArchery 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8 = 1
	local9 = 1
	local10 = 1
	local11
	local12
	local13
	local14
	[local15 6]
	[local21 6]
	[local27 6]
	[local33 6]
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	[local48 3] = [160 187 218]
	[local51 3] = [117 100 107]
	[local54 3] = [65 151 258]
	[local57 3] = [40 60 47]
	[local60 3] = [0 6 4]
	[local63 3] = [3 5 4]
	[local66 3] = [63 150 256]
	local69
	local70
	[local71 4] = [1200 0 1 0]
	[local75 4] = [1200 1 1 0]
	[local79 4] = [1200 2 1 0]
	[local83 4] = [1200 3 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(switch local70
		(0
			(for ((= temp0 0)) (< temp0 local12) ((++ temp0))
				([local21 temp0] hide:)
			)
		)
		(1
			(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
				([local27 temp0] hide:)
			)
		)
		(2
			(for ((= temp0 0)) (< temp0 local14) ((++ temp0))
				([local33 temp0] hide:)
			)
		)
	)
)

(procedure (localproc_1)
	(while (>= (-- local11) 0)
		([local15 local11] dispose:)
	)
	(= local11 0)
	(while (>= (-- local12) 0)
		([local21 local12] dispose:)
	)
	(= local12 0)
	(while (>= (-- local13) 0)
		([local27 local13] dispose:)
	)
	(= local13 0)
	(while (>= (-- local14) 0)
		([local33 local14] dispose:)
	)
	(= local14 0)
)

(procedure (localproc_2)
	(if (== global125 2)
		(= local45 (Random 0 20))
	else
		(= local45 (Random 21 100))
	)
	(cond
		((> local45 80)
			(= local44 (/ 120 global125))
		)
		((> local45 60)
			(= local44 (/ 160 global125))
		)
		((> local45 40)
			(= local44 (/ 200 global125))
		)
		((> local45 20)
			(= local44 (/ 320 global125))
		)
		(else
			(= local44 (/ 360 global125))
		)
	)
)

(procedure (localproc_3)
	(if (== global125 2)
		(= local46 (Random 6 8))
	else
		(= local46 (Random 4 7))
	)
	(cond
		((<= local46 5)
			(= local47 (Random 8 11))
		)
		((<= local46 7)
			(= local47 (Random 17 21))
		)
		((= local46 8)
			(= local47 (Random 65 74))
		)
	)
	(windFlags init:)
)

(procedure (localproc_4)
	(HandsOff)
	(bigTarget hide:)
	(localproc_1)
	(flagTree hide:)
	(garland1 hide:)
	(garland2 hide:)
	(garland3 hide:)
	(windFlags hide:)
	(bowHand hide:)
	(bow hide:)
	(arrow hide:)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCurRoom drawPic: 803)
)

(procedure (localproc_5)
	(gCurRoom drawPic: 200 setScript: prepareArrow)
	(flagTree show:)
	(garland1 show:)
	(garland2 show:)
	(garland3 show:)
	(windFlags show:)
	(bowHand show:)
	(bow show:)
	(arrow show:)
	(= local43 0)
)

(instance povGladeArchery of Rm
	(properties
		picture 200
		style 3
	)

	(method (init)
		(gTheIconBar disable: 2 3 5 6 7)
		(gPMouse joyInc: 2)
		(super init:)
		(= local69 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(garland1 cel: 3 setPri: 3 init:)
		(garland2 cel: 4 setPri: 3 init:)
		(garland3 cel: 0 setPri: 3 init:)
		(bigTarget setPri: 10 init: hide:)
		(= local6 (and (== gDay 8) (== gDisguiseNum 4))) ; yeoman
		(bowHand setPri: 12 init:)
		(bow setPri: 12 loop: 0 cel: 0 init:)
		(arrow setPri: 14 loop: 0 cel: 0 init:)
		(flagTree init: stopUpd:)
		(localproc_2)
		(localproc_3)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(leftTargetArea init:)
		(midTargetArea init:)
		(rightTargetArea init:)
		(if (and (== gPrevRoomNum 190) (== gDay 1) (not (IsFlag 76)))
			(SetFlag 76)
		)
	)

	(method (dispose)
		(shootSound dispose:)
		(hitSound dispose:)
		(gPMouse joyInc: 5)
		(= gUseSortedFeatures local69)
		(super dispose:)
	)

	(method (doit)
		(if (== (-- local44) 0)
			(localproc_3)
			(localproc_2)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1200 7 1) ; "'Tis peaceful to shoot in this quiet, light-dappled glade."
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windFlags of Prop
	(properties
		x 35
		y 85
		view 200
	)

	(method (init)
		(super init:)
		(self loop: local46 setPri: 3 setCycle: Fwd cycleSpeed: local47)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(2 ; Look
				(Say 1200 11 1) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garland1 of Prop
	(properties
		x 160
		y 129
		view 200
		loop 2
	)

	(method (doVerb theVerb)
		(= local70 0)
		(switch theVerb
			(2 ; Look
				(if local12
					(self setScript: closeUpGarland)
				else
					(self setScript: showEmptyTarget)
				)
			)
			(10 ; Longbow
				(leftTargetArea doVerb: 10)
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garland2 of Prop
	(properties
		x 186
		y 110
		view 200
		loop 2
	)

	(method (doVerb theVerb)
		(= local70 1)
		(switch theVerb
			(2 ; Look
				(if local13
					(self setScript: closeUpGarland)
				else
					(self setScript: showEmptyTarget)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(10 ; Longbow
				(midTargetArea doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance garland3 of Prop
	(properties
		x 217
		y 121
		view 200
		loop 2
	)

	(method (doVerb theVerb)
		(= local70 2)
		(switch theVerb
			(2 ; Look
				(if local14
					(self setScript: closeUpGarland)
				else
					(self setScript: showEmptyTarget)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(10 ; Longbow
				(rightTargetArea doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bowHand of View
	(properties
		x 137
		y 239
		lookStr {My arm is steady upon the bow.}
		view 201
		loop 1
		signal 20480
	)

	(method (init)
		(super init:)
		(self setCel: local6)
	)

	(method (doit)
		(if (OneOf gTheCursor 4 5)
			(= x (- (Max 135 (Min 240 gMouseX)) 22))
			(= y (+ (Max 80 (Min 130 gMouseY)) 109))
			(if (and local10 (<= 148 gMouseX 226) (<= 82 gMouseY 132))
				(gGame setCursor: 5 1)
			else
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (not local10)
					(if (< local11 6)
						(gCurRoom setScript: prepareArrow)
					else
						(gCurRoom setScript: newRound)
					)
				)
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bow of View
	(properties
		x 195
		y 144
		lookStr {So many years have I held a longbow, it feels like a part of my own arm.}
		view 201
		signal 20480
	)

	(method (doit)
		(= x (+ (bowHand x:) 58))
		(= y (- (bowHand y:) 95))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arrow of View
	(properties
		x 159
		y 133
		lookStr {My arrow is nocked and ready to be loosed.}
		view 332
		priority 16
		signal 16400
	)

	(method (doit)
		(= x (+ (bowHand x:) 22))
		(= y (- (bowHand y:) 106))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance smallArrow of View
	(properties
		view 332
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1200 12) ; "My previous shot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigTarget of View
	(properties
		x 151
		y 167
		view 200
		signal 16392
	)

	(method (onMe param1)
		(return
			(and
				(<= nsLeft (param1 x:) nsRight)
				(<= nsTop (param1 y:) nsBottom)
			)
		)
	)
)

(instance flagTree of View
	(properties
		x 32
		y 143
		view 200
		loop 1
		priority 9
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(2 ; Look
				(Say 1200 11) ; "The bit of cloth tied to the tree tells how strongly the wind blows, and from which direction."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock1 of Feature
	(properties
		x 32
		y 122
		nsTop 114
		nsLeft 17
		nsBottom 131
		nsRight 47
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1200 8 1) ; "I should take care not to ruin my arrow by firing upon a rock."
			)
			(1 ; Walk
				(gCurRoom setScript: leaveGlade)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock2 of Feature
	(properties
		x 124
		y 137
		nsTop 129
		nsLeft 113
		nsBottom 145
		nsRight 136
		sightAngle 90
	)

	(method (doVerb)
		(rock1 doVerb: &rest)
	)
)

(instance rock3 of Feature
	(properties
		x 282
		y 172
		nsTop 156
		nsLeft 246
		nsBottom 189
		nsRight 319
		sightAngle 90
	)

	(method (doVerb)
		(rock1 doVerb: &rest)
	)
)

(instance prepareArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arrow
					cel: 0
					posn: (+ (bowHand x:) 22) (- (bowHand y:) 106)
					show:
				)
				(= local10 1)
				(gGame setCursor: 5 1)
				(= cycles 5)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance fireArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(arrow cel: 1)
				(= cycles 1)
			)
			(1
				(shootSound play:)
				(arrow cel: 2)
				(= cycles 1)
			)
			(2
				(arrow hide:)
				(= local39 (arrow x:))
				(= local40 (arrow y:))
				(= local10 0)
				(= ticks
					(switch local70
						(0 5)
						(1 20)
						(2 15)
					)
				)
			)
			(3
				(+=
					local39
					(switch local46
						(4
							(-
								(switch local70
									(0
										(Random 3 7)
									)
									(1
										(Random 1 5)
									)
									(2
										(Random 2 6)
									)
								)
							)
						)
						(5
							(switch local70
								(0
									(Random 3 7)
								)
								(1
									(Random 1 5)
								)
								(2
									(Random 2 6)
								)
							)
						)
						(6
							(-
								(switch local70
									(0
										(Random 2 6)
									)
									(1
										(Random 1 4)
									)
									(2
										(Random 1 5)
									)
								)
							)
						)
						(7
							(switch local70
								(0
									(Random 2 6)
								)
								(1
									(Random 1 4)
								)
								(2
									(Random 1 5)
								)
							)
						)
					)
				)
				(+= local40 [local60 local70])
				(arrow cel: [local63 local70])
				((= [local15 local11] (smallArrow new:))
					view: 332
					loop: 0
					cel: [local63 local70]
					posn: local39 local40
					ignoreActors:
					setPri: 5
					init:
					stopUpd:
				)
				(if
					(or
						(> 280 local39 230)
						(> 137 local39 35)
						(and (> 179 local39 172) (> 103 local40 71))
						(and (> 205 local39 194) (> 115 local40 78))
					)
					(= local41 999)
					(= local42 999)
				else
					(= local41
						(+
							(/
								(*
									(- local39 [local48 local70])
									[local57 local70]
								)
								10
							)
							[local54 local70]
						)
					)
					(if (== local39 local43)
						(-= local41 1)
					)
					(= local42
						(+
							(/
								(*
									(- local40 [local51 local70])
									[local57 local70]
								)
								10
							)
							122
						)
					)
				)
				(= local43 local39)
				(switch local70
					(0
						((= [local21 local12] (Prop new:))
							view: 200
							loop: 3
							cel: 0
							posn: local41 local42
							setPri: 11
							ignoreActors:
							init:
							hide:
						)
						(++ local12)
						(= local0 0)
					)
					(1
						((= [local27 local13] (Prop new:))
							view: 200
							loop: 3
							cel: 0
							posn: local41 local42
							setPri: 11
							ignoreActors:
							init:
							hide:
						)
						(++ local13)
						(= local1 0)
					)
					(2
						((= [local33 local14] (Prop new:))
							view: 200
							loop: 3
							cel: 0
							posn: local41 local42
							setPri: 11
							ignoreActors:
							init:
							hide:
						)
						(++ local14)
						(= local2 0)
					)
				)
				(if
					(or
						(> 280 local39 230)
						(> 137 local39 35)
						(and (> 179 local39 172) (> 103 local40 71))
						(and (> 205 local39 194) (> 115 local40 78))
					)
					([local15 local11] hide:)
					(hitSound number: 357)
				else
					(hitSound number: 908)
				)
				(if (== gDay 1)
					(SetFlag 41)
				)
				(++ local11)
				(gGame
					setCursor:
						gTheCursor
						1
						(+ gMouseX (Random 0 8) -4)
						(+ gMouseY (Random 0 8) -4)
				)
				(= cycles (if (== local41 999) 10 else 1))
			)
			(4
				(User canInput: 1)
				(hitSound play:)
				(if (IsFlag 43)
					(cond
						(
							(and
								(or
									(> 280 local39 230)
									(> 137 local39 35)
									(and (> 179 local39 172) (> 103 local40 71))
									(and (> 205 local39 194) (> 115 local40 78))
								)
								local9
							)
							(client setScript: saySomethingWill self 2)
						)
						(
							(and
								(switch local70
									(0
										(== local39 160)
									)
									(1
										(== local39 187)
									)
									(2
										(== local39 218)
									)
								)
								(switch local70
									(0
										(or (== local40 117) (== local40 118))
									)
									(1
										(or (== local40 99) (== local40 100))
									)
									(2
										(== local40 107)
									)
								)
								local7
							)
							(client setScript: saySomethingWill self 0)
						)
						(
							(and
								(switch local70
									(0
										(or
											(>= 179 local39 168)
											(>= 154 local39 138)
											(and
												(>= 179 local39 138)
												(or
													(> 110 local40 64)
													(> 151 local40 125)
												)
											)
										)
									)
									(1
										(or
											(>= 193 local39 191)
											(>= 183 local39 180)
											(and
												(>= 193 local39 180)
												(or
													(>= 92 local40 56)
													(>= 114 local40 102)
												)
											)
										)
									)
									(2
										(or
											(>= 228 local39 222)
											(>= 213 local39 206)
											(and
												(>= 228 local39 206)
												(or
													(> 100 local40 82)
													(> 124 local40 113)
												)
											)
										)
									)
								)
								local8
							)
							(client setScript: saySomethingWill self 1)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(if (not (SetFlag 166))
					(gCurRoom setScript: showCloseUpGarland)
				else
					(= cycles 1)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance showCloseUpGarland of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar select: (gTheIconBar at: 1))
				(gGame setCursor: 1 1)
				(= ticks 60)
			)
			(1
				(HandsOn 1)
				(client setScript: closeUpGarland)
			)
		)
	)
)

(instance closeUpGarland of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(arrow hide:)
				(bow hide:)
				(bowHand hide:)
				(bigTarget x: [local66 local70])
				(= cycles 1)
			)
			(1
				(bigTarget show:)
				(SetNowSeen bigTarget)
				(switch local70
					(0
						(for ((= temp0 0)) (< temp0 local12) ((++ temp0))
							(= temp1 [local21 temp0])
							(if (bigTarget onMe: temp1)
								(temp1 show:)
							)
						)
						(if (not local0)
							(temp1 setCycle: Osc 1)
						)
						(= local0 1)
					)
					(1
						(for ((= temp0 0)) (< temp0 local13) ((++ temp0))
							(= temp1 [local27 temp0])
							(if (bigTarget onMe: temp1)
								(temp1 show:)
							)
						)
						(if (not local1)
							(temp1 setCycle: Osc 1)
						)
						(= local1 1)
					)
					(2
						(for ((= temp0 0)) (< temp0 local14) ((++ temp0))
							(= temp1 [local33 temp0])
							(if (bigTarget onMe: temp1)
								(temp1 show:)
							)
						)
						(if (not local2)
							(temp1 setCycle: Osc 1)
						)
						(= local2 1)
					)
				)
				(= ticks 150)
			)
			(2
				(localproc_0)
				(bigTarget hide:)
				(= cycles 5)
			)
			(3
				(bow show:)
				(bowHand show:)
				(if (== local10 1)
					(arrow show:)
				)
				(= cycles 2)
			)
			(4
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance saySomethingWill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(0
						(= local7 0)
						(Converse 1 @local71 14 0 self) ; "A masterful shot, Robin!"
					)
					(1
						(= local8 0)
						(Converse 1 @local75 14 0 self) ; "Methinks this would be a good day to wager against you! Your shooting is terrible!"
					)
					(2
						(= local9 0)
						(Converse 1 @local83 14 0 self) ; "Ho, Robin! Too much ale has blurred your vision and lost you an arrow!"
					)
				)
			)
			(1
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance leaveGlade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local11
					(Say 1200 10 self) ; "I'll collect what I've fired before I leave."
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom newRoom: 190)
				(self dispose:)
			)
		)
	)
)

(instance newRound of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 18)
			)
			(1
				(if (IsFlag 43)
					(Converse 1 @local79 14 0 self) ; "Hold fast, Robin, while I collect the arrows."
				else
					(Say 1200 9 self) ; "I'll collect my arrows before I fire again."
				)
			)
			(2
				(HandsOn 1)
				(gTheIconBar disable: 0 4 select: (gTheIconBar at: 1))
				(= ticks 300)
			)
			(3
				(if (bigTarget isNotHidden:)
					(-- state)
				)
				(= ticks 10)
			)
			(4
				(localproc_4)
				(= ticks 60)
			)
			(5
				(localproc_5)
				(HandsOn 1)
				(gTheIconBar enable: 0 4 curIcon: (gTheIconBar at: 4))
				(gGame setCursor: 4 1)
				(= ticks 30)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance showEmptyTarget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(arrow hide:)
				(bow hide:)
				(bowHand hide:)
				(= cycles 1)
			)
			(1
				(bigTarget x: [local66 local70] show:)
				(= cycles 2)
			)
			(2
				(switch local70
					(0
						(if local3
							(= local3 0)
							(Say 1200 4) ; "This garland is the closest of the three."
						)
					)
					(1
						(if local4
							(= local4 0)
							(Say 1200 5) ; "This garland is the most difficult of the three."
						)
					)
					(2
						(if local5
							(= local5 0)
							(Say 1200 6) ; "This garland is placed at a challenging, but not overly difficult, distance."
						)
					)
				)
				(= cycles 5)
			)
			(3
				(bigTarget x: [local66 local70] hide:)
				(= cycles 3)
			)
			(4
				(bow show:)
				(bowHand show:)
				(if (== local10 1)
					(arrow show:)
				)
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 906
	)
)

(instance hitSound of Sound
	(properties
		flags 1
	)
)

(instance leftTargetArea of Feature
	(properties
		x 161
		y 130
		nsTop 80
		nsLeft 140
		nsBottom 134
		nsRight 174
		description {targetArea}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (and local10 (< local11 6))
					(= local70 0)
					(gCurRoom setScript: fireArrow)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance midTargetArea of Feature
	(properties
		x 188
		y 101
		nsTop 70
		nsLeft 175
		nsBottom 122
		nsRight 200
		description {targetArea}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (and local10 (< local11 6))
					(= local70 1)
					(gCurRoom setScript: fireArrow)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightTargetArea of Feature
	(properties
		x 218
		y 105
		nsTop 75
		nsLeft 201
		nsBottom 125
		nsRight 234
		description {targetArea}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (and local10 (< local11 6))
					(= local70 2)
					(gCurRoom setScript: fireArrow)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

