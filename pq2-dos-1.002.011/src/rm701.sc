;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Menu)
(use System)

(public
	rm701 0
)

(local
	[local0 40]
)

(procedure (localproc_0 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (= temp1 (StrAt @local0 temp0)) ((++ temp0))
		(if (and (>= temp1 97) (<= temp1 122))
			(StrAt @local0 temp0 (- temp1 32))
		)
	)
)

(instance event of Event ; UNUSED
	(properties)
)

(instance rm701 of Rm
	(properties
		picture 701
	)

	(method (init)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (& (GetTime 1) $0007)) ; SysTime12
		(= local0 0)
		(localproc_0)
		(Print 701 0 #icon 701 0 temp0 #edit @local0 20) ; "TO: Detective Bonds FROM: Captain Hall SUBJECT: ID of evidence photo Please provide the LAST name of the person pictured in the attached evidence photo for homicide case 186751. Please respond in box below, ASAP!"
		(= gQuit 1)
		(localproc_1)
		(switch temp0
			(0
				(if (not (StrCmp @local0 {GRANANDEZ}))
					(= gQuit 0)
				)
			)
			(1
				(if (not (StrCmp @local0 {SIMMS}))
					(= gQuit 0)
				)
			)
			(2
				(if (not (StrCmp @local0 {TASELLI}))
					(= gQuit 0)
				)
			)
			(3
				(if (not (StrCmp @local0 {COLBY}))
					(= gQuit 0)
				)
			)
			(4
				(if (not (StrCmp @local0 {BAINS}))
					(= gQuit 0)
				)
			)
			(5
				(if (not (StrCmp @local0 {SNIDER}))
					(= gQuit 0)
				)
			)
			(6
				(if (not (StrCmp @local0 {JONES}))
					(= gQuit 0)
				)
			)
			(else
				(if (not (StrCmp @local0 {DICKEY}))
					(= gQuit 0)
				)
			)
		)
		(if gQuit
			(Print 701 1) ; "Sorry Bonds, you'll need to do better than that!"
		else
			(MenuBar draw:)
			(SL enable:)
			(gGame restart:)
		)
	)
)

