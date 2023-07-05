;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64032)
(include sci.sh)
(use Main)
(use TPMessager)
(use Str)
(use Array)
(use Talker)

(public
	TalkerName 0
	oMessager 1
)

(local
	oTalkerNames
)

(procedure (GetTalkerNameFromMsg who &tmp whoId whoName)
	(if (not (Message msgGET 1 who 0 0 1))
		(if (not (Message msgGET 1 100 0 0 1))
			(return (= whoName (Str with: {Somebody})))
		else
			(= whoId 100)
		)
	else
		(= whoId who)
	)
	(= whoName (Str newWith: 50 {}))
	(Message msgGET 1 whoId 0 0 1 (whoName data:))
	(return whoName)
)

(procedure (LearnTalkerNames &tmp i)
	(= oTalkerNames (IDArray new: 101))
	(for ((= i 0)) (<= i 100) ((++ i))
		(oTalkerNames at: i (GetTalkerNameFromMsg i))
	)
)

(procedure (TalkerName who &tmp talkerName)
	(if (or (< who 0) (>= who (oTalkerNames size:)))
		(= talkerName (oTalkerNames at: 100))
	else
		(= talkerName (oTalkerNames at: who))
	)
	(return talkerName)
)

(instance oNarrator of Narrator
	(properties)
)

(instance moTorin of Mouth
	(properties
		view 60109
	)

	(method (init)
		(= client gEgo)
		(super init: &rest)
	)
)

(instance toTorin of Talker
	(properties)

	(method (init)
		(= mouth moTorin)
		(super init: &rest)
	)
)

(instance oMessager of TPMessager
	(properties)

	(method (init)
		(super init: &rest)
		(LearnTalkerNames)
	)

	(method (findTalker who)
		(cond
			((not saveMessages)
				(return oNarrator)
			)
			((== who 99)
				(return oNarrator)
			)
			((== who 1)
				(if gtTorin
					(return gtTorin)
				else
					(return toTorin)
				)
			)
			((== who 19)
				(if gtSam
					(return gtSam)
				else
					(return oNarrator)
				)
			)
			((== who 20)
				(if gtMax
					(return gtMax)
				else
					(return oNarrator)
				)
			)
			((== who 13)
				(switch gnHermanTalker
					(0
						(return oNarrator)
					)
					(1
						(return (ScriptID 15000 1)) ; toGuard1
					)
					(2
						(return (ScriptID 15000 2)) ; toGuard2
					)
					(3
						(return (ScriptID 15100 1)) ; toHermanTable
					)
					(4
						(return (ScriptID 15100 2)) ; toHermanDrinking
					)
					(5
						(return (ScriptID 15000 3)) ; toGuardCU
					)
					(6
						(return (ScriptID 15100 3)) ; toHermanBookcase
					)
					(7
						(return (ScriptID 15500 1)) ; toHerman
					)
					(8
						(return (ScriptID 15200 1)) ; toHerman
					)
				)
			)
			((== who 9)
				(if (== gCurRoomNum 14000) ; roSnails
					(return (ScriptID 14000 1)) ; toSlim
				else
					(return oNarrator)
				)
			)
			((== who 10)
				(if (== gCurRoomNum 14000) ; roSnails
					(return (ScriptID 14000 2)) ; toSlime
				else
					(return oNarrator)
				)
			)
			((== who 12)
				(return (ScriptID 16100 1)) ; toZax
			)
			((== who 25)
				(return (ScriptID 50500 1)) ; toJudge
			)
			((== who 26)
				(return (ScriptID 50400 1)) ; toMrsPlant
			)
			((== who 34)
				(switch gnRabbitTalker
					(0
						(return oNarrator)
					)
					(1
						(return (ScriptID 50900 1)) ; toRabbitCu
					)
					(2
						(return (ScriptID 50900 2)) ; toRabbit
					)
				)
			)
			((== who 32)
				(switch gnCentipedeTalker
					(0
						(return oNarrator)
					)
					(1
						(return (ScriptID 50900 3)) ; toCentipede
					)
				)
			)
			((== who 35)
				(if gtZippy
					(return gtZippy)
				else
					(return (ScriptID 50900 4)) ; toMagician
				)
			)
			((== who 37)
				(return (ScriptID 50900 5)) ; toAcrobat
			)
			((== who 33)
				(if gtArcher
					(return gtArcher)
				else
					(return oNarrator)
				)
			)
			((== who 38)
				(if gtCarpenter
					(return gtCarpenter)
				else
					(return oNarrator)
				)
			)
			((== who 36)
				(if gtArchivist
					(return gtArchivist)
				else
					(return oNarrator)
				)
			)
			((== who 39)
				(return (ScriptID 50900 6)) ; toStageManager
			)
			((== who 48)
				(if gtSmetana
					(return gtSmetana)
				else
					(return oNarrator)
				)
			)
			((== who 23)
				(if gtLeenah
					(return gtLeenah)
				else
					(return oNarrator)
				)
			)
			((== who 18)
				(if gtVeder
					(return gtVeder)
				else
					(return oNarrator)
				)
			)
			((== who 21)
				(if gtTripe
					(return gtTripe)
				else
					(return oNarrator)
				)
			)
			((== who 22)
				(if gtViscera
					(return gtViscera)
				else
					(return oNarrator)
				)
			)
			((== who 52)
				(if gtSoldier
					(return gtSoldier)
				else
					(return oNarrator)
				)
			)
			((== who 6)
				(if gtKurtzwell
					(return gtKurtzwell)
				else
					(return oNarrator)
				)
			)
			((== who 3)
				(if gtPecand
					(return gtPecand)
				else
					(return oNarrator)
				)
			)
			((== who 4)
				(if gtLycentia
					(return gtLycentia)
				else
					(return oNarrator)
				)
			)
			((== who 5)
				(if gtDreep
					(return gtDreep)
				else
					(return oNarrator)
				)
			)
			((== who 24)
				(if gtCop
					(return gtCop)
				else
					(return oNarrator)
				)
			)
			((== who 15)
				(if gtMrsBitter
					(return gtMrsBitter)
				else
					(return oNarrator)
				)
			)
			((== who 45)
				(if gtBobbyBitter
					(return gtBobbyBitter)
				else
					(return oNarrator)
				)
			)
			((== who 16)
				(if gtKing
					(return gtKing)
				else
					(return oNarrator)
				)
			)
			((== who 56)
				(if gtKingDi
					(return gtKingDi)
				else
					(return oNarrator)
				)
			)
			((== who 17)
				(if gtQueen
					(return gtQueen)
				else
					(return oNarrator)
				)
			)
			((== who 55)
				(if gtQueenToKing
					(return gtQueenToKing)
				else
					(return oNarrator)
				)
			)
			((== who 46)
				(if gtPhace
					(return gtPhace)
				else
					(return oNarrator)
				)
			)
			((== who 50)
				(if gtTree
					(return gtTree)
				else
					(return oNarrator)
				)
			)
			((== who 7)
				(return (ScriptID 51400 1)) ; toPa
			)
			((== who 8)
				(return (ScriptID 51400 2)) ; toMa
			)
			(else
				(return oNarrator)
			)
		)
		(return oNarrator)
	)
)

