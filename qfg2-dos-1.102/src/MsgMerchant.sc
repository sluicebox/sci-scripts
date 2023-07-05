;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use Talker)
(use KattaMerchant)

(local
	[msgDays 9] = [16 32767 14 7 12 5 9 3 -1]
)

(procedure (CalcDayMsg &tmp i)
	(= gCurDayMsg 6)
	(= gCurDayElemState 32767)
	(= i 0)
	(while (!= [msgDays i] -1)
		(if (>= gDay [msgDays i])
			(= gCurDayElemState [msgDays (+ i 1)])
			(break)
		)
		(+= i 2)
		(-- gCurDayMsg)
	)
)

(class MsgMerchant of KattaMerchant
	(properties
		firstMsgNum 0
		lastMsgSaid 0
		saidMsg 0
	)

	(method (init)
		(CalcDayMsg)
		(super init:)
	)

	(method (doit &tmp ix newLastMsgSaid)
		(super doit:)
		(if
			(and
				(not (self getSaidMsg:))
				(< (gEgo distanceTo: self) 45)
				(< (self getLastMsgSaid:) gCurDayMsg)
				(== (gCurRoom inOut:) 3)
				(not (gEgo script:))
			)
			(if (== gCurDayMsg 2)
				(= newLastMsgSaid (+ (self getLastMsgSaid:) 1))
			else
				(= newLastMsgSaid gCurDayMsg)
			)
			(self updLastMsgSaid: newLastMsgSaid setSaidMsg:)
			(if (<= gElementalState gCurDayElemState)
				(gEgo setMotion: 0)
				(self sayMsg: (- (+ newLastMsgSaid firstMsgNum) 1))
			)
		)
	)

	(method (getLastMsgSaid)
		(return lastMsgSaid)
	)

	(method (updLastMsgSaid msg)
		(= lastMsgSaid msg)
	)

	(method (getSaidMsg)
		(return saidMsg)
	)

	(method (setSaidMsg)
		(= saidMsg 1)
	)

	(method (sayMsg whatMsg)
		(Say self msgFile whatMsg)
	)
)

