;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64032)
(include sci.sh)
(use Main)
(use ego_64007)
(use TPMessager)
(use PArray)
(use Str)
(use Talker)

(public
	TalkerName 0
	oMessager 1
	proc64032_2 2
)

(local
	local0
	local1
)

(procedure (proc64032_2)
	(= local1 (Str newWith: 400 { }))
	(= local0 (PArray new:))
	(local0
		add:
			99
			1
			23
			2
			32
			33
			38
			34
			34
			35
			2
			9
			39
			36
			14
			37
			9
			10
			17
			12
			29
			13
			27
			39
			20
			40
			37
			41
			6
			14
			18
			42
			28
			15
			36
			43
			1
			16
			5
			17
			33
			44
			13
			18
			11
			19
			30
			20
			12
			21
			16
			45
			4
			24
			26
			25
			3
			26
			8
			27
			22
			49
			21
			48
			19
			28
			25
			29
			7
			30
			35
			50
			24
			51
			10
			31
			15
			32
	)
)

(procedure (TalkerName param1 &tmp temp0 temp1)
	(if (or (not local1) (not local0) (< (local0 size:) param1))
		(PrintDebug {Illegal call of TalkerName})
		(return {(***MISSING NAME***)})
	)
	(= temp0 (local0 at: param1))
	(if
		(and
			(or (== param1 23) (== param1 32))
			(not ((ScriptID 64017 0) test: 280)) ; oFlags
		)
		(= temp1 2)
	else
		(= temp1 1)
	)
	(if (not (Message msgGET 17 temp0 0 0 temp1 (local1 data:)))
		(return {(***MISSING NAME***)})
	else
		(return (local1 data:))
	)
)

(instance oNarrator of Narrator
	(properties)
)

(instance oMessager of TPMessager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(cond
			((== param1 23)
				(if global334
					(return global334)
				else
					(return oNarrator)
				)
			)
			((== param1 2)
				(if global335
					(return global335)
				else
					(return oNarrator)
				)
			)
			((== param1 14)
				(if gToDick
					(return gToDick)
				else
					(return oNarrator)
				)
			)
			((== param1 9)
				(if global336
					(return global336)
				else
					(return oNarrator)
				)
			)
			((== param1 29)
				(if gToGraham
					(return gToGraham)
				else
					(return oNarrator)
				)
			)
			((== param1 27)
				(if gToCroupier
					(return gToCroupier)
				else
					(return oNarrator)
				)
			)
			((== param1 6)
				(if global357
					(return global357)
				else
					(return oNarrator)
				)
			)
			((== param1 18)
				(if global353
					(return global353)
				else
					(return oNarrator)
				)
			)
			((== param1 28)
				(if gToJulia
					(return gToJulia)
				else
					(return oNarrator)
				)
			)
			((== param1 36)
				(if global352
					(return global352)
				else
					(return oNarrator)
				)
			)
			((== param1 1)
				(cond
					(global330
						(return global330)
					)
					(
						(and
							gEgo
							(gEgo plane:)
							(gEgo isNotHidden:)
							((gEgo plane:) isEnabled:)
							(== (gEgo view:) 60100)
							(!= (= temp0 (GetActorLoop gEgo)) 3)
						)
						(return (ScriptID 64007 1)) ; toLarryTalker
					)
					(else
						(return oNarrator)
					)
				)
			)
			((== param1 11)
				(if global339
					(return global339)
				else
					(return oNarrator)
				)
			)
			((== param1 12)
				(if global341
					(return global341)
				else
					(return oNarrator)
				)
			)
			((== param1 16)
				(if global340
					(return global340)
				else
					(return oNarrator)
				)
			)
			((== param1 30)
				(if gToPaul
					(return gToPaul)
				else
					(return oNarrator)
				)
			)
			((== param1 26)
				(if gToBonds
					(return gToBonds)
				else
					(return oNarrator)
				)
			)
			((== param1 3)
				(if global332
					(return global332)
				else
					(return oNarrator)
				)
			)
			((== param1 4)
				(if gToShamara
					(return gToShamara)
				else
					(return oNarrator)
				)
			)
			((== param1 8)
				(if gToVicki
					(return gToVicki)
				else
					(return oNarrator)
				)
			)
			((== param1 22)
				(if global355
					(return global355)
				else
					(return oNarrator)
				)
			)
			((== param1 19)
				(if global345
					(return global345)
				else
					(return oNarrator)
				)
			)
			((== param1 25)
				(if gToWaitress
					(return gToWaitress)
				else
					(return oNarrator)
				)
			)
			((== param1 7)
				(if gToWang
					(return gToWang)
				else
					(return oNarrator)
				)
			)
			((== param1 35)
				(if global344
					(return global344)
				else
					(return oNarrator)
				)
			)
			((== param1 24)
				(if global354
					(return global354)
				else
					(return oNarrator)
				)
			)
			((== param1 10)
				(if global338
					(return global338)
				else
					(return oNarrator)
				)
			)
			((== param1 15)
				(if gToX
					(return gToX)
				else
					(return oNarrator)
				)
			)
			((== param1 99)
				(return oNarrator)
			)
			(else
				(return oNarrator)
			)
		)
		(return oNarrator)
	)
)

