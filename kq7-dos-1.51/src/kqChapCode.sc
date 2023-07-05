;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use ExitButton)
(use System)

(public
	kqChapCode 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if (!= [gRozInventoryIndexes temp0] -1)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if (!= [gValInventoryIndexes temp0] -1)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_2 param1)
	(switch param1
		(1
			(SetFlag 6)
			(SetFlag 9)
			(SetFlag 13)
			(SetFlag 14)
			(SetFlag 15)
			(SetFlag 24)
			(SetFlag 28)
			(SetFlag 32)
			(SetFlag 37)
			(SetFlag 41)
			(SetFlag 43)
			(SetFlag 18)
			(SetFlag 305)
			(SetFlag 300)
			(SetFlag 304)
			(SetFlag 7)
			(SetFlag 34)
			(SetFlag 317)
			(SetFlag 311)
			(SetFlag 312)
			(SetFlag 313)
			(SetFlag 339)
			(SetFlag 320)
			(SetFlag 325)
			(SetFlag 315)
			(SetFlag 327)
			(SetFlag 323)
			(SetFlag 10)
			(SetFlag 31)
			(SetFlag 318)
			(SetFlag 328)
			((gInventory at: 10) owner: 1100) ; Jackalope_Fur
			(= gGem1Position 2)
			(= gGem2Position 2)
			(= gGem3Position 2)
		)
		(2
			(SetFlag 50)
			(SetFlag 51)
			(SetFlag 52)
			(SetFlag 53)
			(SetFlag 54)
			(SetFlag 55)
			(SetFlag 56)
			(SetFlag 57)
			(SetFlag 58)
			(SetFlag 59)
			(SetFlag 60)
			(SetFlag 61)
			(SetFlag 62)
			(SetFlag 63)
			(SetFlag 64)
			(SetFlag 65)
			(SetFlag 73)
			(SetFlag 67)
			(SetFlag 55)
		)
		(3
			(SetFlag 100)
			(SetFlag 101)
			(SetFlag 110)
			(SetFlag 111)
			(SetFlag 113)
			(SetFlag 120)
			(SetFlag 122)
			(SetFlag 125)
			(SetFlag 126)
			(SetFlag 127)
			(SetFlag 402)
			(SetFlag 109)
			(SetFlag 29)
			(ClearFlag 141)
			(ClearFlag 106)
		)
		(4
			(SetFlag 150)
			(SetFlag 152)
			(SetFlag 451)
			(SetFlag 155)
			(SetFlag 156)
			(SetFlag 157)
			(SetFlag 159)
			(SetFlag 160)
			(SetFlag 179)
			(SetFlag 180)
			(ClearFlag 165)
			(SetFlag 166)
			(SetFlag 167)
			(SetFlag 168)
			(SetFlag 169)
			(SetFlag 171)
			(SetFlag 172)
			(SetFlag 173)
			(SetFlag 181)
			(SetFlag 182)
			(ClearFlag 172)
			(ClearFlag 278)
		)
		(5
			(SetFlag 278)
			(SetFlag 200)
			(SetFlag 202)
			(SetFlag 204)
			(SetFlag 206)
			(SetFlag 207)
			(SetFlag 208)
			(SetFlag 210)
			(SetFlag 211)
			(SetFlag 212)
			(SetFlag 214)
			(SetFlag 103)
			((gInventory at: 72) owner: 4000) ; Femur
			(SetFlag 219)
			(SetFlag 222)
			(SetFlag 223)
			(SetFlag 224)
		)
	)
)

(instance kqChapCode of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2)
		(if argc
			(= temp2 1)
			(= gChapter param1)
		else
			(= temp2 0)
			(++ gChapter)
		)
		(FrameOut)
		(= gInventoryCount 0)
		(if ((ScriptID 0 4) size:) ; respondSet
			((ScriptID 0 4) release: add: 10 add: 8) ; respondSet
		)
		(if (mod gChapter 2)
			(= gValOrRoz -4) ; Val
		else
			(= gValOrRoz -3) ; Roz
		)
		(ClearFlag 338)
		(switch gChapter
			(1
				(if (IsFlag 8)
					(ClearFlag 8)
					(gEgo get: 0) ; Golden_Comb
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(gCurRoom newRoom: 1250)
				)
			)
			(2
				(if (IsFlag 8)
					(ClearFlag 8)
					(localproc_2 1)
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(gCurRoom newRoom: 2470)
				)
			)
			(3
				(if (or (IsFlag 8) (not (localproc_0)))
					(ClearFlag 8)
					(localproc_2 1)
					(localproc_2 2)
					(gEgo get: 0 get: 1 get: 7 get: 3 get: 2 get: 8) ; Golden_Comb, Ripped_Petticoat, Basket, Stick, Clay_Pot, Hunting_Horn
				else
					(for ((= temp0 0)) (< temp0 16) ((+= temp0 1))
						(if (!= [gRozInventoryIndexes temp0] -1)
							(gEgo get: [gRozInventoryIndexes temp0])
						)
					)
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(gCurRoom newRoom: 1000)
				)
			)
			(4
				(if (or (IsFlag 8) (not (localproc_1)))
					(ClearFlag 8)
					(localproc_2 1)
					(localproc_2 2)
					(localproc_2 3)
					(gEgo get: 35 get: 28 get: 31 get: 38) ; Lantern, Silver_Pellet, Dragon_Toad, Hammer_and_Chisel
				else
					(ClearFlag 106)
					(for ((= temp0 0)) (< temp0 16) ((+= temp0 1))
						(if (!= [gValInventoryIndexes temp0] -1)
							(gEgo get: [gValInventoryIndexes temp0])
						)
					)
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(ClearFlag 141)
					(gCurRoom newRoom: 4050)
				)
			)
			(5
				(if (or (IsFlag 8) (not (localproc_0)))
					(ClearFlag 8)
					(localproc_2 1)
					(localproc_2 2)
					(localproc_2 3)
					(localproc_2 4)
					(gEgo
						get: 0 ; Golden_Comb
						get: 1 ; Ripped_Petticoat
						get: 8 ; Hunting_Horn
						get: 3 ; Stick
						get: 2 ; Clay_Pot
						get: 48 ; Moon
						get: 43 ; Mask
						get: 47 ; Magic_Statue
					)
				else
					(for ((= temp0 0)) (< temp0 16) ((+= temp0 1))
						(if (!= [gRozInventoryIndexes temp0] -1)
							(gEgo get: [gRozInventoryIndexes temp0])
						)
					)
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(gCurRoom newRoom: 5100)
				)
			)
			(6
				(if (or (IsFlag 8) (not (localproc_1)))
					(ClearFlag 8)
					(localproc_2 1)
					(localproc_2 2)
					(localproc_2 3)
					(localproc_2 4)
					(localproc_2 5)
					(gEgo
						get: 35 ; Lantern
						get: 38 ; Hammer_and_Chisel
						get: 61 ; Woolen_Stocking
						get: 56 ; Shovel
						get: 62 ; Device
						get: 58 ; Extra_Life
						get: 53 ; Magic_Wand
					)
				else
					(for ((= temp0 0)) (< temp0 16) ((+= temp0 1))
						(if (!= [gValInventoryIndexes temp0] -1)
							(gEgo get: [gValInventoryIndexes temp0])
						)
					)
				)
				(if (and temp2 param2)
					(gCurRoom newRoom: param2)
				else
					(gCurRoom newRoom: 2204)
					((ScriptID 0 5) setReal: (ScriptID 0 5) 210) ; lavaDeathTimer, lavaDeathTimer
					((ScriptID 0 9) setReal: (ScriptID 0 9) 300) ; volcanoDeathTimer, volcanoDeathTimer
				)
			)
		)
	)
)

