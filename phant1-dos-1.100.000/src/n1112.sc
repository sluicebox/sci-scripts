;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1112)
(include sci.sh)
(use Main)
(use scaryInvInit)

(public
	proc1112_0 0
	proc1112_1 1
	proc1112_2 2
	proc1112_3 3
	proc1112_4 4
	proc1112_5 5
	proc1112_6 6
)

(procedure (proc1112_0)
	(SetFlag 93)
	(SetFlag 94)
	(SetFlag 95)
	(SetFlag 97)
	(SetFlag 14)
	(SetFlag 158)
	(SetFlag 159)
	(SetFlag 209)
	(SetFlag 114)
	(SetFlag 39)
	(SetFlag 208)
	(SetFlag 9)
	(SetFlag 126)
	(SetFlag 208)
	(SetFlag 412)
	((gInventory at: 21) owner: 0) ; invFigurine
	((gInventory at: 0) owner: gEgo) ; invLibKey
	((gInventory at: 5) owner: 20200) ; invHammer
)

(procedure (proc1112_1)
	(SetFlag 71)
	(SetFlag 162)
	(SetFlag 163)
	(SetFlag 55)
	(SetFlag 233)
	(SetFlag 292)
	(SetFlag 66)
)

(procedure (proc1112_2)
	(SetFlag 164)
	(SetFlag 136)
	(SetFlag 232)
	(SetFlag 165)
	(SetFlag 167)
	(SetFlag 168)
	(SetFlag 169)
	(SetFlag 46)
	(SetFlag 171)
	(SetFlag 237)
	(SetFlag 172)
	(SetFlag 173)
	(SetFlag 180)
	(SetFlag 2)
	(SetFlag 267)
	(ClearFlag 11)
	(SetFlag 6)
	(SetFlag 7)
	(SetFlag 8)
	(SetFlag 27)
	(SetFlag 128)
	((gInventory at: 5) owner: gEgo) ; invHammer
	((gInventory at: 4) owner: gEgo) ; invPoker
	((gInventory at: 6) owner: gEgo) ; invStairKey
)

(procedure (proc1112_3)
	(SetFlag 174)
	(SetFlag 176)
	(SetFlag 153)
	(SetFlag 184)
	(SetFlag 186)
	(SetFlag 187)
	(SetFlag 188)
	(SetFlag 189)
	(SetFlag 337)
	(SetFlag 204)
	(SetFlag 205)
	(SetFlag 16)
	(SetFlag 91)
	(SetFlag 203)
	(SetFlag 321)
	(SetFlag 325)
)

(procedure (proc1112_4)
	(SetFlag 195)
	(SetFlag 194)
	(SetFlag 214)
	(SetFlag 215)
	(SetFlag 217)
	(SetFlag 198)
	(SetFlag 15)
	(SetFlag 199)
	(SetFlag 327)
	(ClearFlag 99)
	(SetFlag 316)
	(SetFlag 300)
	(SetFlag 42)
	(SetFlag 38)
)

(procedure (proc1112_5)
	(SetFlag 206)
	(SetFlag 200)
	(SetFlag 218)
	(SetFlag 367)
)

(procedure (proc1112_6 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (<= temp0 446) ((++ temp0))
		(ClearFlag temp0)
	)
	(for ((= temp0 0)) (<= temp0 21) ((++ temp0))
		(gEgo put: temp0)
		((gInventory at: temp0) owner: 0)
	)
	(proc28_2)
)

