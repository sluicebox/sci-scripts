;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 951)
(include sci.sh)
(use Main)

(public
	proc951_0 0
	proc951_1 1
	proc951_2 2
	SetFlag 3
	ClearFlag 4
	IsFlag 5
	proc951_6 6
	proc951_7 7
	proc951_8 8
	proc951_9 9
	proc951_10 10
	proc951_11 11
	proc951_12 12
	proc951_13 13
	proc951_14 14
	proc951_15 15
	proc951_16 16
	proc951_17 17
	proc951_18 18
	proc951_19 19
)

(procedure (proc951_0 param1 &tmp temp0 temp1)
	(while (= temp0 (Random 0 22))
		(if (>= temp0 23)
			(= temp0 0)
		)
		(= temp1 (* temp0 2))
		(if
			(and
				(not
					(or
						(and
							(or (== param1 204) (== param1 214))
							(== [global118 temp1] 25050)
						)
						(and
							(or (== param1 203) (== param1 213))
							(== [global118 temp1] 14080)
						)
						(and
							(or (== param1 203) (== param1 213))
							(== [global118 temp1] 25050)
						)
						(and (== (IsFlag 62) 0) (== [global118 temp1] 8100))
						(and (== (IsFlag 62) 0) (== [global118 temp1] 11310))
						(and (== (IsFlag 62) 0) (== [global118 temp1] 22190))
					)
				)
				(== [global118 (+ temp1 1)] 0)
			)
			(if (== [global118 temp1] 7112)
				(ClearFlag 64)
				(ClearFlag 8)
			)
			(if (== [global118 temp1] 8490)
				(ClearFlag 40)
			)
			(if (== [global118 temp1] 12181)
				(ClearFlag 10)
			)
			(if (== [global118 temp1] 16420)
				(ClearFlag 77)
				(ClearFlag 13)
			)
			(if (== [global118 temp1] 20553)
				(ClearFlag 17)
			)
			(if (== [global118 temp1] 21070)
				(ClearFlag 21)
				(ClearFlag 83)
			)
			(if (== [global118 temp1] 23550)
				(ClearFlag 23)
			)
			(if (== [global118 temp1] 24380)
				(ClearFlag 66)
				(ClearFlag 91)
			)
			(if (== [global118 temp1] 25005)
				(ClearFlag 25)
			)
			(if (== [global118 temp1] 29080)
				(ClearFlag 68)
			)
			(if (== [global118 temp1] 30420)
				(ClearFlag 58)
			)
			(if (== [global118 temp1] 31310)
				(ClearFlag 11)
			)
			(if (== [global118 temp1] 32570)
				(ClearFlag 82)
				(ClearFlag 81)
			)
			(if (== [global118 temp1] 35110)
				(= global546 1200)
				(ClearFlag 90)
			)
			(break)
		)
	)
	(= [global118 (+ temp1 1)] param1)
)

(procedure (proc951_1 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 [global164 (* 2 param1)])
	(= temp0 0)
	(switch param1
		(0
			(= temp3 {water})
			(cond
				((== temp1 -1)
					(= temp0 3000)
				)
				((and (>= gCurRoomNum 20000) (proc951_11 4 25000))
					(= temp0 9000)
				)
				(else
					(switch (Random 0 1)
						(0
							(= temp0 9000)
						)
						(1
							(= temp0 25000)
						)
					)
				)
			)
		)
		(1
			(= temp3 {wax})
			(if (== temp1 -1)
				(= temp2 (Random 0 2))
			else
				(= temp2 (Random 0 3))
			)
			(switch temp2
				(0
					(= temp0 8000)
				)
				(1
					(= temp0 22000)
				)
				(2
					(= temp0 24000)
				)
				(3
					(= temp0 temp1)
				)
			)
		)
		(2
			(= temp3 {ash})
			(cond
				((or (== temp1 -1) global186)
					(= temp0 6000)
				)
				((not (IsFlag 59))
					(= temp0 6000)
					(SetFlag 59)
				)
				(else
					(switch (Random 0 1)
						(0
							(= temp0 6000)
						)
						(1
							(= temp0 21000)
						)
					)
				)
			)
		)
		(3
			(= temp3 {tar})
			(cond
				(global186
					(= temp0 14000)
				)
				((or (<= 14000 gCurRoomNum 14999) (== gCurRoomNum 13342)) ; rm13v342
					(= temp0 14000)
				)
				(else
					(switch (Random 0 1)
						(0
							(= temp0 11000)
						)
						(1
							(= temp0 14000)
						)
					)
				)
			)
		)
		(4
			(= temp3 {fabric})
			(if (or (== temp1 -1) (<= 25000 gCurRoomNum 25999) (== gCurRoomNum 26210)) ; rm25v0, rm26v210
				(= temp0 25000)
			else
				(switch (Random 0 3)
					(0
						(= temp0 temp1)
					)
					(1
						(= temp0 25000)
					)
					(2
						(= temp0 20000)
					)
					(3
						(= temp0 21000)
					)
				)
			)
		)
		(5
			(= temp3 {wood})
			(if (== temp1 -1)
				(= temp2 (Random 0 3))
			else
				(= temp2 (Random 0 7))
			)
			(switch temp2
				(0
					(= temp0 7000)
				)
				(1
					(= temp0 23000)
				)
				(2
					(= temp0 24000)
				)
				(3
					(= temp0 36000)
				)
				(4
					(= temp0 temp1)
				)
				(5
					(= temp0 temp1)
				)
				(6
					(= temp0 temp1)
				)
				(7
					(= temp0 temp1)
				)
			)
		)
		(6
			(= temp3 {crystal})
			(if global186
				(= temp0 12000)
			else
				(switch (Random 0 1)
					(0
						(= temp0 12000)
					)
					(1
						(= temp0 9000)
					)
				)
			)
		)
		(7
			(= temp3 {electric})
			(cond
				((< global547 9)
					(= temp2 (Random 0 1))
				)
				((<= -26536 gCurRoomNum -25537)
					(= temp2 2)
				)
				((IsFlag 79)
					(= temp2 2)
				)
				(else
					(= temp2 (Random 0 2))
				)
			)
			(switch temp2
				(0
					(= temp0 29000)
				)
				(1
					(= temp0 32000)
				)
				(2
					(= temp0 39000)
				)
			)
		)
		(8
			(= temp3 {sand})
			(if global186
				(= temp0 12000)
			else
				(switch (Random 0 1)
					(0
						(= temp0 12000)
					)
					(1
						(= temp0 19000)
					)
				)
			)
		)
		(9
			(= temp3 {metal})
			(if (== temp1 -1)
				(= temp2 (Random 0 2))
			else
				(= temp2 (Random 0 3))
			)
			(if global186
				(= temp0 17000)
			else
				(switch temp2
					(0
						(= temp0 17000)
					)
					(1
						(= temp0 37000)
					)
					(2
						(= temp0 11000)
					)
					(3
						(= temp0 temp1)
					)
				)
			)
		)
	)
	(if (and (!= temp1 0) temp0)
		(= [global164 (* 2 param1)] temp0)
	)
)

(procedure (proc951_2 param1 &tmp temp0)
	(+= global109 param1)
	(if (> param1 0)
		(proc951_15 (* param1 75))
	else
		(proc951_15 (* param1 150))
	)
	(cond
		((> global109 100)
			(= global109 100)
		)
		((< global109 0)
			(= global109 0)
		)
	)
	(= temp0 (- 10 (/ global109 10)))
	((ScriptID 950 1) cel: temp0) ; vEssenceView
	(UpdateScreenItem (ScriptID 950 1)) ; vEssenceView
	(if (== global109 0)
		(gSounds play: 15011 0 98 0)
		(gCurRoom newRoom: 914) ; deadRoom
	)
)

(procedure (SetFlag param1)
	(|= [global209 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (ClearFlag param1)
	(&= [global209 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
)

(procedure (IsFlag param1)
	(return (& [global209 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc951_6) ; UNUSED
	(if (or (!= gMouseX global340) (!= gMouseY global341))
		(= global340 gMouseX)
		(= global341 gMouseY)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc951_7 param1)
	(if (ResCheck 140 param1) ; WAVE
		(Load 140 param1) ; WAVE
	else
		(Load rsAUDIO param1)
	)
)

(procedure (proc951_8 param1)
	(if (ResCheck 140 param1) ; WAVE
		(UnLoad 140 param1)
	else
		(UnLoad 141 param1)
	)
)

(procedure (proc951_9 &tmp temp0))

(procedure (proc951_10))

(procedure (proc951_18 param1 &tmp temp0)
	(cond
		((ResCheck 140 param1) ; WAVE
			(if (!= (Load 140 param1) 0) ; WAVE
				(Lock 140 param1 1) ; WAVE
			)
		)
		((!= (Load rsAUDIO param1) 0)
			(Lock rsAUDIO param1 1)
		)
	)
)

(procedure (proc951_19 param1)
	(if (ResCheck 140 param1) ; WAVE
		(Lock 140 param1 0) ; WAVE
	else
		(Lock rsAUDIO param1 0)
	)
)

(procedure (proc951_11 param1 param2 &tmp temp0)
	(= temp0 (== param2 [global164 (* 2 param1)]))
	(if (and (== param1 3) (== param2 14000) [global164 (* 2 param1)])
		(= temp0 1)
	)
	(if (and (== param2 25000) [global164 8])
		(if (== param1 4)
			(= temp0 1)
		)
		(if (and (== param1 0) [global164 0])
			(= temp0 0)
			(= [global164 0] 9000)
		)
	)
	(return temp0)
)

(procedure (proc951_12)
	(if global105
		(gShiversInvItem dispose:)
		(= gShiversInvItem 0)
		(= global184 0)
		(switch global105
			(220
				((ScriptID 950 10) init:) ; vWaterPotView
				(|= global104 $0080)
			)
			(226
				((ScriptID 950 4) init:) ; vCrystalPotView
				(|= global104 $0002)
			)
			(228
				((ScriptID 950 3) init:) ; vSandPotView
				(|= global104 $0001)
			)
			(229
				((ScriptID 950 5) init:) ; vMetalPotView
				(|= global104 $0004)
			)
			(221
				((ScriptID 950 12) init:) ; vWaxPotView
				(|= global104 $0200)
			)
			(223
				((ScriptID 950 6) init:) ; vTarPotView
				(|= global104 $0008)
			)
			(222
				((ScriptID 950 9) init:) ; vAshPotView
				(|= global104 $0040)
			)
			(224
				((ScriptID 950 11) init:) ; vFabricPotView
				(|= global104 $0100)
			)
			(225
				((ScriptID 950 7) init:) ; vWoodPotView
				(|= global104 $0010)
			)
			(227
				((ScriptID 950 8) init:) ; vElectricPotView
				(|= global104 $0020)
			)
		)
		(gSounds play: 15015 0 90 0)
		(++ global547)
		(= global105 0)
		(gNormalCursor show:)
	)
)

(procedure (proc951_13 &tmp temp0 temp1)
	(if global105
		(gShiversInvItem dispose:)
		(= gShiversInvItem 0)
		(= global184 0)
		(gNormalCursor show:)
		(if (> global105 219)
			(= temp1 (+ (= temp0 (+ 200 (mod global105 10))) 10))
			(proc951_0 temp0)
			(proc951_0 temp1)
		else
			(proc951_0 global105)
		)
		(= global105 0)
	)
)

(procedure (proc951_14 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp3 0)) (< temp3 23) ((++ temp3))
		(cond
			((== [global118 (= temp2 (* temp3 2))] 6220)
				(= [global118 (+ temp2 1)] 212)
			)
			((== [global118 temp2] 19220)
				(= [global118 (+ temp2 1)] 202)
			)
			((== [global118 temp2] 9420)
				(= [global118 (+ temp2 1)] 217)
			)
			(else
				(= [global118 (+ temp2 1)] 0)
			)
		)
	)
	(for ((= temp3 0)) (< temp3 94) ((++ temp3))
		(ClearFlag temp3)
	)
	(for ((= temp3 0)) (< temp3 178) ((++ temp3))
		(cond
			((< temp3 20)
				(= [global350 temp3] 2500)
			)
			((< temp3 66)
				(= [global350 temp3] 250)
			)
			((< temp3 80)
				(= [global350 temp3] 300)
			)
			((< temp3 130)
				(= [global350 temp3] 350)
			)
			((< temp3 140)
				(= [global350 temp3] 625)
			)
			((< temp3 143)
				(= [global350 temp3] 1000)
			)
			((< temp3 160)
				(= [global350 temp3] 1500)
			)
			((< temp3 167)
				(= [global350 temp3] 2750)
			)
			((< temp3 170)
				(= [global350 temp3] 6500)
			)
			((< temp3 177)
				(= [global350 temp3] 300)
			)
		)
	)
	(for ((= temp0 200)) (<= temp0 219) ((++ temp0))
		(if (and (!= temp0 212) (!= temp0 202) (!= temp0 217))
			(proc951_0 temp0)
		)
	)
	(for ((= temp1 0)) (<= temp1 9) ((++ temp1))
		(= [global164 (* temp1 2)] -1)
		(proc951_1 temp1)
		(= [global164 (+ (* temp1 2) 1)] 0)
	)
	(SetFlag 37)
	(if (> (gGame detailLevel:) 7)
		(ClearFlag 35)
		(ClearFlag 38)
	else
		(SetFlag 35)
		(SetFlag 38)
	)
	(= global109 100)
	(= global105 0)
	(= global106 0)
	(= global107 0)
	(= gExitFeature 0)
	(= global184 0)
	(= global185 0)
	(= global347 0)
	(= global104 0)
	(= global547 0)
	(= gScore 0)
	(= global349 0)
	(= global546 1200)
	(= global549 2)
	(= global550 0)
	(= global551 0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [global322 temp0] (+ (* (Random 1 5) 2) 1))
		(= [global328 temp0] (Random 0 3))
		(if (== [global328 temp0] [global334 temp0])
			(= [global328 temp0] (- 3 [global334 temp0]))
		)
		(= [global540 temp0] (Random 1 3))
	)
)

(procedure (proc951_15 param1)
	(if (IsFlag 87)
		(= param1 0)
	)
	(if (>= param1 0)
		(+= gScore param1)
		(+= global349 (/ gScore 1000))
		(= gScore (mod gScore 1000))
		(if (> global349 999)
			(= global349 999)
			(= gScore 999)
		)
	else
		(= param1 (- 0 param1))
		(while (>= param1 1000)
			(if global349
				(-- global349)
				(-= param1 1000)
			else
				(= gScore 0)
				(= param1 0)
				(break)
			)
		)
		(if (> gScore param1)
			(-= gScore param1)
		else
			(= gScore 0)
		)
	)
)

(procedure (proc951_16 param1)
	(if [global350 param1]
		(proc951_15 [global350 param1])
		(= [global350 param1] 0)
	)
)

(procedure (proc951_17 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp3 0)) (< temp3 23) ((++ temp3))
		(= temp2 (* temp3 2))
		(= [global118 (+ temp2 1)] 0)
	)
	(for ((= temp3 0)) (< temp3 94) ((++ temp3))
		(ClearFlag temp3)
	)
	(for ((= temp3 0)) (< temp3 178) ((++ temp3))
		(= [global350 temp3] 0)
	)
	(for ((= temp1 0)) (<= temp1 9) ((++ temp1))
		(= [global164 (* temp1 2)] 0)
	)
	(SetFlag 87)
	(if (> (gGame detailLevel:) 7)
		(ClearFlag 35)
		(ClearFlag 38)
	else
		(SetFlag 35)
		(SetFlag 38)
	)
	(SetFlag 2)
	(= global109 100)
	(= global105 0)
	(= global106 0)
	(= global107 0)
	(= gExitFeature 0)
	(= global184 0)
	(= global185 0)
	(= global347 0)
	(= global104 1023)
	(= global547 10)
	(= global546 1200)
	(= global550 0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [global322 temp0] (+ (* (Random 1 5) 2) 1))
		(= [global328 temp0] (Random 0 3))
		(if (== [global328 temp0] [global334 temp0])
			(= [global328 temp0] (- 3 [global334 temp0]))
		)
		(= [global540 temp0] (Random 1 3))
	)
)

