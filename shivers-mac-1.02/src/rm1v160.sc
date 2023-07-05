;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1160)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm1v160 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 8]
	[local13 16] = [88 69 124 69 160 69 196 69 125 97 163 97 200 97 239 97]
)

(procedure (localproc_0 &tmp temp0)
	(= local2 0)
	(= local3 0)
	(= local4 0)
	(= local0 0)
	(= local1 0)
	(gNormalCursor show:)
	(gearCursor hide:)
	(gear1 posn: [local13 2] [local13 3] loop: 1 init:)
	(gear2 posn: [local13 4] [local13 5] loop: 2 init:)
	(gear3 posn: [local13 6] [local13 7] loop: 3 init:)
	(gear4 posn: [local13 8] [local13 9] loop: 12 init:)
	(gear5 posn: [local13 10] [local13 11] loop: 13 init:)
	(gear6 posn: [local13 12] [local13 13] loop: 14 init:)
	(= [local5 0] 0)
	(= [local5 1] gear1)
	(= [local5 2] gear2)
	(= [local5 3] gear3)
	(= [local5 4] gear4)
	(= [local5 5] gear5)
	(= [local5 6] gear6)
	(= [local5 7] 0)
)

(procedure (localproc_1 param1 &tmp temp0)
	(cond
		((== [local5 param1] 0)
			(if local3
				(if (not (localproc_3 param1 local4))
					(gCurRoom setScript: sBadCursor)
				else
					(= temp0 (/ (local3 loop:) 8))
					(= [local5 param1] local3)
					(proc951_9 10107)
					(gSounds stop: 10107)
					(gSounds play: 10107 0 82 0)
					(local3
						x: [local13 (* 2 param1)]
						y: [local13 (+ (* 2 param1) 1)]
						loop: (+ param1 (* temp0 8))
						show:
					)
					(= local3 0)
					(gearCursor hide:)
					(gNormalCursor show:)
					(SetCursor 999 0 gTheCursor)
					(if (and (!= local4 param1) (<= (++ local2) 7))
						(if (== local2 7)
							(if (localproc_2)
								(= local0 1)
								(box0 dispose:)
								(box1 dispose:)
								(box2 dispose:)
								(box3 dispose:)
								(box4 dispose:)
								(box5 dispose:)
								(box6 dispose:)
								(box7 dispose:)
								(= local2 0)
								(computerText loop: 9 cel: 0 setCycle: End)
							else
								(gCurRoom newRoom: 1162) ; rm1v162
							)
						else
							(computerText loop: local2 cel: 0 setCycle: End)
						)
					)
					(= local4 0)
				)
			)
		)
		((not local3)
			(= local3 [local5 param1])
			(= temp0 (/ (local3 loop:) 8))
			(local3 hide:)
			(= [local5 param1] 0)
			(= local4 param1)
			(gNormalCursor hide:)
			(gearCursor loop: temp0 x: (- gMouseX 27) y: (- gMouseY 7) show:)
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(= temp1 1)
	(for ((= temp0 1)) (<= temp0 3) ((++ temp0))
		(if (or (not [local5 temp0]) (< ([local5 temp0] loop:) 8))
			(= temp1 0)
		)
	)
	(for ((= temp0 4)) (<= temp0 6) ((++ temp0))
		(if (or (not [local5 temp0]) (> ([local5 temp0] loop:) 7))
			(= temp1 0)
		)
	)
	(return temp1)
)

(procedure (localproc_3 param1 param2 &tmp temp0)
	(switch param1
		(0
			(= temp0 (OneOf param2 0 1 4))
		)
		(1
			(= temp0 (OneOf param2 0 1 2 4 5))
		)
		(2
			(= temp0 (OneOf param2 1 2 3 4 5 6))
		)
		(3
			(= temp0 (OneOf param2 2 3 5 6 7))
		)
		(4
			(= temp0 (OneOf param2 0 1 2 4 5))
		)
		(5
			(= temp0 (OneOf param2 1 2 3 4 5 6))
		)
		(6
			(= temp0 (OneOf param2 2 3 5 6 7))
		)
		(7
			(= temp0 (OneOf param2 3 6 7))
		)
	)
)

(instance rm1v160 of ShiversRoom
	(properties
		picture 1160
	)

	(method (init &tmp temp0 temp1)
		(if (== gPrevRoomNum 1162) ; rm1v162
			(gSounds play: 10129 0 82 0)
		)
		(efExitBack init: 8)
		(crank init: setPri: 10 1)
		(localproc_0)
		(box0 init:)
		(box1 init:)
		(box2 init:)
		(box3 init:)
		(box4 init:)
		(box5 init:)
		(box6 init:)
		(box7 init:)
		(gearCursor init:)
		(computerText init: loop: 0 cel: 0 setCycle: End)
		(super init: &rest)
		(= temp1 (Random 1 30))
		(= temp0 (Random 5 10))
		(cond
			((< 0 temp1 4)
				(gSounds playChain: -1 temp0 10116 0)
				(gSounds adjChainVol: 42)
			)
			((< 3 temp1 7)
				(gSounds playChain: -1 temp0 10117 0)
				(gSounds adjChainVol: 42)
			)
			((< 6 temp1 10)
				(gSounds playChain: -1 temp0 10118 0)
				(gSounds adjChainVol: 42)
			)
			((< 9 temp1 13)
				(gSounds playChain: -1 temp0 10120 0)
				(gSounds adjChainVol: 42)
			)
			((< 12 temp1 16)
				(gSounds playChain: -1 temp0 10121 0)
				(gSounds adjChainVol: 42)
			)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 1162
	)

	(method (init)
		(self
			createPoly:
				48
				44
				43
				59
				28
				66
				21
				98
				39
				118
				102
				118
				102
				123
				259
				123
				259
				45
				50
				45
				50
				0
				261
				0
				262
				141
				0
				141
				0
				0
				48
				0
				48
				44
		)
		(super init: &rest)
	)
)

(instance crank of ShiversProp
	(properties
		view 1001
	)

	(method (onMe &tmp temp0)
		(= temp0 (super onMe: &rest))
		(if local0
			(return temp0)
		else
			(return 0)
		)
	)

	(method (doVerb &tmp [temp0 5])
		(if local0
			(gCurRoom setScript: sTurnCrank)
		)
	)
)

(instance allGears of Prop
	(properties
		x 20
		view 1001
		loop 1
	)
)

(instance gear1 of Prop
	(properties
		x 124
		y 69
		view 1000
		loop 9
	)
)

(instance gear2 of Prop
	(properties
		x 160
		y 69
		view 1000
		loop 10
	)
)

(instance gear3 of Prop
	(properties
		x 196
		y 69
		view 1000
		loop 11
	)
)

(instance gear4 of Prop
	(properties
		x 125
		y 97
		view 1000
		loop 4
	)
)

(instance gear5 of Prop
	(properties
		x 163
		y 97
		view 1000
		loop 5
	)
)

(instance gear6 of Prop
	(properties
		x 200
		y 97
		view 1000
		loop 6
	)
)

(instance gearCursor of Prop
	(properties
		view 1005
	)

	(method (doit)
		(if local3
			(= x (- gMouseX 27))
			(= y (- gMouseY 7))
			(UpdateScreenItem self)
		)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 255 1)
		(self hide:)
	)
)

(instance computerText of Prop
	(properties
		view 1006
	)

	(method (init)
		(super init: &rest)
		(self setPri: 25 1)
	)
)

(instance box0 of HotSpot
	(properties
		nsLeft 72
		nsTop 53
		nsRight 104
		nsBottom 85
	)

	(method (doVerb &tmp temp0)
		(localproc_1 0)
	)
)

(instance box1 of HotSpot
	(properties
		nsLeft 108
		nsTop 53
		nsRight 140
		nsBottom 85
	)

	(method (doVerb &tmp temp0)
		(localproc_1 1)
	)
)

(instance box2 of HotSpot
	(properties
		nsLeft 144
		nsTop 53
		nsRight 176
		nsBottom 85
	)

	(method (doVerb &tmp temp0)
		(localproc_1 2)
	)
)

(instance box3 of HotSpot
	(properties
		nsLeft 180
		nsTop 53
		nsRight 212
		nsBottom 85
	)

	(method (doVerb &tmp temp0)
		(localproc_1 3)
	)
)

(instance box4 of HotSpot
	(properties
		nsLeft 109
		nsTop 81
		nsRight 141
		nsBottom 113
	)

	(method (doVerb &tmp temp0)
		(localproc_1 4)
	)
)

(instance box5 of HotSpot
	(properties
		nsLeft 147
		nsTop 81
		nsRight 179
		nsBottom 113
	)

	(method (doVerb &tmp temp0)
		(localproc_1 5)
	)
)

(instance box6 of HotSpot
	(properties
		nsLeft 184
		nsTop 81
		nsRight 216
		nsBottom 113
	)

	(method (doVerb &tmp temp0)
		(localproc_1 6)
	)
)

(instance box7 of HotSpot
	(properties
		nsLeft 223
		nsTop 81
		nsRight 255
		nsBottom 113
	)

	(method (doVerb &tmp temp0)
		(localproc_1 7)
	)
)

(instance sBadCursor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gearCursor scratch: (gearCursor loop:))
				(gearCursor loop: 2)
				(= seconds 2)
			)
			(1
				(gearCursor loop: (gearCursor scratch:))
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 1161
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 1161
	)
)

(instance sTurnCrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_9 10108)
				(proc951_9 10130)
				(gear1 dispose:)
				(gear2 dispose:)
				(gear3 dispose:)
				(gear4 dispose:)
				(gear5 dispose:)
				(gear6 dispose:)
				(allGears init: setPri: 10 1)
				(= cycles 1)
			)
			(1
				(gSounds play: 10108 0 90 0)
				(allGears setCycle: Fwd)
				(crank setCycle: End self)
			)
			(2
				(allGears setCycle: End)
				(= seconds 3)
			)
			(3
				(if (not (IsFlag 0))
					(gSounds play: 10130 0 122 self)
				else
					(= cycles 1)
				)
			)
			(4
				(SetFlag 0)
				(proc951_15 6750)
				(gGame handsOn:)
				(gCurRoom newRoom: 1162) ; rm1v162
				(self dispose:)
			)
		)
	)
)

